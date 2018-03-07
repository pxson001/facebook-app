package com.facebook.messaging.business.nativesignup.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.messaging.business.nativesignup.view.model.NativeSignUpRowViewParams;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/* compiled from: msg_latencies */
public class NativeSignUpRowView extends CustomRelativeLayout {
    private final ImageView f9019a;
    private final BetterTextView f9020b;
    private final BetterTextView f9021c;
    private final BetterTextView f9022d;

    public NativeSignUpRowView(Context context) {
        this(context, null, 0);
    }

    public NativeSignUpRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeSignUpRowView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        setContentView(2130905370);
        this.f9019a = (ImageView) a(2131564052);
        this.f9020b = (BetterTextView) a(2131564053);
        this.f9021c = (BetterTextView) a(2131564054);
        this.f9022d = (BetterTextView) a(2131564055);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NativeSignUpRow, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.f9019a.setImageDrawable(getResources().getDrawable(resourceId));
        obtainStyledAttributes.recycle();
    }

    public final void m9286a() {
        this.f9020b.setTextColor(-65536);
        this.f9019a.setColorFilter(-65536);
    }

    public void setViewParams(NativeSignUpRowViewParams nativeSignUpRowViewParams) {
        this.f9021c.setText(nativeSignUpRowViewParams.f9024b);
        this.f9022d.setText(nativeSignUpRowViewParams.f9025c);
        this.f9020b.setText(nativeSignUpRowViewParams.f9023a);
        if (Strings.isNullOrEmpty(this.f9022d.getText().toString())) {
            m9285c();
        } else {
            m9284b();
        }
    }

    private void m9284b() {
        this.f9020b.setVisibility(8);
        this.f9021c.setVisibility(0);
        this.f9022d.setVisibility(0);
        this.f9019a.setColorFilter(getResources().getColor(2131361848));
        this.f9019a.setAlpha(0.53f);
    }

    private void m9285c() {
        this.f9020b.setVisibility(0);
        this.f9021c.setVisibility(8);
        this.f9022d.setVisibility(8);
        this.f9019a.setColorFilter(getResources().getColor(2131363294));
        this.f9019a.setAlpha(1.0f);
    }
}
