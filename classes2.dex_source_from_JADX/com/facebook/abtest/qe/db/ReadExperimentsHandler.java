package com.facebook.abtest.qe.db;

import android.content.ContentResolver;
import android.database.Cursor;
import com.facebook.abtest.qe.data.SerializedQuickExperimentInfo;
import com.facebook.abtest.qe.db.QuickExperimentContract.ExperimentsMetaInfoTable.Columns;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: update_failed_message */
public class ReadExperimentsHandler {
    private static Class<ReadExperimentsHandler> f1805a = ReadExperimentsHandler.class;
    private final DefaultAndroidThreadUtil f1806b;
    private final ContentResolver f1807c;
    private final QuickExperimentContract f1808d;
    private final Provider<String> f1809e;

    public static ReadExperimentsHandler m3635b(InjectorLike injectorLike) {
        return new ReadExperimentsHandler(DefaultAndroidThreadUtil.m1646b(injectorLike), ContentResolverMethodAutoProvider.m3641b(injectorLike), QuickExperimentContract.m3642a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4437));
    }

    @Inject
    ReadExperimentsHandler(AndroidThreadUtil androidThreadUtil, ContentResolver contentResolver, QuickExperimentContract quickExperimentContract, Provider<String> provider) {
        this.f1806b = androidThreadUtil;
        this.f1807c = contentResolver;
        this.f1808d = quickExperimentContract;
        this.f1809e = provider;
    }

    public static ReadExperimentsHandler m3634a(InjectorLike injectorLike) {
        return m3635b(injectorLike);
    }

    public final Map<String, String> m3637a() {
        Cursor query = this.f1807c.query(this.f1808d.f1814d.f1816a, null, null, null, null);
        Builder builder = ImmutableMap.builder();
        try {
            int a = Columns.a.m2089a(query);
            int a2 = Columns.b.m2089a(query);
            while (query.moveToNext()) {
                String string = query.getString(a);
                String string2 = query.getString(a2);
                if (!(string == null || string2 == null)) {
                    builder.m609b(string, string2);
                }
            }
            return builder.m610b();
        } finally {
            query.close();
        }
    }

    @Nullable
    public final String m3636a(String str) {
        String str2 = null;
        Cursor query = this.f1807c.query(this.f1808d.f1814d.f1816a, new String[]{Columns.b.m2091a()}, Columns.a + " = ?", new String[]{str}, null);
        try {
            if (query.moveToNext()) {
                str2 = query.getString(Columns.b.m2089a(query));
            } else {
                query.close();
            }
            return str2;
        } finally {
            query.close();
        }
    }

    public final Set<SerializedQuickExperimentInfo> m3638b() {
        this.f1806b.m1655b();
        return new HashSet();
    }

    public final Set<SerializedQuickExperimentInfo> m3639c() {
        this.f1806b.m1655b();
        return new HashSet();
    }
}
