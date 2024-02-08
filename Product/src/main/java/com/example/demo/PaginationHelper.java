package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class PaginationHelper {

    public static Pageable createPageable(int page, int size) {
        return PageRequest.of(page, size);
    }

    public static <T> ResponseEntity<Page<T>> createPagedResponse(Page<T> data) {
        return ResponseEntity.ok(data);
    }
}

