package com.facebook.saved.intentfilter;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved.intentfilter.experiments.ExperimentsForSavedIntentFilterModule;
import javax.inject.Inject;

/* compiled from: local_contact_id */
public class ExternalSaveActivity$InitOnBoot implements INeedInit {
    private final PackageManager f9209a;
    private final String f9210b;
    private final QeAccessor f9211c;

    public static ExternalSaveActivity$InitOnBoot m9554b(InjectorLike injectorLike) {
        return new ExternalSaveActivity$InitOnBoot(PackageManagerMethodAutoProvider.a(injectorLike), String_PackageNameMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public static ExternalSaveActivity$InitOnBoot m9553a(InjectorLike injectorLike) {
        return m9554b(injectorLike);
    }

    @Inject
    public ExternalSaveActivity$InitOnBoot(PackageManager packageManager, String str, QeAccessor qeAccessor) {
        this.f9209a = packageManager;
        this.f9210b = str;
        this.f9211c = qeAccessor;
    }

    public void init() {
        this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.SaveIconSaveToFacebookAlias"), 2, 1);
        this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.SaveIconSavePrivatelyAlias"), 2, 1);
        this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.FacebookIconSaveForLaterAlias"), 2, 1);
        this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.FacebookIconSavePrivatelyAlias"), 2, 1);
        String a = this.f9211c.a(Liveness.Live, ExperimentsForSavedIntentFilterModule.f11397a, null);
        String a2 = this.f9211c.a(Liveness.Live, ExperimentsForSavedIntentFilterModule.f11398b, null);
        if (a != null && a2 != null) {
            if (a.equals("facebook")) {
                if (a2.equals("save_for_later")) {
                    this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.FacebookIconSaveForLaterAlias"), 1, 1);
                } else if (a2.equals("save_privately")) {
                    this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.FacebookIconSavePrivatelyAlias"), 1, 1);
                }
            } else if (!a.equals("save")) {
            } else {
                if (a2.equals("save_to_facebook")) {
                    this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.SaveIconSaveToFacebookAlias"), 1, 1);
                } else if (a2.equals("save_privately")) {
                    this.f9209a.setComponentEnabledSetting(new ComponentName(this.f9210b, "com.facebook.saved.intentfilter.SaveIconSavePrivatelyAlias"), 1, 1);
                }
            }
        }
    }
}
