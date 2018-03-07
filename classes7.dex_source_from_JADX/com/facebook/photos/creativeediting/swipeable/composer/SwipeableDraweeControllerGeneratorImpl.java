package com.facebook.photos.creativeediting.swipeable.composer;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_ImageTransformExecutorServiceMethodAutoProvider;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController.C08104;
import com.facebook.photos.imageprocessing.FiltersEngine;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: longUrl */
public class SwipeableDraweeControllerGeneratorImpl {
    public static final CallerContext f9846a = CallerContext.a(SwipeableDraweeControllerGeneratorImpl.class, "creative_editing_in_composer");
    public static final String f9847b = SwipeableDraweeControllerGeneratorImpl.class.getSimpleName();
    public final Context f9848c;
    private final SwipeableParamsHelper f9849d;
    public final FbDraweeControllerBuilder f9850e;
    public final SwipeablePostprocessorManager f9851f;
    public final List<SwipeableDraweeControllerGenerator$EventSubscriber> f9852g = new ArrayList();
    public final AutoRotateDrawable f9853h;
    public boolean f9854i;
    private boolean f9855j;
    public boolean f9856k;
    private boolean f9857l;
    @Nullable
    public Uri f9858m;
    private int f9859n;
    private int f9860o;
    public DraweeSwipeableItem f9861p;
    public DraweeSwipeableItem f9862q;
    public DraweeSwipeableItem f9863r;
    public DraweeHolder f9864s;
    public DraweeHolder f9865t;
    public DraweeHolder f9866u;
    public BaseControllerListener f9867v;
    public BaseControllerListener f9868w;
    public BaseControllerListener f9869x;
    public C08104 f9870y;

    /* compiled from: longUrl */
    class C08171 extends BaseControllerListener {
        final /* synthetic */ SwipeableDraweeControllerGeneratorImpl f9845a;

        C08171(SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl) {
            this.f9845a = swipeableDraweeControllerGeneratorImpl;
        }

        public final void m11803b(String str, @Nullable Object obj) {
            super.b(str, (CloseableImage) obj);
            if (this.f9845a.f9854i) {
                if (this == this.f9845a.f9867v && this.f9845a.f9861p == null) {
                    this.f9845a.f9861p = SwipeableDraweeControllerGeneratorImpl.m11805a(this.f9845a, this.f9845a.f9864s, this.f9845a.f9870y.m11757a());
                } else if (this == this.f9845a.f9868w && this.f9845a.f9862q == null) {
                    this.f9845a.f9862q = SwipeableDraweeControllerGeneratorImpl.m11805a(this.f9845a, this.f9845a.f9865t, this.f9845a.f9870y.m11758b());
                } else if (this == this.f9845a.f9869x && this.f9845a.f9863r == null) {
                    this.f9845a.f9863r = SwipeableDraweeControllerGeneratorImpl.m11805a(this.f9845a, this.f9845a.f9866u, this.f9845a.f9870y.m11759c());
                }
                SwipeableDraweeControllerGeneratorImpl.m11809g(this.f9845a);
            } else if (this.f9845a.f9856k) {
                for (SwipeableDraweeControllerGenerator$EventSubscriber a : this.f9845a.f9852g) {
                    a.mo513a();
                }
                this.f9845a.f9856k = false;
            } else {
                this.f9845a.f9854i = true;
                for (SwipeableDraweeControllerGenerator$EventSubscriber a2 : this.f9845a.f9852g) {
                    a2.mo514a(SwipeableDraweeControllerGeneratorImpl.m11805a(this.f9845a, this.f9845a.f9865t, this.f9845a.f9870y.m11758b()));
                }
            }
        }

        public final void m11804b(String str, Throwable th) {
            super.b(str, th);
            String str2 = SwipeableDraweeControllerGeneratorImpl.f9847b;
        }
    }

    public static SwipeableDraweeControllerGeneratorImpl m11807b(InjectorLike injectorLike) {
        return new SwipeableDraweeControllerGeneratorImpl((Context) injectorLike.getInstance(Context.class), FbDraweeControllerBuilder.b(injectorLike), SwipeableParamsHelper.m11713b(injectorLike), new SwipeablePostprocessorManager(ListeningExecutorService_ImageTransformExecutorServiceMethodAutoProvider.a(injectorLike), FiltersEngine.a(injectorLike), IdBasedProvider.a(injectorLike, 9290)));
    }

    public static SwipeableDraweeControllerGeneratorImpl m11806a(InjectorLike injectorLike) {
        return m11807b(injectorLike);
    }

    @Inject
    public SwipeableDraweeControllerGeneratorImpl(Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, SwipeableParamsHelper swipeableParamsHelper, SwipeablePostprocessorManager swipeablePostprocessorManager) {
        this.f9848c = context;
        this.f9850e = fbDraweeControllerBuilder;
        this.f9849d = swipeableParamsHelper;
        this.f9851f = swipeablePostprocessorManager;
        this.f9853h = new AutoRotateDrawable(this.f9848c.getResources().getDrawable(2130844043), 1000);
    }

    public final void m11813a(SwipeableDraweeControllerGenerator$EventSubscriber swipeableDraweeControllerGenerator$EventSubscriber) {
        Preconditions.checkState(!this.f9852g.isEmpty());
        this.f9852g.add(swipeableDraweeControllerGenerator$EventSubscriber);
    }

    public final void m11815b(SwipeableDraweeControllerGenerator$EventSubscriber swipeableDraweeControllerGenerator$EventSubscriber) {
        if (swipeableDraweeControllerGenerator$EventSubscriber != null) {
            this.f9852g.remove(swipeableDraweeControllerGenerator$EventSubscriber);
        }
    }

    public final void m11812a(@Nullable Uri uri, int i, int i2, SwipeableDraweeControllerGenerator$EventSubscriber swipeableDraweeControllerGenerator$EventSubscriber, boolean z, C08104 c08104) {
        this.f9858m = uri;
        this.f9859n = i;
        this.f9860o = i2;
        this.f9870y = c08104;
        this.f9855j = z;
        this.f9852g.add(swipeableDraweeControllerGenerator$EventSubscriber);
    }

    public final void m11811a() {
        if (this.f9870y != null) {
            if (this.f9870y.m11757a() == null || this.f9870y.m11759c() == null) {
                this.f9857l = false;
            } else {
                this.f9857l = true;
            }
            if (this.f9858m == null) {
                this.f9861p = m11805a(this, null, this.f9870y.m11757a());
                this.f9862q = m11805a(this, null, this.f9870y.m11758b());
                this.f9863r = m11805a(this, null, this.f9870y.m11759c());
                m11809g(this);
                return;
            }
            SwipeableRepeatedPostprocessor swipeableRepeatedPostprocessor;
            String str;
            this.f9861p = null;
            this.f9862q = null;
            this.f9863r = null;
            SwipeablePostprocessorManager swipeablePostprocessorManager = this.f9851f;
            SwipeableParams a = this.f9870y.m11757a();
            SwipeableParams b = this.f9870y.m11758b();
            SwipeableParams c = this.f9870y.m11759c();
            if (a != null) {
                swipeableRepeatedPostprocessor = swipeablePostprocessorManager.f9882c;
                if (SwipeableItemType.FILTER.equals(a.c)) {
                    str = a.b;
                } else {
                    str = Filter.PassThrough.name();
                }
                swipeableRepeatedPostprocessor.m11830a(str);
            }
            if (b != null) {
                swipeableRepeatedPostprocessor = swipeablePostprocessorManager.f9883d;
                if (SwipeableItemType.FILTER.equals(b.c)) {
                    str = b.b;
                } else {
                    str = Filter.PassThrough.name();
                }
                swipeableRepeatedPostprocessor.m11830a(str);
            }
            if (c != null) {
                swipeableRepeatedPostprocessor = swipeablePostprocessorManager.f9884e;
                if (SwipeableItemType.FILTER.equals(c.c)) {
                    str = c.b;
                } else {
                    str = Filter.PassThrough.name();
                }
                swipeableRepeatedPostprocessor.m11830a(str);
            }
            m11808f();
        }
    }

    public final void m11814a(boolean z) {
        if (this.f9855j != z) {
            this.f9855j = z;
            if (z) {
                this.f9856k = false;
                if (this.f9858m != null) {
                    this.f9851f.m11826e();
                    return;
                } else {
                    m11809g(this);
                    return;
                }
            }
            this.f9856k = true;
            this.f9851f.m11825d();
            this.f9854i = false;
        }
    }

    private void m11808f() {
        GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(this.f9848c.getResources()).e(ScaleType.c);
        e.d = 0;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = e;
        if (this.f9868w == null && this.f9867v == null && this.f9869x == null) {
            this.f9868w = m11810h();
            this.f9867v = m11810h();
            this.f9869x = m11810h();
        }
        if (this.f9865t == null) {
            FbDraweeControllerBuilder fbDraweeControllerBuilder = this.f9850e;
            ImageRequestBuilder a = ImageRequestBuilder.a(this.f9858m);
            a.d = new ResizeOptions(this.f9859n, this.f9860o);
            a = a;
            a.c = true;
            a = a;
            a.j = this.f9851f.f9883d;
            ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).a(this.f9868w)).a(f9846a);
            this.f9865t = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), this.f9848c);
            this.f9865t.a(this.f9850e.s());
        }
        if (this.f9857l) {
            if (this.f9864s == null) {
                fbDraweeControllerBuilder = this.f9850e;
                a = ImageRequestBuilder.a(this.f9858m);
                a.d = new ResizeOptions(this.f9859n, this.f9860o);
                a = a;
                a.c = true;
                a = a;
                a.j = this.f9851f.f9882c;
                ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).a(this.f9867v)).a(f9846a);
                this.f9864s = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), this.f9848c);
                this.f9864s.a(this.f9850e.s());
            }
            if (this.f9866u == null) {
                fbDraweeControllerBuilder = this.f9850e;
                a = ImageRequestBuilder.a(this.f9858m);
                a.d = new ResizeOptions(this.f9859n, this.f9860o);
                a = a;
                a.c = true;
                a = a;
                a.j = this.f9851f.f9884e;
                ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a.m())).a(this.f9869x)).a(f9846a);
                this.f9866u = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), this.f9848c);
                this.f9866u.a(this.f9850e.s());
            }
        } else {
            this.f9864s = null;
            this.f9866u = null;
            this.f9861p = null;
            this.f9863r = null;
        }
        for (SwipeableDraweeControllerGenerator$EventSubscriber a2 : this.f9852g) {
            a2.mo515a(m11805a(this, this.f9864s, this.f9870y.m11757a()), m11805a(this, this.f9865t, this.f9870y.m11758b()), m11805a(this, this.f9866u, this.f9870y.m11759c()));
        }
    }

    public static void m11809g(SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl) {
        Object obj = 1;
        Object obj2 = (swipeableDraweeControllerGeneratorImpl.f9861p != null || swipeableDraweeControllerGeneratorImpl.f9870y.m11757a() == null) ? null : 1;
        Object obj3;
        if (swipeableDraweeControllerGeneratorImpl.f9862q != null || swipeableDraweeControllerGeneratorImpl.f9870y.m11758b() == null) {
            obj3 = null;
        } else {
            obj3 = 1;
        }
        if (swipeableDraweeControllerGeneratorImpl.f9863r != null || swipeableDraweeControllerGeneratorImpl.f9870y.m11759c() == null) {
            obj = null;
        }
        if (swipeableDraweeControllerGeneratorImpl.f9855j) {
            if (swipeableDraweeControllerGeneratorImpl.f9858m != null) {
                Object obj4;
                SwipeablePostprocessorManager swipeablePostprocessorManager = swipeableDraweeControllerGeneratorImpl.f9851f;
                if (swipeablePostprocessorManager.f9885f && swipeablePostprocessorManager.f9886g && swipeablePostprocessorManager.f9887h) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (obj4 == null) {
                    return;
                }
            }
            if (obj2 == null && r3 == null && r1 == null) {
                for (SwipeableDraweeControllerGenerator$EventSubscriber b : swipeableDraweeControllerGeneratorImpl.f9852g) {
                    b.mo516b(swipeableDraweeControllerGeneratorImpl.f9861p, swipeableDraweeControllerGeneratorImpl.f9862q, swipeableDraweeControllerGeneratorImpl.f9863r);
                }
            }
        }
    }

    private BaseControllerListener m11810h() {
        return new C08171(this);
    }

    @Nullable
    public static DraweeSwipeableItem m11805a(@Nullable SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl, DraweeHolder draweeHolder, SwipeableParams swipeableParams) {
        if (swipeableParams == null) {
            return null;
        }
        if (swipeableParams.c != SwipeableItemType.FRAME) {
            return new DraweeSwipeableItem(draweeHolder, swipeableParams.d);
        }
        DraweeSwipeableItem draweeSwipeableItem = new DraweeSwipeableItem(draweeHolder, swipeableParams.d);
        ImmutableList a = swipeableParams.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            StickerParams stickerParams = (StickerParams) a.get(i);
            Uri d = stickerParams.d();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(swipeableDraweeControllerGeneratorImpl.f9848c.getResources());
            genericDraweeHierarchyBuilder.l = swipeableDraweeControllerGeneratorImpl.f9853h;
            genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder.e(ScaleType.c);
            FbPipelineDraweeController s = swipeableDraweeControllerGeneratorImpl.f9850e.b(d).r().a(f9846a).s();
            DraweeHolder a2 = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), swipeableDraweeControllerGeneratorImpl.f9848c);
            a2.a(s);
            draweeSwipeableItem.a(stickerParams, a2);
        }
        return draweeSwipeableItem;
    }
}
