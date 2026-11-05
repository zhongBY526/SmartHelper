<script setup>
import { ref, onMounted } from 'vue'
import { CheckHealth } from './api/ai'

const message = ref('正在连接后端...')
const loading = ref(false)

async function connectBackend() {
  loading.value = true

  try {
    const response = await CheckHealth()
    message.value = '后端连接成功'
  } catch (error) {
    message.value = '连接失败，请检查后端是否启动'
    console.error(error)
  } finally {
    loading.value = false
  }
}
onMounted(() => {
  connectBackend()
})
</script>
<template>
  <div class="container">
    <h1>SmartHelper 智能助手</h1>
    <div class="status">
      <p>{{ message }}</p>
      <button @click="connectBackend" :disabled="loading">
        {{ loading ? '连接中...' : '重新连接后端' }}
      </button>
    </div>
  </div>
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
