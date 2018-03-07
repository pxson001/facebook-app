package com.facebook.vault.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.ipc.vault.VaultContract.ImagesTable.Columns;

/* compiled from: threadCriteria */
public final class VaultImageProviderRow implements Parcelable {
    public static final Creator<VaultImageProviderRow> CREATOR = new C01791();
    public String f1874a;
    public long f1875b;
    public long f1876c;
    public long f1877d;
    public int f1878e;
    public int f1879f;
    public int f1880g;
    public int f1881h;
    public long f1882i;

    /* compiled from: threadCriteria */
    final class C01791 implements Creator<VaultImageProviderRow> {
        C01791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VaultImageProviderRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new VaultImageProviderRow[i];
        }
    }

    public VaultImageProviderRow(String str, long j, long j2, long j3, int i, int i2, int i3, int i4, long j4) {
        this.f1874a = str;
        this.f1875b = j;
        this.f1876c = Math.max(0, j2);
        this.f1877d = j3;
        this.f1878e = i;
        this.f1879f = i2;
        this.f1880g = i3;
        this.f1881h = i4;
        this.f1882i = j4;
    }

    public VaultImageProviderRow(Cursor cursor) {
        this.f1874a = cursor.getString(Columns.a.a(cursor));
        this.f1875b = cursor.getLong(Columns.b.a(cursor));
        this.f1876c = Math.max(0, cursor.getLong(Columns.c.a(cursor)));
        this.f1877d = cursor.getLong(Columns.d.a(cursor));
        this.f1878e = cursor.getInt(Columns.e.a(cursor));
        this.f1879f = cursor.getInt(Columns.f.a(cursor));
        this.f1880g = cursor.getInt(Columns.g.a(cursor));
        this.f1881h = cursor.getInt(Columns.h.a(cursor));
        this.f1882i = cursor.getLong(Columns.i.a(cursor));
    }

    public VaultImageProviderRow(Parcel parcel) {
        this.f1874a = parcel.readString();
        this.f1875b = parcel.readLong();
        this.f1876c = parcel.readLong();
        this.f1877d = parcel.readLong();
        this.f1878e = parcel.readInt();
        this.f1879f = parcel.readInt();
        this.f1880g = parcel.readInt();
        this.f1881h = parcel.readInt();
        this.f1882i = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1874a);
        parcel.writeLong(this.f1875b);
        parcel.writeLong(this.f1876c);
        parcel.writeLong(this.f1877d);
        parcel.writeInt(this.f1878e);
        parcel.writeInt(this.f1879f);
        parcel.writeInt(this.f1880g);
        parcel.writeInt(this.f1881h);
        parcel.writeLong(this.f1882i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean m1957a() {
        Object obj = 1;
        if (!(this.f1879f == 1 || this.f1879f == 0)) {
            obj = null;
        }
        return obj == null && this.f1878e > 0;
    }

    public final String toString() {
        return StringFormatUtil.a("image_hash: %s, fbid: %d, upload_date: %d, date_taken: %d, failure#: %d, upload_state: %d, queued: %d, last_attempt: %d", new Object[]{this.f1874a, Long.valueOf(this.f1875b), Long.valueOf(this.f1877d), Long.valueOf(this.f1876c), Integer.valueOf(this.f1878e), Integer.valueOf(this.f1879f), Integer.valueOf(this.f1881h), Long.valueOf(this.f1882i)});
    }

    public final ContentValues m1958b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.a.d, this.f1874a);
        contentValues.put(Columns.b.d, Long.valueOf(this.f1875b));
        contentValues.put(Columns.c.d, Long.valueOf(this.f1876c));
        contentValues.put(Columns.d.d, Long.valueOf(this.f1877d));
        contentValues.put(Columns.e.d, Integer.valueOf(this.f1878e));
        contentValues.put(Columns.f.d, Integer.valueOf(this.f1879f));
        contentValues.put(Columns.g.d, Integer.valueOf(this.f1880g));
        contentValues.put(Columns.h.d, Integer.valueOf(this.f1881h));
        contentValues.put(Columns.i.d, Long.valueOf(this.f1882i));
        return contentValues;
    }
}
