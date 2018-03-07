package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android_src.mmsv2.pdu.CharacterSets;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.PduPart;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.media.upload.MediaResourceSizeEstimator;
import com.facebook.messaging.sms.defaultapp.config.MmsSmsConfig;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaMimeTypeMap;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: com.facebook.rtc.fbwebrtc.intent.action.SHOW_UI */
public class PduPartFactory {
    public static final Set<String> f17562a = ImmutableSet.of("image/png", "image/jpeg", "image/jpg");
    private static final CallerContext f17563b = CallerContext.b(PduPartFactory.class, "image_fetch_mms");
    private static StringBuilder f17564c;
    private final Context f17565d;
    private final MediaMimeTypeMap f17566e;
    private final ListeningExecutorService f17567f;
    public final DefaultBlueServiceOperationFactory f17568g;
    private final MediaResourceSizeEstimator f17569h;
    public final StatFsHelper f17570i;
    private final Lazy<MmsSmsConfig> f17571j;
    private final Lazy<ImagePipeline> f17572k;

    public static PduPartFactory m17560b(InjectorLike injectorLike) {
        return new PduPartFactory((Context) injectorLike.getInstance(Context.class), MediaMimeTypeMap.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), MediaResourceSizeEstimator.b(injectorLike), StatFsHelperMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 8470), IdBasedSingletonScopeProvider.b(injectorLike, 2309));
    }

    @Inject
    public PduPartFactory(Context context, MediaMimeTypeMap mediaMimeTypeMap, ListeningExecutorService listeningExecutorService, BlueServiceOperationFactory blueServiceOperationFactory, MediaResourceSizeEstimator mediaResourceSizeEstimator, StatFsHelper statFsHelper, Lazy<MmsSmsConfig> lazy, Lazy<ImagePipeline> lazy2) {
        this.f17565d = context;
        this.f17566e = mediaMimeTypeMap;
        this.f17567f = listeningExecutorService;
        this.f17568g = blueServiceOperationFactory;
        this.f17569h = mediaResourceSizeEstimator;
        this.f17570i = statFsHelper;
        this.f17571j = lazy;
        this.f17572k = lazy2;
    }

    public static PduPart m17554a(String str) {
        PduPart pduPart = new PduPart();
        pduPart.m3690e("text/plain".getBytes());
        pduPart.m3682a(str.getBytes());
        pduPart.m3693g("text".getBytes());
        try {
            pduPart.m3680a(CharacterSets.m3598a(Charset.defaultCharset().name().toLowerCase(Locale.US)));
            m17557a(pduPart, "text");
        } catch (Throwable e) {
            BLog.c("PduPartFactory", e, "System default charset is not recognized: %s", new Object[]{r2});
        }
        return pduPart;
    }

    public final PduPart m17564a(MediaResource mediaResource, Set<Uri> set, int i) {
        PduPart pduPart = new PduPart();
        try {
            long j = mediaResource.p;
            String str = mediaResource.o != null ? mediaResource.o : "image/jpeg";
            MmsSmsConfig mmsSmsConfig = (MmsSmsConfig) this.f17571j.get();
            int c = mmsSmsConfig.m17641c() / i;
            int e = mmsSmsConfig.m17643e();
            int d = mmsSmsConfig.m17642d();
            if (m17558a(mediaResource, c, e, d)) {
                ImageRequestBuilder a = ImageRequestBuilder.a(mediaResource.c);
                if (mediaResource.j > e || mediaResource.k > d || !m17561d(mediaResource)) {
                    a.a(new MmsImagePostprocessor(j, str, c, e, d));
                }
                CloseableReference closeableReference = (CloseableReference) FutureUtils.a(DataSourceToFutureAdapter.a(((ImagePipeline) this.f17572k.get()).c(a.m(), f17563b)));
                if (closeableReference != null) {
                    try {
                        if (closeableReference.a() instanceof CloseableBitmap) {
                            Bitmap a2 = ((CloseableBitmap) closeableReference.a()).a();
                            Uri d2 = MmsFileProvider.m17523d();
                            OutputStream fileOutputStream = new FileOutputStream(MmsFileProvider.m17522a(this.f17565d, d2));
                            if (StringUtil.a(str, "image/png")) {
                                a2.compress(CompressFormat.PNG, 100, fileOutputStream);
                            } else {
                                a2.compress(CompressFormat.JPEG, m17552a(a2.getByteCount() / c), fileOutputStream);
                            }
                            set.add(d2);
                            pduPart.m3681a(d2);
                            pduPart.m3690e(str.getBytes());
                            m17557a(pduPart, mediaResource.c.getLastPathSegment());
                        }
                    } finally {
                        CloseableReference.c(closeableReference);
                    }
                }
                throw new MmsException("Could not decode image to bitmap");
            }
            pduPart.m3681a(mediaResource.c);
            pduPart.m3690e(str.getBytes());
            m17557a(pduPart, mediaResource.c.getLastPathSegment());
            return pduPart;
        } catch (Throwable e2) {
            BLog.c("PduPartFactory", e2, "Failed creating photo pdu part for resource: %s", new Object[]{mediaResource.c});
            throw new MmsException(e2.getMessage());
        }
    }

    public final PduPart m17563a(MediaResource mediaResource) {
        MediaResource C = MediaResource.a().a(mediaResource).a(Source.VIDEO_MMS).C();
        if (m17562e(C)) {
            C = m17555a(C, 30000);
        }
        PduPart pduPart = new PduPart();
        try {
            String a = m17556a(C.c.toString(), "video/");
            if (Strings.isNullOrEmpty(a)) {
                a = "video/mp4";
            }
            pduPart.m3690e(a.getBytes());
            pduPart.m3681a(C.c);
            m17557a(pduPart, "video");
            return pduPart;
        } catch (Throwable e) {
            BLog.b("PduPartFactory", e, "Failed creating video pdu part for resource: %s", new Object[]{C.c});
            throw new MmsException(e.getMessage());
        }
    }

    public final PduPart m17565b(MediaResource mediaResource) {
        PduPart pduPart = new PduPart();
        try {
            String a = m17556a(mediaResource.c.toString(), "audio/");
            if (Strings.isNullOrEmpty(a)) {
                a = "audio/mp4";
            }
            pduPart.m3690e(a.getBytes());
            pduPart.m3681a(mediaResource.c);
            m17557a(pduPart, "audio");
            return pduPart;
        } catch (Throwable e) {
            BLog.b("PduPartFactory", e, "Failed creating audio pdu part for resource: %s", new Object[]{mediaResource.c});
            throw new MmsException(e.getMessage());
        }
    }

    public static PduPart m17553a() {
        PduPart pduPart = new PduPart();
        pduPart.m3690e("application/smil".getBytes());
        pduPart.f3861f = "smil".getBytes();
        m17557a(pduPart, "smil");
        return pduPart;
    }

    public static PduPart m17559b(String str) {
        PduPart pduPart = new PduPart();
        pduPart.m3690e("application/smil".getBytes());
        String str2 = "sticker:" + str;
        pduPart.f3861f = str2.getBytes();
        m17557a(pduPart, str2);
        return pduPart;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    private java.lang.String m17556a(java.lang.String r5, @javax.annotation.Nullable java.lang.String r6) {
        /*
        r4 = this;
        r2 = 0;
        if (r6 == 0) goto L_0x000b;
    L_0x0003:
        r0 = "/";
        r0 = r6.endsWith(r0);
        if (r0 == 0) goto L_0x003c;
    L_0x000b:
        r0 = 1;
    L_0x000c:
        com.google.common.base.Preconditions.checkArgument(r0);
        r0 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r5);
        r1 = com.google.common.base.Strings.isNullOrEmpty(r0);
        if (r1 != 0) goto L_0x0042;
    L_0x0019:
        r1 = r4.f17566e;
        r1 = r1.b(r0);
    L_0x001f:
        if (r1 == 0) goto L_0x0040;
    L_0x0021:
        if (r6 == 0) goto L_0x0040;
    L_0x0023:
        r0 = r1.startsWith(r6);
        if (r0 != 0) goto L_0x0040;
    L_0x0029:
        r0 = "^.*/";
        r0 = r1.replaceAll(r0, r6);
        r3 = android_src.mmsv2.pdu.ContentType.m3600a(r0);
        if (r3 == 0) goto L_0x0040;
    L_0x0035:
        r1 = android_src.mmsv2.pdu.ContentType.m3600a(r0);
        if (r1 == 0) goto L_0x003e;
    L_0x003b:
        return r0;
    L_0x003c:
        r0 = 0;
        goto L_0x000c;
    L_0x003e:
        r0 = r2;
        goto L_0x003b;
    L_0x0040:
        r0 = r1;
        goto L_0x0035;
    L_0x0042:
        r1 = r2;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.defaultapp.PduPartFactory.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static boolean m17558a(MediaResource mediaResource, int i, int i2, int i3) {
        boolean z;
        if (mediaResource.d != Type.PHOTO || mediaResource.o == null) {
            z = false;
        } else {
            z = f17562a.contains(mediaResource.o);
        }
        return z && (mediaResource.p > ((long) i) || mediaResource.j > i2 || mediaResource.k > i3);
    }

    private static boolean m17561d(MediaResource mediaResource) {
        return mediaResource.d == Type.PHOTO && (StringUtil.a(mediaResource.o, "image/jpeg") || StringUtil.a(mediaResource.o, "image/jpg"));
    }

    private static int m17552a(int i) {
        if (i < 5) {
            return 100;
        }
        if (i < 25) {
            return 75;
        }
        if (i >= 50) {
            return 25;
        }
        return 50;
    }

    private boolean m17562e(MediaResource mediaResource) {
        long a = (long) this.f17569h.a(mediaResource);
        if (a < ((long) ((MmsSmsConfig) this.f17571j.get()).m17641c())) {
            Object obj = null;
            if (a > 0 && ((this.f17570i.a(StorageType.EXTERNAL) > 0 || this.f17570i.a(StorageType.INTERNAL) > 0) && (this.f17570i.a(StorageType.EXTERNAL, a) || this.f17570i.a(StorageType.INTERNAL, a)))) {
                obj = 1;
            }
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    private MediaResource m17555a(final MediaResource mediaResource, long j) {
        try {
            MediaResource mediaResource2 = (MediaResource) ((OperationResult) FutureDetour.a(Futures.a(this.f17567f.a(new Callable<ListenableFuture<OperationResult>>(this) {
                final /* synthetic */ PduPartFactory f17561b;

                public Object call() {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("mediaResource", mediaResource);
                    bundle.putBoolean("transcode", true);
                    return BlueServiceOperationFactoryDetour.a(this.f17561b.f17568g, "video_resize", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 210893627).a();
                }
            })), j, TimeUnit.MILLISECONDS, 1340079977)).h();
            if (mediaResource2 != null) {
                Long.valueOf(mediaResource.p);
                Long.valueOf(mediaResource2.p);
                return mediaResource2;
            }
        } catch (Throwable e) {
            BLog.b("PduPartFactory", e, "Failed in compressing video resource for mms", new Object[0]);
        }
        return mediaResource;
    }

    public static void m17557a(PduPart pduPart, String str) {
        pduPart.m3693g(str.getBytes());
        if (f17564c == null) {
            f17564c = new StringBuilder();
        }
        f17564c.setLength(0);
        f17564c.append('<').append(str).append('>');
        pduPart.m3685b(f17564c.toString().getBytes());
    }
}
