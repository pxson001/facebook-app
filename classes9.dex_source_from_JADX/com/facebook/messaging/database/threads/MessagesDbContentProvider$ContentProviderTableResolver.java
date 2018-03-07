package com.facebook.messaging.database.threads;

import android.database.Cursor;
import android.net.Uri;
import com.facebook.database.provider.AbstractContentProviderTable;
import com.facebook.database.provider.ContentProviderTable;
import javax.inject.Provider;

/* compiled from: max_width */
class MessagesDbContentProvider$ContentProviderTableResolver<T extends ContentProviderTable> extends AbstractContentProviderTable {
    private final Provider<T> f10539a;

    public MessagesDbContentProvider$ContentProviderTableResolver(Provider<T> provider) {
        this.f10539a = provider;
    }

    public final Cursor m11140a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return ((AbstractContentProviderTable) this.f10539a.get()).a(uri, strArr, str, strArr2, str2);
    }
}
