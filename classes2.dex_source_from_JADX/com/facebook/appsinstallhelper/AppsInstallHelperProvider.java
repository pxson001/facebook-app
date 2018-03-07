package com.facebook.appsinstallhelper;

import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.content.AppInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: impression_count */
public class AppsInstallHelperProvider extends AbstractAssistedProvider<AppsInstallHelper> {
    public final AppsInstallHelper m27972a(AppsInstallInfo appsInstallInfo) {
        return new AppsInstallHelper(DefaultSecureContextHelper.m4636a((InjectorLike) this), GooglePlayIntentHelper.m22732b((InjectorLike) this), AppInfo.m8674a(this), appsInstallInfo);
    }
}
