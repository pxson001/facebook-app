package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;

/* compiled from: show_reshare_post_button */
public class RowViewPagerIndicator extends CustomLinearLayout {
    public static final ViewType f3727a = new C03141();
    public HScrollCirclePageIndicator f3728b;

    /* compiled from: show_reshare_post_button */
    final class C03141 extends ViewType {
        C03141() {
        }

        public final View m4406a(Context context) {
            return new RowViewPagerIndicator(context, false);
        }
    }

    public RowViewPagerIndicator(Context context, boolean z) {
        super(context);
        setContentView(z ? 2130906095 : 2130906094);
        this.f3728b = (HScrollCirclePageIndicator) a(2131563265);
    }
}
