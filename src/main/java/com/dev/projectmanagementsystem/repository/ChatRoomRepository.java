package com.dev.projectmanagementsystem.repository;


import com.dev.projectmanagementsystem.models.ChatRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(Long senderId, Long recipientId);
}

