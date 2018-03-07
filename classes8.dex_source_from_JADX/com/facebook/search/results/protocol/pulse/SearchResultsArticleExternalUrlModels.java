package com.facebook.search.results.protocol.pulse;

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
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl.LinkMedia;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlInterfaces.SearchResultsArticleExternalUrl.Title;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.AllShareStoriesParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.InstantArticleParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.InstantArticleParser.LatestVersionParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.LinkMediaParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.LinkMediaParser.ImageParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.LinkMediaParser.PulseCoverPhotoParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.OpenGraphNodeParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.SourceParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.SummaryParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.TitleParser;
import com.facebook.search.results.protocol.pulse.SearchResultsArticleExternalUrlParsers.SearchResultsArticleExternalUrlParser.VideoShareParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: messageSpec */
public class SearchResultsArticleExternalUrlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -200149713)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: messageSpec */
    public final class SearchResultsArticleExternalUrlModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SearchResultsArticleExternalUrl {
        @Nullable
        private AllShareStoriesModel f8825d;
        private long f8826e;
        @Nullable
        private String f8827f;
        @Nullable
        private String f8828g;
        @Nullable
        private InstantArticleModel f8829h;
        @Nullable
        private LinkMediaModel f8830i;
        @Nullable
        private OpenGraphNodeModel f8831j;
        @Nullable
        private SourceModel f8832k;
        @Nullable
        private SummaryModel f8833l;
        @Nullable
        private TitleModel f8834m;
        @Nullable
        private String f8835n;
        @Nullable
        private VideoShareModel f8836o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class AllShareStoriesModel extends BaseModel implements GraphQLVisitableModel {
            private int f8801d;

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllShareStoriesModel.class, new Deserializer());
                }

                public Object m10417a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllShareStoriesParser.m10509a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allShareStoriesModel = new AllShareStoriesModel();
                    ((BaseModel) allShareStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allShareStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) allShareStoriesModel).a();
                    }
                    return allShareStoriesModel;
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<AllShareStoriesModel> {
                public final void m10418a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) obj;
                    if (allShareStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allShareStoriesModel.m10419a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allShareStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllShareStoriesParser.m10510a(allShareStoriesModel.w_(), allShareStoriesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AllShareStoriesModel.class, new Serializer());
                }
            }

            public AllShareStoriesModel() {
                super(1);
            }

            public final int jK_() {
                return -1051680685;
            }

            public final GraphQLVisitableModel m10420a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10419a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f8801d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10421a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8801d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: messageSpec */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsArticleExternalUrlModel.class, new Deserializer());
            }

            public Object m10422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsArticleExternalUrlParser.m10531a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsArticleExternalUrlModel = new SearchResultsArticleExternalUrlModel();
                ((BaseModel) searchResultsArticleExternalUrlModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsArticleExternalUrlModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsArticleExternalUrlModel).a();
                }
                return searchResultsArticleExternalUrlModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1370463646)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class InstantArticleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f8806d;
            @Nullable
            private LatestVersionModel f8807e;

            /* compiled from: messageSpec */
            public final class Builder {
                @Nullable
                public String f8802a;
                @Nullable
                public LatestVersionModel f8803b;
            }

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InstantArticleModel.class, new Deserializer());
                }

                public Object m10423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InstantArticleParser.m10513a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object instantArticleModel = new InstantArticleModel();
                    ((BaseModel) instantArticleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (instantArticleModel instanceof Postprocessable) {
                        return ((Postprocessable) instantArticleModel).a();
                    }
                    return instantArticleModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -602222693)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messageSpec */
            public final class LatestVersionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8805d;

                /* compiled from: messageSpec */
                public final class Builder {
                    @Nullable
                    public String f8804a;
                }

                /* compiled from: messageSpec */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LatestVersionModel.class, new Deserializer());
                    }

                    public Object m10424a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LatestVersionParser.m10511a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object latestVersionModel = new LatestVersionModel();
                        ((BaseModel) latestVersionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (latestVersionModel instanceof Postprocessable) {
                            return ((Postprocessable) latestVersionModel).a();
                        }
                        return latestVersionModel;
                    }
                }

                /* compiled from: messageSpec */
                public class Serializer extends JsonSerializer<LatestVersionModel> {
                    public final void m10425a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LatestVersionModel latestVersionModel = (LatestVersionModel) obj;
                        if (latestVersionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(latestVersionModel.m10427a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            latestVersionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LatestVersionParser.m10512a(latestVersionModel.w_(), latestVersionModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LatestVersionModel.class, new Serializer());
                    }
                }

                public LatestVersionModel() {
                    super(1);
                }

                public LatestVersionModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m10429a() {
                    this.f8805d = super.a(this.f8805d, 0);
                    return this.f8805d;
                }

                public static LatestVersionModel m10426a(LatestVersionModel latestVersionModel) {
                    if (latestVersionModel == null) {
                        return null;
                    }
                    if (latestVersionModel instanceof LatestVersionModel) {
                        return latestVersionModel;
                    }
                    Builder builder = new Builder();
                    builder.f8804a = latestVersionModel.m10429a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f8804a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new LatestVersionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 1619159843;
                }

                public final GraphQLVisitableModel m10428a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10427a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10429a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<InstantArticleModel> {
                public final void m10430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InstantArticleModel instantArticleModel = (InstantArticleModel) obj;
                    if (instantArticleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(instantArticleModel.m10433a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        instantArticleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InstantArticleParser.m10514a(instantArticleModel.w_(), instantArticleModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InstantArticleModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LatestVersionModel m10437c() {
                return m10432j();
            }

            public InstantArticleModel() {
                super(2);
            }

            public InstantArticleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10436b() {
                this.f8806d = super.a(this.f8806d, 0);
                return this.f8806d;
            }

            @Nullable
            private LatestVersionModel m10432j() {
                this.f8807e = (LatestVersionModel) super.a(this.f8807e, 1, LatestVersionModel.class);
                return this.f8807e;
            }

            public static InstantArticleModel m10431a(InstantArticleModel instantArticleModel) {
                if (instantArticleModel == null) {
                    return null;
                }
                if (instantArticleModel instanceof InstantArticleModel) {
                    return instantArticleModel;
                }
                Builder builder = new Builder();
                builder.f8802a = instantArticleModel.m10436b();
                builder.f8803b = LatestVersionModel.m10426a(instantArticleModel.m10437c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8802a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8803b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new InstantArticleModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m10435a() {
                return m10436b();
            }

            public final int jK_() {
                return 1607392245;
            }

            public final GraphQLVisitableModel m10434a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10432j() != null) {
                    LatestVersionModel latestVersionModel = (LatestVersionModel) graphQLModelMutatingVisitor.b(m10432j());
                    if (m10432j() != latestVersionModel) {
                        graphQLVisitableModel = (InstantArticleModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8807e = latestVersionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10433a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10436b());
                int a = ModelHelper.a(flatBufferBuilder, m10432j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2132161629)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class LinkMediaModel extends BaseModel implements GraphQLVisitableModel, LinkMedia {
            @Nullable
            private GraphQLObjectType f8811d;
            @Nullable
            private ImageModel f8812e;
            @Nullable
            private PulseCoverPhotoModel f8813f;

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LinkMediaModel.class, new Deserializer());
                }

                public Object m10438a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LinkMediaParser.m10519a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object linkMediaModel = new LinkMediaModel();
                    ((BaseModel) linkMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (linkMediaModel instanceof Postprocessable) {
                        return ((Postprocessable) linkMediaModel).a();
                    }
                    return linkMediaModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messageSpec */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8808d;

                /* compiled from: messageSpec */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m10439a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m10515a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageModel = new ImageModel();
                        ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageModel instanceof Postprocessable) {
                            return ((Postprocessable) imageModel).a();
                        }
                        return imageModel;
                    }
                }

                /* compiled from: messageSpec */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m10440a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m10442a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m10516a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                private String m10441a() {
                    this.f8808d = super.a(this.f8808d, 0);
                    return this.f8808d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m10443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10442a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10441a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: messageSpec */
            public final class PulseCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8810d;

                /* compiled from: messageSpec */
                public final class Builder {
                    @Nullable
                    public String f8809a;
                }

                /* compiled from: messageSpec */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PulseCoverPhotoModel.class, new Deserializer());
                    }

                    public Object m10444a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PulseCoverPhotoParser.m10517a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pulseCoverPhotoModel = new PulseCoverPhotoModel();
                        ((BaseModel) pulseCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pulseCoverPhotoModel instanceof Postprocessable) {
                            return ((Postprocessable) pulseCoverPhotoModel).a();
                        }
                        return pulseCoverPhotoModel;
                    }
                }

                /* compiled from: messageSpec */
                public class Serializer extends JsonSerializer<PulseCoverPhotoModel> {
                    public final void m10445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PulseCoverPhotoModel pulseCoverPhotoModel = (PulseCoverPhotoModel) obj;
                        if (pulseCoverPhotoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pulseCoverPhotoModel.m10447a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pulseCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PulseCoverPhotoParser.m10518a(pulseCoverPhotoModel.w_(), pulseCoverPhotoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PulseCoverPhotoModel.class, new Serializer());
                    }
                }

                public PulseCoverPhotoModel() {
                    super(1);
                }

                public PulseCoverPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m10449a() {
                    this.f8810d = super.a(this.f8810d, 0);
                    return this.f8810d;
                }

                public static PulseCoverPhotoModel m10446a(PulseCoverPhotoModel pulseCoverPhotoModel) {
                    if (pulseCoverPhotoModel == null) {
                        return null;
                    }
                    if (pulseCoverPhotoModel instanceof PulseCoverPhotoModel) {
                        return pulseCoverPhotoModel;
                    }
                    Builder builder = new Builder();
                    builder.f8809a = pulseCoverPhotoModel.m10449a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f8809a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PulseCoverPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m10448a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10447a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10449a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<LinkMediaModel> {
                public final void m10450a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LinkMediaModel linkMediaModel = (LinkMediaModel) obj;
                    if (linkMediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(linkMediaModel.m10454a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        linkMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LinkMediaParser.m10520a(linkMediaModel.w_(), linkMediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LinkMediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PulseCoverPhotoModel mo566c() {
                return m10453k();
            }

            public LinkMediaModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m10451a() {
                if (this.b != null && this.f8811d == null) {
                    this.f8811d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8811d;
            }

            @Nullable
            private ImageModel m10452j() {
                this.f8812e = (ImageModel) super.a(this.f8812e, 1, ImageModel.class);
                return this.f8812e;
            }

            @Nullable
            private PulseCoverPhotoModel m10453k() {
                this.f8813f = (PulseCoverPhotoModel) super.a(this.f8813f, 2, PulseCoverPhotoModel.class);
                return this.f8813f;
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m10455a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10452j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m10452j());
                    if (m10452j() != imageModel) {
                        graphQLVisitableModel = (LinkMediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8812e = imageModel;
                    }
                }
                if (m10453k() != null) {
                    PulseCoverPhotoModel pulseCoverPhotoModel = (PulseCoverPhotoModel) graphQLModelMutatingVisitor.b(m10453k());
                    if (m10453k() != pulseCoverPhotoModel) {
                        graphQLVisitableModel = (LinkMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8813f = pulseCoverPhotoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10454a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10451a());
                int a2 = ModelHelper.a(flatBufferBuilder, m10452j());
                int a3 = ModelHelper.a(flatBufferBuilder, m10453k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 370399820)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class OpenGraphNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8817d;
            @Nullable
            private String f8818e;
            @Nullable
            private GraphQLSavedState f8819f;

            /* compiled from: messageSpec */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8814a;
                @Nullable
                public String f8815b;
                @Nullable
                public GraphQLSavedState f8816c;

                public final OpenGraphNodeModel m10457a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8814a);
                    int b = flatBufferBuilder.b(this.f8815b);
                    int a2 = flatBufferBuilder.a(this.f8816c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new OpenGraphNodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OpenGraphNodeModel.class, new Deserializer());
                }

                public Object m10458a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OpenGraphNodeParser.m10521a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object openGraphNodeModel = new OpenGraphNodeModel();
                    ((BaseModel) openGraphNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (openGraphNodeModel instanceof Postprocessable) {
                        return ((Postprocessable) openGraphNodeModel).a();
                    }
                    return openGraphNodeModel;
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<OpenGraphNodeModel> {
                public final void m10459a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) obj;
                    if (openGraphNodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(openGraphNodeModel.m10462a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        openGraphNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OpenGraphNodeParser.m10522a(openGraphNodeModel.w_(), openGraphNodeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OpenGraphNodeModel.class, new Serializer());
                }
            }

            public OpenGraphNodeModel() {
                super(3);
            }

            public OpenGraphNodeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m10465a(String str, ConsistencyTuple consistencyTuple) {
                if ("viewer_saved_state".equals(str)) {
                    consistencyTuple.a = m10469d();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m10466a(String str, Object obj, boolean z) {
                if ("viewer_saved_state".equals(str)) {
                    m10461a((GraphQLSavedState) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType m10467b() {
                if (this.b != null && this.f8817d == null) {
                    this.f8817d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8817d;
            }

            @Nullable
            public final String m10468c() {
                this.f8818e = super.a(this.f8818e, 1);
                return this.f8818e;
            }

            @Nullable
            public final GraphQLSavedState m10469d() {
                this.f8819f = (GraphQLSavedState) super.b(this.f8819f, 2, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8819f;
            }

            private void m10461a(GraphQLSavedState graphQLSavedState) {
                this.f8819f = graphQLSavedState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLSavedState != null ? graphQLSavedState.name() : null);
                }
            }

            public static OpenGraphNodeModel m10460a(OpenGraphNodeModel openGraphNodeModel) {
                if (openGraphNodeModel == null) {
                    return null;
                }
                if (openGraphNodeModel instanceof OpenGraphNodeModel) {
                    return openGraphNodeModel;
                }
                Builder builder = new Builder();
                builder.f8814a = openGraphNodeModel.m10467b();
                builder.f8815b = openGraphNodeModel.m10468c();
                builder.f8816c = openGraphNodeModel.m10469d();
                return builder.m10457a();
            }

            @Nullable
            public final String m10464a() {
                return m10468c();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m10463a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10462a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10467b());
                int b = flatBufferBuilder.b(m10468c());
                int a2 = flatBufferBuilder.a(m10469d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: messageSpec */
        public class Serializer extends JsonSerializer<SearchResultsArticleExternalUrlModel> {
            public final void m10470a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsArticleExternalUrlModel searchResultsArticleExternalUrlModel = (SearchResultsArticleExternalUrlModel) obj;
                if (searchResultsArticleExternalUrlModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsArticleExternalUrlModel.m10504a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsArticleExternalUrlModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsArticleExternalUrlParser.m10532a(searchResultsArticleExternalUrlModel.w_(), searchResultsArticleExternalUrlModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsArticleExternalUrlModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class SourceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8820d;

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SourceModel.class, new Deserializer());
                }

                public Object m10471a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SourceParser.m10523a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sourceModel = new SourceModel();
                    ((BaseModel) sourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sourceModel instanceof Postprocessable) {
                        return ((Postprocessable) sourceModel).a();
                    }
                    return sourceModel;
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<SourceModel> {
                public final void m10472a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SourceModel sourceModel = (SourceModel) obj;
                    if (sourceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sourceModel.m10474a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SourceParser.m10524a(sourceModel.w_(), sourceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SourceModel.class, new Serializer());
                }
            }

            public SourceModel() {
                super(1);
            }

            @Nullable
            private String m10473a() {
                this.f8820d = super.a(this.f8820d, 0);
                return this.f8820d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10474a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10473a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class SummaryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8822d;

            /* compiled from: messageSpec */
            public final class Builder {
                @Nullable
                public String f8821a;
            }

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SummaryModel.class, new Deserializer());
                }

                public Object m10476a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SummaryParser.m10525a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object summaryModel = new SummaryModel();
                    ((BaseModel) summaryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (summaryModel instanceof Postprocessable) {
                        return ((Postprocessable) summaryModel).a();
                    }
                    return summaryModel;
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<SummaryModel> {
                public final void m10477a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SummaryModel summaryModel = (SummaryModel) obj;
                    if (summaryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(summaryModel.m10479a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        summaryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SummaryParser.m10526a(summaryModel.w_(), summaryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SummaryModel.class, new Serializer());
                }
            }

            public SummaryModel() {
                super(1);
            }

            public SummaryModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10481a() {
                this.f8822d = super.a(this.f8822d, 0);
                return this.f8822d;
            }

            public static SummaryModel m10478a(SummaryModel summaryModel) {
                if (summaryModel == null) {
                    return null;
                }
                if (summaryModel instanceof SummaryModel) {
                    return summaryModel;
                }
                Builder builder = new Builder();
                builder.f8821a = summaryModel.m10481a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8821a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SummaryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10480a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10479a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10481a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel, Title {
            @Nullable
            private String f8823d;

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m10482a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m10527a(jsonParser, flatBufferBuilder));
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

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m10483a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m10484a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m10528a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String mo568a() {
                this.f8823d = super.a(this.f8823d, 0);
                return this.f8823d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10485a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10484a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo568a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 417346557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: messageSpec */
        public final class VideoShareModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8824d;

            /* compiled from: messageSpec */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoShareModel.class, new Deserializer());
                }

                public Object m10487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoShareParser.m10529a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoShareModel = new VideoShareModel();
                    ((BaseModel) videoShareModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoShareModel instanceof Postprocessable) {
                        return ((Postprocessable) videoShareModel).a();
                    }
                    return videoShareModel;
                }
            }

            /* compiled from: messageSpec */
            public class Serializer extends JsonSerializer<VideoShareModel> {
                public final void m10488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoShareModel videoShareModel = (VideoShareModel) obj;
                    if (videoShareModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoShareModel.m10490a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoShareModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoShareParser.m10530a(videoShareModel.w_(), videoShareModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoShareModel.class, new Serializer());
                }
            }

            public VideoShareModel() {
                super(1);
            }

            @Nullable
            private String m10489a() {
                this.f8824d = super.a(this.f8824d, 0);
                return this.f8824d;
            }

            public final int jK_() {
                return 364166212;
            }

            public final GraphQLVisitableModel m10491a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10490a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10489a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ OpenGraphNodeModel mo574E() {
            return m10496n();
        }

        @Nullable
        public final /* synthetic */ SummaryModel mo579T() {
            return m10498p();
        }

        @Nullable
        public final /* synthetic */ Title ax() {
            return m10499q();
        }

        @Nullable
        public final /* synthetic */ LinkMedia ay() {
            return m10495m();
        }

        public SearchResultsArticleExternalUrlModel() {
            super(12);
        }

        @Nullable
        private AllShareStoriesModel m10492j() {
            this.f8825d = (AllShareStoriesModel) super.a(this.f8825d, 0, AllShareStoriesModel.class);
            return this.f8825d;
        }

        @Nullable
        public final String mo593v() {
            this.f8827f = super.a(this.f8827f, 2);
            return this.f8827f;
        }

        @Nullable
        private String m10493k() {
            this.f8828g = super.a(this.f8828g, 3);
            return this.f8828g;
        }

        @Nullable
        private InstantArticleModel m10494l() {
            this.f8829h = (InstantArticleModel) super.a(this.f8829h, 4, InstantArticleModel.class);
            return this.f8829h;
        }

        @Nullable
        private LinkMediaModel m10495m() {
            this.f8830i = (LinkMediaModel) super.a(this.f8830i, 5, LinkMediaModel.class);
            return this.f8830i;
        }

        @Nullable
        private OpenGraphNodeModel m10496n() {
            this.f8831j = (OpenGraphNodeModel) super.a(this.f8831j, 6, OpenGraphNodeModel.class);
            return this.f8831j;
        }

        @Nullable
        private SourceModel m10497o() {
            this.f8832k = (SourceModel) super.a(this.f8832k, 7, SourceModel.class);
            return this.f8832k;
        }

        @Nullable
        private SummaryModel m10498p() {
            this.f8833l = (SummaryModel) super.a(this.f8833l, 8, SummaryModel.class);
            return this.f8833l;
        }

        @Nullable
        private TitleModel m10499q() {
            this.f8834m = (TitleModel) super.a(this.f8834m, 9, TitleModel.class);
            return this.f8834m;
        }

        @Nullable
        private String m10500r() {
            this.f8835n = super.a(this.f8835n, 10);
            return this.f8835n;
        }

        @Nullable
        private VideoShareModel m10501s() {
            this.f8836o = (VideoShareModel) super.a(this.f8836o, 11, VideoShareModel.class);
            return this.f8836o;
        }

        @Nullable
        public final String m10506a() {
            return m10493k();
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m10505a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10492j() != null) {
                AllShareStoriesModel allShareStoriesModel = (AllShareStoriesModel) graphQLModelMutatingVisitor.b(m10492j());
                if (m10492j() != allShareStoriesModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8825d = allShareStoriesModel;
                }
            }
            if (m10494l() != null) {
                InstantArticleModel instantArticleModel = (InstantArticleModel) graphQLModelMutatingVisitor.b(m10494l());
                if (m10494l() != instantArticleModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8829h = instantArticleModel;
                }
            }
            if (m10495m() != null) {
                LinkMediaModel linkMediaModel = (LinkMediaModel) graphQLModelMutatingVisitor.b(m10495m());
                if (m10495m() != linkMediaModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8830i = linkMediaModel;
                }
            }
            if (m10496n() != null) {
                OpenGraphNodeModel openGraphNodeModel = (OpenGraphNodeModel) graphQLModelMutatingVisitor.b(m10496n());
                if (m10496n() != openGraphNodeModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8831j = openGraphNodeModel;
                }
            }
            if (m10497o() != null) {
                SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m10497o());
                if (m10497o() != sourceModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8832k = sourceModel;
                }
            }
            if (m10498p() != null) {
                SummaryModel summaryModel = (SummaryModel) graphQLModelMutatingVisitor.b(m10498p());
                if (m10498p() != summaryModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8833l = summaryModel;
                }
            }
            if (m10499q() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m10499q());
                if (m10499q() != titleModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8834m = titleModel;
                }
            }
            if (m10501s() != null) {
                VideoShareModel videoShareModel = (VideoShareModel) graphQLModelMutatingVisitor.b(m10501s());
                if (m10501s() != videoShareModel) {
                    graphQLVisitableModel = (SearchResultsArticleExternalUrlModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8836o = videoShareModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10504a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10492j());
            int b = flatBufferBuilder.b(mo593v());
            int b2 = flatBufferBuilder.b(m10493k());
            int a2 = ModelHelper.a(flatBufferBuilder, m10494l());
            int a3 = ModelHelper.a(flatBufferBuilder, m10495m());
            int a4 = ModelHelper.a(flatBufferBuilder, m10496n());
            int a5 = ModelHelper.a(flatBufferBuilder, m10497o());
            int a6 = ModelHelper.a(flatBufferBuilder, m10498p());
            int a7 = ModelHelper.a(flatBufferBuilder, m10499q());
            int b3 = flatBufferBuilder.b(m10500r());
            int a8 = ModelHelper.a(flatBufferBuilder, m10501s());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f8826e, 0);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10507a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8826e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}
