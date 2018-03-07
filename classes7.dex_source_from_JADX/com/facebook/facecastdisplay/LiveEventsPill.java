package com.facebook.facecastdisplay;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: story_key */
public class LiveEventsPill extends CustomLinearLayout {
    public final FbTextView f2951a;

    public LiveEventsPill(Context context) {
        this(context, null);
    }

    public LiveEventsPill(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveEventsPill(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905074);
        this.f2951a = (FbTextView) findViewById(2131563468);
        setOrientation(0);
        setBackgroundResource(2130841684);
    }

    public void setPillText(String str) {
        this.f2951a.setText(str);
    }
}
