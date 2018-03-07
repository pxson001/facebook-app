package com.facebook.graphql.cursor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.collect.LongArraySet;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlTable;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.cursor.CursorModelCache;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.executor.filemap.FlatBufferModelFileManager;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CacheVisitorAnalytics;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: metaline_1 */
public class GraphCursorDatabase implements IHaveUserData, DiskTrimmable {
    private static final String f7854a = GraphCursorDatabase.class.getSimpleName();
    private static volatile GraphCursorDatabase f7855i;
    private final GraphCursorDatabaseSupplier f7856b;
    private final Clock f7857c;
    private final File f7858d;
    private final QuickPerformanceLogger f7859e;
    public final SessionHolder f7860f;
    private final AtomicLong f7861g = new AtomicLong(1);
    private final AtomicInteger f7862h = new AtomicInteger(1);

    /* compiled from: metaline_1 */
    class TrackedCursor extends CursorWrapper {
        final /* synthetic */ GraphCursorDatabase f8020a;
        private final String f8021b;
        private final Bundle f8022c;

        public TrackedCursor(GraphCursorDatabase graphCursorDatabase, Cursor cursor, String str, Bundle bundle) {
            this.f8020a = graphCursorDatabase;
            super(cursor);
            this.f8021b = str;
            this.f8022c = bundle;
        }

        public void close() {
            this.f8020a.f7860f.m8189b(this.f8021b);
            super.close();
        }

        public Bundle getExtras() {
            return this.f8022c;
        }
    }

    public static com.facebook.graphql.cursor.database.GraphCursorDatabase m8126a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7855i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.cursor.database.GraphCursorDatabase.class;
        monitor-enter(r1);
        r0 = f7855i;	 Catch:{ all -> 0x003a }
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
        r0 = m8140b(r0);	 Catch:{ all -> 0x0035 }
        f7855i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7855i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDatabase.a(com.facebook.inject.InjectorLike):com.facebook.graphql.cursor.database.GraphCursorDatabase");
    }

    private void m8131a(long r8, long r10, com.facebook.flatbuffers.MutableFlattenable r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r0 = r7.f7856b;
        r1 = r0.a();
        r0 = r7.f7859e;
        r2 = 8716301; // 0x85000d float:1.2214139E-38 double:4.306425E-317;
        r0.b(r2);
        r0 = r12.w_();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = r0.c();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2.<init>();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ModelsTable$Columns.f7886d;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.a();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        if (r0 == 0) goto L_0x00ac;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
    L_0x0023:
        r0 = r0.array();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
    L_0x0027:
        r2.put(r3, r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = "models";	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3.<init>();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ModelsTable$Columns.f7883a;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = r4.a();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = " = ?";	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = 1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r5 = 0;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r6 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = r1.update(r0, r2, r3, r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = 1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        if (r0 != r2) goto L_0x00af;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
    L_0x0056:
        r0 = 1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
    L_0x0057:
        com.google.common.base.Preconditions.checkState(r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = new android.content.ContentValues;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0.<init>();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7871f;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = r2.a();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r7.f7857c;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = r3.a();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = "connections";	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3.<init>();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = r4.a();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = " = ?";	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = 1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r5 = 0;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r6 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = r1.update(r2, r0, r3, r4);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r1 = 1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        if (r0 != r1) goto L_0x00b1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
    L_0x009e:
        r0 = 1;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
    L_0x009f:
        com.google.common.base.Preconditions.checkState(r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = r7.f7859e;
        r1 = 8716301; // 0x85000d float:1.2214139E-38 double:4.306425E-317;
        r2 = 2;
        r0.b(r1, r2);
    L_0x00ab:
        return;
    L_0x00ac:
        r0 = 0;
        goto L_0x0027;
    L_0x00af:
        r0 = 0;
        goto L_0x0057;
    L_0x00b1:
        r0 = 0;
        goto L_0x009f;
    L_0x00b3:
        r0 = move-exception;
        r1 = f7854a;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = "Unable to update delta buffer";	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        com.facebook.debug.log.BLog.b(r1, r2, r0);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = r7.f7859e;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r1 = 8716301; // 0x85000d float:1.2214139E-38 double:4.306425E-317;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r2 = 3;	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0.b(r1, r2);	 Catch:{ Exception -> 0x00b3, all -> 0x00ce }
        r0 = r7.f7859e;
        r1 = 8716301; // 0x85000d float:1.2214139E-38 double:4.306425E-317;
        r2 = 2;
        r0.b(r1, r2);
        goto L_0x00ab;
    L_0x00ce:
        r0 = move-exception;
        r1 = r7.f7859e;
        r2 = 8716301; // 0x85000d float:1.2214139E-38 double:4.306425E-317;
        r3 = 2;
        r1.b(r2, r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDatabase.a(long, long, com.facebook.flatbuffers.MutableFlattenable):void");
    }

    private synchronized java.util.Map<java.lang.String, com.facebook.graphql.cursor.database.GraphCursorDatabase.ChangeSet> m8147c(java.util.Collection<java.lang.String> r28, @javax.annotation.Nullable com.facebook.graphql.executor.iface.CacheVisitor r29, java.util.Collection<com.facebook.graphql.executor.iface.CacheVisitor> r30) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 15, insn: 0x0217: MOVE  (r3 ?[OBJECT, ARRAY]) = (r15 ?[OBJECT, ARRAY]), block:B:90:0x0217, method: com.facebook.graphql.cursor.database.GraphCursorDatabase.c(java.util.Collection, com.facebook.graphql.executor.iface.CacheVisitor, java.util.Collection):java.util.Map<java.lang.String, com.facebook.graphql.cursor.database.GraphCursorDatabase$ChangeSet>
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:168)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r27 = this;
        monitor-enter(r27);
        r0 = r27;
        r2 = r0.f7856b;
        r16 = r2.a();
        r17 = new java.util.HashMap;
        r17.<init>();
        r3 = 0;
        r2 = r28.size();
        r2 = new java.lang.String[r2];
        r0 = r28;
        r2 = r0.toArray(r2);
        r2 = (java.lang.String[]) r2;
        r4 = 1497247918; // 0x593e30ae float:3.34586059E15 double:7.397387596E-315;
        r0 = r16;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r0, r4);
        r0 = r27;	 Catch:{ all -> 0x0179 }
        r1 = r16;	 Catch:{ all -> 0x0179 }
        r18 = m8123a(r1, r2);	 Catch:{ all -> 0x0179 }
        r15 = 0;
        r19 = r18.getCount();	 Catch:{ all -> 0x0216, all -> 0x016b }
        if (r19 <= 0) goto L_0x0231;	 Catch:{ all -> 0x0216, all -> 0x016b }
    L_0x0034:
        r20 = new com.facebook.graphql.cursor.ModelReader;	 Catch:{ all -> 0x0216, all -> 0x016b }
        r0 = r20;	 Catch:{ all -> 0x0216, all -> 0x016b }
        r1 = r18;	 Catch:{ all -> 0x0216, all -> 0x016b }
        r0.<init>(r1);	 Catch:{ all -> 0x0216, all -> 0x016b }
        r14 = 0;
        r2 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = r2.a();	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r0 = r18;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r21 = r0.getColumnIndexOrThrow(r2);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = r2.a();	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r0 = r18;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r22 = r0.getColumnIndexOrThrow(r2);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7867b;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = r2.a();	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r0 = r18;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r23 = r0.getColumnIndexOrThrow(r2);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7868c;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = r2.a();	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r0 = r18;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r24 = r0.getColumnIndexOrThrow(r2);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = "tags";	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r0 = r18;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r25 = r0.getColumnIndexOrThrow(r2);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r2 = r3;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
    L_0x0077:
        r3 = r18.moveToNext();	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        if (r3 == 0) goto L_0x0196;
    L_0x007d:
        r0 = r27;	 Catch:{ Exception -> 0x0142 }
        r3 = r0.f7859e;	 Catch:{ Exception -> 0x0142 }
        r4 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ Exception -> 0x0142 }
        r3.b(r4);	 Catch:{ Exception -> 0x0142 }
        r12 = r20.m8336c();	 Catch:{ Exception -> 0x0142 }
        r12 = (com.facebook.flatbuffers.MutableFlattenable) r12;	 Catch:{ Exception -> 0x0142 }
        r0 = r18;	 Catch:{ Exception -> 0x0142 }
        r1 = r25;	 Catch:{ Exception -> 0x0142 }
        r3 = r0.getString(r1);	 Catch:{ Exception -> 0x0142 }
        r13 = 0;	 Catch:{ Exception -> 0x0142 }
        if (r3 == 0) goto L_0x009e;	 Catch:{ Exception -> 0x0142 }
    L_0x0098:
        r4 = ",";	 Catch:{ Exception -> 0x0142 }
        r13 = android.text.TextUtils.split(r3, r4);	 Catch:{ Exception -> 0x0142 }
    L_0x009e:
        r0 = r18;	 Catch:{ Exception -> 0x0142 }
        r1 = r21;	 Catch:{ Exception -> 0x0142 }
        r6 = r0.getLong(r1);	 Catch:{ Exception -> 0x0142 }
        r0 = r18;	 Catch:{ Exception -> 0x0142 }
        r1 = r23;	 Catch:{ Exception -> 0x0142 }
        r8 = r0.getLong(r1);	 Catch:{ Exception -> 0x0142 }
        r0 = r18;	 Catch:{ Exception -> 0x0142 }
        r1 = r24;	 Catch:{ Exception -> 0x0142 }
        r10 = r0.getLong(r1);	 Catch:{ Exception -> 0x0142 }
        r3 = r27;	 Catch:{ Exception -> 0x0142 }
        r4 = r29;	 Catch:{ Exception -> 0x0142 }
        r5 = r30;	 Catch:{ Exception -> 0x0142 }
        r3 = m8136a(r4, r5, r6, r8, r10, r12, r13);	 Catch:{ Exception -> 0x0142 }
        r0 = r27;	 Catch:{ Exception -> 0x0142 }
        r4 = r0.f7859e;	 Catch:{ Exception -> 0x0142 }
        r5 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ Exception -> 0x0142 }
        r4 = r4.f(r5);	 Catch:{ Exception -> 0x0142 }
        if (r4 == 0) goto L_0x0101;	 Catch:{ Exception -> 0x0142 }
    L_0x00cd:
        r0 = r27;	 Catch:{ Exception -> 0x0142 }
        r4 = r0.f7859e;	 Catch:{ Exception -> 0x0142 }
        r5 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ Exception -> 0x0142 }
        r6 = "model_class_name";	 Catch:{ Exception -> 0x0142 }
        r7 = r20.m8335b();	 Catch:{ Exception -> 0x0142 }
        r4.b(r5, r6, r7);	 Catch:{ Exception -> 0x0142 }
        r0 = r27;	 Catch:{ Exception -> 0x0142 }
        r4 = r0.f7859e;	 Catch:{ Exception -> 0x0142 }
        r5 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ Exception -> 0x0142 }
        r6 = "row_tags_count";	 Catch:{ Exception -> 0x0142 }
        r7 = r28.size();	 Catch:{ Exception -> 0x0142 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x0142 }
        r4.b(r5, r6, r7);	 Catch:{ Exception -> 0x0142 }
        r0 = r27;	 Catch:{ Exception -> 0x0142 }
        r4 = r0.f7859e;	 Catch:{ Exception -> 0x0142 }
        r5 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ Exception -> 0x0142 }
        r6 = "row_was_updated";	 Catch:{ Exception -> 0x0142 }
        r7 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0142 }
        r4.b(r5, r6, r7);	 Catch:{ Exception -> 0x0142 }
    L_0x0101:
        if (r3 == 0) goto L_0x022e;
    L_0x0103:
        r3 = r2 + 1;
        r0 = r18;	 Catch:{ Exception -> 0x022a }
        r1 = r22;	 Catch:{ Exception -> 0x022a }
        r2 = r0.getString(r1);	 Catch:{ Exception -> 0x022a }
        r0 = r17;	 Catch:{ Exception -> 0x022a }
        r4 = r0.containsKey(r2);	 Catch:{ Exception -> 0x022a }
        if (r4 != 0) goto L_0x011f;	 Catch:{ Exception -> 0x022a }
    L_0x0115:
        r4 = new com.facebook.graphql.cursor.database.GraphCursorDatabase$ChangeSet;	 Catch:{ Exception -> 0x022a }
        r4.<init>();	 Catch:{ Exception -> 0x022a }
        r0 = r17;	 Catch:{ Exception -> 0x022a }
        r0.put(r2, r4);	 Catch:{ Exception -> 0x022a }
    L_0x011f:
        r0 = r17;	 Catch:{ Exception -> 0x022a }
        r2 = r0.get(r2);	 Catch:{ Exception -> 0x022a }
        r2 = (com.facebook.graphql.cursor.database.GraphCursorDatabase.ChangeSet) r2;	 Catch:{ Exception -> 0x022a }
        r2 = r2.a;	 Catch:{ Exception -> 0x022a }
        r0 = r18;	 Catch:{ Exception -> 0x022a }
        r1 = r21;	 Catch:{ Exception -> 0x022a }
        r4 = r0.getLong(r1);	 Catch:{ Exception -> 0x022a }
        r2.a(r4);	 Catch:{ Exception -> 0x022a }
    L_0x0134:
        r0 = r27;	 Catch:{  }
        r2 = r0.f7859e;	 Catch:{  }
        r4 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{  }
        r5 = 2;	 Catch:{  }
        r2.b(r4, r5);	 Catch:{  }
        r2 = r3;
        goto L_0x0077;
    L_0x0142:
        r3 = move-exception;
    L_0x0143:
        r0 = r27;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r3 = r0.f7859e;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r4 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r5 = 3;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r3.b(r4, r5);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r0 = r27;	 Catch:{  }
        r3 = r0.f7859e;	 Catch:{  }
        r4 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{  }
        r5 = 2;	 Catch:{  }
        r3.b(r4, r5);	 Catch:{  }
        goto L_0x0077;
    L_0x015b:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
    L_0x015d:
        r3 = move-exception;
        r26 = r3;
        r3 = r2;
        r2 = r26;
    L_0x0163:
        if (r3 == 0) goto L_0x021a;
    L_0x0165:
        r20.close();	 Catch:{ Throwable -> 0x0210, all -> 0x0216 }
    L_0x0168:
        throw r2;	 Catch:{  }
    L_0x0169:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x0216, all -> 0x016b }
    L_0x016b:
        r3 = move-exception;
        r26 = r3;
        r3 = r2;
        r2 = r26;
    L_0x0171:
        if (r18 == 0) goto L_0x0178;
    L_0x0173:
        if (r3 == 0) goto L_0x0225;
    L_0x0175:
        r18.close();	 Catch:{ Throwable -> 0x021f }
    L_0x0178:
        throw r2;	 Catch:{  }
    L_0x0179:
        r2 = move-exception;
        r3 = 1690720131; // 0x64c65783 float:2.927009E22 double:8.353267335E-315;
        r0 = r16;	 Catch:{ all -> 0x0179 }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{ all -> 0x0179 }
        throw r2;	 Catch:{ all -> 0x0179 }
    L_0x0183:
        r2 = move-exception;
        monitor-exit(r27);
        throw r2;
    L_0x0186:
        r2 = move-exception;
        r0 = r27;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r3 = r0.f7859e;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r4 = 8716304; // 0x850010 float:1.2214143E-38 double:4.3064264E-317;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r5 = 2;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r3.b(r4, r5);	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        throw r2;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
    L_0x0193:
        r2 = move-exception;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r3 = r14;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        goto L_0x0163;	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
    L_0x0196:
        r16.setTransactionSuccessful();	 Catch:{ all -> 0x0193, all -> 0x015d, all -> 0x0186 }
        r20.close();	 Catch:{  }
    L_0x019c:
        if (r18 == 0) goto L_0x01a1;
    L_0x019e:
        r18.close();	 Catch:{  }
    L_0x01a1:
        r3 = 1637606255; // 0x619be36f float:3.594542E20 double:8.09084992E-315;
        r0 = r16;	 Catch:{  }
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r0, r3);	 Catch:{  }
        r0 = r27;	 Catch:{  }
        r3 = r0.f7859e;	 Catch:{  }
        r4 = 8716305; // 0x850011 float:1.2214145E-38 double:4.306427E-317;	 Catch:{  }
        r3 = r3.f(r4);	 Catch:{  }
        if (r3 == 0) goto L_0x020e;	 Catch:{  }
    L_0x01b6:
        r0 = r27;	 Catch:{  }
        r3 = r0.f7859e;	 Catch:{  }
        r4 = 8716305; // 0x850011 float:1.2214145E-38 double:4.306427E-317;	 Catch:{  }
        r5 = "confirmed_visitor_name";	 Catch:{  }
        r6 = m8141b(r29);	 Catch:{  }
        r3.b(r4, r5, r6);	 Catch:{  }
        r0 = r27;	 Catch:{  }
        r3 = r0.f7859e;	 Catch:{  }
        r4 = 8716305; // 0x850011 float:1.2214145E-38 double:4.306427E-317;	 Catch:{  }
        r5 = "tags_to_visit_count";	 Catch:{  }
        r6 = r28.size();	 Catch:{  }
        r6 = java.lang.String.valueOf(r6);	 Catch:{  }
        r3.b(r4, r5, r6);	 Catch:{  }
        r0 = r27;	 Catch:{  }
        r3 = r0.f7859e;	 Catch:{  }
        r4 = 8716305; // 0x850011 float:1.2214145E-38 double:4.306427E-317;	 Catch:{  }
        r5 = "rows_visited_count";	 Catch:{  }
        r6 = java.lang.String.valueOf(r19);	 Catch:{  }
        r3.b(r4, r5, r6);	 Catch:{  }
        r0 = r27;	 Catch:{  }
        r3 = r0.f7859e;	 Catch:{  }
        r4 = 8716305; // 0x850011 float:1.2214145E-38 double:4.306427E-317;	 Catch:{  }
        r5 = "rows_updated_count";	 Catch:{  }
        r2 = java.lang.String.valueOf(r2);	 Catch:{  }
        r3.b(r4, r5, r2);	 Catch:{  }
        r0 = r27;	 Catch:{  }
        r2 = r0.f7859e;	 Catch:{  }
        r3 = 8716305; // 0x850011 float:1.2214145E-38 double:4.306427E-317;	 Catch:{  }
        r4 = "sessions_updated_count";	 Catch:{  }
        r5 = r17.size();	 Catch:{  }
        r5 = java.lang.String.valueOf(r5);	 Catch:{  }
        r2.b(r3, r4, r5);	 Catch:{  }
    L_0x020e:
        monitor-exit(r27);
        return r17;
    L_0x0210:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x0168;	 Catch:{  }
    L_0x0216:
        r2 = move-exception;	 Catch:{  }
        r3 = r15;	 Catch:{  }
        goto L_0x0171;	 Catch:{  }
    L_0x021a:
        r20.close();	 Catch:{  }
        goto L_0x0168;
    L_0x021f:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r3, r4);	 Catch:{  }
        goto L_0x0178;	 Catch:{  }
    L_0x0225:
        r18.close();	 Catch:{  }
        goto L_0x0178;
    L_0x022a:
        r2 = move-exception;
        r2 = r3;
        goto L_0x0143;
    L_0x022e:
        r3 = r2;
        goto L_0x0134;
    L_0x0231:
        r2 = r3;
        goto L_0x019c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDatabase.c(java.util.Collection, com.facebook.graphql.executor.iface.CacheVisitor, java.util.Collection):java.util.Map<java.lang.String, com.facebook.graphql.cursor.database.GraphCursorDatabase$ChangeSet>");
    }

    public final synchronized <TEdge> void m8162a(java.lang.String r12, java.lang.String r13, com.google.common.base.Predicate<TEdge> r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r11 = this;
        r2 = 0;
        monitor-enter(r11);
        r0 = r11.f7856b;
        r3 = r0.a();
        r4 = new java.util.HashMap;
        r4.<init>();
        r0 = new com.facebook.graphql.cursor.database.GraphCursorDatabase$ChangeSet;
        r0.<init>();
        r4.put(r12, r0);
        r0 = "tag";
        r1 = 1;
        r1 = new java.lang.String[r1];
        r5 = 0;
        r1[r5] = r13;
        r0 = com.facebook.database.sqlite.SqlExpression.a(r0, r1);
        r1 = 1077860768; // 0x403ed9a0 float:2.9820328 double:5.325339765E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r3, r1);
        r1 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5 = "SELECT connections._id AS _id, connections.sort_key AS sort_key, connections.version AS version, connections.flags AS flags, connections.tags AS tags, models.file AS file, models.offset AS offset, models.mutation_data AS mutation_data, models.class AS class, connections.optimistic_model - connections.confirmed_model AS is_optimistic FROM connections INNER JOIN models ON connections.optimistic_model = models._id WHERE connections.session_id = ? AND connections._id IN (SELECT node_id FROM tags WHERE ";	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r1.<init>(r5);	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r0 = r0.a();	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r0 = r1.append(r0);	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r1 = ")";	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r0 = r0.append(r1);	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r0 = r0.toString();	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r1 = 2;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r1 = new java.lang.String[r1];	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5 = 0;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r1[r5] = r12;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5 = 1;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r1[r5] = r13;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5 = r3.rawQuery(r0, r1);	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r0 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a;	 Catch:{ all -> 0x00cb, all -> 0x008d }
        r0 = r0.a();	 Catch:{ all -> 0x00cb, all -> 0x008d }
        r1 = r5.getColumnIndexOrThrow(r0);	 Catch:{ all -> 0x00cb, all -> 0x008d }
        r6 = new com.facebook.graphql.cursor.ModelReader;	 Catch:{ all -> 0x00cb, all -> 0x008d }
        r6.<init>(r5);	 Catch:{ all -> 0x00cb, all -> 0x008d }
    L_0x005c:
        r0 = r5.moveToNext();	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        if (r0 == 0) goto L_0x00b1;	 Catch:{ all -> 0x00e2, all -> 0x0081 }
    L_0x0062:
        r0 = r6.m8336c();	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        r0 = r14.apply(r0);	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        if (r0 == 0) goto L_0x005c;	 Catch:{ all -> 0x00e2, all -> 0x0081 }
    L_0x006c:
        r8 = r5.getLong(r1);	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        r0 = r4.get(r12);	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        r0 = (com.facebook.graphql.cursor.database.GraphCursorDatabase.ChangeSet) r0;	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        r0 = r0.b;	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        r0.a(r8);	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        m8133a(r3, r8);	 Catch:{ all -> 0x00e2, all -> 0x0081 }
        goto L_0x005c;
    L_0x007f:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00e2, all -> 0x0081 }
    L_0x0081:
        r1 = move-exception;
        r10 = r1;
        r1 = r0;
        r0 = r10;
    L_0x0085:
        if (r1 == 0) goto L_0x00cd;
    L_0x0087:
        r6.close();	 Catch:{ Throwable -> 0x00c6, all -> 0x00cb }
    L_0x008a:
        throw r0;	 Catch:{  }
    L_0x008b:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00cb, all -> 0x008d }
    L_0x008d:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0090:
        if (r5 == 0) goto L_0x0097;
    L_0x0092:
        if (r2 == 0) goto L_0x00de;
    L_0x0094:
        r5.close();	 Catch:{ Throwable -> 0x00d1 }
    L_0x0097:
        throw r0;	 Catch:{  }
    L_0x0098:
        r0 = move-exception;
        r1 = f7854a;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r2 = "Failed to delete edge with tag:%s";	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5 = 1;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5 = new java.lang.Object[r5];	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r6 = 0;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r5[r6] = r13;	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        com.facebook.debug.log.BLog.b(r1, r0, r2, r5);	 Catch:{ SQLException -> 0x0098, all -> 0x00d6 }
        r0 = 322433050; // 0x1337f01a float:2.3216227E-27 double:1.59303093E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r3, r0);	 Catch:{  }
    L_0x00ac:
        r11.m8135a(r4);	 Catch:{  }
        monitor-exit(r11);
        return;
    L_0x00b1:
        r3.setTransactionSuccessful();	 Catch:{  }
        r6.close();	 Catch:{  }
        if (r5 == 0) goto L_0x00bc;
    L_0x00b9:
        r5.close();	 Catch:{  }
    L_0x00bc:
        r0 = 263641238; // 0xfb6d896 float:1.8030011E-29 double:1.302560785E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r3, r0);	 Catch:{  }
        goto L_0x00ac;
    L_0x00c3:
        r0 = move-exception;
        monitor-exit(r11);
        throw r0;
    L_0x00c6:
        r6 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r6);	 Catch:{  }
        goto L_0x008a;	 Catch:{  }
    L_0x00cb:
        r0 = move-exception;	 Catch:{  }
        goto L_0x0090;	 Catch:{  }
    L_0x00cd:
        r6.close();	 Catch:{  }
        goto L_0x008a;
    L_0x00d1:
        r1 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r2, r1);	 Catch:{  }
        goto L_0x0097;
    L_0x00d6:
        r0 = move-exception;
        r1 = 909927399; // 0x363c63e7 float:2.8072334E-6 double:4.49563868E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r3, r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00de:
        r5.close();	 Catch:{  }
        goto L_0x0097;
    L_0x00e2:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDatabase.a(java.lang.String, java.lang.String, com.google.common.base.Predicate):void");
    }

    public final synchronized void m8166b(java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r9 = this;
        monitor-enter(r9);
        r2 = new com.facebook.graphql.cursor.database.GraphCursorDatabase$ChangeSet;
        r2.<init>();
        r0 = r9.f7856b;
        r3 = r0.a();
        r0 = r9.f7859e;
        r1 = 8716298; // 0x85000a float:1.2214135E-38 double:4.3064234E-317;
        r0.b(r1);
        r0 = 1304970372; // 0x4dc84484 float:4.1999168E8 double:6.447410296E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r3, r0);
        r4 = m8139b(r3, r10);	 Catch:{ SQLException -> 0x009e, all -> 0x00c0 }
        r1 = 0;
        r0 = r4.moveToFirst();	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        if (r0 == 0) goto L_0x003e;	 Catch:{ all -> 0x00d5, all -> 0x0092 }
    L_0x0025:
        r0 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a;	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        r0 = r0.a();	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        r0 = r4.getColumnIndexOrThrow(r0);	 Catch:{ all -> 0x00d5, all -> 0x0092 }
    L_0x002f:
        r6 = r4.getLong(r0);	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        r5 = r2.b;	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        r5.a(r6);	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        r5 = r4.moveToNext();	 Catch:{ all -> 0x00d5, all -> 0x0092 }
        if (r5 != 0) goto L_0x002f;
    L_0x003e:
        if (r4 == 0) goto L_0x0043;
    L_0x0040:
        r4.close();	 Catch:{  }
    L_0x0043:
        r0 = "connections";	 Catch:{  }
        r1 = new java.lang.StringBuilder;	 Catch:{  }
        r1.<init>();	 Catch:{  }
        r4 = com.facebook.graphql.cursor.database.GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d;	 Catch:{  }
        r1 = r1.append(r4);	 Catch:{  }
        r4 = " = ?";	 Catch:{  }
        r1 = r1.append(r4);	 Catch:{  }
        r1 = r1.toString();	 Catch:{  }
        r4 = 1;	 Catch:{  }
        r4 = new java.lang.String[r4];	 Catch:{  }
        r5 = 0;	 Catch:{  }
        r4[r5] = r10;	 Catch:{  }
        r3.delete(r0, r1, r4);	 Catch:{  }
        m8156g(r3);	 Catch:{  }
        m8155f(r3);	 Catch:{  }
        r3.setTransactionSuccessful();	 Catch:{  }
        r0 = 1286668242; // 0x4cb0ffd2 float:9.2798608E7 double:6.35698576E-315;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r3, r0);	 Catch:{  }
        r0 = r9.f7859e;	 Catch:{  }
        r1 = 8716298; // 0x85000a float:1.2214135E-38 double:4.3064234E-317;	 Catch:{  }
        r3 = 2;	 Catch:{  }
        r0.b(r1, r3);	 Catch:{  }
    L_0x007b:
        r0 = r2.b;	 Catch:{  }
        r0 = r0.a();	 Catch:{  }
        if (r0 != 0) goto L_0x008e;	 Catch:{  }
    L_0x0083:
        r0 = new java.util.HashMap;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r0.put(r10, r2);	 Catch:{  }
        r9.m8135a(r0);	 Catch:{  }
    L_0x008e:
        monitor-exit(r9);
        return;
    L_0x0090:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00d5, all -> 0x0092 }
    L_0x0092:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0096:
        if (r4 == 0) goto L_0x009d;
    L_0x0098:
        if (r1 == 0) goto L_0x00d1;
    L_0x009a:
        r4.close();	 Catch:{ Throwable -> 0x00bb }
    L_0x009d:
        throw r0;	 Catch:{  }
    L_0x009e:
        r0 = move-exception;
        r0 = r9.f7859e;	 Catch:{ SQLException -> 0x009e, all -> 0x00c0 }
        r1 = 8716298; // 0x85000a float:1.2214135E-38 double:4.3064234E-317;	 Catch:{ SQLException -> 0x009e, all -> 0x00c0 }
        r4 = 3;	 Catch:{ SQLException -> 0x009e, all -> 0x00c0 }
        r0.b(r1, r4);	 Catch:{ SQLException -> 0x009e, all -> 0x00c0 }
        r0 = -966302987; // 0xffffffffc66762f5 float:-14808.739 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r3, r0);	 Catch:{  }
        r0 = r9.f7859e;	 Catch:{  }
        r1 = 8716298; // 0x85000a float:1.2214135E-38 double:4.3064234E-317;	 Catch:{  }
        r3 = 2;	 Catch:{  }
        r0.b(r1, r3);	 Catch:{  }
        goto L_0x007b;
    L_0x00b8:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x00bb:
        r4 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r4);	 Catch:{  }
        goto L_0x009d;
    L_0x00c0:
        r0 = move-exception;
        r1 = 140589434; // 0x861397a float:6.777604E-34 double:6.94604095E-316;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r3, r1);	 Catch:{  }
        r1 = r9.f7859e;	 Catch:{  }
        r2 = 8716298; // 0x85000a float:1.2214135E-38 double:4.3064234E-317;	 Catch:{  }
        r3 = 2;	 Catch:{  }
        r1.b(r2, r3);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x00d1:
        r4.close();	 Catch:{  }
        goto L_0x009d;
    L_0x00d5:
        r0 = move-exception;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDatabase.b(java.lang.String):void");
    }

    private static GraphCursorDatabase m8140b(InjectorLike injectorLike) {
        return new GraphCursorDatabase((Context) injectorLike.getInstance(Context.class), GraphCursorDatabaseSupplier.m8168a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (DiskTrimmableRegistry) DiskCacheManager.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), CursorModelCache.m8182a(injectorLike));
    }

    @Inject
    public GraphCursorDatabase(Context context, GraphCursorDatabaseSupplier graphCursorDatabaseSupplier, Clock clock, DiskTrimmableRegistry diskTrimmableRegistry, QuickPerformanceLogger quickPerformanceLogger, CursorModelCache cursorModelCache) {
        this.f7856b = graphCursorDatabaseSupplier;
        this.f7857c = clock;
        this.f7859e = quickPerformanceLogger;
        this.f7858d = new File(context.getFilesDir().getAbsolutePath(), "graph_cursor");
        this.f7860f = new SessionHolder(cursorModelCache);
        diskTrimmableRegistry.a(this);
    }

    @VisibleForTesting
    private SQLiteDatabase m8151d() {
        return this.f7856b.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.database.Cursor m8158a(java.lang.String r9) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.f7860f;	 Catch:{ all -> 0x0065 }
        r0.m8187a(r9);	 Catch:{ all -> 0x0065 }
        r2 = r8.m8151d();	 Catch:{ all -> 0x0065 }
        r0 = 2121406221; // 0x7e72170d float:8.0448215E37 double:1.0481139347E-314;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.a(r2, r0);	 Catch:{ all -> 0x0065 }
        r3 = m8120a(r2, r9);	 Catch:{ all -> 0x005d }
        r1 = 0;
        r0 = m8129a(r3);	 Catch:{ Throwable -> 0x0052 }
        if (r3 == 0) goto L_0x001e;
    L_0x001b:
        r3.close();	 Catch:{  }
    L_0x001e:
        r1 = "SELECT connections._id AS _id, connections.sort_key AS sort_key, connections.version AS version, connections.flags AS flags, connections.tags AS tags, models.file AS file, models.offset AS offset, models.mutation_data AS mutation_data, models.class AS class, connections.optimistic_model - connections.confirmed_model AS is_optimistic FROM connections INNER JOIN models ON connections.optimistic_model = models._id WHERE connections.session_id=? ORDER BY connections.sort_key DESC";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{  }
        r4 = 0;
        r3[r4] = r9;	 Catch:{  }
        r1 = r2.rawQuery(r1, r3);	 Catch:{  }
        r1.getCount();	 Catch:{  }
        r3 = new android.os.Bundle;	 Catch:{  }
        r3.<init>();	 Catch:{  }
        r4 = "CHANGE_NUMBER";
        r5 = r8.f7861g;	 Catch:{  }
        r6 = r5.get();	 Catch:{  }
        r3.putLong(r4, r6);	 Catch:{  }
        r4 = "CHUNKS";
        r3.putParcelableArrayList(r4, r0);	 Catch:{  }
        r2.setTransactionSuccessful();	 Catch:{  }
        r0 = new com.facebook.graphql.cursor.database.GraphCursorDatabase$TrackedCursor;	 Catch:{  }
        r0.<init>(r8, r1, r9, r3);	 Catch:{  }
        r1 = -803846277; // 0xffffffffd016477b float:-1.00850678E10 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r2, r1);	 Catch:{  }
        monitor-exit(r8);
        return r0;
    L_0x0052:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0054 }
    L_0x0054:
        r0 = move-exception;
        if (r3 == 0) goto L_0x005c;
    L_0x0057:
        if (r1 == 0) goto L_0x006d;
    L_0x0059:
        r3.close();	 Catch:{ Throwable -> 0x0068 }
    L_0x005c:
        throw r0;	 Catch:{  }
    L_0x005d:
        r0 = move-exception;
        r1 = -1353630293; // 0xffffffffaf513dab float:-1.9030348E-10 double:NaN;
        com.facebook.tools.dextr.runtime.detour.SQLiteDetour.b(r2, r1);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0065:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x0068:
        r3 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r3);	 Catch:{  }
        goto L_0x005c;
    L_0x006d:
        r3.close();	 Catch:{  }
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.database.GraphCursorDatabase.a(java.lang.String):android.database.Cursor");
    }

    private static Cursor m8120a(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.query(false, "chunks", new String[]{GraphCursorDatabaseContract$ChunksTable$Columns.f7878d.d, GraphCursorDatabaseContract$ChunksTable$Columns.f7879e.d, GraphCursorDatabaseContract$ChunksTable$Columns.f7877c.d, GraphCursorDatabaseContract$ChunksTable$Columns.f7881g.d}, "session_id = ?", new String[]{(String) Preconditions.checkNotNull(str)}, null, null, "sort_key DESC", null);
    }

    private static String m8127a(CharArrayBuffer charArrayBuffer) {
        return new String(charArrayBuffer.data, 0, charArrayBuffer.sizeCopied);
    }

    @VisibleForTesting
    private static ArrayList<PageInfo> m8129a(Cursor cursor) {
        ArrayList<PageInfo> arrayList = new ArrayList();
        int count = cursor.getCount();
        if (count == 0) {
            return arrayList;
        }
        if (count % 2 != 0) {
            BLog.b(GraphCursorDatabase.class, "Got unexpected odd number of chunk rows: %d", new Object[]{Integer.valueOf(count)});
            return arrayList;
        }
        String a;
        int i = count / 2;
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(GraphCursorDatabaseContract$ChunksTable$Columns.f7878d.a());
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(GraphCursorDatabaseContract$ChunksTable$Columns.f7879e.a());
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(GraphCursorDatabaseContract$ChunksTable$Columns.f7877c.a());
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(GraphCursorDatabaseContract$ChunksTable$Columns.f7881g.a());
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer = new CharArrayBuffer(64);
        boolean z = false;
        boolean z2 = false;
        long j = 0;
        charArrayBuffer = new CharArrayBuffer(32);
        charArrayBuffer = new CharArrayBuffer(32);
        int i2 = 0;
        while (i2 < i) {
            boolean z3;
            int i3 = i2 * 2;
            int i4 = (i2 * 2) + 1;
            Preconditions.checkState(cursor.moveToPosition(i3));
            boolean z4 = cursor.getInt(columnIndexOrThrow2) > 0;
            Preconditions.checkState(cursor.moveToPosition(i4));
            boolean z5 = cursor.getInt(columnIndexOrThrow2) > 0;
            if (i2 == 0) {
                Preconditions.checkState(cursor.moveToPosition(i3));
                cursor.copyStringToBuffer(columnIndexOrThrow, charArrayBuffer);
                cursor.copyStringToBuffer(columnIndexOrThrow3, charArrayBuffer);
                j = cursor.getLong(columnIndexOrThrow4);
                Preconditions.checkState(cursor.moveToPosition(i4));
                cursor.copyStringToBuffer(columnIndexOrThrow, charArrayBuffer);
                cursor.copyStringToBuffer(columnIndexOrThrow3, charArrayBuffer);
                z3 = z5;
            } else if (z2 && z4) {
                a = m8127a(charArrayBuffer);
                SortKeyHelper.a(a);
                arrayList.add(new PageInfo(a, m8127a(charArrayBuffer), m8127a(charArrayBuffer), m8127a(charArrayBuffer), z, z2, 0, j));
                Preconditions.checkState(cursor.moveToPosition(i3));
                cursor.copyStringToBuffer(columnIndexOrThrow, charArrayBuffer);
                cursor.copyStringToBuffer(columnIndexOrThrow3, charArrayBuffer);
                j = cursor.getLong(columnIndexOrThrow4);
                Preconditions.checkState(cursor.moveToPosition(i4));
                cursor.copyStringToBuffer(columnIndexOrThrow, charArrayBuffer);
                cursor.copyStringToBuffer(columnIndexOrThrow3, charArrayBuffer);
                z3 = z5;
            } else {
                Preconditions.checkState(cursor.moveToPosition(i4));
                cursor.copyStringToBuffer(columnIndexOrThrow, charArrayBuffer);
                cursor.copyStringToBuffer(columnIndexOrThrow3, charArrayBuffer);
                z3 = z5;
                z4 = z;
            }
            i2++;
            z2 = z3;
            z = z4;
        }
        a = m8127a(charArrayBuffer);
        SortKeyHelper.a(a);
        arrayList.add(new PageInfo(a, m8127a(charArrayBuffer), m8127a(charArrayBuffer), m8127a(charArrayBuffer), z, z2, 0, j));
        return arrayList;
    }

    public final synchronized void ai_() {
        SQLiteDatabase a = this.f7856b.a();
        m8148c(a);
        m8152e();
        m8153e(a);
        m8154f();
    }

    public final synchronized void m8165b() {
        SQLiteDatabase a = this.f7856b.a();
        SQLiteDetour.a(a, -1267785528);
        try {
            int delete = a.delete("connections", "1", null);
            Integer.valueOf(delete);
            m8156g(a);
            m8155f(a);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, delete);
            m8154f();
            FlatBufferModelFileManager.b(this.f7858d);
        } finally {
            SQLiteDetour.b(a, -726937922);
        }
    }

    public synchronized void clearUserData() {
        this.f7856b.e();
        FlatBufferModelFileManager.b(this.f7858d);
    }

    private Cursor m8138b(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.rawQuery("SELECT session_id FROM (SELECT session_id, MAX(timestamp) AS newest_timestamp FROM chunks GROUP BY session_id) WHERE newest_timestamp < CAST(? as INTEGER)", new String[]{String.valueOf(this.f7857c.a() - 432000000)});
    }

    @VisibleForTesting
    private void m8148c(SQLiteDatabase sQLiteDatabase) {
        ImmutableSet copyOf = ImmutableSet.copyOf(this.f7860f.m8188a());
        SQLiteDetour.a(sQLiteDatabase, 1006448900);
        try {
            Throwable th;
            Cursor b = m8138b(sQLiteDatabase);
            Throwable th2 = null;
            try {
                if (b.moveToFirst()) {
                    int columnIndexOrThrow = b.getColumnIndexOrThrow("session_id");
                    do {
                        String string = b.getString(columnIndexOrThrow);
                        if (!copyOf.contains(string)) {
                            m8166b(string);
                        }
                    } while (b.moveToNext());
                    m8155f(sQLiteDatabase);
                    m8156g(sQLiteDatabase);
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (b != null) {
                    b.close();
                }
                SQLiteDetour.b(sQLiteDatabase, -701150024);
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            throw th;
            if (b != null) {
                if (th22 != null) {
                    try {
                        b.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    b.close();
                }
            }
            throw th;
        } catch (Throwable th5) {
            SQLiteDetour.b(sQLiteDatabase, 1122019156);
        }
    }

    private static Cursor m8150d(SQLiteDatabase sQLiteDatabase) {
        String str = "24";
        return sQLiteDatabase.rawQuery("SELECT DISTINCT a.session_id AS session_id, SUBSTR(a.sort_key, 0, ? + 1) AS sort_key, SUM(b.row_count) AS row_count FROM chunks AS a, (SELECT DISTINCT session_id, SUBSTR(sort_key, 0, ? + 1) AS sort_key, row_count FROM chunks) AS b WHERE a.session_id = b.session_id AND a.sort_key <= b.sort_key GROUP BY a.session_id, a.sort_key ORDER BY a.sort_key DESC", new String[]{str, str});
    }

    private static int m8145c(String str) {
        if (!str.startsWith("notifications_session") && str.startsWith("FriendsCenter")) {
            return 5000;
        }
        return 100;
    }

    @VisibleForTesting
    private void m8153e(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Map hashMap = new HashMap();
        SQLiteDetour.a(sQLiteDatabase, -1650500300);
        try {
            Cursor d = m8150d(sQLiteDatabase);
            Throwable th2 = null;
            try {
                if (d.moveToFirst()) {
                    int columnIndexOrThrow = d.getColumnIndexOrThrow("session_id");
                    int columnIndexOrThrow2 = d.getColumnIndexOrThrow("sort_key");
                    int columnIndexOrThrow3 = d.getColumnIndexOrThrow("row_count");
                    do {
                        String string = d.getString(columnIndexOrThrow);
                        if (!hashMap.containsKey(string) && d.getInt(columnIndexOrThrow3) >= m8145c(string)) {
                            hashMap.put(string, m8146c(sQLiteDatabase, string, d.getString(columnIndexOrThrow2)));
                        }
                    } while (d.moveToNext());
                    m8155f(sQLiteDatabase);
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (d != null) {
                    d.close();
                }
                SQLiteDetour.b(sQLiteDatabase, -417724887);
                Preconditions.checkState(!sQLiteDatabase.inTransaction());
                m8135a(hashMap);
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (d != null) {
                if (th22 != null) {
                    try {
                        d.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    d.close();
                }
            }
            throw th;
            throw th;
        } catch (Throwable th5) {
            SQLiteDetour.b(sQLiteDatabase, -511626682);
        }
    }

    private static Cursor m8121a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        return sQLiteDatabase.rawQuery("SELECT _id FROM connections WHERE session_id = ? AND SUBSTR(sort_key, 0, ? + 1) <= ?", new String[]{str, "24", str2});
    }

    private static void m8144b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z = true;
        if (sQLiteDatabase.delete("chunks", "session_id = ? AND SUBSTR(sort_key, 0, ? + 1) <= ?", new String[]{str, "24", str2}) % 2 != 0) {
            z = false;
        }
        Preconditions.checkState(z);
    }

    private static ChangeSet m8146c(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Throwable th;
        ChangeSet changeSet = new ChangeSet();
        Cursor a = m8121a(sQLiteDatabase, str, str2);
        Throwable th2 = null;
        try {
            if (a.moveToFirst()) {
                int columnIndexOrThrow = a.getColumnIndexOrThrow("_id");
                do {
                    long j = a.getLong(columnIndexOrThrow);
                    m8133a(sQLiteDatabase, j);
                    changeSet.b.a(j);
                } while (a.moveToNext());
                m8144b(sQLiteDatabase, str, str2);
            }
            if (a != null) {
                a.close();
            }
            return changeSet;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    private static void m8155f(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-328181862);
        sQLiteDatabase.execSQL("DELETE FROM models WHERE _id NOT IN (SELECT DISTINCT confirmed_model FROM connections) AND _id NOT IN (SELECT DISTINCT optimistic_model FROM connections)");
        SQLiteDetour.a(1966520490);
    }

    private static void m8156g(SQLiteDatabase sQLiteDatabase) {
        SQLiteDetour.a(-736418505);
        sQLiteDatabase.execSQL("DELETE FROM chunks WHERE session_id NOT IN (SELECT DISTINCT session_id FROM connections)");
        SQLiteDetour.a(-1323600);
    }

    private static Cursor m8157h(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.query(true, "models", new String[]{GraphCursorDatabaseContract$ModelsTable$Columns.f7884b.d}, null, null, null, null, null, null);
    }

    @VisibleForTesting
    private synchronized void m8152e() {
        Throwable th;
        Throwable th2 = null;
        synchronized (this) {
            Cursor h = m8157h(this.f7856b.a());
            try {
                Set set;
                if (h.moveToFirst()) {
                    HashSet hashSet = new HashSet(h.getCount());
                    int columnIndexOrThrow = h.getColumnIndexOrThrow(GraphCursorDatabaseContract$ModelsTable$Columns.f7884b.a());
                    do {
                        hashSet.add(h.getString(columnIndexOrThrow));
                    } while (h.moveToNext());
                    set = hashSet;
                }
                if (h != null) {
                    h.close();
                }
                if (set != null) {
                    FlatBufferModelFileManager.a(this.f7858d, set);
                }
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
        }
        return;
        if (h != null) {
            if (th22 != null) {
                try {
                    h.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                h.close();
            }
        }
        throw th;
        throw th;
    }

    private void m8154f() {
        try {
            SQLiteDatabase a = this.f7856b.a();
            if (!a.inTransaction()) {
                SQLiteDetour.a(219367870);
                a.execSQL("VACUUM");
                SQLiteDetour.a(-43990037);
            }
        } catch (Throwable e) {
            BLog.b(f7854a, "SQLite disk too full to vacuum", e);
        } catch (Throwable e2) {
            BLog.b(f7854a, "Could not vacuum, likely in a transaction or something", e2);
        }
    }

    public final void m8164a(Collection<String> collection, Collection<CacheVisitor> collection2) {
        m8135a(m8142b((Collection) collection, null, (Collection) collection2));
    }

    public final void m8163a(Collection<String> collection, CacheVisitor cacheVisitor, Collection<CacheVisitor> collection2) {
        m8135a(m8142b((Collection) collection, cacheVisitor, (Collection) collection2));
    }

    private void m8135a(Map<String, ChangeSet> map) {
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                if (this.f7860f.m8190c(str)) {
                    Bundle bundle = new Bundle(1);
                    LongArraySet longArraySet = ((ChangeSet) map.get(str)).a;
                    if (!(longArraySet == null || longArraySet.a())) {
                        bundle.putLongArray("CHANGED_ROW_IDS", longArraySet.b());
                    }
                    longArraySet = ((ChangeSet) map.get(str)).b;
                    if (!(longArraySet == null || longArraySet.a())) {
                        bundle.putLongArray("DELETED_ROW_IDS", longArraySet.b());
                    }
                    LocalModelCursorLoaderManager.m8199a(str, bundle);
                }
            }
        }
    }

    public final Bundle m8160a(String str, BufferRows bufferRows, boolean z) {
        return m8161a(str, bufferRows.a(), bufferRows.b(), bufferRows.c(), null, z);
    }

    public final synchronized Bundle m8161a(String str, ByteBuffer byteBuffer, BufferRowMapper bufferRowMapper, ImmutableList<PageInfo> immutableList, ImmutableSet<String> immutableSet, boolean z) {
        Bundle bundle;
        Throwable th;
        Throwable th2;
        int i;
        FileOutputStream fileOutputStream;
        bundle = new Bundle();
        bundle.putLong("CHANGE_NUMBER", this.f7861g.incrementAndGet());
        String a = FlatBufferModelFileManager.a(this.f7858d);
        SQLiteDatabase a2 = this.f7856b.a();
        SQLiteDetour.a(a2, 171428381);
        this.f7859e.b(8716297);
        this.f7859e.a(8716297, "single_buffer");
        try {
            fileOutputStream = new FileOutputStream(a);
            if (byteBuffer != null) {
                try {
                    fileOutputStream.write(byteBuffer.array());
                } catch (Throwable th22) {
                    Throwable th3 = th22;
                    th22 = th;
                    th = th3;
                }
            }
            if (z) {
                a2.delete("connections", GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d + " = ?", new String[]{str});
                m8156g(a2);
                m8155f(a2);
            } else if (!(immutableSet == null || immutableSet.isEmpty())) {
                LongArraySet a3 = m8124a(str, (Collection) immutableSet);
                if (!(a3 == null || a3.a())) {
                    bundle.putLongArray("DELETED_ROW_IDS", a3.b());
                }
            }
            if (bufferRowMapper != null) {
                long[] jArr = new long[bufferRowMapper.a()];
                for (int i2 = 0; i2 < bufferRowMapper.a(); i2++) {
                    jArr[i2] = m8118a(a2, str, a, bufferRowMapper.a(i2), bufferRowMapper.b(i2), bufferRowMapper.e(i2), bufferRowMapper.c(i2), bufferRowMapper.d(i2));
                }
                if (jArr.length > 0) {
                    bundle.putLongArray("INSERTED_ROW_IDS", jArr);
                }
            }
            m8134a(a2, str, (ImmutableList) immutableList);
            a2.setTransactionSuccessful();
            fileOutputStream.close();
            SQLiteDetour.b(a2, -496128215);
            this.f7859e.b(8716297, (short) 2);
        } catch (SQLException e) {
            try {
                i = this.f7859e;
                i.b(8716297, (short) 3);
                SQLiteDetour.b(a2, i);
                this.f7859e.b(8716297, (short) 2);
                return bundle;
            } finally {
                SQLiteDetour.b(a2, 1961159554);
                this.f7859e.b(8716297, (short) 2);
            }
        } catch (IOException e2) {
            i = this.f7859e;
            i.b(8716297, (short) 3);
            SQLiteDetour.b(a2, i);
            this.f7859e.b(8716297, (short) 2);
            return bundle;
        }
        return bundle;
        if (th22 != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th4) {
                AndroidCompat.addSuppressed(th22, th4);
            }
        } else {
            fileOutputStream.close();
        }
        throw th;
        throw th;
    }

    public final synchronized Bundle m8159a(String str, EntryIterator entryIterator, ImmutableList<PageInfo> immutableList, ImmutableSet<String> immutableSet, boolean z) {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putLong("CHANGE_NUMBER", this.f7861g.incrementAndGet());
        FileOutputStream fileOutputStream = null;
        SQLiteDatabase a = this.f7856b.a();
        this.f7859e.b(8716297);
        this.f7859e.a(8716297, "multi_buffer");
        SQLiteDetour.a(a, -1120532278);
        if (z) {
            try {
                SQLiteDatabase sQLiteDatabase = a;
                sQLiteDatabase.delete("connections", GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d + " = ?", new String[]{str});
                m8156g(a);
                m8155f(a);
            } catch (SQLException e) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                try {
                    int i = this.f7859e;
                    i.b(8716297, (short) 3);
                    SQLiteDetour.b(a, i);
                    this.f7859e.b(8716297, (short) 2);
                    return bundle;
                } finally {
                    SQLiteDetour.b(a, 664007375);
                    this.f7859e.b(8716297, (short) 2);
                }
            } catch (IOException e3) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                int i2 = this.f7859e;
                i2.b(8716297, (short) 3);
                SQLiteDetour.b(a, i2);
                this.f7859e.b(8716297, (short) 2);
                return bundle;
            }
        } else if (!(immutableSet == null || immutableSet.isEmpty())) {
            LongArraySet a2 = m8124a(str, (Collection) immutableSet);
            if (!(a2 == null || a2.a())) {
                bundle.putLongArray("DELETED_ROW_IDS", a2.b());
            }
        }
        String a3 = FlatBufferModelFileManager.a(this.f7858d);
        FileOutputStream fileOutputStream2 = new FileOutputStream(a3);
        int i3 = 0;
        while (entryIterator.a()) {
            try {
                MutableFlattenable mutableFlattenable;
                MutableFlattenable b = entryIterator.b();
                if (b.w_() == null) {
                    mutableFlattenable = (MutableFlattenable) MutableFlatBuffer.a(ByteBuffer.wrap(FlatBufferBuilder.b(b)), b.getClass(), null, null, true, null);
                } else {
                    mutableFlattenable = b;
                }
                byte[] array = mutableFlattenable.w_().a().array();
                m8118a(a, str, a3, i3 + mutableFlattenable.u_(), mutableFlattenable.getClass(), entryIterator.e(), entryIterator.c(), entryIterator.d());
                fileOutputStream2.write(array, 0, array.length);
                i3 = array.length + i3;
            } catch (SQLException e4) {
                fileOutputStream = fileOutputStream2;
            } catch (IOException e5) {
                fileOutputStream = fileOutputStream2;
            }
        }
        fileOutputStream2.close();
        m8134a(a, str, (ImmutableList) immutableList);
        a.setTransactionSuccessful();
        SQLiteDetour.b(a, 1563203483);
        this.f7859e.b(8716297, (short) 2);
        return bundle;
    }

    @VisibleForTesting
    private long m8118a(SQLiteDatabase sQLiteDatabase, String str, @Nullable String str2, int i, Class cls, int i2, String str3, Collection<String> collection) {
        long a = this.f7857c.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GraphCursorDatabaseContract$ModelsTable$Columns.f7884b.a(), (String) Preconditions.checkNotNull(str2));
        Preconditions.checkArgument(i > 0);
        contentValues.put(GraphCursorDatabaseContract$ModelsTable$Columns.f7885c.a(), Integer.valueOf(i));
        contentValues.put(GraphCursorDatabaseContract$ModelsTable$Columns.f7887e.a(), cls.getName());
        SQLiteDetour.a(273472528);
        long insertOrThrow = sQLiteDatabase.insertOrThrow("models", null, contentValues);
        SQLiteDetour.a(-305032764);
        contentValues = new ContentValues();
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7869d.a(), (String) Preconditions.checkNotNull(str));
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7867b.a(), Long.valueOf(insertOrThrow));
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7868c.a(), Long.valueOf(insertOrThrow));
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7870e.a(), Integer.valueOf(i2));
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7871f.a(), Long.valueOf(a));
        Preconditions.checkArgument(str3.length() == 32);
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7872g.a(), (String) Preconditions.checkNotNull(str3));
        if (collection != null) {
            contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7873h.a(), TextUtils.join(",", collection));
        }
        SQLiteDetour.a(2134348352);
        a = sQLiteDatabase.insertOrThrow("connections", null, contentValues);
        SQLiteDetour.a(424091805);
        if (collection != null) {
            for (String str4 : collection) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(GraphCursorDatabaseContract$TagsTable$Columns.f7889a.a(), str4);
                contentValues2.put(GraphCursorDatabaseContract$TagsTable$Columns.f7890b.a(), Long.valueOf(a));
                SQLiteDetour.a(-894573328);
                sQLiteDatabase.insertOrThrow("tags", null, contentValues2);
                SQLiteDetour.a(1794222054);
            }
        }
        return a;
    }

    private void m8134a(SQLiteDatabase sQLiteDatabase, String str, ImmutableList<PageInfo> immutableList) {
        if (immutableList != null && !immutableList.isEmpty()) {
            long a = this.f7857c.a();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PageInfo pageInfo = (PageInfo) immutableList.get(i);
                Preconditions.checkArgument(pageInfo.a.compareTo(pageInfo.b) > 0);
                Preconditions.checkArgument(pageInfo.a.length() == 32);
                Preconditions.checkArgument(pageInfo.b.length() == 32);
                m8119a(sQLiteDatabase, str, pageInfo.a, pageInfo.c, pageInfo.e, pageInfo.g, a);
                m8119a(sQLiteDatabase, str, pageInfo.b, pageInfo.d, pageInfo.f, pageInfo.g, a);
            }
        }
    }

    @VisibleForTesting
    private static long m8119a(SQLiteDatabase sQLiteDatabase, String str, String str2, @Nullable String str3, boolean z, int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(GraphCursorDatabaseContract$ChunksTable$Columns.f7876b.d, (String) Preconditions.checkNotNull(str));
        contentValues.put(GraphCursorDatabaseContract$ChunksTable$Columns.f7877c.d, (String) Preconditions.checkNotNull(str2));
        contentValues.put(GraphCursorDatabaseContract$ChunksTable$Columns.f7878d.d, str3);
        contentValues.put(GraphCursorDatabaseContract$ChunksTable$Columns.f7879e.d, Boolean.valueOf(z));
        Preconditions.checkArgument(i >= 0);
        contentValues.put(GraphCursorDatabaseContract$ChunksTable$Columns.f7880f.d, Integer.valueOf(i));
        contentValues.put(GraphCursorDatabaseContract$ChunksTable$Columns.f7881g.d, Long.valueOf(j));
        SQLiteDetour.a(-1652949451);
        long insertOrThrow = sQLiteDatabase.insertOrThrow("chunks", null, contentValues);
        SQLiteDetour.a(182808681);
        return insertOrThrow;
    }

    private static Cursor m8139b(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("SELECT _id FROM connections WHERE session_id = ? ", new String[]{str});
    }

    private static Cursor m8122a(SQLiteDatabase sQLiteDatabase, String str, Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.add(str);
        arrayList.addAll(collection);
        return sQLiteDatabase.rawQuery("SELECT _id FROM connections WHERE session_id = ? AND _id IN (SELECT node_id FROM tags WHERE " + SqlExpression.a("tag", collection).a() + ")", (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    private LongArraySet m8124a(String str, Collection<String> collection) {
        Cursor a;
        Throwable th;
        Throwable th2;
        LongArraySet longArraySet = new LongArraySet();
        if (!collection.isEmpty()) {
            SQLiteDatabase a2 = this.f7856b.a();
            a = m8122a(a2, str, (Collection) collection);
            th = null;
            try {
                if (a.moveToFirst()) {
                    int columnIndexOrThrow = a.getColumnIndexOrThrow(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a.a());
                    do {
                        long j = a.getLong(columnIndexOrThrow);
                        longArraySet.a(j);
                        m8133a(a2, j);
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                th3 = th2;
                th2 = th4;
            }
        }
        return longArraySet;
        if (a != null) {
            if (th3 != null) {
                try {
                    a.close();
                } catch (Throwable th5) {
                    AndroidCompat.addSuppressed(th3, th5);
                }
            } else {
                a.close();
            }
        }
        throw th2;
        throw th2;
    }

    public final synchronized void m8167c() {
        SQLiteDatabase a = this.f7856b.a();
        a.delete("connections", null, null);
        a.delete("chunks", null, null);
        a.delete("models", null, null);
        FlatBufferModelFileManager.b(this.f7858d);
    }

    public static void m8132a(SQLiteDatabase sQLiteDatabase) {
        m8149c(sQLiteDatabase, "connections");
        m8149c(sQLiteDatabase, "chunks");
        m8149c(sQLiteDatabase, "models");
        m8149c(sQLiteDatabase, "tags");
    }

    private static void m8149c(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.rawQuery(SqlTable.a(str), null).close();
    }

    private synchronized Map<String, ChangeSet> m8142b(Collection<String> collection, @Nullable CacheVisitor cacheVisitor, Collection<CacheVisitor> collection2) {
        Map<String, ChangeSet> c;
        this.f7859e.b(8716305);
        short s = (short) 3;
        try {
            c = m8147c((Collection) collection, cacheVisitor, (Collection) collection2);
            this.f7859e.b(8716305, (short) 2);
        } catch (Throwable th) {
            this.f7859e.b(8716305, s);
        }
        return c;
    }

    private static String m8141b(CacheVisitor cacheVisitor) {
        if (cacheVisitor == null) {
            return "null";
        }
        return cacheVisitor instanceof CacheVisitorAnalytics ? ((CacheVisitorAnalytics) cacheVisitor).m3405b() : cacheVisitor.getClass().getName();
    }

    private Cursor m8123a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        int andIncrement = this.f7862h.getAndIncrement();
        this.f7859e.e(8716306, andIncrement);
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT connections._id AS _id, connections.confirmed_model AS confirmed_model, connections.optimistic_model AS optimistic_model, connections.sort_key AS sort_key, connections.version AS version, connections.flags AS flags, connections.tags AS tags, connections.session_id AS session_id, models.file AS file, models.offset AS offset, models.mutation_data AS mutation_data, models.class AS class FROM connections INNER JOIN models ON connections.confirmed_model = models._id WHERE connections._id IN (SELECT node_id FROM tags WHERE " + SqlExpression.a("tag", strArr).a() + ")", strArr);
            this.f7859e.b(8716306, andIncrement, "row_count", String.valueOf(rawQuery.getCount()));
            this.f7859e.b(8716306, andIncrement, "tags_count", String.valueOf(strArr.length));
            return rawQuery;
        } finally {
            this.f7859e.b(8716306, andIncrement, (short) 2);
        }
    }

    @RowUpdateMethod
    private static String m8128a(MutableFlattenable mutableFlattenable, MutableFlattenable mutableFlattenable2) {
        MutableFlatBuffer w_ = mutableFlattenable2.w_();
        if (w_ == null || mutableFlattenable2 != mutableFlattenable) {
            return "reflatten";
        }
        if (w_.b()) {
            return "delta";
        }
        return "not_updated";
    }

    private boolean m8136a(@Nullable CacheVisitor cacheVisitor, Collection<CacheVisitor> collection, long j, long j2, long j3, MutableFlattenable mutableFlattenable, String[] strArr) {
        MutableFlattenable a;
        if (cacheVisitor != null) {
            a = m8125a(mutableFlattenable, cacheVisitor, "confirmed");
            if (a == null) {
                return false;
            }
        }
        a = mutableFlattenable;
        if (a == null) {
            return false;
        }
        boolean z;
        MutableFlattenable mutableFlattenable2;
        String a2;
        String a3 = m8128a(mutableFlattenable, a);
        Object obj = -1;
        switch (a3.hashCode()) {
            case -739998607:
                if (a3.equals("reflatten")) {
                    obj = null;
                    break;
                }
                break;
            case 95468472:
                if (a3.equals("delta")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                m8143b(j, j2, a);
                z = true;
                break;
            case 1:
                m8131a(j, j2, a);
                z = true;
                break;
            default:
                z = false;
                break;
        }
        this.f7859e.b(8716304, "confirmed_model_update", a3);
        MutableFlattenable mutableFlattenable3 = a;
        for (CacheVisitor cacheVisitor2 : collection) {
            Object obj2;
            long a4;
            if (m8137a(strArr, cacheVisitor2.mo268a())) {
                MutableFlattenable a5 = m8125a(mutableFlattenable3, cacheVisitor2, "optimistic");
                if (a5 != null) {
                    mutableFlattenable3 = a5;
                } else {
                    mutableFlattenable2 = a5;
                    if (mutableFlattenable2 != null) {
                        m8130a(j, j2, j3);
                        return true;
                    }
                    a2 = m8128a(a, mutableFlattenable2);
                    obj2 = -1;
                    switch (a2.hashCode()) {
                        case -739998607:
                            if (a2.equals("reflatten")) {
                                obj2 = null;
                                break;
                            }
                            break;
                        case 95468472:
                            if (a2.equals("delta")) {
                                obj2 = 1;
                                break;
                            }
                            break;
                    }
                    switch (obj2) {
                        case null:
                            if (j3 != j2) {
                                a4 = m8117a(j, j2);
                            } else {
                                a4 = j3;
                            }
                            m8143b(j, a4, mutableFlattenable2);
                            z = true;
                            break;
                        case 1:
                            if (j3 != j2) {
                                a4 = m8117a(j, j2);
                            } else {
                                a4 = j3;
                            }
                            m8131a(j, a4, mutableFlattenable2);
                            z = true;
                            break;
                        default:
                            if (j3 != j2) {
                                m8130a(j, j2, j3);
                                z = true;
                                break;
                            }
                            break;
                    }
                    this.f7859e.b(8716304, "optimistic_model_update", a2);
                    return z;
                }
            }
        }
        mutableFlattenable2 = mutableFlattenable3;
        if (mutableFlattenable2 != null) {
            a2 = m8128a(a, mutableFlattenable2);
            obj2 = -1;
            switch (a2.hashCode()) {
                case -739998607:
                    if (a2.equals("reflatten")) {
                        obj2 = null;
                        break;
                    }
                    break;
                case 95468472:
                    if (a2.equals("delta")) {
                        obj2 = 1;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    if (j3 != j2) {
                        a4 = j3;
                    } else {
                        a4 = m8117a(j, j2);
                    }
                    m8143b(j, a4, mutableFlattenable2);
                    z = true;
                    break;
                case 1:
                    if (j3 != j2) {
                        a4 = j3;
                    } else {
                        a4 = m8117a(j, j2);
                    }
                    m8131a(j, a4, mutableFlattenable2);
                    z = true;
                    break;
                default:
                    if (j3 != j2) {
                        m8130a(j, j2, j3);
                        z = true;
                        break;
                    }
                    break;
            }
            this.f7859e.b(8716304, "optimistic_model_update", a2);
            return z;
        }
        m8130a(j, j2, j3);
        return true;
    }

    private MutableFlattenable m8125a(MutableFlattenable mutableFlattenable, CacheVisitor cacheVisitor, @ModelRowType String str) {
        int andIncrement = this.f7862h.getAndIncrement();
        this.f7859e.e(8716307, andIncrement);
        try {
            if (this.f7859e.j(8716307, andIncrement)) {
                this.f7859e.b(8716307, andIncrement, "model_row_type", str);
                this.f7859e.b(8716307, andIncrement, "model_class_name", mutableFlattenable.getClass().getName());
                this.f7859e.b(8716307, andIncrement, "visitor_name", m8141b(cacheVisitor));
            }
            MutableFlattenable mutableFlattenable2 = (MutableFlattenable) cacheVisitor.mo270a(mutableFlattenable);
            if (mutableFlattenable2 != null && str == "confirmed" && this.f7859e.j(8716307, andIncrement)) {
                this.f7859e.b(8716307, andIncrement, "model_update", m8128a(mutableFlattenable, mutableFlattenable2));
            }
            this.f7859e.b(8716307, andIncrement, (short) 2);
            return mutableFlattenable2;
        } catch (Exception e) {
            this.f7859e.b(8716307, andIncrement, (short) 3);
            throw e;
        } catch (Throwable th) {
            this.f7859e.b(8716307, andIncrement, (short) 2);
        }
    }

    private static boolean m8137a(String[] strArr, Collection<String> collection) {
        if (strArr == null || collection == null) {
            return false;
        }
        for (Object contains : strArr) {
            if (collection.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    private void m8143b(long j, long j2, MutableFlattenable mutableFlattenable) {
        Throwable th;
        SQLiteDatabase a = this.f7856b.a();
        this.f7859e.b(8716300);
        String a2 = FlatBufferModelFileManager.a(this.f7858d);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(a2);
            Throwable th2 = null;
            try {
                byte[] b = FlatBufferBuilder.b(mutableFlattenable);
                int a3 = FlatBuffer.a(ByteBuffer.wrap(b));
                fileOutputStream.write(b);
                ContentValues contentValues = new ContentValues();
                contentValues.put(GraphCursorDatabaseContract$ModelsTable$Columns.f7884b.a(), a2);
                contentValues.put(GraphCursorDatabaseContract$ModelsTable$Columns.f7885c.a(), Integer.valueOf(a3));
                contentValues.put(GraphCursorDatabaseContract$ModelsTable$Columns.f7886d.a(), null);
                Preconditions.checkState(a.update("models", contentValues, new StringBuilder().append(GraphCursorDatabaseContract$ModelsTable$Columns.f7883a.a()).append(" = ?").toString(), new String[]{String.valueOf(j2)}) == 1);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7871f.a(), Long.valueOf(this.f7857c.a()));
                Preconditions.checkState(a.update("connections", contentValues2, new StringBuilder().append(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a.a()).append(" = ?").toString(), new String[]{String.valueOf(j)}) == 1);
                fileOutputStream.close();
                this.f7859e.b(8716300, (short) 2);
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            throw th;
            if (th22 != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                fileOutputStream.close();
            }
            throw th;
        } catch (SQLException e) {
            th = e;
            try {
                BLog.b(f7854a, "Unable to re-flatten", th);
                this.f7859e.b(8716300, (short) 3);
            } finally {
                this.f7859e.b(8716300, (short) 2);
            }
        } catch (IOException e2) {
            th = e2;
            BLog.b(f7854a, "Unable to re-flatten", th);
            this.f7859e.b(8716300, (short) 3);
        }
    }

    private long m8117a(long j, long j2) {
        Throwable th;
        Throwable th2;
        boolean z = true;
        SQLiteDatabase a = this.f7856b.a();
        String[] strArr = new String[]{String.valueOf(j2)};
        SQLiteDetour.a(-485654518);
        a.execSQL("INSERT INTO models(file, offset, mutation_data, class) SELECT file, offset, mutation_data, class FROM models WHERE _id = ?", strArr);
        SQLiteDetour.a(733099095);
        Cursor rawQuery = a.rawQuery("SELECT last_insert_rowid()", null);
        try {
            Preconditions.checkState(rawQuery.moveToFirst());
            long j3 = rawQuery.getLong(0);
            if (rawQuery != null) {
                rawQuery.close();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7868c.a(), Long.valueOf(j3));
            if (a.update("connections", contentValues, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a.a() + " = ?", new String[]{String.valueOf(j)}) != 1) {
                z = false;
            }
            Preconditions.checkState(z);
            return j3;
        } catch (Throwable th22) {
            Throwable th3 = th22;
            th22 = th;
            th = th3;
        }
        throw th;
        if (rawQuery != null) {
            if (th22 != null) {
                try {
                    rawQuery.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                rawQuery.close();
            }
        }
        throw th;
    }

    private static void m8133a(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z = true;
        if (sQLiteDatabase.delete("connections", GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a.d + " = ?", new String[]{String.valueOf(j)}) != 1) {
            z = false;
        }
        Preconditions.checkState(z);
    }

    private void m8130a(long j, long j2, long j3) {
        boolean z = true;
        SQLiteDatabase a = this.f7856b.a();
        Preconditions.checkState(a.delete("models", new StringBuilder().append(GraphCursorDatabaseContract$ModelsTable$Columns.f7883a.a()).append(" = ?").toString(), new String[]{String.valueOf(j3)}) == 1);
        ContentValues contentValues = new ContentValues();
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7868c.a(), Long.valueOf(j2));
        contentValues.put(GraphCursorDatabaseContract$ConnectionsTable$Columns.f7871f.a(), Long.valueOf(this.f7857c.a()));
        if (a.update("connections", contentValues, GraphCursorDatabaseContract$ConnectionsTable$Columns.f7866a.a() + " = ?", new String[]{String.valueOf(j)}) != 1) {
            z = false;
        }
        Preconditions.checkState(z);
    }
}
