package com.javasutra.SuperParts.services;

import com.google.common.collect.Lists;
import com.javasutra.SuperParts.models.Part;
import com.javasutra.SuperParts.models.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;


@Service("partService")
@Repository
@Transactional
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Part> findAll() {
        return Lists.newArrayList(partRepository.findAll());
    }

    @Override
    @Transactional(readOnly=true)
    public Part findById(Long id) {
        return partRepository.findById(id).get();
    }

    @Override
    public Part save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public void delete(Part part) {
        partRepository.delete(part);
    }

    @Override
    public Page<Part> findAllByPage(Pageable pageable) {
        return partRepository.findAll(pageable);
    }

    @Override
    public Part update(Part part, Long id) {

        Part entity = findById(id);
        if (part.getTitle()!= null) entity.setTitle(part.getTitle());
        if (part.getPartscount()!= 0) entity.setPartscount(part.getPartscount());
        if (part.isNeed()!= entity.isNeed()) entity.setNeed(part.isNeed());
        return partRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Part> search(String title,String need, Pageable pageable) {
            return partRepository.findBySearchParams(title,need, pageable);
        }

        @Override
    @Transactional(readOnly = true)
    public Page<Part> search(String title, Pageable pageable) {
        return partRepository.findBySearchParams(title, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public int findAssembledComputer() {
        return partRepository.findAssembledComputer();
    }

    @Override
    public String correctText(int num) {
        if(num%10==1){
            return "";
        }
        if(num%10>1 && num%10<5){
            return "а";
        }
        return "ов";
    }
}
