package com.intern.agenttest.service.serviceImpl;

import com.intern.agenttest.dto.ChatRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.intern.agenttest.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
    @Value("${smarthelper.assistant.name}")
    private String assistantName;
    @Override
    public String getResponse(ChatRequest chatRequest) {
        return "assistantName:"+assistantName+chatRequest.getMessage();
    }

    @Override
    public String sendQuestion(ChatRequest chatRequest) {
        return "";
    }
}
