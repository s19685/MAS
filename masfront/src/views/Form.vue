<template>
  <div class="holder">
    <FlatRow :apidata="this.result"/>
    <form >
      <label for="firstname">First Name:</label>
      <input type="text" name="firstname" v-model="firstname" />

      <label for="lastname">Last Name:</label>
      <input type="text" name="lastname" v-model="lastname" />

      <label for="datefrom">Date from:<sup>*</sup></label>
      <input type="date" name="datefrom" v-model="dateFrom" :max="dateTo"/>

      <label for="dateto">Date to:<sup>*</sup></label>
      <input type="date" name="dateto" v-model="dateTo" :min="dateFrom"/>

      <button type="button" name="button" @click="apiPut">OK</button>
    </form>
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
        firstname:"",
        lastname:"",
        dateFrom:"",
        dateTo:"",
        result:[]
      }
    },
    created(){
      axios.get(this.API_URL +"flat/"+this.$route.params.id)
      .then((response) =>{
        console.log(response);
        this.result = response.data;
      })
    },
    methods:{
      apiPut(){
        console.log(this.result.id);
        axios.post(this.API_URL+"rental",
        {
          firstName:this.firstname,
          lastName:this.lastname,
          flatId:this.result.id,
          dateFrom:this.dateFrom,
          dateTo:this.dateTo
        }).then((response) =>{
          console.log(response);
        })
        this.$router.push({name:"Summary", params:{data:this.result}})
      }
    }

  }
</script>

<style scoped>
.holder{
  margin: 50px;
}

form{
  display: flex;
  flex-direction: column;
  align-items: center;

}

</style>
