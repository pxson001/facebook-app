package com.facebook.messaging.sms.contacts;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.util.LongSparseArray;
import android_src.provider.Telephony$Threads;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.sharedutils.SmsRecipientUtil;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.google.common.base.Strings;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: edit_story_privacy_save_failed */
public class SmsContactsRankingHelper {
    private static final Uri f13297a = Telephony$Threads.f13306a.buildUpon().appendQueryParameter("simple", "true").build();
    private static final String[] f13298b = new String[]{"_id", "date", "recipient_ids", "message_count"};
    private static volatile SmsContactsRankingHelper f13299i;
    private long f13300c = 0;
    public Map<String, Double> f13301d = RegularImmutableBiMap.a;
    private Map<String, Double> f13302e = RegularImmutableBiMap.a;
    private final Context f13303f;
    private final SmsRecipientUtil f13304g;
    private final Clock f13305h;

    public static com.facebook.messaging.sms.contacts.SmsContactsRankingHelper m14188a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13299i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.contacts.SmsContactsRankingHelper.class;
        monitor-enter(r1);
        r0 = f13299i;	 Catch:{ all -> 0x003a }
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
        r0 = m14191b(r0);	 Catch:{ all -> 0x0035 }
        f13299i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13299i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.contacts.SmsContactsRankingHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.contacts.SmsContactsRankingHelper");
    }

    private static SmsContactsRankingHelper m14191b(InjectorLike injectorLike) {
        return new SmsContactsRankingHelper((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), SmsRecipientUtil.m14196a(injectorLike));
    }

    @Inject
    public SmsContactsRankingHelper(Context context, Clock clock, SmsRecipientUtil smsRecipientUtil) {
        this.f13303f = context;
        this.f13305h = clock;
        this.f13304g = smsRecipientUtil;
    }

    public final Map<String, Double> m14194a(String str) {
        m14189a();
        Map hashMap = new HashMap();
        CharSequence e = FbPhoneNumberUtils.m14148e(str);
        if (!Strings.isNullOrEmpty(e)) {
            for (String str2 : this.f13302e.keySet()) {
                if (str2.contains(e)) {
                    hashMap.put(str2, this.f13302e.get(str2));
                }
            }
        }
        return hashMap;
    }

    public final double m14192a(String str, @Nullable String str2) {
        m14189a();
        Double d = (Double) this.f13301d.get(str);
        if (d == null) {
            d = (Double) this.f13302e.get(FbPhoneNumberUtils.m14148e(str));
            if (d == null && str2 != null) {
                d = (Double) this.f13302e.get(str2);
            }
        }
        return d != null ? d.doubleValue() : 0.0d;
    }

    public final List<String> m14193a(int i) {
        m14189a();
        List arrayList = new ArrayList();
        for (String str : this.f13301d.keySet()) {
            if (((long) FbPhoneNumberUtils.m14148e(str).length()) > 6) {
                arrayList.add(str);
            }
        }
        Collections.sort(arrayList, new 1(this));
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    private synchronized void m14189a() {
        long a = this.f13305h.a();
        if (a - this.f13300c >= 86400000) {
            try {
                m14190a(a);
            } catch (Throwable th) {
                BLog.c("SmsContactsRankingHelper", th, "load ranking map failed", new Object[0]);
            } finally {
                this.f13300c = a;
            }
        }
    }

    private void m14190a(long j) {
        Cursor query;
        Throwable th;
        long j2 = j - 7776000000L;
        ConjunctionExpression a = SqlExpression.a(new Expression[]{SqlExpression.e("message_count", "0"), SqlExpression.f("date", String.valueOf(j2)), SqlExpression.a(SqlExpression.d("recipient_ids", "% %"))});
        Map hashMap = new HashMap();
        try {
            query = this.f13303f.getContentResolver().query(f13297a, f13298b, a.a(), a.b(), null);
            try {
                int columnIndex = query.getColumnIndex("recipient_ids");
                int columnIndex2 = query.getColumnIndex("message_count");
                int columnIndex3 = query.getColumnIndex("date");
                while (query.moveToNext()) {
                    try {
                        long parseLong = Long.parseLong(query.getString(columnIndex));
                        hashMap.put(Long.valueOf(parseLong), Double.valueOf(m14187a(query.getInt(columnIndex2), j - query.getLong(columnIndex3))));
                    } catch (NumberFormatException e) {
                    }
                }
                if (query != null) {
                    query.close();
                }
                Map hashMap2 = new HashMap();
                Map hashMap3 = new HashMap();
                LongSparseArray a2 = this.f13304g.m14199a(hashMap.keySet());
                for (columnIndex2 = 0; columnIndex2 < a2.a(); columnIndex2++) {
                    long b = a2.b(columnIndex2);
                    String str = (String) a2.a(b);
                    if (FbPhoneNumberUtils.m14147c(str)) {
                        double doubleValue = ((Double) hashMap.get(Long.valueOf(b))).doubleValue();
                        hashMap3.put(str, Double.valueOf(doubleValue));
                        str = FbPhoneNumberUtils.m14148e(str);
                        if (!Strings.isNullOrEmpty(str)) {
                            hashMap2.put(str, Double.valueOf(doubleValue));
                        }
                    }
                }
                this.f13301d = hashMap3;
                this.f13302e = hashMap2;
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

    private static double m14187a(int i, long j) {
        return m14186a(((1.0d / (Math.exp(-(((double) i) * 0.05d)) + 1.0d)) - 0.5d) * 2.0d, j);
    }

    private static double m14186a(double d, long j) {
        return (d == 0.0d || j <= 0) ? d : d * Math.pow(0.5d, ((double) j) / 1.2096E9d);
    }
}
