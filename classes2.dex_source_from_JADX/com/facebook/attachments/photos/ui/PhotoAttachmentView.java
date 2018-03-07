package com.facebook.attachments.photos.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;

/* compiled from: graphql_cache */
public class PhotoAttachmentView extends GenericDraweeView {
    public PhotoAttachmentView(Context context) {
        this(context, null);
    }

    public PhotoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29751a(context);
    }

    private void m29751a(Context context) {
        Resources resources = context.getResources();
        setContentDescription(getResources().getString(2131233364));
        Drawable colorDrawable = new ColorDrawable(resources.getColor(2131362786));
        Drawable autoRotateDrawable = new AutoRotateDrawable(resources.getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f14198f = colorDrawable;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder2 = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder2.f14200h = resources.getDrawable(2130840253);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder3 = genericDraweeHierarchyBuilder2;
        genericDraweeHierarchyBuilder3.f14204l = autoRotateDrawable;
        setHierarchy(genericDraweeHierarchyBuilder3.m20567e(ScalingUtils$ScaleType.f14221h).m20571u());
    }
}
