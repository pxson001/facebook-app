package com.facebook.placetips.upsell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialActionController;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationStatusResult;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.StatusCode;
import com.facebook.placetips.upsell.abtest.ExperimentsForPlaceTipsUpsellAbtestModule;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: candidate_session_id */
public class OnLoginGmsLsUpsellInterstitialController implements InterstitialActionController, InterstitialController {
    private static final ImmutableList<InterstitialTrigger> f18475a = ImmutableList.of(new InterstitialTrigger(Action.FIRST_NEWSFEED_AFTER_LOGIN));
    private static final PrefKey f18476b = ((PrefKey) SharedPrefKeys.a.a("on_login_gms_dialog_seen"));
    private static final String[] f18477c = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private final Provider<PlaceTipsUpsellExperimentController> f18478d;
    public final Provider<GooglePlayLocationServicesSettingsManager> f18479e;
    private final SecureContextHelper f18480f;
    public final Executor f18481g;
    public final PlaceTipsUpsellAnalyticsLogger f18482h;
    private final Provider<String> f18483i;
    private final FbSharedPreferences f18484j;
    private final ActivityRuntimePermissionsManagerProvider f18485k;
    private final AbstractFbErrorReporter f18486l;

    public static OnLoginGmsLsUpsellInterstitialController m22403b(InjectorLike injectorLike) {
        return new OnLoginGmsLsUpsellInterstitialController(IdBasedProvider.a(injectorLike, 3028), IdBasedProvider.a(injectorLike, 7458), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PlaceTipsUpsellAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public OnLoginGmsLsUpsellInterstitialController(Provider<PlaceTipsUpsellExperimentController> provider, Provider<GooglePlayLocationServicesSettingsManager> provider2, SecureContextHelper secureContextHelper, Executor executor, PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger, Provider<String> provider3, FbSharedPreferences fbSharedPreferences, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, FbErrorReporter fbErrorReporter) {
        this.f18478d = provider;
        this.f18479e = provider2;
        this.f18480f = secureContextHelper;
        this.f18481g = executor;
        this.f18482h = placeTipsUpsellAnalyticsLogger;
        this.f18483i = provider3;
        this.f18484j = fbSharedPreferences;
        this.f18485k = activityRuntimePermissionsManagerProvider;
        this.f18486l = fbErrorReporter;
    }

    public final void m22409a(final Context context, Object obj) {
        this.f18482h.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_ON_LOGIN_GMS_LS_DIALOG_START);
        Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        if (activity == null) {
            this.f18486l.b(OnLoginGmsLsUpsellInterstitialController.class.getSimpleName(), "Needed an Activity object but this controller did not run within an activity");
        } else {
            this.f18485k.a(activity).a(f18477c, new RuntimePermissionsListener(this) {
                final /* synthetic */ OnLoginGmsLsUpsellInterstitialController f18474b;

                /* compiled from: candidate_session_id */
                class C20341 implements FutureCallback<LocationStatusResult> {
                    final /* synthetic */ C20351 f18472a;

                    C20341(C20351 c20351) {
                        this.f18472a = c20351;
                    }

                    public void onSuccess(Object obj) {
                        LocationStatusResult locationStatusResult = (LocationStatusResult) obj;
                        PlaceTipsUpsellAnalyticsLogger placeTipsUpsellAnalyticsLogger = this.f18472a.f18474b.f18482h;
                        switch (PlaceTipsUpsellAnalyticsLogger$1.f18497b[locationStatusResult.b.ordinal()]) {
                            case 1:
                                placeTipsUpsellAnalyticsLogger.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_DIALOG_IS_POSSIBLE);
                                break;
                            case 2:
                                placeTipsUpsellAnalyticsLogger.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_DIALOG_ALREADY_ATTEMPTED);
                                break;
                            case 3:
                                placeTipsUpsellAnalyticsLogger.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_NOT_NEEDED);
                                break;
                            case 4:
                                placeTipsUpsellAnalyticsLogger.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_NOT_POSSIBLE);
                                break;
                            case 5:
                                placeTipsUpsellAnalyticsLogger.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_FAILED);
                                break;
                        }
                        if (locationStatusResult.b == StatusCode.EASY_RESOLUTION_POSSIBLE) {
                            OnLoginGmsLsUpsellInterstitialController.m22402a(this.f18472a.f18474b, context);
                        }
                    }

                    public void onFailure(Throwable th) {
                        this.f18472a.f18474b.f18482h.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_FAILED, th, null);
                    }
                }

                public final void m22399a() {
                    Futures.a(((GooglePlayLocationServicesSettingsManager) this.f18474b.f18479e.get()).a(new LocationSettingsRequestParams()), new C20341(this), this.f18474b.f18481g);
                }

                public final void m22400a(String[] strArr, String[] strArr2) {
                    this.f18474b.f18482h.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LOCATION_PERMISSION_REQ_DENIED);
                }

                public final void m22401b() {
                    this.f18474b.f18482h.a(PlaceTipsUpsellAnalyticsEvent.LOCATION_OPT_IN_LOCATION_PERMISSION_REQ_CANCELED);
                }
            });
        }
    }

    public static void m22402a(OnLoginGmsLsUpsellInterstitialController onLoginGmsLsUpsellInterstitialController, Context context) {
        Intent intent = new Intent(context, UpsellContainerActivity.class);
        intent.putExtra("gms_dialog_surface", "surafce_first_news_feed_after_login");
        intent.putExtra("gms_dialog_mechanism", "mechanism_passive");
        onLoginGmsLsUpsellInterstitialController.f18480f.a(intent, context);
        onLoginGmsLsUpsellInterstitialController.m22406f();
    }

    public final String m22411b() {
        return "3931";
    }

    public final void m22410a(Parcelable parcelable) {
    }

    public final void m22408a(long j) {
    }

    public final InterstitialControllerState m22407a(InterstitialTrigger interstitialTrigger) {
        if (interstitialTrigger.action == Action.FIRST_NEWSFEED_AFTER_LOGIN && m22405e() && ((PlaceTipsUpsellExperimentController) this.f18478d.get()).b.a(ExperimentsForPlaceTipsUpsellAbtestModule.f18557f, false)) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m22412c() {
        return f18475a;
    }

    public final long hI_() {
        return 0;
    }

    @Nullable
    private PrefKey m22404d() {
        String str = (String) this.f18483i.get();
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return (PrefKey) f18476b.a(str);
    }

    private boolean m22405e() {
        PrefKey d = m22404d();
        if (d == null || this.f18484j.a(d, false)) {
            return false;
        }
        return true;
    }

    private void m22406f() {
        PrefKey d = m22404d();
        if (d != null) {
            this.f18484j.edit().putBoolean(d, true).commit();
        }
    }
}
