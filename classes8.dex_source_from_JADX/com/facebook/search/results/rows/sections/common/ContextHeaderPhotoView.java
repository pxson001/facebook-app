package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: REACTION_UNIT_INTERACTION */
public class ContextHeaderPhotoView extends CustomRelativeLayout {
    public final FbDraweeView f23982a;
    private final BetterTextView f23983b;

    public ContextHeaderPhotoView(Context context) {
        this(context, null, 2130903794);
    }

    private ContextHeaderPhotoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setContentView(i);
        this.f23982a = (FbDraweeView) a(2131560273);
        this.f23983b = (BetterTextView) a(2131560274);
    }

    public final void m27557a(Context context, int i) {
        this.f23983b.setTextAppearance(context, i);
    }

    public void setTextPadding(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        this.f23983b.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public final void m27558a(Uri uri, CallerContext callerContext) {
        this.f23982a.a(uri, callerContext);
    }

    public void setCoverPhotoTitle(String str) {
        this.f23983b.setText(str);
    }
}
