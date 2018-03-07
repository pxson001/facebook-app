package com.facebook.growth.nux.preferences;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: p2p_request_success */
public class ResetNUXStatusPreference extends Preference {
    @Inject
    public DefaultBlueServiceOperationFactory f7499a;
    @Inject
    public FbSharedPreferences f7500b;
    @Inject
    public Toaster f7501c;
    @Inject
    @ForUiThread
    public Executor f7502d;

    /* compiled from: p2p_request_success */
    public class C08321 implements OnPreferenceClickListener {
        final /* synthetic */ ResetNUXStatusPreference f7496a;

        public C08321(ResetNUXStatusPreference resetNUXStatusPreference) {
            this.f7496a = resetNUXStatusPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f7496a.f7501c.a(new ToastBuilder("Starting NUX status reset."));
            ResetNUXStatusPreference resetNUXStatusPreference = this.f7496a;
            resetNUXStatusPreference.f7500b.edit().a(GrowthPrefKeys.b).commit();
            Futures.a(BlueServiceOperationFactoryDetour.a(resetNUXStatusPreference.f7499a, "reset_nux_status", new Bundle(), ErrorPropagation.BY_EXCEPTION, CallerContext.a(ResetNUXStatusPreference.class), -150317793).a(), new C08332(resetNUXStatusPreference), resetNUXStatusPreference.f7502d);
            return true;
        }
    }

    /* compiled from: p2p_request_success */
    public class C08332 implements FutureCallback<OperationResult> {
        final /* synthetic */ ResetNUXStatusPreference f7497a;

        public C08332(ResetNUXStatusPreference resetNUXStatusPreference) {
            this.f7497a = resetNUXStatusPreference;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f7497a.f7501c.a(new ToastBuilder("NUX status reset on server complete. Starting status fetch from server."));
            ResetNUXStatusPreference resetNUXStatusPreference = this.f7497a;
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchAndUpdateInterstitialsParams", new FetchInterstitialsParams(ImmutableList.of("1630")));
            Futures.a(BlueServiceOperationFactoryDetour.a(resetNUXStatusPreference.f7499a, "interstitials_fetch_and_update", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(ResetNUXStatusPreference.class), -614296450).a(), new C08343(resetNUXStatusPreference), resetNUXStatusPreference.f7502d);
        }

        public void onFailure(Throwable th) {
            this.f7497a.f7501c.a(new ToastBuilder("NUX status reset failed."));
        }
    }

    /* compiled from: p2p_request_success */
    public class C08343 implements FutureCallback<OperationResult> {
        final /* synthetic */ ResetNUXStatusPreference f7498a;

        public C08343(ResetNUXStatusPreference resetNUXStatusPreference) {
            this.f7498a = resetNUXStatusPreference;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f7498a.f7501c.a(new ToastBuilder("NUX status fetched. Choose the Launch option below or log out and back in to see NUX."));
        }

        public void onFailure(Throwable th) {
            this.f7498a.f7501c.a(new ToastBuilder("NUX status reset complete, but server fetch failed. Log out and back in to see NUX."));
        }
    }

    public static void m7801a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ResetNUXStatusPreference resetNUXStatusPreference = (ResetNUXStatusPreference) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        Toaster b2 = Toaster.b(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        resetNUXStatusPreference.f7499a = b;
        resetNUXStatusPreference.f7500b = fbSharedPreferences;
        resetNUXStatusPreference.f7501c = b2;
        resetNUXStatusPreference.f7502d = executor;
    }

    public ResetNUXStatusPreference(Context context) {
        super(context);
        Class cls = ResetNUXStatusPreference.class;
        m7801a(this, getContext());
    }
}
