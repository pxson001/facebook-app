package com.facebook.placetips.upsell;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.GravitySettingsForUserUpdateInputData.NotificationsEnabled;
import com.facebook.inject.Lazy;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentInterfaces.GravitySettingsGraphQlFragment;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: can_choose_multiple_options */
public class PlaceTipsUpsellLocationHistoryUtil {
    public static final CallerContext f18522a = CallerContext.a(PlaceTipsUpsellLocationHistoryUtil.class);
    public final PlaceTipsSettingsHelper f18523b;
    public final AbstractFbErrorReporter f18524c;
    public final PlaceTipsUpsellAnalyticsLogger f18525d;
    public final Lazy<Accessor> f18526e;

    /* compiled from: can_choose_multiple_options */
    public class C20471 implements FutureCallback<OperationResult> {
        final /* synthetic */ PlaceTipsUpsellLocationHistoryUtil f18519a;

        public C20471(PlaceTipsUpsellLocationHistoryUtil placeTipsUpsellLocationHistoryUtil) {
            this.f18519a = placeTipsUpsellLocationHistoryUtil;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f18519a.f18525d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LOCATION_HISTORY_TURNED_ON);
        }

        public void onFailure(Throwable th) {
            this.f18519a.f18525d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LOCATION_HISTORY_FAILED);
            this.f18519a.f18524c.a("place_tips_settings_save", "Failed to turn on location history", th);
        }
    }

    /* compiled from: can_choose_multiple_options */
    public class C20482 implements AsyncFunction<OperationResult, GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsUpsellLocationHistoryUtil f18520a;

        public C20482(PlaceTipsUpsellLocationHistoryUtil placeTipsUpsellLocationHistoryUtil) {
            this.f18520a = placeTipsUpsellLocationHistoryUtil;
        }

        public final ListenableFuture m22443a(Object obj) {
            PlaceTipsUpsellLocationHistoryUtil placeTipsUpsellLocationHistoryUtil = this.f18520a;
            ListenableFuture a = placeTipsUpsellLocationHistoryUtil.f18523b.m3889a(null, NotificationsEnabled.ENABLED);
            Futures.a(a, new C20493(placeTipsUpsellLocationHistoryUtil), MoreExecutors.a());
            return a;
        }
    }

    /* compiled from: can_choose_multiple_options */
    public class C20493 implements FutureCallback<GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsUpsellLocationHistoryUtil f18521a;

        public C20493(PlaceTipsUpsellLocationHistoryUtil placeTipsUpsellLocationHistoryUtil) {
            this.f18521a = placeTipsUpsellLocationHistoryUtil;
        }

        public void onSuccess(@Nullable Object obj) {
            GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) obj;
            this.f18521a.f18525d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_NOTIFICATIONS_TURNED_ON);
            ((Accessor) this.f18521a.f18526e.get()).a(gravitySettingsGraphQlFragmentModel);
        }

        public void onFailure(Throwable th) {
            this.f18521a.f18525d.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_NOTIFICATIONS_FAILED);
            this.f18521a.f18524c.a("place_tips_settings_save", "Failed to update gravity settings", th);
        }
    }

    @Inject
    public PlaceTipsUpsellLocationHistoryUtil(PlaceTipsSettingsHelper placeTipsSettingsHelper, FbErrorReporter fbErrorReporter, PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger, Lazy<Accessor> lazy) {
        this.f18523b = placeTipsSettingsHelper;
        this.f18524c = fbErrorReporter;
        this.f18525d = placeTipsUpsellAnalyticsLogger;
        this.f18526e = lazy;
    }
}
