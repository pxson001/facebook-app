package com.facebook.groups.react;

import android.app.Activity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.react.bridge.ReactContext;

/* compiled from: payment_pin_listening_controller_fragment_tag */
public class GroupComposerLauncherProvider extends AbstractAssistedProvider<GroupComposerLauncher> {
    public final GroupComposerLauncher m7313a(ReactContext reactContext, Activity activity) {
        return new GroupComposerLauncher(reactContext, activity, (ComposerLauncher) ComposerLauncherImpl.a(this), IdBasedLazy.a(this, 2371), IdBasedLazy.a(this, 5272), IdBasedSingletonScopeProvider.b(this, 3863), IdBasedLazy.a(this, 401), IdBasedSingletonScopeProvider.b(this, 576));
    }
}
