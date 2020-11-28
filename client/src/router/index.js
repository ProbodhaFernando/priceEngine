import Vue from 'vue'
import Router from 'vue-router'
import ProductPriceView from '../components/ProductPriceView'
import OrderProduct from '../components/OrderProduct'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/product_price_list',
      name: 'ProductPriceList',
      component: ProductPriceView
    },
    {
      path: '/order_product',
      name: 'OrderProduct',
      component: OrderProduct
    }
  ]
})
