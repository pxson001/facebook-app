package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.ratingbar.FractionalRatingBar;
import com.facebook.widget.text.BetterTextView;

/* compiled from: search_time_to_interaction */
public class PageInfoRatingsAndReviewsComponentView extends SegmentedLinearLayout {
    private static final CallerContext f2158a = CallerContext.a(PageInfoRatingsAndReviewsComponentView.class, "pages_public_view");
    public final FbDraweeView f2159b = ((FbDraweeView) a(2131565558));
    private final int f2160c;
    private final int f2161d;
    public final FbRelativeLayout f2162e = ((FbRelativeLayout) a(2131565554));
    private final FractionalRatingBar f2163f = ((FractionalRatingBar) a(2131565555));
    private final BetterTextView f2164g = ((BetterTextView) a(2131565556));
    private final BetterTextView f2165h = ((BetterTextView) a(2131565557));

    public PageInfoRatingsAndReviewsComponentView(Context context) {
        super(context);
        Resources resources = getResources();
        this.f2160c = resources.getDimensionPixelSize(2131429798);
        this.f2161d = resources.getDimensionPixelSize(2131429797);
        setContentView(2130906044);
        setSegmentedDivider(new ColorDrawable(resources.getColor(2131361958)));
        setSegmentedDividerThickness(resources.getDimensionPixelSize(2131427379));
        setSegmentedDividerPadding(this.f2160c);
        setShowSegmentedDividers(2);
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setPadding(this.f2161d, this.f2160c, this.f2161d, this.f2160c);
    }

    public final void m3168a(String str, double d, String str2, OnClickListener onClickListener, String str3, OnClickListener onClickListener2) {
        if (str3 == null || onClickListener2 == null) {
            this.f2159b.setVisibility(8);
        } else {
            this.f2159b.setOnClickListener(onClickListener2);
            this.f2159b.a(Uri.parse(str3), f2158a);
            this.f2159b.setVisibility(0);
        }
        this.f2162e.setOnClickListener(onClickListener);
        this.f2163f.setRating((float) d);
        this.f2164g.setText(str);
        this.f2165h.setText(str2);
    }
}
