package com.facebook.inject.generated;

import android.content.ComponentName;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.ComponentName_InternalSettingsActivityMethodAutoProvider;
import com.facebook.katana.app.module.common.ComponentName_FragmentBaseActivityMethodAutoProvider;
import com.facebook.katana.app.module.common.ComponentName_FragmentChromeActivityMethodAutoProvider;
import com.facebook.katana.app.module.common.ComponentName_PostSplashScreenMethodAutoProvider;
import com.facebook.katana.app.module.common.ComponentName_ReactFragmentActivityMethodAutoProvider;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.login.ComponentName_LogoutActivityComponentMethodAutoProvider;
import com.facebook.katana.login.ComponentName_WorkOnboardingFlowComponentMethodAutoProvider;
import com.facebook.messaging.linkhandling.ComponentName_ForSecureIntentHandlerActivityMethodAutoProvider;
import com.facebook.messaging.shortcuts.ComponentName_ForIntentHandlerActivityMethodAutoProvider;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

/* compiled from: default_duration_for_boosted_post */
public class C0490x39ca9ed8 implements Provider<ComponentName> {
    public static ComponentName m10042a(InjectorLike injectorLike, Class<? extends Annotation> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1837613207:
                if (name.equals("com.facebook.common.init.PostSplashScreen")) {
                    return ComponentName_PostSplashScreenMethodAutoProvider.a(injectorLike);
                }
                break;
            case -1785148863:
                if (name.equals("com.facebook.base.activity.ReactFragmentActivity")) {
                    return ComponentName_ReactFragmentActivityMethodAutoProvider.b(injectorLike);
                }
                break;
            case -1534541214:
                if (name.equals("com.facebook.katana.login.LogoutActivityComponent")) {
                    return ComponentName_LogoutActivityComponentMethodAutoProvider.b(injectorLike);
                }
                break;
            case -1360399018:
                if (name.equals("com.facebook.base.activity.FragmentChromeActivity")) {
                    return ComponentName_FragmentChromeActivityMethodAutoProvider.b(injectorLike);
                }
                break;
            case -1121921021:
                if (name.equals("com.facebook.messaging.annotations.ForIntentHandlerActivity")) {
                    return ComponentName_ForIntentHandlerActivityMethodAutoProvider.b(injectorLike);
                }
                break;
            case -746326425:
                if (name.equals("com.facebook.katana.login.LoginActivityComponent")) {
                    return ComponentName_LoginActivityComponentMethodAutoProvider.b(injectorLike);
                }
                break;
            case -286271539:
                if (name.equals("com.facebook.bugreporter.annotations.InternalSettingsActivity")) {
                    return ComponentName_InternalSettingsActivityMethodAutoProvider.b(injectorLike);
                }
                break;
            case -38901267:
                if (name.equals("com.facebook.base.activity.FragmentBaseActivity")) {
                    return ComponentName_FragmentBaseActivityMethodAutoProvider.a(injectorLike);
                }
                break;
            case 1595042515:
                if (name.equals("com.facebook.groups.treehouse.constants.GroupsStartActivity")) {
                    return (ComponentName) null;
                }
                break;
            case 2026365921:
                if (name.equals("com.facebook.katana.login.WorkOnboardingFlowComponent")) {
                    return ComponentName_WorkOnboardingFlowComponentMethodAutoProvider.b(injectorLike);
                }
                break;
            case 2117042252:
                if (name.equals("com.facebook.messaging.annotations.ForSecureIntentHandlerActivity")) {
                    return ComponentName_ForSecureIntentHandlerActivityMethodAutoProvider.b(injectorLike);
                }
                break;
        }
        FbInjector.a(name);
        return null;
    }
}
