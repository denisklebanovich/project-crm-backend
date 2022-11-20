package com.dev.projectmanagementsystem.repository;

import com.dev.projectmanagementsystem.models.ChatMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatId(String chatId);

}
