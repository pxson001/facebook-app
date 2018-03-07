package com.facebook.contacts.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import javax.annotation.Nullable;

/* compiled from: getBucketCount */
class FbContactsContentProvider$FavoritesTable extends AbstractContentProviderTable {
    final /* synthetic */ FbContactsContentProvider f11240a;

    public FbContactsContentProvider$FavoritesTable(FbContactsContentProvider fbContactsContentProvider) {
        this.f11240a = fbContactsContentProvider;
    }

    public final Cursor m11661a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, String str2, @Nullable String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(SELECT fbid, display_order FROM favorite_contacts)");
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(stringBuilder.toString());
        sQLiteQueryBuilder.setProjectionMap(FbContactsContentProvider.c);
        return sQLiteQueryBuilder.query(this.f11240a.f.a(), strArr, str, strArr2, null, null, str2, str3);
    }
}
