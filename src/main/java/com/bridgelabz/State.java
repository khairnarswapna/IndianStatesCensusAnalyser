package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class State {

    @CsvBindByName(column = "SrNo")
    private String srNo;
    @CsvBindByName(column = "StateName")
    private String StateName;
    @CsvBindByName(column = "TIN")
    private String TIN;
    @CsvBindByName(column = "StateCode")
    private String StateCode;

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }
    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        this.StateName = stateName;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        this.StateCode = stateCode;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }
    @Override
    public String toString() {
        return "State{" +
                "srNo='" + srNo + '\'' +
                ", stateName='" + StateName + '\'' +
                ", stateCode='" + StateCode + '\'' +
                ", TIN='" + TIN + '\'' +
                '}';
    }
}
