package com.example.example.service;

import com.example.example.entry.Gril;
import com.example.example.enums.ResultEnum;
import com.example.example.exception.GrilException;
import com.example.example.reproperitory.GrilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class GrilService {
    @Autowired
    GrilRepository grilRepository;

    @Transactional
    public void insertTwo(){
        Gril grilA=new Gril();
        grilA.setCupSize("A");
        grilA.setAge(8);
        grilRepository.save(grilA);

        Gril grilB=new Gril();
        grilB.setCupSize("A");
        grilB.setAge(8);
        grilRepository.save(grilB);
    }
    public void getAge(Integer id)throws Exception{
        Gril gril=grilRepository.getOne(id);

        if(gril.getAge()<10){
            throw new GrilException(ResultEnum.PRIMARY_SCHOOL);
        }else if(gril.getAge()<30){
            throw new GrilException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

}
