package com.facebook.messaging.send.client;

import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.send.client.StartupRetryManager.InitialSendRetryStatus;
import com.google.common.util.concurrent.FutureCallback;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;

/* compiled from: default_creative_spec */
public class StartupRetryManager$2 implements FutureCallback<LinkedHashMap<String, Message>> {
    final /* synthetic */ StartupRetryManager f16847a;

    public StartupRetryManager$2(StartupRetryManager startupRetryManager) {
        this.f16847a = startupRetryManager;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f16847a.a((LinkedHashMap) obj);
    }

    public void onFailure(Throwable th) {
        StartupRetryManager startupRetryManager = this.f16847a;
        if (startupRetryManager.k != InitialSendRetryStatus.ABORTED) {
            startupRetryManager.k = InitialSendRetryStatus.FAILED;
            startupRetryManager.h.a("StartupRetryManager", "Failed to start send retry during startup.");
        }
    }
}
