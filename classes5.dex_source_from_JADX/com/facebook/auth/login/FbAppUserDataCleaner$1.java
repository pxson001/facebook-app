package com.facebook.auth.login;

import com.facebook.auth.privacy.IHaveUserData;

/* compiled from: sysdump */
public class FbAppUserDataCleaner$1 {
    final /* synthetic */ IHaveUserData f2292a;
    final /* synthetic */ FbAppUserDataCleaner f2293b;

    FbAppUserDataCleaner$1(FbAppUserDataCleaner fbAppUserDataCleaner, IHaveUserData iHaveUserData) {
        this.f2293b = fbAppUserDataCleaner;
        this.f2292a = iHaveUserData;
    }

    public final void m3185a() {
        this.f2292a.clearUserData();
    }
}
