package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: TOPIC_OTHER */
public class LocalAssetFetchProducer extends LocalFetchProducer {
    private final AssetManager f13768a;

    public LocalAssetFetchProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, AssetManager assetManager, boolean z) {
        super(executor, nativePooledByteBufferFactory, z);
        this.f13768a = assetManager;
    }

    protected final EncodedImage mo1275a(ImageRequest imageRequest) {
        return m23106b(this.f13768a.open(m23124c(imageRequest), 2), m23123b(imageRequest));
    }

    private int m23123b(ImageRequest imageRequest) {
        AssetFileDescriptor openFd;
        Throwable th;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            openFd = this.f13768a.openFd(m23124c(imageRequest));
            try {
                int length = (int) openFd.getLength();
                if (openFd == null) {
                    return length;
                }
                try {
                    openFd.close();
                    return length;
                } catch (IOException e) {
                    return length;
                }
            } catch (IOException e2) {
                assetFileDescriptor = openFd;
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e3) {
                    }
                }
                return -1;
            } catch (Throwable th2) {
                th = th2;
                if (openFd != null) {
                    try {
                        openFd.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            return -1;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openFd = null;
            th = th4;
            if (openFd != null) {
                openFd.close();
            }
            throw th;
        }
    }

    protected final String mo1276a() {
        return "LocalAssetFetchProducer";
    }

    private static String m23124c(ImageRequest imageRequest) {
        return imageRequest.c.getPath().substring(1);
    }
}
