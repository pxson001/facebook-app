package com.facebook.languages.switcher.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SuggestedLocalesResultDeserializer.class)
/* compiled from: token_query */
public class SuggestedLocalesResult implements Parcelable {
    public static final Creator<SuggestedLocalesResult> CREATOR = new C00591();
    @JsonProperty("locales")
    public final ImmutableList<LocaleModel> locales;

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = SuggestedLocalesResult_LocaleModelDeserializer.class)
    /* compiled from: token_query */
    public class LocaleModel implements Parcelable {
        public static final Creator<LocaleModel> CREATOR = new C00601();
        @JsonProperty("locale")
        public final String locale;

        /* compiled from: token_query */
        final class C00601 implements Creator<LocaleModel> {
            C00601() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new LocaleModel(parcel);
            }

            public final Object[] newArray(int i) {
                return new LocaleModel[i];
            }
        }

        public LocaleModel() {
            this.locale = null;
        }

        public LocaleModel(Parcel parcel) {
            this.locale = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.locale);
        }
    }

    /* compiled from: token_query */
    final class C00591 implements Creator<SuggestedLocalesResult> {
        C00591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SuggestedLocalesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SuggestedLocalesResult[i];
        }
    }

    public SuggestedLocalesResult() {
        this.locales = null;
    }

    public SuggestedLocalesResult(Parcel parcel) {
        this.locales = ImmutableListHelper.a(parcel.readArrayList(LocaleModel.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.locales);
    }
}
