(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2930"],{"1riY":function(e,t,i){"use strict";i.r(t);var s=i("xash"),n=i("Pl4H"),o=i("w7v5"),r=i("Asgo"),c=i.n(r),a=i("EPZ6"),u=i.n(a),l={name:"EditorSlideUpload",props:{color:{type:String,default:"#1890ff"}},data:function(){return{dialogVisible:!1,listObj:{},fileList:[]}},methods:{checkAllSuccess:function(){var e=this;return u()(this.listObj).every(function(t){return e.listObj[t].hasSuccess})},handleSubmit:function(){var e=this,t=u()(this.listObj).map(function(t){return e.listObj[t]});this.checkAllSuccess()?(this.$emit("successCBK",t),this.listObj={},this.fileList=[],this.dialogVisible=!1):this.$message("请等待所有图片上传成功 或 出现了网络问题，请刷新页面重新上传！")},handleSuccess:function(e,t){for(var i=t.uid,s=u()(this.listObj),n=0,o=s.length;n<o;n++)if(this.listObj[s[n]].uid===i)return this.listObj[s[n]].url=e.files.file,void(this.listObj[s[n]].hasSuccess=!0)},handleRemove:function(e){for(var t=e.uid,i=u()(this.listObj),s=0,n=i.length;s<n;s++)if(this.listObj[i[s]].uid===t)return void delete this.listObj[i[s]]},beforeUpload:function(e){var t=this,i=window.URL||window.webkitURL,s=e.uid;return this.listObj[s]={},new c.a(function(n,o){var r=new Image;r.src=i.createObjectURL(e),r.onload=function(){t.listObj[s]={hasSuccess:!1,uid:e.uid,width:this.width,height:this.height}},n(!0)})}}},d=(i("wn0B"),i("ZrdR")),h=Object(d.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"upload-container"},[i("el-button",{style:{background:e.color,borderColor:e.color},attrs:{icon:"el-icon-upload",size:"mini",type:"primary"},on:{click:function(t){e.dialogVisible=!0}}},[e._v("上传图片\n  ")]),e._v(" "),i("el-dialog",{attrs:{visible:e.dialogVisible},on:{"update:visible":function(t){e.dialogVisible=t}}},[i("el-upload",{staticClass:"editor-slide-upload",attrs:{multiple:!0,"file-list":e.fileList,"show-file-list":!0,"on-remove":e.handleRemove,"on-success":e.handleSuccess,"before-upload":e.beforeUpload,action:"https://httpbin.org/post","list-type":"picture-card"}},[i("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")])],1),e._v(" "),i("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.handleSubmit}},[e._v("确 定")])],1)],1)},[],!1,null,"39480e6e",null);h.options.__file="editorImage.vue";var f=["advlist anchor autolink autosave code codesample colorpicker colorpicker contextmenu directionality emoticons fullscreen hr image imagetools importcss insertdatetime link lists media nonbreaking noneditable pagebreak paste preview print save searchreplace spellchecker tabfocus table template textcolor textpattern visualblocks visualchars wordcount"],m=["searchreplace bold italic underline strikethrough alignleft aligncenter alignright outdent indent  blockquote undo redo removeformat subscript superscript code codesample","hr bullist numlist link image charmap preview anchor pagebreak insertdatetime media table emoticons forecolor backcolor fullscreen"],p={name:"Tinymce",components:{editorImage:h.exports},props:{id:{type:String,default:function(){return"vue-tinymce-"+ +new Date+(1e3*Math.random()).toFixed(0)}},value:{type:String,default:""},toolbar:{type:Array,required:!1,default:function(){return[]}},menubar:{type:String,default:"file edit insert view format table"},height:{type:Number,required:!1,default:360}},data:function(){return{hasChange:!1,hasInit:!1,tinymceId:this.id,fullscreen:!1,languageTypeList:{en:"en",zh:"zh_CN"}}},computed:{language:function(){return this.languageTypeList[this.$store.getters.language]}},watch:{value:function(e){var t=this;!this.hasChange&&this.hasInit&&this.$nextTick(function(){return window.tinymce.get(t.tinymceId).setContent(e||"")})},language:function(){var e=this;this.destroyTinymce(),this.$nextTick(function(){return e.initTinymce()})}},mounted:function(){this.initTinymce()},activated:function(){this.initTinymce()},deactivated:function(){this.destroyTinymce()},destroyed:function(){this.destroyTinymce()},methods:{initTinymce:function(){var e=this,t=this;window.tinymce.init({language:this.language,selector:"#"+this.tinymceId,height:this.height,body_class:"panel-body ",object_resizing:!1,toolbar:this.toolbar.length>0?this.toolbar:m,menubar:this.menubar,plugins:f,end_container_on_empty_block:!0,powerpaste_word_import:"clean",code_dialog_height:450,code_dialog_width:1e3,advlist_bullet_styles:"square",advlist_number_styles:"default",imagetools_cors_hosts:["www.tinymce.com","codepen.io"],default_link_target:"_blank",link_title:!1,nonbreaking_force_tab:!0,init_instance_callback:function(i){t.value&&i.setContent(t.value),t.hasInit=!0,i.on("NodeChange Change KeyUp SetContent",function(){e.hasChange=!0,e.$emit("input",i.getContent())})},setup:function(e){e.on("FullscreenStateChanged",function(e){t.fullscreen=e.state})}})},destroyTinymce:function(){window.tinymce.get(this.tinymceId)&&window.tinymce.get(this.tinymceId).destroy()},setContent:function(e){window.tinymce.get(this.tinymceId).setContent(e)},getContent:function(){window.tinymce.get(this.tinymceId).getContent()},imageSuccessCBK:function(e){var t=this;e.forEach(function(e){window.tinymce.get(t.tinymceId).insertContent('<img class="wscnph" src="'+e.url+'" >')})}}},b=(i("79La"),Object(d.a)(p,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"tinymce-container editor-container",class:{fullscreen:this.fullscreen}},[t("textarea",{staticClass:"tinymce-textarea",attrs:{id:this.tinymceId}}),this._v(" "),t("div",{staticClass:"editor-custom-btn-container"},[t("editorImage",{staticClass:"editor-upload-btn",attrs:{color:"#1890ff"},on:{successCBK:this.imageSuccessCBK}})],1)])},[],!1,null,"261f5e1f",null));b.options.__file="index.vue";var g={components:{Tinymce:b.exports},data:function(){return{saveBtnDisabled:!1,courseInfo:{title:"",subjectId:"",subjectParentId:"",teacherId:"",lessonNum:0,description:"",cover:"https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/default.gif",price:0},teacherList:[],subjectList:[],subjectTwoList:[],BASE_API:"https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin",courseId:"",flag:""}},created:function(){this.$route.params&&this.$route.params.id?(this.$route.query&&this.$route.query.from&&(this.flag=this.$route.query.from),this.courseId=this.$route.params.id,this.getCourseInfo()):(this.getTeacherList(),this.getAllSucject())},watch:{$route:function(e,t){this.courseInfo={lessonNum:0,cover:"https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/default.gif",price:0}}},methods:{getCourseInfo:function(){var e=this;s.a.getCourseInfo(this.courseId).then(function(t){e.courseInfo=t.data.courseInfo,n.a.getAllSucject().then(function(t){e.subjectList=t.data.list,e.subjectTwoList=e.subjectList.filter(function(t){return t.id===e.courseInfo.subjectParentId})[0].children,e.getTeacherList()})})},handleAvatarSuccess:function(e,t){this.courseInfo.cover=e.data.url},beforeAvatarUpload:function(e){var t="image/jpeg"===e.type,i=e.size/1024/1024<2;return t||this.$message.error("上传头像图片只能是 JPG 格式!"),i||this.$message.error("上传头像图片大小不能超过 2MB!"),t&&i},changeOneSubject:function(e){this.subjectTwoList=this.subjectList.filter(function(t){return t.id===e})[0].children,this.courseInfo.subjectId=""},getAllSucject:function(){var e=this;n.a.getAllSucject().then(function(t){e.subjectList=t.data.list})},getTeacherList:function(){var e=this;o.a.getAllTeacherList().then(function(t){e.teacherList=t.data.items})},saveCourseInfo:function(){var e=this;""!=this.courseInfo.title&&""!=this.courseInfo.description&&""!=this.courseInfo.teacherId&&""!=this.courseInfo.subjectId&&""!=this.courseInfo.subjectParentId?s.a.addCourseInfo(this.courseInfo).then(function(t){t.code&&(e.$message.success(t.message),e.$router.push({path:"/edu/course/chapter/"+t.data.courseId}))}):this.$message({type:"error",message:"课程信息填写不全！"})},updateCourseInfo:function(){var e=this;s.a.updateCourseInfo(this.courseInfo).then(function(t){e.$message.success(t.message),"edit"===e.flag?e.$router.push({path:"/edu/course/list/"}):e.$router.push({path:"/edu/course/chapter/"+e.courseId})})},SaveOrUpdate:function(){""!==this.courseId?this.updateCourseInfo():this.saveCourseInfo()}}},v=(i("STy4"),Object(d.a)(g,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},["edit"!==e.flag?i("h2",{staticStyle:{"text-align":"center"}},[e._v("发布新课程")]):e._e(),e._v(" "),"edit"!==e.flag?i("el-steps",{staticStyle:{"margin-bottom":"40px"},attrs:{active:1,"process-status":"wait","align-center":""}},[i("el-step",{attrs:{title:"编辑课程基本信息"}}),e._v(" "),i("el-step",{attrs:{title:"创建课程大纲"}}),e._v(" "),i("el-step",{attrs:{title:"发布提交"}})],1):e._e(),e._v(" "),i("el-form",{attrs:{"label-width":"120px"}},[i("el-form-item",{attrs:{label:"课程标题"}},[i("el-input",{attrs:{placeholder:" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"},model:{value:e.courseInfo.title,callback:function(t){e.$set(e.courseInfo,"title",t)},expression:"courseInfo.title"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课程类别"}},[i("el-select",{attrs:{placeholder:"一级分类"},on:{change:e.changeOneSubject},model:{value:e.courseInfo.subjectParentId,callback:function(t){e.$set(e.courseInfo,"subjectParentId",t)},expression:"courseInfo.subjectParentId"}},e._l(e.subjectList,function(e){return i("el-option",{key:e.id,attrs:{label:e.title,value:e.id}})})),e._v(" "),i("el-select",{attrs:{placeholder:"二级分类"},model:{value:e.courseInfo.subjectId,callback:function(t){e.$set(e.courseInfo,"subjectId",t)},expression:"courseInfo.subjectId"}},e._l(e.subjectTwoList,function(e){return i("el-option",{key:e.id,attrs:{label:e.title,value:e.id}})}))],1),e._v(" "),i("el-form-item",{attrs:{label:"课程讲师"}},[i("el-select",{attrs:{placeholder:"请选择讲师"},model:{value:e.courseInfo.teacherId,callback:function(t){e.$set(e.courseInfo,"teacherId",t)},expression:"courseInfo.teacherId"}},e._l(e.teacherList,function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.id}})}))],1),e._v(" "),i("el-form-item",{attrs:{label:"总课时"}},[i("el-input-number",{attrs:{min:0,"controls-position":"right",placeholder:"请填写课程的总课时数"},model:{value:e.courseInfo.lessonNum,callback:function(t){e.$set(e.courseInfo,"lessonNum",t)},expression:"courseInfo.lessonNum"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课程简介"}},[i("tinymce",{attrs:{height:300},model:{value:e.courseInfo.description,callback:function(t){e.$set(e.courseInfo,"description",t)},expression:"courseInfo.description"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课程封面"}},[i("el-upload",{staticClass:"avatar-uploader",attrs:{"show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload,action:e.BASE_API+"/eduoss/fileoss"}},[i("img",{attrs:{src:e.courseInfo.cover}})])],1),e._v(" "),i("el-form-item",{attrs:{label:"课程价格"}},[i("el-input-number",{attrs:{min:0,"controls-position":"right",placeholder:"免费课程请设置为0元"},model:{value:e.courseInfo.price,callback:function(t){e.$set(e.courseInfo,"price",t)},expression:"courseInfo.price"}}),e._v("\n      元\n    ")],1),e._v(" "),i("el-form-item",[i("el-button",{attrs:{disabled:e.saveBtnDisabled,type:"primary"},on:{click:e.SaveOrUpdate}},[e._v("保存并下一步")])],1)],1)],1)},[],!1,null,"31760e80",null));v.options.__file="info.vue";t.default=v.exports},"79La":function(e,t,i){"use strict";var s=i("D9dH");i.n(s).a},D9dH:function(e,t,i){},Pl4H:function(e,t,i){"use strict";var s=i("t3Un");t.a={getAllSucject:function(){return Object(s.a)({url:"/eduService/subject/getSubjectList",method:"get"})}}},STy4:function(e,t,i){"use strict";var s=i("tiLM");i.n(s).a},tiLM:function(e,t,i){},veHz:function(e,t,i){},wn0B:function(e,t,i){"use strict";var s=i("veHz");i.n(s).a},xash:function(e,t,i){"use strict";var s=i("t3Un");t.a={addCourseInfo:function(e){return Object(s.a)({url:"/eduService/course",method:"post",data:e})},getCourseInfo:function(e){return Object(s.a)({url:"/eduService/course/"+e,method:"get"})},updateCourseInfo:function(e){return Object(s.a)({url:"/eduService/course",method:"put",data:e})},getPublishCourseInfo:function(e){return Object(s.a)({url:"/eduService/course/getPublishCourseInfo/"+e,method:"get"})},publishCourse:function(e){return Object(s.a)({url:"/eduService/course/publish/"+e,method:"put"})},pageCourseCondition:function(e,t,i,n){return Object(s.a)({url:"/eduService/course/pageCourseCondition/"+e+"/"+t,method:"get",params:{title:i,status:n}})},deleteCourse:function(e){return Object(s.a)({url:"/eduService/course/"+e,method:"delete"})}}}}]);