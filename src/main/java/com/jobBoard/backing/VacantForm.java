
package com.jobBoard.backing;

import com.jobBoard.helpers.DistrictHelper;
import com.jobBoard.model.Candidate;

import javax.enterprise.context.RequestScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.component.*;
import javax.faces.event.*;

import javax.inject.*;

@Named
@RequestScoped
public class VacantForm {
    
    @Inject
    private Candidate candidate;
    
    @Inject
    private DistrictHelper districtHelper;
    
    private boolean commentarySent;
    
    public VacantForm(){
        
    }
    
    public String send(){
        
        if(this.candidate.getName().equals("Juan")){
            
            if(this.candidate.getSurname().equals("Perez")){
                
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                
                FacesContext facesContext = FacesContext.getCurrentInstance();
                
                String componentId = null;
                
                facesContext.addMessage(componentId, facesMessage);
                
                return "index";
                
            }
            
            return "success";
            
        }else{
            
            return "failed";
            
        }
        
    }
    
    public void postalCodeListener(ValueChangeEvent valueChangeEvent){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        
        int newPostalCode = ((Long) valueChangeEvent.getNewValue()).intValue();
        
        UIInput districtIdInputText = (UIInput) uiViewRoot.findComponent("vacantForm:districtId");
        int districtId = this.districtHelper.getDistrictIdByPostalCode(newPostalCode);
        districtIdInputText.setValue(districtId);
        districtIdInputText.setSubmittedValue(districtId);

        UIInput cityInputText = (UIInput) uiViewRoot.findComponent("vacantForm:city");
        String newCity = "Sevilla";
        cityInputText.setValue(newCity);
        cityInputText.setSubmittedValue(newCity);

        facesContext.renderResponse();

    }

    public Candidate getCandidate() {
        
        return candidate;
        
    }
    
    
    public void setCandidate(Candidate candidate){
        
        this.candidate = candidate;
        
    }
    
    public void hideCommentary(ActionEvent actionEvent){
        
        this.commentarySent = !this.commentarySent;
        
    }

    public boolean isCommentarySent() {
        return commentarySent;
    }

    public void setCommentarySent(boolean commentarySent) {
        this.commentarySent = commentarySent;
    }

    public DistrictHelper getDistrictHelper() {
        return districtHelper;
    }

    public void setDistrictHelper(DistrictHelper districtHelper) {
        this.districtHelper = districtHelper;
    }
    
}