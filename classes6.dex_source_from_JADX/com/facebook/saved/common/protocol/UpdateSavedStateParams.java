package com.facebook.saved.common.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: setDescriptionTags */
public class UpdateSavedStateParams implements Parcelable {
    public static final Creator<UpdateSavedStateParams> CREATOR = new C02921();
    public final Optional<String> f4857a;
    public final Optional<String> f4858b;
    public final Optional<String> f4859c;
    public final Optional<String> f4860d;
    public final SavedAction f4861e;
    public final CurationSurface f4862f;
    public final CurationMechanism f4863g;
    public final ImmutableList<String> f4864h;

    /* compiled from: setDescriptionTags */
    final class C02921 implements Creator<UpdateSavedStateParams> {
        C02921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateSavedStateParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateSavedStateParams[i];
        }
    }

    /* compiled from: setDescriptionTags */
    public class Builder {
        public Optional<String> f4849a = Absent.INSTANCE;
        public Optional<String> f4850b = Absent.INSTANCE;
        public Optional<String> f4851c = Absent.INSTANCE;
        public Optional<String> f4852d = Absent.INSTANCE;
        public SavedAction f4853e;
        public CurationSurface f4854f;
        public CurationMechanism f4855g;
        public final ImmutableList<String> f4856h;

        public Builder(SavedAction savedAction, CurationSurface curationSurface, CurationMechanism curationMechanism, ImmutableList<String> immutableList) {
            this.f4853e = savedAction;
            this.f4854f = curationSurface;
            this.f4855g = curationMechanism;
            this.f4856h = immutableList;
        }

        public final UpdateSavedStateParams m7660a() {
            return new UpdateSavedStateParams(this);
        }
    }

    /* compiled from: setDescriptionTags */
    public enum SavedAction {
        SAVE("SAVE"),
        UNSAVE("UNSAVE"),
        ARCHIVE("ARCHIVE"),
        UNARCHIVE("UNARCHIVE"),
        REMOVE_FROM_ARCHIVE("REMOVE_FROM_ARCHIVE");
        
        public final String value;

        private SavedAction(String str) {
            this.value = str;
        }
    }

    public UpdateSavedStateParams(Builder builder) {
        this.f4857a = builder.f4849a;
        this.f4858b = builder.f4851c;
        this.f4859c = builder.f4850b;
        this.f4861e = builder.f4853e;
        this.f4862f = builder.f4854f;
        this.f4863g = builder.f4855g;
        this.f4864h = builder.f4856h;
        this.f4860d = builder.f4852d;
    }

    public UpdateSavedStateParams(Parcel parcel) {
        this.f4857a = Optional.fromNullable(parcel.readString());
        this.f4858b = Optional.fromNullable(parcel.readString());
        this.f4859c = Optional.fromNullable(parcel.readString());
        this.f4860d = Optional.fromNullable(parcel.readString());
        this.f4861e = (SavedAction) parcel.readSerializable();
        this.f4862f = (CurationSurface) parcel.readSerializable();
        this.f4863g = (CurationMechanism) parcel.readSerializable();
        this.f4864h = ImmutableListHelper.a(parcel.createStringArrayList());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString((String) this.f4857a.orNull());
        parcel.writeString((String) this.f4858b.orNull());
        parcel.writeString((String) this.f4859c.orNull());
        parcel.writeString((String) this.f4860d.orNull());
        parcel.writeSerializable(this.f4861e);
        parcel.writeSerializable(this.f4862f);
        parcel.writeSerializable(this.f4863g);
        parcel.writeStringList(this.f4864h);
    }
}
