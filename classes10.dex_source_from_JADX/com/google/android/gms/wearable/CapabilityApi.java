package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface CapabilityApi {

    public interface CapabilityListener {
        void mo133a(CapabilityInfo capabilityInfo);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CapabilityFilterType {
    }

    public interface GetCapabilityResult extends Result {
        CapabilityInfo mo671b();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NodeFilterType {
    }

    PendingResult<GetCapabilityResult> mo672a(GoogleApiClient googleApiClient, String str, int i);
}
