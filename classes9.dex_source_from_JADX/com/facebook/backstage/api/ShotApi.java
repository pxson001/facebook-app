package com.facebook.backstage.api;

import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.data.UploadShot;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.base.media.MediaItemFactory.VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.photos.upload.protocol.UploadPhotoMethod;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoParams.Builder;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.uploaders.VideoUploader;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: seen_by_users */
public class ShotApi {
    public static final String f4273a = ShotApi.class.getSimpleName();
    private static volatile ShotApi f4274j;
    public final ExecutorService f4275b;
    private final ApiMethodRunnerImpl f4276c;
    private final Provider<String> f4277d;
    private final ShotCreateMethod f4278e;
    private final UploadPhotoMethod f4279f;
    private final VideoUploader f4280g;
    private final UploadOperationFactory f4281h;
    public final BackstageAnalyticsLogger f4282i;

    /* compiled from: seen_by_users */
    public class C03871 implements Runnable {
        final /* synthetic */ UploadShot f4270a;
        final /* synthetic */ SettableFuture f4271b;
        final /* synthetic */ ShotApi f4272c;

        public C03871(ShotApi shotApi, UploadShot uploadShot, SettableFuture settableFuture) {
            this.f4272c = shotApi;
            this.f4270a = uploadShot;
            this.f4271b = settableFuture;
        }

        public void run() {
            try {
                ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
                apiMethodRunnerParams.a(RequestPriority.NON_INTERACTIVE);
                String a = ShotApi.m4273a(this.f4272c, this.f4270a.m4920a(), this.f4270a.m4922c(), apiMethodRunnerParams);
                ShotApi.f4273a;
                FutureDetour.a(this.f4271b, this.f4272c.m4271a(a, this.f4270a.m4921b(), this.f4270a.m4922c(), this.f4270a.m4923d(), this.f4270a.m4928j()).get(0), 1509585971);
                this.f4272c.f4282i.m4265a(Event.UPLOAD_COMPLETED, a);
            } catch (Throwable e) {
                this.f4272c.f4282i.m4264a(Event.UPLOAD_FAILED);
                this.f4271b.a(e);
                BLog.b(ShotApi.f4273a, "Error in uploading", e);
            }
        }
    }

    public static com.facebook.backstage.api.ShotApi m4269a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4274j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.api.ShotApi.class;
        monitor-enter(r1);
        r0 = f4274j;	 Catch:{ all -> 0x003a }
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
        r0 = m4275b(r0);	 Catch:{ all -> 0x0035 }
        f4274j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4274j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.api.ShotApi.a(com.facebook.inject.InjectorLike):com.facebook.backstage.api.ShotApi");
    }

    private static ShotApi m4275b(InjectorLike injectorLike) {
        return new ShotApi((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), ShotCreateMethod.m4276a(injectorLike), UploadPhotoMethod.b(injectorLike), VideoUploader.b(injectorLike), UploadOperationFactory.b(injectorLike), BackstageAnalyticsLogger.m4259a(injectorLike));
    }

    @Inject
    public ShotApi(ExecutorService executorService, ApiMethodRunner apiMethodRunner, Provider<String> provider, ShotCreateMethod shotCreateMethod, UploadPhotoMethod uploadPhotoMethod, VideoUploader videoUploader, UploadOperationFactory uploadOperationFactory, BackstageAnalyticsLogger backstageAnalyticsLogger) {
        this.f4275b = executorService;
        this.f4276c = apiMethodRunner;
        this.f4277d = provider;
        this.f4278e = shotCreateMethod;
        this.f4279f = uploadPhotoMethod;
        this.f4280g = videoUploader;
        this.f4281h = uploadOperationFactory;
        this.f4282i = backstageAnalyticsLogger;
    }

    public static String m4273a(ShotApi shotApi, String str, MediaType mediaType, ApiMethodRunnerParams apiMethodRunnerParams) {
        if (mediaType != MediaType.PHOTO) {
            return shotApi.m4274a(str);
        }
        UploadPhotoParams a = new Builder(new UploadPhotoSource("", 0)).a();
        a.z = str;
        return Long.toString(((Long) shotApi.f4276c.a(shotApi.f4279f, a, apiMethodRunnerParams)).longValue());
    }

    private String m4274a(String str) {
        UploadOperationFactory uploadOperationFactory = this.f4281h;
        VideoItem a = new VideoItemBuilder().b(str).c(uploadOperationFactory.c.a((Uri) Preconditions.checkNotNull(Uri.parse(str)))).a();
        UploadOperation.Builder builder = new UploadOperation.Builder();
        builder.b = ImmutableList.of(Preconditions.checkNotNull(a));
        UploadOperation.Builder builder2 = builder;
        builder2.e = "";
        builder2 = builder2;
        builder2.a = SafeUUIDGenerator.a().toString();
        builder = builder2.a(MinutiaeTag.a);
        builder.g = Long.parseLong((String) uploadOperationFactory.a.get());
        builder2 = builder;
        builder2.d = RegularImmutableList.a;
        builder2 = builder2;
        builder2.h = "own_timeline";
        builder2 = builder2;
        builder2.i = -1;
        builder2 = builder2;
        builder2.k = false;
        builder2 = builder2;
        builder2.l = RedSpaceValue.POST_TO_NEWSFEED;
        builder2 = builder2;
        builder2.o = PhotoUploadPrivacy.a;
        builder2 = builder2;
        builder2.p = PublishMethod.BACKSTAGE_VIDEO_POST;
        builder2 = builder2;
        builder2.q = Type.VIDEO;
        builder2 = builder2;
        builder2.w = uploadOperationFactory.b.a() / 1000;
        builder2 = builder2;
        builder2.y = false;
        builder2 = builder2;
        builder2.z = false;
        builder2 = builder2;
        builder2.H = "feed_inline";
        builder2 = builder2.d(40);
        builder2.A = PublishMode.SAVE_DRAFT;
        builder2 = builder2;
        builder2.U = uploadOperationFactory.e.a();
        UploadOperation a2 = builder2.a();
        this.f4280g.a();
        return this.f4280g.a(a2).c;
    }

    private ImmutableList<String> m4271a(String str, String str2, MediaType mediaType, @Nullable String str3, long j) {
        String str4;
        if (Strings.isNullOrEmpty(str3)) {
            str3 = null;
        }
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.f = RequestPriority.NON_INTERACTIVE;
        int i = (int) (j / 1000);
        if (mediaType == MediaType.PHOTO) {
            str4 = "photo";
        } else {
            str4 = "video";
        }
        ShotCreateParams.Builder builder = new ShotCreateParams.Builder(str, str4, SafeUUIDGenerator.a().toString(), (String) this.f4277d.get());
        builder.f4291f = str2;
        ShotCreateParams.Builder builder2 = builder;
        builder2.f4287b = str3;
        builder2 = builder2;
        builder2.f4292g = i;
        return ((ShotCreateResult) this.f4276c.a(this.f4278e, builder2.m4280a(), apiMethodRunnerParams)).f4302a;
    }
}
