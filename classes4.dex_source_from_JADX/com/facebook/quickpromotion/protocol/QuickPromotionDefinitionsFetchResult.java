package com.facebook.quickpromotion.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = QuickPromotionDefinitionsFetchResultDeserializer.class)
@Immutable
/* compiled from: request_location_update */
public class QuickPromotionDefinitionsFetchResult implements Parcelable {
    public static final Creator<QuickPromotionDefinitionsFetchResult> CREATOR = new C01581();
    @JsonProperty("promotions")
    public final List<QuickPromotionDefinition> mQuickPromotionDefinitions = null;

    /* compiled from: request_location_update */
    final class C01581 implements Creator<QuickPromotionDefinitionsFetchResult> {
        C01581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new QuickPromotionDefinitionsFetchResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new QuickPromotionDefinitionsFetchResult[i];
        }
    }

    public QuickPromotionDefinitionsFetchResult(Parcel parcel) {
        parcel.readList(this.mQuickPromotionDefinitions, QuickPromotionDefinition.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.mQuickPromotionDefinitions);
    }
}
