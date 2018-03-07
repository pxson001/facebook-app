package com.facebook.search.results.rows.sections.derp;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.search.results.rows.sections.livefeed.ui.LiveFeedHeaderView;
import javax.annotation.Nullable;

/* compiled from: REACTION_FORWARD_SCROLL */
public class DerpSuperDenseHeaderView extends LiveFeedHeaderView {
    public FbDraweeView f24080h = ((FbDraweeView) getView(2131560958));

    public DerpSuperDenseHeaderView(Context context) {
        super(context, null, 0, 2130903880);
        Resources resources = getResources();
        setThumbnailPadding(resources.getDimensionPixelSize(2131432586));
        setPadding(resources.getDimensionPixelSize(2131432586), resources.getDimensionPixelSize(2131432587), resources.getDimensionPixelSize(2131432586), resources.getDimensionPixelSize(2131432592));
    }

    public final void m27632a(@Nullable Uri uri, CallerContext callerContext) {
        this.f24080h.a(uri, callerContext);
        this.f24080h.setVisibility(0);
    }
}
