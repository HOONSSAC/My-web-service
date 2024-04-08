package com.b1uesoda.springboot.web.dto;

import com.b1uesoda.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // PostsSaveRequestDto에서 필요한 부분만 빌더 패턴을 사용하여 Posts로 변환
    public Posts toEntity() {
        return Posts.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    }
}
