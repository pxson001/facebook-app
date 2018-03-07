package com.facebook.friendsharing.souvenirs.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart.ModelsTable.Columns;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.io.IOException;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: hotp_login_approvals */
public class SouvenirModelsDataAccessLayer {
    public static final PrefKey f10703a = ((PrefKey) SharedPrefKeys.a.a("souvenir_db_model_version"));
    private static volatile SouvenirModelsDataAccessLayer f10704e;
    private final SouvenirsDatabaseSupplier f10705b;
    private final FbObjectMapper f10706c;
    private final FbSharedPreferences f10707d;

    public static com.facebook.friendsharing.souvenirs.persistence.SouvenirModelsDataAccessLayer m11162a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10704e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.persistence.SouvenirModelsDataAccessLayer.class;
        monitor-enter(r1);
        r0 = f10704e;	 Catch:{ all -> 0x003a }
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
        r0 = m11165b(r0);	 Catch:{ all -> 0x0035 }
        f10704e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10704e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.persistence.SouvenirModelsDataAccessLayer.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.persistence.SouvenirModelsDataAccessLayer");
    }

    private static SouvenirModelsDataAccessLayer m11165b(InjectorLike injectorLike) {
        return new SouvenirModelsDataAccessLayer(SouvenirsDatabaseSupplier.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SouvenirModelsDataAccessLayer(SouvenirsDatabaseSupplier souvenirsDatabaseSupplier, FbObjectMapper fbObjectMapper, FbSharedPreferences fbSharedPreferences) {
        this.f10705b = souvenirsDatabaseSupplier;
        this.f10706c = fbObjectMapper;
        this.f10707d = fbSharedPreferences;
    }

    public final ImmutableSet<SouvenirModel> m11167a() {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("models");
        Cursor query = sQLiteQueryBuilder.query(this.f10705b.a(), null, null, null, null, null, null);
        if (query == null) {
            return ImmutableSet.of();
        }
        try {
            if (query.moveToFirst()) {
                Builder builder = new Builder();
                int a = Columns.a.a(query);
                int a2 = Columns.b.a(query);
                int a3 = Columns.c.a(query);
                do {
                    SouvenirModel souvenirModel = (SouvenirModel) this.f10706c.a(query.getString(a3), SouvenirModel.class);
                    m11163a(query, a, a2, souvenirModel);
                    builder.c(souvenirModel);
                } while (query.moveToNext());
                ImmutableSet<SouvenirModel> b = builder.b();
                query.close();
                return b;
            }
            query.close();
            return ImmutableSet.of();
        } catch (Throwable e) {
            throw new IOException("When deserializing JSON blob into SouvenirModel, we had a mapping issue", e);
        } catch (Throwable e2) {
            throw new IOException("When deserializing JSON blob into SouvenirModel, we had a parsing error", e2);
        } catch (Throwable th) {
            query.close();
        }
    }

    public final Collection<SouvenirModel> m11168a(Collection<SouvenirModel> collection) {
        Preconditions.checkNotNull(collection);
        SQLiteDatabase a = this.f10705b.a();
        SQLiteDetour.a(a, -1993977024);
        try {
            for (SouvenirModel a2 : collection) {
                m11164a(a, a2);
            }
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -550521901);
            return collection;
        } catch (Throwable e) {
            throw new IllegalArgumentException("SouvenirModel couldn't be serialized into JSON for storage", e);
        } catch (Throwable th) {
            SQLiteDetour.b(a, 1509392273);
        }
    }

    public final int m11170b() {
        return this.f10705b.a().delete("models", "1", null);
    }

    public final int m11166a(long j) {
        Expression b = Columns.b.b(String.valueOf(j));
        return this.f10705b.a().delete("models", b.a(), b.b());
    }

    private void m11164a(SQLiteDatabase sQLiteDatabase, SouvenirModel souvenirModel) {
        String a = ((SouvenirModel) Preconditions.checkNotNull(souvenirModel)).m11461a().a();
        long c = souvenirModel.m11461a().c();
        String a2 = this.f10706c.a(souvenirModel);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.a.toString(), a);
        contentValues.put(Columns.b.toString(), Long.valueOf(c));
        contentValues.put(Columns.c.toString(), a2);
        SQLiteDetour.a(-1292911476);
        sQLiteDatabase.replaceOrThrow("models", "", contentValues);
        SQLiteDetour.a(-915394324);
    }

    public final int m11171c() {
        return this.f10707d.a(f10703a, -1);
    }

    public final void m11169a(int i) {
        this.f10707d.edit().a(f10703a, i).commit();
    }

    private static void m11163a(Cursor cursor, int i, int i2, SouvenirModel souvenirModel) {
        String string = cursor.getString(i);
        String a = souvenirModel.m11461a().a();
        Preconditions.checkState(a.equals(string), "The value in the 'id' column does not match that in the blob" + "\nID Column: " + string + "\nModel ID: " + a);
        long j = cursor.getLong(i2);
        long c = souvenirModel.m11461a().c();
        Preconditions.checkState(c == j, "The value in the 'start_date' column does not match that in the blob" + "\nStart Date Column: " + j + "\nModel Start Date: " + c);
    }
}
