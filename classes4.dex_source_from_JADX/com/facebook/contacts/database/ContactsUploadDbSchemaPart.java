package com.facebook.contacts.database;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.database.supplier.SharedSQLiteSchemaPart;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: markerLag */
public class ContactsUploadDbSchemaPart extends SharedSQLiteSchemaPart {
    private static volatile ContactsUploadDbSchemaPart f8305a;

    public static com.facebook.contacts.database.ContactsUploadDbSchemaPart m8572a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
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
        r0 = f8305a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.contacts.database.ContactsUploadDbSchemaPart.class;
        monitor-enter(r1);
        r0 = f8305a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8573c();	 Catch:{ all -> 0x0034 }
        f8305a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8305a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.database.ContactsUploadDbSchemaPart.a(com.facebook.inject.InjectorLike):com.facebook.contacts.database.ContactsUploadDbSchemaPart");
    }

    private static ContactsUploadDbSchemaPart m8573c() {
        return new ContactsUploadDbSchemaPart();
    }

    @Inject
    protected ContactsUploadDbSchemaPart() {
        super("contacts_upload", 2);
    }

    protected final void m8574a(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(1065247146);
        sQLiteDatabase.execSQL("CREATE TABLE phone_address_book_snapshot (local_contact_id INTEGER PRIMARY KEY, contact_hash TEXT)");
        SQLiteDetour.a(1736731148);
    }

    protected final void m8575a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        SQLiteDetour.a(-538941706);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS phone_address_book_snapshot");
        SQLiteDetour.a(1323068826);
        m8574a(sQLiteDatabase);
    }

    public final void m8576b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("phone_address_book_snapshot", null, null);
    }
}
