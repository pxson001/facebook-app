package com.facebook.pages.identity.cards.criticreviews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import com.facebook.inject.FbInjector;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: privacy_checkup_manager_empty_item */
public class PageIdentityCriticReviewsCardView extends CustomLinearLayout implements PageCardView {
    @Inject
    public PageIdentityCriticReviewsAdapterProvider f3458a;
    public ViewPager f3459b = ((ViewPager) a(2131565486));

    public static void m4535a(Object obj, Context context) {
        ((PageIdentityCriticReviewsCardView) obj).f3458a = (PageIdentityCriticReviewsAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(PageIdentityCriticReviewsAdapterProvider.class);
    }

    public PageIdentityCriticReviewsCardView(Context context) {
        super(context);
        Class cls = PageIdentityCriticReviewsCardView.class;
        m4535a(this, getContext());
        setContentView(2130906014);
        setOrientation(1);
    }
}
