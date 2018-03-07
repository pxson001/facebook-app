package com.facebook.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.annotationcache.AnnotationCache;
import com.facebook.common.annotationcache.AnnotationCacheMethodAutoProvider;
import com.facebook.common.appchoreographer.iface.ChoreographedActivity;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.common.dispose.DisposableContext;
import com.facebook.common.dispose.DisposableContextHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.touchlistener.FbTouchEventActivityListener;
import com.facebook.common.touchlistener.STATICDI_MULTIBIND_PROVIDER$FbTouchEventActivityListener;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.C0216x9d3093cb;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: system_counters  */
public class FbFragmentActivity extends FragmentActivity implements FbServiceAwareActivity, FragmentManagerHost, ListenableActivity, ChoreographedActivity, DisposableContext, PropertyBag, ProvidesInterface {
    private static final Class f3716p = FbFragmentActivity.class;
    private Factory f3717A;
    public C0216x9d3093cb f3718B;
    private FbActivityListenerDispatcher f3719C;
    private AppInitLock f3720D;
    private String f3721E = "";
    private final PropertyBagHelper f3722q = new PropertyBagHelper();
    private Lazy<Set<FbTouchEventActivityListener>> f3723r;
    private boolean f3724s;
    private FbResources f3725t;
    private DisposableContextHelper f3726u;
    private AnnotationCache f3727v;
    private AbstractFbErrorReporter f3728w;
    private String f3729x;
    private boolean f3730y;
    private FbCustomReportDataSupplier f3731z;

    /* compiled from: system_counters  */
    class C02141 implements FbActivitySuper {
        final /* synthetic */ FbFragmentActivity f3752a;

        C02141(FbFragmentActivity fbFragmentActivity) {
            this.f3752a = fbFragmentActivity;
        }

        public final boolean mo837a(int i, MenuItem menuItem) {
            return super.onMenuItemSelected(i, menuItem);
        }

        public final void mo836a() {
            super.gE_();
        }
    }

    /* compiled from: system_counters  */
    class C02152 implements FbCustomReportDataSupplier {
        final /* synthetic */ FbFragmentActivity f3753a;

        C02152(FbFragmentActivity fbFragmentActivity) {
            this.f3753a = fbFragmentActivity;
        }

        @TargetApi(11)
        public final String mo633a(Throwable th) {
            Writer stringWriter = new StringWriter();
            this.f3753a.dump("", null, new PrintWriter(stringWriter), new String[0]);
            return stringWriter.toString();
        }

        public final String mo632a() {
            return null;
        }
    }

    private static <T extends Context> void m6090a(Class<T> cls, T t) {
        m6091a((Object) t, (Context) t);
    }

    private static void m6091a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FbFragmentActivity) obj).m6089a(DownloadedFbResources.m2490a(injectorLike), DisposableContextHelper.m6133b(injectorLike), AnnotationCacheMethodAutoProvider.m6191a(injectorLike), ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$FbTouchEventActivityListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), FbErrorReporterImpl.m2317a(injectorLike), FactoryMethodAutoProvider.m6192b(injectorLike), FbActivityListenerDispatcher.m6140b(injectorLike), AppInitLock.m2271a(injectorLike));
    }

    protected final <T extends View> Optional<T> m6109c(int i) {
        Preconditions.checkNotNull(this);
        return Optional.fromNullable(findViewById(i));
    }

    @Inject
    private void m6089a(FbResources fbResources, DisposableContextHelper disposableContextHelper, AnnotationCache annotationCache, Lazy<Set<FbTouchEventActivityListener>> lazy, FbErrorReporter fbErrorReporter, Factory factory, FbActivityListenerDispatcher fbActivityListenerDispatcher, AppInitLock appInitLock) {
        this.f3725t = fbResources;
        this.f3726u = disposableContextHelper;
        this.f3727v = annotationCache;
        this.f3723r = lazy;
        this.f3728w = fbErrorReporter;
        this.f3717A = factory;
        this.f3719C = fbActivityListenerDispatcher;
        this.f3720D = appInitLock;
    }

    public final void mo820a(ActivityListener activityListener) {
        this.f3719C.m6158a(activityListener);
    }

    public final void mo824b(ActivityListener activityListener) {
        this.f3719C.m6169b(activityListener);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        hy_();
        TracerDetour.a("%s.attachBaseContext()", getClass().getSimpleName(), -607161390);
        try {
            m6090a(FbFragmentActivity.class, (Context) this);
            mo797j();
        } finally {
            TracerDetour.a(853050562);
        }
    }

    protected void hy_() {
    }

    protected final void onCreate(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -185146432);
        this.f3720D.m2277b();
        TracerDetour.a("%s.onCreate", getClass().getSimpleName(), 656412251);
        if (bundle != null) {
            try {
                bundle.setClassLoader(FbFragmentActivity.class.getClassLoader());
            } catch (Throwable th) {
                TracerDetour.a(200525911);
                LogUtils.c(544053587, a);
            }
        }
        this.f3719C.m6153a((Activity) this, mo800m());
        boolean a2 = this.f3719C.m6162a(bundle);
        super.onCreate(bundle);
        if (a2) {
            TracerDetour.a(543874978);
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 165356469, a);
            return;
        }
        mo2564a(bundle);
        if (this.f3719C.m6172b(bundle)) {
            TracerDetour.a(-321432960);
            LogUtils.c(-872985590, a);
            return;
        }
        mo790b(bundle);
        this.f3719C.m6177d();
        this.f3721E = getClass().getSimpleName() + "_FLAG_" + Integer.toString(hashCode());
        this.f3728w.mo345c(this.f3721E, "1");
        mo813p();
        TracerDetour.a(-761969664);
        LogUtils.c(-685152717, a);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f3719C.m6176c(bundle);
    }

    public Resources getResources() {
        return this.f3725t;
    }

    protected void mo2564a(@Nullable Bundle bundle) {
    }

    protected void mo790b(@Nullable Bundle bundle) {
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        this.f3719C.m6179d(bundle);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 993614065);
        super.onStart();
        this.f3719C.m6180e();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1000182798, a);
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!isFinishing() || this.f3727v.m6139a(getClass(), DeliverOnNewIntentWhenFinishing.class)) {
            this.f3719C.m6154a(intent);
            this.f3724s = false;
            mo784a(intent);
            Preconditions.checkState(this.f3724s, "onActivityNewIntent didn't call super.onActivityNewIntent()");
        }
    }

    protected void mo784a(Intent intent) {
        this.f3724s = true;
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1768347970);
        super.onStop();
        this.f3719C.m6181f();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -240090656, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 980943167);
        super.onPause();
        this.f3728w.mo343b(this.f3729x);
        this.f3719C.m6182g();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1867768974, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -579160485);
        TracerDetour.a("%s.onResume", getClass().getSimpleName(), -1266791901);
        try {
            mo797j();
            super.onResume();
            if (this.f3730y) {
                this.f3728w.mo338a(this.f3729x, this.f3731z);
            }
            this.f3719C.m6183h();
        } finally {
            TracerDetour.a(1689428151);
            LogUtils.c(-465304790, a);
        }
    }

    protected void hp_() {
        super.hp_();
        this.f3719C.m6184i();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1836282813);
        try {
            this.f3726u.m6135a();
            this.f3719C.m6185j();
        } finally {
            super.onDestroy();
            this.f3728w.mo337a(this.f3721E);
            LogUtils.c(1874763330, a);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TracerDetour.a("FbFragmentActivity.dispatchTouchEvent", -952809832);
        try {
            TracerDetour.a("FbActivityListeners.onTouchEvent", -1524505008);
            try {
                int hasNext;
                Iterator it = ((Set) this.f3723r.get()).iterator();
                while (true) {
                    hasNext = it.hasNext();
                    if (hasNext == 0) {
                        break;
                    }
                    ((InteractionEventListenerDispatcher) it.next()).m6207a();
                }
                TracerDetour.a(hasNext);
                boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                return dispatchTouchEvent;
            } finally {
                TracerDetour.a(1590379200);
            }
        } finally {
            TracerDetour.a(1433356246);
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        this.f3719C.m6186k();
    }

    public boolean mo823a(Throwable th) {
        return this.f3719C.m6166a(th);
    }

    public boolean onSearchRequested() {
        Optional l = this.f3719C.m6187l();
        return l.isPresent() ? ((Boolean) l.get()).booleanValue() : super.onSearchRequested();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Optional a = this.f3719C.m6148a(i, keyEvent);
        return a.isPresent() ? ((Boolean) a.get()).booleanValue() : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Optional b = this.f3719C.m6167b(i, keyEvent);
        return b.isPresent() ? ((Boolean) b.get()).booleanValue() : super.onKeyUp(i, keyEvent);
    }

    public void finish() {
        BLog.a(f3716p, new RuntimeException("dummy for stack trace"), "Finishing %s (cls %s)", new Object[]{getComponentName(), getClass().getName()});
        super.finish();
        this.f3719C.m6188m();
    }

    public void onContentChanged() {
        super.onContentChanged();
        this.f3719C.m6189n();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f3719C.m6160a(z);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog c = this.f3719C.m6174c(i);
        return c != null ? c : super.onCreateDialog(i);
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        if (!this.f3719C.m6161a(i, dialog)) {
            super.onPrepareDialog(i, dialog);
        }
    }

    public void onBackPressed() {
        if (kO_().mo851c() && !this.f3719C.m6190o()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        mo797j();
        super.onConfigurationChanged(configuration);
        this.f3719C.m6155a(configuration);
    }

    private void mo797j() {
        this.f3725t.m2553a();
    }

    @Deprecated
    public FbInjector hz_() {
        return FbInjector.get(this);
    }

    public <T extends View> T mo2563a(int i) {
        return FindViewUtil.m6201b((Activity) this, i);
    }

    protected Set<ActivityListener> hA_() {
        return Collections.unmodifiableSet(this.f3719C.f3742b);
    }

    public void mo821a(AbstractListenableDisposable abstractListenableDisposable) {
        this.f3726u.m6136a(abstractListenableDisposable);
    }

    public final void gE_() {
        if (!this.f3719C.m6170b()) {
            super.gE_();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f3719C.m6157a(menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.f3719C.m6168b(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f3719C.m6163a(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    public View onCreatePanelView(int i) {
        Optional a = this.f3719C.m6147a(i);
        return a != null ? (View) a.orNull() : super.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        Optional a = this.f3719C.m6149a(i, menu);
        return a.isPresent() ? ((Boolean) a.get()).booleanValue() : super.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        Optional a = this.f3719C.m6151a(i, view, menu);
        return a.isPresent() ? ((Boolean) a.get()).booleanValue() : super.onPreparePanel(i, view, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Optional a = this.f3719C.m6150a(i, menuItem);
        return a.isPresent() ? ((Boolean) a.get()).booleanValue() : super.onMenuItemSelected(i, menuItem);
    }

    public void mo822a(Object obj, Object obj2) {
        this.f3722q.m6132a(obj, obj2);
    }

    public Object mo818a(Object obj) {
        return this.f3722q.m6131a(obj);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f3719C.m6152a(i, i2, intent);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.f3719C.m6178d(i);
    }

    public void mo819a(Fragment fragment) {
        super.mo819a(fragment);
        this.f3719C.m6156a(fragment);
    }

    public MenuInflater getMenuInflater() {
        MenuInflater c = this.f3719C.m6175c();
        return c != null ? c : super.getMenuInflater();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = super.onCreateView(str, context, attributeSet);
        if (onCreateView != null || this.f3717A == null) {
            return onCreateView;
        }
        return this.f3717A.onCreateView(str, context, attributeSet);
    }

    public void setContentView(int i) {
        TracerDetour.a("setContentView(%s)", getResources().getResourceName(i), -889737807);
        LoomLogger.a(LoomLoggerDetour.a(996011171), "setContentView", getResources().getResourceName(i));
        try {
            if (!this.f3719C.m6171b(i)) {
                super.setContentView(i);
            }
            TracerDetour.a(624034688);
        } catch (Throwable th) {
            TracerDetour.a(1309554827);
        }
    }

    public void setContentView(View view) {
        if (!this.f3719C.m6164a(view)) {
            super.setContentView(view);
        }
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (!this.f3719C.m6165a(view, layoutParams)) {
            super.setContentView(view, layoutParams);
        }
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        if (!this.f3719C.m6173b(view, layoutParams)) {
            super.addContentView(view, layoutParams);
        }
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f3719C.m6159a(charSequence, i);
    }

    private FbActivitySuper mo800m() {
        return new C02141(this);
    }

    public final <T> T mo817a(Class<? extends T> cls) {
        return mo2566b((Class) cls);
    }

    protected <T> T mo2566b(Class<? extends T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    private void mo813p() {
        boolean z;
        if (VERSION.SDK_INT < 11 || !BuildConstants.i) {
            z = false;
        } else {
            z = true;
        }
        this.f3730y = z;
        if (this.f3730y) {
            this.f3729x = "dumpsys activity " + getClass().getSimpleName();
            this.f3731z = new C02152(this);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.f3718B != null) {
            ActivityRuntimePermissionsManager.a(this.f3718B.f3759a, i, strArr, iArr);
        }
    }
}
