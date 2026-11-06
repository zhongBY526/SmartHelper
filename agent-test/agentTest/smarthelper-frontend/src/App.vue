<script setup>
import { ref, onMounted } from 'vue'
import {sendMsg} from './api/ai'

const message = ref('正在连接后端...')
const loading = ref(false)
</script>
<template>

</template>
<style scoped>
.container {
  text-align: center;
  margin-top: 120px;
  font-family: Arial, sans-serif;
}

.status {
  margin-top: 30px;
}

button {
  padding: 10px 20px;
  border: none;
  border-radius: 6px;
  background: #409eff;
  color: white;
  cursor: pointer;
}
</style>
