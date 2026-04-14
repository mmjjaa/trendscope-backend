package com.trendscope.api.controller;

import com.trendscope.api.entity.Keyword;
import com.trendscope.api.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/keywords")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class KeywordController {

    private final KeywordService keywordService;

    @GetMapping
    public List<Keyword> getKeywords() {
        return keywordService.getKeywords();
    }

    @PostMapping
    public ResponseEntity<Keyword> addKeyword(@RequestBody Map<String, String> body) {
        Keyword created = keywordService.addKeyword(
                body.get("keyword"),
                body.get("category")
        );
        return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKeyword(@PathVariable String id) {
        keywordService.deleteKeyword(id);
        return ResponseEntity.ok(Map.of("ok", true));
    }
}
