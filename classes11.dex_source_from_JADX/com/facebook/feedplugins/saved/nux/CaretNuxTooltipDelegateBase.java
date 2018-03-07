package com.facebook.feedplugins.saved.nux;

import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

/* compiled from: bundle_self_view_sent */
public abstract class CaretNuxTooltipDelegateBase {
    private static final String f9258f = CaretNuxTooltipDelegateBase.class.getSimpleName();
    public final String f9259a;
    protected final ImmutableSet<String> f9260b;
    protected final AbstractFbErrorReporter f9261c;
    protected final SaveAnalyticsLogger f9262d;
    protected final InterstitialManager f9263e;

    public abstract boolean mo253a(FeedUnit feedUnit);

    public CaretNuxTooltipDelegateBase(FbErrorReporter fbErrorReporter, ImmutableSet<String> immutableSet, SaveAnalyticsLogger saveAnalyticsLogger, InterstitialManager interstitialManager, String str) {
        this.f9261c = fbErrorReporter;
        this.f9260b = immutableSet;
        this.f9262d = saveAnalyticsLogger;
        this.f9263e = interstitialManager;
        this.f9259a = str;
    }

    public final void m9896b(FeedUnit feedUnit) {
        this.f9263e.a().a("2862");
        m9894e(feedUnit);
    }

    public final void m9897c(FeedUnit feedUnit) {
        Optional d = m9898d(feedUnit);
        if (m9893a(d)) {
            GraphQLStory graphQLStory = (GraphQLStory) d.get();
            this.f9262d.a("native_newsfeed", graphQLStory.c(), CurationSurface.NATIVE_STORY, CurationMechanism.CARET_NUX, graphQLStory.as().k());
        }
    }

    private void m9894e(FeedUnit feedUnit) {
        Optional d = m9898d(feedUnit);
        if (m9893a(d)) {
            GraphQLStory graphQLStory = (GraphQLStory) d.get();
            this.f9262d.b("native_newsfeed", graphQLStory.c(), CurationSurface.NATIVE_STORY, CurationMechanism.CARET_NUX, graphQLStory.as().k());
        }
    }

    private boolean m9893a(Optional<GraphQLStory> optional) {
        if (optional.isPresent()) {
            GraphQLStory graphQLStory = (GraphQLStory) optional.get();
            if (graphQLStory.as() != null && GraphQLHelper.a(graphQLStory.as())) {
                return true;
            }
            this.f9261c.a(f9258f, "The caret nux tooltip is shown on a feed unit without enough save info.");
            return false;
        }
        this.f9261c.a(f9258f, "The caret nux tooltip is shown on a non-story feed unit.");
        return false;
    }

    protected final Optional<GraphQLStory> m9898d(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return Absent.INSTANCE;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if (this.f9260b.contains(feedUnit.g())) {
            return Optional.of(graphQLStory);
        }
        if (graphQLStory.L() == null || !this.f9260b.contains(graphQLStory.L().g())) {
            return Absent.INSTANCE;
        }
        return Optional.of(graphQLStory);
    }
}
