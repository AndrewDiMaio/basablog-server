package com.unzip.unzip.Services;

import com.unzip.unzip.Models.Tags;
import com.unzip.unzip.Models.BlogPost;
import com.unzip.unzip.Repositories.BlogPostRepository;
import com.unzip.unzip.Repositories.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogPostService {
    @Autowired
    BlogPostRepository blogPostRepository;
    @Autowired
    TagsRepository tagsRepository;

    public void save(BlogPost post){
        post.setHashpostId(post.getTitle() , post.getUserId());
        blogPostRepository.save(post);
        tagsRepository.save(new Tags(post.getTag(),post.getHashpostId()));
    }


}
