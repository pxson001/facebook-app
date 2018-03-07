package com.facebook.abtest.qe.db;

import android.database.Cursor;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: zero_rating2/clearable/fast_hash */
public class ExperimentsProviderTable extends AbstractContentProviderTable {
    private final QuickExperimentDbSupplier f401a;

    @Inject
    public ExperimentsProviderTable(QuickExperimentDbSupplier quickExperimentDbSupplier) {
        this.f401a = quickExperimentDbSupplier;
    }

    public final Cursor mo59a(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2, @Nullable String str3) {
        return this.f401a.mo2480a().query("experiments", strArr, str, strArr2, null, null, str2, str3);
    }
}
