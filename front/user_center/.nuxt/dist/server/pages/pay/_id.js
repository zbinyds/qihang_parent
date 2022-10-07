exports.ids = [8];
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

/***/ 93:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "img/erweima.b6b264b.png";

/***/ }),

/***/ 98:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/pay/_id.vue?vue&type=template&id=5bb4deb0&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', {
    staticClass: "cart py-container"
  }, [_vm._ssrNode("<div class=\"checkout py-container pay\"><div class=\"checkout-tit\"><h4 class=\"fl tit-txt\"><span class=\"success-icon\"></span><span class=\"success-info\">" + _vm._ssrEscape("订单已提交，请您及时付款！订单号：" + _vm._s(_vm.payObj.out_trade_no)) + "</span></h4> <span class=\"fr\"><em class=\"sui-lead\">应付金额：</em><em class=\"orange money\">" + _vm._ssrEscape("￥" + _vm._s(_vm.payObj.total_fee)) + "</em></span> <div class=\"clearfix\"></div></div> <div class=\"checkout-steps\"><div class=\"fl weixin\"><img src=\"data:image/svg+xml;base64,PHN2ZyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnIHhtbG5zOnhsaW5rPSdodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rJyB3aWR0aD0nMjQnIGhlaWdodD0nMjQnIHZpZXdCb3g9JzAgMCAyNCAyNCc+ICA8ZGVmcz4gICAgPHBhdGggaWQ9JzBmMjA3OTFjLTY3NzQtNGU1Mi05MjBmLTZiNmQ4NDA0YjRkYy1hJyBkPSdNNi43MjQgMGgxMC41NTJjMi4zMzggMCAzLjE4Ni4yNDMgNC4wNC43QTQuNzY2IDQuNzY2IDAgMCAxIDIzLjMgMi42ODRjLjQ1OC44NTUuNzAxIDEuNzAzLjcwMSA0LjA0djEwLjU1M2MwIDIuMzM4LS4yNDMgMy4xODYtLjcgNC4wNGE0Ljc2NiA0Ljc2NiAwIDAgMS0xLjk4MyAxLjk4M2MtLjg1NS40NTgtMS43MDMuNzAxLTQuMDQuNzAxSDYuNzIzYy0yLjMzOCAwLTMuMTg2LS4yNDMtNC4wNC0uN0E0Ljc2NiA0Ljc2NiAwIDAgMSAuNyAyMS4zMTZjLS40NTctLjg1NC0uNy0xLjcwMi0uNy00LjAzOVY2LjcyM2MwLTIuMzM4LjI0My0zLjE4Ni43LTQuMDRBNC43NjYgNC43NjYgMCAwIDEgMi42ODQuN0MzLjUzOC4yNDMgNC4zODYgMCA2LjcyMyAweicvPiAgICA8bGluZWFyR3JhZGllbnQgaWQ9JzBmMjA3OTFjLTY3NzQtNGU1Mi05MjBmLTZiNmQ4NDA0YjRkYy1iJyB4MT0nNTAlJyB4Mj0nNTAlJyB5MT0nMCUnIHkyPScxMDAlJz4gICAgICA8c3RvcCBvZmZzZXQ9JzAlJyBzdG9wLWNvbG9yPScjMDJFMzZGJy8+ICAgICAgPHN0b3Agb2Zmc2V0PScxMDAlJyBzdG9wLWNvbG9yPScjMDVDRDY1Jy8+ICAgICAgPHN0b3Agb2Zmc2V0PScxMDAlJyBzdG9wLWNvbG9yPScjMDdDMTYwJy8+ICAgIDwvbGluZWFyR3JhZGllbnQ+ICA8L2RlZnM+ICA8ZyBmaWxsPSdub25lJyBmaWxsLXJ1bGU9J2V2ZW5vZGQnPiAgICA8bWFzayBpZD0nMGYyMDc5MWMtNjc3NC00ZTUyLTkyMGYtNmI2ZDg0MDRiNGRjLWMnIGZpbGw9JyNmZmYnPiAgICAgIDx1c2UgeGxpbms6aHJlZj0nIzBmMjA3OTFjLTY3NzQtNGU1Mi05MjBmLTZiNmQ4NDA0YjRkYy1hJy8+ICAgIDwvbWFzaz4gICAgPHBhdGggZmlsbD0ndXJsKCMwZjIwNzkxYy02Nzc0LTRlNTItOTIwZi02YjZkODQwNGI0ZGMtYiknIGQ9J00wIDBoMjR2MjRIMHonIG1hc2s9J3VybCgjMGYyMDc5MWMtNjc3NC00ZTUyLTkyMGYtNmI2ZDg0MDRiNGRjLWMpJy8+ICAgIDxwYXRoIGZpbGw9JyNGRkYnIGQ9J00xOS4wOTUgMTcuNjNjMS4xNDEtLjgyNiAxLjg3LTIuMDUgMS44Ny0zLjQwOCAwLTIuNDktMi40MjMtNC41MS01LjQxMS00LjUxLTIuOTg5IDAtNS40MTEgMi4wMi01LjQxMSA0LjUxIDAgMi40OSAyLjQyMiA0LjUxIDUuNDEgNC41MS42MTggMCAxLjIxNC0uMDg5IDEuNzY3LS4yNDhhLjU0My41NDMgMCAwIDEgLjQ0Ny4wNmwxLjE4NC42ODNjLjAzMy4wMi4wNjUuMDM0LjEwNC4wMzQuMSAwIC4xOC0uMDguMTgtLjE4IDAtLjA0NS0uMDE3LS4wOS0uMDI4LS4xMzJsLS4yNDQtLjkxYS4zNi4zNiAwIDAgMSAuMTMyLS40MDlNMTMuNzUgMTMuNWEuNzIxLjcyMSAwIDEgMSAwLTEuNDQyLjcyMS43MjEgMCAwIDEgMCAxLjQ0M005LjQ5MyA0LjczNGMzLjI0IDAgNS45MjUgMS45NzcgNi40MTQgNC41NjJhNy4yMDYgNy4yMDYgMCAwIDAtLjM1My0uMDFjLTMuMjcgMC01LjkyMiAyLjIxLTUuOTIyIDQuOTM2IDAgLjQ2LjA3Ny45MDQuMjE4IDEuMzI2YTcuNjg3IDcuNjg3IDAgMCAxLTIuNDc2LS4yODguNjUxLjY1MSAwIDAgMC0uNTM2LjA3MWwtMS40MjEuODJhLjI0NS4yNDUgMCAwIDEtLjEyNS4wNDEuMjE2LjIxNiAwIDAgMS0uMjE3LS4yMTZjMC0uMDU0LjAyMS0uMTA3LjAzNS0uMTU4bC4yOTItMS4wOTJhLjQzMy40MzMgMCAwIDAtLjE1OS0uNDlDMy44NzYgMTMuMjQzIDMgMTEuNzc1IDMgMTAuMTQ1YzAtMi45ODkgMi45MDctNS40MTIgNi40OTMtNS40MTJ6bTcuODY1IDcuMzIzYS43MjEuNzIxIDAgMSAxIDAgMS40NDMuNzIxLjcyMSAwIDAgMSAwLTEuNDQzek03LjMyOCA3LjU0OGEuODY2Ljg2NiAwIDEgMCAwIDEuNzMyLjg2Ni44NjYgMCAwIDAgMC0xLjczMnptNC4zMyAwYS44NjYuODY2IDAgMSAwIDAgMS43MzEuODY2Ljg2NiAwIDAgMCAwLTEuNzN6JyBtYXNrPSd1cmwoIzBmMjA3OTFjLTY3NzQtNGU1Mi05MjBmLTZiNmQ4NDA0YjRkYy1jKScvPiAgPC9nPjwvc3ZnPg==\">\n        微信支付\n      </div> <div class=\"fl sao\"><p class=\"red\">请使用微信扫一扫付款。</p> <div class=\"fl code\"><img id=\"qrious\"" + _vm._ssrAttr("src", __webpack_require__(93)) + " alt=\"测试二维码\"> <div class=\"saosao\"><p>请使用微信扫一扫</p> <p>扫描二维码支付</p></div></div></div> <div class=\"clearfix\"></div></div></div>")]);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/pay/_id.vue?vue&type=template&id=5bb4deb0&

// EXTERNAL MODULE: ./api/order.js
var order = __webpack_require__(71);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/pay/_id.vue?vue&type=script&lang=js&

/* harmony default export */ var _idvue_type_script_lang_js_ = ({
  // 根据订单id生成微信支付二维码
  asyncData({
    params,
    error
  }) {
    return order["a" /* default */].createCode(params.id).then(response => {
      return {
        payObj: response.data.data
      };
    });
  },

  data() {
    return {
      timer: null,
      // 定时器名称
      initQCode: '',
      timer1: ''
    };
  },

  mounted() {
    // 在页面渲染之后执行
    // 提示
    this.$notify({
      title: '起航教育',
      message: '测试阶段暂不提供支付功能。10s后将自动付款',
      type: 'warning',
      duration: 10000,
      // 显示时长10s
      offset: 100 // 向下偏移100像素

    }); // 定时器。每隔10秒，去查询一次支付状态

    this.timer1 = setInterval(() => {
      this.queryPayStatus(this.payObj.out_trade_no);
    }, 10000);
  },

  methods: {
    // 查询支付状态的方法
    queryPayStatus(out_trade_no) {
      order["a" /* default */].queryPayStatus(out_trade_no).then(response => {
        if (response.data.success) {
          // 如果支付成功，清除定时器
          clearInterval(this.timer1);
          this.$message.success(response.data.message); // 跳转到课程详情页面观看视频

          this.$router.push({
            path: '/course/' + this.payObj.course_id
          });
        }
      });
    }

  }
});
// CONCATENATED MODULE: ./pages/pay/_id.vue?vue&type=script&lang=js&
 /* harmony default export */ var pay_idvue_type_script_lang_js_ = (_idvue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/pay/_id.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  pay_idvue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "38982212"
  
)

/* harmony default export */ var _id = __webpack_exports__["default"] = (component.exports);

/***/ })

};;
//# sourceMappingURL=_id.js.map