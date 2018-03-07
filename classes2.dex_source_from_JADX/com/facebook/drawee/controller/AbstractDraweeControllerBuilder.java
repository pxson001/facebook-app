package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources.1;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* compiled from: multi_step_review_composer */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    private static final ControllerListener<Object> f13210a = new C05331();
    private static final NullPointerException f13211b = new NullPointerException("No image request was specified!");
    private static final AtomicLong f13212p = new AtomicLong();
    private final Context f13213c;
    private final Set<ControllerListener> f13214d;
    @Nullable
    private Object f13215e;
    @Nullable
    public REQUEST f13216f;
    @Nullable
    public REQUEST f13217g;
    @Nullable
    public REQUEST[] f13218h;
    private boolean f13219i;
    @Nullable
    private Supplier<DataSource<IMAGE>> f13220j;
    @Nullable
    public ControllerListener<? super INFO> f13221k;
    private boolean f13222l;
    private boolean f13223m;
    public boolean f13224n;
    @Nullable
    public DraweeController f13225o;

    /* compiled from: multi_step_review_composer */
    final class C05331 extends BaseControllerListener<Object> {
        C05331() {
        }

        public final void mo2603a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    protected abstract DataSource<IMAGE> mo2588a(REQUEST request, Object obj, boolean z);

    protected abstract AbstractDraweeController mo2599n();

    public abstract BUILDER mo2600o();

    public /* synthetic */ DraweeController mo2589a() {
        return mo2595i();
    }

    public final /* synthetic */ SimpleDraweeControllerBuilder mo2602a(@Nullable DraweeController draweeController) {
        return m19449b(draweeController);
    }

    public /* synthetic */ SimpleDraweeControllerBuilder mo2591a(Object obj) {
        return mo2593b(obj);
    }

    protected AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.f13213c = context;
        this.f13214d = set;
        mo2601p();
    }

    private void mo2601p() {
        this.f13215e = null;
        this.f13216f = null;
        this.f13217g = null;
        this.f13218h = null;
        this.f13219i = true;
        this.f13221k = null;
        this.f13222l = false;
        this.f13223m = false;
        this.f13225o = null;
    }

    public BUILDER mo2592b() {
        mo2601p();
        return mo2600o();
    }

    public BUILDER mo2593b(Object obj) {
        this.f13215e = obj;
        return mo2600o();
    }

    @Nullable
    public Object mo2594c() {
        return this.f13215e;
    }

    public final BUILDER m19452c(REQUEST request) {
        this.f13216f = request;
        return mo2600o();
    }

    public final BUILDER m19456d(REQUEST request) {
        this.f13217g = request;
        return mo2600o();
    }

    public final BUILDER m19442a(REQUEST[] requestArr) {
        return m19443a((Object[]) requestArr, true);
    }

    public final BUILDER m19443a(REQUEST[] requestArr, boolean z) {
        this.f13218h = requestArr;
        this.f13219i = z;
        return mo2600o();
    }

    public final BUILDER m19441a(boolean z) {
        this.f13222l = z;
        return mo2600o();
    }

    protected final void m19455c(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.f14365f == null) {
            abstractDraweeController.f14365f = new GestureDetector(this.f13213c);
            if (abstractDraweeController.f14365f != null) {
                abstractDraweeController.f14365f.f22013a = abstractDraweeController;
            }
        }
    }

    public final BUILDER m19453c(boolean z) {
        this.f13223m = z;
        return mo2600o();
    }

    public final BUILDER m19440a(ControllerListener<? super INFO> controllerListener) {
        this.f13221k = controllerListener;
        return mo2600o();
    }

    public final BUILDER m19449b(@Nullable DraweeController draweeController) {
        this.f13225o = draweeController;
        return mo2600o();
    }

    public AbstractDraweeController mo2595i() {
        mo2596j();
        if (this.f13216f == null && this.f13218h == null && this.f13217g != null) {
            this.f13216f = this.f13217g;
            this.f13217g = null;
        }
        return mo2597k();
    }

    protected void mo2596j() {
        boolean z = false;
        boolean z2 = this.f13218h == null || this.f13216f == null;
        Preconditions.b(z2, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f13220j == null || (this.f13218h == null && this.f13216f == null && this.f13217g == null)) {
            z = true;
        }
        Preconditions.b(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected AbstractDraweeController mo2597k() {
        AbstractDraweeController n = mo2599n();
        n.f14374o = this.f13224n;
        m19451b(n);
        m19447a(n);
        return n;
    }

    protected static String m19436l() {
        return String.valueOf(f13212p.getAndIncrement());
    }

    protected Supplier<DataSource<IMAGE>> mo2598m() {
        if (this.f13220j != null) {
            return this.f13220j;
        }
        Supplier<DataSource<IMAGE>> supplier = null;
        if (this.f13216f != null) {
            supplier = m19457e(this.f13216f);
        } else if (this.f13218h != null) {
            Object[] objArr = this.f13218h;
            boolean z = this.f13219i;
            int i = 0;
            List arrayList = new ArrayList(objArr.length * 2);
            if (z) {
                for (Object a : objArr) {
                    arrayList.add(mo2587a(a, true));
                }
            }
            while (i < objArr.length) {
                arrayList.add(m19457e(objArr[i]));
                i++;
            }
            Object a2 = FirstAvailableDataSourceSupplier.m29786a(arrayList);
        }
        if (!(supplier == null || this.f13217g == null)) {
            List arrayList2 = new ArrayList(2);
            arrayList2.add(supplier);
            arrayList2.add(m19457e(this.f13217g));
            supplier = IncreasingQualityDataSourceSupplier.m29789a(arrayList2);
        }
        if (supplier == null) {
            return new 1(f13211b);
        }
        return supplier;
    }

    public final Supplier<DataSource<IMAGE>> m19457e(REQUEST request) {
        return mo2587a((Object) request, false);
    }

    public Supplier<DataSource<IMAGE>> mo2587a(REQUEST request, boolean z) {
        return new 2(this, request, mo2594c(), z);
    }

    protected final void m19447a(AbstractDraweeController abstractDraweeController) {
        if (this.f13214d != null) {
            for (ControllerListener a : this.f13214d) {
                abstractDraweeController.m20741a(a);
            }
        }
        if (this.f13221k != null) {
            abstractDraweeController.m20741a(this.f13221k);
        }
        if (this.f13223m) {
            abstractDraweeController.m20741a(f13210a);
        }
    }

    protected final void m19451b(AbstractDraweeController abstractDraweeController) {
        if (this.f13222l) {
            RetryManager retryManager = abstractDraweeController.f14364e;
            if (retryManager == null) {
                retryManager = new RetryManager();
                abstractDraweeController.f14364e = retryManager;
            }
            retryManager.f22010a = this.f13222l;
            m19455c(abstractDraweeController);
        }
    }
}
