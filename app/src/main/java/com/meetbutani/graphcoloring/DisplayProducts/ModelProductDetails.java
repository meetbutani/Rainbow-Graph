package com.meetbutani.graphcoloring.DisplayProducts;

import java.io.Serializable;

public class ModelProductDetails implements Serializable {

    public String Pro_Name, Pro_Price, Pro_Company, Pro_Warranty;
    public int Pro_Id;

    public ModelProductDetails() {
    }

    public ModelProductDetails(String pro_Name, String pro_Price, String pro_Company, String pro_Warranty) {
        Pro_Name = pro_Name;
        Pro_Price = pro_Price;
        Pro_Company = pro_Company;
        Pro_Warranty = pro_Warranty;
    }

    public ModelProductDetails(int pro_Id, String pro_Name, String pro_Price, String pro_Company, String pro_Warranty) {
        Pro_Name = pro_Name;
        Pro_Price = pro_Price;
        Pro_Company = pro_Company;
        Pro_Warranty = pro_Warranty;
        Pro_Id = pro_Id;
    }
}
