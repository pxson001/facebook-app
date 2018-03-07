package com.facebook.katana.push.mqtt;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker;
import com.facebook.mqtt.model.thrift.InboxNotification;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.util.InboxJewelCountSourceController;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchThreadListParams */
public class FbandroidMqttPushHandler implements MqttPushHandler {
    private static final Class<?> f11681a = FbandroidMqttPushHandler.class;
    private static volatile FbandroidMqttPushHandler f11682e;
    private final FbandroidPushHandler f11683b;
    private final ObjectMapper f11684c;
    private final Provider<FolderCountsDebugDataTracker> f11685d;

    public static com.facebook.katana.push.mqtt.FbandroidMqttPushHandler m12225a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11682e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.push.mqtt.FbandroidMqttPushHandler.class;
        monitor-enter(r1);
        r0 = f11682e;	 Catch:{ all -> 0x003a }
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
        r0 = m12231b(r0);	 Catch:{ all -> 0x0035 }
        f11682e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11682e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.push.mqtt.FbandroidMqttPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.katana.push.mqtt.FbandroidMqttPushHandler");
    }

    private static FbandroidMqttPushHandler m12231b(InjectorLike injectorLike) {
        return new FbandroidMqttPushHandler(new FbandroidPushHandler(JewelCounters.a(injectorLike), InboxJewelCountSourceController.m8008b(injectorLike)), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 2558));
    }

    @Inject
    public FbandroidMqttPushHandler(FbandroidPushHandler fbandroidPushHandler, ObjectMapper objectMapper, Provider<FolderCountsDebugDataTracker> provider) {
        this.f11683b = fbandroidPushHandler;
        this.f11684c = objectMapper;
        this.f11685d = provider;
    }

    public void onMessage(String str, byte[] bArr) {
        try {
            if ("/inbox".equals(str)) {
                m12232b(this.f11684c.a(StringUtil.a(bArr)));
            } else if ("/t_inbox".equals(str)) {
                m12229a(m12226a(bArr));
            } else if ("/mobile_requests_count".equals(str)) {
                m12230a(this.f11684c.a(StringUtil.a(bArr)));
            } else if ("/friend_requests_seen".equals(str)) {
                m12227a();
            }
        } catch (Throwable e) {
            BLog.a(f11681a, "Failed to read mqtt message", e);
        }
    }

    private void m12227a() {
        this.f11683b.f11686a.a(Jewel.FRIEND_REQUESTS, 0);
    }

    private void m12230a(JsonNode jsonNode) {
        this.f11683b.f11686a.a(Jewel.FRIEND_REQUESTS, JSONUtil.d(jsonNode.b("num_unseen")));
    }

    private void m12232b(JsonNode jsonNode) {
        m12228a(JSONUtil.d(jsonNode.b("unread")), JSONUtil.d(jsonNode.b("unseen")), JSONUtil.d(jsonNode.b("recent_unread")));
    }

    private void m12229a(InboxNotification inboxNotification) {
        m12228a(inboxNotification.unread.intValue(), inboxNotification.unseen.intValue(), inboxNotification.recentUnread.intValue());
    }

    private void m12228a(int i, int i2, int i3) {
        ((FolderCountsDebugDataTracker) this.f11685d.get()).m10060a(i, i2, i3);
        this.f11683b.m12233a(i2, i3);
    }

    private static InboxNotification m12226a(byte[] bArr) {
        TProtocol a = new Factory().a(new TIOStreamTransport(new ByteArrayInputStream(bArr, 0, bArr.length)));
        try {
            MqttThriftHeader.m12262b(a);
            return InboxNotification.b(a);
        } catch (TException e) {
            throw new IOException(e);
        }
    }
}
