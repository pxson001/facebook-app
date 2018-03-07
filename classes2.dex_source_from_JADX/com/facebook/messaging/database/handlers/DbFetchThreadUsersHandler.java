package com.facebook.messaging.database.handlers;

import android.database.Cursor;
import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.common.calltoaction.serialization.CallToActionSerialization;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.database.threads.ThreadsDbSchemaPart$ThreadUsersTable$Columns;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.facebook.user.module.UserSerialization;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: m_payments_new_checkout_flow */
public class DbFetchThreadUsersHandler {
    private static final String[] f15286f = new String[]{Columns.f15293a, Columns.f15294b, Columns.f15295c, Columns.f15296d, Columns.f15297e, Columns.f15298f, Columns.f15299g, Columns.f15300h, Columns.f15301i, Columns.f15302j, Columns.f15303k, Columns.f15304l, Columns.f15305m, Columns.f15306n, Columns.f15307o, Columns.f15308p, Columns.f15309q, Columns.f15310r, Columns.f15311s, Columns.f15312t, Columns.f15313u, Columns.f15314v, Columns.f15315w, Columns.f15316x, Columns.f15317y, Columns.f15318z};
    private static volatile DbFetchThreadUsersHandler f15287g;
    private final Clock f15288a;
    private final Provider<ThreadsDatabaseSupplier> f15289b;
    private final UserSerialization f15290c;
    private final ObjectMapperWithUncheckedException f15291d;
    private final CallToActionSerialization f15292e;

    /* compiled from: m_payments_new_checkout_flow */
    final class Columns {
        static final String f15293a = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15319a.f1025d;
        static final String f15294b = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15320b.f1025d;
        static final String f15295c = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15321c.f1025d;
        static final String f15296d = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15323e.f1025d;
        static final String f15297e = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15322d.f1025d;
        static final String f15298f = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15324f.f1025d;
        static final String f15299g = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15325g.f1025d;
        static final String f15300h = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15326h.f1025d;
        static final String f15301i = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15327i.f1025d;
        static final String f15302j = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15329k.f1025d;
        static final String f15303k = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15330l.f1025d;
        static final String f15304l = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15331m.f1025d;
        static final String f15305m = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15332n.f1025d;
        static final String f15306n = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15328j.f1025d;
        static final String f15307o = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15333o.f1025d;
        static final String f15308p = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15334p.f1025d;
        static final String f15309q = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15335q.f1025d;
        static final String f15310r = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15336r.f1025d;
        static final String f15311s = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15337s.f1025d;
        static final String f15312t = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15338t.f1025d;
        static final String f15313u = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15339u.f1025d;
        static final String f15314v = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15340v.f1025d;
        static final String f15315w = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15341w.f1025d;
        static final String f15316x = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15342x.f1025d;
        static final String f15317y = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15343y.f1025d;
        static final String f15318z = ThreadsDbSchemaPart$ThreadUsersTable$Columns.f15344z.f1025d;
    }

    public static com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler m21839a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15287g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler.class;
        monitor-enter(r1);
        r0 = f15287g;	 Catch:{ all -> 0x003a }
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
        r0 = m21841b(r0);	 Catch:{ all -> 0x0035 }
        f15287g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15287g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler");
    }

    private static DbFetchThreadUsersHandler m21841b(InjectorLike injectorLike) {
        return new DbFetchThreadUsersHandler(SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 7815), UserSerialization.m21850b(injectorLike), ObjectMapperWithUncheckedException.m21860a(injectorLike), CallToActionSerialization.m21865b(injectorLike));
    }

    @Inject
    DbFetchThreadUsersHandler(Clock clock, Provider<ThreadsDatabaseSupplier> provider, UserSerialization userSerialization, ObjectMapperWithUncheckedException objectMapperWithUncheckedException, CallToActionSerialization callToActionSerialization) {
        this.f15288a = clock;
        this.f15289b = provider;
        this.f15290c = userSerialization;
        this.f15291d = objectMapperWithUncheckedException;
        this.f15292e = callToActionSerialization;
    }

    @Nullable
    public final User m21845a(UserKey userKey) {
        Collection hashSet = new HashSet();
        hashSet.add(userKey);
        ImmutableList a = m21846a(hashSet);
        if (a == null || a.size() != 1) {
            return null;
        }
        User user = (User) a.get(0);
        long a2 = this.f15288a.mo211a() - user.f3584L;
        if (a2 <= 86400000) {
            return user;
        }
        userKey.toString();
        Long.valueOf(a2);
        return null;
    }

    public final ImmutableList<User> m21846a(Collection<UserKey> collection) {
        TracerDetour.a("DbFetchThreadUsersHandler.doThreadUsersQuery", 796453799);
        try {
            Map c = Maps.m838c();
            String str = null;
            String[] strArr = null;
            if (collection != null) {
                Expression a = SqlExpression.m10728a(Columns.f15293a, UserKey.m5863b((Collection) collection));
                str = a.mo1476a();
                strArr = a.mo1477b();
            }
            Cursor query = ((ThreadsDatabaseSupplier) this.f15289b.get()).mo2480a().query("thread_users", f15286f, str, strArr, null, null, null);
            while (query.moveToNext()) {
                try {
                    PicSquare a2;
                    CommercePageType commercePageType;
                    ImmutableList c2;
                    ImmutableList b;
                    ImmutableList a3;
                    long parseLong;
                    UserKey a4 = UserKey.m5860a(m21840a(query, Columns.f15293a));
                    Name name = new Name(m21840a(query, Columns.f15294b), m21840a(query, Columns.f15295c), m21840a(query, Columns.f15296d));
                    String a5 = m21840a(query, Columns.f15297e);
                    String a6 = m21840a(query, Columns.f15299g);
                    if (a6 != null) {
                        a2 = UserSerialization.m21847a(this.f15291d.m21862a(a6));
                    } else {
                        a2 = null;
                    }
                    boolean b2 = m21842b(query, Columns.f15298f);
                    boolean b3 = m21842b(query, Columns.f15301i);
                    boolean b4 = m21842b(query, Columns.f15302j);
                    boolean b5 = m21842b(query, Columns.f15304l);
                    boolean b6 = m21842b(query, Columns.f15305m);
                    boolean b7 = m21842b(query, Columns.f15307o);
                    float c3 = m21843c(query, Columns.f15303k);
                    String a7 = m21840a(query, Columns.f15300h);
                    String a8 = m21840a(query, Columns.f15311s);
                    boolean b8 = m21842b(query, Columns.f15312t);
                    CommercePageType commercePageType2 = null;
                    try {
                        a6 = m21840a(query, Columns.f15306n);
                        if (!Strings.isNullOrEmpty(a6)) {
                            commercePageType2 = CommercePageType.valueOf(a6);
                        }
                        commercePageType = commercePageType2;
                    } catch (IllegalArgumentException e) {
                        commercePageType = null;
                    }
                    a6 = m21840a(query, Columns.f15308p);
                    if (a6 != null) {
                        c2 = UserSerialization.m21853c(this.f15291d.m21862a(a6));
                    } else {
                        c2 = null;
                    }
                    ImmutableList of = ImmutableList.of();
                    String a9 = m21840a(query, Columns.f15315w);
                    if (a9 != null) {
                        b = UserSerialization.m21852b(this.f15291d.m21862a(a9));
                    } else {
                        b = of;
                    }
                    of = ImmutableList.of();
                    a9 = m21840a(query, Columns.f15318z);
                    if (a9 != null) {
                        a3 = this.f15292e.m21866a(a9);
                    } else {
                        a3 = of;
                    }
                    boolean b9 = m21842b(query, Columns.f15309q);
                    long d = m21844d(query, Columns.f15310r);
                    boolean b10 = m21842b(query, Columns.f15313u);
                    boolean b11 = m21842b(query, Columns.f15314v);
                    boolean b12 = m21842b(query, Columns.f15316x);
                    boolean b13 = m21842b(query, Columns.f15317y);
                    UserBuilder c4 = new UserBuilder().m5767a(a4.m5866a(), a4.m5867b()).m5776b(name).m5786e(a5).m5782c(b2).m5765a(a2).m5799l(a7).m5785d(b3).m5798k(b4).m5760a(c3).m5790f(b6).m5787e(b5).m5766a(commercePageType).m5796j(b7).m5777b(c2).m5792h(b9).m5780c(d);
                    if (a8 != null) {
                        parseLong = Long.parseLong(a8);
                    } else {
                        parseLong = 0;
                    }
                    c.put(a4, c4.m5784d(parseLong).m5801m(b8).m5794i(b10).m5791g(b11).m5769a(b).m5803o(b12).m5804p(b13).m5781c(a3).aa());
                } finally {
                    query.close();
                }
            }
            ImmutableList<User> copyOf = ImmutableList.copyOf(c.values());
            return copyOf;
        } finally {
            TracerDetour.a(-578949210);
        }
    }

    private static String m21840a(Cursor cursor, String str) {
        return cursor.getString(cursor.getColumnIndexOrThrow(str));
    }

    private static boolean m21842b(Cursor cursor, String str) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(str)) != 0;
    }

    private static float m21843c(Cursor cursor, String str) {
        return cursor.getFloat(cursor.getColumnIndexOrThrow(str));
    }

    private static long m21844d(Cursor cursor, String str) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(str));
    }
}
