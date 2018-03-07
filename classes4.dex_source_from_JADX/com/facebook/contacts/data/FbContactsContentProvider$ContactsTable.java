package com.facebook.contacts.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import javax.annotation.Nullable;

/* compiled from: getBucketCount */
class FbContactsContentProvider$ContactsTable extends AbstractContentProviderTable {
    final /* synthetic */ FbContactsContentProvider f11239a;

    public FbContactsContentProvider$ContactsTable(FbContactsContentProvider fbContactsContentProvider) {
        this.f11239a = fbContactsContentProvider;
    }

    public final Cursor m11660a(Uri uri, String[] strArr, String str, String[] strArr2, @Nullable String str2, @Nullable String str3) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        String a = FbContactsContentProvider.a(this.f11239a, str2);
        String a2 = FbContactsContentProvider.a(this.f11239a, str, a);
        sQLiteQueryBuilder.setTables(this.f11239a.a("contacts", strArr, a2, a));
        sQLiteQueryBuilder.setProjectionMap(FbContactsContentProvider.b);
        return sQLiteQueryBuilder.query(this.f11239a.f.a(), strArr, a2, strArr2, null, null, str2, str3);
    }
}
