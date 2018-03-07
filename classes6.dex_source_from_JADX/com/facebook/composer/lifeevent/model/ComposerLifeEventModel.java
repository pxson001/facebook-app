package com.facebook.composer.lifeevent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.enums.GraphQLLifeEventEducationExperienceType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.google.common.base.Preconditions;

/* compiled from: place_list_ */
public class ComposerLifeEventModel implements Parcelable {
    public static final Creator<ComposerLifeEventModel> CREATOR = new C04631();
    public final String f7831a;
    public final GraphQLLifeEventAPIIdentifier f7832b;
    public final DefaultImageFieldsModel f7833c;
    public final String f7834d;
    public final boolean f7835e;
    public final String f7836f;
    public final String f7837g;
    public final boolean f7838h;
    public final GraphQLLifeEventEducationExperienceType f7839i;
    public final String f7840j;
    public final String f7841k;

    /* compiled from: place_list_ */
    final class C04631 implements Creator<ComposerLifeEventModel> {
        C04631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerLifeEventModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerLifeEventModel[i];
        }
    }

    /* compiled from: place_list_ */
    public final class Builder {
        public String f7820a;
        public GraphQLLifeEventAPIIdentifier f7821b;
        public DefaultImageFieldsModel f7822c;
        public String f7823d;
        public boolean f7824e;
        public String f7825f;
        public String f7826g;
        public boolean f7827h;
        public GraphQLLifeEventEducationExperienceType f7828i;
        public String f7829j;
        public String f7830k;

        public Builder(ComposerLifeEventModel composerLifeEventModel) {
            this.f7820a = composerLifeEventModel.f7831a;
            this.f7821b = composerLifeEventModel.f7832b;
            this.f7822c = composerLifeEventModel.f7833c;
            this.f7823d = composerLifeEventModel.f7834d;
            this.f7824e = composerLifeEventModel.f7835e;
            this.f7825f = composerLifeEventModel.f7836f;
            this.f7826g = composerLifeEventModel.f7837g;
            this.f7827h = composerLifeEventModel.f7838h;
            this.f7828i = composerLifeEventModel.f7839i;
            this.f7829j = composerLifeEventModel.f7840j;
            this.f7830k = composerLifeEventModel.f7841k;
        }

        public Builder(LifeEventFieldsModel lifeEventFieldsModel) {
            this.f7820a = lifeEventFieldsModel.m11355a();
            this.f7821b = lifeEventFieldsModel.m11359m();
            this.f7828i = lifeEventFieldsModel.m11356j() == null ? GraphQLLifeEventEducationExperienceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : lifeEventFieldsModel.m11356j();
            this.f7822c = lifeEventFieldsModel.m11357k();
            this.f7823d = lifeEventFieldsModel.m11358l();
        }

        public final ComposerLifeEventModel m11265a() {
            Preconditions.checkNotNull(this.f7820a, "description should not be null");
            Preconditions.checkNotNull(this.f7821b, "life event type should not be null");
            Preconditions.checkNotNull(this.f7828i, "education experience type should not be null");
            return new ComposerLifeEventModel(this);
        }
    }

    public ComposerLifeEventModel(Builder builder) {
        this.f7831a = builder.f7820a;
        this.f7832b = builder.f7821b;
        this.f7833c = builder.f7822c;
        this.f7834d = builder.f7823d;
        this.f7835e = builder.f7824e;
        this.f7836f = builder.f7825f;
        this.f7837g = builder.f7826g;
        this.f7838h = builder.f7827h;
        this.f7839i = builder.f7828i;
        this.f7840j = builder.f7829j;
        this.f7841k = builder.f7830k;
    }

    public ComposerLifeEventModel(Parcel parcel) {
        this.f7831a = parcel.readString();
        this.f7832b = GraphQLLifeEventAPIIdentifier.valueOf(parcel.readString());
        this.f7833c = (DefaultImageFieldsModel) FlatBufferModelHelper.a(parcel);
        this.f7834d = parcel.readString();
        this.f7835e = ParcelUtil.a(parcel);
        this.f7836f = parcel.readString();
        this.f7837g = parcel.readString();
        this.f7838h = ParcelUtil.a(parcel);
        this.f7839i = GraphQLLifeEventEducationExperienceType.valueOf(parcel.readString());
        this.f7840j = parcel.readString();
        this.f7841k = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7831a);
        parcel.writeString(this.f7832b.name());
        FlatBufferModelHelper.a(parcel, this.f7833c);
        parcel.writeString(this.f7834d);
        ParcelUtil.a(parcel, this.f7835e);
        parcel.writeString(this.f7836f);
        parcel.writeString(this.f7837g);
        ParcelUtil.a(parcel, this.f7838h);
        parcel.writeString(this.f7839i.name());
        parcel.writeString(this.f7840j);
        parcel.writeString(this.f7841k);
    }

    public final Builder m11266l() {
        return new Builder(this);
    }
}
