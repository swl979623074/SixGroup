package sixth.sixthgroup.model;

import java.util.Date;

public class OperationLog {
    private Integer oploId;

    private Integer oploPeopleid;

    private String oploContent;

    private Date oploTime;

    public Integer getOploId() {
        return oploId;
    }

    public void setOploId(Integer oploId) {
        this.oploId = oploId;
    }

    public Integer getOploPeopleid() {
        return oploPeopleid;
    }

    public void setOploPeopleid(Integer oploPeopleid) {
        this.oploPeopleid = oploPeopleid;
    }

    public String getOploContent() {
        return oploContent;
    }

    public void setOploContent(String oploContent) {
        this.oploContent = oploContent == null ? null : oploContent.trim();
    }

    public Date getOploTime() {
        return oploTime;
    }

    public void setOploTime(Date oploTime) {
        this.oploTime = oploTime;
    }
}