package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import javax.annotation.Nullable;

/* compiled from: android_cliff_confirmation */
public class ReactionStoryBlockUnitComponentView extends ImageBlockLayout {
    private static final CallerContext f19494h = CallerContext.a(ReactionStoryBlockUnitComponentView.class);
    public FbDraweeView f19495i;

    public ReactionStoryBlockUnitComponentView(Context context) {
        super(context);
        setContentView(2130906718);
        Resources resources = getResources();
        setThumbnailDrawable(resources.getDrawable(2130841701));
        setThumbnailGravity(48);
        setThumbnailPadding(resources.getDimensionPixelOffset(2131431413));
        setThumbnailSize(resources.getDimensionPixelSize(2131431430));
        setBackgroundDrawable(new ColorDrawable(resources.getColor(2131361920)));
        setGravity(48);
        setPadding(resources.getDimensionPixelOffset(2131431388), resources.getDimensionPixelOffset(2131431413), resources.getDimensionPixelOffset(2131431388), resources.getDimensionPixelOffset(2131431413));
    }

    public final void m23442a(@Nullable Uri uri, @Nullable Uri uri2) {
        if (uri != null || uri2 != null) {
            int i;
            if (this.f19495i == null) {
                this.f19495i = (FbDraweeView) ((ViewStub) getView(2131566786)).inflate();
            }
            this.f19495i.setVisibility(0);
            if (uri != null) {
                i = 1;
            } else {
                i = 0;
            }
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(i != 0 ? 2131431430 : 2131427456);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(i != 0 ? 2131431430 : 2131427456);
            if (this.f19495i.getLayoutParams() != null) {
                this.f19495i.getLayoutParams().width = dimensionPixelSize;
                this.f19495i.getLayoutParams().height = dimensionPixelSize2;
            } else {
                this.f19495i.setLayoutParams(new LayoutParams(dimensionPixelSize, dimensionPixelSize2));
            }
            FbDraweeView fbDraweeView = this.f19495i;
            if (uri == null) {
                uri = uri2;
            }
            fbDraweeView.a(uri, f19494h);
        } else if (this.f19495i != null) {
            this.f19495i.setVisibility(8);
        }
    }
}
