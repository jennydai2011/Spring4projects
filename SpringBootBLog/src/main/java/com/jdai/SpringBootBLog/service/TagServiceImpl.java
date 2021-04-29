package com.jdai.SpringBootBLog.service;

import com.jdai.SpringBootBLog.dao.TagRepository;
import com.jdai.SpringBootBLog.dao.TypeRepository;
import com.jdai.SpringBootBLog.exception.NotFoundException;
import com.jdai.SpringBootBLog.po.Tag;
import com.jdai.SpringBootBLog.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }
    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }
    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.getOne(id);

        if(t == null){
            throw  new NotFoundException("Type not found");
        }
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }
    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> getTags(String ids) {
        List<Long> longIds = new ArrayList<>();
        if(ids!=null){
            String[] idStrs= ids.split(",");
            for(String item: idStrs){
                longIds.add(Long.valueOf(item));
            }
        }
        return tagRepository.findAllById(longIds);
    }
}
