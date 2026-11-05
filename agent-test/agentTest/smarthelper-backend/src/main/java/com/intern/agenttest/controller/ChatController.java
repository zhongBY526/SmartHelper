package com.intern.agenttest.controller;


import com.intern.agenttest.common.Result;
import com.intern.agenttest.dto.ChatRequest;
import com.intern.agenttest.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send/")
    public Result<String> getAiResponse(@RequestBody  ChatRequest chatRequest) {
        return Result.success(chatService.getResponse(chatRequest));
    }
}
