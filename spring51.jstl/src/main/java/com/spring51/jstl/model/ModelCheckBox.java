package com.spring51.jstl.model;

public class ModelCheckBox {
    
    private String code;
    private String value;
    private Boolean checked;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Boolean getChecked() {
        return checked;
    }
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
    
    public ModelCheckBox() {
        super();
    }
    public ModelCheckBox(String code, String value, Boolean checked) {
        super();
        this.code = code;
        this.value = value;
        this.checked = checked;
    }
   
}
