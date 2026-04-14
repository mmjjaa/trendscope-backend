package com.trendscope.api.repository;

import com.trendscope.api.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, String> {
    List<Keyword> findByUserIdOrderByCreatedAtDesc(String userId);
    boolean existsByUserIdAndKeyword(String userId, String keyword);
}
