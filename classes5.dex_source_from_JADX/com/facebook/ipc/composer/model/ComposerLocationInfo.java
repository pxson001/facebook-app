package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerLocationInfoDeserializer.class)
@JsonSerialize(using = ComposerLocationInfoSerializer.class)
/* compiled from: TLS */
public class ComposerLocationInfo implements Parcelable {
    public static final Creator<ComposerLocationInfo> CREATOR = new C13321();
    @JsonProperty("implicit_loc")
    @Nullable
    final ImplicitLocation mImplicitLoc;
    @JsonProperty("implicit_location_disabled_by_user")
    final boolean mImplicitLocationDisabledByUser;
    @JsonProperty("is_checkin")
    final boolean mIsCheckin;
    @JsonProperty("lightweight_place_picker_places")
    final ImmutableList<CheckinPlaceModel> mLightweightPlacePickerPlaces;
    @JsonProperty("lightweight_place_picker_search_results_id")
    final String mLightweightPlacePickerSearchResultsId;
    @JsonProperty("lightweight_place_picker_session_id")
    final String mLightweightPlacePickerSessionId;
    @JsonProperty("place_attachment_removed")
    final boolean mPlaceAttachmentRemoved;
    @JsonProperty("tagged_place")
    @Nullable
    final CheckinPlaceModel mTaggedPlace;
    @JsonProperty("text_only_place")
    @Nullable
    final String mTextOnlyPlace;
    @JsonProperty("xed_location")
    final boolean mXedLocation;

    /* compiled from: TLS */
    final class C13321 implements Creator<ComposerLocationInfo> {
        C13321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerLocationInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerLocationInfo[i];
        }
    }

    /* compiled from: TLS */
    public class Builder {
        @Nullable
        public CheckinPlaceModel f13959a;
        public boolean f13960b;
        @Nullable
        public String f13961c;
        public boolean f13962d;
        public boolean f13963e;
        @Nullable
        public ImplicitLocation f13964f;
        public ImmutableList<CheckinPlaceModel> f13965g = RegularImmutableList.a;
        public String f13966h = SafeUUIDGenerator.a().toString();
        public String f13967i = "";
        public boolean f13968j;

        public Builder(ComposerLocationInfo composerLocationInfo) {
            this.f13959a = composerLocationInfo.mTaggedPlace;
            this.f13960b = composerLocationInfo.mPlaceAttachmentRemoved;
            this.f13961c = composerLocationInfo.mTextOnlyPlace;
            this.f13962d = composerLocationInfo.mIsCheckin;
            this.f13963e = composerLocationInfo.mXedLocation;
            this.f13964f = composerLocationInfo.mImplicitLoc;
            this.f13965g = composerLocationInfo.mLightweightPlacePickerPlaces;
            this.f13966h = composerLocationInfo.mLightweightPlacePickerSessionId;
            this.f13967i = composerLocationInfo.mLightweightPlacePickerSearchResultsId;
            this.f13968j = composerLocationInfo.mImplicitLocationDisabledByUser;
        }

        public final Builder m23324a(@Nullable CheckinPlaceModel checkinPlaceModel) {
            m23321c();
            this.f13959a = CheckinPlaceModel.a(checkinPlaceModel);
            return this;
        }

        public final Builder m23326a(@Nullable String str) {
            m23321c();
            this.f13961c = str;
            return this;
        }

        public final Builder m23323a(@Nullable ImplicitLocation implicitLocation) {
            this.f13964f = implicitLocation;
            return this;
        }

        public final Builder m23327b(CheckinPlaceModel checkinPlaceModel) {
            m23325a(checkinPlaceModel, null);
            return this;
        }

        public final Builder m23325a(CheckinPlaceModel checkinPlaceModel, ImplicitLocation implicitLocation) {
            m23321c();
            this.f13963e = false;
            if (checkinPlaceModel != null) {
                this.f13959a = CheckinPlaceModel.a(checkinPlaceModel);
            }
            if (implicitLocation != null) {
                this.f13964f = implicitLocation;
            }
            return this;
        }

        public final Builder m23322a() {
            this.f13963e = true;
            this.f13960b = false;
            this.f13959a = null;
            this.f13964f = null;
            this.f13961c = null;
            return this;
        }

        public final ComposerLocationInfo m23328b() {
            return new ComposerLocationInfo(this);
        }

        private void m23321c() {
            this.f13959a = null;
            this.f13961c = null;
        }
    }

    /* compiled from: TLS */
    public interface ProvidesLocationInfo {
        ComposerLocationInfo m23329g();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m23330a(ComposerLocationInfo composerLocationInfo) {
        return new Builder(composerLocationInfo);
    }

    private ComposerLocationInfo() {
        this(new Builder());
    }

    public ComposerLocationInfo(Builder builder) {
        this.mTaggedPlace = builder.f13959a;
        this.mPlaceAttachmentRemoved = builder.f13960b;
        this.mTextOnlyPlace = builder.f13961c;
        this.mIsCheckin = builder.f13962d;
        this.mXedLocation = builder.f13963e;
        this.mImplicitLoc = builder.f13964f;
        this.mLightweightPlacePickerPlaces = builder.f13965g;
        this.mLightweightPlacePickerSessionId = builder.f13966h;
        this.mLightweightPlacePickerSearchResultsId = builder.f13967i;
        this.mImplicitLocationDisabledByUser = builder.f13968j;
    }

    public ComposerLocationInfo(Parcel parcel) {
        this.mTaggedPlace = (CheckinPlaceModel) FlatBufferModelHelper.m4278a(parcel);
        this.mTextOnlyPlace = parcel.readString();
        this.mIsCheckin = ParcelUtil.m3827a(parcel);
        this.mXedLocation = ParcelUtil.m3827a(parcel);
        this.mPlaceAttachmentRemoved = ParcelUtil.m3827a(parcel);
        this.mImplicitLoc = (ImplicitLocation) parcel.readParcelable(ImplicitLocation.class.getClassLoader());
        this.mLightweightPlacePickerPlaces = ImmutableList.copyOf(FlatBufferModelHelper.m4294b(parcel));
        this.mLightweightPlacePickerSessionId = parcel.readString();
        this.mLightweightPlacePickerSearchResultsId = parcel.readString();
        this.mImplicitLocationDisabledByUser = ParcelUtil.m3827a(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.m4288a(parcel, this.mTaggedPlace);
        parcel.writeString(this.mTextOnlyPlace);
        ParcelUtil.m3826a(parcel, this.mIsCheckin);
        ParcelUtil.m3826a(parcel, this.mXedLocation);
        ParcelUtil.m3826a(parcel, this.mPlaceAttachmentRemoved);
        parcel.writeParcelable(this.mImplicitLoc, i);
        FlatBufferModelHelper.m4289a(parcel, this.mLightweightPlacePickerPlaces);
        parcel.writeString(this.mLightweightPlacePickerSessionId);
        parcel.writeString(this.mLightweightPlacePickerSearchResultsId);
        ParcelUtil.m3826a(parcel, this.mImplicitLocationDisabledByUser);
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public final CheckinPlaceModel m23331a() {
        return this.mTaggedPlace;
    }

    public final boolean m23332b() {
        return this.mPlaceAttachmentRemoved;
    }

    @Nullable
    public final String m23333c() {
        return this.mTextOnlyPlace;
    }

    public final boolean m23334d() {
        return this.mIsCheckin;
    }

    public final boolean m23335e() {
        return this.mXedLocation;
    }

    @Nullable
    public final ImplicitLocation m23336f() {
        return this.mImplicitLoc;
    }

    public final ImmutableList<? extends CheckinPlace> m23337g() {
        return this.mLightweightPlacePickerPlaces;
    }

    public final String m23338h() {
        return this.mLightweightPlacePickerSessionId;
    }

    public final String m23339i() {
        return this.mLightweightPlacePickerSearchResultsId;
    }

    public final long m23340j() {
        if (m23331a() != null) {
            return Long.parseLong(m23331a().cf_());
        }
        if (m23336f() != null) {
            return m23336f().pageId;
        }
        return -1;
    }

    public final boolean m23341k() {
        return (m23331a() == null && m23333c() == null) ? false : true;
    }

    public final boolean m23342l() {
        return this.mImplicitLocationDisabledByUser;
    }
}
