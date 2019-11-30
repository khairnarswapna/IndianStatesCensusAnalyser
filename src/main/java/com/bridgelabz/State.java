package com.bridgelabz;

public class State {
    private String srNo;
    private String stateName;
    private String stateCode;
    private String TIN;

    public String getSrNo() {
        return srNo;
    }

    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
                ", stateName='" + stateName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", TIN='" + TIN + '\'' +
                '}';
    }
}
