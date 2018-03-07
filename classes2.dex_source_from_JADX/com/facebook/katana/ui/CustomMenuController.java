package com.facebook.katana.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.about.AboutActivity;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.bugreporter.BugReporter;
import com.facebook.bugreporter.BugReporterRelated;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.activitylistener.annotations.HideSettingsFromOptionsMenu;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.annotationcache.AnnotationCache;
import com.facebook.common.annotationcache.AnnotationCacheMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.debug.monkey.MonkeyMode;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.LogoutActivity;
import com.facebook.katana.activity.FacebookActivity;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.features.bugreporter.annotations.BugReportingNotRequired;
import com.facebook.katana.settings.activity.SettingsActivity;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.katana.urimap.IntentHandlerUtil;
import com.facebook.katana.util.LogoutHelper;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.menu.ExportMenuToFbHostActivity;
import com.facebook.menu.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.photos.mediagallery.ui.MediaGalleryActivity;
import com.facebook.selfupdate.SelfUpdateManager;
import com.facebook.ui.custommenu.CustomMenu;
import com.facebook.ui.custommenu.CustomMenuItem;
import com.facebook.user.model.User;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: subscribe_location */
public class CustomMenuController extends AbstractFbActivityListener {
    private static CustomMenuController f3908o;
    private static final Object f3909p = new Object();
    public CustomMenu f3910a;
    public Map<Integer, CustomMenuItem> f3911b = new LinkedHashMap();
    public Map<Integer, String> f3912c = new HashMap();
    public final Activity f3913d;
    private final LoggedInUserSessionManager f3914e;
    public final Lazy<BugReporter> f3915f;
    private final InteractionLogger f3916g;
    public final AbstractFbErrorReporter f3917h;
    private final MonkeyMode f3918i;
    private final AnnotationCache f3919j;
    private final Lazy<DBLStorageAndRetrievalHelper> f3920k;
    private final SecureContextHelper f3921l;
    private final Lazy<LogoutHelper> f3922m;
    private final Lazy<FbReactInstanceHolder> f3923n;

    private static CustomMenuController m6516b(InjectorLike injectorLike) {
        return new CustomMenuController(ActivityMethodAutoProvider.m6475b(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5011), InteractionLogger.m6498a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), MonkeyMode.m6527a(injectorLike), AnnotationCacheMethodAutoProvider.m6191a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2396), DefaultSecureContextHelper.m4636a(injectorLike), IdBasedLazy.m1808a(injectorLike, 7381), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5782));
    }

    public static CustomMenuController m6514a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomMenuController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f3909p) {
                CustomMenuController customMenuController;
                if (a2 != null) {
                    customMenuController = (CustomMenuController) a2.mo818a(f3909p);
                } else {
                    customMenuController = f3908o;
                }
                if (customMenuController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m6516b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f3909p, b3);
                        } else {
                            f3908o = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = customMenuController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public CustomMenuController(Activity activity, LoggedInUserAuthDataStore loggedInUserAuthDataStore, Lazy<BugReporter> lazy, InteractionLogger interactionLogger, FbErrorReporter fbErrorReporter, MonkeyMode monkeyMode, AnnotationCache annotationCache, Lazy<DBLStorageAndRetrievalHelper> lazy2, SecureContextHelper secureContextHelper, Lazy<LogoutHelper> lazy3, Lazy<FbReactInstanceHolder> lazy4) {
        this.f3913d = activity;
        this.f3914e = loggedInUserAuthDataStore;
        this.f3915f = lazy;
        this.f3916g = interactionLogger;
        this.f3917h = fbErrorReporter;
        this.f3918i = monkeyMode;
        this.f3919j = annotationCache;
        this.f3921l = secureContextHelper;
        this.f3920k = lazy2;
        this.f3922m = lazy3;
        this.f3923n = lazy4;
    }

    public final Optional<Boolean> mo245a(Activity activity, int i, KeyEvent keyEvent) {
        if (i == 4) {
            LoggerUtils.m12200a(activity).m5498a("tap_back_button");
            if (this.f3910a == null || !this.f3910a.h) {
                Object obj;
                if (keyEvent.getRepeatCount() == 0) {
                    keyEvent.startTracking();
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return Optional.of(Boolean.valueOf(true));
                }
            }
            this.f3910a.d();
            return Optional.of(Boolean.valueOf(true));
        }
        if (i == 82 && keyEvent.isLongPress()) {
            return Optional.of(Boolean.valueOf(true));
        }
        if (i != 82 || keyEvent.getRepeatCount() != 0) {
            return Absent.INSTANCE;
        }
        if (activity instanceof LogoutActivity) {
            return Optional.of(Boolean.valueOf(true));
        }
        if (this.f3910a == null && this.f3910a == null) {
            this.f3910a = new Fb4aCustomMenu(this.f3913d, LayoutInflater.from(this.f3913d));
        }
        if (this.f3910a.h) {
            LoggerUtils.m12200a(activity).m5519c(Modules.c);
            this.f3910a.d();
        } else {
            boolean z;
            LoggerUtils.m12200a(activity).m5511a(Modules.c, true);
            if (activity instanceof MediaGalleryActivity) {
                z = activity instanceof MediaGalleryActivity;
            } else {
                z = false;
            }
            if (z) {
                m6519m(activity);
            } else {
                Fragment fragment;
                View a;
                FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.m2500a((Context) activity, FragmentManagerHost.class);
                if (fragmentManagerHost == null || fragmentManagerHost.kO_() == null) {
                    fragment = null;
                } else {
                    fragment = fragmentManagerHost.kO_().mo841a("chromeless:content:fragment:tag");
                }
                if (fragment == null || !fragment.m282z()) {
                    a = FbRootViewUtil.m13815a(activity);
                } else {
                    a = fragment.f116T;
                }
                this.f3910a.a(a, false, true);
            }
        }
        return Optional.of(Boolean.valueOf(true));
    }

    private boolean m6515a(ExportMenuToFbHostActivity exportMenuToFbHostActivity) {
        List<CustomFbHostMenuItem> d = exportMenuToFbHostActivity.d();
        if (d == null) {
            return false;
        }
        List<Integer> arrayList = new ArrayList();
        for (Integer intValue : this.f3911b.keySet()) {
            int intValue2 = intValue.intValue();
            if (intValue2 < 1001 || intValue2 > 1009) {
                arrayList.add(Integer.valueOf(intValue2));
            }
        }
        for (Integer intValue3 : arrayList) {
            this.f3911b.remove(Integer.valueOf(intValue3.intValue()));
        }
        for (CustomFbHostMenuItem customFbHostMenuItem : d) {
            m6521a(customFbHostMenuItem.a, customFbHostMenuItem.b, customFbHostMenuItem.c > 0 ? customFbHostMenuItem.c : 2130842601);
            m6523a(customFbHostMenuItem.a, customFbHostMenuItem.d);
            if (customFbHostMenuItem.e != null) {
                this.f3912c.put(Integer.valueOf(customFbHostMenuItem.a), customFbHostMenuItem.e);
            }
        }
        return true;
    }

    public final void nc_() {
        Object obj = 1;
        Object obj2 = TriState.YES == TriState_IsMeUserAnEmployeeMethodAutoProvider.m11944b(FbInjector.get(this.f3913d)) ? 1 : null;
        if (this.f3918i.m6529a()) {
            this.f3911b.clear();
        } else {
            obj = null;
        }
        boolean a = this.f3919j.m6139a(this.f3913d.getClass(), HideSettingsFromOptionsMenu.class);
        if (this.f3911b.get(Integer.valueOf(1001)) == null && this.f3914e.m2522b() && !(this.f3913d instanceof SettingsActivity) && !a) {
            m6521a(1001, 2131236506, 2130842601);
        }
        if (this.f3911b.get(Integer.valueOf(1003)) == null && this.f3914e.m2522b() && !a && r1 == null) {
            m6521a(1003, 2131236553, 2130842598);
        }
        if (this.f3911b.get(Integer.valueOf(1002)) == null) {
            m6521a(1002, 2131232455, 2130842597);
        }
        if (this.f3911b.get(Integer.valueOf(1009)) == null && obj2 != null && r1 == null) {
            m6521a(1009, 2131236893, 17301561);
        }
        if (this.f3911b.get(Integer.valueOf(1004)) == null && obj2 != null && r1 == null) {
            m6521a(1004, 2131237526, 17301560);
        }
        if (this.f3911b.get(Integer.valueOf(1005)) == null && m6518j(this.f3913d) && this.f3914e.m2522b() && !(this.f3913d instanceof BugReporterRelated) && r1 == null) {
            m6521a(1005, 2131235816, 2130842596);
        }
        if (this.f3911b.get(Integer.valueOf(1007)) == null && obj2 != null && r1 == null) {
            m6521a(1007, 2131236748, 17301570);
        }
        this.f3912c.clear();
        if (this.f3913d instanceof FacewebFragment) {
            FacewebFragment facewebFragment = (FacewebFragment) this.f3913d;
            int i = 0;
            FacebookActivity aq = facewebFragment.aq();
            if (aq instanceof CustomMenuController) {
                CustomMenuController customMenuController = (CustomMenuController) aq;
                if (facewebFragment.aC) {
                    customMenuController.m6521a(100, 2131236493, 2130842600);
                    customMenuController.m6523a(100, !facewebFragment.aJ);
                }
                if (TriState.YES == TriState_IsMeUserAnEmployeeMethodAutoProvider.m11944b(facewebFragment.an())) {
                    customMenuController.m6522a(101, "Faceweb!", 2130840844);
                }
                if (facewebFragment.ay != null) {
                    customMenuController.m6522a(2100, facewebFragment.ay.b, facewebFragment.ay.a);
                }
                if (facewebFragment.aS != null) {
                    while (i < facewebFragment.aS.length) {
                        int i2 = i + 2000;
                        JSONObject jSONObject = facewebFragment.aS[i];
                        if (jSONObject.has("icon")) {
                            customMenuController.m6522a(i2, jSONObject.optString("title"), jSONObject.optInt("icon"));
                        } else {
                            customMenuController.m6522a(i2, jSONObject.optString("title"), 2130842602);
                        }
                        i++;
                    }
                }
            } else {
                BLog.a(facewebFragment.ar(), "Activity is not an instance of CustomMenuHandler, not adding menu options");
            }
        }
        if (this.f3913d instanceof ExportMenuToFbHostActivity) {
            m6515a((ExportMenuToFbHostActivity) this.f3913d);
        }
        m6517e();
    }

    private void m6517e() {
        if (this.f3910a != null) {
            this.f3910a.a(new ArrayList(this.f3911b.values()));
        }
    }

    public final void m6521a(int i, int i2, int i3) {
        m6522a(i, this.f3913d.getResources().getString(i2), i3);
    }

    public final void m6522a(int i, String str, int i2) {
        if (!this.f3911b.containsKey(Integer.valueOf(i))) {
            CustomMenuItem customMenuItem = new CustomMenuItem();
            customMenuItem.c = i;
            customMenuItem.a = str;
            customMenuItem.b = i2;
            this.f3911b.put(Integer.valueOf(i), customMenuItem);
        }
    }

    public final void m6523a(int i, boolean z) {
        CustomMenuItem customMenuItem = (CustomMenuItem) this.f3911b.get(Integer.valueOf(i));
        if (customMenuItem != null) {
            customMenuItem.d = z;
        }
    }

    public final void m6525a(CustomMenuItem customMenuItem) {
        boolean z = true;
        switch (customMenuItem.c) {
            case 1001:
                this.f3916g.m6505a(UIElements.h, null);
                this.f3913d.startActivity(new Intent(this.f3913d, SettingsActivity.class));
                return;
            case 1002:
                this.f3916g.m6505a(UIElements.i, null);
                this.f3921l.mo662a(new Intent(this.f3913d, AboutActivity.class), this.f3913d);
                return;
            case 1003:
                this.f3916g.m6505a(UIElements.n, null);
                User c = this.f3914e.m2523c();
                if (c == null || ((DBLStorageAndRetrievalHelper) this.f3920k.get()).m8212c(c.f3598a) == null) {
                    z = false;
                }
                ((LogoutHelper) this.f3922m.get()).a(this.f3913d, z);
                return;
            case 1004:
                this.f3916g.m6505a(UIElements.l, null);
                Builder builder = new Builder(this.f3913d);
                builder.b("How do you want to fail?").c("OOM crash", new 3(this)).a("Hard crash", new 2(this)).b("Soft error", new 1(this));
                builder.b();
                return;
            case 1005:
                this.f3916g.m6505a(UIElements.k, null);
                if (m6518j(this.f3913d)) {
                    ((BugReporter) this.f3915f.get()).a(this.f3913d);
                    return;
                }
                return;
            case 1006:
                this.f3916g.m6505a(UIElements.o, null);
                this.f3910a.d();
                this.f3910a.a(FbRootViewUtil.m13815a(this.f3913d), true, true);
                return;
            case 1007:
                this.f3916g.m6505a(UIElements.j, null);
                SelfUpdateManager.m12703a(FbInjector.get(this.f3913d)).m12709a(true);
                return;
            case 1008:
                Intent a = Fb4aUriIntentMapper.m8640a(FbInjector.get(this.f3913d)).mo1267a(this.f3913d, FBLinks.f2145T);
                a.putExtra("trigger", "context_menu");
                this.f3913d.startActivity(a);
                return;
            case 1009:
                ((FbReactInstanceHolder) this.f3923n.get()).c().g();
                return;
            default:
                int i = customMenuItem.c;
                if (this.f3912c.containsKey(Integer.valueOf(i))) {
                    String str = (String) this.f3912c.get(Integer.valueOf(i));
                    if (str != null) {
                        IntentHandlerUtil.a(FbInjector.get(this.f3913d)).a(this.f3913d, str);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final void mo248a(Activity activity, Configuration configuration) {
        super.mo248a(activity, configuration);
        if (this.f3910a != null && this.f3910a.h) {
            this.f3910a.d();
            this.f3910a.a(FbRootViewUtil.m13815a(activity), this.f3910a.i, false);
        }
    }

    public final void mo242d(Activity activity) {
        if (this.f3910a != null && this.f3910a.h) {
            this.f3910a.d();
        }
    }

    private boolean m6518j(Activity activity) {
        return !this.f3919j.m6139a(activity.getClass(), BugReportingNotRequired.class);
    }

    private static void m6519m(Activity activity) {
        if ((activity instanceof MediaGalleryActivity) && (activity instanceof MediaGalleryActivity)) {
            ((MediaGalleryActivity) activity).i();
        }
    }
}
