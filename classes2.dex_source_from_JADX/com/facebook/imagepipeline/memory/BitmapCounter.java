package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: page/<p$1>/info */
public class BitmapCounter {
    @GuardedBy("this")
    private int f10550a;
    @GuardedBy("this")
    private long f10551b;
    private final int f10552c;
    private final int f10553d;
    private final ResourceReleaser<Bitmap> f10554e;

    /* compiled from: page/<p$1>/info */
    class C04461 implements ResourceReleaser<Bitmap> {
        final /* synthetic */ BitmapCounter f10589a;

        C04461(BitmapCounter bitmapCounter) {
            this.f10589a = bitmapCounter;
        }

        public final void mo2019a(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            try {
                this.f10589a.m15674b(bitmap);
            } finally {
                bitmap.recycle();
            }
        }
    }

    public BitmapCounter(int i, int i2) {
        boolean z = true;
        Preconditions.a(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.a(z);
        this.f10552c = i;
        this.f10553d = i2;
        this.f10554e = new C04461(this);
    }

    public final synchronized boolean m15673a(Bitmap bitmap) {
        boolean z;
        int a = BitmapUtil.m25068a(bitmap);
        if (this.f10550a >= this.f10552c || this.f10551b + ((long) a) > ((long) this.f10553d)) {
            z = false;
        } else {
            this.f10550a++;
            this.f10551b = ((long) a) + this.f10551b;
            z = true;
        }
        return z;
    }

    public final synchronized void m15674b(Bitmap bitmap) {
        boolean z = true;
        synchronized (this) {
            int a = BitmapUtil.m25068a(bitmap);
            Preconditions.a(this.f10550a > 0, "No bitmaps registered.");
            if (((long) a) > this.f10551b) {
                z = false;
            }
            Preconditions.a(z, "Bitmap size bigger than the total registered size: %d, %d", new Object[]{Integer.valueOf(a), Long.valueOf(this.f10551b)});
            this.f10551b -= (long) a;
            this.f10550a--;
        }
    }

    public final ResourceReleaser<Bitmap> m15671a() {
        return this.f10554e;
    }

    public final List<CloseableReference<Bitmap>> m15672a(List<Bitmap> list) {
        Bitmap bitmap;
        int i = 0;
        while (i < list.size()) {
            try {
                bitmap = (Bitmap) list.get(i);
                if (VERSION.SDK_INT < 21) {
                    Bitmaps.m15694a(bitmap);
                }
                if (m15673a(bitmap)) {
                    i++;
                } else {
                    throw new TooManyBitmapsException();
                }
            } catch (Throwable e) {
                Throwable th = e;
                if (list != null) {
                    for (Bitmap bitmap2 : list) {
                        int i2 = i - 1;
                        if (i > 0) {
                            m15674b(bitmap2);
                        }
                        bitmap2.recycle();
                        i = i2;
                    }
                }
                throw Throwables.m15700b(th);
            }
        }
        List<CloseableReference<Bitmap>> arrayList = new ArrayList();
        for (Bitmap bitmap22 : list) {
            arrayList.add(CloseableReference.m15676a(bitmap22, this.f10554e));
        }
        return arrayList;
    }
}
