import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
// 마운트 시점 변경 (라우트 초기 탐색 후)
router.isReady().then(
    () => {
        app.mount('#app')
    }

)

//마운트 시점 변경  : vue 라우터가 초기 작업을 완료한 시점으로 변경한다. 우리가 후에 구현할 라우터 기능이 중복 호출이 되지 않기 위해 셋팅


