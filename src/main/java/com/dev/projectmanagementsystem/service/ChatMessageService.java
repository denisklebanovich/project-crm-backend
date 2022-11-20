package com.dev.projectmanagementsystem.service;

import com.dev.projectmanagementsystem.models.ChatMessage;
import com.dev.projectmanagementsystem.models.MessageStatus;
import com.dev.projectmanagementsystem.repository.ChatMessageRepository;
import org.hibernate.Criteria;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository messageRepository;

    @Autowired
    private ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        messageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(Long senderId, Long recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);

        var messages =
                chatId.map(cId -> messageRepository.findByChatId(cId)).orElse(new ArrayList<>());


        return messages;
    }

    public ChatMessage findById(Long id) {
        return messageRepository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
                    return messageRepository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new NullPointerException("can't find message (" + id + ")"));
    }
}
