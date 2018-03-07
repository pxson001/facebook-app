package com.facebook.contacts.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import javax.annotation.Nullable;

/* compiled from: getBucketCount */
class FbContactsContentProvider$SmsFavoritesTable extends AbstractContentProviderTable {
    final /* synthetic */ FbContactsContentProvider f11241a;

    public FbContactsContentProvider$SmsFavoritesTable(FbContactsContentProvider fbContactsContentProvider) {
        this.f11241a = fbContactsContentProvider;
    }

    public final Cursor m11662a(Uri uri, String[] strArr, @Nullable String str, String[] strArr2, String str2, @Nullable String str3) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("favorite_sms_contacts");
        sQLiteQueryBuilder.setProjectionMap(FbContactsContentProvider.d);
        return sQLiteQueryBuilder.query(this.f11241a.f.a(), strArr, str, strArr2, null, null, str2, str3);
    }
}
