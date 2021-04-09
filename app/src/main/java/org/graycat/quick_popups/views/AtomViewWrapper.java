package org.graycat.quick_popups.views;

import android.view.View;

public class AtomViewWrapper extends ViewWrapper {
    protected View view;

    public AtomViewWrapper(View view, String name) {
        super(view, name);
    }

    @Override
    protected void setView(View view) {
        this.view = view;
    }

    @Override
    protected View getView() {
        return this.view;
    }
}
