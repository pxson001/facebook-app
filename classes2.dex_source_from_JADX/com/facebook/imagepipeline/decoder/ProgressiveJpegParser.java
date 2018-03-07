package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteArrayBufferedInputStream;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: mediaItemId */
public class ProgressiveJpegParser {
    private int f14616a = 0;
    private int f14617b = 0;
    private int f14618c = 0;
    private int f14619d = 0;
    public int f14620e = 0;
    public int f14621f = 0;
    private final GenericByteArrayPool f14622g;

    public ProgressiveJpegParser(GenericByteArrayPool genericByteArrayPool) {
        this.f14622g = (GenericByteArrayPool) Preconditions.a(genericByteArrayPool);
    }

    public final boolean m21037a(EncodedImage encodedImage) {
        if (this.f14616a == 6) {
            return false;
        }
        if (encodedImage.m15718h() <= this.f14618c) {
            return false;
        }
        InputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.m15711b(), (byte[]) this.f14622g.mo2018a(16384), this.f14622g);
        boolean a;
        try {
            StreamUtil.a(pooledByteArrayBufferedInputStream, (long) this.f14618c);
            a = m21035a(pooledByteArrayBufferedInputStream);
            return a;
        } catch (IOException e) {
            a = e;
            Throwables.m15700b(a);
            return false;
        } finally {
            Closeables.a(pooledByteArrayBufferedInputStream);
        }
    }

    private boolean m21035a(InputStream inputStream) {
        int i = this.f14620e;
        while (this.f14616a != 6) {
            try {
                int read = inputStream.read();
                if (read != -1) {
                    this.f14618c++;
                    switch (this.f14616a) {
                        case 0:
                            if (read != 255) {
                                this.f14616a = 6;
                                break;
                            }
                            this.f14616a = 1;
                            break;
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            if (read != 216) {
                                this.f14616a = 6;
                                break;
                            }
                            this.f14616a = 2;
                            break;
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            if (read == 255) {
                                this.f14616a = 3;
                                break;
                            }
                            break;
                        case 3:
                            if (read != 255) {
                                if (read != 0) {
                                    if (read == 218 || read == 217) {
                                        m21036b(this.f14618c - 2);
                                    }
                                    if (!m21034a(read)) {
                                        this.f14616a = 2;
                                        break;
                                    }
                                    this.f14616a = 4;
                                    break;
                                }
                                this.f14616a = 2;
                                break;
                            }
                            this.f14616a = 3;
                            break;
                        case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                            this.f14616a = 5;
                            break;
                        case 5:
                            int i2 = ((this.f14617b << 8) + read) - 2;
                            StreamUtil.a(inputStream, (long) i2);
                            this.f14618c = i2 + this.f14618c;
                            this.f14616a = 2;
                            break;
                        default:
                            Preconditions.b(false);
                            break;
                    }
                    this.f14617b = read;
                } else if (this.f14616a != 6 || this.f14620e == i) {
                    return false;
                } else {
                    return true;
                }
            } catch (Throwable e) {
                Throwables.m15700b(e);
            }
        }
        if (this.f14616a != 6) {
        }
        return false;
    }

    private static boolean m21034a(int i) {
        if (i == 1) {
            return false;
        }
        if ((i >= 208 && i <= 215) || i == 217 || i == 216) {
            return false;
        }
        return true;
    }

    private void m21036b(int i) {
        if (this.f14619d > 0) {
            this.f14621f = i;
        }
        int i2 = this.f14619d;
        this.f14619d = i2 + 1;
        this.f14620e = i2;
    }

    public final int m21038b() {
        return this.f14620e;
    }
}
