package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.WaterfallIdGenerator;
import com.facebook.photos.base.analytics.photostab.PhotosTabBaseParams;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.vault.momentsupsell.analytics.MomentsUpsellLogger;
import com.facebook.vault.momentsupsell.data.MomentsAppInfoStore;
import com.facebook.vault.momentsupsell.data.MomentsAppInfoStoreListener;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import com.facebook.vault.momentsupsell.ui.MomentsAppPopoverWindow;
import com.facebook.vault.momentsupsell.ui.MomentsAppPopoverWindow.1;
import com.facebook.vault.momentsupsell.ui.MomentsAppPromotionView;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.service.VaultManager;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.groups.feed.ui.GroupsFeedFragment */
public class PandoraTabPagerFragment extends FbFragment implements DialtoneStateChangedListener {
    public static final String an = PandoraTabPagerFragment.class.getSimpleName();
    @Inject
    PandoraTabPagerAdapterProvider f17718a;
    private boolean aA;
    public int aB = 0;
    @Inject
    public SyncModePref al;
    @Inject
    public VaultManager am;
    private ViewPager ao;
    public PandoraTabPagerAdapter ap;
    private TabbedViewPagerIndicator aq;
    private MomentsAppInfoStoreListener ar;
    @Nullable
    public MomentsAppInfo as;
    @Nullable
    public MomentsAppPopoverWindow at;
    public String au;
    public ProfileViewerContext av;
    private CallerContext aw;
    public boolean ax;
    public boolean ay;
    public boolean az;
    @Inject
    @LoggedInUserId
    String f17719b;
    @Inject
    Lazy<PhotoFlowLogger> f17720c;
    @Inject
    Lazy<WaterfallIdGenerator> f17721d;
    @Inject
    PandoraSequenceLogger f17722e;
    @Inject
    MomentsAppInfoStore f17723f;
    @Inject
    MomentsUpsellLogger f17724g;
    @Inject
    public PandoraSyncTabUtils f17725h;
    @Inject
    DialtoneController f17726i;

    /* compiled from: com.facebook.groups.feed.ui.GroupsFeedFragment */
    class C18912 implements MomentsAppInfoStoreListener {
        final /* synthetic */ PandoraTabPagerFragment f17714a;

        C18912(PandoraTabPagerFragment pandoraTabPagerFragment) {
            this.f17714a = pandoraTabPagerFragment;
        }

        public final void mo1061a() {
            PandoraTabPagerFragment.m21689e(this.f17714a);
        }
    }

    /* compiled from: com.facebook.groups.feed.ui.GroupsFeedFragment */
    class C18923 extends OnToolbarButtonListener {
        final /* synthetic */ PandoraTabPagerFragment f17715a;

        C18923(PandoraTabPagerFragment pandoraTabPagerFragment) {
            this.f17715a = pandoraTabPagerFragment;
        }

        public final void m21683a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f17715a.ao().onBackPressed();
        }
    }

    /* compiled from: com.facebook.groups.feed.ui.GroupsFeedFragment */
    public class C18934 extends OnToolbarButtonListener {
        final /* synthetic */ PandoraTabPagerFragment f17716a;

        public C18934(PandoraTabPagerFragment pandoraTabPagerFragment) {
            this.f17716a = pandoraTabPagerFragment;
        }

        public final void m21684a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f17716a.ap.m21677d() != null) {
                this.f17716a.ap.m21677d().as();
            }
        }
    }

    public static void m21687a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PandoraTabPagerFragment) obj).m21686a((PandoraTabPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraTabPagerAdapterProvider.class), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), IdBasedLazy.a(injectorLike, 9251), IdBasedLazy.a(injectorLike, 9261), PandoraSequenceLogger.m21549a(injectorLike), MomentsAppInfoStore.a(injectorLike), MomentsUpsellLogger.a(injectorLike), PandoraSyncTabUtils.m21656b(injectorLike), (DialtoneController) DialtoneControllerImpl.a(injectorLike), SyncModePref.a(injectorLike), VaultManager.a(injectorLike));
    }

    public static final PandoraTabPagerFragment m21685a(Bundle bundle, String str, String str2, CallerContext callerContext) {
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("userId", str);
        if (!Strings.isNullOrEmpty(str2)) {
            bundle.putString("userName", str2);
        }
        bundle.putParcelable("callerContext", callerContext);
        PandoraTabPagerFragment pandoraTabPagerFragment = new PandoraTabPagerFragment();
        pandoraTabPagerFragment.g(bundle);
        return pandoraTabPagerFragment;
    }

    public final void m21695c(Bundle bundle) {
        super.c(bundle);
        Class cls = PandoraTabPagerFragment.class;
        m21687a(this, getContext());
    }

    public final void m21696h(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1513403149);
        super.h(bundle);
        if (!(bundle == null || this.ap == null)) {
            this.ap.kR_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1066982313, a);
    }

    public final View m21694a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1688743993);
        this.f17722e.m21551a("InflateTabPagerFragment");
        final String string = this.s.getString("userId");
        String string2 = this.s.getString("userName");
        this.aw = (CallerContext) this.s.getParcelable("callerContext");
        this.au = this.s.getString("session_id");
        if (StringUtil.a(this.au)) {
            this.f17721d.get();
            this.au = WaterfallIdGenerator.a();
            this.s.putString("session_id", this.au);
        }
        this.av = new ProfileViewerContext(string, this.f17719b, GraphQLFriendshipStatus.fromString(this.s.getString("friendship_status")), GraphQLSubscribeStatus.fromString(this.s.getString("subscribe_status")));
        View linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.ao = new ViewPager(viewGroup.getContext());
        this.ao.setId(2131558612);
        this.ap = this.f17718a.m21678a(string, string2, this.s, s(), this.aw, this.au);
        this.ao.setAdapter(this.ap);
        this.aq = new TabbedViewPagerIndicator(viewGroup.getContext());
        this.aq.setViewPager(this.ao);
        this.aq.l = new OnPageChangeListener(this) {
            final /* synthetic */ PandoraTabPagerFragment f17713b;

            public final void m21679a(int i, float f, int i2) {
            }

            public final void e_(int i) {
                Object obj;
                PandoraTabPagerFragment.m21690g(this.f17713b, i);
                PhotosTabBaseParams photosTabBaseParams = new PhotosTabBaseParams(this.f17713b.av.g().name(), String.valueOf(string), PandoraTabPagerFragment.m21691h(this.f17713b, i), PandoraTabPagerFragment.m21691h(this.f17713b, this.f17713b.aB));
                ((DefaultPhotoFlowLogger) this.f17713b.f17720c.get()).a(this.f17713b.au);
                ((DefaultPhotoFlowLogger) this.f17713b.f17720c.get()).a(photosTabBaseParams);
                PandoraTabPagerFragment pandoraTabPagerFragment = this.f17713b;
                int i2 = 2;
                if (pandoraTabPagerFragment.ax) {
                    i2 = 3;
                }
                if (pandoraTabPagerFragment.ay) {
                    i2++;
                }
                if (pandoraTabPagerFragment.az) {
                    i2++;
                }
                if (i2 == i) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    String str;
                    MomentsUpsellLogger momentsUpsellLogger = this.f17713b.f17724g;
                    MomentsAppInfo momentsAppInfo = this.f17713b.as;
                    if (momentsAppInfo == null) {
                        str = "loading";
                    } else if (momentsAppInfo.b) {
                        str = "interstitial";
                    } else if (momentsAppInfo.d) {
                        str = "moments";
                    } else {
                        str = "shoebox";
                    }
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("shoebox_moments_tab_view");
                    honeyClientEvent.b("view_state", str);
                    momentsUpsellLogger.a.a(honeyClientEvent);
                    if (this.f17713b.at != null) {
                        MomentsAppPopoverWindow momentsAppPopoverWindow = this.f17713b.at;
                        momentsAppPopoverWindow.b.a(this.f17713b.T);
                    }
                }
                this.f17713b.aB = i;
            }

            public final void m21680b(int i) {
            }
        };
        this.ar = new C18912(this);
        this.f17722e.m21553b("InflateTabPagerFragment");
        this.f17722e.m21551a("AttachTabPagerSubfragments");
        this.ax = this.s.getBoolean("has_tagged_mediaset");
        this.ay = this.s.getBoolean("extra_should_merge_camera_roll");
        this.az = this.s.getBoolean("extra_should_show_suggested_photos", false);
        this.aA = this.s.getBoolean("extra_should_show_suggested_photos_before_camera_roll", false);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        linearLayout.addView(this.aq, layoutParams);
        linearLayout.addView(this.ao, new LinearLayout.LayoutParams(-2, -2));
        this.f17722e.m21553b("AttachTabPagerSubfragments");
        int b = m21688b();
        if (b != -1 && b < this.ap.b()) {
            this.ao.a(b, false);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -416645932, a);
        return linearLayout;
    }

    private int m21688b() {
        Uri parse = Uri.parse(mt_().getString("extra_launch_uri"));
        int i = -1;
        if (parse.getQueryParameter("tab") != null) {
            try {
                i = Integer.parseInt(parse.getQueryParameter("tab"));
            } catch (NumberFormatException e) {
            }
        }
        if (mt_().getBoolean("land_on_uploads_tab")) {
            return 1;
        }
        return i;
    }

    public final void m21692G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1887860204);
        super.G();
        this.f17723f.a(this.ar);
        m21689e(this);
        this.f17726i.a(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1522701129, a);
    }

    public final void m21693H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2061397670);
        super.H();
        this.f17723f.b(this.ar);
        this.f17726i.b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1086663403, a);
    }

    public static void m21689e(PandoraTabPagerFragment pandoraTabPagerFragment) {
        MomentsAppInfo a = pandoraTabPagerFragment.f17723f.a();
        if (!Objects.equal(a, pandoraTabPagerFragment.as)) {
            pandoraTabPagerFragment.as = a;
            PandoraTabPagerAdapter pandoraTabPagerAdapter = pandoraTabPagerFragment.ap;
            if (!Objects.equal(pandoraTabPagerAdapter.f17709o, a)) {
                pandoraTabPagerAdapter.f17709o = a;
                pandoraTabPagerAdapter.kR_();
            }
            if (!(pandoraTabPagerFragment.as.c == null || pandoraTabPagerFragment.as.c.j)) {
                pandoraTabPagerFragment.at = new MomentsAppPopoverWindow(pandoraTabPagerFragment.getContext());
                MomentsAppPopoverWindow momentsAppPopoverWindow = pandoraTabPagerFragment.at;
                MomentsAppInfo momentsAppInfo = pandoraTabPagerFragment.as;
                View inflate = LayoutInflater.from(momentsAppPopoverWindow.a).inflate(2130905295, null, false);
                ((MomentsAppPromotionView) inflate.findViewById(2131563904)).a(momentsAppInfo);
                ImageView imageView = (ImageView) inflate.findViewById(2131563905);
                imageView.setImageDrawable(new GlyphColorizer(momentsAppPopoverWindow.a.getResources()).a(2130839815, -11643291));
                imageView.setOnClickListener(new 1(momentsAppPopoverWindow));
                momentsAppPopoverWindow.b.d(inflate);
                momentsAppPopoverWindow.b.b(0.5f);
                momentsAppPopoverWindow.b.d(true);
                momentsAppPopoverWindow.b.w = true;
            }
            pandoraTabPagerFragment.aq.b();
            m21690g(pandoraTabPagerFragment, pandoraTabPagerFragment.ao.k);
            if (!a.f) {
                pandoraTabPagerFragment.al.a("OFF");
                pandoraTabPagerFragment.am.a();
            }
        }
    }

    public static void m21690g(PandoraTabPagerFragment pandoraTabPagerFragment, int i) {
        boolean z = false;
        FbTitleBar fbTitleBar = (FbTitleBar) pandoraTabPagerFragment.ao().findViewById(2131558563);
        if (fbTitleBar != null) {
            fbTitleBar.setButtonSpecs(null);
            if (i <= 3) {
                if (pandoraTabPagerFragment.ay) {
                    boolean z2 = pandoraTabPagerFragment.az && pandoraTabPagerFragment.aA;
                    if (z2 == i) {
                        Builder a = TitleBarButtonSpec.a();
                        a.g = pandoraTabPagerFragment.getContext().getString(2131236747);
                        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
                        fbTitleBar.setOnToolbarButtonListener(new C18934(pandoraTabPagerFragment));
                        return;
                    }
                }
                if (Objects.equal(pandoraTabPagerFragment.s.getString("userId"), pandoraTabPagerFragment.f17719b)) {
                    boolean booleanExtra = pandoraTabPagerFragment.ao().getIntent().getBooleanExtra("extra_cancel_button_enabled", false);
                    if (booleanExtra) {
                        Builder a2 = TitleBarButtonSpec.a();
                        a2.g = pandoraTabPagerFragment.getContext().getString(2131236746);
                        fbTitleBar.setButtonSpecs(ImmutableList.of(a2.a()));
                        fbTitleBar.setOnToolbarButtonListener(new C18923(pandoraTabPagerFragment));
                        return;
                    }
                    int i2;
                    List of;
                    if (i < 2) {
                        z = pandoraTabPagerFragment.ao().getIntent().getBooleanExtra("disable_camera_roll", false);
                    }
                    if (i == 2) {
                        z = true;
                    }
                    if (i != 3) {
                        i2 = 2130837954;
                    } else if (pandoraTabPagerFragment.ar()) {
                        i2 = 2130840542;
                    } else {
                        z = true;
                        i2 = 2130837954;
                    }
                    Builder a3 = TitleBarButtonSpec.a();
                    a3.i = i2;
                    Builder builder = a3;
                    builder.j = pandoraTabPagerFragment.jW_().getString(2131234350);
                    TitleBarButtonSpec a4 = builder.a();
                    if (!z || booleanExtra) {
                        of = ImmutableList.of(a4);
                    } else {
                        of = null;
                    }
                    fbTitleBar.setButtonSpecs(of);
                }
            }
        }
    }

    private void m21686a(PandoraTabPagerAdapterProvider pandoraTabPagerAdapterProvider, String str, Lazy<PhotoFlowLogger> lazy, Lazy<WaterfallIdGenerator> lazy2, PandoraSequenceLogger pandoraSequenceLogger, MomentsAppInfoStore momentsAppInfoStore, MomentsUpsellLogger momentsUpsellLogger, PandoraSyncTabUtils pandoraSyncTabUtils, DialtoneController dialtoneController, SyncModePref syncModePref, VaultManager vaultManager) {
        this.f17718a = pandoraTabPagerAdapterProvider;
        this.f17719b = str;
        this.f17720c = lazy;
        this.f17721d = lazy2;
        this.f17722e = pandoraSequenceLogger;
        this.f17723f = momentsAppInfoStore;
        this.f17724g = momentsUpsellLogger;
        this.f17725h = pandoraSyncTabUtils;
        this.f17726i = dialtoneController;
        this.al = syncModePref;
        this.am = vaultManager;
    }

    private boolean ar() {
        return this.f17725h.m21657a(this.as) == PandoraSyncTabState.SYNC;
    }

    public static String m21691h(PandoraTabPagerFragment pandoraTabPagerFragment, int i) {
        int i2;
        int i3 = 0;
        int i4 = pandoraTabPagerFragment.ay ? 0 : 1;
        if (pandoraTabPagerFragment.az) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (!pandoraTabPagerFragment.ax) {
            i3 = 1;
        }
        if (pandoraTabPagerFragment.az && pandoraTabPagerFragment.aA) {
            if (i == 0) {
                return "Suggested Photos";
            }
            if (i == 1 && pandoraTabPagerFragment.ay) {
                return "camera_roll";
            }
        } else if (!pandoraTabPagerFragment.az || pandoraTabPagerFragment.aA) {
            if (!pandoraTabPagerFragment.az && i == 0 && pandoraTabPagerFragment.ay) {
                return "camera_roll";
            }
        } else if (i == 0) {
            return "camera_roll";
        } else {
            if (i == 1) {
                return "Suggested Photos";
            }
        }
        i4 += i2 + 0;
        if (i == 2 - i4 && pandoraTabPagerFragment.ax) {
            return "photos_of";
        }
        i4 += i3;
        if (i == 3 - i4) {
            return "photo_uploads";
        }
        if (i == 4 - i4) {
            return "albums";
        }
        if (i != 5 - i4) {
            return null;
        }
        String str;
        switch (pandoraTabPagerFragment.f17725h.m21657a(pandoraTabPagerFragment.as)) {
            case NONE:
                str = "";
                break;
            case SYNC:
                str = "sync";
                break;
            case LOADING:
                str = "loading";
                break;
            case MOMENTS_PROMOTION:
                str = "moments_promotion";
                break;
            case MOMENTS_SEGUE:
                str = "moments_segue";
                break;
            default:
                BLog.c(an, "Unknown sync tab state: %s", new Object[]{pandoraTabPagerFragment.f17725h.m21657a(pandoraTabPagerFragment.as)});
                str = "";
                break;
        }
        return str;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        if (!z) {
            this.ap.kR_();
        }
    }
}
