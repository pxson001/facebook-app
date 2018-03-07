package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PicSquareDeserializer.class)
@Immutable
/* compiled from: sms_takeover_promo_row */
public class PicSquare implements Parcelable {
    public static final Creator<PicSquare> CREATOR = new C00972();
    private static final Comparator<PicSquareUrlWithSize> f1997a = new C00961();
    @JsonProperty("picSquareUrls")
    private final ImmutableList<PicSquareUrlWithSize> mPicSquareUrlsWithSizes;

    /* compiled from: sms_takeover_promo_row */
    final class C00961 implements Comparator<PicSquareUrlWithSize> {
        C00961() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((PicSquareUrlWithSize) obj).size - ((PicSquareUrlWithSize) obj2).size;
        }
    }

    /* compiled from: sms_takeover_promo_row */
    final class C00972 implements Creator<PicSquare> {
        C00972() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PicSquare(parcel);
        }

        public final Object[] newArray(int i) {
            return new PicSquare[i];
        }
    }

    public PicSquare(ImmutableList<PicSquareUrlWithSize> immutableList) {
        Preconditions.checkArgument(!immutableList.isEmpty());
        Collection a = Lists.a(immutableList);
        Collections.sort(a, f1997a);
        this.mPicSquareUrlsWithSizes = ImmutableList.copyOf(a);
    }

    public PicSquare(@Nullable PicSquareUrlWithSize picSquareUrlWithSize, @Nullable PicSquareUrlWithSize picSquareUrlWithSize2, @Nullable PicSquareUrlWithSize picSquareUrlWithSize3) {
        boolean z = true;
        int i = picSquareUrlWithSize != null ? 1 : 0;
        if (picSquareUrlWithSize2 != null) {
            i++;
        }
        if (picSquareUrlWithSize3 != null) {
            i++;
        }
        if (i == 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        switch (i) {
            case 1:
                if (picSquareUrlWithSize != null) {
                    this.mPicSquareUrlsWithSizes = ImmutableList.of(picSquareUrlWithSize);
                    return;
                } else if (picSquareUrlWithSize2 != null) {
                    this.mPicSquareUrlsWithSizes = ImmutableList.of(picSquareUrlWithSize2);
                    return;
                } else {
                    this.mPicSquareUrlsWithSizes = ImmutableList.of(picSquareUrlWithSize3);
                    return;
                }
            case 2:
                if (picSquareUrlWithSize == null) {
                    picSquareUrlWithSize = picSquareUrlWithSize3;
                } else if (picSquareUrlWithSize2 == null) {
                    picSquareUrlWithSize2 = picSquareUrlWithSize3;
                }
                if (picSquareUrlWithSize.size < picSquareUrlWithSize2.size) {
                    this.mPicSquareUrlsWithSizes = ImmutableList.of(picSquareUrlWithSize, picSquareUrlWithSize2);
                    return;
                } else {
                    this.mPicSquareUrlsWithSizes = ImmutableList.of(picSquareUrlWithSize2, picSquareUrlWithSize);
                    return;
                }
            default:
                PicSquareUrlWithSize picSquareUrlWithSize4;
                if (picSquareUrlWithSize.size <= picSquareUrlWithSize2.size) {
                    picSquareUrlWithSize4 = picSquareUrlWithSize2;
                    picSquareUrlWithSize2 = picSquareUrlWithSize;
                    picSquareUrlWithSize = picSquareUrlWithSize4;
                }
                if (picSquareUrlWithSize.size <= picSquareUrlWithSize3.size) {
                    picSquareUrlWithSize4 = picSquareUrlWithSize3;
                    picSquareUrlWithSize3 = picSquareUrlWithSize;
                    picSquareUrlWithSize = picSquareUrlWithSize4;
                }
                this.mPicSquareUrlsWithSizes = ImmutableList.of(picSquareUrlWithSize2, picSquareUrlWithSize3, picSquareUrlWithSize);
                return;
        }
    }

    public PicSquare(Parcel parcel) {
        this.mPicSquareUrlsWithSizes = ImmutableList.copyOf(parcel.readArrayList(PicSquareUrlWithSize.class.getClassLoader()));
    }

    private PicSquare() {
        this.mPicSquareUrlsWithSizes = null;
    }

    public final PicSquareUrlWithSize m2096a(int i) {
        int size = this.mPicSquareUrlsWithSizes.size();
        for (int i2 = 0; i2 < size; i2++) {
            PicSquareUrlWithSize picSquareUrlWithSize = (PicSquareUrlWithSize) this.mPicSquareUrlsWithSizes.get(i2);
            if (i <= picSquareUrlWithSize.size) {
                return picSquareUrlWithSize;
            }
        }
        return (PicSquareUrlWithSize) this.mPicSquareUrlsWithSizes.get(size - 1);
    }

    public final ImmutableList<PicSquareUrlWithSize> m2097a() {
        return this.mPicSquareUrlsWithSizes;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.mPicSquareUrlsWithSizes);
    }
}
