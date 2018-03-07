package com.facebook.user.tiles;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
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
import com.facebook.messaging.connectivity.ConnectionStatusMonitor.ConnectionType;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapper;
import com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapperListener;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.tiles.UserTileView.OnUserTileUpdatedListener;
import com.facebook.user.tiles.UserTileViewParams.Type;
import com.facebook.widget.images.PathFittingBitmapShaderFactory;
import com.facebook.widget.tiles.InstrumentTile;
import com.facebook.widget.tiles.TileBadge;
import com.facebook.widget.tiles.UserBadgeDrawable;
import com.facebook.widget.tiles.UserInitialsDrawable;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: oxygen_map_disk_cache_null_key_error */
public class UserTileDrawableController {
    private static final Class<?> f5680a;
    public static final CallerContext f5681b;
    private static final int f5682c = Color.rgb(238, 238, 238);
    public OnUserTileUpdatedListener f5683A;
    private Type f5684B;
    private final Resources f5685d;
    private final UserTileViewLogic f5686e;
    private final ImagePipeline f5687f;
    private final Executor f5688g;
    private final Provider<Boolean> f5689h;
    private final SelfRegistrableReceiverImpl f5690i;
    private final AnalyticsLogger f5691j;
    public final ImagePipelineWrapper f5692k;
    private final GatekeeperStoreImpl f5693l;
    public Drawable f5694m;
    public ShapeDrawable f5695n;
    public UserBadgeDrawable f5696o;
    public UserInitialsDrawable f5697p;
    private Drawable f5698q;
    private int f5699r;
    private boolean f5700s;
    private UserTileViewParams f5701t;
    private boolean f5702u = true;
    private ImageRequest f5703v;
    private ImageRequest f5704w;
    public DataSource<CloseableReference<CloseableImage>> f5705x;
    private CloseableReference<CloseableImage> f5706y;
    private String f5707z;

    /* compiled from: oxygen_map_disk_cache_null_key_error */
    class UserUpdateActionReceiver implements ActionReceiver {
        private WeakReference<UserTileDrawableController> f5708a;

        public UserUpdateActionReceiver(UserTileDrawableController userTileDrawableController) {
            this.f5708a = new WeakReference(userTileDrawableController);
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1630168165);
            UserTileDrawableController userTileDrawableController = (UserTileDrawableController) this.f5708a.get();
            if (userTileDrawableController != null) {
                UserTileDrawableController.m6175a(userTileDrawableController, intent);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 361266785, a);
        }
    }

    public static UserTileDrawableController m6177b(InjectorLike injectorLike) {
        return new UserTileDrawableController(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), UserTileViewLogic.m2670a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4376), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ImagePipelineWrapper.m4472a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    static {
        Class cls = UserTileDrawableController.class;
        f5680a = cls;
        f5681b = CallerContext.a(cls, "profile_user_tile_view", "user_tile");
    }

    @Inject
    public UserTileDrawableController(AnalyticsLogger analyticsLogger, Resources resources, UserTileViewLogic userTileViewLogic, ImagePipeline imagePipeline, Executor executor, Provider<Boolean> provider, FbBroadcastManager fbBroadcastManager, ImagePipelineWrapper imagePipelineWrapper, GatekeeperStore gatekeeperStore) {
        this.f5685d = resources;
        this.f5686e = userTileViewLogic;
        this.f5687f = imagePipeline;
        this.f5688g = executor;
        this.f5689h = provider;
        this.f5691j = analyticsLogger;
        this.f5692k = imagePipelineWrapper;
        this.f5693l = gatekeeperStore;
        this.f5690i = fbBroadcastManager.a().a("com.facebook.orca.users.ACTION_USERS_UPDATED", new UserUpdateActionReceiver(this)).a();
    }

    public static void m6175a(UserTileDrawableController userTileDrawableController, Intent intent) {
        if (userTileDrawableController.f5701t != null && intent.getParcelableArrayListExtra("updated_users").contains(userTileDrawableController.f5701t.f5727c)) {
            userTileDrawableController.m6179e();
        }
    }

    public final void m6185a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UserTileView, i, 0);
        this.f5698q = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.UserTileDrawable, i, 0);
        int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(1, 0);
        boolean z = obtainStyledAttributes2.getBoolean(3, false);
        this.f5700s = obtainStyledAttributes2.getBoolean(2, false);
        int color = obtainStyledAttributes2.getColor(0, f5682c);
        obtainStyledAttributes2.recycle();
        this.f5695n = new ShapeDrawable();
        Paint paint = this.f5695n.getPaint();
        paint.setColor(color);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        m6188a(z);
        this.f5696o = new UserBadgeDrawable(context, attributeSet, i);
        this.f5697p = new UserInitialsDrawable();
        this.f5697p.m6201a(context, 2131361853);
        this.f5697p.m6199a((float) SizeUtil.a(context.getResources(), 2131427404));
        if (this.f5698q != null) {
            this.f5694m = new LayerDrawable(new Drawable[]{this.f5695n, this.f5698q, this.f5697p, this.f5696o});
        } else {
            this.f5694m = new LayerDrawable(new Drawable[]{this.f5695n, this.f5697p, this.f5696o});
        }
        if (dimensionPixelSize <= 0) {
            dimensionPixelSize = SizeUtil.a(context, 50.0f);
        }
        m6183a(dimensionPixelSize);
    }

    public final void m6184a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f5694m.setBounds(i3, i4, i - i5, i2 - i6);
        if (this.f5698q != null) {
            this.f5698q.setBounds(0, 0, i, i2);
        }
    }

    public final void m6183a(int i) {
        Preconditions.checkArgument(i > 0);
        if (this.f5699r != i) {
            this.f5699r = i;
            this.f5695n.setIntrinsicWidth(this.f5699r);
            this.f5695n.setIntrinsicHeight(this.f5699r);
            m6179e();
        }
    }

    public final void m6188a(boolean z) {
        m6186a(z ? new OvalShape() : new RectShape());
    }

    public final void m6186a(Shape shape) {
        this.f5695n.setShape(shape);
    }

    public final void m6187a(UserTileViewParams userTileViewParams) {
        this.f5701t = userTileViewParams;
        m6179e();
    }

    public final void m6189c() {
        if (this.f5702u) {
            this.f5702u = false;
            this.f5690i.b();
            m6179e();
        }
    }

    public final void m6190d() {
        if (!this.f5702u) {
            this.f5702u = true;
            this.f5690i.c();
            m6180f();
        }
    }

    private void m6179e() {
        Type type;
        TileBadge tileBadge;
        Type type2 = this.f5684B;
        if (this.f5701t != null) {
            type = this.f5701t.f5726b;
        } else {
            type = null;
        }
        this.f5684B = type;
        UserBadgeDrawable userBadgeDrawable = this.f5696o;
        if (this.f5701t != null) {
            tileBadge = this.f5701t.f5729e;
        } else {
            tileBadge = TileBadge.NONE;
        }
        userBadgeDrawable.m6194a(tileBadge);
        if (this.f5684B == Type.ADDRESS_BOOK_CONTACT) {
            String str = this.f5701t.f5730f;
            if (type2 == this.f5684B && StringUtil.a(this.f5707z, str) && (this.f5697p.f5719d == null || this.f5697p.m6204b(this.f5701t.f5731g.i()))) {
                return;
            }
        }
        m6174a(this.f5686e.m2674a(this.f5701t, this.f5699r, this.f5699r), true);
    }

    private void m6174a(final ImageRequest imageRequest, final boolean z) {
        if (imageRequest != null && this.f5703v != null && imageRequest.equals(this.f5703v)) {
            return;
        }
        if (imageRequest == null) {
            m6181g();
            return;
        }
        String str;
        if (!this.f5700s) {
            m6181g();
        }
        if (this.f5684B == Type.ADDRESS_BOOK_CONTACT) {
            str = this.f5701t.f5730f;
        } else {
            str = null;
        }
        this.f5707z = str;
        this.f5704w = imageRequest;
        this.f5703v = imageRequest;
        final ImageRequestBuilder a = ImageRequestBuilder.a(imageRequest);
        if (this.f5707z != null && this.f5697p.m6202a(this.f5701t.f5731g.i())) {
            m6182i();
        }
        if (((Boolean) this.f5689h.get()).booleanValue()) {
            a.f = ImageType.SMALL;
        }
        if (this.f5693l.a(240, false)) {
            if (this.f5699r > 0) {
                a.d = new ResizeOptions(this.f5699r, this.f5699r);
            } else {
                a.d = new ResizeOptions(this.f5695n.getBounds().width(), this.f5695n.getBounds().height());
            }
            ImagePipelineWrapper imagePipelineWrapper = this.f5692k;
            Executor executor = !imagePipelineWrapper.f3992l.mo685a(ConnectionType.HTTP) ? imagePipelineWrapper.f3991k.a(946, false) ? imagePipelineWrapper.f3986f : imagePipelineWrapper.f3985e : !FacebookUriUtil.f(imageRequest.c) ? imagePipelineWrapper.f3991k.a(946, false) ? imagePipelineWrapper.f3986f : imagePipelineWrapper.f3985e : !FacebookUriUtil.k(imageRequest.c) ? imagePipelineWrapper.f3991k.a(946, false) ? imagePipelineWrapper.f3986f : imagePipelineWrapper.f3985e : imagePipelineWrapper.f3983c;
            ExecutorDetour.a(executor, new Runnable(this) {
                final /* synthetic */ UserTileDrawableController f5744d;

                /* compiled from: oxygen_map_disk_cache_null_key_error */
                class C02461 implements ImagePipelineWrapperListener<CloseableReference<CloseableImage>> {
                    final /* synthetic */ C02451 f5755a;

                    C02461(C02451 c02451) {
                        this.f5755a = c02451;
                    }

                    public final void mo537a(DataSource<CloseableReference<CloseableImage>> dataSource) {
                        UserTileDrawableController.m6176a(this.f5755a.f5744d, (DataSource) dataSource, imageRequest);
                    }

                    public final void mo536a() {
                        UserTileDrawableController.m6178c(this.f5755a.f5744d, z);
                    }
                }

                public void run() {
                    UserTileDrawableController userTileDrawableController = this.f5744d;
                    ImagePipelineWrapper imagePipelineWrapper = this.f5744d.f5692k;
                    ImageRequestBuilder imageRequestBuilder = a;
                    UserTileDrawableController userTileDrawableController2 = this.f5744d;
                    userTileDrawableController.f5705x = imagePipelineWrapper.m4484b(imageRequestBuilder, UserTileDrawableController.f5681b);
                    this.f5744d.f5692k.m4482a(this.f5744d.f5705x, new C02461(this));
                }
            }, 859530948);
            return;
        }
        this.f5705x = this.f5687f.c(a.m(), f5681b);
        this.f5705x.a(new 2(this, imageRequest, z), this.f5688g);
    }

    public static void m6178c(UserTileDrawableController userTileDrawableController, boolean z) {
        if (userTileDrawableController.f5695n.getShaderFactory() != null || !z || userTileDrawableController.f5701t == null || userTileDrawableController.f5701t.f5726b != Type.ADDRESS_BOOK_CONTACT) {
            return;
        }
        if (userTileDrawableController.f5697p.m6202a(userTileDrawableController.f5701t.f5731g.i())) {
            userTileDrawableController.f5703v = null;
            userTileDrawableController.m6182i();
            if (userTileDrawableController.f5683A != null) {
                userTileDrawableController.f5683A.a();
                return;
            }
            return;
        }
        userTileDrawableController.m6174a(UserTileViewLogic.m2667a(userTileDrawableController.f5701t, userTileDrawableController.f5699r), false);
    }

    public static void m6176a(UserTileDrawableController userTileDrawableController, DataSource dataSource, ImageRequest imageRequest) {
        if (dataSource.b()) {
            userTileDrawableController.f5705x = null;
            userTileDrawableController.f5697p.m6198a();
            CloseableReference closeableReference = (CloseableReference) dataSource.d();
            if (closeableReference == null || !(closeableReference.a() instanceof CloseableBitmap) || userTileDrawableController.f5704w == null || imageRequest == null || !imageRequest.equals(userTileDrawableController.f5704w)) {
                CloseableReference.c(closeableReference);
                return;
            }
            userTileDrawableController.f5706y = closeableReference;
            CloseableBitmap closeableBitmap = (CloseableBitmap) closeableReference.a();
            userTileDrawableController.f5695n.setShaderFactory(new PathFittingBitmapShaderFactory(null, closeableBitmap.a()));
            userTileDrawableController.f5695n.setShape(userTileDrawableController.f5695n.getShape());
            if (userTileDrawableController.f5683A != null) {
                userTileDrawableController.f5683A.a();
            }
            InstrumentTile.m6248a(userTileDrawableController.f5691j, f5681b, userTileDrawableController.f5695n, closeableBitmap.a());
        }
    }

    private void m6180f() {
        this.f5703v = null;
        if (this.f5705x != null) {
            this.f5705x.g();
            this.f5705x = null;
        }
        if (this.f5706y != null) {
            this.f5706y.close();
            this.f5706y = null;
        }
    }

    private void m6181g() {
        m6180f();
        this.f5695n.setShaderFactory(null);
        this.f5695n.getPaint().setShader(null);
        this.f5695n.setShape(this.f5695n.getShape());
        this.f5697p.m6198a();
        this.f5707z = null;
    }

    private void m6182i() {
        if (this.f5701t != null && this.f5701t.f5729e == TileBadge.SMS) {
            this.f5697p.m6203b(this.f5685d.getColor(2131361864));
            this.f5697p.m6205c(this.f5685d.getColor(2131362659));
        }
    }
}
