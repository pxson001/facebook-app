package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.widget.RecyclableView;

/* compiled from: answered_voice_call */
public class StoryPageWithPhotoView extends StoryPageView implements RecyclableView {
    private final GenericDraweeView f9873a;
    private LinearLayout f9874b;

    public StoryPageWithPhotoView(Context context) {
        this(context, 2130907279);
    }

    private StoryPageWithPhotoView(Context context, int i) {
        super(context, i);
        this.f9874b = (LinearLayout) c(2131562633);
        this.f9873a = (GenericDraweeView) c(2131567724);
        Resources resources = getResources();
        Drawable colorDrawable = new ColorDrawable(resources.getColor(2131362786));
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = colorDrawable;
        this.f9873a.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public void setWidth(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f9874b.getLayoutParams();
        layoutParams.width = i;
        this.f9874b.setLayoutParams(layoutParams);
        this.f9874b.requestLayout();
    }

    public GenericDraweeView getPhoto() {
        return this.f9873a;
    }
}
