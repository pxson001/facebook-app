package com.facebook.messaging.sms.sharedutils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.PhoneLookup;
import android_src.provider.Telephony$Mms;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.cursors.CursorHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserEmailAddress;
import com.facebook.user.model.UserPhoneNumber;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: eligible_clash_units */
public class SmsUserUtil {
    private static final String[] f13266a = new String[]{"normalized_number", "type", "_id", "display_name", "photo_thumb_uri"};
    private static final String[] f13267b = new String[]{"data1", "data2", "contact_id", "display_name", "photo_thumb_uri"};
    private static volatile SmsUserUtil f13268e;
    private final ContentResolver f13269c;
    private final FbPhoneNumberUtils f13270d;

    public static com.facebook.messaging.sms.sharedutils.SmsUserUtil m14137a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13268e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sms.sharedutils.SmsUserUtil.class;
        monitor-enter(r1);
        r0 = f13268e;	 Catch:{ all -> 0x003a }
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
        r0 = m14140b(r0);	 Catch:{ all -> 0x0035 }
        f13268e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13268e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sms.sharedutils.SmsUserUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sms.sharedutils.SmsUserUtil");
    }

    private static SmsUserUtil m14140b(InjectorLike injectorLike) {
        return new SmsUserUtil(ContentResolverMethodAutoProvider.b(injectorLike), FbPhoneNumberUtils.m14146b(injectorLike));
    }

    @Inject
    public SmsUserUtil(ContentResolver contentResolver, FbPhoneNumberUtils fbPhoneNumberUtils) {
        this.f13269c = contentResolver;
        this.f13270d = fbPhoneNumberUtils;
    }

    public final User m14145a(String str) {
        if (StringUtil.a(str)) {
            throw new IllegalArgumentException("Invalid message address");
        } else if (FbPhoneNumberUtils.m14147c(str)) {
            r0 = m14142c(str);
            if (r0 == null) {
                return m14143d(str);
            }
            return r0;
        } else {
            if (Telephony$Mms.m12758b(str)) {
                r0 = m14141b(str);
                if (r0 != null) {
                    return r0;
                }
            }
            List arrayList = new ArrayList();
            arrayList.add(new UserEmailAddress(str, 4));
            UserBuilder a = new UserBuilder().a(Type.EMAIL, str);
            a.h = str;
            a = a;
            a.c = arrayList;
            return a.aa();
        }
    }

    @Nullable
    private User m14141b(String str) {
        Cursor query;
        User a;
        Throwable e;
        try {
            query = this.f13269c.query(Uri.withAppendedPath(Email.CONTENT_LOOKUP_URI, Uri.encode(str)), f13267b, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a = m14138a(query);
                    } else {
                        a = null;
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    try {
                        BLog.c("SmsUserUtil", e, "Failed to get user by email address %s", new Object[]{str});
                        if (query == null) {
                            a = null;
                        } else {
                            query.close();
                            a = null;
                        }
                        return a;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
                return a;
            } else if (query == null) {
                return null;
            } else {
                query.close();
                return null;
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            query = null;
            BLog.c("SmsUserUtil", e, "Failed to get user by email address %s", new Object[]{str});
            if (query == null) {
                query.close();
                a = null;
            } else {
                a = null;
            }
            return a;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    @Nullable
    private User m14142c(String str) {
        User a;
        Throwable e;
        Object normalize = PhoneNumberUtil.normalize(str);
        if (!StringUtil.a(normalize)) {
            Cursor query;
            try {
                query = this.f13269c.query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(normalize)), f13266a, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            a = m14139a(query, str);
                        } else {
                            a = null;
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        try {
                            BLog.c("SmsUserUtil", e, "Failed to get user by phone number %s", new Object[]{str});
                            if (query != null) {
                                query.close();
                                a = null;
                                return a;
                            }
                            a = null;
                            return a;
                        } catch (Throwable th) {
                            e = th;
                            if (query != null) {
                                query.close();
                            }
                            throw e;
                        }
                    }
                    return a;
                } else if (query == null) {
                    return null;
                } else {
                    query.close();
                    return null;
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
                query = null;
                BLog.c("SmsUserUtil", e, "Failed to get user by phone number %s", new Object[]{str});
                if (query != null) {
                    query.close();
                    a = null;
                    return a;
                }
                a = null;
                return a;
            } catch (Throwable th2) {
                e = th2;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw e;
            }
        }
        a = null;
        return a;
    }

    private static User m14138a(Cursor cursor) {
        List arrayList = new ArrayList();
        arrayList.add(new UserEmailAddress(CursorHelper.c(cursor, "data1"), CursorHelper.a(cursor, "data2")));
        UserBuilder a = new UserBuilder().a(Type.ADDRESS_BOOK, Long.toString(CursorHelper.b(cursor, "contact_id")));
        a.c = arrayList;
        UserBuilder userBuilder = a;
        userBuilder.h = CursorHelper.c(cursor, "display_name");
        userBuilder = userBuilder;
        userBuilder.n = CursorHelper.c(cursor, "contact_id");
        return userBuilder.aa();
    }

    private User m14139a(Cursor cursor, String str) {
        List arrayList = new ArrayList();
        String c = CursorHelper.c(cursor, "normalized_number");
        if (Strings.isNullOrEmpty(c)) {
            c = m14144f(str);
        }
        arrayList.add(new UserPhoneNumber(this.f13270d.m14151b(str), str, c, CursorHelper.a(cursor, "type")));
        Long valueOf = Long.valueOf(CursorHelper.b(cursor, "_id"));
        UserBuilder a = new UserBuilder().a(valueOf == null ? "" : Long.toString(valueOf.longValue()), ((UserPhoneNumber) arrayList.get(0)).c);
        a.d = arrayList;
        a = a;
        a.h = CursorHelper.c(cursor, "display_name");
        a = a;
        a.n = CursorHelper.c(cursor, "photo_thumb_uri");
        return a.aa();
    }

    private User m14143d(String str) {
        List arrayList = new ArrayList();
        String b = this.f13270d.m14151b(str);
        arrayList.add(new UserPhoneNumber(b, str, 2));
        UserBuilder a = new UserBuilder().a(null, m14144f(str));
        a.h = b;
        UserBuilder userBuilder = a;
        userBuilder.d = arrayList;
        return userBuilder.aa();
    }

    private String m14144f(String str) {
        return this.f13270d.m14152d(str);
    }
}
