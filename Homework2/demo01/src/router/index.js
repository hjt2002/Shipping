import { createRouter, createWebHashHistory } from 'vue-router'
const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        name: 'login',
        meta: {
            title: '登录'
        },
        component: () => import('../view/Login.vue')
    },
    {
        path: '/home',
        name: '主页',
        meta: {
            title: '主页'
        },
        component: () => import('../view/Home.vue'),
        redirect: '/index',

        children: [
            {
                path: '/index',
                meta: {
                    title: '首页'
                },
                component: () => import('../view/Shipper.vue')
            },
            {
                path: '/order',
                meta:{
                    title: '订单',
                },
                component: () => import('../view/Order.vue')
            },
            {
                path: '/trackinfo',
                meta:{
                    title: '订单货运信息'
                },
                component: () => import('../view/TrackInfo.vue')
            }
            // {
            //     path: '/user/list',
            //     meta: {
            //         title: '用户管理'
            //     },
            //     component: () => import('../view/user/Index.vue'),
            // },
            // {
            //     path: '/user/detail',
            //     meta: {
            //         title: '用户详情'
            //     },
            //     component: () => import('../view/user/Detail.vue'),
            // },
        ]
    },
]
const router = createRouter({
    history: createWebHashHistory(),
    routes
})

// 挂载路由导航守卫：to表示将要访问的路径，from表示从哪里来，next是下一个要做的操作
router.beforeEach((to, from, next) => {
    // 修改页面 title
    if (to.meta.title) {
      document.title = 'Shipping Manage System - ' + to.meta.title
    }
    // 放行登录页面
    if (to.path === '/login') {
      return next()
    }
    // 获取token
    // const token= sessionStorage.getItem('token')
    // if (!token) {
    //   return next('/login')
    // } else {
    //   next()
    // }
    return next()
  })
  
// 导出路由
export default router