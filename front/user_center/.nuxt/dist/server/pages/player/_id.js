exports.ids = [9];
exports.modules = {

/***/ 96:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/player/_id.vue?vue&type=template&id=52bdc9ae&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', {
    staticStyle: {
      "width": "1080px",
      "margin": "50px auto"
    }
  }, [_vm._ssrNode("<h1 style=\"text-align: center; margin: 20px auto;\">测试视频</h1> <link rel=\"stylesheet\" href=\"https://g.alicdn.com/de/prismplayer/2.8.1/skins/default/aliplayer-min.css\"> <script charset=\"utf-8\" type=\"text/javascript\" src=\"https://g.alicdn.com/de/prismplayer/2.8.1/aliplayer-min.js\"></script> <div id=\"J_prismPlayer\" class=\"prism-player\"></div>")]);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/player/_id.vue?vue&type=template&id=52bdc9ae&

// EXTERNAL MODULE: ./utils/request.js
var request = __webpack_require__(7);

// CONCATENATED MODULE: ./api/video.js

/* harmony default export */ var video = ({
  // 获取视频播放凭证
  getPlayAuth(id) {
    return Object(request["a" /* default */])({
      url: `/eduVod/videoVod/getVideoAuth/${id}`,
      method: 'get'
    });
  }

});
// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/player/_id.vue?vue&type=script&lang=js&

/* harmony default export */ var _idvue_type_script_lang_js_ = ({
  layout: 'default',

  // 应用video布局
  asyncData({
    params,
    error
  }) {
    return video.getPlayAuth(params.id).then(response => {
      return {
        vid: params.id,
        playAuth: response.data.data.playAuth
      };
    });
  },

  /**
   * 页面渲染完成时：此时js脚本已加载，Aliplayer已定义，可以使用
   * 如果在created生命周期函数中使用，Aliplayer is not defined错误
   */
  mounted() {
    new Aliplayer({
      id: 'J_prismPlayer',
      vid: this.vid,
      // 视频id
      playauth: this.playAuth,
      // 播放凭证
      encryptType: '1',
      // 如果播放加密视频，则需设置encryptType=1，非加密视频无需设置此项
      width: '100%',
      height: '500px',
      autoplay: false,
      // 自动播放
      controlBarVisibility: 'hover',
      // 控制条的显示方式：鼠标悬停
      useH5Prism: true // 播放器类型：html5

    }, function (player) {
      console.log('播放器创建成功');
    });
  }

});
// CONCATENATED MODULE: ./pages/player/_id.vue?vue&type=script&lang=js&
 /* harmony default export */ var player_idvue_type_script_lang_js_ = (_idvue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/player/_id.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  player_idvue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "0eb98ae3"
  
)

/* harmony default export */ var _id = __webpack_exports__["default"] = (component.exports);

/***/ })

};;
//# sourceMappingURL=_id.js.map