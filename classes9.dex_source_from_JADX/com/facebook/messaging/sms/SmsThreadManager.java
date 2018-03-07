package com.facebook.messaging.sms;

import android.annotation.TargetApi;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.util.LongSparseArray;
import android_src.mmsv2.pdu.EncodedStringValue;
import android_src.mmsv2.pdu.PduPersister;
import android_src.provider.Telephony.Threads;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.clockskew.SkewedTimestampHandler;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.SmsThreadKeyUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.model.threads.ThreadSummaryByDateComparator;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.DeleteThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadListResultBuilder;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.common.SmsException;
import com.facebook.messaging.sms.database.ReadonlyModeMarkThreadDbHandler;
import com.facebook.messaging.sms.defaultapp.MmsSmsPendingMessagesMarker;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.sms.defaultapp.SmsReceiver;
import com.facebook.messaging.sms.readonly.AnonymousSmsThreadHelper;
import com.facebook.messaging.sms.sharedutils.SmsRecipientUtil;
import com.facebook.messaging.sms.util.SmsContactUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(19)
@UserScoped
/* compiled from: communication */
public class SmsThreadManager {
    private static final Uri f17496a = Threads.a.buildUpon().appendQueryParameter("simple", "true").build();
    private static final String[] f17497b = new String[]{"_id", "date", "recipient_ids", "snippet", "snippet_cs", "read", "error"};
    private static final String[] f17498c = new String[]{"recipient_ids"};
    private static final String[] f17499d = new String[]{"_id", "read"};
    private static final String[] f17500e = new String[]{"message_count"};
    private static final String[] f17501f = new String[]{"thread_id"};
    private static final ContentValues f17502g;
    private static final Object f17503x = new Object();
    private final LongSparseArray<List<String>> f17504h = new LongSparseArray();
    private final Set<Long> f17505i = new HashSet();
    private final Context f17506j;
    private final SmsRecipientUtil f17507k;
    public final SmsContactUtil f17508l;
    private final Clock f17509m;
    private final DefaultBlueServiceOperationFactory f17510n;
    private final SecureContextHelper f17511o;
    private final MmsSmsPendingMessagesMarker f17512p;
    private final Lazy<ReadonlyModeMarkThreadDbHandler> f17513q;
    private SkewedTimestampHandler f17514r;
    private final Lazy<SmsSpecialThreadManager> f17515s;
    private final Lazy<SmsTakeoverAnalyticsLogger> f17516t;
    private final Lazy<SmsIntegrationState> f17517u;
    private final Lazy<AnonymousSmsThreadHelper> f17518v;
    private final Lazy<SmsPermissionsUtil> f17519w;

    private static SmsThreadManager m17479b(InjectorLike injectorLike) {
        return new SmsThreadManager((Context) injectorLike.getInstance(Context.class), SmsRecipientUtil.a(injectorLike), SmsContactUtil.m17710a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MmsSmsPendingMessagesMarker.m17541a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8451), SkewedTimestampHandler.m10342a(injectorLike), IdBasedLazy.a(injectorLike, 8443), IdBasedLazy.a(injectorLike, 2706), IdBasedSingletonScopeProvider.b(injectorLike, 2704), IdBasedLazy.a(injectorLike, 8482), IdBasedSingletonScopeProvider.b(injectorLike, 8460));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sms.SmsThreadManager m17473a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17503x;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m17479b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17503x;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.SmsThreadManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sms.SmsThreadManager) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17503x;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sms.SmsThreadManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.SmsThreadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.SmsThreadManager");
    }

    static {
        ContentValues contentValues = new ContentValues(2);
        f17502g = contentValues;
        contentValues.put("read", "1");
        f17502g.put("seen", "1");
    }

    @Inject
    public SmsThreadManager(Context context, SmsRecipientUtil smsRecipientUtil, SmsContactUtil smsContactUtil, Clock clock, BlueServiceOperationFactory blueServiceOperationFactory, SecureContextHelper secureContextHelper, MmsSmsPendingMessagesMarker mmsSmsPendingMessagesMarker, Lazy<ReadonlyModeMarkThreadDbHandler> lazy, SkewedTimestampHandler skewedTimestampHandler, Lazy<SmsSpecialThreadManager> lazy2, Lazy<SmsTakeoverAnalyticsLogger> lazy3, Lazy<SmsIntegrationState> lazy4, Lazy<AnonymousSmsThreadHelper> lazy5, Lazy<SmsPermissionsUtil> lazy6) {
        this.f17506j = context;
        this.f17507k = smsRecipientUtil;
        this.f17508l = smsContactUtil;
        this.f17509m = clock;
        this.f17510n = blueServiceOperationFactory;
        this.f17511o = secureContextHelper;
        this.f17512p = mmsSmsPendingMessagesMarker;
        this.f17513q = lazy;
        this.f17514r = skewedTimestampHandler;
        this.f17515s = lazy2;
        this.f17516t = lazy3;
        this.f17517u = lazy4;
        this.f17518v = lazy5;
        this.f17519w = lazy6;
    }

    @Nullable
    public final ThreadSummary m17484a(long j, @Nullable Map<String, User> map) {
        ThreadSummary threadSummary = null;
        if (j != AnonymousSmsThreadHelper.f17729a) {
            ThreadSummary threadSummary2;
            Expression a = SqlExpression.a("_id", Long.toString(j));
            Cursor query = this.f17506j.getContentResolver().query(f17496a, f17497b, a.a(), a.b(), null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        threadSummary = m17472a(query, (Map) map);
                    }
                    query.close();
                    threadSummary2 = threadSummary;
                } catch (Throwable th) {
                    query.close();
                }
            } else {
                threadSummary2 = null;
            }
            if (threadSummary2 == null) {
                threadSummary2 = m17478b(j, map);
            }
            if (threadSummary2 == null) {
                threadSummary2 = m17480c(j, map);
            }
            return threadSummary2;
        } else if (!((SmsPermissionsUtil) this.f17519w.get()).m17594b()) {
            return ((AnonymousSmsThreadHelper) this.f17518v.get()).m17686a();
        } else {
            long b = m17477b();
            if (b > 0) {
                return ((AnonymousSmsThreadHelper) this.f17518v.get()).m17687a(b);
            }
            return null;
        }
    }

    @Nullable
    private ThreadSummary m17478b(long j, @Nullable Map<String, User> map) {
        ThreadSummary threadSummary = null;
        Cursor e = m17481e(j);
        if (e != null) {
            try {
                if (e.moveToNext()) {
                    threadSummary = m17472a(e, (Map) map);
                }
                e.close();
            } catch (Throwable th) {
                e.close();
            }
        }
        return threadSummary;
    }

    private Cursor m17481e(long j) {
        return this.f17506j.getContentResolver().query(Threads.a.buildUpon().appendPath(Long.toString(j)).appendPath("subject").build(), f17497b, null, null, null);
    }

    public final List<String> m17487a(long j) {
        List<String> list = (List) this.f17504h.a(j);
        if (list != null) {
            return list;
        }
        Expression a = SqlExpression.a("_id", String.valueOf(j));
        Cursor query = this.f17506j.getContentResolver().query(f17496a, f17498c, a.a(), a.b(), null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    list = this.f17507k.a(CursorHelper.c(query, "recipient_ids"));
                    if (list != null) {
                        this.f17504h.b(j, list);
                    }
                    query.close();
                    return list;
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        List<String> f = m17482f(j);
        String str = "SmsThreadManager";
        String str2 = "Reverted to get thread hack %s";
        Object[] objArr = new Object[1];
        objArr[0] = f != null ? "successfully" : "unsuccessfully";
        BLog.c(str, str2, objArr);
        return f;
    }

    private List<String> m17482f(long j) {
        Cursor e = m17481e(j);
        if (e != null) {
            try {
                if (e.moveToNext()) {
                    List<String> a = this.f17507k.a(CursorHelper.c(e, "recipient_ids"));
                    if (a != null) {
                        this.f17504h.b(j, a);
                    }
                    e.close();
                    return a;
                }
                e.close();
            } catch (Throwable th) {
                e.close();
            }
        }
        Collection a2 = SmsThreadKeyUtil.a(j);
        if (a2 != null) {
            return new ArrayList(a2);
        }
        return new ArrayList(0);
    }

    public final int m17493b(long j) {
        return m17487a(j).size();
    }

    private List<ThreadSummary> m17475a(int i, long j, Map<String, User> map) {
        List<ThreadSummary> arrayList = new ArrayList();
        ThreadSummary a;
        if (((SmsIntegrationState) this.f17517u.get()).c()) {
            if (j < 0) {
                a = m17484a(AnonymousSmsThreadHelper.f17729a, null);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            return arrayList;
        }
        boolean z;
        m17476a();
        m17492a(false);
        StringBuilder stringBuilder = new StringBuilder();
        if (j > 0) {
            stringBuilder.append("date<=").append(j).append(" AND ");
        }
        stringBuilder.append("message_count != 0");
        Cursor query = this.f17506j.getContentResolver().query(f17496a, f17497b, stringBuilder.toString(), null, "date DESC LIMIT " + i);
        long j2 = Long.MAX_VALUE;
        if (query != null) {
            z = false;
            while (query.moveToNext() && query.getPosition() < i) {
                try {
                    try {
                        a = m17472a(query, (Map) map);
                        if (a.k > j2) {
                            z = true;
                        }
                        j2 = a.k;
                        arrayList.add(a);
                    } catch (Throwable e) {
                        BLog.c("SmsThreadManager", "Failed to load thread", e);
                    }
                } catch (Throwable th) {
                    query.close();
                }
            }
            query.close();
        } else {
            z = false;
        }
        if (z) {
            Collections.sort(arrayList, new ThreadSummaryByDateComparator());
        }
        return arrayList;
    }

    private void m17476a() {
        Object obj;
        if (this.f17512p.f17555f) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            Intent intent = new Intent(this.f17506j, SmsReceiver.class);
            intent.setAction("com.facebook.messaging.sms.MARK_PENDING_MMS");
            this.f17506j.sendBroadcast(intent);
        }
    }

    private ThreadSummary m17472a(Cursor cursor, @Nullable Map<String, User> map) {
        List a;
        long b = CursorHelper.b(cursor, "_id");
        long b2 = CursorHelper.b(cursor, "date");
        String c = CursorHelper.c(cursor, "snippet");
        int a2 = CursorHelper.a(cursor, "snippet_cs");
        String c2 = CursorHelper.c(cursor, "recipient_ids");
        boolean z = CursorHelper.a(cursor, "read") > 0;
        int a3 = CursorHelper.a(cursor, "error");
        List list = (List) this.f17504h.a(b);
        if (list == null) {
            a = this.f17507k.a(c2);
            if (a != null) {
                this.f17504h.b(b, a);
            }
        } else {
            a = list;
        }
        return m17471a(b, b2, c, a2, z, a3, a, map);
    }

    private ThreadSummary m17480c(long j, @Nullable Map<String, User> map) {
        List a;
        List list = (List) this.f17504h.a(j);
        if (list == null) {
            a = m17487a(j);
        } else {
            a = list;
        }
        return m17471a(j, this.f17509m.a(), null, 0, true, 0, a, map);
    }

    private ThreadSummary m17471a(long j, long j2, String str, int i, boolean z, int i2, List<String> list, @Nullable Map<String, User> map) {
        boolean z2;
        String a = m17474a(str, i);
        List arrayList = new ArrayList();
        boolean z3 = true;
        for (String str2 : list) {
            boolean z4;
            User a2;
            if (SmsContactUtil.m17712b(str2)) {
                z4 = false;
            } else {
                z4 = z3;
            }
            if (map == null || !map.containsKey(str2)) {
                a2 = this.f17508l.m17714a(str2);
            } else {
                a2 = (User) map.get(str2);
            }
            if (map != null) {
                map.put(str2, a2);
            }
            arrayList.add(new ThreadParticipantBuilder().a(SmsContactUtil.m17709a(a2)).f());
            z3 = z4;
        }
        arrayList.add(new ThreadParticipantBuilder().a(this.f17508l.m17713a()).f());
        ThreadSummaryBuilder c = ThreadSummary.newBuilder().a(FolderName.INBOX).a(ThreadKey.b(j)).a(z3).e(this.f17514r.m10348a(j, j2)).j(j2).a(arrayList).c(a);
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ThreadSummaryBuilder a3 = c.c(z2).a(ThreadCustomization.newBuilder().b(this.f17506j.getResources().getColor(2131362305)).g());
        if (!(z || ((SmsIntegrationState) this.f17517u.get()).d())) {
            z = ((ReadonlyModeMarkThreadDbHandler) this.f17513q.get()).m17508a(j, j2, 0);
        }
        if (z) {
            a3.f(j2);
        }
        return a3.V();
    }

    private long m17477b() {
        Throwable th;
        Cursor cursor;
        try {
            Cursor query = this.f17506j.getContentResolver().query(f17496a, f17497b, "message_count>0", null, "date DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        long b = CursorHelper.b(query, "date");
                        if (query == null) {
                            return b;
                        }
                        query.close();
                        return b;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void m17495c(long j) {
        Throwable th;
        Cursor cursor;
        if (!((SmsIntegrationState) this.f17517u.get()).d()) {
            ((ReadonlyModeMarkThreadDbHandler) this.f17513q.get()).m17507a(ImmutableList.of(Long.valueOf(j)));
        } else if (j < 0) {
            ((SmsSpecialThreadManager) this.f17515s.get()).m17460a(j);
        } else {
            ContentResolver contentResolver = this.f17506j.getContentResolver();
            Uri withAppendedId = ContentUris.withAppendedId(Threads.a, j);
            try {
                Cursor query = contentResolver.query(withAppendedId, f17499d, "read=0 or seen=0", null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            Integer.valueOf(query.getCount());
                            contentResolver.update(withAppendedId, f17502g, "read=0 or seen=0", null);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public final void m17490a(Collection<Long> collection) {
        Throwable e;
        if (collection.size() == 1) {
            m17495c(((Long) Iterables.a(collection, Long.valueOf(0))).longValue());
        } else if (((SmsIntegrationState) this.f17517u.get()).d()) {
            ConjunctionExpression b = SqlExpression.b(new Expression[]{SqlExpression.a("read", "0"), SqlExpression.a("seen", "0")});
            ArrayList arrayList = new ArrayList(collection.size());
            for (Long l : collection) {
                if (l != null) {
                    if (l.longValue() < 0) {
                        ((SmsSpecialThreadManager) this.f17515s.get()).m17460a(l.longValue());
                    } else {
                        Builder withSelection = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Threads.a, l.longValue())).withSelection(b.a(), b.b());
                        withSelection.withValue("read", "1");
                        withSelection.withValue("seen", "1");
                        arrayList.add(withSelection.build());
                    }
                }
            }
            try {
                this.f17506j.getContentResolver().applyBatch("mms-sms", arrayList);
            } catch (RemoteException e2) {
                e = e2;
                BLog.b("SmsThreadManager", e, "sms/mms thread mark read failed. # threads = %d", new Object[]{Integer.valueOf(collection.size())});
            } catch (OperationApplicationException e3) {
                e = e3;
                BLog.b("SmsThreadManager", e, "sms/mms thread mark read failed. # threads = %d", new Object[]{Integer.valueOf(collection.size())});
            }
        } else {
            ((ReadonlyModeMarkThreadDbHandler) this.f17513q.get()).m17507a((Collection) collection);
        }
    }

    public final void m17494b(Collection<Long> collection) {
        Throwable e;
        Expression a = SqlExpression.a("read", "1");
        ArrayList arrayList = new ArrayList(collection.size());
        for (Long l : collection) {
            if (l != null) {
                if (l.longValue() < 0) {
                    ((SmsSpecialThreadManager) this.f17515s.get()).m17461b(l.longValue());
                } else {
                    Builder withSelection = ContentProviderOperation.newUpdate(ContentUris.withAppendedId(Threads.a, l.longValue())).withSelection(a.a(), a.b());
                    withSelection.withValue("read", "0");
                    arrayList.add(withSelection.build());
                }
            }
        }
        try {
            this.f17506j.getContentResolver().applyBatch("mms-sms", arrayList);
            return;
        } catch (RemoteException e2) {
            e = e2;
        } catch (OperationApplicationException e3) {
            e = e3;
        }
        BLog.b("SmsThreadManager", e, "sms/mms thread mark unread failed. # threads = %d", new Object[]{Integer.valueOf(collection.size())});
    }

    public final void m17491a(Set<Long> set) {
        Throwable e;
        ArrayList arrayList = new ArrayList(set.size());
        for (Long l : set) {
            if (l != null) {
                if (l.longValue() < 0) {
                    ((SmsSpecialThreadManager) this.f17515s.get()).m17462c(l.longValue());
                } else {
                    arrayList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(Threads.a, l.longValue())).build());
                    this.f17514r.m10349a(l.longValue());
                }
            }
        }
        try {
            this.f17506j.getContentResolver().applyBatch("mms-sms", arrayList);
        } catch (RemoteException e2) {
            e = e2;
            BLog.b("SmsThreadManager", e, "sms/mms thread deletion failed. # threads = %d", new Object[]{Integer.valueOf(set.size())});
            throw new SmsException("Failed to delete sms thread.");
        } catch (OperationApplicationException e3) {
            e = e3;
            BLog.b("SmsThreadManager", e, "sms/mms thread deletion failed. # threads = %d", new Object[]{Integer.valueOf(set.size())});
            throw new SmsException("Failed to delete sms thread.");
        }
    }

    public final void m17489a(String str) {
        boolean z = MmsSmsIdUtils.m17503d(str) || MmsSmsIdUtils.m17502c(str);
        Preconditions.checkArgument(z);
        this.f17506j.getContentResolver().delete(MmsSmsIdUtils.m17502c(str) ? MmsSmsIdUtils.m17497a(str) : MmsSmsIdUtils.m17500b(str), null, null);
    }

    private String m17474a(String str, int i) {
        if (StringUtil.a(str)) {
            return this.f17506j.getResources().getString(2131232331);
        }
        return i != 0 ? new EncodedStringValue(i, PduPersister.m3715a(str)).m3610c() : str;
    }

    public final void m17492a(boolean z) {
        Object obj = null;
        if (!z) {
            Cursor query = this.f17506j.getContentResolver().query(f17496a, f17497b, "message_count=0", null, "date DESC LIMIT 1");
            if (query != null) {
                try {
                    Object obj2;
                    if (query.moveToNext()) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    query.close();
                    obj = obj2;
                } catch (Throwable th) {
                    query.close();
                }
            }
        }
        if (z || r6 != null) {
            this.f17506j.getContentResolver().delete(Threads.b, null, null);
        }
    }

    public final boolean m17496d(long j) {
        Cursor query;
        Throwable th;
        boolean z = false;
        if (!this.f17505i.contains(Long.valueOf(j))) {
            Expression a = SqlExpression.a("_id", String.valueOf(j));
            try {
                query = this.f17506j.getContentResolver().query(f17496a, f17500e, a.a(), a.b(), null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            z = query.getInt(0) == 0;
                            if (query != null) {
                                query.close();
                            }
                            if (!z) {
                                this.f17505i.add(Long.valueOf(j));
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                z = true;
                if (query != null) {
                    query.close();
                }
                if (z) {
                    this.f17505i.add(Long.valueOf(j));
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
        return z;
    }

    public final FetchThreadListResult m17486a(FetchThreadListParams fetchThreadListParams) {
        boolean z;
        boolean z2 = true;
        if (fetchThreadListParams.f17118b == FolderName.INBOX) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "SMS Threads can only belong in the inbox");
        Map hashMap = new HashMap();
        Object a = m17475a(fetchThreadListParams.m17109f(), -1, hashMap);
        ImmutableList copyOf = ImmutableList.copyOf(a);
        if (a.size() >= fetchThreadListParams.m17109f()) {
            z2 = false;
        }
        ThreadsCollection threadsCollection = new ThreadsCollection(copyOf, z2);
        FetchThreadListResultBuilder newBuilder = FetchThreadListResult.newBuilder();
        newBuilder.f17145c = threadsCollection;
        newBuilder = newBuilder;
        newBuilder.f17143a = DataFetchDisposition.k;
        newBuilder = newBuilder;
        newBuilder.f17152j = this.f17509m.a();
        newBuilder = newBuilder;
        newBuilder.f17144b = FolderName.INBOX;
        newBuilder = newBuilder;
        newBuilder.f17146d = ImmutableList.copyOf(hashMap.values());
        return newBuilder.m17129m();
    }

    public final FetchMoreThreadsResult m17485a(FetchMoreThreadsParams fetchMoreThreadsParams) {
        boolean z;
        boolean z2 = true;
        if (fetchMoreThreadsParams.f17083a == FolderName.INBOX) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "SMS Threads can only belong in the inbox");
        Map hashMap = new HashMap();
        Object a = m17475a(fetchMoreThreadsParams.f17087e, fetchMoreThreadsParams.f17088f, hashMap);
        ImmutableList copyOf = ImmutableList.copyOf(a);
        if (a.size() == fetchMoreThreadsParams.f17087e) {
            z2 = false;
        }
        return new FetchMoreThreadsResult(DataFetchDisposition.k, FolderName.INBOX, new ThreadsCollection(copyOf, z2), ImmutableList.copyOf(hashMap.values()), this.f17509m.a());
    }

    public final long m17483a(Uri uri, long j) {
        long j2;
        Bundle bundle;
        Uri parse;
        Intent intent;
        Throwable th;
        Cursor cursor = null;
        Cursor query;
        try {
            query = this.f17506j.getContentResolver().query(uri, f17501f, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        j2 = query.getLong(0);
                        if (query != null) {
                            query.close();
                        }
                        if (j2 == j) {
                            return j;
                        }
                        bundle = new Bundle();
                        bundle.putParcelable("deleteThreadsParams", new DeleteThreadsParams(ImmutableList.of(ThreadKey.b(j))));
                        BlueServiceOperationFactoryDetour.a(this.f17510n, "delete_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -1947868859).a(true).a();
                        parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.A, Long.toString(j2)));
                        intent = new Intent(MessagingIntentUris.a);
                        intent.setData(parse);
                        intent.setFlags(268435456);
                        intent.putExtra("focus_compose", true);
                        intent.putExtra("show_composer", true);
                        this.f17511o.a(intent, this.f17506j);
                        return j2;
                    }
                } catch (Exception e) {
                    if (query == null) {
                        j2 = j;
                    } else {
                        query.close();
                        j2 = j;
                    }
                    if (j2 == j) {
                        return j;
                    }
                    bundle = new Bundle();
                    bundle.putParcelable("deleteThreadsParams", new DeleteThreadsParams(ImmutableList.of(ThreadKey.b(j))));
                    BlueServiceOperationFactoryDetour.a(this.f17510n, "delete_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -1947868859).a(true).a();
                    parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.A, Long.toString(j2)));
                    intent = new Intent(MessagingIntentUris.a);
                    intent.setData(parse);
                    intent.setFlags(268435456);
                    intent.putExtra("focus_compose", true);
                    intent.putExtra("show_composer", true);
                    this.f17511o.a(intent, this.f17506j);
                    return j2;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            j2 = j;
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            query = null;
            if (query == null) {
                query.close();
                j2 = j;
            } else {
                j2 = j;
            }
            if (j2 == j) {
                return j;
            }
            bundle = new Bundle();
            bundle.putParcelable("deleteThreadsParams", new DeleteThreadsParams(ImmutableList.of(ThreadKey.b(j))));
            BlueServiceOperationFactoryDetour.a(this.f17510n, "delete_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -1947868859).a(true).a();
            parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.A, Long.toString(j2)));
            intent = new Intent(MessagingIntentUris.a);
            intent.setData(parse);
            intent.setFlags(268435456);
            intent.putExtra("focus_compose", true);
            intent.putExtra("show_composer", true);
            this.f17511o.a(intent, this.f17506j);
            return j2;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (j2 == j) {
            return j;
        }
        bundle = new Bundle();
        bundle.putParcelable("deleteThreadsParams", new DeleteThreadsParams(ImmutableList.of(ThreadKey.b(j))));
        BlueServiceOperationFactoryDetour.a(this.f17510n, "delete_threads", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), -1947868859).a(true).a();
        parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.A, Long.toString(j2)));
        intent = new Intent(MessagingIntentUris.a);
        intent.setData(parse);
        intent.setFlags(268435456);
        intent.putExtra("focus_compose", true);
        intent.putExtra("show_composer", true);
        this.f17511o.a(intent, this.f17506j);
        return j2;
    }

    public final void m17488a(ThreadSummary threadSummary) {
        Object obj;
        if (threadSummary == null || threadSummary.h == null || threadSummary.h.isEmpty()) {
            obj = null;
        } else {
            ThreadKey threadKey = threadSummary.a;
            if (ThreadKey.d(threadKey)) {
                List<String> a = m17487a(threadKey.i());
                if (a == null || a.isEmpty()) {
                    obj = null;
                } else {
                    Map hashMap = new HashMap(a.size());
                    for (String a2 : a) {
                        User a3 = this.f17508l.m17714a(a2);
                        hashMap.put(a3.T, a3);
                    }
                    ImmutableList immutableList = threadSummary.h;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
                        if (threadParticipant.b().e()) {
                            User user = (User) hashMap.get(threadParticipant.b());
                            if (user == null || !StringUtil.a(threadParticipant.e(), user.k())) {
                                obj = 1;
                                break;
                            }
                        }
                    }
                    obj = null;
                }
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            FetchThreadParamsBuilder newBuilder = FetchThreadParams.newBuilder();
            newBuilder.f17163a = ThreadCriteria.a(threadSummary.a);
            newBuilder = newBuilder;
            newBuilder.f17164b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            newBuilder = newBuilder;
            newBuilder.f17168f = 20;
            Parcelable i2 = newBuilder.m17140i();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadParams", i2);
            BlueServiceOperationFactoryDetour.a(this.f17510n, "fetch_thread", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(SmsThreadManager.class), -1113140565).a();
        }
    }
}
