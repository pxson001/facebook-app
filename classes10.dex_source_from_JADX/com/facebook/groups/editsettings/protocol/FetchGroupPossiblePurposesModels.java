package com.facebook.groups.editsettings.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.editsettings.protocol.FetchGroupPossiblePurposesParsers.FetchGroupPossiblePurposesParser;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentModels.GroupPurposeModel;
import com.facebook.groups.editsettings.protocol.GroupPurposeFragmentParsers.GroupPurposeParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: Unable to process the whole batch of deltas at once. */
public class FetchGroupPossiblePurposesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1663102304)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unable to process the whole batch of deltas at once. */
    public final class FetchGroupPossiblePurposesModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<GroupPurposeModel> f21692d;

        /* compiled from: Unable to process the whole batch of deltas at once. */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupPossiblePurposesModel.class, new Deserializer());
            }

            public Object m22689a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupPossiblePurposesParser.m22696a(jsonParser);
                Object fetchGroupPossiblePurposesModel = new FetchGroupPossiblePurposesModel();
                ((BaseModel) fetchGroupPossiblePurposesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupPossiblePurposesModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupPossiblePurposesModel).a();
                }
                return fetchGroupPossiblePurposesModel;
            }
        }

        /* compiled from: Unable to process the whole batch of deltas at once. */
        public class Serializer extends JsonSerializer<FetchGroupPossiblePurposesModel> {
            public final void m22690a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupPossiblePurposesModel fetchGroupPossiblePurposesModel = (FetchGroupPossiblePurposesModel) obj;
                if (fetchGroupPossiblePurposesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupPossiblePurposesModel.m22691a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupPossiblePurposesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupPossiblePurposesModel.w_();
                int u_ = fetchGroupPossiblePurposesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("possible_purposes");
                    GroupPurposeParser.m22870a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupPossiblePurposesModel.class, new Serializer());
            }
        }

        public FetchGroupPossiblePurposesModel() {
            super(1);
        }

        public final void m22694a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m22695a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<GroupPurposeModel> m22693a() {
            this.f21692d = super.a(this.f21692d, 0, GroupPurposeModel.class);
            return (ImmutableList) this.f21692d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m22692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22693a() != null) {
                Builder a = ModelHelper.a(m22693a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchGroupPossiblePurposesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21692d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22691a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22693a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
