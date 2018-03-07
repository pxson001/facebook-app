package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
/* compiled from: page/%s/invite_friends_to_like_page */
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    private final EmptyJpegGenerator f10590a;
    private final PlatformDecoder f10591b;

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder) {
        this.f10590a = emptyJpegGenerator;
        this.f10591b = platformDecoder;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> mo2020a(int r6, int r7, android.graphics.Bitmap.Config r8) {
        /*
        r5 = this;
        r0 = r5.f10590a;
        r1 = (short) r6;
        r2 = (short) r7;
        r1 = r0.m15774a(r1, r2);
        r2 = new com.facebook.imagepipeline.image.EncodedImage;	 Catch:{ all -> 0x0038 }
        r2.<init>(r1);	 Catch:{ all -> 0x0038 }
        r0 = com.facebook.imageformat.ImageFormat.JPEG;	 Catch:{ all -> 0x0038 }
        r2.m15710a(r0);	 Catch:{ all -> 0x0038 }
        r3 = r5.f10591b;	 Catch:{ all -> 0x0033 }
        r0 = r1.m15682a();	 Catch:{ all -> 0x0033 }
        r0 = (com.facebook.imagepipeline.memory.NativePooledByteBuffer) r0;	 Catch:{ all -> 0x0033 }
        r0 = r0.m15689a();	 Catch:{ all -> 0x0033 }
        r3 = r3.m15669a(r2, r8, r0);	 Catch:{ all -> 0x0033 }
        r0 = r3.m15682a();	 Catch:{ all -> 0x0033 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0033 }
        r4 = 0;
        r0.eraseColor(r4);	 Catch:{ all -> 0x0033 }
        com.facebook.imagepipeline.image.EncodedImage.m15704d(r2);	 Catch:{  }
        r1.close();
        return r3;
    L_0x0033:
        r0 = move-exception;
        com.facebook.imagepipeline.image.EncodedImage.m15704d(r2);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0038:
        r0 = move-exception;
        r1.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory.a(int, int, android.graphics.Bitmap$Config):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>");
    }
}
