package com.facebook.abtest.qe.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.content.SecureContentProvider;
import com.facebook.database.provider.TableMatcher;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: zero_rating2/clearable/last_interstitial_displayed_time */
public class QuickExperimentContentProvider extends SecureContentProvider {
    private static Class<ExperimentsProviderTable> f396a = ExperimentsProviderTable.class;
    private QuickExperimentContract f397b;
    private ExperimentsProviderTable f398c;
    private ExperimentsMetaInfoProviderTable f399d;
    private TableMatcher f400e;

    private static <T extends InjectableComponentWithContext> void m774a(Class<T> cls, T t) {
        m775a((Object) t, t.getContext());
    }

    private static void m775a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((QuickExperimentContentProvider) obj).m773a(QuickExperimentContract.m3642a(injectorLike), new ExperimentsProviderTable(QuickExperimentDbSupplier.a(injectorLike)), new ExperimentsMetaInfoProviderTable(QuickExperimentDbSupplier.a(injectorLike)));
    }

    @Inject
    private void m773a(QuickExperimentContract quickExperimentContract, ExperimentsProviderTable experimentsProviderTable, ExperimentsMetaInfoProviderTable experimentsMetaInfoProviderTable) {
        this.f397b = quickExperimentContract;
        this.f398c = experimentsProviderTable;
        this.f399d = experimentsMetaInfoProviderTable;
    }

    protected final void mo10a() {
        super.mo10a();
        m774a(QuickExperimentContentProvider.class, (InjectableComponentWithContext) this);
        this.f400e = new TableMatcher();
        this.f400e.m805a(this.f397b.f1811a, "quick_experiment", this.f398c);
        this.f400e.m805a(this.f397b.f1811a, "metainfo", this.f399d);
    }

    public final Cursor mo6a(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2) {
        TracerDetour.a("QuickExperimentContentProvider.doQuery", 124693693);
        try {
            Cursor a = this.f400e.m804a(uri).m784a(uri, strArr, str, strArr2, str2);
            return a;
        } finally {
            Long.valueOf(TracerDetour.b(2057196078));
        }
    }

    protected final int mo5a(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    protected final Uri mo7a(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    protected final String mo8a(Uri uri) {
        throw new UnsupportedOperationException();
    }

    protected final int mo4a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
