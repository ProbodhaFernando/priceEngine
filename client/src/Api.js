import axios from 'axios'

const SERVER_URL = 'http://localhost:9000'

const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 1000
})

export default {
  // Create
  createOrder: (productId, quantityType, quantity, status) => instance.post('/api/order',
    {
      productId: productId,
      qtyType: quantityType,
      quantity: quantity,
      status: status
    })
    .then(function (response) {
      return response
    })
    .catch(function (error) {
      console.log(error)
    }),

  // Read
  getAllProductPriceView: () => instance.get('/api/product/productPrice')
    .then(function (response) {
      return response
    }).catch(function (error) {
      console.log(error)
    }).finally(function () {
      console.log('Finally Executed!!!')
    }),
  getAllProducts: () => instance.get('/api/product/')
    .then(function (response) {
      return response
    }).catch(function (error) {
      console.log(error)
    }).finally(function () {
      console.log('Finally Executed!!!')
    })
}
