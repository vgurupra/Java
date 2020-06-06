package com.company.basics.controls;

public class CheckBox extends UIControl {
    public CheckBox(String color){
        super(color);
    }

    @Override
    public void enableRender(){
        super.enable();
        System.out.println("Render enabled in Checkbox");
    }

    @Override
    public void disableRender() {
        super.disable();
        System.out.println("Render disabled in Checkbox");
    }
}
