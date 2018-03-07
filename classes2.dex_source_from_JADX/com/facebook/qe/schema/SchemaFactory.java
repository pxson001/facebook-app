package com.facebook.qe.schema;

import android.content.Context;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.iolite.Closeables;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: unknown_experiment */
public final class SchemaFactory {
    private static Schema f1946a = null;
    private static Schema f1947b = null;

    /* compiled from: unknown_experiment */
    final class C01362 implements Schema {
        final /* synthetic */ byte[] f1954a;

        C01362(byte[] bArr) {
            this.f1954a = bArr;
        }

        public final int mo567a() {
            return 5350;
        }

        public final int mo568b() {
            return 710;
        }

        public final String mo569c() {
            return "BD6477555BE1BDCAB5AB9DE6E5E6A867FC3C611A";
        }

        public final byte[] mo570d() {
            return this.f1954a;
        }
    }

    /* compiled from: unknown_experiment */
    final class C01371 implements Schema {
        final /* synthetic */ byte[] f1955a;

        C01371(byte[] bArr) {
            this.f1955a = bArr;
        }

        public final int mo567a() {
            return 5;
        }

        public final int mo568b() {
            return 1;
        }

        public final String mo569c() {
            return "6F28E2C2CA776D1DB1EF4B9E78DDCA36F6AC0013";
        }

        public final byte[] mo570d() {
            return this.f1955a;
        }
    }

    private SchemaFactory() {
    }

    public static synchronized Schema m3881a(Context context) {
        Schema schema;
        synchronized (SchemaFactory.class) {
            if (f1946a == null) {
                f1946a = new C01371(m3882a(context, "sessionless_index.bin", 336));
            }
            schema = f1946a;
        }
        return schema;
    }

    public static synchronized Schema m3884b(Context context) {
        Schema schema;
        synchronized (SchemaFactory.class) {
            if (f1947b == null) {
                f1947b = new C01362(m3882a(context, "sessioned_index.bin", 268632));
            }
            schema = f1947b;
        }
        return schema;
    }

    private static byte[] m3882a(Context context, String str, int i) {
        InputStream open;
        byte[] a;
        Throwable th;
        Throwable th2;
        try {
            open = context.getAssets().open(str);
            try {
                a = ByteStreams.m3910a(open, i);
                Closeables.m2790a(open);
            } catch (FileNotFoundException e) {
                try {
                    a = m3883a("/assets/" + str, i);
                    Closeables.m2790a(open);
                    return a;
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.m2790a(open);
                    throw th;
                }
            } catch (IOException e2) {
                th = e2;
                throw new RuntimeException("IOException encountered while reading asset", th);
            }
        } catch (FileNotFoundException e3) {
            open = null;
            a = m3883a("/assets/" + str, i);
            Closeables.m2790a(open);
            return a;
        } catch (Throwable e4) {
            th2 = e4;
            Object obj = null;
            th = th2;
            throw new RuntimeException("IOException encountered while reading asset", th);
        } catch (Throwable e42) {
            th2 = e42;
            open = null;
            th = th2;
            Closeables.m2790a(open);
            throw th;
        }
        return a;
    }

    private static byte[] m3883a(String str, int i) {
        InputStream inputStream = null;
        try {
            inputStream = SchemaFactory.class.getResourceAsStream(str);
            byte[] a = ByteStreams.m3910a(inputStream, i);
            Closeables.m2790a(inputStream);
            return a;
        } catch (Throwable e) {
            throw new RuntimeException("IOException encountered while reading resource", e);
        } catch (Throwable th) {
            Closeables.m2790a(inputStream);
        }
    }
}
