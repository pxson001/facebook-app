package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: last_send_failure_backround_data_restriction_last_notified_ms */
public class CloseableStaticBitmap extends CloseableBitmap {
    @GuardedBy("this")
    private CloseableReference<Bitmap> f17884a;
    private volatile Bitmap f17885b;
    private final ImmutableQualityInfo f17886c;
    public final int f17887d;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this.f17885b = (Bitmap) Preconditions.a(bitmap);
        this.f17884a = CloseableReference.m15676a(this.f17885b, (ResourceReleaser) Preconditions.a(resourceReleaser));
        this.f17886c = qualityInfo;
        this.f17887d = i;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        this.f17884a = (CloseableReference) Preconditions.a(closeableReference.m15684c());
        this.f17885b = (Bitmap) this.f17884a.m15682a();
        this.f17886c = qualityInfo;
        this.f17887d = i;
    }

    public void close() {
        CloseableReference i = m25105i();
        if (i != null) {
            i.close();
        }
    }

    private synchronized CloseableReference<Bitmap> m25105i() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.f17884a;
        this.f17884a = null;
        this.f17885b = null;
        return closeableReference;
    }

    public final synchronized boolean mo2981c() {
        return this.f17884a == null;
    }

    public final Bitmap mo2979a() {
        return this.f17885b;
    }

    public final int mo2980b() {
        return BitmapUtil.m25068a(this.f17885b);
    }

    public final int mo2984f() {
        Bitmap bitmap = this.f17885b;
        return bitmap == null ? 0 : bitmap.getWidth();
    }

    public final int mo2985g() {
        Bitmap bitmap = this.f17885b;
        return bitmap == null ? 0 : bitmap.getHeight();
    }

    public final int m25112h() {
        return this.f17887d;
    }

    public final ImmutableQualityInfo mo2983d() {
        return this.f17886c;
    }
}
