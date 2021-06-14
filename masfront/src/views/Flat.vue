<template>
  <div class="listHolder">
    <FlatDetails :apidata="results" />
  </div>
</template>

<script>
import FlatDetails from '@/components/FlatDetails.vue';
import axios from 'axios';

  export default {
      components:{
        FlatDetails
      },
      data(){
        return{
          results:[]
        }
      },
      created(){
        console.log(this.$route.params.id)
        axios.get(this.API_URL +"flat/"+this.$route.params.id)
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
