package com.facebook.bugreporter.activity.categorylist;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.TriState;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.media.metadata.COMPILATION */
public class CategoryInfo implements Parcelable {
    public static final Creator<CategoryInfo> CREATOR = new C10311();
    private final String f10693a;
    private final String f10694b;
    public final long f10695c;
    public final boolean f10696d;

    /* compiled from: android.media.metadata.COMPILATION */
    final class C10311 implements Creator<CategoryInfo> {
        C10311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CategoryInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new CategoryInfo[i];
        }
    }

    private CategoryInfo(String str, long j, boolean z) {
        this(str, str, j, z);
    }

    private CategoryInfo(String str, String str2, long j, boolean z) {
        this.f10693a = str;
        this.f10694b = str2;
        this.f10695c = j;
        this.f10696d = z;
    }

    public final String m18726a(TriState triState) {
        return TriState.YES.equals(triState) ? this.f10693a : this.f10694b;
    }

    public CategoryInfo(Parcel parcel) {
        this.f10693a = parcel.readString();
        this.f10694b = parcel.readString();
        this.f10695c = parcel.readLong();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f10696d = zArr[0];
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10693a);
        parcel.writeString(this.f10694b);
        parcel.writeLong(this.f10695c);
        parcel.writeBooleanArray(new boolean[]{this.f10696d});
    }

    public static CategoryInfo m18723a(String str, long j) {
        return new CategoryInfo(str, j, true);
    }

    public static CategoryInfo m18725b(String str, long j) {
        return new CategoryInfo(str, j, false);
    }

    public static CategoryInfo m18724a(String str, String str2, long j) {
        return new CategoryInfo(str, str2, j, true);
    }
}
