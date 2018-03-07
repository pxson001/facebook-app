package com.facebook.pages.identity.cards.actionbar;

import android.app.Activity;
import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorUnsubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel.Builder;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: privacy_checkup_state */
public class PagesFollowActionHelper {
    private final DefaultAndroidThreadUtil f3297a;
    private final FriendingClient f3298b;
    private final Toaster f3299c;
    private final AbstractFbErrorReporter f3300d;
    private final PagesAnalytics f3301e;
    public final Context f3302f;

    public static PagesFollowActionHelper m4447b(InjectorLike injectorLike) {
        return new PagesFollowActionHelper(DefaultAndroidThreadUtil.b(injectorLike), FriendingClient.b(injectorLike), Toaster.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PagesAnalytics.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PagesFollowActionHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, FriendingClient friendingClient, Toaster toaster, AbstractFbErrorReporter abstractFbErrorReporter, PagesAnalytics pagesAnalytics, Context context) {
        this.f3297a = defaultAndroidThreadUtil;
        this.f3298b = friendingClient;
        this.f3299c = toaster;
        this.f3300d = abstractFbErrorReporter;
        this.f3301e = pagesAnalytics;
        this.f3302f = context;
    }

    public final SettableFuture<Void> m4449a(PageHeaderData pageHeaderData, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
        ListenableFuture a;
        final SettableFuture<Void> f = SettableFuture.f();
        final GraphQLSubscribeStatus Y = pageHeaderData.e.Y();
        final GraphQLSecondarySubscribeStatus T = pageHeaderData.g().T();
        long e = pageHeaderData.e();
        final boolean equals = GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(graphQLSubscribeStatus);
        Builder a2 = Builder.a(pageHeaderData.g());
        a2.Q = graphQLSubscribeStatus;
        a2 = a2;
        a2.L = graphQLSecondarySubscribeStatus;
        pageHeaderData.a(a2.a());
        if (!GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(graphQLSubscribeStatus)) {
            a = this.f3298b.a(String.valueOf(e), SubscribeLocation.PROFILE, true);
        } else if (GraphQLSubscribeStatus.CAN_SUBSCRIBE.equals(Y)) {
            a = this.f3298b.a(String.valueOf(e), ActorSubscribeInputData.SubscribeLocation.PROFILE, true);
        } else {
            m4446a(this, pageHeaderData, graphQLSecondarySubscribeStatus, T, f);
            return f;
        }
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2 = graphQLSecondarySubscribeStatus;
        final GraphQLSubscribeStatus graphQLSubscribeStatus2 = graphQLSubscribeStatus;
        this.f3297a.a(a, new FutureCallback<Void>(this) {
            final /* synthetic */ PagesFollowActionHelper f3291h;

            public void onSuccess(Object obj) {
                PageAnalyticsEvent pageAnalyticsEvent;
                PagesFollowActionHelper pagesFollowActionHelper = this.f3291h;
                if (equals) {
                    pageAnalyticsEvent = NetworkSuccessEvent.EVENT_PAGE_FOLLOW_SUCCESS;
                } else {
                    pageAnalyticsEvent = NetworkSuccessEvent.EVENT_PAGE_UNFOLLOW_SUCCESS;
                }
                PagesFollowActionHelper.m4445a(pagesFollowActionHelper, pageAnalyticsEvent, pageHeaderData2.a);
                if (equals) {
                    PagesFollowActionHelper.m4446a(this.f3291h, pageHeaderData2, graphQLSecondarySubscribeStatus2, T, f);
                }
                if (!GraphQLSecondarySubscribeStatus.SEE_FIRST.equals(graphQLSecondarySubscribeStatus2)) {
                    FutureDetour.a(f, null, 179658880);
                }
            }

            public void onFailure(Throwable th) {
                if (!(th instanceof CancellationException)) {
                    PageAnalyticsEvent pageAnalyticsEvent;
                    PagesFollowActionHelper pagesFollowActionHelper = this.f3291h;
                    if (equals) {
                        pageAnalyticsEvent = NetworkFailureEvent.EVENT_PAGE_FOLLOW_ERROR;
                    } else {
                        pageAnalyticsEvent = NetworkFailureEvent.EVENT_PAGE_UNFOLLOW_ERROR;
                    }
                    PagesFollowActionHelper.m4445a(pagesFollowActionHelper, pageAnalyticsEvent, pageHeaderData2.a);
                    PageHeaderData pageHeaderData = pageHeaderData2;
                    Builder a = Builder.a(pageHeaderData2.e);
                    a.Q = Y;
                    a = a;
                    a.L = T;
                    pageHeaderData.a(a.a());
                    PagesFollowActionHelper.m4444a(this.f3291h, graphQLSubscribeStatus2, th);
                    f.a(th);
                }
            }
        });
        return f;
    }

    public static void m4446a(PagesFollowActionHelper pagesFollowActionHelper, PageHeaderData pageHeaderData, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2, SettableFuture settableFuture) {
        ListenableFuture a;
        final boolean equals = GraphQLSecondarySubscribeStatus.SEE_FIRST.equals(graphQLSecondarySubscribeStatus);
        if (equals) {
            a = pagesFollowActionHelper.f3298b.a(String.valueOf(pageHeaderData.a), NewStatus.SEE_FIRST, Location.PROFILE, true);
        } else {
            a = pagesFollowActionHelper.f3298b.a(String.valueOf(pageHeaderData.e()), NewStatus.REGULAR_FOLLOW, Location.PROFILE, true);
        }
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        final SettableFuture settableFuture2 = settableFuture;
        final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus3 = graphQLSecondarySubscribeStatus2;
        pagesFollowActionHelper.f3297a.a(a, new FutureCallback<Void>(pagesFollowActionHelper) {
            final /* synthetic */ PagesFollowActionHelper f3296e;

            public void onSuccess(Object obj) {
                PageAnalyticsEvent pageAnalyticsEvent;
                Void voidR = (Void) obj;
                PagesFollowActionHelper pagesFollowActionHelper = this.f3296e;
                if (equals) {
                    pageAnalyticsEvent = NetworkSuccessEvent.EVENT_PAGE_FOLLOW_SEE_FIRST_SUCCESS;
                } else {
                    pageAnalyticsEvent = NetworkSuccessEvent.EVENT_PAGE_FOLLOW_REGULAR_SUCCESS;
                }
                PagesFollowActionHelper.m4445a(pagesFollowActionHelper, pageAnalyticsEvent, pageHeaderData2.a);
                FutureDetour.a(settableFuture2, voidR, 1951803045);
            }

            public void onFailure(Throwable th) {
                PageAnalyticsEvent pageAnalyticsEvent;
                PagesFollowActionHelper pagesFollowActionHelper = this.f3296e;
                if (equals) {
                    pageAnalyticsEvent = NetworkFailureEvent.EVENT_PAGE_FOLLOW_SEE_FIRST_ERROR;
                } else {
                    pageAnalyticsEvent = NetworkFailureEvent.EVENT_PAGE_FOLLOW_REGULAR_ERROR;
                }
                PagesFollowActionHelper.m4445a(pagesFollowActionHelper, pageAnalyticsEvent, pageHeaderData2.a);
                PageHeaderData pageHeaderData = pageHeaderData2;
                Builder a = Builder.a(pageHeaderData2.e);
                a.L = graphQLSecondarySubscribeStatus3;
                pageHeaderData.a(a.a());
                settableFuture2.a(th);
                this.f3296e.m4450a(th, pageHeaderData2);
            }
        });
    }

    @VisibleForTesting
    protected final void m4450a(Throwable th, PageHeaderData pageHeaderData) {
        Object obj;
        if (m4448b(th)) {
            Activity activity = (Activity) ContextUtils.a(this.f3302f, Activity.class);
            if (activity == null || activity.isFinishing()) {
                obj = null;
            } else {
                obj = 1;
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f3302f);
            builder.a(2131234917);
            builder.b(this.f3302f.getString(2131234918, new Object[]{pageHeaderData.e.D()}));
            builder.a(2131230726, null);
            builder.a().show();
            return;
        }
        m4444a(this, GraphQLSubscribeStatus.IS_SUBSCRIBED, th);
    }

    public static boolean m4448b(Throwable th) {
        if (th == null || !(th instanceof GraphQLException)) {
            return false;
        }
        GraphQLException graphQLException = (GraphQLException) th;
        if (graphQLException.error == null || graphQLException.error.a() != 1529005) {
            return false;
        }
        return true;
    }

    public static void m4444a(PagesFollowActionHelper pagesFollowActionHelper, GraphQLSubscribeStatus graphQLSubscribeStatus, Throwable th) {
        int i;
        String str;
        if (GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(graphQLSubscribeStatus)) {
            i = 2131235441;
            str = "page_identity_follow_fail";
        } else {
            i = 2131235442;
            str = "page_identity_unfollow_fail";
        }
        pagesFollowActionHelper.f3299c.b(new ToastBuilder(i));
        pagesFollowActionHelper.f3300d.a(str, th);
    }

    public static void m4445a(PagesFollowActionHelper pagesFollowActionHelper, PageAnalyticsEvent pageAnalyticsEvent, long j) {
        pagesFollowActionHelper.f3301e.a(pageAnalyticsEvent, j);
    }
}
