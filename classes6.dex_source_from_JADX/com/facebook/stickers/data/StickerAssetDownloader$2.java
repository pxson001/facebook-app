package com.facebook.stickers.data;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.ui.images.fetch.ImageReferrer;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.google.common.collect.ImmutableList;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: employer_hub_id */
class StickerAssetDownloader$2 extends MediaDownloadRequest<Void> {
    final /* synthetic */ StickerAssetDownloader f16489a;

    StickerAssetDownloader$2(StickerAssetDownloader stickerAssetDownloader, Uri uri, DownloadResultResponseHandler downloadResultResponseHandler, FbHttpRequestCancelTrigger fbHttpRequestCancelTrigger, CallerContext callerContext) {
        this.f16489a = stickerAssetDownloader;
        super(uri, downloadResultResponseHandler, fbHttpRequestCancelTrigger, callerContext);
    }

    public final HttpUriRequest m23957a() {
        HttpUriRequest a = super.a();
        a.addHeader("Referer", new ImageReferrer(this.f16489a.e.c(), ImmutableList.of("sticker_pack_download")).a().toString());
        return a;
    }
}
