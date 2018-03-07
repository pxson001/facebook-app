package com.facebook.selfupdate;

import com.facebook.appupdate.SelfUpdateLauncher;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: raw_name */
public class SelfUpdateLauncherMethodAutoProvider extends AbstractProvider<SelfUpdateLauncher> {
    public static SelfUpdateLauncher m12739b(InjectorLike injectorLike) {
        return SelfUpdateModule.m12759a(AppUpdateInjectorMethodAutoProvider.m12740a(injectorLike));
    }

    public Object get() {
        return SelfUpdateModule.m12759a(AppUpdateInjectorMethodAutoProvider.m12740a(this));
    }

    public static SelfUpdateLauncher m12738a(InjectorLike injectorLike) {
        return m12739b(injectorLike);
    }
}
