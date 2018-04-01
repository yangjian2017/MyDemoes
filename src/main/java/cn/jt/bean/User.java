package cn.jt.bean;

import org.nutz.dao.entity.annotation.*;

import java.util.Date;

/**
 * @author yangjian
 */

@Table("user")
@TableIndexes({@Index(fields = "username"), @Index(fields = "phone"), @Index(fields = "email")})
public class User {
    @Name
    @ColDefine(width = 32)
    @Prev(els = @EL("uuid()"))
    String uuid;

    @Column
    @ColDefine(width = 8)
    @Comment("姓名")
    String name;

    @Column
    @ColDefine(width = 20, notNull = true)
    @Comment("用户名，可以用户登录，用户名不可为空且必须唯一")
    String username;

    @Column
    @ColDefine(width = 32)
    @Comment("密码，MD5加密后的密码")
    String password;

    @Column
    @ColDefine(width = 16)
    @Comment("昵称")
    String nickname;

    @Column
    @ColDefine(width = 3)
    @Comment("年龄")
    int age;

    @Column
    @ColDefine(width = 2)
    @Comment("性别：男/女/人妖/保密/未知...")
    String sex;

    @Column
    @ColDefine(width = 11)
    @Comment("手机号，不可重复")
    String phone;

    @Column
    @ColDefine(width = 30)
    @Comment("邮箱，不可重复")
    String email;

    @Column
    @ColDefine(type = ColType.DATE)
    @Comment("出生日期")
    Date birthday;

    @Column
    @ColDefine(type = ColType.VARCHAR, width = 120)
    @Comment("爱好")
    String hobby;

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User() {
        // nothing to do ,it just be for to use User(name,sex,age)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
