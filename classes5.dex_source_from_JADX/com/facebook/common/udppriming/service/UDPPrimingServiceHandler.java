package com.facebook.common.udppriming.service;

import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.udppriming.client.EncryptChannelInformation;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.Lazy;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: should_show_notif_settings_transition_nux */
public class UDPPrimingServiceHandler {
    public static final AtomicBoolean f2740a = new AtomicBoolean(false);
    public final ApiMethodRunnerImpl f2741b;
    public final Lazy<EncryptChannelRequestMethod> f2742c;
    public final DefaultProcessIdleExecutor f2743d;
    public final Runnable f2744e = new C01931(this);

    /* compiled from: should_show_notif_settings_transition_nux */
    class C01931 implements Runnable {
        final /* synthetic */ UDPPrimingServiceHandler f2739a;

        C01931(UDPPrimingServiceHandler uDPPrimingServiceHandler) {
            this.f2739a = uDPPrimingServiceHandler;
        }

        public void run() {
            try {
                this.f2739a.f2741b.a((ApiMethod) this.f2739a.f2742c.get(), EncryptChannelInformation.a().b());
            } catch (Throwable e) {
                BLog.b("UDPPrimingServiceHandler", e.getMessage(), e);
            }
            UDPPrimingServiceHandler.f2740a.set(false);
        }
    }

    @Inject
    public UDPPrimingServiceHandler(ApiMethodRunner apiMethodRunner, Lazy<EncryptChannelRequestMethod> lazy, IdleExecutor idleExecutor) {
        this.f2741b = apiMethodRunner;
        this.f2742c = lazy;
        this.f2743d = idleExecutor;
    }
}
