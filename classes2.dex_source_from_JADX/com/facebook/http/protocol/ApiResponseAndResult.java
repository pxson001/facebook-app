package com.facebook.http.protocol;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: last_read_receipt_time_ms */
public class ApiResponseAndResult<RESULT> {
    private final ApiResponse f17907a;
    @Nullable
    private final RESULT f17908b;

    public ApiResponseAndResult(ApiResponse apiResponse, @Nullable RESULT result) {
        this.f17907a = (ApiResponse) Preconditions.checkNotNull(apiResponse);
        this.f17908b = result;
    }

    public final RESULT m25142a() {
        return this.f17908b;
    }
}
