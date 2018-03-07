package com.facebook.messaging.sms.sharedutils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: edit_story_privacy_open */
public class SmsRecipientUtil {
    private static final Uri f13317a = Uri.parse("content://mms-sms/canonical-addresses");
    private static final String[] f13318d = new String[]{"_id", "address"};
    private static volatile SmsRecipientUtil f13319e;
    private final Map<Long, String> f13320b = Collections.synchronizedMap(new ArrayMap());
    private final ContentResolver f13321c;

    public static com.facebook.messaging.sms.sharedutils.SmsRecipientUtil m14196a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13319e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.sharedutils.SmsRecipientUtil.class;
        monitor-enter(r1);
        r0 = f13319e;	 Catch:{ all -> 0x003a }
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
        r0 = m14198b(r0);	 Catch:{ all -> 0x0035 }
        f13319e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13319e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.sharedutils.SmsRecipientUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.sharedutils.SmsRecipientUtil");
    }

    private static SmsRecipientUtil m14198b(InjectorLike injectorLike) {
        return new SmsRecipientUtil(ContentResolverMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public SmsRecipientUtil(ContentResolver contentResolver) {
        this.f13321c = contentResolver;
    }

    public final List<String> m14200a(String str) {
        if (StringUtil.a(str)) {
            return new ArrayList();
        }
        String[] split = str.split(" ");
        List arrayList = new ArrayList(split.length);
        List<String> arrayList2 = new ArrayList(split.length);
        for (String parseLong : split) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(parseLong));
                if (this.f13320b.containsKey(valueOf)) {
                    arrayList2.add(this.f13320b.get(valueOf));
                } else {
                    arrayList.add(valueOf);
                }
            } catch (NumberFormatException e) {
            }
        }
        if (arrayList.isEmpty()) {
            return arrayList2;
        }
        arrayList2.addAll(m14197a(arrayList));
        return arrayList2;
    }

    public final LongSparseArray<String> m14199a(Collection<Long> collection) {
        if (collection == null || collection.isEmpty()) {
            return new LongSparseArray();
        }
        List<Long> arrayList = new ArrayList();
        LongSparseArray<String> longSparseArray = new LongSparseArray(collection.size());
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (this.f13320b.containsKey(Long.valueOf(longValue2))) {
                longSparseArray.b(longValue2, this.f13320b.get(Long.valueOf(longValue2)));
            } else {
                arrayList.add(Long.valueOf(longValue2));
            }
        }
        if (!arrayList.isEmpty()) {
            m14197a((List) arrayList);
            for (Long longValue3 : arrayList) {
                longValue2 = longValue3.longValue();
                if (this.f13320b.containsKey(Long.valueOf(longValue2))) {
                    longSparseArray.b(longValue2, this.f13320b.get(Long.valueOf(longValue2)));
                }
            }
        }
        return longSparseArray;
    }

    private List<String> m14197a(List<Long> list) {
        Throwable th;
        List<String> arrayList = new ArrayList(list.size());
        Expression a = SqlExpression.a("_id", list);
        Cursor query;
        try {
            query = this.f13321c.query(f13317a, f13318d, a.a(), a.b(), null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("address");
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow("_id");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    this.f13320b.put(Long.valueOf(query.getLong(columnIndexOrThrow2)), string);
                    arrayList.add(string);
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
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
