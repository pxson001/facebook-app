package com.facebook.assetdownload.background;

import com.facebook.assetdownload.AssetDownloadXConfig;
import com.facebook.assetdownload.background.AssetDownloadRunner.DataLimitEligibilityCallback;
import com.facebook.assetdownload.background.AssetDownloadRunner.EligibilityCallback;
import com.facebook.assetdownload.background.AssetDownloadRunner.TimeLimitEligibilityCallback;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

/* compiled from: profile_question_skip */
public class AssetDownloadConditionalWorker implements ConditionalWorker {
    private final AssetDownloadRunner f7267a;
    private final XConfigReader f7268b;
    private final AssetDownloadWaitForWifiEligibilityCallbackFactory f7269c;

    /* compiled from: profile_question_skip */
    class ConditionalWorkerEligibilityCallback implements EligibilityCallback {
        private final ConditionalWorkerRunner f7266a;

        public ConditionalWorkerEligibilityCallback(ConditionalWorkerRunner conditionalWorkerRunner) {
            this.f7266a = conditionalWorkerRunner;
        }

        public final boolean mo903a() {
            return this.f7266a.a();
        }

        public final void mo904b() {
        }

        public final String mo905c() {
            return "ConditionalWorkerCheck";
        }
    }

    public static AssetDownloadConditionalWorker m10391b(InjectorLike injectorLike) {
        return new AssetDownloadConditionalWorker(AssetDownloadRunner.m10406b(injectorLike), XConfigReader.a(injectorLike), new AssetDownloadWaitForWifiEligibilityCallbackFactory((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ConnectivityManagerMethodAutoProvider.b(injectorLike)));
    }

    @Inject
    public AssetDownloadConditionalWorker(AssetDownloadRunner assetDownloadRunner, XConfigReader xConfigReader, AssetDownloadWaitForWifiEligibilityCallbackFactory assetDownloadWaitForWifiEligibilityCallbackFactory) {
        this.f7267a = assetDownloadRunner;
        this.f7268b = xConfigReader;
        this.f7269c = assetDownloadWaitForWifiEligibilityCallbackFactory;
    }

    public final boolean m10392a(ConditionalWorkerRunner conditionalWorkerRunner) {
        this.f7267a.m10413b();
        AssetDownloadRunner assetDownloadRunner = this.f7267a;
        long a = this.f7268b.a(AssetDownloadXConfig.h, 30000);
        if (assetDownloadRunner.f7291o != null) {
            assetDownloadRunner.f7290n.remove(assetDownloadRunner.f7291o);
        }
        assetDownloadRunner.f7291o = new TimeLimitEligibilityCallback(assetDownloadRunner.f7278b, a);
        assetDownloadRunner.m10411a(assetDownloadRunner.f7291o);
        assetDownloadRunner = this.f7267a;
        a = this.f7268b.a(AssetDownloadXConfig.f, 2097152);
        if (assetDownloadRunner.f7292p != null) {
            assetDownloadRunner.f7290n.remove(assetDownloadRunner.f7292p);
        }
        assetDownloadRunner.f7292p = new DataLimitEligibilityCallback(a);
        assetDownloadRunner.m10411a(assetDownloadRunner.f7292p);
        assetDownloadRunner = this.f7267a;
        a = this.f7268b.a(AssetDownloadXConfig.g, 524288);
        if (assetDownloadRunner.f7293q != null) {
            assetDownloadRunner.f7290n.remove(assetDownloadRunner.f7293q);
        }
        assetDownloadRunner.f7293q = new DataLimitEligibilityCallback(a);
        assetDownloadRunner.m10411a(assetDownloadRunner.f7293q);
        this.f7267a.m10410a(this.f7268b.a(AssetDownloadXConfig.e, 2));
        long a2 = this.f7268b.a(AssetDownloadXConfig.i, 36000000);
        if (a2 >= 0) {
            this.f7267a.m10411a(this.f7269c.m10422a(a2));
        }
        if (conditionalWorkerRunner != null) {
            this.f7267a.m10411a(new ConditionalWorkerEligibilityCallback(conditionalWorkerRunner));
        }
        return this.f7267a.m10412a();
    }
}
