package com.facebook.base.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.AbstractFragmentHost;
import android.support.v4.app.ActivityFragmentHost;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.activitylistener.FbActivityListener;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.common.dispose.DisposableContext;
import com.facebook.common.dispose.DisposableContextHelper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Optional;

/* compiled from: treehouse_basic_model */
public class FbPreferenceActivity extends PreferenceActivity implements FbServiceAwareActivity, DisposableContext, PropertyBag {
    private final PropertyBagHelper f1680a = new PropertyBagHelper();
    private ActivityFragmentHost f1681b;
    public DisposableContextHelper f1682c;
    public FbActivityListenerDispatcher f1683d;
    public FbActivitySuper f1684e;
    public FbResources f1685f;

    /* compiled from: treehouse_basic_model */
    public class C01581 implements FbActivitySuper {
        final /* synthetic */ FbPreferenceActivity f2421a;

        public C01581(FbPreferenceActivity fbPreferenceActivity) {
            this.f2421a = fbPreferenceActivity;
        }

        public final boolean m3514a(int i, MenuItem menuItem) {
            return super.onMenuItemSelected(i, menuItem);
        }

        public final void m3513a() {
        }
    }

    public static void m2263a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FbPreferenceActivity fbPreferenceActivity = (FbPreferenceActivity) obj;
        DisposableContextHelper b = DisposableContextHelper.b(fbInjector);
        FbResources fbResources = (FbResources) DownloadedFbResources.a(fbInjector);
        FbActivityListenerDispatcher b2 = FbActivityListenerDispatcher.b(fbInjector);
        fbPreferenceActivity.f1685f = fbResources;
        fbPreferenceActivity.f1682c = b;
        fbPreferenceActivity.f1683d = b2;
    }

    public final void m2268a(FbActivityListener fbActivityListener) {
        this.f1683d.a(fbActivityListener);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Class cls = FbPreferenceActivity.class;
        m2263a((Object) this, (Context) this);
    }

    protected final void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 689103318);
        Intent intent = getIntent();
        intent.putExtra(":android:show_fragment", null);
        setIntent(intent);
        FbActivityListenerDispatcher fbActivityListenerDispatcher = this.f1683d;
        if (this.f1684e == null) {
            this.f1684e = new C01581(this);
        }
        fbActivityListenerDispatcher.a(this, this.f1684e);
        this.f1681b = new ActivityFragmentHost(this);
        mo1282a(bundle);
        if (isFinishing()) {
            super.onCreate(bundle);
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 753717706, a);
            return;
        }
        Object obj = null;
        this.f1683d.a(bundle);
        if (isFinishing()) {
            obj = 1;
        }
        super.onCreate(bundle);
        if (obj != null) {
            LogUtils.c(-1905956429, a);
            return;
        }
        AbstractFragmentHost abstractFragmentHost = this.f1681b;
        if (bundle != null) {
            abstractFragmentHost.f20b.a(bundle.getParcelable("android:support:fragments"), null);
        }
        abstractFragmentHost.f20b.m();
        m2272b(bundle);
        this.f1683d.b(bundle);
        if (isFinishing()) {
            LogUtils.c(-1002313036, a);
            return;
        }
        mo472c(bundle);
        this.f1683d.d();
        this.f1681b.f20b.n();
        LogUtils.c(216010201, a);
    }

    protected boolean isValidFragment(String str) {
        return true;
    }

    protected void mo1282a(Bundle bundle) {
    }

    protected void m2272b(Bundle bundle) {
    }

    protected void mo472c(Bundle bundle) {
    }

    public Resources getResources() {
        return this.f1685f;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.f1683d.d(bundle);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1690842579);
        super.onStart();
        this.f1681b.f20b.o();
        this.f1683d.e();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 353587423, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1258402420);
        super.onStop();
        this.f1681b.f20b.r();
        this.f1683d.f();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -544256611, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2049975918);
        super.onPause();
        this.f1681b.f20b.q();
        this.f1683d.g();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1415052601, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -816112255);
        super.onResume();
        this.f1681b.m40c();
        this.f1683d.h();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 2010115180, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1726503207);
        try {
            this.f1682c.a();
            this.f1681b.m41f();
            this.f1683d.j();
        } finally {
            super.onDestroy();
            LogUtils.c(195450378, a);
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        this.f1683d.k();
    }

    public Object onRetainNonConfigurationInstance() {
        return null;
    }

    public final boolean m2271a(Throwable th) {
        return this.f1683d.a(th);
    }

    public boolean onSearchRequested() {
        Optional l = this.f1683d.l();
        if (l.isPresent()) {
            return ((Boolean) l.get()).booleanValue();
        }
        return super.onSearchRequested();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Optional a = this.f1683d.a(i, keyEvent);
        if (a.isPresent()) {
            return ((Boolean) a.get()).booleanValue();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Optional b = this.f1683d.b(i, keyEvent);
        if (b.isPresent()) {
            return ((Boolean) b.get()).booleanValue();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void m2269a(AbstractListenableDisposable abstractListenableDisposable) {
        this.f1682c.a(abstractListenableDisposable);
    }

    public void finish() {
        super.finish();
        this.f1683d.m();
    }

    public void onContentChanged() {
        super.onContentChanged();
        this.f1683d.n();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f1683d.a(z);
    }

    protected Dialog onCreateDialog(int i) {
        Dialog c = this.f1683d.c(i);
        return c != null ? c : super.onCreateDialog(i);
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        if (!this.f1683d.a(i, dialog)) {
            super.onPrepareDialog(i, dialog);
        }
    }

    public void onBackPressed() {
        if (!this.f1683d.o()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1683d.a(configuration);
    }

    protected final <T extends View> T m2265a(int i) {
        return FindViewUtil.b(this, i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f1683d.a(menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.f1683d.b(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f1683d.a(menuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public View onCreatePanelView(int i) {
        Optional a = this.f1683d.a(i);
        if (a != null) {
            return (View) a.orNull();
        }
        return super.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        Optional a = this.f1683d.a(i, menu);
        if (a.isPresent()) {
            return ((Boolean) a.get()).booleanValue();
        }
        return super.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        Optional a = this.f1683d.a(i, view, menu);
        if (a.isPresent()) {
            return ((Boolean) a.get()).booleanValue();
        }
        return super.onPreparePanel(i, view, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Optional a = this.f1683d.a(i, menuItem);
        if (a.isPresent()) {
            return ((Boolean) a.get()).booleanValue();
        }
        return super.onMenuItemSelected(i, menuItem);
    }

    public final void m2270a(Object obj, Object obj2) {
        this.f1680a.a(obj, obj2);
    }

    public final Object m2266a(Object obj) {
        return this.f1680a.a(obj);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f1683d.a(i, i2, intent);
    }

    public MenuInflater getMenuInflater() {
        MenuInflater c = this.f1683d.c();
        return c != null ? c : super.getMenuInflater();
    }

    public void setContentView(int i) {
        if (!this.f1683d.b(i)) {
            super.setContentView(i);
        }
    }

    public void setContentView(View view) {
        if (!this.f1683d.a(view)) {
            super.setContentView(view);
        }
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (!this.f1683d.a(view, layoutParams)) {
            super.setContentView(view, layoutParams);
        }
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        if (!this.f1683d.b(view, layoutParams)) {
            super.addContentView(view, layoutParams);
        }
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f1683d.a(charSequence, i);
    }

    public final FragmentManager m2273c() {
        return this.f1681b.p();
    }
}
