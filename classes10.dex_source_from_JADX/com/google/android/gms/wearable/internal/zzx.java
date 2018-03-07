package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;

public final class zzx implements DataApi {

    public class zza implements DataItemResult {
        private final Status f13442a;
        private final DataItem f13443b;

        public zza(Status status, DataItem dataItem) {
            this.f13442a = status;
            this.f13443b = dataItem;
        }

        public final Status cp_() {
            return this.f13442a;
        }
    }

    public class zzb implements DeleteDataItemsResult {
        private final Status f13444a;
        private final int f13445b;

        public zzb(Status status, int i) {
            this.f13444a = status;
            this.f13445b = i;
        }

        public final Status cp_() {
            return this.f13444a;
        }
    }

    public final PendingResult<DataItemBuffer> mo673a(GoogleApiClient googleApiClient, final Uri uri) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.b(uri != null, "uri must not be null");
        if (null == null || null == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.b(z, "invalid filter type");
        return googleApiClient.a(new zzi<DataItemBuffer>(this, googleApiClient, 0) {
            final /* synthetic */ zzx f13438d;

            protected final void m13634b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
                zzce com_google_android_gms_wearable_internal_zzce = (zzce) com_google_android_gms_common_api_Api_zzb;
                ((zzbb) com_google_android_gms_wearable_internal_zzce.q()).mo622a(new zzcd$zzl(this), uri, 0);
            }

            protected final Result m13635c(Status status) {
                return new DataItemBuffer(DataHolder.b(status.g));
            }
        });
    }

    public final PendingResult<DataItemResult> mo674a(GoogleApiClient googleApiClient, final PutDataRequest putDataRequest) {
        return googleApiClient.a(new zzi<DataItemResult>(this, googleApiClient) {
            final /* synthetic */ zzx f13435c;

            protected final void m13632b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
                ((zzce) com_google_android_gms_common_api_Api_zzb).m13588a((com.google.android.gms.internal.zzlx.zzb) this, putDataRequest);
            }

            public final Result m13633c(Status status) {
                return new zza(status, null);
            }
        });
    }

    public final PendingResult<DeleteDataItemsResult> mo675b(GoogleApiClient googleApiClient, final Uri uri) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.b(uri != null, "uri must not be null");
        if (null == null || null == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.b(z, "invalid filter type");
        return googleApiClient.a(new zzi<DeleteDataItemsResult>(this, googleApiClient, 0) {
            final /* synthetic */ zzx f13441d;

            protected final void m13636b(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) {
                zzce com_google_android_gms_wearable_internal_zzce = (zzce) com_google_android_gms_common_api_Api_zzb;
                ((zzbb) com_google_android_gms_wearable_internal_zzce.q()).mo643b(new zzcd$zze(this), uri, 0);
            }

            protected final Result m13637c(Status status) {
                return new zzb(status, 0);
            }
        });
    }
}
