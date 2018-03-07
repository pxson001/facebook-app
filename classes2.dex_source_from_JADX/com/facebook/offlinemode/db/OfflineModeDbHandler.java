package com.facebook.offlinemode.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.OfflineModeDbSchemaPart.OfflineRequestsTable;
import com.facebook.offlinemode.db.OfflineModeDbSchemaPart.OfflineRequestsTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_state */
public class OfflineModeDbHandler {
    public static final ClassLoader f12426a = OfflineModeDbHandler.class.getClassLoader();
    private static final String f12427b = OfflineModeDbHandler.class.getSimpleName();
    private static volatile OfflineModeDbHandler f12428j;
    public final OfflineModeDatabaseSupplier f12429c;
    public final DefaultAndroidThreadUtil f12430d;
    private final AbstractFbErrorReporter f12431e;
    private final AnalyticsLogger f12432f;
    private final ObjectMapper f12433g;
    private final Clock f12434h;
    private final AppVersionInfo f12435i;

    public static com.facebook.offlinemode.db.OfflineModeDbHandler m18498a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12428j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.offlinemode.db.OfflineModeDbHandler.class;
        monitor-enter(r1);
        r0 = f12428j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18502b(r0);	 Catch:{ all -> 0x0035 }
        f12428j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12428j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.offlinemode.db.OfflineModeDbHandler.a(com.facebook.inject.InjectorLike):com.facebook.offlinemode.db.OfflineModeDbHandler");
    }

    private static OfflineModeDbHandler m18502b(InjectorLike injectorLike) {
        return new OfflineModeDbHandler(OfflineModeDatabaseSupplier.m18506a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), AppVersionInfoMethodAutoProvider.m2629a(injectorLike));
    }

    @Inject
    public OfflineModeDbHandler(OfflineModeDatabaseSupplier offlineModeDatabaseSupplier, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, ObjectMapper objectMapper, Clock clock, AppVersionInfo appVersionInfo) {
        this.f12429c = offlineModeDatabaseSupplier;
        this.f12430d = defaultAndroidThreadUtil;
        this.f12431e = abstractFbErrorReporter;
        this.f12432f = analyticsLogger;
        this.f12433g = objectMapper;
        this.f12434h = clock;
        this.f12435i = appVersionInfo;
    }

    public final void m18504a(PendingRequest pendingRequest) {
        long j;
        this.f12430d.m1655b();
        Preconditions.checkNotNull(pendingRequest);
        if (pendingRequest.d > 0) {
            j = pendingRequest.d;
        } else {
            j = this.f12434h.mo211a();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f12445a.toString(), pendingRequest.b);
        contentValues.put(Columns.f12454j.toString(), Long.valueOf(j));
        contentValues.put(Columns.f12455k.toString(), Long.valueOf(pendingRequest.e));
        contentValues.put(Columns.f12456l.toString(), Integer.valueOf(pendingRequest.f));
        contentValues.put(Columns.f12457m.toString(), Integer.valueOf(pendingRequest.g));
        contentValues.put(Columns.f12458n.toString(), Build.FINGERPRINT);
        contentValues.put(Columns.f12459o.toString(), this.f12435i.mo367a());
        m18499a(pendingRequest, contentValues);
        if (!StringUtil.m3589a(pendingRequest.c)) {
            contentValues.put(Columns.f12446b.toString(), pendingRequest.c);
            Expression a = Columns.f12445a.m2090a(pendingRequest.b);
            if (this.f12429c.mo2480a().update("pending_request", contentValues, a.mo1476a(), a.mo1477b()) == 0) {
                String str = pendingRequest.c;
                this.f12430d.m1655b();
                Expression a2 = Columns.f12446b.m2090a(str);
                if (this.f12429c.mo2480a().delete("pending_request", a2.mo1476a(), a2.mo1477b()) != 0) {
                    return;
                }
            }
            return;
        }
        SQLiteDetour.a(-1880745303);
        this.f12429c.mo2480a().replaceOrThrow("pending_request", "", contentValues);
        SQLiteDetour.a(987943120);
    }

    private void m18499a(PendingRequest pendingRequest, ContentValues contentValues) {
        if (pendingRequest instanceof PendingBlueServiceRequest) {
            PendingBlueServiceRequest pendingBlueServiceRequest = (PendingBlueServiceRequest) pendingRequest;
            contentValues.put(Columns.f12447c.toString(), pendingBlueServiceRequest.h);
            contentValues.put(Columns.f12448d.toString(), m18501a(pendingBlueServiceRequest.i));
            return;
        }
        PendingGraphQlMutationRequest pendingGraphQlMutationRequest = (PendingGraphQlMutationRequest) pendingRequest;
        contentValues.put(Columns.f12449e.toString(), pendingGraphQlMutationRequest.h.getName());
        try {
            contentValues.put(Columns.f12450f.toString(), this.f12433g.m6659a(pendingGraphQlMutationRequest.i));
            if (pendingGraphQlMutationRequest.j != null) {
                contentValues.put(Columns.f12451g.toString(), pendingGraphQlMutationRequest.j.getClass().getName());
                contentValues.put(Columns.f12452h.toString(), FlatBufferBuilder.m21463b((Flattenable) pendingGraphQlMutationRequest.j));
            }
            contentValues.put(Columns.f12453i.toString(), FlatBufferBuilder.m21463b(new FlattenableTags(pendingGraphQlMutationRequest.k)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final ImmutableList<PendingRequest> m18503a() {
        this.f12430d.m1655b();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("pending_request");
        Cursor query = sQLiteQueryBuilder.query(this.f12429c.mo2480a(), OfflineRequestsTable.f12444b, null, null, null, null, Columns.f12454j.m2091a());
        int a = Columns.f12445a.m2089a(query);
        int a2 = Columns.f12447c.m2089a(query);
        int a3 = Columns.f12449e.m2089a(query);
        int a4 = Columns.f12448d.m2089a(query);
        int a5 = Columns.f12450f.m2089a(query);
        int a6 = Columns.f12451g.m2089a(query);
        int a7 = Columns.f12452h.m2089a(query);
        int a8 = Columns.f12453i.m2089a(query);
        int a9 = Columns.f12454j.m2089a(query);
        int a10 = Columns.f12455k.m2089a(query);
        int a11 = Columns.f12456l.m2089a(query);
        int a12 = Columns.f12457m.m2089a(query);
        int a13 = Columns.f12458n.m2089a(query);
        int a14 = Columns.f12459o.m2089a(query);
        Builder builder = ImmutableList.builder();
        List<String> a15 = Lists.m1296a();
        String string;
        while (query.moveToNext()) {
            try {
                string = query.getString(a13);
                String string2 = query.getString(a);
                String string3 = query.getString(a2);
                String string4 = query.getString(a3);
                String string5 = query.getString(a6);
                String string6 = query.getString(a14);
                if (!Strings.isNullOrEmpty(string3) && !Build.FINGERPRINT.equals(string)) {
                    this.f12432f.mo526a(new HoneyClientEvent("offline_mode_operation_dropped_new_build_detected").m5094g("offline").m5090b("request_id", string2).m5090b("operation_type", string3).m5090b("old_android_build_fingerprint", string).m5090b("android_build_fingerprint", Build.FINGERPRINT));
                    a15.add(string2);
                } else if (Strings.isNullOrEmpty(string5) || this.f12435i.mo367a().equals(string6)) {
                    PendingRequest a16 = m18497a(query, string2, string3, string4, string5, a4, a5, a7, a8, query.getLong(a9), query.getLong(a10), query.getInt(a11), query.getInt(a12), a15);
                    if (a16 != null) {
                        builder.m1069c(a16);
                    }
                } else {
                    this.f12432f.mo526a(new HoneyClientEvent("offline_mode_operation_dropped_new_app_version_detected").m5094g("offline").m5090b("request_id", string2).m5090b("mutation_query_class", string4).m5090b("old_app_version", string6).m5090b("app_version", this.f12435i.mo367a()));
                    a15.add(string2);
                }
            } catch (Throwable e) {
                this.f12431e.m2343a(f12427b, "Could not construct pending request.", e);
                query.close();
                for (String string7 : a15) {
                    m18505a(string7);
                }
            } catch (Throwable e2) {
                Throwable th = e2;
                query.close();
                for (String string72 : a15) {
                    m18505a(string72);
                }
            }
        }
        query.close();
        for (String string722 : a15) {
            m18505a(string722);
        }
        return builder.m1068b();
    }

    @Nullable
    private PendingRequest m18497a(Cursor cursor, String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, List<String> list) {
        PendingRequest.Builder a;
        if (Strings.isNullOrEmpty(str2)) {
            byte[] blob = cursor.getBlob(i2);
            byte[] blob2 = cursor.getBlob(i3);
            byte[] blob3 = cursor.getBlob(i4);
            try {
                GraphQlQueryParamSet graphQlQueryParamSet = (GraphQlQueryParamSet) this.f12433g.m6658a(blob, GraphQlQueryParamSet.class);
                GraphQLVisitableModel graphQLVisitableModel = null;
                if (!Strings.isNullOrEmpty(str4)) {
                    graphQLVisitableModel = (GraphQLVisitableModel) MutableFlatBuffer.m21520a(ByteBuffer.wrap(blob2), Class.forName(str4), null);
                }
                ByteBuffer wrap = ByteBuffer.wrap(blob3);
                FlattenableTags flattenableTags = new FlattenableTags();
                flattenableTags.a(wrap, FlatBuffer.m4026a(wrap));
                a = new PendingGraphQlMutationRequest.Builder().a(Class.forName(str3).asSubclass(TypedGraphQLMutationString.class)).a(graphQlQueryParamSet).a(graphQLVisitableModel).a(flattenableTags.a());
            } catch (Throwable e) {
                this.f12431e.m2343a(f12427b, "Error while trying to deserialize a PendingRequest - invalid param json", e);
                list.add(str);
                a = null;
            } catch (Throwable e2) {
                this.f12431e.m2343a(f12427b, "Error while trying to deserialize a PendingRequest - invalid query class name", e2);
                list.add(str);
                a = null;
            } catch (Exception e3) {
                m18500a(e3, str, list);
                a = null;
            }
        } else {
            try {
                a = new PendingBlueServiceRequest.Builder().c(str2).a(m18496a(cursor.getBlob(i)));
            } catch (Exception e32) {
                m18500a(e32, str, list);
                a = null;
            }
        }
        if (a == null) {
            return null;
        }
        return a.a(str).b(j).a(j2).a(i5).b(i6).a();
    }

    private void m18500a(Exception exception, String str, List<String> list) {
        this.f12431e.m2343a(f12427b, "Error while trying to deserialize a PendingRequest", (Throwable) exception);
        list.add(str);
    }

    private static Bundle m18496a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            Bundle readBundle = obtain.readBundle(f12426a);
            return readBundle;
        } finally {
            obtain.recycle();
        }
    }

    private static byte[] m18501a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public final void m18505a(String str) {
        this.f12430d.m1655b();
        Expression a = Columns.f12445a.m2090a(str);
        this.f12429c.mo2480a().delete("pending_request", a.mo1476a(), a.mo1477b());
    }
}
