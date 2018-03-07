package com.facebook.api.graphql.ctamessagesend;

import com.facebook.api.graphql.ctamessagesend.CtaMessageSend2MutationParsers.CtaMessageSendMutation2Parser;
import com.facebook.api.graphql.ctamessagesend.CtaMessageSend2MutationParsers.CtaMessageSendMutation2Parser.PageParser;
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
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsParsers.VideoHomeBadgeSubParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_home_visit_data */
public class CtaMessageSend2MutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2133075758)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_home_visit_data */
    public final class CtaMessageSendMutation2Model extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageModel f563d;

        /* compiled from: video_home_visit_data */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CtaMessageSendMutation2Model.class, new Deserializer());
            }

            public Object m577a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CtaMessageSendMutation2Parser.m591a(jsonParser);
                Object ctaMessageSendMutation2Model = new CtaMessageSendMutation2Model();
                ((BaseModel) ctaMessageSendMutation2Model).a(a, FlatBuffer.a(a.a), jsonParser);
                if (ctaMessageSendMutation2Model instanceof Postprocessable) {
                    return ((Postprocessable) ctaMessageSendMutation2Model).a();
                }
                return ctaMessageSendMutation2Model;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_home_visit_data */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f562d;

            /* compiled from: video_home_visit_data */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m590a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: video_home_visit_data */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m581a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoHomeBadgeSubParser.m19762a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m584a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m585a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m580j() {
                this.f562d = super.a(this.f562d, 0);
                return this.f562d;
            }

            @Nullable
            public final String m583a() {
                return m580j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m582a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m581a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m580j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_home_visit_data */
        public class Serializer extends JsonSerializer<CtaMessageSendMutation2Model> {
            public final void m586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CtaMessageSendMutation2Model ctaMessageSendMutation2Model = (CtaMessageSendMutation2Model) obj;
                if (ctaMessageSendMutation2Model.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ctaMessageSendMutation2Model.m588a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    ctaMessageSendMutation2Model.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = ctaMessageSendMutation2Model.w_();
                int u_ = ctaMessageSendMutation2Model.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    VideoHomeBadgeSubParser.m19762a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CtaMessageSendMutation2Model.class, new Serializer());
            }
        }

        public CtaMessageSendMutation2Model() {
            super(1);
        }

        @Nullable
        private PageModel m587a() {
            this.f563d = (PageModel) super.a(this.f563d, 0, PageModel.class);
            return this.f563d;
        }

        public final int jK_() {
            return -1339667593;
        }

        public final GraphQLVisitableModel m589a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m587a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m587a());
                if (m587a() != pageModel) {
                    graphQLVisitableModel = (CtaMessageSendMutation2Model) ModelHelper.a(null, this);
                    graphQLVisitableModel.f563d = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m588a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m587a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
