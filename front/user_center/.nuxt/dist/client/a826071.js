(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{404:function(t,e,c){"use strict";c.r(e);c(42);var r=c(95),n=function(){return Object(r.a)({url:"/educms/userBanner/getBannerLimitThree",method:"get"})},l=function(){return Object(r.a)({url:"/eduService/front/index",method:"get"})},o={data:function(){return{swiperOption:{pagination:{el:".swiper-pagination"},navigation:{nextEl:".swiper-button-next",prevEl:".swiper-button-prev"},autoplay:{disableOnInteraction:!0,delay:5e3}},bannerList:[],courseList:[],teacherList:[]}},created:function(){this.getBannerList(),this.getCourseAndTeacherData()},methods:{getBannerList:function(){var t=this;n().then((function(e){t.bannerList=e.data.data.bannerList}))},getCourseAndTeacherData:function(){var t=this;l().then((function(e){t.courseList=e.data.data.courseList,t.teacherList=e.data.data.teacherList}))}}},v=c(24),component=Object(v.a)(o,(function(){var t=this,e=t._self._c;return e("div",[e("div",{directives:[{name:"swiper",rawName:"v-swiper:mySwiper",value:t.swiperOption,expression:"swiperOption",arg:"mySwiper"}]},[e("div",{staticClass:"swiper-wrapper"},t._l(t.bannerList,(function(t){return e("div",{key:t.id,staticClass:"swiper-slide",staticStyle:{background:"#040b1b"}},[e("a",{attrs:{href:t.linkUrl,target:"_blank"}},[e("img",{attrs:{src:t.imageUrl,alt:t.title}})])])})),0),t._v(" "),e("div",{staticClass:"swiper-pagination swiper-pagination-white"}),t._v(" "),e("div",{staticClass:"swiper-button-prev swiper-button-white",attrs:{slot:"button-prev"},slot:"button-prev"}),t._v(" "),e("div",{staticClass:"swiper-button-next swiper-button-white",attrs:{slot:"button-next"},slot:"button-next"})]),t._v(" "),e("div",{attrs:{id:"aCoursesList"}},[e("div",[e("section",{staticClass:"container"},[t._m(0),t._v(" "),e("div",[e("article",{staticClass:"comm-course-list"},[e("ul",{staticClass:"of",attrs:{id:"bna"}},t._l(t.courseList,(function(c){return e("li",{key:c.id},[e("div",{staticClass:"cc-l-wrap"},[e("section",{staticClass:"course-img"},[e("img",{staticClass:"img-responsive",attrs:{src:c.cover,alt:c.title}}),t._v(" "),e("div",{staticClass:"cc-mask"},[e("a",{staticClass:"comm-btn c-btn-1",attrs:{href:"/course/"+c.id,title:"开始学习"}},[t._v("开始学习")])])]),t._v(" "),e("h3",{staticClass:"hLh30 txtOf mt10"},[e("a",{staticClass:"course-title fsize18 c-333",attrs:{title:c.title,href:"/course/"+c.id}},[t._v(t._s(c.title))])]),t._v(" "),e("section",{staticClass:"mt10 hLh20 of"},[0==c.price?e("span",{staticClass:"fr jgTag bg-green"},[e("i",{staticClass:"c-fff fsize12 f-fA"},[t._v("免费")])]):e("span",{staticClass:"fr jgTag bg-red"},[e("i",{staticClass:"c-fff fsize12 f-fA"},[t._v(t._s(c.price))])]),t._v(" "),e("span",{staticClass:"fl jgAttr c-ccc f-fA"},[e("i",{staticClass:"c-999 f-fA"},[t._v(t._s(c.viewCount)+"人学习")]),t._v("\n                      |\n                      "),e("i",{staticClass:"c-999 f-fA"},[t._v(t._s(c.lessonNum)+"课时")])])])])])})),0),t._v(" "),e("div",{staticClass:"clear"})]),t._v(" "),t._m(1)])])]),t._v(" "),e("div",[e("section",{staticClass:"container"},[t._m(2),t._v(" "),e("div",[e("article",{staticClass:"i-teacher-list"},[e("ul",{staticClass:"of"},t._l(t.teacherList,(function(c){return e("li",{key:c.id},[e("section",{staticClass:"i-teach-wrap"},[e("div",{staticClass:"i-teach-pic"},[e("a",{attrs:{title:c.name,href:"#"}},[e("img",{attrs:{alt:c.name,src:c.avatar}})])]),t._v(" "),e("div",{staticClass:"mt10 hLh30 txtOf tac"},[e("a",{staticClass:"fsize18 c-666",attrs:{title:c.name,href:"#"}},[t._v(t._s(c.name))])]),t._v(" "),e("div",{staticClass:"hLh30 txtOf tac"},[e("span",{staticClass:"fsize14 c-999"},[t._v(t._s(c.career))])]),t._v(" "),e("div",{staticClass:"mt15 i-q-txt"},[e("p",{staticClass:"c-999 f-fA"},[t._v("\n                      "+t._s(c.intro)+"\n                    ")])])])])})),0),t._v(" "),e("div",{staticClass:"clear"})]),t._v(" "),t._m(3)])])])])])}),[function(){var t=this._self._c;return t("header",{staticClass:"comm-title"},[t("h2",{staticClass:"tac"},[t("span",{staticClass:"c-333"},[this._v("热门课程")])])])},function(){var t=this._self._c;return t("section",{staticClass:"tac pt20"},[t("a",{staticClass:"comm-btn c-btn-2",attrs:{href:"/course",target:"_blank",title:"全部课程"}},[this._v("全部课程")])])},function(){var t=this._self._c;return t("header",{staticClass:"comm-title"},[t("h2",{staticClass:"tac"},[t("span",{staticClass:"c-333"},[this._v("名师大咖")])])])},function(){var t=this._self._c;return t("section",{staticClass:"tac pt20"},[t("a",{staticClass:"comm-btn c-btn-2",attrs:{href:"/teacher",target:"_blank",title:"全部讲师"}},[this._v("全部讲师")])])}],!1,null,null,null);e.default=component.exports}}]);