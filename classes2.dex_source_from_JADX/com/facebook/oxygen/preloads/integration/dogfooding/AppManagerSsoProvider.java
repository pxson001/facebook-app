package com.facebook.oxygen.preloads.integration.dogfooding;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.facebook.auth.annotations.IsMeUserAnEmployee;
import com.facebook.auth.annotations.IsMeUserTrustedTester;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.util.TriState;
import com.facebook.content.PublicContentProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: zero_rating2/clearable/reg_status */
public class AppManagerSsoProvider extends PublicContentProvider {
    @Inject
    AppManagerSsoCallerVerifier f385a;
    @Inject
    Provider<ViewerContext> f386b;
    @Inject
    @IsMeUserAnEmployee
    Provider<TriState> f387c;
    @Inject
    @IsMeUserTrustedTester
    Provider<TriState> f388d;
    @Inject
    AbstractFbErrorReporter f389e;

    private static <T extends InjectableComponentWithContext> void m744a(Class<T> cls, T t) {
        m745a((Object) t, t.getContext());
    }

    private static void m745a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AppManagerSsoProvider) obj).m743a(AppManagerSsoCallerVerifier.b(injectorLike), IdBasedProvider.m1811a(injectorLike, 372), IdBasedProvider.m1811a(injectorLike, 640), IdBasedProvider.m1811a(injectorLike, 642), (AbstractFbErrorReporter) FbErrorReporterImpl.m2317a(injectorLike));
    }

    protected final void mo10a() {
        AppInitLockHelper.m8874a(getContext());
        m744a(AppManagerSsoProvider.class, (InjectableComponentWithContext) this);
    }

    protected final boolean mo9b() {
        AppManagerSsoCallerVerifier appManagerSsoCallerVerifier = this.f385a;
        appManagerSsoCallerVerifier.b.a();
        appManagerSsoCallerVerifier.a.a();
        return true;
    }

    protected final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ViewerContext viewerContext = (ViewerContext) this.f386b.get();
        if (viewerContext == null) {
            this.f389e.m2340a("AppManagerSsoProvider__USER_NOT_LOGGED_IN", "Not logged in.");
            return m742a("User not logged in.");
        } else if (this.f387c.get() == TriState.YES || this.f388d.get() == TriState.YES) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"uid", "access_token", "failure_reason"});
            matrixCursor.addRow(new Object[]{viewerContext.mUserId, viewerContext.mAuthToken, null});
            return matrixCursor;
        } else {
            this.f389e.m2340a("AppManagerSsoProvider__USER_NOT_LOGGED_IN", viewerContext.mUserId);
            return m742a("User is not an employee.");
        }
    }

    private static Cursor m742a(String str) {
        Cursor matrixCursor = new MatrixCursor(new String[]{"uid", "access_token", "failure_reason"});
        matrixCursor.addRow(new Object[]{null, null, str});
        return matrixCursor;
    }

    protected final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    private void m743a(AppManagerSsoCallerVerifier appManagerSsoCallerVerifier, Provider<ViewerContext> provider, Provider<TriState> provider2, Provider<TriState> provider3, FbErrorReporter fbErrorReporter) {
        this.f385a = appManagerSsoCallerVerifier;
        this.f386b = provider;
        this.f387c = provider2;
        this.f388d = provider3;
        this.f389e = fbErrorReporter;
    }
}
