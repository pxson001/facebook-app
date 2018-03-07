package com.facebook.contacts.ccu;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.RawContactsEntity;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: isMessageBlockedByViewer */
public class ContactsIterators {
    public static final String[] f10161a = new String[]{"_id", "contact_id", "deleted", "mimetype", "data1", "data2", "data3"};
    private static final Object f10162e = new Object();
    private final CachedColumnNameCursorProvider f10163b;
    private final ContentResolver f10164c;
    private final RuntimePermissionsUtil f10165d;

    private static ContactsIterators m10622b(InjectorLike injectorLike) {
        return new ContactsIterators((CachedColumnNameCursorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class), ContentResolverMethodAutoProvider.b(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public ContactsIterators(CachedColumnNameCursorProvider cachedColumnNameCursorProvider, ContentResolver contentResolver, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f10163b = cachedColumnNameCursorProvider;
        this.f10164c = contentResolver;
        this.f10165d = runtimePermissionsUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.ccu.ContactsIterators m10621a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f10162e;	 Catch:{ all -> 0x006c }
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
        r1 = m10622b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10162e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.ccu.ContactsIterators) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.ccu.ContactsIterators) r0;	 Catch:{  }
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
        r0 = f10162e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.ccu.ContactsIterators) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.ccu.ContactsIterators.a(com.facebook.inject.InjectorLike):com.facebook.contacts.ccu.ContactsIterators");
    }

    @Nullable
    public final ContactsIterator m10623a() {
        if (!this.f10165d.a("android.permission.READ_CONTACTS")) {
            return null;
        }
        Cursor query;
        try {
            query = this.f10164c.query(RawContactsEntity.CONTENT_URI, f10161a, null, null, "contact_id");
        } catch (Exception e) {
            query = null;
        }
        return query == null ? null : new ContactsIterator(CachedColumnNameCursorProvider.m10624a(query));
    }
}
