package com.facebook.stickers.data;

import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.google.common.io.Closeables;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* compiled from: employer_hub_id */
class StickerAssetDownloader$1 implements DownloadResultResponseHandler<Void> {
    final /* synthetic */ File f16487a;
    final /* synthetic */ StickerAssetDownloader f16488b;

    StickerAssetDownloader$1(StickerAssetDownloader stickerAssetDownloader, File file) {
        this.f16488b = stickerAssetDownloader;
        this.f16487a = file;
    }

    public final Object m23956a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
        Closeable fileOutputStream = new FileOutputStream(this.f16487a);
        try {
            this.f16488b.d.a(inputStream, fileOutputStream);
            return null;
        } finally {
            Closeables.a(fileOutputStream, true);
        }
    }
}
