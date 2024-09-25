package com.yh.windnacelle.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yh.windnacelle.demo.ImagePath;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 人员信息对象 wind_person
 *
 * @author wyy
 * @date 2024-09-13
 */
public class WindPerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 分组id */
    @Excel(name = "分组id")
    private Long groupId;

    /** 封面图片地址 */
    @Excel(name = "封面图片地址")
    private String imgPath;

    /** 图片路径集合 */
    @Excel(name = "图片路径集合")
    private List<ImagePath> imgPathList;

    /** $column.columnComment */
    private Date createdAt;

    /** $column.columnComment */
    private Date updatedAt;

    /** 组别名称 **/
    private String groupName;

    public String getGroup() {
        return groupName;
    }

    public void setGroup(String groupName) {
        this.groupName = groupName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setGroupId(Long groupId)
    {
        this.groupId = groupId;
    }

    public Long getGroupId()
    {
        return groupId;
    }
    public void setImgPath(String imgPath)
    {
        this.imgPath = imgPath;
    }

    public String getImgPath()
    {
        return imgPath;
    }
    public void setImgPathList(List<ImagePath> imgPathList)
    {
        this.imgPathList = imgPathList;
    }

    public List<ImagePath> getImgPathList()
    {
        return imgPathList;
    }
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("sex", getSex())
            .append("groupId", getGroupId())
            .append("imgPath", getImgPath())
            .append("imgPathList", getImgPathList())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }


}
