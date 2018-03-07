package com.facebook.rtc.assetdownloader;

import com.facebook.common.callercontext.CallerContext;

/* compiled from: audio_type */
class AssetDownloader$1 implements Runnable {
    final /* synthetic */ String f19207a;
    final /* synthetic */ DownloadListener f19208b;
    final /* synthetic */ CallerContext f19209c;
    final /* synthetic */ AssetDownloader f19210d;

    AssetDownloader$1(AssetDownloader assetDownloader, String str, DownloadListener downloadListener, CallerContext callerContext) {
        this.f19210d = assetDownloader;
        this.f19207a = str;
        this.f19208b = downloadListener;
        this.f19209c = callerContext;
    }

    public void run() {
        AssetDownloader.b(this.f19210d, this.f19207a, this.f19208b, this.f19209c);
    }
}
