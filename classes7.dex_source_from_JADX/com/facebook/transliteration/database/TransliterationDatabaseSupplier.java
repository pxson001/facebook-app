package com.facebook.transliteration.database;

import android.content.Context;
import android.database.Cursor;
import com.facebook.database.supplier.AbstractDatabaseSupplier;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadCheckerDisallowUiThread;
import com.facebook.inject.InjectorLike;
import com.facebook.transliteration.database.DictionarySchema.DictionaryTable.Columns;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: exit_source */
public class TransliterationDatabaseSupplier extends AbstractDatabaseSupplier {
    private static volatile TransliterationDatabaseSupplier f15166a;

    public static com.facebook.transliteration.database.TransliterationDatabaseSupplier m19160a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f15166a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.transliteration.database.TransliterationDatabaseSupplier.class;
        monitor-enter(r1);
        r0 = f15166a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m19161b(r0);	 Catch:{ all -> 0x0035 }
        f15166a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15166a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.transliteration.database.TransliterationDatabaseSupplier.a(com.facebook.inject.InjectorLike):com.facebook.transliteration.database.TransliterationDatabaseSupplier");
    }

    private static TransliterationDatabaseSupplier m19161b(InjectorLike injectorLike) {
        return new TransliterationDatabaseSupplier((Context) injectorLike.getInstance(Context.class), (DbThreadChecker) DbThreadCheckerDisallowUiThread.a(injectorLike), DictionarySchema.m19158a(injectorLike));
    }

    @Inject
    public TransliterationDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, DictionarySchema dictionarySchema) {
        super(context, dbThreadChecker, ImmutableList.of(dictionarySchema), "transliteration_db");
    }

    public final Map<String, String> m19162a(int i) {
        Map<String, String> hashMap = new HashMap();
        Cursor query = a().query("dictionary_table", new String[]{Columns.f15162c.a(), Columns.f15163d.a()}, Columns.f15161b.a() + "=?", new String[]{String.valueOf(i)}, null, null, null);
        try {
            int a = Columns.f15162c.a(query);
            int a2 = Columns.f15163d.a(query);
            while (query.moveToNext()) {
                hashMap.put(query.getString(a), query.getString(a2));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }
}
