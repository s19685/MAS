<template>
  <div class="banner">
    <h2>SUKCES</h2>
    udalo Ci sie wynajac mieszkanie: {{this.flat.name}}
    <p>od {{this.dateFrom}} do {{this.dateTo}}</p>
    <p>Twoj kod do wejscia: {{this.flat.entryCode}}</p>
    <p>Laczny koszt: {{this.result}}</p>
  </div>
</template>

<script>
import axios from 'axios';

  export default {
      data(){
        return{
          flat: this.$route.params.data,
          dateFrom:this.$route.params.dateFrom,
          dateTo: this.$route.params.dateTo,
          ide: this.$route.params.ide,
          result:[]
        }
      },
      created(){
        console.log(this.$route.params.ide);
        axios.get(this.API_URL +"rental/"+this.ide)
        .then((response) =>{
          console.log(response);
          this.result = response.data;
        })
      },

  }
</script>

<style scoped>
.banner{
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>
