package com.facebook.privacy.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

/* compiled from: fe49e41caaf17589f8c18e8698bbe441 */
public class SelectablePrivacyData implements Parcelable {
    public static final Creator<SelectablePrivacyData> CREATOR = new C10241();
    public final PrivacyOptionsResult f15106a;
    public final boolean f15107b;
    public final boolean f15108c;
    public final GraphQLPrivacyOption f15109d;

    /* compiled from: fe49e41caaf17589f8c18e8698bbe441 */
    final class C10241 implements Creator<SelectablePrivacyData> {
        C10241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SelectablePrivacyData(parcel);
        }

        public final Object[] newArray(int i) {
            return new SelectablePrivacyData[i];
        }
    }

    /* compiled from: fe49e41caaf17589f8c18e8698bbe441 */
    public class Builder {
        public PrivacyOptionsResult f15102a = null;
        public GraphQLPrivacyOption f15103b = null;
        public boolean f15104c = false;
        public boolean f15105d = false;

        public Builder(SelectablePrivacyData selectablePrivacyData) {
            if (selectablePrivacyData != null) {
                this.f15102a = selectablePrivacyData.f15106a;
                this.f15103b = selectablePrivacyData.f15109d;
                this.f15104c = selectablePrivacyData.f15107b;
                this.f15105d = selectablePrivacyData.f15108c;
            }
        }

        public final Builder m22696a(GraphQLPrivacyOption graphQLPrivacyOption) {
            this.f15103b = graphQLPrivacyOption;
            if (this.f15103b != null && Strings.isNullOrEmpty(this.f15103b.c())) {
                String str = "";
                com.facebook.graphql.model.GraphQLPrivacyOption.Builder builder = this.f15103b == null ? new com.facebook.graphql.model.GraphQLPrivacyOption.Builder() : com.facebook.graphql.model.GraphQLPrivacyOption.Builder.a(this.f15103b);
                builder.j = str;
                this.f15103b = builder.a();
            }
            return this;
        }

        public final SelectablePrivacyData m22697b() {
            return new SelectablePrivacyData(this);
        }
    }

    public SelectablePrivacyData(Builder builder) {
        this.f15106a = builder.f15102a;
        this.f15109d = builder.f15103b;
        this.f15107b = builder.f15104c;
        this.f15108c = builder.f15105d;
    }

    public SelectablePrivacyData(Parcel parcel) {
        this.f15106a = (PrivacyOptionsResult) parcel.readParcelable(PrivacyOptionsResult.class.getClassLoader());
        this.f15109d = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.f15107b = ParcelUtil.a(parcel);
        this.f15108c = ParcelUtil.a(parcel);
    }

    public final String m22700d() {
        if (this.f15109d == null) {
            return null;
        }
        if (this.f15106a == null || !this.f15107b) {
            return this.f15109d.c();
        }
        return GraphQLPrivacyOptionBuilder.m22662a(this.f15109d).m22663a().m22668b().c();
    }

    public final GraphQLPrivacyOptionTagExpansionType m22702g() {
        GraphQLPrivacyOption graphQLPrivacyOption = this.f15109d;
        if (graphQLPrivacyOption == null) {
            return GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (graphQLPrivacyOption.G_() == null || graphQLPrivacyOption.G_().isEmpty()) {
            return graphQLPrivacyOption.E_();
        }
        return (GraphQLPrivacyOptionTagExpansionType) graphQLPrivacyOption.G_().get(0);
    }

    public final GraphQLPrivacyOption m22698b() {
        GraphQLPrivacyOptionBuilder a = GraphQLPrivacyOptionBuilder.m22662a(this.f15109d);
        if (this.f15107b) {
            a.m22663a();
        }
        return a.m22668b();
    }

    public final int m22699c() {
        return this.f15106a.b(this.f15109d);
    }

    public final boolean m22701f() {
        if (this.f15109d == null) {
            return false;
        }
        if (m22702g() == GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES || m22702g() == GraphQLPrivacyOptionTagExpansionType.TAGGEES) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectablePrivacyData)) {
            return false;
        }
        SelectablePrivacyData selectablePrivacyData = (SelectablePrivacyData) obj;
        if (Objects.equal(this.f15106a, selectablePrivacyData.f15106a) && PrivacyOptionHelper.a(this.f15109d, selectablePrivacyData.f15109d) && this.f15107b == selectablePrivacyData.f15107b && this.f15108c == selectablePrivacyData.f15108c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15106a, Boolean.valueOf(this.f15107b), Boolean.valueOf(this.f15108c)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15106a, i);
        FlatBufferModelHelper.a(parcel, this.f15109d);
        ParcelUtil.a(parcel, this.f15107b);
        ParcelUtil.a(parcel, this.f15108c);
    }
}
