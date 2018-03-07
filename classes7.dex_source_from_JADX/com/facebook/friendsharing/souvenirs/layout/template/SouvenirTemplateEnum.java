package com.facebook.friendsharing.souvenirs.layout.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: Ran into a problem extracting thumbnail */
public enum SouvenirTemplateEnum implements Parcelable {
    SINGLE_ITEM(new SouvenirSingleItemTemplate()),
    TWO_SQUARE_ITEMS(new SouvenirHorizontalSquareItemsTemplate(2)),
    THREE_SQUARE_ITEMS(new SouvenirHorizontalSquareItemsTemplate(3)),
    TRIPLE_ITEMS_FIRST_PORTRAIT(new SouvenirTripleSquareItemsTemplate(true)),
    TRIPLE_ITEMS_THIRD_PORTRAIT(new SouvenirTripleSquareItemsTemplate(false));
    
    public static final Creator<SouvenirTemplateEnum> CREATOR = null;
    private final SouvenirTemplate mTemplate;

    /* compiled from: Ran into a problem extracting thumbnail */
    final class C20911 implements Creator<SouvenirTemplateEnum> {
        C20911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return SouvenirTemplateEnum.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new SouvenirTemplateEnum[i];
        }
    }

    static {
        CREATOR = new C20911();
    }

    private SouvenirTemplateEnum(SouvenirTemplate souvenirTemplate) {
        this.mTemplate = souvenirTemplate;
    }

    public final SouvenirTemplate getTemplate() {
        return this.mTemplate;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    public final int describeContents() {
        return 0;
    }
}
