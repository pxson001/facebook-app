package com.facebook.backstage.consumption;

import android.os.Bundle;
import com.facebook.backstage.consumption.BackstageNavigatorImpl.C04391;
import com.google.common.base.Strings;

/* compiled from: saved_privacy */
public class BackstageNavigatorApi {
    private static BackstageNavigatorApi f4517a;
    private C04391 f4518b;
    public NavigationState f4519c = null;
    public NavigationState f4520d = null;
    public NavigationState f4521e = null;
    public NavigationState f4522f = null;

    /* compiled from: saved_privacy */
    public enum Action {
        NONE,
        REFRESH
    }

    /* compiled from: saved_privacy */
    public enum NavigationState {
        COLD_START,
        NUX,
        MAIN_LIST,
        CAMERA,
        TEXT_ONLY,
        IMPORT,
        AUDIENCE_CONTROL,
        REPLY
    }

    private BackstageNavigatorApi() {
    }

    public static BackstageNavigatorApi m4489a() {
        if (f4517a == null) {
            f4517a = new BackstageNavigatorApi();
        }
        return f4517a;
    }

    public final void m4494a(C04391 c04391) {
        this.f4518b = c04391;
        if (this.f4519c != null && this.f4520d != null) {
            m4491b(this.f4519c, this.f4520d, Action.NONE);
        }
    }

    public final void m4492a(NavigationState navigationState, NavigationState navigationState2) {
        m4491b(navigationState, navigationState2, Action.NONE);
    }

    public final void m4493a(NavigationState navigationState, NavigationState navigationState2, Action action) {
        m4491b(navigationState, navigationState2, action);
    }

    private void m4491b(NavigationState navigationState, NavigationState navigationState2, Action action) {
        this.f4521e = navigationState;
        this.f4522f = navigationState2;
        if (this.f4518b == null) {
            this.f4519c = navigationState;
            this.f4520d = navigationState2;
            return;
        }
        this.f4519c = null;
        this.f4520d = null;
        BackstageNavigatorImpl.m4495a(this.f4518b.f4523a, navigationState, navigationState2, action);
    }

    public static NavigationState m4490b(Bundle bundle) {
        String string = bundle.getString("NAVIGATION_RECORDING_KEY");
        if (Strings.isNullOrEmpty(string)) {
            return NavigationState.MAIN_LIST;
        }
        return (NavigationState) Enum.valueOf(NavigationState.class, string);
    }
}
