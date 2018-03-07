package com.facebook.assetdownload.remote;

import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.google.common.base.Preconditions;
import java.io.File;

/* compiled from: profile_photo_prompt_dismissed */
public class DownloadExecutionRequest {
    public final AssetDownloadConfiguration f7337a;
    private final File f7338b;

    public DownloadExecutionRequest(AssetDownloadConfiguration assetDownloadConfiguration, File file) {
        Preconditions.checkNotNull(assetDownloadConfiguration, "assetDownloadConfiguration must not be null");
        Preconditions.checkNotNull(assetDownloadConfiguration.m10373a(), "assetDownloadConfiguration.getSource() must not return null");
        Preconditions.checkNotNull(file, "destination must not be null");
        this.f7337a = assetDownloadConfiguration;
        this.f7338b = file;
    }

    public final File m10442b() {
        return this.f7338b;
    }

    public final String m10443d() {
        return this.f7337a.mAnalyticsTag;
    }
}
