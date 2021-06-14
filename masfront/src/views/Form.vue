<template>
  <div class="holder">
    <FlatRow :apidata="this.result"/>
    <form >
      <label >Dvices to choose:</label>

      <div class="devices">
        <label for="horns">{{res[0].name}} - {{res[0].price}} zl za dzien </label>
        <input type="checkbox" :id="res[0].id" :name="res[0].name" v-model="xd">
      </div>
      <div class="devices">
        <label for="horns">{{res[1].name}} - {{res[1].price}} zl za dzien </label>
        <input type="checkbox" :id="res[1].id" :name="res[1].name" v-model="xd1">
      </div>
      <div class="devices">
        <label for="horns">{{res[2].name}} - {{res[2].price}} zl za dzien </label>
        <input type="checkbox" :id="res[2].id" :name="res[2].name" v-model="xd2">
      </div>

      <button type="button" name="button" @click="apiPut">ADD</button>

    </form>

    <form >
      <label for="firstname">First Name:</label>
      <input type="text" name="firstname" v-model="firstname" />

      <label for="lastname">Last Name:</label>
      <input type="text" name="lastname" v-model="lastname" />

      <label for="datefrom">Date from:</label>
      <input type="date" name="datefrom" v-model="dateFrom" :max="dateTo"/>

      <label for="dateto">Date to:</label>
      <input type="date" name="dateto" v-model="dateTo" :min="dateFrom"/>


      <!-- <div v-for="item in res" :key="item.id" class="devices">
        <label for="horns">{{item.name}} - {{item.price}} zl za dzien </label>
        <input type="checkbox" :id="item.id" :name="item.name" v-model="xd">
      </div> -->


      <button type="button" name="button" @click="apiPost">OK</button>
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
        result:[],
        res:[],
        resp:"",
        xd:false,
        xd1:false,
        xd2:false
      }
    },
    created(){
      axios.get(this.API_URL +"flat/"+this.$route.params.id)
      .then((response) =>{
        console.log(response);
        this.result = response.data;
      })
      axios.get(this.API_URL +"devices")
      .then((response) =>{
          this.res = response.data;
          console.log(response);
      })
    },
    methods:{
      apiPut(){
        axios.put(this.API_URL+"flat/"+this.$route.params.id,
        {
          first:this.xd,
          second:this.xd1,
          third:this.xd2
        }).then((response) =>{
          console.log(response);
        })
      },
      apiPost(){
        axios.post(this.API_URL+"rental",
        {
          firstName:this.firstname,
          lastName:this.lastname,
          flatId:this.result.id,
          dateFrom:this.dateFrom,
          dateTo:this.dateTo
        }).then((response) =>{
          console.log(response);
          this.resp = response.data;
          console.log(this.resp);
          this.$router.push({name:"Summary", params:{data:this.result, ide:this.resp,dateFrom:this.dateFrom,dateTo:this.dateTo}})
        })
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
  font-size: 20px;
}

label{
  padding: 5px;
}

.devices{
  width: 500px;
  display: flex;
  flex-direction: row;
justify-content: space-between;
}

</style>
