package com.facebook.database.provider;

import android.content.UriMatcher;
import android.net.Uri;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: zero_rating2/clearable/default_optin/type_key */
public class TableMatcher {
    private final UriMatcher f411a = new UriMatcher(-1);
    private final Map<Integer, ContentProviderTable> f412b = Maps.m838c();
    private int f413c = 1;

    public final void m805a(String str, String str2, AbstractContentProviderTable abstractContentProviderTable) {
        int i = this.f413c;
        this.f413c = i + 1;
        this.f411a.addURI(str, str2, i);
        this.f412b.put(Integer.valueOf(i), abstractContentProviderTable);
    }

    public final AbstractContentProviderTable m804a(Uri uri) {
        int match = this.f411a.match(uri);
        if (match == -1) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        AbstractContentProviderTable abstractContentProviderTable = (AbstractContentProviderTable) this.f412b.get(Integer.valueOf(match));
        if (abstractContentProviderTable != null) {
            return abstractContentProviderTable;
        }
        throw new IllegalStateException("Table is null?");
    }
}
