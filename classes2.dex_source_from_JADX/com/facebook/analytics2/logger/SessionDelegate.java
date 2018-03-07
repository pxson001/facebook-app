package com.facebook.analytics2.logger;

import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: tab_nux */
public class SessionDelegate {
    private final SessionManager f3367a;
    @Nullable
    public EventProcessorManager f3368b;
    @Nullable
    private String f3369c;
    @Nullable
    private BatchSession f3370d;
    @GuardedBy("this")
    private boolean f3371e;

    public SessionDelegate(SessionManager sessionManager) {
        this.f3367a = sessionManager;
    }

    final synchronized BatchSession m5578a(EventProcessorManager eventProcessorManager) {
        m5573b(eventProcessorManager);
        return this.f3370d;
    }

    public final void m5579a() {
        m5574e();
        m5576g();
    }

    public final void m5581b() {
        m5574e();
        m5576g();
    }

    public final void m5580a(String str) {
        m5574e();
        this.f3369c = str;
        m5576g();
    }

    public final void m5582c() {
        m5574e();
        String str = this.f3369c;
        this.f3369c = null;
        this.f3368b.m5405d().m5558a(str);
        this.f3368b.m5403b().m5558a(str);
        m5576g();
    }

    private synchronized void m5574e() {
        if (!this.f3371e) {
            throw new IllegalStateException("SessionDelegate should have called bootstrapIfNeeded");
        }
    }

    private synchronized void m5573b(EventProcessorManager eventProcessorManager) {
        if (!this.f3371e) {
            this.f3368b = eventProcessorManager;
            this.f3369c = this.f3367a.m5302d();
            this.f3367a.m5298a(this);
            m5575f();
            this.f3371e = true;
        }
    }

    private void m5575f() {
        this.f3370d = new BatchSession(this.f3369c, UUID.randomUUID().toString());
    }

    private void m5576g() {
        m5575f();
        m5577h();
    }

    private synchronized void m5577h() {
        m5572a(this.f3368b.m5404c(), this.f3370d);
        m5572a(this.f3368b.m5402a(), this.f3370d);
    }

    private static void m5572a(@Nullable EventProcessor eventProcessor, BatchSession batchSession) {
        if (eventProcessor != null) {
            WriterHandler writerHandler = eventProcessor.f3343a;
            writerHandler.sendMessage(writerHandler.obtainMessage(3, batchSession));
        }
    }
}
