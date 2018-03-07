package com.facebook.widget.tiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.ActivityListenerManager;
import com.facebook.common.activitylistener.BaseActivityListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.SizeUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.ImageType;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapperListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.shortcuts.MessengerShortcutHelper;
import com.facebook.messaging.shortcuts.MessengerShortcutHelper.1;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.stickers.store.StickerStoreFragment */
public class ThreadTileDrawableController {
    public static final CallerContext f19946a = CallerContext.a(ThreadTileDrawableController.class, "thread_tile_view", "thread_tile");
    private final Resources f19947b;
    public final ImagePipeline f19948c;
    public final Executor f19949d;
    public final Provider<Boolean> f19950e;
    private final AbstractFbErrorReporter f19951f;
    public final SelfRegistrableReceiverImpl f19952g;
    private final AnalyticsLogger f19953h;
    public final ImagePipelineWrapper f19954i;
    public final GatekeeperStoreImpl f19955j;
    private final ExecutorService f19956k;
    private final ThreadUserTile[] f19957l;
    public Drawable f19958m;
    public ThreadTileDrawable f19959n;
    private UserInitialsDrawable f19960o;
    public UserBadgeDrawable f19961p;
    private Drawable f19962q;
    public int f19963r;
    public ThreadTileViewData f19964s;
    public boolean f19965t;
    public boolean f19966u;
    public boolean f19967v;
    public 1 f19968w;
    private boolean f19969x;
    private final ActivityListener f19970y = new C14971(this);

    /* compiled from: com.facebook.stickers.store.StickerStoreFragment */
    class C14971 extends BaseActivityListener {
        final /* synthetic */ ThreadTileDrawableController f19930a;

        C14971(ThreadTileDrawableController threadTileDrawableController) {
            this.f19930a = threadTileDrawableController;
        }

        public final void m28656b(Activity activity) {
            if (!this.f19930a.f19967v) {
                this.f19930a.f19967v = true;
                ThreadTileDrawableController.m28669g(this.f19930a);
            }
        }

        public final void m28657e(Activity activity) {
            if (this.f19930a.f19967v) {
                this.f19930a.f19967v = false;
                ThreadTileDrawableController.m28668f(this.f19930a);
            }
        }
    }

    /* compiled from: com.facebook.stickers.store.StickerStoreFragment */
    class C14982 implements ActionReceiver {
        final /* synthetic */ ThreadTileDrawableController f19931a;

        C14982(ThreadTileDrawableController threadTileDrawableController) {
            this.f19931a = threadTileDrawableController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1712939701);
            ThreadTileDrawableController threadTileDrawableController = this.f19931a;
            ImmutableSet copyOf = ImmutableSet.copyOf(intent.getParcelableArrayListExtra("updated_users"));
            ImmutableList d = threadTileDrawableController.f19964s.mo1512d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                if (copyOf.contains((UserKey) d.get(i))) {
                    ThreadTileDrawableController.m28669g(threadTileDrawableController);
                    break;
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2098158062, a);
        }
    }

    /* compiled from: com.facebook.stickers.store.StickerStoreFragment */
    public class C15004 implements ImagePipelineWrapperListener<CloseableReference<CloseableImage>> {
        final /* synthetic */ int f19937a;
        final /* synthetic */ boolean f19938b;
        final /* synthetic */ ThreadTileDrawableController f19939c;

        public C15004(ThreadTileDrawableController threadTileDrawableController, int i, boolean z) {
            this.f19939c = threadTileDrawableController;
            this.f19937a = i;
            this.f19938b = z;
        }

        public final void m28659a(DataSource<CloseableReference<CloseableImage>> dataSource) {
            ThreadTileDrawableController.m28663a(this.f19939c, this.f19937a, (DataSource) dataSource);
        }

        public final void m28658a() {
            ThreadTileDrawableController.m28664a(this.f19939c, this.f19937a, this.f19938b);
        }
    }

    /* compiled from: com.facebook.stickers.store.StickerStoreFragment */
    public class C15015 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        final /* synthetic */ int f19940a;
        final /* synthetic */ boolean f19941b;
        final /* synthetic */ ThreadTileDrawableController f19942c;

        public C15015(ThreadTileDrawableController threadTileDrawableController, int i, boolean z) {
            this.f19942c = threadTileDrawableController;
            this.f19940a = i;
            this.f19941b = z;
        }

        public final void m28660e(DataSource<CloseableReference<CloseableImage>> dataSource) {
            ThreadTileDrawableController.m28663a(this.f19942c, this.f19940a, (DataSource) dataSource);
        }

        public final void m28661f(DataSource dataSource) {
            ThreadTileDrawableController.m28664a(this.f19942c, this.f19940a, this.f19941b);
        }
    }

    /* compiled from: com.facebook.stickers.store.StickerStoreFragment */
    public class ThreadUserTile {
        public ImageRequest f19943a;
        public DataSource<CloseableReference<CloseableImage>> f19944b;
        public CloseableReference<CloseableImage> f19945c;
    }

    public static ThreadTileDrawableController m28665b(InjectorLike injectorLike) {
        return new ThreadTileDrawableController(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4376), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4377), ImagePipelineWrapper.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThreadTileDrawableController(AnalyticsLogger analyticsLogger, Resources resources, ImagePipeline imagePipeline, Executor executor, Provider<Boolean> provider, FbErrorReporter fbErrorReporter, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider2, ImagePipelineWrapper imagePipelineWrapper, GatekeeperStore gatekeeperStore, ExecutorService executorService) {
        this.f19947b = resources;
        this.f19948c = imagePipeline;
        this.f19949d = executor;
        this.f19950e = provider;
        this.f19951f = fbErrorReporter;
        this.f19967v = true;
        this.f19953h = analyticsLogger;
        this.f19954i = imagePipelineWrapper;
        this.f19955j = gatekeeperStore;
        this.f19956k = executorService;
        this.f19969x = ((Boolean) provider2.get()).booleanValue();
        this.f19965t = true;
        this.f19966u = false;
        this.f19957l = new ThreadUserTile[3];
        for (int i = 0; i < this.f19957l.length; i++) {
            this.f19957l[i] = new ThreadUserTile();
        }
        this.f19952g = fbBroadcastManager.a().a("com.facebook.orca.users.ACTION_USERS_UPDATED", new C14982(this)).a();
    }

    public final void m28674a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThreadTileDrawable, i, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f19962q = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize > 0) {
            this.f19963r = dimensionPixelSize;
        } else {
            this.f19963r = SizeUtil.a(context, 50.0f);
        }
        this.f19959n = new ThreadTileDrawable(context, attributeSet, i);
        this.f19960o = new UserInitialsDrawable();
        this.f19960o.a(context, 2131361853);
        this.f19960o.a((float) SizeUtil.a(context.getResources(), 2131427409));
        this.f19961p = new UserBadgeDrawable(context, attributeSet, i);
        this.f19958m = new LayerDrawable(this.f19962q == null ? new Drawable[]{this.f19959n, this.f19960o, this.f19961p} : new Drawable[]{this.f19959n, this.f19960o, this.f19962q, this.f19961p});
        if (!this.f19969x) {
            ActivityListenerManager.a(this.f19970y, context);
        }
    }

    public final void m28673a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f19958m.setBounds(i3, i4, i - i5, i2 - i6);
        if (this.f19962q != null) {
            this.f19962q.setBounds(0, 0, i, i2);
        }
    }

    public static void m28668f(ThreadTileDrawableController threadTileDrawableController) {
        if (threadTileDrawableController.f19965t || !threadTileDrawableController.f19967v) {
            for (int i = 0; i < threadTileDrawableController.f19957l.length; i++) {
                threadTileDrawableController.m28666b(i);
            }
        }
    }

    public final void m28672a(int i) {
        Preconditions.checkArgument(i > 0);
        if (this.f19963r != i) {
            this.f19963r = i;
            m28675a(this.f19964s);
        }
    }

    public final void m28675a(ThreadTileViewData threadTileViewData) {
        this.f19964s = threadTileViewData;
        m28669g(this);
    }

    public static void m28669g(ThreadTileDrawableController threadTileDrawableController) {
        int i = 0;
        if ((!threadTileDrawableController.f19965t && threadTileDrawableController.f19967v) || threadTileDrawableController.f19966u) {
            TileBadge b;
            int a;
            if (threadTileDrawableController.f19964s != null) {
                b = threadTileDrawableController.f19964s.mo1510b();
                a = threadTileDrawableController.f19964s.mo1507a();
            } else {
                b = TileBadge.NONE;
                a = 0;
            }
            threadTileDrawableController.f19961p.a(b);
            threadTileDrawableController.f19959n.m28654a(a);
            while (i < threadTileDrawableController.f19957l.length) {
                if (i >= a) {
                    threadTileDrawableController.m28666b(i);
                } else {
                    threadTileDrawableController.m28667c(i);
                }
                i++;
            }
        }
    }

    private void m28666b(int i) {
        ThreadUserTile threadUserTile = this.f19957l[i];
        if (threadUserTile.f19945c != null) {
            threadUserTile.f19945c.close();
            threadUserTile.f19945c = null;
        }
        if (threadUserTile.f19944b != null) {
            threadUserTile.f19944b.g();
            threadUserTile.f19944b = null;
        }
        threadUserTile.f19943a = null;
        ThreadTileDrawable threadTileDrawable = this.f19959n;
        boolean z = i >= 0 && i < threadTileDrawable.f19928i.length;
        Preconditions.checkArgument(z);
        ShapeDrawable shapeDrawable = threadTileDrawable.f19928i[i];
        if (shapeDrawable != null && shapeDrawable.getShaderFactory() != null) {
            Shape shape = shapeDrawable.getShape();
            shapeDrawable.setShaderFactory(null);
            shapeDrawable.getPaint().setShader(null);
            shapeDrawable.setShape(shape);
        }
    }

    private void m28667c(int i) {
        Bitmap e = this.f19964s.mo1513e();
        if (e != null) {
            this.f19960o.a();
            m28666b(i);
            this.f19959n.m28655a(i, e);
            m28670h();
            return;
        }
        m28662a(i, this.f19964s.mo1508a(i, this.f19963r, this.f19963r), true);
    }

    private void m28662a(int i, ImageRequest imageRequest, boolean z) {
        final ThreadUserTile threadUserTile = this.f19957l[i];
        if (threadUserTile.f19943a == null || imageRequest == null || !threadUserTile.f19943a.equals(imageRequest)) {
            if (!(this.f19960o.d == null || this.f19960o.b(this.f19964s.mo1514f()))) {
                this.f19960o.a();
            }
            m28666b(i);
            threadUserTile.f19943a = imageRequest;
            if (imageRequest != null) {
                m28671j();
                final ImageRequest imageRequest2 = imageRequest;
                final int i2 = i;
                final boolean z2 = z;
                ExecutorDetour.a(this.f19956k, new Runnable(this) {
                    final /* synthetic */ ThreadTileDrawableController f19936e;

                    public void run() {
                        ThreadTileDrawableController threadTileDrawableController = this.f19936e;
                        ImageRequest imageRequest = imageRequest2;
                        ThreadUserTile threadUserTile = threadUserTile;
                        int i = i2;
                        boolean z = z2;
                        ImageRequestBuilder a = ImageRequestBuilder.a(imageRequest);
                        if (((Boolean) threadTileDrawableController.f19950e.get()).booleanValue() && !threadTileDrawableController.f19964s.mo1511c()) {
                            a.f = ImageType.SMALL;
                        }
                        if (threadTileDrawableController.f19955j.a(240, false)) {
                            if (threadTileDrawableController.f19963r > 0) {
                                a.d = new ResizeOptions(threadTileDrawableController.f19963r, threadTileDrawableController.f19963r);
                            } else {
                                a.d = new ResizeOptions(threadTileDrawableController.f19959n.getBounds().width(), threadTileDrawableController.f19959n.getBounds().height());
                            }
                            DataSource b = threadTileDrawableController.f19954i.b(a, ThreadTileDrawableController.f19946a);
                            threadUserTile.f19944b = b;
                            threadTileDrawableController.f19954i.a(b, new C15004(threadTileDrawableController, i, z));
                            return;
                        }
                        b = threadTileDrawableController.f19948c.c(a.m(), ThreadTileDrawableController.f19946a);
                        threadUserTile.f19944b = b;
                        b.a(new C15015(threadTileDrawableController, i, z), threadTileDrawableController.f19949d);
                    }
                }, 429064461);
            }
        }
    }

    public static void m28663a(ThreadTileDrawableController threadTileDrawableController, int i, DataSource dataSource) {
        if (dataSource.b()) {
            ThreadUserTile threadUserTile = threadTileDrawableController.f19957l[i];
            if (threadUserTile.f19944b == null || threadUserTile.f19944b == dataSource) {
                threadUserTile.f19944b = null;
                int i2 = threadTileDrawableController.f19959n.f19929j;
                if (i >= i2) {
                    threadTileDrawableController.f19951f.a("T5504543", "Setting ThreadTile at an invalid index (" + i + ", tileCount = " + i2 + ")");
                    return;
                }
                threadTileDrawableController.f19960o.a();
                CloseableReference closeableReference = (CloseableReference) dataSource.d();
                if (closeableReference == null || !(closeableReference.a() instanceof CloseableBitmap)) {
                    CloseableReference.c(closeableReference);
                } else {
                    threadUserTile.f19945c = closeableReference;
                    CloseableBitmap closeableBitmap = (CloseableBitmap) closeableReference.a();
                    threadTileDrawableController.f19959n.m28655a(i, closeableBitmap.a());
                    InstrumentTile.a(threadTileDrawableController.f19953h, f19946a, threadTileDrawableController.f19959n, closeableBitmap.a());
                }
                threadTileDrawableController.m28670h();
            }
        }
    }

    private void m28670h() {
        ThreadUserTile[] threadUserTileArr = this.f19957l;
        int length = threadUserTileArr.length;
        int i = 0;
        while (i < length) {
            ThreadUserTile threadUserTile = threadUserTileArr[i];
            if (threadUserTile.f19943a == null || threadUserTile.f19944b == null) {
                i++;
            } else {
                return;
            }
        }
        if (this.f19968w != null) {
            1 1 = this.f19968w;
            Bitmap a = 1.f.g.a(1.a.f19958m);
            1.f.g.a(1.b, 1.c, a, 1.f.b.getDrawable(2130842117), false);
            a.recycle();
            1.f.j.vibrate(50);
            MessengerShortcutHelper messengerShortcutHelper = 1.f;
            ThreadKey threadKey = 1.d;
            HoneyClientEventFast a2 = messengerShortcutHelper.c.a(1.e, false);
            if (a2.a()) {
                a2.b("shortcut");
                a2.a("thread_key", threadKey.toString());
                if (threadKey.m3505b()) {
                    a2.a("is_for_group_thread", true);
                }
                a2.b();
            }
        }
    }

    public static void m28664a(ThreadTileDrawableController threadTileDrawableController, int i, boolean z) {
        Object obj;
        ShapeDrawable shapeDrawable = threadTileDrawableController.f19959n.f19928i[i];
        if (shapeDrawable == null || shapeDrawable.getShaderFactory() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null || !z || threadTileDrawableController.f19964s.mo1510b() != TileBadge.SMS) {
            return;
        }
        if (threadTileDrawableController.m28671j()) {
            threadTileDrawableController.f19957l[i].f19943a = null;
            return;
        }
        ImageRequest b = threadTileDrawableController.f19964s.mo1509b(i, threadTileDrawableController.f19963r, threadTileDrawableController.f19963r);
        if (b != null) {
            threadTileDrawableController.m28662a(i, b, false);
        }
    }

    private boolean m28671j() {
        if (this.f19964s.mo1510b() != TileBadge.SMS || !this.f19960o.a(this.f19964s.mo1514f())) {
            return false;
        }
        this.f19960o.b(this.f19947b.getColor(2131361864));
        this.f19960o.c(this.f19947b.getColor(2131362659));
        return true;
    }
}
