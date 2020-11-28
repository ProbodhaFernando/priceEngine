<template>
  <div class="container">
    <h1>PRODUCT PRICES:</h1>
    <div v-for="productPrice in productPriceList" :key="productPrice.productName">
      <h2>{{ productPrice.productName }}</h2>
      <table class="productPriceTable">
        <tr>
          <th>Units</th>
          <th>Price</th>
        </tr>
        <tr v-for="(price, index) in productPrice.priceList" v-bind:key="index">
          <td>{{ index + 1 }}</td>
          <td>{{ price }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import api from '../Api'

export default {
  name: 'ProductPriceView',
  data: function () {
    return {
      productPriceList: []
    }
  },
  mounted () {
    // api call to get products list
    api.getAllProductPriceView().then(response => {
      this.productPriceList = response.data
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

.productPriceTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

.productPriceTable td, .productPriceTable th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

.productPriceTable tr:nth-child(even){background-color: #f2f2f2;}

.productPriceTable tr:hover {background-color: #ddd;}

.productPriceTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  background-color: #4CAF50;
  color: white;
}
</style>
