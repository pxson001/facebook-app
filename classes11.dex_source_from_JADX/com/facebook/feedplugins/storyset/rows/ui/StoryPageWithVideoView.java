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

/* compiled from: answer_index */
public class StoryPageWithVideoView extends StoryPageView implements RecyclableView {
    private final GenericDraweeView f9877a;
    private LinearLayout f9878b;

    public StoryPageWithVideoView(Context context) {
        this(context, 2130907281);
    }

    private StoryPageWithVideoView(Context context, int i) {
        super(context, i);
        this.f9878b = (LinearLayout) c(2131562633);
        this.f9877a = (GenericDraweeView) c(2131567716);
        Resources resources = getResources();
        Drawable colorDrawable = new ColorDrawable(resources.getColor(2131362786));
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = colorDrawable;
        this.f9877a.setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    public void setWidth(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f9878b.getLayoutParams();
        layoutParams.width = i;
        this.f9878b.setLayoutParams(layoutParams);
        this.f9878b.requestLayout();
    }

    public GenericDraweeView getVideo() {
        return this.f9877a;
    }
}
