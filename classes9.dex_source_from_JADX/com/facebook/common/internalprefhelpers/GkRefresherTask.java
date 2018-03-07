package com.facebook.common.internalprefhelpers;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.internal.GkConfigurationComponent;
import com.facebook.gk.internal.GkSessionlessFetcher;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: public_profile */
public class GkRefresherTask extends FbAsyncTask<Void, Void, Boolean> {
    private final GkManualUpdater f5986a;
    private final Toaster f5987b;
    private final Provider<Boolean> f5988c;

    public static GkRefresherTask m6311b(InjectorLike injectorLike) {
        return new GkRefresherTask(new GkManualUpdater((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GkConfigurationComponent.a(injectorLike), GkSessionlessFetcher.a(injectorLike), BatchComponentRunner.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike)), Toaster.b(injectorLike), IdBasedProvider.a(injectorLike, 3926));
    }

    protected void onPostExecute(@Nullable Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.f5987b.b(new ToastBuilder("Gks refreshed"));
        } else {
            this.f5987b.b(new ToastBuilder("Failure refreshing gks"));
        }
    }

    @Inject
    public GkRefresherTask(GkManualUpdater gkManualUpdater, Toaster toaster, Provider<Boolean> provider) {
        this.f5986a = gkManualUpdater;
        this.f5987b = toaster;
        this.f5988c = provider;
    }

    protected void onPreExecute() {
        this.f5987b.b(new ToastBuilder("Refreshing gks"));
    }

    protected final Object m6312a(Object[] objArr) {
        try {
            this.f5986a.m6310a(((Boolean) this.f5988c.get()).booleanValue());
            return Boolean.valueOf(true);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }
}
