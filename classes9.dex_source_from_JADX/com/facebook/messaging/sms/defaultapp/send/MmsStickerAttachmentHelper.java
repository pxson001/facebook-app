package com.facebook.messaging.sms.defaultapp.send;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.PduPart;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.messaging.sms.defaultapp.PduPartFactory;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.client.StickerAssetDownloadUtil;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.stickers.ui.StickerUrls;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.extra.IS_REPLY */
public class MmsStickerAttachmentHelper {
    public static final CallerContext f17694a = CallerContext.b(MmsStickerAttachmentHelper.class, "image_fetch_mms");
    private final Context f17695b;
    private final ListeningExecutorService f17696c;
    private final ImagePipeline f17697d;
    private final RuntimePermissionsUtil f17698e;
    private StickerUrls f17699f;
    public final StickerAssetDownloadUtil f17700g;
    private FetchStickerCoordinator f17701h;
    private final StickerCache f17702i;

    @Inject
    public MmsStickerAttachmentHelper(Context context, ListeningExecutorService listeningExecutorService, ImagePipeline imagePipeline, FetchStickerCoordinator fetchStickerCoordinator, RuntimePermissionsUtil runtimePermissionsUtil, StickerAssetDownloadUtil stickerAssetDownloadUtil, StickerCache stickerCache, StickerUrls stickerUrls) {
        this.f17695b = context;
        this.f17696c = listeningExecutorService;
        this.f17697d = imagePipeline;
        this.f17701h = fetchStickerCoordinator;
        this.f17702i = stickerCache;
        this.f17700g = stickerAssetDownloadUtil;
        this.f17698e = runtimePermissionsUtil;
        this.f17699f = stickerUrls;
    }

    public final PduPart m17660a(String str) {
        Sticker d = this.f17702i.d(str);
        if (d == null) {
            d = (Sticker) FutureUtils.a(this.f17701h.a(str));
        }
        if (d == null) {
            throw new MmsException("Unable to get sticker information");
        } else if (this.f17698e.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
            return m17657a(d);
        } else {
            return m17659b(d);
        }
    }

    private PduPart m17656a(Uri uri, String str) {
        try {
            return m17655a(Media.getBitmap(this.f17695b.getContentResolver(), uri), str);
        } catch (Throwable e) {
            BLog.b("MmsStickerAttachmentHelper", e, "Failed creating photo pdu part for resource: %s", new Object[]{uri});
            throw new MmsException(e.getMessage());
        }
    }

    private static PduPart m17655a(Bitmap bitmap, String str) {
        PduPart pduPart = new PduPart();
        try {
            pduPart.m3682a(m17658a(bitmap));
            pduPart.m3690e("image/png".getBytes());
            PduPartFactory.m17557a(pduPart, "sticker:" + str);
            return pduPart;
        } catch (Throwable e) {
            BLog.b("MmsStickerAttachmentHelper", e, "Failed creating photo pdu part for sticker", new Object[0]);
            throw new MmsException(e.getMessage());
        }
    }

    private static byte[] m17658a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private PduPart m17657a(final Sticker sticker) {
        Uri uri;
        if (sticker.d != null) {
            uri = sticker.d;
        } else if (sticker.h != null) {
            uri = sticker.h;
        } else {
            OperationResult operationResult = (OperationResult) FutureUtils.a(this.f17696c.a(new Callable<OperationResult>(this) {
                final /* synthetic */ MmsStickerAttachmentHelper f17693b;

                public Object call() {
                    Future a;
                    if (sticker.g != null) {
                        a = this.f17693b.f17700g.a(sticker.a, StickerAssetType.PREVIEW, sticker.g, MmsStickerAttachmentHelper.f17694a);
                    } else if (sticker.c != null) {
                        a = this.f17693b.f17700g.a(sticker.a, StickerAssetType.STATIC, sticker.c, MmsStickerAttachmentHelper.f17694a);
                    } else {
                        throw new MmsException("No usable uri for sticker");
                    }
                    if (a != null) {
                        return (OperationResult) FutureUtils.a(a, 60000);
                    }
                    return null;
                }
            }), 60000);
            if (operationResult != null && operationResult.b) {
                Sticker d = this.f17702i.d(sticker.a);
                if (d != null) {
                    if (d.d != null) {
                        uri = d.d;
                    } else if (d.h != null) {
                        uri = d.h;
                    }
                }
            }
            uri = null;
        }
        if (uri != null) {
            return m17656a(uri, sticker.a);
        }
        throw new MmsException("Unable to get image for sticker");
    }

    private PduPart m17659b(Sticker sticker) {
        CloseableReference closeableReference = (CloseableReference) FutureUtils.a(DataSourceToFutureAdapter.a(this.f17697d.c(StickerUrls.c(sticker), f17694a)), 60000);
        if (closeableReference != null) {
            try {
                if (closeableReference.a() instanceof CloseableBitmap) {
                    PduPart a = m17655a(((CloseableBitmap) closeableReference.a()).a(), sticker.a);
                    return a;
                }
            } finally {
                CloseableReference.c(closeableReference);
            }
        }
        throw new MmsException("Unable to download sticker image");
    }
}
