package com.brandi.discoevents;

/**
 * Created by Brandi Werner on 11/25/2017.
 */

public class EventData {

    private int EventID;
    private String OrgName;
    private String EventName;
    private String EventDesc;
    private String EventDate;
    private int Picture;
    private String EventLocation;
    private boolean csTag;
    private boolean ceTag;
    private boolean deptTag;
    private boolean eeTag;

    public boolean isCsTag() {
        return csTag;
    }

    public void setCsTag(boolean csTag) {
        this.csTag = csTag;
    }

    public boolean isCeTag() {
        return ceTag;
    }

    public void setCeTag(boolean ceTag) {
        this.ceTag = ceTag;
    }

    public boolean isDeptTag() {
        return deptTag;
    }

    public void setDeptTag(boolean deptTag) {
        this.deptTag = deptTag;
    }

    public boolean isEeTag() {
        return eeTag;
    }

    public void setEeTag(boolean eeTag) {
        this.eeTag = eeTag;
    }

    public EventData(){
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int eventID) {
        EventID = eventID;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDesc() {
        return EventDesc;
    }

    public void setEventDesc(String eventDesc) {
        EventDesc = eventDesc;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String eventLocation) {
        EventLocation = eventLocation;
    }
}