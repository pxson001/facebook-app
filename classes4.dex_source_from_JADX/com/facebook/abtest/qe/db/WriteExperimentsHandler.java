package com.facebook.abtest.qe.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: thumbnail_image */
public class WriteExperimentsHandler {
    private static final String f1075a = (QuickExperimentContract$ExperimentsTable$Columns.f1081b.d + "=?");
    public static final String f1076b = (QuickExperimentContract$ExperimentsTable$Columns.f1081b.d + "=? and " + QuickExperimentContract$ExperimentsTable$Columns.f1088i.d + "=?");
    public final QuickExperimentDbSupplier f1077c;
    private final CustomContentSerialization f1078d;
    private final Provider<String> f1079e;

    public static WriteExperimentsHandler m1371b(InjectorLike injectorLike) {
        return new WriteExperimentsHandler(QuickExperimentDbSupplier.m1374a(injectorLike), CustomContentSerialization.m1380b(injectorLike), IdBasedProvider.a(injectorLike, 4437));
    }

    @Inject
    public WriteExperimentsHandler(QuickExperimentDbSupplier quickExperimentDbSupplier, CustomContentSerialization customContentSerialization, Provider<String> provider) {
        this.f1077c = (QuickExperimentDbSupplier) Preconditions.checkNotNull(quickExperimentDbSupplier);
        this.f1078d = customContentSerialization;
        this.f1079e = provider;
    }

    public static WriteExperimentsHandler m1369a(InjectorLike injectorLike) {
        return m1371b(injectorLike);
    }

    public final void m1372a(QuickExperimentInfo quickExperimentInfo, DataSource dataSource) {
        Preconditions.checkNotNull(quickExperimentInfo);
        SQLiteDatabase a = this.f1077c.a();
        SQLiteDetour.a(a, 2036793345);
        try {
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 1315237833);
        }
    }

    public final void m1373a(Collection<QuickExperimentInfo> collection, Iterable<Entry<String, String>> iterable, DataSource dataSource) {
        if (collection != null) {
            SQLiteDatabase a = this.f1077c.a();
            SQLiteDetour.a(a, -1978980063);
            try {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                for (Entry entry : iterable) {
                    m1370a(a, (String) entry.getKey(), (String) entry.getValue());
                }
                a.setTransactionSuccessful();
            } finally {
                SQLiteDetour.b(a, -572515378);
            }
        }
    }

    private static void m1370a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(QuickExperimentContract$ExperimentsMetaInfoTable$Columns.f1097a.d, str);
        contentValues.put(QuickExperimentContract$ExperimentsMetaInfoTable$Columns.f1098b.d, str2);
        SQLiteDetour.a(-1529082953);
        sQLiteDatabase.replace("metainfo", null, contentValues);
        SQLiteDetour.a(-144118965);
    }
}
