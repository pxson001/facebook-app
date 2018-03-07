package com.facebook.ipc.creativecam;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment;
import com.facebook.productionprompts.logging.PromptAnalytics;

/* compiled from: mqtt-mini.facebook.com */
public interface CreativeCamLauncher {
    CreativeEditingCameraFragment mo2609a(CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics);

    void mo2610a(Activity activity, int i, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics);

    void mo2611a(Fragment fragment, int i, CreativeCamLaunchConfig creativeCamLaunchConfig, String str, @Nullable PromptAnalytics promptAnalytics);
}
