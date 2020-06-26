package co.selim.vertx_spa

import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.kotlin.core.json.jsonObjectOf

class MainVerticle : AbstractVerticle() {
  override fun start() {
    val router = Router.router(vertx)

    router.route()
      .handler(StaticHandler.create())

    router.get("/api/message")
      .handler { ctx ->
        val response = jsonObjectOf(
          "message" to "Hello World!"
        )

        ctx.response()
          .setStatusCode(200)
          .putHeader("Content-Type", "application/json; charset=utf-8")
          .end(response.encode())
      }

    router.route()
      .handler { ctx ->
        ctx.response()
          .setStatusCode(200)
          .putHeader("Content-Type", "text/html; charset=utf-8")
          .sendFile("webroot/index.html")
      }

    vertx
      .createHttpServer()
      .requestHandler(router)
      .listen(8080, "localhost")
  }
}
