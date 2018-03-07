package com.facebook.contacts.iterator;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.RawContactsEntity;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb4a */
public class PhoneUserIterators {
    private static final Class<?> f12167a = PhoneUserIterators.class;
    private static final String[] f12168b = new String[]{"_id"};
    private static final String[] f12169c = new String[]{"_id", "has_phone_number"};
    private static final String[] f12170d = new String[]{"_id", "contact_id", "deleted", "data_version", "mimetype", "is_primary", "is_super_primary", "data_version", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9"};
    private static final String[] f12171e = new String[]{"_id", "version"};
    private static volatile PhoneUserIterators f12172l;
    private final ContentResolver f12173f;
    private final MessengerPhoneUserIteratorProvider f12174g;
    private final FB4APhonebookContactIteratorProvider f12175h;
    private final MessengerPhonebookContactIteratorProvider f12176i;
    private final RuntimePermissionsUtil f12177j;
    private final Provider<TriState> f12178k;

    public static com.facebook.contacts.iterator.PhoneUserIterators m12840a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12172l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.PhoneUserIterators.class;
        monitor-enter(r1);
        r0 = f12172l;	 Catch:{ all -> 0x003a }
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
        r0 = m12842b(r0);	 Catch:{ all -> 0x0035 }
        f12172l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12172l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.PhoneUserIterators.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.PhoneUserIterators");
    }

    private static PhoneUserIterators m12842b(InjectorLike injectorLike) {
        return new PhoneUserIterators(ContentResolverMethodAutoProvider.b(injectorLike), (MessengerPhoneUserIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessengerPhoneUserIteratorProvider.class), (FB4APhonebookContactIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FB4APhonebookContactIteratorProvider.class), (MessengerPhonebookContactIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessengerPhonebookContactIteratorProvider.class), RuntimePermissionsUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 655));
    }

    @Inject
    public PhoneUserIterators(ContentResolver contentResolver, MessengerPhoneUserIteratorProvider messengerPhoneUserIteratorProvider, FB4APhonebookContactIteratorProvider fB4APhonebookContactIteratorProvider, MessengerPhonebookContactIteratorProvider messengerPhonebookContactIteratorProvider, RuntimePermissionsUtil runtimePermissionsUtil, Provider<TriState> provider) {
        this.f12173f = contentResolver;
        this.f12174g = messengerPhoneUserIteratorProvider;
        this.f12175h = fB4APhonebookContactIteratorProvider;
        this.f12176i = messengerPhonebookContactIteratorProvider;
        this.f12177j = runtimePermissionsUtil;
        this.f12178k = provider;
    }

    public final MessengerPhoneUserIterator m12844a() {
        List a = Lists.a();
        Uri uri = Contacts.CONTENT_URI;
        Expression a2 = SqlExpression.a("has_phone_number", "1");
        Cursor query = this.f12173f.query(uri, f12169c, a2.a(), a2.b(), null);
        while (query.moveToNext()) {
            try {
                a.add(Integer.valueOf(query.getInt(0)));
            } finally {
                query.close();
            }
        }
        Cursor a3 = m12839a(a);
        return this.f12174g.m12849a(a3);
    }

    public final MessengerPhoneUserIterator m12845a(String str, int i) {
        List a = Lists.a();
        m12841a(str, i, a);
        m12843b(str, i, a);
        return this.f12174g.m12849a(m12839a(a));
    }

    @Nullable
    public final AbstractPhonebookContactIterator m12846b() {
        if (!this.f12177j.a("android.permission.READ_CONTACTS")) {
            return null;
        }
        Cursor a = m12838a(RawContactsEntity.CONTENT_URI);
        Cursor a2 = m12838a(RawContactsEntity.PROFILE_CONTENT_URI);
        try {
            Cursor cursor;
            List arrayList = new ArrayList();
            if (a != null) {
                arrayList.add(a);
            }
            if (a2 != null) {
                arrayList.add(a2);
            }
            if (arrayList.isEmpty()) {
                cursor = null;
            } else {
                Object mergeCursor = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[arrayList.size()]));
            }
            if (cursor != null) {
                return this.f12175h.m12850a(cursor);
            }
            return null;
        } catch (Throwable e) {
            BLog.a(f12167a, e, "Got Exception in getFB4AContactsUploadIterator, closing open cursors.", new Object[0]);
            if (a != null) {
                a.close();
            }
            if (a2 != null) {
                a2.close();
            }
            throw e;
        }
    }

    @Nullable
    public final AbstractPhonebookContactIterator m12847c() {
        if (!this.f12177j.a("android.permission.READ_CONTACTS")) {
            return null;
        }
        Cursor query = this.f12173f.query(RawContactsEntity.CONTENT_URI, AbstractPhonebookContactIterator.a, null, null, "contact_id");
        if (query != null) {
            return this.f12176i.m12851a(query);
        }
        return null;
    }

    @Nullable
    public final Cursor m12848d() {
        if (!this.f12177j.a("android.permission.READ_CONTACTS")) {
            return null;
        }
        Cursor query;
        try {
            query = this.f12173f.query(RawContacts.CONTENT_URI, f12171e, null, null, "_id");
        } catch (Throwable e) {
            BLog.a(f12167a, e, "Got Exception in getRawContactsIdAndVersionCursor, closing open cursor.", new Object[0]);
            query = null;
        }
        return query;
    }

    @Nullable
    private Cursor m12838a(Uri uri) {
        String[] e;
        if (((TriState) this.f12178k.get()).asBoolean(true)) {
            e = AbstractPhonebookContactIterator.e();
        } else {
            e = AbstractPhonebookContactIterator.a;
        }
        try {
            return this.f12173f.query(uri, e, null, null, "contact_id");
        } catch (Throwable e2) {
            BLog.a(f12167a, e2, "Got Exception in getCursorByEndpoint, closing open cursor.", new Object[0]);
            return null;
        }
    }

    private void m12841a(String str, int i, List<Integer> list) {
        Cursor query = this.f12173f.query(Contacts.CONTENT_FILTER_URI.buildUpon().appendPath(str).build(), f12168b, null, null, null);
        while (query.moveToNext() && list.size() < i) {
            try {
                list.add(Integer.valueOf(query.getInt(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        query.close();
    }

    private void m12843b(String str, int i, List<Integer> list) {
        Cursor query = this.f12173f.query(PhoneLookup.CONTENT_FILTER_URI.buildUpon().appendPath(str).build(), f12168b, null, null, null);
        while (query.moveToNext() && list.size() < i) {
            try {
                list.add(Integer.valueOf(query.getInt(0)));
            } catch (Throwable th) {
                query.close();
            }
        }
        query.close();
    }

    private Cursor m12839a(List<Integer> list) {
        Expression a = SqlExpression.a("contact_id", list);
        return this.f12173f.query(RawContactsEntity.CONTENT_URI, f12170d, a.a(), a.b(), null);
    }
}
