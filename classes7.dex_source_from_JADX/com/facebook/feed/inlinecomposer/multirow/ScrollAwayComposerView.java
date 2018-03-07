package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;

/* compiled from: android.settings.SETTINGS */
public class ScrollAwayComposerView extends ContentViewWithButton {
    private static final CallerContext f19253h = CallerContext.a(ScrollAwayComposerView.class);
    private ImageView f19254i;
    private FbDraweeView f19255j;

    public ScrollAwayComposerView(Context context) {
        this(context, null);
    }

    public ScrollAwayComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollAwayComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904331);
        this.f19254i = (ImageView) getView(2131561938);
        this.f19255j = (FbDraweeView) getView(2131561926);
        setBackgroundDrawable(ContextCompat.a(getContext(), 2130840258));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131430514);
        setThumbnailPadding(dimensionPixelSize);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        d(getResources().getDimensionPixelSize(2131428826), getResources().getDimensionPixelSize(2131428826));
        setTitleTextAppearance(2131625566);
        setGravity(16);
    }

    public void setProfilePhotoUri(Uri uri) {
        this.f19255j.a(uri, f19253h);
    }

    public void setIcon(Drawable drawable) {
        this.f19254i.setImageDrawable(drawable);
    }
}
