<template>
  <div class="details">
    <img alt="Vue logo" src="@/assets/logo.png">
    <div class="row">
      <div class="">
        <h1>NAME</h1>
        <p>metry</p>
      </div>
      <div class="">
        <h1>CENA</h1>
        <button type="button" name="button"><router-link to="/form">GO</router-link></button>
      </div>
    </div>
    <div class="desc">
      opis
    </div>
    <h1>Wyposarzenie:</h1>
    <div class="center">
      <div class="row" v-for="item in items" :key="item.id">
        <div class="">
          {{ item.a }}
        </div>
        <div class="">
          {{ item.b }}X{{item.c}}
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    data(){
            return{
              items:[{a:"XDD",b:"1234",c:"2134"},{a:"XXD",b:"12d4"}]
            }
          },
  }
</script>

<style scoped>

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
  background-color: grey;
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


</style>
