package com.facebook.messaging.attachments;

import android.content.Context;
import android.net.Uri;
import com.facebook.assetdownload.AssetDownloadConfiguration.Builder;
import com.facebook.assetdownload.remote.DownloadExecutionRequest;
import com.facebook.assetdownload.remote.DownloadExecutionResult;
import com.facebook.assetdownload.remote.DownloadExecutor;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.io.Files;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: p2p_confirm_csc */
public class EncryptedAttachmentDownloader {
    private static final Class<?> f7719a = EncryptedAttachmentDownloader.class;
    private static volatile EncryptedAttachmentDownloader f7720f;
    private final Context f7721b;
    private final DownloadExecutor f7722c;
    private final ExecutorService f7723d;
    @GuardedBy("this")
    private final HashMap<String, ListenableFuture<Uri>> f7724e = new HashMap();

    public static com.facebook.messaging.attachments.EncryptedAttachmentDownloader m8016a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7720f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.attachments.EncryptedAttachmentDownloader.class;
        monitor-enter(r1);
        r0 = f7720f;	 Catch:{ all -> 0x003a }
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
        r0 = m8018b(r0);	 Catch:{ all -> 0x0035 }
        f7720f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7720f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attachments.EncryptedAttachmentDownloader.a(com.facebook.inject.InjectorLike):com.facebook.messaging.attachments.EncryptedAttachmentDownloader");
    }

    private static EncryptedAttachmentDownloader m8018b(InjectorLike injectorLike) {
        return new EncryptedAttachmentDownloader((Context) injectorLike.getInstance(Context.class, ForAppContext.class), DownloadExecutor.b(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EncryptedAttachmentDownloader(@ForAppContext Context context, DownloadExecutor downloadExecutor, ExecutorService executorService) {
        this.f7721b = context;
        this.f7722c = downloadExecutor;
        this.f7723d = executorService;
    }

    public final synchronized ListenableFuture<Uri> m8021a(final String str) {
        ListenableFuture<Uri> a;
        final File a2 = EncryptedFileAttachmentUtils.m8022a(this.f7721b, str);
        if (a2.exists()) {
            a = Futures.a(Uri.fromFile(a2));
        } else if (this.f7724e.containsKey(str)) {
            a = (ListenableFuture) this.f7724e.get(str);
        } else {
            final File b = m8019b(str);
            b.delete();
            a = Futures.b(this.f7722c.a(m8015a(m8020c(str), b)), new AsyncFunction<DownloadExecutionResult, Uri>(this) {
                final /* synthetic */ EncryptedAttachmentDownloader f7718d;

                public final ListenableFuture m8013a(@Nullable Object obj) {
                    return Futures.a(EncryptedAttachmentDownloader.m8014a(this.f7718d, str, a2, b));
                }
            }, this.f7723d);
            this.f7724e.put(str, a);
        }
        return a;
    }

    @VisibleForTesting
    private File m8019b(String str) {
        return new File(EncryptedFileAttachmentUtils.m8022a(this.f7721b, str).getAbsolutePath() + ".tmp");
    }

    @VisibleForTesting
    private static Uri m8020c(String str) {
        return Uri.parse("https://www.facebook.com/si/neotenic/" + str);
    }

    private static DownloadExecutionRequest m8015a(Uri uri, File file) {
        Builder builder = new Builder("BlobAttachment");
        builder.b = uri;
        builder = builder;
        builder.i.put("X-MxA0QVGVEJw", "true");
        return new DownloadExecutionRequest(builder.a(), file);
    }

    public static synchronized Uri m8014a(EncryptedAttachmentDownloader encryptedAttachmentDownloader, String str, File file, File file2) {
        Uri fromFile;
        synchronized (encryptedAttachmentDownloader) {
            try {
                Files.c(file2, file);
                encryptedAttachmentDownloader.f7724e.remove(str);
                fromFile = Uri.fromFile(file);
            } catch (IOException e) {
                file2.delete();
                throw e;
            }
        }
        return fromFile;
    }

    @VisibleForTesting
    private static void m8017a(File file, File file2) {
        Files.c(file, file2);
    }
}
