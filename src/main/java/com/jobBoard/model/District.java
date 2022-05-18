
package com.jobBoard.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class District {
    
    private int districtId;
    
    private String districtName;
    
    private int postalCode;

    public District(int districtId, String districtName, int postalCode) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.postalCode = postalCode;
    }
    
    public District(){
        
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    
    
}
