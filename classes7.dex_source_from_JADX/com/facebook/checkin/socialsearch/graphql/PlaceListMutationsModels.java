package com.facebook.checkin.socialsearch.graphql;

import com.facebook.checkin.socialsearch.graphql.PlaceListMutationsParsers.ConvertToPlaceListStoryMutationCallParser;
import com.facebook.checkin.socialsearch.graphql.PlaceListMutationsParsers.ConvertToPlaceListStoryMutationCallParser.StoryParser;
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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: unit_name */
public class PlaceListMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -6132403)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unit_name */
    public final class ConvertToPlaceListStoryMutationCallModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StoryModel f1102d;

        /* compiled from: unit_name */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConvertToPlaceListStoryMutationCallModel.class, new Deserializer());
            }

            public Object m1072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ConvertToPlaceListStoryMutationCallParser.m1087a(jsonParser);
                Object convertToPlaceListStoryMutationCallModel = new ConvertToPlaceListStoryMutationCallModel();
                ((BaseModel) convertToPlaceListStoryMutationCallModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (convertToPlaceListStoryMutationCallModel instanceof Postprocessable) {
                    return ((Postprocessable) convertToPlaceListStoryMutationCallModel).a();
                }
                return convertToPlaceListStoryMutationCallModel;
            }
        }

        /* compiled from: unit_name */
        public class Serializer extends JsonSerializer<ConvertToPlaceListStoryMutationCallModel> {
            public final void m1073a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ConvertToPlaceListStoryMutationCallModel convertToPlaceListStoryMutationCallModel = (ConvertToPlaceListStoryMutationCallModel) obj;
                if (convertToPlaceListStoryMutationCallModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(convertToPlaceListStoryMutationCallModel.m1082a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    convertToPlaceListStoryMutationCallModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = convertToPlaceListStoryMutationCallModel.w_();
                int u_ = convertToPlaceListStoryMutationCallModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("story");
                    StoryParser.m1086a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ConvertToPlaceListStoryMutationCallModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: unit_name */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1101d;

            /* compiled from: unit_name */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m1074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m1085a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyModel = new StoryModel();
                    ((BaseModel) storyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyModel instanceof Postprocessable) {
                        return ((Postprocessable) storyModel).a();
                    }
                    return storyModel;
                }
            }

            /* compiled from: unit_name */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m1075a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m1077a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m1086a(storyModel.w_(), storyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(1);
            }

            public final void m1080a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1081a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1076j() {
                this.f1101d = super.a(this.f1101d, 0);
                return this.f1101d;
            }

            @Nullable
            public final String m1079a() {
                return m1076j();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m1078a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1077a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1076j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ConvertToPlaceListStoryMutationCallModel() {
            super(1);
        }

        @Nullable
        public final StoryModel m1083a() {
            this.f1102d = (StoryModel) super.a(this.f1102d, 0, StoryModel.class);
            return this.f1102d;
        }

        public final int jK_() {
            return 2061121002;
        }

        public final GraphQLVisitableModel m1084a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1083a() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m1083a());
                if (m1083a() != storyModel) {
                    graphQLVisitableModel = (ConvertToPlaceListStoryMutationCallModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1102d = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1082a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1083a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
