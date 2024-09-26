package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 人员图片列表对象 wind_person_imgpath
 *
 * @author wyy
 * @date 2024-09-26
 */
public class WindPersonImgpath extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

    /** 用户id */
    private int personId;

    /** $column.columnComment */
    private String faceVector;

    /** $column.columnComment */
    private boolean faceValid;

    /** $column.columnComment */
    private boolean asCover;

    /** $column.columnComment */
    private String imgPath;

    /** $column.columnComment */
    private String url;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
    public void setPersonId(int personId)
    {
        this.personId = personId;
    }

    public int getPersonId()
    {
        return personId;
    }
    public void setFaceVector(String faceVector)
    {
        this.faceVector = faceVector;
    }

    public String getFaceVector()
    {
        return faceVector;
    }
    public void setFaceValid(boolean faceValid)
    {
        this.faceValid = faceValid;
    }

    public boolean getFaceValid()
    {
        return faceValid;
    }
    public void setAsCover(boolean asCover)
    {
        this.asCover = asCover;
    }

    public boolean getAsCover()
    {
        return asCover;
    }
    public void setImgPath(String imgPath)
    {
        this.imgPath = imgPath;
    }

    public String getImgPath()
    {
        return imgPath;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("personId", getPersonId())
            .append("faceVector", getFaceVector())
            .append("faceValid", getFaceValid())
            .append("asCover", getAsCover())
            .append("imgPath", getImgPath())
            .append("url", getUrl())
            .toString();
    }
}
