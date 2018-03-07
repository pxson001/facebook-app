package com.facebook.composer.publish.cache.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.publish.cache.db.ComposerDbSchemaPart.PendingStoryTable.Columns;
import com.facebook.composer.publish.cache.db.DbComposerHandler.SerializedPendingStoryPersistentData;
import com.facebook.composer.publish.common.PendingStoryPersistentData;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: unspecified tigon */
public class ComposerPublishDbCacheServiceHandler implements BlueServiceHandler$Filter {
    private static final Class<?> f536a = ComposerPublishDbCacheServiceHandler.class;
    private static volatile ComposerPublishDbCacheServiceHandler f537f;
    private final Context f538b;
    public final Provider<DbComposerHandler> f539c;
    private final AbstractFbErrorReporter f540d;
    public final ObjectMapper f541e;

    public static com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler m830a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f537f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler.class;
        monitor-enter(r1);
        r0 = f537f;	 Catch:{ all -> 0x003a }
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
        r0 = m832b(r0);	 Catch:{ all -> 0x0035 }
        f537f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f537f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler");
    }

    private static ComposerPublishDbCacheServiceHandler m832b(InjectorLike injectorLike) {
        return new ComposerPublishDbCacheServiceHandler((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.a(injectorLike, 860), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerPublishDbCacheServiceHandler(Context context, Provider<DbComposerHandler> provider, FbErrorReporter fbErrorReporter, ObjectMapper objectMapper) {
        this.f538b = context;
        this.f539c = provider;
        this.f540d = fbErrorReporter;
        this.f541e = objectMapper;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        if ("save_pending_story".equals(str)) {
            PendingStoryPersistentData pendingStoryPersistentData = (PendingStoryPersistentData) operationParams.c.getParcelable("pending_story_param_key");
            Preconditions.checkNotNull(pendingStoryPersistentData.a);
            Preconditions.checkNotNull(pendingStoryPersistentData.b);
            DbComposerHandler dbComposerHandler = (DbComposerHandler) this.f539c.get();
            ObjectMapper objectMapper = this.f541e;
            SerializedPendingStoryPersistentData serializedPendingStoryPersistentData = new SerializedPendingStoryPersistentData(pendingStoryPersistentData.b.a(), objectMapper.a(pendingStoryPersistentData.a), objectMapper.a(pendingStoryPersistentData.b));
            dbComposerHandler.f548e.b();
            Preconditions.checkNotNull(serializedPendingStoryPersistentData);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.f553a.toString(), serializedPendingStoryPersistentData.a);
            contentValues.put(Columns.f555c.toString(), serializedPendingStoryPersistentData.b);
            contentValues.put(Columns.f554b.toString(), serializedPendingStoryPersistentData.c);
            SQLiteDetour.a(-1915444211);
            dbComposerHandler.f547d.a().replaceOrThrow("pending_story", "", contentValues);
            SQLiteDetour.a(-523506705);
            dbComposerHandler.f550g.edit().putBoolean(ComposerPrefKeys.f, true).commit();
            return OperationResult.a;
        } else if ("delete_pending_story".equals(str)) {
            return m834b(operationParams);
        } else {
            if ("delete_all_pending_stories".equals(str)) {
                return m833b();
            }
            return blueServiceHandler.a(operationParams);
        }
    }

    private OperationResult m834b(OperationParams operationParams) {
        return m831a(operationParams.c.getString("request_id_param_key"));
    }

    private OperationResult m831a(String str) {
        DbComposerHandler dbComposerHandler = (DbComposerHandler) this.f539c.get();
        dbComposerHandler.f548e.b();
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        Expression a = Columns.f553a.a(str);
        dbComposerHandler.f547d.a().delete("pending_story", a.a(), a.b());
        if (DatabaseUtils.queryNumEntries(dbComposerHandler.f547d.a(), "pending_story") == 0) {
            dbComposerHandler.f550g.edit().putBoolean(ComposerPrefKeys.f, false).commit();
        }
        return OperationResult.a;
    }

    private OperationResult m833b() {
        DbComposerHandler dbComposerHandler = (DbComposerHandler) this.f539c.get();
        dbComposerHandler.f548e.b();
        dbComposerHandler.f547d.a().delete("pending_story", null, null);
        dbComposerHandler.f550g.edit().putBoolean(ComposerPrefKeys.f, false).commit();
        return OperationResult.a;
    }

    @Nonnull
    public final ImmutableList<PendingStoryPersistentData> m836a() {
        ImmutableList d = ((DbComposerHandler) this.f539c.get()).m849d();
        Builder builder = ImmutableList.builder();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            SerializedPendingStoryPersistentData serializedPendingStoryPersistentData = (SerializedPendingStoryPersistentData) d.get(i);
            try {
                PendingStoryPersistentData a = serializedPendingStoryPersistentData.a(this.f541e);
                Preconditions.checkNotNull(a.b.a());
                Preconditions.checkArgument(a.b.a().equals(serializedPendingStoryPersistentData.a));
                builder.c(a);
            } catch (Throwable e) {
                this.f540d.a("composer_publish_db_deserialize_fail", "story=" + serializedPendingStoryPersistentData.b + ", publish=" + serializedPendingStoryPersistentData.c, e);
                m831a(serializedPendingStoryPersistentData.a);
            }
        }
        return builder.b();
    }
}
