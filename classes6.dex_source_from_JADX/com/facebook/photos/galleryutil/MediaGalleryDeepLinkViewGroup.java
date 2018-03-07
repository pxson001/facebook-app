package com.facebook.photos.galleryutil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: higher_quality_transcode */
public class MediaGalleryDeepLinkViewGroup extends CustomLinearLayout {
    private static final CallerContext f13005a = CallerContext.a(MediaGalleryDeepLinkViewGroup.class, "photo_gallery");
    private GenericDraweeHierarchy f13006b;
    private FbDraweeView f13007c;
    private TextView f13008d;

    public MediaGalleryDeepLinkViewGroup(Context context) {
        super(context);
    }

    public MediaGalleryDeepLinkViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaGalleryDeepLinkViewGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void m20353a() {
        setOrientation(0);
        this.f13007c = new FbDraweeView(getContext());
        this.f13007c.setPadding(0, 0, getResources().getDimensionPixelSize(2131430342), 0);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.b = true;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.u = roundingParams;
        this.f13006b = genericDraweeHierarchyBuilder.u();
        this.f13007c.setHierarchy(this.f13006b);
        addView(this.f13007c, new LayoutParams(getResources().getDimensionPixelSize(2131430343), getResources().getDimensionPixelSize(2131430344)));
        this.f13008d = new TextView(getContext());
        this.f13008d.setTextSize((float) SizeUtil.c(getResources(), 2131427402));
        this.f13008d.setTextColor(getResources().getColor(2131361864));
        addView(this.f13008d);
    }

    public void setText(String str) {
        if (this.f13008d == null) {
            m20353a();
        }
        this.f13008d.setText(str);
    }

    public void setText(int i) {
        if (this.f13008d == null) {
            m20353a();
        }
        this.f13008d.setText(i);
    }

    public void setAppIconDrawableFromResource(int i) {
        if (this.f13007c == null) {
            m20353a();
        }
        this.f13007c.setImageDrawable(getResources().getDrawable(i));
    }

    public void setAppIconDrawable(Drawable drawable) {
        if (this.f13007c == null) {
            m20353a();
        }
        this.f13007c.setImageDrawable(drawable);
    }

    public void setAppIconUrl(Uri uri) {
        if (this.f13007c == null) {
            m20353a();
        }
        this.f13007c.a(uri, f13005a);
    }
}
