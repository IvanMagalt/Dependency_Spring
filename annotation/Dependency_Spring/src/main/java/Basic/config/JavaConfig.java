package Basic.config;

import Basic.controller.PostController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Basic.repository.IPostRepository;
import Basic.repository.PostRepository;
import Basic.service.PostService;

@Configuration
public class JavaConfig {

    @Bean
    public PostController postController(PostService service){
        return new PostController(service);
    }

    @Bean
    public PostService postService(IPostRepository iRepository){
        return new PostService(iRepository);
    }

    @Bean
    public IPostRepository iPostRepository(){
        return new PostRepository();
    }

}
