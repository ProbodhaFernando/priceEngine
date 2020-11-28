<template>
  <div class="container">
    <h1>ORDER PRODUCTS:</h1>
    <form v-on:submit.prevent="placeOrder">
      <table class="orderTable">
        <tr>
          <td>
            <label>Select Product:</label>
          </td>
          <td>
            <select v-model="selectedProductId">
              <option v-for="product in products" :key="product.id" :value="product.id">{{ product.name }}</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            <label>Quantity Type:</label>
          </td>
          <td>
            <select v-model="quantityType">
              <option value="UNIT">Units</option>
              <option value="CARTON">Cartons</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            <label>Quantity:</label>
          </td>
          <td>
            <input type="text" v-model.number="quantity"/>
          </td>
        </tr>
      </table>
      <div class="submit">
        <input type="submit" value="Get Total Price"/>
      </div>
    </form>
    <div class="totalPrice">
      <span>Total Price: </span>
      <span>{{ totalPrice }}</span>
    </div>
  </div>
</template>

<script>
import api from '../Api'

export default {
  name: 'OrderProduct',
  data: function () {
    return {
      products: [],
      selectedProductId: 0,
      quantityType: String,
      quantity: 0,
      totalPrice: 0
    }
  },
  mounted () {
    api.getAllProducts().then(response => {
      this.products = response.data
    })
  },
  methods: {
    placeOrder: function () {
      api.createOrder(this.selectedProductId, this.quantityType, this.quantity, 'INPROGRESS')
        .then(response => {
          this.totalPrice = response.data
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

.orderTable tr td {
  padding: 10px;
}

.submit input, .submit {
  padding: 10px;
}

.totalPrice {
  padding: 30px 10px 10px 10px;
  color: red;
  font-size: 30px;
}
</style>
