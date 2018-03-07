package com.facebook.loom.config;

import android.util.SparseArray;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/default_optin/campaign_token_to_refresh_type_key */
public class QPLControllerConfig implements ControllerConfig {
    @Nullable
    public final SparseArray<QPLTraceControlConfiguration> f457a;

    public QPLControllerConfig(@Nullable SparseArray<QPLTraceControlConfiguration> sparseArray) {
        this.f457a = sparseArray;
    }

    @Nullable
    public final QPLTraceControlConfiguration m993a(int i) {
        Object obj;
        if (this.f457a == null || this.f457a.size() <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return null;
        }
        return (QPLTraceControlConfiguration) this.f457a.get(i);
    }
}
