package com.facebook.offers.activity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.offers.fetcher.OffersWalletFetcher;
import com.facebook.offers.fragment.OfferRenderingUtils;
import com.facebook.offers.graphql.OfferMutationsModels.OfferClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferMutationsModels.OfferViewClaimToWalletMutationModel;
import com.facebook.offers.graphql.OfferQueriesInterfaces.OfferClaimData;
import com.facebook.offers.logging.OffersEventUtil;
import com.facebook.offers.model.OfferOrCoupon;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: custom_cta_click_confirm_delete_mobile */
public class OfferRedirectToWebActivity extends FbFragmentActivity implements AnalyticsActivity {
    @Inject
    OffersWalletFetcher f16175p;
    @Inject
    @LoggedInUserId
    Provider<String> f16176q;
    @Inject
    AnalyticsLogger f16177r;
    @Inject
    OffersEventUtil f16178s;
    @Inject
    OfferRenderingUtils f16179t;
    private int f16180u;
    private String f16181v;
    private String f16182w;
    private String f16183x;

    private static <T extends Context> void m18987a(Class<T> cls, T t) {
        m18988a((Object) t, (Context) t);
    }

    public static void m18988a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OfferRedirectToWebActivity) obj).m18985a(OffersWalletFetcher.m18991a(injectorLike), IdBasedProvider.a(injectorLike, 4442), AnalyticsLoggerMethodAutoProvider.a(injectorLike), OffersEventUtil.m19445b(injectorLike), OfferRenderingUtils.m19015a(injectorLike));
    }

    public final String am_() {
        return "offers_web_redirect_page";
    }

    public final void m18990b(Bundle bundle) {
        Class cls = OfferRedirectToWebActivity.class;
        m18988a((Object) this, (Context) this);
        super.b(bundle);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f16180u = point.x;
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("offer_id");
        String string2 = extras.getString("offer_view_id");
        String string3 = extras.getString("share_id");
        this.f16181v = extras.getString("notif_trigger");
        this.f16182w = extras.getString("notif_medium");
        this.f16183x = extras.getString("rule");
        m18989a(string, string2, string3, this.f16181v, this.f16182w, this.f16183x);
        this.f16179t.m19019a(this, extras.getString("site_uri"), extras.getString("offer_code"), extras.getString("title"), string, string2, string3);
        finish();
    }

    private void m18985a(OffersWalletFetcher offersWalletFetcher, Provider<String> provider, AnalyticsLogger analyticsLogger, OffersEventUtil offersEventUtil, OfferRenderingUtils offerRenderingUtils) {
        this.f16175p = offersWalletFetcher;
        this.f16176q = provider;
        this.f16177r = analyticsLogger;
        this.f16178s = offersEventUtil;
        this.f16179t = offerRenderingUtils;
    }

    private void m18989a(@Nullable String str, @Nullable String str2, String str3, @Nullable final String str4, @Nullable final String str5, @Nullable final String str6) {
        if (str != null) {
            Futures.a(this.f16175p.m18995a(str, str3, this.f16180u, (String) this.f16176q.get()), new FutureCallback<GraphQLResult<OfferClaimToWalletMutationModel>>(this) {
                final /* synthetic */ OfferRedirectToWebActivity f16170d;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null || ((OfferClaimToWalletMutationModel) graphQLResult.e).m19063a() == null) {
                        BLog.b("OfferRedirectToWebActivity", "Error saving offer");
                    } else {
                        this.f16170d.m18986a(((OfferClaimToWalletMutationModel) graphQLResult.e).m19063a(), str5, str6);
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b("OfferRedirectToWebActivity", "Error saving offer", th);
                }
            });
        } else {
            Futures.a(this.f16175p.m18997b(str2, str3, this.f16180u, (String) this.f16176q.get()), new FutureCallback<GraphQLResult<OfferViewClaimToWalletMutationModel>>(this) {
                final /* synthetic */ OfferRedirectToWebActivity f16174d;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null || ((OfferViewClaimToWalletMutationModel) graphQLResult.e).m19068a() == null) {
                        BLog.b("OfferRedirectToWebActivity", "Error saving offer");
                    } else {
                        this.f16174d.m18986a(((OfferViewClaimToWalletMutationModel) graphQLResult.e).m19068a(), str5, str6);
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b("OfferRedirectToWebActivity", "Error saving offer", th);
                }
            });
        }
    }

    private void m18986a(OfferClaimData offerClaimData, @Nullable String str, String str2) {
        new StringBuilder("Results: ").append(offerClaimData);
        if (this.f16181v != null || str != null || str2 != null) {
            this.f16177r.a(this.f16178s.m19446a(OfferOrCoupon.m19448a(offerClaimData), this.f16181v, this.f16182w, this.f16183x));
        }
    }
}
