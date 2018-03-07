package com.facebook.search.bootstrap.db.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.KeywordsTable.Columns;
import com.facebook.search.bootstrap.db.model.KeywordDbModel;
import com.facebook.search.bootstrap.db.model.KeywordDbModel.Builder;

/* compiled from: expires_seconds_since_epoch */
public class KeywordIterator extends CursorIterator<KeywordDbModel> {
    public KeywordIterator(Cursor cursor) {
        super(cursor);
    }

    protected final Object m23421a(Cursor cursor) {
        Builder builder = new Builder();
        builder.f15726a = cursor.getString(cursor.getColumnIndex(Columns.f15695b.d));
        builder = builder;
        builder.f15730e = cursor.getString(cursor.getColumnIndex(Columns.f15696c.d));
        builder = builder;
        builder.f15727b = cursor.getString(cursor.getColumnIndex(Columns.f15697d.d));
        builder = builder;
        builder.f15728c = cursor.getString(cursor.getColumnIndex(Columns.f15698e.d));
        builder = builder;
        builder.f15729d = cursor.getString(cursor.getColumnIndex(Columns.f15699f.d));
        builder = builder;
        builder.f15731f = cursor.getString(cursor.getColumnIndex(Columns.f15700g.d));
        builder = builder;
        builder.f15732g = cursor.getString(cursor.getColumnIndex(Columns.f15701h.d));
        return new KeywordDbModel(builder);
    }
}
