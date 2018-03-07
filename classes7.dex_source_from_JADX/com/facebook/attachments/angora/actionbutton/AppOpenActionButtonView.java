package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

@Deprecated
/* compiled from: video broadcast request failed for  */
public class AppOpenActionButtonView extends CustomLinearLayout {
    private ProgressBar f700a;
    private TextView f701b;

    public AppOpenActionButtonView(Context context) {
        super(context);
        m765a();
    }

    public AppOpenActionButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m765a();
    }

    private void m765a() {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        setClickable(true);
        LayoutInflater.from(getContext()).inflate(2130903265, this);
        this.f700a = (ProgressBar) findViewById(2131559623);
        this.f701b = (TextView) findViewById(2131558966);
    }

    public void setText(CharSequence charSequence) {
        this.f701b.setText(charSequence);
    }

    public void setProgressVisibility(int i) {
        this.f700a.setVisibility(i);
    }
}
