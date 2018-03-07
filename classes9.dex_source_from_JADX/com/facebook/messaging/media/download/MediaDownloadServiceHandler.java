package com.facebook.messaging.media.download;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.bitmaps.WebpTranscoder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.attachments.CryptoHandler;
import com.facebook.messaging.attachments.EncryptedFileAttachmentUtils;
import com.facebook.messaging.attachments.VideoAttachmentData;
import com.facebook.messaging.media.download.DownloadedMedia.ResultCode;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper;
import com.facebook.messaging.media.imageurirequest.ImageUriRequestManager;
import com.facebook.messaging.media.photoquality.PhotoQualityHelper;
import com.facebook.video.engine.VideoDataSource;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.io.Closeables;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

/* compiled from: mErrorMessage */
public class MediaDownloadServiceHandler implements BlueServiceHandler {
    private static final Pattern f11542a = Pattern.compile("\\.|:");
    private static final ImmutableSet<String> f11543b = m12186a();
    private final Context f11544c;
    private final AnalyticsLogger f11545d;
    private final AbstractFbErrorReporter f11546e;
    private final Lazy<WebpTranscoder> f11547f;
    private final FbHttpRequestProcessor f11548g;
    private final TempFileManager f11549h;
    private final ImageUriRequestManager f11550i;
    private final PhotoQualityHelper f11551j;
    private final GatekeeperStoreImpl f11552k;
    private final ImagePipelineWrapper f11553l;
    private final CryptoHandler f11554m;
    private final File f11555n;
    private final File f11556o;

    /* compiled from: mErrorMessage */
    class FileDownloadResponseHandler implements ResponseHandler<Void> {
        final /* synthetic */ MediaDownloadServiceHandler f11540a;
        private final File f11541b;

        public FileDownloadResponseHandler(MediaDownloadServiceHandler mediaDownloadServiceHandler, File file) {
            this.f11540a = mediaDownloadServiceHandler;
            this.f11541b = file;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            StatusLine statusLine = httpResponse.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            HttpEntity entity = httpResponse.getEntity();
            if (statusCode != 200) {
                throw new HttpResponseException(statusCode, statusLine.getReasonPhrase());
            } else if (entity == null) {
                throw new ClientProtocolException("Missing HTTP entity");
            } else {
                String a = NetworkDataLogUtils.a(httpResponse);
                InputStream bufferedInputStream = new BufferedInputStream(entity.getContent());
                try {
                    MediaDownloadServiceHandler.m12192a(this.f11540a, bufferedInputStream, this.f11541b, "image/webp".equals(a));
                    return null;
                } finally {
                    bufferedInputStream.close();
                }
            }
        }
    }

    public static MediaDownloadServiceHandler m12196b(InjectorLike injectorLike) {
        return new MediaDownloadServiceHandler((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4982), PhotoDirectoryProvider.m12203a(), File_VideoDirectoryMethodAutoProvider.m12169a(injectorLike), TempFileManager.a(injectorLike), ImageUriRequestManager.b(injectorLike), PhotoQualityHelper.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ImagePipelineWrapper.a(injectorLike), CryptoHandler.b(injectorLike));
    }

    public final OperationResult m12201a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("photo_download".equals(str)) {
            return m12195b(operationParams);
        }
        if ("video_download".equals(str)) {
            return m12200d(operationParams);
        }
        if ("save_mms_photo".equals(str)) {
            return m12199c(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    private OperationResult m12195b(OperationParams operationParams) {
        DownloadPhotosParams downloadPhotosParams = (DownloadPhotosParams) operationParams.c.getParcelable("downloadPhotosParams");
        ArrayList a = Lists.a();
        ImmutableList immutableList = downloadPhotosParams.f11512a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(m12185a(downloadPhotosParams, (PhotoToDownload) immutableList.get(i), operationParams.e));
        }
        return OperationResult.a(a);
    }

    private OperationResult m12199c(OperationParams operationParams) {
        return OperationResult.a(m12184a(((SaveMmsPhotoParams) operationParams.c.getParcelable("saveMmsPhotoParams")).f11559a));
    }

    private OperationResult m12200d(OperationParams operationParams) {
        VideoAttachmentData videoAttachmentData = (VideoAttachmentData) operationParams.c.getParcelable("video_attachment_data");
        if (!m12198b()) {
            return OperationResult.a(ErrorCode.OTHER);
        }
        for (VideoDataSource videoDataSource : videoAttachmentData.f7769f) {
            Uri uri = videoDataSource.b;
            if (FacebookUriUtil.f(uri)) {
                File a = m12189a(videoAttachmentData.f7772i);
                if (a.exists()) {
                    return OperationResult.a(new DownloadedMedia(ResultCode.PRE_EXISTING, Uri.fromFile(a)));
                }
                if (m12194a(uri, a, videoAttachmentData, operationParams.e)) {
                    this.f11544c.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(a)));
                    return OperationResult.a(new DownloadedMedia(ResultCode.DOWNLOADED, Uri.fromFile(a)));
                }
            } else {
                this.f11546e.a("MediaDownloadServiceHandler", "Called with non-http URI: " + uri);
            }
        }
        return OperationResult.a(ErrorCode.OTHER);
    }

    private static ImmutableSet<String> m12186a() {
        Builder builder = ImmutableSet.builder();
        for (ImageFormat imageFormat : ImageFormat.values()) {
            if (imageFormat != ImageFormat.UNKNOWN) {
                try {
                    builder.c(ImageFormat.getFileExtension(imageFormat));
                } catch (Throwable e) {
                    BLog.c("MediaDownloadServiceHandler", e, "Unknown image format %s", new Object[]{imageFormat.name()});
                }
            }
        }
        return builder.b();
    }

    @Inject
    public MediaDownloadServiceHandler(Context context, AnalyticsLogger analyticsLogger, FbHttpRequestProcessor fbHttpRequestProcessor, FbErrorReporter fbErrorReporter, Lazy<WebpTranscoder> lazy, File file, File file2, TempFileManager tempFileManager, ImageUriRequestManager imageUriRequestManager, PhotoQualityHelper photoQualityHelper, GatekeeperStore gatekeeperStore, ImagePipelineWrapper imagePipelineWrapper, CryptoHandler cryptoHandler) {
        this.f11544c = context;
        this.f11545d = analyticsLogger;
        this.f11546e = fbErrorReporter;
        this.f11548g = fbHttpRequestProcessor;
        this.f11547f = lazy;
        this.f11555n = file;
        this.f11556o = file2;
        this.f11549h = tempFileManager;
        this.f11550i = imageUriRequestManager;
        this.f11551j = photoQualityHelper;
        this.f11552k = gatekeeperStore;
        this.f11553l = imagePipelineWrapper;
        this.f11554m = cryptoHandler;
    }

    private DownloadedMedia m12185a(DownloadPhotosParams downloadPhotosParams, PhotoToDownload photoToDownload, CallerContext callerContext) {
        if (photoToDownload.f11557a == null) {
            this.f11546e.a("MediaDownloadServiceHandler", "Called with no FBID.");
            return new DownloadedMedia(ResultCode.FAILURE, null);
        }
        boolean z = downloadPhotosParams.f11514c;
        String replaceAll = f11542a.matcher(photoToDownload.f11557a).replaceAll("_");
        File a = m12202a(replaceAll, downloadPhotosParams.f11513b);
        if (a != null && !z) {
            return new DownloadedMedia(ResultCode.PRE_EXISTING, Uri.fromFile(a));
        }
        File a2 = m12190a(replaceAll, "tmp", downloadPhotosParams.f11513b);
        if (a2 == null) {
            this.f11546e.a("MediaDownloadServiceHandler", "Could not create photo file for saving");
            return new DownloadedMedia(ResultCode.FAILURE, null);
        }
        try {
            Uri a3;
            m12193a("messenger_save_photo_start", photoToDownload.f11557a, Boolean.valueOf(z), callerContext.c());
            if (photoToDownload.f11558b != null) {
                byte[] b = this.f11554m.b(Uri.fromFile(EncryptedFileAttachmentUtils.m8022a(this.f11544c, photoToDownload.f11557a)), photoToDownload.f11558b);
                FileOutputStream fileOutputStream = new FileOutputStream(a2);
                fileOutputStream.write(b);
                fileOutputStream.close();
            } else {
                a3 = this.f11550i.a(photoToDownload.f11557a, this.f11551j.a(), callerContext);
                if (a3 == null) {
                    this.f11546e.a("MediaDownloadServiceHandler", "Could not retrieve URL of image");
                    return new DownloadedMedia(ResultCode.FAILURE, null);
                }
                m12191a(a3, a2, callerContext);
            }
            a3 = Uri.fromFile(m12188a(a2));
            this.f11544c.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", a3));
            m12193a("messenger_save_photo_success", photoToDownload.f11557a, Boolean.valueOf(z), callerContext.c());
            return new DownloadedMedia(ResultCode.DOWNLOADED, a3);
        } catch (Throwable e) {
            BLog.b("MediaDownloadServiceHandler", "Unable to download to file ", e);
            m12193a("messenger_save_photo_fail", photoToDownload.f11557a, Boolean.valueOf(z), callerContext.c());
            return new DownloadedMedia(ResultCode.FAILURE, null);
        } catch (Throwable e2) {
            BLog.b("MediaDownloadServiceHandler", "Unable to download to file ", e2);
            m12193a("messenger_save_photo_fail", photoToDownload.f11557a, Boolean.valueOf(z), callerContext.c());
            return new DownloadedMedia(ResultCode.FAILURE, null);
        } catch (Throwable e22) {
            BLog.b("MediaDownloadServiceHandler", "Unable to download to file ", e22);
            m12193a("messenger_save_photo_fail", photoToDownload.f11557a, Boolean.valueOf(z), callerContext.c());
            return new DownloadedMedia(ResultCode.FAILURE, null);
        }
    }

    private DownloadedMedia m12184a(Uri uri) {
        InputStream openInputStream;
        OutputStream fileOutputStream;
        DownloadedMedia downloadedMedia;
        Throwable e;
        InputStream inputStream = null;
        File b = m12197b(uri);
        if (b == null) {
            this.f11546e.a("MediaDownloadServiceHandler", "Could not create photo file for saving");
            return new DownloadedMedia(ResultCode.FAILURE, null);
        } else if (b.exists()) {
            return new DownloadedMedia(ResultCode.PRE_EXISTING, null);
        } else {
            try {
                openInputStream = this.f11544c.getContentResolver().openInputStream(uri);
                try {
                    fileOutputStream = new FileOutputStream(b);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = openInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        Uri fromFile = Uri.fromFile(m12188a(b));
                        this.f11544c.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                        downloadedMedia = new DownloadedMedia(ResultCode.DOWNLOADED, fromFile);
                        if (openInputStream != null) {
                            Closeables.a(openInputStream);
                        }
                        try {
                            fileOutputStream.close();
                            return downloadedMedia;
                        } catch (IOException e2) {
                            return downloadedMedia;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = openInputStream;
                        try {
                            BLog.b("MediaDownloadServiceHandler", e, "failed to save mms photo", new Object[0]);
                            downloadedMedia = new DownloadedMedia(ResultCode.FAILURE, null);
                            if (inputStream != null) {
                                Closeables.a(inputStream);
                            }
                            if (fileOutputStream != null) {
                                return downloadedMedia;
                            }
                            try {
                                fileOutputStream.close();
                                return downloadedMedia;
                            } catch (IOException e4) {
                                return downloadedMedia;
                            }
                        } catch (Throwable th) {
                            e = th;
                            openInputStream = inputStream;
                            if (openInputStream != null) {
                                Closeables.a(openInputStream);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (openInputStream != null) {
                            Closeables.a(openInputStream);
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileOutputStream = null;
                    inputStream = openInputStream;
                    BLog.b("MediaDownloadServiceHandler", e, "failed to save mms photo", new Object[0]);
                    downloadedMedia = new DownloadedMedia(ResultCode.FAILURE, null);
                    if (inputStream != null) {
                        Closeables.a(inputStream);
                    }
                    if (fileOutputStream != null) {
                        return downloadedMedia;
                    }
                    fileOutputStream.close();
                    return downloadedMedia;
                } catch (Throwable th3) {
                    e = th3;
                    fileOutputStream = null;
                    if (openInputStream != null) {
                        Closeables.a(openInputStream);
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                BLog.b("MediaDownloadServiceHandler", e, "failed to save mms photo", new Object[0]);
                downloadedMedia = new DownloadedMedia(ResultCode.FAILURE, null);
                if (inputStream != null) {
                    Closeables.a(inputStream);
                }
                if (fileOutputStream != null) {
                    return downloadedMedia;
                }
                fileOutputStream.close();
                return downloadedMedia;
            } catch (Throwable th4) {
                e = th4;
                fileOutputStream = null;
                openInputStream = null;
                if (openInputStream != null) {
                    Closeables.a(openInputStream);
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
    }

    @Nullable
    private File m12197b(Uri uri) {
        StringBuilder append = new StringBuilder(256).append(uri.getLastPathSegment()).append("_").append(System.currentTimeMillis()).append(".tmp");
        File a = m12187a(PhotoDownloadDestination.GALLERY);
        if (a != null) {
            return new File(a, append.toString());
        }
        this.f11546e.a("MediaDownloadServiceHandler", "Failed to create directory to save photos.");
        return null;
    }

    @Nullable
    public final File m12202a(String str, PhotoDownloadDestination photoDownloadDestination) {
        if (photoDownloadDestination == PhotoDownloadDestination.TEMP) {
            photoDownloadDestination = PhotoDownloadDestination.GALLERY;
        }
        Iterator it = f11543b.iterator();
        while (it.hasNext()) {
            File a = m12190a(str, (String) it.next(), photoDownloadDestination);
            if (a != null && a.exists()) {
                return a;
            }
        }
        return null;
    }

    private void m12191a(Uri uri, File file, CallerContext callerContext) {
        if (this.f11552k.a(205, false)) {
            CloseableReference a = m12183a(uri, callerContext);
            if (a == null) {
                throw new IOException("Closeable reference is null. uri=" + uri.toString());
            }
            InputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) a.a());
            try {
                m12192a(this, pooledByteBufferInputStream, file, ImageFormat.isWebpFormat(ImageFormatChecker.a(pooledByteBufferInputStream)));
            } finally {
                Closeables.a(pooledByteBufferInputStream);
                CloseableReference.c(a);
            }
        } else {
            this.f11548g.a(FbHttpRequest.newBuilder().a("MessengerPhotoDownload").a(callerContext).a(new HttpGet(new URI(uri.toString()))).a(new FileDownloadResponseHandler(this, file)).a());
        }
    }

    private CloseableReference<PooledByteBuffer> m12183a(Uri uri, CallerContext callerContext) {
        return (CloseableReference) Uninterruptibles.a(DataSourceToFutureAdapter.a(this.f11553l.a(ImageRequestBuilder.a(uri), callerContext)));
    }

    private static File m12188a(File file) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            ImageFormat a = ImageFormatChecker.a(fileInputStream);
            Object obj = null;
            try {
                obj = ImageFormat.getFileExtension(a);
            } catch (Throwable e) {
                BLog.c("MediaDownloadServiceHandler", e, "Unknown image format %s", new Object[]{a.name()});
            }
            if (Files.a(file.getName()).equalsIgnoreCase(obj) || TextUtils.isEmpty(obj)) {
                return file;
            }
            File file2 = new File(file.getParentFile(), Files.b(file.getName()) + "." + obj);
            if (file.renameTo(file2)) {
                return file2;
            }
            BLog.a("MediaDownloadServiceHandler", "Could not rename file %s to %s", new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return file;
        } finally {
            fileInputStream.close();
        }
    }

    private boolean m12194a(Uri uri, File file, VideoAttachmentData videoAttachmentData, CallerContext callerContext) {
        m12193a("messenger_save_video_start", videoAttachmentData.f7772i, null, callerContext.c());
        try {
            this.f11548g.a(FbHttpRequest.newBuilder().a("MessengerVideoDownload").a(callerContext).a(new HttpGet(new URI(uri.toString()))).a(new FileDownloadResponseHandler(this, file)).a());
            m12193a("messenger_save_video_success", videoAttachmentData.f7772i, null, callerContext.c());
            return true;
        } catch (IOException e) {
            this.f11546e.a("MediaDownloadServiceHandler", "Unable to write to file " + e.getMessage());
            m12193a("messenger_save_video_fail", videoAttachmentData.f7772i, null, callerContext.c());
            return false;
        } catch (URISyntaxException e2) {
            this.f11546e.a("MediaDownloadServiceHandler", "Unable to write to file " + e2.getMessage());
            m12193a("messenger_save_video_fail", videoAttachmentData.f7772i, null, callerContext.c());
            return false;
        }
    }

    private void m12193a(String str, String str2, @Nullable Boolean bool, @Nullable String str3) {
        HoneyClientEventFast a = this.f11545d.a(str, false);
        if (a.a()) {
            a.a("media_fbid", str2);
            if (bool != null) {
                a.a("is_auto_download", bool.booleanValue());
            }
            if (str3 != null) {
                a.a("download_media_caller_context", str3);
            }
            a.b();
        }
    }

    @Nullable
    private File m12190a(String str, String str2, PhotoDownloadDestination photoDownloadDestination) {
        StringBuilder append = new StringBuilder(256).append("received_").append(str);
        switch (photoDownloadDestination) {
            case GALLERY:
                File a = m12187a(photoDownloadDestination);
                if (a != null) {
                    return new File(a, append.append(".").append(str2).toString());
                }
                this.f11546e.a("MediaDownloadServiceHandler", "Failed to create directory to save photos.");
                return null;
            case TEMP:
                return this.f11549h.a(append.append("_").toString(), "." + str2, Privacy.PREFER_SDCARD);
            default:
                return null;
        }
    }

    private File m12189a(String str) {
        Preconditions.checkState(m12198b(), "Failed to create directory to save videos.");
        return new File(this.f11556o, "received_" + str + ".mp4");
    }

    @Nullable
    private File m12187a(PhotoDownloadDestination photoDownloadDestination) {
        switch (photoDownloadDestination) {
            case GALLERY:
                File file = this.f11555n;
                if (file.exists() || file.mkdirs()) {
                    return file;
                }
                return null;
            default:
                return null;
        }
    }

    private boolean m12198b() {
        return this.f11556o.exists() || this.f11556o.mkdirs();
    }

    public static void m12192a(MediaDownloadServiceHandler mediaDownloadServiceHandler, InputStream inputStream, File file, boolean z) {
        if (z) {
            OutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ((WebpTranscoder) mediaDownloadServiceHandler.f11547f.get()).a(inputStream, fileOutputStream, 90);
            } finally {
                fileOutputStream.close();
            }
        } else {
            Files.a(file, new FileWriteMode[0]).a(inputStream);
        }
    }
}
