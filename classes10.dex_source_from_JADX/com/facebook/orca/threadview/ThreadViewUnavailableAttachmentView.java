package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: me/locationupdates */
public class ThreadViewUnavailableAttachmentView extends CustomLinearLayout {
    private View f8048a;
    private TextView f8049b;
    private TextView f8050c;
    private int f8051d;

    public ThreadViewUnavailableAttachmentView(Context context) {
        this(context, null);
    }

    public ThreadViewUnavailableAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected ThreadViewUnavailableAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907394);
        this.f8048a = a(2131563207);
        this.f8049b = (TextView) a(2131567853);
        this.f8050c = (TextView) a(2131567854);
        this.f8051d = getPaddingTop();
    }

    public final void m7947a(boolean z) {
        this.f8048a.setVisibility(z ? 0 : 8);
    }

    public final void m7946a() {
        this.f8048a.setBackgroundColor(getResources().getColor(2131362293));
        this.f8050c.setTextColor(getResources().getColor(2131362296));
    }

    public void setTitleTextColor(int i) {
        this.f8049b.setTextColor(i);
    }

    public final void m7948b(boolean z) {
        setPadding(getPaddingLeft(), z ? this.f8051d : 0, getPaddingRight(), getPaddingBottom());
    }
}
