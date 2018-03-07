package com.facebook.photos.creativeediting.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.io.FbCloseables;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: incentives */
public class CreativeEditingImageHelper {
    public static final String f12835a = CreativeEditingImageHelper.class.getSimpleName();
    private final Context f12836b;
    public final Lazy<BitmapUtils> f12837c;
    public final Lazy<TempFileManager> f12838d;
    private final CreativeEditingBitmapHelper f12839e;
    @DefaultExecutorService
    private final ExecutorService f12840f;

    public static CreativeEditingImageHelper m20223b(InjectorLike injectorLike) {
        return new CreativeEditingImageHelper((Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 406), IdBasedSingletonScopeProvider.b(injectorLike, 600), CreativeEditingBitmapHelper.m20213b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    public static CreativeEditingImageHelper m20222a(InjectorLike injectorLike) {
        return m20223b(injectorLike);
    }

    @Inject
    public CreativeEditingImageHelper(Context context, Lazy<BitmapUtils> lazy, Lazy<TempFileManager> lazy2, CreativeEditingBitmapHelper creativeEditingBitmapHelper, ExecutorService executorService) {
        this.f12836b = context;
        this.f12837c = lazy;
        this.f12838d = lazy2;
        this.f12839e = creativeEditingBitmapHelper;
        this.f12840f = executorService;
    }

    public final ListenableFuture<Uri> m20224a(float f, CreativeEditingData creativeEditingData, final Uri uri, final boolean z) {
        RectF c = creativeEditingData.m4440c() != null ? creativeEditingData.m4440c() : new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        this.f12837c.get();
        Dimension a = BitmapUtils.a(uri.getPath());
        CreativeEditingBitmapHelper creativeEditingBitmapHelper = this.f12839e;
        int i = (int) (((float) a.b) * f);
        int i2 = (int) (((float) a.a) * f);
        this.f12837c.get();
        return Futures.b(creativeEditingBitmapHelper.m20214a(uri, i, i2, BitmapUtils.b(uri.getPath()), creativeEditingData.m4445h(), creativeEditingData.m4446i(), c, false), new AsyncFunction<Bitmap, Uri>(this) {
            final /* synthetic */ CreativeEditingImageHelper f12834c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final com.google.common.util.concurrent.ListenableFuture m20221a(java.lang.Object r7) {
                /*
                r6 = this;
                r7 = (android.graphics.Bitmap) r7;
                r0 = r12;
                r0 = r0.getPath();
                r1 = com.google.common.io.Files.b(r0);
                r0 = r12;
                r0 = r0.getPath();
                r2 = com.google.common.io.Files.a(r0);
                r0 = r6.f12834c;
                r0 = r0.f12838d;
                r0 = r0.get();
                r0 = (com.facebook.common.tempfile.TempFileManager) r0;
                r3 = new java.lang.StringBuilder;
                r4 = "FB_CT_";
                r3.<init>(r4);
                r3 = r3.append(r1);
                r4 = "_";
                r3 = r3.append(r4);
                r3 = r3.toString();
                r4 = new java.lang.StringBuilder;
                r5 = ".";
                r4.<init>(r5);
                r2 = r4.append(r2);
                r2 = r2.toString();
                r4 = com.facebook.common.tempfile.TempFileManager.Privacy.REQUIRE_PRIVATE;
                r2 = r0.a(r3, r2, r4);
                r0 = r6.f12834c;	 Catch:{ BitmapException -> 0x009d }
                r0 = r0.f12837c;	 Catch:{ BitmapException -> 0x009d }
                r0.get();	 Catch:{ BitmapException -> 0x009d }
                r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ BitmapException -> 0x009d }
                r3 = 80;
                com.facebook.bitmaps.BitmapUtils.a(r7, r0, r3, r2);	 Catch:{ BitmapException -> 0x009d }
                r0 = r6.f12834c;	 Catch:{ BitmapException -> 0x009d }
                r0 = r0.f12837c;	 Catch:{ BitmapException -> 0x009d }
                r0 = r0.get();	 Catch:{ BitmapException -> 0x009d }
                r0 = (com.facebook.bitmaps.BitmapUtils) r0;	 Catch:{ BitmapException -> 0x009d }
                r3 = r12;	 Catch:{ BitmapException -> 0x009d }
                r3 = r3.getPath();	 Catch:{ BitmapException -> 0x009d }
                r4 = r2.getPath();	 Catch:{ BitmapException -> 0x009d }
                r0.a(r3, r4);	 Catch:{ BitmapException -> 0x009d }
                r0 = r13;	 Catch:{ BitmapException -> 0x009d }
                if (r0 == 0) goto L_0x0091;
            L_0x0073:
                r0 = r6.f12834c;	 Catch:{ BitmapException -> 0x009d }
                r3 = android.net.Uri.fromFile(r2);	 Catch:{ BitmapException -> 0x009d }
                r4 = new java.lang.StringBuilder;	 Catch:{ BitmapException -> 0x009d }
                r5 = "edited_";
                r4.<init>(r5);	 Catch:{ BitmapException -> 0x009d }
                r1 = r4.append(r1);	 Catch:{ BitmapException -> 0x009d }
                r4 = ".jpg";
                r1 = r1.append(r4);	 Catch:{ BitmapException -> 0x009d }
                r1 = r1.toString();	 Catch:{ BitmapException -> 0x009d }
                r0.m20225a(r3, r1);	 Catch:{ BitmapException -> 0x009d }
            L_0x0091:
                r7.recycle();
            L_0x0094:
                r0 = android.net.Uri.fromFile(r2);
                r0 = com.google.common.util.concurrent.Futures.a(r0);
                return r0;
            L_0x009d:
                r0 = move-exception;
                r1 = com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper.f12835a;	 Catch:{ all -> 0x00a9 }
                r3 = "Error saving masterpiece to disk";
                com.facebook.debug.log.BLog.b(r1, r3, r0);	 Catch:{ all -> 0x00a9 }
                r7.recycle();
                goto L_0x0094;
            L_0x00a9:
                r0 = move-exception;
                r7.recycle();
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper.1.a(java.lang.Object):com.google.common.util.concurrent.ListenableFuture");
            }
        }, this.f12840f);
    }

    public final void m20225a(Uri uri, String str) {
        Closeable channel;
        Throwable th;
        Throwable th2;
        Closeable closeable = null;
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Facebook_edited");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(uri.getPath());
            File file3 = new File(file, str);
            try {
                channel = new FileInputStream(file2).getChannel();
                try {
                    Closeable channel2 = new FileOutputStream(file3).getChannel();
                    try {
                        channel2.transferFrom(channel, 0, channel.size());
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(file3));
                        this.f12836b.sendBroadcast(intent);
                        FbCloseables.a(channel);
                        FbCloseables.a(channel2);
                    } catch (Throwable e) {
                        th = e;
                        closeable = channel;
                        channel = channel2;
                        th2 = th;
                        try {
                            BLog.b(f12835a, "failed copy image to gallery", th2);
                            FbCloseables.a(closeable);
                            FbCloseables.a(channel);
                        } catch (Throwable th3) {
                            th2 = th3;
                            Closeable closeable2 = channel;
                            channel = closeable;
                            closeable = closeable2;
                            FbCloseables.a(channel);
                            FbCloseables.a(closeable);
                            throw th2;
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        closeable = channel2;
                        th2 = th;
                        FbCloseables.a(channel);
                        FbCloseables.a(closeable);
                        throw th2;
                    }
                } catch (IOException e3) {
                    th2 = e3;
                    closeable = channel;
                    channel = null;
                    BLog.b(f12835a, "failed copy image to gallery", th2);
                    FbCloseables.a(closeable);
                    FbCloseables.a(channel);
                } catch (Throwable th4) {
                    th2 = th4;
                    FbCloseables.a(channel);
                    FbCloseables.a(closeable);
                    throw th2;
                }
            } catch (IOException e4) {
                th2 = e4;
                channel = null;
                BLog.b(f12835a, "failed copy image to gallery", th2);
                FbCloseables.a(closeable);
                FbCloseables.a(channel);
            } catch (Throwable th5) {
                th2 = th5;
                channel = null;
                FbCloseables.a(channel);
                FbCloseables.a(closeable);
                throw th2;
            }
        }
    }
}
