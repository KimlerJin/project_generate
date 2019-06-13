package com.domain.project.module.generate.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.domain.project.module.generate.entity.GenerateModule;
import com.domain.project.module.generate.pojo.GenerateModuleQO;
import com.domain.project.mybatis.entity.SuperEntity;
import com.domain.project.module.generate.mapper.GenerateModuleMapper;
import com.domain.project.module.generate.pojo.GenerateModuleDTO;
import com.domain.project.module.generate.pojo.GenerateModuleVO;
import com.domain.project.module.generate.service.GenerateModuleService;
import com.domain.project.mybatis.service.SuperService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Henry
 * @since 2018-06-11
 */
@Service
public class GenerateModuleServiceImpl extends SuperService<GenerateModuleMapper, GenerateModule> implements GenerateModuleService {


    @Autowired
    private MapperFacade mapper;

    @Override
    public GenerateModuleVO getVOById(Long id) {
        GenerateModule obj = selectById(id);
        return convertToVO(obj);
    }

    @Override
    public List<GenerateModuleVO> getVOList(GenerateModuleQO qo) {
//        return selectList(new EntityWrapper<>()).stream().map(this::convertToVO).collect(Collectors.toList());
        return baseMapper.getVOList(qo);
    }

    @Override
    public Page<GenerateModuleVO> getVOPage(GenerateModuleQO qo) {
//        Page<GenerateModule> pages = selectPage(page);
//        Page<GenerateModuleVO> nPages = new Page<>(pages.getCurrent(), pages.getSize());
//        nPages.setTotal(pages.getTotal());
//        nPages.setRecords(pages.getRecords().stream().map(this::convertToVO).collect(Collectors.toList()));
//        return nPages;
        Page<GenerateModuleVO> pages = qo.getPage();
        pages.setRecords(baseMapper.getVOList(pages, qo));
        return pages;
    }


    @Override
    public GenerateModule create(GenerateModuleDTO dto) {
        GenerateModule obj = mapper.map(dto, GenerateModule.class);
        obj.setCreateDate(new Date());
        obj.setUpdateDate(new Date());
        insert(obj);
        return obj;
    }

    @Override
    public GenerateModule update(Long id, GenerateModuleDTO dto) {
        GenerateModule obj = selectById(id);
        mapper.map(dto, obj);
        obj.setDeleteFlag(SuperEntity.DEL_FLAG_NORMAL);
        obj.setUpdateDate(new Date());
        updateById(obj);
        return obj;
    }

    private GenerateModuleVO convertToVO(GenerateModule obj) {
        GenerateModuleVO vo = mapper.map(obj, GenerateModuleVO.class);
        return vo;
    }

}
