package org.graycat.quick_popups.views;

import android.view.View;

import java.util.HashMap;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class ViewGroupWrapper extends ViewWrapper {

    protected HashMap<String, ViewWrapper> children = new HashMap<>();

    ViewGroupWrapper(ConstraintLayout viewGroup, String name) {
        super(viewGroup, name);
    }

    @Override
    protected void setView(View view) {
        children.put("parent", this);
    }

    @Override
    protected View getView() {
        return getRoot();
    }

    public ConstraintLayout getRoot() {
        return (ConstraintLayout) children.get("parent").getView();
    }

    protected void addChildTo(ViewWrapper child, String firstView, LayoutParams param) {
        ConstraintSet constraintSet = new ConstraintSet();
        int childId = child.getView().getId();
        child.getView().setVisibility(View.VISIBLE);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        child.getView().setLayoutParams(layoutParams);
        getRoot().addView(child.getView(), 0);

        constraintSet.clone(getRoot());
        if (param == LayoutParams.VERTICAL) {
            if (!"parent".equals(firstView)) {
                constraintSet.connect(childId, ConstraintSet.TOP, children.get(firstView).getView().getId(), ConstraintSet.BOTTOM, 0);
                constraintSet.connect(children.get(firstView).getView().getId(), ConstraintSet.BOTTOM, childId, ConstraintSet.TOP, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.TOP, children.get(firstView).getView().getId(), ConstraintSet.TOP, 0);
            }
        }
        if (param == LayoutParams.HORIZONTAL) {
            if (!"parent".equals(firstView)) {
                constraintSet.connect(childId, ConstraintSet.START, children.get(firstView).getView().getId(), ConstraintSet.END, 0);
                constraintSet.connect(children.get(firstView).getView().getId(), ConstraintSet.END, childId, ConstraintSet.START, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.START, children.get(firstView).getView().getId(), ConstraintSet.START, 0);
            }
        }
        constraintSet.applyTo(getRoot());
        children.put(child.getViewName(), child);
    }

    protected void addChildBetween(ViewWrapper child, String firstView, String secondView, LayoutParams param) {
        ConstraintSet constraintSet = new ConstraintSet();
        int childId = child.getView().getId();
        child.getView().setVisibility(View.VISIBLE);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        child.getView().setLayoutParams(layoutParams);
        getRoot().addView(child.getView(), 0);

        constraintSet.clone(getRoot());
        if (param == LayoutParams.VERTICAL) {
            if (!"parent".equals(firstView)) {
                constraintSet.connect(childId, ConstraintSet.TOP, children.get(firstView).getView().getId(), ConstraintSet.BOTTOM, 0);
                constraintSet.connect(children.get(firstView).getView().getId(), ConstraintSet.BOTTOM, childId, ConstraintSet.TOP, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.TOP, children.get(firstView).getView().getId(), ConstraintSet.TOP, 0);
            }
            if (!"parent".equals(secondView)) {
                constraintSet.connect(childId, ConstraintSet.BOTTOM, children.get(secondView).getView().getId(), ConstraintSet.TOP, 0);
                constraintSet.connect(children.get(secondView).getView().getId(), ConstraintSet.TOP, childId, ConstraintSet.BOTTOM, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.BOTTOM, children.get(secondView).getView().getId(), ConstraintSet.BOTTOM, 0);
            }
        }
        if (param == LayoutParams.HORIZONTAL) {
            if (!"parent".equals(firstView)) {
                constraintSet.connect(childId, ConstraintSet.START, children.get(firstView).getView().getId(), ConstraintSet.END, 0);
                constraintSet.connect(children.get(firstView).getView().getId(), ConstraintSet.END, childId, ConstraintSet.START, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.START, children.get(firstView).getView().getId(), ConstraintSet.START, 0);
            }
            if (!"parent".equals(secondView)) {
                constraintSet.connect(childId, ConstraintSet.END, children.get(secondView).getView().getId(), ConstraintSet.START, 0);
                constraintSet.connect(children.get(secondView).getView().getId(), ConstraintSet.START, childId, ConstraintSet.END, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.END, children.get(secondView).getView().getId(), ConstraintSet.START, 0);
            }
        }
        constraintSet.applyTo(getRoot());
        children.put(child.getViewName(), child);
    }

    public void invalidateView() {
        getRoot().invalidate();
    }

}
