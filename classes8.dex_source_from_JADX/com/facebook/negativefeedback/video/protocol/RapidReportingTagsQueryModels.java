package com.facebook.negativefeedback.video.protocol;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryParsers.RapidReportingTagsQueryParser;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryParsers.RapidReportingTagsQueryParser.NegativeFeedbackPromptParser;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryParsers.RapidReportingTagsQueryParser.NegativeFeedbackPromptParser.TagsParser;
import com.facebook.negativefeedback.video.protocol.RapidReportingTagsQueryParsers.RapidReportingTagsQueryParser.NegativeFeedbackPromptParser.TagsParser.TitleParser;
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

/* compiled from: text_alignment */
public class RapidReportingTagsQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1432797931)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: text_alignment */
    public final class RapidReportingTagsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1639d;
        @Nullable
        private String f1640e;
        @Nullable
        private NegativeFeedbackPromptModel f1641f;

        /* compiled from: text_alignment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RapidReportingTagsQueryModel.class, new Deserializer());
            }

            public Object m1834a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RapidReportingTagsQueryParser.m1868a(jsonParser);
                Object rapidReportingTagsQueryModel = new RapidReportingTagsQueryModel();
                ((BaseModel) rapidReportingTagsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rapidReportingTagsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) rapidReportingTagsQueryModel).a();
                }
                return rapidReportingTagsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1959834817)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: text_alignment */
        public final class NegativeFeedbackPromptModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TagsModel> f1638d;

            /* compiled from: text_alignment */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NegativeFeedbackPromptModel.class, new Deserializer());
                }

                public Object m1835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NegativeFeedbackPromptParser.m1866a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object negativeFeedbackPromptModel = new NegativeFeedbackPromptModel();
                    ((BaseModel) negativeFeedbackPromptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (negativeFeedbackPromptModel instanceof Postprocessable) {
                        return ((Postprocessable) negativeFeedbackPromptModel).a();
                    }
                    return negativeFeedbackPromptModel;
                }
            }

            /* compiled from: text_alignment */
            public class Serializer extends JsonSerializer<NegativeFeedbackPromptModel> {
                public final void m1836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NegativeFeedbackPromptModel negativeFeedbackPromptModel = (NegativeFeedbackPromptModel) obj;
                    if (negativeFeedbackPromptModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(negativeFeedbackPromptModel.m1850a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        negativeFeedbackPromptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NegativeFeedbackPromptParser.m1867a(negativeFeedbackPromptModel.w_(), negativeFeedbackPromptModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NegativeFeedbackPromptModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -621153651)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: text_alignment */
            public final class TagsModel extends BaseModel implements GraphQLVisitableModel {
                private int f1635d;
                @Nullable
                private String f1636e;
                @Nullable
                private TitleModel f1637f;

                /* compiled from: text_alignment */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TagsModel.class, new Deserializer());
                    }

                    public Object m1837a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TagsParser.m1864b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object tagsModel = new TagsModel();
                        ((BaseModel) tagsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (tagsModel instanceof Postprocessable) {
                            return ((Postprocessable) tagsModel).a();
                        }
                        return tagsModel;
                    }
                }

                /* compiled from: text_alignment */
                public class Serializer extends JsonSerializer<TagsModel> {
                    public final void m1838a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TagsModel tagsModel = (TagsModel) obj;
                        if (tagsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(tagsModel.m1845a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            tagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TagsParser.m1865b(tagsModel.w_(), tagsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(TagsModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: text_alignment */
                public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1634d;

                    /* compiled from: text_alignment */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                        }

                        public Object m1839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TitleParser.m1862a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object titleModel = new TitleModel();
                            ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (titleModel instanceof Postprocessable) {
                                return ((Postprocessable) titleModel).a();
                            }
                            return titleModel;
                        }
                    }

                    /* compiled from: text_alignment */
                    public class Serializer extends JsonSerializer<TitleModel> {
                        public final void m1840a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TitleModel titleModel = (TitleModel) obj;
                            if (titleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(titleModel.m1841a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TitleParser.m1863a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TitleModel.class, new Serializer());
                        }
                    }

                    public TitleModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m1843a() {
                        this.f1634d = super.a(this.f1634d, 0);
                        return this.f1634d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m1842a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1841a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1843a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public TagsModel() {
                    super(3);
                }

                public final int m1844a() {
                    a(0, 0);
                    return this.f1635d;
                }

                @Nullable
                public final String m1848j() {
                    this.f1636e = super.a(this.f1636e, 1);
                    return this.f1636e;
                }

                @Nullable
                public final TitleModel m1849k() {
                    this.f1637f = (TitleModel) super.a(this.f1637f, 2, TitleModel.class);
                    return this.f1637f;
                }

                public final int jK_() {
                    return -1900408256;
                }

                public final GraphQLVisitableModel m1846a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1849k() != null) {
                        TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m1849k());
                        if (m1849k() != titleModel) {
                            graphQLVisitableModel = (TagsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1637f = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1845a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1848j());
                    int a = ModelHelper.a(flatBufferBuilder, m1849k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f1635d, 0);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m1847a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f1635d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            public NegativeFeedbackPromptModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<TagsModel> m1852a() {
                this.f1638d = super.a(this.f1638d, 0, TagsModel.class);
                return (ImmutableList) this.f1638d;
            }

            public final int jK_() {
                return 1098071294;
            }

            public final GraphQLVisitableModel m1851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1852a() != null) {
                    Builder a = ModelHelper.a(m1852a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NegativeFeedbackPromptModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1638d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1850a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1852a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: text_alignment */
        public class Serializer extends JsonSerializer<RapidReportingTagsQueryModel> {
            public final void m1853a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RapidReportingTagsQueryModel rapidReportingTagsQueryModel = (RapidReportingTagsQueryModel) obj;
                if (rapidReportingTagsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rapidReportingTagsQueryModel.m1856a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rapidReportingTagsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rapidReportingTagsQueryModel.w_();
                int u_ = rapidReportingTagsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("negative_feedback_prompt");
                    NegativeFeedbackPromptParser.m1867a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RapidReportingTagsQueryModel.class, new Serializer());
            }
        }

        public RapidReportingTagsQueryModel() {
            super(3);
        }

        public final void m1859a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1860a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1854k() {
            if (this.b != null && this.f1639d == null) {
                this.f1639d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1639d;
        }

        @Nullable
        private String m1855l() {
            this.f1640e = super.a(this.f1640e, 1);
            return this.f1640e;
        }

        @Nullable
        public final NegativeFeedbackPromptModel m1861j() {
            this.f1641f = (NegativeFeedbackPromptModel) super.a(this.f1641f, 2, NegativeFeedbackPromptModel.class);
            return this.f1641f;
        }

        @Nullable
        public final String m1858a() {
            return m1855l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m1857a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1861j() != null) {
                NegativeFeedbackPromptModel negativeFeedbackPromptModel = (NegativeFeedbackPromptModel) graphQLModelMutatingVisitor.b(m1861j());
                if (m1861j() != negativeFeedbackPromptModel) {
                    graphQLVisitableModel = (RapidReportingTagsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1641f = negativeFeedbackPromptModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1856a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1854k());
            int b = flatBufferBuilder.b(m1855l());
            int a2 = ModelHelper.a(flatBufferBuilder, m1861j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
