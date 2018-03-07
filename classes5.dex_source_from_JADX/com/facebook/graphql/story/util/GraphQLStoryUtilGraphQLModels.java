package com.facebook.graphql.story.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces.HasFeedbackTargetOfTypeGraphQL;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.HasFeedbackTargetOfTypeGraphQLParser;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLParsers.HasFeedbackTargetOfTypeGraphQLParser.TargetParser;
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

/* compiled from: TRIGHT;TKEY;>; */
public class GraphQLStoryUtilGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -469530242)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TRIGHT;TKEY;>; */
    public final class HasFeedbackTargetOfTypeGraphQLModel extends BaseModel implements HasFeedbackTargetOfTypeGraphQL, GraphQLVisitableModel {
        @Nullable
        private TargetModel f13504d;

        /* compiled from: TRIGHT;TKEY;>; */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HasFeedbackTargetOfTypeGraphQLModel.class, new Deserializer());
            }

            public Object m22651a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = HasFeedbackTargetOfTypeGraphQLParser.m22698a(jsonParser);
                Object hasFeedbackTargetOfTypeGraphQLModel = new HasFeedbackTargetOfTypeGraphQLModel();
                ((BaseModel) hasFeedbackTargetOfTypeGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (hasFeedbackTargetOfTypeGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) hasFeedbackTargetOfTypeGraphQLModel).a();
                }
                return hasFeedbackTargetOfTypeGraphQLModel;
            }
        }

        /* compiled from: TRIGHT;TKEY;>; */
        public class Serializer extends JsonSerializer<HasFeedbackTargetOfTypeGraphQLModel> {
            public final void m22652a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                HasFeedbackTargetOfTypeGraphQLModel hasFeedbackTargetOfTypeGraphQLModel = (HasFeedbackTargetOfTypeGraphQLModel) obj;
                if (hasFeedbackTargetOfTypeGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(hasFeedbackTargetOfTypeGraphQLModel.m22663a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    hasFeedbackTargetOfTypeGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = hasFeedbackTargetOfTypeGraphQLModel.w_();
                int u_ = hasFeedbackTargetOfTypeGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("target");
                    TargetParser.m22697a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(HasFeedbackTargetOfTypeGraphQLModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TRIGHT;TKEY;>; */
        public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f13502d;
            @Nullable
            private String f13503e;

            /* compiled from: TRIGHT;TKEY;>; */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                }

                public Object m22653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TargetParser.m22696a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object targetModel = new TargetModel();
                    ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (targetModel instanceof Postprocessable) {
                        return ((Postprocessable) targetModel).a();
                    }
                    return targetModel;
                }
            }

            /* compiled from: TRIGHT;TKEY;>; */
            public class Serializer extends JsonSerializer<TargetModel> {
                public final void m22654a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TargetModel targetModel = (TargetModel) obj;
                    if (targetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(targetModel.m22656a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TargetParser.m22697a(targetModel.w_(), targetModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TargetModel.class, new Serializer());
                }
            }

            public TargetModel() {
                super(2);
            }

            public final void m22659a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m22660a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m22661b() {
                if (this.b != null && this.f13502d == null) {
                    this.f13502d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13502d;
            }

            @Nullable
            private String m22655j() {
                this.f13503e = super.a(this.f13503e, 1);
                return this.f13503e;
            }

            @Nullable
            public final String m22658a() {
                return m22655j();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m22657a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m22656a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m22661b());
                int b = flatBufferBuilder.b(m22655j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ TargetModel mo1234a() {
            return m22662j();
        }

        public HasFeedbackTargetOfTypeGraphQLModel() {
            super(1);
        }

        public HasFeedbackTargetOfTypeGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private TargetModel m22662j() {
            this.f13504d = (TargetModel) super.a(this.f13504d, 0, TargetModel.class);
            return this.f13504d;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m22665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22662j() != null) {
                TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m22662j());
                if (m22662j() != targetModel) {
                    graphQLVisitableModel = (HasFeedbackTargetOfTypeGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13504d = targetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22663a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22662j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
