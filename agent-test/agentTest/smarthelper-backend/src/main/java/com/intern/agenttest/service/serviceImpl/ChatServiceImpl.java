package com.intern.agenttest.service.serviceImpl;

import com.intern.agenttest.dto.ChatRequest;
import org.springframework.stereotype.Service;

import com.intern.agenttest.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public String getResponse(ChatRequest chatRequest) {
        return "usermessage:"+chatRequest.getMessage();
    }

    @Override
    public String sendQuestion(ChatRequest chatRequest) {
        return "";
    }
}
