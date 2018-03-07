package com.facebook.pages.adminedpages.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlColumn;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.adminedpages.db.AdminedPagesDbSchemaPart.AdminedPagesTable;
import com.facebook.pages.adminedpages.db.AdminedPagesDbSchemaPart.AdminedPagesTable.Columns;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel.AdminInfoModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel.ProfilePictureModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchMethod.Result;
import com.facebook.pages.adminedpages.protocol.PagesAccessTokenPrefetchMethod;
import com.facebook.pages.adminedpages.service.AdminedPagesOperationConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: error reading dex error log */
public class DbAdminedPagesHandler {
    private static final String[] f12819a = new String[]{Columns.f12824a.toString(), Columns.f12825b.toString(), Columns.f12826c.toString(), Columns.f12828e.toString(), Columns.f12829f.toString(), Columns.f12830g.toString()};
    private static volatile DbAdminedPagesHandler f12820e;
    private AdminedPagesDatabaseSupplier f12821b;
    private DefaultAndroidThreadUtil f12822c;
    private FbSharedPreferences f12823d;

    public static com.facebook.pages.adminedpages.db.DbAdminedPagesHandler m13661a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12820e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.adminedpages.db.DbAdminedPagesHandler.class;
        monitor-enter(r1);
        r0 = f12820e;	 Catch:{ all -> 0x003a }
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
        r0 = m13662b(r0);	 Catch:{ all -> 0x0035 }
        f12820e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12820e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.adminedpages.db.DbAdminedPagesHandler.a(com.facebook.inject.InjectorLike):com.facebook.pages.adminedpages.db.DbAdminedPagesHandler");
    }

    private static DbAdminedPagesHandler m13662b(InjectorLike injectorLike) {
        return new DbAdminedPagesHandler(AdminedPagesDatabaseSupplier.m13665a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public DbAdminedPagesHandler(AdminedPagesDatabaseSupplier adminedPagesDatabaseSupplier, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FbSharedPreferences fbSharedPreferences) {
        this.f12821b = adminedPagesDatabaseSupplier;
        this.f12822c = defaultAndroidThreadUtil;
        this.f12823d = fbSharedPreferences;
    }

    public final void m13664a(Result result, PagesAccessTokenPrefetchMethod.Result result2) {
        this.f12822c.b();
        if (result.m4511c().isPresent()) {
            ImmutableList<NodesModel> b = ((AdminedPagesModel) result.m4511c().get()).m4517b();
            this.f12821b.a().delete("admined_pages_table", null, null);
            if (!b.isEmpty()) {
                for (NodesModel nodesModel : b) {
                    CharSequence c = nodesModel.m4524c();
                    if (!StringUtil.a(c)) {
                        ContentValues contentValues = new ContentValues();
                        ImmutableList immutableList = AdminedPagesTable.f12834a;
                        int size = immutableList.size();
                        for (int i = 0; i < size; i++) {
                            contentValues.putNull(((SqlColumn) immutableList.get(i)).toString());
                        }
                        contentValues.put(Columns.f12824a.toString(), nodesModel.m4524c());
                        if (nodesModel.m4525d() != null) {
                            contentValues.put(Columns.f12825b.toString(), nodesModel.m4525d());
                        }
                        if (!(nodesModel.m4523b() == null || StringUtil.a(nodesModel.km_().a()))) {
                            contentValues.put(Columns.f12826c.toString(), nodesModel.km_().a());
                        }
                        if (!(nodesModel.m4526g() == null || nodesModel.m4526g().isEmpty())) {
                            contentValues.put(Columns.f12828e.toString(), StringUtil.b(":", new Object[]{nodesModel.m4526g()}));
                        }
                        if (nodesModel.m4523b() != null) {
                            contentValues.put(Columns.f12829f.toString(), String.valueOf(nodesModel.m4523b().a()));
                        }
                        String str = (String) result2.f4011a.get(c);
                        if (!StringUtil.a(str)) {
                            contentValues.put(Columns.f12830g.toString(), str);
                        }
                        SQLiteDetour.a(1050657195);
                        this.f12821b.a().insertOrThrow("admined_pages_table", "", contentValues);
                        SQLiteDetour.a(126336035);
                    }
                }
            }
        }
    }

    public final OperationResult m13663a() {
        Throwable th;
        this.f12822c.b();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("admined_pages_table");
        Cursor query;
        try {
            query = sQLiteQueryBuilder.query(this.f12821b.a(), f12819a, null, null, null, null, null);
            try {
                OperationResult a;
                if (query.moveToFirst()) {
                    Builder builder = new Builder();
                    Map hashMap = new HashMap();
                    int i = 0;
                    int columnIndex = query.getColumnIndex(Columns.f12824a.a());
                    int columnIndex2 = query.getColumnIndex(Columns.f12825b.a());
                    int columnIndex3 = query.getColumnIndex(Columns.f12826c.a());
                    int columnIndex4 = query.getColumnIndex(Columns.f12828e.a());
                    int columnIndex5 = query.getColumnIndex(Columns.f12829f.a());
                    int columnIndex6 = query.getColumnIndex(Columns.f12830g.a());
                    if (columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1 || columnIndex5 == -1 || columnIndex4 == -1 || columnIndex6 == -1) {
                        a = OperationResult.a(ErrorCode.CACHE_DISK_ERROR);
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        do {
                            ImmutableList immutableList = null;
                            try {
                                Object string = query.getString(columnIndex4);
                                if (!StringUtil.a(string)) {
                                    immutableList = new Builder().b(StringUtil.a(string, ':')).b();
                                }
                                String string2 = query.getString(columnIndex);
                                String string3 = query.getString(columnIndex6);
                                builder.c(new NodesModel.Builder().a(string2).b(query.getString(columnIndex2)).a(new ProfilePictureModel.Builder().a(query.getString(columnIndex3)).a()).a(immutableList).a(new AdminInfoModel.Builder().a(Boolean.valueOf(query.getString(columnIndex5)).booleanValue()).a()).a());
                                hashMap.put(string2, string3);
                                i++;
                            } catch (IllegalArgumentException e) {
                            }
                        } while (query.moveToNext());
                        AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.Builder a2 = new AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.Builder().a(new AdminedPagesModel.Builder().a(builder.b()).a(i).a());
                        long a3 = this.f12823d.a(AdminedPagesOperationConstants.f12806b, 0);
                        Result result = new Result(DataFreshnessResult.FROM_CACHE_STALE, a3, a2.a());
                        PagesAccessTokenPrefetchMethod.Result result2 = new PagesAccessTokenPrefetchMethod.Result(DataFreshnessResult.FROM_CACHE_STALE, a3, hashMap);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(result);
                        arrayList.add(result2);
                        a = OperationResult.a(arrayList);
                        if (query != null) {
                            query.close();
                        }
                    }
                } else {
                    a = OperationResult.a();
                    if (query != null) {
                        query.close();
                    }
                }
                return a;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
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
