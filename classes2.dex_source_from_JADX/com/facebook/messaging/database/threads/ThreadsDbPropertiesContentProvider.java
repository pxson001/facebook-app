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
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: zero_rating2/clearable/dialogs/ */
public class ThreadsDbPropertiesContentProvider extends UserScopedMessagesDbContentProvider {
    private static final Class<?> f407c = ThreadsDbPropertiesContentProvider.class;
    @Inject
    Provider<ThreadsDatabaseSupplier> f408a;
    @Inject
    Provider<ThreadsDbPropertiesContract> f409b;
    private TableMatcher f410d = new TableMatcher();

    private static <T extends InjectableComponentWithContext> void m795a(Class<T> cls, T t) {
        m796a((Object) t, t.getContext());
    }

    private static void m796a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ThreadsDbPropertiesContentProvider) obj).m797a(IdBasedProvider.m1811a(injectorLike, 7815), IdBasedProvider.m1811a(injectorLike, 7817));
    }

    protected final synchronized void mo10a() {
        super.mo10a();
        TracerDetour.a("ThreadsDbPropertiesContentProvider.onInitialize", 338286375);
        try {
            m795a(ThreadsDbPropertiesContentProvider.class, (InjectableComponentWithContext) this);
            ThreadsDbPropertiesContract threadsDbPropertiesContract = (ThreadsDbPropertiesContract) this.f409b.get();
            this.f410d = new TableMatcher();
            TableMatcher tableMatcher = this.f410d;
            int b = threadsDbPropertiesContract.b();
            tableMatcher.m805a(b, "properties", new PropertiesTable(this));
            TracerDetour.a(b);
        } finally {
            TracerDetour.a(1932651530);
        }
    }

    protected final Cursor mo56b(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        TracerDetour.a("ThreadsDbPropertiesContentProvider.doQuery", -1112940117);
        try {
            Cursor a = this.f410d.m804a(uri).m784a(uri, strArr, str, strArr2, str2);
            return a;
        } finally {
            Long.valueOf(TracerDetour.b(-1823818739));
        }
    }

    protected final int mo55b(Uri uri, String str, String[] strArr) {
        TracerDetour.a("ThreadsDbPropertiesContentProvider.doDelete", 858080048);
        try {
            int a = this.f410d.m804a(uri).m783a(str, strArr);
            return a;
        } finally {
            Long.valueOf(TracerDetour.b(-1879670151));
        }
    }

    protected final Uri mo57b(Uri uri, ContentValues contentValues) {
        TracerDetour.a("ThreadsDbPropertiesContentProvider.doInsert", 1420775506);
        try {
            Uri a = this.f410d.m804a(uri).m786a(contentValues);
            return a;
        } finally {
            Long.valueOf(TracerDetour.b(-1510342305));
        }
    }

    protected final int mo58d() {
        throw new UnsupportedOperationException();
    }

    protected final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    private void m797a(Provider<ThreadsDatabaseSupplier> provider, Provider<ThreadsDbPropertiesContract> provider2) {
        this.f408a = provider;
        this.f409b = provider2;
    }
}
