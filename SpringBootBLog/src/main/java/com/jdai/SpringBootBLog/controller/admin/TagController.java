package com.jdai.SpringBootBLog.controller.admin;

import com.jdai.SpringBootBLog.po.Tag;
import com.jdai.SpringBootBLog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute("page",  tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/tag-input";
    }

    @GetMapping("/tags/{id}")
    public String editInput(@PathVariable("id") Long id, Model model){
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tag-input";
    }
    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){
        if(tagService.getTagByName(tag.getName()) !=null){
            result.rejectValue("name", "nameError：", "不能添加重复标签");
        }
        if(result.hasErrors()){
            return "admin/tag-input";
        }
        Tag t = tagService.saveTag(tag);
        if( t== null){
            //UI message
            attributes.addFlashAttribute("message", "添加失败");
        }else{
            attributes.addFlashAttribute("message" , "添加成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes){
       tagService.deleteTag(id);

        Tag t = tagService.getTag(id);
        if( t== null){
            //UI message
            attributes.addFlashAttribute("message", "删除失败");
        }else{
            attributes.addFlashAttribute("message" , "删除成功");
        }

        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result, @PathVariable Long id,
                           RedirectAttributes attributes){
        if(tagService.getTagByName(tag.getName()) !=null){
            result.rejectValue("name", "nameError：", "不能添加重复分类");
        }
        if(result.hasErrors()){
            return "admin/tag-input";
        }
        Tag t = tagService.updateTag(id, tag);
        if( t== null){
            //UI message
            attributes.addFlashAttribute("message", "更新失败");
        }else{
            attributes.addFlashAttribute("message" , "更新成功");
        }
        return "redirect:/admin/tags";
    }

}
