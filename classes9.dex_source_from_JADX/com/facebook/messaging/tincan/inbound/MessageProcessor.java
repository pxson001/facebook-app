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
import com.facebook.messaging.tincan.crypto.CryptoSession;
import com.facebook.messaging.tincan.crypto.CryptoSessionIdFactory;
import com.facebook.messaging.tincan.crypto.CryptoSessionStorage;
import com.facebook.messaging.tincan.crypto.CryptoSessionStorage$MessageMetaData;
import com.facebook.messaging.tincan.crypto.ProcessAcceptPayloadResult;
import com.facebook.messaging.tincan.database.clock.TincanDbClock;
import com.facebook.messaging.tincan.messenger.IncomingMessageHandler;
import com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage;
import com.facebook.messaging.tincan.messenger.MessengerPacketIdFactory;
import com.facebook.messaging.tincan.omnistore.TincanMessage;
import com.facebook.messaging.tincan.outbound.Sender;
import com.facebook.messaging.tincan.thrift.MessagingCollectionAddress;
import com.facebook.messaging.tincan.thrift.Salamander;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.thrift.TException;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.whispersystems.libsignal.DuplicateMessageException;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.InvalidMessageException;
import org.whispersystems.libsignal.InvalidVersionException;
import org.whispersystems.libsignal.LegacyMessageException;
import org.whispersystems.libsignal.NoSessionException;
import org.whispersystems.libsignal.UntrustedIdentityException;

@Singleton
/* compiled from: client_email */
public class MessageProcessor {
    private static final Class<?> f17957a = MessageProcessor.class;
    private static volatile MessageProcessor f17958k;
    private final TincanPacketFactory f17959b;
    private final Provider<CryptoSessionStorage> f17960c;
    private final Provider<CryptoEngine> f17961d;
    private final Provider<MessageHandler> f17962e;
    private final ThriftUtil f17963f;
    private final Sender f17964g;
    private final MessengerPacketIdFactory f17965h;
    private final Lazy<TincanDebugErrorReporter> f17966i;
    private final TincanDbClock f17967j;

    public static com.facebook.messaging.tincan.inbound.MessageProcessor m17958a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17958k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.inbound.MessageProcessor.class;
        monitor-enter(r1);
        r0 = f17958k;	 Catch:{ all -> 0x003a }
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
        r0 = m17961b(r0);	 Catch:{ all -> 0x0035 }
        f17958k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17958k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.inbound.MessageProcessor.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.inbound.MessageProcessor");
    }

    private static MessageProcessor m17961b(InjectorLike injectorLike) {
        return new MessageProcessor(TincanPacketFactory.m17965a(injectorLike), IdBasedProvider.a(injectorLike, 8579), IdBasedProvider.a(injectorLike, 8558), IdBasedSingletonScopeProvider.a(injectorLike, 2736), ThriftUtil.a(injectorLike), Sender.a(injectorLike), MessengerPacketIdFactory.a(injectorLike), IdBasedLazy.a(injectorLike, 2716), TincanDbClock.a(injectorLike));
    }

    @Inject
    public MessageProcessor(TincanPacketFactory tincanPacketFactory, Provider<CryptoSessionStorage> provider, Provider<CryptoEngine> provider2, Provider<MessageHandler> provider3, ThriftUtil thriftUtil, Sender sender, PacketIdFactory packetIdFactory, Lazy<TincanDebugErrorReporter> lazy, TincanDbClock tincanDbClock) {
        this.f17959b = tincanPacketFactory;
        this.f17960c = provider;
        this.f17961d = provider2;
        this.f17962e = provider3;
        this.f17963f = thriftUtil;
        this.f17964g = sender;
        this.f17965h = packetIdFactory;
        this.f17966i = lazy;
        this.f17967j = tincanDbClock;
    }

    public final void m17964a(TincanMessage tincanMessage) {
        Throwable e;
        try {
            TincanPacket a = this.f17959b.m17967a(tincanMessage);
            if (a.f17969b.sender_packet_id == null) {
                BLog.b(f17957a, "Received a packet with a null sender_packet_id!");
            } else {
                Base64.encodeToString(a.f17969b.sender_packet_id, 0);
            }
            if (a.f17969b.date_micros != null) {
                this.f17967j.a(a.f17969b.date_micros.longValue() / 1000);
            }
            switch (a.f17969b.type.intValue()) {
                case 2:
                    m17963c(a);
                    return;
                case 4:
                    m17960a(a);
                    return;
                case 50:
                    ((IncomingMessageHandler) this.f17962e.get()).d(a);
                    return;
                case 51:
                    ((IncomingMessageHandler) this.f17962e.get()).e(a);
                    return;
                case 2020:
                    m17962b(a);
                    return;
                default:
                    if (a.f17969b.type.intValue() >= 400) {
                        ((IncomingMessageHandler) this.f17962e.get()).c(a);
                        return;
                    }
                    return;
            }
        } catch (TException e2) {
            e = e2;
            BLog.b(f17957a, "Message processing error", e);
        } catch (RuntimeException e3) {
            e = e3;
            BLog.b(f17957a, "Message processing error", e);
        }
    }

    private void m17960a(TincanPacket tincanPacket) {
        Throwable e;
        MessagingCollectionAddress messagingCollectionAddress = tincanPacket.f17969b.msg_from;
        String a = CryptoSessionIdFactory.m17860a(messagingCollectionAddress.user_id.longValue());
        String a2 = CryptoSessionIdFactory.m17861a(messagingCollectionAddress.user_id.longValue(), messagingCollectionAddress.instance_id);
        MessengerCryptoSessionStorage messengerCryptoSessionStorage = (MessengerCryptoSessionStorage) this.f17960c.get();
        CryptoSession a3 = messengerCryptoSessionStorage.m18006a(a);
        if (a3 == null) {
            BLog.b(f17957a, "No local session for received accept packet %s", new Object[]{tincanPacket.f17968a});
            m17959a(4040, tincanPacket);
            return;
        }
        ProcessAcceptPayloadResult a4;
        if (tincanPacket.f17969b.body == null) {
            BLog.b(f17957a, "No body in accept message");
            m17959a(4010, tincanPacket);
            a4 = ProcessAcceptPayloadResult.m17896a();
        } else {
            try {
                this.f17961d.get();
                a4 = CryptoEngine.m17847a(a3, a2, tincanPacket.f17969b.body.m18121e().link_accepted_salamander_payload, messengerCryptoSessionStorage);
            } catch (InvalidVersionException e2) {
                e = e2;
                BLog.b(f17957a, "Error processing accept packet", e);
                m17959a(4010, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (InvalidMessageException e3) {
                e = e3;
                BLog.b(f17957a, "Error processing accept packet", e);
                m17959a(4010, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (DuplicateMessageException e4) {
                e = e4;
                BLog.b(f17957a, "Error processing accept packet", e);
                m17959a(4010, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (LegacyMessageException e5) {
                e = e5;
                BLog.b(f17957a, "Error processing accept packet", e);
                m17959a(4010, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (InvalidKeyException e6) {
                e = e6;
                BLog.b(f17957a, "Invalid key processing accept packet", e);
                m17959a(4020, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (InvalidKeyIdException e7) {
                e = e7;
                BLog.b(f17957a, "Invalid key processing accept packet", e);
                m17959a(4020, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (UntrustedIdentityException e8) {
                e = e8;
                BLog.b(f17957a, "Invalid key processing accept packet", e);
                m17959a(4020, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            } catch (Throwable e9) {
                BLog.b(f17957a, "Unknown or missing payload in accept packet", e9);
                m17959a(4010, tincanPacket);
                a4 = ProcessAcceptPayloadResult.m17896a();
            }
        }
        ((MessengerCryptoSessionStorage) this.f17960c.get()).m18009a(a3, a2);
        if (a4.f17885a) {
            Salamander b = ThriftUtil.b(a4.f17886b);
            if (b == null || b.type == null || b.type.intValue() != 1) {
                m17959a(4030, tincanPacket);
                ((MessengerCryptoSessionStorage) this.f17960c.get()).m18011c(a2);
                ((IncomingMessageHandler) this.f17962e.get()).b(a, a2);
                return;
            }
            ((IncomingMessageHandler) this.f17962e.get()).a(a4.f17887c, a4.f17888d);
            return;
        }
        ((MessengerCryptoSessionStorage) this.f17960c.get()).m18011c(a2);
        ((IncomingMessageHandler) this.f17962e.get()).b(a, a2);
    }

    private void m17962b(TincanPacket tincanPacket) {
        MessengerCryptoSessionStorage messengerCryptoSessionStorage = (MessengerCryptoSessionStorage) this.f17960c.get();
        messengerCryptoSessionStorage.f18017c.b(messengerCryptoSessionStorage.f18019e.a(CryptoSessionIdFactory.m17860a(tincanPacket.f17969b.msg_from.user_id.longValue())));
        this.f17962e.get();
    }

    private void m17963c(TincanPacket tincanPacket) {
        Throwable e;
        CryptoSession a = ((MessengerCryptoSessionStorage) this.f17960c.get()).m18006a(CryptoSessionIdFactory.m17861a(tincanPacket.f17969b.msg_from.user_id.longValue(), tincanPacket.f17969b.msg_from.instance_id));
        if (a == null) {
            BLog.b(f17957a, "No local session for received message");
            m17959a(7000, tincanPacket);
            return;
        }
        CryptoSessionStorage$MessageMetaData cryptoSessionStorage$MessageMetaData = new CryptoSessionStorage$MessageMetaData(tincanPacket.f17969b.msg_from.user_id.longValue(), tincanPacket.f17969b.msg_from.instance_id, tincanPacket.f17969b.msg_to.user_id.longValue(), tincanPacket.f17969b.msg_to.instance_id, tincanPacket.f17969b.date_micros.longValue(), tincanPacket.f17968a);
        try {
            this.f17961d.get();
            byte[] a2 = CryptoEngine.m17848a(a, cryptoSessionStorage$MessageMetaData, tincanPacket.f17969b.body.m18119c(), (MessengerCryptoSessionStorage) this.f17960c.get());
            this.f17964g.a(tincanPacket.f17969b.msg_to.user_id.longValue(), tincanPacket.f17969b.msg_to.instance_id, tincanPacket.f17969b.msg_from.user_id.longValue(), tincanPacket.f17969b.msg_from.instance_id, tincanPacket.f17969b.date_micros.longValue(), this.f17965h.a());
            ((IncomingMessageHandler) this.f17962e.get()).a(tincanPacket, a2);
        } catch (LegacyMessageException e2) {
            e = e2;
            BLog.b(f17957a, "Error decrypting Salamander packet", e);
            m17959a(6500, tincanPacket);
        } catch (InvalidMessageException e3) {
            e = e3;
            BLog.b(f17957a, "Error decrypting Salamander packet", e);
            m17959a(6500, tincanPacket);
        } catch (DuplicateMessageException e4) {
            e = e4;
            BLog.b(f17957a, "Error decrypting Salamander packet", e);
            m17959a(6500, tincanPacket);
        } catch (NoSessionException e5) {
            e = e5;
            BLog.b(f17957a, "Error decrypting Salamander packet", e);
            m17959a(6500, tincanPacket);
        }
    }

    private void m17959a(int i, TincanPacket tincanPacket) {
        this.f17964g.a(tincanPacket.f17969b.msg_from, i, tincanPacket.f17969b.sender_packet_id, this.f17965h.a());
    }
}
