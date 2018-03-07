package com.facebook.privacy.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.AudienceInfoFieldsForLoginModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1965203321)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sms_in_readonly_mode */
public final class FetchAudienceInfoModels$FetchAudienceInfoForLoginModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private AudienceInfoFieldsForLoginModel f2108d;

    public FetchAudienceInfoModels$FetchAudienceInfoForLoginModel() {
        super(1);
    }

    @Nullable
    private AudienceInfoFieldsForLoginModel m2204a() {
        this.f2108d = (AudienceInfoFieldsForLoginModel) super.a(this.f2108d, 0, AudienceInfoFieldsForLoginModel.class);
        return this.f2108d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m2206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2204a() != null) {
            AudienceInfoFieldsForLoginModel audienceInfoFieldsForLoginModel = (AudienceInfoFieldsForLoginModel) graphQLModelMutatingVisitor.b(m2204a());
            if (m2204a() != audienceInfoFieldsForLoginModel) {
                graphQLVisitableModel = (FetchAudienceInfoModels$FetchAudienceInfoForLoginModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f2108d = audienceInfoFieldsForLoginModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m2205a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2204a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
