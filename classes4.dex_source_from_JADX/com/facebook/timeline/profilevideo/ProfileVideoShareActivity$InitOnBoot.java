package com.facebook.timeline.profilevideo;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.ultralight.Inject;

/* compiled from: like_sentence */
public class ProfileVideoShareActivity$InitOnBoot implements INeedInit {
    private final QeAccessor f9359a;
    private final PackageManager f9360b;
    private final String f9361c;

    public static ProfileVideoShareActivity$InitOnBoot m9752b(InjectorLike injectorLike) {
        return new ProfileVideoShareActivity$InitOnBoot((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), String_PackageNameMethodAutoProvider.a(injectorLike));
    }

    public static ProfileVideoShareActivity$InitOnBoot m9751a(InjectorLike injectorLike) {
        return m9752b(injectorLike);
    }

    @Inject
    private ProfileVideoShareActivity$InitOnBoot(QeAccessor qeAccessor, PackageManager packageManager, String str) {
        this.f9359a = qeAccessor;
        this.f9360b = packageManager;
        this.f9361c = str;
    }

    public void init() {
        if (this.f9359a.a(ExperimentsForTimelineAbTestModule.f, false)) {
            this.f9360b.setComponentEnabledSetting(new ComponentName(this.f9361c, "com.facebook.timeline.profilevideo.ProfileVideoShareActivityAlias"), 1, 1);
        } else {
            this.f9360b.setComponentEnabledSetting(new ComponentName(this.f9361c, "com.facebook.timeline.profilevideo.ProfileVideoShareActivityAlias"), 2, 1);
        }
    }
}
