package com.facebook.messengerwear.support;

import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messengerwear.shared.MessengerWearConstants.AssetType;
import com.facebook.messengerwear.shared.MessengerWearConstants.WearDataApiPath;
import com.facebook.messengerwear.support.MessengerWearMediaAssets.C06841;
import com.facebook.messengerwear.support.MessengerWearMediaAssets.C06852;
import com.facebook.messengerwear.support.MessengerWearMediaFetcher.MediaData;
import com.facebook.messengerwear.support.graphql.MessengerWearStickersGraphQLModels.FetchRecentlyUsedStickersQueryModel;
import com.facebook.messengerwear.support.graphql.MessengerWearStickersGraphQLModels.FetchRecentlyUsedStickersQueryModel.RecentlyUsedStickersModel.EdgesModel;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ultralight.Inject;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_load_full_image_view */
public class MessengerWearMediaManager {
    public static final Class f5058a = MessengerWearMediaManager.class;
    private static volatile MessengerWearMediaManager f5059g;
    @Inject
    public MessengerWearMediaFetcher f5060b;
    @Inject
    public MessengerWearMediaAssets f5061c;
    @BackgroundExecutorService
    @Inject
    public ExecutorService f5062d;
    @Inject
    public GraphQLQueryExecutor f5063e;
    @Inject
    private WearableGoogleApiClientFactory f5064f;

    /* compiled from: photo_load_full_image_view */
    public class C06951 implements FutureCallback<GraphQLResult<FetchRecentlyUsedStickersQueryModel>> {
        final /* synthetic */ MessengerWearMediaManager f5046a;

        /* compiled from: photo_load_full_image_view */
        class C06941 implements FutureCallback<List<FetchResult>> {
            final /* synthetic */ C06951 f5045a;

            C06941(C06951 c06951) {
                this.f5045a = c06951;
            }

            public void onSuccess(@Nullable Object obj) {
                List list = (List) obj;
                if (list == null) {
                    BLog.a(MessengerWearMediaManager.f5058a, "Unable to retrieve assets");
                } else {
                    MessengerWearMediaManager.m4555b(this.f5045a.f5046a, list);
                }
            }

            public void onFailure(Throwable th) {
                BLog.a(MessengerWearMediaManager.f5058a, "Unable to retrieve assets", th);
            }
        }

        public C06951(MessengerWearMediaManager messengerWearMediaManager) {
            this.f5046a = messengerWearMediaManager;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FetchRecentlyUsedStickersQueryModel) graphQLResult.e).m4607a() == null) {
                BLog.a(MessengerWearMediaManager.f5058a, "updateRecentlyUsedStickers: couldn't retrieve user stickers");
                return;
            }
            ImmutableList a = ((FetchRecentlyUsedStickersQueryModel) graphQLResult.e).m4607a().m4603a();
            int size = a.size();
            if (size == 0) {
                BLog.a(MessengerWearMediaManager.f5058a, "updateRecentlyUsedStickers: no sticker retrieved");
                return;
            }
            UnmodifiableIterator it = a.iterator();
            List arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(FetchRequest.m4551a(((EdgesModel) it.next()).m4599a().m4595j()));
            }
            Arrays.toString(arrayList.toArray(new FetchRequest[size]));
            Futures.a(this.f5046a.m4556a(arrayList), new C06941(this), this.f5046a.f5062d);
        }

        public void onFailure(Throwable th) {
            BLog.b(MessengerWearMediaManager.f5058a, "Unable to retrieve MRU sticker ids", th);
        }
    }

    /* compiled from: photo_load_full_image_view */
    public class FetchRequest {
        public final ImageAttachmentData f5052a;
        public final String f5053b;
        public final AssetType f5054c;

        public FetchRequest(ImageAttachmentData imageAttachmentData, String str, AssetType assetType) {
            this.f5052a = imageAttachmentData;
            this.f5053b = str;
            this.f5054c = assetType;
        }

        public static FetchRequest m4551a(String str) {
            return new FetchRequest(null, str, AssetType.STICKER);
        }

        public String toString() {
            return "FetchRequest{type=" + this.f5054c + ", id='" + this.f5053b + '\'' + '}';
        }
    }

    /* compiled from: photo_load_full_image_view */
    public class FetchResult {
        public final String f5055a;
        public final Asset[] f5056b;
        public final AssetType f5057c;

        public FetchResult(String str, Asset[] assetArr, AssetType assetType) {
            this.f5055a = str;
            this.f5056b = assetArr;
            this.f5057c = assetType;
        }
    }

    public static com.facebook.messengerwear.support.MessengerWearMediaManager m4552a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5059g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messengerwear.support.MessengerWearMediaManager.class;
        monitor-enter(r1);
        r0 = f5059g;	 Catch:{ all -> 0x003a }
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
        r0 = m4554b(r0);	 Catch:{ all -> 0x0035 }
        f5059g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5059g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messengerwear.support.MessengerWearMediaManager.a(com.facebook.inject.InjectorLike):com.facebook.messengerwear.support.MessengerWearMediaManager");
    }

    private static MessengerWearMediaManager m4554b(InjectorLike injectorLike) {
        MessengerWearMediaManager messengerWearMediaManager = new MessengerWearMediaManager();
        MessengerWearMediaFetcher b = MessengerWearMediaFetcher.m4548b(injectorLike);
        MessengerWearMediaAssets messengerWearMediaAssets = new MessengerWearMediaAssets();
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike);
        WearableGoogleApiClientFactory a = WearableGoogleApiClientFactory.m4583a(injectorLike);
        messengerWearMediaAssets.f5015b = (Clock) SystemClockMethodAutoProvider.a(injectorLike);
        messengerWearMediaAssets.f5016c = executorService;
        messengerWearMediaAssets.f5017d = a;
        messengerWearMediaManager.m4553a(b, messengerWearMediaAssets, (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), WearableGoogleApiClientFactory.m4583a(injectorLike));
        return messengerWearMediaManager;
    }

    private void m4553a(MessengerWearMediaFetcher messengerWearMediaFetcher, MessengerWearMediaAssets messengerWearMediaAssets, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, WearableGoogleApiClientFactory wearableGoogleApiClientFactory) {
        this.f5060b = messengerWearMediaFetcher;
        this.f5061c = messengerWearMediaAssets;
        this.f5062d = executorService;
        this.f5063e = graphQLQueryExecutor;
        this.f5064f = wearableGoogleApiClientFactory;
    }

    public static void m4555b(MessengerWearMediaManager messengerWearMediaManager, List list) {
        PutDataMapRequest a = PutDataMapRequest.m13277a(WearDataApiPath.m4495a());
        DataMap b = a.m13279b();
        int size = list.size();
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            FetchResult fetchResult = (FetchResult) list.get(i);
            Asset[] assetArr = fetchResult.f5056b;
            int i3 = i2;
            i2 = 0;
            while (i2 < assetArr.length) {
                b.m13257a("frame_" + i3, assetArr[i2]);
                i2++;
                i3++;
            }
            strArr[i] = fetchResult.f5055a;
            i++;
            i2 = i3;
        }
        b.m13261a("sticker_ids", strArr);
        Arrays.toString(strArr);
        PutDataRequest c = a.m13280c();
        c.m13289g();
        GoogleApiClient a2 = messengerWearMediaManager.f5064f.m4585a();
        try {
            if (a2.d().b()) {
                if (!((DataItemResult) Wearable.f13157a.mo674a(a2, c).a()).cp_().e()) {
                    BLog.a(f5058a, "updateRecentlyUsedStickerDataItem: putDataItem() failure");
                }
                a2.e();
                return;
            }
            BLog.b(f5058a, "Connection to Google API failed");
        } catch (Throwable e) {
            BLog.b(f5058a, "updateRecentlyUsedStickerDataItem", e);
        } finally {
            a2.e();
        }
    }

    public final ListenableFuture<List<FetchResult>> m4556a(List<FetchRequest> list) {
        Integer.valueOf(list.size());
        Iterable arrayList = new ArrayList();
        for (final FetchRequest fetchRequest : list) {
            final SettableFuture f = SettableFuture.f();
            arrayList.add(f);
            MessengerWearMediaAssets messengerWearMediaAssets = this.f5061c;
            SettableFuture f2 = SettableFuture.f();
            ExecutorDetour.a(messengerWearMediaAssets.f5016c, new C06841(messengerWearMediaAssets, fetchRequest, f2), -935137608);
            Futures.a(f2, new FutureCallback<Asset[]>(this) {
                final /* synthetic */ MessengerWearMediaManager f5051c;

                /* compiled from: photo_load_full_image_view */
                class C06971 implements FutureCallback<MediaData> {
                    final /* synthetic */ C06982 f5048a;

                    /* compiled from: photo_load_full_image_view */
                    class C06961 implements FutureCallback<Asset[]> {
                        final /* synthetic */ C06971 f5047a;

                        C06961(C06971 c06971) {
                            this.f5047a = c06971;
                        }

                        public void onSuccess(@Nullable Object obj) {
                            FutureDetour.a(f, new FetchResult(fetchRequest.f5053b, (Asset[]) obj, AssetType.STICKER), 1024999427);
                        }

                        public void onFailure(Throwable th) {
                            f.a(th);
                        }
                    }

                    C06971(C06982 c06982) {
                        this.f5048a = c06982;
                    }

                    public void onSuccess(@Nullable Object obj) {
                        MediaData mediaData = (MediaData) obj;
                        if (mediaData == null) {
                            FutureDetour.a(f, null, -172070687);
                            return;
                        }
                        MessengerWearMediaAssets messengerWearMediaAssets = this.f5048a.f5051c.f5061c;
                        AssetType assetType = fetchRequest.f5054c;
                        SettableFuture f = SettableFuture.f();
                        ExecutorDetour.a(messengerWearMediaAssets.f5016c, new C06852(messengerWearMediaAssets, mediaData, assetType, f), -1845147029);
                        Futures.a(f, new C06961(this), this.f5048a.f5051c.f5062d);
                    }

                    public void onFailure(Throwable th) {
                        BLog.b(MessengerWearMediaManager.f5058a, "Media Data fetch failed", th);
                        f.a(th);
                    }
                }

                public void onSuccess(@Nullable Object obj) {
                    Asset[] assetArr = (Asset[]) obj;
                    Boolean.valueOf(assetArr != null);
                    if (assetArr != null) {
                        FutureDetour.a(f, new FetchResult(fetchRequest.f5053b, assetArr, fetchRequest.f5054c), -427732119);
                        return;
                    }
                    try {
                        ListenableFuture a;
                        if (fetchRequest.f5054c == AssetType.STICKER) {
                            a = this.f5051c.f5060b.m4550a(fetchRequest.f5053b);
                        } else {
                            a = this.f5051c.f5060b.m4549a(fetchRequest.f5052a);
                        }
                        Futures.a(a, new C06971(this), this.f5051c.f5062d);
                    } catch (Throwable e) {
                        f.a(e);
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b(MessengerWearMediaManager.f5058a, "Media Data check in Cache failed with error", th);
                    f.a(th);
                }
            }, this.f5062d);
        }
        return Futures.a(arrayList);
    }
}
