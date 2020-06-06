package com.company.basics.controls;

public class TextBox extends UIControl {
    public TextBox(String color){
        super(color);
    }

    @Override
    public void enableRender() {
        super.enable();
        System.out.println("Render enabled in TextBox");
    }

    @Override
    public void disableRender() {
        super.disable();
        System.out.println("Render disabled in TextBox");
    }
}
