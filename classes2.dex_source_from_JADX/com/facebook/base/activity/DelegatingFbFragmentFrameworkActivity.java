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
import com.facebook.base.activity.FbFragmentActivityDelegate.1;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: my */
public class DelegatingFbFragmentFrameworkActivity extends FbFragmentActivity {
    private final FbFragmentActivityLike f13064p;

    public DelegatingFbFragmentFrameworkActivity(FbFragmentActivityDelegate fbFragmentActivityDelegate) {
        1 1 = new 1(this);
        fbFragmentActivityDelegate.a = this;
        fbFragmentActivityDelegate.b = 1;
        this.f13064p = new 1(fbFragmentActivityDelegate);
    }

    protected final void mo2564a(@Nullable Bundle bundle) {
        this.f13064p.a(bundle);
    }

    protected final void mo790b(@Nullable Bundle bundle) {
        this.f13064p.b(bundle);
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        this.f13064p.c(bundle);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -531876491);
        this.f13064p.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1137686555, a);
    }

    protected final void mo784a(Intent intent) {
        this.f13064p.a(intent);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -565756428);
        this.f13064p.b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -680968360, a);
    }

    @TargetApi(14)
    public void onTrimMemory(int i) {
        this.f13064p.a(i);
    }

    public void onLowMemory() {
        this.f13064p.c();
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -40861928);
        this.f13064p.d();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -779747833, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 279891343);
        this.f13064p.e();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 538970676, a);
    }

    protected final void hp_() {
        this.f13064p.g();
    }

    protected void onPostResume() {
        this.f13064p.f();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -467214278);
        this.f13064p.h();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -334973996, a);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f13064p.a(motionEvent);
    }

    public void onUserInteraction() {
        this.f13064p.i();
    }

    public final boolean mo823a(Throwable th) {
        return this.f13064p.a(th);
    }

    public boolean onSearchRequested() {
        return this.f13064p.j();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f13064p.a(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f13064p.b(i, keyEvent);
    }

    public void finish() {
        this.f13064p.k();
    }

    public void finishFromChild(Activity activity) {
        this.f13064p.a(activity);
    }

    public void onContentChanged() {
        this.f13064p.l();
    }

    protected Dialog onCreateDialog(int i) {
        return this.f13064p.b(i);
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        this.f13064p.a(i, dialog);
    }

    public void onBackPressed() {
        this.f13064p.m();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f13064p.a(configuration);
    }

    public final FbInjector hz_() {
        return this.f13064p.n();
    }

    protected final <T extends View> T mo2563a(int i) {
        return this.f13064p.c(i);
    }

    protected final Set<ActivityListener> hA_() {
        return this.f13064p.o();
    }

    public final void mo821a(AbstractListenableDisposable abstractListenableDisposable) {
        this.f13064p.a(abstractListenableDisposable);
    }

    public View onCreatePanelView(int i) {
        return this.f13064p.d(i);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return this.f13064p.a(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.f13064p.b(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.f13064p.a(menuItem);
    }

    public final void mo822a(Object obj, Object obj2) {
        this.f13064p.a(obj, obj2);
    }

    public final Object mo818a(Object obj) {
        return this.f13064p.a(obj);
    }

    public void onAttachedToWindow() {
        this.f13064p.q();
    }

    public final FragmentManager kO_() {
        return this.f13064p.r();
    }

    public final void mo819a(Fragment fragment) {
        this.f13064p.a(fragment);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.f13064p.d(bundle);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f13064p.a(z);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        this.f13064p.a(contextMenu, view, contextMenuInfo);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.f13064p.b(menuItem);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f13064p.a(keyEvent);
    }

    public Window getWindow() {
        return this.f13064p.s();
    }

    public void setContentView(int i) {
        this.f13064p.e(i);
    }

    public Intent getIntent() {
        return this.f13064p.t();
    }

    public void setIntent(Intent intent) {
        this.f13064p.b(intent);
    }

    public Resources getResources() {
        return this.f13064p.u();
    }

    public void startActivity(Intent intent) {
        this.f13064p.c(intent);
    }

    public void setRequestedOrientation(int i) {
        this.f13064p.f(i);
    }

    public MenuInflater getMenuInflater() {
        return this.f13064p.v();
    }

    public boolean hasWindowFocus() {
        return this.f13064p.w();
    }

    public final void mo2565a(Fragment fragment, Intent intent, int i) {
        this.f13064p.a(fragment, intent, i);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f13064p.a(intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f13064p.a(i, i2, intent);
    }

    protected final <T> T mo2566b(Class<? extends T> cls) {
        return this.f13064p.a(cls);
    }
}
