package com.facebook.assetdownload.debug;

import com.facebook.assetdownload.background.AssetDownloadConditionalWorker;
import com.facebook.assetdownload.local.DownloadLocalFileManager;
import com.facebook.assetdownload.local.DownloadLocalFileMapper;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.time.Clock;
import javax.inject.Inject;

/* compiled from: profile_picture_suggestions */
public class AssetDownloadDebugHelper {
    private final AssetDownloadConfigurationRepository f7310a;
    private final Clock f7311b;
    private final AssetDownloadConditionalWorker f7312c;
    private final DownloadLocalFileManager f7313d;
    private final DownloadLocalFileMapper f7314e;

    @Inject
    public AssetDownloadDebugHelper(AssetDownloadConfigurationRepository assetDownloadConfigurationRepository, Clock clock, AssetDownloadConditionalWorker assetDownloadConditionalWorker, DownloadLocalFileManager downloadLocalFileManager, DownloadLocalFileMapper downloadLocalFileMapper) {
        this.f7310a = assetDownloadConfigurationRepository;
        this.f7311b = clock;
        this.f7312c = assetDownloadConditionalWorker;
        this.f7313d = downloadLocalFileManager;
        this.f7314e = downloadLocalFileMapper;
    }
}
