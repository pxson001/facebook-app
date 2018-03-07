package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLInterfaces.IsPopularObjectsStoryGraphQL;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.IsPopularObjectsStoryGraphQLParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.IsPopularObjectsStoryGraphQLParser.AttachmentsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class FeedStoryUtilGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 917622401)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
    public final class IsPopularObjectsStoryGraphQLModel extends BaseModel implements IsPopularObjectsStoryGraphQL, GraphQLVisitableConsistentModel {
        @Nullable
        private List<AttachmentsModel> f22497d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1317720611)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f22496d;

            /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m25094a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m25184b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attachmentsModel = new AttachmentsModel();
                    ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) attachmentsModel).a();
                    }
                    return attachmentsModel;
                }
            }

            /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m25095a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m25096a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m25182a(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            public AttachmentsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<GraphQLStoryAttachmentStyle> m25098a() {
                this.f22496d = super.c(this.f22496d, 0, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f22496d;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m25097a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25096a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int d = flatBufferBuilder.d(m25098a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, d);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(IsPopularObjectsStoryGraphQLModel.class, new Deserializer());
            }

            public Object m25099a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = IsPopularObjectsStoryGraphQLParser.m25185a(jsonParser);
                Object isPopularObjectsStoryGraphQLModel = new IsPopularObjectsStoryGraphQLModel();
                ((BaseModel) isPopularObjectsStoryGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (isPopularObjectsStoryGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) isPopularObjectsStoryGraphQLModel).a();
                }
                return isPopularObjectsStoryGraphQLModel;
            }
        }

        /* compiled from: TQUERY_CONSTRUCTION_PARAM; */
        public class Serializer extends JsonSerializer<IsPopularObjectsStoryGraphQLModel> {
            public final void m25100a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                IsPopularObjectsStoryGraphQLModel isPopularObjectsStoryGraphQLModel = (IsPopularObjectsStoryGraphQLModel) obj;
                if (isPopularObjectsStoryGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(isPopularObjectsStoryGraphQLModel.m25101a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    isPopularObjectsStoryGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = isPopularObjectsStoryGraphQLModel.w_();
                int u_ = isPopularObjectsStoryGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    AttachmentsParser.m25183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(IsPopularObjectsStoryGraphQLModel.class, new Serializer());
            }
        }

        public IsPopularObjectsStoryGraphQLModel() {
            super(1);
        }

        public final void m25103a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25104a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> m25105d() {
            this.f22497d = super.a(this.f22497d, 0, AttachmentsModel.class);
            return (ImmutableList) this.f22497d;
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m25102a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25105d() != null) {
                Builder a = ModelHelper.a(m25105d(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (IsPopularObjectsStoryGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22497d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25101a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25105d());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
