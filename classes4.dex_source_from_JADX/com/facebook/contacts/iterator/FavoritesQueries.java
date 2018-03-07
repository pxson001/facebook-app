package com.facebook.contacts.iterator;

import android.content.ContentResolver;
import android.database.Cursor;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.contacts.data.FbContactsContract;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader;
import com.facebook.messaging.sms.contacts.PhoneContactsLoader.CallerContext;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: email_oauth_last_attempt_time */
public class FavoritesQueries {
    private static volatile FavoritesQueries f13182e;
    private final ContentResolver f13183a;
    private final FbContactsContract f13184b;
    private final UserIterators f13185c;
    private final Lazy<PhoneContactsLoader> f13186d;

    /* compiled from: email_oauth_last_attempt_time */
    class FavoriteOrderComparator implements Comparator<User> {
        private Map<String, Integer> f13663a;
        private Map<String, Float> f13664b;

        public int compare(Object obj, Object obj2) {
            return Float.compare(m14453a((User) obj), m14453a((User) obj2));
        }

        public FavoriteOrderComparator(Map<String, Integer> map, Map<String, Float> map2) {
            this.f13663a = map;
            this.f13664b = map2;
        }

        private float m14453a(User user) {
            String str;
            if (user.b()) {
                str = user.w().b;
                if (this.f13664b.containsKey(str)) {
                    return ((Float) this.f13664b.get(str)).floatValue();
                }
                return 10000.0f;
            }
            str = user.n().a();
            if (this.f13663a.containsKey(str)) {
                return (float) ((Integer) this.f13663a.get(str)).intValue();
            }
            return 10000.0f;
        }
    }

    public static com.facebook.contacts.iterator.FavoritesQueries m14044a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13182e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.FavoritesQueries.class;
        monitor-enter(r1);
        r0 = f13182e;	 Catch:{ all -> 0x003a }
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
        r0 = m14045b(r0);	 Catch:{ all -> 0x0035 }
        f13182e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13182e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.FavoritesQueries.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.FavoritesQueries");
    }

    private static FavoritesQueries m14045b(InjectorLike injectorLike) {
        return new FavoritesQueries(ContentResolverMethodAutoProvider.b(injectorLike), FbContactsContract.m11624a(injectorLike), UserIterators.m14040a(injectorLike), IdBasedLazy.a(injectorLike, 2707));
    }

    @Inject
    public FavoritesQueries(ContentResolver contentResolver, FbContactsContract fbContactsContract, UserIterators userIterators, Lazy<PhoneContactsLoader> lazy) {
        this.f13183a = contentResolver;
        this.f13184b = fbContactsContract;
        this.f13185c = userIterators;
        this.f13186d = lazy;
    }

    public final ImmutableList<User> m14048a() {
        Map b = m14046b();
        Collection b2 = this.f13185c.m14043b(ContactCursorsQuery.m11634b(b.keySet()));
        Map c = m14047c();
        ImmutableList a = ((PhoneContactsLoader) this.f13186d.get()).m14178a(c.keySet(), CallerContext.PEOPLE_TAB);
        Collection arrayList = new ArrayList();
        arrayList.addAll(b2);
        arrayList.addAll(a);
        Collections.sort(arrayList, new FavoriteOrderComparator(b, c));
        return ImmutableList.copyOf(arrayList);
    }

    private Map<String, Integer> m14046b() {
        Map<String, Integer> hashMap = new HashMap();
        Cursor query = this.f13183a.query(this.f13184b.f11198d.f11208a, new String[]{"fbid", "display_order"}, null, null, "display_order ASC");
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(0), Integer.valueOf(query.getInt(1)));
                } finally {
                    query.close();
                }
            }
        }
        return hashMap;
    }

    private Map<String, Float> m14047c() {
        Map<String, Float> hashMap = new HashMap();
        Cursor query = this.f13183a.query(this.f13184b.f11199e.f11210a, new String[]{"raw_phone_number", "display_order"}, null, null, "display_order ASC");
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(0), Float.valueOf(query.getFloat(1)));
                } finally {
                    query.close();
                }
            }
        }
        return hashMap;
    }
}
