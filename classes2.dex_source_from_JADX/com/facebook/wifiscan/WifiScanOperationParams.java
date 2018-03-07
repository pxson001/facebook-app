package com.facebook.wifiscan;

import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: location_manager_result */
public class WifiScanOperationParams {
    public final long f16578a;
    public final long f16579b;

    public WifiScanOperationParams(long j, long j2) {
        this.f16578a = j;
        this.f16579b = j2;
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("timeout_ms", this.f16578a).add("age_limit_ms", this.f16579b).toString();
    }
}
