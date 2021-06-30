package com.alisher.project.repositories;

import com.alisher.project.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Transactional
    Long deleteBySrcIgnoreCaseContains(List<String> obsceneWords);

    Long deleteBySrcIgnoreCaseContains(String obsceneWord);
}
