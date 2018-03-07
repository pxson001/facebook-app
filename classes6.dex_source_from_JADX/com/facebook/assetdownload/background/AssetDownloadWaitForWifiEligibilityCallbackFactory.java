package com.facebook.assetdownload.background;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.assetdownload.AssetDownloadPrefKeys;
import com.facebook.assetdownload.background.AssetDownloadRunner.EligibilityCallback;
import com.facebook.common.time.Clock;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: profile_question_object_selected */
public class AssetDownloadWaitForWifiEligibilityCallbackFactory {
    public static final PrefKey f7306a = ((PrefKey) AssetDownloadPrefKeys.f7264a.a("last_run"));
    private final Clock f7307b;
    private final FbSharedPreferences f7308c;
    private final ConnectivityManager f7309d;

    /* compiled from: profile_question_object_selected */
    class WaitForWifiEligibilityCallback implements EligibilityCallback {
        private final Clock f7301a;
        private final FbSharedPreferences f7302b;
        private final ConnectivityManager f7303c;
        private final long f7304d;
        private final boolean f7305e;

        private WaitForWifiEligibilityCallback(Clock clock, FbSharedPreferences fbSharedPreferences, ConnectivityManager connectivityManager, long j) {
            this.f7301a = clock;
            this.f7302b = fbSharedPreferences;
            this.f7303c = connectivityManager;
            this.f7304d = j;
            long a = this.f7302b.a(AssetDownloadWaitForWifiEligibilityCallbackFactory.f7306a, 0);
            if (a <= 0) {
                m10418d();
                a = this.f7302b.a(AssetDownloadWaitForWifiEligibilityCallbackFactory.f7306a, 0);
            }
            boolean z = a < this.f7301a.a() - this.f7304d || a > this.f7301a.a();
            this.f7305e = z;
        }

        public final boolean mo903a() {
            Object obj = 1;
            NetworkInfo activeNetworkInfo = this.f7303c.getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1)) {
                obj = null;
            }
            return obj != null || this.f7305e;
        }

        public final void mo904b() {
            if (mo903a()) {
                m10418d();
            }
        }

        public final String mo905c() {
            return "MayBeWaitForWifiEligibilityCallback";
        }

        private void m10418d() {
            this.f7302b.edit().a(AssetDownloadWaitForWifiEligibilityCallbackFactory.f7306a, this.f7301a.a()).commit();
        }
    }

    @Inject
    public AssetDownloadWaitForWifiEligibilityCallbackFactory(Clock clock, FbSharedPreferences fbSharedPreferences, ConnectivityManager connectivityManager) {
        this.f7307b = clock;
        this.f7308c = fbSharedPreferences;
        this.f7309d = connectivityManager;
    }

    public final EligibilityCallback m10422a(long j) {
        return new WaitForWifiEligibilityCallback(this.f7307b, this.f7308c, this.f7309d, j);
    }
}
