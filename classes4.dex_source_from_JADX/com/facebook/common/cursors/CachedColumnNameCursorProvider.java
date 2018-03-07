package com.facebook.common.cursors;

import android.database.Cursor;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: isMemorialized */
public class CachedColumnNameCursorProvider extends AbstractAssistedProvider<CachedColumnNameCursor> {
    public static CachedColumnNameCursor m10624a(Cursor cursor) {
        return new CachedColumnNameCursor(cursor);
    }
}
