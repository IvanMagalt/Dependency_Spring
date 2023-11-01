package Basic.service;

import Basic.exception.NotFoundException;
import Basic.model.Post;
import Basic.repository.IPostRepository;
import Basic.repository.PostRepository;

import java.util.Collection;

public class PostService {
    private final PostRepository repository;

    public PostService(IPostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
