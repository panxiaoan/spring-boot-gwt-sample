package com.pxa.sample.server.model.vo;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-01-12 16:17
 */
public class UserVO implements VO {

    private static final long serialVersionUID = 4903788506932793481L;

    private Long id;
    private String username;
    private String name;
    private Integer age;
    private String sex;
    private String password;

    public UserVO() {
    }

    public UserVO(Long id, String username, String name, Integer age, String sex) {
        super();
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
