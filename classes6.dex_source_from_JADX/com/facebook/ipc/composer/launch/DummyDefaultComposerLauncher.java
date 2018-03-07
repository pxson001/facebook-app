package com.facebook.ipc.composer.launch;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;

/* compiled from: li */
public class DummyDefaultComposerLauncher implements ComposerLauncher {
    public static DummyDefaultComposerLauncher m18328a(InjectorLike injectorLike) {
        return new DummyDefaultComposerLauncher();
    }

    public final void m18333a(@Nullable String str, ComposerConfiguration composerConfiguration, Context context) {
        throw new RuntimeException("Method not implemented!");
    }

    public final void m18331a(@Nullable String str, ComposerConfiguration composerConfiguration, int i, Activity activity) {
        throw new RuntimeException("Method not implemented!");
    }

    public final void m18332a(@Nullable String str, ComposerConfiguration composerConfiguration, int i, Fragment fragment) {
        throw new RuntimeException("Method not implemented!");
    }

    public final void m18329a(int i, Activity activity) {
    }

    public final void m18330a(int i, Fragment fragment) {
    }
}
