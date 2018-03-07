package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: RECENT_SEARCHES */
public class CommerceProductItemView extends CustomFrameLayout {
    private FbDraweeView f23937a;
    private ContentView f23938b;
    private BetterTextView f23939c;

    public CommerceProductItemView(Context context) {
        super(context);
        m27524a();
    }

    public CommerceProductItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m27524a();
    }

    protected CommerceProductItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27524a();
    }

    private void m27524a() {
        setContentView(2130906979);
        this.f23937a = (FbDraweeView) findViewById(2131559119);
        this.f23938b = (ContentView) findViewById(2131561061);
        ((GenericDraweeHierarchy) this.f23937a.getHierarchy()).b(2130840626);
        this.f23939c = (BetterTextView) findViewById(2131567269);
    }

    public final void m27525a(@Nullable Uri uri, CallerContext callerContext) {
        this.f23937a.a(uri, callerContext);
    }

    public void setProductName(CharSequence charSequence) {
        this.f23938b.setTitleText(charSequence);
    }

    public void setProductPrice(CharSequence charSequence) {
        this.f23938b.setSubtitleText(charSequence);
    }

    public void setProductSubtitle(CharSequence charSequence) {
        this.f23938b.setMetaText(charSequence);
    }

    public void setNearbyIndicatorEnabled(boolean z) {
        if (z) {
            this.f23939c.setVisibility(0);
        } else {
            this.f23939c.setVisibility(8);
        }
    }
}
