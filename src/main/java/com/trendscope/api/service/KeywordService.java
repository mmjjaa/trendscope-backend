package com.trendscope.api.service;

import com.trendscope.api.entity.Keyword;
import com.trendscope.api.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;
    private static final String TEMP_USER_ID = "demo-user";

    public List<Keyword> getKeywords() {
        return keywordRepository.findByUserIdOrderByCreatedAtDesc(TEMP_USER_ID);
    }

    public Keyword addKeyword(String keyword, String category) {
        if (keywordRepository.existsByUserIdAndKeyword(TEMP_USER_ID, keyword)) {
            throw new IllegalArgumentException("이미 존재하는 키워드입니다.");
        }
        Keyword kw = new Keyword();
        kw.setKeyword(keyword);
        kw.setCategory(category);
        kw.setUserId(TEMP_USER_ID);
        return keywordRepository.save(kw);
    }

    public void deleteKeyword(String id) {
        keywordRepository.deleteById(id);
    }
}
