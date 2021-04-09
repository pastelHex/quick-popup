package org.graycat.quick_popups.dialogs;

import android.content.Context;
import android.os.Bundle;

import org.graycat.quick_popups.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;

public abstract class ClosableDialog extends DialogBase {
    @BindView(R.id.close_button)
    AppCompatButton closeButton;

    public ClosableDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        closeButton.setOnClickListener(v -> this.dismiss());
    }
}
