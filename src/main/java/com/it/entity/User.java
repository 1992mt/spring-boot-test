package com.it.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User implements Serializable{
    /**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uname;

    private Date createdate;

    private String udec;

    private String pass;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return udec
     */
    public String getUdec() {
        return udec;
    }

    /**
     * @param udec
     */
    public void setUdec(String udec) {
        this.udec = udec;
    }

    /**
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}