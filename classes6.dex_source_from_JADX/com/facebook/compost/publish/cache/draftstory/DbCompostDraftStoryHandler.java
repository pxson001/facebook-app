package com.facebook.compost.publish.cache.draftstory;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.compost.publish.cache.draftstory.CompostDraftDbSchemaPart.DraftStoryTable.Columns;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_picker */
public class DbCompostDraftStoryHandler {
    private static volatile DbCompostDraftStoryHandler f8113c;
    public final CompostDraftDatabaseSupplier f8114a;
    private final FbObjectMapper f8115b;

    public static com.facebook.compost.publish.cache.draftstory.DbCompostDraftStoryHandler m11672a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8113c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.compost.publish.cache.draftstory.DbCompostDraftStoryHandler.class;
        monitor-enter(r1);
        r0 = f8113c;	 Catch:{ all -> 0x003a }
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
        r0 = m11674b(r0);	 Catch:{ all -> 0x0035 }
        f8113c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8113c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.compost.publish.cache.draftstory.DbCompostDraftStoryHandler.a(com.facebook.inject.InjectorLike):com.facebook.compost.publish.cache.draftstory.DbCompostDraftStoryHandler");
    }

    private static DbCompostDraftStoryHandler m11674b(InjectorLike injectorLike) {
        return new DbCompostDraftStoryHandler(CompostDraftDatabaseSupplier.m11668a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DbCompostDraftStoryHandler(CompostDraftDatabaseSupplier compostDraftDatabaseSupplier, FbObjectMapper fbObjectMapper) {
        this.f8114a = compostDraftDatabaseSupplier;
        this.f8115b = fbObjectMapper;
    }

    public final ImmutableList<CompostDraftStory> m11676a(long j) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("draft_story");
        Expression d = Columns.f8110b.d(String.valueOf(j));
        Cursor query = sQLiteQueryBuilder.query(this.f8114a.a(), null, d.a(), d.b(), null, null, null);
        if (query == null) {
            return ImmutableList.of();
        }
        int a = Columns.f8109a.a(query);
        int a2 = Columns.f8110b.a(query);
        int a3 = Columns.f8111c.a(query);
        Builder builder = new Builder();
        while (query.moveToNext()) {
            try {
                GraphQLStory graphQLStory = (GraphQLStory) this.f8115b.a(query.getString(a3), GraphQLStory.class);
                m11673a(query, a2, graphQLStory);
                builder.c(CompostDraftStory.m11618a(query.getString(a), graphQLStory));
            } catch (JsonMappingException e) {
                throw new IOException("When deserializing JSON blob into GraphQLStory, we had a mapping issure", e);
            } catch (JsonParseException e2) {
                throw new IOException("When deserializing JSON blob into GraphQLStory, we had a parsing error", e2);
            } catch (Throwable th) {
                query.close();
            }
        }
        query.close();
        return builder.b();
    }

    public final void m11677a(CompostDraftStory compostDraftStory) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.f8109a.toString(), compostDraftStory.mo934f());
            contentValues.put(Columns.f8110b.toString(), Long.valueOf(compostDraftStory.m11620a().V()));
            contentValues.put(Columns.f8111c.toString(), this.f8115b.a(compostDraftStory.m11620a()));
            SQLiteDetour.a(-1359440887);
            this.f8114a.a().replaceOrThrow("draft_story", "", contentValues);
            SQLiteDetour.a(701094639);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("CompostDraftStory couldn't be serialized into JSON for storage", e);
        }
    }

    public final int m11675a() {
        return this.f8114a.a().delete("draft_story", null, null);
    }

    private static void m11673a(Cursor cursor, int i, GraphQLStory graphQLStory) {
        boolean z;
        long j = cursor.getLong(i);
        long V = graphQLStory.V();
        if (V == j) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "The value in the 'creation_time' column does not match that in the GraphQLStory" + "\nCreation Time Column: " + j + "\nGraphQLStory Creation Time: " + V);
    }
}
