<template>
  <div class="banner">
    <h2>SUKCES</h2>
    udalo Ci sie wynajac mieszkanie: {{this.flat.name}}
    <p>Twoj kod do wejscia: {{this.flat.entryCode}}</p>
  </div>
</template>

<script>
  export default {
      data(){
        return{
          flat: this.$route.params.data
        }
      }
  }
</script>

<style scoped>
.banner{
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>
