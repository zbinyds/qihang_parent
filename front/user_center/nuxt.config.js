module.exports = {
  /*
  ** Headers of the page
  */
  plugins: [
    { src: '~/plugins/nuxt-swiper-plugin.js', ssr: false }
  ],
  css: [
    'swiper/dist/css/swiper.css'
  ],
  head: {
    title: '起航教育 - Java视频|前端视频|Python视频|大数据视频-IT在线视频课程，粉丝力挺，老学员为你推荐',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'keywords', name: 'keywords', content: '起航教育,IT在线视频教程,Java视频,HTML5视频,前端视频,Python视频,大数据视频' },
      { hid: 'description', name: 'description', content: '起航教育是国内领先的IT在线视频学习平台、职业教育平台。截止目前,起航教育线上、线下学习人次数以万计！会同上百个知名开发团队联合制定的Java、HTML5前端、大数据、Python等视频课程，被广大学习者及IT工程师誉为：业界最适合自学、代码量最大、案例最多、实战性最强、技术最前沿的IT系列视频课程！' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ],
    script:[
      {src: "https://g.alicdn.com/de/prismplayer/2.8.1/aliplayer-min.js", type:"text/javascript"}
    ]
  },
  /*
  ** Customize the progress bar color
  */
  loading: { color: '#3B8070' },
  /*
  ** Build configuration
  */
  build: {
    /*
    ** Run ESLint on save
    */
    extend(config, { isDev, isClient }) {
      if (isDev && isClient) {
        config.module.rules.push({
          enforce: 'pre',
          test: /\.(js|vue)$/,
          loader: 'eslint-loader',
          exclude: /(node_modules)/,
          options: {
            fix: true
          }
        })
      }
    }
  }
}

