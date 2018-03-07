package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: search_results_loaded */
public class PageInfoWriteFirstReviewComponentView extends CustomLinearLayout {
    public static final CallerContext f2166a = CallerContext.a(PageInfoWriteFirstReviewComponentView.class, "pages_public_view");
    public final FbDraweeView f2167b = ((FbDraweeView) a(2131565559));
    public final BetterTextView f2168c = ((BetterTextView) a(2131565560));

    public PageInfoWriteFirstReviewComponentView(Context context) {
        super(context);
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131429798);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131429797);
        setContentView(2130906045);
        setOrientation(0);
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }
}
