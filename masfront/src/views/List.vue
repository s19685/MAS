<template>
  <div class="listHolder">
      <FlatRow />
      <!-- <FlatRow v-for="item in results" :key="item.id" :apidata="item"/> -->
  </div>
</template>

<script>
import FlatRow from '@/components/FlatRow.vue';
import axios from 'axios';

  export default {
      components:{
        FlatRow
      },
      data(){
        return{
          results:[]
        }
      },
      created(){
        axios.get(this.API_URL +"flat")
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
