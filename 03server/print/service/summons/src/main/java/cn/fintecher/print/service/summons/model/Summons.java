package cn.fintecher.print.service.summons.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author : sunyanping
 * @Description : 法院传票model
 * @Date : 2017/4/27.
 */
@ApiModel(value = "法院传票模板")
public class Summons {
    @ApiModelProperty("法院名称")
    private String courtName;
    @ApiModelProperty("案件括号内容")
    private String casenumName;
    @ApiModelProperty("案件字")
    private String casenumWord;
    @ApiModelProperty("案件号")
    private String casenumCount;
    @ApiModelProperty("案由")
    private String caseReason;
    @ApiModelProperty("被传唤人")
    private String calledPerson;
    @ApiModelProperty("工作单位或地址")
    private String calledAddress;
    @ApiModelProperty("传唤事由")
    private String calledThing;
    @ApiModelProperty("应到时间-年")
    private String arrivalsYear;
    @ApiModelProperty("应到时间-月")
    private String arrivalsMonth;
    @ApiModelProperty("应到时间-日")
    private String arrivalsDay;
    @ApiModelProperty("应到时间-时")
    private String arrivalsHour;
    @ApiModelProperty("应到时间-分")
    private String arrivalsMinute;
    @ApiModelProperty("应到住所")
    private String destination;
    @ApiModelProperty("审判员")
    private String judge;
    @ApiModelProperty("书记员")
    private String clerk;
    @ApiModelProperty("传单发出时间-年")
    private String callYear;
    @ApiModelProperty("传单发出时间-月")
    private String callMonth;
    @ApiModelProperty("传单发出时间-日")
    private String callDay;

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getCasenumName() {
        return casenumName;
    }

    public void setCasenumName(String casenumName) {
        this.casenumName = casenumName;
    }

    public String getCasenumWord() {
        return casenumWord;
    }

    public void setCasenumWord(String casenumWord) {
        this.casenumWord = casenumWord;
    }

    public String getCasenumCount() {
        return casenumCount;
    }

    public void setCasenumCount(String casenumCount) {
        this.casenumCount = casenumCount;
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason;
    }

    public String getCalledPerson() {
        return calledPerson;
    }

    public void setCalledPerson(String calledPerson) {
        this.calledPerson = calledPerson;
    }

    public String getCalledAddress() {
        return calledAddress;
    }

    public void setCalledAddress(String calledAddress) {
        this.calledAddress = calledAddress;
    }

    public String getCalledThing() {
        return calledThing;
    }

    public void setCalledThing(String calledThing) {
        this.calledThing = calledThing;
    }

    public String getArrivalsYear() {
        return arrivalsYear;
    }

    public void setArrivalsYear(String arrivalsYear) {
        this.arrivalsYear = arrivalsYear;
    }

    public String getArrivalsMonth() {
        return arrivalsMonth;
    }

    public void setArrivalsMonth(String arrivalsMonth) {
        this.arrivalsMonth = arrivalsMonth;
    }

    public String getArrivalsDay() {
        return arrivalsDay;
    }

    public void setArrivalsDay(String arrivalsDay) {
        this.arrivalsDay = arrivalsDay;
    }

    public String getArrivalsHour() {
        return arrivalsHour;
    }

    public void setArrivalsHour(String arrivalsHour) {
        this.arrivalsHour = arrivalsHour;
    }

    public String getArrivalsMinute() {
        return arrivalsMinute;
    }

    public void setArrivalsMinute(String arrivalsMinute) {
        this.arrivalsMinute = arrivalsMinute;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getClerk() {
        return clerk;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public String getCallYear() {
        return callYear;
    }

    public void setCallYear(String callYear) {
        this.callYear = callYear;
    }

    public String getCallMonth() {
        return callMonth;
    }

    public void setCallMonth(String callMonth) {
        this.callMonth = callMonth;
    }

    public String getCallDay() {
        return callDay;
    }

    public void setCallDay(String callDay) {
        this.callDay = callDay;
    }
}
