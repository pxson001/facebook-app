package com.facebook.messengerwear.support;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.animated.gif.GifImage;
import com.facebook.animated.webp.WebPImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.debug.log.BLog;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ultralight.Inject;
import com.google.common.io.ByteStreams;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: photo_menu */
public class MessengerWearMediaFetcher {
    public static final Class f5037a = MessengerWearMediaFetcher.class;
    private static final CallerContext f5038b = CallerContext.a(MessengerWearMediaFetcher.class);
    @Inject
    public Provider<StickerCache> f5039c;
    @Inject
    public FetchStickerCoordinator f5040d;
    @BackgroundExecutorService
    @Inject
    public ExecutorService f5041e;
    @Inject
    private ImagePipeline f5042f;
    @Inject
    @ForUiThread
    public ExecutorService f5043g;
    @Inject
    private PlatformBitmapFactory f5044h;

    /* compiled from: photo_menu */
    /* synthetic */ class C06935 {
        static final /* synthetic */ int[] f5031a = new int[ImageFormat.values().length];

        static {
            try {
                f5031a[ImageFormat.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5031a[ImageFormat.WEBP_ANIMATED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: photo_menu */
    public class MediaData {
        public final String f5032a;
        public final byte[][] f5033b;
        public final int[] f5034c;
        public final int f5035d;
        public final int f5036e;

        public MediaData(String str, byte[] bArr) {
            this.f5032a = str;
            this.f5036e = 1;
            this.f5033b = new byte[1][];
            this.f5033b[0] = bArr;
            this.f5034c = null;
            this.f5035d = 0;
        }

        public MediaData(String str, byte[][] bArr, int[] iArr, int i) {
            this.f5036e = bArr.length;
            this.f5032a = str;
            this.f5033b = bArr;
            this.f5034c = iArr;
            this.f5035d = i;
        }
    }

    public static MessengerWearMediaFetcher m4548b(InjectorLike injectorLike) {
        MessengerWearMediaFetcher messengerWearMediaFetcher = new MessengerWearMediaFetcher();
        messengerWearMediaFetcher.m4547a(IdBasedProvider.a(injectorLike, 3445), FetchStickerCoordinator.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
        return messengerWearMediaFetcher;
    }

    private void m4547a(Provider<StickerCache> provider, FetchStickerCoordinator fetchStickerCoordinator, ExecutorService executorService, ImagePipeline imagePipeline, ExecutorService executorService2, PlatformBitmapFactory platformBitmapFactory) {
        this.f5039c = provider;
        this.f5040d = fetchStickerCoordinator;
        this.f5041e = executorService;
        this.f5042f = imagePipeline;
        this.f5043g = executorService2;
        this.f5044h = platformBitmapFactory;
    }

    public final ListenableFuture<MediaData> m4549a(final ImageAttachmentData imageAttachmentData) {
        String str = imageAttachmentData.e;
        final SettableFuture f = SettableFuture.f();
        int i = imageAttachmentData.c;
        float min = Math.min(Math.min(((float) 480) / ((float) imageAttachmentData.d), 1.0f), Math.min(((float) 480) / ((float) i), 1.0f));
        int[] iArr = new int[]{Math.max((int) (((float) i) * min), 1), Math.max((int) (min * ((float) r5)), 1)};
        Integer.valueOf(imageAttachmentData.c);
        Integer.valueOf(imageAttachmentData.d);
        Integer.valueOf(iArr[0]);
        Integer.valueOf(iArr[1]);
        ImageRequestBuilder a = ImageRequestBuilder.a(imageAttachmentData.a.a);
        a.d = new ResizeOptions(iArr[0], iArr[1]);
        Futures.a(m4545a(this, a.m()), new FutureCallback<byte[]>(this) {
            final /* synthetic */ MessengerWearMediaFetcher f5020c;

            public void onSuccess(@Nullable Object obj) {
                int i;
                byte[] bArr = (byte[]) obj;
                Class cls = MessengerWearMediaFetcher.f5037a;
                if (bArr == null) {
                    i = 0;
                } else {
                    i = bArr.length;
                }
                Integer.valueOf(i);
                if (bArr == null) {
                    FutureDetour.a(f, null, 355213710);
                } else {
                    FutureDetour.a(f, MessengerWearMediaFetcher.m4544a(this.f5020c, bArr, imageAttachmentData.e), 365442385);
                }
            }

            public void onFailure(Throwable th) {
                BLog.b(MessengerWearMediaFetcher.f5037a, "Failed to fetch photo image(s)", th);
                f.a(th);
            }
        }, this.f5041e);
        return f;
    }

    public final ListenableFuture<MediaData> m4550a(final String str) {
        ListenableFuture a;
        final SettableFuture f = SettableFuture.f();
        Sticker d = ((StickerCache) this.f5039c.get()).d(str);
        if (d != null) {
            a = Futures.a(d);
        } else {
            a = SettableFuture.f();
            ExecutorDetour.a(this.f5043g, new Runnable(this) {
                final /* synthetic */ MessengerWearMediaFetcher f5028c;

                /* compiled from: photo_menu */
                class C06901 implements FutureCallback<Sticker> {
                    final /* synthetic */ C06913 f5025a;

                    C06901(C06913 c06913) {
                        this.f5025a = c06913;
                    }

                    public void onSuccess(Object obj) {
                        Sticker sticker = (Sticker) obj;
                        Class cls = MessengerWearMediaFetcher.f5037a;
                        FutureDetour.a(a, sticker, -1557662889);
                    }

                    public void onFailure(Throwable th) {
                        BLog.b(MessengerWearMediaFetcher.f5037a, "Fetched for sticker info failed", th);
                        a.a(th);
                    }
                }

                public void run() {
                    try {
                        Futures.a(this.f5028c.f5040d.a(str), new C06901(this), this.f5028c.f5041e);
                    } catch (Throwable e) {
                        BLog.b(MessengerWearMediaFetcher.f5037a, "Fetch sticker failed...", e);
                        a.a(e);
                    }
                }
            }, 265299241);
        }
        Futures.a(a, new FutureCallback<Sticker>(this) {
            final /* synthetic */ MessengerWearMediaFetcher f5024c;

            /* compiled from: photo_menu */
            class C06881 implements FutureCallback<byte[]> {
                final /* synthetic */ C06892 f5021a;

                C06881(C06892 c06892) {
                    this.f5021a = c06892;
                }

                public void onSuccess(@Nullable Object obj) {
                    byte[] bArr = (byte[]) obj;
                    if (bArr == null) {
                        FutureDetour.a(f, null, 1159736593);
                    } else {
                        FutureDetour.a(f, MessengerWearMediaFetcher.m4544a(this.f5021a.f5024c, bArr, str), 2102007275);
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b(MessengerWearMediaFetcher.f5037a, "Failed to fetch sticker image(s)", th);
                    f.a(th);
                }
            }

            public void onSuccess(@Nullable Object obj) {
                Sticker sticker = (Sticker) obj;
                Class cls = MessengerWearMediaFetcher.f5037a;
                Uri uri = StickerUtil.a(sticker) ? sticker.f != null ? sticker.f : sticker.e : sticker.d != null ? sticker.d : sticker.c;
                ImageRequest a = ImageRequest.a(uri);
                if (a == null) {
                    f.a(new IllegalArgumentException());
                } else {
                    Futures.a(MessengerWearMediaFetcher.m4545a(this.f5024c, a), new C06881(this), this.f5024c.f5041e);
                }
            }

            public void onFailure(Throwable th) {
                BLog.b(MessengerWearMediaFetcher.f5037a, "Sticker request failed", th);
                f.a(th);
            }
        }, this.f5041e);
        return f;
    }

    public static MediaData m4544a(@Nullable MessengerWearMediaFetcher messengerWearMediaFetcher, byte[] bArr, String str) {
        ImageFormat a;
        Throwable e;
        AnimatedImage a2;
        MediaData a3;
        Throwable th = null;
        if (bArr == null) {
            return th;
        }
        InputStream byteArrayInputStream;
        ImageFormat imageFormat = ImageFormat.PNG;
        Object a4;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                a = ImageFormatChecker.a(byteArrayInputStream);
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    BLog.b(f5037a, "Error while detecting image format.", e);
                    switch (C06935.f5031a[a.ordinal()]) {
                        case 1:
                            a2 = GifImage.a(bArr);
                            if (a2.c() > 1) {
                                a3 = messengerWearMediaFetcher.m4543a(a2, str);
                            } else {
                                a3 = new MediaData(str, bArr);
                            }
                            a2.h();
                            return a3;
                        case 2:
                            a2 = WebPImage.a(bArr);
                            a4 = messengerWearMediaFetcher.m4543a(a2, str);
                            a2.h();
                            return a4;
                        default:
                            return new MediaData(str, bArr);
                    }
                }
                switch (C06935.f5031a[a.ordinal()]) {
                    case 1:
                        a2 = GifImage.a(bArr);
                        if (a2.c() > 1) {
                            a3 = messengerWearMediaFetcher.m4543a(a2, str);
                        } else {
                            a3 = new MediaData(str, bArr);
                        }
                        a2.h();
                        return a3;
                    case 2:
                        a2 = WebPImage.a(bArr);
                        a4 = messengerWearMediaFetcher.m4543a(a2, str);
                        a2.h();
                        return a4;
                    default:
                        return new MediaData(str, bArr);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            e = th3;
            a = imageFormat;
            BLog.b(f5037a, "Error while detecting image format.", e);
            switch (C06935.f5031a[a.ordinal()]) {
                case 1:
                    a2 = GifImage.a(bArr);
                    if (a2.c() > 1) {
                        a3 = new MediaData(str, bArr);
                    } else {
                        a3 = messengerWearMediaFetcher.m4543a(a2, str);
                    }
                    a2.h();
                    return a3;
                case 2:
                    a2 = WebPImage.a(bArr);
                    a4 = messengerWearMediaFetcher.m4543a(a2, str);
                    a2.h();
                    return a4;
                default:
                    return new MediaData(str, bArr);
            }
        }
        if (e != null) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(e, th4);
            }
        } else {
            byteArrayInputStream.close();
        }
        throw th3;
        throw th3;
    }

    private MediaData m4543a(AnimatedImage animatedImage, String str) {
        int c = animatedImage.c();
        int a = animatedImage.a();
        int b = animatedImage.b();
        CloseableReference a2 = this.f5044h.a(a, b, Config.ARGB_8888);
        Bitmap bitmap = (Bitmap) a2.a();
        byte[][] bArr = new byte[c][];
        for (int i = 0; i < c; i++) {
            animatedImage.a(i).a(a, b, bitmap);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.WEBP, 0, byteArrayOutputStream);
            bArr[i] = byteArrayOutputStream.toByteArray();
        }
        a2.close();
        return new MediaData(str, bArr, animatedImage.d(), animatedImage.e());
    }

    public static ListenableFuture m4545a(MessengerWearMediaFetcher messengerWearMediaFetcher, ImageRequest imageRequest) {
        Throwable th;
        Object obj;
        Throwable th2;
        Throwable th3;
        Throwable th4 = null;
        imageRequest.b().toString();
        final ListenableFuture f = SettableFuture.f();
        if (UriUtil.a(imageRequest.b())) {
            messengerWearMediaFetcher.f5042f.d(imageRequest, f5038b).a(new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(messengerWearMediaFetcher) {
                final /* synthetic */ MessengerWearMediaFetcher f5030b;

                protected final void m4542f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    Class cls = MessengerWearMediaFetcher.f5037a;
                    dataSource.e();
                    if (dataSource.e() != null) {
                        f.a(dataSource.e());
                    } else {
                        FutureDetour.a(f, null, -1415609508);
                    }
                }

                protected final void m4541e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    Throwable th;
                    Throwable th2 = null;
                    if (dataSource.d() == null) {
                        MessengerWearMediaFetcher.f5037a;
                        FutureDetour.a(f, null, -318089523);
                        return;
                    }
                    PooledByteBufferInputStream pooledByteBufferInputStream;
                    MessengerWearMediaFetcher.f5037a;
                    Integer.valueOf(((NativePooledByteBuffer) ((CloseableReference) dataSource.d()).a()).a());
                    CloseableReference closeableReference = (CloseableReference) dataSource.d();
                    NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) closeableReference.a();
                    Object obj = new byte[nativePooledByteBuffer.a()];
                    try {
                        pooledByteBufferInputStream = new PooledByteBufferInputStream(nativePooledByteBuffer);
                        try {
                            ByteStreams.a(pooledByteBufferInputStream, obj);
                            pooledByteBufferInputStream.close();
                            pooledByteBufferInputStream.close();
                            FutureDetour.a(f, obj, 465384676);
                            return;
                        } catch (Throwable th22) {
                            Throwable th3 = th22;
                            th22 = th;
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        f.a(th4);
                        BLog.b(MessengerWearMediaFetcher.f5037a, "IO Exception occurred", th4);
                    } finally {
                        closeableReference.close();
                    }
                    throw th4;
                    if (th22 != null) {
                        try {
                            pooledByteBufferInputStream.close();
                        } catch (Throwable th5) {
                            AndroidCompat.addSuppressed(th22, th5);
                        }
                    } else {
                        pooledByteBufferInputStream.close();
                    }
                    throw th4;
                }
            }, messengerWearMediaFetcher.f5041e);
            return f;
        }
        File m = imageRequest.m();
        try {
            InputStream fileInputStream = new FileInputStream(m);
            try {
                th = new byte[((int) m.length())];
                try {
                    ByteStreams.a(fileInputStream, th);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        th4 = e;
                        BLog.b(f5037a, "Exception loading media file from File System", th4);
                        return Futures.a(obj);
                    }
                    return Futures.a(obj);
                } catch (Throwable th32) {
                    th2 = th32;
                    th32 = th;
                    th = th2;
                    if (th4 == null) {
                        fileInputStream.close();
                    } else {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            AndroidCompat.addSuppressed(th4, th5);
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th6) {
                        th4 = th6;
                        obj = th32;
                    }
                }
            } catch (Throwable th7) {
                th6 = th7;
                th32 = null;
                if (th4 == null) {
                    fileInputStream.close();
                } else {
                    fileInputStream.close();
                }
                throw th6;
            }
        } catch (Throwable th62) {
            th2 = th62;
            obj = null;
            th4 = th2;
            BLog.b(f5037a, "Exception loading media file from File System", th4);
            return Futures.a(obj);
        }
    }
}
