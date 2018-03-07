package com.facebook.saved2.ui.mutator;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.crudolib.dbquery.loader.inprocess.NoContentResolver;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.InjectorLike;
import com.facebook.saved2.model.Saved2DatabaseProvider;
import com.facebook.saved2.model.Saved2ItemTable;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: non_optimal_niem */
public class Saved2DbMutator {
    public final Saved2DatabaseProvider f7859a;
    private final ExecutorService f7860b;
    private final Clock f7861c;

    public static Saved2DbMutator m8245b(InjectorLike injectorLike) {
        return new Saved2DbMutator(Saved2DatabaseProvider.m8062a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public Saved2DbMutator(Saved2DatabaseProvider saved2DatabaseProvider, ExecutorService executorService, Clock clock) {
        this.f7859a = saved2DatabaseProvider;
        this.f7860b = executorService;
        this.f7861c = clock;
    }

    public final void m8247a(long j) {
        m8244a(j, new String[]{"is_deleted_client"}, new Object[]{Integer.valueOf(1)});
    }

    public final void m8250b(long j) {
        m8246h(j);
    }

    public final void m8251c(long j) {
        m8244a(j, new String[]{"is_deleted_client"}, new Object[]{Integer.valueOf(0)});
    }

    public final void m8252d(long j) {
        m8244a(j, new String[]{"section_name", "saved_state"}, new Object[]{"ARCHIVED", GraphQLSavedState.ARCHIVED.toString()});
    }

    public final void m8253e(long j) {
        m8244a(j, new String[]{"is_unarchived_client", "saved_state"}, new Object[]{Integer.valueOf(0), GraphQLSavedState.ARCHIVED.toString()});
    }

    public final void m8254f(long j) {
        m8244a(j, new String[]{"is_unarchived_client", "saved_state"}, new Object[]{Integer.valueOf(1), GraphQLSavedState.SAVED.toString()});
    }

    public final void m8255g(long j) {
        m8246h(j);
    }

    public final void m8248a(long j, String str) {
        m8244a(j, new String[]{"section_name", "saved_state"}, new Object[]{str, GraphQLSavedState.SAVED.toString()});
    }

    private void m8244a(long j, String[] strArr, Object[] objArr) {
        final long j2 = j;
        final String[] strArr2 = strArr;
        final Object[] objArr2 = objArr;
        ExecutorDetour.a(this.f7860b, new Runnable(this) {
            final /* synthetic */ Saved2DbMutator f7853d;

            public void run() {
                SQLiteDatabase a = this.f7853d.f7859a.m8064a();
                SQLiteDetour.a(a, -1280952698);
                try {
                    String str = "_id=?";
                    String[] strArr = new String[]{String.valueOf(j2)};
                    ContentValues contentValues = new ContentValues();
                    for (int i = 0; i < strArr2.length; i++) {
                        contentValues.put(strArr2[i], String.valueOf(objArr2[i]));
                    }
                    a.updateWithOnConflict("item", contentValues, str, strArr, 5);
                    a.setTransactionSuccessful();
                    NoContentResolver.a().a(Saved2ItemTable.class);
                } finally {
                    SQLiteDetour.b(a, -200469793);
                }
            }
        }, 577768022);
    }

    private void m8246h(final long j) {
        ExecutorDetour.a(this.f7860b, new Runnable(this) {
            final /* synthetic */ Saved2DbMutator f7855b;

            public void run() {
                SQLiteDatabase a = this.f7855b.f7859a.m8064a();
                SQLiteDetour.a(a, -811029556);
                try {
                    String str = "item";
                    a.delete(str, "_id=?", new String[]{String.valueOf(j)});
                    a.setTransactionSuccessful();
                    NoContentResolver.a().a(Saved2ItemTable.class);
                } finally {
                    SQLiteDetour.b(a, 612929316);
                }
            }
        }, -643725980);
    }

    private static ContentValues m8243a(String str, String str2, long j, String str3, String str4, String str5, String str6, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("section_name", str);
        contentValues.put("node_id", str2);
        contentValues.put("time_saved_ms", Long.valueOf(j));
        contentValues.put("group_title", "TODAY");
        contentValues.put("target_id", str2);
        contentValues.put("picture_uri", str3);
        contentValues.put("title", str4);
        contentValues.put("subtitle", str5);
        contentValues.put("playable_url", str6);
        contentValues.put("is_playable", Integer.valueOf(1));
        contentValues.put("media_content_size", Long.valueOf(j2));
        contentValues.put("section_name_server", str);
        contentValues.put("saved_state", GraphQLSavedState.SAVED.toString());
        contentValues.put("is_download_client", Integer.valueOf(1));
        return contentValues;
    }

    public final void m8249a(String str, String str2, String str3, String str4, String str5, long j) {
        long a = this.f7861c.a();
        final ContentValues a2 = m8243a("VIDEOS", str, a, str2, str3, str4, str5, j);
        final ContentValues a3 = m8243a("ALL", str, a, str2, str3, str4, str5, j);
        ExecutorDetour.a(this.f7860b, new Runnable(this) {
            final /* synthetic */ Saved2DbMutator f7858c;

            public void run() {
                SQLiteDatabase a = this.f7858c.f7859a.m8064a();
                SQLiteDetour.a(a, -1720198634);
                try {
                    ContentValues contentValues = a3;
                    SQLiteDetour.a(-626344127);
                    a.insert("item", null, contentValues);
                    SQLiteDetour.a(1512624983);
                    contentValues = a2;
                    SQLiteDetour.a(-1512855849);
                    a.insert("item", null, contentValues);
                    SQLiteDetour.a(-406120890);
                    a.setTransactionSuccessful();
                    NoContentResolver.a().a(Saved2ItemTable.class);
                } finally {
                    SQLiteDetour.b(a, 1570435211);
                }
            }
        }, 1447117842);
    }
}
