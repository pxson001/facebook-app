package com.facebook.contacts.handlers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.database.ContactsDatabaseSupplier;
import com.facebook.contacts.database.ContactsDbSchemaPart.FavoriteSmsContactsTable.Columns;
import com.facebook.contacts.properties.DbContactsProperties;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.user.model.User;
import com.google.common.base.Strings;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reused_past */
public class DbFavoriteContactsHandler {
    private static final Class<?> f3336a = DbFavoriteContactsHandler.class;
    private static volatile DbFavoriteContactsHandler f3337e;
    private final Clock f3338b;
    private final ContactsDatabaseSupplier f3339c;
    private final DbContactsPropertyUtil f3340d;

    public static com.facebook.contacts.handlers.DbFavoriteContactsHandler m3572a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3337e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.handlers.DbFavoriteContactsHandler.class;
        monitor-enter(r1);
        r0 = f3337e;	 Catch:{ all -> 0x003a }
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
        r0 = m3575b(r0);	 Catch:{ all -> 0x0035 }
        f3337e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3337e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.DbFavoriteContactsHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.handlers.DbFavoriteContactsHandler");
    }

    private static DbFavoriteContactsHandler m3575b(InjectorLike injectorLike) {
        return new DbFavoriteContactsHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsDatabaseSupplier.m8560a(injectorLike), DbContactsPropertyUtil.m8548b(injectorLike));
    }

    @Inject
    public DbFavoriteContactsHandler(Clock clock, ContactsDatabaseSupplier contactsDatabaseSupplier, DbContactsPropertyUtil dbContactsPropertyUtil) {
        this.f3338b = clock;
        this.f3339c = contactsDatabaseSupplier;
        this.f3340d = dbContactsPropertyUtil;
    }

    public final void m3576a(Collection<User> collection, boolean z) {
        SQLiteDatabase a = this.f3339c.a();
        SQLiteDetour.a(a, -1467155144);
        try {
            a.delete("favorite_contacts", null, null);
            if (!z) {
                a.delete("favorite_sms_contacts", null, null);
            }
            int i = 0;
            float f = 0.0f;
            for (User user : collection) {
                int i2;
                float f2;
                if (!user.b()) {
                    i2 = i + 1;
                    m3574a(user.d(), i2);
                    f2 = (float) i2;
                } else if (user.w() == null || Strings.isNullOrEmpty(user.w().c())) {
                    f2 = f;
                    i2 = i;
                } else {
                    f += 0.001f;
                    m3573a(user.w().c(), f);
                }
                i = i2;
                f = f2;
            }
            this.f3340d.m8556b(DbContactsProperties.f13094e, collection.size());
            this.f3340d.m8557b(DbContactsProperties.f13095f, this.f3338b.a());
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, 578282471);
        } catch (Throwable e) {
            BLog.a(f3336a, "SQLException", e);
            throw e;
        } catch (Throwable th) {
            SQLiteDetour.b(a, -253984638);
        }
    }

    private void m3574a(String str, int i) {
        SQLiteDatabase a = this.f3339c.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fbid", str);
        contentValues.put("display_order", Integer.valueOf(i));
        SQLiteDetour.a(1033892858);
        a.replaceOrThrow("favorite_contacts", "", contentValues);
        SQLiteDetour.a(849391137);
    }

    private void m3573a(String str, float f) {
        SQLiteDatabase a = this.f3339c.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f8303a.d, str);
        contentValues.put(Columns.f8304b.d, Float.valueOf(f));
        SQLiteDetour.a(1801855420);
        a.replaceOrThrow("favorite_sms_contacts", "", contentValues);
        SQLiteDetour.a(977443800);
    }
}
