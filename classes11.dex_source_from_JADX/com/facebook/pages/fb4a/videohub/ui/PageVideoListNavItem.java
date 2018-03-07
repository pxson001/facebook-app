package com.facebook.pages.fb4a.videohub.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: privacy_review_write_sent */
public class PageVideoListNavItem extends CustomFrameLayout {
    private final FbTextView f3118a;
    private String f3119b;

    public PageVideoListNavItem(Context context, int i) {
        this(context, null, i);
    }

    private PageVideoListNavItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3119b = null;
        setContentView(2130907689);
        this.f3118a = (FbTextView) c(2131568361);
        this.f3119b = getResources().getString(2131235463);
        m4215a();
    }

    public final void m4216a(String str) {
        this.f3119b = str;
        m4215a();
    }

    private void m4215a() {
        this.f3118a.setText(getResources().getString(2131235462, new Object[]{this.f3119b}));
    }
}
