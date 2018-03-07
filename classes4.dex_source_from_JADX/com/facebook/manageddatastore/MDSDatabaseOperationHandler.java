package com.facebook.manageddatastore;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.ipc.cache.CacheContract$CacheTable;
import com.facebook.ipc.cache.CacheContract$CacheTable.Columns;
import com.facebook.manageddatastore.ManagedDataStore.Client;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: subtext */
public class MDSDatabaseOperationHandler<K, V> {
    private static final String[] f1594a = new String[]{Columns.f1599c.d, Columns.f1600d.d};
    private final Client<K, V> f1595b;
    private final ContentResolver f1596c;

    public final com.facebook.manageddatastore.MDSDatabaseOperationHandler.DiskStoreEntry<V> m1838a(@javax.annotation.Nullable K r8) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r3 = 0;
        r1 = r7.m1836d(r8);
        r0 = r7.f1596c;
        r2 = f1594a;
        r4 = r3;
        r5 = r3;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 == 0) goto L_0x0033;
    L_0x0011:
        r0 = r1.moveToFirst();	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        if (r0 == 0) goto L_0x0033;	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
    L_0x0017:
        r0 = 0;	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r2 = r1.getString(r0);	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r0 = 1;	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r4 = r1.getLong(r0);	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r0 = new com.facebook.manageddatastore.MDSDatabaseOperationHandler$DiskStoreEntry;	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r6 = r7.f1595b;	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r2 = r6.mo110a(r2);	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        r0.<init>(r2, r4);	 Catch:{ DeserializeException -> 0x0039, all -> 0x0040 }
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();
    L_0x0031:
        r3 = r0;
    L_0x0032:
        return r3;
    L_0x0033:
        if (r1 == 0) goto L_0x0032;
    L_0x0035:
        r1.close();
        goto L_0x0032;
    L_0x0039:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0032;
    L_0x003c:
        r1.close();
        goto L_0x0032;
    L_0x0040:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.close();
    L_0x0046:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.manageddatastore.MDSDatabaseOperationHandler.a(java.lang.Object):com.facebook.manageddatastore.MDSDatabaseOperationHandler$DiskStoreEntry<V>");
    }

    public MDSDatabaseOperationHandler(Client<K, V> client, ContentResolver contentResolver) {
        this.f1595b = (Client) Preconditions.checkNotNull(client);
        this.f1596c = (ContentResolver) Preconditions.checkNotNull(contentResolver);
    }

    public final void m1842b(K k) {
        this.f1596c.delete(m1836d(k), null, null);
    }

    final void m1839a() {
        this.f1596c.delete(Uri.withAppendedPath(CacheContract$CacheTable.f1605d, Uri.encode(m1835b())), null, null);
    }

    private String m1835b() {
        return this.f1595b.mo103a() + ":";
    }

    private Uri m1836d(@Nullable K k) {
        return Uri.withAppendedPath(CacheContract$CacheTable.f1603b, Uri.encode(m1837e(k)));
    }

    @VisibleForTesting
    private String m1837e(@Nullable K k) {
        return m1835b() + this.f1595b.mo104a((Object) k);
    }

    final void m1841a(@Nullable K k, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f1598b.d, m1837e(k));
        contentValues.put(Columns.f1599c.d, str);
        contentValues.put(Columns.f1600d.d, Long.valueOf(j));
        this.f1596c.insert(CacheContract$CacheTable.f1602a, contentValues);
    }

    final void m1840a(long j) {
        this.f1596c.delete(Uri.withAppendedPath(Uri.withAppendedPath(CacheContract$CacheTable.f1604c, Uri.encode(m1835b())), String.valueOf(1000 * j)), null, null);
    }

    public final boolean m1843c(@Nullable K k) {
        Cursor query;
        Throwable th;
        try {
            boolean z;
            query = this.f1596c.query(CacheContract$CacheTable.f1602a, new String[]{"COUNT(*) AS count"}, Columns.f1598b.a() + "=?", new String[]{m1837e(k)}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && query.getInt(0) > 0) {
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            z = false;
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
