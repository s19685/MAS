<template>
  <div class="holder">
    <FlatRow />
    <form >
      <label for="firstname">First Name:</label>
      <input type="text" name="firstname" v-model="username" />

      <label for="lastname">Last Name:</label>
      <input type="text" name="lastname" v-model="lastname" />

      <label for="datefrom">Date from:<sup>*</sup></label>
      <input type="date" name="datefrom" v-model="dateFrom" :max="dateTo"/>

      <label for="dateto">Date to:<sup>*</sup></label>
      <input type="date" name="dateto" v-model="dateTo" :min="dateFrom"/>

      <button type="button" name="button" @click="apiPut"><router-link to="/summary">OK</router-link></button>
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
        username:"",
        lastname:"",
        dateFrom:"",
        dateTo:"",
        results:[]
      }
    },
    created(){
      axios.get(this.API_URL +"flat/")
      .then((response) =>{
        console.log(response);
        this.results = response.data;
      })
    },
    methods:{
      apiPut(){
        console.log("elo");
        // axios.put(this.API_URL+"rental",
        // {
        //   username:this.username,
        //   lastname:this.lastname,
        //   apartamentid:this.flatId,
        //   dateFrom:this.dateFrom,
        //   dateTo:this.dateTo
        // }).then((response) =>{
        //   console.log(response);
        // })
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
