package com.facebook.imagepipeline.internal;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.inject.Assisted;
import com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsAnalyticsLogger;
import com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler;
import com.google.common.base.Preconditions;
import com.google.common.io.CountingInputStream;
import com.google.common.primitives.Bytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.inject.Inject;

/* compiled from: seen_state_session_number */
public class FbImageCompressionCountReader extends InputStream {
    private static final byte[] f2863a = new byte[]{(byte) -1, (byte) -40};
    private static final byte[] f2864b = "FBMD0f0007".getBytes(Charset.forName("US-ASCII"));
    private final CompressionSavingsStorageHandler f2865c;
    private final DataSensitivitySettingsPrefUtil f2866d;
    private final CompressionSavingsAnalyticsLogger f2867e;
    private final FbNetworkManager f2868f;
    private final Uri f2869g;
    private final CountingInputStream f2870h;
    private final CallerContext f2871i;
    private long f2872j = -1;

    @Inject
    public FbImageCompressionCountReader(CompressionSavingsStorageHandler compressionSavingsStorageHandler, CompressionSavingsAnalyticsLogger compressionSavingsAnalyticsLogger, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil, FbNetworkManager fbNetworkManager, @Assisted Uri uri, @Assisted InputStream inputStream, @Assisted CallerContext callerContext) {
        this.f2867e = compressionSavingsAnalyticsLogger;
        this.f2866d = dataSensitivitySettingsPrefUtil;
        this.f2865c = compressionSavingsStorageHandler;
        this.f2868f = fbNetworkManager;
        this.f2869g = uri;
        this.f2870h = new CountingInputStream(inputStream);
        this.f2871i = callerContext;
    }

    public int read(byte[] bArr) {
        int i;
        if (this.f2872j < 0) {
            this.f2872j = (long) m3131a(this.f2870h, bArr);
            i = (int) this.f2870h.f2884a;
            i += Math.max(0, this.f2870h.read(bArr, i, bArr.length - i));
        } else {
            i = this.f2870h.read(bArr);
        }
        if (i < 0 && this.f2868f.h()) {
            m3133a();
        }
        return i;
    }

    public int read() {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public void close() {
        this.f2870h.close();
    }

    private void m3133a() {
        long b = m3136b() - this.f2870h.f2884a;
        if (this.f2866d.a(false)) {
            this.f2867e.m3145a(this.f2869g, this.f2871i, this.f2870h.m3146a(), Math.max(this.f2872j, this.f2870h.m3146a()));
        }
        if (b > 0) {
            this.f2865c.m3140a(b, true);
        }
    }

    @VisibleForTesting
    private long m3136b() {
        Preconditions.checkArgument(this.f2872j >= 0);
        return this.f2872j;
    }

    private static int m3131a(InputStream inputStream, byte[] bArr) {
        boolean z = true;
        int i = 0;
        if (bArr.length < 512) {
            z = false;
        }
        Preconditions.checkState(z);
        try {
            if (m3132a(inputStream, bArr, 0, 512) == 512 && bArr[0] == f2863a[0] && bArr[1] == f2863a[1]) {
                int a = Bytes.m3147a(bArr, f2864b);
                if (a >= 0) {
                    Object obj = new byte[8];
                    System.arraycopy(bArr, a + (f2864b.length + 56), obj, 0, 8);
                    m3134a(obj);
                    i = Integer.parseInt(new String(obj), 16);
                }
            }
        } catch (IOException e) {
            throw e;
        } catch (NumberFormatException e2) {
        }
        return i;
    }

    private static void m3134a(byte[] bArr) {
        boolean z;
        int i = 0;
        if (bArr.length % 2 == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        while (i < bArr.length / 4) {
            int i2 = i * 2;
            int length = (bArr.length - i2) - 2;
            m3135a(bArr, i2, length);
            m3135a(bArr, i2 + 1, length + 1);
            i++;
        }
    }

    private static void m3135a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    private static int m3132a(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        Preconditions.checkState(i + i2 <= bArr.length);
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
