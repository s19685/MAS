<template>
  <div id="app">
    <header>
      <img alt="Vue logo" src="./assets/logo.png" to="/">
      <h1><router-link class="xd" to="/">My Estate</router-link></h1>
    </header>
    
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style>

header{
  background-color: #A3D3C9;
  height: 100px;
  width: 100%;
  display: flex;
  flex-direction: row;
}

img{
  transform: scale(0.7 );
}

h1{
  margin: 0;
  display: flex;
  align-items: center;
  color: white;
}

body{
  margin: 0;
}

.xd{
  text-decoration: none;
  color: white;
}


</style>
