<template>
  <div>
    <!-- 路由链接 -->
    <RouterLink to="/home">首页 </RouterLink>             <!-- 字符串跳转 -->
    <RouterLink :to="{path:'/about'}">关于 </RouterLink>  <!-- 对象跳转 -->
    <RouterLink replace :to="{name:'news'}">新闻</RouterLink>     <!-- 具名跳转 -->
    <div class="routerType">
      <RouterView/> <!-- 路由出口 -->
    </div>
    姓名：<input v-model="piniaUser.username.value"/> {{userName}}<br/>
    薪水：<input type="number" v-model="salary"/> {{salary}}<br/>
    <button v-on:click="addSalary">提交</button>
    <button v-on:click="clear">重置</button>
    <button @click="showDetail">详细信息</button>
    <hr/>
    <div class="userInfo" v-show="isShowDetail">
      <h2>个人信息</h2>
      <p>年龄：<input type="number" v-model="userInfo.age" value="0"/></p>
      <p><input type="radio" v-model="userInfo.sex" value="1"/>男<input type="radio" v-model="userInfo.sex"
                                                                        value="2">女</p>
      <p>岗位：<select v-model="userInfo.department">
        <option value="dev">开发</option>
        <option value="test">测试</option>
        <option value="maintain">运维</option>
      </select>
      </p>
      <p>技术：<span v-for="skill in userInfo.skills" :key="skill">{{skill}}</span></p>
      <p>新技术：<input v-model="newSkill"/>
        <button @click="learnNewSkill">学习新技术</button>
      </p>
      <p>个人信息汇总：{{userInfo}}</p>
    </div>
  </div>
  <MyCompositionApi />
</template>

<script>
import MyCompositionApi from './components/MyCompositionApi.vue'
import { inject } from 'vue'

export default {
  data() {
    return {
      userName: '',
      salary: '',
      userInfo: {
        age: 0,
        sex: 1,
        department: 'test',
        skills: ['java', 'redis', 'mysql']
      },
      newSkill: '',
      isShowDetail: false
    }
  },
  setup() {
    const piniaUser = inject('piniaUser') // 在setup中注入对象
    return { piniaUser } // 返回以在模板中使用
  },
  methods: {
    addSalary() {
      this.salary = (Number(this.salary) || 0) + 2000
    },
    clear() {
      this.userName = ''
      this.salary = ''
    },
    learnNewSkill() {
      this.userInfo.skills.push(this.newSkill)
      this.newSkill = ''
    },
    showDetail(){
      this.isShowDetail = !this.isShowDetail

    }
  },
  components: {
    MyCompositionApi
  }
}
</script>

<style scoped>
.userInfo span {
  background-color: gold;
  margin-left: 10px;
}
.routerType {
  background-color: green;
}
</style>

