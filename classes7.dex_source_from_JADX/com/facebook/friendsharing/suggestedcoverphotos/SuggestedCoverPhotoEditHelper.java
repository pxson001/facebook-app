package com.facebook.friendsharing.suggestedcoverphotos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger;
import com.facebook.friendsharing.suggestedcoverphotos.analytics.SuggestedCoverPhotosLogger$Action;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.sharing.TempBinaryFileManager;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncher;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncherProvider;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: Provided attachment is not one of the visible attachments */
public class SuggestedCoverPhotoEditHelper {
    private static final CallerContext f24282a = CallerContext.a(SuggestedCoverPhotoEditHelper.class, SuggestedCoverPhotoEditHelper.class.getSimpleName());
    public final Activity f24283b;
    public final String f24284c;
    private final ImagePipeline f24285d;
    public final TempBinaryFileManager f24286e;
    @DefaultExecutorService
    public final ListeningExecutorService f24287f;
    @ForUiThread
    public final ExecutorService f24288g;
    public final MediaItemFactory f24289h;
    public final CoverPhotoRepositionActivityLauncherProvider f24290i;
    @LoggedInUserId
    public final String f24291j;
    private final Toaster f24292k;
    public final SuggestedCoverPhotosLogger f24293l;
    public final PromptAnalytics f24294m;
    public CoverPhotoRepositionActivityLauncher f24295n;

    /* compiled from: Provided attachment is not one of the visible attachments */
    class C21141 extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        final /* synthetic */ SuggestedCoverPhotoEditHelper f24275a;

        C21141(SuggestedCoverPhotoEditHelper suggestedCoverPhotoEditHelper) {
            this.f24275a = suggestedCoverPhotoEditHelper;
        }

        protected final void m26500e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            if (dataSource.b()) {
                this.f24275a.f24293l.a.a(SuggestedCoverPhotosLogger.a(this.f24275a.f24284c, SuggestedCoverPhotosLogger$Action.DOWNLOAD_SUCCESS.name()));
                SuggestedCoverPhotoEditHelper suggestedCoverPhotoEditHelper = this.f24275a;
                CloseableReference closeableReference = (CloseableReference) dataSource.d();
                PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
                if (ImageFormatChecker.b(pooledByteBufferInputStream) == ImageFormat.JPEG) {
                    pooledByteBufferInputStream.reset();
                    Futures.a(suggestedCoverPhotoEditHelper.f24287f.a(new C21163(suggestedCoverPhotoEditHelper, pooledByteBufferInputStream, closeableReference)), new C21152(suggestedCoverPhotoEditHelper, pooledByteBufferInputStream, closeableReference), suggestedCoverPhotoEditHelper.f24288g);
                } else {
                    Closeables.a(pooledByteBufferInputStream);
                    CloseableReference.c(closeableReference);
                }
            }
        }

        protected final void m26501f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            this.f24275a.f24293l.a.a(SuggestedCoverPhotosLogger.a(this.f24275a.f24284c, SuggestedCoverPhotosLogger$Action.ERROR_FAILED_DOWNLOAD.name()));
            SuggestedCoverPhotoEditHelper.m26502b(this.f24275a);
        }
    }

    /* compiled from: Provided attachment is not one of the visible attachments */
    public class C21152 implements FutureCallback<Uri> {
        final /* synthetic */ PooledByteBufferInputStream f24276a;
        final /* synthetic */ CloseableReference f24277b;
        final /* synthetic */ SuggestedCoverPhotoEditHelper f24278c;

        public C21152(SuggestedCoverPhotoEditHelper suggestedCoverPhotoEditHelper, PooledByteBufferInputStream pooledByteBufferInputStream, CloseableReference closeableReference) {
            this.f24278c = suggestedCoverPhotoEditHelper;
            this.f24276a = pooledByteBufferInputStream;
            this.f24277b = closeableReference;
        }

        public void onSuccess(Object obj) {
            Uri uri = (Uri) obj;
            SuggestedCoverPhotoEditHelper suggestedCoverPhotoEditHelper = this.f24278c;
            MediaItem a = suggestedCoverPhotoEditHelper.f24289h.a(uri, FallbackMediaId.SINGLE_SHOT_CAMERA);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_media_items", arrayList);
            if (suggestedCoverPhotoEditHelper.f24295n == null) {
                suggestedCoverPhotoEditHelper.f24295n = suggestedCoverPhotoEditHelper.f24290i.a(Long.valueOf(Long.parseLong(suggestedCoverPhotoEditHelper.f24291j)));
            }
            suggestedCoverPhotoEditHelper.f24295n.a(suggestedCoverPhotoEditHelper.f24283b, intent, true, suggestedCoverPhotoEditHelper.f24284c, suggestedCoverPhotoEditHelper.f24294m);
        }

        public void onFailure(Throwable th) {
            Closeables.a(this.f24276a);
            CloseableReference.c(this.f24277b);
            SuggestedCoverPhotoEditHelper.m26502b(this.f24278c);
        }
    }

    /* compiled from: Provided attachment is not one of the visible attachments */
    public class C21163 implements Callable<Uri> {
        final /* synthetic */ PooledByteBufferInputStream f24279a;
        final /* synthetic */ CloseableReference f24280b;
        final /* synthetic */ SuggestedCoverPhotoEditHelper f24281c;

        public C21163(SuggestedCoverPhotoEditHelper suggestedCoverPhotoEditHelper, PooledByteBufferInputStream pooledByteBufferInputStream, CloseableReference closeableReference) {
            this.f24281c = suggestedCoverPhotoEditHelper;
            this.f24279a = pooledByteBufferInputStream;
            this.f24280b = closeableReference;
        }

        public Object call() {
            Object a;
            try {
                a = this.f24281c.f24286e.m12915a(this.f24279a);
            } catch (IOException e) {
                return null;
            } finally {
                Closeables.a(this.f24279a);
                CloseableReference.c(this.f24280b);
            }
            return a;
        }
    }

    @Inject
    public SuggestedCoverPhotoEditHelper(@Nullable @Assisted Activity activity, @Assisted String str, @Assisted PromptAnalytics promptAnalytics, ImagePipeline imagePipeline, TempBinaryFileManager tempBinaryFileManager, ListeningExecutorService listeningExecutorService, ExecutorService executorService, MediaItemFactory mediaItemFactory, CoverPhotoRepositionActivityLauncherProvider coverPhotoRepositionActivityLauncherProvider, String str2, Toaster toaster, SuggestedCoverPhotosLogger suggestedCoverPhotosLogger) {
        this.f24283b = activity;
        this.f24284c = str;
        this.f24285d = imagePipeline;
        this.f24286e = tempBinaryFileManager;
        this.f24287f = listeningExecutorService;
        this.f24288g = executorService;
        this.f24289h = mediaItemFactory;
        this.f24290i = coverPhotoRepositionActivityLauncherProvider;
        this.f24291j = str2;
        this.f24292k = toaster;
        this.f24293l = suggestedCoverPhotosLogger;
        this.f24294m = promptAnalytics;
    }

    public final void m26503a(Uri uri) {
        ImageRequest a = ImageRequest.a(uri);
        if (a == null) {
            m26502b(this);
        } else {
            this.f24285d.d(a, f24282a).a(new C21141(this), this.f24288g);
        }
    }

    public static void m26502b(SuggestedCoverPhotoEditHelper suggestedCoverPhotoEditHelper) {
        suggestedCoverPhotoEditHelper.f24292k.a(new ToastBuilder(2131238431));
    }
}
