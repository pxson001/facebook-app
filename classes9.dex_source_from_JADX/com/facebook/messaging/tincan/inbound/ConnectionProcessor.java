package com.facebook.messaging.tincan.inbound;

import android.util.Base64;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.tincan.TincanDebugErrorReporter;
import com.facebook.messaging.tincan.crypto.CryptoEngine;
import com.facebook.messaging.tincan.crypto.CryptoSessionIdFactory;
import com.facebook.messaging.tincan.crypto.CryptoSessionStorage;
import com.facebook.messaging.tincan.crypto.CryptoSessionStorage$MessageMetaData;
import com.facebook.messaging.tincan.messenger.IncomingMessageHandler;
import com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage;
import com.facebook.messaging.tincan.messenger.MessengerPacketIdFactory;
import com.facebook.messaging.tincan.omnistore.TincanMessage;
import com.facebook.messaging.tincan.outbound.Sender;
import com.facebook.messaging.tincan.thrift.RequestPayload;
import com.facebook.thrift.TException;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.whispersystems.libsignal.InvalidKeyException;

@Singleton
/* compiled from: client_expiration_time_ms */
public class ConnectionProcessor {
    private static final Class<?> f17948a = ConnectionProcessor.class;
    private static volatile ConnectionProcessor f17949i;
    private final Provider<ConnectionRequestHandler> f17950b;
    private final Provider<CryptoEngine> f17951c;
    private final Provider<CryptoSessionStorage> f17952d;
    private final TincanPacketFactory f17953e;
    private final Sender f17954f;
    private final MessengerPacketIdFactory f17955g;
    private final Lazy<TincanDebugErrorReporter> f17956h;

    public static com.facebook.messaging.tincan.inbound.ConnectionProcessor m17953a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17949i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.inbound.ConnectionProcessor.class;
        monitor-enter(r1);
        r0 = f17949i;	 Catch:{ all -> 0x003a }
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
        r0 = m17956b(r0);	 Catch:{ all -> 0x0035 }
        f17949i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17949i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.inbound.ConnectionProcessor.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.inbound.ConnectionProcessor");
    }

    private static ConnectionProcessor m17956b(InjectorLike injectorLike) {
        return new ConnectionProcessor(IdBasedSingletonScopeProvider.a(injectorLike, 2736), IdBasedProvider.a(injectorLike, 8579), IdBasedProvider.a(injectorLike, 8558), TincanPacketFactory.m17965a(injectorLike), Sender.a(injectorLike), MessengerPacketIdFactory.a(injectorLike), IdBasedLazy.a(injectorLike, 2716));
    }

    @Inject
    public ConnectionProcessor(Provider<ConnectionRequestHandler> provider, Provider<CryptoSessionStorage> provider2, Provider<CryptoEngine> provider3, TincanPacketFactory tincanPacketFactory, Sender sender, PacketIdFactory packetIdFactory, Lazy<TincanDebugErrorReporter> lazy) {
        this.f17950b = provider;
        this.f17951c = provider3;
        this.f17952d = provider2;
        this.f17953e = tincanPacketFactory;
        this.f17954f = sender;
        this.f17955g = packetIdFactory;
        this.f17956h = lazy;
    }

    public final void m17957a(TincanMessage tincanMessage) {
        Throwable e;
        try {
            TincanPacket a = this.f17953e.m17967a(tincanMessage);
            if (a.f17969b.sender_packet_id == null) {
                BLog.b(f17948a, "Received a packet with a null sender_packet_id!");
            } else {
                Base64.encodeToString(a.f17969b.sender_packet_id, 0);
            }
            switch (a.f17969b.type.intValue()) {
                case 3:
                    m17955a(a);
                    return;
                case 100:
                    ((IncomingMessageHandler) this.f17950b.get()).b(a);
                    return;
                default:
                    return;
            }
        } catch (TException e2) {
            e = e2;
            BLog.b(f17948a, "Connection request processing error", e);
        } catch (RuntimeException e3) {
            e = e3;
            BLog.b(f17948a, "Connection request processing error", e);
        }
    }

    private void m17955a(TincanPacket tincanPacket) {
        Throwable e;
        CryptoSessionStorage$MessageMetaData cryptoSessionStorage$MessageMetaData = new CryptoSessionStorage$MessageMetaData(tincanPacket.f17969b.msg_from.user_id.longValue(), tincanPacket.f17969b.msg_from.instance_id, tincanPacket.f17969b.sig_to.user_id.longValue(), null, tincanPacket.f17969b.date_micros.longValue(), tincanPacket.f17968a);
        if (tincanPacket.f17969b.body == null) {
            BLog.b(f17948a, "No payload in connection request");
            m17954a(3010, tincanPacket);
            return;
        }
        try {
            RequestPayload d = tincanPacket.f17969b.body.m18120d();
            if (d.pre_key_bundle == null || d.pre_key_bundle.identity_key == null || d.pre_key_bundle.pre_key == null || d.pre_key_bundle.signed_pre_key == null || d.pre_key_bundle.signed_pre_key_signature == null) {
                BLog.b(f17948a, "Incomplete pre key data in connection request");
                m17954a(3010, tincanPacket);
                return;
            }
            try {
                ((CryptoEngine) this.f17951c.get()).m17855a(CryptoSessionIdFactory.m17861a(tincanPacket.f17969b.msg_from.user_id.longValue(), tincanPacket.f17969b.msg_from.instance_id), d.pre_key_bundle, cryptoSessionStorage$MessageMetaData, (MessengerCryptoSessionStorage) this.f17952d.get());
                ((IncomingMessageHandler) this.f17950b.get()).a(tincanPacket);
            } catch (InvalidKeyException e2) {
                e = e2;
                BLog.b(f17948a, "Invalid pre key data in connection request", e);
                m17954a(3020, tincanPacket);
            } catch (RuntimeException e3) {
                e = e3;
                BLog.b(f17948a, "Invalid pre key data in connection request", e);
                m17954a(3020, tincanPacket);
            } catch (Throwable e4) {
                BLog.b(f17948a, "Untrusted identity made a connection request", e4);
                m17954a(3020, tincanPacket);
            }
        } catch (Throwable e42) {
            BLog.b(f17948a, "Unknown payload found in connection request", e42);
            m17954a(3010, tincanPacket);
        }
    }

    private void m17954a(int i, TincanPacket tincanPacket) {
        Preconditions.checkArgument(tincanPacket != null);
        this.f17954f.a(tincanPacket.f17969b.msg_from, null, i, tincanPacket.f17969b.sender_packet_id, this.f17955g.a());
    }
}
