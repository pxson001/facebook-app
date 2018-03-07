package com.facebook.graphql.cursor;

import android.database.Cursor;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: messenger_contacts */
public class ModelReader implements Closeable {
    @GuardedBy("sModelFiles")
    private static final HashMap<String, MappedByteBuffer> f8033a = new HashMap();
    @GuardedBy("sModelClasses")
    private static final HashMap<String, Class> f8034b = new HashMap();
    private final Cursor f8035c;
    private final int f8036d;
    private final int f8037e;
    private final int f8038f;
    private final int f8039g;

    public static void m8332a() {
        synchronized (f8033a) {
            f8033a.clear();
        }
        synchronized (f8034b) {
            f8034b.clear();
        }
    }

    public ModelReader(Cursor cursor) {
        this.f8035c = cursor;
        this.f8037e = cursor.getColumnIndexOrThrow("file");
        this.f8038f = cursor.getColumnIndexOrThrow("offset");
        this.f8039g = cursor.getColumnIndexOrThrow("mutation_data");
        this.f8036d = cursor.getColumnIndexOrThrow("class");
    }

    public final String m8335b() {
        return this.f8035c.getString(this.f8036d);
    }

    private Class m8333e() {
        Throwable e;
        String b = m8335b();
        synchronized (f8034b) {
            Class cls = (Class) f8034b.get(b);
        }
        if (cls != null) {
            return cls;
        }
        try {
            cls = Class.forName(b);
            synchronized (f8034b) {
                f8034b.put(b, cls);
            }
            return cls;
        } catch (ClassNotFoundException e2) {
            e = e2;
            BLog.b(ModelReader.class, e, "Unable to resolve Flattenable subclass with name '%s'", new Object[]{b});
            return null;
        } catch (ClassCastException e3) {
            e = e3;
            BLog.b(ModelReader.class, e, "Unable to resolve Flattenable subclass with name '%s'", new Object[]{b});
            return null;
        }
    }

    public final <T extends Flattenable> T m8336c() {
        Class e = m8333e();
        if (e == null) {
            return null;
        }
        int i = this.f8035c.getInt(this.f8038f);
        ByteBuffer f = m8334f();
        if (f == null) {
            return null;
        }
        ByteBuffer wrap;
        f.order(ByteOrder.LITTLE_ENDIAN);
        byte[] blob = this.f8035c.getBlob(this.f8039g);
        if (blob != null) {
            wrap = ByteBuffer.wrap(blob);
        } else {
            wrap = null;
        }
        return new MutableFlatBuffer(f, wrap, null, true, null).a(i, e);
    }

    public final void m8337d() {
        MappedByteBuffer f = m8334f();
        if (f != null && !f.isLoaded()) {
            f.load();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.MappedByteBuffer m8334f() {
        /*
        r10 = this;
        r6 = 0;
        r0 = r10.f8035c;
        r1 = r10.f8037e;
        r7 = r0.getString(r1);
        com.google.common.base.Preconditions.checkNotNull(r7);
        r1 = f8033a;
        monitor-enter(r1);
        r0 = f8033a;	 Catch:{ all -> 0x0022 }
        r0 = r0.get(r7);	 Catch:{ all -> 0x0022 }
        r0 = (java.nio.MappedByteBuffer) r0;	 Catch:{ all -> 0x0022 }
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0025;
    L_0x001a:
        r1 = r0.isLoaded();
        java.lang.Boolean.valueOf(r1);
    L_0x0021:
        return r0;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x0025:
        r8 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x006a }
        r8.<init>(r7);	 Catch:{ IOException -> 0x006a }
        r0 = r8.getChannel();	 Catch:{ Throwable -> 0x005e, all -> 0x007f }
        r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ Throwable -> 0x0050, all -> 0x008f }
        r2 = 0;
        r4 = r0.size();	 Catch:{ Throwable -> 0x0050, all -> 0x008f }
        r1 = r0.map(r1, r2, r4);	 Catch:{ Throwable -> 0x0050, all -> 0x008f }
        r2 = f8033a;	 Catch:{ Throwable -> 0x0050, all -> 0x008f }
        monitor-enter(r2);	 Catch:{ Throwable -> 0x0050, all -> 0x008f }
        r3 = f8033a;	 Catch:{ all -> 0x004d }
        r3.put(r7, r1);	 Catch:{ all -> 0x004d }
        monitor-exit(r2);	 Catch:{ all -> 0x004d }
        if (r0 == 0) goto L_0x0048;
    L_0x0045:
        r0.close();	 Catch:{  }
    L_0x0048:
        r8.close();	 Catch:{  }
        r0 = r1;
        goto L_0x0021;
    L_0x004d:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{  }
        throw r1;	 Catch:{  }
    L_0x0050:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0052 }
    L_0x0052:
        r2 = move-exception;
        r9 = r2;
        r2 = r1;
        r1 = r9;
    L_0x0056:
        if (r0 == 0) goto L_0x005d;
    L_0x0058:
        if (r2 == 0) goto L_0x0082;
    L_0x005a:
        r0.close();	 Catch:{ Throwable -> 0x007a, all -> 0x007f }
    L_0x005d:
        throw r1;	 Catch:{  }
    L_0x005e:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0060 }
    L_0x0060:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x0064:
        if (r1 == 0) goto L_0x008b;
    L_0x0066:
        r8.close();	 Catch:{ Throwable -> 0x0086 }
    L_0x0069:
        throw r0;	 Catch:{  }
    L_0x006a:
        r0 = move-exception;
        r1 = com.facebook.graphql.cursor.ModelReader.class;
        r2 = "Error mapping file '%s'";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r7;
        com.facebook.debug.log.BLog.b(r1, r0, r2, r3);
        r0 = r6;
        goto L_0x0021;
    L_0x007a:
        r0 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r0);	 Catch:{  }
        goto L_0x005d;
    L_0x007f:
        r0 = move-exception;
        r1 = r6;
        goto L_0x0064;
    L_0x0082:
        r0.close();	 Catch:{  }
        goto L_0x005d;
    L_0x0086:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);	 Catch:{  }
        goto L_0x0069;
    L_0x008b:
        r8.close();	 Catch:{  }
        goto L_0x0069;
    L_0x008f:
        r1 = move-exception;
        r2 = r6;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.ModelReader.f():java.nio.MappedByteBuffer");
    }

    public void close() {
    }
}
