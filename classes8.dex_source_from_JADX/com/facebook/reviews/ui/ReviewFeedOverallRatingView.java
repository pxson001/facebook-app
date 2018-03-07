package com.facebook.reviews.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.binder.StarRatingBarChartBinder;
import com.facebook.reviews.util.ReviewTextUtils;
import com.facebook.reviews.util.helper.ReviewsRatingHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.EntityListener;
import javax.inject.Inject;

/* compiled from: TimeToSurfaceTabFragmentCreate */
public class ReviewFeedOverallRatingView extends CustomLinearLayout {
    private static final String f21756i = ReviewFeedOverallRatingView.class.getSimpleName();
    @Inject
    AbstractFbErrorReporter f21757a;
    @Inject
    FbUriIntentHandler f21758b;
    @Inject
    GraphQLLinkExtractor f21759c;
    @Inject
    NumberTruncationUtil f21760d;
    @Inject
    ReviewsLogger f21761e;
    @Inject
    ReviewsRatingHelper f21762f;
    @Inject
    ReviewTextUtils f21763g;
    @Inject
    StarRatingBarChartBinder f21764h;
    private TextView f21765j;
    private BarChart f21766k;
    private TextWithEntitiesView f21767l;

    private static <T extends View> void m25260a(Class<T> cls, T t) {
        m25261a((Object) t, t.getContext());
    }

    private static void m25261a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReviewFeedOverallRatingView) obj).m25257a((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), NumberTruncationUtil.a(injectorLike), ReviewsLogger.a(injectorLike), ReviewsRatingHelper.m4932a(injectorLike), ReviewTextUtils.m4903a(injectorLike), StarRatingBarChartBinder.m25045a(injectorLike));
    }

    private void m25257a(AbstractFbErrorReporter abstractFbErrorReporter, FbUriIntentHandler fbUriIntentHandler, GraphQLLinkExtractor graphQLLinkExtractor, NumberTruncationUtil numberTruncationUtil, ReviewsLogger reviewsLogger, ReviewsRatingHelper reviewsRatingHelper, ReviewTextUtils reviewTextUtils, StarRatingBarChartBinder starRatingBarChartBinder) {
        this.f21757a = abstractFbErrorReporter;
        this.f21758b = fbUriIntentHandler;
        this.f21759c = graphQLLinkExtractor;
        this.f21760d = numberTruncationUtil;
        this.f21761e = reviewsLogger;
        this.f21762f = reviewsRatingHelper;
        this.f21763g = reviewTextUtils;
        this.f21764h = starRatingBarChartBinder;
    }

    public ReviewFeedOverallRatingView(Context context) {
        super(context);
        m25256a();
    }

    public ReviewFeedOverallRatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25256a();
    }

    private void m25256a() {
        m25260a(ReviewFeedOverallRatingView.class, (View) this);
        setContentView(2130906850);
        this.f21765j = (TextView) a(2131566999);
        this.f21766k = (BarChart) a(2131567000);
        this.f21767l = (TextWithEntitiesView) a(2131567001);
        this.f21766k.setBarAnimationEnabled(true);
    }

    public final void m25263a(SparseIntArray sparseIntArray, int i) {
        this.f21764h.m25047a(this.f21766k, sparseIntArray, i);
    }

    public void setTitle(double d) {
        this.f21765j.setText(new SpannableStringBuilder(this.f21762f.m4934a(d, getResources().getDimensionPixelSize(2131427408))).append(" ").append(getResources().getString(2131235338)));
    }

    public final void m25264a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, final String str, final String str2) {
        this.f21767l.setMovementMethod(LinkMovementMethod.getInstance());
        this.f21767l.a(defaultTextWithEntitiesLongFields, new EntityListener(this) {
            final /* synthetic */ ReviewFeedOverallRatingView f21755c;

            public final void m25255a(Ranges ranges) {
                this.f21755c.m25258a(ranges, str, str2);
            }
        });
    }

    public final void m25262a(double d, int i) {
        String a = this.f21763g.m4905a(d);
        this.f21767l.setText(getResources().getQuantityString(2131689614, i, new Object[]{a, this.f21760d.a(i)}));
    }

    private void m25258a(Ranges ranges, String str, String str2) {
        if (ranges.a() == null) {
            this.f21757a.a(f21756i, "No entity in spotlight string");
            return;
        }
        ReviewsLogger reviewsLogger = this.f21761e;
        String d = ranges.a().d();
        HoneyClientEvent c = ReviewsLogger.c("entity_in_spotlight_section_tap", str, str2);
        c.b("target", d);
        reviewsLogger.a.a(c);
        String a = this.f21759c.a(LinkExtractorConverter.a(ranges.a()));
        if (a == null) {
            this.f21757a.a(f21756i, "Could not find entity url in spotlight string");
        } else {
            this.f21758b.a(getContext(), a);
        }
    }
}
