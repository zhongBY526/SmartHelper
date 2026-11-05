package com.intern.agenttest.service;

import com.intern.agenttest.dto.ChatRequest;

public interface ChatService {
    String getResponse(ChatRequest chatRequest);

    String sendQuestion(ChatRequest chatRequest);
}
