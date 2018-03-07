package com.facebook.facedetection;

import android.content.Context;
import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.AssetDownloadConfiguration.Builder;
import com.facebook.assetdownload.AssetDownloadConfiguration.ConnectionConstraint;
import com.facebook.assetdownload.AssetDownloadConfiguration.StorageConstraint;
import com.facebook.assetdownload.AssetDownloadHandler;
import com.facebook.assetdownload.AssetDownloadManager;
import com.facebook.assetdownload.background.AssetDownloadConditionalWorker;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.inject.Inject;

/* compiled from: num_db_contacts */
public class FaceDetectionAssetDownloader implements AssetDownloadHandler {
    private final Context f9796a;
    private final AssetDownloadManager f9797b;

    public static FaceDetectionAssetDownloader m15537b(InjectorLike injectorLike) {
        return new FaceDetectionAssetDownloader((Context) injectorLike.getInstance(Context.class), AssetDownloadManager.a(injectorLike));
    }

    @Inject
    public FaceDetectionAssetDownloader(Context context, AssetDownloadManager assetDownloadManager) {
        this.f9796a = context;
        this.f9797b = assetDownloadManager;
    }

    public final void m15539a() {
        if (!this.f9796a.getFileStreamPath("assets.zip").exists()) {
            Builder builder = new Builder("FaceDetectionAssets");
            builder.f7247b = Uri.parse("https://www.facebook.com/mobileassets/facedetection");
            builder = builder;
            builder.f7253h = "FaceDetectionAssets";
            builder = builder;
            builder.f7248c = -20;
            builder = builder;
            builder.f7249d = ConnectionConstraint.CAN_BE_ANY;
            builder = builder;
            builder.f7250e = StorageConstraint.CAN_BE_EXTERNAL;
            this.f9797b.a(builder.m10372a(), true);
            ((AssetDownloadConditionalWorker) this.f9797b.e.get()).m10392a(null);
        }
    }

    public final void mo1016a(AssetDownloadConfiguration assetDownloadConfiguration, File file) {
        Throwable th;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            Throwable th2 = null;
            try {
                FileOutputStream openFileOutput = this.f9796a.openFileOutput("assets.zip", 0);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        openFileOutput.write(bArr, 0, read);
                    } else {
                        openFileOutput.close();
                        fileInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (th22 != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                fileInputStream.close();
            }
            throw th;
            throw th;
        } catch (Throwable th5) {
            BLog.b("FaceDetectionAssetDownloader", "Couldn't read facedetection assets", th5);
        }
    }

    public final InputStream m15538a(String str) {
        Throwable th;
        Throwable th2 = null;
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(this.f9796a.openFileInput("assets.zip")));
        ZipEntry nextEntry;
        do {
            try {
                nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return null;
                }
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
        } while (!nextEntry.getName().equals(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = zipInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                zipInputStream.close();
                return byteArrayInputStream;
            }
        }
        throw th;
        if (th22 != null) {
            try {
                zipInputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            zipInputStream.close();
        }
        throw th;
    }

    public final boolean mo1017a(AssetDownloadConfiguration assetDownloadConfiguration) {
        return assetDownloadConfiguration.mIdentifier.equals("FaceDetectionAssets");
    }
}
