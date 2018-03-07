package com.facebook.contacts.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.SqlUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.data.FbContactsContract.SearchQuery;
import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.facebook.contacts.index.PhoneNumberNormalizer;
import com.facebook.database.provider.AbstractContentProviderTable;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: getBucketCount */
class FbContactsContentProvider$SearchTable extends AbstractContentProviderTable {
    final /* synthetic */ FbContactsContentProvider f11242a;

    public FbContactsContentProvider$SearchTable(FbContactsContentProvider fbContactsContentProvider) {
        this.f11242a = fbContactsContentProvider;
    }

    public final Cursor m11664a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, @Nullable String str3) {
        String a = m11663a(this.f11242a.h.f11200f.m11629a(uri));
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        String a2 = FbContactsContentProvider.a(this.f11242a, str2);
        String a3 = FbContactsContentProvider.a(this.f11242a, str, a2);
        sQLiteQueryBuilder.setTables(this.f11242a.a("(" + a + ")", strArr, a3, a2));
        sQLiteQueryBuilder.setProjectionMap(FbContactsContentProvider.b);
        TracerDetour.a("FbContactsContentProvider.doSearchQuery", -1871373891);
        try {
            Cursor query = sQLiteQueryBuilder.query(this.f11242a.f.a(), strArr, a3, strArr2, null, null, str2, str3);
            return query;
        } finally {
            long b = TracerDetour.b(-1341801850);
            FbContactsContentProvider.g();
            Long.valueOf(b);
        }
    }

    private String m11663a(SearchQuery searchQuery) {
        if (StringUtil.c(searchQuery.a)) {
            return "contacts";
        }
        String str;
        Iterable a = Lists.a();
        if (searchQuery.b.contains(SearchType.NAME)) {
            ImmutableList<String> a2 = this.f11242a.i.m11658a(searchQuery.a);
            List a3 = Lists.a();
            if (a2.size() > 1) {
                for (String str2 : a2) {
                    CharSequence a4 = this.f11242a.g.m11655a(str2);
                    if (!StringUtil.a(a4)) {
                        a3.add(a4);
                    }
                }
            }
            if (a3.size() <= 1 || a3.size() > 4) {
                Object a5 = this.f11242a.g.m11655a(searchQuery.a);
                if (!StringUtil.a(a5)) {
                    a.add("SELECT contact_internal_id FROM contacts_indexed_data WHERE type = 'name' AND indexed_data GLOB '" + a5 + "*' ");
                }
            } else {
                int i;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SELECT t0.contact_internal_id FROM ");
                for (i = 0; i < a3.size(); i++) {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(StringFormatUtil.a("contacts_indexed_data t%d", new Object[]{Integer.valueOf(i)}));
                }
                stringBuilder.append(" WHERE ");
                for (i = 0; i < a3.size(); i++) {
                    if (i > 0) {
                        stringBuilder.append(" AND ");
                    }
                    stringBuilder.append(StringFormatUtil.a("(t%d.type = 'name' AND ", new Object[]{Integer.valueOf(i)}));
                    stringBuilder.append(StringFormatUtil.a("t%d.indexed_data GLOB '%s*')", new Object[]{Integer.valueOf(i), a3.get(i)}));
                }
                for (i = 1; i < a3.size(); i++) {
                    stringBuilder.append(" AND (t0.contact_internal_id = ");
                    stringBuilder.append(StringFormatUtil.a("t%d.contact_internal_id)", new Object[]{Integer.valueOf(i)}));
                }
                a.add(stringBuilder.toString());
            }
        }
        Iterable a6 = Lists.a();
        Iterator it = searchQuery.b.iterator();
        while (it.hasNext()) {
            str2 = (String) FbContactsContentProvider.e.get((SearchType) it.next());
            if (str2 != null) {
                a6.add(str2);
            }
        }
        if (!a6.isEmpty()) {
            str2 = PhoneNumberNormalizer.a(searchQuery.a);
            if (str2.length() > 0) {
                a.add("SELECT contact_internal_id FROM contacts_indexed_data WHERE type IN " + SqlUtil.m14313a(a6) + " AND indexed_data GLOB '" + str2 + "*' ");
            }
        }
        return "SELECT * FROM contacts" + " WHERE internal_id IN ( " + Joiner.on(" UNION ALL ").join(a) + ")";
    }
}
