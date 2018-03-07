package com.facebook.localcontent.photos;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.google.common.base.Objects;

/* compiled from: document_subtitle */
public class PhotosByCategoryPandoraInstanceId extends PandoraInstanceId {
    public static final Creator<PhotosByCategoryPandoraInstanceId> CREATOR = new C16591();
    public String f15203a;
    private int f15204b;
    public CategoryInputCategoryName f15205c;
    public GraphQLPhotosByCategoryEntryPoint f15206d;

    /* compiled from: document_subtitle */
    final class C16591 implements Creator<PhotosByCategoryPandoraInstanceId> {
        C16591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotosByCategoryPandoraInstanceId(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotosByCategoryPandoraInstanceId[i];
        }
    }

    public PhotosByCategoryPandoraInstanceId(String str, int i, CategoryInputCategoryName categoryInputCategoryName, GraphQLPhotosByCategoryEntryPoint graphQLPhotosByCategoryEntryPoint) {
        this.f15203a = str;
        this.f15204b = i;
        this.f15205c = categoryInputCategoryName;
        this.f15206d = graphQLPhotosByCategoryEntryPoint;
    }

    public PhotosByCategoryPandoraInstanceId(Parcel parcel) {
        this.f15203a = parcel.readString();
        this.f15204b = parcel.readInt();
        this.f15205c = (CategoryInputCategoryName) parcel.readSerializable();
        this.f15206d = (GraphQLPhotosByCategoryEntryPoint) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15203a);
        parcel.writeInt(this.f15204b);
        parcel.writeSerializable(this.f15205c);
        parcel.writeSerializable(this.f15206d);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PhotosByCategoryPandoraInstanceId)) {
            return false;
        }
        PhotosByCategoryPandoraInstanceId photosByCategoryPandoraInstanceId = (PhotosByCategoryPandoraInstanceId) obj;
        if (this.f15203a.equals(photosByCategoryPandoraInstanceId.f15203a) && this.f15204b == photosByCategoryPandoraInstanceId.f15204b && this.f15205c.equals(photosByCategoryPandoraInstanceId.f15205c) && this.f15206d.equals(photosByCategoryPandoraInstanceId.f15206d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15203a, Integer.valueOf(this.f15204b), this.f15205c, this.f15206d});
    }

    public String toString() {
        return this.f15203a + "," + this.f15204b + "," + this.f15205c.toString() + "," + this.f15206d.toString();
    }
}
