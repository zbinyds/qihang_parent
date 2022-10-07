exports.ids = [5];
exports.modules = {

/***/ 97:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/index.vue?vue&type=template&id=6267cf58&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', [_c('div', {
    directives: [{
      name: "swiper",
      rawName: "v-swiper:mySwiper",
      value: _vm.swiperOption,
      expression: "swiperOption",
      arg: "mySwiper"
    }]
  }, [_vm._ssrNode("<div class=\"swiper-wrapper\">" + _vm._ssrList(_vm.bannerList, function (banner) {
    return "<div class=\"swiper-slide\" style=\"background: #040b1b\"><a" + _vm._ssrAttr("href", banner.linkUrl) + " target=\"_blank\"><img" + _vm._ssrAttr("src", banner.imageUrl) + _vm._ssrAttr("alt", banner.title) + "></a></div>";
  }) + "</div> <div class=\"swiper-pagination swiper-pagination-white\"></div> <div slot=\"button-prev\" class=\"swiper-button-prev swiper-button-white\"></div> <div slot=\"button-next\" class=\"swiper-button-next swiper-button-white\"></div>")]), _vm._ssrNode(" <div id=\"aCoursesList\"><div><section class=\"container\"><header class=\"comm-title\"><h2 class=\"tac\"><span class=\"c-333\">热门课程</span></h2></header> <div><article class=\"comm-course-list\"><ul id=\"bna\" class=\"of\">" + _vm._ssrList(_vm.courseList, function (course) {
    return "<li><div class=\"cc-l-wrap\"><section class=\"course-img\"><img" + _vm._ssrAttr("src", course.cover) + _vm._ssrAttr("alt", course.title) + " class=\"img-responsive\"> <div class=\"cc-mask\"><a" + _vm._ssrAttr("href", '/course/' + course.id) + " title=\"开始学习\" class=\"comm-btn c-btn-1\">开始学习</a></div></section> <h3 class=\"hLh30 txtOf mt10\"><a" + _vm._ssrAttr("title", course.title) + _vm._ssrAttr("href", '/course/' + course.id) + " class=\"course-title fsize18 c-333\">" + _vm._ssrEscape(_vm._s(course.title)) + "</a></h3> <section class=\"mt10 hLh20 of\">" + (course.price == 0 ? "<span class=\"fr jgTag bg-green\"><i class=\"c-fff fsize12 f-fA\">免费</i></span>" : "<span class=\"fr jgTag bg-red\"><i class=\"c-fff fsize12 f-fA\">" + _vm._ssrEscape(_vm._s(course.price)) + "</i></span>") + " <span class=\"fl jgAttr c-ccc f-fA\"><i class=\"c-999 f-fA\">" + _vm._ssrEscape(_vm._s(course.viewCount) + "人学习") + "</i>\n                      |\n                      <i class=\"c-999 f-fA\">" + _vm._ssrEscape(_vm._s(course.lessonNum) + "课时") + "</i></span></section></div></li>";
  }) + "</ul> <div class=\"clear\"></div></article> <section class=\"tac pt20\"><a href=\"/course\" target=\"_blank\" title=\"全部课程\" class=\"comm-btn c-btn-2\">全部课程</a></section></div></section></div> <div><section class=\"container\"><header class=\"comm-title\"><h2 class=\"tac\"><span class=\"c-333\">名师大咖</span></h2></header> <div><article class=\"i-teacher-list\"><ul class=\"of\">" + _vm._ssrList(_vm.teacherList, function (teacher) {
    return "<li><section class=\"i-teach-wrap\"><div class=\"i-teach-pic\"><a" + _vm._ssrAttr("title", teacher.name) + " href=\"#\"><img" + _vm._ssrAttr("alt", teacher.name) + _vm._ssrAttr("src", teacher.avatar) + "></a></div> <div class=\"mt10 hLh30 txtOf tac\"><a" + _vm._ssrAttr("title", teacher.name) + " href=\"#\" class=\"fsize18 c-666\">" + _vm._ssrEscape(_vm._s(teacher.name)) + "</a></div> <div class=\"hLh30 txtOf tac\"><span class=\"fsize14 c-999\">" + _vm._ssrEscape(_vm._s(teacher.career)) + "</span></div> <div class=\"mt15 i-q-txt\"><p class=\"c-999 f-fA\">" + _vm._ssrEscape("\n                      " + _vm._s(teacher.intro) + "\n                    ") + "</p></div></section></li>";
  }) + "</ul> <div class=\"clear\"></div></article> <section class=\"tac pt20\"><a href=\"/teacher\" target=\"_blank\" title=\"全部讲师\" class=\"comm-btn c-btn-2\">全部讲师</a></section></div></section></div></div>")], 2);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/index.vue?vue&type=template&id=6267cf58&

// EXTERNAL MODULE: ./utils/request.js
var request = __webpack_require__(7);

// CONCATENATED MODULE: ./api/banner.js

/* harmony default export */ var banner = ({
  // 获取首页banner轮播图数据
  getBannerList() {
    return Object(request["a" /* default */])({
      url: '/educms/userBanner/getBannerLimitThree',
      method: 'get'
    });
  },

  // 获取前台首页热门课程以及名师数据
  getIndexHotData() {
    return Object(request["a" /* default */])({
      url: '/eduService/front/index',
      method: 'get'
    });
  }

});
// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/index.vue?vue&type=script&lang=js&

/* harmony default export */ var lib_vue_loader_options_pagesvue_type_script_lang_js_ = ({
  data() {
    return {
      swiperOption: {
        // 配置分页
        pagination: {
          el: '.swiper-pagination' // 分页的dom节点

        },
        // 配置导航
        navigation: {
          nextEl: '.swiper-button-next',
          // 下一页dom节点
          prevEl: '.swiper-button-prev' // 前一页dom节点

        },
        autoplay: {
          disableOnInteraction: true,
          // 用户操作swiper之后，是否禁止自动轮播
          delay: 5000 // 5s自动轮播

        }
      },
      bannerList: [],
      // 轮播图列表
      courseList: [],
      // 热门课程展示
      teacherList: [] // 名师展示

    };
  },

  created() {
    this.getBannerList();
    this.getCourseAndTeacherData();
  },

  methods: {
    // 获取轮播图数据
    getBannerList() {
      banner.getBannerList().then(res => {
        this.bannerList = res.data.data.bannerList;
      });
    },

    // 获取热门课程、名师数据
    getCourseAndTeacherData() {
      banner.getIndexHotData().then(res => {
        this.courseList = res.data.data.courseList;
        this.teacherList = res.data.data.teacherList;
      });
    }

  }
});
// CONCATENATED MODULE: ./pages/index.vue?vue&type=script&lang=js&
 /* harmony default export */ var pagesvue_type_script_lang_js_ = (lib_vue_loader_options_pagesvue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/index.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  pagesvue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "4979d15e"
  
)

/* harmony default export */ var pages = __webpack_exports__["default"] = (component.exports);

/***/ })

};;
//# sourceMappingURL=index.js.map