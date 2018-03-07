package com.facebook.messaging.database.threads;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import javax.annotation.Nullable;

/* compiled from: max_budgets_count */
class ThreadsDbPropertiesContentProvider$PropertiesTable extends AbstractContentProviderTable {
    final /* synthetic */ ThreadsDbPropertiesContentProvider f10657a;

    public ThreadsDbPropertiesContentProvider$PropertiesTable(ThreadsDbPropertiesContentProvider threadsDbPropertiesContentProvider) {
        this.f10657a = threadsDbPropertiesContentProvider;
    }

    public final Cursor m11178a(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2, @Nullable String str3) {
        return ((ThreadsDatabaseSupplier) this.f10657a.a.get()).a().query("properties", strArr, str, strArr2, null, null, str2, str3);
    }

    @Nullable
    public final Uri m11179a(ContentValues contentValues) {
        SQLiteDetour.a(-1910915396);
        ((ThreadsDatabaseSupplier) this.f10657a.a.get()).a().replaceOrThrow("properties", null, contentValues);
        SQLiteDetour.a(-211028076);
        return null;
    }

    public final int m11177a(String str, String[] strArr) {
        return ((ThreadsDatabaseSupplier) this.f10657a.a.get()).a().delete("properties", str, strArr);
    }
}
