package com.facebook.messengerwear.support;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.support.v4.util.ArrayMap;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messengerwear.shared.Message;
import com.facebook.messengerwear.shared.MessengerWearConstants.AssetType;
import com.facebook.messengerwear.shared.MessengerWearConstants.WearDataApiPath;
import com.facebook.messengerwear.shared.MessengerWearCrypto;
import com.facebook.messengerwear.shared.MessengerWearThreadNotification;
import com.facebook.messengerwear.support.MessengerWearMediaManager.FetchRequest;
import com.facebook.messengerwear.support.MessengerWearMediaManager.FetchResult;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(18)
/* compiled from: photo_save_photo_view */
public class MessengerWearDispatcher {
    public static final Class f4999a = MessengerWearDispatcher.class;
    private static volatile MessengerWearDispatcher f5000g;
    public final ExecutorService f5001b;
    private final MessengerWearMediaManager f5002c;
    public final GoogleApiClient f5003d;
    public final Clock f5004e;
    public Map<String, Long> f5005f = Collections.synchronizedMap(new ArrayMap());

    /* compiled from: photo_save_photo_view */
    class WearNotificationDispatchRunnable implements Runnable {
        final /* synthetic */ MessengerWearDispatcher f4995a;
        private final MessengerWearThreadNotification f4996b;
        private final byte[] f4997c;
        @Nullable
        private final List<FetchResult> f4998d;

        WearNotificationDispatchRunnable(MessengerWearDispatcher messengerWearDispatcher, MessengerWearThreadNotification messengerWearThreadNotification, byte[] bArr, List<FetchResult> list) {
            this.f4995a = messengerWearDispatcher;
            this.f4996b = messengerWearThreadNotification;
            this.f4997c = bArr;
            this.f4998d = list;
        }

        WearNotificationDispatchRunnable(MessengerWearDispatcher messengerWearDispatcher, MessengerWearThreadNotification messengerWearThreadNotification, byte[] bArr) {
            this(messengerWearDispatcher, messengerWearThreadNotification, bArr, null);
        }

        public void run() {
            if (this.f4995a.f5003d.a(30, TimeUnit.SECONDS).b()) {
                try {
                    PutDataMapRequest a = PutDataMapRequest.m13277a(WearDataApiPath.m4496a(MessengerWearCrypto.m4503a(this.f4996b.f4973a)));
                    DataMap b = a.m13279b();
                    Parcel obtain = Parcel.obtain();
                    this.f4996b.writeToParcel(obtain, 0);
                    b.m13259a("thread_data_obj", MessengerWearCrypto.m4505a(obtain.marshall()));
                    if (this.f4997c != null) {
                        b.m13257a("thread_picture", Asset.m13226a(MessengerWearCrypto.m4505a(this.f4997c)));
                    }
                    if (this.f4998d != null) {
                        int i = 0;
                        for (FetchResult fetchResult : this.f4998d) {
                            int length = fetchResult.f5056b.length;
                            int i2 = 0;
                            while (i2 < length) {
                                int i3 = i + 1;
                                b.m13257a("asset_" + i, fetchResult.f5056b[i2]);
                                i2++;
                                i = i3;
                            }
                        }
                    }
                    b.m13256a("ts", this.f4995a.f5004e.a());
                    PutDataRequest c = a.m13280c();
                    c.m13289g();
                    if (!((DataItemResult) Wearable.f13157a.mo674a(this.f4995a.f5003d, c).a(30, TimeUnit.SECONDS)).cp_().e()) {
                        BLog.b(MessengerWearDispatcher.f4999a, "Failed to set DataItem: %d - %s", new Object[]{Integer.valueOf(((DataItemResult) Wearable.f13157a.mo674a(this.f4995a.f5003d, c).a(30, TimeUnit.SECONDS)).cp_().f()), ((DataItemResult) Wearable.f13157a.mo674a(this.f4995a.f5003d, c).a(30, TimeUnit.SECONDS)).cp_().c()});
                    }
                    this.f4995a.f5003d.e();
                    return;
                } catch (Throwable e) {
                    BLog.b(MessengerWearDispatcher.f4999a, "Unable to encrypt notification", e);
                    this.f4995a.f5003d.e();
                    return;
                }
            }
            BLog.b(MessengerWearDispatcher.f4999a, "Unable to connection to Google Api: %d - %s", new Object[]{Integer.valueOf(this.f4995a.f5003d.a(30, TimeUnit.SECONDS).c()), this.f4995a.f5003d.a(30, TimeUnit.SECONDS).e()});
        }
    }

    public static com.facebook.messengerwear.support.MessengerWearDispatcher m4537a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5000g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messengerwear.support.MessengerWearDispatcher.class;
        monitor-enter(r1);
        r0 = f5000g;	 Catch:{ all -> 0x003a }
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
        r0 = m4538b(r0);	 Catch:{ all -> 0x0035 }
        f5000g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5000g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messengerwear.support.MessengerWearDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.messengerwear.support.MessengerWearDispatcher");
    }

    private static MessengerWearDispatcher m4538b(InjectorLike injectorLike) {
        return new MessengerWearDispatcher((ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), MessengerWearMediaManager.m4552a(injectorLike), WearableGoogleApiClientFactory.m4583a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessengerWearDispatcher(ExecutorService executorService, MessengerWearMediaManager messengerWearMediaManager, WearableGoogleApiClientFactory wearableGoogleApiClientFactory, Clock clock) {
        this.f5004e = clock;
        this.f5003d = wearableGoogleApiClientFactory.m4585a();
        this.f5001b = executorService;
        this.f5002c = messengerWearMediaManager;
    }

    public final void m4539a(final MessengerWearThreadNotification messengerWearThreadNotification, final byte[] bArr, ImmutableList<ImageAttachmentData> immutableList) {
        Object obj;
        this.f5005f.put(messengerWearThreadNotification.f4973a, Long.valueOf(messengerWearThreadNotification.f4976d.f4955a));
        Iterator it = messengerWearThreadNotification.f4977e.iterator();
        while (it.hasNext()) {
            if (((Message) it.next()).m4494a()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null && immutableList.isEmpty()) {
            ExecutorDetour.a(this.f5001b, new WearNotificationDispatchRunnable(this, messengerWearThreadNotification, bArr), -1466905097);
            return;
        }
        List arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        Iterator it2 = messengerWearThreadNotification.f4977e.iterator();
        while (it2.hasNext()) {
            Message message = (Message) it2.next();
            if (message.m4494a()) {
                hashSet.add(message.f4959e);
            }
        }
        for (String a : ImmutableList.copyOf(hashSet)) {
            arrayList.add(FetchRequest.m4551a(a));
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ImageAttachmentData imageAttachmentData = (ImageAttachmentData) immutableList.get(i);
            arrayList.add(new FetchRequest(imageAttachmentData, imageAttachmentData.e, AssetType.IMAGE));
        }
        Futures.a(this.f5002c.m4556a(arrayList), new FutureCallback<List<FetchResult>>(this) {
            final /* synthetic */ MessengerWearDispatcher f4994c;

            public void onSuccess(@Nullable Object obj) {
                List list = (List) obj;
                if (messengerWearThreadNotification.f4976d.f4955a <= ((Long) this.f4994c.f5005f.get(messengerWearThreadNotification.f4973a)).longValue()) {
                    ExecutorDetour.a(this.f4994c.f5001b, new WearNotificationDispatchRunnable(this.f4994c, messengerWearThreadNotification, bArr, list), 95908236);
                }
            }

            public void onFailure(Throwable th) {
                BLog.b(MessengerWearDispatcher.f4999a, "Exception occured processing the media fetch", th);
            }
        }, this.f5001b);
    }
}
