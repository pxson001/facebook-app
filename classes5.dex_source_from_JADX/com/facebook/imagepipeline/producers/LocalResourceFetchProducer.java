package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: TOPIC_MIDDLE_SCHOOL */
public class LocalResourceFetchProducer extends LocalFetchProducer {
    private final Resources f13790a;

    public LocalResourceFetchProducer(Executor executor, NativePooledByteBufferFactory nativePooledByteBufferFactory, Resources resources, boolean z) {
        super(executor, nativePooledByteBufferFactory, z);
        this.f13790a = resources;
    }

    protected final EncodedImage mo1275a(ImageRequest imageRequest) {
        return m23106b(this.f13790a.openRawResource(m23157c(imageRequest)), m23156b(imageRequest));
    }

    private int m23156b(ImageRequest imageRequest) {
        AssetFileDescriptor openRawResourceFd;
        Throwable th;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            openRawResourceFd = this.f13790a.openRawResourceFd(m23157c(imageRequest));
            try {
                int length = (int) openRawResourceFd.getLength();
                if (openRawResourceFd == null) {
                    return length;
                }
                try {
                    openRawResourceFd.close();
                    return length;
                } catch (IOException e) {
                    return length;
                }
            } catch (NotFoundException e2) {
                assetFileDescriptor = openRawResourceFd;
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e3) {
                    }
                }
                return -1;
            } catch (Throwable th2) {
                th = th2;
                if (openRawResourceFd != null) {
                    try {
                        openRawResourceFd.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (NotFoundException e5) {
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            return -1;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openRawResourceFd = null;
            th = th4;
            if (openRawResourceFd != null) {
                openRawResourceFd.close();
            }
            throw th;
        }
    }

    protected final String mo1276a() {
        return "LocalResourceFetchProducer";
    }

    private static int m23157c(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.c.getPath().substring(1));
    }
}
