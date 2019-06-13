package com.domain.project.module.generate.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.domain.project.module.generate.entity.GenerateModule;
import com.domain.project.module.generate.pojo.GenerateModuleDTO;
import com.domain.project.module.generate.pojo.GenerateModuleQO;
import com.domain.project.module.generate.pojo.GenerateModuleVO;

import java.util.List;

/**
 * <p>
 * VO
 * </p>
 *
 * @author Henry
 * @since 2018-06-11
 */
public interface GenerateModuleService extends IService<GenerateModule> {

    GenerateModuleVO getVOById(Long id);

    List<GenerateModuleVO> getVOList(GenerateModuleQO qo);

    Page<GenerateModuleVO> getVOPage(GenerateModuleQO qo);

    GenerateModule create(GenerateModuleDTO dto);

    GenerateModule update(Long id, GenerateModuleDTO dto);

}
