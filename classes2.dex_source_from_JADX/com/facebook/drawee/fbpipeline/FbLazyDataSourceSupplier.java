package com.facebook.drawee.fbpipeline;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: media_reminder */
public class FbLazyDataSourceSupplier implements Supplier<DataSource<CloseableReference<CloseableImage>>> {
    public Lazy<ImagePipeline> f14531a;
    public ImageRequest f14532b;
    private ImageRequest f14533c;
    public Object f14534d;
    private final AtomicBoolean f14535e = new AtomicBoolean(false);
    public final AtomicBoolean f14536f = new AtomicBoolean(false);

    public final Object mo2058a() {
        if (this.f14535e.get()) {
            this.f14536f.set(true);
            ((ImagePipeline) this.f14531a.get()).m16076f(this.f14532b, CallerContext.m9059a((CallerContext) this.f14534d, "lazy_load"));
            if (this.f14533c == null) {
                return ((ImagePipeline) this.f14531a.get()).m16073c(this.f14532b, this.f14534d);
            }
            List arrayList = new ArrayList(2);
            arrayList.add(((ImagePipeline) this.f14531a.get()).m16065a(this.f14532b, this.f14534d, false));
            arrayList.add(((ImagePipeline) this.f14531a.get()).m16065a(this.f14533c, this.f14534d, false));
            return IncreasingQualityDataSourceSupplier.m29789a(arrayList).m29791b();
        } else if (this.f14533c != null) {
            return ((ImagePipeline) this.f14531a.get()).m16073c(this.f14533c, this.f14534d);
        } else {
            ImageRequestBuilder a = ImageRequestBuilder.m18777a(this.f14532b);
            a.f12718b = RequestLevel.DISK_CACHE;
            return ((ImagePipeline) this.f14531a.get()).m16073c(a.m18785m(), this.f14534d);
        }
    }

    @Inject
    public FbLazyDataSourceSupplier(Lazy<ImagePipeline> lazy, @Assisted ImageRequest imageRequest, @Assisted ImageRequest imageRequest2, @Assisted Object obj) {
        this.f14531a = lazy;
        this.f14532b = imageRequest;
        this.f14533c = imageRequest2;
        this.f14534d = obj;
        ImageRequestBuilder a = ImageRequestBuilder.m18777a(this.f14532b);
        a.f12718b = RequestLevel.DISK_CACHE;
        ((ImagePipeline) this.f14531a.get()).m16074d(a.m18785m(), this.f14534d).mo2783a(new 1(this), CallerThreadExecutor.f14746a);
    }

    public final void m20951c() {
        this.f14535e.set(true);
    }
}
