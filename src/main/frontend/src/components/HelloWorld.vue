<template>
  <div>
    <h1>{{ message }}</h1>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      message: null
    }
  },
  async created() {
    const response = await fetch("/api/message");
    const data = await response.json();
    this.message = data.message;
  }
}
</script>

<style scoped>
</style>
