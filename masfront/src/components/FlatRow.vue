<template>
  <div class="row">
    <img alt="Vue logo" src="@/assets/logo.png">
    <div class="info">
      <h1>{{ apidata.name }}</h1>
      <p>{{ apidata.desc }}</p>
      <h1>{{ apidata.price }} zl za dzien</h1>
    </div>
    <button type="button" name="button"><router-link :to="'/flat/'+apidata.id">GO</router-link></button>
  </div>
</template>


<script>
  export default {
    props:{
      apidata:{
        id:Number,
        name:String,
        desc:String,
        price:Number
      }
    }
  }
</script>

<style scoped>

h1{
  color: black;
}

button{
  width: 100px;
  height: 100px;
  margin-right: 15px;
}

.row{
  width: 100%;
  height: 200px;
  border-radius: 15px;
  margin: 10px;
  background-color: #A3D3C9;

  display: flex;
  align-items: center;
  justify-content: space-between;

}

.info{
  margin-left: -160px;
  width:50%;

}



</style>
