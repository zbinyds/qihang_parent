(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1bbc"],{c4Et:function(e,t,i){"use strict";i.r(t);var n=i("bS4n"),s=i.n(n),o=i("qlbV"),r={name:"",pid:0,path:"",component:"",type:"1"},a={permissionValue:"",type:"2",name:"",path:"",component:"",pid:0},l={data:function(){return{filterText:"",menuList:[],defaultProps:{children:"children",label:"name"},dialogFormValue:"添加菜单",dialogFormVisible:!1,dialogPermissionVisible:!1,menu:r,permission:a,menuValidateRules:{name:[{required:!0,trigger:"blur",message:"菜单名必须输入"}],path:[{required:!0,trigger:"blur",message:"菜单路径必须输入"}],component:[{required:!0,trigger:"blur",message:"组件名称必须输入"}]},permissionValidateRules:{name:[{required:!0,trigger:"blur",message:"功能名称必须输入"}],permissionValue:[{required:!0,trigger:"blur",message:"功能权限值必须输入"}]}}},watch:{filterText:function(e){this.$refs.menuTree.filter(e)}},created:function(){this.fetchNodeList()},methods:{fetchNodeList:function(){var e=this;o.a.getNestedTreeList().then(function(t){!0===t.success&&(e.menuList=t.data.children,console.log(e.menuList))})},filterNode:function(e,t){return!e||-1!==t.title.toLowerCase().indexOf(e.toLowerCase())},remove:function(e){var t=this;console.log(e),this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){return o.a.removeById(e.id)}).then(function(){t.fetchNodeList(),t.$message({type:"success",message:"删除成功!"})}).catch(function(e){"cancel"===e?t.$message({type:"info",message:"已取消删除"}):t.$message({type:"error",message:"删除失败"})})},appendPermission:function(){var e=this;this.$refs.permission.validate(function(t){t&&(e.permission.id?e.update(e.permission):o.a.saveLevelOne(e.permission).then(function(t){e.dialogPermissionVisible=!1,e.$message({type:"success",message:"添加功能成功"}),e.fetchNodeList(),e.menu=s()({},r),e.permission=s()({},a)}))})},appendLevelOne:function(){var e=this;o.a.saveLevelOne(this.menu).then(function(t){e.dialogFormVisible=!1,e.$message({type:"success",message:"添加一级菜单成功"}),e.fetchNodeList(),e.menu=s()({},r),e.permission=s()({},a)}).catch(function(t){e.dialogFormVisible=!1,e.$message({type:"error",message:"添加一级菜单失败"}),e.menu=s()({},r),e.permission=s()({},a)})},append:function(){var e=this;this.$refs.menu.validate(function(t){t&&(e.menu.id?e.update(e.menu):0==e.menu.pid?e.appendLevelOne():e.appendLevelTwo())})},update:function(e){var t=this;o.a.update(e).then(function(e){t.dialogFormVisible=!1,t.$message({type:"success",message:"修改成功"}),t.fetchNodeList(),t.restData()})},appendLevelTwo:function(){var e=this;o.a.saveLevelOne(this.menu).then(function(t){e.dialogFormVisible=!1,e.$message({type:"success",message:"添加二级分类成功"}),e.fetchNodeList(),e.menu=s()({},r),e.permission=s()({},a)}).catch(function(t){e.dialogFormVisible=!1,e.$message({type:"error",message:"添加二级分类失败"}),e.menu=s()({},r),e.permission=s()({},a)})},getById:function(e){this.dialogFormVisible=!0,this.menu=e},updateFunction:function(e){this.dialogPermissionVisible=!0,this.permission=e},restData:function(){this.dialogPermissionVisible=!1,this.dialogFormVisible=!1,this.menu=s()({},r),this.permission=s()({},a)}}},m=i("ZrdR"),u=Object(m.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},[i("el-input",{staticStyle:{"margin-bottom":"30px"},attrs:{placeholder:"Filter keyword"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),e._v(" "),i("el-table",{staticStyle:{width:"100%","margin-bottom":"20px"},attrs:{data:e.menuList,"row-key":"id",border:"","default-expand-all":"","tree-props":{children:"children",hasChildren:"hasChildren"}}},[i("el-table-column",{attrs:{prop:"name",label:"名称",sortable:"",width:"180"}}),e._v(" "),i("el-table-column",{attrs:{prop:"path",label:"访问路径",sortable:"",width:"180"}}),e._v(" "),i("el-table-column",{attrs:{prop:"component",label:"组件路径",sortable:"",width:"180"}}),e._v(" "),i("el-table-column",{attrs:{prop:"permissionValue",label:"权限值"}}),e._v(" "),i("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[1!=t.row.level&&2!=t.row.level||!e.hasPerm("permission.add")?e._e():i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(){e.dialogFormVisible=!0,e.menu.pid=t.row.id}}},[e._v("添加菜单\n        ")]),e._v(" "),3==t.row.level&&e.hasPerm("permission.add")?i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(){e.dialogPermissionVisible=!0,e.permission.pid=t.row.id}}},[e._v("添加功能\n        ")]):e._e(),e._v(" "),4==t.row.level&&e.hasPerm("permission.update")?i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(){return e.updateFunction(t.row)}}},[e._v("修改功能\n        ")]):e._e(),e._v(" "),4!=t.row.level&&e.hasPerm("permission.update")?i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(){return e.getById(t.row)}}},[e._v("修改\n        ")]):e._e(),e._v(" "),e.hasPerm("permission.remove")?i("el-button",{attrs:{type:"text",size:"mini"},on:{click:function(){return e.remove(t.row)}}},[e._v("删除\n        ")]):e._e()]}}])})],1),e._v(" "),i("el-dialog",{attrs:{visible:e.dialogFormVisible,title:e.dialogFormValue},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[i("el-form",{ref:"menu",attrs:{model:e.menu,rules:e.menuValidateRules,"label-width":"120px"}},[i("el-form-item",{attrs:{label:"菜单名称",prop:"name"}},[i("el-input",{model:{value:e.menu.name,callback:function(t){e.$set(e.menu,"name",t)},expression:"menu.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"访问路径",prop:"path"}},[i("el-input",{model:{value:e.menu.path,callback:function(t){e.$set(e.menu,"path",t)},expression:"menu.path"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"组件路径",prop:"component"}},[i("el-input",{model:{value:e.menu.component,callback:function(t){e.$set(e.menu,"component",t)},expression:"menu.component"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.restData()}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:function(t){e.append()}}},[e._v("确 定")])],1)],1),e._v(" "),i("el-dialog",{attrs:{visible:e.dialogPermissionVisible,title:"添加功能"},on:{"update:visible":function(t){e.dialogPermissionVisible=t}}},[i("el-form",{ref:"permission",attrs:{model:e.permission,rules:e.permissionValidateRules,"label-width":"120px"}},[i("el-form-item",{attrs:{label:"功能名称",prop:"name"}},[i("el-input",{model:{value:e.permission.name,callback:function(t){e.$set(e.permission,"name",t)},expression:"permission.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"访问路径"}},[i("el-input",{model:{value:e.permission.path,callback:function(t){e.$set(e.permission,"path",t)},expression:"permission.path"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"组件路径"}},[i("el-input",{model:{value:e.permission.component,callback:function(t){e.$set(e.permission,"component",t)},expression:"permission.component"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"功能权限值",prop:"permissionValue"}},[i("el-input",{model:{value:e.permission.permissionValue,callback:function(t){e.$set(e.permission,"permissionValue",t)},expression:"permission.permissionValue"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.restData()}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:function(t){e.appendPermission()}}},[e._v("确 定")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="list.vue";t.default=u.exports},qlbV:function(e,t,i){"use strict";var n=i("t3Un"),s="/admin/rabc/permission";t.a={getNestedTreeList:function(){return Object(n.a)({url:""+s,method:"get"})},removeById:function(e){return Object(n.a)({url:s+"/"+e,method:"delete"})},saveLevelOne:function(e){return Object(n.a)({url:""+s,method:"post",data:e})},update:function(e){return Object(n.a)({url:""+s,method:"put",data:e})},toAssign:function(e){return Object(n.a)({url:s+"/toAssign/"+e,method:"get"})},doAssign:function(e,t){return Object(n.a)({url:s+"/doAssign",method:"post",params:{roleId:e,permissionId:t}})}}}}]);