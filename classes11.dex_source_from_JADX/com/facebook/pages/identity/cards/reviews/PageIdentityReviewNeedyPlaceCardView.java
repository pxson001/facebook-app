package com.facebook.pages.identity.cards.reviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ratingbar.BetterRatingBar;
import com.facebook.widget.ratingbar.BetterRatingBar.RatingChangedListener;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: poll_loaded */
public class PageIdentityReviewNeedyPlaceCardView extends CustomLinearLayout implements PageCardView {
    @Inject
    public PagesAnalytics f3675a;
    @Inject
    public DefaultPageSurfaceIntentBuilder f3676b;
    @Inject
    public ComposerLauncher f3677c;
    public BetterRatingBar f3678d = ((BetterRatingBar) a(2131565532));
    public View f3679e = a(2131565531);
    public TextView f3680f = ((TextView) a(2131565533));
    public TextView f3681g = ((TextView) a(2131565529));
    public TextWithEntitiesView f3682h = ((TextWithEntitiesView) a(2131565530));
    public GraphQLPrivacyOption f3683i;
    public int f3684j;
    public Long f3685k;
    public String f3686l;

    /* compiled from: poll_loaded */
    public class C05031 implements RatingChangedListener {
        final /* synthetic */ PageIdentityReviewNeedyPlaceCardView f3673a;

        public C05031(PageIdentityReviewNeedyPlaceCardView pageIdentityReviewNeedyPlaceCardView) {
            this.f3673a = pageIdentityReviewNeedyPlaceCardView;
        }

        public final void m4699a(int i, int i2) {
        }

        public final void m4698a(int i) {
            PageIdentityReviewNeedyPlaceCardView.m4700a(this.f3673a, i, null);
        }
    }

    /* compiled from: poll_loaded */
    public class C05042 implements OnClickListener {
        final /* synthetic */ PageIdentityReviewNeedyPlaceCardView f3674a;

        public C05042(PageIdentityReviewNeedyPlaceCardView pageIdentityReviewNeedyPlaceCardView) {
            this.f3674a = pageIdentityReviewNeedyPlaceCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -816043819);
            PageIdentityReviewNeedyPlaceCardView.m4700a(this.f3674a, this.f3674a.f3684j, this.f3674a.f3683i);
            Logger.a(2, EntryType.UI_INPUT_END, -914860995, a);
        }
    }

    public static void m4701a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityReviewNeedyPlaceCardView pageIdentityReviewNeedyPlaceCardView = (PageIdentityReviewNeedyPlaceCardView) obj;
        PagesAnalytics a = PagesAnalytics.a(fbInjector);
        DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder = (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(fbInjector);
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(fbInjector);
        pageIdentityReviewNeedyPlaceCardView.f3675a = a;
        pageIdentityReviewNeedyPlaceCardView.f3676b = defaultPageSurfaceIntentBuilder;
        pageIdentityReviewNeedyPlaceCardView.f3677c = composerLauncher;
    }

    public PageIdentityReviewNeedyPlaceCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityReviewNeedyPlaceCardView.class;
        m4701a(this, getContext());
        setContentView(2130906035);
        setOrientation(1);
        this.f3681g.setMaxLines(Integer.MAX_VALUE);
        this.f3682h.setMaxLines(Integer.MAX_VALUE);
        this.f3678d.a(new C05031(this));
        this.f3680f.setOnClickListener(new C05042(this));
    }

    public static void m4700a(PageIdentityReviewNeedyPlaceCardView pageIdentityReviewNeedyPlaceCardView, @Nullable int i, GraphQLPrivacyOption graphQLPrivacyOption) {
        pageIdentityReviewNeedyPlaceCardView.f3675a.a(TapEvent.EVENT_REVIEW_NEEDY_PLACE_CARD_TAPPED, pageIdentityReviewNeedyPlaceCardView.f3685k.longValue());
        pageIdentityReviewNeedyPlaceCardView.f3677c.a(null, pageIdentityReviewNeedyPlaceCardView.f3676b.a(pageIdentityReviewNeedyPlaceCardView.f3685k.longValue(), pageIdentityReviewNeedyPlaceCardView.f3686l, graphQLPrivacyOption, CurationMechanism.REVIEW_NEEDY_PLACE_CARD, i).a(), 10107, (Activity) pageIdentityReviewNeedyPlaceCardView.getContext());
    }
}
