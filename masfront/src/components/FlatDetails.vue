<template>
  <div class="details">
    <img alt="Vue logo" src="@/assets/logo.png">
    <div class="row">
      <div class="">
        <h1>{{ apidata.name }}</h1>
        <p>{{ apidata.area }} m2</p>
      </div>
      <div class="">
        <h1>{{ apidata.price }} zl za dzien</h1>
        <button type="button" name="button"><router-link :to="'/form/'+apidata.id">GO</router-link></button>
      </div>
    </div>
    <h2>Opis:</h2>
    <div class="desc">
      {{ apidata.desc }}
    </div>
    <h2>Wyposarzenie:</h2>
    <div class="center">
      <div class="row" v-for="item in apidata.furnitures" :key="item.id">
        <div class="">
          {{ item.name }}
        </div>
        <div class="">
          {{ item.height }} X {{item.length}} X {{item.width}}
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    props:{
      apidata:{
        id:Number,
        name:String,
        desc:String,
        price:Number,
        area:Number,
        furnitures:[]
      }
    }
  }
</script>

<style scoped>

h1{
  color: black;
}

.row{
  display: flex;
  justify-content: space-between;
  padding: 15px;
}
.center{
  width: 50%;
  margin: auto;
}
.details{
  display: flex;
  flex-direction: column;
  padding: 15px;

}

.desc{
  padding: 15px;

}

button{
  width: 200px;
}

img{
  background-color: black;
  width: 100%;
}


</style>
