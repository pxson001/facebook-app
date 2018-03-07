package com.facebook.timeline.header;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.RelationshipType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.ContextItemsRenderingStyle;
import com.facebook.timeline.contextual.TimelineContextItemsData;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapter;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapterProvider;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.TimelineIntroCardAdapter.C16544;
import com.facebook.timeline.header.TimelineIntroCardAdapter.CollapseState;
import com.facebook.timeline.header.controllers.IntroCardCollapseController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController;
import com.facebook.timeline.header.controllers.TimelineHeaderViewController.IntroViewType;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.favphotos.FavoritePhotosUtil;
import com.facebook.timeline.header.favphotos.IntroCardSuggestedPhotosExperimentController;
import com.facebook.timeline.header.favphotos.edit.TimelineEditFavPhotosActivity;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLModels.TimelineTaggedMediaSetFieldsModel;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_nearby_dashboard_ping_edit */
public class IntroCardBinder {
    public boolean f11237A;
    public int f11238B;
    private final Context f11239a;
    private final QeAccessor f11240b;
    private final FavPhotosVsFeaturedContainersController f11241c;
    private final ProfileControllerDelegate f11242d;
    public final Provider<TimelineAnalyticsLogger> f11243e;
    private final Provider<SecureContextHelper> f11244f;
    private final Provider<FbUriIntentHandler> f11245g;
    private final TimelineHeaderViewController f11246h;
    private final TimelineContextualInfoAdapterProvider f11247i;
    private final TimelinePerformanceLogger f11248j;
    public final IntroCardSuggestedPhotosExperimentController f11249k;
    public final C16544 f11250l;
    private final FeaturedContainersHeaderData f11251m;
    public final TimelineHeaderUserData f11252n;
    private final TimelineTaggedMediaSetData f11253o;
    public final TimelineContext f11254p;
    @Nullable
    private final TimelineHeaderDataLogger f11255q;
    private final IntroCardCollapseController f11256r;
    private final boolean f11257s;
    @Nullable
    private TimelineContextualInfoAdapter f11258t;
    @Nullable
    public TimelineContextualInfoData f11259u;
    @Nullable
    private OnClickListener f11260v;
    @Nullable
    public OnClickListener f11261w;
    @Nullable
    public OnClickListener f11262x;
    @Nullable
    public OnClickListener f11263y;
    public boolean f11264z;

    /* compiled from: friends_nearby_dashboard_ping_edit */
    class C16261 implements OnClickListener {
        final /* synthetic */ IntroCardBinder f11229a;

        C16261(IntroCardBinder introCardBinder) {
            this.f11229a = introCardBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1254250549);
            if (this.f11229a.f11250l != null) {
                Object obj = this.f11229a.f11250l.f11444a;
                obj.f11463k.f11626b = CollapseState.EXPANDED;
                obj.f11472t.m11536d();
                AdapterDetour.a(obj, -736856088);
            }
            ((TimelineAnalyticsLogger) this.f11229a.f11243e.get()).c(this.f11229a.f11254p.b, RelationshipType.getRelationshipType(this.f11229a.f11254p.i(), this.f11229a.f11252n.B(), this.f11229a.f11252n.C()));
            Logger.a(2, EntryType.UI_INPUT_END, 2105926736, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_ping_edit */
    public class C16272 implements OnClickListener {
        final /* synthetic */ IntroCardBinder f11230a;

        public C16272(IntroCardBinder introCardBinder) {
            this.f11230a = introCardBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -834110470);
            ((TimelineAnalyticsLogger) this.f11230a.f11243e.get()).d(this.f11230a.f11254p.b);
            IntroCardBinder.m11376f(this.f11230a);
            Logger.a(2, EntryType.UI_INPUT_END, 1358705989, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_ping_edit */
    public class C16283 implements OnClickListener {
        final /* synthetic */ IntroCardBinder f11231a;

        public C16283(IntroCardBinder introCardBinder) {
            this.f11231a = introCardBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1997647581);
            ((TimelineAnalyticsLogger) this.f11231a.f11243e.get()).e(this.f11231a.f11254p.b);
            IntroCardBinder.m11376f(this.f11231a);
            Logger.a(2, EntryType.UI_INPUT_END, -1108951678, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_ping_edit */
    class C16294 implements OnClickListener {
        final /* synthetic */ IntroCardBinder f11232a;

        C16294(IntroCardBinder introCardBinder) {
            this.f11232a = introCardBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1569687474);
            IntroCardBinder.m11381k(this.f11232a);
            Logger.a(2, EntryType.UI_INPUT_END, -1369667956, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_ping_edit */
    public class C16305 implements OnClickListener {
        final /* synthetic */ IntroCardBinder f11233a;

        public C16305(IntroCardBinder introCardBinder) {
            this.f11233a = introCardBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1770262585);
            IntroCardBinder.m11382l(this.f11233a);
            Logger.a(2, EntryType.UI_INPUT_END, 1228055277, a);
        }
    }

    @Inject
    public IntroCardBinder(Context context, QeAccessor qeAccessor, FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController, ProfileControllerDelegate profileControllerDelegate, Provider<TimelineAnalyticsLogger> provider, Provider<SecureContextHelper> provider2, Provider<FbUriIntentHandler> provider3, TimelineHeaderViewController timelineHeaderViewController, TimelineContextualInfoAdapterProvider timelineContextualInfoAdapterProvider, TimelinePerformanceLogger timelinePerformanceLogger, IntroCardSuggestedPhotosExperimentController introCardSuggestedPhotosExperimentController, IntroCardCollapseController introCardCollapseController, FeaturedContainersHeaderData featuredContainersHeaderData, Boolean bool, @Assisted IntroCardExpandListener introCardExpandListener, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Assisted TimelineUserContext timelineUserContext) {
        this.f11239a = context;
        this.f11240b = qeAccessor;
        this.f11241c = favPhotosVsFeaturedContainersController;
        this.f11242d = profileControllerDelegate;
        this.f11243e = provider;
        this.f11244f = provider2;
        this.f11245g = provider3;
        this.f11246h = timelineHeaderViewController;
        this.f11247i = timelineContextualInfoAdapterProvider;
        this.f11248j = timelinePerformanceLogger;
        this.f11255q = profileControllerDelegate.mo471f();
        this.f11249k = introCardSuggestedPhotosExperimentController;
        this.f11250l = introCardExpandListener;
        this.f11256r = introCardCollapseController;
        this.f11257s = bool.booleanValue();
        this.f11252n = timelineHeaderUserData;
        this.f11253o = timelineTaggedMediaSetData;
        this.f11254p = timelineUserContext;
        this.f11251m = featuredContainersHeaderData;
    }

    public final void m11383a(TimelineIntroCardView timelineIntroCardView, boolean z, boolean z2) {
        int i = 1;
        timelineIntroCardView.f11518m = this;
        this.f11264z = z;
        this.f11237A = z2;
        boolean a = m11371a(timelineIntroCardView);
        int i2 = (a || m11375d(timelineIntroCardView)) ? 1 : 0;
        if (i2 == 0) {
            timelineIntroCardView.setVisibility(8);
        } else {
            timelineIntroCardView.setVisibility(0);
            int dimensionPixelSize = this.f11239a.getResources().getDimensionPixelSize(2131429933);
            int dimensionPixelSize2 = this.f11239a.getResources().getDimensionPixelSize(2131429934);
            i2 = this.f11264z ? this.f11239a.getResources().getDimensionPixelSize(2131429935) : 0;
            if (!(a && timelineIntroCardView.m11553e())) {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = this.f11239a.getResources().getDimensionPixelSize(2131429935);
            }
            this.f11238B = i;
            timelineIntroCardView.setPadding(dimensionPixelSize, i2, dimensionPixelSize2, 0);
            timelineIntroCardView.setBackgroundResource(2131361920);
        }
        if (this.f11237A) {
            timelineIntroCardView.m11557i();
        } else {
            timelineIntroCardView.m11558j();
        }
    }

    private boolean m11371a(TimelineIntroCardView timelineIntroCardView) {
        boolean z;
        int i = 0;
        if (!this.f11240b.a(ExperimentsForTimelineAbTestModule.ai, false) || this.f11252n.b == null) {
            z = false;
        } else {
            TimelineHeaderViewController timelineHeaderViewController = this.f11246h;
            TimelineHeaderUserData timelineHeaderUserData = this.f11252n;
            FeaturedContainersHeaderData featuredContainersHeaderData = this.f11251m;
            TimelineContext timelineContext = this.f11254p;
            int i2 = 0;
            if (timelineHeaderUserData.b != null) {
                if (TimelineHeaderViewController.m11689b(timelineHeaderUserData)) {
                    if (!(timelineHeaderUserData.W() || timelineContext.i())) {
                        i2 = 2;
                    }
                    int a = TimelineHeaderViewController.m11685a(timelineHeaderUserData.b);
                    if (!(a > i2 + 1 || TimelineHeaderViewController.m11688b(timelineContext, timelineHeaderUserData, featuredContainersHeaderData) || timelineContext.i())) {
                        i2 = a;
                    }
                } else {
                    i2 = TimelineHeaderViewController.m11685a(timelineHeaderUserData.b);
                }
            }
            int i3 = i2;
            if (this.f11259u == null) {
                this.f11259u = new TimelineContextualInfoData(i3);
            }
            this.f11259u.m10468a(TimelineContextItemsData.m10452a(this.f11252n.b.g()), TimelineHeaderViewController.m11684a(this.f11256r.m11668a(this.f11254p, this.f11252n, this.f11251m), this.f11254p, this.f11252n, this.f11251m, i3));
            if (this.f11258t == null) {
                this.f11258t = this.f11247i.m10456a(this.f11254p, this.f11259u, ContextItemsRenderingStyle.INTRO_CARD_PUBLIC_ABOUT_ITEMS_STYLE, new C16261(this), this.f11239a.getString(2131235043));
            }
            timelineIntroCardView.m11545a(this.f11258t);
            if (this.f11254p.i() && this.f11256r.m11668a(this.f11254p, this.f11252n, this.f11251m) != CollapseState.COLLAPSED) {
                m11372b(timelineIntroCardView);
            }
            m11374c(timelineIntroCardView);
            z = timelineIntroCardView.m11552d();
        }
        if (this.f11258t != null) {
            i = this.f11258t.getCount();
        }
        this.f11248j.G = i;
        return z;
    }

    private void m11372b(TimelineIntroCardView timelineIntroCardView) {
        if (m11378g()) {
            if (!this.f11257s) {
                if (this.f11262x == null) {
                    this.f11262x = new C16283(this);
                }
                timelineIntroCardView.m11549b(this.f11262x);
            }
            timelineIntroCardView.m11543a();
            return;
        }
        if (this.f11263y == null) {
            this.f11263y = new C16272(this);
        }
        timelineIntroCardView.m11544a(this.f11263y);
        timelineIntroCardView.m11548b();
        if (this.f11255q != null) {
            TimelineHeaderDataLogger timelineHeaderDataLogger = this.f11255q;
            if (!timelineHeaderDataLogger.f11382q) {
                timelineHeaderDataLogger.f11382q = true;
                timelineHeaderDataLogger.f11370e.h(timelineHeaderDataLogger.f11368c, timelineHeaderDataLogger.f11367b);
            }
        }
    }

    public static void m11376f(IntroCardBinder introCardBinder) {
        introCardBinder.f11242d.mn_();
        ((FbUriIntentHandler) introCardBinder.f11245g.get()).a(introCardBinder.f11239a, FBLinks.ba);
    }

    private void m11374c(TimelineIntroCardView timelineIntroCardView) {
        if (m11378g()) {
            timelineIntroCardView.m11550c();
        }
    }

    private boolean m11378g() {
        return this.f11259u != null && this.f11259u.d();
    }

    private boolean m11375d(final TimelineIntroCardView timelineIntroCardView) {
        IntroViewType a = this.f11246h.m11690a(this.f11252n, this.f11254p, this.f11256r.m11668a(this.f11254p, this.f11252n, this.f11251m));
        boolean b = this.f11241c.m12777b();
        boolean a2 = this.f11240b.a(ExperimentsForTimelineAbTestModule.Y, false);
        boolean z = true;
        switch (a) {
            case NONE:
                timelineIntroCardView.m11554f();
                timelineIntroCardView.m11556h();
                timelineIntroCardView.m11555g();
                z = false;
                break;
            case EMPTY:
                z = m11377f(timelineIntroCardView);
                break;
            case CONTENT:
                z = m11373b(timelineIntroCardView, b, a2);
                break;
            case SUGGESTED_CONTENT:
                timelineIntroCardView.m11555g();
                timelineIntroCardView.m11554f();
                ImmutableList ab = this.f11252n.ab();
                if (this.f11261w == null) {
                    this.f11261w = new C16305(this);
                }
                timelineIntroCardView.m11546a(ab, this.f11261w, new OnClickListener(this) {
                    final /* synthetic */ IntroCardBinder f11235b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -214109629);
                        this.f11235b.f11249k.m11367g();
                        this.f11235b.m11383a(timelineIntroCardView, this.f11235b.f11264z, this.f11235b.f11237A);
                        Logger.a(2, EntryType.UI_INPUT_END, 1048052260, a);
                    }
                });
                z = true;
                break;
        }
        this.f11248j.H = a.name();
        return z;
    }

    private boolean m11377f(TimelineIntroCardView timelineIntroCardView) {
        timelineIntroCardView.m11554f();
        timelineIntroCardView.m11556h();
        timelineIntroCardView.m11551c(m11379h());
        return true;
    }

    private boolean m11373b(TimelineIntroCardView timelineIntroCardView, boolean z, boolean z2) {
        boolean z3 = false;
        timelineIntroCardView.m11555g();
        timelineIntroCardView.m11556h();
        boolean z4 = z && this.f11254p.i();
        if (z2 && this.f11254p.i()) {
            z3 = true;
        }
        timelineIntroCardView.m11547a(z4, z3, this.f11252n.Z(), m11379h());
        return true;
    }

    private OnClickListener m11379h() {
        if (this.f11260v == null) {
            this.f11260v = new C16294(this);
        }
        return this.f11260v;
    }

    private boolean m11380j() {
        return (this.f11252n == null || this.f11252n.b == null) ? false : true;
    }

    public static void m11381k(IntroCardBinder introCardBinder) {
        if (!introCardBinder.m11380j()) {
            return;
        }
        if (introCardBinder.f11252n.Z().isEmpty()) {
            ((TimelineAnalyticsLogger) introCardBinder.f11243e.get()).f(introCardBinder.f11254p.b);
            introCardBinder.m11370a(null);
            return;
        }
        ((TimelineAnalyticsLogger) introCardBinder.f11243e.get()).g(introCardBinder.f11254p.b);
        introCardBinder.m11370a(introCardBinder.f11252n.Z());
    }

    public static void m11382l(IntroCardBinder introCardBinder) {
        if (introCardBinder.m11380j()) {
            ((TimelineAnalyticsLogger) introCardBinder.f11243e.get()).a(introCardBinder.f11254p.b, introCardBinder.f11252n.ab().size());
            introCardBinder.m11370a(FavoritePhotosUtil.m11788a(introCardBinder.f11252n.ab()));
        }
    }

    private void m11370a(ImmutableList<? extends FavoritePhoto> immutableList) {
        Intent intent = new Intent(this.f11239a, TimelineEditFavPhotosActivity.class);
        intent.putExtra("show_feed_sharing_switch_extra", this.f11252n.b.dv_());
        intent.putExtra("initial_is_feed_sharing_switch_checked", this.f11252n.b.k());
        if (immutableList != null) {
            FlatBufferModelHelper.a(intent, "fav_photos_extra", immutableList);
        }
        TimelineTaggedMediaSetData timelineTaggedMediaSetData = this.f11253o;
        if (timelineTaggedMediaSetData.d()) {
            TimelineTaggedMediaSetFieldsModel timelineTaggedMediaSetFieldsModel = (TimelineTaggedMediaSetFieldsModel) timelineTaggedMediaSetData.a().get();
            boolean z = (timelineTaggedMediaSetFieldsModel.a() == null || timelineTaggedMediaSetFieldsModel.a().a().isEmpty()) ? false : true;
            intent.putExtra("has_tagged_mediaset", z);
        } else {
            intent.putExtra("has_tagged_mediaset", true);
            intent.putExtra("land_on_uploads_tab", true);
        }
        ((SecureContextHelper) this.f11244f.get()).a(intent, 1822, (Activity) ContextUtils.a(this.f11239a, Activity.class));
    }
}
