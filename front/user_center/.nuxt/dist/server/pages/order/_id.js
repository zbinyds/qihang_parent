exports.ids = [7];
exports.modules = {

/***/ 71:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var _utils_request__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(7);

/* harmony default export */ __webpack_exports__["a"] = ({
  // 生成订单
  createOrdercourseId(courseId) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduOrder/order/createOrder/${courseId}`,
      method: 'post'
    });
  },

  // 根据订单id查询订单信息
  getOrderDetail(orderNo) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduOrder/order/getOrderDetail/${orderNo}`,
      method: 'get'
    });
  },

  // 生成微信支付二维码
  createCode(orderNo) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduOrder/pay/createNative/${orderNo}`,
      method: 'post'
    });
  },

  // 查询支付状态
  queryPayStatus(orderNo) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduOrder/pay/queryOrderStatus/${orderNo}`,
      method: 'post'
    });
  }

});

/***/ }),

/***/ 92:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "img/cart_setp2.3e654b7.png";

/***/ }),

/***/ 99:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/order/_id.vue?vue&type=template&id=c1d90074&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', {
    staticClass: "Page Confirm"
  }, [_vm._ssrNode("<div class=\"Title\"><h1 class=\"fl f18\">订单确认</h1> <img" + _vm._ssrAttr("src", __webpack_require__(92)) + " class=\"fr\"> <div class=\"clear\"></div></div> <form id=\"flowForm\" name=\"flowForm\" method=\"post\" action><table class=\"GoodList\"><tbody><tr><th class=\"name\">商品</th> <th class=\"price\">原价</th> <th class=\"priceNew\">价格</th></tr></tbody> <tbody><tr><td colspan=\"3\" class=\"teacher\">" + _vm._ssrEscape("讲师：" + _vm._s(_vm.order.teacherName)) + "</td></tr> <tr class=\"good\"><td class=\"name First\"><a" + _vm._ssrAttr("href", 'https://localhost:3000/course/' + _vm.order.courseId) + " target=\"_blank\"><img" + _vm._ssrAttr("src", _vm.order.courseCover) + "></a> <div class=\"goodInfo\"><input type=\"hidden\" value=\"14502\" class=\"ids ids_14502\"> <a" + _vm._ssrAttr("href", 'https://localhost:3000/course/' + _vm.order.courseId) + " target=\"_blank\">" + _vm._ssrEscape(_vm._s(_vm.order.courseTitle)) + "</a></div></td> <td class=\"price\"><p>\n              ￥<strong>" + _vm._ssrEscape(_vm._s(_vm.order.totalFee)) + "</strong></p></td> <td class=\"red priceNew Last\">\n            ￥<strong>" + _vm._ssrEscape(_vm._s(_vm.order.totalFee)) + "</strong></td></tr> <tr><td colspan=\"3\" class=\"Billing tr\"><div class=\"tr\"><p>\n                共 <strong class=\"red\">1</strong> 件商品，合计<span class=\"red f20\">￥<strong>" + _vm._ssrEscape(_vm._s(_vm.order.totalFee)) + "</strong></span></p></div></td></tr></tbody></table> <div class=\"Finish\"><div id=\"AgreeDiv\" class=\"fr\"><label for=\"Agree\"><p class=\"on\"><input type=\"checkbox\">我已阅读并同意<a href=\"javascript:void(0)\" target=\"_blank\">《起航教育购买协议》</a></p></label></div> <div class=\"clear\"></div> <div class=\"Main fl\"><div class=\"fl\"><a" + _vm._ssrAttr("href", '/course/' + _vm.order.courseId) + ">返回课程详情页</a></div> <div class=\"fr\"><p>\n            共 <strong class=\"red\">1</strong> 件商品，合计<span class=\"red f20\">￥<strong id=\"AllPrice\">" + _vm._ssrEscape(_vm._s(_vm.order.totalFee)) + "</strong></span></p></div></div> <input id=\"usedScore\" name=\"score\" value=\"0\" type=\"hidden\"> <button id=\"submitPay\" type=\"button\" class=\"fr redb\">\n        去支付\n      </button> <div class=\"clear\"></div></div></form>")]);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/order/_id.vue?vue&type=template&id=c1d90074&

// EXTERNAL MODULE: ./api/order.js
var order = __webpack_require__(71);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/order/_id.vue?vue&type=script&lang=js&

/* harmony default export */ var _idvue_type_script_lang_js_ = ({
  data() {
    return {
      orderNo: '',
      // 订单编号
      order: {},
      // 订单对象
      flag: 0 // 是否阅读协议

    };
  },

  created() {
    if (this.$route.params.id) {
      this.orderNo = this.$route.params.id;
      this.getOrderDetail();
    }
  },

  methods: {
    // 获取订单详细信息
    getOrderDetail() {
      order["a" /* default */].getOrderDetail(this.orderNo).then(res => {
        if (res.data.code === '20000') {
          this.order = res.data.data.order;
        }
      });
    },

    // 支付按钮
    toPay() {
      if (this.flag === 1) {
        this.$router.push({
          path: `/pay/${this.orderNo}`
        });
      } else {
        this.$message.error('请先阅读并同意《起航教育购买协议》！');
      }
    },

    // 判断协议是否被选中
    check() {
      if (event.target.checked) {
        this.flag = 1;
      } else {
        this.flag = 0;
      }
    }

  }
});
// CONCATENATED MODULE: ./pages/order/_id.vue?vue&type=script&lang=js&
 /* harmony default export */ var order_idvue_type_script_lang_js_ = (_idvue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/order/_id.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  order_idvue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "7ce945b8"
  
)

/* harmony default export */ var _id = __webpack_exports__["default"] = (component.exports);

/***/ })

};;
//# sourceMappingURL=_id.js.map