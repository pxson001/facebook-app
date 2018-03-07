package com.google.android.gms.wearable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ChannelApi {

    public interface ChannelListener {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseReason {
    }
}
