package com.facebook.photos.creativeediting.swipeable.composer;

import android.graphics.RectF;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativecam.ui.CreativeCamSwipeableController.1;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState.SwipingState;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.Listener;
import com.facebook.photos.creativeediting.swipeable.common.OrderedFrameAssetsLoaderListener;
import com.facebook.photos.creativeediting.swipeable.common.SwipeEventListener;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout.DataProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout.SwipeableLayoutEventListener;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableAnimatingNuxViewController;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableAnimatingNuxViewController.C08241;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableAnimatingNuxViewController.C08262;
import com.facebook.photos.creativeediting.swipeable.composer.nux.SwipeableNuxController;
import com.facebook.widget.ScrollingAwareScrollView;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: lost_connection */
public class CreativeEditingSwipeableController {
    public static final String f9797a = CreativeEditingSwipeableController.class.getSimpleName();
    @Nullable
    public DraweeSwipeableItem f9798A;
    @Nullable
    public DraweeSwipeableItem f9799B;
    public SwipeableParams f9800C;
    public SwipeableParams f9801D;
    public SwipeableParams f9802E;
    public ImmutableList<SwipeableParams> f9803F = RegularImmutableList.a;
    @Nullable
    public SwipeableParams f9804G;
    @Nullable
    public 1 f9805H;
    public boolean f9806I;
    private SwipeableNuxManager f9807J;
    public ScrollingAwareScrollView f9808K;
    public SwipeableTouchEventController f9809L;
    private final SwipeableDraweeControllerGenerator$EventSubscriber f9810b = new C08071(this);
    private final SwipeableLayoutEventListener f9811c = new C08082(this);
    private final DataProvider f9812d = new C08093(this);
    private final C08104 f9813e = new C08104(this);
    public final C08115 f9814f = new C08115(this);
    private final C08126 f9815g = new C08126(this);
    private final C08137 f9816h = new C08137(this);
    public final EventListener f9817i;
    private final SwipeableParamsHelper f9818j;
    private final SwipeableTouchEventControllerProvider f9819k;
    public final Set<SwipeEventListener> f9820l = new HashSet();
    private final SwipeableNuxManagerProvider f9821m;
    public final SwipeableDraweeControllerGeneratorImpl f9822n;
    private final FrameAssetsLoader f9823o;
    public final SwipeableParamsListBuilderProvider f9824p;
    private final ArrayList<DraweeSwipeableItem> f9825q = new ArrayList(3);
    public String f9826r;
    public CreativeEditingSwipeableLayout f9827s;
    @Nullable
    private Uri f9828t;
    public int f9829u;
    public int f9830v;
    public boolean f9831w;
    public boolean f9832x;
    public volatile boolean f9833y;
    @Nullable
    public DraweeSwipeableItem f9834z;

    /* compiled from: lost_connection */
    class C08071 implements SwipeableDraweeControllerGenerator$EventSubscriber {
        final /* synthetic */ CreativeEditingSwipeableController f9786a;

        C08071(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9786a = creativeEditingSwipeableController;
        }

        public final void mo515a(DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3) {
            boolean z = true;
            if (this.f9786a.f9831w) {
                boolean z2;
                this.f9786a.f9798A = draweeSwipeableItem2;
                if (draweeSwipeableItem != null) {
                    if (draweeSwipeableItem.c == null || draweeSwipeableItem.c.h() == null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    Preconditions.checkArgument(z2, "left item's drawable hierarchy was not properly set up");
                    draweeSwipeableItem.a(this.f9786a.f9827s);
                    CreativeEditingSwipeableController.m11766a(this.f9786a, draweeSwipeableItem, 0);
                }
                if (draweeSwipeableItem2 != null) {
                    if (draweeSwipeableItem2.c == null || draweeSwipeableItem2.c.h() == null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    Preconditions.checkArgument(z2, "center item's drawable hierarchy was not properly set up");
                    draweeSwipeableItem2.a(this.f9786a.f9827s);
                    CreativeEditingSwipeableController.m11766a(this.f9786a, draweeSwipeableItem2, 1);
                }
                if (draweeSwipeableItem3 != null) {
                    if (draweeSwipeableItem3.c == null || draweeSwipeableItem3.c.h() == null) {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "right item's drawable hierarchy was not properly set up");
                    draweeSwipeableItem3.a(this.f9786a.f9827s);
                    CreativeEditingSwipeableController.m11766a(this.f9786a, draweeSwipeableItem3, 2);
                }
                this.f9786a.m11782b(this.f9786a.f9833y);
            }
        }

        public final void mo514a(DraweeSwipeableItem draweeSwipeableItem) {
            if (this.f9786a.f9831w) {
                this.f9786a.f9827s.m11799a();
                this.f9786a.m11783c();
            }
        }

        public final void mo516b(DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3) {
            if (this.f9786a.f9831w) {
                this.f9786a.f9834z = draweeSwipeableItem;
                this.f9786a.f9798A = draweeSwipeableItem2;
                this.f9786a.f9799B = draweeSwipeableItem3;
                CreativeEditingSwipeableController.m11768m(this.f9786a);
                this.f9786a.f9827s.m11799a();
                this.f9786a.f9827s.m11800b();
                this.f9786a.m11783c();
                if (!this.f9786a.f9806I && !this.f9786a.f9820l.isEmpty()) {
                    this.f9786a.f9806I = true;
                    for (SwipeEventListener a : this.f9786a.f9820l) {
                        a.mo512a(CreativeEditingSwipeableController.m11770q(this.f9786a));
                    }
                }
            }
        }

        public final void mo513a() {
            if (this.f9786a.f9834z != null) {
                CreativeEditingSwipeableController.m11767b(this.f9786a, this.f9786a.f9834z, 0);
            }
            if (this.f9786a.f9798A != null) {
                CreativeEditingSwipeableController.m11767b(this.f9786a, this.f9786a.f9798A, 1);
            }
            if (this.f9786a.f9799B != null) {
                CreativeEditingSwipeableController.m11767b(this.f9786a, this.f9786a.f9799B, 2);
            }
            this.f9786a.f9832x = false;
            this.f9786a.f9827s.m11802f();
            this.f9786a.m11783c();
        }
    }

    /* compiled from: lost_connection */
    class C08082 implements SwipeableLayoutEventListener {
        final /* synthetic */ CreativeEditingSwipeableController f9787a;

        C08082(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9787a = creativeEditingSwipeableController;
        }

        public final void mo517a() {
            if (this.f9787a.m11789k()) {
                this.f9787a.f9822n.m11814a(false);
            }
        }

        public final void mo518a(SwipingTouchEventState swipingTouchEventState, SwipingState swipingState) {
            if (this.f9787a.f9831w) {
                switch (C08159.f9796a[swipingState.ordinal()]) {
                    case 1:
                        if (this.f9787a.f9808K != null) {
                            this.f9787a.f9808K.a = true;
                        }
                        if (!this.f9787a.f9833y) {
                            BLog.b(CreativeEditingSwipeableController.f9797a, "Invisible, no need to update the swiping state");
                            return;
                        } else if (!swipingTouchEventState.h() && !swipingTouchEventState.g()) {
                            return;
                        } else {
                            if (swipingTouchEventState.d()) {
                                int i;
                                CreativeEditingSwipeableController creativeEditingSwipeableController = this.f9787a;
                                if (creativeEditingSwipeableController.f9801D.equals(SwipeableParamsHelper.m11707a(creativeEditingSwipeableController.f9803F, creativeEditingSwipeableController.f9801D.b))) {
                                    i = 0;
                                } else {
                                    i = 1;
                                }
                                creativeEditingSwipeableController.f9800C = i != 0 ? SwipeableParamsHelper.m11712b(creativeEditingSwipeableController.f9803F, creativeEditingSwipeableController.f9802E) : creativeEditingSwipeableController.f9801D;
                                creativeEditingSwipeableController.f9801D = creativeEditingSwipeableController.f9802E;
                                creativeEditingSwipeableController.f9802E = SwipeableParamsHelper.m11706a(creativeEditingSwipeableController.f9803F, creativeEditingSwipeableController.f9801D);
                                creativeEditingSwipeableController.f9834z = creativeEditingSwipeableController.f9798A;
                                creativeEditingSwipeableController.f9798A = creativeEditingSwipeableController.f9799B;
                                CreativeEditingSwipeableController.m11767b(creativeEditingSwipeableController, creativeEditingSwipeableController.f9799B, 2);
                                creativeEditingSwipeableController.f9799B = null;
                                creativeEditingSwipeableController.f9827s.m11801e();
                                creativeEditingSwipeableController.f9817i.mo492a(creativeEditingSwipeableController.f9826r, creativeEditingSwipeableController.f9801D, 1);
                                SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl = creativeEditingSwipeableController.f9822n;
                                swipeableDraweeControllerGeneratorImpl.f9861p = swipeableDraweeControllerGeneratorImpl.f9862q;
                                swipeableDraweeControllerGeneratorImpl.f9862q = swipeableDraweeControllerGeneratorImpl.f9863r;
                                swipeableDraweeControllerGeneratorImpl.f9863r = null;
                                DraweeHolder draweeHolder = swipeableDraweeControllerGeneratorImpl.f9864s;
                                swipeableDraweeControllerGeneratorImpl.f9864s = swipeableDraweeControllerGeneratorImpl.f9865t;
                                swipeableDraweeControllerGeneratorImpl.f9865t = swipeableDraweeControllerGeneratorImpl.f9866u;
                                swipeableDraweeControllerGeneratorImpl.f9866u = draweeHolder;
                                BaseControllerListener baseControllerListener = swipeableDraweeControllerGeneratorImpl.f9867v;
                                swipeableDraweeControllerGeneratorImpl.f9867v = swipeableDraweeControllerGeneratorImpl.f9868w;
                                swipeableDraweeControllerGeneratorImpl.f9868w = swipeableDraweeControllerGeneratorImpl.f9869x;
                                swipeableDraweeControllerGeneratorImpl.f9869x = baseControllerListener;
                                if (swipeableDraweeControllerGeneratorImpl.f9858m != null) {
                                    String str;
                                    SwipeablePostprocessorManager swipeablePostprocessorManager = swipeableDraweeControllerGeneratorImpl.f9851f;
                                    if (SwipeableItemType.FILTER.equals(swipeableDraweeControllerGeneratorImpl.f9870y.m11759c().c)) {
                                        str = swipeableDraweeControllerGeneratorImpl.f9870y.m11759c().b;
                                    } else {
                                        str = Filter.PassThrough.name();
                                    }
                                    SwipeableRepeatedPostprocessor swipeableRepeatedPostprocessor = swipeablePostprocessorManager.f9882c;
                                    swipeablePostprocessorManager.f9882c = swipeablePostprocessorManager.f9883d;
                                    swipeablePostprocessorManager.f9883d = swipeablePostprocessorManager.f9884e;
                                    swipeablePostprocessorManager.f9884e = swipeableRepeatedPostprocessor;
                                    swipeablePostprocessorManager.f9887h = false;
                                    swipeablePostprocessorManager.f9884e.m11830a(str);
                                } else {
                                    swipeableDraweeControllerGeneratorImpl.f9863r = SwipeableDraweeControllerGeneratorImpl.m11805a(swipeableDraweeControllerGeneratorImpl, swipeableDraweeControllerGeneratorImpl.f9866u, swipeableDraweeControllerGeneratorImpl.f9870y.m11759c());
                                    SwipeableDraweeControllerGeneratorImpl.m11809g(swipeableDraweeControllerGeneratorImpl);
                                }
                                creativeEditingSwipeableController.m11783c();
                                for (SwipeEventListener a : creativeEditingSwipeableController.f9820l) {
                                    a.mo510a();
                                }
                                return;
                            } else if (swipingTouchEventState.e()) {
                                CreativeEditingSwipeableController.m11769p(this.f9787a);
                                return;
                            } else if (swipingTouchEventState.i()) {
                                this.f9787a.f9827s.m11799a();
                                this.f9787a.m11783c();
                                this.f9787a.f9804G = this.f9787a.f9801D;
                                return;
                            } else {
                                return;
                            }
                        }
                    case 2:
                        if (this.f9787a.f9808K != null) {
                            this.f9787a.f9808K.a = false;
                            return;
                        }
                        return;
                    case 3:
                        if (this.f9787a.f9809L.m11847g()) {
                            SwipeableParams swipeableParams;
                            CreativeEditingSwipeableController creativeEditingSwipeableController2 = this.f9787a;
                            if (swipingTouchEventState.d()) {
                                swipeableParams = this.f9787a.f9802E;
                            } else {
                                swipeableParams = this.f9787a.f9800C;
                            }
                            creativeEditingSwipeableController2.f9804G = swipeableParams;
                            for (SwipeEventListener a2 : this.f9787a.f9820l) {
                                a2.mo511a(this.f9787a.f9804G);
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final void mo519b() {
            if (CreativeEditingSwipeableController.m11770q(this.f9787a)) {
                this.f9787a.f9809L.m11846f();
            }
        }
    }

    /* compiled from: lost_connection */
    class C08093 implements DataProvider {
        final /* synthetic */ CreativeEditingSwipeableController f9788a;

        C08093(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9788a = creativeEditingSwipeableController;
        }

        public final boolean mo520a() {
            return CreativeEditingSwipeableController.m11771r(this.f9788a);
        }

        @Nullable
        public final DraweeSwipeableItem mo521b() {
            return this.f9788a.f9834z;
        }

        @Nullable
        public final DraweeSwipeableItem mo522c() {
            return this.f9788a.f9798A;
        }

        @Nullable
        public final DraweeSwipeableItem mo523d() {
            return this.f9788a.f9799B;
        }

        public final SwipingTouchEventState mo524e() {
            return this.f9788a.f9809L.f9917o;
        }

        public final float mo525f() {
            return this.f9788a.f9809L.m11845e();
        }
    }

    /* compiled from: lost_connection */
    public class C08104 {
        final /* synthetic */ CreativeEditingSwipeableController f9789a;

        C08104(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9789a = creativeEditingSwipeableController;
        }

        public final SwipeableParams m11757a() {
            return this.f9789a.f9800C;
        }

        public final SwipeableParams m11758b() {
            return this.f9789a.f9801D;
        }

        public final SwipeableParams m11759c() {
            return this.f9789a.f9802E;
        }
    }

    /* compiled from: lost_connection */
    public class C08115 {
        public final /* synthetic */ CreativeEditingSwipeableController f9790a;

        C08115(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9790a = creativeEditingSwipeableController;
        }

        public final void m11760a() {
            this.f9790a.f9809L.m11844b(false);
        }
    }

    /* compiled from: lost_connection */
    public class C08126 {
        final /* synthetic */ CreativeEditingSwipeableController f9791a;

        C08126(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9791a = creativeEditingSwipeableController;
        }

        public final void m11761a(SwipeableAnimatingNuxViewController swipeableAnimatingNuxViewController) {
            ViewGroup viewGroup = (ViewGroup) this.f9791a.f9827s.f9839d.a();
            C08115 c08115 = this.f9791a.f9814f;
            swipeableAnimatingNuxViewController.f9927b = viewGroup;
            swipeableAnimatingNuxViewController.f9933i = c08115;
            viewGroup.removeAllViews();
            swipeableAnimatingNuxViewController.f9931g = swipeableAnimatingNuxViewController.mo527a();
            ((ViewGroup) viewGroup.getParent().getParent()).addView(swipeableAnimatingNuxViewController.f9931g);
            LayoutParamsUtil.a(swipeableAnimatingNuxViewController.f9931g, -2, -2);
            swipeableAnimatingNuxViewController.f9932h = swipeableAnimatingNuxViewController.mo528b();
            if (swipeableAnimatingNuxViewController.f9932h != null) {
                viewGroup.addView(swipeableAnimatingNuxViewController.f9932h);
            }
            swipeableAnimatingNuxViewController.f9929e = swipeableAnimatingNuxViewController.mo533g();
            if (!swipeableAnimatingNuxViewController.mo534h()) {
                if (!SwipeableAnimatingNuxViewController.f9925c.get()) {
                    swipeableAnimatingNuxViewController.f9928d = true;
                    swipeableAnimatingNuxViewController.f9927b.postDelayed(new C08241(swipeableAnimatingNuxViewController), 200);
                }
            } else if (!SwipeableAnimatingNuxViewController.f9925c.get()) {
                swipeableAnimatingNuxViewController.f9928d = true;
                swipeableAnimatingNuxViewController.f9927b.postDelayed(new C08262(swipeableAnimatingNuxViewController), 200);
            }
        }
    }

    /* compiled from: lost_connection */
    public class C08137 {
        final /* synthetic */ CreativeEditingSwipeableController f9792a;

        C08137(CreativeEditingSwipeableController creativeEditingSwipeableController) {
            this.f9792a = creativeEditingSwipeableController;
        }

        public final boolean m11762a() {
            return CreativeEditingSwipeableController.m11771r(this.f9792a);
        }

        public final boolean m11763b() {
            return CreativeEditingSwipeableController.m11770q(this.f9792a);
        }
    }

    /* compiled from: lost_connection */
    /* synthetic */ class C08159 {
        static final /* synthetic */ int[] f9796a = new int[SwipingState.values().length];

        static {
            try {
                f9796a[SwipingState.NOT_SWIPING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9796a[SwipingState.SWIPING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9796a[SwipingState.FINISHING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public CreativeEditingSwipeableController(@Assisted EventListener eventListener, @Assisted SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl, @Nullable @Assisted Uri uri, @Assisted String str, SwipeableNuxManagerProvider swipeableNuxManagerProvider, SwipeableParamsHelper swipeableParamsHelper, SwipeableTouchEventControllerProvider swipeableTouchEventControllerProvider, FrameAssetsLoader frameAssetsLoader, SwipeableParamsListBuilderProvider swipeableParamsListBuilderProvider) {
        this.f9817i = eventListener;
        this.f9821m = swipeableNuxManagerProvider;
        this.f9818j = swipeableParamsHelper;
        this.f9819k = swipeableTouchEventControllerProvider;
        this.f9822n = swipeableDraweeControllerGeneratorImpl;
        this.f9828t = uri;
        this.f9826r = str;
        this.f9823o = frameAssetsLoader;
        this.f9824p = swipeableParamsListBuilderProvider;
        this.f9825q.add(null);
        this.f9825q.add(null);
        this.f9825q.add(null);
        this.f9809L = this.f9819k.m11848a(this.f9816h);
    }

    public final void m11774a(CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, int i, int i2, boolean z) {
        boolean z2 = false;
        Preconditions.checkArgument(i > 0);
        if (i2 > 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f9829u = i;
        this.f9830v = i2;
        this.f9827s = (CreativeEditingSwipeableLayout) Preconditions.checkNotNull(creativeEditingSwipeableLayout);
        this.f9827s.f9844i = this.f9812d;
        this.f9827s.f9843h = this.f9811c;
        SwipeableTouchEventController swipeableTouchEventController = this.f9809L;
        swipeableTouchEventController.f9920r = (CreativeEditingSwipeableLayout) Preconditions.checkNotNull(this.f9827s);
        swipeableTouchEventController.f9920r.setOnTouchListener(swipeableTouchEventController.f9913k);
        this.f9831w = true;
        this.f9822n.m11812a(this.f9828t, this.f9829u, this.f9830v, this.f9810b, z, this.f9813e);
    }

    public final void m11776a(ImmutableList<Frame> immutableList, @Nullable Listener listener, @Nullable String str) {
        this.f9823o.m11672a((ImmutableList) immutableList, m11765a(listener, str));
    }

    public final void m11781b(ImmutableList<Frame> immutableList, @Nullable Listener listener, @Nullable String str) {
        this.f9823o.m11672a((ImmutableList) immutableList, new OrderedFrameAssetsLoaderListener(immutableList, m11765a(listener, str)));
    }

    private Listener m11765a(@Nullable final Listener listener, @Nullable final String str) {
        return new Listener(this) {
            final /* synthetic */ CreativeEditingSwipeableController f9795c;

            public final void mo509a(FrameModel frameModel) {
                if (this.f9795c.f9831w) {
                    this.f9795c.m11777a(this.f9795c.f9824p.m11726a(this.f9795c.f9829u, this.f9795c.f9830v).m11722a(this.f9795c.f9803F).m11721a(frameModel, "").m11724b(), str);
                    if (listener != null) {
                        listener.mo509a(frameModel);
                    }
                }
            }
        };
    }

    public final void m11777a(ImmutableList<SwipeableParams> immutableList, @Nullable String str) {
        Preconditions.checkArgument(this.f9831w, "You must bind this controller before setting its swipeable params list");
        this.f9803F = immutableList;
        if (this.f9828t != null && this.f9803F.isEmpty()) {
            this.f9803F = ImmutableList.of(new SwipeableParams(RegularImmutableList.a, Filter.PassThrough.name(), SwipeableItemType.FILTER, this.f9818j.m11718a(Filter.PassThrough.name())));
        }
        if (this.f9805H != null) {
            1 1 = this.f9805H;
            1.a.d.m11700a(1.a.r, this.f9803F, 1.a.k);
        }
        this.f9806I = false;
        if (StringUtil.a(str)) {
            String name;
            if (this.f9801D == null) {
                name = Filter.PassThrough.name();
            } else {
                name = this.f9801D.b;
            }
            m11778a(name);
            return;
        }
        if (SwipeableParamsHelper.m11707a(this.f9803F, str) == null) {
            str = Filter.PassThrough.name();
        }
        m11778a(str);
    }

    public final void m11778a(String str) {
        Preconditions.checkNotNull(str);
        SwipeableParams a = SwipeableParamsHelper.m11707a(this.f9803F, str);
        if (a != null) {
            SwipeableParams swipeableParams = this.f9800C;
            SwipeableParams swipeableParams2 = this.f9801D;
            SwipeableParams swipeableParams3 = this.f9802E;
            this.f9801D = a;
            this.f9804G = a;
            this.f9800C = SwipeableParamsHelper.m11712b(this.f9803F, this.f9801D);
            this.f9802E = SwipeableParamsHelper.m11706a(this.f9803F, this.f9801D);
            if (!Objects.equal(swipeableParams, this.f9800C) || !Objects.equal(swipeableParams2, this.f9801D) || !Objects.equal(swipeableParams3, this.f9802E)) {
                this.f9822n.m11811a();
            }
        }
    }

    public final void m11775a(@Nullable ImmutableList<SwipeableNuxController> immutableList) {
        if (immutableList != null && !immutableList.isEmpty()) {
            if (this.f9807J == null) {
                this.f9807J = new SwipeableNuxManager(this.f9815g);
                m11773a(this.f9807J);
            }
            this.f9807J.f9873c = (ImmutableList) Preconditions.checkNotNull(immutableList);
        }
    }

    public final void m11772a(@Nullable OnClickListener onClickListener) {
        this.f9809L.f9922t = onClickListener;
    }

    public final void m11780b() {
        this.f9809L.f9924v = false;
    }

    public final void m11783c() {
        if (m11770q(this)) {
            SwipeableTouchEventController swipeableTouchEventController = this.f9809L;
            if (swipeableTouchEventController.f9918p.m11762a() && swipeableTouchEventController.f9905c) {
                swipeableTouchEventController.f9905c = false;
                if (swipeableTouchEventController.f9908f != null) {
                    float floatValue = ((Float) swipeableTouchEventController.f9908f.a).floatValue();
                    float floatValue2 = ((Float) swipeableTouchEventController.f9908f.b).floatValue();
                    swipeableTouchEventController.f9908f = null;
                    SwipeableTouchEventController.m11841c(swipeableTouchEventController, floatValue);
                    SwipeableTouchEventController.m11839a(swipeableTouchEventController, SwipingState.SWIPING);
                    SwipeableTouchEventController.m11838a(swipeableTouchEventController, floatValue2, 0.0f, true, false);
                    return;
                }
                SwipeableTouchEventController.m11841c(swipeableTouchEventController, swipeableTouchEventController.f9906d);
                SwipeableTouchEventController.m11839a(swipeableTouchEventController, SwipingState.SWIPING);
                SwipeableTouchEventController.m11838a(swipeableTouchEventController, swipeableTouchEventController.f9907e, swipeableTouchEventController.f9907e - swipeableTouchEventController.f9906d, false, false);
            }
        }
    }

    public final void m11773a(SwipeEventListener swipeEventListener) {
        this.f9820l.add(swipeEventListener);
    }

    public final RectF m11784d() {
        return new RectF(0.0f, 0.0f, (float) this.f9827s.getMeasuredWidth(), (float) this.f9827s.getMeasuredHeight());
    }

    public final void m11785f() {
        if (this.f9827s != null) {
            this.f9827s.m11802f();
        }
    }

    public final void m11779a(RectF[] rectFArr) {
        this.f9822n.f9851f.m11824a(rectFArr);
    }

    @Nullable
    public final String m11786g() {
        if (m11789k()) {
            return this.f9804G != null ? this.f9804G.b : "";
        } else {
            return null;
        }
    }

    @Nullable
    public final ImmutableList<StickerParams> m11787i() {
        if (this.f9804G == null) {
            return null;
        }
        return this.f9804G.a();
    }

    public final void m11788j() {
        this.f9831w = false;
        if (this.f9807J != null) {
            this.f9820l.remove(this.f9807J);
        }
        SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl = this.f9822n;
        swipeableDraweeControllerGeneratorImpl.f9852g.clear();
        swipeableDraweeControllerGeneratorImpl.f9851f.m11825d();
        swipeableDraweeControllerGeneratorImpl.f9854i = false;
        SwipeableTouchEventController swipeableTouchEventController = this.f9809L;
        if (swipeableTouchEventController.f9920r != null) {
            swipeableTouchEventController.f9916n.a();
            swipeableTouchEventController.f9920r.setOnTouchListener(null);
            swipeableTouchEventController.f9920r = null;
        }
        this.f9827s = null;
    }

    public final boolean m11789k() {
        return this.f9831w && this.f9822n != null;
    }

    public final void m11782b(boolean z) {
        this.f9827s.setVisibility(z ? 0 : 4);
        if (this.f9833y != z) {
            this.f9833y = z;
            if (this.f9822n != null) {
                this.f9822n.m11814a(z);
            }
            if (z) {
                m11768m(this);
                this.f9832x = true;
                return;
            }
            if (this.f9834z != null) {
                m11767b(this, this.f9834z, 0);
            }
            if (this.f9798A != null) {
                m11767b(this, this.f9798A, 1);
            }
            if (this.f9799B != null) {
                m11767b(this, this.f9799B, 2);
            }
        }
    }

    public static void m11766a(CreativeEditingSwipeableController creativeEditingSwipeableController, DraweeSwipeableItem draweeSwipeableItem, int i) {
        Preconditions.checkNotNull(draweeSwipeableItem);
        if (creativeEditingSwipeableController.f9825q.get(i) != null) {
            m11767b(creativeEditingSwipeableController, draweeSwipeableItem, i);
        }
        creativeEditingSwipeableController.f9825q.set(i, draweeSwipeableItem);
        draweeSwipeableItem.e.set(true);
        if (draweeSwipeableItem.c != null) {
            draweeSwipeableItem.c.b();
        }
        for (DraweeHolder b : draweeSwipeableItem.b.values()) {
            b.b();
        }
    }

    public static void m11767b(CreativeEditingSwipeableController creativeEditingSwipeableController, DraweeSwipeableItem draweeSwipeableItem, int i) {
        if (draweeSwipeableItem != null) {
            creativeEditingSwipeableController.f9825q.set(i, null);
            draweeSwipeableItem.e.set(false);
            if (draweeSwipeableItem.c != null) {
                draweeSwipeableItem.c.d();
            }
            for (DraweeHolder d : draweeSwipeableItem.b.values()) {
                d.d();
            }
        }
    }

    public static void m11768m(CreativeEditingSwipeableController creativeEditingSwipeableController) {
        if (creativeEditingSwipeableController.f9834z != null) {
            if (creativeEditingSwipeableController.f9834z.d == null) {
                creativeEditingSwipeableController.f9834z.a(creativeEditingSwipeableController.f9827s);
            }
            m11766a(creativeEditingSwipeableController, creativeEditingSwipeableController.f9834z, 0);
        }
        if (creativeEditingSwipeableController.f9798A != null) {
            if (creativeEditingSwipeableController.f9798A.d == null) {
                creativeEditingSwipeableController.f9798A.a(creativeEditingSwipeableController.f9827s);
            }
            m11766a(creativeEditingSwipeableController, creativeEditingSwipeableController.f9798A, 1);
        }
        if (creativeEditingSwipeableController.f9799B != null) {
            if (creativeEditingSwipeableController.f9799B.d == null) {
                creativeEditingSwipeableController.f9799B.a(creativeEditingSwipeableController.f9827s);
            }
            m11766a(creativeEditingSwipeableController, creativeEditingSwipeableController.f9799B, 2);
        }
    }

    public static void m11769p(CreativeEditingSwipeableController creativeEditingSwipeableController) {
        int i;
        if (creativeEditingSwipeableController.f9801D.equals(SwipeableParamsHelper.m11707a(creativeEditingSwipeableController.f9803F, creativeEditingSwipeableController.f9801D.b))) {
            i = 0;
        } else {
            i = 1;
        }
        creativeEditingSwipeableController.f9802E = i != 0 ? SwipeableParamsHelper.m11706a(creativeEditingSwipeableController.f9803F, creativeEditingSwipeableController.f9800C) : creativeEditingSwipeableController.f9801D;
        creativeEditingSwipeableController.f9801D = creativeEditingSwipeableController.f9800C;
        creativeEditingSwipeableController.f9800C = SwipeableParamsHelper.m11712b(creativeEditingSwipeableController.f9803F, creativeEditingSwipeableController.f9801D);
        creativeEditingSwipeableController.f9799B = creativeEditingSwipeableController.f9798A;
        creativeEditingSwipeableController.f9798A = creativeEditingSwipeableController.f9834z;
        m11767b(creativeEditingSwipeableController, creativeEditingSwipeableController.f9834z, 0);
        creativeEditingSwipeableController.f9834z = null;
        creativeEditingSwipeableController.f9827s.m11801e();
        creativeEditingSwipeableController.f9817i.mo492a(creativeEditingSwipeableController.f9826r, creativeEditingSwipeableController.f9801D, 0);
        SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl = creativeEditingSwipeableController.f9822n;
        swipeableDraweeControllerGeneratorImpl.f9863r = swipeableDraweeControllerGeneratorImpl.f9862q;
        swipeableDraweeControllerGeneratorImpl.f9862q = swipeableDraweeControllerGeneratorImpl.f9861p;
        swipeableDraweeControllerGeneratorImpl.f9861p = null;
        DraweeHolder draweeHolder = swipeableDraweeControllerGeneratorImpl.f9866u;
        swipeableDraweeControllerGeneratorImpl.f9866u = swipeableDraweeControllerGeneratorImpl.f9865t;
        swipeableDraweeControllerGeneratorImpl.f9865t = swipeableDraweeControllerGeneratorImpl.f9864s;
        swipeableDraweeControllerGeneratorImpl.f9864s = draweeHolder;
        BaseControllerListener baseControllerListener = swipeableDraweeControllerGeneratorImpl.f9869x;
        swipeableDraweeControllerGeneratorImpl.f9869x = swipeableDraweeControllerGeneratorImpl.f9868w;
        swipeableDraweeControllerGeneratorImpl.f9868w = swipeableDraweeControllerGeneratorImpl.f9867v;
        swipeableDraweeControllerGeneratorImpl.f9867v = baseControllerListener;
        if (swipeableDraweeControllerGeneratorImpl.f9858m != null) {
            String str;
            SwipeablePostprocessorManager swipeablePostprocessorManager = swipeableDraweeControllerGeneratorImpl.f9851f;
            if (SwipeableItemType.FILTER.equals(swipeableDraweeControllerGeneratorImpl.f9870y.m11757a().c)) {
                str = swipeableDraweeControllerGeneratorImpl.f9870y.m11757a().b;
            } else {
                str = Filter.PassThrough.name();
            }
            SwipeableRepeatedPostprocessor swipeableRepeatedPostprocessor = swipeablePostprocessorManager.f9884e;
            swipeablePostprocessorManager.f9884e = swipeablePostprocessorManager.f9883d;
            swipeablePostprocessorManager.f9883d = swipeablePostprocessorManager.f9882c;
            swipeablePostprocessorManager.f9882c = swipeableRepeatedPostprocessor;
            swipeablePostprocessorManager.f9885f = false;
            swipeablePostprocessorManager.f9882c.m11830a(str);
        } else {
            swipeableDraweeControllerGeneratorImpl.f9861p = SwipeableDraweeControllerGeneratorImpl.m11805a(swipeableDraweeControllerGeneratorImpl, swipeableDraweeControllerGeneratorImpl.f9864s, swipeableDraweeControllerGeneratorImpl.f9870y.m11757a());
            SwipeableDraweeControllerGeneratorImpl.m11809g(swipeableDraweeControllerGeneratorImpl);
        }
        creativeEditingSwipeableController.m11783c();
        for (SwipeEventListener a : creativeEditingSwipeableController.f9820l) {
            a.mo510a();
        }
    }

    public static boolean m11770q(CreativeEditingSwipeableController creativeEditingSwipeableController) {
        if (creativeEditingSwipeableController.f9803F == null || creativeEditingSwipeableController.f9803F.size() <= 1 || !creativeEditingSwipeableController.f9809L.f9924v) {
            return false;
        }
        return true;
    }

    public static boolean m11771r(CreativeEditingSwipeableController creativeEditingSwipeableController) {
        return m11770q(creativeEditingSwipeableController) && creativeEditingSwipeableController.f9832x && creativeEditingSwipeableController.f9834z != null && creativeEditingSwipeableController.f9799B != null;
    }
}
