package com.facebook.assetdownload.remote;

import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: profile_photo_prompt_canceled */
public class DownloadExecutor {
    private final ListeningExecutorService f7344a;
    private final AssetMediaDownloader f7345b;

    /* compiled from: profile_photo_prompt_canceled */
    class DownloadCallable implements Callable<DownloadExecutionResult> {
        private final DownloadExecutionRequest f7341a;
        private final AssetMediaDownloader f7342b;

        public DownloadCallable(DownloadExecutionRequest downloadExecutionRequest, AssetMediaDownloader assetMediaDownloader) {
            this.f7341a = downloadExecutionRequest;
            this.f7342b = assetMediaDownloader;
        }

        public Object call() {
            return (DownloadExecutionResult) this.f7342b.a(new MediaDownloadRequest(this.f7341a.f7337a.m10373a(), new DownloadExecutorHandler(this.f7341a), StringUtil.a(this.f7341a.m10443d()) ? CallerContext.a(DownloadExecutor.class) : CallerContext.b(DownloadExecutor.class, this.f7341a.m10443d()), this.f7341a.f7337a.mHttpHeaders));
        }
    }

    /* compiled from: profile_photo_prompt_canceled */
    class DownloadExecutorHandler implements DownloadResultResponseHandler<DownloadExecutionResult> {
        private final DownloadExecutionRequest f7343a;

        public DownloadExecutorHandler(DownloadExecutionRequest downloadExecutionRequest) {
            this.f7343a = downloadExecutionRequest;
        }

        public final Object m10445a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            if (inputStream == null) {
                throw new IOException("responseData is not available");
            }
            try {
                Object downloadExecutionResult = new DownloadExecutionResult(this.f7343a, Files.a(this.f7343a.m10442b(), new FileWriteMode[0]).a(inputStream));
                return downloadExecutionResult;
            } finally {
                inputStream.close();
            }
        }
    }

    public static DownloadExecutor m10446b(InjectorLike injectorLike) {
        return new DownloadExecutor(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), AssetMediaDownloader.m10440a(injectorLike));
    }

    @Inject
    public DownloadExecutor(ListeningExecutorService listeningExecutorService, AssetMediaDownloader assetMediaDownloader) {
        this.f7344a = listeningExecutorService;
        this.f7345b = assetMediaDownloader;
    }

    public final ListenableFuture<DownloadExecutionResult> m10447a(DownloadExecutionRequest downloadExecutionRequest) {
        return this.f7344a.a(new DownloadCallable(downloadExecutionRequest, this.f7345b));
    }
}
