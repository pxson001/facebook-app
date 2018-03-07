package com.facebook.privacy.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionWithIconFields;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PrivacyOptionsResultDeserializer.class)
@JsonSerialize(using = PrivacyOptionsResultSerializer.class)
/* compiled from: sim_home_location */
public final class PrivacyOptionsResult implements Parcelable {
    public static final Creator<PrivacyOptionsResult> CREATOR = new C01151();
    @JsonProperty("basic_privacy_options")
    public final ImmutableList<GraphQLPrivacyOption> basicPrivacyOptions;
    @JsonProperty("friend_list_privacy_options")
    public final ImmutableList<GraphQLPrivacyOption> friendListPrivacyOptions;
    @JsonProperty("is_result_from_server")
    public final boolean isResultFromServer;
    @JsonProperty("is_selected_option_external")
    public final boolean isSelectedOptionExternal;
    @JsonProperty("recent_privacy_option")
    public final GraphQLPrivacyOption recentPrivacyOption;
    @JsonProperty("selected_privacy_option")
    public final GraphQLPrivacyOption selectedPrivacyOption;

    /* compiled from: sim_home_location */
    final class C01151 implements Creator<PrivacyOptionsResult> {
        C01151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PrivacyOptionsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new PrivacyOptionsResult[i];
        }
    }

    /* compiled from: sim_home_location */
    public class Builder {
        private ImmutableList<GraphQLPrivacyOption> f2198a;
        private ImmutableList<GraphQLPrivacyOption> f2199b;
        private GraphQLPrivacyOption f2200c;
        private GraphQLPrivacyOption f2201d;
        private boolean f2202e;
        private boolean f2203f;

        public Builder(PrivacyOptionsResult privacyOptionsResult) {
            this.f2198a = privacyOptionsResult.basicPrivacyOptions;
            this.f2199b = privacyOptionsResult.friendListPrivacyOptions;
            this.f2200c = privacyOptionsResult.selectedPrivacyOption;
            this.f2201d = privacyOptionsResult.recentPrivacyOption;
            this.f2203f = privacyOptionsResult.isResultFromServer;
            if (privacyOptionsResult.isSelectedOptionExternal) {
                this.f2203f = false;
                com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
                int size = this.f2198a.size();
                for (int i = 0; i < size; i++) {
                    PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = (GraphQLPrivacyOption) this.f2198a.get(i);
                    if (PrivacyOptionHelper.m2349a(privacyOptionFieldsForComposer, this.f2200c)) {
                        this.f2202e = true;
                    } else {
                        builder.c(privacyOptionFieldsForComposer);
                    }
                }
                this.f2198a = builder.b();
            }
        }

        public final Builder m2380a(GraphQLPrivacyOption graphQLPrivacyOption) {
            Preconditions.checkArgument(PrivacyOptionsResultFactory.m2329a((PrivacyOptionFields) graphQLPrivacyOption));
            this.f2203f = false;
            if (PrivacyOptionHelper.m2350a(this.f2198a, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption) || PrivacyOptionHelper.m2350a(this.f2199b, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption)) {
                this.f2202e = false;
            } else {
                this.f2202e = true;
            }
            this.f2200c = graphQLPrivacyOption;
            return this;
        }

        public final Builder m2379a() {
            this.f2203f = false;
            return this;
        }

        public final PrivacyOptionsResult m2381b() {
            ImmutableList immutableList = this.f2198a;
            if (this.f2202e) {
                immutableList = ImmutableList.builder().b(this.f2198a).c(this.f2200c).b();
            }
            return new PrivacyOptionsResult(immutableList, this.f2199b, this.f2200c, this.f2201d, this.f2202e, this.f2203f);
        }
    }

    PrivacyOptionsResult() {
        this.basicPrivacyOptions = null;
        this.friendListPrivacyOptions = null;
        this.selectedPrivacyOption = null;
        this.isSelectedOptionExternal = false;
        this.recentPrivacyOption = null;
        this.isResultFromServer = false;
    }

    public PrivacyOptionsResult(ImmutableList<GraphQLPrivacyOption> immutableList, ImmutableList<GraphQLPrivacyOption> immutableList2, GraphQLPrivacyOption graphQLPrivacyOption, @Nullable GraphQLPrivacyOption graphQLPrivacyOption2, boolean z, boolean z2) {
        this.basicPrivacyOptions = immutableList;
        this.friendListPrivacyOptions = immutableList2;
        this.selectedPrivacyOption = m2340a(graphQLPrivacyOption);
        this.isSelectedOptionExternal = z;
        this.recentPrivacyOption = m2340a(graphQLPrivacyOption2);
        this.isResultFromServer = z2;
    }

    public PrivacyOptionsResult(Parcel parcel) {
        this.basicPrivacyOptions = ImmutableList.copyOf(parcel.readArrayList(GraphQLPrivacyOptionsContentEdge.class.getClassLoader()));
        this.friendListPrivacyOptions = ImmutableList.copyOf(parcel.readArrayList(GraphQLPrivacyOptionsContentEdge.class.getClassLoader()));
        this.selectedPrivacyOption = m2340a((GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel));
        this.isSelectedOptionExternal = ParcelUtil.a(parcel);
        this.recentPrivacyOption = m2340a((GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel));
        this.isResultFromServer = ParcelUtil.a(parcel);
    }

    public static Builder m2336a(PrivacyOptionsResult privacyOptionsResult) {
        return new Builder(privacyOptionsResult);
    }

    @JsonIgnore
    public final GraphQLPrivacyOption m2340a(@Nullable GraphQLPrivacyOption graphQLPrivacyOption) {
        int i;
        int i2 = 0;
        int size = this.basicPrivacyOptions.size();
        for (i = 0; i < size; i++) {
            PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = (GraphQLPrivacyOption) this.basicPrivacyOptions.get(i);
            if (PrivacyOptionHelper.m2349a(privacyOptionFieldsForComposer, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption)) {
                return privacyOptionFieldsForComposer;
            }
        }
        i = this.friendListPrivacyOptions.size();
        while (i2 < i) {
            privacyOptionFieldsForComposer = (GraphQLPrivacyOption) this.friendListPrivacyOptions.get(i2);
            if (PrivacyOptionHelper.m2349a(privacyOptionFieldsForComposer, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption)) {
                return privacyOptionFieldsForComposer;
            }
            i2++;
        }
        return null;
    }

    @JsonIgnore
    public final GraphQLPrivacyOption m2339a(GraphQLPrivacyOptionType graphQLPrivacyOptionType) {
        int i;
        int i2 = 0;
        int size = this.basicPrivacyOptions.size();
        for (i = 0; i < size; i++) {
            PrivacyOptionWithIconFields privacyOptionWithIconFields = (GraphQLPrivacyOption) this.basicPrivacyOptions.get(i);
            if (PrivacyOptionHelper.m2343a(privacyOptionWithIconFields) == graphQLPrivacyOptionType) {
                return privacyOptionWithIconFields;
            }
        }
        i = this.friendListPrivacyOptions.size();
        while (i2 < i) {
            privacyOptionWithIconFields = (GraphQLPrivacyOption) this.friendListPrivacyOptions.get(i2);
            if (PrivacyOptionHelper.m2343a(privacyOptionWithIconFields) == graphQLPrivacyOptionType) {
                return privacyOptionWithIconFields;
            }
            i2++;
        }
        return null;
    }

    @JsonIgnore
    public final GraphQLPrivacyOption m2337a() {
        GraphQLPrivacyOption graphQLPrivacyOption = null;
        int size = this.basicPrivacyOptions.size();
        int i = 0;
        while (i < size) {
            GraphQLPrivacyOption graphQLPrivacyOption2 = (GraphQLPrivacyOption) this.basicPrivacyOptions.get(i);
            if (PrivacyOptionHelper.m2343a((PrivacyOptionWithIconFields) graphQLPrivacyOption2) == GraphQLPrivacyOptionType.EVERYONE) {
                return graphQLPrivacyOption2;
            }
            if (PrivacyOptionHelper.m2343a((PrivacyOptionWithIconFields) graphQLPrivacyOption2) != GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS) {
                graphQLPrivacyOption2 = graphQLPrivacyOption;
            }
            i++;
            graphQLPrivacyOption = graphQLPrivacyOption2;
        }
        return graphQLPrivacyOption;
    }

    @JsonIgnore
    public final int m2341b(GraphQLPrivacyOption graphQLPrivacyOption) {
        int a = PrivacyOptionHelper.m2342a(this.basicPrivacyOptions, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption);
        if (a >= 0) {
            return a;
        }
        a = PrivacyOptionHelper.m2342a(this.friendListPrivacyOptions, (PrivacyOptionFieldsForComposer) graphQLPrivacyOption);
        if (a >= 0) {
            return a + this.basicPrivacyOptions.size();
        }
        return -1;
    }

    @JsonIgnore
    public final GraphQLPrivacyOption m2338a(int i) {
        if (i < this.basicPrivacyOptions.size()) {
            return (GraphQLPrivacyOption) this.basicPrivacyOptions.get(i);
        }
        if (i < this.basicPrivacyOptions.size() + this.friendListPrivacyOptions.size()) {
            return (GraphQLPrivacyOption) this.friendListPrivacyOptions.get(i - this.basicPrivacyOptions.size());
        }
        return null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.basicPrivacyOptions);
        parcel.writeList(this.friendListPrivacyOptions);
        FlatBufferModelHelper.a(parcel, this.selectedPrivacyOption);
        ParcelUtil.a(parcel, this.isSelectedOptionExternal);
        FlatBufferModelHelper.a(parcel, this.recentPrivacyOption);
        ParcelUtil.a(parcel, this.isResultFromServer);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrivacyOptionsResult)) {
            return false;
        }
        PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
        if (this.basicPrivacyOptions.size() != privacyOptionsResult.basicPrivacyOptions.size()) {
            return false;
        }
        int i;
        for (i = 0; i < this.basicPrivacyOptions.size(); i++) {
            if (!PrivacyOptionHelper.m2349a((PrivacyOptionFieldsForComposer) this.basicPrivacyOptions.get(i), (PrivacyOptionFieldsForComposer) privacyOptionsResult.basicPrivacyOptions.get(i))) {
                return false;
            }
        }
        if (this.friendListPrivacyOptions.size() != privacyOptionsResult.friendListPrivacyOptions.size()) {
            return false;
        }
        for (i = 0; i < this.friendListPrivacyOptions.size(); i++) {
            if (!PrivacyOptionHelper.m2349a((PrivacyOptionFieldsForComposer) this.friendListPrivacyOptions.get(i), (PrivacyOptionFieldsForComposer) privacyOptionsResult.friendListPrivacyOptions.get(i))) {
                return false;
            }
        }
        if (PrivacyOptionHelper.m2349a(this.selectedPrivacyOption, privacyOptionsResult.selectedPrivacyOption) && PrivacyOptionHelper.m2349a(this.recentPrivacyOption, privacyOptionsResult.recentPrivacyOption) && this.isSelectedOptionExternal == privacyOptionsResult.isSelectedOptionExternal && this.isResultFromServer == privacyOptionsResult.isResultFromServer) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.basicPrivacyOptions.size()), Integer.valueOf(this.friendListPrivacyOptions.size()), Boolean.valueOf(this.isSelectedOptionExternal), Boolean.valueOf(this.isResultFromServer)});
    }

    public final String toString() {
        return Objects.toStringHelper(PrivacyOptionsResult.class).add("basicPrivacyOptions", this.basicPrivacyOptions).add("friendListOptions", this.friendListPrivacyOptions).add("selectedPrivacyOption", this.selectedPrivacyOption).add("recentPrivacyOption", this.recentPrivacyOption).add("isSelectedOptionExternal", this.isSelectedOptionExternal).toString();
    }
}
