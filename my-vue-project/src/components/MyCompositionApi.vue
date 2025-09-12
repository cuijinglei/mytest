<template>
    <div class="">
        变量1：<input v-model="const1"/>{{const1}}
    </div>
</template>
<script>
export default {
    name: 'MyCompositionApi'
}
</script>
<script setup>
import {getConst1} from '@/components/MyJs'
let {const1} = getConst1()
</script>

<style scoped>
    . {
        /* Your styles here */
    }
</style>