<template>
新闻
<ul>
    <li><RouterLink to="/news/1">新闻1</RouterLink></li>
    <li><RouterLink to="/news/2">新闻2</RouterLink></li>
  <div class="news-content">
    <RouterView/>
  </div>
</ul>
</template>

<script>
</script>

<style scoped>
    .news-content {
      background-color: #42b983;
      height: 90%;
    }
</style>