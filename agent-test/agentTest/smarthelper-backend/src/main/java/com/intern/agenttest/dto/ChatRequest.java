package com.intern.agenttest.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class ChatRequest {
    @NotBlank(message = "消息不能为空")
    @Size(min=1, max=100, message = "消息长度在1到100个字符之间")
    private String message;
}
