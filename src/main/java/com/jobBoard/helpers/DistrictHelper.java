
package com.jobBoard.helpers;

import com.jobBoard.model.District;

import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

import javax.inject.Named;

@Named
@RequestScoped
public class DistrictHelper {
    
    public List<District> getDistricts(){
        
        List<District> districts = new ArrayList<>();
        
        int districtId = 1;
        
        District district = new District(districtId++, "Heliopolis", 41012);
        
        districts.add(district);
        
        district = new District(districtId++, "Triana", 41010);
        
        districts.add(district);
        
        district = new District(districtId++, "Poligono Norte", 41009);
        
        districts.add(district);
        
        return districts;
        
    }
    
    public int getDistrictIdByName(String districtName){
        
        int districtId = 0;
        
        List<District> districts = this.getDistricts();
        
        for(District district: districts){
            
            if(district.getDistrictName().equals(districtName)){
                
                districtId = district.getDistrictId();
                break;
                
            }
            
        }
        
        return districtId;
        
    }
    
    public int getDistrictIdByPostalCode(int postalCode){
        
        int districtId = 0;
        
        List<District> districts = this.getDistricts();
        
        for(District district: districts){
            
            if(district.getPostalCode() == postalCode){
                
                districtId = district.getDistrictId();
                break;
                
            }
            
        }
        
        return districtId;
        
    }
    
    public List<SelectItem> getSelectItems(){
        
        List<SelectItem> selectItems = new ArrayList<>();
        
        List<District> districts = this.getDistricts();
        
        for(District district: districts){
            
            SelectItem selectItem = new SelectItem(district.getDistrictId(),
                                                   district.getDistrictName());
            
            selectItems.add(selectItem);
            
        }
        
        return selectItems;
        
    }
    
}
