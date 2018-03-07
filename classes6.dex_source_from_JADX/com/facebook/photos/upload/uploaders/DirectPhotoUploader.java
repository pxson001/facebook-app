package com.facebook.photos.upload.uploaders;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.acra.util.ProcFileReader;
import com.facebook.acra.util.ProcFileReader.OpenFDLimits;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.bitmaps.BitmapException;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageResizerMethodAutoProvider;
import com.facebook.bitmaps.ImageScaleParam;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.InterpretedException;
import com.facebook.photos.base.analytics.LoggingTypes.SourceType;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;
import com.facebook.photos.base.analytics.PhotoFlowLogger.UploadInfo;
import com.facebook.photos.base.analytics.upload.UploadBaseParams;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingUploadParams;
import com.facebook.photos.creativeediting.utilities.CreativeEditingBitmapHelper;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.facebook.photos.imageprocessing.FiltersEngine;
import com.facebook.photos.upload.ImageSampling.ImageSampler;
import com.facebook.photos.upload.ImageSampling.ImageSamplerFactory;
import com.facebook.photos.upload.disk.StatusHelper;
import com.facebook.photos.upload.disk.TempFiles;
import com.facebook.photos.upload.disk.UploadTempFileManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.RequestLogger;
import com.facebook.photos.upload.protocol.UploadPhotoMethod;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoParams.Builder;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.retry.NoImmediateRetryPolicy;
import com.facebook.photos.upload.scaling.ImageScalingPolicy;
import com.facebook.photos.upload.uploaders.PreprocessedResult.Status;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: from server */
public class DirectPhotoUploader {
    public static final Class<?> f14329a = DirectPhotoUploader.class;
    private final ImageSamplerFactory f14330b;
    private final UploadTempFileManager f14331c;
    public final BitmapUtils f14332d;
    private final ImageResizer f14333e;
    private final ImageScalingPolicy f14334f;
    private final FiltersEngine f14335g;
    private final Provider<ImmediateRetryPolicy> f14336h;
    private final AbstractSingleMethodRunner f14337i;
    private final UploadOperationHelper f14338j;
    private final UploadPhotoMethod f14339k;
    private final AbstractFbErrorReporter f14340l;
    private final StatusHelper f14341m;
    private final Clock f14342n;
    private final CreativeEditingBitmapHelper f14343o;
    private final ExecutorService f14344p;
    private final CreativeEditingFileManager f14345q;
    public boolean f14346r;
    private final PhotoOverlayObjectMapper f14347s;

    /* compiled from: from server */
    public class DecodeSourceFileException extends ImageResizingException {
        public DecodeSourceFileException(String str) {
            super(str, false);
        }
    }

    /* compiled from: from server */
    public class DirectUploadListener {
        void mo1155a(int i, int i2, float f) {
        }

        public void mo1156a(UploadPhotoParams uploadPhotoParams, UploadRecord uploadRecord) {
        }
    }

    /* compiled from: from server */
    class FileToUploadNotFoundException extends InterpretedException {
        public FileToUploadNotFoundException(String str) {
            super(str, true);
        }
    }

    @VisibleForTesting
    /* compiled from: from server */
    public class InvalidVaultSourceException extends Exception {
    }

    /* compiled from: from server */
    class LoggerProgressListener implements ApiMethodProgressListener {
        private final DefaultPhotoFlowLogger f14315a;
        private final UploadBaseParams f14316b;
        private final ProgressController f14317c;
        private final MediaUploadCancelHandler f14318d;
        private long f14319e;
        private long f14320f;
        private boolean f14321g;
        private boolean f14322h;
        private int f14323i;

        public LoggerProgressListener(ProgressController progressController, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, MediaUploadCancelHandler mediaUploadCancelHandler) {
            this.f14317c = progressController;
            this.f14315a = defaultPhotoFlowLogger;
            this.f14316b = uploadBaseParams;
            this.f14318d = mediaUploadCancelHandler;
        }

        final void m21976a(long j, int i) {
            this.f14319e = 0;
            this.f14320f = j;
            this.f14321g = j >= 0;
            this.f14322h = false;
            this.f14323i = i;
            if (this.f14321g) {
                this.f14315a.m19912b(this.f14316b, j, this.f14323i);
            }
        }

        final void m21978a(ExceptionInterpreter exceptionInterpreter) {
            if (!this.f14321g) {
                return;
            }
            if (this.f14318d.f14351d) {
                this.f14315a.m19854a(this.f14316b, this.f14319e, this.f14320f, this.f14323i);
            } else if (exceptionInterpreter != null) {
                this.f14315a.m19855a(this.f14316b, this.f14319e, this.f14320f, this.f14323i, (PhotoFlowLogger$ExceptionReporter) exceptionInterpreter);
            } else if (!this.f14322h) {
                this.f14315a.m19925c(this.f14316b, this.f14320f, this.f14323i);
            }
        }

        public final void m21977a(long j, long j2) {
            this.f14319e = j;
            this.f14320f = j2;
            boolean z = this.f14319e >= this.f14320f;
            this.f14317c.m21979a(((float) j) / ((float) j2));
            if (this.f14321g && !this.f14322h && z) {
                this.f14315a.m19925c(this.f14316b, this.f14320f, this.f14323i);
                this.f14322h = true;
            }
        }
    }

    /* compiled from: from server */
    class ProcessException extends InterpretedException {
        public ProcessException(String str, boolean z) {
            super(str, z);
        }
    }

    /* compiled from: from server */
    class MinDimensionException extends ProcessException {
        public MinDimensionException(String str) {
            super(str, true);
        }
    }

    /* compiled from: from server */
    class NoFbIdException extends ReportedException {
        public NoFbIdException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    @VisibleForTesting
    /* compiled from: from server */
    public class PhotoUploadException extends ReportedException {
        public PhotoUploadException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    @VisibleForTesting
    /* compiled from: from server */
    public class ProcessUploadException extends ReportedException {
        public ProcessUploadException(ExceptionInterpreter exceptionInterpreter) {
            super(exceptionInterpreter);
        }
    }

    /* compiled from: from server */
    public class ProgressController {
        private final DirectUploadListener f14324a;
        private int f14325b;
        private int f14326c;

        public ProgressController(DirectUploadListener directUploadListener) {
            this.f14324a = directUploadListener;
        }

        public final void m21979a(float f) {
            this.f14324a.mo1155a(this.f14325b, this.f14326c, f);
        }

        public final void m21980a(int i, int i2) {
            this.f14325b = i;
            this.f14326c = i2;
            this.f14324a.mo1155a(this.f14325b, this.f14326c, 0.0f);
        }
    }

    /* compiled from: from server */
    class TransferResult {
        public final long f14327a;
        public final int f14328b;

        TransferResult(long j, int i) {
            this.f14327a = j;
            this.f14328b = i;
        }
    }

    public static DirectPhotoUploader m21990b(InjectorLike injectorLike) {
        return new DirectPhotoUploader(ImageSamplerFactory.m21186a(injectorLike), UploadTempFileManager.m21320a(injectorLike), BitmapUtils.a(injectorLike), ImageResizerMethodAutoProvider.a(injectorLike), ImageScalingPolicy.m21908a(injectorLike), FiltersEngine.m20374a(injectorLike), IdBasedProvider.a(injectorLike, 9491), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), UploadOperationHelper.m21580a(injectorLike), UploadPhotoMethod.m21751a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StatusHelper.m21311a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), CreativeEditingBitmapHelper.m20210a(injectorLike), PhotoOverlayObjectMapper.m20234a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), CreativeEditingFileManager.m20215a(injectorLike));
    }

    @Inject
    public DirectPhotoUploader(ImageSamplerFactory imageSamplerFactory, UploadTempFileManager uploadTempFileManager, BitmapUtils bitmapUtils, ImageResizer imageResizer, ImageScalingPolicy imageScalingPolicy, FiltersEngine filtersEngine, Provider<ImmediateRetryPolicy> provider, SingleMethodRunner singleMethodRunner, UploadOperationHelper uploadOperationHelper, UploadPhotoMethod uploadPhotoMethod, FbErrorReporter fbErrorReporter, StatusHelper statusHelper, Clock clock, CreativeEditingBitmapHelper creativeEditingBitmapHelper, PhotoOverlayObjectMapper photoOverlayObjectMapper, ExecutorService executorService, CreativeEditingFileManager creativeEditingFileManager) {
        this.f14330b = imageSamplerFactory;
        this.f14331c = uploadTempFileManager;
        this.f14332d = bitmapUtils;
        this.f14333e = imageResizer;
        this.f14334f = imageScalingPolicy;
        this.f14335g = filtersEngine;
        this.f14336h = provider;
        this.f14337i = singleMethodRunner;
        this.f14338j = uploadOperationHelper;
        this.f14339k = uploadPhotoMethod;
        this.f14340l = fbErrorReporter;
        this.f14341m = statusHelper;
        this.f14342n = clock;
        this.f14343o = creativeEditingBitmapHelper;
        this.f14347s = photoOverlayObjectMapper;
        this.f14344p = executorService;
        this.f14345q = creativeEditingFileManager;
        imageResizer.a(false);
    }

    public final String m21993a(MediaItem mediaItem, String str, String str2, @Nullable ViewerContext viewerContext) {
        Collection a = Lists.a(new UploadPhotoParams[]{new Builder(new UploadPhotoSource(mediaItem.e(), mediaItem.e)).m21758a(viewerContext).m21770a()});
        DefaultPhotoFlowLogger a2 = this.f14338j.m21585a(str);
        a2.f12595k = str2;
        String str3 = (String) m21994a(a, new DirectUploadListener(), new MediaUploadCancelHandler(), a2, a2.m19944j("2.0"), null, (ImmediateRetryPolicy) this.f14336h.get()).keySet().iterator().next();
        this.f14331c.m21338a(a2.f12594j);
        return str3;
    }

    public final Map<String, UploadRecord> m21994a(Collection<UploadPhotoParams> collection, DirectUploadListener directUploadListener, MediaUploadCancelHandler mediaUploadCancelHandler, PhotoFlowLogger photoFlowLogger, UploadBaseParams uploadBaseParams, @Nullable UploadInfo uploadInfo, ImmediateRetryPolicy immediateRetryPolicy) {
        int i = 1;
        Map c = Maps.c();
        photoFlowLogger.m19934d(uploadBaseParams, (UploadOperation) uploadInfo);
        try {
            ImageSampler c2 = this.f14330b.m21191c();
            ProgressController progressController = new ProgressController(directUploadListener);
            for (UploadPhotoParams uploadPhotoParams : collection) {
                UploadRecord a;
                progressController.m21980a(i, collection.size());
                try {
                    a = m21984a(uploadPhotoParams, progressController, photoFlowLogger, uploadBaseParams, c2, mediaUploadCancelHandler, i, collection.size(), immediateRetryPolicy);
                } catch (InvalidVaultSourceException e) {
                    a = m21984a(uploadPhotoParams.m21808a(), progressController, photoFlowLogger, uploadBaseParams, c2, mediaUploadCancelHandler, i, collection.size(), immediateRetryPolicy);
                }
                c.put(Long.toString(a.fbid), a);
                directUploadListener.mo1156a(uploadPhotoParams, a);
                i++;
            }
            photoFlowLogger.m19871a(uploadBaseParams, (UploadOperation) uploadInfo);
            return c;
        } catch (Exception e2) {
            int i2 = 1 - 1;
            if (mediaUploadCancelHandler.m22007e()) {
                photoFlowLogger.m19872a(uploadBaseParams, (UploadOperation) uploadInfo, i2);
                mediaUploadCancelHandler.m22001a("Upload cancelled at photo #" + 1);
            }
            photoFlowLogger.m19873a(uploadBaseParams, (UploadOperation) uploadInfo, i2, collection.size() - i2, e2 instanceof ReportedException ? (ReportedException) e2 : m21981a(e2));
            throw e2;
        }
    }

    public final PreprocessedResult m21992a(String str, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, MediaUploadCancelHandler mediaUploadCancelHandler) {
        try {
            defaultPhotoFlowLogger.m19918b("photo_preprocessed_batch");
            return new PreprocessedResult(Status.PREPROCESSED, m21983a(str, defaultPhotoFlowLogger, uploadBaseParams, mediaUploadCancelHandler, new Dimension(1, 1), null, 0, false), null);
        } catch (ReportedException e) {
            if (mediaUploadCancelHandler.m22007e() || (e.m21708h().m19959a() instanceof DecodeSourceFileException) || new File(str).length() > 4194304) {
                return new PreprocessedResult(Status.FATAL, null, null);
            }
            return new PreprocessedResult(Status.USE_ORIGINAL, null, null);
        }
    }

    public final UploadRecord m21991a(String str, String str2, String str3, MediaUploadCancelHandler mediaUploadCancelHandler, ViewerContext viewerContext, int i, int i2) {
        UploadPhotoParams a = new Builder(new UploadPhotoSource(str, 0)).m21758a(viewerContext).m21770a();
        a.m21813b(true);
        DefaultPhotoFlowLogger a2 = this.f14338j.m21585a(str2);
        a2.m19918b(str3);
        return m21984a(a, new ProgressController(new DirectUploadListener()), a2, a2.m19944j("2.0"), this.f14330b.m21191c(), mediaUploadCancelHandler, i, i2, new NoImmediateRetryPolicy());
    }

    private UploadRecord m21984a(UploadPhotoParams uploadPhotoParams, ProgressController progressController, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, ImageSampler imageSampler, MediaUploadCancelHandler mediaUploadCancelHandler, int i, int i2, ImmediateRetryPolicy immediateRetryPolicy) {
        TempFiles tempFiles;
        TempFiles a;
        ReportedException e;
        Exception e2;
        PhotoFlowLogger$ExceptionReporter photoFlowLogger$ExceptionReporter;
        PhotoFlowLogger$ExceptionReporter a2;
        Throwable th;
        SourceType sourceType = uploadPhotoParams.m21828q() ? SourceType.VAULT : SourceType.LOCAL;
        defaultPhotoFlowLogger.m19849a(uploadBaseParams, i - 1, sourceType);
        progressController.m21979a(0.0f);
        long j = -1;
        try {
            TransferResult a3;
            UploadRecord uploadRecord;
            Object obj = (uploadPhotoParams.m21814c() == null || !uploadPhotoParams.m21814c().m4459a().m4449l()) ? null : 1;
            String d = uploadPhotoParams.m21816e() == null ? uploadPhotoParams.m21815d() : uploadPhotoParams.m21816e();
            if (obj == null && uploadPhotoParams.ac()) {
                tempFiles = null;
            } else {
                try {
                    a = m21983a(d, defaultPhotoFlowLogger, uploadBaseParams, mediaUploadCancelHandler, uploadPhotoParams.m21798E(), uploadPhotoParams.m21814c(), uploadPhotoParams.m21797D(), uploadPhotoParams.m21823l());
                    try {
                        uploadPhotoParams.m21810a(a.m21316b().getAbsolutePath());
                        j = a.m21316b().length();
                        if (uploadPhotoParams.m21814c() != null) {
                            ImmutableList h = uploadPhotoParams.m21814c().m4459a().m4445h();
                            int size = h.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                PhotoOverlayItem photoOverlayItem = (PhotoOverlayItem) h.get(i3);
                                if (photoOverlayItem instanceof UriAwarePhotoOverlayItem) {
                                    CreativeEditingFileManager.m20217a(((UriAwarePhotoOverlayItem) photoOverlayItem).mo225d());
                                }
                            }
                        }
                        tempFiles = a;
                    } catch (ProcessUploadException e3) {
                        e = e3;
                        try {
                            if (!mediaUploadCancelHandler.m22007e() || (e.m21708h().m19959a() instanceof DecodeSourceFileException) || new File(d).length() > 4194304) {
                                throw e;
                            }
                            uploadPhotoParams.m21810a(d);
                            j = new File(d).length();
                            tempFiles = a;
                            a3 = m21985a(uploadPhotoParams, i, i2, j, defaultPhotoFlowLogger, uploadBaseParams, mediaUploadCancelHandler, progressController, imageSampler, immediateRetryPolicy);
                            defaultPhotoFlowLogger.m19865a(uploadBaseParams, sourceType, a3.f14327a, a3.f14328b);
                            if (tempFiles != null) {
                                tempFiles.m21315a(false);
                            }
                            uploadRecord = new UploadRecord(a3.f14327a, this.f14342n.a(), uploadPhotoParams.m21832w());
                            if (tempFiles != null) {
                                tempFiles.m21314a();
                            }
                            return uploadRecord;
                        } catch (Exception e4) {
                            e2 = e4;
                            try {
                                if (mediaUploadCancelHandler.m22007e()) {
                                    defaultPhotoFlowLogger.m19864a(uploadBaseParams, sourceType);
                                    mediaUploadCancelHandler.m22001a("uploading");
                                }
                                if (e2 instanceof ReportedException) {
                                    photoFlowLogger$ExceptionReporter = (ReportedException) e2;
                                    defaultPhotoFlowLogger.m19866a(uploadBaseParams, sourceType, photoFlowLogger$ExceptionReporter);
                                    throw photoFlowLogger$ExceptionReporter;
                                }
                                a2 = m21981a(e2);
                                defaultPhotoFlowLogger.m19866a(uploadBaseParams, sourceType, a2);
                                if (e2 instanceof InvalidVaultSourceException) {
                                    throw e2;
                                }
                                if (a2.m19970k()) {
                                    a.m21315a(false);
                                }
                                throw new PhotoUploadException(a2);
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    a.m21314a();
                                }
                                throw th;
                            }
                        }
                    }
                } catch (ProcessUploadException e5) {
                    e = e5;
                    a = null;
                    if (mediaUploadCancelHandler.m22007e()) {
                    }
                    throw e;
                }
            }
            try {
                a3 = m21985a(uploadPhotoParams, i, i2, j, defaultPhotoFlowLogger, uploadBaseParams, mediaUploadCancelHandler, progressController, imageSampler, immediateRetryPolicy);
                defaultPhotoFlowLogger.m19865a(uploadBaseParams, sourceType, a3.f14327a, a3.f14328b);
                if (tempFiles != null) {
                    tempFiles.m21315a(false);
                }
                uploadRecord = new UploadRecord(a3.f14327a, this.f14342n.a(), uploadPhotoParams.m21832w());
                if (tempFiles != null) {
                    tempFiles.m21314a();
                }
                return uploadRecord;
            } catch (Exception e6) {
                e2 = e6;
                a = tempFiles;
                if (mediaUploadCancelHandler.m22007e()) {
                    defaultPhotoFlowLogger.m19864a(uploadBaseParams, sourceType);
                    mediaUploadCancelHandler.m22001a("uploading");
                }
                if (e2 instanceof ReportedException) {
                    a2 = m21981a(e2);
                    defaultPhotoFlowLogger.m19866a(uploadBaseParams, sourceType, a2);
                    if (e2 instanceof InvalidVaultSourceException) {
                        if (a2.m19970k()) {
                            a.m21315a(false);
                        }
                        throw new PhotoUploadException(a2);
                    }
                    throw e2;
                }
                photoFlowLogger$ExceptionReporter = (ReportedException) e2;
                defaultPhotoFlowLogger.m19866a(uploadBaseParams, sourceType, photoFlowLogger$ExceptionReporter);
                throw photoFlowLogger$ExceptionReporter;
            } catch (Throwable th3) {
                th = th3;
                a = tempFiles;
                if (a != null) {
                    a.m21314a();
                }
                throw th;
            }
        } catch (Exception e7) {
            e2 = e7;
            a = null;
            if (mediaUploadCancelHandler.m22007e()) {
                defaultPhotoFlowLogger.m19864a(uploadBaseParams, sourceType);
                mediaUploadCancelHandler.m22001a("uploading");
            }
            if (e2 instanceof ReportedException) {
                photoFlowLogger$ExceptionReporter = (ReportedException) e2;
                defaultPhotoFlowLogger.m19866a(uploadBaseParams, sourceType, photoFlowLogger$ExceptionReporter);
                throw photoFlowLogger$ExceptionReporter;
            }
            a2 = m21981a(e2);
            defaultPhotoFlowLogger.m19866a(uploadBaseParams, sourceType, a2);
            if (e2 instanceof InvalidVaultSourceException) {
                throw e2;
            }
            if (a2.m19970k()) {
                a.m21315a(false);
            }
            throw new PhotoUploadException(a2);
        } catch (Throwable th4) {
            th = th4;
            a = null;
            if (a != null) {
                a.m21314a();
            }
            throw th;
        }
    }

    private TempFiles m21983a(String str, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, MediaUploadCancelHandler mediaUploadCancelHandler, Dimension dimension, @Nullable CreativeEditingUploadParams creativeEditingUploadParams, int i, boolean z) {
        TempFiles b;
        TempFiles a;
        Exception exception;
        boolean e;
        PhotoFlowLogger$ExceptionReporter a2;
        TempFiles tempFiles = null;
        String a3;
        try {
            a3 = defaultPhotoFlowLogger.m19838a();
            File a4 = this.f14331c.m21335a(a3, str);
            if (a4 != null) {
                if (m21989a(a4, dimension) && BitmapUtils.b(str) == BitmapUtils.b(a4.getAbsolutePath())) {
                    Dimension a5 = BitmapUtils.a(a4.getAbsolutePath());
                    if (a5.b <= 0 || a5.a <= 0) {
                        throw new DecodeSourceFileException(this.f14341m.m21313a(a4.getAbsolutePath(), "decode persisted file"));
                    } else if (creativeEditingUploadParams == null || !creativeEditingUploadParams.m4459a().m4449l()) {
                        return new TempFiles(a4, null, true);
                    } else {
                        b = this.f14331c.m21339b(a4, 5242880);
                        if (b == null) {
                            throw new ProcessException("Failed to create auto-enhance temp files.", true);
                        }
                        m21987a(b, Math.max(a5.b, a5.a), creativeEditingUploadParams);
                        return m21982a(b, i, creativeEditingUploadParams, BitmapUtils.a(b.m21316b().getAbsolutePath()));
                    }
                }
                tempFiles = this.f14331c.m21331a(a4, 5242880);
            }
            if (tempFiles == null) {
                try {
                    a = this.f14331c.m21333a(a3, 5242880, 1048576);
                } catch (Exception e2) {
                    b = tempFiles;
                    exception = e2;
                    e = mediaUploadCancelHandler.m22007e();
                    if (!e) {
                        if (b != null) {
                        }
                        m21986a(defaultPhotoFlowLogger, uploadBaseParams, str, a3);
                    }
                    if (b != null) {
                        b.m21315a(false);
                        b.m21314a();
                    }
                    if (e) {
                        defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                        mediaUploadCancelHandler.m22001a("processing");
                    }
                    a2 = m21981a(exception);
                    defaultPhotoFlowLogger.m19926c(uploadBaseParams, a2);
                    throw new ProcessUploadException(a2);
                }
            }
            a = tempFiles;
            if (a == null) {
                try {
                    throw new ProcessException("Failed to create temp files", true);
                } catch (Exception e22) {
                    exception = e22;
                    b = a;
                    e = mediaUploadCancelHandler.m22007e();
                    if (e) {
                        if (b != null) {
                        }
                        m21986a(defaultPhotoFlowLogger, uploadBaseParams, str, a3);
                    }
                    if (b != null) {
                        b.m21315a(false);
                        b.m21314a();
                    }
                    if (e) {
                        defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                        mediaUploadCancelHandler.m22001a("processing");
                    }
                    a2 = m21981a(exception);
                    defaultPhotoFlowLogger.m19926c(uploadBaseParams, a2);
                    throw new ProcessUploadException(a2);
                }
            }
            defaultPhotoFlowLogger.m19909b(uploadBaseParams);
            Dimension a6 = BitmapUtils.a(str);
            if (a6.b <= 0 || a6.a <= 0) {
                throw new DecodeSourceFileException(this.f14341m.m21313a(str, "decode input file"));
            }
            mediaUploadCancelHandler.m22001a("processing");
            ImageScaleParam a7 = this.f14334f.m21910a(this.f14333e, str, a6, a.m21317c(), z);
            long length = a.m21317c().length();
            if (length < 1) {
                throw new ProcessException("empty resized file", true);
            }
            TempFiles a8;
            if (creativeEditingUploadParams != null && creativeEditingUploadParams.m4459a().m4449l()) {
                m21987a(a, Math.max(a7.a(), a7.b()), creativeEditingUploadParams);
                a8 = m21982a(a, i, creativeEditingUploadParams, BitmapUtils.a(a.m21316b().getAbsolutePath()));
            } else if (!a.m21317c().renameTo(a.m21316b())) {
                throw new ProcessException("can't rename scratch file", true);
            } else if (a.m21316b().length() <= 0) {
                throw new ProcessException("move failed", true);
            } else {
                a8 = a;
            }
            if (dimension != null) {
                try {
                    if (a7.a() < dimension.b || a7.b() < dimension.a) {
                        throw new MinDimensionException("Resized image too small got " + a7.a() + "x" + a7.b() + " but need " + dimension.b + "x" + dimension.a);
                    }
                } catch (Exception e3) {
                    exception = e3;
                    b = a8;
                    e = mediaUploadCancelHandler.m22007e();
                    if (e) {
                        if (b != null) {
                        }
                        m21986a(defaultPhotoFlowLogger, uploadBaseParams, str, a3);
                    }
                    if (b != null) {
                        b.m21315a(false);
                        b.m21314a();
                    }
                    if (e) {
                        defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                        mediaUploadCancelHandler.m22001a("processing");
                    }
                    a2 = m21981a(exception);
                    defaultPhotoFlowLogger.m19926c(uploadBaseParams, a2);
                    throw new ProcessUploadException(a2);
                }
            }
            defaultPhotoFlowLogger.m19879a(uploadBaseParams, "", a6.b, a6.a, -1, -1, a7.a(), a7.b(), -1, -1, -1, length, (long) a7.c());
            return a8;
        } catch (Exception e222) {
            b = null;
            exception = e222;
            e = mediaUploadCancelHandler.m22007e();
            if (e) {
                a3 = (b != null || b.m21317c() == null) ? null : b.m21317c().getAbsolutePath();
                m21986a(defaultPhotoFlowLogger, uploadBaseParams, str, a3);
            }
            if (b != null) {
                b.m21315a(false);
                b.m21314a();
            }
            if (e) {
                defaultPhotoFlowLogger.m19923c(uploadBaseParams);
                mediaUploadCancelHandler.m22001a("processing");
            }
            a2 = m21981a(exception);
            defaultPhotoFlowLogger.m19926c(uploadBaseParams, a2);
            throw new ProcessUploadException(a2);
        }
    }

    private synchronized TempFiles m21982a(TempFiles tempFiles, int i, CreativeEditingUploadParams creativeEditingUploadParams, Dimension dimension) {
        CreativeEditingData a = creativeEditingUploadParams.m4459a();
        if (!(a == null || ((a.m4445h() == null || a.m4445h().isEmpty()) && (a.m4446i() == null || a.m4446i().isEmpty())))) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Uri fromFile = Uri.fromFile(tempFiles.m21316b());
            File c = tempFiles.m21317c();
            try {
                this.f14346r = false;
                RectF c2 = a.m4440c();
                if (c2 == null) {
                    c2 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
                }
                this.f14347s.m20238a(c2, i);
                Collection a2 = this.f14347s.m20237a(a.m4445h());
                ImmutableList i2 = a.m4446i();
                if (!((a2 == null || a2.isEmpty()) && (i2 == null || i2.isEmpty()))) {
                    ImmutableList of;
                    CreativeEditingBitmapHelper creativeEditingBitmapHelper = this.f14343o;
                    int i3 = dimension.b;
                    int i4 = dimension.a;
                    if (a2 == null) {
                        of = ImmutableList.of();
                    } else {
                        of = ImmutableList.copyOf(a2);
                    }
                    if (i2 == null) {
                        i2 = ImmutableList.of();
                    } else {
                        i2 = ImmutableList.copyOf(i2);
                    }
                    ListenableFuture a3 = creativeEditingBitmapHelper.m20214a(fromFile, i3, i4, 0, of, i2, new RectF(0.0f, 0.0f, 1.0f, 1.0f), true);
                    final ImageScaleParam a4 = this.f14334f.m21909a(dimension.b, dimension.a, false);
                    final File file = c;
                    final Uri uri = fromFile;
                    final CountDownLatch countDownLatch2 = countDownLatch;
                    Futures.a(a3, new AbstractDisposableFutureCallback<Bitmap>(this) {
                        final /* synthetic */ DirectPhotoUploader f14312e;

                        protected final void m21966a(Object obj) {
                            Bitmap bitmap = (Bitmap) obj;
                            try {
                                BitmapUtils.a(bitmap, CompressFormat.JPEG, a4.c(), file);
                                this.f14312e.f14332d.a(uri.getPath(), file.getAbsolutePath());
                                this.f14312e.f14346r = true;
                            } catch (BitmapException e) {
                                BLog.b(DirectPhotoUploader.f14329a, "Error writing overlay photo to disk.", e);
                                this.f14312e.f14346r = false;
                            } finally {
                                bitmap.recycle();
                                countDownLatch2.countDown();
                            }
                        }

                        protected final void m21967a(Throwable th) {
                            BLog.b(DirectPhotoUploader.f14329a, "Error creating overlay bitmap.", th);
                            this.f14312e.f14346r = false;
                            countDownLatch2.countDown();
                        }
                    }, this.f14344p);
                    countDownLatch.await();
                    if (!tempFiles.m21317c().renameTo(tempFiles.m21316b())) {
                        throw new ProcessException("can't rename scratch file", true);
                    }
                }
            } catch (Throwable e) {
                BLog.b(f14329a, "Inturrupted", e);
                if (!tempFiles.m21317c().renameTo(tempFiles.m21316b())) {
                    throw new ProcessException("can't rename scratch file", true);
                }
            }
        }
        return tempFiles;
    }

    public final boolean m21995a(String str, String str2, Dimension dimension) {
        File a = this.f14331c.m21335a(str, str2);
        return a == null ? false : m21989a(a, dimension);
    }

    private void m21987a(TempFiles tempFiles, int i, CreativeEditingUploadParams creativeEditingUploadParams) {
        Preconditions.checkNotNull(creativeEditingUploadParams);
        Preconditions.checkNotNull(tempFiles);
        Preconditions.checkNotNull(tempFiles.f13611b);
        if (FiltersEngine.f13035j) {
            String absolutePath = tempFiles.f13611b.getAbsolutePath();
            if (!this.f14335g.m20387a(absolutePath, tempFiles.f13610a.getAbsolutePath(), creativeEditingUploadParams, BitmapUtils.b(absolutePath), i)) {
                throw new ProcessException("AutoEnhance failed", false);
            }
        } else if (!tempFiles.f13611b.renameTo(tempFiles.f13610a)) {
            throw new ProcessException("can't rename scratch file", true);
        } else if (tempFiles.f13610a.length() <= 0) {
            throw new ProcessException("move failed", true);
        }
    }

    private boolean m21989a(File file, Dimension dimension) {
        if (file.exists()) {
            Dimension a = BitmapUtils.a(file.getAbsolutePath());
            if (a.b >= dimension.b && a.a >= dimension.a) {
                return true;
            }
            file.delete();
        }
        return false;
    }

    private void m21986a(DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, String str, String str2) {
        final Writer stringWriter = new StringWriter(1024);
        PrintWriter printWriter = new PrintWriter(stringWriter);
        StatusHelper statusHelper = this.f14341m;
        VMMemoryInfo a = statusHelper.f13609a.a();
        if (!StringUtil.a(null)) {
            printWriter.append(null).append(' ');
        }
        printWriter.append(a.toString());
        if (a.a()) {
            printWriter.append(", low memory device");
        }
        if (statusHelper.f13609a.a(a)) {
            printWriter.append(", low on memory");
        }
        printWriter.append(", fd open: ").print(ProcFileReader.getOpenFDCount());
        OpenFDLimits openFDLimits = ProcFileReader.getOpenFDLimits();
        if (openFDLimits != null) {
            printWriter.append(", fd hard max: ").print(openFDLimits.hardLimit);
            printWriter.append(", fd soft max: ").print(openFDLimits.softLimit);
        }
        StatusHelper.m21312a(printWriter, str, ", source", false);
        if (str2 != null) {
            StatusHelper.m21312a(printWriter, str2, ", tempFile", true);
        }
        defaultPhotoFlowLogger.m19867a(uploadBaseParams, new PhotoFlowLogger$ExceptionReporter(this) {
            final /* synthetic */ DirectPhotoUploader f14314b;

            public final String mo1088b() {
                return null;
            }

            public final String mo1089c() {
                return "processPhoto Exception";
            }

            public final String mo1090d() {
                return stringWriter.toString();
            }

            public final int mo1091e() {
                return -1;
            }

            public final int mo1092f() {
                return -1;
            }

            public final String mo1093g() {
                return null;
            }
        });
    }

    private TransferResult m21985a(UploadPhotoParams uploadPhotoParams, int i, int i2, long j, DefaultPhotoFlowLogger defaultPhotoFlowLogger, UploadBaseParams uploadBaseParams, MediaUploadCancelHandler mediaUploadCancelHandler, ProgressController progressController, ImageSampler imageSampler, ImmediateRetryPolicy immediateRetryPolicy) {
        ExceptionInterpreter exceptionInterpreter;
        int i3;
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        LoggerProgressListener loggerProgressListener = new LoggerProgressListener(progressController, defaultPhotoFlowLogger, uploadBaseParams, mediaUploadCancelHandler);
        apiMethodRunnerParams.a(loggerProgressListener);
        apiMethodRunnerParams.a(mediaUploadCancelHandler.m22006d());
        long j2 = -1;
        int i4 = 0;
        mediaUploadCancelHandler.m22001a("before upload");
        ExceptionInterpreter exceptionInterpreter2 = null;
        while (true) {
            if (i4 > 0) {
                imageSampler.mo1123a(1);
            }
            uploadPhotoParams.m21811a(imageSampler.mo1125a(i, i2, uploadPhotoParams));
            loggerProgressListener.m21976a(j, i4);
            try {
                RequestLogger.m21739a(this.f14339k, uploadPhotoParams);
                j2 = ((Long) this.f14337i.a(this.f14339k, uploadPhotoParams, apiMethodRunnerParams)).longValue();
                if (j2 < 0) {
                    throw new InterpretedException("No fbid", true);
                }
                loggerProgressListener.m21978a(null);
                immediateRetryPolicy.mo1146a();
                exceptionInterpreter = exceptionInterpreter2;
                if (mediaUploadCancelHandler.m22007e() || j2 >= 0) {
                    i3 = i4;
                } else {
                    i3 = i4 + 1;
                    if (i3 > immediateRetryPolicy.mo1151b()) {
                        break;
                    }
                    i4 = i3;
                    exceptionInterpreter2 = exceptionInterpreter;
                }
            } catch (Throwable e) {
                BLog.a(f14329a, e, "Upload failed: %s", new Object[]{this.f14341m.m21313a(uploadPhotoParams.m21812b(), e.getMessage())});
                throw new FileToUploadNotFoundException(this.f14341m.m21313a(uploadPhotoParams.m21812b(), e.getMessage()));
            } catch (Exception e2) {
                exceptionInterpreter = m21981a(e2);
                loggerProgressListener.m21978a(exceptionInterpreter);
                mediaUploadCancelHandler.m22001a("during upload");
                if (exceptionInterpreter.m19967h() && exceptionInterpreter.mo1091e() == 122 && uploadPhotoParams.m21828q()) {
                    throw new InvalidVaultSourceException();
                }
                immediateRetryPolicy.mo1147a(exceptionInterpreter);
            }
        }
        mediaUploadCancelHandler.m22001a("after upload");
        imageSampler.mo1123a(i3);
        if (j2 < 0) {
            if (exceptionInterpreter == null) {
                this.f14340l.a(f14329a.getSimpleName(), "No fbid");
                exceptionInterpreter = m21981a(new InterpretedException("No fbid", true));
            }
            throw new NoFbIdException(exceptionInterpreter);
        }
        progressController.m21979a(1.0f);
        uploadPhotoParams.m21809a(j2);
        if (imageSampler.mo1125a(i, i2, uploadPhotoParams)) {
            imageSampler.mo1122a();
            try {
                this.f14337i.a(this.f14339k, uploadPhotoParams, apiMethodRunnerParams);
            } catch (Throwable e3) {
                BLog.a(f14329a, e3, "Full scale upload failed: %s", new Object[]{e3.getMessage()});
            }
        }
        return new TransferResult(j2, i3);
    }

    private ExceptionInterpreter m21981a(Exception exception) {
        if (exception instanceof RuntimeException) {
            this.f14340l.a(f14329a.getSimpleName(), "Wrapping " + exception.getClass().getSimpleName(), exception);
        }
        return ReportedException.m21701a(exception);
    }
}
