package com.facebook.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.inject.FbInjector;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: suggest_intent_extra_data */
public class FbFragmentActivityDelegate implements FragmentManagerHost {
    public Activity f2419a;
    public FbFragmentActivityLike f2420b;

    /* compiled from: suggest_intent_extra_data */
    public class C01571 implements FbFragmentActivityLike {
        final /* synthetic */ FbFragmentActivityDelegate f2418a;

        public C01571(FbFragmentActivityDelegate fbFragmentActivityDelegate) {
            this.f2418a = fbFragmentActivityDelegate;
        }

        public final void mo515a(@Nullable Bundle bundle) {
            this.f2418a.f2420b.mo515a(bundle);
        }

        public final void mo531b(@Nullable Bundle bundle) {
            this.f2418a.m3496b(bundle);
        }

        public final void mo538c(@Nullable Bundle bundle) {
            this.f2418a.m3500c(bundle);
        }

        public final void mo507a() {
            this.f2418a.m3503f();
        }

        public final void mo512a(Intent intent) {
            this.f2418a.m3493a(intent);
        }

        public final void mo529b() {
            this.f2418a.m3504g();
        }

        @TargetApi(14)
        public final void mo508a(int i) {
            this.f2418a.f2420b.mo508a(i);
        }

        public final void mo536c() {
            this.f2418a.f2420b.mo536c();
        }

        public final void mo540d() {
            this.f2418a.m3505i();
        }

        public final void mo542e() {
            this.f2418a.m3506j();
        }

        public final void mo544f() {
            this.f2418a.f2420b.mo544f();
        }

        public final void mo546g() {
            this.f2418a.f2420b.mo546g();
        }

        public final void mo547h() {
            this.f2418a.m3507m();
        }

        public final boolean mo526a(MotionEvent motionEvent) {
            return this.f2418a.f2420b.mo526a(motionEvent);
        }

        public final void mo548i() {
            this.f2418a.f2420b.mo548i();
        }

        public final boolean mo527a(Throwable th) {
            return this.f2418a.f2420b.mo527a(th);
        }

        public final boolean mo549j() {
            return this.f2418a.f2420b.mo549j();
        }

        public final boolean mo522a(int i, KeyEvent keyEvent) {
            return this.f2418a.f2420b.mo522a(i, keyEvent);
        }

        public final boolean mo532b(int i, KeyEvent keyEvent) {
            return this.f2418a.m3497b(i, keyEvent);
        }

        public final void mo550k() {
            this.f2418a.m3508p();
        }

        public final void mo551l() {
            this.f2418a.f2420b.mo551l();
        }

        public final Dialog mo528b(int i) {
            return this.f2418a.f2420b.mo528b(i);
        }

        public final void mo510a(int i, Dialog dialog) {
            this.f2418a.f2420b.mo510a(i, dialog);
        }

        public final void mo552m() {
            this.f2418a.m3509r();
        }

        public final void mo514a(Configuration configuration) {
            this.f2418a.m3495a(configuration);
        }

        public final FbInjector mo553n() {
            return this.f2418a.f2420b.mo553n();
        }

        public final <T extends View> T mo535c(int i) {
            return this.f2418a.m3498c(i);
        }

        public final Set<ActivityListener> mo554o() {
            return this.f2418a.f2420b.mo554o();
        }

        public final void mo519a(AbstractListenableDisposable abstractListenableDisposable) {
            this.f2418a.f2420b.mo519a(abstractListenableDisposable);
        }

        public final View mo539d(int i) {
            return this.f2418a.f2420b.mo539d(i);
        }

        public final boolean mo524a(Menu menu) {
            return this.f2418a.f2420b.mo524a(menu);
        }

        public final boolean mo533b(Menu menu) {
            return this.f2418a.f2420b.mo533b(menu);
        }

        public final boolean mo525a(MenuItem menuItem) {
            return this.f2418a.f2420b.mo525a(menuItem);
        }

        public final void mo555p() {
            this.f2418a.gE_();
        }

        public final void mo520a(Object obj, Object obj2) {
            this.f2418a.f2420b.mo520a(obj, obj2);
        }

        public final Object mo506a(Object obj) {
            return this.f2418a.f2420b.mo506a(obj);
        }

        public final void mo556q() {
            this.f2418a.f2420b.mo556q();
        }

        public final FragmentManager mo557r() {
            return this.f2418a.kO_();
        }

        public final void mo516a(Fragment fragment) {
            this.f2418a.f2420b.mo516a(fragment);
        }

        public final void mo541d(Bundle bundle) {
            this.f2418a.m3501d(bundle);
        }

        public final void mo521a(boolean z) {
            this.f2418a.f2420b.mo521a(z);
        }

        public final void mo518a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            this.f2418a.f2420b.mo518a(contextMenu, view, contextMenuInfo);
        }

        public final boolean mo534b(MenuItem menuItem) {
            return this.f2418a.f2420b.mo534b(menuItem);
        }

        public final boolean mo523a(KeyEvent keyEvent) {
            return this.f2418a.f2420b.mo523a(keyEvent);
        }

        public final Window mo558s() {
            return this.f2418a.m3510v();
        }

        public final void mo543e(int i) {
            this.f2418a.m3502e(i);
        }

        public final Intent mo559t() {
            return this.f2418a.m3511w();
        }

        public final void mo530b(Intent intent) {
            this.f2418a.f2420b.mo530b(intent);
        }

        public final Resources mo560u() {
            return this.f2418a.m3512x();
        }

        public final void mo537c(Intent intent) {
            this.f2418a.m3499c(intent);
        }

        public final void mo545f(int i) {
            this.f2418a.f2420b.mo545f(i);
        }

        public final MenuInflater mo561v() {
            return this.f2418a.f2420b.mo561v();
        }

        public final boolean mo562w() {
            return this.f2418a.f2420b.mo562w();
        }

        public final void m3445a(ActivityListener activityListener) {
            this.f2418a.f2420b.a(activityListener);
        }

        public final void m3459b(ActivityListener activityListener) {
            this.f2418a.f2420b.b(activityListener);
        }

        public final void mo511a(Activity activity) {
            this.f2418a.f2420b.mo511a(activity);
        }

        public final void mo517a(Fragment fragment, Intent intent, int i) {
            this.f2418a.f2420b.mo517a(fragment, intent, i);
        }

        public final void mo513a(Intent intent, int i) {
            this.f2418a.m3494a(intent, i);
        }

        public final void mo509a(int i, int i2, Intent intent) {
            this.f2418a.m3492a(i, i2, intent);
        }

        public final <T> T mo505a(Class<? extends T> cls) {
            return this.f2418a.m3491a((Class) cls);
        }
    }

    protected final Activity mZ_() {
        return this.f2419a;
    }

    protected void m3496b(@Nullable Bundle bundle) {
        this.f2420b.mo531b(bundle);
    }

    protected void m3500c(@Nullable Bundle bundle) {
        this.f2420b.mo538c(bundle);
    }

    protected void m3503f() {
        this.f2420b.mo507a();
    }

    protected void m3493a(Intent intent) {
        this.f2420b.mo512a(intent);
    }

    protected void m3504g() {
        this.f2420b.mo529b();
    }

    protected void m3505i() {
        this.f2420b.mo540d();
    }

    protected void m3506j() {
        this.f2420b.mo542e();
    }

    protected void m3507m() {
        this.f2420b.mo547h();
    }

    public boolean m3497b(int i, KeyEvent keyEvent) {
        return this.f2420b.mo532b(i, keyEvent);
    }

    public void m3508p() {
        this.f2420b.mo550k();
    }

    public void m3509r() {
        this.f2420b.mo552m();
    }

    public void m3495a(Configuration configuration) {
        this.f2420b.mo514a(configuration);
    }

    protected final <T extends View> T m3498c(int i) {
        return this.f2420b.mo535c(i);
    }

    public final void gE_() {
        this.f2420b.mo555p();
    }

    public final FragmentManager kO_() {
        return this.f2420b.mo557r();
    }

    protected void m3501d(Bundle bundle) {
        this.f2420b.mo541d(bundle);
    }

    public final Window m3510v() {
        return this.f2420b.mo558s();
    }

    public void m3502e(int i) {
        this.f2420b.mo543e(i);
    }

    public final Intent m3511w() {
        return this.f2420b.mo559t();
    }

    public final Resources m3512x() {
        return this.f2420b.mo560u();
    }

    public void m3499c(Intent intent) {
        this.f2420b.mo537c(intent);
    }

    public void m3494a(Intent intent, int i) {
        this.f2420b.mo513a(intent, i);
    }

    protected void m3492a(int i, int i2, Intent intent) {
        this.f2420b.mo509a(i, i2, intent);
    }

    protected final <T> T m3491a(Class<? extends T> cls) {
        return cls.isInstance(this) ? this : this.f2420b.mo505a((Class) cls);
    }
}
