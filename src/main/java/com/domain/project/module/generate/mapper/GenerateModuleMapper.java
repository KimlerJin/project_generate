package com.domain.project.module.generate.mapper;


import com.baomidou.mybatisplus.plugins.Page;
import com.domain.project.module.generate.entity.GenerateModule;
import com.domain.project.module.generate.pojo.GenerateModuleQO;
import com.domain.project.module.generate.pojo.GenerateModuleVO;
import com.domain.project.mybatis.mapper.SuperMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Henry
 * @since 2018-06-12
 */
public interface GenerateModuleMapper extends SuperMapper<GenerateModule> {

    List<GenerateModuleVO> getVOList(GenerateModuleQO qo);

    List<GenerateModuleVO> getVOList(Page page, GenerateModuleQO qo);

}
