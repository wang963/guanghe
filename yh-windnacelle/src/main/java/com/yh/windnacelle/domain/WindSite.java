package com.yh.windnacelle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yh.common.annotation.Excel;
import com.yh.common.core.domain.BaseEntity;

/**
 * 电站信息对象 wind_site
 *
 * @author zzs
 * @date 2024-07-02
 */
public class WindSite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer siteId;

    /** 名称 */
    @Excel(name = "名称")
    private String siteName;

    /** 风机数量 */
    @Excel(name = "风机数量")
    private String fnumber;

    /** 装机容量 */
    @Excel(name = "装机容量")
    private String capacity;

    /** 经度 */
    @Excel(name = "经度")
    private String latitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String longitude;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telephone;

    /** 地址信息 */
    @Excel(name = "地址信息")
    private String address;

    /** 电站图片 */
    @Excel(name = "电站图片")
    private String simage;

    /** 介绍 */
    @Excel(name = "介绍")
    private String introduce;

    public void setSiteId(Integer siteId)
    {
        this.siteId = siteId;
    }

    public Integer getSiteId()
    {
        return siteId;
    }
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public String getSiteName()
    {
        return siteName;
    }
    public void setFnumber(String fnumber)
    {
        this.fnumber = fnumber;
    }

    public String getFnumber()
    {
        return fnumber;
    }
    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getCapacity()
    {
        return capacity;
    }
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return longitude;
    }
    public void setContacts(String contacts)
    {
        this.contacts = contacts;
    }

    public String getContacts()
    {
        return contacts;
    }
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getTelephone()
    {
        return telephone;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setSimage(String simage)
    {
        this.simage = simage;
    }

    public String getSimage()
    {
        return simage;
    }
    public void setIntroduce(String introduce)
    {
        this.introduce = introduce;
    }

    public String getIntroduce()
    {
        return introduce;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("siteId", getSiteId())
            .append("siteName", getSiteName())
            .append("fnumber", getFnumber())
            .append("capacity", getCapacity())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("contacts", getContacts())
            .append("telephone", getTelephone())
            .append("address", getAddress())
            .append("simage", getSimage())
            .append("introduce", getIntroduce())
            .toString();
    }
}
