package sixth.sixthgroup.model;

import java.util.Date;

public class Student {
    private Integer studId;

    private Integer studGradeid;

    private String studName;

    private String studSex;

    private String studAge;

    private String studTel;

    private Integer studQq;

    private String studAddress;

    private String studIdcard;

    private Integer studNum;

    private Date studBron;

    private Integer studBanknum;

    private String studNation;

    private String studDorimitory;

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public Integer getStudGradeid() {
        return studGradeid;
    }

    public void setStudGradeid(Integer studGradeid) {
        this.studGradeid = studGradeid;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName == null ? null : studName.trim();
    }

    public String getStudSex() {
        return studSex;
    }

    public void setStudSex(String studSex) {
        this.studSex = studSex == null ? null : studSex.trim();
    }

    public String getStudAge() {
        return studAge;
    }

    public void setStudAge(String studAge) {
        this.studAge = studAge == null ? null : studAge.trim();
    }

    public String getStudTel() {
        return studTel;
    }

    public void setStudTel(String studTel) {
        this.studTel = studTel == null ? null : studTel.trim();
    }

    public Integer getStudQq() {
        return studQq;
    }

    public void setStudQq(Integer studQq) {
        this.studQq = studQq;
    }

    public String getStudAddress() {
        return studAddress;
    }

    public void setStudAddress(String studAddress) {
        this.studAddress = studAddress == null ? null : studAddress.trim();
    }

    public String getStudIdcard() {
        return studIdcard;
    }

    public void setStudIdcard(String studIdcard) {
        this.studIdcard = studIdcard == null ? null : studIdcard.trim();
    }

    public Integer getStudNum() {
        return studNum;
    }

    public void setStudNum(Integer studNum) {
        this.studNum = studNum;
    }

    public Date getStudBron() {
        return studBron;
    }

    public void setStudBron(Date studBron) {
        this.studBron = studBron;
    }

    public Integer getStudBanknum() {
        return studBanknum;
    }

    public void setStudBanknum(Integer studBanknum) {
        this.studBanknum = studBanknum;
    }

    public String getStudNation() {
        return studNation;
    }

    public void setStudNation(String studNation) {
        this.studNation = studNation == null ? null : studNation.trim();
    }

    public String getStudDorimitory() {
        return studDorimitory;
    }

    public void setStudDorimitory(String studDorimitory) {
        this.studDorimitory = studDorimitory == null ? null : studDorimitory.trim();
    }
}