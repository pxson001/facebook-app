package com.facebook.photos.consumptiongallery;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FragmentManagerHost.Util;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.friendsharing.souvenirs.fragment.SouvenirsFragment.UfiControllerListener;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.consumptiongallery.Feedback.ObjectType;
import com.facebook.ui.flyout.IFlyoutInterface;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: status_update */
public class ConsumptionUfiController {
    public final Context f2091a;
    public final ConsumptionPhotoCache f2092b;
    public final AnalyticsLogger f2093c;
    public final AbstractFbErrorReporter f2094d;
    public final FeedbackPopoverLauncher f2095e;
    public UfiControllerListener f2096f;
    public final Provider<GraphQLSubscriptionHolder> f2097g;
    public final FutureCallback<GraphQLResult<GraphQLFeedback>> f2098h = new C02381(this);
    public final FeedbackMutationHelper f2099i;
    public final RawLikeHelper f2100j;
    public GraphQLSubscriptionHolder f2101k;

    /* compiled from: status_update */
    class C02381 implements FutureCallback<GraphQLResult<GraphQLFeedback>> {
        final /* synthetic */ ConsumptionUfiController f2086a;

        C02381(ConsumptionUfiController consumptionUfiController) {
            this.f2086a = consumptionUfiController;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) ((GraphQLResult) obj).e;
            if (graphQLFeedback != null) {
                Feedback feedback;
                ConsumptionUfiController consumptionUfiController = this.f2086a;
                if (!Strings.isNullOrEmpty(graphQLFeedback.z_())) {
                    consumptionUfiController.f2096f.a(new Feedback(graphQLFeedback));
                }
                ConsumptionPhoto a = consumptionUfiController.f2092b.m2293a(Long.parseLong(graphQLFeedback.j()));
                if (a != null) {
                    a.f2080n = graphQLFeedback.y_();
                    a.f2076j = GraphQLHelper.o(graphQLFeedback).a();
                    a.f2077k = GraphQLHelper.f(graphQLFeedback);
                    feedback = new Feedback(a);
                } else {
                    feedback = null;
                }
                Feedback feedback2 = feedback;
                if (feedback2 != null) {
                    consumptionUfiController.f2096f.a(feedback2);
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: status_update */
    public class C02392 implements MutationCallback<GraphQLFeedback> {
        final /* synthetic */ ConsumptionUfiController f2087a;

        public C02392(ConsumptionUfiController consumptionUfiController) {
            this.f2087a = consumptionUfiController;
        }

        public final void m2295a(Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            if (this.f2087a.f2096f != null) {
                this.f2087a.f2096f.a(new Feedback(graphQLFeedback));
            }
        }

        public final /* bridge */ /* synthetic */ void m2297b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m2298c(Object obj) {
        }

        public final void m2296a(Object obj, ServiceException serviceException) {
            this.f2087a.f2094d.a("SnowflakeUfiController", "Failed to set like ", serviceException);
        }
    }

    /* compiled from: status_update */
    public class C02403 implements MutationCallback<String> {
        final /* synthetic */ Feedback f2088a;
        final /* synthetic */ boolean f2089b;
        final /* synthetic */ ConsumptionUfiController f2090c;

        public C02403(ConsumptionUfiController consumptionUfiController, Feedback feedback, boolean z) {
            this.f2090c = consumptionUfiController;
            this.f2088a = feedback;
            this.f2089b = z;
        }

        public final /* bridge */ /* synthetic */ void m2301b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m2302c(Object obj) {
        }

        public final void m2299a(Object obj) {
            int i;
            this.f2088a.f2111j = this.f2089b;
            Feedback feedback = this.f2088a;
            if (this.f2089b) {
                i = this.f2088a.f2107f + 1;
            } else {
                i = this.f2088a.f2107f - 1;
            }
            feedback.f2107f = i;
            if (this.f2088a.f2103b == ObjectType.PHOTO) {
                ConsumptionPhoto a = this.f2090c.f2092b.m2293a(this.f2088a.f2106e);
                if (a != null) {
                    a.f2080n = this.f2088a.f2111j;
                    a.f2076j = this.f2088a.f2107f;
                }
            }
            if (this.f2090c.f2096f != null) {
                this.f2090c.f2096f.a(this.f2088a);
            }
        }

        public final void m2300a(Object obj, ServiceException serviceException) {
            this.f2090c.f2094d.a("SnowflakeUfiController", "Failed to set like ", serviceException);
        }
    }

    public static ConsumptionUfiController m2303b(InjectorLike injectorLike) {
        return new ConsumptionUfiController((Context) injectorLike.getInstance(Context.class), ConsumptionPhotoCache.m2290a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FeedbackPopoverLauncher.a(injectorLike), IdBasedProvider.a(injectorLike, 2169), FeedbackMutationHelper.b(injectorLike), RawLikeHelper.b(injectorLike));
    }

    @Inject
    public ConsumptionUfiController(Context context, ConsumptionPhotoCache consumptionPhotoCache, AnalyticsLogger analyticsLogger, FbErrorReporter fbErrorReporter, FeedbackPopoverLauncher feedbackPopoverLauncher, Provider<GraphQLSubscriptionHolder> provider, FeedbackMutationHelper feedbackMutationHelper, RawLikeHelper rawLikeHelper) {
        this.f2091a = context;
        this.f2092b = consumptionPhotoCache;
        this.f2093c = analyticsLogger;
        this.f2094d = fbErrorReporter;
        this.f2095e = feedbackPopoverLauncher;
        this.f2097g = provider;
        this.f2099i = feedbackMutationHelper;
        this.f2100j = rawLikeHelper;
    }

    public final boolean m2305b() {
        return m2304e() != null;
    }

    public final boolean m2306c() {
        IFlyoutInterface e = m2304e();
        if (e == null) {
            return false;
        }
        return e.a();
    }

    public final void m2307d() {
        m2304e();
    }

    private IFlyoutInterface m2304e() {
        Fragment a = Util.a(this.f2091a).kO_().a("chromeless:content:fragment:tag");
        if (a != null && a.z() && (a instanceof IFlyoutInterface)) {
            return (IFlyoutInterface) a;
        }
        return null;
    }
}
