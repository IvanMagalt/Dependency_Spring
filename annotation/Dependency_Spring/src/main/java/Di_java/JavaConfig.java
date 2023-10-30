package config;

import controller.PostController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.IPostRepository;
import repository.PostRepository;
import service.PostService;

@Configuration
public class JavaConfig {

    @Bean
    public PostController postController(PostService service){
        return new PostController(service);
    }

    @Bean
    public PostService postService(IPostRepository irepository){
        return new PostService(irepository);
    }

    @Bean
    public IPostRepository iPostRepository(){
        return new PostRepository();
    }

}
