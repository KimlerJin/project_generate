package com.domain.project.common.pojo;

import com.baomidou.mybatisplus.plugins.Page;
import com.domain.project.common.util.MapUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * 基础查询对象
 * <p>
 * <p>适用于所有查询接口</p>
 *
 * @author Deng Hua on 2018/1/9.
 * @version 1.0
 */
public class SuperQO implements Serializable {

    private Integer current = 1;
    private Integer size = 10;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Map<String, Object> toMap() {
        try {
            return MapUtils.objectToMap(this);
        } catch (Exception e) {
            return null;
        }
    }

    public Page getPage() {
        return new Page(current, size);
    }

    public Map<String, Object> getCondition() {
        try {
            return MapUtils.objectToMap(this, "current", "size");
        } catch (Exception e) {
            return null;
        }

    }
}
