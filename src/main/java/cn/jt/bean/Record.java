package cn.jt.bean;

import org.nutz.dao.entity.annotation.*;

import java.sql.Timestamp;

/**
 * 一张记录表
 * @author yangjian
 */
@Table("record")
public class Record {

    @Name
    @ColDefine(width = 32,type = ColType.VARCHAR)
    @Prev(els = @EL("uuid()"))
    private String uuid;

    @Column
    @ColDefine(width = 1000,type = ColType.TEXT)
    @Comment("文本")
    private String text;

    @Column
    @ColDefine(width = 1000,type = ColType.TEXT)
    @Comment("图片，存的url，多个用逗号(,)分隔,最多九张")
    private String images;

    @Column
    @ColDefine(type = ColType.DATETIME)
    @Comment("创建时间，存的是时间戳")
    private Timestamp createTime;

    public Record(){}

    public Record(String text, String images){
        this.text = text;
        this.images = images;
    }

    public Record(String text, String images,Timestamp createTime){
        this.text = text;
        this.images = images;
        this.createTime = createTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
