package com.facebook.ui.images.fetch;

import com.facebook.ui.images.fetch.DefaultFetchImageHandler.DownloadResultCode;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: secondary_upload_message */
class DefaultFetchImageHandler$DownloadResultContainer {
    public final FetchedImage f5100a;
    public final DownloadResultCode f5101b;

    public DefaultFetchImageHandler$DownloadResultContainer(FetchedImage fetchedImage, DownloadResultCode downloadResultCode) {
        this.f5100a = (FetchedImage) Preconditions.checkNotNull(fetchedImage);
        this.f5101b = (DownloadResultCode) Preconditions.checkNotNull(downloadResultCode);
    }
}
