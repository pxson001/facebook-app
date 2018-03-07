package com.facebook.rtc.assetdownloader;

import com.google.common.io.ByteStreams;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: audio_type */
class AssetDownloader$2 implements ResponseHandler<File> {
    final /* synthetic */ String f19211a;
    final /* synthetic */ AssetDownloader f19212b;

    AssetDownloader$2(AssetDownloader assetDownloader, String str) {
        this.f19212b = assetDownloader;
        this.f19211a = str;
    }

    public Object handleResponse(HttpResponse httpResponse) {
        Throwable th;
        OutputStream outputStream;
        InputStream inputStream;
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            return null;
        }
        try {
            InputStream content = httpResponse.getEntity().getContent();
            try {
                File c = AssetDownloader.c(this.f19212b, this.f19211a);
                OutputStream fileOutputStream = new FileOutputStream(c);
                try {
                    ByteStreams.a(content, fileOutputStream);
                    fileOutputStream.close();
                    if (content != null) {
                        content.close();
                    }
                    return c;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    inputStream = content;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                inputStream = content;
                th = th3;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th32) {
            inputStream = null;
            th = th32;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
