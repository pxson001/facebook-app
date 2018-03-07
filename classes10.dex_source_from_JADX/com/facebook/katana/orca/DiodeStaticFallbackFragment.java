package com.facebook.katana.orca;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.http.fburl.FbSiteUrlConfig;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.abtest.DiodeExperimentController;
import com.facebook.messaging.abtest.DiodeExperimentController.LearnMoreButtonStyle;
import com.facebook.messaging.abtest.ExperimentsForMessagingAbTestModule;
import com.facebook.messaging.appspecific.PackageNameResolver;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.FriendLists;
import com.facebook.messaging.contacts.loader.ContactsLoader.InitParams;
import com.facebook.messaging.contacts.loader.ContactsLoader.Result;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.forcemessenger.ClickThroughDestination;
import com.facebook.messaging.forcemessenger.ForceMessenger.Stage;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sideloading.AutoQESpecForSideloadingModule;
import com.facebook.sideloading.SideloadingChecker;
import com.facebook.sideloading.SideloadingFileUtils;
import com.facebook.sideloading.SideloadingLogger;
import com.facebook.sideloading.SideloadingManager;
import com.facebook.sideloading.SideloadingManager.DownloadingButtonListener;
import com.facebook.sideloading.SideloadingPrefKeys;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: units_position_index */
public class DiodeStaticFallbackFragment extends FbFragment implements ScrollableListContainer {
    @Inject
    GooglePlayIntentHelper f996a;
    public Button aA;
    private TextView aB;
    @Inject
    FbSharedPreferences al;
    @Inject
    @IsWorkBuild
    Boolean am;
    @Inject
    AutoQESpecForSideloadingModule an;
    @Inject
    DiodeExperimentController ao;
    @Inject
    FbSiteUrlConfig ap;
    protected Button aq;
    public ContactsLoader ar;
    public List<User> as;
    private ClickThroughDestination at = ClickThroughDestination.THREAD_LIST;
    private ScrollView au;
    private TextView av;
    private TextView aw;
    private ImageView ax;
    public FacepileView ay;
    public TextView az;
    @Inject
    AnalyticsLogger f997b;
    @Inject
    ContactsLoaderFactory f998c;
    @Inject
    Lazy<LinkHandlingHelper> f999d;
    @Inject
    @LoggedInUser
    Provider<User> f1000e;
    @Inject
    SideloadingChecker f1001f;
    @Inject
    SideloadingManager f1002g;
    @Inject
    SideloadingFileUtils f1003h;
    @Inject
    SideloadingLogger f1004i;

    /* compiled from: units_position_index */
    class C01581 implements Callback<Void, Result, Throwable> {
        final /* synthetic */ DiodeStaticFallbackFragment f986a;

        C01581(DiodeStaticFallbackFragment diodeStaticFallbackFragment) {
            this.f986a = diodeStaticFallbackFragment;
        }

        public final void m1041a(Object obj, Object obj2) {
            Result result = (Result) obj2;
            DiodeStaticFallbackFragment diodeStaticFallbackFragment = this.f986a;
            if (diodeStaticFallbackFragment.mx_() && result != null) {
                if (!(result.f == null && result.g == null)) {
                    Collection collection = result.f;
                    Collection collection2 = result.g;
                    Set linkedHashSet = new LinkedHashSet();
                    if (collection2 != null) {
                        linkedHashSet.addAll(collection2);
                    }
                    if (collection != null) {
                        linkedHashSet.addAll(collection);
                    }
                    diodeStaticFallbackFragment.as = Arrays.asList(linkedHashSet.toArray(new User[linkedHashSet.size()]));
                }
                if (!result.w) {
                    diodeStaticFallbackFragment.ar.b();
                    List<User> list = diodeStaticFallbackFragment.as;
                    if (!(diodeStaticFallbackFragment.az == null || list == null || list.isEmpty())) {
                        CharSequence a;
                        List b = Lists.b(10);
                        int i = 0;
                        for (User user : list) {
                            if (i >= 10) {
                                break;
                            }
                            b.add(Uri.parse(user.x()));
                            i++;
                        }
                        diodeStaticFallbackFragment.ay.setFaceUrls(b);
                        diodeStaticFallbackFragment.ay.setVisibility(0);
                        if (list.size() == 1) {
                            a = diodeStaticFallbackFragment.a(2131236585, new Object[]{((User) list.get(0)).h()});
                        } else if (list.size() == 2) {
                            a = diodeStaticFallbackFragment.a(2131236586, new Object[]{((User) list.get(0)).h(), ((User) list.get(1)).h()});
                        } else {
                            a = diodeStaticFallbackFragment.a(2131236587, new Object[]{((User) list.get(0)).h(), ((User) list.get(1)).h(), Integer.valueOf(list.size() - 2)});
                        }
                        diodeStaticFallbackFragment.az.setText(a);
                        diodeStaticFallbackFragment.az.setVisibility(0);
                    }
                }
            }
        }

        public final /* bridge */ /* synthetic */ void m1042b(Object obj, Object obj2) {
        }

        public final /* bridge */ /* synthetic */ void m1043c(Object obj, Object obj2) {
        }
    }

    /* compiled from: units_position_index */
    class C01592 implements OnClickListener {
        final /* synthetic */ DiodeStaticFallbackFragment f987a;

        C01592(DiodeStaticFallbackFragment diodeStaticFallbackFragment) {
            this.f987a = diodeStaticFallbackFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1746029049);
            if (DiodeStaticFallbackFragment.ar(this.f987a)) {
                if (this.f987a.al.a(SideloadingPrefKeys.m10162g("com.facebook.orca"), 0) != 2) {
                    this.f987a.aA.setText(2131236578);
                    this.f987a.aA.setClickable(false);
                    this.f987a.f1004i.m10128a("sideloading_diode_screen_download_button_on_click", ImmutableBiMap.b("surface", "fallback"));
                } else {
                    this.f987a.f1004i.m10128a("sideloading_diode_screen_install_button_on_click", ImmutableBiMap.b("surface", "fallback"));
                }
                this.f987a.f1002g.m10149a("com.facebook.orca");
                LogUtils.a(327925876, a);
                return;
            }
            DiodeStaticFallbackFragment.m1050b(this.f987a, UIElements.s);
            LogUtils.a(1943148701, a);
        }
    }

    /* compiled from: units_position_index */
    class C01614 implements OnClickListener {
        final /* synthetic */ DiodeStaticFallbackFragment f990a;

        C01614(DiodeStaticFallbackFragment diodeStaticFallbackFragment) {
            this.f990a = diodeStaticFallbackFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1787696717);
            DiodeStaticFallbackFragment.m1050b(this.f990a, UIElements.t);
            Logger.a(2, EntryType.UI_INPUT_END, 2119517771, a);
        }
    }

    /* compiled from: units_position_index */
    /* synthetic */ class C01636 {
        static final /* synthetic */ int[] f993a = new int[LearnMoreButtonStyle.values().length];

        static {
            try {
                f993a[LearnMoreButtonStyle.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f993a[LearnMoreButtonStyle.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f993a[LearnMoreButtonStyle.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: units_position_index */
    class DownloadingButtonListenImplentation implements DownloadingButtonListener {
        final /* synthetic */ DiodeStaticFallbackFragment f995a;

        /* compiled from: units_position_index */
        class C01641 implements Runnable {
            final /* synthetic */ DownloadingButtonListenImplentation f994a;

            C01641(DownloadingButtonListenImplentation downloadingButtonListenImplentation) {
                this.f994a = downloadingButtonListenImplentation;
            }

            public void run() {
                this.f994a.f995a.aA.setText(2131236577);
                this.f994a.f995a.aA.setClickable(true);
            }
        }

        public DownloadingButtonListenImplentation(DiodeStaticFallbackFragment diodeStaticFallbackFragment) {
            this.f995a = diodeStaticFallbackFragment;
        }

        public final void mo38a() {
            FragmentActivity o = this.f995a.o();
            if (o != null) {
                o.runOnUiThread(new C01641(this));
            }
        }
    }

    public static void m1047a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DiodeStaticFallbackFragment) obj).m1046a(GooglePlayIntentHelper.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ContactsLoaderFactory.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 7898), IdBasedProvider.a(injectorLike, 3595), SideloadingChecker.m10113b(injectorLike), SideloadingManager.m10139a(injectorLike), SideloadingFileUtils.m10115b(injectorLike), SideloadingLogger.m10126b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), AutoQESpecForSideloadingModule.a(injectorLike), DiodeExperimentController.a(injectorLike), FbSiteUrlConfig.a(injectorLike));
    }

    private void m1046a(GooglePlayIntentHelper googlePlayIntentHelper, AnalyticsLogger analyticsLogger, ContactsLoaderFactory contactsLoaderFactory, Lazy<LinkHandlingHelper> lazy, Provider<User> provider, SideloadingChecker sideloadingChecker, SideloadingManager sideloadingManager, SideloadingFileUtils sideloadingFileUtils, SideloadingLogger sideloadingLogger, FbSharedPreferences fbSharedPreferences, Boolean bool, AutoQESpecForSideloadingModule autoQESpecForSideloadingModule, DiodeExperimentController diodeExperimentController, FbSiteUrlConfig fbSiteUrlConfig) {
        this.f996a = googlePlayIntentHelper;
        this.f997b = analyticsLogger;
        this.f998c = contactsLoaderFactory;
        this.f999d = lazy;
        this.f1000e = provider;
        this.f1001f = sideloadingChecker;
        this.f1002g = sideloadingManager;
        this.f1003h = sideloadingFileUtils;
        this.f1004i = sideloadingLogger;
        this.al = fbSharedPreferences;
        this.am = bool;
        this.an = autoQESpecForSideloadingModule;
        this.ao = diodeExperimentController;
        this.ap = fbSiteUrlConfig;
    }

    public final void m1056c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = DiodeStaticFallbackFragment.class;
        m1047a((Object) this, getContext());
        ContactsLoaderFactory contactsLoaderFactory = this.f998c;
        ContactsLoader contactsLoader = (ContactsLoader) contactsLoaderFactory.b.get();
        contactsLoader.v = new InitParams(EnumSet.of(FriendLists.TOP_FRIENDS_ON_MESSENGER, FriendLists.FRIENDS_ON_MESSENGER));
        this.ar = contactsLoader;
        this.ar.a(new C01581(this));
    }

    public final View m1053a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1494974937);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130903912, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1468601510, a);
        return inflate;
    }

    public final void m1054a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.au = (ScrollView) FindViewUtil.b(view, 2131561033);
        this.av = (TextView) FindViewUtil.b(view, 2131561035);
        this.aw = (TextView) FindViewUtil.b(view, 2131561036);
        this.ax = (ImageView) FindViewUtil.b(view, 2131561037);
        this.ay = (FacepileView) FindViewUtil.b(view, 2131561038);
        this.az = (TextView) FindViewUtil.b(view, 2131561039);
        this.aq = (Button) FindViewUtil.b(view, 2131561040);
        this.aA = (Button) FindViewUtil.b(view, 2131561041);
        this.aB = (TextView) FindViewUtil.b(view, 2131561042);
    }

    public final void m1057d(Bundle bundle) {
        String str;
        String str2;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1342466246);
        super.d(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null && bundle2.containsKey("click_through")) {
            this.at = (ClickThroughDestination) bundle2.getSerializable("click_through");
        } else if (ao().getIntent().hasExtra("click_through")) {
            this.at = (ClickThroughDestination) ao().getIntent().getSerializableExtra("click_through");
        }
        m1049b();
        if (ar(this)) {
            this.f1002g.f10074t = new DownloadingButtonListenImplentation(this);
        }
        this.aA.setOnClickListener(new C01592(this));
        StringBuilder stringBuilder = new StringBuilder("https://");
        FbSiteUrlConfig fbSiteUrlConfig = this.ap;
        if (((Boolean) fbSiteUrlConfig.a.get()).booleanValue()) {
            String a2 = fbSiteUrlConfig.b.a(InternalHttpPrefKeys.q, "default");
            Object obj = -1;
            switch (a2.hashCode()) {
                case -1183762670:
                    if (a2.equals("intern")) {
                        obj = null;
                        break;
                    }
                    break;
                case 99349:
                    if (a2.equals("dev")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1544803905:
                    if (a2.equals("default")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1865400007:
                    if (a2.equals("sandbox")) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    str = "www.intern.facebook.com";
                    break;
                case 1:
                    str = "www.dev.facebook.com";
                    break;
                case 2:
                case 3:
                    obj = fbSiteUrlConfig.b.a(InternalHttpPrefKeys.r, null);
                    if (!StringUtil.a(obj)) {
                        str = "www." + obj;
                        break;
                    } else {
                        str = "www.facebook.com";
                        break;
                    }
                default:
                    str = "www.facebook.com";
                    break;
            }
        }
        str = "www.facebook.com";
        StringBuilder append = stringBuilder.append(str);
        if (this.am.booleanValue()) {
            str2 = "/help/work/732834203488236";
        } else {
            str2 = "/help/237721796268379";
        }
        str2 = append.append(str2).toString();
        OnClickListener c01603 = new OnClickListener(this) {
            final /* synthetic */ DiodeStaticFallbackFragment f989b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -212182790);
                this.f989b.m1055a(str2);
                Logger.a(2, EntryType.UI_INPUT_END, 1693984689, a);
            }
        };
        this.aq.setOnClickListener(c01603);
        this.aB.setOnClickListener(c01603);
        int[] iArr = C01636.f993a;
        String a3 = this.ao.a.a(ExperimentsForMessagingAbTestModule.a, LearnMoreButtonStyle.DEFAULT.name());
        for (LearnMoreButtonStyle learnMoreButtonStyle : LearnMoreButtonStyle.values()) {
            if (a3.equalsIgnoreCase(learnMoreButtonStyle.name())) {
                switch (iArr[learnMoreButtonStyle.ordinal()]) {
                    case 1:
                        this.aq.setVisibility(8);
                        this.aB.setVisibility(0);
                        break;
                    case 2:
                        this.aq.setVisibility(8);
                        this.aB.setVisibility(8);
                        break;
                    case 3:
                        this.aq.setVisibility(0);
                        this.aB.setVisibility(8);
                        break;
                }
                if (this.ao.a.a(ExperimentsForMessagingAbTestModule.c, false)) {
                    this.ax.setContentDescription(b(2131236575));
                    this.ax.setOnClickListener(new C01614(this));
                }
                this.ar.a();
                LogUtils.f(1900411272, a);
            }
        }
        LearnMoreButtonStyle learnMoreButtonStyle2 = LearnMoreButtonStyle.DEFAULT;
        switch (iArr[learnMoreButtonStyle2.ordinal()]) {
            case 1:
                this.aq.setVisibility(8);
                this.aB.setVisibility(0);
                break;
            case 2:
                this.aq.setVisibility(8);
                this.aB.setVisibility(8);
                break;
            case 3:
                this.aq.setVisibility(0);
                this.aB.setVisibility(8);
                break;
        }
        if (this.ao.a.a(ExperimentsForMessagingAbTestModule.c, false)) {
            this.ax.setContentDescription(b(2131236575));
            this.ax.setOnClickListener(new C01614(this));
        }
        this.ar.a();
        LogUtils.f(1900411272, a);
    }

    public static void m1050b(DiodeStaticFallbackFragment diodeStaticFallbackFragment, String str) {
        diodeStaticFallbackFragment.f996a.a(diodeStaticFallbackFragment.getContext(), PackageNameResolver.a());
        diodeStaticFallbackFragment.m1048a(str, null);
    }

    public final void m1052G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -735259789);
        super.G();
        if (D()) {
            final View view = this.T;
            if (view.getWidth() > 0) {
                aq(this);
            } else {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ DiodeStaticFallbackFragment f992b;

                    public void onGlobalLayout() {
                        CustomViewUtils.a(view, this);
                        DiodeStaticFallbackFragment.aq(this.f992b);
                    }
                });
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -945639410, a);
    }

    public final void gB_() {
        this.au.fullScroll(33);
    }

    public final boolean gC_() {
        return this.au.getScrollY() == 0;
    }

    @Nullable
    public final ScrollingViewProxy m1058n() {
        return null;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 832926863);
        super.mY_();
        this.f1002g.m10148a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -36075116, a);
    }

    private void m1049b() {
        User user = (User) this.f1000e.get();
        this.av.setText(a(2131236581, new Object[]{user.h()}));
        this.aw.setText(2131236584);
        this.ax.setImageResource(2130838416);
        this.aA.setText(2131236575);
        if (ar(this)) {
            int a = this.al.a(SideloadingPrefKeys.m10162g("com.facebook.orca"), 0);
            if (this.f1003h.m10119b("com.facebook.orca")) {
                this.aA.setText(2131236577);
                m1051c("Install");
            } else if (a == 1) {
                this.aA.setText(2131236578);
                this.aA.setClickable(false);
                m1051c("Downloading");
            } else {
                this.aA.setText(2131236576);
                m1051c("Download");
            }
        }
        this.aq.setText(2131236588);
    }

    protected final void m1055a(String str) {
        Context context = getContext();
        if (context != null) {
            m1048a(UIElements.y, str);
            ((LinkHandlingHelper) this.f999d.get()).a(context, Uri.parse(str));
        }
    }

    private void m1051c(String str) {
        this.f1004i.m10128a("sideloading_diode_screen_shown", ImmutableBiMap.b("button_text", str));
    }

    private void m1048a(String str, @Nullable String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.e = str;
        honeyClientEvent.d = "button";
        m1045a(honeyClientEvent);
        if (str2 != null) {
            honeyClientEvent.b("link", str2);
        }
        this.f997b.c(honeyClientEvent);
    }

    public static void aq(DiodeStaticFallbackFragment diodeStaticFallbackFragment) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("view");
        honeyClientEvent.e = UIElements.z;
        diodeStaticFallbackFragment.m1045a(honeyClientEvent);
        diodeStaticFallbackFragment.f997b.c(honeyClientEvent);
    }

    private void m1045a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "diode_qp_module";
        if (this.at != null) {
            honeyClientEvent.b("dest", this.at.toString());
        }
        honeyClientEvent.a("user_stage", Stage.INSTALL_NOW);
    }

    public static boolean ar(DiodeStaticFallbackFragment diodeStaticFallbackFragment) {
        return diodeStaticFallbackFragment.f1001f.m10114a() && diodeStaticFallbackFragment.an.b().m10112a(false);
    }
}
