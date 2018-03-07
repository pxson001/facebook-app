package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.content.SecureContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.messaging.providers.ViewerContextHelperForContentProviders;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: zero_rating2/clearable/last_time_checked */
public abstract class UserScopedMessagesDbContentProvider extends SecureContentProvider {
    @Inject
    public Provider<ViewerContextHelperForContentProviders> f395e;

    private static <T extends InjectableComponentWithContext> void m762a(Class<T> cls, T t) {
        m763a((Object) t, t.getContext());
    }

    private static void m763a(Object obj, Context context) {
        ((UserScopedMessagesDbContentProvider) obj).f395e = IdBasedProvider.m1811a(FbInjector.get(context), 8307);
    }

    protected abstract int mo55b(Uri uri, String str, String[] strArr);

    protected abstract Cursor mo56b(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    protected abstract Uri mo57b(Uri uri, ContentValues contentValues);

    protected abstract int mo58d();

    UserScopedMessagesDbContentProvider() {
    }

    protected synchronized void mo10a() {
        TracerDetour.a("UserScopedMessagesDbContentProvider.onInitialize", -1805102074);
        try {
            Class cls = UserScopedMessagesDbContentProvider.class;
            m762a(cls, (InjectableComponentWithContext) this);
            TracerDetour.a(cls);
        } finally {
            TracerDetour.a(644651182);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int mo5a(android.net.Uri r4, java.lang.String r5, java.lang.String[] r6) {
        /*
        r3 = this;
        r0 = r3.f395e;
        r0 = r0.get();
        r0 = (com.facebook.messaging.providers.ViewerContextHelperForContentProviders) r0;
        r2 = r0.a(r4);
        r1 = 0;
        r0 = r3.mo55b(r4, r5, r6);	 Catch:{ Throwable -> 0x0017 }
        if (r2 == 0) goto L_0x0016;
    L_0x0013:
        r2.close();
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0021;
    L_0x001c:
        if (r1 == 0) goto L_0x0027;
    L_0x001e:
        r2.close();	 Catch:{ Throwable -> 0x0022 }
    L_0x0021:
        throw r0;
    L_0x0022:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x0021;
    L_0x0027:
        r2.close();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.UserScopedMessagesDbContentProvider.a(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final android.net.Uri mo7a(android.net.Uri r4, android.content.ContentValues r5) {
        /*
        r3 = this;
        r0 = r3.f395e;
        r0 = r0.get();
        r0 = (com.facebook.messaging.providers.ViewerContextHelperForContentProviders) r0;
        r2 = r0.a(r4);
        r1 = 0;
        r0 = r3.mo57b(r4, r5);	 Catch:{ Throwable -> 0x0017 }
        if (r2 == 0) goto L_0x0016;
    L_0x0013:
        r2.close();
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0021;
    L_0x001c:
        if (r1 == 0) goto L_0x0027;
    L_0x001e:
        r2.close();	 Catch:{ Throwable -> 0x0022 }
    L_0x0021:
        throw r0;
    L_0x0022:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x0021;
    L_0x0027:
        r2.close();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.UserScopedMessagesDbContentProvider.a(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final android.database.Cursor mo6a(android.net.Uri r4, java.lang.String[] r5, java.lang.String r6, java.lang.String[] r7, java.lang.String r8) {
        /*
        r3 = this;
        r0 = r3.f395e;
        r0 = r0.get();
        r0 = (com.facebook.messaging.providers.ViewerContextHelperForContentProviders) r0;
        r2 = r0.a(r4);
        r1 = 0;
        r0 = r3.mo56b(r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x0017 }
        if (r2 == 0) goto L_0x0016;
    L_0x0013:
        r2.close();
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0021;
    L_0x001c:
        if (r1 == 0) goto L_0x0027;
    L_0x001e:
        r2.close();	 Catch:{ Throwable -> 0x0022 }
    L_0x0021:
        throw r0;
    L_0x0022:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x0021;
    L_0x0027:
        r2.close();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.UserScopedMessagesDbContentProvider.a(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int mo4a(android.net.Uri r4, android.content.ContentValues r5, java.lang.String r6, java.lang.String[] r7) {
        /*
        r3 = this;
        r0 = r3.f395e;
        r0 = r0.get();
        r0 = (com.facebook.messaging.providers.ViewerContextHelperForContentProviders) r0;
        r2 = r0.a(r4);
        r1 = 0;
        r0 = r3.mo58d();	 Catch:{ Throwable -> 0x0017 }
        if (r2 == 0) goto L_0x0016;
    L_0x0013:
        r2.close();
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0021;
    L_0x001c:
        if (r1 == 0) goto L_0x0027;
    L_0x001e:
        r2.close();	 Catch:{ Throwable -> 0x0022 }
    L_0x0021:
        throw r0;
    L_0x0022:
        r2 = move-exception;
        com.facebook.androidcompat.AndroidCompat.addSuppressed(r1, r2);
        goto L_0x0021;
    L_0x0027:
        r2.close();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.UserScopedMessagesDbContentProvider.a(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
