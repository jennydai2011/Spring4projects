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

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.getOne(id);

        if(t == null){
            throw  new NotFoundException("Type not found");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<Type> allTypes() {
        return typeRepository.findAll();
    }

    @Override
    public List<Tag> allTags() {
        return tagRepository.findAll();
    }
}
