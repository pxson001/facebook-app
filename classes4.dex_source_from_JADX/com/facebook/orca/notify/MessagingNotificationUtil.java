package com.facebook.orca.notify;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.ListDataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.notify.NewMessageNotification.MessengerUserStatus;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: set_contact_logs_upload_setting_param_key */
public class MessagingNotificationUtil {
    private static final CallerContext f2379a = CallerContext.a(MessagingNotificationUtil.class, "notifications");
    private static volatile MessagingNotificationUtil f2380s;
    public final Context f2381b;
    public final Resources f2382c;
    public final Provider<DataCache> f2383d;
    private final UserTileViewLogic f2384e;
    private final DefaultBlueServiceOperationFactory f2385f;
    private final Provider<ThreadParticipantUtils> f2386g;
    private final Provider<MessengerThreadTileViewDataFactory> f2387h;
    private final AttachmentDataFactory f2388i;
    public final Provider<Boolean> f2389j;
    private final PlatformBitmapFactory f2390k;
    private ImagePipeline f2391l;
    public final MessagingPerformanceLogger f2392m;
    private final Random f2393n = new Random();
    private final ResourceReleaser<Bitmap> f2394o = SimpleBitmapReleaser.m2682a();
    private final Provider<MessengerThreadNameViewDataFactory> f2395p;
    private final I18nJoiner f2396q;
    private final Provider<Boolean> f2397r;

    public static com.facebook.orca.notify.MessagingNotificationUtil m2639a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2380s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.MessagingNotificationUtil.class;
        monitor-enter(r1);
        r0 = f2380s;	 Catch:{ all -> 0x003a }
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
        r0 = m2649b(r0);	 Catch:{ all -> 0x0035 }
        f2380s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2380s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.MessagingNotificationUtil.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.MessagingNotificationUtil");
    }

    private static MessagingNotificationUtil m2649b(InjectorLike injectorLike) {
        return new MessagingNotificationUtil((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 2567), UserTileViewLogic.m2670a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 7706), IdBasedProvider.a(injectorLike, 8293), AttachmentDataFactory.a(injectorLike), IdBasedProvider.a(injectorLike, 4050), MessagingPerformanceLogger.m9038a(injectorLike), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 8584), I18nJoiner.m2675b(injectorLike), IdBasedProvider.a(injectorLike, 4073));
    }

    @Inject
    public MessagingNotificationUtil(Context context, Provider<DataCache> provider, UserTileViewLogic userTileViewLogic, ImagePipeline imagePipeline, BlueServiceOperationFactory blueServiceOperationFactory, Provider<ThreadParticipantUtils> provider2, Provider<MessengerThreadTileViewDataFactory> provider3, AttachmentDataFactory attachmentDataFactory, Provider<Boolean> provider4, MessagingPerformanceLogger messagingPerformanceLogger, PlatformBitmapFactory platformBitmapFactory, Provider<MessengerThreadNameViewDataFactory> provider5, I18nJoiner i18nJoiner, Provider<Boolean> provider6) {
        this.f2381b = context;
        this.f2385f = blueServiceOperationFactory;
        this.f2382c = context.getResources();
        this.f2383d = provider;
        this.f2384e = userTileViewLogic;
        this.f2391l = imagePipeline;
        this.f2386g = provider2;
        this.f2387h = provider3;
        this.f2388i = attachmentDataFactory;
        this.f2389j = provider4;
        this.f2390k = platformBitmapFactory;
        this.f2392m = messagingPerformanceLogger;
        this.f2395p = provider5;
        this.f2396q = i18nJoiner;
        this.f2397r = provider6;
    }

    @Nullable
    public final DataSource<CloseableReference<CloseableImage>> m2652a(ParticipantInfo participantInfo) {
        return m2638a(participantInfo, false, null);
    }

    private int m2633a() {
        return this.f2382c.getDimensionPixelSize(17104901);
    }

    private int m2647b() {
        return this.f2382c.getDimensionPixelSize(17104902);
    }

    @Nullable
    private DataSource<CloseableReference<CloseableImage>> m2638a(@Nullable ParticipantInfo participantInfo, boolean z, @Nullable BitmapCallback bitmapCallback) {
        DataSource<CloseableReference<CloseableImage>> dataSource = null;
        if (participantInfo != null && participantInfo.a()) {
            UserKey userKey = participantInfo.b;
            int b = m2647b();
            int a = m2633a();
            dataSource = m2637a(this.f2384e.m2674a(UserTileViewParams.m6209a(userKey), a, b), a, b, z, null);
            if (bitmapCallback != null && dataSource != null) {
                dataSource.a(m2636a(bitmapCallback), MoreExecutors.a());
            } else if (bitmapCallback != null) {
                bitmapCallback.a();
            }
        }
        return dataSource;
    }

    public final void m2658a(NewMessageNotification newMessageNotification, BitmapCallback bitmapCallback) {
        Object obj;
        ThreadKey threadKey = newMessageNotification.d;
        ParticipantInfo b = m2659b(newMessageNotification.c);
        Bitmap bitmap = null;
        MessengerUserStatus messengerUserStatus = newMessageNotification.k;
        if (((Boolean) this.f2389j.get()).booleanValue() && newMessageNotification.c.b.a == Type.ONE_TO_ONE && (messengerUserStatus == MessengerUserStatus.IS_MESSENGER_USER || messengerUserStatus == MessengerUserStatus.IS_NOT_MESSENGER_USER)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            bitmap = BitmapFactory.decodeResource(this.f2382c, newMessageNotification.k == MessengerUserStatus.IS_MESSENGER_USER ? 2130842117 : 2130842015);
        }
        m2656a(threadKey, bitmapCallback, b, bitmap);
    }

    public final void m2656a(ThreadKey threadKey, BitmapCallback bitmapCallback, ParticipantInfo participantInfo, @Nullable Bitmap bitmap) {
        if (ThreadKey.g(threadKey)) {
            bitmapCallback.a();
            return;
        }
        ThreadSummary a = m2654a(threadKey);
        if (a == null) {
            m2638a(participantInfo, true, bitmapCallback);
            return;
        }
        ThreadTileViewData a2 = ((MessengerThreadTileViewDataFactory) this.f2387h.get()).a(a);
        List b = Lists.b(a2.a());
        if (a2.e() != null) {
            b.add(a2.e());
            m2644a(bitmap, b, bitmapCallback);
        } else if (a2.a() == 1) {
            m2640a(m2647b(), m2633a(), bitmapCallback, bitmap, a2);
        } else {
            m2645a(bitmapCallback, m2647b(), m2633a(), a2);
        }
    }

    private void m2644a(@Nullable Bitmap bitmap, List<Bitmap> list, BitmapCallback bitmapCallback) {
        Bitmap bitmap2;
        int a = m2633a();
        if (list.isEmpty()) {
            bitmap2 = null;
        } else if (list.size() == 1) {
            bitmap2 = m2634a((Bitmap) list.get(0), bitmap, a);
        } else {
            boolean z = true;
            if (list.size() <= 1 || list.size() >= 4) {
                z = false;
            }
            Preconditions.checkArgument(z);
            Bitmap createBitmap = Bitmap.createBitmap(a, a, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int a2 = SizeUtil.a(this.f2381b, 1.0f);
            int i = (int) (((float) (a - a2)) * 0.5f);
            m2642a(a, (List) list, canvas, i);
            if (list.size() == 2) {
                m2650b(a, list, canvas, a2, i);
            } else {
                m2643a(a, (List) list, canvas, a2, i);
            }
            bitmap2 = createBitmap;
        }
        CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(bitmap2, this.f2394o, ImmutableQualityInfo.a, 0);
        Preconditions.checkNotNull(closeableStaticBitmap);
        bitmapCallback.a(CloseableReference.a(closeableStaticBitmap));
    }

    public final void m2657a(NewMessageNotification newMessageNotification) {
        Message message = newMessageNotification.c;
        ThreadSummary a = m2654a(message.b);
        if (a == null) {
            m2638a(m2659b(message), true, null);
            return;
        }
        ThreadTileViewData a2 = ((MessengerThreadTileViewDataFactory) this.f2387h.get()).a(a);
        if (a2.a() != 1) {
            m2641a(0, 0, a2);
        } else if (a2.e() == null) {
            m2637a(a2.a(0, 0, 0), 0, 0, true, null);
        }
    }

    private void m2641a(int i, int i2, ThreadTileViewData threadTileViewData) {
        for (int i3 = 0; i3 < threadTileViewData.a(); i3++) {
            m2637a(threadTileViewData.a(i3, i2, i), i2, i, true, null);
        }
    }

    private void m2645a(BitmapCallback bitmapCallback, int i, int i2, ThreadTileViewData threadTileViewData) {
        DataSource[] dataSourceArr = new DataSource[threadTileViewData.a()];
        for (int i3 = 0; i3 < threadTileViewData.a(); i3++) {
            DataSource a = m2637a(threadTileViewData.a(i3, i2, i), i2, i, false, null);
            if (a != null) {
                dataSourceArr[i3] = a;
            }
        }
        ListDataSource.a(dataSourceArr).a(new 2(this, bitmapCallback, i2), MoreExecutors.a());
    }

    private void m2640a(int i, int i2, BitmapCallback bitmapCallback, @Nullable Bitmap bitmap, ThreadTileViewData threadTileViewData) {
        Postprocessor postprocessor = null;
        if (bitmap != null) {
            postprocessor = new 1(this, bitmap, i2);
        }
        DataSource a = m2637a(threadTileViewData.a(0, i2, i), i2, i, false, postprocessor);
        if (a != null) {
            a.a(m2636a(bitmapCallback), MoreExecutors.a());
        } else {
            bitmapCallback.a();
        }
    }

    private BaseDataSubscriber<CloseableReference<CloseableImage>> m2636a(BitmapCallback bitmapCallback) {
        return new 3(this, bitmapCallback);
    }

    @Nullable
    public final DataSource<CloseableReference<CloseableImage>> m2651a(Message message) {
        ImmutableList f = this.f2388i.f(message);
        if (f == null || f.isEmpty()) {
            return null;
        }
        return this.f2391l.c(ImageRequestBuilder.a(((ImageAttachmentData) f.get(0)).a.a).m(), f2379a);
    }

    @Nullable
    private DataSource<CloseableReference<CloseableImage>> m2637a(ImageRequest imageRequest, int i, int i2, boolean z, @Nullable Postprocessor postprocessor) {
        if (imageRequest == null) {
            return null;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(imageRequest);
        if (postprocessor == null) {
            a.j = new ScalingPostprocessor(Math.max(i2, i));
        } else {
            a.j = postprocessor;
        }
        ImageRequest m = a.m();
        if (!z) {
            return this.f2391l.c(m, f2379a);
        }
        this.f2391l.f(m, f2379a);
        return null;
    }

    @Nullable
    public final MessagesCollection m2653a(ThreadKey threadKey, int i) {
        int nextInt = this.f2393n.nextInt();
        this.f2392m.m9057b(nextInt, "MessagingNotificationUtil.tryToGetThreadMessagesCollection");
        Bundle bundle = new Bundle();
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.a = ThreadCriteria.a(threadKey);
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.b = DataFreshnessParam.DO_NOT_CHECK_SERVER;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        if (i <= 20) {
            i = 20;
        }
        fetchThreadParamsBuilder.f = i;
        bundle.putParcelable("fetchThreadParams", fetchThreadParamsBuilder.i());
        bundle.putInt("logger_instance_key", nextInt);
        OperationFuture c = BlueServiceOperationFactoryDetour.a(this.f2385f, "fetch_thread", bundle, CallerContext.a(MessagingNotificationUtil.class), -956987263).c();
        Futures.a(c, new 4(this, nextInt));
        OperationResult operationResult = (OperationResult) FutureUtils.a(c);
        if (operationResult == null) {
            return null;
        }
        return ((FetchThreadResult) operationResult.k()).d;
    }

    @Nullable
    public final ParticipantInfo m2659b(@Nonnull Message message) {
        this.f2386g.get();
        ThreadSummary a = m2654a(message.b);
        ParticipantInfo participantInfo = message.e;
        if (a != null) {
            ParticipantInfo a2 = ThreadParticipantUtils.a(a.h, participantInfo.b);
            if (a2 != null) {
                participantInfo = a2;
            } else {
                a2 = ThreadParticipantUtils.a(a.j, participantInfo.b);
                if (a2 != null) {
                    participantInfo = a2;
                }
            }
        }
        return participantInfo;
    }

    @Nullable
    public final ThreadSummary m2654a(ThreadKey threadKey) {
        int nextInt = this.f2393n.nextInt();
        this.f2392m.m9057b(nextInt, "MessagingNotificationUtil.tryToGetThreadSummary");
        Bundle bundle = new Bundle();
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.a = ThreadCriteria.a(threadKey);
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.b = DataFreshnessParam.DO_NOT_CHECK_SERVER;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.f = 0;
        bundle.putParcelable("fetchThreadParams", fetchThreadParamsBuilder.i());
        bundle.putInt("logger_instance_key", nextInt);
        OperationResult operationResult = (OperationResult) FutureUtils.a(BlueServiceOperationFactoryDetour.a(this.f2385f, "fetch_thread", bundle, CallerContext.a(MessagingNotificationUtil.class), 1002904331).c());
        if (operationResult == null) {
            return null;
        }
        return ((FetchThreadResult) operationResult.k()).c;
    }

    private Bitmap m2634a(Bitmap bitmap, @Nullable Bitmap bitmap2, int i) {
        if (bitmap2 == null) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        m2646a(this, bitmap, bitmap2, createBitmap, i);
        return createBitmap;
    }

    public static void m2646a(MessagingNotificationUtil messagingNotificationUtil, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i) {
        Canvas canvas = new Canvas(bitmap3);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        int a = SizeUtil.a(messagingNotificationUtil.f2381b, 2.0f);
        canvas.drawBitmap(bitmap2, null, new Rect((i - bitmap2.getWidth()) - a, (i - bitmap2.getHeight()) - a, i - a, i - a), null);
    }

    @Nullable
    public static CloseableReference m2648b(MessagingNotificationUtil messagingNotificationUtil, List list, int i) {
        List arrayList = new ArrayList();
        for (CloseableReference closeableReference : list) {
            if (closeableReference != null && (closeableReference.a() instanceof CloseableBitmap)) {
                arrayList.add(((CloseableBitmap) closeableReference.a()).a());
            }
        }
        boolean z = arrayList.size() > 1 && arrayList.size() < 4;
        Preconditions.checkArgument(z);
        CloseableReference closeableReference2 = messagingNotificationUtil.f2390k.a(i, i);
        if (closeableReference2 == null) {
            return null;
        }
        CloseableReference a = CloseableReference.a(new CloseableStaticBitmap(closeableReference2, ImmutableQualityInfo.a, 0));
        Canvas canvas = new Canvas((Bitmap) closeableReference2.a());
        int a2 = SizeUtil.a(messagingNotificationUtil.f2381b, 1.0f);
        int i2 = (int) (((float) (i - a2)) * 0.5f);
        m2642a(i, arrayList, canvas, i2);
        if (arrayList.size() == 2) {
            m2650b(i, arrayList, canvas, a2, i2);
        } else {
            m2643a(i, arrayList, canvas, a2, i2);
        }
        return a;
    }

    public static void m2643a(int i, List<Bitmap> list, Canvas canvas, int i2, int i3) {
        int i4 = (i - i2) / 2;
        canvas.drawBitmap((Bitmap) list.get(1), null, new Rect(i3 + i2, 0, i, i4), null);
        canvas.drawBitmap((Bitmap) list.get(2), null, new Rect(i3 + i2, i4 + i2, i, i), null);
    }

    public static void m2650b(int i, List<Bitmap> list, Canvas canvas, int i2, int i3) {
        Rect rect = new Rect(i3 + i2, 0, i, i);
        canvas.drawBitmap((Bitmap) list.get(1), m2635a(i), rect, null);
    }

    public static void m2642a(int i, List<Bitmap> list, Canvas canvas, int i2) {
        Rect rect = new Rect(0, 0, i2, i);
        canvas.drawBitmap((Bitmap) list.get(0), m2635a(i), rect, null);
    }

    private static Rect m2635a(int i) {
        return new Rect((i - ((int) (((float) i) * 0.5f))) / 2, 0, (((int) (((float) i) * 0.5f)) + i) / 2, i);
    }

    public final String m2655a(Message message, @Nullable ThreadSummary threadSummary) {
        if (ThreadKey.g(message.b)) {
            return this.f2382c.getString(2131232385);
        }
        String string;
        String str;
        ParticipantInfo b = m2659b(message);
        if (b == null || StringUtil.a(b.c)) {
            string = this.f2382c.getString(2131230720);
        } else {
            string = ((DataCache) this.f2383d.get()).m10353a(message.b, b);
        }
        String str2 = string;
        if (message.b.a == Type.GROUP) {
            MessengerThreadNameViewData a = ((MessengerThreadNameViewDataFactory) this.f2395p.get()).a(threadSummary);
            if (a == null) {
                return str2;
            }
            if (a.a) {
                str = a.b;
            } else if (!a.c.isEmpty()) {
                str = this.f2396q.m2679a(a.c);
            }
            return str;
        }
        str = str2;
        return str;
    }
}
