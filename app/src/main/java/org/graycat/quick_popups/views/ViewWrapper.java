package org.graycat.quick_popups.views;

import android.view.View;

public abstract class ViewWrapper {

    private String viewName;

    public ViewWrapper(View view, String name){
        this.viewName = name;
        setView(view);
    }

    protected abstract void setView(View view);
    protected abstract View getView();

    public String getViewName() {
        return viewName;
    }
}
