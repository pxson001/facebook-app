package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.widget.TextView;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: V_MPEGH/ISO/HEVC */
public class GifShareAttachmentView extends CustomLinearLayout {
    public final FbDraweeView f21060a;
    private final TextView f21061b;

    public GifShareAttachmentView(Context context) {
        this(context, 2130904592);
    }

    private GifShareAttachmentView(Context context, int i) {
        super(context);
        setContentView(i);
        setOrientation(1);
        this.f21060a = (FbDraweeView) a(2131562541);
        this.f21061b = (TextView) a(2131563058);
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(context.getResources().getDrawable(2130843434), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        genericDraweeHierarchyBuilder.f = autoRotateDrawable;
        this.f21060a.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public void setAspectRatio(float f) {
        this.f21060a.setAspectRatio(f);
    }

    public void setBottomText(CharSequence charSequence) {
        this.f21061b.setText(charSequence);
    }

    public void setBottomTextVisibility(boolean z) {
        this.f21061b.setVisibility(z ? 0 : 8);
    }
}
