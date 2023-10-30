package service;

import exception.NotFoundException;
import model.Post;
import repository.IPostRepository;

import java.util.List;

public class PostService {
    private final IPostRepository repository;

    public PostService(IPostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
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
