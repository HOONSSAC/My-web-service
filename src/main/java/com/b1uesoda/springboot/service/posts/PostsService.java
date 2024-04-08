package com.b1uesoda.springboot.service.posts;

import com.b1uesoda.springboot.domain.posts.PostsRepository;
import com.b1uesoda.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor // final로 선언된 필드를 인자값으로 하는 생성자를 생성
@Service // 서비스 빈으로 등록
public class PostsService {
    private final PostsRepository postsRepository; // PostsRepository를 주입받음

    // 게시글 저장
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
