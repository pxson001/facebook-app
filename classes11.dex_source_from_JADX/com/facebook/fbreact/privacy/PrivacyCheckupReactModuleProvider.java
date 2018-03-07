package com.facebook.fbreact.privacy;

import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager;
import com.facebook.react.bridge.ReactApplicationContext;

/* compiled from: error serializing ComposerConfiguration */
public class PrivacyCheckupReactModuleProvider extends AbstractAssistedProvider<PrivacyCheckupReactModule> {
    public final PrivacyCheckupReactModule m8644a(ReactApplicationContext reactApplicationContext) {
        return new PrivacyCheckupReactModule(ViewerContextMethodAutoProvider.b(this), IDBackedPrivacyCheckupManager.m11319a((InjectorLike) this), (Clock) SystemClockMethodAutoProvider.a(this), (ComposerLauncher) ComposerLauncherImpl.a(this), reactApplicationContext);
    }
}
