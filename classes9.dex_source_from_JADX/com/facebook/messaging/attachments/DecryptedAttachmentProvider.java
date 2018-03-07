package com.facebook.messaging.attachments;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.content.SecureContentProvider;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* compiled from: p2p_confirm_pin */
public class DecryptedAttachmentProvider extends SecureContentProvider {
    public static final Class<?> f7708a = DecryptedAttachmentProvider.class;
    private static final String f7709b = (BuildConstants.e + ".attachments.DecryptedAttachmentProvider");
    private static final String f7710c = ("content://" + f7709b);
    private final UriMatcher f7711d = new UriMatcher(-1);
    public ExecutorService f7712e;
    public EncryptedAttachmentDownloader f7713f;
    public CryptoHandler f7714g;

    @VisibleForTesting
    /* compiled from: p2p_confirm_pin */
    class ByteTransferRunnable implements Runnable {
        private final byte[] f7706a;
        private final OutputStream f7707b;

        public ByteTransferRunnable(byte[] bArr, OutputStream outputStream) {
            this.f7706a = bArr;
            this.f7707b = outputStream;
        }

        public void run() {
            try {
                m8000a(this.f7706a, this.f7707b, 1024);
            } catch (Throwable e) {
                BLog.b(DecryptedAttachmentProvider.f7708a, "Exception transferring file", e);
            }
        }

        @VisibleForTesting
        private static void m8000a(byte[] bArr, OutputStream outputStream, int i) {
            int i2 = 0;
            while (i2 < bArr.length) {
                try {
                    int i3;
                    if (i2 + i <= bArr.length) {
                        i3 = i;
                    } else {
                        i3 = bArr.length - i2;
                    }
                    outputStream.write(bArr, i2, i3);
                    i2 = i3 + i2;
                } finally {
                    outputStream.flush();
                    outputStream.close();
                }
            }
        }
    }

    public static void m8003a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        DecryptedAttachmentProvider decryptedAttachmentProvider = (DecryptedAttachmentProvider) obj;
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike);
        EncryptedAttachmentDownloader a = EncryptedAttachmentDownloader.m8016a(injectorLike);
        CryptoHandler b = CryptoHandler.b(injectorLike);
        decryptedAttachmentProvider.f7712e = executorService;
        decryptedAttachmentProvider.f7713f = a;
        decryptedAttachmentProvider.f7714g = b;
    }

    public static Uri m8001a(String str, String str2) {
        return Uri.withAppendedPath(Uri.withAppendedPath(Uri.parse(f7710c), str), Uri.encode(str2));
    }

    protected final void m8010a() {
        super.a();
        this.f7711d.addURI(f7709b, "*/*", 1);
        Class cls = DecryptedAttachmentProvider.class;
        m8003a((Object) this, getContext());
    }

    protected final AssetFileDescriptor m8011b(Uri uri) {
        Throwable e;
        Preconditions.checkState(this.f7711d.match(uri) == 1);
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(1);
        try {
            Uri uri2 = (Uri) Preconditions.checkNotNull(FutureDetour.a(this.f7713f.m8021a((String) pathSegments.get(0)), 336983526));
            m8004c(uri2);
            byte[] b = this.f7714g.b(uri2, str);
            if (b != null) {
                return new AssetFileDescriptor(m8002a(b), 0, -1);
            }
            BLog.b(f7708a, "Error during attachment decryption");
            return null;
        } catch (InterruptedException e2) {
            e = e2;
            BLog.b(f7708a, "Error during file download or decryption", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            BLog.b(f7708a, "Error during file download or decryption", e);
            return null;
        } catch (IOException e4) {
            e = e4;
            BLog.b(f7708a, "Error during file download or decryption", e);
            return null;
        } catch (KeyChainException e5) {
            e = e5;
            BLog.b(f7708a, "Error during file download or decryption", e);
            return null;
        } catch (CryptoInitializationException e6) {
            e = e6;
            BLog.b(f7708a, "Error during file download or decryption", e);
            return null;
        }
    }

    private ParcelFileDescriptor m8002a(byte[] bArr) {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ExecutorDetour.a(this.f7712e, new ByteTransferRunnable(bArr, new AutoCloseOutputStream(createPipe[1])), -68439509);
        return createPipe[0];
    }

    private static void m8004c(Uri uri) {
        File file = new File(uri.getPath());
        Preconditions.checkArgument(file.exists());
        Preconditions.checkArgument(file.length() > 0);
    }

    protected final int m8006a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    protected final String m8009a(Uri uri) {
        return null;
    }

    protected final Uri m8008a(Uri uri, ContentValues contentValues) {
        return null;
    }

    protected final Cursor m8007a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    protected final int m8005a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
