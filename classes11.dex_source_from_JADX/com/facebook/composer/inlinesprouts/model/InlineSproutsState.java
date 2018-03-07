package com.facebook.composer.inlinesprouts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = InlineSproutsStateSerializer.class)
/* compiled from: fundraiser_campaign_model */
public class InlineSproutsState implements Parcelable {
    public static final Creator<InlineSproutsState> CREATOR = new C08411();
    public final boolean f6648a;
    public final boolean f6649b;
    public final boolean f6650c;
    public final boolean f6651d;
    public final boolean f6652e;
    public final boolean f6653f;
    public final boolean f6654g;
    public final InlineSproutsStateSpec$SproutsMetadataFlow f6655h;

    /* compiled from: fundraiser_campaign_model */
    final class C08411 implements Creator<InlineSproutsState> {
        C08411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new InlineSproutsState(parcel);
        }

        public final Object[] newArray(int i) {
            return new InlineSproutsState[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = InlineSproutsState_BuilderDeserializer.class)
    /* compiled from: fundraiser_campaign_model */
    public class Builder {
        private static final InlineSproutsStateSpec$SproutsMetadataFlow f6638a = InlineSproutsStateSpec$SproutsMetadataFlow.NO_MEDIA_ATTACHED;
        public boolean f6639b;
        public boolean f6640c;
        public boolean f6641d;
        public boolean f6642e;
        public boolean f6643f;
        public boolean f6644g;
        public boolean f6645h;
        public InlineSproutsStateSpec$SproutsMetadataFlow f6646i = f6638a;

        static {
            C0842x7f4707d4 c0842x7f4707d4 = new C0842x7f4707d4();
        }

        public Builder(InlineSproutsState inlineSproutsState) {
            Preconditions.checkNotNull(inlineSproutsState);
            if (inlineSproutsState instanceof InlineSproutsState) {
                inlineSproutsState = inlineSproutsState;
                this.f6639b = inlineSproutsState.f6648a;
                this.f6640c = inlineSproutsState.f6649b;
                this.f6641d = inlineSproutsState.f6650c;
                this.f6642e = inlineSproutsState.f6651d;
                this.f6643f = inlineSproutsState.f6652e;
                this.f6644g = inlineSproutsState.f6653f;
                this.f6645h = inlineSproutsState.f6654g;
                this.f6646i = inlineSproutsState.f6655h;
                return;
            }
            this.f6639b = inlineSproutsState.isFacecastNuxShowing();
            this.f6640c = inlineSproutsState.isInlineSproutsOpen();
            this.f6641d = inlineSproutsState.isLocationAttached();
            this.f6642e = inlineSproutsState.isMediaAttached();
            this.f6643f = inlineSproutsState.isMinutiaeAttached();
            this.f6644g = inlineSproutsState.isTagPeopleAttached();
            this.f6645h = inlineSproutsState.isVideoTaggingPromptShowing();
            this.f6646i = inlineSproutsState.getSproutsMetadataFlowState();
        }

        public final InlineSproutsState m8091a() {
            return new InlineSproutsState(this);
        }

        @JsonProperty("is_facecast_nux_showing")
        public Builder setIsFacecastNuxShowing(boolean z) {
            this.f6639b = z;
            return this;
        }

        @JsonProperty("is_inline_sprouts_open")
        public Builder setIsInlineSproutsOpen(boolean z) {
            this.f6640c = z;
            return this;
        }

        @JsonProperty("is_location_attached")
        public Builder setIsLocationAttached(boolean z) {
            this.f6641d = z;
            return this;
        }

        @JsonProperty("is_media_attached")
        public Builder setIsMediaAttached(boolean z) {
            this.f6642e = z;
            return this;
        }

        @JsonProperty("is_minutiae_attached")
        public Builder setIsMinutiaeAttached(boolean z) {
            this.f6643f = z;
            return this;
        }

        @JsonProperty("is_tag_people_attached")
        public Builder setIsTagPeopleAttached(boolean z) {
            this.f6644g = z;
            return this;
        }

        @JsonProperty("is_video_tagging_prompt_showing")
        public Builder setIsVideoTaggingPromptShowing(boolean z) {
            this.f6645h = z;
            return this;
        }

        @JsonProperty("sprouts_metadata_flow_state")
        public Builder setSproutsMetadataFlowState(InlineSproutsStateSpec$SproutsMetadataFlow inlineSproutsStateSpec$SproutsMetadataFlow) {
            this.f6646i = inlineSproutsStateSpec$SproutsMetadataFlow;
            return this;
        }
    }

    /* compiled from: fundraiser_campaign_model */
    class Deserializer extends JsonDeserializer<InlineSproutsState> {
        private static final InlineSproutsState_BuilderDeserializer f6647a = new InlineSproutsState_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m8092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f6647a.a(jsonParser, deserializationContext)).m8091a();
        }
    }

    public InlineSproutsState(Builder builder) {
        this.f6648a = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6639b))).booleanValue();
        this.f6649b = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6640c))).booleanValue();
        this.f6650c = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6641d))).booleanValue();
        this.f6651d = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6642e))).booleanValue();
        this.f6652e = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6643f))).booleanValue();
        this.f6653f = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6644g))).booleanValue();
        this.f6654g = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f6645h))).booleanValue();
        this.f6655h = (InlineSproutsStateSpec$SproutsMetadataFlow) Preconditions.checkNotNull(builder.f6646i);
    }

    public InlineSproutsState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f6648a = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6649b = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6650c = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6651d = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6652e = z;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f6653f = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.f6654g = z2;
        this.f6655h = InlineSproutsStateSpec$SproutsMetadataFlow.valueOf(parcel.readString());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m8093a(InlineSproutsState inlineSproutsState) {
        return new Builder(inlineSproutsState);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f6648a ? 1 : 0);
        if (this.f6649b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f6650c) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f6651d) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f6652e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f6653f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f6654g) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f6655h.name());
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("is_facecast_nux_showing")
    public boolean isFacecastNuxShowing() {
        return this.f6648a;
    }

    @JsonProperty("is_inline_sprouts_open")
    public boolean isInlineSproutsOpen() {
        return this.f6649b;
    }

    @JsonProperty("is_location_attached")
    public boolean isLocationAttached() {
        return this.f6650c;
    }

    @JsonProperty("is_media_attached")
    public boolean isMediaAttached() {
        return this.f6651d;
    }

    @JsonProperty("is_minutiae_attached")
    public boolean isMinutiaeAttached() {
        return this.f6652e;
    }

    @JsonProperty("is_tag_people_attached")
    public boolean isTagPeopleAttached() {
        return this.f6653f;
    }

    @JsonProperty("is_video_tagging_prompt_showing")
    public boolean isVideoTaggingPromptShowing() {
        return this.f6654g;
    }

    @JsonProperty("sprouts_metadata_flow_state")
    public InlineSproutsStateSpec$SproutsMetadataFlow getSproutsMetadataFlowState() {
        return this.f6655h;
    }
}
