package com.company.basics.controls;

public abstract class UIControl {
    private boolean isEnabled;
    private String color;
    public UIControl(String color){
        this.isEnabled = false;
        this.color = color;
    }

    public final void greet(){
        System.out.println("Hello World!");
    }

    public void enable(){
        isEnabled = true;
        System.out.println("Enabled: "+isEnabled+" , Color:"+color);
    }

    public void disable(){
        isEnabled = false;
        System.out.println("Disabled: "+isEnabled+" , Color:"+color);
    }

    public abstract void enableRender();

    public abstract void disableRender();
}
