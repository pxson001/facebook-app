package com.facebook.ipc.creativecam;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment;
import com.facebook.productionprompts.logging.PromptAnalytics;

/* compiled from: place_unsave_error */
public class DummyDefaultCreativeCamLauncher implements CreativeCamLauncher {
    public static DummyDefaultCreativeCamLauncher m8047a(InjectorLike injectorLike) {
        return new DummyDefaultCreativeCamLauncher();
    }

    public final CreativeEditingCameraFragment m8048a(CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        throw new RuntimeException("Method not implemented!");
    }

    public final void m8049a(Activity activity, int i, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        throw new RuntimeException("Method not implemented!");
    }

    public final void m8050a(Fragment fragment, int i, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics) {
        throw new RuntimeException("Method not implemented!");
    }
}
