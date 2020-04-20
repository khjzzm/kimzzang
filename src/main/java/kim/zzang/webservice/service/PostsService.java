package kim.zzang.webservice.service;

import kim.zzang.webservice.domain.posts.Posts;
import kim.zzang.webservice.dto.posts.PostsMainResponseDto;
import kim.zzang.webservice.dto.posts.PostsSaveRequestDto;
import kim.zzang.webservice.dto.posts.PostsUpdateRequestDto;
import kim.zzang.webservice.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long insert(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id){
        postsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new) // .map(posts -> new PostsMainResponseDto(posts))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Posts> findByAuthor(String author) {
        return postsRepository.findByAuthor(author);
    }

    @Transactional(readOnly = true)
    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }

    @Transactional
    public Long update(PostsUpdateRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    public void deleteAllByIdInQuery(List<Long> ids) {
        postsRepository.deleteAllByIdInQuery(ids);
    }

    @Transactional
    public Long findAllPostCnt() {
        return postsRepository.count();
    }
}