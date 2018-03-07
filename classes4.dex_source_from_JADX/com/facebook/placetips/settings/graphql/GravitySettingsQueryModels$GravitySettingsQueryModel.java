package com.facebook.placetips.settings.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -317827517)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: ringtone */
public final class GravitySettingsQueryModels$GravitySettingsQueryModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private GravitySettingsGraphQlFragmentModel f3331d;

    /* compiled from: ringtone */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GravitySettingsQueryModels$GravitySettingsQueryModel.class, new Deserializer());
        }

        public Object m3893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GravitySettingsQueryParsers$GravitySettingsQueryParser.m3894a(jsonParser);
            Object gravitySettingsQueryModels$GravitySettingsQueryModel = new GravitySettingsQueryModels$GravitySettingsQueryModel();
            ((BaseModel) gravitySettingsQueryModels$GravitySettingsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
            if (gravitySettingsQueryModels$GravitySettingsQueryModel instanceof Postprocessable) {
                return ((Postprocessable) gravitySettingsQueryModels$GravitySettingsQueryModel).a();
            }
            return gravitySettingsQueryModels$GravitySettingsQueryModel;
        }
    }

    public GravitySettingsQueryModels$GravitySettingsQueryModel() {
        super(1);
    }

    @Nullable
    public final GravitySettingsGraphQlFragmentModel m3563a() {
        this.f3331d = (GravitySettingsGraphQlFragmentModel) super.a(this.f3331d, 0, GravitySettingsGraphQlFragmentModel.class);
        return this.f3331d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m3562a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3563a() != null) {
            GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) graphQLModelMutatingVisitor.b(m3563a());
            if (m3563a() != gravitySettingsGraphQlFragmentModel) {
                graphQLVisitableModel = (GravitySettingsQueryModels$GravitySettingsQueryModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3331d = gravitySettingsGraphQlFragmentModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3561a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3563a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
