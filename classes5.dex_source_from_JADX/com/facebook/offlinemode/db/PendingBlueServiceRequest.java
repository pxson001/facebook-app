package com.facebook.offlinemode.db;

import android.os.Bundle;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.offlinemode.common.PendingRequest;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: dbl_password_set_nonce */
public class PendingBlueServiceRequest extends PendingRequest {
    public final String f5208h;
    public final Bundle f5209i;

    /* compiled from: dbl_password_set_nonce */
    public class Builder extends com.facebook.offlinemode.common.PendingRequest.Builder {
        public String f5206g;
        public Bundle f5207h;

        public final Builder m10067a(Operation operation) {
            this.f5206g = operation.e();
            this.f5207h = operation.f();
            return this;
        }

        public final Builder m10068c(String str) {
            this.f5206g = str;
            return this;
        }

        public final Builder m10066a(Bundle bundle) {
            this.f5207h = bundle;
            return this;
        }

        public final PendingRequest m10065a() {
            return new PendingBlueServiceRequest(this.a, this.b, this.f5206g, this.f5207h, this.d, this.c, this.e, this.f);
        }
    }

    private PendingBlueServiceRequest(@Nullable String str, @Nullable String str2, String str3, Bundle bundle, long j, long j2, int i, int i2) {
        super(i, j, str, str2, i2, j2);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str3));
        this.f5208h = str3;
        this.f5209i = bundle;
    }

    public final String m10069c() {
        return this.f5208h;
    }
}
