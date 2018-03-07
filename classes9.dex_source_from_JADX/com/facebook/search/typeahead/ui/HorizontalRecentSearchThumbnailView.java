package com.facebook.search.typeahead.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: userid */
public class HorizontalRecentSearchThumbnailView extends CustomFrameLayout {
    private FbDraweeView f701a;
    private BetterTextView f702b;
    private int f703c;
    private int f704d;

    public HorizontalRecentSearchThumbnailView(Context context) {
        super(context);
        m782a();
    }

    public HorizontalRecentSearchThumbnailView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m782a();
    }

    public HorizontalRecentSearchThumbnailView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m782a();
    }

    private void m782a() {
        setContentView(2130904789);
        this.f701a = (FbDraweeView) findViewById(2131559119);
        this.f702b = (BetterTextView) findViewById(2131558955);
        this.f703c = getResources().getDimensionPixelSize(2131431696);
        this.f704d = getResources().getDimensionPixelSize(2131431697);
    }

    public final void m783a(@Nullable Uri uri, Drawable drawable, CallerContext callerContext) {
        ((GenericDraweeHierarchy) this.f701a.getHierarchy()).a(RoundingParams.e());
        if (uri != null) {
            this.f701a.a(uri, callerContext);
        } else {
            this.f701a.setImageDrawable(drawable);
        }
    }

    public void setBadgeCount(int i) {
        if (i == 0) {
            this.f702b.setVisibility(8);
            return;
        }
        this.f702b.setMinWidth(i >= 10 ? this.f704d : this.f703c);
        this.f702b.setVisibility(0);
        this.f702b.setText(i >= 10 ? "10+" : String.valueOf(i));
    }
}
