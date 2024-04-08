package com.b1uesoda.springboot.service.posts;

import com.b1uesoda.springboot.domain.posts.Posts;
import com.b1uesoda.springboot.domain.posts.PostsRepository;
import com.b1uesoda.springboot.web.dto.PostsResponseDto;
import com.b1uesoda.springboot.web.dto.PostsSaveRequestDto;
import com.b1uesoda.springboot.web.dto.PostsUpdateRequestDto;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
