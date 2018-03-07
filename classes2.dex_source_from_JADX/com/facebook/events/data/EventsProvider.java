package com.facebook.events.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.SecureContentProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable;
import com.facebook.events.data.EventsCommonContract.EventsCommonTable.Columns;
import com.facebook.events.model.Event;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: zero_rating2/clearable/default_optin/subtitle_key */
public class EventsProvider extends SecureContentProvider {
    @Inject
    EventsDatabaseSupplier f416a;
    @Inject
    Clock f417b;
    @Inject
    EventsCommonContract f418c;
    private UriMatcher f419d;

    public static void m859a(android.content.ContentResolver r6, com.facebook.events.data.EventsCommonContract r7, com.facebook.events.model.Event r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = 0;
        r1 = r7.a(r8);
        r0 = r6;
        r3 = r2;
        r4 = r2;
        r5 = r2;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 == 0) goto L_0x002b;
    L_0x000f:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        if (r0 <= 0) goto L_0x002b;	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
    L_0x0015:
        r1.moveToFirst();	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        r0 = r7.a(r1);	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        r2 = com.facebook.events.data.EventsTableProviderHelper.a(r8);	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        r3 = 0;	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        r4 = 0;	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        r6.update(r0, r2, r3, r4);	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
    L_0x0025:
        if (r1 == 0) goto L_0x002a;
    L_0x0027:
        r1.close();
    L_0x002a:
        return;
    L_0x002b:
        r0 = r7.b;	 Catch:{  }
        r2 = com.facebook.events.data.EventsTableProviderHelper.a(r8);	 Catch:{  }
        r6.insert(r0, r2);	 Catch:{  }
        goto L_0x0025;
    L_0x0035:
        r0 = move-exception;
        r2 = com.facebook.events.data.EventsProvider.class;	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        r3 = "Unexpected error when updating/inserting events: ";	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        com.facebook.debug.log.BLog.b(r2, r3, r0);	 Catch:{ Exception -> 0x0035, all -> 0x0043 }
        if (r1 == 0) goto L_0x002a;
    L_0x003f:
        r1.close();
        goto L_0x002a;
    L_0x0043:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r1.close();
    L_0x0049:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.data.EventsProvider.a(android.content.ContentResolver, com.facebook.events.data.EventsCommonContract, com.facebook.events.model.Event):void");
    }

    private static <T extends InjectableComponentWithContext> void m864a(Class<T> cls, T t) {
        m865a((Object) t, t.getContext());
    }

    private static void m865a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsProvider) obj).m863a(EventsDatabaseSupplier.a(injectorLike), (Clock) SystemClockMethodAutoProvider.m1498a(injectorLike), EventsCommonContract.b(injectorLike));
    }

    protected final void mo10a() {
        super.mo10a();
        m864a(EventsProvider.class, (InjectableComponentWithContext) this);
        this.f419d = m868d();
    }

    private UriMatcher m868d() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(this.f418c.a, "events", 1);
        uriMatcher.addURI(this.f418c.a, "events/#", 2);
        uriMatcher.addURI(this.f418c.a, "events/facebook_id/#", 3);
        uriMatcher.addURI(this.f418c.a, "upcoming", 4);
        uriMatcher.addURI(this.f418c.a, "past", 5);
        uriMatcher.addURI(this.f418c.a, "invited", 7);
        uriMatcher.addURI(this.f418c.a, "hosting", 8);
        uriMatcher.addURI(this.f418c.a, "custom", 9);
        return uriMatcher;
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArr3;
        String str3;
        String str4;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("events");
        sQLiteQueryBuilder.setProjectionMap(null);
        long a = this.f417b.mo211a();
        long a2 = m852a(a);
        String l = Long.toString(a2);
        Expression a3 = m854a(a, a2);
        Expression a4;
        switch (this.f419d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                strArr3 = strArr2;
                str3 = str;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a4 = EventsCommonContract.a(uri.getLastPathSegment());
                str = a4.mo1476a();
                strArr3 = a4.mo1477b();
                str3 = str;
                break;
            case 3:
                a4 = EventsCommonContract.b(uri.getLastPathSegment());
                str = a4.mo1476a();
                strArr3 = a4.mo1477b();
                str3 = str;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str = a3.mo1476a();
                strArr3 = a3.mo1477b();
                str3 = str;
                break;
            case 5:
                a3 = Columns.H.m2095c(l);
                ConjunctionExpression b = SqlExpression.m10731b(Columns.I.m2095c(l), SqlExpression.m10724a(SqlExpression.m10725a(Columns.I.f1025d)));
                a4 = SqlExpression.m10723a(a3, b, m869e());
                str = a4.mo1476a();
                strArr3 = a4.mo1477b();
                str3 = str;
                break;
            case 7:
                a4 = SqlExpression.m10723a(a3, Columns.A.m2090a(GraphQLEventGuestStatus.INVITED.name()));
                str = a4.mo1476a();
                strArr3 = a4.mo1477b();
                str3 = str;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                a4 = SqlExpression.m10723a(a3, Columns.G.m2097d("0"));
                str = a4.mo1476a();
                strArr3 = a4.mo1477b();
                str3 = str;
                break;
            case 9:
                strArr3 = strArr2;
                str3 = str;
                break;
            default:
                throw new IllegalArgumentException("Uri for query not supported: " + uri);
        }
        if (Strings.isNullOrEmpty(str2)) {
            str4 = EventsCommonTable.a;
        } else {
            str4 = str2;
        }
        Cursor query = sQLiteQueryBuilder.query(this.f416a.mo2480a(), strArr, str3, strArr3, null, null, str4);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    private static long m852a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    private Expression m854a(long j, long j2) {
        if (j - j2 < 10800000) {
            j2 = j - 10800000;
        }
        String l = Long.toString(j2);
        Expression e = Columns.H.m2099e(l);
        Expression e2 = Columns.I.m2099e(l);
        Expression[] expressionArr = new Expression[]{e, e2};
        return SqlExpression.m10723a(SqlExpression.m10731b(expressionArr), m869e());
    }

    private static Expression m869e() {
        Expression d = Columns.C.m2097d("0");
        Expression a = SqlExpression.m10729a(Columns.A.f1025d, GraphQLEventGuestStatus.HOST.name(), GraphQLEventGuestStatus.GOING.name(), GraphQLEventGuestStatus.INVITED.name(), GraphQLEventGuestStatus.MAYBE.name(), GraphQLEventGuestStatus.NOT_GOING.name(), GraphQLEventGuestStatus.LIKED.name(), GraphQLEventGuestStatus.SAVED.name(), GraphQLEventGuestStatus.SUBSCRIBED_ADMIN_CALENDAR.name());
        Expression a2 = SqlExpression.m10729a(Columns.B.f1025d, GraphQLEventWatchStatus.WATCHED.toString(), GraphQLEventWatchStatus.GOING.toString(), GraphQLEventWatchStatus.DECLINED.toString());
        return SqlExpression.m10731b(d, a, a2);
    }

    protected final String mo8a(Uri uri) {
        switch (this.f419d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "vnd.android.cursor.dir/vnd.facebook.events.event";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return "vnd.android.cursor.item/vnd.facebook.events.event";
            default:
                throw new IllegalArgumentException("Unsupported Uri: " + uri);
        }
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        if (this.f419d.match(uri) != 1) {
            throw new IllegalArgumentException("Uri for insert not supported: " + uri);
        }
        SQLiteDetour.a(1018388760);
        long insert = this.f416a.mo2480a().insert("events", null, contentValues);
        SQLiteDetour.a(1040443171);
        if (insert > 0) {
            Uri withAppendedId = ContentUris.withAppendedId(this.f418c.b, insert);
            getContext().getContentResolver().notifyChange(withAppendedId, null);
            m870f();
            return withAppendedId;
        }
        throw new IllegalArgumentException("Writing to DB failed for values: " + contentValues);
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        Expression a;
        switch (this.f419d.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f416a.mo2481e();
                return 0;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a = EventsCommonContract.a(uri.getLastPathSegment());
                str = a.mo1476a();
                strArr = a.mo1477b();
                break;
            case 3:
                a = EventsCommonContract.b(uri.getLastPathSegment());
                str = a.mo1476a();
                strArr = a.mo1477b();
                break;
            case 9:
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI for delete: " + uri);
        }
        int delete = this.f416a.mo2480a().delete("events", str, strArr);
        if (delete <= 0) {
            return delete;
        }
        m870f();
        return delete;
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String a;
        String[] b;
        SQLiteDatabase a2 = this.f416a.mo2480a();
        Expression a3;
        switch (this.f419d.match(uri)) {
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a3 = EventsCommonContract.a(uri.getLastPathSegment());
                a = a3.mo1476a();
                b = a3.mo1477b();
                break;
            case 3:
                a3 = EventsCommonContract.b(uri.getLastPathSegment());
                a = a3.mo1476a();
                b = a3.mo1477b();
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI for update: " + uri);
        }
        int update = a2.update("events", contentValues, a, b);
        if (update > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
            m870f();
        }
        return update;
    }

    public static void m860a(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, Event event, ListeningExecutorService listeningExecutorService) {
        ExecutorDetour.a(listeningExecutorService, new 1(contentResolver, eventsCommonContract, event), 1645570334);
    }

    public static void m857a(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, int i, ListeningExecutorService listeningExecutorService) {
        ExecutorDetour.a(listeningExecutorService, new 2(contentResolver, eventsCommonContract, i), 1682395477);
    }

    public static void m866b(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, int i) {
        m862a(contentResolver, eventsCommonContract, m867c(contentResolver, eventsCommonContract, i));
    }

    private static List<String> m867c(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, int i) {
        List<String> a;
        Throwable e;
        String[] strArr = new String[]{Columns.b.m2091a()};
        String e2 = Columns.H.m2100e();
        List<String> emptyList = Collections.emptyList();
        Cursor query = contentResolver.query(eventsCommonContract.e, strArr, null, null, e2);
        try {
            int columnIndex = query.getColumnIndex(Columns.b.m2091a());
            a = Lists.m1296a();
            if (query.getCount() >= i) {
                a = Lists.m1296a();
                try {
                    query.moveToPosition(i);
                    while (!query.isAfterLast()) {
                        a.add(query.getString(columnIndex));
                        query.moveToNext();
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        BLog.b(EventsProvider.class, "Unexpected error when deleting past events: ", e);
                        if (query != null) {
                            query.close();
                        }
                        return a;
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
            } else if (query != null) {
                query.close();
            }
        } catch (Throwable e4) {
            e = e4;
            a = emptyList;
            BLog.b(EventsProvider.class, "Unexpected error when deleting past events: ", e);
            if (query != null) {
                query.close();
            }
            return a;
        }
        return a;
    }

    public static void m858a(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, long j, long j2, List<String> list) {
        m862a(contentResolver, eventsCommonContract, m855a(m853a(contentResolver, eventsCommonContract, j, j2), (List) list));
    }

    public static void m861a(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, String str, ListeningExecutorService listeningExecutorService) {
        listeningExecutorService.mo269a(new 3(contentResolver, eventsCommonContract, str));
    }

    private void m863a(EventsDatabaseSupplier eventsDatabaseSupplier, Clock clock, EventsCommonContract eventsCommonContract) {
        this.f416a = eventsDatabaseSupplier;
        this.f417b = clock;
        this.f418c = eventsCommonContract;
    }

    private static Cursor m853a(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, long j, long j2) {
        String l = Long.toString(j);
        String l2 = Long.toString(j2);
        Expression e = Columns.H.m2099e(l);
        Expression c = Columns.H.m2095c(l2);
        e = SqlExpression.m10723a(e, c);
        String a = e.mo1476a();
        String[] b = e.mo1477b();
        return contentResolver.query(eventsCommonContract.h, new String[]{Columns.b.f1025d, Columns.H.f1025d, Columns.I.f1025d}, a, b, null);
    }

    private static List<String> m855a(Cursor cursor, List<String> list) {
        List<String> a = Lists.m1296a();
        String a2 = Columns.b.m2091a();
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String string = cursor.getString(cursor.getColumnIndex(a2));
                if (!list.contains(string)) {
                    a.add(string);
                }
                cursor.moveToNext();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            BLog.b(EventsProvider.class, "Unexpected error when deleting events for sync: ", e);
            return a;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return a;
    }

    private static void m862a(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, @Nonnull List<String> list) {
        if (!list.isEmpty()) {
            Expression a = SqlExpression.m10728a(Columns.b.f1025d, (Collection) list);
            contentResolver.delete(eventsCommonContract.h, a.mo1476a(), a.mo1477b());
        }
    }

    private void m870f() {
        getContext().getContentResolver().notifyChange(this.f418c.d, null);
        getContext().getContentResolver().notifyChange(this.f418c.e, null);
        getContext().getContentResolver().notifyChange(this.f418c.f, null);
        getContext().getContentResolver().notifyChange(this.f418c.g, null);
    }
}
