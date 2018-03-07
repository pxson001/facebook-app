package com.facebook.timeline.profilevideo.upload;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.util.Pair;
import android.webkit.MimeTypeMap;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.file.FileUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.media.MediaItemFactory.VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilevideo.model.ProfileVideoModel;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoModel;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoModel.Builder;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.creativeediting.utilities.VideoMetadataExtractHelper;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.effects.renderers.EffectsFactory;
import com.facebook.videocodec.effects.renderers.EffectsFactory.EffectsBuilder;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.policy.HdVideoResizingPolicy;
import com.facebook.videocodec.policy.VideoMirroringMode;
import com.facebook.videocodec.resizer.VideoResizeResult;
import com.facebook.videocodec.resizer.VideoResizer;
import com.facebook.videocodec.resizer.VideoResizerParams;
import com.facebook.videocodec.resizer.VideoResizerUtils;
import com.google.common.io.Files;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: mHasUserInteracted */
public final class ProfileVideoUploader {
    public static final CallerContext f9458a = CallerContext.a(ProfileVideoUploader.class, "create_profile_video_android");
    private static final Object f9459s = new Object();
    public final Context f9460b;
    public final UploadOperationFactory f9461c;
    public final UploadManager f9462d;
    public final ViewerContext f9463e;
    public final AbstractFbErrorReporter f9464f;
    public final ProfileVideoUploadListenerProvider f9465g;
    public final OptimisticProfileVideoStore f9466h;
    public final Clock f9467i;
    public final ListeningExecutorService f9468j;
    public final ListeningExecutorService f9469k;
    public final TempFileManager f9470l;
    public final ProfileMediaChangeBroadcaster f9471m;
    private final QeAccessor f9472n;
    public final VideoMetadataExtractor f9473o;
    public final VideoResizer f9474p;
    public final HdVideoResizingPolicy f9475q;
    public final EffectsFactory f9476r;

    /* compiled from: mHasUserInteracted */
    public class C09881 implements AsyncFunction<VideoResizeResult, Pair<UploadOperation, OptimisticProfileVideoModel>> {
        final /* synthetic */ ProfileVideoModel f9450a;
        final /* synthetic */ CloseableReference f9451b;
        final /* synthetic */ String f9452c;
        final /* synthetic */ ProfileVideoUploader f9453d;

        public C09881(ProfileVideoUploader profileVideoUploader, ProfileVideoModel profileVideoModel, CloseableReference closeableReference, String str) {
            this.f9453d = profileVideoUploader;
            this.f9450a = profileVideoModel;
            this.f9451b = closeableReference;
            this.f9452c = str;
        }

        public final ListenableFuture m11193a(@Nullable Object obj) {
            final VideoResizeResult videoResizeResult = (VideoResizeResult) obj;
            return this.f9453d.f9468j.a(new Callable<Pair<UploadOperation, OptimisticProfileVideoModel>>(this) {
                final /* synthetic */ C09881 f9449b;

                public Object call() {
                    ProfileVideoModel a;
                    String str;
                    String b;
                    String str2;
                    Object obj = null;
                    ProfileVideoModel profileVideoModel = this.f9449b.f9450a;
                    if (videoResizeResult != null) {
                        a = profileVideoModel.m11136m().m11120a(Uri.fromFile(videoResizeResult.a)).m11121a();
                        obj = 1;
                    } else {
                        a = profileVideoModel;
                    }
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a.m11125b());
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                    if (a.m11128e() == 1 || a.m11128e() == 2) {
                        String path = a.m11124a().getPath();
                        str = "camera";
                        try {
                            b = ProfileVideoUploader.m11196b(path, "." + fileExtensionFromUrl);
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(Uri.fromFile(new File(b)));
                            this.f9449b.f9453d.f9460b.sendBroadcast(intent);
                            str2 = path;
                        } catch (IOException e) {
                            b = path;
                            str2 = path;
                        }
                    } else {
                        b = a.m11124a().getPath();
                        str = "upload";
                        str2 = ProfileVideoUploader.m11197c(this.f9449b.f9453d, b, "." + fileExtensionFromUrl);
                    }
                    VideoItemBuilder b2 = new VideoItemBuilder().b(b);
                    if (mimeTypeFromExtension != null) {
                        b2.c(mimeTypeFromExtension);
                    }
                    VideoItem a2 = b2.a();
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f9449b.f9451b.a()).compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("thumbnail_bitmap", byteArrayOutputStream.toByteArray());
                    bundle.putLong("frame_offset", (long) a.m11127d());
                    VideoCreativeEditingData videoCreativeEditingData = null;
                    if (obj == null) {
                        videoCreativeEditingData = a.m11129f();
                        bundle.putParcelable("video_creative_editing_metadata", videoCreativeEditingData);
                    }
                    UploadOperation a3 = this.f9449b.f9453d.f9461c.a(this.f9449b.f9453d.f9463e, a2, bundle, this.f9449b.f9452c, str, a.m11135l(), a.m11133j(), this.f9449b.f9450a.m11129f().g(), a.m11134k());
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(a.m11124a().getPath());
                    float b3 = VideoMetadataExtractHelper.b(mediaMetadataRetriever);
                    mediaMetadataRetriever.release();
                    return new Pair(a3, new Builder().m11163a(this.f9449b.f9452c).m11165b("uploading").m11166c(Uri.fromFile(new File(str2)).toString()).m11161a(this.f9449b.f9453d.f9467i.a()).m11162a(videoCreativeEditingData).m11160a(b3).m11164a());
                }
            });
        }
    }

    /* compiled from: mHasUserInteracted */
    public class C09892 implements FutureCallback<Pair<UploadOperation, OptimisticProfileVideoModel>> {
        final /* synthetic */ String f9454a;
        final /* synthetic */ ProfileVideoUploader f9455b;

        public C09892(ProfileVideoUploader profileVideoUploader, String str) {
            this.f9455b = profileVideoUploader;
            this.f9454a = str;
        }

        public void onSuccess(@Nullable Object obj) {
            Pair pair = (Pair) obj;
            if (pair != null) {
                this.f9455b.f9462d.a((UploadOperation) pair.a);
                InjectorLike injectorLike = this.f9455b.f9465g;
                ProfileVideoUploadListener profileVideoUploadListener = new ProfileVideoUploadListener(this.f9454a, MediaUploadEventBus.a(injectorLike), OptimisticProfileVideoStore.m11170a(injectorLike), ProfileMediaChangeBroadcaster.m10942a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), (ProfileVideoNotificationListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfileVideoNotificationListenerProvider.class));
                profileVideoUploadListener.f9440b.a(profileVideoUploadListener.f9446h);
                profileVideoUploadListener.f9440b.a(profileVideoUploadListener.f9447i);
                HandlerDetour.b(profileVideoUploadListener.f9443e, profileVideoUploadListener.f9445g, 86400000, -1020704696);
                this.f9455b.f9466h.m11182a((OptimisticProfileVideoModel) pair.b);
                this.f9455b.f9471m.m10948e();
            }
        }

        public void onFailure(Throwable th) {
            BLog.a(ProfileVideoUploader.class, th, "Failed to upload profile video", new Object[0]);
        }
    }

    /* compiled from: mHasUserInteracted */
    public class C09903 implements Callable<VideoResizeResult> {
        final /* synthetic */ ProfileVideoModel f9456a;
        final /* synthetic */ ProfileVideoUploader f9457b;

        public C09903(ProfileVideoUploader profileVideoUploader, ProfileVideoModel profileVideoModel) {
            this.f9457b = profileVideoUploader;
            this.f9456a = profileVideoModel;
        }

        public Object call() {
            File a = this.f9457b.f9470l.a("profile-video-cropped", ".mp4", Privacy.REQUIRE_PRIVATE);
            try {
                VideoMetadata a2 = this.f9457b.f9473o.a(this.f9456a.m11124a());
                this.f9457b.f9475q.a(1500);
                EffectsBuilder a3 = this.f9457b.f9476r.a();
                if (!(this.f9456a.m11129f() == null || this.f9456a.m11129f().f() == null)) {
                    a3.a(Uri.parse(this.f9456a.m11129f().f()), ProfileVideoUploader.f9458a);
                }
                VideoMirroringMode videoMirroringMode = (this.f9456a.m11129f() == null || !this.f9456a.m11129f().h()) ? VideoMirroringMode.NONE : VideoMirroringMode.MIRROR_HORIZONTALLY;
                return (VideoResizeResult) FutureDetour.a(this.f9457b.f9474p.a(VideoResizerParams.newBuilder().a(new File(this.f9456a.m11124a().getPath())).b(a).a(VideoResizerUtils.a(1.0f, a2)).a(this.f9457b.f9475q).a(this.f9456a.m11131h()).b(this.f9456a.m11132i()).a(this.f9456a.m11130g()).a(a3.a()).a(videoMirroringMode).o()), 1953451732);
            } catch (Throwable e) {
                BLog.b("ProfileVideoUploader", "Failed to transcode", e);
                return null;
            }
        }
    }

    private static ProfileVideoUploader m11195b(InjectorLike injectorLike) {
        return new ProfileVideoUploader((Context) injectorLike.getInstance(Context.class), UploadOperationFactory.a(injectorLike), UploadManager.a(injectorLike), ViewerContextMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ProfileVideoUploadListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfileVideoUploadListenerProvider.class), OptimisticProfileVideoStore.m11170a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), TempFileManager.a(injectorLike), ProfileMediaChangeBroadcaster.m10942a(injectorLike), (VideoMetadataExtractor) DefaultVideoMetadataExtractor.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BackingFileResolver.a(injectorLike), VideoResizer.a(injectorLike), HdVideoResizingPolicy.a(injectorLike), EffectsFactory.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.timeline.profilevideo.upload.ProfileVideoUploader m11194a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f9459s;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11195b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9459s;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.timeline.profilevideo.upload.ProfileVideoUploader) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.timeline.profilevideo.upload.ProfileVideoUploader) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f9459s;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.timeline.profilevideo.upload.ProfileVideoUploader) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.profilevideo.upload.ProfileVideoUploader.a(com.facebook.inject.InjectorLike):com.facebook.timeline.profilevideo.upload.ProfileVideoUploader");
    }

    @Inject
    public ProfileVideoUploader(Context context, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager, ViewerContext viewerContext, AbstractFbErrorReporter abstractFbErrorReporter, ProfileVideoUploadListenerProvider profileVideoUploadListenerProvider, OptimisticProfileVideoStore optimisticProfileVideoStore, Clock clock, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, TempFileManager tempFileManager, ProfileMediaChangeBroadcaster profileMediaChangeBroadcaster, VideoMetadataExtractor videoMetadataExtractor, QeAccessor qeAccessor, BackingFileResolver backingFileResolver, VideoResizer videoResizer, HdVideoResizingPolicy hdVideoResizingPolicy, EffectsFactory effectsFactory) {
        this.f9460b = context;
        this.f9461c = uploadOperationFactory;
        this.f9462d = uploadManager;
        this.f9463e = viewerContext;
        this.f9464f = abstractFbErrorReporter;
        this.f9465g = profileVideoUploadListenerProvider;
        this.f9466h = optimisticProfileVideoStore;
        this.f9467i = clock;
        this.f9468j = listeningExecutorService;
        this.f9469k = listeningExecutorService2;
        this.f9470l = tempFileManager;
        this.f9471m = profileMediaChangeBroadcaster;
        this.f9472n = qeAccessor;
        this.f9473o = videoMetadataExtractor;
        this.f9474p = videoResizer;
        this.f9475q = hdVideoResizingPolicy;
        this.f9476r = effectsFactory;
    }

    public static String m11196b(String str, String str2) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Facebook");
        FileUtils.a(file);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        File file2 = new File(str);
        File file3 = new File(file, "VID_" + format + str2);
        Files.a(file2, file3);
        return file3.getPath();
    }

    public static String m11197c(ProfileVideoUploader profileVideoUploader, String str, String str2) {
        File a = profileVideoUploader.f9470l.a("profile-video", str2, Privacy.REQUIRE_PRIVATE);
        Files.a(new File(str), a);
        return a.getPath();
    }
}
