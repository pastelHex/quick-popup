package org.graycat.quick_popups.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import org.graycat.quick_popups.R;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import butterknife.BindView;

public abstract class DialogBase extends Dialog {

    @BindView(R.id.main_layout)
    ConstraintLayout mainLayout;

    String title = null;
    protected HashMap<String, View> children = new HashMap<>();

    public DialogBase(@NonNull Context context) {
        super(context);
    }

    public DialogBase(@NonNull Context context, String title) {
        super(context);
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        children.put("parent", mainLayout);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void addChild(View child, String childName, String viewAbove, String viewUnder) {
        Window window = this.getWindow();
        if (window != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            int childId = child.getId();
            child.setVisibility(View.VISIBLE);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            child.setLayoutParams(layoutParams);
            mainLayout.addView(child, 0);

            constraintSet.clone(mainLayout);
            if (!"parent".equals(viewAbove)) {
                constraintSet.connect(childId, ConstraintSet.TOP, children.get(viewAbove).getId(), ConstraintSet.BOTTOM, 0);
                constraintSet.connect(children.get(viewAbove).getId(), ConstraintSet.BOTTOM, childId, ConstraintSet.TOP, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.TOP, children.get(viewAbove).getId(), ConstraintSet.TOP, 0);
            }
            if (!"parent".equals(viewUnder)) {
                constraintSet.connect(childId, ConstraintSet.BOTTOM, children.get(viewUnder).getId(), ConstraintSet.TOP, 0);
                constraintSet.connect(children.get(viewUnder).getId(), ConstraintSet.TOP, childId, ConstraintSet.BOTTOM, 0);
            } else {
                constraintSet.connect(childId, ConstraintSet.BOTTOM, children.get(viewUnder).getId(), ConstraintSet.BOTTOM, 0);
            }
            constraintSet.applyTo(mainLayout);
            mainLayout.invalidate();
            children.put(childName, child);
        }
    }
}
