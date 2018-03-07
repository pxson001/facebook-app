package com.facebook.productionprompts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesEntityFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.Builder;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: standalone */
public final class PromptDisplayReason implements Parcelable {
    public static final Creator<PromptDisplayReason> CREATOR = new C02641();
    @JsonProperty("reason_with_entities")
    public final DefaultTextWithEntitiesLongFieldsModel textWithEntities;

    /* compiled from: standalone */
    final class C02641 implements Creator<PromptDisplayReason> {
        C02641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PromptDisplayReason(parcel);
        }

        public final Object[] newArray(int i) {
            return new PromptDisplayReason[i];
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.textWithEntities);
    }

    public final String m6343b() {
        return this.textWithEntities == null ? null : this.textWithEntities.a();
    }

    private int m6339c() {
        return this.textWithEntities == null ? 0 : m6342f().c();
    }

    private int m6340d() {
        return this.textWithEntities == null ? 0 : m6342f().b();
    }

    private String m6341e() {
        return this.textWithEntities == null ? null : m6342f().j().D_();
    }

    private RangesModel m6342f() {
        return (RangesModel) this.textWithEntities.b().get(0);
    }

    public PromptDisplayReason() {
        this.textWithEntities = null;
    }

    public PromptDisplayReason(DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel) {
        if (defaultTextWithEntitiesLongFieldsModel == null) {
            this.textWithEntities = null;
            return;
        }
        DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel2;
        RangesModel rangesModel = (RangesModel) defaultTextWithEntitiesLongFieldsModel.b().get(0);
        String a = defaultTextWithEntitiesLongFieldsModel.a();
        int c = rangesModel.c();
        int b = rangesModel.b();
        DefaultTextWithEntitiesEntityFieldsModel j = rangesModel.j();
        String a2 = new GraphQLLinkExtractor().a(j.b(), j.d());
        if (a == null) {
            defaultTextWithEntitiesLongFieldsModel2 = null;
        } else {
            Builder builder = new Builder();
            builder.b = a;
            builder = builder;
            RangesModel.Builder builder2 = new RangesModel.Builder();
            builder2.c = c;
            builder2 = builder2;
            builder2.b = b;
            builder2 = builder2;
            DefaultTextWithEntitiesEntityFieldsModel.Builder builder3 = new DefaultTextWithEntitiesEntityFieldsModel.Builder();
            builder3.f = a2;
            builder2.a = builder3.a();
            builder.a = ImmutableList.of(builder2.a());
            defaultTextWithEntitiesLongFieldsModel2 = builder.a();
        }
        this.textWithEntities = defaultTextWithEntitiesLongFieldsModel2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PromptDisplayReason)) {
            return false;
        }
        PromptDisplayReason promptDisplayReason = (PromptDisplayReason) obj;
        if (Objects.equal(m6343b(), promptDisplayReason.m6343b()) && Objects.equal(Integer.valueOf(m6339c()), Integer.valueOf(promptDisplayReason.m6339c())) && Objects.equal(Integer.valueOf(m6340d()), Integer.valueOf(promptDisplayReason.m6340d())) && Objects.equal(m6341e(), promptDisplayReason.m6341e())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.textWithEntities});
    }

    public final int describeContents() {
        return 0;
    }

    public PromptDisplayReason(Parcel parcel) {
        this.textWithEntities = (DefaultTextWithEntitiesLongFieldsModel) FlatBufferModelHelper.a(parcel);
    }
}
