package org.graycat.quick_popups.dialogs;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import org.graycat.quick_popups.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WholeScreenDialog extends ClosableDialog {

    @BindView(R.id.main_text)
    TextView mainText;

    public WholeScreenDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.whole_screen_dialog);
        ButterKnife.bind(this);
        children.put("text", mainText);
        children.put("button", closeButton);
        closeButton.setOnClickListener(v -> this.dismiss());
        if (title != null) {
            View titleBar = getLayoutInflater().inflate(R.layout.title_bar, null);
            titleBar.setId(View.generateViewId());
            addChild(titleBar, "title", "parent", "text");
        }
        Window window = this.getWindow();
        if (window != null) {
            //this.surface = new SurfaceImpl(this.getContext());
            window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //window.takeSurface(this.surface);
        }
    }

    @OnClick(R.id.add_button)
    public void onC() {
        AppCompatButton b = new AppCompatButton(this.getContext());
        b.setText("dfgsdfgd");
        b.setId(View.generateViewId());
        addChild(b, "testButton", "text", "button");
    }
}

class SurfaceImpl extends GLSurfaceView {
    public SurfaceHolder surfaceHolder;

    public SurfaceImpl(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder != null) {
            //super.surfaceCreated(holder);
            surfaceHolder = holder;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (holder != null) {
            super.surfaceChanged(holder, format, width, height);
            Log.d("EXAMPLE", "surfaceChanged " + format + " " + width + " " + height);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (holder != null) {
            super.surfaceDestroyed(holder);
            Log.d("EXAMPLE", "surfaceDestr ");
        }
    }
}
