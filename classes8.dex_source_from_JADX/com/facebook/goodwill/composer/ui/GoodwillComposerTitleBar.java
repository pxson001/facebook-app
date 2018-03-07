package com.facebook.goodwill.composer.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;

/* compiled from: yyyyMMdd'T'HHmmss */
public class GoodwillComposerTitleBar extends FbRelativeLayout {
    private View f140a;
    private FbTextView f141b;
    private View f142c;

    public GoodwillComposerTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130904608, this, true);
        this.f140a = inflate.findViewById(2131559455);
        this.f142c = inflate.findViewById(2131559325);
        this.f141b = (FbTextView) inflate.findViewById(2131558927);
        setClickable(true);
    }

    public void setTitle(int i) {
        this.f141b.setText(i);
    }

    public final void m158a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.f140a.setOnClickListener(onClickListener);
        this.f142c.setOnClickListener(onClickListener2);
    }
}
