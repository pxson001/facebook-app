package com.facebook.photos.mediafetcher.query.param;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.photos.mediafetcher.interfaces.QueryParam;

/* compiled from: key_load_suggest_edits_sections */
public class CategoryQueryParam extends QueryParam {
    public static final Creator<CategoryQueryParam> CREATOR = new C09011();
    public final String f10634a;
    public final CategoryInputCategoryName f10635b;
    public final String f10636c;

    /* compiled from: key_load_suggest_edits_sections */
    final class C09011 implements Creator<CategoryQueryParam> {
        C09011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CategoryQueryParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new CategoryQueryParam[i];
        }
    }

    public CategoryQueryParam(String str, CategoryInputCategoryName categoryInputCategoryName, String str2) {
        this.f10634a = str;
        this.f10635b = categoryInputCategoryName;
        this.f10636c = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10634a);
        parcel.writeSerializable(this.f10635b);
        parcel.writeString(this.f10636c);
    }

    public CategoryQueryParam(Parcel parcel) {
        this.f10634a = parcel.readString();
        this.f10635b = (CategoryInputCategoryName) parcel.readSerializable();
        this.f10636c = parcel.readString();
    }
}
