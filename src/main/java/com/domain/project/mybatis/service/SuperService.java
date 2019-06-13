package com.domain.project.mybatis.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * This is a description here
 *
 * @Author henry_deng
 * @Date 2019/4/18 12:54
 * @Version 1.0
 */
public class SuperService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {
    // 这里可以放一些公共的方法
}
