package com.facebook.messaging.attribution;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: outgoing_messenger_payments */
public class PlatformAttributionLogging {
    public static final Class<?> f7853a = PlatformAttributionLogging.class;
    private static volatile PlatformAttributionLogging f7854f;
    public final AnalyticsLogger f7855b;
    public final ListeningExecutorService f7856c;
    public final Context f7857d;
    private final Executor f7858e;

    /* compiled from: outgoing_messenger_payments */
    public class C08762 implements Callable<Info> {
        final /* synthetic */ PlatformAttributionLogging f7852a;

        public C08762(PlatformAttributionLogging platformAttributionLogging) {
            this.f7852a = platformAttributionLogging;
        }

        public Object call() {
            Object obj = null;
            try {
                obj = AdvertisingIdClient.a(this.f7852a.f7857d);
            } catch (GooglePlayServicesRepairableException e) {
            } catch (GooglePlayServicesNotAvailableException e2) {
            } catch (IOException e3) {
            }
            return obj;
        }
    }

    public static com.facebook.messaging.attribution.PlatformAttributionLogging m8077a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7854f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.attribution.PlatformAttributionLogging.class;
        monitor-enter(r1);
        r0 = f7854f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8079b(r0);	 Catch:{ all -> 0x0035 }
        f7854f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7854f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attribution.PlatformAttributionLogging.a(com.facebook.inject.InjectorLike):com.facebook.messaging.attribution.PlatformAttributionLogging");
    }

    private static PlatformAttributionLogging m8079b(InjectorLike injectorLike) {
        return new PlatformAttributionLogging(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PlatformAttributionLogging(AnalyticsLogger analyticsLogger, ListeningExecutorService listeningExecutorService, Executor executor, Context context) {
        this.f7855b = analyticsLogger;
        this.f7856c = listeningExecutorService;
        this.f7857d = context;
        this.f7858e = executor;
    }

    public final void m8084a(String str, String str2, String str3) {
        m8078a("view_attribution_link", str, str2, str3);
    }

    public final void m8087b(String str, String str2, String str3) {
        m8078a("tap_on_attribution_link", str, str2, str3);
    }

    private void m8078a(String str, String str2, String str3, @Nullable String str4) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(str3);
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        Futures.a(this.f7856c.a(new C08762(this)), new FutureCallback<Info>(this) {
            final /* synthetic */ PlatformAttributionLogging f7851e;

            public void onSuccess(@Nullable Object obj) {
                Info info = (Info) obj;
                HoneyClientEvent b = new HoneyClientEvent(str5).b("app_id", str6).b("message_id", str7);
                if (str8 != null) {
                    b.b("button", str8);
                }
                if (info != null) {
                    b.b("ADID", info.a);
                }
                this.f7851e.f7855b.a(b);
            }

            public void onFailure(Throwable th) {
                BLog.c(PlatformAttributionLogging.f7853a, Strings.nullToEmpty(th.getMessage()), th);
            }
        }, this.f7858e);
    }

    public final void m8083a(String str, String str2) {
        m8080c("view_participants_dialog", str, str2);
    }

    public final void m8086b(String str, String str2) {
        m8080c("accept_participants_dialog", str, str2);
    }

    public final void m8089c(String str, String str2) {
        m8080c("dismiss_participants_dialog", str, str2);
    }

    public final void m8082a(String str) {
        m8081d("view_inline_reply_dialog", str, "platform_app");
    }

    public final void m8085b(String str) {
        m8081d("send_inline_reply_dialog_event", str, "platform_app");
    }

    public final void m8088c(String str) {
        m8081d("cancel_inline_reply_dialog_event", str, "platform_app");
    }

    public final void m8090d(String str) {
        m8081d("send_inline_reply_dialog_event", str, "sample_content");
    }

    public final void m8091e(String str) {
        m8081d("cancel_inline_reply_dialog_event", str, "sample_content");
    }

    private void m8080c(String str, String str2, String str3) {
        this.f7855b.a(new HoneyClientEvent(str).b("app_id", str2).b("message_id", str3));
    }

    private void m8081d(String str, String str2, String str3) {
        this.f7855b.a(new HoneyClientEvent(str).b("app_id", str2).b("content_source", str3));
    }
}
