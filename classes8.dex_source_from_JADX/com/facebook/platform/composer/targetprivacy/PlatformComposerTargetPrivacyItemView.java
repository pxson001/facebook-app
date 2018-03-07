package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;

/* compiled from: resultsFragment */
public final class PlatformComposerTargetPrivacyItemView extends RelativeLayout {
    private static final CallerContext f4381a = CallerContext.a(PlatformComposerTargetPrivacyItemView.class);
    private GlyphView f4382b;
    private View f4383c;
    private FbDraweeView f4384d;
    private FbTextView f4385e;

    public PlatformComposerTargetPrivacyItemView(Context context) {
        this(context, null, 0);
    }

    public PlatformComposerTargetPrivacyItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlatformComposerTargetPrivacyItemView(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable = 0;
        super(context, attributeSet, i);
        View.inflate(context, 2130906320, this);
        this.f4384d = (FbDraweeView) findViewById(2131559450);
        this.f4382b = (GlyphView) findViewById(2131558934);
        this.f4385e = (FbTextView) findViewById(2131558927);
        this.f4383c = findViewById(2131566132);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PlatformComposerTargetPrivacyItemView, i, 0);
            try {
                Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
                drawable = obtainStyledAttributes.getDrawable(1);
                boolean z = obtainStyledAttributes.getBoolean(2, false);
                CharSequence a = ResourceUtils.a(context, obtainStyledAttributes, 3);
                if (drawable2 != null) {
                    this.f4382b.setImageDrawable(drawable2);
                }
                if (drawable != null) {
                    if (VERSION.SDK_INT >= 16) {
                        this.f4382b.setBackground(drawable);
                    } else {
                        this.f4382b.setBackgroundDrawable(drawable);
                    }
                }
                setIsSelected(z);
                this.f4385e.setText(a);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void setProfilePictureUrl(Uri uri) {
        this.f4384d.a(uri, f4381a);
        if (uri == null) {
            this.f4384d.setVisibility(8);
            this.f4382b.setVisibility(0);
            return;
        }
        this.f4384d.setVisibility(0);
        this.f4382b.setVisibility(8);
    }

    public final void setIsSelected(boolean z) {
        this.f4383c.setVisibility(z ? 0 : 4);
    }

    public final String getTitleText() {
        return this.f4385e.getText().toString();
    }
}
