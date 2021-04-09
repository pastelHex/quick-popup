package org.graycat.quick_popups.dialogs;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import org.graycat.quick_popups.R;

import androidx.annotation.NonNull;
import butterknife.ButterKnife;

public class SimpleDialog extends ClosableDialog {

    public SimpleDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.test_dialog);
        ButterKnife.bind(this);
        closeButton.setOnClickListener(v -> this.dismiss());
        Window window = this.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
    }


}
