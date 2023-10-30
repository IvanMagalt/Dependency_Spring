package Basic.repository;

import Basic.model.Post;
import Basic.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository implements IPostRepository {
    private final ConcurrentMap<Long, Post> allPosts;
    private final AtomicLong idCounter = new AtomicLong(0L);

    public PostRepository() {
        allPosts = new ConcurrentHashMap<>();
    }

    public List<Post> all() {
        return new ArrayList<>(allPosts.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(allPosts.get(id));
    }

    public Post save(Post savePost) {
        if (savePost.getId() == 0) {
            long id = idCounter.incrementAndGet();
            savePost.setId(id);
            allPosts.put(id, savePost);
        } else if (savePost.getId() != 0) {
            Long currentId = savePost.getId();
            allPosts.put(currentId, savePost);
        }
        return savePost;
    }

    public void removeById(long id) {
        if (allPosts.containsKey(id)) {
            allPosts.remove(id);
        } else {
            throw new NotFoundException("Wrong id");
        }
    }
}