package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.database.provider.TableMatcher;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: zero_rating2/clearable/network_type */
public class MessagesDbContentProvider extends UserScopedMessagesDbContentProvider {
    @Inject
    Provider<MessagesDbContract> f390a;
    @Inject
    Provider<ThreadsDatabaseSupplier> f391b;
    @Inject
    Provider<ThreadsProviderTable> f392c;
    @Inject
    Provider<MessagesProviderTable> f393d;
    private TableMatcher f394f;

    private static <T extends InjectableComponentWithContext> void m753a(Class<T> cls, T t) {
        m754a((Object) t, t.getContext());
    }

    private static void m754a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MessagesDbContentProvider) obj).m755a(IdBasedProvider.m1811a(injectorLike, 7810), IdBasedProvider.m1811a(injectorLike, 7815), IdBasedProvider.m1811a(injectorLike, 7819), IdBasedProvider.m1811a(injectorLike, 7811));
    }

    protected final synchronized void mo10a() {
        super.mo10a();
        TracerDetour.a("MessagesDbContentProvider.onInitialize", 1455216131);
        try {
            m753a(MessagesDbContentProvider.class, (InjectableComponentWithContext) this);
            MessagesDbContract messagesDbContract = (MessagesDbContract) this.f390a.get();
            this.f394f = new TableMatcher();
            this.f394f.m805a(messagesDbContract.a, "thread_summaries", new ContentProviderTableResolver(this.f392c));
            TableMatcher tableMatcher = this.f394f;
            int i = messagesDbContract.a;
            tableMatcher.m805a(i, "messages", new ContentProviderTableResolver(this.f393d));
            TracerDetour.a(i);
        } finally {
            TracerDetour.a(-1511327477);
        }
    }

    protected final Cursor mo56b(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2) {
        TracerDetour.a("MessagesDbContentProvider.doQuery", 1579192259);
        try {
            Cursor a = this.f394f.m804a(uri).m784a(uri, strArr, str, strArr2, str2);
            return a;
        } finally {
            Long.valueOf(TracerDetour.b(1335340492));
        }
    }

    protected final int mo55b(Uri uri, String str, String[] strArr) {
        if (((MessagesDbContract) this.f390a.get()).e.a.equals(uri)) {
            ((ThreadsDatabaseSupplier) this.f391b.get()).mo2481e();
            return 0;
        }
        throw new UnsupportedOperationException();
    }

    protected final int mo58d() {
        throw new UnsupportedOperationException();
    }

    protected final Uri mo57b(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    protected final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    private void m755a(Provider<MessagesDbContract> provider, Provider<ThreadsDatabaseSupplier> provider2, Provider<ThreadsProviderTable> provider3, Provider<MessagesProviderTable> provider4) {
        this.f390a = provider;
        this.f391b = provider2;
        this.f392c = provider3;
        this.f393d = provider4;
    }
}
