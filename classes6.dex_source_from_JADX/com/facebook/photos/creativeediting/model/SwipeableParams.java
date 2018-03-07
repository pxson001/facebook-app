package com.facebook.photos.creativeediting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: surface was null */
public class SwipeableParams implements Parcelable {
    public static final Creator<SwipeableParams> CREATOR = new C02161();
    private List<StickerParams> f3514a;
    public String f3515b = "";
    public SwipeableItemType f3516c;
    public String f3517d;

    /* compiled from: surface was null */
    final class C02161 implements Creator<SwipeableParams> {
        C02161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SwipeableParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SwipeableParams[i];
        }
    }

    /* compiled from: surface was null */
    public enum SwipeableItemType {
        FILTER,
        FRAME
    }

    public SwipeableParams(List<StickerParams> list, String str, SwipeableItemType swipeableItemType, String str2) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(str);
        this.f3514a = list;
        this.f3515b = str;
        this.f3516c = swipeableItemType;
        this.f3517d = str2;
    }

    public SwipeableParams(Parcel parcel) {
        this.f3514a = ImmutableList.copyOf(parcel.createTypedArrayList(StickerParams.CREATOR));
        this.f3515b = parcel.readString();
        this.f3516c = SwipeableItemType.values()[parcel.readInt()];
        this.f3517d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray((Parcelable[]) this.f3514a.toArray(new StickerParams[this.f3514a.size()]), i);
        parcel.writeString(this.f3515b);
        parcel.writeInt(this.f3516c.ordinal());
        parcel.writeString(this.f3517d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwipeableParams)) {
            return false;
        }
        SwipeableParams swipeableParams = (SwipeableParams) obj;
        if (this.f3515b.equals(swipeableParams.f3515b) && this.f3516c.equals(swipeableParams.f3516c)) {
            ImmutableList a = m4705a();
            ImmutableList a2 = ((SwipeableParams) obj).m4705a();
            Object obj2 = null;
            if (a == null && a2 == null) {
                obj2 = 1;
            } else if ((a != null || a2 == null) && ((a == null || a2 != null) && a.size() == a2.size())) {
                for (int i = 0; i < a.size(); i++) {
                    if (!((StickerParams) a.get(i)).m4686a((StickerParams) a2.get(i))) {
                        break;
                    }
                }
                int i2 = 1;
            }
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3515b.hashCode() + 527) * 31) + this.f3516c.hashCode();
    }

    public final ImmutableList<StickerParams> m4705a() {
        return ImmutableList.copyOf(this.f3514a);
    }
}
