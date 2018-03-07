package com.facebook.platform.common.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.content.PublicContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.config.DefaultPlatformConfig;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Iterator;

/* compiled from: zero_url_rewrite */
public class PlatformProviderBase extends PublicContentProvider {
    private static final UriMatcher f285a = new UriMatcher(-1);
    public static String f286b;
    public DefaultPlatformConfig f287c;

    private static <T extends InjectableComponentWithContext> void m579a(Class<T> cls, T t) {
        m580a((Object) t, t.getContext());
    }

    private static void m580a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PlatformProviderBase platformProviderBase = (PlatformProviderBase) obj;
        String a = String_PackageNameMethodAutoProvider.m4353a(injectorLike);
        DefaultPlatformConfig a2 = DefaultPlatformConfig.a(injectorLike);
        f286b = a;
        platformProviderBase.f287c = a2;
    }

    protected final void mo10a() {
        super.mo10a();
        m579a(PlatformProviderBase.class, (InjectableComponentWithContext) this);
        f285a.addURI(f286b + ".provider.PlatformProvider", "versions", 1);
    }

    public final synchronized Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor matrixCursor;
        switch (f285a.match(uri)) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                matrixCursor = new MatrixCursor(new String[]{"version"});
                Iterator it = this.f287c.a().iterator();
                while (it.hasNext()) {
                    matrixCursor.addRow(new Integer[]{(Integer) it.next()});
                }
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        return matrixCursor;
    }

    public final int mo5a(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    public final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    public final Uri mo7a(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    public final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
