(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-95a2"],{"B/8z":function(e,t,i){},KjZR:function(e,t,i){"use strict";var o=i("B/8z");i.n(o).a},VTSi:function(e,t,i){"use strict";i.r(t);var o=i("t3Un"),s=function(e){return Object(o.a)({url:"/eduService/chapter/getAllChapter/"+e,method:"get"})},r=function(e){return Object(o.a)({url:"/eduService/chapter",method:"post",data:e})},a=function(e,t){return Object(o.a)({url:"/eduService/chapter/"+e,method:"put",data:t})},n=function(e){return Object(o.a)({url:"/eduService/chapter/"+e,method:"delete"})},d=function(e){return Object(o.a)({url:"/eduService/chapter/"+e,method:"get"})},l=function(e){return Object(o.a)({url:"/eduService/video",method:"post",data:e})},c=function(e){return Object(o.a)({url:"/eduService/video",method:"put",data:e})},u=function(e){return Object(o.a)({url:"/eduService/video/"+e,method:"delete"})},h=function(e){return Object(o.a)({url:"/eduService/video/"+e,method:"get"})},v=function(e){return Object(o.a)({url:"/eduVod/videoVod/removeVideo/"+e,method:"delete"})},p={data:function(){return{saveBtnDisabled:!1,chapterVideoList:[],courseId:"",dialogChapterFormVisible:!1,dialogVideoFormVisible:!1,saveVideoBtnDisabled:!1,eduChapter:{title:"",sort:0},video:{id:"",title:"",sort:0,isFree:0,videoSourceId:"",videoOriginalName:"",duration:0,size:0},formTitle:"",flag:"",BASE_API:"https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin",fileList:[]}},created:function(){this.$route.params&&this.$route.params.id&&(this.$route.query&&this.$route.query.from&&(this.flag=this.$route.query.from),this.courseId=this.$route.params.id,this.getChapterVideoList(this.courseId))},methods:{handleVodUploadSuccess:function(e,t){var i=this;this.video.videoSourceId=e.data.videoId,this.video.videoOriginalName=t.name,this.video.size=t.size;var o=new Audio(t.url);o.addEventListener("loadedmetadata",function(){i.video.duration=Math.round(o.duration),console.log("时长："+i.video.duration+"s")}),console.log(this.video)},handleUploadExceed:function(e,t){this.$message.warning("想要重新上传视频，请先删除已上传的视频！")},beforeVodRemove:function(e,t){return this.$confirm("确定移除 <<"+e.name+">>？")},handleVodRemove:function(){var e=this;v(this.video.videoSourceId).then(function(t){e.$message.success(t.message),e.fileList=[],e.video.videoSourceId="",e.video.videoOriginalName="",e.video.size=0,e.video.duration=0})},openAddVideo:function(e){this.formTitle="添加小节",this.dialogVideoFormVisible=!0,this.video.id="",this.video.title="",this.video.sort=0,this.video.isFree=0,this.video.chapterId=e,this.video.duration=0,this.video.size=0},openEditVideo:function(e){var t=this;this.formTitle="修改小节",this.dialogVideoFormVisible=!0,this.fileList=[],h(e).then(function(e){t.video=e.data.video}),console.log(this.video)},saveVideo:function(){var e=this;this.video.courseId=this.courseId,l(this.video).then(function(t){e.$message.success(t.message),e.dialogVideoFormVisible=!1,e.fileList=[],e.video.videoSourceId="",e.video.videoOriginalName="",e.video.size=0,e.video.duration=0,e.getChapterVideoList(e.courseId)})},updateVideo:function(){var e=this;c(this.video).then(function(t){e.$message.success(t.message),e.dialogVideoFormVisible=!1,e.getChapterVideoList(e.courseId)})},saveOrUpdateVideo:function(){""===this.video.id?""===this.video.title?this.$message.error("必填参数缺失！"):this.saveVideo():this.updateVideo()},removeVideoConfirm:function(e){var t=this;this.$confirm("此操作将永久删除该小节, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){return u(e)}).then(function(e){t.$message.success(e.message),t.getChapterVideoList(t.courseId)})},removeChapterConfirm:function(e){var t=this;this.$confirm("此操作将永久删除该章节, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){return n(e)}).then(function(e){t.$message.success(e.message),t.getChapterVideoList(t.courseId)})},openEditChapter:function(e){var t=this;this.formTitle="修改章节",this.dialogChapterFormVisible=!0,d(e).then(function(e){t.eduChapter=e.data.chapter})},openAddChapter:function(){this.dialogChapterFormVisible=!0,this.formTitle="添加章节",this.eduChapter={sort:0}},addChapter:function(){var e=this;this.eduChapter.courseId=this.courseId,r(this.eduChapter).then(function(t){e.$message.success(t.message),e.dialogChapterFormVisible=!1,e.getChapterVideoList(e.courseId)})},editChapter:function(){var e=this;a(this.eduChapter.id,this.eduChapter).then(function(t){e.$message.success(t.message),e.dialogChapterFormVisible=!1,e.getChapterVideoList(e.courseId)})},saveOrUpdate:function(){this.eduChapter.id?this.editChapter():this.addChapter()},getChapterVideoList:function(e){var t=this;s(e).then(function(e){t.chapterVideoList=e.data.list})},previous:function(){this.$router.push({path:"/edu/course/info/"+this.courseId})},next:function(){"edit"===this.flag?this.$router.push({path:"/edu/course/list"}):this.$router.push({path:"/edu/course/publish/"+this.courseId})}}},m=(i("KjZR"),i("ZrdR")),f=Object(m.a)(p,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},["edit"!==e.flag?i("h2",{staticStyle:{"text-align":"center"}},[e._v("发布新课程")]):i("h2",{staticStyle:{"text-align":"center"}},[e._v("修改课程大纲")]),e._v(" "),"edit"!==e.flag?i("el-steps",{staticStyle:{"margin-bottom":"40px"},attrs:{active:2,"process-status":"wait","align-center":""}},[i("el-step",{attrs:{title:"填写课程基本信息"}}),e._v(" "),i("el-step",{attrs:{title:"创建课程大纲"}}),e._v(" "),i("el-step",{attrs:{title:"发布提交"}})],1):e._e(),e._v(" "),i("el-button",{attrs:{type:"text"},on:{click:function(t){e.openAddChapter()}}},[e._v("添加章节")]),e._v(" "),i("el-dialog",{attrs:{visible:e.dialogChapterFormVisible,title:e.formTitle},on:{"update:visible":function(t){e.dialogChapterFormVisible=t}}},[i("el-form",{attrs:{model:e.eduChapter,"label-width":"120px"}},[i("el-form-item",{attrs:{label:"章节标题"}},[i("el-input",{model:{value:e.eduChapter.title,callback:function(t){e.$set(e.eduChapter,"title",t)},expression:"eduChapter.title"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"章节排序"}},[i("el-input-number",{attrs:{min:0,"controls-position":"right"},model:{value:e.eduChapter.sort,callback:function(t){e.$set(e.eduChapter,"sort",t)},expression:"eduChapter.sort"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.dialogChapterFormVisible=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.saveOrUpdate}},[e._v("确 定")])],1)],1),e._v(" "),i("el-dialog",{attrs:{visible:e.dialogVideoFormVisible,title:e.formTitle},on:{"update:visible":function(t){e.dialogVideoFormVisible=t}}},[i("el-form",{attrs:{model:e.video,"label-width":"120px"}},[i("el-form-item",{attrs:{label:"课时标题"}},[i("el-input",{model:{value:e.video.title,callback:function(t){e.$set(e.video,"title",t)},expression:"video.title"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课时排序"}},[i("el-input-number",{attrs:{min:0,"controls-position":"right"},model:{value:e.video.sort,callback:function(t){e.$set(e.video,"sort",t)},expression:"video.sort"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"是否免费"}},[i("el-radio-group",{model:{value:e.video.isFree,callback:function(t){e.$set(e.video,"isFree",t)},expression:"video.isFree"}},[i("el-radio",{attrs:{label:0}},[e._v("默认")]),e._v(" "),i("el-radio",{attrs:{label:1}},[e._v("免费")])],1)],1),e._v(" "),i("el-form-item",{attrs:{label:"上传视频"}},[i("el-upload",{staticClass:"upload-demo",attrs:{"on-success":e.handleVodUploadSuccess,"on-remove":e.handleVodRemove,"before-remove":e.beforeVodRemove,"on-exceed":e.handleUploadExceed,"file-list":e.fileList,action:e.BASE_API+"/eduVod/videoVod/uploadVideo",limit:1}},[i("el-button",{attrs:{size:"small",type:"primary"}},[e._v("上传视频")]),e._v(" "),i("el-tooltip",{attrs:{placement:"right-end"}},[i("div",{attrs:{slot:"content"},slot:"content"},[e._v("\n              最大支持1G，"),i("br"),e._v("\n              支持3GP、ASF、AVI、DAT、DV、FLV、F4V、"),i("br"),e._v("\n              GIF、M2T、M4V、MJ2、MJPEG、MKV、MOV、MP4、"),i("br"),e._v("\n              MPE、MPG、MPEG、MTS、OGG、QT、RM、RMVB、"),i("br"),e._v("\n              SWF、TS、VOB、WMV、WEBM 等视频格式上传\n            ")]),e._v(" "),i("i",{staticClass:"el-icon-question"})])],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.dialogVideoFormVisible=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{disabled:e.saveVideoBtnDisabled,type:"primary"},on:{click:e.saveOrUpdateVideo}},[e._v("确 定")])],1)],1),e._v(" "),i("el-form",[i("ul",{staticClass:"chanpterList"},e._l(e.chapterVideoList,function(t){return i("li",{key:t.id},[i("p",[e._v("\n          "+e._s(t.title)+"\n          "),i("span",{staticClass:"acts"},[i("el-button",{attrs:{type:"text"},on:{click:function(i){e.openAddVideo(t.id)}}},[e._v("添加小节")]),e._v(" "),i("el-button",{attrs:{type:"text"},on:{click:function(i){e.openEditChapter(t.id)}}},[e._v("编辑")]),e._v(" "),i("el-button",{attrs:{type:"text"},on:{click:function(i){e.removeChapterConfirm(t.id)}}},[e._v("删除")])],1)]),e._v(" "),i("ul",{staticClass:"chanpterList videoList"},e._l(t.children,function(t){return i("li",{key:t.id},[i("p",[e._v("\n              "+e._s(t.title)+"\n              "),i("span",{staticClass:"acts"},[i("el-button",{attrs:{type:"text"},on:{click:function(i){e.openEditVideo(t.id)}}},[e._v("编辑")]),e._v(" "),i("el-button",{attrs:{type:"text"},on:{click:function(i){e.removeVideoConfirm(t.id)}}},[e._v("删除")])],1)])])}))])})),e._v(" "),i("div",{staticStyle:{"text-align":"center"}},["edit"!==e.flag?i("el-button",{on:{click:e.previous}},[e._v("上一步")]):e._e(),e._v(" "),"edit"!==e.flag?i("el-button",{attrs:{disabled:e.saveBtnDisabled,type:"primary"},on:{click:e.next}},[e._v("下一步")]):i("el-button",{attrs:{disabled:e.saveBtnDisabled,type:"primary"},on:{click:e.next}},[e._v("提交修改")])],1)])],1)},[],!1,null,"004ad9a1",null);f.options.__file="chapter.vue";t.default=f.exports}}]);