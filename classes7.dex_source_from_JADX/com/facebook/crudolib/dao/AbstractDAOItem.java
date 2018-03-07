package com.facebook.crudolib.dao;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.facebook.crudolib.dao.DAOItem.Creator;

/* compiled from: character */
public abstract class AbstractDAOItem implements DAOItem {
    protected final Cursor f17842a;
    private final int f17843b;

    protected AbstractDAOItem(Cursor cursor) {
        if (cursor == null) {
            throw new IllegalArgumentException("cursor is null");
        }
        this.f17842a = cursor;
        this.f17843b = cursor.getColumnIndexOrThrow("_id");
    }

    public final Cursor mo1375a() {
        return this.f17842a;
    }

    public final boolean mo1377a(int i) {
        return this.f17842a.moveToPosition(i);
    }

    public final int mo1378b() {
        return this.f17842a.getPosition();
    }

    public final void mo1379c() {
        this.f17842a.close();
    }

    @TargetApi(11)
    public final <T extends DAOItem> T mo1376a(Creator<T> creator) {
        Cursor matrixCursor = new MatrixCursor(this.f17842a.getColumnNames());
        int columnCount = this.f17842a.getColumnCount();
        Object[] objArr = new Object[columnCount];
        for (int i = 0; i < columnCount; i++) {
            switch (this.f17842a.getType(i)) {
                case 0:
                    objArr[i] = null;
                    break;
                case 1:
                    objArr[i] = Integer.valueOf(this.f17842a.getInt(i));
                    break;
                case 2:
                    objArr[i] = Float.valueOf(this.f17842a.getFloat(i));
                    break;
                case 4:
                    objArr[i] = this.f17842a.getBlob(i);
                    break;
                default:
                    objArr[i] = this.f17842a.getString(i);
                    break;
            }
        }
        matrixCursor.addRow(objArr);
        return creator.a(matrixCursor);
    }

    public long m21683d() {
        return this.f17842a.getLong(this.f17843b);
    }
}
