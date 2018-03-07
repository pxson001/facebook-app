package com.facebook.fbreact.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnGenericMotionListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics2.logger.Analytics2EventConfig;
import com.facebook.analytics2.logger.Analytics2Logger;
import com.facebook.analytics2.logger.EventBuilder;
import com.facebook.analytics2.logger.EventLogType;
import com.facebook.analytics2.loggermodule.Analytics2LoggerMethodAutoProvider;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.CanHandleMenuPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringUtil;
import com.facebook.fbreact.exceptionmanager.FbReactExceptionManager;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: staging_ground_use_edit */
public class ImmersiveReactFragment extends FbFragment implements AnalyticsFragment, CanHandleBackPressed, CanHandleMenuPressed, NativeModuleCallExceptionHandler {
    private static final Analytics2EventConfig f3477f = Analytics2EventConfig.a("react_native", "immersive_react_fragment_start_react_application", false, EventLogType.CLIENT_EVENT, false);
    @Inject
    FbReactInstanceHolder f3478a;
    public String aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    @Nullable
    public CustomFrameLayout al;
    @Nullable
    public ReactRootView am;
    private HasTitleBar an;
    public boolean ao;
    public boolean ap;
    private OnGenericMotionListener aq;
    private String ar;
    private String as;
    private String at;
    private int au;
    private boolean av;
    private Bundle aw;
    private int ax;
    private String ay = "unknown";
    private int az;
    @Inject
    FbReactExceptionManager f3479b;
    @Inject
    ImmersiveReactFragmentHooks f3480c;
    @Inject
    Analytics2Logger f3481d;
    @Inject
    GatekeeperStoreImpl f3482e;
    private final C02991 f3483g = new C02991(this);
    private final C03002 f3484h = new C03002(this);
    public volatile Bundle f3485i;

    /* compiled from: staging_ground_use_edit */
    public class C02991 {
        public final /* synthetic */ ImmersiveReactFragment f3462a;

        C02991(ImmersiveReactFragment immersiveReactFragment) {
            this.f3462a = immersiveReactFragment;
        }
    }

    /* compiled from: staging_ground_use_edit */
    public class C03002 {
        public final /* synthetic */ ImmersiveReactFragment f3463a;

        C03002(ImmersiveReactFragment immersiveReactFragment) {
            this.f3463a = immersiveReactFragment;
        }
    }

    /* compiled from: staging_ground_use_edit */
    class C03013 implements DefaultHardwareBackBtnHandler {
        final /* synthetic */ ImmersiveReactFragment f3464a;

        C03013(ImmersiveReactFragment immersiveReactFragment) {
            this.f3464a = immersiveReactFragment;
        }

        public final void mo164a() {
            this.f3464a.o().finish();
        }
    }

    /* compiled from: staging_ground_use_edit */
    class C03024 extends OnToolbarButtonListener {
        final /* synthetic */ ImmersiveReactFragment f3465a;

        C03024(ImmersiveReactFragment immersiveReactFragment) {
            this.f3465a = immersiveReactFragment;
        }

        public final void m4167a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            ReactContext as = this.f3465a.as();
            if (as != null) {
                ((RCTNativeAppEventEmitter) as.m13515a(RCTNativeAppEventEmitter.class)).emit(this.f3465a.aA, null);
            }
        }
    }

    /* compiled from: staging_ground_use_edit */
    public class Builder {
        public String f3466a;
        public String f3467b;
        public String f3468c;
        public int f3469d;
        public boolean f3470e;
        public Bundle f3471f;
        public String f3472g = "unknown";
        public int f3473h = -1;
        public String f3474i;
        public int f3475j;
        public boolean f3476k;

        protected Builder() {
        }

        public Bundle m4168a() {
            Bundle bundle = new Bundle();
            if (this.f3466a != null) {
                bundle.putString("uri", this.f3466a);
            }
            if (this.f3467b != null) {
                bundle.putString("route_name", this.f3467b);
            }
            if (this.f3468c != null) {
                bundle.putString("module_name", this.f3468c);
            }
            bundle.putInt("title_res", this.f3469d);
            bundle.putBoolean("show_search", this.f3470e);
            bundle.putBundle("init_props", this.f3471f);
            bundle.putString("analytics_tag", this.f3472g);
            bundle.putInt("requested_orientation", this.f3473h);
            bundle.putInt("button_res", this.f3475j);
            bundle.putString("button_event", this.f3474i);
            bundle.putBoolean("disable_immersive_hooks", this.f3476k);
            return bundle;
        }

        public final ImmersiveReactFragment m4169b() {
            ImmersiveReactFragment c = m4170c();
            c.g(m4168a());
            return c;
        }

        protected ImmersiveReactFragment m4170c() {
            return new ImmersiveReactFragment();
        }
    }

    public static void m4173a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ImmersiveReactFragment) obj).m4172a(FbReactInstanceHolder.m4203a(injectorLike), FbReactExceptionManager.a(injectorLike), ImmersiveReactFragmentHooks.m4188a(injectorLike), Analytics2LoggerMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private void m4172a(FbReactInstanceHolder fbReactInstanceHolder, FbReactExceptionManager fbReactExceptionManager, ImmersiveReactFragmentHooks immersiveReactFragmentHooks, Analytics2Logger analytics2Logger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f3478a = fbReactInstanceHolder;
        this.f3479b = fbReactExceptionManager;
        this.f3480c = immersiveReactFragmentHooks;
        this.f3481d = analytics2Logger;
        this.f3482e = gatekeeperStoreImpl;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @SuppressLint({"WrongConstant"})
    public void m4183c(Bundle bundle) {
        Class cls = ImmersiveReactFragment.class;
        m4173a((Object) this, getContext());
        super.c(bundle);
        Bundle bundle2 = this.s;
        this.ar = bundle2.getString("uri");
        this.as = bundle2.getString("route_name");
        this.at = bundle2.getString("module_name");
        this.au = bundle2.getInt("title_res");
        this.av = bundle2.getBoolean("show_search");
        this.aw = bundle2.getBundle("init_props");
        this.ay = bundle2.getString("analytics_tag");
        this.ax = bundle2.getInt("requested_orientation", -1);
        this.az = bundle2.getInt("button_res");
        this.aA = bundle2.getString("button_event");
        this.aB = bundle2.getBoolean("disable_immersive_hooks");
        boolean z = (this.as == null && this.at == null) ? false : true;
        Preconditions.checkArgument(z);
        if (this.ay == "unknown") {
            if (!StringUtil.a(this.as)) {
                this.ay = "react_" + this.as;
            } else if (!StringUtil.a(this.at)) {
                this.ay = "react_" + this.at;
            }
        }
        o().setRequestedOrientation(this.ax);
        aq();
        this.f3479b.a(this);
        this.aD = true;
    }

    protected void aq() {
    }

    public void m4184d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 432075659);
        super.d(bundle);
        this.f3485i = bundle;
        ay();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 552307412, a);
    }

    public final View m4178a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2101993433);
        this.al = new CustomFrameLayout(getContext());
        this.al.setLayoutParams(new LayoutParams(-1, -1));
        this.al.addView(aw(), new LayoutParams(-1, -1));
        CustomFrameLayout customFrameLayout = this.al;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 118363598, a);
        return customFrameLayout;
    }

    public final void m4180a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        ar();
        av();
    }

    private void av() {
        SoftAssertions.m13549a(this.am);
        Analytics2Logger analytics2Logger = this.f3481d;
        Analytics2EventConfig analytics2EventConfig = f3477f;
        EventBuilder a = analytics2Logger.a(analytics2EventConfig.a, analytics2EventConfig.b, analytics2EventConfig.c, analytics2EventConfig.d, analytics2EventConfig.e);
        boolean a2 = a.a();
        if (this.as != null) {
            if (this.aw == null) {
                this.aw = new Bundle();
            }
            this.aw.putString("uri", ax());
            this.aw.putString("routeName", this.as);
            this.am.m13328a(au(), "FacebookAppRouteHandler", this.aw);
            if (a2) {
                a.d("routeName", this.as);
            }
        } else if (this.at != null) {
            this.am.m13328a(au(), this.at, this.aw);
            if (a2) {
                a.d("moduleName", this.at);
            }
        }
        if (a2) {
            if (this.ar != null) {
                a.d("uri", this.ar);
            }
            a.d();
        }
    }

    protected void ar() {
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -181353523);
        super.mY_();
        if (this.am != null) {
            this.am.m13326a();
            this.am = null;
        }
        this.al = null;
        this.ap = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1760868026, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -740590754);
        super.mi_();
        ay();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1598353143, a);
    }

    public void m4175G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1000947078);
        super.G();
        aA();
        this.f3478a.m4207b(this.f3484h);
        ReactInstanceManager au = au();
        if (this.ap || this.ao) {
            this.ap = false;
            this.ao = false;
            if (this.al != null) {
                this.al.removeAllViews();
                this.al.addView(aw(), new LayoutParams(-1, -1));
            }
            ar();
            av();
        }
        DefaultHardwareBackBtnHandler c03013 = new C03013(this);
        FbReactInstanceHolder fbReactInstanceHolder = this.f3478a;
        fbReactInstanceHolder.f3507e.add(this);
        fbReactInstanceHolder.f3508f.remove(this);
        au.mo624a(o(), c03013);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1860867304, a);
    }

    public void m4186g(boolean z) {
        super.g(z);
        if (!this.aD) {
            return;
        }
        if (z) {
            aA();
        } else {
            aB(this);
        }
    }

    public void m4176H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 696912891);
        ReactInstanceManager au = au();
        FbReactInstanceHolder fbReactInstanceHolder = this.f3478a;
        fbReactInstanceHolder.f3507e.remove(this);
        fbReactInstanceHolder.f3508f.add(this);
        if (!(!fbReactInstanceHolder.f3507e.isEmpty() || this.ap || au == null)) {
            au.mo632e();
        }
        aB(this);
        super.H();
        if (!ao().isFinishing()) {
            FbReactInstanceHolder fbReactInstanceHolder2 = this.f3478a;
            fbReactInstanceHolder2.f3509g.add(this.f3484h);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2122607647, a);
    }

    public void m4177I() {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1798907048);
        this.f3478a.m4207b(this.f3484h);
        FbReactInstanceHolder fbReactInstanceHolder = this.f3478a;
        fbReactInstanceHolder.f3507e.remove(this);
        fbReactInstanceHolder.f3508f.remove(this);
        if (fbReactInstanceHolder.f3507e.isEmpty() && fbReactInstanceHolder.f3508f.isEmpty()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && this.f3478a.m4205a()) {
            au().mo633f();
        }
        if (this.f3482e.a(753, false)) {
            this.f3478a.m4206b();
        }
        if (this.f3479b != null) {
            this.f3479b.b(this);
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -407705954, a);
    }

    public void m4185e(Bundle bundle) {
        super.e(bundle);
        if (this.f3485i != null) {
            bundle.putAll(this.f3485i);
        }
    }

    public final void m4179a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        aA();
        ReactInstanceManager au = au();
        if (au != null) {
            au.mo623a(i, i2, intent);
        }
    }

    public boolean O_() {
        ReactInstanceManager au = au();
        ReactContext as = as();
        if (this.ap || as == null || !as.m13528b()) {
            return false;
        }
        au.mo631d();
        return true;
    }

    public final void m4181a(Exception exception) {
        if (!(this.al == null || this.am == null)) {
            this.al.removeAllViews();
            this.al.addView(LayoutInflater.from(getContext()).inflate(2130906586, this.al, false));
            this.am = null;
        }
        this.ap = true;
    }

    public final String am_() {
        return this.ay;
    }

    public final boolean m4182a() {
        ReactInstanceManager au = au();
        if (au == null || !BuildConstants.i) {
            return false;
        }
        au.mo634g();
        return true;
    }

    protected final ReactContext as() {
        ReactInstanceManager au = au();
        return au != null ? au.mo637j() : null;
    }

    private ReactRootView aw() {
        if (this.am == null) {
            this.am = new ReactRootView(getContext());
            this.am.setId(2131558758);
            if (this.aq != null) {
                this.am.setOnGenericMotionListener(this.aq);
            }
        }
        return this.am;
    }

    public final ReactInstanceManager au() {
        return this.f3478a.m4208c();
    }

    private String ax() {
        String str = this.ar;
        if (this.aw == null) {
            this.aw = new Bundle();
            return str;
        }
        Set<String> keySet = this.aw.keySet();
        if (str == null || keySet.isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        Object obj = 1;
        for (String str2 : keySet) {
            Object obj2 = this.aw.get(str2);
            if (obj2 != null) {
                if (obj != null) {
                    stringBuilder.append("?");
                    obj = null;
                } else {
                    stringBuilder.append("&");
                }
                stringBuilder.append(str2 + "=" + String.valueOf(obj2));
            }
        }
        return stringBuilder.toString();
    }

    private void ay() {
        if (this.an == null) {
            this.an = (HasTitleBar) a(HasTitleBar.class);
        }
        if (this.an != null) {
            if (this.au != 0) {
                this.an.y_(this.au);
            }
            az();
        }
    }

    private void m4174a(String str) {
        if (this.an == null) {
            this.an = (HasTitleBar) a(HasTitleBar.class);
        }
        if (this.an != null) {
            this.an.a_(str);
            az();
        }
    }

    private void az() {
        this.an.c(!this.av);
        if (this.aA != null && this.az != 0) {
            com.facebook.widget.titlebar.TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = getContext().getString(this.az);
            this.an.a(a.a());
            this.an.a(new C03024(this));
        }
    }

    private void aA() {
        if (!this.aB && !this.aC) {
            this.aC = true;
            ImmersiveReactFragmentHooks immersiveReactFragmentHooks = this.f3480c;
            C02991 c02991 = this.f3483g;
            if (c02991 != immersiveReactFragmentHooks.f3492c) {
                if (c02991 != immersiveReactFragmentHooks.f3492c) {
                    immersiveReactFragmentHooks.f3491b.a(SoftError.a("ImmersiveReactFragmentHooks", "New listener registered before unresgister is called on previous listener.").g());
                }
                immersiveReactFragmentHooks.f3492c = c02991;
            }
        }
    }

    public static void aB(ImmersiveReactFragment immersiveReactFragment) {
        if (!immersiveReactFragment.aB && immersiveReactFragment.aC) {
            immersiveReactFragment.aC = false;
            ImmersiveReactFragmentHooks immersiveReactFragmentHooks = immersiveReactFragment.f3480c;
            C02991 c02991 = immersiveReactFragment.f3483g;
            if (immersiveReactFragmentHooks.f3492c != null) {
                if (c02991 != immersiveReactFragmentHooks.f3492c) {
                    immersiveReactFragmentHooks.f3491b.a(SoftError.a("ImmersiveReactFragmentHooks", "Unregister listener called with the wrong listener passed in. A different fragmentthan the current one listening is calling unregister.").g());
                }
                immersiveReactFragmentHooks.f3492c = null;
            }
        }
    }
}
