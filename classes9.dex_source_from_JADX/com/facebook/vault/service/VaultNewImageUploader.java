package com.facebook.vault.service;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageResizerMethodAutoProvider;
import com.facebook.bitmaps.ImageScaleParam;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.NetworkException;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.AuthTokenNullException;
import com.facebook.http.protocol.CountingOutputStreamWithProgress.ProgressListener;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.vault.VaultContract.ImagesTable;
import com.facebook.ipc.vault.VaultContract.ImagesTable.Columns;
import com.facebook.vault.constants.VaultConstants;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.protocol.VaultImageUploadMethod;
import com.facebook.vault.protocol.VaultImageUploadParams;
import com.facebook.vault.protocol.VaultImageUploadResult;
import com.facebook.vault.provider.VaultImageProviderRow;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.inject.Inject;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

/* compiled from: third_party_registration_params */
public class VaultNewImageUploader {
    private static final Class<?> f1895a;
    private static final String f1896b;
    private final Context f1897c;
    private final AbstractSingleMethodRunner f1898d;
    private final VaultImageUploadMethod f1899e;
    private final VaultLocalImageFetcher f1900f;
    private final VaultLogger f1901g;
    private final ImageResizer f1902h;
    private final DeviceIDPref f1903i;
    private final VaultHelpers f1904j;
    public final VaultNotificationManager f1905k;
    private final VaultTable f1906l;
    private final AbstractFbErrorReporter f1907m;

    /* compiled from: third_party_registration_params */
    class VaultUploadProgressListener implements ProgressListener {
        final /* synthetic */ VaultNewImageUploader f1891a;
        private int f1892b = 0;
        private long f1893c;
        private VaultImageProviderRow f1894d;

        public VaultUploadProgressListener(VaultNewImageUploader vaultNewImageUploader, long j, VaultImageProviderRow vaultImageProviderRow) {
            this.f1891a = vaultNewImageUploader;
            this.f1893c = j;
            this.f1894d = vaultImageProviderRow;
        }

        public final void m1963a(long j) {
            int floor = (int) Math.floor((90.0d * ((double) j)) / ((double) this.f1893c));
            if (floor != this.f1892b) {
                this.f1892b = floor;
                if (this.f1892b % 10 == 0) {
                    this.f1891a.f1905k.a(this.f1894d, floor);
                }
            }
        }
    }

    public static VaultNewImageUploader m1971b(InjectorLike injectorLike) {
        return new VaultNewImageUploader((Context) injectorLike.getInstance(Context.class), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new VaultImageUploadMethod((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)), VaultLocalImageFetcher.c(injectorLike), ImageResizerMethodAutoProvider.b(injectorLike), DeviceIDPref.a(injectorLike), VaultHelpers.b(injectorLike), VaultLogger.c(injectorLike), VaultNotificationManager.a(injectorLike), VaultTable.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    static {
        Class cls = VaultNewImageUploader.class;
        f1895a = cls;
        f1896b = cls.getSimpleName();
    }

    @Inject
    public VaultNewImageUploader(Context context, AbstractSingleMethodRunner abstractSingleMethodRunner, VaultImageUploadMethod vaultImageUploadMethod, VaultLocalImageFetcher vaultLocalImageFetcher, ImageResizer imageResizer, DeviceIDPref deviceIDPref, VaultHelpers vaultHelpers, VaultLogger vaultLogger, VaultNotificationManager vaultNotificationManager, VaultTable vaultTable, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1897c = context;
        this.f1898d = abstractSingleMethodRunner;
        this.f1899e = vaultImageUploadMethod;
        this.f1900f = vaultLocalImageFetcher;
        this.f1902h = imageResizer;
        this.f1903i = deviceIDPref;
        this.f1904j = vaultHelpers;
        this.f1901g = vaultLogger;
        this.f1905k = vaultNotificationManager;
        this.f1906l = vaultTable;
        this.f1907m = abstractFbErrorReporter;
    }

    public final boolean m1973a(VaultImageProviderRow vaultImageProviderRow, int i) {
        boolean c = this.f1904j.c();
        long a = this.f1903i.a();
        if (this.f1904j.a(i)) {
            String str = vaultImageProviderRow.f1874a;
            String c2 = this.f1900f.c(str);
            if (c2 == null) {
                this.f1905k.a(str);
                return false;
            }
            File file = c ? new File(c2) : m1965a(c2, vaultImageProviderRow, c);
            if (file == null || !file.exists()) {
                this.f1905k.a(str);
                return false;
            }
            long length = file.length();
            VaultImageUploadParams vaultImageUploadParams = new VaultImageUploadParams(file, str, Long.toString(a), vaultImageProviderRow.f1875b, new VaultUploadProgressListener(this, length, vaultImageProviderRow));
            m1969a(vaultImageProviderRow, c, length);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                VaultImageUploadResult vaultImageUploadResult = (VaultImageUploadResult) this.f1898d.a(this.f1899e, vaultImageUploadParams);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (vaultImageUploadResult.m1954a() > 0) {
                    m1967a(vaultImageProviderRow, vaultImageUploadResult.m1954a(), c, currentTimeMillis2, length, c2);
                    if (!c) {
                        file.delete();
                    }
                    return false;
                }
                m1968a(vaultImageProviderRow, "upload result missing fbid", currentTimeMillis2, length, c2);
                if (!c) {
                    file.delete();
                }
                return true;
            } catch (Exception e) {
                BLog.b(f1896b, "syncPhoto", e);
                if (m1970a(e)) {
                    m1966a(vaultImageProviderRow);
                } else {
                    String message = e.getMessage();
                    if (message == null) {
                        message = Log.getStackTraceString(e).substring(0, 100);
                    }
                    this.f1907m.a("vault_image_upload_api exception: " + message, "", e);
                    m1968a(vaultImageProviderRow, e.getMessage(), System.currentTimeMillis() - currentTimeMillis, length, c2);
                }
                if (!c) {
                    file.delete();
                }
                return true;
            } catch (Throwable th) {
                if (!c) {
                    file.delete();
                }
            }
        } else {
            this.f1906l.b(vaultImageProviderRow.f1874a);
            m1966a(vaultImageProviderRow);
            return false;
        }
    }

    private File m1965a(String str, VaultImageProviderRow vaultImageProviderRow, boolean z) {
        int i;
        if (z && vaultImageProviderRow.f1879f != 1) {
            i = VaultConstants.b;
        } else if (z || vaultImageProviderRow.f1879f == 1 || vaultImageProviderRow.f1879f == 0) {
            Boolean.valueOf(z);
            return null;
        } else {
            i = VaultConstants.a;
        }
        try {
            if (!new File(str).exists()) {
                return null;
            }
            File createTempFile = File.createTempFile("resized_", "", m1964a(this.f1897c));
            this.f1902h.a(str, createTempFile.getPath(), new ImageScaleParam(i, i, VaultConstants.c));
            return createTempFile;
        } catch (ImageResizingException e) {
            this.f1907m.a("vault_image_upload_resize exception", "resize of " + str + " failed: " + e.getMessage(), e);
            return null;
        } catch (Throwable e2) {
            this.f1907m.a("vault_image_upload_resize exception", "resize of " + str + " failed: " + e2.getMessage(), e2);
            return null;
        }
    }

    private void m1969a(VaultImageProviderRow vaultImageProviderRow, boolean z, long j) {
        Boolean.valueOf(z);
        Long.valueOf(j);
        vaultImageProviderRow.toString();
        this.f1897c.getContentResolver().insert(ImagesTable.a, vaultImageProviderRow.m1958b());
        this.f1901g.a(vaultImageProviderRow, z, j);
        if (vaultImageProviderRow.f1878e == 0) {
            this.f1901g.a(vaultImageProviderRow, j);
        }
        this.f1905k.a(vaultImageProviderRow);
    }

    private void m1967a(VaultImageProviderRow vaultImageProviderRow, long j, boolean z, long j2, long j3, String str) {
        this.f1905k.a(vaultImageProviderRow, 100);
        vaultImageProviderRow.f1875b = j;
        vaultImageProviderRow.f1877d = System.currentTimeMillis();
        boolean z2 = vaultImageProviderRow.f1879f == 0 && z;
        if (z) {
            vaultImageProviderRow.f1879f = 1;
        } else {
            vaultImageProviderRow.f1879f = 0;
        }
        vaultImageProviderRow.f1881h = 0;
        Long.valueOf(j3);
        Long.valueOf(j2);
        vaultImageProviderRow.toString();
        this.f1897c.getContentResolver().update(ImagesTable.a, vaultImageProviderRow.m1958b(), StringFormatUtil.a("%s = ?", new Object[]{Columns.a.a()}), new String[]{vaultImageProviderRow.f1874a});
        this.f1901g.a(vaultImageProviderRow, j2, j3, z2, str);
        m1972b(vaultImageProviderRow);
    }

    private void m1968a(VaultImageProviderRow vaultImageProviderRow, String str, long j, long j2, String str2) {
        vaultImageProviderRow.f1878e++;
        if (vaultImageProviderRow.f1878e == 8) {
            this.f1901g.b(vaultImageProviderRow, j2);
            vaultImageProviderRow.f1879f = 6;
        }
        vaultImageProviderRow.toString();
        this.f1901g.a(vaultImageProviderRow, str, j, j2, str2);
        m1966a(vaultImageProviderRow);
    }

    private void m1966a(VaultImageProviderRow vaultImageProviderRow) {
        vaultImageProviderRow.f1881h = 0;
        ContentValues b = vaultImageProviderRow.m1958b();
        String[] strArr = new String[]{vaultImageProviderRow.f1874a};
        this.f1897c.getContentResolver().update(ImagesTable.a, b, StringFormatUtil.a("%s = ?", new Object[]{Columns.a.d}), strArr);
        m1972b(vaultImageProviderRow);
    }

    private void m1972b(VaultImageProviderRow vaultImageProviderRow) {
        this.f1905k.b(vaultImageProviderRow);
    }

    private static File m1964a(Context context) {
        return context.getDir("vault_temp", 0);
    }

    private static boolean m1970a(Exception exception) {
        return (exception instanceof AuthTokenNullException) || (exception instanceof NetworkException) || (exception instanceof UnknownHostException) || (exception instanceof SSLException) || (exception instanceof SocketException) || (exception instanceof SocketTimeoutException) || (exception instanceof ConnectTimeoutException) || (exception instanceof HttpHostConnectException);
    }
}
