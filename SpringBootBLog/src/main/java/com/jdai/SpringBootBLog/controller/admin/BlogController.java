package com.jdai.SpringBootBLog.controller.admin;

import com.jdai.SpringBootBLog.po.Blog;
import com.jdai.SpringBootBLog.po.User;
import com.jdai.SpringBootBLog.service.BlogService;
import com.jdai.SpringBootBLog.service.TagService;
import com.jdai.SpringBootBLog.service.TypeService;
import com.jdai.SpringBootBLog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size=2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blogQuery, Model model){
        model.addAttribute("types", typeService.allTypes());
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));

        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size =2, sort = {"udpateTIme"}, direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blogQuery, Model model){
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return "/admin/blogs :: blogList";

    }

    @GetMapping("/blogs/input")
    public String newBlog(Model model){
        model.addAttribute("types", typeService.allTypes());
        model.addAttribute("tags", typeService.allTags());

        model.addAttribute("blog", new Blog());
        return "admin/blog-input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes,
                       HttpSession session){
        blog.setUser((User)session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.getTags(blog.getTagIds()));
        Blog b = blogService.saveBlog(blog);
        if(b==null){
            attributes.addFlashAttribute("message", "insert failed");
        }else{
            attributes.addFlashAttribute("message", "insert success");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}")
    public String editBlog(@PathVariable Long id, Model model){
        model.addAttribute("types", typeService.allTypes());
        model.addAttribute("tags", typeService.allTags());

        Blog blog = blogService.getBlog(id);
        blog.init(); //convert tagList to tagIds

        model.addAttribute("blog", blog);
        return "admin/blog-input";
    }

    @GetMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlog(id);
        Blog blog = blogService.getBlog(id);
        if( blog== null){
            //UI message
            attributes.addFlashAttribute("message", "删除失败");
        }else{
            attributes.addFlashAttribute("message" , "删除成功");
        }
        return "redirect:/admin/blogs";
    }



}
