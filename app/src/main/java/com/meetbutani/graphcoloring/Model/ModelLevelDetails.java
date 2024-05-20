package com.meetbutani.graphcoloring.Model;

import java.io.Serializable;

public class ModelLevelDetails implements Serializable {

    public String Level_Name, Level_Status;
    public int Level_Id;

    public ModelLevelDetails() {
    }

    public ModelLevelDetails(String Level_Name, String Level_Status) {
        this.Level_Name = Level_Name;
        this.Level_Status = Level_Status;
    }

    public ModelLevelDetails(int Level_Id, String Level_Name, String Level_Status) {
        this.Level_Id = Level_Id;
        this.Level_Name = Level_Name;
        this.Level_Status = Level_Status;
    }
}
