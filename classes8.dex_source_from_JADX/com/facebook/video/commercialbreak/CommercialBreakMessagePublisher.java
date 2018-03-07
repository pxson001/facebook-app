package com.facebook.video.commercialbreak;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.video.commercialbreak.CommercialBreakMessageConstants.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: logger_params */
public class CommercialBreakMessagePublisher {
    private static final String f9727a = CommercialBreakMessagePublisher.class.getSimpleName();
    private static volatile CommercialBreakMessagePublisher f9728e;
    private final SkywalkerSubscriptionConnector f9729b;
    private final ObjectMapper f9730c;
    @Nullable
    public String f9731d;

    public static com.facebook.video.commercialbreak.CommercialBreakMessagePublisher m11438a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9728e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.commercialbreak.CommercialBreakMessagePublisher.class;
        monitor-enter(r1);
        r0 = f9728e;	 Catch:{ all -> 0x003a }
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
        r0 = m11440b(r0);	 Catch:{ all -> 0x0035 }
        f9728e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9728e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.commercialbreak.CommercialBreakMessagePublisher.a(com.facebook.inject.InjectorLike):com.facebook.video.commercialbreak.CommercialBreakMessagePublisher");
    }

    private static CommercialBreakMessagePublisher m11440b(InjectorLike injectorLike) {
        return new CommercialBreakMessagePublisher(SkywalkerSubscriptionConnector.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CommercialBreakMessagePublisher(SkywalkerSubscriptionConnector skywalkerSubscriptionConnector, ObjectMapper objectMapper) {
        this.f9729b = skywalkerSubscriptionConnector;
        this.f9730c = objectMapper;
    }

    public final void m11441a(long j) {
        if (this.f9731d != null) {
            String str = "video_broadcast/commercial_break_" + this.f9731d;
            ObjectNode e = this.f9730c.e();
            e.a("type", Type.INTENT.name().toLowerCase(Locale.US));
            e.a("commercial_break_length_ms", j);
            m11439a(str, e);
        }
    }

    public final void m11442a(long j, long j2) {
        if (this.f9731d != null) {
            String str = "video_broadcast/commercial_break_" + this.f9731d;
            ObjectNode e = this.f9730c.e();
            e.a("type", Type.START.name().toLowerCase(Locale.US));
            e.a("commercial_break_start_time_ms", j);
            e.a("commercial_break_length_ms", j2);
            m11439a(str, e);
        }
    }

    private void m11439a(String str, ObjectNode objectNode) {
        this.f9729b.a(str, objectNode);
    }
}
