package com.facebook.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TRENDING */
public class MainFilter implements Parcelable {
    public static final Creator<MainFilter> CREATOR = new C23681();
    private final String f22138a;
    private final String f22139b;
    private final String f22140c;
    private final String f22141d;
    private final ImmutableList<FilterValue> f22142e;
    private final CustomFilterValue f22143f;
    private FilterValue f22144g;

    /* compiled from: TRENDING */
    final class C23681 implements Creator<MainFilter> {
        C23681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MainFilter(parcel);
        }

        public final Object[] newArray(int i) {
            return new MainFilter[i];
        }
    }

    public MainFilter(Parcel parcel) {
        this.f22138a = parcel.readString();
        this.f22139b = parcel.readString();
        this.f22140c = parcel.readString();
        this.f22141d = parcel.readString();
        Collection a = Lists.a();
        parcel.readTypedList(a, FilterValue.CREATOR);
        this.f22142e = ImmutableList.copyOf(a);
        this.f22143f = (CustomFilterValue) parcel.readParcelable(CustomFilterValue.class.getClassLoader());
        this.f22144g = (FilterValue) parcel.readParcelable(FilterValue.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f22138a);
        parcel.writeString(this.f22139b);
        parcel.writeString(this.f22140c);
        parcel.writeString(this.f22141d);
        parcel.writeTypedList(this.f22142e);
        parcel.writeParcelable(this.f22143f, 0);
        parcel.writeParcelable(this.f22144g, 0);
    }
}
