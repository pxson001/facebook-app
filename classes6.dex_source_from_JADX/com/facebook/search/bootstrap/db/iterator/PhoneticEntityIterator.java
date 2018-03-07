package com.facebook.search.bootstrap.db.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.search.bootstrap.db.data.BootstrapDbSchemaPart.EntitiesTable.Columns;
import com.facebook.search.bootstrap.db.model.EntityDbModel;
import com.facebook.search.bootstrap.db.model.EntityDbModel.Builder;

/* compiled from: expireTime */
public class PhoneticEntityIterator extends CursorIterator<EntityDbModel> {
    protected final Object m23422a(Cursor cursor) {
        boolean z;
        boolean z2 = false;
        Builder j = EntityDbModel.m23425j();
        j.f15712b = cursor.getString(cursor.getColumnIndex(Columns.f15680b.d));
        j = j;
        j.f15713c = cursor.getString(cursor.getColumnIndex(Columns.f15681c.d));
        j = j;
        j.f15714d = cursor.getString(cursor.getColumnIndex(Columns.f15682d.d));
        j = j;
        j.f15715e = cursor.getString(cursor.getColumnIndex(Columns.f15683e.d));
        j = j;
        j.f15716f = cursor.getString(cursor.getColumnIndex(Columns.f15684f.d));
        j = j;
        j.f15717g = cursor.getString(cursor.getColumnIndex(Columns.f15685g.d));
        Builder builder = j;
        if (cursor.getLong(cursor.getColumnIndex(Columns.f15686h.d)) == 1) {
            z = true;
        } else {
            z = false;
        }
        builder.f15718h = z;
        j = builder;
        j.f15719i = cursor.getString(cursor.getColumnIndex(Columns.f15687i.d));
        j = j;
        if (cursor.getLong(cursor.getColumnIndex(Columns.f15688j.d)) == 1) {
            z2 = true;
        }
        j.f15711a = z2;
        j = j;
        j.f15720j = true;
        return j.m23424k();
    }

    public PhoneticEntityIterator(Cursor cursor) {
        super(cursor);
    }
}
