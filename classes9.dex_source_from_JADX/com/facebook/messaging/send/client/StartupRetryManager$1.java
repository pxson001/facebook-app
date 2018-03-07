package com.facebook.messaging.send.client;

import com.facebook.messaging.model.messages.Message;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;

/* compiled from: default_creative_spec */
public class StartupRetryManager$1 implements Callable<LinkedHashMap<String, Message>> {
    final /* synthetic */ long f16844a;
    final /* synthetic */ long f16845b;
    final /* synthetic */ StartupRetryManager f16846c;

    public StartupRetryManager$1(StartupRetryManager startupRetryManager, long j, long j2) {
        this.f16846c = startupRetryManager;
        this.f16844a = j;
        this.f16845b = j2;
    }

    public Object call() {
        LinkedHashMap a = this.f16846c.g.a(this.f16846c.l, ((int) this.f16844a) + 1);
        if (a == null || a.isEmpty()) {
            return a;
        }
        if (((long) a.size()) > this.f16844a) {
            StartupRetryManager.e(this.f16846c);
            return new LinkedHashMap();
        }
        Object obj;
        for (Message message : a.values()) {
            if (message.c < this.f16845b) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return a;
        }
        StartupRetryManager.b(this.f16846c, a);
        return new LinkedHashMap();
    }
}
