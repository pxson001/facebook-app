package com.facebook.abtest.qe.db;

import android.database.Cursor;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import javax.inject.Inject;

/* compiled from: total_label */
public class ExperimentsMetaInfoProviderTable extends AbstractContentProviderTable {
    private final QuickExperimentDbSupplier f1726a;

    @Inject
    public ExperimentsMetaInfoProviderTable(QuickExperimentDbSupplier quickExperimentDbSupplier) {
        this.f1726a = quickExperimentDbSupplier;
    }

    public final Cursor m2372a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return this.f1726a.a().query("metainfo", strArr, str, strArr2, null, null, str2, str3);
    }
}
