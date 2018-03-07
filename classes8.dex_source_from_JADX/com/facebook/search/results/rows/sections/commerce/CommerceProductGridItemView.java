package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: REFOLLOW */
public class CommerceProductGridItemView extends CustomFrameLayout {
    private final CommerceGridItemImageView f23914a;
    private final FbDraweeView f23915b;
    private final BetterTextView f23916c;

    public CommerceProductGridItemView(Context context) {
        this(context, null);
    }

    public CommerceProductGridItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommerceProductGridItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906981);
        this.f23914a = (CommerceGridItemImageView) c(2131559119);
        this.f23915b = (FbDraweeView) c(2131567270);
        this.f23916c = (BetterTextView) c(2131560624);
        ((GenericDraweeHierarchy) this.f23914a.getHierarchy()).b(2130840626);
    }

    public final void m27511a(Uri uri, CallerContext callerContext) {
        this.f23914a.a(uri, callerContext);
    }

    public final void m27512b(Uri uri, CallerContext callerContext) {
        this.f23915b.a(uri, callerContext);
    }

    public void setProductPrice(String str) {
        this.f23916c.setText(str);
    }
}
