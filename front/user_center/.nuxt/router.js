import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _56d698c6 = () => interopDefault(import('..\\pages\\article\\index.vue' /* webpackChunkName: "pages/article/index" */))
const _83f14602 = () => interopDefault(import('..\\pages\\consulte\\index.vue' /* webpackChunkName: "pages/consulte/index" */))
const _44746dc6 = () => interopDefault(import('..\\pages\\course\\index.vue' /* webpackChunkName: "pages/course/index" */))
const _1763f6a2 = () => interopDefault(import('..\\pages\\login.vue' /* webpackChunkName: "pages/login" */))
const _7d37bc66 = () => interopDefault(import('..\\pages\\register.vue' /* webpackChunkName: "pages/register" */))
const _43d74e5a = () => interopDefault(import('..\\pages\\teacher\\index.vue' /* webpackChunkName: "pages/teacher/index" */))
const _602ff032 = () => interopDefault(import('..\\pages\\ucenter\\index.vue' /* webpackChunkName: "pages/ucenter/index" */))
const _d1052276 = () => interopDefault(import('..\\pages\\course\\_id.vue' /* webpackChunkName: "pages/course/_id" */))
const _0bb6cc54 = () => interopDefault(import('..\\pages\\order\\_id.vue' /* webpackChunkName: "pages/order/_id" */))
const _5e0e923c = () => interopDefault(import('..\\pages\\pay\\_id.vue' /* webpackChunkName: "pages/pay/_id" */))
const _58e072bf = () => interopDefault(import('..\\pages\\player\\_id.vue' /* webpackChunkName: "pages/player/_id" */))
const _c48dc17c = () => interopDefault(import('..\\pages\\teacher\\_id.vue' /* webpackChunkName: "pages/teacher/_id" */))
const _2aa66198 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/article",
    component: _56d698c6,
    name: "article"
  }, {
    path: "/consulte",
    component: _83f14602,
    name: "consulte"
  }, {
    path: "/course",
    component: _44746dc6,
    name: "course"
  }, {
    path: "/login",
    component: _1763f6a2,
    name: "login"
  }, {
    path: "/register",
    component: _7d37bc66,
    name: "register"
  }, {
    path: "/teacher",
    component: _43d74e5a,
    name: "teacher"
  }, {
    path: "/ucenter",
    component: _602ff032,
    name: "ucenter"
  }, {
    path: "/course/:id",
    component: _d1052276,
    name: "course-id"
  }, {
    path: "/order/:id?",
    component: _0bb6cc54,
    name: "order-id"
  }, {
    path: "/pay/:id?",
    component: _5e0e923c,
    name: "pay-id"
  }, {
    path: "/player/:id?",
    component: _58e072bf,
    name: "player-id"
  }, {
    path: "/teacher/:id",
    component: _c48dc17c,
    name: "teacher-id"
  }, {
    path: "/",
    component: _2aa66198,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
