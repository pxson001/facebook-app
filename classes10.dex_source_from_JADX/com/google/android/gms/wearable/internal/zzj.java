package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Set;

public class zzj implements CapabilityApi {

    public class zzc implements CapabilityInfo {
        private final String f13430a;
        private final Set<Node> f13431b;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.mo574a(), capabilityInfo.mo575b());
        }

        private zzc(String str, Set<Node> set) {
            this.f13430a = str;
            this.f13431b = set;
        }

        public final String mo574a() {
            return this.f13430a;
        }

        public final Set<Node> mo575b() {
            return this.f13431b;
        }
    }

    public class zze implements GetCapabilityResult {
        private final CapabilityInfo f13432a;
        private final Status f13433b;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.f13433b = status;
            this.f13432a = capabilityInfo;
        }

        public final CapabilityInfo mo671b() {
            return this.f13432a;
        }

        public final Status cp_() {
            return this.f13433b;
        }
    }

    public final PendingResult<GetCapabilityResult> mo672a(GoogleApiClient googleApiClient, final String str, final int i) {
        boolean z = true;
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        zzx.b(z);
        return googleApiClient.a(new zzi<GetCapabilityResult>(this, googleApiClient) {
            final /* synthetic */ zzj f13429d;

            protected final void m13626b(zzb com_google_android_gms_common_api_Api_zzb) {
                zzce com_google_android_gms_wearable_internal_zzce = (zzce) com_google_android_gms_common_api_Api_zzb;
                ((zzbb) com_google_android_gms_wearable_internal_zzce.q()).mo634a(new zzcd$zzg(this), str, i);
            }

            protected final Result m13627c(Status status) {
                return new zze(status, null);
            }
        });
    }
}
