package org.graycat.quick_popups;

import android.os.Bundle;

import org.graycat.quick_popups.dialogs.SimpleDialog;
import org.graycat.quick_popups.dialogs.WholeScreenDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.simple_dialog_button)
    AppCompatButton smallDialogButton;

    @BindView(R.id.big_dialog_button)
    AppCompatButton bigDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
       /* Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.test_dialog);
        dialog.setCancelable(false);

        Window window = dialog.getWindow();
        if (window != null) {
            //window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
        AppCompatButton btn = dialog.findViewById(R.id.close_button);
        btn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();*/
    }

    @OnClick(R.id.simple_dialog_button)
    public void onMainButtonClick() {
        new SimpleDialog(this).show();
    }

    @OnClick(R.id.big_dialog_button)
    public void onBigDialogButtonClick() {
        new WholeScreenDialog(this).show();
    }
}
