exports.ids = [11];
exports.modules = {

/***/ 100:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/teacher/_id.vue?vue&type=template&id=7c43a76c&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', {
    staticClass: "bg-fa of",
    attrs: {
      "id": "aCoursesList"
    }
  }, [_vm._ssrNode("<section class=\"container\"><header class=\"comm-title\"><h2 class=\"fl tac\"><span class=\"c-333\">讲师介绍</span></h2></header> <div class=\"t-infor-wrap\"><section class=\"fl t-infor-box c-desc-content\"><div class=\"mt20 ml20\"><section class=\"t-infor-pic\"><img" + _vm._ssrAttr("src", _vm.teacherDetail.avatar) + "></section> <h3 class=\"hLh30\"><span class=\"fsize24 c-333\">" + _vm._ssrEscape(_vm._s(_vm.teacherDetail.name) + " \n              " + _vm._s(_vm.teacherDetail.level === 1 ? "高级讲师" : "首席讲师") + "\n            ") + "</span></h3> <section class=\"mt10\"><span class=\"t-tag-bg\">" + _vm._ssrEscape(_vm._s(_vm.teacherDetail.career)) + "</span></section> <section class=\"t-infor-txt\"><p class=\"mt20\">" + _vm._ssrEscape(_vm._s(_vm.teacherDetail.intro)) + "</p></section> <div class=\"clear\"></div></div></section> <div class=\"clear\"></div></div> <section class=\"mt30\"><div><header class=\"comm-title all-teacher-title c-course-content\"><h2 class=\"fl tac\"><span class=\"c-333\">主讲课程</span></h2> <section class=\"c-tab-title\"><a href=\"javascript: void(0)\"> </a></section></header> " + (_vm.eduCourseList.length == 0 ? "<section class=\"no-data-wrap\"><em class=\"icon30 no-data-ico\"> </em> <span class=\"c-666 fsize14 ml10 vam\">没有相关数据，小编正在努力整理中...</span></section>" : "<!---->") + " <article class=\"comm-course-list\"><ul class=\"of\">" + _vm._ssrList(_vm.eduCourseList, function (course) {
    return "<li><div class=\"cc-l-wrap\"><section class=\"course-img\"><img" + _vm._ssrAttr("src", course.cover) + " class=\"img-responsive\"> <div class=\"cc-mask\"><a" + _vm._ssrAttr("href", '/course/' + course.id) + " title=\"开始学习\" target=\"_blank\" class=\"comm-btn c-btn-1\">开始学习</a></div></section> <h3 class=\"hLh30 txtOf mt10\"><a" + _vm._ssrAttr("title", course.title) + _vm._ssrAttr("href", '/course/' + course.id) + " target=\"_blank\" class=\"course-title fsize18 c-333\">" + _vm._ssrEscape(_vm._s(course.title)) + "</a></h3></div></li>";
  }) + "</ul> <div class=\"clear\"></div></article></div></section></section>")]);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/teacher/_id.vue?vue&type=template&id=7c43a76c&

// EXTERNAL MODULE: ./api/teacher.js
var teacher = __webpack_require__(81);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/teacher/_id.vue?vue&type=script&lang=js&

/* harmony default export */ var _idvue_type_script_lang_js_ = ({
  // 异步请求，页面加载发送请求
  asyncData({
    params,
    error
  }) {
    return teacher["a" /* default */].getTeacherDetail(params.id).then(res => {
      return {
        teacherDetail: res.data.data.teacherDetail,
        eduCourseList: res.data.data.eduCourseList
      };
    });
  }

});
// CONCATENATED MODULE: ./pages/teacher/_id.vue?vue&type=script&lang=js&
 /* harmony default export */ var teacher_idvue_type_script_lang_js_ = (_idvue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/teacher/_id.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  teacher_idvue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "3124494c"
  
)

/* harmony default export */ var _id = __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ 81:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var _utils_request__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(7);

/* harmony default export */ __webpack_exports__["a"] = ({
  // 获取讲师分页信息
  getTeacherList(page, pageSize) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduService/teacherFront/teacherList/${page}/${pageSize}`,
      method: 'get'
    });
  },

  // 讲师详情
  getTeacherDetail(teacherId) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduService/teacherFront/teacherDetail/${teacherId}`,
      method: 'get'
    });
  }

});

/***/ })

};;
//# sourceMappingURL=_id.js.map