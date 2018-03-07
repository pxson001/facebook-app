package com.facebook.abtest.qe.service;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.abtest.qe.db.QuickExperimentContract.ExperimentsTable.Columns;
import com.facebook.abtest.qe.db.QuickExperimentDbSupplier;
import com.facebook.abtest.qe.log.RecentUIDsUtil;
import com.facebook.abtest.qe.multiprocess.QuickExperimentBroadcastManager;
import com.facebook.auth.privacy.IHaveUserData;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import java.util.List;
import javax.inject.Inject;

/* compiled from: topic_image */
public class QuickExperimentUserDataDbCleaner implements IHaveUserData {
    private final QuickExperimentDbSupplier f1774a;
    private final QuickExperimentBroadcastManager f1775b;
    private final RecentUIDsUtil f1776c;

    @Inject
    public QuickExperimentUserDataDbCleaner(QuickExperimentDbSupplier quickExperimentDbSupplier, QuickExperimentBroadcastManager quickExperimentBroadcastManager, RecentUIDsUtil recentUIDsUtil) {
        this.f1774a = quickExperimentDbSupplier;
        this.f1775b = quickExperimentBroadcastManager;
        this.f1776c = recentUIDsUtil;
    }

    @VisibleForTesting
    private static void m2456a(SQLiteDatabase sQLiteDatabase, List<String> list) {
        sQLiteDatabase.delete("experiments", m2455a(list), null);
    }

    @VisibleForTesting
    private static String m2455a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return Columns.a.d + " NOT IN ('" + Joiner.on("','").join(list.toArray()) + "')";
    }

    public void clearUserData() {
        m2456a(this.f1774a.a(), this.f1776c.a());
        this.f1775b.a.a(new Intent("com.facebook.abtest.action.CLEAR_CACHE"));
    }
}
