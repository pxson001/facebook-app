package com.facebook.photos.prefetch;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapperImpl.DataProvider;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: onReportAccountValidation must be called on the GoogleApiClient handler thread */
public class DefaultPrefetcher {
    public final DefaultAndroidThreadUtil f11084a;
    private final PrefetchRange f11085b;
    private final DataProvider f11086c;
    private final ImageFetcher f11087d;
    private final ArrayList<PrefetchParams> f11088e = new ArrayList();
    private final ArrayList<PrefetchParams> f11089f = new ArrayList();
    private int f11090g;
    private int f11091h;
    public volatile boolean f11092i;

    @Inject
    public DefaultPrefetcher(DefaultAndroidThreadUtil defaultAndroidThreadUtil, @Assisted PrefetchRange prefetchRange, @Assisted DataProvider dataProvider, @Assisted ImageFetcher imageFetcher) {
        this.f11084a = defaultAndroidThreadUtil;
        this.f11085b = prefetchRange;
        this.f11086c = dataProvider;
        this.f11087d = imageFetcher;
    }

    public final void m16441a(int i, int i2) {
        this.f11084a.m1649a();
        Preconditions.checkState(this.f11092i);
        if (this.f11090g != i || this.f11091h != i2) {
            this.f11090g = i;
            this.f11091h = i2;
            m16439d();
        }
    }

    public final void m16440a() {
        this.f11084a.m1649a();
        Preconditions.checkState(this.f11092i);
        m16439d();
    }

    public final void m16442c() {
        this.f11084a.m1649a();
        Preconditions.checkState(this.f11092i);
        this.f11092i = false;
        m16439d();
    }

    private void m16439d() {
        int a;
        if (this.f11092i) {
            DataProvider dataProvider = this.f11086c;
            dataProvider.f10459a.f10444a.m1649a();
            a = dataProvider.f10459a.f10453j.mo2530a();
        } else {
            a = 0;
        }
        this.f11088e.clear();
        this.f11089f.clear();
        int max = Math.max(Math.max(this.f11085b.f10432c, this.f11085b.f10430a), Math.max(this.f11085b.f10433d, this.f11085b.f10431b));
        for (int i = 1; i <= max; i++) {
            int i2 = this.f11090g - i;
            int i3 = this.f11091h + i;
            if (i3 >= 0 && i3 < r0) {
                if (i <= this.f11085b.f10433d) {
                    m16438a(this.f11089f, this.f11086c.m15541a(i3));
                } else if (i <= this.f11085b.f10432c) {
                    m16438a(this.f11088e, this.f11086c.m15541a(i3));
                }
            }
            if (i2 >= 0 && i2 < r0) {
                if (i <= this.f11085b.f10431b) {
                    m16438a(this.f11089f, this.f11086c.m15541a(i2));
                } else if (i <= this.f11085b.f10430a) {
                    m16438a(this.f11088e, this.f11086c.m15541a(i2));
                }
            }
        }
        this.f11087d.mo2003b(this.f11089f, this.f11088e);
    }

    private static <T> void m16438a(List<T> list, List<T> list2) {
        if (list2 != null && !list2.isEmpty()) {
            if (list2.size() == 1) {
                list.add(list2.get(0));
            } else {
                list.addAll(list2);
            }
        }
    }
}
