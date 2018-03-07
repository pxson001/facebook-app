package com.facebook.ipc.composer.launch;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.facebook.ipc.composer.intent.ComposerConfiguration;

/* compiled from: physical_cell_id */
public interface ComposerLauncher {
    void mo1953a(int i, Activity activity);

    void mo1954a(int i, Fragment fragment);

    void mo1955a(@Nullable String str, ComposerConfiguration composerConfiguration, int i, Activity activity);

    void mo1956a(@Nullable String str, ComposerConfiguration composerConfiguration, int i, Fragment fragment);

    void mo1957a(@Nullable String str, ComposerConfiguration composerConfiguration, Context context);
}
