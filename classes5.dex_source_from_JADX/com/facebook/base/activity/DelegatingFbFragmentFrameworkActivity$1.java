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
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.inject.FbInjector;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: suggest_intent_query */
class DelegatingFbFragmentFrameworkActivity$1 implements FbFragmentActivityLike {
    final /* synthetic */ DelegatingFbFragmentFrameworkActivity f2417a;

    DelegatingFbFragmentFrameworkActivity$1(DelegatingFbFragmentFrameworkActivity delegatingFbFragmentFrameworkActivity) {
        this.f2417a = delegatingFbFragmentFrameworkActivity;
    }

    public final void mo515a(@Nullable Bundle bundle) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, bundle);
    }

    public final void mo531b(@Nullable Bundle bundle) {
        DelegatingFbFragmentFrameworkActivity.b(this.f2417a, bundle);
    }

    public final void mo538c(@Nullable Bundle bundle) {
        DelegatingFbFragmentFrameworkActivity.c(this.f2417a, bundle);
    }

    public final void mo507a() {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a);
    }

    public final void mo512a(Intent intent) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, intent);
    }

    public final void mo529b() {
        DelegatingFbFragmentFrameworkActivity.b(this.f2417a);
    }

    @TargetApi(14)
    public final void mo508a(int i) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, i);
    }

    public final void mo536c() {
        DelegatingFbFragmentFrameworkActivity.c(this.f2417a);
    }

    public final void mo540d() {
        DelegatingFbFragmentFrameworkActivity.d(this.f2417a);
    }

    public final void mo542e() {
        DelegatingFbFragmentFrameworkActivity.e(this.f2417a);
    }

    public final void mo544f() {
        DelegatingFbFragmentFrameworkActivity.f(this.f2417a);
    }

    public final void mo546g() {
        DelegatingFbFragmentFrameworkActivity.g(this.f2417a);
    }

    public final void mo547h() {
        DelegatingFbFragmentFrameworkActivity.h(this.f2417a);
    }

    public final boolean mo526a(MotionEvent motionEvent) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, motionEvent);
    }

    public final void mo548i() {
        DelegatingFbFragmentFrameworkActivity.i(this.f2417a);
    }

    public final boolean mo527a(Throwable th) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, th);
    }

    public final boolean mo549j() {
        return DelegatingFbFragmentFrameworkActivity.j(this.f2417a);
    }

    public final boolean mo522a(int i, KeyEvent keyEvent) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, i, keyEvent);
    }

    public final boolean mo532b(int i, KeyEvent keyEvent) {
        return DelegatingFbFragmentFrameworkActivity.b(this.f2417a, i, keyEvent);
    }

    public final void mo550k() {
        DelegatingFbFragmentFrameworkActivity.k(this.f2417a);
    }

    public final void mo551l() {
        DelegatingFbFragmentFrameworkActivity.l(this.f2417a);
    }

    public final Dialog mo528b(int i) {
        return DelegatingFbFragmentFrameworkActivity.b(this.f2417a, i);
    }

    public final void mo510a(int i, Dialog dialog) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, i, dialog);
    }

    public final void mo552m() {
        DelegatingFbFragmentFrameworkActivity.m(this.f2417a);
    }

    public final void mo514a(Configuration configuration) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, configuration);
    }

    public final FbInjector mo553n() {
        return DelegatingFbFragmentFrameworkActivity.n(this.f2417a);
    }

    public final <T extends View> T mo535c(int i) {
        return DelegatingFbFragmentFrameworkActivity.c(this.f2417a, i);
    }

    public final Set<ActivityListener> mo554o() {
        return DelegatingFbFragmentFrameworkActivity.o(this.f2417a);
    }

    public final void mo519a(AbstractListenableDisposable abstractListenableDisposable) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, abstractListenableDisposable);
    }

    public final View mo539d(int i) {
        return DelegatingFbFragmentFrameworkActivity.d(this.f2417a, i);
    }

    public final boolean mo524a(Menu menu) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, menu);
    }

    public final boolean mo533b(Menu menu) {
        return DelegatingFbFragmentFrameworkActivity.b(this.f2417a, menu);
    }

    public final boolean mo525a(MenuItem menuItem) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, menuItem);
    }

    public final void mo555p() {
        DelegatingFbFragmentFrameworkActivity.p(this.f2417a);
    }

    public final void mo520a(Object obj, Object obj2) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, obj, obj2);
    }

    public final Object mo506a(Object obj) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, obj);
    }

    public final void mo556q() {
        DelegatingFbFragmentFrameworkActivity.q(this.f2417a);
    }

    public final FragmentManager mo557r() {
        return DelegatingFbFragmentFrameworkActivity.r(this.f2417a);
    }

    public final void mo516a(Fragment fragment) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, fragment);
    }

    public final void mo541d(Bundle bundle) {
        DelegatingFbFragmentFrameworkActivity.d(this.f2417a, bundle);
    }

    public final void mo521a(boolean z) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, z);
    }

    public final void mo518a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, contextMenu, view, contextMenuInfo);
    }

    public final boolean mo534b(MenuItem menuItem) {
        return DelegatingFbFragmentFrameworkActivity.b(this.f2417a, menuItem);
    }

    public final boolean mo523a(KeyEvent keyEvent) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, keyEvent);
    }

    public final Window mo558s() {
        return DelegatingFbFragmentFrameworkActivity.s(this.f2417a);
    }

    public final void mo543e(int i) {
        DelegatingFbFragmentFrameworkActivity.e(this.f2417a, i);
    }

    public final Intent mo559t() {
        return DelegatingFbFragmentFrameworkActivity.t(this.f2417a);
    }

    public final void mo530b(Intent intent) {
        DelegatingFbFragmentFrameworkActivity.b(this.f2417a, intent);
    }

    public final Resources mo560u() {
        return DelegatingFbFragmentFrameworkActivity.u(this.f2417a);
    }

    public final void mo537c(Intent intent) {
        DelegatingFbFragmentFrameworkActivity.c(this.f2417a, intent);
    }

    public final void mo545f(int i) {
        DelegatingFbFragmentFrameworkActivity.f(this.f2417a, i);
    }

    public final MenuInflater mo561v() {
        return DelegatingFbFragmentFrameworkActivity.v(this.f2417a);
    }

    public final boolean mo562w() {
        return DelegatingFbFragmentFrameworkActivity.w(this.f2417a);
    }

    public final void m3385a(ActivityListener activityListener) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, activityListener);
    }

    public final void m3399b(ActivityListener activityListener) {
        DelegatingFbFragmentFrameworkActivity.b(this.f2417a, activityListener);
    }

    public final void mo511a(Activity activity) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, activity);
    }

    public final void mo517a(Fragment fragment, Intent intent, int i) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, fragment, intent, i);
    }

    public final void mo513a(Intent intent, int i) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, intent, i);
    }

    public final void mo509a(int i, int i2, Intent intent) {
        DelegatingFbFragmentFrameworkActivity.a(this.f2417a, i, i2, intent);
    }

    public final <T> T mo505a(Class<? extends T> cls) {
        return DelegatingFbFragmentFrameworkActivity.a(this.f2417a, cls);
    }
}
