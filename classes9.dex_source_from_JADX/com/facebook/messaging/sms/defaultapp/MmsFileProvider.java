package com.facebook.messaging.sms.defaultapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android_src.mmsv2.pdu.GenericPdu;
import android_src.mmsv2.pdu.MmsException;
import android_src.mmsv2.pdu.PduComposer;
import com.facebook.content.PublicContentProvider;
import com.facebook.debug.log.BLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/* compiled from: com.google.android.gms.auth.RESOLVE_CREDENTIAL */
public class MmsFileProvider extends PublicContentProvider {
    private static final Random f17536a = new Random();
    private static final UriMatcher f17537b = new UriMatcher(-1);

    public static Uri m17521a(Context context, GenericPdu genericPdu) {
        OutputStream bufferedOutputStream;
        Throwable e;
        Uri d = m17523d();
        File a = m17522a(context, d);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a));
            try {
                if (new PduComposer(context, genericPdu).m3650a(bufferedOutputStream)) {
                    try {
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                    }
                    return d;
                }
                throw new MmsException("Failure writing pdu to file");
            } catch (IOException e3) {
                e = e3;
                try {
                    if (a.exists()) {
                        a.delete();
                    }
                    BLog.b("MmsFileProvider", e, "Cannot create temporary file %s", new Object[]{a.getAbsolutePath()});
                    throw new MmsException("Cannot create raw mms file");
                } catch (Throwable th) {
                    e = th;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            } catch (OutOfMemoryError e5) {
                e = e5;
                if (a.exists()) {
                    a.delete();
                }
                BLog.b("MmsFileProvider", "Out of memory in composing PDU", e);
                throw new MmsException("Cannot create raw mms file because out of memory");
            }
        } catch (IOException e6) {
            e = e6;
            bufferedOutputStream = null;
            if (a.exists()) {
                a.delete();
            }
            BLog.b("MmsFileProvider", e, "Cannot create temporary file %s", new Object[]{a.getAbsolutePath()});
            throw new MmsException("Cannot create raw mms file");
        } catch (OutOfMemoryError e7) {
            e = e7;
            Object obj = null;
            if (a.exists()) {
                a.delete();
            }
            BLog.b("MmsFileProvider", "Out of memory in composing PDU", e);
            throw new MmsException("Cannot create raw mms file because out of memory");
        } catch (Throwable th2) {
            e = th2;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
            throw e;
        }
    }

    public static Uri m17523d() {
        return new Builder().authority("com.facebook.messaging.sms.MmsFileProvider").scheme("content").path(String.valueOf(Math.abs(f17536a.nextLong()))).build();
    }

    public static File m17522a(Context context, Uri uri) {
        File file = new File(context.getCacheDir(), "rawmms");
        file.mkdirs();
        return new File(file, uri.getPath() + ".mms");
    }

    public final void m17530a() {
        f17537b.addURI("com.facebook.messaging.sms.MmsFileProvider", "#", 1);
    }

    protected final AssetFileDescriptor m17531b(Uri uri) {
        return openAssetFile(uri, "r");
    }

    protected final AssetFileDescriptor m17526a(Uri uri, String str) {
        ParcelFileDescriptor openFile = openFile(uri, str);
        return openFile != null ? new AssetFileDescriptor(openFile, 0, -1) : null;
    }

    public final ParcelFileDescriptor m17532b(Uri uri, String str) {
        switch (f17537b.match(uri)) {
            case 1:
                int i;
                File a = m17522a(getContext(), uri);
                if (TextUtils.equals(str, "r")) {
                    i = 268435456;
                } else {
                    i = 738197504;
                }
                return ParcelFileDescriptor.open(a, i);
            default:
                throw new FileNotFoundException();
        }
    }

    public final int m17525a(Uri uri, String str, String[] strArr) {
        switch (f17537b.match(uri)) {
            case 1:
                if (m17522a(getContext(), uri).delete()) {
                    return 1;
                }
                return 0;
            default:
                return 0;
        }
    }

    public final int m17524a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public final Cursor m17527a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final String m17529a(Uri uri) {
        return null;
    }

    public final Uri m17528a(Uri uri, ContentValues contentValues) {
        return null;
    }
}
