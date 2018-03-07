package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.graphics.RectF;
import android.support.v4.app.FragmentActivity;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.location.FbLocationCache;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.maps.FbStaticMapView;
import com.facebook.maps.MapsLocationUtils;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionGeoRectangleFieldsModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: android_native_article_image_perf */
public class ReactionPageMapWithNavigationComponentView extends CustomFrameLayout {
    public static final CallerContext f19468g = CallerContext.a(ReactionPageMapWithNavigationComponentView.class);
    public static final FbLocationOperationParams f19469h;
    @Inject
    FbLocationCache f19470a;
    @Inject
    public FbLocationOperation f19471b;
    @Inject
    public FbLocationStatusUtil f19472c;
    @Inject
    GlyphColorizer f19473d;
    @Inject
    public TasksManager f19474e;
    @Inject
    MapsLocationUtils f19475f;
    private final StaticMapOptions f19476i = new StaticMapOptions("pages_single_location_map");
    public ImmutableLocation f19477j;
    private ImmutableLocation f19478k;
    private FbStaticMapView f19479l;
    private FbTextView f19480m;
    @Nullable
    private String f19481n;
    @Nullable
    private String f19482o;

    /* compiled from: android_native_article_image_perf */
    public class C21101 implements Callable<ListenableFuture<ImmutableLocation>> {
        final /* synthetic */ ReactionPageMapWithNavigationComponentView f19466a;

        public C21101(ReactionPageMapWithNavigationComponentView reactionPageMapWithNavigationComponentView) {
            this.f19466a = reactionPageMapWithNavigationComponentView;
        }

        public Object call() {
            this.f19466a.f19471b.a(ReactionPageMapWithNavigationComponentView.f19469h, ReactionPageMapWithNavigationComponentView.f19468g);
            return this.f19466a.f19471b;
        }
    }

    /* compiled from: android_native_article_image_perf */
    public class C21112 extends AbstractDisposableFutureCallback<ImmutableLocation> {
        final /* synthetic */ ReactionPageMapWithNavigationComponentView f19467a;

        public C21112(ReactionPageMapWithNavigationComponentView reactionPageMapWithNavigationComponentView) {
            this.f19467a = reactionPageMapWithNavigationComponentView;
        }

        protected final void m23431a(Object obj) {
            ImmutableLocation immutableLocation = (ImmutableLocation) obj;
            if (immutableLocation != null) {
                this.f19467a.f19477j = immutableLocation;
                ReactionPageMapWithNavigationComponentView.m23436g(this.f19467a);
            }
        }

        protected final void m23432a(Throwable th) {
        }
    }

    public static void m23434a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ReactionPageMapWithNavigationComponentView) obj).m23433a(FbLocationCache.b(fbInjector), FbLocationOperation.b(fbInjector), FbLocationStatusUtil.a(fbInjector), GlyphColorizer.a(fbInjector), TasksManager.b(fbInjector), MapsLocationUtils.b(fbInjector));
    }

    private void m23433a(FbLocationCache fbLocationCache, FbLocationOperation fbLocationOperation, FbLocationStatusUtil fbLocationStatusUtil, GlyphColorizer glyphColorizer, TasksManager tasksManager, MapsLocationUtils mapsLocationUtils) {
        this.f19470a = fbLocationCache;
        this.f19471b = fbLocationOperation;
        this.f19472c = fbLocationStatusUtil;
        this.f19473d = glyphColorizer;
        this.f19474e = tasksManager;
        this.f19475f = mapsLocationUtils;
    }

    static {
        Builder c = FbLocationOperationParams.a(Priority.HIGH_ACCURACY).c(600000);
        c.b = 120000;
        c = c;
        c.c = 500.0f;
        c = c;
        c.d = 5000;
        f19469h = c.a();
    }

    public ReactionPageMapWithNavigationComponentView(Context context) {
        super(context);
        m23435f();
    }

    private void m23435f() {
        Class cls = ReactionPageMapWithNavigationComponentView.class;
        m23434a(this, getContext());
        setContentView(2130906698);
        ((DraweeView) c(2131566764)).setBackgroundDrawable(this.f19473d.a(2130839827, -12887656));
        this.f19479l = (FbStaticMapView) c(2131566760);
        FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(getContext(), FragmentActivity.class);
        if (fragmentActivity != null) {
            this.f19479l.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, fragmentActivity.kO_(), null);
        }
        this.f19479l.setCenteredMapPinDrawable(getResources().getDrawable(2130842483));
        this.f19480m = (FbTextView) c(2131566763);
        m23437h();
    }

    public final void m23438a(@Nullable String str, @Nullable String str2, ImmutableLocation immutableLocation, ReactionGeoRectangleFieldsModel reactionGeoRectangleFieldsModel, int i) {
        this.f19478k = immutableLocation;
        StaticMapOptions a = this.f19476i.a().a(i).a(this.f19478k.a(), this.f19478k.b());
        if (reactionGeoRectangleFieldsModel != null) {
            a.a(new RectF((float) reactionGeoRectangleFieldsModel.d(), (float) reactionGeoRectangleFieldsModel.b(), (float) reactionGeoRectangleFieldsModel.a(), (float) reactionGeoRectangleFieldsModel.c()));
        }
        this.f19479l.setMapOptions(a);
        this.f19481n = str2;
        this.f19482o = str;
        m23436g(this);
    }

    public static void m23436g(ReactionPageMapWithNavigationComponentView reactionPageMapWithNavigationComponentView) {
        CharSequence subtitleString = reactionPageMapWithNavigationComponentView.getSubtitleString();
        reactionPageMapWithNavigationComponentView.f19480m.setVisibility(StringUtil.a(subtitleString) ? 8 : 0);
        reactionPageMapWithNavigationComponentView.f19480m.setText(subtitleString);
    }

    private String getSubtitleString() {
        String locationInfoString = getLocationInfoString();
        if (StringUtil.a(this.f19482o) && StringUtil.a(locationInfoString)) {
            return null;
        }
        if (StringUtil.a(locationInfoString)) {
            return this.f19482o;
        }
        if (StringUtil.a(this.f19482o)) {
            return locationInfoString;
        }
        return getResources().getString(2131237294, new Object[]{this.f19482o, locationInfoString});
    }

    @Nullable
    private String getLocationInfoString() {
        m23437h();
        if (this.f19477j == null || this.f19478k == null) {
            return this.f19481n;
        }
        return this.f19475f.a(this.f19477j, this.f19478k, 99000.0d, this.f19481n);
    }

    private void m23437h() {
        if (this.f19477j == null) {
            this.f19477j = this.f19470a.a(120000);
            if (this.f19477j == null) {
                Object obj;
                if (this.f19472c.a() == State.OKAY) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null && !this.f19471b.isDone()) {
                    this.f19474e.a("page_map_with_navigation_get_location_task_key", new C21101(this), new C21112(this));
                }
            }
        }
    }
}
