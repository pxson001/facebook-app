package com.google.android.gms.wearable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface MessageApi {

    public interface MessageListener {
        void mo135a(MessageEvent messageEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterType {
    }
}
