package com.facebook.contacts.iterator;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.contacts.data.FbContactsContract;
import com.facebook.contacts.data.FbContactsContract.ContactColumns;
import com.facebook.contacts.data.FbContactsContract.QueryType;
import com.facebook.contacts.data.FbContactsContract.SearchTable;
import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: getCurrentFrameAsBitmapSLOW */
public class ContactCursors {
    private static final Class<?> f11189a = ContactCursors.class;
    private static volatile ContactCursors f11190e;
    private final ContentResolver f11191b;
    private final FbContactsContract f11192c;
    private final Provider<User> f11193d;

    /* compiled from: getCurrentFrameAsBitmapSLOW */
    class C05421 implements Function<ContactProfileType, Integer> {
        final /* synthetic */ ContactCursors f11230a;

        C05421(ContactCursors contactCursors) {
            this.f11230a = contactCursors;
        }

        public Object apply(Object obj) {
            return Integer.valueOf(((ContactProfileType) obj).getDbValue());
        }
    }

    public static com.facebook.contacts.iterator.ContactCursors m11620a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11190e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.ContactCursors.class;
        monitor-enter(r1);
        r0 = f11190e;	 Catch:{ all -> 0x003a }
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
        r0 = m11621b(r0);	 Catch:{ all -> 0x0035 }
        f11190e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11190e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.ContactCursors.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.ContactCursors");
    }

    private static ContactCursors m11621b(InjectorLike injectorLike) {
        return new ContactCursors(ContentResolverMethodAutoProvider.b(injectorLike), FbContactsContract.m11624a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    @Inject
    public ContactCursors(ContentResolver contentResolver, FbContactsContract fbContactsContract, Provider<User> provider) {
        this.f11191b = contentResolver;
        this.f11192c = fbContactsContract;
        this.f11193d = provider;
    }

    public final Cursor m11622a(ContactCursorsQuery contactCursorsQuery, QueryType queryType) {
        return m11623a(contactCursorsQuery, queryType, this.f11192c.m11626a());
    }

    @Nullable
    public final Cursor m11623a(ContactCursorsQuery contactCursorsQuery, QueryType queryType, Set<SearchType> set) {
        List a;
        String str;
        Uri withAppendedPath;
        if (queryType == QueryType.CONTACT) {
            a = Lists.a(new String[]{"data", "phonebook_section_key", "_id"});
        } else {
            a = Lists.a(ContactColumns.f11206a);
        }
        String[] strArr = new String[a.size()];
        a.toArray(strArr);
        ConjunctionExpression a2 = SqlExpression.a();
        if (contactCursorsQuery.f11216a != null) {
            a2.a(SqlExpression.a("type", Collections2.a(contactCursorsQuery.f11216a, new C05421(this))));
        }
        if (contactCursorsQuery.f11217b != null) {
            a2.a(SqlExpression.a("link_type", Collections2.a(contactCursorsQuery.f11217b, new 2(this))));
        }
        if (contactCursorsQuery.f11220e) {
            a2.a(SqlExpression.b("fbid", new String[]{((User) this.f11193d.get()).a}));
        }
        if (contactCursorsQuery.f11222g) {
            a2.a(SqlExpression.a("is_messenger_user", "false"));
        }
        if (contactCursorsQuery.f11221f) {
            a2.a(SqlExpression.a("is_mobile_pushable", "1"));
        }
        if (contactCursorsQuery.f11223h) {
            a2.a(SqlExpression.a("is_messenger_user", "true"));
        }
        if (contactCursorsQuery.f11224i) {
            a2.a(SqlExpression.a("is_on_viewer_contact_list", "true"));
        }
        if (contactCursorsQuery.f11218c != null) {
            a2.a(SqlExpression.a("fbid", UserKey.c(contactCursorsQuery.f11218c)));
        }
        if (contactCursorsQuery.f11225j) {
            a2.a(SqlExpression.a("communication_rank", "0"));
        }
        String str2 = null;
        SortKey sortKey = contactCursorsQuery.f11226k;
        if (sortKey != SortKey.NO_SORT_ORDER) {
            if (sortKey == SortKey.PHAT_RANK) {
                BLog.b(f11189a, "Trying to use PHAT rank to sort a legacy contacts query. Falling back to communication rank");
            }
            String str3 = sortKey.mLegacyIndexColumnName;
            StringBuilder append = new StringBuilder().append(str3);
            if (contactCursorsQuery.f11227l) {
                str2 = " DESC";
            } else {
                str2 = "";
            }
            str2 = append.append(str2).toString();
            a2.a(SqlExpression.a(str3));
        }
        if (contactCursorsQuery.f11228m >= 0) {
            if (str2 == null) {
                str2 = "_id";
            }
            str = str2 + " LIMIT " + contactCursorsQuery.f11228m;
        } else {
            str = str2;
        }
        if (contactCursorsQuery.f11219d != null) {
            SearchTable searchTable = this.f11192c.f11200f;
            str3 = contactCursorsQuery.f11219d;
            withAppendedPath = Uri.withAppendedPath(Uri.withAppendedPath(searchTable.f11212c, Uri.encode(Joiner.on(",").join(set))), Uri.encode(str3));
        } else {
            withAppendedPath = this.f11192c.f11197c.f11204c;
        }
        return this.f11191b.query(withAppendedPath, strArr, a2.a(), a2.b(), str);
    }
}
