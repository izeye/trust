package com.ctb.trust.support.message.repository;

import com.ctb.trust.support.message.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 16. 6. 4..
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
