package com.b1uesoda.springboot.web;

import com.b1uesoda.springboot.service.posts.PostsService;
import com.b1uesoda.springboot.web.dto.PostsResponseDto;
import com.b1uesoda.springboot.web.dto.PostsSaveRequestDto;
import com.b1uesoda.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// 게시글 등록을 위한 PostsApiController 클래스
@RequiredArgsConstructor // final로 선언된 필드를 인자값으로 하는 생성자를 생성
@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class PostsApiController {

    private final PostsService postsService; // PostsService를 주입받음

    @PostMapping("/api/v1/posts") // HTTP Method인 POST의 요청을 받을 수 있는 API를 만들어줌
    // @RequestBody: JSON으로 넘어온 데이터를 객체로 변환
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/{id}") // HTTP Method인 POST의 요청을 받을 수 있는 API를 만들어줌
    // @PathVariable: URL 경로에 변수를 넣어주는 역할
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") // HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어줌
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
