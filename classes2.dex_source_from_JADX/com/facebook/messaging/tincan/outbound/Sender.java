package com.facebook.messaging.tincan.outbound;

import android.util.Base64;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.tincan.TincanDebugErrorReporter;
import com.facebook.messaging.tincan.TincanDeviceIdHolder;
import com.facebook.messaging.tincan.crypto.CryptoEngine;
import com.facebook.messaging.tincan.crypto.CryptoSession;
import com.facebook.messaging.tincan.crypto.CryptoSessionIdFactory;
import com.facebook.messaging.tincan.crypto.CryptoSessionStorage;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.messaging.tincan.messenger.MessengerCryptoSessionStorage;
import com.facebook.messaging.tincan.omnistore.TincanOmnistoreRefresherByGatekeeper;
import com.facebook.messaging.tincan.prefs.TincanPrefKeys;
import com.facebook.messaging.tincan.thrift.MessagingCollectionAddress;
import com.facebook.messaging.tincan.thrift.PacketBody;
import com.facebook.messaging.tincan.thrift.ReceiptPayload;
import com.facebook.messaging.tincan.thrift.RequestPreKeyBundle;
import com.facebook.messaging.tincan.thrift.SignalingCollectionAddress;
import com.facebook.messaging.tincan.thrift.ThriftFactory;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.OmnistoreException;
import com.facebook.omnistore.module.OmnistoreComponent;
import com.facebook.omnistore.module.OmnistoreComponent.SubscriptionInfo;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.whispersystems.libsignal.util.KeyHelper;

@Singleton
/* compiled from: mOnDrawListeners */
public class Sender implements OmnistoreComponent {
    private static final Class<?> f15492a = Sender.class;
    private static volatile Sender f15493n;
    private final TincanDeviceIdHolder f15494b;
    private final Provider<String> f15495c;
    private final Provider<CryptoSessionStorage> f15496d;
    private final Provider<CryptoEngine> f15497e;
    private final ThriftUtil f15498f;
    private final SystemClock f15499g;
    private final TincanGatekeepers f15500h;
    private final TincanOmnistoreRefresherByGatekeeper f15501i;
    private final Lazy<TincanDebugErrorReporter> f15502j;
    public final FbSharedPreferences f15503k;
    private Collection f15504l;
    private byte[] f15505m = new byte[32];

    public static com.facebook.messaging.tincan.outbound.Sender m22110a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15493n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.tincan.outbound.Sender.class;
        monitor-enter(r1);
        r0 = f15493n;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22114b(r0);	 Catch:{ all -> 0x0035 }
        f15493n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15493n;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.outbound.Sender.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.outbound.Sender");
    }

    private static Sender m22114b(InjectorLike injectorLike) {
        return new Sender(TincanDeviceIdHolder.m22122a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4443), IdBasedProvider.m1811a(injectorLike, 8579), IdBasedProvider.m1811a(injectorLike, 8558), ThriftUtil.m21835a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), TincanGatekeepers.m4518b(injectorLike), TincanOmnistoreRefresherByGatekeeper.m22127a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2716), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public Sender(TincanDeviceIdHolder tincanDeviceIdHolder, Provider<String> provider, Provider<CryptoSessionStorage> provider2, Provider<CryptoEngine> provider3, ThriftUtil thriftUtil, SystemClock systemClock, TincanGatekeepers tincanGatekeepers, TincanOmnistoreRefresherByGatekeeper tincanOmnistoreRefresherByGatekeeper, Lazy<TincanDebugErrorReporter> lazy, FbSharedPreferences fbSharedPreferences) {
        this.f15494b = tincanDeviceIdHolder;
        this.f15495c = provider;
        this.f15496d = provider2;
        this.f15497e = provider3;
        this.f15498f = thriftUtil;
        this.f15499g = systemClock;
        this.f15500h = tincanGatekeepers;
        this.f15501i = tincanOmnistoreRefresherByGatekeeper;
        this.f15502j = lazy;
        this.f15503k = fbSharedPreferences;
        this.f15501i.m22130a((OmnistoreComponent) this);
    }

    public SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore) {
        if (!this.f15500h.m4519a()) {
            return SubscriptionInfo.IGNORED_INFO;
        }
        String str;
        if (this.f15503k.mo286a(TincanPrefKeys.b, false)) {
            str = "tincan_out_dev";
        } else {
            str = "tincan_out";
        }
        return SubscriptionInfo.forOpenSubscription(omnistore.createCollectionNameBuilder(str).addSegment((String) this.f15495c.get()).addSegment(this.f15494b.m22126a()).build());
    }

    public synchronized void onCollectionAvailable(Collection collection) {
        this.f15504l = collection;
    }

    public synchronized void onDeltasReceived(List<Delta> list) {
    }

    public IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer) {
        return new IndexedFields();
    }

    public synchronized void onCollectionInvalidated() {
        this.f15504l = null;
    }

    public final synchronized void m22117a(long j, byte[] bArr) {
        RequestPreKeyBundle a;
        long parseLong = Long.parseLong((String) this.f15495c.get());
        String a2 = this.f15494b.m22126a();
        SignalingCollectionAddress a3 = ThriftFactory.a(j);
        MessagingCollectionAddress a4 = ThriftFactory.a(parseLong, a2);
        String a5 = CryptoSessionIdFactory.a(j);
        CryptoSession a6 = ((MessengerCryptoSessionStorage) this.f15496d.get()).a(a5);
        if (a6 != null) {
            a = ((CryptoEngine) this.f15497e.get()).a(a6, (MessengerCryptoSessionStorage) this.f15496d.get());
        } else {
            a = ((CryptoEngine) this.f15497e.get()).a(a5, (MessengerCryptoSessionStorage) this.f15496d.get());
        }
        if (this.f15503k.mo286a(TincanPrefKeys.h, false)) {
            m22113a(a.identity_key);
            m22113a(a.pre_key);
            m22113a(a.signed_pre_key);
            m22113a(a.signed_pre_key_signature);
        } else if (this.f15503k.mo286a(TincanPrefKeys.i, false)) {
            a = new RequestPreKeyBundle(null, null, null, null);
        } else if (this.f15503k.mo286a(TincanPrefKeys.j, false)) {
            a = new RequestPreKeyBundle(KeyHelper.a().a().b(), a.pre_key, a.signed_pre_key, a.signed_pre_key_signature);
        }
        if (this.f15503k.mo286a(TincanPrefKeys.k, false)) {
            m22112a(a3, null, a4, 3, null, bArr, null);
        } else if (this.f15503k.mo286a(TincanPrefKeys.l, false)) {
            m22112a(a3, null, a4, 3, PacketBody.b(new byte[0]), bArr, null);
        } else {
            m22112a(a3, null, a4, 3, PacketBody.a(ThriftFactory.a(a)), bArr, null);
        }
    }

    public final synchronized void m22116a(long j, String str, long j2, String str2, byte[] bArr, byte[] bArr2) {
        MessagingCollectionAddress a = ThriftFactory.a(j, str);
        MessagingCollectionAddress a2 = ThriftFactory.a(j2, str2);
        if (this.f15503k.mo286a(TincanPrefKeys.d, false)) {
            m22113a(bArr);
        }
        byte[] a3 = CryptoEngine.a(((MessengerCryptoSessionStorage) this.f15496d.get()).a(CryptoSessionIdFactory.a(j2, str2)), bArr, (MessengerCryptoSessionStorage) this.f15496d.get());
        if (this.f15503k.mo286a(TincanPrefKeys.e, false)) {
            m22113a(a3);
        }
        m22112a(null, a2, a, 4, PacketBody.a(ThriftFactory.a(a3)), bArr2, this.f15505m);
    }

    @Nullable
    public final synchronized void m22121b(long j, String str, long j2, String str2, byte[] bArr, byte[] bArr2) {
        CryptoSession a = ((MessengerCryptoSessionStorage) this.f15496d.get()).a(CryptoSessionIdFactory.a(j2, str2));
        if (a == null) {
            BLog.b(f15492a, "No crypto session found for sending message content");
        } else {
            if (this.f15503k.mo286a(TincanPrefKeys.f, false)) {
                bArr = Arrays.copyOf(bArr, bArr.length);
                m22113a(bArr);
            } else if (this.f15503k.mo286a(TincanPrefKeys.g, false)) {
                bArr = new byte[0];
            }
            byte[] b = CryptoEngine.b(a, bArr, (MessengerCryptoSessionStorage) this.f15496d.get());
            if (this.f15503k.mo286a(TincanPrefKeys.m, false)) {
                m22113a(b);
            }
            m22112a(null, ThriftFactory.a(j2, str2), ThriftFactory.a(j, str), 2, PacketBody.a(b), bArr2, this.f15505m);
        }
    }

    public final synchronized void m22115a(long j, String str, long j2, String str2, long j3, byte[] bArr) {
        ReceiptPayload receiptPayload = new ReceiptPayload(Long.valueOf(j3));
        m22112a(null, ThriftFactory.a(j2, str2), ThriftFactory.a(j, str), 50, PacketBody.a(receiptPayload), bArr, null);
    }

    public final synchronized void m22120b(long j, String str, long j2, String str2, long j3, byte[] bArr) {
        ReceiptPayload receiptPayload = new ReceiptPayload(Long.valueOf(j3));
        m22112a(null, ThriftFactory.a(j2, str2), ThriftFactory.a(j, str), 51, PacketBody.a(receiptPayload), bArr, null);
    }

    public final synchronized void m22118a(MessagingCollectionAddress messagingCollectionAddress, int i, byte[] bArr, byte[] bArr2) {
        m22119a(messagingCollectionAddress, ThriftFactory.a(Long.parseLong((String) this.f15495c.get()), this.f15494b.m22126a()), i, bArr, bArr2);
    }

    public final synchronized void m22119a(@Nullable MessagingCollectionAddress messagingCollectionAddress, @Nullable MessagingCollectionAddress messagingCollectionAddress2, int i, byte[] bArr, byte[] bArr2) {
        m22112a(null, messagingCollectionAddress, messagingCollectionAddress2, i, PacketBody.b(bArr), bArr2, null);
    }

    private synchronized void m22112a(@Nullable SignalingCollectionAddress signalingCollectionAddress, @Nullable MessagingCollectionAddress messagingCollectionAddress, @Nullable MessagingCollectionAddress messagingCollectionAddress2, int i, PacketBody packetBody, byte[] bArr, @Nullable byte[] bArr2) {
        if (this.f15504l == null) {
            ((TincanDebugErrorReporter) this.f15502j.get()).a(f15492a, "No out collection subscribed to save to");
        } else {
            long a = this.f15499g.mo211a() * 1000;
            byte[] a2 = ThriftUtil.m21836a(ThriftFactory.a(signalingCollectionAddress, messagingCollectionAddress, messagingCollectionAddress2, a, i, packetBody, bArr, bArr2));
            try {
                this.f15504l.saveObject(m22111a(Long.valueOf(Long.parseLong((String) this.f15495c.get())), this.f15494b.m22126a(), a), Long.toString(a), a2);
            } catch (OmnistoreException e) {
                ((TincanDebugErrorReporter) this.f15502j.get()).a(f15492a, "Packet send via Omnistore failed", e);
            }
        }
    }

    private String m22111a(Long l, String str, long j) {
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.putLong(l.longValue());
        allocate.put(bytes);
        String encodeToString = Base64.encodeToString(this.f15498f.m21838a(allocate.array()), 11);
        return StringFormatUtil.a("%d@%s", new Object[]{Long.valueOf(j), encodeToString});
    }

    private static void m22113a(byte[] bArr) {
        if (bArr.length >= 2) {
            int length = bArr.length - 1;
            int i = 0;
            while (i < bArr.length / 2) {
                byte b = bArr[i];
                bArr[i] = bArr[i + length];
                bArr[i + length] = b;
                i++;
                length -= 2;
            }
        }
    }
}
