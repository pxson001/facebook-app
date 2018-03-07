package com.facebook.search.typeahead.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: user_set_contact_info */
public class HorizontalRecentSearchView extends CustomFrameLayout {
    private BetterTextView f705a;
    private HorizontalRecentSearchThumbnailView f706b;

    public HorizontalRecentSearchView(Context context) {
        super(context);
        m784a();
    }

    public HorizontalRecentSearchView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m784a();
    }

    protected HorizontalRecentSearchView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m784a();
    }

    private void m784a() {
        setContentView(2130904790);
        this.f706b = (HorizontalRecentSearchThumbnailView) findViewById(2131562910);
        this.f705a = (BetterTextView) findViewById(2131558927);
    }

    public void setTitle(CharSequence charSequence) {
        this.f705a.setText(charSequence);
    }

    public final void m785a(@Nullable Uri uri, Drawable drawable, CallerContext callerContext) {
        this.f706b.m783a(uri, drawable, callerContext);
    }

    public void setBadgeCount(int i) {
        this.f706b.setBadgeCount(i);
    }
}
