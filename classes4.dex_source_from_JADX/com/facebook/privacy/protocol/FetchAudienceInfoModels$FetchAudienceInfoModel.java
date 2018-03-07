package com.facebook.privacy.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -2011861491)
@JsonSerialize(using = Serializer.class)
/* compiled from: sms_in_readonly_mode */
public final class FetchAudienceInfoModels$FetchAudienceInfoModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private FetchAudienceInfoModels$AudienceInfoFieldsModel f2124d;

    /* compiled from: sms_in_readonly_mode */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(FetchAudienceInfoModels$FetchAudienceInfoModel.class, new Deserializer());
        }

        public Object m2227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = FetchAudienceInfoParsers$FetchAudienceInfoParser.m2228a(jsonParser);
            Object fetchAudienceInfoModels$FetchAudienceInfoModel = new FetchAudienceInfoModels$FetchAudienceInfoModel();
            ((BaseModel) fetchAudienceInfoModels$FetchAudienceInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
            if (fetchAudienceInfoModels$FetchAudienceInfoModel instanceof Postprocessable) {
                return ((Postprocessable) fetchAudienceInfoModels$FetchAudienceInfoModel).a();
            }
            return fetchAudienceInfoModels$FetchAudienceInfoModel;
        }
    }

    public FetchAudienceInfoModels$FetchAudienceInfoModel() {
        super(1);
    }

    @Nullable
    public final FetchAudienceInfoModels$AudienceInfoFieldsModel m2226a() {
        this.f2124d = (FetchAudienceInfoModels$AudienceInfoFieldsModel) super.a(this.f2124d, 0, FetchAudienceInfoModels$AudienceInfoFieldsModel.class);
        return this.f2124d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m2225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2226a() != null) {
            FetchAudienceInfoModels$AudienceInfoFieldsModel fetchAudienceInfoModels$AudienceInfoFieldsModel = (FetchAudienceInfoModels$AudienceInfoFieldsModel) graphQLModelMutatingVisitor.b(m2226a());
            if (m2226a() != fetchAudienceInfoModels$AudienceInfoFieldsModel) {
                graphQLVisitableModel = (FetchAudienceInfoModels$FetchAudienceInfoModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f2124d = fetchAudienceInfoModels$AudienceInfoFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m2224a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2226a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
