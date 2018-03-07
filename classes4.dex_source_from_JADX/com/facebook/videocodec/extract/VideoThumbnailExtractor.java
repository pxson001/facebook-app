package com.facebook.videocodec.extract;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.io.FileNotFoundException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mHardwareRenderer */
public class VideoThumbnailExtractor {
    private static final Class<?> f8699a = VideoThumbnailExtractor.class;
    private static volatile VideoThumbnailExtractor f8700e;
    private final ContentResolver f8701b;
    private final AbstractFbErrorReporter f8702c;
    private final DefaultAndroidThreadUtil f8703d;

    public static com.facebook.videocodec.extract.VideoThumbnailExtractor m8976a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8700e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.videocodec.extract.VideoThumbnailExtractor.class;
        monitor-enter(r1);
        r0 = f8700e;	 Catch:{ all -> 0x003a }
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
        r0 = m8978b(r0);	 Catch:{ all -> 0x0035 }
        f8700e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8700e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.extract.VideoThumbnailExtractor.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.extract.VideoThumbnailExtractor");
    }

    private static VideoThumbnailExtractor m8978b(InjectorLike injectorLike) {
        return new VideoThumbnailExtractor(ContentResolverMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public VideoThumbnailExtractor(ContentResolver contentResolver, AbstractFbErrorReporter abstractFbErrorReporter, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f8701b = contentResolver;
        this.f8702c = abstractFbErrorReporter;
        this.f8703d = defaultAndroidThreadUtil;
    }

    public final Bitmap m8980a(Uri uri, int i) {
        this.f8703d.b();
        if (uri.getScheme().equals("content")) {
            return m8979c(uri, i);
        }
        if (uri.getScheme().equals("file")) {
            return ThumbnailUtils.createVideoThumbnail(uri.getPath(), i);
        }
        throw new IllegalArgumentException("Video uri must have either \"file://\" or \"content://\" schema. Schema was " + uri.getScheme());
    }

    @TargetApi(10)
    public final Bitmap m8982b(Uri uri, int i) {
        this.f8703d.b();
        return m8977b(uri, i, 0);
    }

    @TargetApi(10)
    public final Bitmap m8981a(Uri uri, int i, int i2) {
        this.f8703d.b();
        return m8977b(uri, i, i2);
    }

    private Bitmap m8979c(Uri uri, int i) {
        Preconditions.checkArgument(uri.getScheme().equals("content"));
        return m8977b(uri, i, -1);
    }

    @TargetApi(10)
    private Bitmap m8977b(Uri uri, int i, int i2) {
        AssetFileDescriptor openAssetFileDescriptor;
        Bitmap frameAtTime;
        Bitmap bitmap;
        Throwable e;
        int width;
        int height;
        int max;
        float f;
        AssetFileDescriptor assetFileDescriptor;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            openAssetFileDescriptor = this.f8701b.openAssetFileDescriptor(uri, "r");
            try {
                mediaMetadataRetriever.setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (i2 == 0) {
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime((long) i2);
                } else {
                    frameAtTime = mediaMetadataRetriever.getFrameAtTime((long) i2, 3);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e2) {
                }
                if (openAssetFileDescriptor != null) {
                    try {
                        openAssetFileDescriptor.close();
                        bitmap = frameAtTime;
                    } catch (Throwable e3) {
                        this.f8702c.a(f8699a.getName(), "Couldn't close file descriptor for video uri: " + uri.toString(), e3);
                        bitmap = frameAtTime;
                    }
                } else {
                    bitmap = frameAtTime;
                }
            } catch (IllegalArgumentException e4) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e5) {
                }
                if (openAssetFileDescriptor != null) {
                    try {
                        openAssetFileDescriptor.close();
                        bitmap = null;
                    } catch (Throwable e32) {
                        this.f8702c.a(f8699a.getName(), "Couldn't close file descriptor for video uri: " + uri.toString(), e32);
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    if (i == 1) {
                        width = bitmap.getWidth();
                        height = bitmap.getHeight();
                        max = Math.max(width, height);
                        if (max <= 512) {
                            return bitmap;
                        }
                        f = 512.0f / ((float) max);
                        return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                    } else if (i == 3) {
                        return bitmap;
                    } else {
                        return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                    }
                }
                bitmap = null;
                if (bitmap == null) {
                    return null;
                }
                if (i == 1) {
                    width = bitmap.getWidth();
                    height = bitmap.getHeight();
                    max = Math.max(width, height);
                    if (max <= 512) {
                        return bitmap;
                    }
                    f = 512.0f / ((float) max);
                    return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                } else if (i == 3) {
                    return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                } else {
                    return bitmap;
                }
            } catch (RuntimeException e6) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e7) {
                }
                if (openAssetFileDescriptor != null) {
                    try {
                        openAssetFileDescriptor.close();
                        bitmap = null;
                    } catch (Throwable e322) {
                        this.f8702c.a(f8699a.getName(), "Couldn't close file descriptor for video uri: " + uri.toString(), e322);
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    if (i == 1) {
                        width = bitmap.getWidth();
                        height = bitmap.getHeight();
                        max = Math.max(width, height);
                        if (max <= 512) {
                            return bitmap;
                        }
                        f = 512.0f / ((float) max);
                        return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                    } else if (i == 3) {
                        return bitmap;
                    } else {
                        return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                    }
                }
                bitmap = null;
                if (bitmap == null) {
                    return null;
                }
                if (i == 1) {
                    width = bitmap.getWidth();
                    height = bitmap.getHeight();
                    max = Math.max(width, height);
                    if (max <= 512) {
                        return bitmap;
                    }
                    f = 512.0f / ((float) max);
                    return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                } else if (i == 3) {
                    return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                } else {
                    return bitmap;
                }
            } catch (Throwable e8) {
                Throwable th = e8;
                assetFileDescriptor = openAssetFileDescriptor;
                e322 = th;
                try {
                    this.f8702c.a(f8699a.getName(), "Couldn't open file descriptor for video uri: " + uri.toString(), e322);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e9) {
                    }
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                            bitmap = null;
                        } catch (Throwable e3222) {
                            this.f8702c.a(f8699a.getName(), "Couldn't close file descriptor for video uri: " + uri.toString(), e3222);
                            bitmap = null;
                        }
                        if (bitmap == null) {
                            return null;
                        }
                        if (i == 1) {
                            width = bitmap.getWidth();
                            height = bitmap.getHeight();
                            max = Math.max(width, height);
                            if (max <= 512) {
                                return bitmap;
                            }
                            f = 512.0f / ((float) max);
                            return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                        } else if (i == 3) {
                            return bitmap;
                        } else {
                            return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                        }
                    }
                    bitmap = null;
                    if (bitmap == null) {
                        return null;
                    }
                    if (i == 1) {
                        width = bitmap.getWidth();
                        height = bitmap.getHeight();
                        max = Math.max(width, height);
                        if (max <= 512) {
                            return bitmap;
                        }
                        f = 512.0f / ((float) max);
                        return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                    } else if (i == 3) {
                        return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                    } else {
                        return bitmap;
                    }
                } catch (Throwable th2) {
                    e3222 = th2;
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e10) {
                    }
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (Throwable e11) {
                            this.f8702c.a(f8699a.getName(), "Couldn't close file descriptor for video uri: " + uri.toString(), e11);
                        }
                    }
                    throw e3222;
                }
            } catch (Throwable e112) {
                assetFileDescriptor = openAssetFileDescriptor;
                e3222 = e112;
                mediaMetadataRetriever.release();
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                throw e3222;
            }
        } catch (IllegalArgumentException e12) {
            openAssetFileDescriptor = null;
            mediaMetadataRetriever.release();
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
                bitmap = null;
                if (bitmap == null) {
                    return null;
                }
                if (i == 1) {
                    width = bitmap.getWidth();
                    height = bitmap.getHeight();
                    max = Math.max(width, height);
                    if (max <= 512) {
                        return bitmap;
                    }
                    f = 512.0f / ((float) max);
                    return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                } else if (i == 3) {
                    return bitmap;
                } else {
                    return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                }
            }
            bitmap = null;
            if (bitmap == null) {
                return null;
            }
            if (i == 1) {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
                max = Math.max(width, height);
                if (max <= 512) {
                    return bitmap;
                }
                f = 512.0f / ((float) max);
                return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
            } else if (i == 3) {
                return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
            } else {
                return bitmap;
            }
        } catch (RuntimeException e13) {
            openAssetFileDescriptor = null;
            mediaMetadataRetriever.release();
            if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
                bitmap = null;
                if (bitmap == null) {
                    return null;
                }
                if (i == 1) {
                    width = bitmap.getWidth();
                    height = bitmap.getHeight();
                    max = Math.max(width, height);
                    if (max <= 512) {
                        return bitmap;
                    }
                    f = 512.0f / ((float) max);
                    return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                } else if (i == 3) {
                    return bitmap;
                } else {
                    return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                }
            }
            bitmap = null;
            if (bitmap == null) {
                return null;
            }
            if (i == 1) {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
                max = Math.max(width, height);
                if (max <= 512) {
                    return bitmap;
                }
                f = 512.0f / ((float) max);
                return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
            } else if (i == 3) {
                return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
            } else {
                return bitmap;
            }
        } catch (FileNotFoundException e14) {
            e3222 = e14;
            assetFileDescriptor = null;
            this.f8702c.a(f8699a.getName(), "Couldn't open file descriptor for video uri: " + uri.toString(), e3222);
            mediaMetadataRetriever.release();
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
                bitmap = null;
                if (bitmap == null) {
                    return null;
                }
                if (i == 1) {
                    width = bitmap.getWidth();
                    height = bitmap.getHeight();
                    max = Math.max(width, height);
                    if (max <= 512) {
                        return bitmap;
                    }
                    f = 512.0f / ((float) max);
                    return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
                } else if (i == 3) {
                    return bitmap;
                } else {
                    return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
                }
            }
            bitmap = null;
            if (bitmap == null) {
                return null;
            }
            if (i == 1) {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
                max = Math.max(width, height);
                if (max <= 512) {
                    return bitmap;
                }
                f = 512.0f / ((float) max);
                return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
            } else if (i == 3) {
                return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
            } else {
                return bitmap;
            }
        } catch (Throwable th3) {
            e3222 = th3;
            assetFileDescriptor = null;
            mediaMetadataRetriever.release();
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            throw e3222;
        }
        if (bitmap == null) {
            return null;
        }
        if (i == 1) {
            width = bitmap.getWidth();
            height = bitmap.getHeight();
            max = Math.max(width, height);
            if (max <= 512) {
                return bitmap;
            }
            f = 512.0f / ((float) max);
            return Bitmap.createScaledBitmap(bitmap, Math.round(((float) width) * f), Math.round(((float) height) * f), true);
        } else if (i == 3) {
            return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
        } else {
            return bitmap;
        }
    }
}
