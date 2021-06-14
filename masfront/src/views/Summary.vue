<template>
  <div class="listHolder">
    <h1>SUKCES</h1>
  </div>
</template>

<script>
import axios from 'axios';

  export default {
      components:{
      },
      data(){
        return{
          results:[]
        }
      },
      created(){
        axios.get(this.API_URL +"flat/")
             .then((response) =>{
               console.log(response);
               this.results = response.data;
             })
      }
  }
</script>

<style scoped>
.listHolder{
  margin: 20px;
}

</style>
