exports.ids = [3];
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

/***/ 72:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var _utils_request__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(7);

/* harmony default export */ __webpack_exports__["a"] = ({
  // 分页带条件查询课程列表
  coursePageCondition(page, pageSize, searchObj) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduService/courseFront/coursePageCondition/${page}/${pageSize}`,
      method: 'post',
      data: searchObj
    });
  },

  // 获取所有分类信息
  getAllSubject() {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduService/subject/getSubjectList`,
      method: 'get'
    });
  },

  // 获取课程详情数据
  getCourseInfo(courseId) {
    return Object(_utils_request__WEBPACK_IMPORTED_MODULE_0__[/* default */ "a"])({
      url: `/eduService/courseFront/getCourseDetail/${courseId}`,
      method: 'get'
    });
  }

});

/***/ }),

/***/ 91:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "img/avatar-boy.b88b103.gif";

/***/ }),

/***/ 94:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/course/_id.vue?vue&type=template&id=1353000b&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', {
    staticClass: "bg-fa of",
    attrs: {
      "id": "aCoursesList"
    }
  }, [_vm._ssrNode("<section class=\"container\">", "</section>", [_vm._ssrNode("<section class=\"path-wrap txtOf hLh30\"><a href=\"/\" title class=\"c-999 fsize14\">首页</a>\n      \\\n      <a href=\"/course\" title class=\"c-999 fsize14\">课程列表</a>\n      \\\n      <span class=\"c-333 fsize14\">" + _vm._ssrEscape(_vm._s(_vm.data.title)) + "</span></section> <div><article class=\"c-v-pic-wrap\" style=\"height: 357px\"><section id=\"videoPlay\" class=\"p-h-video-box\"><img" + _vm._ssrAttr("src", _vm.data.cover) + _vm._ssrAttr("alt", _vm.data.title) + " class=\"dis c-v-pic\"></section></article> <aside class=\"c-attr-wrap\" style=\"height: 357px; width: 520px\"><section class=\"ml20 mr15\"><h2 class=\"hLh30 txtOf mt15\"><span class=\"c-fff fsize24\">" + _vm._ssrEscape(_vm._s(_vm.data.title)) + "</span></h2> <section class=\"c-attr-jg\"><span class=\"c-fff\">价格：</span> <b class=\"c-yellow\" style=\"font-size: 24px\">" + _vm._ssrEscape("￥" + _vm._s(_vm.data.price)) + "</b></section> <section class=\"c-attr-mt c-attr-undis\"><span class=\"c-fff fsize14\">" + _vm._ssrEscape("主讲： " + _vm._s(_vm.data.name) + "   ") + "</span></section> <section class=\"c-attr-mt of\"><span class=\"ml10 vam\"><em class=\"icon18 scIcon\"></em> <a title=\"点击收藏课程\" class=\"c-fff vam\">" + _vm._ssrEscape("\n                " + _vm._s(!_vm.collectStatus ? "收藏" : "已收藏") + "\n              ") + "</a></span></section> <section class=\"c-attr-mt\">" + (_vm.data.price === 0 ? "<a href=\"#\" class=\"comm-btn c-btn-3\">立即观看</a>" : "<!---->") + " <a href=\"#\" class=\"comm-btn c-btn-3\"" + _vm._ssrStyle(null, null, {
    display: _vm.data.price !== 0 && !_vm.data.isAuth ? '' : 'none'
  }) + ">立即购买</a> <a href=\"#\" class=\"comm-btn c-btn-3\"" + _vm._ssrStyle(null, null, {
    display: _vm.data.isAuth && _vm.data.price !== 0 ? '' : 'none'
  }) + ">已购买</a></section></section></aside> <div class=\"clear\"></div></div> "), _vm._ssrNode("<div class=\"mt20 c-infor-box\">", "</div>", [_vm._ssrNode("<article class=\"fl col-7\">", "</article>", [_vm._ssrNode("<section class=\"mr30\">", "</section>", [_vm._ssrNode("<div class=\"i-box\">", "</div>", [_vm._ssrNode("<div><section id=\"c-i-tabTitle\" class=\"c-infor-tabTitle c-tab-title\"><a name=\"c-i\" title=\"课程详情\" href=\"javascript:void(0)\"" + _vm._ssrClass(null, {
    current: _vm.flag == 0
  }) + ">课程详情</a> <a name=\"c-i\" title=\"课程评价\" href=\"javascript:void(0)\"" + _vm._ssrClass(null, {
    current: _vm.flag == 1
  }) + ">课程评价</a></section></div> <article hre class=\"ml10 mr10 pt20\"" + _vm._ssrStyle(null, null, {
    display: _vm.flag == 0 ? '' : 'none'
  }) + "><div><h6 class=\"c-i-content c-infor-title\"><span>课程介绍</span></h6> <div class=\"course-txt-body-wrap\"><section class=\"course-txt-body\"><p>" + _vm._s(_vm.data.description) + "</p></section></div></div> <div class=\"mt50\"><h6 class=\"c-g-content c-infor-title\"><span>课程大纲</span></h6> " + (_vm.data.length === 0 ? "<section class=\"no-data-wrap\"><em class=\"icon30 no-data-ico\"> </em> <span class=\"c-666 fsize14 ml10 vam\">暂时还没有课程大纲哦，小编正在努力整理中...</span></section>" : "<!---->") + " <section class=\"mt20\"><div class=\"lh-menu-wrap\"><menu id=\"lh-menu\" class=\"lh-menu mt10 mr10\"><ul>" + _vm._ssrList(_vm.data.list, function (chapter) {
    return "<li class=\"lh-menu-stair\"><a" + _vm._ssrAttr("title", chapter.title) + " href=\"javascript: void(0)\" class=\"current-1\"><em class=\"lh-menu-i-1 icon18 mr10\"></em>" + _vm._ssrEscape(_vm._s(chapter.title) + "\n                          ") + "</a> <ol class=\"lh-menu-ol\" style=\"display: block\">" + _vm._ssrList(chapter.children, function (video) {
      return "<li class=\"lh-menu-second ml30\">" + (_vm.data.isAuth ? "<a" + _vm._ssrAttr("href", '/player/' + video.videoSourceId) + " target=\"_blank\"><span class=\"fr\"><i class=\"free-icon vam mr10\"" + _vm._ssrStyle(null, null, {
        display: video.isFree === 1 ? '' : 'none'
      }) + ">免费</i></span> <em class=\"lh-menu-i-2 icon16 mr5\"> </em>" + _vm._ssrEscape(_vm._s(video.title) + "\n                              ") + "</a>" : "<!---->") + "</li>";
    }) + "</ol></li>";
  }) + "</ul></menu></div></section> <section class=\"mt20\"></section></div></article> "), _vm._ssrNode("<article class=\"ml10 mr10 pt20\"" + _vm._ssrStyle(null, null, {
    display: _vm.flag == 1 ? '' : 'none'
  }) + ">", "</article>", [_vm._ssrNode("<div class=\"mt0 commentHtml\">", "</div>", [_vm._ssrNode("<div>", "</div>", [_vm._ssrNode("<h6 id=\"i-art-comment\" class=\"c-c-content c-infor-title\"><span class=\"commentTitle\">" + _vm._ssrEscape("课程评论 (共" + _vm._s(_vm.commentInfo.total) + "条评论)") + "</span></h6> "), _vm._ssrNode("<section class=\"lh-bj-list pr mt20 replyhtml\">", "</section>", [_vm._ssrNode("<ul>", "</ul>", [_vm._ssrNode("<li class=\"unBr\">", "</li>", [_vm._ssrNode("<aside class=\"noter-pic\"><img width=\"50\" height=\"50\"" + _vm._ssrAttr("src", __webpack_require__(91)) + " class=\"picImg\"></aside> "), _vm._ssrNode("<div class=\"of\">", "</div>", [_vm._ssrNode("<section class=\"n-reply-wrap\">", "</section>", [_vm._ssrNode("<fieldset><textarea id=\"commentContent\" name placeholder=\"输入您要评论的文字\">" + _vm._ssrEscape(_vm._s(_vm.comment.content)) + "</textarea></fieldset> "), _vm._ssrNode("<p class=\"of mt5 tar pl10 pr10\">", "</p>", [_vm._ssrNode("<span class=\"fl\">", "</span>", [_c('tt', {
    staticClass: "c-red commentContentmeg",
    staticStyle: {
      "display": "none"
    }
  })], 1), _vm._ssrNode(" <input type=\"button\" value=\"回复\" class=\"lh-reply-btn\">")], 2)], 2)])], 2)])]), _vm._ssrNode(" "), _vm._ssrNode("<section>", "</section>", [_vm._ssrNode("<section class=\"question-list lh-bj-list pr\">", "</section>", [_vm._ssrNode("<ul class=\"pr10\">", "</ul>", _vm._l(_vm.commentInfo.items, function (comment, index) {
    return _vm._ssrNode("<li>", "</li>", [_vm._ssrNode("<aside class=\"noter-pic\"><img" + _vm._ssrAttr("src", comment.avatar) + " width=\"50\" height=\"50\" class=\"picImg\"></aside> "), _vm._ssrNode("<div class=\"of\">", "</div>", [_vm._ssrNode("<span class=\"fl\">", "</span>", [_c('font', {
      staticClass: "fsize12 c-blue"
    }, [_vm._v("\n                                " + _vm._s(comment.nickname))]), _vm._ssrNode(" "), _c('font', {
      staticClass: "fsize12 c-999 ml5"
    }, [_vm._v("评论：")])], 2)]), _vm._ssrNode(" <div class=\"noter-txt mt5\"><p>" + _vm._ssrEscape(_vm._s(comment.content)) + "</p></div> "), _vm._ssrNode("<div class=\"of mt5\">", "</div>", [_vm._ssrNode("<span class=\"fr\">", "</span>", [_c('font', {
      staticClass: "fsize12 c-999 ml5"
    }, [_vm._v(_vm._s(comment.gmtCreate))])], 1)])], 2);
  }), 0)])]), _vm._ssrNode(" <div class=\"paging\"><a href=\"#\" title=\"首页\"" + _vm._ssrClass(null, {
    undisable: !_vm.commentInfo.hasPrevious
  }) + ">首</a> <a href=\"#\" title=\"前一页\"" + _vm._ssrClass(null, {
    undisable: !_vm.commentInfo.hasPrevious
  }) + ">&lt;</a> " + _vm._ssrList(_vm.commentInfo.pages, function (page) {
    return "<a" + _vm._ssrAttr("title", '第' + page + '页') + " href=\"#\"" + _vm._ssrClass(null, {
      current: _vm.commentInfo.current == page,
      undisable: _vm.commentInfo.current == page
    }) + ">" + _vm._ssrEscape(_vm._s(page)) + "</a>";
  }) + " <a href=\"#\" title=\"后一页\"" + _vm._ssrClass(null, {
    undisable: !_vm.commentInfo.hasNext
  }) + ">&gt;</a> <a href=\"#\" title=\"末页\"" + _vm._ssrClass(null, {
    undisable: !_vm.commentInfo.hasNext
  }) + ">末</a> <div class=\"clear\"></div></div>")], 2)])])], 2)])]), _vm._ssrNode(" <aside class=\"fl col-3\"><div class=\"i-box\"><div><section class=\"c-infor-tabTitle c-tab-title\"><a title=\"主讲讲师\">主讲讲师</a></section> <section class=\"stud-act-list\"><ul style=\"height: auto\"><li><div class=\"u-face\"><a" + _vm._ssrAttr("href", '/teacher/' + _vm.data.teacherId) + " target=\"_blank\"><img" + _vm._ssrAttr("src", _vm.data.avatar) + " width=\"50\" height=\"50\" alt></a></div> <section class=\"hLh30 txtOf\"><a" + _vm._ssrAttr("href", '/teacher/' + _vm.data.teacherId) + " target=\"_blank\" class=\"c-333 fsize16 fl\">" + _vm._ssrEscape(_vm._s(_vm.data.name)) + "</a></section> <section class=\"hLh20 txtOf\"><span class=\"c-999\">" + _vm._ssrEscape(_vm._s(_vm.data.career)) + "</span></section></li></ul></section></div></div></aside> <div class=\"clear\"></div>")], 2)], 2)]);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/course/_id.vue?vue&type=template&id=1353000b&

// EXTERNAL MODULE: ./api/course.js
var course = __webpack_require__(72);

// EXTERNAL MODULE: ./utils/request.js
var request = __webpack_require__(7);

// CONCATENATED MODULE: ./api/collect.js

/* harmony default export */ var collect = ({
  // 收藏课程
  collect(courseId, memberId) {
    return Object(request["a" /* default */])({
      url: '/eduService/collect',
      method: 'post',
      data: {
        courseId,
        memberId
      }
    });
  },

  // 查询课程收藏状态
  collectStatus(courseId, memberId) {
    return Object(request["a" /* default */])({
      url: `/eduService/collect/${courseId}/${memberId}`,
      methods: 'get'
    });
  }

});
// CONCATENATED MODULE: ./api/comment.js

/* harmony default export */ var api_comment = ({
  // 获取课程评论分页数据
  getCommentPage(courseId, page, pageSize) {
    return Object(request["a" /* default */])({
      url: `/eduService/comment/getCommentList/${courseId}/${page}/${pageSize}`,
      method: 'get'
    });
  },

  // 发布评论
  saveComment(comment) {
    return Object(request["a" /* default */])({
      url: '/eduService/comment/saveComment',
      method: 'post',
      data: comment
    });
  }

});
// EXTERNAL MODULE: ./api/login.js
var login = __webpack_require__(9);

// EXTERNAL MODULE: ./api/order.js
var order = __webpack_require__(71);

// EXTERNAL MODULE: external "js-cookie"
var external_js_cookie_ = __webpack_require__(5);
var external_js_cookie_default = /*#__PURE__*/__webpack_require__.n(external_js_cookie_);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/course/_id.vue?vue&type=script&lang=js&






/* harmony default export */ var _idvue_type_script_lang_js_ = ({
  data() {
    return {
      courseId: '',
      // 课程id
      data: {},
      // 课程信息
      length: 0,
      // 课程章节小节列表长度
      flag: 0,
      // 用户控制详情和评论切换
      commentInfo: {},
      // 分页课程评论信息
      comment: {},
      // 评论对象
      collectStatus: false // 课程是否被收藏

    };
  },

  created() {
    if (this.$route.params.id) {
      this.courseId = this.$route.params.id;
      this.getCourseDetail();
      this.getCommentList();
      this.initData(); // 初始化用户信息
    }
  },

  methods: {
    // 根据token获取到用户信息
    initData() {
      var token = external_js_cookie_default.a.get('token');

      if (token) {
        login["a" /* default */].getMemberInfo().then(res => {
          this.loginInfo = res.data.data.UserInfo; // 查询课程是否被收藏

          this.isCollect();
        });
      }
    },

    // ==================课程支付=================
    createOrders() {
      // 判断用户是否登录，已登录才能够购买课程
      if (this.loginInfo !== undefined) {
        this.$confirm('还未拥有此课程, 立即购买?', '起航教育', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          order["a" /* default */].createOrdercourseId(this.courseId).then(res => {
            // 获取订单号并跳转到订单详情页面
            this.$router.push({
              path: `/order/${res.data.data.orderNo}`
            });
          });
        });
      } else {
        // 未登录提示请登录后评论
        this.$message.error('请登录后购买课程！');
        this.$router.push({
          path: '/login'
        });
      }
    },

    // ==================课程评论=================
    // 获取评论分页展示列表信息
    getCommentList() {
      api_comment.getCommentPage(this.courseId, 1, 10).then(res => {
        this.commentInfo = res.data.data;
      });
    },

    // 发表评论
    addComment() {
      // 如果登录了才能发表评论
      if (this.loginInfo) {
        // 封装评论对象
        this.comment.memberId = this.loginInfo.id;
        this.comment.nickname = this.loginInfo.nickname;
        this.comment.avatar = this.loginInfo.avatar;
        this.comment.courseId = this.courseId;
        this.comment.teacherId = this.data.teacherId; // 发表评论

        api_comment.saveComment(this.comment).then(res => {
          if (res.data.code === '20000') {
            // 成功提示
            this.$message.success(res.data.message); // 清空评论框

            this.comment.content = ''; // 发表评论后，重新刷新评论列表

            this.getCommentList();
          } else {
            this.$message.error(res.data.message);
          }
        });
      } else {
        // 未登录提示请登录后评论
        this.$message.error('请登录后评论！');
        this.$router.push({
          path: '/login'
        });
      }
    },

    // 评论翻页
    gotoPage(page) {
      // 只有（当跳转的页码为有效页码)且(跳转的页码不和当前页码相同)时才进行跳转。
      if (page > 0 && page <= this.commentInfo.pages && page !== this.commentInfo.current) {
        api_comment.getCommentPage(this.courseId, page, 10).then(res => {
          this.commentInfo = res.data.data;
        });
      }
    },

    // ==================课程详情=================
    getCourseDetail() {
      course["a" /* default */].getCourseInfo(this.courseId).then(response => {
        this.data = response.data.data;
        this.data.length = response.data.data.list.length;
      });
    },

    // ==================课程收藏=================
    // 查询课程是否被收藏
    isCollect() {
      collect.collectStatus(this.courseId, this.loginInfo.id).then(res => {
        // 课程已收藏
        if (res.data.message === '课程已收藏！') {
          this.collectStatus = true;
        }
      });
    },

    collect() {
      // 当课程未收藏且已登录时，才允许收藏
      if (!this.collectStatus && this.loginInfo) {
        collect.collect(this.courseId, this.loginInfo.id).then(res => {
          this.collectStatus = true;
          this.$message.success(res.data.message);
        });
      }
    }

  }
});
// CONCATENATED MODULE: ./pages/course/_id.vue?vue&type=script&lang=js&
 /* harmony default export */ var course_idvue_type_script_lang_js_ = (_idvue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/course/_id.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  course_idvue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "83ac13c6"
  
)

/* harmony default export */ var _id = __webpack_exports__["default"] = (component.exports);

/***/ })

};;
//# sourceMappingURL=_id.js.map