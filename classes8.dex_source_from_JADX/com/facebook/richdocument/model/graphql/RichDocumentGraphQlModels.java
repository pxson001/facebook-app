package com.facebook.richdocument.model.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLCapitalizationStyle;
import com.facebook.graphql.enums.GraphQLComposedBlockType;
import com.facebook.graphql.enums.GraphQLComposedEntityType;
import com.facebook.graphql.enums.GraphQLDocumentAuthorStyle;
import com.facebook.graphql.enums.GraphQLDocumentDateStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.enums.GraphQLInlineStyle;
import com.facebook.graphql.enums.GraphQLInstantArticlePublishStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTextAnnotationHorizontalPosition;
import com.facebook.graphql.enums.GraphQLTextAnnotationPresentationStyle;
import com.facebook.graphql.enums.GraphQLTextAnnotationVerticalPosition;
import com.facebook.graphql.enums.GraphQLUnderlineStyle;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBMessengerSubscriptionInfo;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPage;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentAuthors;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentBodyElements;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentFontResource;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentListItems;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentMaster;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentNestedListItem;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentNestedListItemFields;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentPhoto;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentRelatedArticles;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentSlideshow;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentVideo;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBAggregatedEntitiesAtRangeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBAggregatedEntitiesAtRangeParser.SampleEntitiesParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBMessengerSubscriptionInfoParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBMessengerSubscriptionInfoParser.MessengerContentSubscriptionOptionParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBPageParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBPhotoParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBProfileParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBTextWithEntitiesParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBTextWithEntitiesParser.RangesParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBTextWithEntitiesParser.RangesParser.EntityParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBVideoParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.FBVideoParser.MessageParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleDocumentKickerParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleDocumentKickerParser.RelatedArticleVersionParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleEdgeParser.NodeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentAuthorEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentAuthorParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentAuthorParser.ProfileParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentBylineParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentEdgeParser.CoverMediaParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentEdgeParser.DocumentAuthorsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentEdgeParser.DocumentBodyElementsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentElementStyleParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentFontResourceParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentGlobalShareParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentGlobalShareParser.LinkMediaParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentGlobalShareParser.LinkMediaParser.ImageParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentGlobalShareParser.TitleParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentLinkStyleParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentListItemEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentListItemEdgeParser.RichDocumentListItemParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentListItemsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentListItemsParser.ListElementsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentLocationAnnotationParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentLogoParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentMasterParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentMasterParser.RelatedArticleObjectsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemFieldsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser.NLENParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser.NLENParser.NLENLParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser.NLENParser.NLENLParser.NLENLEParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser.NLENParser.NLENLParser.NLENLEParser.NLENLENParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser.NLENParser.NLENLParser.NLENLEParser.NLENLENParser.NLENLENLParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentNestedListItemParser.LParser.EParser.NParser.NLParser.NLEParser.NLENParser.NLENLParser.NLENLEParser.NLENLENParser.NLENLENLParser.NLENLENLEParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentRelatedArticleParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentRelatedArticlesParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentRelatedArticlesParser.RelatedArticleObjsParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentSectionEdgeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentSectionEdgeParser.RichDocumentSectionParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentSlideParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentSlideshowParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentSlideshowParser.SlideEdgesParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentStyleParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentStyleParser.FallbackArticleStyleParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextAnnotationParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTrackerParser;
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

/* compiled from: photo_picker_camera_cancelled */
public class RichDocumentGraphQlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 709943400)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBAggregatedEntitiesAtRangeModel extends BaseModel implements GraphQLVisitableModel {
        private int f5819d;
        private int f5820e;
        @Nullable
        private List<SampleEntitiesModel> f5821f;

        /* compiled from: photo_picker_camera_cancelled */
        public final class Builder {
            public int f5806a;
            public int f5807b;
            @Nullable
            public ImmutableList<SampleEntitiesModel> f5808c;
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBAggregatedEntitiesAtRangeModel.class, new Deserializer());
            }

            public Object m5620a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBAggregatedEntitiesAtRangeParser.m6453b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBAggregatedEntitiesAtRangeModel = new FBAggregatedEntitiesAtRangeModel();
                ((BaseModel) fBAggregatedEntitiesAtRangeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBAggregatedEntitiesAtRangeModel instanceof Postprocessable) {
                    return ((Postprocessable) fBAggregatedEntitiesAtRangeModel).a();
                }
                return fBAggregatedEntitiesAtRangeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1807432863)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class SampleEntitiesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f5814d;
            @Nullable
            private String f5815e;
            @Nullable
            private String f5816f;
            @Nullable
            private String f5817g;
            @Nullable
            private String f5818h;

            /* compiled from: photo_picker_camera_cancelled */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f5809a;
                @Nullable
                public String f5810b;
                @Nullable
                public String f5811c;
                @Nullable
                public String f5812d;
                @Nullable
                public String f5813e;
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SampleEntitiesModel.class, new Deserializer());
                }

                public Object m5621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SampleEntitiesParser.m6452b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sampleEntitiesModel = new SampleEntitiesModel();
                    ((BaseModel) sampleEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sampleEntitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) sampleEntitiesModel).a();
                    }
                    return sampleEntitiesModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<SampleEntitiesModel> {
                public final void m5622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SampleEntitiesModel sampleEntitiesModel = (SampleEntitiesModel) obj;
                    if (sampleEntitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sampleEntitiesModel.m5624a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sampleEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SampleEntitiesParser.m6451a(sampleEntitiesModel.w_(), sampleEntitiesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SampleEntitiesModel.class, new Serializer());
                }
            }

            public SampleEntitiesModel() {
                super(5);
            }

            public SampleEntitiesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(5);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m5627b() {
                if (this.b != null && this.f5814d == null) {
                    this.f5814d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5814d;
            }

            @Nullable
            public final String m5628c() {
                this.f5815e = super.a(this.f5815e, 1);
                return this.f5815e;
            }

            @Nullable
            public final String m5629d() {
                this.f5816f = super.a(this.f5816f, 2);
                return this.f5816f;
            }

            @Nullable
            public final String hQ_() {
                this.f5817g = super.a(this.f5817g, 3);
                return this.f5817g;
            }

            @Nullable
            public final String m5630g() {
                this.f5818h = super.a(this.f5818h, 4);
                return this.f5818h;
            }

            public static SampleEntitiesModel m5623a(SampleEntitiesModel sampleEntitiesModel) {
                if (sampleEntitiesModel == null) {
                    return null;
                }
                if (sampleEntitiesModel instanceof SampleEntitiesModel) {
                    return sampleEntitiesModel;
                }
                Builder builder = new Builder();
                builder.f5809a = sampleEntitiesModel.m5627b();
                builder.f5810b = sampleEntitiesModel.m5628c();
                builder.f5811c = sampleEntitiesModel.m5629d();
                builder.f5812d = sampleEntitiesModel.hQ_();
                builder.f5813e = sampleEntitiesModel.m5630g();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5809a);
                int b = flatBufferBuilder.b(builder.f5810b);
                int b2 = flatBufferBuilder.b(builder.f5811c);
                int b3 = flatBufferBuilder.b(builder.f5812d);
                int b4 = flatBufferBuilder.b(builder.f5813e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, b4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SampleEntitiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m5626a() {
                return m5629d();
            }

            public final int jK_() {
                return 2080559107;
            }

            public final GraphQLVisitableModel m5625a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5624a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5627b());
                int b = flatBufferBuilder.b(m5628c());
                int b2 = flatBufferBuilder.b(m5629d());
                int b3 = flatBufferBuilder.b(hQ_());
                int b4 = flatBufferBuilder.b(m5630g());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, b4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBAggregatedEntitiesAtRangeModel> {
            public final void m5631a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBAggregatedEntitiesAtRangeModel fBAggregatedEntitiesAtRangeModel = (FBAggregatedEntitiesAtRangeModel) obj;
                if (fBAggregatedEntitiesAtRangeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBAggregatedEntitiesAtRangeModel.m5634a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBAggregatedEntitiesAtRangeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBAggregatedEntitiesAtRangeParser.m6454b(fBAggregatedEntitiesAtRangeModel.w_(), fBAggregatedEntitiesAtRangeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBAggregatedEntitiesAtRangeModel.class, new Serializer());
            }
        }

        public FBAggregatedEntitiesAtRangeModel() {
            super(3);
        }

        public FBAggregatedEntitiesAtRangeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m5633a() {
            a(0, 0);
            return this.f5819d;
        }

        public final int m5637b() {
            a(0, 1);
            return this.f5820e;
        }

        @Nonnull
        public final ImmutableList<SampleEntitiesModel> m5638c() {
            this.f5821f = super.a(this.f5821f, 2, SampleEntitiesModel.class);
            return (ImmutableList) this.f5821f;
        }

        public static FBAggregatedEntitiesAtRangeModel m5632a(FBAggregatedEntitiesAtRangeModel fBAggregatedEntitiesAtRangeModel) {
            if (fBAggregatedEntitiesAtRangeModel == null) {
                return null;
            }
            if (fBAggregatedEntitiesAtRangeModel instanceof FBAggregatedEntitiesAtRangeModel) {
                return fBAggregatedEntitiesAtRangeModel;
            }
            Builder builder = new Builder();
            builder.f5806a = fBAggregatedEntitiesAtRangeModel.m5633a();
            builder.f5807b = fBAggregatedEntitiesAtRangeModel.m5637b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < fBAggregatedEntitiesAtRangeModel.m5638c().size(); i++) {
                builder2.c(SampleEntitiesModel.m5623a((SampleEntitiesModel) fBAggregatedEntitiesAtRangeModel.m5638c().get(i)));
            }
            builder.f5808c = builder2.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f5808c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, builder.f5806a, 0);
            flatBufferBuilder.a(1, builder.f5807b, 0);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new FBAggregatedEntitiesAtRangeModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 1563462756;
        }

        public final GraphQLVisitableModel m5635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5638c() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m5638c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FBAggregatedEntitiesAtRangeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5821f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5634a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5638c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f5819d, 0);
            flatBufferBuilder.a(1, this.f5820e, 0);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5636a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5819d = mutableFlatBuffer.a(i, 0, 0);
            this.f5820e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -543596091)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBMessengerSubscriptionInfoModel extends BaseModel implements GraphQLVisitableModel, FBMessengerSubscriptionInfo {
        @Nullable
        private MessengerContentSubscriptionOptionModel f5824d;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBMessengerSubscriptionInfoModel.class, new Deserializer());
            }

            public Object m5639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBMessengerSubscriptionInfoParser.m6457a(jsonParser);
                Object fBMessengerSubscriptionInfoModel = new FBMessengerSubscriptionInfoModel();
                ((BaseModel) fBMessengerSubscriptionInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBMessengerSubscriptionInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) fBMessengerSubscriptionInfoModel).a();
                }
                return fBMessengerSubscriptionInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -263662987)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class MessengerContentSubscriptionOptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5822d;
            @Nullable
            private String f5823e;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContentSubscriptionOptionModel.class, new Deserializer());
                }

                public Object m5640a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerContentSubscriptionOptionParser.m6455a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContentSubscriptionOptionModel = new MessengerContentSubscriptionOptionModel();
                    ((BaseModel) messengerContentSubscriptionOptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContentSubscriptionOptionModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContentSubscriptionOptionModel).a();
                    }
                    return messengerContentSubscriptionOptionModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<MessengerContentSubscriptionOptionModel> {
                public final void m5641a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContentSubscriptionOptionModel messengerContentSubscriptionOptionModel = (MessengerContentSubscriptionOptionModel) obj;
                    if (messengerContentSubscriptionOptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContentSubscriptionOptionModel.m5642a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContentSubscriptionOptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerContentSubscriptionOptionParser.m6456a(messengerContentSubscriptionOptionModel.w_(), messengerContentSubscriptionOptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerContentSubscriptionOptionModel.class, new Serializer());
                }
            }

            public MessengerContentSubscriptionOptionModel() {
                super(2);
            }

            @Nullable
            public final String m5644a() {
                this.f5822d = super.a(this.f5822d, 0);
                return this.f5822d;
            }

            @Nullable
            public final String m5645b() {
                this.f5823e = super.a(this.f5823e, 1);
                return this.f5823e;
            }

            public final int jK_() {
                return 1459786904;
            }

            public final GraphQLVisitableModel m5643a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5642a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5644a());
                int b2 = flatBufferBuilder.b(m5645b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBMessengerSubscriptionInfoModel> {
            public final void m5646a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBMessengerSubscriptionInfoModel fBMessengerSubscriptionInfoModel = (FBMessengerSubscriptionInfoModel) obj;
                if (fBMessengerSubscriptionInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBMessengerSubscriptionInfoModel.m5648a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBMessengerSubscriptionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBMessengerSubscriptionInfoModel.w_();
                int u_ = fBMessengerSubscriptionInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_content_subscription_option");
                    MessengerContentSubscriptionOptionParser.m6456a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBMessengerSubscriptionInfoModel.class, new Serializer());
            }
        }

        public FBMessengerSubscriptionInfoModel() {
            super(1);
        }

        @Nullable
        private MessengerContentSubscriptionOptionModel m5647a() {
            this.f5824d = (MessengerContentSubscriptionOptionModel) super.a(this.f5824d, 0, MessengerContentSubscriptionOptionModel.class);
            return this.f5824d;
        }

        public final int jK_() {
            return 1607392245;
        }

        public final GraphQLVisitableModel m5649a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5647a() != null) {
                MessengerContentSubscriptionOptionModel messengerContentSubscriptionOptionModel = (MessengerContentSubscriptionOptionModel) graphQLModelMutatingVisitor.b(m5647a());
                if (m5647a() != messengerContentSubscriptionOptionModel) {
                    graphQLVisitableModel = (FBMessengerSubscriptionInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5824d = messengerContentSubscriptionOptionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5648a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5647a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1158598232)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FBPage {
        private boolean f5825d;
        private boolean f5826e;
        @Nullable
        private String f5827f;
        @Nullable
        private String f5828g;
        @Nullable
        private FBFullImageFragmentModel f5829h;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBPageModel.class, new Deserializer());
            }

            public Object m5650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBPageParser.m6458a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBPageModel = new FBPageModel();
                ((BaseModel) fBPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBPageModel instanceof Postprocessable) {
                    return ((Postprocessable) fBPageModel).a();
                }
                return fBPageModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBPageModel> {
            public final void m5651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBPageModel fBPageModel = (FBPageModel) obj;
                if (fBPageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBPageModel.m5654a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBPageParser.m6459a(fBPageModel.w_(), fBPageModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBPageModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel mo313g() {
            return m5653j();
        }

        public FBPageModel() {
            super(5);
        }

        public final void m5658a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo311c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m5659a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m5652a(((Boolean) obj).booleanValue());
            }
        }

        public final boolean mo310b() {
            a(0, 0);
            return this.f5825d;
        }

        public final boolean mo311c() {
            a(0, 1);
            return this.f5826e;
        }

        private void m5652a(boolean z) {
            this.f5826e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        @Nullable
        public final String mo312d() {
            this.f5827f = super.a(this.f5827f, 2);
            return this.f5827f;
        }

        @Nullable
        public final String hR_() {
            this.f5828g = super.a(this.f5828g, 3);
            return this.f5828g;
        }

        @Nullable
        private FBFullImageFragmentModel m5653j() {
            this.f5829h = (FBFullImageFragmentModel) super.a(this.f5829h, 4, FBFullImageFragmentModel.class);
            return this.f5829h;
        }

        @Nullable
        public final String m5656a() {
            return mo312d();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m5655a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5653j() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m5653j());
                if (m5653j() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (FBPageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5829h = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5654a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo312d());
            int b2 = flatBufferBuilder.b(hR_());
            int a = ModelHelper.a(flatBufferBuilder, m5653j());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f5825d);
            flatBufferBuilder.a(1, this.f5826e);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5657a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5825d = mutableFlatBuffer.a(i, 0);
            this.f5826e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1003184020)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBPhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, FBPhoto {
        @Nullable
        private String f5830d;
        @Nullable
        private FBFullImageFragmentModel f5831e;
        @Nullable
        private FBFullImageFragmentModel f5832f;
        @Nullable
        private String f5833g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBPhotoModel.class, new Deserializer());
            }

            public Object m5664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBPhotoParser.m6460a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBPhotoModel = new FBPhotoModel();
                ((BaseModel) fBPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBPhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) fBPhotoModel).a();
                }
                return fBPhotoModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBPhotoModel> {
            public final void m5665a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBPhotoModel fBPhotoModel = (FBPhotoModel) obj;
                if (fBPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBPhotoModel.m5668a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBPhotoParser.m6461a(fBPhotoModel.w_(), fBPhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBPhotoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel mo316c() {
            return m5666j();
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel mo317d() {
            return m5667k();
        }

        public FBPhotoModel() {
            super(4);
        }

        @Nullable
        public final String mo315b() {
            this.f5830d = super.a(this.f5830d, 0);
            return this.f5830d;
        }

        @Nullable
        private FBFullImageFragmentModel m5666j() {
            this.f5831e = (FBFullImageFragmentModel) super.a(this.f5831e, 1, FBFullImageFragmentModel.class);
            return this.f5831e;
        }

        @Nullable
        private FBFullImageFragmentModel m5667k() {
            this.f5832f = (FBFullImageFragmentModel) super.a(this.f5832f, 2, FBFullImageFragmentModel.class);
            return this.f5832f;
        }

        @Nullable
        public final String hS_() {
            this.f5833g = super.a(this.f5833g, 3);
            return this.f5833g;
        }

        @Nullable
        public final String m5670a() {
            return mo315b();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m5669a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            FBFullImageFragmentModel fBFullImageFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5666j() != null) {
                fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m5666j());
                if (m5666j() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (FBPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5831e = fBFullImageFragmentModel;
                }
            }
            if (m5667k() != null) {
                fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m5667k());
                if (m5667k() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (FBPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5832f = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5668a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo315b());
            int a = ModelHelper.a(flatBufferBuilder, m5666j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5667k());
            int b2 = flatBufferBuilder.b(hS_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 684123037)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f5834d;
        @Nullable
        private String f5835e;
        @Nullable
        private String f5836f;
        @Nullable
        private FBFullImageFragmentModel f5837g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBProfileModel.class, new Deserializer());
            }

            public Object m5674a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBProfileParser.m6462a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBProfileModel = new FBProfileModel();
                ((BaseModel) fBProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBProfileModel instanceof Postprocessable) {
                    return ((Postprocessable) fBProfileModel).a();
                }
                return fBProfileModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBProfileModel> {
            public final void m5675a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBProfileModel fBProfileModel = (FBProfileModel) obj;
                if (fBProfileModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBProfileModel.m5679a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBProfileParser.m6463a(fBProfileModel.w_(), fBProfileModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBProfileModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel m5685c() {
            return m5678l();
        }

        public FBProfileModel() {
            super(4);
        }

        public final void m5682a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5683a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m5676j() {
            if (this.b != null && this.f5834d == null) {
                this.f5834d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f5834d;
        }

        @Nullable
        private String m5677k() {
            this.f5835e = super.a(this.f5835e, 1);
            return this.f5835e;
        }

        @Nullable
        public final String m5684b() {
            this.f5836f = super.a(this.f5836f, 2);
            return this.f5836f;
        }

        @Nullable
        private FBFullImageFragmentModel m5678l() {
            this.f5837g = (FBFullImageFragmentModel) super.a(this.f5837g, 3, FBFullImageFragmentModel.class);
            return this.f5837g;
        }

        @Nullable
        public final String m5681a() {
            return m5677k();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m5680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5678l() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m5678l());
                if (m5678l() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (FBProfileModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5837g = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5679a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5676j());
            int b = flatBufferBuilder.b(m5677k());
            int b2 = flatBufferBuilder.b(m5684b());
            int a2 = ModelHelper.a(flatBufferBuilder, m5678l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 412162856)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBTextWithEntitiesModel extends BaseModel implements DefaultTextWithEntitiesFields, GraphQLVisitableModel {
        @Nullable
        private List<FBAggregatedEntitiesAtRangeModel> f5857d;
        @Nullable
        private List<RangesModel> f5858e;
        @Nullable
        private String f5859f;

        /* compiled from: photo_picker_camera_cancelled */
        public final class Builder {
            @Nullable
            public ImmutableList<FBAggregatedEntitiesAtRangeModel> f5838a;
            @Nullable
            public ImmutableList<RangesModel> f5839b;
            @Nullable
            public String f5840c;
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBTextWithEntitiesModel.class, new Deserializer());
            }

            public Object m5686a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBTextWithEntitiesParser.m6469a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBTextWithEntitiesModel = new FBTextWithEntitiesModel();
                ((BaseModel) fBTextWithEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBTextWithEntitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) fBTextWithEntitiesModel).a();
                }
                return fBTextWithEntitiesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -471888600)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityModel f5854d;
            private int f5855e;
            private int f5856f;

            /* compiled from: photo_picker_camera_cancelled */
            public final class Builder {
                @Nullable
                public EntityModel f5841a;
                public int f5842b;
                public int f5843c;
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m5687a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m6467b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rangesModel = new RangesModel();
                    ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rangesModel instanceof Postprocessable) {
                        return ((Postprocessable) rangesModel).a();
                    }
                    return rangesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1807432863)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_picker_camera_cancelled */
            public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f5849d;
                @Nullable
                private String f5850e;
                @Nullable
                private String f5851f;
                @Nullable
                private String f5852g;
                @Nullable
                private String f5853h;

                /* compiled from: photo_picker_camera_cancelled */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f5844a;
                    @Nullable
                    public String f5845b;
                    @Nullable
                    public String f5846c;
                    @Nullable
                    public String f5847d;
                    @Nullable
                    public String f5848e;
                }

                /* compiled from: photo_picker_camera_cancelled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                    }

                    public Object m5688a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EntityParser.m6464a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object entityModel = new EntityModel();
                        ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (entityModel instanceof Postprocessable) {
                            return ((Postprocessable) entityModel).a();
                        }
                        return entityModel;
                    }
                }

                /* compiled from: photo_picker_camera_cancelled */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m5689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EntityModel entityModel = (EntityModel) obj;
                        if (entityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(entityModel.m5691a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EntityParser.m6465a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EntityModel.class, new Serializer());
                    }
                }

                public EntityModel() {
                    super(5);
                }

                public EntityModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(5);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final GraphQLObjectType m5694b() {
                    if (this.b != null && this.f5849d == null) {
                        this.f5849d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f5849d;
                }

                @Nullable
                public final String m5695c() {
                    this.f5850e = super.a(this.f5850e, 1);
                    return this.f5850e;
                }

                @Nullable
                public final String m5696d() {
                    this.f5851f = super.a(this.f5851f, 2);
                    return this.f5851f;
                }

                @Nullable
                public final String hT_() {
                    this.f5852g = super.a(this.f5852g, 3);
                    return this.f5852g;
                }

                @Nullable
                public final String m5697g() {
                    this.f5853h = super.a(this.f5853h, 4);
                    return this.f5853h;
                }

                public static EntityModel m5690a(EntityModel entityModel) {
                    if (entityModel == null) {
                        return null;
                    }
                    if (entityModel instanceof EntityModel) {
                        return entityModel;
                    }
                    Builder builder = new Builder();
                    builder.f5844a = entityModel.m5694b();
                    builder.f5845b = entityModel.m5695c();
                    builder.f5846c = entityModel.m5696d();
                    builder.f5847d = entityModel.hT_();
                    builder.f5848e = entityModel.m5697g();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f5844a);
                    int b = flatBufferBuilder.b(builder.f5845b);
                    int b2 = flatBufferBuilder.b(builder.f5846c);
                    int b3 = flatBufferBuilder.b(builder.f5847d);
                    int b4 = flatBufferBuilder.b(builder.f5848e);
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    flatBufferBuilder.b(4, b4);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EntityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m5693a() {
                    return m5696d();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m5692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5691a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5694b());
                    int b = flatBufferBuilder.b(m5695c());
                    int b2 = flatBufferBuilder.b(m5696d());
                    int b3 = flatBufferBuilder.b(hT_());
                    int b4 = flatBufferBuilder.b(m5697g());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    flatBufferBuilder.b(4, b4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m5698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m5701a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RangesParser.m6468b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EntityModel m5703a() {
                return m5700j();
            }

            public RangesModel() {
                super(3);
            }

            public RangesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private EntityModel m5700j() {
                this.f5854d = (EntityModel) super.a(this.f5854d, 0, EntityModel.class);
                return this.f5854d;
            }

            public final int m5705b() {
                a(0, 1);
                return this.f5855e;
            }

            public final int m5706c() {
                a(0, 2);
                return this.f5856f;
            }

            public static RangesModel m5699a(RangesModel rangesModel) {
                if (rangesModel == null) {
                    return null;
                }
                if (rangesModel instanceof RangesModel) {
                    return rangesModel;
                }
                Builder builder = new Builder();
                builder.f5841a = EntityModel.m5690a(rangesModel.m5703a());
                builder.f5842b = rangesModel.m5705b();
                builder.f5843c = rangesModel.m5706c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f5841a);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, builder.f5842b, 0);
                flatBufferBuilder.a(2, builder.f5843c, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RangesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m5702a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5700j() != null) {
                    EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m5700j());
                    if (m5700j() != entityModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5854d = entityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5701a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5700j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f5855e, 0);
                flatBufferBuilder.a(2, this.f5856f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5704a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5855e = mutableFlatBuffer.a(i, 1, 0);
                this.f5856f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBTextWithEntitiesModel> {
            public final void m5707a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBTextWithEntitiesModel fBTextWithEntitiesModel = (FBTextWithEntitiesModel) obj;
                if (fBTextWithEntitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBTextWithEntitiesModel.m5709a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBTextWithEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBTextWithEntitiesParser.m6470a(fBTextWithEntitiesModel.w_(), fBTextWithEntitiesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBTextWithEntitiesModel.class, new Serializer());
            }
        }

        public FBTextWithEntitiesModel() {
            super(3);
        }

        public FBTextWithEntitiesModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<FBAggregatedEntitiesAtRangeModel> m5712b() {
            this.f5857d = super.a(this.f5857d, 0, FBAggregatedEntitiesAtRangeModel.class);
            return (ImmutableList) this.f5857d;
        }

        @Nonnull
        public final ImmutableList<RangesModel> m5713c() {
            this.f5858e = super.a(this.f5858e, 1, RangesModel.class);
            return (ImmutableList) this.f5858e;
        }

        @Nullable
        public final String m5711a() {
            this.f5859f = super.a(this.f5859f, 2);
            return this.f5859f;
        }

        public static FBTextWithEntitiesModel m5708a(FBTextWithEntitiesModel fBTextWithEntitiesModel) {
            int i = 0;
            if (fBTextWithEntitiesModel == null) {
                return null;
            }
            if (fBTextWithEntitiesModel instanceof FBTextWithEntitiesModel) {
                return fBTextWithEntitiesModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < fBTextWithEntitiesModel.m5712b().size(); i2++) {
                builder2.c(FBAggregatedEntitiesAtRangeModel.m5632a((FBAggregatedEntitiesAtRangeModel) fBTextWithEntitiesModel.m5712b().get(i2)));
            }
            builder.f5838a = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < fBTextWithEntitiesModel.m5713c().size()) {
                builder3.c(RangesModel.m5699a((RangesModel) fBTextWithEntitiesModel.m5713c().get(i)));
                i++;
            }
            builder.f5839b = builder3.b();
            builder.f5840c = fBTextWithEntitiesModel.m5711a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f5838a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f5839b);
            int b = flatBufferBuilder.b(builder.f5840c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new FBTextWithEntitiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m5710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5712b() != null) {
                a = ModelHelper.a(m5712b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FBTextWithEntitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5857d = a.b();
                }
            }
            if (m5713c() != null) {
                a = ModelHelper.a(m5713c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FBTextWithEntitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5858e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5709a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5712b());
            int a2 = ModelHelper.a(flatBufferBuilder, m5713c());
            int b = flatBufferBuilder.b(m5711a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 573055356)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class FBVideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, FBVideo {
        private int f5861d;
        @Nullable
        private String f5862e;
        private int f5863f;
        private int f5864g;
        private int f5865h;
        private boolean f5866i;
        @Nullable
        private MessageModel f5867j;
        private int f5868k;
        @Nullable
        private String f5869l;
        @Nullable
        private String f5870m;
        @Nullable
        private String f5871n;
        @Nullable
        private String f5872o;
        @Nullable
        private String f5873p;
        private double f5874q;
        private double f5875r;
        @Nullable
        private String f5876s;
        @Nullable
        private String f5877t;
        @Nullable
        private String f5878u;
        private int f5879v;
        @Nullable
        private FBFullImageFragmentModel f5880w;
        private int f5881x;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBVideoModel.class, new Deserializer());
            }

            public Object m5714a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBVideoParser.m6473a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBVideoModel = new FBVideoModel();
                ((BaseModel) fBVideoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBVideoModel instanceof Postprocessable) {
                    return ((Postprocessable) fBVideoModel).a();
                }
                return fBVideoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5860d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                }

                public Object m5715a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageParser.m6471a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageModel = new MessageModel();
                    ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageModel instanceof Postprocessable) {
                        return ((Postprocessable) messageModel).a();
                    }
                    return messageModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<MessageModel> {
                public final void m5716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageModel messageModel = (MessageModel) obj;
                    if (messageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageModel.m5718a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageParser.m6472a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                }
            }

            public MessageModel() {
                super(1);
            }

            @Nullable
            private String m5717a() {
                this.f5860d = super.a(this.f5860d, 0);
                return this.f5860d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m5719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5718a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5717a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<FBVideoModel> {
            public final void m5720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBVideoModel fBVideoModel = (FBVideoModel) obj;
                if (fBVideoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBVideoModel.m5723a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBVideoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBVideoParser.m6474a(fBVideoModel.w_(), fBVideoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBVideoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel mo337x() {
            return m5721A();
        }

        public FBVideoModel() {
            super(21);
        }

        public final int mo320g() {
            a(0, 0);
            return this.f5861d;
        }

        @Nullable
        public final String mo319b() {
            this.f5862e = super.a(this.f5862e, 1);
            return this.f5862e;
        }

        public final int hU_() {
            a(0, 2);
            return this.f5863f;
        }

        public final int hV_() {
            a(0, 3);
            return this.f5864g;
        }

        public final int mo323j() {
            a(0, 4);
            return this.f5865h;
        }

        public final boolean mo324k() {
            a(0, 5);
            return this.f5866i;
        }

        @Nullable
        private MessageModel m5722z() {
            this.f5867j = (MessageModel) super.a(this.f5867j, 6, MessageModel.class);
            return this.f5867j;
        }

        public final int mo325l() {
            a(0, 7);
            return this.f5868k;
        }

        @Nullable
        public final String mo326m() {
            this.f5869l = super.a(this.f5869l, 8);
            return this.f5869l;
        }

        @Nullable
        public final String mo327n() {
            this.f5870m = super.a(this.f5870m, 9);
            return this.f5870m;
        }

        @Nullable
        public final String mo328o() {
            this.f5871n = super.a(this.f5871n, 10);
            return this.f5871n;
        }

        @Nullable
        public final String mo329p() {
            this.f5872o = super.a(this.f5872o, 11);
            return this.f5872o;
        }

        @Nullable
        public final String mo330q() {
            this.f5873p = super.a(this.f5873p, 12);
            return this.f5873p;
        }

        public final double mo331r() {
            a(1, 5);
            return this.f5874q;
        }

        public final double mo332s() {
            a(1, 6);
            return this.f5875r;
        }

        @Nullable
        public final String mo333t() {
            this.f5876s = super.a(this.f5876s, 15);
            return this.f5876s;
        }

        @Nullable
        public final String mo334u() {
            this.f5877t = super.a(this.f5877t, 16);
            return this.f5877t;
        }

        @Nullable
        public final String mo335v() {
            this.f5878u = super.a(this.f5878u, 17);
            return this.f5878u;
        }

        public final int mo336w() {
            a(2, 2);
            return this.f5879v;
        }

        @Nullable
        private FBFullImageFragmentModel m5721A() {
            this.f5880w = (FBFullImageFragmentModel) super.a(this.f5880w, 19, FBFullImageFragmentModel.class);
            return this.f5880w;
        }

        public final int mo338y() {
            a(2, 4);
            return this.f5881x;
        }

        @Nullable
        public final String m5725a() {
            return mo319b();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m5724a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5722z() != null) {
                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m5722z());
                if (m5722z() != messageModel) {
                    graphQLVisitableModel = (FBVideoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5867j = messageModel;
                }
            }
            if (m5721A() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m5721A());
                if (m5721A() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (FBVideoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5880w = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5723a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo319b());
            int a = ModelHelper.a(flatBufferBuilder, m5722z());
            int b2 = flatBufferBuilder.b(mo326m());
            int b3 = flatBufferBuilder.b(mo327n());
            int b4 = flatBufferBuilder.b(mo328o());
            int b5 = flatBufferBuilder.b(mo329p());
            int b6 = flatBufferBuilder.b(mo330q());
            int b7 = flatBufferBuilder.b(mo333t());
            int b8 = flatBufferBuilder.b(mo334u());
            int b9 = flatBufferBuilder.b(mo335v());
            int a2 = ModelHelper.a(flatBufferBuilder, m5721A());
            flatBufferBuilder.c(21);
            flatBufferBuilder.a(0, this.f5861d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f5863f, 0);
            flatBufferBuilder.a(3, this.f5864g, 0);
            flatBufferBuilder.a(4, this.f5865h, 0);
            flatBufferBuilder.a(5, this.f5866i);
            flatBufferBuilder.b(6, a);
            flatBufferBuilder.a(7, this.f5868k, 0);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, b3);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, b5);
            flatBufferBuilder.b(12, b6);
            flatBufferBuilder.a(13, this.f5874q, 0.0d);
            flatBufferBuilder.a(14, this.f5875r, 0.0d);
            flatBufferBuilder.b(15, b7);
            flatBufferBuilder.b(16, b8);
            flatBufferBuilder.b(17, b9);
            flatBufferBuilder.a(18, this.f5879v, 0);
            flatBufferBuilder.b(19, a2);
            flatBufferBuilder.a(20, this.f5881x, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5726a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5861d = mutableFlatBuffer.a(i, 0, 0);
            this.f5863f = mutableFlatBuffer.a(i, 2, 0);
            this.f5864g = mutableFlatBuffer.a(i, 3, 0);
            this.f5865h = mutableFlatBuffer.a(i, 4, 0);
            this.f5866i = mutableFlatBuffer.a(i, 5);
            this.f5868k = mutableFlatBuffer.a(i, 7, 0);
            this.f5874q = mutableFlatBuffer.a(i, 13, 0.0d);
            this.f5875r = mutableFlatBuffer.a(i, 14, 0.0d);
            this.f5879v = mutableFlatBuffer.a(i, 18, 0);
            this.f5881x = mutableFlatBuffer.a(i, 20, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1533085316)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RelatedArticleDocumentKickerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f5884d;
        @Nullable
        private RelatedArticleVersionModel f5885e;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RelatedArticleDocumentKickerModel.class, new Deserializer());
            }

            public Object m5745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RelatedArticleDocumentKickerParser.m6477a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object relatedArticleDocumentKickerModel = new RelatedArticleDocumentKickerModel();
                ((BaseModel) relatedArticleDocumentKickerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (relatedArticleDocumentKickerModel instanceof Postprocessable) {
                    return ((Postprocessable) relatedArticleDocumentKickerModel).a();
                }
                return relatedArticleDocumentKickerModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1730988701)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class RelatedArticleVersionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private RichDocumentTextModel f5882d;
            @Nullable
            private String f5883e;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RelatedArticleVersionModel.class, new Deserializer());
                }

                public Object m5746a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RelatedArticleVersionParser.m6475a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object relatedArticleVersionModel = new RelatedArticleVersionModel();
                    ((BaseModel) relatedArticleVersionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (relatedArticleVersionModel instanceof Postprocessable) {
                        return ((Postprocessable) relatedArticleVersionModel).a();
                    }
                    return relatedArticleVersionModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<RelatedArticleVersionModel> {
                public final void m5747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RelatedArticleVersionModel relatedArticleVersionModel = (RelatedArticleVersionModel) obj;
                    if (relatedArticleVersionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(relatedArticleVersionModel.m5750a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        relatedArticleVersionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RelatedArticleVersionParser.m6476a(relatedArticleVersionModel.w_(), relatedArticleVersionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RelatedArticleVersionModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RichDocumentText m5753b() {
                return m5748j();
            }

            public RelatedArticleVersionModel() {
                super(2);
            }

            @Nullable
            private RichDocumentTextModel m5748j() {
                this.f5882d = (RichDocumentTextModel) super.a(this.f5882d, 0, RichDocumentTextModel.class);
                return this.f5882d;
            }

            @Nullable
            private String m5749k() {
                this.f5883e = super.a(this.f5883e, 1);
                return this.f5883e;
            }

            @Nullable
            public final String m5752a() {
                return m5749k();
            }

            public final int jK_() {
                return 1619159843;
            }

            public final GraphQLVisitableModel m5751a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5748j() != null) {
                    RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5748j());
                    if (m5748j() != richDocumentTextModel) {
                        graphQLVisitableModel = (RelatedArticleVersionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5882d = richDocumentTextModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5750a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5748j());
                int b = flatBufferBuilder.b(m5749k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RelatedArticleDocumentKickerModel> {
            public final void m5754a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RelatedArticleDocumentKickerModel relatedArticleDocumentKickerModel = (RelatedArticleDocumentKickerModel) obj;
                if (relatedArticleDocumentKickerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(relatedArticleDocumentKickerModel.m5756a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    relatedArticleDocumentKickerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RelatedArticleDocumentKickerParser.m6478a(relatedArticleDocumentKickerModel.w_(), relatedArticleDocumentKickerModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RelatedArticleDocumentKickerModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RelatedArticleVersionModel m5760c() {
            return m5755j();
        }

        public RelatedArticleDocumentKickerModel() {
            super(2);
        }

        @Nullable
        public final String m5759b() {
            this.f5884d = super.a(this.f5884d, 0);
            return this.f5884d;
        }

        @Nullable
        private RelatedArticleVersionModel m5755j() {
            this.f5885e = (RelatedArticleVersionModel) super.a(this.f5885e, 1, RelatedArticleVersionModel.class);
            return this.f5885e;
        }

        @Nullable
        public final String m5758a() {
            return m5759b();
        }

        public final int jK_() {
            return 1607392245;
        }

        public final GraphQLVisitableModel m5757a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5755j() != null) {
                RelatedArticleVersionModel relatedArticleVersionModel = (RelatedArticleVersionModel) graphQLModelMutatingVisitor.b(m5755j());
                if (m5755j() != relatedArticleVersionModel) {
                    graphQLVisitableModel = (RelatedArticleDocumentKickerModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5885e = relatedArticleVersionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5756a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5759b());
            int a = ModelHelper.a(flatBufferBuilder, m5755j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1404077099)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RelatedArticleEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NodeModel f5888d;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RelatedArticleEdgeModel.class, new Deserializer());
            }

            public Object m5761a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RelatedArticleEdgeParser.m6481b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object relatedArticleEdgeModel = new RelatedArticleEdgeModel();
                ((BaseModel) relatedArticleEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (relatedArticleEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) relatedArticleEdgeModel).a();
                }
                return relatedArticleEdgeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1617558826)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RelatedArticleGlobalShareModel f5886d;
            private boolean f5887e;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m5762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m6479a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nodeModel = new NodeModel();
                    ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (nodeModel instanceof Postprocessable) {
                        return ((Postprocessable) nodeModel).a();
                    }
                    return nodeModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m5763a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m5765a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m6480a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RelatedArticleGlobalShareModel m5767a() {
                return m5764j();
            }

            public NodeModel() {
                super(2);
            }

            @Nullable
            private RelatedArticleGlobalShareModel m5764j() {
                this.f5886d = (RelatedArticleGlobalShareModel) super.a(this.f5886d, 0, RelatedArticleGlobalShareModel.class);
                return this.f5886d;
            }

            public final boolean m5769b() {
                a(0, 1);
                return this.f5887e;
            }

            public final int jK_() {
                return -669384015;
            }

            public final GraphQLVisitableModel m5766a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5764j() != null) {
                    RelatedArticleGlobalShareModel relatedArticleGlobalShareModel = (RelatedArticleGlobalShareModel) graphQLModelMutatingVisitor.b(m5764j());
                    if (m5764j() != relatedArticleGlobalShareModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5886d = relatedArticleGlobalShareModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5765a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5764j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f5887e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5768a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5887e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RelatedArticleEdgeModel> {
            public final void m5770a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RelatedArticleEdgeModel relatedArticleEdgeModel = (RelatedArticleEdgeModel) obj;
                if (relatedArticleEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(relatedArticleEdgeModel.m5772a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    relatedArticleEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RelatedArticleEdgeParser.m6482b(relatedArticleEdgeModel.w_(), relatedArticleEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RelatedArticleEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NodeModel m5774a() {
            return m5771j();
        }

        public RelatedArticleEdgeModel() {
            super(1);
        }

        @Nullable
        private NodeModel m5771j() {
            this.f5888d = (NodeModel) super.a(this.f5888d, 0, NodeModel.class);
            return this.f5888d;
        }

        public final int jK_() {
            return 1801309283;
        }

        public final GraphQLVisitableModel m5773a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5771j() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m5771j());
                if (m5771j() != nodeModel) {
                    graphQLVisitableModel = (RelatedArticleEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5888d = nodeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5772a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5771j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1374275218)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RelatedArticleGlobalShareModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f5893d;
        @Nullable
        private String f5894e;
        @Nullable
        private RelatedArticleDocumentKickerModel f5895f;
        @Nullable
        private LinkMediaModel f5896g;
        @Nullable
        private TitleModel f5897h;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.class;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m5775a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.m6489a(r11, r4);
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r4 = 0;
                r5.position(r4);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = 4;
                r6 = java.lang.Boolean.valueOf(r8);
                r4.a(r5, r6);
                r2 = r4;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r11);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0048;
            L_0x0042:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0048:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1991511105)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class LinkMediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f5890d;
            @Nullable
            private ImageModel f5891e;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5776a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.LinkMediaParser.m6485a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_picker_camera_cancelled */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f5889d;

                /* compiled from: photo_picker_camera_cancelled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.class;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$ImageModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m5777a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.LinkMediaParser.ImageParser.m6483a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$ImageModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: photo_picker_camera_cancelled */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m5778a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m5779a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.LinkMediaParser.ImageParser.m6484a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.class;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$ImageModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.Serializer.<clinit>():void");
                    }
                }

                public ImageModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5781a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f5889d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f5889d = r0;
                    r0 = r2.f5889d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m5780a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m5779a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r2.h();
                    r0 = r2.m5781a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<LinkMediaModel> {
                public final void m5782a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5785a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.LinkMediaParser.m6486a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel m5787a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m5784k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.a():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$ImageModel");
            }

            public LinkMediaModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.graphql.enums.GraphQLObjectType m5783j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.b;
                if (r0 == 0) goto L_0x0017;
            L_0x0004:
                r0 = r4.f5890d;
                if (r0 != 0) goto L_0x0017;
            L_0x0008:
                r0 = r4.b;
                r1 = r4.c;
                r2 = 0;
                r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                r0 = r0.d(r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                r4.f5890d = r0;
            L_0x0017:
                r0 = r4.f5890d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.j():com.facebook.graphql.enums.GraphQLObjectType");
            }

            @javax.annotation.Nullable
            private com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel m5784k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f5891e;
                r1 = 1;
                r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel) r0;
                r3.f5891e = r0;
                r0 = r3.f5891e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.k():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel$ImageModel");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 74219460; // 0x46c7fc4 float:2.7800334E-36 double:3.66692854E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5786a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m5784k();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m5784k();
                r0 = r4.b(r0);
                r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.ImageModel) r0;
                r2 = r3.m5784k();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel) r1;
                r1.f5891e = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5785a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r3.h();
                r0 = r3.m5783j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = r3.m5784k();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
                r2 = 2;
                r4.c(r2);
                r2 = 0;
                r4.b(r2, r0);
                r0 = 1;
                r4.b(r0, r1);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RelatedArticleGlobalShareModel> {
            public final void m5788a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m5797a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r8.a(r0, r1);
            L_0x0035:
                r0 = r8.w_();
                r1 = r8.u_();
                com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.m6490a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.class;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5892d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$TitleModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5789a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.TitleParser.m6487a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$TitleModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m5790a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5791a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RelatedArticleGlobalShareParser.TitleParser.m6488a(r0, r1, r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$TitleModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.Serializer.<clinit>():void");
                }
            }

            public TitleModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final java.lang.String m5793a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = r2.f5892d;
                r1 = 0;
                r0 = super.a(r0, r1);
                r2.f5892d = r0;
                r0 = r2.f5892d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.a():java.lang.String");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1919764332; // 0xffffffff8d92b894 float:-9.04238E-31 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5792a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.h();
                r0.i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5791a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.h();
                r0 = r2.m5793a();
                r0 = r3.b(r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleDocumentKickerModel m5802d() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m5794j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.d():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleDocumentKickerModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel m5803g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m5796l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.g():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$TitleModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel hW_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m5795k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.hW_():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel");
        }

        public RelatedArticleGlobalShareModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 5;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5800b() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f5893d;
            r1 = 0;
            r0 = super.a(r0, r1);
            r2.f5893d = r0;
            r0 = r2.f5893d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.b():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5801c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f5894e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f5894e = r0;
            r0 = r2.f5894e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.c():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleDocumentKickerModel m5794j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f5895f;
            r1 = 2;
            r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleDocumentKickerModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleDocumentKickerModel) r0;
            r3.f5895f = r0;
            r0 = r3.f5895f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.j():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleDocumentKickerModel");
        }

        @javax.annotation.Nullable
        private com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel m5795k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f5896g;
            r1 = 3;
            r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel) r0;
            r3.f5896g = r0;
            r0 = r3.f5896g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.k():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$LinkMediaModel");
        }

        @javax.annotation.Nullable
        private com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel m5796l() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f5897h;
            r1 = 4;
            r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel) r0;
            r3.f5897h = r0;
            r0 = r3.f5897h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.l():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RelatedArticleGlobalShareModel$TitleModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5799a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.m5801c();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.a():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 514783620; // 0x1eaef984 float:1.8526164E-20 double:2.543369017E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m5798a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m5794j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m5794j();
            r0 = r4.b(r0);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleDocumentKickerModel) r0;
            r2 = r3.m5794j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel) r1;
            r1.f5895f = r0;
        L_0x0022:
            r0 = r3.m5795k();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m5795k();
            r0 = r4.b(r0);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.LinkMediaModel) r0;
            r2 = r3.m5795k();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel) r1;
            r1.f5896g = r0;
        L_0x0040:
            r0 = r3.m5796l();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m5796l();
            r0 = r4.b(r0);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.TitleModel) r0;
            r2 = r3.m5796l();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel) r1;
            r1.f5897h = r0;
        L_0x005e:
            r3.i();
            if (r1 != 0) goto L_0x0064;
        L_0x0063:
            return r3;
        L_0x0064:
            r3 = r1;
            goto L_0x0063;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m5797a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r6.h();
            r0 = r6.m5800b();
            r0 = r7.b(r0);
            r1 = r6.m5801c();
            r1 = r7.b(r1);
            r2 = r6.m5794j();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r2);
            r3 = r6.m5795k();
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r3);
            r4 = r6.m5796l();
            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r4);
            r5 = 5;
            r7.c(r5);
            r5 = 0;
            r7.b(r5, r0);
            r0 = 1;
            r7.b(r0, r1);
            r0 = 2;
            r7.b(r0, r2);
            r0 = 3;
            r7.b(r0, r3);
            r0 = 4;
            r7.b(r0, r4);
            r6.i();
            r0 = r7.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1663643602)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentAuthorEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RichDocumentAuthorModel f5898d;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentAuthorEdgeModel.class, new Deserializer());
            }

            public Object m5804a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentAuthorEdgeParser.m6493b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentAuthorEdgeModel = new RichDocumentAuthorEdgeModel();
                ((BaseModel) richDocumentAuthorEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentAuthorEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentAuthorEdgeModel).a();
                }
                return richDocumentAuthorEdgeModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentAuthorEdgeModel> {
            public final void m5805a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentAuthorEdgeModel richDocumentAuthorEdgeModel = (RichDocumentAuthorEdgeModel) obj;
                if (richDocumentAuthorEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentAuthorEdgeModel.m5807a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentAuthorEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentAuthorEdgeParser.m6494b(richDocumentAuthorEdgeModel.w_(), richDocumentAuthorEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentAuthorEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentAuthorModel m5809a() {
            return m5806j();
        }

        public RichDocumentAuthorEdgeModel() {
            super(1);
        }

        @Nullable
        private RichDocumentAuthorModel m5806j() {
            this.f5898d = (RichDocumentAuthorModel) super.a(this.f5898d, 0, RichDocumentAuthorModel.class);
            return this.f5898d;
        }

        public final int jK_() {
            return -1694929105;
        }

        public final GraphQLVisitableModel m5808a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5806j() != null) {
                RichDocumentAuthorModel richDocumentAuthorModel = (RichDocumentAuthorModel) graphQLModelMutatingVisitor.b(m5806j());
                if (m5806j() != richDocumentAuthorModel) {
                    graphQLVisitableModel = (RichDocumentAuthorEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5898d = richDocumentAuthorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5807a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5806j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2115163305)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentAuthorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private RichDocumentTextModel f5906d;
        @Nullable
        private String f5907e;
        @Nullable
        private String f5908f;
        @Nullable
        private String f5909g;
        private boolean f5910h;
        private boolean f5911i;
        @Nullable
        private ProfileModel f5912j;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentAuthorModel.class, new Deserializer());
            }

            public Object m5810a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentAuthorParser.m6497a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentAuthorModel = new RichDocumentAuthorModel();
                ((BaseModel) richDocumentAuthorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentAuthorModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentAuthorModel).a();
                }
                return richDocumentAuthorModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1322531247)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FBPage {
            @Nullable
            private GraphQLObjectType f5899d;
            private boolean f5900e;
            private boolean f5901f;
            @Nullable
            private String f5902g;
            @Nullable
            private String f5903h;
            @Nullable
            private FBFullImageFragmentModel f5904i;
            @Nullable
            private GraphQLSubscribeStatus f5905j;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m5811a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileParser.m6495a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileModel = new ProfileModel();
                    ((BaseModel) profileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileModel instanceof Postprocessable) {
                        return ((Postprocessable) profileModel).a();
                    }
                    return profileModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m5812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m5816a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileParser.m6496a(profileModel.w_(), profileModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel mo313g() {
                return m5815j();
            }

            public ProfileModel() {
                super(7);
            }

            public final void m5820a(String str, ConsistencyTuple consistencyTuple) {
                if ("does_viewer_like".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(mo311c());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = ia_();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m5821a(String str, Object obj, boolean z) {
                if ("does_viewer_like".equals(str)) {
                    m5814a(((Boolean) obj).booleanValue());
                } else if ("subscribe_status".equals(str)) {
                    m5813a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType hZ_() {
                if (this.b != null && this.f5899d == null) {
                    this.f5899d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5899d;
            }

            public final boolean mo310b() {
                a(0, 1);
                return this.f5900e;
            }

            public final boolean mo311c() {
                a(0, 2);
                return this.f5901f;
            }

            private void m5814a(boolean z) {
                this.f5901f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            @Nullable
            public final String mo312d() {
                this.f5902g = super.a(this.f5902g, 3);
                return this.f5902g;
            }

            @Nullable
            public final String hR_() {
                this.f5903h = super.a(this.f5903h, 4);
                return this.f5903h;
            }

            @Nullable
            private FBFullImageFragmentModel m5815j() {
                this.f5904i = (FBFullImageFragmentModel) super.a(this.f5904i, 5, FBFullImageFragmentModel.class);
                return this.f5904i;
            }

            @Nullable
            public final GraphQLSubscribeStatus ia_() {
                this.f5905j = (GraphQLSubscribeStatus) super.b(this.f5905j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5905j;
            }

            private void m5813a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f5905j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m5818a() {
                return mo312d();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m5817a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5815j() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m5815j());
                    if (m5815j() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (ProfileModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5904i = fBFullImageFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5816a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, hZ_());
                int b = flatBufferBuilder.b(mo312d());
                int b2 = flatBufferBuilder.b(hR_());
                int a2 = ModelHelper.a(flatBufferBuilder, m5815j());
                int a3 = flatBufferBuilder.a(ia_());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f5900e);
                flatBufferBuilder.a(2, this.f5901f);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5819a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5900e = mutableFlatBuffer.a(i, 1);
                this.f5901f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentAuthorModel> {
            public final void m5826a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentAuthorModel richDocumentAuthorModel = (RichDocumentAuthorModel) obj;
                if (richDocumentAuthorModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentAuthorModel.m5829a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentAuthorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentAuthorParser.m6498a(richDocumentAuthorModel.w_(), richDocumentAuthorModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentAuthorModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentText m5833b() {
            return m5827j();
        }

        @Nullable
        public final /* synthetic */ ProfileModel hY_() {
            return m5828k();
        }

        public RichDocumentAuthorModel() {
            super(7);
        }

        @Nullable
        private RichDocumentTextModel m5827j() {
            this.f5906d = (RichDocumentTextModel) super.a(this.f5906d, 0, RichDocumentTextModel.class);
            return this.f5906d;
        }

        @Nullable
        public final String m5834c() {
            this.f5907e = super.a(this.f5907e, 1);
            return this.f5907e;
        }

        @Nullable
        public final String m5835d() {
            this.f5908f = super.a(this.f5908f, 2);
            return this.f5908f;
        }

        @Nullable
        public final String hX_() {
            this.f5909g = super.a(this.f5909g, 3);
            return this.f5909g;
        }

        public final boolean m5836g() {
            a(0, 4);
            return this.f5910h;
        }

        @Nullable
        private ProfileModel m5828k() {
            this.f5912j = (ProfileModel) super.a(this.f5912j, 6, ProfileModel.class);
            return this.f5912j;
        }

        @Nullable
        public final String m5831a() {
            return hX_();
        }

        public final int jK_() {
            return 48048806;
        }

        public final GraphQLVisitableModel m5830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5827j() != null) {
                RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5827j());
                if (m5827j() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentAuthorModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5906d = richDocumentTextModel;
                }
            }
            if (m5828k() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(m5828k());
                if (m5828k() != profileModel) {
                    graphQLVisitableModel = (RichDocumentAuthorModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5912j = profileModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5829a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5827j());
            int b = flatBufferBuilder.b(m5834c());
            int b2 = flatBufferBuilder.b(m5835d());
            int b3 = flatBufferBuilder.b(hX_());
            int a2 = ModelHelper.a(flatBufferBuilder, m5828k());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.a(4, this.f5910h);
            flatBufferBuilder.a(5, this.f5911i);
            flatBufferBuilder.b(6, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5832a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5910h = mutableFlatBuffer.a(i, 4);
            this.f5911i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1283507348)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentBylineModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLDocumentAuthorStyle f5913d;
        @Nullable
        private GraphQLDocumentDateStyle f5914e;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentBylineModel.class, new Deserializer());
            }

            public Object m5837a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentBylineParser.m6499a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentBylineModel = new RichDocumentBylineModel();
                ((BaseModel) richDocumentBylineModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentBylineModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentBylineModel).a();
                }
                return richDocumentBylineModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentBylineModel> {
            public final void m5838a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentBylineModel richDocumentBylineModel = (RichDocumentBylineModel) obj;
                if (richDocumentBylineModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentBylineModel.m5839a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentBylineModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentBylineParser.m6500a(richDocumentBylineModel.w_(), richDocumentBylineModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentBylineModel.class, new Serializer());
            }
        }

        public RichDocumentBylineModel() {
            super(2);
        }

        @Nullable
        public final GraphQLDocumentAuthorStyle m5840a() {
            this.f5913d = (GraphQLDocumentAuthorStyle) super.b(this.f5913d, 0, GraphQLDocumentAuthorStyle.class, GraphQLDocumentAuthorStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5913d;
        }

        @Nullable
        public final GraphQLDocumentDateStyle m5842b() {
            this.f5914e = (GraphQLDocumentDateStyle) super.b(this.f5914e, 1, GraphQLDocumentDateStyle.class, GraphQLDocumentDateStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5914e;
        }

        public final int jK_() {
            return 80134630;
        }

        public final GraphQLVisitableModel m5841a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5839a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m5840a());
            int a2 = flatBufferBuilder.a(m5842b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -351078311)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentEdgeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentEdge {
        @Nullable
        private String f5939d;
        private int f5940e;
        @Nullable
        private RichDocumentTextModel f5941f;
        @Nullable
        private CoverMediaModel f5942g;
        @Nullable
        private RichDocumentTextModel f5943h;
        @Nullable
        private DocumentAuthorsModel f5944i;
        @Nullable
        private DocumentBodyElementsModel f5945j;
        @Nullable
        private RichDocumentTextModel f5946k;
        @Nullable
        private RichDocumentTextModel f5947l;
        @Nullable
        private FBPageModel f5948m;
        @Nullable
        private RichDocumentStyleModel f5949n;
        @Nullable
        private RichDocumentTextModel f5950o;
        @Nullable
        private RichDocumentTextModel f5951p;
        @Nullable
        private GraphQLFeedback f5952q;
        @Nullable
        private GraphQLDocumentFeedbackOptions f5953r;
        @Nullable
        private GraphQLDocumentFormatVersion f5954s;
        @Nullable
        private String f5955t;
        private long f5956u;
        @Nullable
        private GraphQLInstantArticlePublishStatus f5957v;
        private long f5958w;
        @Nullable
        private GraphQLDocumentTextDirectionEnum f5959x;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1126797723)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: photo_picker_camera_cancelled */
        public final class CoverMediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentPhoto, RichDocumentSlideshow, RichDocumentVideo {
            @Nullable
            private GraphQLObjectType f5915d;
            @Nullable
            private GraphQLAudioAnnotationPlayMode f5916e;
            @Nullable
            private RichDocumentTextAnnotationModel f5917f;
            @Nullable
            private String f5918g;
            @Nullable
            private RichDocumentTextAnnotationModel f5919h;
            @Nullable
            private GraphQLDocumentElementType f5920i;
            @Nullable
            private FBVideoModel f5921j;
            @Nullable
            private GraphQLFeedback f5922k;
            @Nullable
            private GraphQLDocumentFeedbackOptions f5923l;
            @Nullable
            private String f5924m;
            @Nullable
            private RichDocumentLocationAnnotationModel f5925n;
            @Nullable
            private FBPhotoModel f5926o;
            @Nullable
            private FBPhotoModel f5927p;
            @Nullable
            private GraphQLDocumentMediaPresentationStyle f5928q;
            @Nullable
            private SlideEdgesModel f5929r;
            @Nullable
            private RichDocumentTextAnnotationModel f5930s;
            @Nullable
            private RichDocumentTextAnnotationModel f5931t;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f5932u;
            @Nullable
            private GraphQLDocumentVideoControlStyle f5933v;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f5934w;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverMediaModel.class, new Deserializer());
                }

                public Object m5843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverMediaParser.m6501a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverMediaModel = new CoverMediaModel();
                    ((BaseModel) coverMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverMediaModel instanceof Postprocessable) {
                        return ((Postprocessable) coverMediaModel).a();
                    }
                    return coverMediaModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<CoverMediaModel> {
                public final void m5844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverMediaModel coverMediaModel = (CoverMediaModel) obj;
                    if (coverMediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverMediaModel.m5854a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverMediaParser.m6502a(coverMediaModel.w_(), coverMediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverMediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m5859d() {
                return m5850w();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m5860g() {
                return m5851x();
            }

            @Nullable
            public final /* synthetic */ FBVideo ig_() {
                return m5852y();
            }

            @Nullable
            public final /* synthetic */ RichDocumentLocationAnnotationModel m5864m() {
                return m5853z();
            }

            @Nullable
            public final /* synthetic */ FBPhoto mo340n() {
                return m5845A();
            }

            @Nullable
            public final /* synthetic */ FBPhoto m5866o() {
                return m5846B();
            }

            @Nullable
            public final /* synthetic */ SlideEdgesModel m5868q() {
                return m5847C();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m5869r() {
                return m5848D();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m5870s() {
                return m5849E();
            }

            public CoverMediaModel() {
                super(20);
            }

            @Nullable
            public final GraphQLObjectType m5857b() {
                if (this.b != null && this.f5915d == null) {
                    this.f5915d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5915d;
            }

            @Nullable
            public final GraphQLAudioAnnotationPlayMode m5858c() {
                this.f5916e = (GraphQLAudioAnnotationPlayMode) super.b(this.f5916e, 1, GraphQLAudioAnnotationPlayMode.class, GraphQLAudioAnnotationPlayMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5916e;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5850w() {
                this.f5917f = (RichDocumentTextAnnotationModel) super.a(this.f5917f, 2, RichDocumentTextAnnotationModel.class);
                return this.f5917f;
            }

            @Nullable
            public final String ie_() {
                this.f5918g = super.a(this.f5918g, 3);
                return this.f5918g;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5851x() {
                this.f5919h = (RichDocumentTextAnnotationModel) super.a(this.f5919h, 4, RichDocumentTextAnnotationModel.class);
                return this.f5919h;
            }

            @Nullable
            public final GraphQLDocumentElementType if_() {
                this.f5920i = (GraphQLDocumentElementType) super.b(this.f5920i, 5, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5920i;
            }

            @Nullable
            private FBVideoModel m5852y() {
                this.f5921j = (FBVideoModel) super.a(this.f5921j, 6, FBVideoModel.class);
                return this.f5921j;
            }

            @Nullable
            public final GraphQLFeedback m5861j() {
                this.f5922k = (GraphQLFeedback) super.a(this.f5922k, 7, GraphQLFeedback.class);
                return this.f5922k;
            }

            @Nullable
            public final GraphQLDocumentFeedbackOptions m5862k() {
                this.f5923l = (GraphQLDocumentFeedbackOptions) super.b(this.f5923l, 8, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5923l;
            }

            @Nullable
            public final String m5863l() {
                this.f5924m = super.a(this.f5924m, 9);
                return this.f5924m;
            }

            @Nullable
            private RichDocumentLocationAnnotationModel m5853z() {
                this.f5925n = (RichDocumentLocationAnnotationModel) super.a(this.f5925n, 10, RichDocumentLocationAnnotationModel.class);
                return this.f5925n;
            }

            @Nullable
            private FBPhotoModel m5845A() {
                this.f5926o = (FBPhotoModel) super.a(this.f5926o, 11, FBPhotoModel.class);
                return this.f5926o;
            }

            @Nullable
            private FBPhotoModel m5846B() {
                this.f5927p = (FBPhotoModel) super.a(this.f5927p, 12, FBPhotoModel.class);
                return this.f5927p;
            }

            @Nullable
            public final GraphQLDocumentMediaPresentationStyle m5867p() {
                this.f5928q = (GraphQLDocumentMediaPresentationStyle) super.b(this.f5928q, 13, GraphQLDocumentMediaPresentationStyle.class, GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5928q;
            }

            @Nullable
            private SlideEdgesModel m5847C() {
                this.f5929r = (SlideEdgesModel) super.a(this.f5929r, 14, SlideEdgesModel.class);
                return this.f5929r;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5848D() {
                this.f5930s = (RichDocumentTextAnnotationModel) super.a(this.f5930s, 15, RichDocumentTextAnnotationModel.class);
                return this.f5930s;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5849E() {
                this.f5931t = (RichDocumentTextAnnotationModel) super.a(this.f5931t, 16, RichDocumentTextAnnotationModel.class);
                return this.f5931t;
            }

            @Nullable
            public final GraphQLDocumentVideoAutoplayStyle m5871t() {
                this.f5932u = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f5932u, 17, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5932u;
            }

            @Nullable
            public final GraphQLDocumentVideoControlStyle m5872u() {
                this.f5933v = (GraphQLDocumentVideoControlStyle) super.b(this.f5933v, 18, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5933v;
            }

            @Nullable
            public final GraphQLDocumentVideoLoopingStyle m5873v() {
                this.f5934w = (GraphQLDocumentVideoLoopingStyle) super.b(this.f5934w, 19, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5934w;
            }

            @Nullable
            public final String m5856a() {
                return m5863l();
            }

            public final int jK_() {
                return 473184577;
            }

            public final GraphQLVisitableModel m5855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                RichDocumentTextAnnotationModel richDocumentTextAnnotationModel;
                FBPhotoModel fBPhotoModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5850w() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5850w());
                    if (m5850w() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5917f = richDocumentTextAnnotationModel;
                    }
                }
                if (m5851x() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5851x());
                    if (m5851x() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5919h = richDocumentTextAnnotationModel;
                    }
                }
                if (m5852y() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m5852y());
                    if (m5852y() != fBVideoModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5921j = fBVideoModel;
                    }
                }
                if (m5861j() != null) {
                    GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m5861j());
                    if (m5861j() != graphQLFeedback) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5922k = graphQLFeedback;
                    }
                }
                if (m5853z() != null) {
                    RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel = (RichDocumentLocationAnnotationModel) graphQLModelMutatingVisitor.b(m5853z());
                    if (m5853z() != richDocumentLocationAnnotationModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5925n = richDocumentLocationAnnotationModel;
                    }
                }
                if (m5845A() != null) {
                    fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m5845A());
                    if (m5845A() != fBPhotoModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5926o = fBPhotoModel;
                    }
                }
                if (m5846B() != null) {
                    fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m5846B());
                    if (m5846B() != fBPhotoModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5927p = fBPhotoModel;
                    }
                }
                if (m5847C() != null) {
                    SlideEdgesModel slideEdgesModel = (SlideEdgesModel) graphQLModelMutatingVisitor.b(m5847C());
                    if (m5847C() != slideEdgesModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5929r = slideEdgesModel;
                    }
                }
                if (m5848D() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5848D());
                    if (m5848D() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5930s = richDocumentTextAnnotationModel;
                    }
                }
                if (m5849E() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5849E());
                    if (m5849E() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (CoverMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5931t = richDocumentTextAnnotationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5854a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5857b());
                int a2 = flatBufferBuilder.a(m5858c());
                int a3 = ModelHelper.a(flatBufferBuilder, m5850w());
                int b = flatBufferBuilder.b(ie_());
                int a4 = ModelHelper.a(flatBufferBuilder, m5851x());
                int a5 = flatBufferBuilder.a(if_());
                int a6 = ModelHelper.a(flatBufferBuilder, m5852y());
                int a7 = ModelHelper.a(flatBufferBuilder, m5861j());
                int a8 = flatBufferBuilder.a(m5862k());
                int b2 = flatBufferBuilder.b(m5863l());
                int a9 = ModelHelper.a(flatBufferBuilder, m5853z());
                int a10 = ModelHelper.a(flatBufferBuilder, m5845A());
                int a11 = ModelHelper.a(flatBufferBuilder, m5846B());
                int a12 = flatBufferBuilder.a(m5867p());
                int a13 = ModelHelper.a(flatBufferBuilder, m5847C());
                int a14 = ModelHelper.a(flatBufferBuilder, m5848D());
                int a15 = ModelHelper.a(flatBufferBuilder, m5849E());
                int a16 = flatBufferBuilder.a(m5871t());
                int a17 = flatBufferBuilder.a(m5872u());
                int a18 = flatBufferBuilder.a(m5873v());
                flatBufferBuilder.c(20);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, b2);
                flatBufferBuilder.b(10, a9);
                flatBufferBuilder.b(11, a10);
                flatBufferBuilder.b(12, a11);
                flatBufferBuilder.b(13, a12);
                flatBufferBuilder.b(14, a13);
                flatBufferBuilder.b(15, a14);
                flatBufferBuilder.b(16, a15);
                flatBufferBuilder.b(17, a16);
                flatBufferBuilder.b(18, a17);
                flatBufferBuilder.b(19, a18);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentEdgeModel.class, new Deserializer());
            }

            public Object m5874a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentEdgeParser.m6507a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentEdgeModel = new RichDocumentEdgeModel();
                ((BaseModel) richDocumentEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentEdgeModel).a();
                }
                return richDocumentEdgeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1286768236)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class DocumentAuthorsModel extends BaseModel implements GraphQLVisitableModel, DocumentAuthors {
            @Nullable
            private List<RichDocumentAuthorEdgeModel> f5935d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DocumentAuthorsModel.class, new Deserializer());
                }

                public Object m5875a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DocumentAuthorsParser.m6503a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object documentAuthorsModel = new DocumentAuthorsModel();
                    ((BaseModel) documentAuthorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (documentAuthorsModel instanceof Postprocessable) {
                        return ((Postprocessable) documentAuthorsModel).a();
                    }
                    return documentAuthorsModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<DocumentAuthorsModel> {
                public final void m5876a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DocumentAuthorsModel documentAuthorsModel = (DocumentAuthorsModel) obj;
                    if (documentAuthorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(documentAuthorsModel.m5877a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        documentAuthorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DocumentAuthorsParser.m6504a(documentAuthorsModel.w_(), documentAuthorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DocumentAuthorsModel.class, new Serializer());
                }
            }

            public DocumentAuthorsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<RichDocumentAuthorEdgeModel> mo341a() {
                this.f5935d = super.a(this.f5935d, 0, RichDocumentAuthorEdgeModel.class);
                return (ImmutableList) this.f5935d;
            }

            public final int jK_() {
                return 567288528;
            }

            public final GraphQLVisitableModel m5878a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (mo341a() != null) {
                    Builder a = ModelHelper.a(mo341a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DocumentAuthorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5935d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5877a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo341a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -355862965)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: photo_picker_camera_cancelled */
        public final class DocumentBodyElementsModel extends BaseModel implements GraphQLVisitableModel, DocumentBodyElements {
            private int f5936d;
            @Nullable
            private List<RichDocumentSectionEdgeModel> f5937e;
            @Nullable
            private DefaultPageInfoFieldsModel f5938f;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DocumentBodyElementsModel.class, new Deserializer());
                }

                public Object m5880a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DocumentBodyElementsParser.m6505a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object documentBodyElementsModel = new DocumentBodyElementsModel();
                    ((BaseModel) documentBodyElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (documentBodyElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) documentBodyElementsModel).a();
                    }
                    return documentBodyElementsModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<DocumentBodyElementsModel> {
                public final void m5881a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) obj;
                    if (documentBodyElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(documentBodyElementsModel.m5883a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        documentBodyElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DocumentBodyElementsParser.m6506a(documentBodyElementsModel.w_(), documentBodyElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DocumentBodyElementsModel.class, new Serializer());
                }
            }

            public DocumentBodyElementsModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<RichDocumentSectionEdgeModel> mo342a() {
                this.f5937e = super.a(this.f5937e, 1, RichDocumentSectionEdgeModel.class);
                return (ImmutableList) this.f5937e;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m5882j() {
                this.f5938f = (DefaultPageInfoFieldsModel) super.a(this.f5938f, 2, DefaultPageInfoFieldsModel.class);
                return this.f5938f;
            }

            public final int jK_() {
                return -1673554030;
            }

            public final GraphQLVisitableModel m5884a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (mo342a() != null) {
                    Builder a = ModelHelper.a(mo342a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) ModelHelper.a(null, this);
                        documentBodyElementsModel.f5937e = a.b();
                        graphQLVisitableModel = documentBodyElementsModel;
                        if (m5882j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5882j());
                            if (m5882j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (DocumentBodyElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f5938f = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m5882j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5882j());
                    if (m5882j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (DocumentBodyElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5938f = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m5883a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo342a());
                int a2 = ModelHelper.a(flatBufferBuilder, m5882j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f5936d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5886a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5936d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentEdgeModel> {
            public final void m5887a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentEdgeModel richDocumentEdgeModel = (RichDocumentEdgeModel) obj;
                if (richDocumentEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentEdgeModel.m5903a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentEdgeParser.m6508a(richDocumentEdgeModel.w_(), richDocumentEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo345d() {
            return m5894r();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo346g() {
            return m5896t();
        }

        @Nullable
        public final /* synthetic */ DocumentBodyElements ib_() {
            return m5898v();
        }

        @Nullable
        public final /* synthetic */ DocumentAuthors ic_() {
            return m5897u();
        }

        @Nullable
        public final /* synthetic */ CoverMediaModel id_() {
            return m5895s();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo350j() {
            return m5900x();
        }

        @Nullable
        public final /* synthetic */ FBPage mo351k() {
            return m5901y();
        }

        @Nullable
        public final /* synthetic */ RichDocumentStyleModel mo352l() {
            return m5902z();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo353m() {
            return m5888A();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo354n() {
            return m5889B();
        }

        public RichDocumentEdgeModel() {
            super(21);
        }

        @Nullable
        public final String mo343b() {
            this.f5939d = super.a(this.f5939d, 0);
            return this.f5939d;
        }

        public final int mo344c() {
            a(0, 1);
            return this.f5940e;
        }

        @Nullable
        private RichDocumentTextModel m5894r() {
            this.f5941f = (RichDocumentTextModel) super.a(this.f5941f, 2, RichDocumentTextModel.class);
            return this.f5941f;
        }

        @Nullable
        private CoverMediaModel m5895s() {
            this.f5942g = (CoverMediaModel) super.a(this.f5942g, 3, CoverMediaModel.class);
            return this.f5942g;
        }

        @Nullable
        private RichDocumentTextModel m5896t() {
            this.f5943h = (RichDocumentTextModel) super.a(this.f5943h, 4, RichDocumentTextModel.class);
            return this.f5943h;
        }

        @Nullable
        private DocumentAuthorsModel m5897u() {
            this.f5944i = (DocumentAuthorsModel) super.a(this.f5944i, 5, DocumentAuthorsModel.class);
            return this.f5944i;
        }

        @Nullable
        private DocumentBodyElementsModel m5898v() {
            this.f5945j = (DocumentBodyElementsModel) super.a(this.f5945j, 6, DocumentBodyElementsModel.class);
            return this.f5945j;
        }

        @Nullable
        private RichDocumentTextModel m5899w() {
            this.f5946k = (RichDocumentTextModel) super.a(this.f5946k, 7, RichDocumentTextModel.class);
            return this.f5946k;
        }

        @Nullable
        private RichDocumentTextModel m5900x() {
            this.f5947l = (RichDocumentTextModel) super.a(this.f5947l, 8, RichDocumentTextModel.class);
            return this.f5947l;
        }

        @Nullable
        private FBPageModel m5901y() {
            this.f5948m = (FBPageModel) super.a(this.f5948m, 9, FBPageModel.class);
            return this.f5948m;
        }

        @Nullable
        private RichDocumentStyleModel m5902z() {
            this.f5949n = (RichDocumentStyleModel) super.a(this.f5949n, 10, RichDocumentStyleModel.class);
            return this.f5949n;
        }

        @Nullable
        private RichDocumentTextModel m5888A() {
            this.f5950o = (RichDocumentTextModel) super.a(this.f5950o, 11, RichDocumentTextModel.class);
            return this.f5950o;
        }

        @Nullable
        private RichDocumentTextModel m5889B() {
            this.f5951p = (RichDocumentTextModel) super.a(this.f5951p, 12, RichDocumentTextModel.class);
            return this.f5951p;
        }

        @Nullable
        private GraphQLFeedback m5890C() {
            this.f5952q = (GraphQLFeedback) super.a(this.f5952q, 13, GraphQLFeedback.class);
            return this.f5952q;
        }

        @Nullable
        private GraphQLDocumentFeedbackOptions m5891D() {
            this.f5953r = (GraphQLDocumentFeedbackOptions) super.b(this.f5953r, 14, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5953r;
        }

        @Nullable
        private GraphQLDocumentFormatVersion m5892E() {
            this.f5954s = (GraphQLDocumentFormatVersion) super.b(this.f5954s, 15, GraphQLDocumentFormatVersion.class, GraphQLDocumentFormatVersion.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5954s;
        }

        @Nullable
        public final String mo355o() {
            this.f5955t = super.a(this.f5955t, 16);
            return this.f5955t;
        }

        @Nullable
        private GraphQLInstantArticlePublishStatus m5893F() {
            this.f5957v = (GraphQLInstantArticlePublishStatus) super.b(this.f5957v, 18, GraphQLInstantArticlePublishStatus.class, GraphQLInstantArticlePublishStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5957v;
        }

        public final long mo356p() {
            a(2, 3);
            return this.f5958w;
        }

        @Nullable
        public final GraphQLDocumentTextDirectionEnum mo357q() {
            this.f5959x = (GraphQLDocumentTextDirectionEnum) super.b(this.f5959x, 20, GraphQLDocumentTextDirectionEnum.class, GraphQLDocumentTextDirectionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5959x;
        }

        @Nullable
        public final String m5905a() {
            return mo355o();
        }

        public final int jK_() {
            return 1619159843;
        }

        public final GraphQLVisitableModel m5904a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            RichDocumentTextModel richDocumentTextModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5894r() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5894r());
                if (m5894r() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5941f = richDocumentTextModel;
                }
            }
            if (m5895s() != null) {
                CoverMediaModel coverMediaModel = (CoverMediaModel) graphQLModelMutatingVisitor.b(m5895s());
                if (m5895s() != coverMediaModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5942g = coverMediaModel;
                }
            }
            if (m5896t() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5896t());
                if (m5896t() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5943h = richDocumentTextModel;
                }
            }
            if (m5897u() != null) {
                DocumentAuthorsModel documentAuthorsModel = (DocumentAuthorsModel) graphQLModelMutatingVisitor.b(m5897u());
                if (m5897u() != documentAuthorsModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5944i = documentAuthorsModel;
                }
            }
            if (m5898v() != null) {
                DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) graphQLModelMutatingVisitor.b(m5898v());
                if (m5898v() != documentBodyElementsModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5945j = documentBodyElementsModel;
                }
            }
            if (m5899w() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5899w());
                if (m5899w() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5946k = richDocumentTextModel;
                }
            }
            if (m5900x() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5900x());
                if (m5900x() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5947l = richDocumentTextModel;
                }
            }
            if (m5901y() != null) {
                FBPageModel fBPageModel = (FBPageModel) graphQLModelMutatingVisitor.b(m5901y());
                if (m5901y() != fBPageModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5948m = fBPageModel;
                }
            }
            if (m5902z() != null) {
                RichDocumentStyleModel richDocumentStyleModel = (RichDocumentStyleModel) graphQLModelMutatingVisitor.b(m5902z());
                if (m5902z() != richDocumentStyleModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5949n = richDocumentStyleModel;
                }
            }
            if (m5888A() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5888A());
                if (m5888A() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5950o = richDocumentTextModel;
                }
            }
            if (m5889B() != null) {
                richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5889B());
                if (m5889B() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5951p = richDocumentTextModel;
                }
            }
            if (m5890C() != null) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m5890C());
                if (m5890C() != graphQLFeedback) {
                    graphQLVisitableModel = (RichDocumentEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5952q = graphQLFeedback;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5903a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo343b());
            int a = ModelHelper.a(flatBufferBuilder, m5894r());
            int a2 = ModelHelper.a(flatBufferBuilder, m5895s());
            int a3 = ModelHelper.a(flatBufferBuilder, m5896t());
            int a4 = ModelHelper.a(flatBufferBuilder, m5897u());
            int a5 = ModelHelper.a(flatBufferBuilder, m5898v());
            int a6 = ModelHelper.a(flatBufferBuilder, m5899w());
            int a7 = ModelHelper.a(flatBufferBuilder, m5900x());
            int a8 = ModelHelper.a(flatBufferBuilder, m5901y());
            int a9 = ModelHelper.a(flatBufferBuilder, m5902z());
            int a10 = ModelHelper.a(flatBufferBuilder, m5888A());
            int a11 = ModelHelper.a(flatBufferBuilder, m5889B());
            int a12 = ModelHelper.a(flatBufferBuilder, m5890C());
            int a13 = flatBufferBuilder.a(m5891D());
            int a14 = flatBufferBuilder.a(m5892E());
            int b2 = flatBufferBuilder.b(mo355o());
            int a15 = flatBufferBuilder.a(m5893F());
            int a16 = flatBufferBuilder.a(mo357q());
            flatBufferBuilder.c(21);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f5940e, 0);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, a9);
            flatBufferBuilder.b(11, a10);
            flatBufferBuilder.b(12, a11);
            flatBufferBuilder.b(13, a12);
            flatBufferBuilder.b(14, a13);
            flatBufferBuilder.b(15, a14);
            flatBufferBuilder.b(16, b2);
            flatBufferBuilder.a(17, this.f5956u, 0);
            flatBufferBuilder.b(18, a15);
            flatBufferBuilder.a(19, this.f5958w, 0);
            flatBufferBuilder.b(20, a16);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5906a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5940e = mutableFlatBuffer.a(i, 1, 0);
            this.f5956u = mutableFlatBuffer.a(i, 17, 0);
            this.f5958w = mutableFlatBuffer.a(i, 19, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 731420551)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentElementStyleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLCapitalizationStyle f5960d;
        @Nullable
        private String f5961e;
        @Nullable
        private String f5962f;
        @Nullable
        private String f5963g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentElementStyleModel.class, new Deserializer());
            }

            public Object m5919a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentElementStyleModel = new RichDocumentElementStyleModel();
                ((BaseModel) richDocumentElementStyleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentElementStyleModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentElementStyleModel).a();
                }
                return richDocumentElementStyleModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentElementStyleModel> {
            public final void m5920a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentElementStyleModel richDocumentElementStyleModel = (RichDocumentElementStyleModel) obj;
                if (richDocumentElementStyleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentElementStyleModel.m5921a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentElementStyleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentElementStyleParser.m6510a(richDocumentElementStyleModel.w_(), richDocumentElementStyleModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentElementStyleModel.class, new Serializer());
            }
        }

        public RichDocumentElementStyleModel() {
            super(4);
        }

        @Nullable
        public final GraphQLCapitalizationStyle m5922a() {
            this.f5960d = (GraphQLCapitalizationStyle) super.b(this.f5960d, 0, GraphQLCapitalizationStyle.class, GraphQLCapitalizationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5960d;
        }

        @Nullable
        public final String m5924b() {
            this.f5961e = super.a(this.f5961e, 1);
            return this.f5961e;
        }

        @Nullable
        public final String m5925c() {
            this.f5962f = super.a(this.f5962f, 2);
            return this.f5962f;
        }

        @Nullable
        public final String m5926d() {
            this.f5963g = super.a(this.f5963g, 3);
            return this.f5963g;
        }

        public final int jK_() {
            return 721651942;
        }

        public final GraphQLVisitableModel m5923a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5921a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m5922a());
            int b = flatBufferBuilder.b(m5924b());
            int b2 = flatBufferBuilder.b(m5925c());
            int b3 = flatBufferBuilder.b(m5926d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -588350329)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentFontResourceModel extends BaseModel implements GraphQLVisitableModel, RichDocumentFontResource {
        private boolean f5964d;
        private boolean f5965e;
        @Nullable
        private String f5966f;
        @Nullable
        private String f5967g;
        @Nullable
        private String f5968h;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentFontResourceModel.class, new Deserializer());
            }

            public Object m5927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentFontResourceParser.m6514b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentFontResourceModel = new RichDocumentFontResourceModel();
                ((BaseModel) richDocumentFontResourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentFontResourceModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentFontResourceModel).a();
                }
                return richDocumentFontResourceModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentFontResourceModel> {
            public final void m5928a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentFontResourceModel richDocumentFontResourceModel = (RichDocumentFontResourceModel) obj;
                if (richDocumentFontResourceModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentFontResourceModel.m5929a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentFontResourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentFontResourceParser.m6512a(richDocumentFontResourceModel.w_(), richDocumentFontResourceModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentFontResourceModel.class, new Serializer());
            }
        }

        public RichDocumentFontResourceModel() {
            super(5);
        }

        @Nullable
        public final String mo25a() {
            this.f5966f = super.a(this.f5966f, 2);
            return this.f5966f;
        }

        @Nullable
        public final String mo26b() {
            this.f5967g = super.a(this.f5967g, 3);
            return this.f5967g;
        }

        @Nullable
        public final String mo27c() {
            this.f5968h = super.a(this.f5968h, 4);
            return this.f5968h;
        }

        public final int jK_() {
            return -183108008;
        }

        public final GraphQLVisitableModel m5930a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5929a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo25a());
            int b2 = flatBufferBuilder.b(mo26b());
            int b3 = flatBufferBuilder.b(mo27c());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f5964d);
            flatBufferBuilder.a(1, this.f5965e);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5932a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5964d = mutableFlatBuffer.a(i, 0);
            this.f5965e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2025034196)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentGlobalShareModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f5973d;
        @Nullable
        private String f5974e;
        @Nullable
        private LinkMediaModel f5975f;
        @Nullable
        private TitleModel f5976g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentGlobalShareModel.class, new Deserializer());
            }

            public Object m5935a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentGlobalShareParser.m6521a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentGlobalShareModel = new RichDocumentGlobalShareModel();
                ((BaseModel) richDocumentGlobalShareModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentGlobalShareModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentGlobalShareModel).a();
                }
                return richDocumentGlobalShareModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1207531186)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class LinkMediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f5970d;
            @Nullable
            private ImageModel f5971e;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LinkMediaModel.class, new Deserializer());
                }

                public Object m5936a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LinkMediaParser.m6517a(jsonParser, flatBufferBuilder));
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
            /* compiled from: photo_picker_camera_cancelled */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f5969d;

                /* compiled from: photo_picker_camera_cancelled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m5937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m6515a(jsonParser, flatBufferBuilder));
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

                /* compiled from: photo_picker_camera_cancelled */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m5938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m5940a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m6516a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                @Nullable
                private String m5939a() {
                    this.f5969d = super.a(this.f5969d, 0);
                    return this.f5969d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m5941a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5940a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5939a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<LinkMediaModel> {
                public final void m5942a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LinkMediaModel linkMediaModel = (LinkMediaModel) obj;
                    if (linkMediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(linkMediaModel.m5945a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        linkMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LinkMediaParser.m6518a(linkMediaModel.w_(), linkMediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LinkMediaModel.class, new Serializer());
                }
            }

            public LinkMediaModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m5943a() {
                if (this.b != null && this.f5970d == null) {
                    this.f5970d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5970d;
            }

            @Nullable
            private ImageModel m5944j() {
                this.f5971e = (ImageModel) super.a(this.f5971e, 1, ImageModel.class);
                return this.f5971e;
            }

            public final int jK_() {
                return 74219460;
            }

            public final GraphQLVisitableModel m5946a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5944j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m5944j());
                    if (m5944j() != imageModel) {
                        graphQLVisitableModel = (LinkMediaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5971e = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5945a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5943a());
                int a2 = ModelHelper.a(flatBufferBuilder, m5944j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentGlobalShareModel> {
            public final void m5947a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentGlobalShareModel richDocumentGlobalShareModel = (RichDocumentGlobalShareModel) obj;
                if (richDocumentGlobalShareModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentGlobalShareModel.m5957a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentGlobalShareModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentGlobalShareParser.m6522a(richDocumentGlobalShareModel.w_(), richDocumentGlobalShareModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentGlobalShareModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f5972d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m5948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m6519a(jsonParser, flatBufferBuilder));
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

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m5949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m5951a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m6520a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            private String m5950a() {
                this.f5972d = super.a(this.f5972d, 0);
                return this.f5972d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m5952a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5951a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5950a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RichDocumentGlobalShareModel() {
            super(4);
        }

        @Nullable
        private String m5953j() {
            this.f5973d = super.a(this.f5973d, 0);
            return this.f5973d;
        }

        @Nullable
        private String m5954k() {
            this.f5974e = super.a(this.f5974e, 1);
            return this.f5974e;
        }

        @Nullable
        private LinkMediaModel m5955l() {
            this.f5975f = (LinkMediaModel) super.a(this.f5975f, 2, LinkMediaModel.class);
            return this.f5975f;
        }

        @Nullable
        private TitleModel m5956m() {
            this.f5976g = (TitleModel) super.a(this.f5976g, 3, TitleModel.class);
            return this.f5976g;
        }

        @Nullable
        public final String m5959a() {
            return m5954k();
        }

        public final int jK_() {
            return 514783620;
        }

        public final GraphQLVisitableModel m5958a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5955l() != null) {
                LinkMediaModel linkMediaModel = (LinkMediaModel) graphQLModelMutatingVisitor.b(m5955l());
                if (m5955l() != linkMediaModel) {
                    graphQLVisitableModel = (RichDocumentGlobalShareModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5975f = linkMediaModel;
                }
            }
            if (m5956m() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m5956m());
                if (m5956m() != titleModel) {
                    graphQLVisitableModel = (RichDocumentGlobalShareModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5976g = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5957a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5953j());
            int b2 = flatBufferBuilder.b(m5954k());
            int a = ModelHelper.a(flatBufferBuilder, m5955l());
            int a2 = ModelHelper.a(flatBufferBuilder, m5956m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1742059580)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentLinkStyleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5977d;
        @Nullable
        private String f5978e;
        @Nullable
        private GraphQLUnderlineStyle f5979f;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentLinkStyleModel.class, new Deserializer());
            }

            public Object m5960a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentLinkStyleParser.m6523a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentLinkStyleModel = new RichDocumentLinkStyleModel();
                ((BaseModel) richDocumentLinkStyleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentLinkStyleModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentLinkStyleModel).a();
                }
                return richDocumentLinkStyleModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentLinkStyleModel> {
            public final void m5961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentLinkStyleModel richDocumentLinkStyleModel = (RichDocumentLinkStyleModel) obj;
                if (richDocumentLinkStyleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentLinkStyleModel.m5962a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentLinkStyleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentLinkStyleParser.m6524a(richDocumentLinkStyleModel.w_(), richDocumentLinkStyleModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentLinkStyleModel.class, new Serializer());
            }
        }

        public RichDocumentLinkStyleModel() {
            super(3);
        }

        @Nullable
        public final String m5964a() {
            this.f5977d = super.a(this.f5977d, 0);
            return this.f5977d;
        }

        @Nullable
        public final String m5965b() {
            this.f5978e = super.a(this.f5978e, 1);
            return this.f5978e;
        }

        @Nullable
        public final GraphQLUnderlineStyle m5966c() {
            this.f5979f = (GraphQLUnderlineStyle) super.b(this.f5979f, 2, GraphQLUnderlineStyle.class, GraphQLUnderlineStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5979f;
        }

        public final int jK_() {
            return -1912994084;
        }

        public final GraphQLVisitableModel m5963a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5962a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5964a());
            int b2 = flatBufferBuilder.b(m5965b());
            int a = flatBufferBuilder.a(m5966c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1043311651)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentListItemEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RichDocumentListItemModel f6015d;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentListItemEdgeModel.class, new Deserializer());
            }

            public Object m5967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentListItemEdgeParser.m6527b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentListItemEdgeModel = new RichDocumentListItemEdgeModel();
                ((BaseModel) richDocumentListItemEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentListItemEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentListItemEdgeModel).a();
                }
                return richDocumentListItemEdgeModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -806931660)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: photo_picker_camera_cancelled */
        public final class RichDocumentListItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentNestedListItem, RichDocumentPhoto, RichDocumentRelatedArticles, RichDocumentSlideshow, RichDocumentVideo {
            @Nullable
            private FBPhotoModel f5980A;
            @Nullable
            private FBPhotoModel f5981B;
            @Nullable
            private GraphQLDocumentMediaPresentationStyle f5982C;
            @Nullable
            private RelatedArticleObjsModel f5983D;
            @Nullable
            private SlideEdgesModel f5984E;
            @Nullable
            private RichDocumentTextAnnotationModel f5985F;
            @Nullable
            private String f5986G;
            @Nullable
            private RichDocumentTextAnnotationModel f5987H;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f5988I;
            @Nullable
            private GraphQLDocumentVideoControlStyle f5989J;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f5990K;
            @Nullable
            private GraphQLDocumentWebviewPresentationStyle f5991L;
            @Nullable
            private GraphQLObjectType f5992d;
            @Nullable
            private GraphQLAudioAnnotationPlayMode f5993e;
            @Nullable
            private RichDocumentTextAnnotationModel f5994f;
            @Nullable
            private String f5995g;
            @Nullable
            private String f5996h;
            @Nullable
            private String f5997i;
            @Nullable
            private RichDocumentTextAnnotationModel f5998j;
            private int f5999k;
            private int f6000l;
            @Nullable
            private GraphQLDocumentElementType f6001m;
            @Nullable
            private RichDocumentTextModel f6002n;
            @Nullable
            private FBVideoModel f6003o;
            private boolean f6004p;
            @Nullable
            private GraphQLFeedback f6005q;
            @Nullable
            private GraphQLDocumentFeedbackOptions f6006r;
            @Nullable
            private String f6007s;
            @Nullable
            private String f6008t;
            @Nullable
            private LModel f6009u;
            @Nullable
            private GraphQLDocumentListStyle f6010v;
            @Nullable
            private RichDocumentLocationAnnotationModel f6011w;
            @Nullable
            private List<RichDocumentLocationAnnotationModel> f6012x;
            @Nullable
            private GraphQLDocumentMapStyle f6013y;
            @Nullable
            private GraphQLDocumentElementMarginStyle f6014z;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RichDocumentListItemModel.class, new Deserializer());
                }

                public Object m5968a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RichDocumentListItemParser.m6525a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object richDocumentListItemModel = new RichDocumentListItemModel();
                    ((BaseModel) richDocumentListItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (richDocumentListItemModel instanceof Postprocessable) {
                        return ((Postprocessable) richDocumentListItemModel).a();
                    }
                    return richDocumentListItemModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<RichDocumentListItemModel> {
                public final void m5969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RichDocumentListItemModel richDocumentListItemModel = (RichDocumentListItemModel) obj;
                    if (richDocumentListItemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(richDocumentListItemModel.m6000a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        richDocumentListItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RichDocumentListItemParser.m6526a(richDocumentListItemModel.w_(), richDocumentListItemModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RichDocumentListItemModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo359c() {
                return m5991r();
            }

            @Nullable
            public final /* synthetic */ LModel m6006d() {
                return m5997x();
            }

            @Nullable
            public final /* synthetic */ FBVideo ig_() {
                return m5992s();
            }

            @Nullable
            public final /* synthetic */ FBPhoto mo340n() {
                return m5972C();
            }

            public RichDocumentListItemModel() {
                super(35);
            }

            @Nullable
            private GraphQLObjectType m5984j() {
                if (this.b != null && this.f5992d == null) {
                    this.f5992d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5992d;
            }

            @Nullable
            private GraphQLAudioAnnotationPlayMode m5985k() {
                this.f5993e = (GraphQLAudioAnnotationPlayMode) super.b(this.f5993e, 1, GraphQLAudioAnnotationPlayMode.class, GraphQLAudioAnnotationPlayMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5993e;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5986l() {
                this.f5994f = (RichDocumentTextAnnotationModel) super.a(this.f5994f, 2, RichDocumentTextAnnotationModel.class);
                return this.f5994f;
            }

            @Nullable
            private String m5987m() {
                this.f5995g = super.a(this.f5995g, 3);
                return this.f5995g;
            }

            @Nullable
            private String m5988o() {
                this.f5996h = super.a(this.f5996h, 4);
                return this.f5996h;
            }

            @Nullable
            private String m5989p() {
                this.f5997i = super.a(this.f5997i, 5);
                return this.f5997i;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5990q() {
                this.f5998j = (RichDocumentTextAnnotationModel) super.a(this.f5998j, 6, RichDocumentTextAnnotationModel.class);
                return this.f5998j;
            }

            @Nullable
            public final GraphQLDocumentElementType mo358b() {
                this.f6001m = (GraphQLDocumentElementType) super.b(this.f6001m, 9, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6001m;
            }

            @Nullable
            private RichDocumentTextModel m5991r() {
                this.f6002n = (RichDocumentTextModel) super.a(this.f6002n, 10, RichDocumentTextModel.class);
                return this.f6002n;
            }

            @Nullable
            private FBVideoModel m5992s() {
                this.f6003o = (FBVideoModel) super.a(this.f6003o, 11, FBVideoModel.class);
                return this.f6003o;
            }

            @Nullable
            private GraphQLFeedback m5993t() {
                this.f6005q = (GraphQLFeedback) super.a(this.f6005q, 13, GraphQLFeedback.class);
                return this.f6005q;
            }

            @Nullable
            private GraphQLDocumentFeedbackOptions m5994u() {
                this.f6006r = (GraphQLDocumentFeedbackOptions) super.b(this.f6006r, 14, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6006r;
            }

            @Nullable
            private String m5995v() {
                this.f6007s = super.a(this.f6007s, 15);
                return this.f6007s;
            }

            @Nullable
            private String m5996w() {
                this.f6008t = super.a(this.f6008t, 16);
                return this.f6008t;
            }

            @Nullable
            private LModel m5997x() {
                this.f6009u = (LModel) super.a(this.f6009u, 17, LModel.class);
                return this.f6009u;
            }

            @Nullable
            public final GraphQLDocumentListStyle ih_() {
                this.f6010v = (GraphQLDocumentListStyle) super.b(this.f6010v, 18, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6010v;
            }

            @Nullable
            private RichDocumentLocationAnnotationModel m5998y() {
                this.f6011w = (RichDocumentLocationAnnotationModel) super.a(this.f6011w, 19, RichDocumentLocationAnnotationModel.class);
                return this.f6011w;
            }

            @Nonnull
            private ImmutableList<RichDocumentLocationAnnotationModel> m5999z() {
                this.f6012x = super.a(this.f6012x, 20, RichDocumentLocationAnnotationModel.class);
                return (ImmutableList) this.f6012x;
            }

            @Nullable
            private GraphQLDocumentMapStyle m5970A() {
                this.f6013y = (GraphQLDocumentMapStyle) super.b(this.f6013y, 21, GraphQLDocumentMapStyle.class, GraphQLDocumentMapStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6013y;
            }

            @Nullable
            private GraphQLDocumentElementMarginStyle m5971B() {
                this.f6014z = (GraphQLDocumentElementMarginStyle) super.b(this.f6014z, 22, GraphQLDocumentElementMarginStyle.class, GraphQLDocumentElementMarginStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6014z;
            }

            @Nullable
            private FBPhotoModel m5972C() {
                this.f5980A = (FBPhotoModel) super.a(this.f5980A, 23, FBPhotoModel.class);
                return this.f5980A;
            }

            @Nullable
            private FBPhotoModel m5973D() {
                this.f5981B = (FBPhotoModel) super.a(this.f5981B, 24, FBPhotoModel.class);
                return this.f5981B;
            }

            @Nullable
            private GraphQLDocumentMediaPresentationStyle m5974E() {
                this.f5982C = (GraphQLDocumentMediaPresentationStyle) super.b(this.f5982C, 25, GraphQLDocumentMediaPresentationStyle.class, GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5982C;
            }

            @Nullable
            private RelatedArticleObjsModel m5975F() {
                this.f5983D = (RelatedArticleObjsModel) super.a(this.f5983D, 26, RelatedArticleObjsModel.class);
                return this.f5983D;
            }

            @Nullable
            private SlideEdgesModel m5976G() {
                this.f5984E = (SlideEdgesModel) super.a(this.f5984E, 27, SlideEdgesModel.class);
                return this.f5984E;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5977H() {
                this.f5985F = (RichDocumentTextAnnotationModel) super.a(this.f5985F, 28, RichDocumentTextAnnotationModel.class);
                return this.f5985F;
            }

            @Nullable
            private String m5978I() {
                this.f5986G = super.a(this.f5986G, 29);
                return this.f5986G;
            }

            @Nullable
            private RichDocumentTextAnnotationModel m5979J() {
                this.f5987H = (RichDocumentTextAnnotationModel) super.a(this.f5987H, 30, RichDocumentTextAnnotationModel.class);
                return this.f5987H;
            }

            @Nullable
            private GraphQLDocumentVideoAutoplayStyle m5980K() {
                this.f5988I = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f5988I, 31, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5988I;
            }

            @Nullable
            private GraphQLDocumentVideoControlStyle m5981L() {
                this.f5989J = (GraphQLDocumentVideoControlStyle) super.b(this.f5989J, 32, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5989J;
            }

            @Nullable
            private GraphQLDocumentVideoLoopingStyle m5982M() {
                this.f5990K = (GraphQLDocumentVideoLoopingStyle) super.b(this.f5990K, 33, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5990K;
            }

            @Nullable
            private GraphQLDocumentWebviewPresentationStyle m5983N() {
                this.f5991L = (GraphQLDocumentWebviewPresentationStyle) super.b(this.f5991L, 34, GraphQLDocumentWebviewPresentationStyle.class, GraphQLDocumentWebviewPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5991L;
            }

            @Nullable
            public final String m6002a() {
                return m5996w();
            }

            public final int jK_() {
                return 473184577;
            }

            public final GraphQLVisitableModel m6001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                RichDocumentTextAnnotationModel richDocumentTextAnnotationModel;
                FBPhotoModel fBPhotoModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5986l() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5986l());
                    if (m5986l() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5994f = richDocumentTextAnnotationModel;
                    }
                }
                if (m5990q() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5990q());
                    if (m5990q() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5998j = richDocumentTextAnnotationModel;
                    }
                }
                if (m5991r() != null) {
                    RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m5991r());
                    if (m5991r() != richDocumentTextModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6002n = richDocumentTextModel;
                    }
                }
                if (m5992s() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m5992s());
                    if (m5992s() != fBVideoModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6003o = fBVideoModel;
                    }
                }
                if (m5993t() != null) {
                    GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m5993t());
                    if (m5993t() != graphQLFeedback) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6005q = graphQLFeedback;
                    }
                }
                if (m5997x() != null) {
                    LModel lModel = (LModel) graphQLModelMutatingVisitor.b(m5997x());
                    if (m5997x() != lModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6009u = lModel;
                    }
                }
                if (m5998y() != null) {
                    RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel = (RichDocumentLocationAnnotationModel) graphQLModelMutatingVisitor.b(m5998y());
                    if (m5998y() != richDocumentLocationAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6011w = richDocumentLocationAnnotationModel;
                    }
                }
                if (m5999z() != null) {
                    Builder a = ModelHelper.a(m5999z(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        RichDocumentListItemModel richDocumentListItemModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        richDocumentListItemModel.f6012x = a.b();
                        graphQLVisitableModel = richDocumentListItemModel;
                    }
                }
                if (m5972C() != null) {
                    fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m5972C());
                    if (m5972C() != fBPhotoModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5980A = fBPhotoModel;
                    }
                }
                if (m5973D() != null) {
                    fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m5973D());
                    if (m5973D() != fBPhotoModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5981B = fBPhotoModel;
                    }
                }
                if (m5975F() != null) {
                    RelatedArticleObjsModel relatedArticleObjsModel = (RelatedArticleObjsModel) graphQLModelMutatingVisitor.b(m5975F());
                    if (m5975F() != relatedArticleObjsModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5983D = relatedArticleObjsModel;
                    }
                }
                if (m5976G() != null) {
                    SlideEdgesModel slideEdgesModel = (SlideEdgesModel) graphQLModelMutatingVisitor.b(m5976G());
                    if (m5976G() != slideEdgesModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5984E = slideEdgesModel;
                    }
                }
                if (m5977H() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5977H());
                    if (m5977H() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5985F = richDocumentTextAnnotationModel;
                    }
                }
                if (m5979J() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m5979J());
                    if (m5979J() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5987H = richDocumentTextAnnotationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6000a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5984j());
                int a2 = flatBufferBuilder.a(m5985k());
                int a3 = ModelHelper.a(flatBufferBuilder, m5986l());
                int b = flatBufferBuilder.b(m5987m());
                int b2 = flatBufferBuilder.b(m5988o());
                int b3 = flatBufferBuilder.b(m5989p());
                int a4 = ModelHelper.a(flatBufferBuilder, m5990q());
                int a5 = flatBufferBuilder.a(mo358b());
                int a6 = ModelHelper.a(flatBufferBuilder, m5991r());
                int a7 = ModelHelper.a(flatBufferBuilder, m5992s());
                int a8 = ModelHelper.a(flatBufferBuilder, m5993t());
                int a9 = flatBufferBuilder.a(m5994u());
                int b4 = flatBufferBuilder.b(m5995v());
                int b5 = flatBufferBuilder.b(m5996w());
                int a10 = ModelHelper.a(flatBufferBuilder, m5997x());
                int a11 = flatBufferBuilder.a(ih_());
                int a12 = ModelHelper.a(flatBufferBuilder, m5998y());
                int a13 = ModelHelper.a(flatBufferBuilder, m5999z());
                int a14 = flatBufferBuilder.a(m5970A());
                int a15 = flatBufferBuilder.a(m5971B());
                int a16 = ModelHelper.a(flatBufferBuilder, m5972C());
                int a17 = ModelHelper.a(flatBufferBuilder, m5973D());
                int a18 = flatBufferBuilder.a(m5974E());
                int a19 = ModelHelper.a(flatBufferBuilder, m5975F());
                int a20 = ModelHelper.a(flatBufferBuilder, m5976G());
                int a21 = ModelHelper.a(flatBufferBuilder, m5977H());
                int b6 = flatBufferBuilder.b(m5978I());
                int a22 = ModelHelper.a(flatBufferBuilder, m5979J());
                int a23 = flatBufferBuilder.a(m5980K());
                int a24 = flatBufferBuilder.a(m5981L());
                int a25 = flatBufferBuilder.a(m5982M());
                int a26 = flatBufferBuilder.a(m5983N());
                flatBufferBuilder.c(35);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.a(7, this.f5999k, 0);
                flatBufferBuilder.a(8, this.f6000l, 0);
                flatBufferBuilder.b(9, a5);
                flatBufferBuilder.b(10, a6);
                flatBufferBuilder.b(11, a7);
                flatBufferBuilder.a(12, this.f6004p);
                flatBufferBuilder.b(13, a8);
                flatBufferBuilder.b(14, a9);
                flatBufferBuilder.b(15, b4);
                flatBufferBuilder.b(16, b5);
                flatBufferBuilder.b(17, a10);
                flatBufferBuilder.b(18, a11);
                flatBufferBuilder.b(19, a12);
                flatBufferBuilder.b(20, a13);
                flatBufferBuilder.b(21, a14);
                flatBufferBuilder.b(22, a15);
                flatBufferBuilder.b(23, a16);
                flatBufferBuilder.b(24, a17);
                flatBufferBuilder.b(25, a18);
                flatBufferBuilder.b(26, a19);
                flatBufferBuilder.b(27, a20);
                flatBufferBuilder.b(28, a21);
                flatBufferBuilder.b(29, b6);
                flatBufferBuilder.b(30, a22);
                flatBufferBuilder.b(31, a23);
                flatBufferBuilder.b(32, a24);
                flatBufferBuilder.b(33, a25);
                flatBufferBuilder.b(34, a26);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6003a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5999k = mutableFlatBuffer.a(i, 7, 0);
                this.f6000l = mutableFlatBuffer.a(i, 8, 0);
                this.f6004p = mutableFlatBuffer.a(i, 12);
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentListItemEdgeModel> {
            public final void m6008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentListItemEdgeModel richDocumentListItemEdgeModel = (RichDocumentListItemEdgeModel) obj;
                if (richDocumentListItemEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentListItemEdgeModel.m6010a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentListItemEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentListItemEdgeParser.m6528b(richDocumentListItemEdgeModel.w_(), richDocumentListItemEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentListItemEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentListItemModel m6012a() {
            return m6009j();
        }

        public RichDocumentListItemEdgeModel() {
            super(1);
        }

        @Nullable
        private RichDocumentListItemModel m6009j() {
            this.f6015d = (RichDocumentListItemModel) super.a(this.f6015d, 0, RichDocumentListItemModel.class);
            return this.f6015d;
        }

        public final int jK_() {
            return -1267606241;
        }

        public final GraphQLVisitableModel m6011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6009j() != null) {
                RichDocumentListItemModel richDocumentListItemModel = (RichDocumentListItemModel) graphQLModelMutatingVisitor.b(m6009j());
                if (m6009j() != richDocumentListItemModel) {
                    graphQLVisitableModel = (RichDocumentListItemEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6015d = richDocumentListItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6010a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6009j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 582012026)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentListItemsModel extends BaseModel implements GraphQLVisitableModel, RichDocumentListItems {
        @Nullable
        private ListElementsModel f6017d;
        @Nullable
        private GraphQLDocumentListStyle f6018e;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentListItemsModel.class, new Deserializer());
            }

            public Object m6013a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentListItemsParser.m6531a(jsonParser);
                Object richDocumentListItemsModel = new RichDocumentListItemsModel();
                ((BaseModel) richDocumentListItemsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentListItemsModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentListItemsModel).a();
                }
                return richDocumentListItemsModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1802091461)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: photo_picker_camera_cancelled */
        public final class ListElementsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RichDocumentListItemEdgeModel> f6016d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ListElementsModel.class, new Deserializer());
                }

                public Object m6014a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ListElementsParser.m6529a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object listElementsModel = new ListElementsModel();
                    ((BaseModel) listElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (listElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) listElementsModel).a();
                    }
                    return listElementsModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<ListElementsModel> {
                public final void m6015a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ListElementsModel listElementsModel = (ListElementsModel) obj;
                    if (listElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(listElementsModel.m6016a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        listElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ListElementsParser.m6530a(listElementsModel.w_(), listElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ListElementsModel.class, new Serializer());
                }
            }

            public ListElementsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<RichDocumentListItemEdgeModel> m6018a() {
                this.f6016d = super.a(this.f6016d, 0, RichDocumentListItemEdgeModel.class);
                return (ImmutableList) this.f6016d;
            }

            public final int jK_() {
                return -530948928;
            }

            public final GraphQLVisitableModel m6017a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6018a() != null) {
                    Builder a = ModelHelper.a(m6018a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ListElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6016d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6016a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6018a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentListItemsModel> {
            public final void m6019a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentListItemsModel richDocumentListItemsModel = (RichDocumentListItemsModel) obj;
                if (richDocumentListItemsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentListItemsModel.m6022a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentListItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentListItemsModel.w_();
                int u_ = richDocumentListItemsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("list_elements");
                    ListElementsParser.m6530a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("list_style");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentListItemsModel.class, new Serializer());
            }
        }

        public RichDocumentListItemsModel() {
            super(2);
        }

        @Nullable
        private ListElementsModel m6020a() {
            this.f6017d = (ListElementsModel) super.a(this.f6017d, 0, ListElementsModel.class);
            return this.f6017d;
        }

        @Nullable
        private GraphQLDocumentListStyle m6021j() {
            this.f6018e = (GraphQLDocumentListStyle) super.b(this.f6018e, 1, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6018e;
        }

        public final int jK_() {
            return -1870845885;
        }

        public final GraphQLVisitableModel m6023a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6020a() != null) {
                ListElementsModel listElementsModel = (ListElementsModel) graphQLModelMutatingVisitor.b(m6020a());
                if (m6020a() != listElementsModel) {
                    graphQLVisitableModel = (RichDocumentListItemsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6017d = listElementsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6022a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6020a());
            int a2 = flatBufferBuilder.a(m6021j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1721325399)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentLocationAnnotationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultLocationFieldsModel f6019d;
        private double f6020e;
        @Nullable
        private String f6021f;
        @Nullable
        private String f6022g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentLocationAnnotationModel.class, new Deserializer());
            }

            public Object m6024a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentLocationAnnotationParser.m6532a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentLocationAnnotationModel = new RichDocumentLocationAnnotationModel();
                ((BaseModel) richDocumentLocationAnnotationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentLocationAnnotationModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentLocationAnnotationModel).a();
                }
                return richDocumentLocationAnnotationModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentLocationAnnotationModel> {
            public final void m6025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel = (RichDocumentLocationAnnotationModel) obj;
                if (richDocumentLocationAnnotationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentLocationAnnotationModel.m6027a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentLocationAnnotationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentLocationAnnotationParser.m6535b(richDocumentLocationAnnotationModel.w_(), richDocumentLocationAnnotationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentLocationAnnotationModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultLocationFields m6028a() {
            return m6026j();
        }

        public RichDocumentLocationAnnotationModel() {
            super(4);
        }

        @Nullable
        private DefaultLocationFieldsModel m6026j() {
            this.f6019d = (DefaultLocationFieldsModel) super.a(this.f6019d, 0, DefaultLocationFieldsModel.class);
            return this.f6019d;
        }

        @Nullable
        public final String m6031b() {
            this.f6021f = super.a(this.f6021f, 2);
            return this.f6021f;
        }

        @Nullable
        public final String m6032c() {
            this.f6022g = super.a(this.f6022g, 3);
            return this.f6022g;
        }

        public final int jK_() {
            return -601764336;
        }

        public final GraphQLVisitableModel m6029a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6026j() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m6026j());
                if (m6026j() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (RichDocumentLocationAnnotationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6019d = defaultLocationFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6027a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6026j());
            int b = flatBufferBuilder.b(m6031b());
            int b2 = flatBufferBuilder.b(m6032c());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f6020e, 0.0d);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6030a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6020e = mutableFlatBuffer.a(i, 1, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1454042005)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentLogoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f6023d;
        @Nullable
        private String f6024e;
        @Nullable
        private String f6025f;
        private int f6026g;
        @Nullable
        private String f6027h;
        private int f6028i;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentLogoModel.class, new Deserializer());
            }

            public Object m6033a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentLogoParser.m6536a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentLogoModel = new RichDocumentLogoModel();
                ((BaseModel) richDocumentLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentLogoModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentLogoModel).a();
                }
                return richDocumentLogoModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentLogoModel> {
            public final void m6034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentLogoModel richDocumentLogoModel = (RichDocumentLogoModel) obj;
                if (richDocumentLogoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentLogoModel.m6035a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentLogoParser.m6537a(richDocumentLogoModel.w_(), richDocumentLogoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RichDocumentLogoModel.class, new Serializer());
            }
        }

        public RichDocumentLogoModel() {
            super(6);
        }

        @Nullable
        public final String m6037a() {
            this.f6023d = super.a(this.f6023d, 0);
            return this.f6023d;
        }

        @Nullable
        public final String m6039b() {
            this.f6024e = super.a(this.f6024e, 1);
            return this.f6024e;
        }

        @Nullable
        public final String m6040c() {
            this.f6025f = super.a(this.f6025f, 2);
            return this.f6025f;
        }

        public final int m6041d() {
            a(0, 3);
            return this.f6026g;
        }

        @Nullable
        public final String ii_() {
            this.f6027h = super.a(this.f6027h, 4);
            return this.f6027h;
        }

        public final int m6042g() {
            a(0, 5);
            return this.f6028i;
        }

        public final int jK_() {
            return -1309124218;
        }

        public final GraphQLVisitableModel m6036a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6035a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6037a());
            int b2 = flatBufferBuilder.b(m6039b());
            int b3 = flatBufferBuilder.b(m6040c());
            int b4 = flatBufferBuilder.b(ii_());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.a(3, this.f6026g, 0);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.a(5, this.f6028i, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6038a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6026g = mutableFlatBuffer.a(i, 3, 0);
            this.f6028i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 674776710)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentMasterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentMaster {
        @Nullable
        private GraphQLFeedback f6030d;
        @Nullable
        private RichDocumentGlobalShareModel f6031e;
        @Nullable
        private String f6032f;
        @Nullable
        private MessengerContentSubscriptionOptionModel f6033g;
        @Nullable
        private RelatedArticleObjectsModel f6034h;
        @Nullable
        private RichDocumentEdgeModel f6035i;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentMasterModel.class, new Deserializer());
            }

            public Object m6043a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentMasterParser.m6540a(jsonParser);
                Object richDocumentMasterModel = new RichDocumentMasterModel();
                ((BaseModel) richDocumentMasterModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentMasterModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentMasterModel).a();
                }
                return richDocumentMasterModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -974869628)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class RelatedArticleObjectsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RichDocumentRelatedArticleModel> f6029d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RelatedArticleObjectsModel.class, new Deserializer());
                }

                public Object m6044a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RelatedArticleObjectsParser.m6538a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object relatedArticleObjectsModel = new RelatedArticleObjectsModel();
                    ((BaseModel) relatedArticleObjectsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (relatedArticleObjectsModel instanceof Postprocessable) {
                        return ((Postprocessable) relatedArticleObjectsModel).a();
                    }
                    return relatedArticleObjectsModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<RelatedArticleObjectsModel> {
                public final void m6045a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RelatedArticleObjectsModel relatedArticleObjectsModel = (RelatedArticleObjectsModel) obj;
                    if (relatedArticleObjectsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(relatedArticleObjectsModel.m6046a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        relatedArticleObjectsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RelatedArticleObjectsParser.m6539a(relatedArticleObjectsModel.w_(), relatedArticleObjectsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RelatedArticleObjectsModel.class, new Serializer());
                }
            }

            public RelatedArticleObjectsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<RichDocumentRelatedArticleModel> m6048a() {
                this.f6029d = super.a(this.f6029d, 0, RichDocumentRelatedArticleModel.class);
                return (ImmutableList) this.f6029d;
            }

            public final int jK_() {
                return -1502360058;
            }

            public final GraphQLVisitableModel m6047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6048a() != null) {
                    Builder a = ModelHelper.a(m6048a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (RelatedArticleObjectsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6029d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6046a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6048a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentMasterModel> {
            public final void m6049a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentMasterModel richDocumentMasterModel = (RichDocumentMasterModel) obj;
                if (richDocumentMasterModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentMasterModel.m6053a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentMasterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentMasterModel.w_();
                int u_ = richDocumentMasterModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("global_share");
                    RichDocumentGlobalShareParser.m6522a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("messenger_content_subscription_option");
                    MessengerContentSubscriptionOptionParser.m6456a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("related_article_objects");
                    RelatedArticleObjectsParser.m6539a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("rich_document_edge");
                    RichDocumentEdgeParser.m6508a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentMasterModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MessengerContentSubscriptionOptionModel mo363d() {
            return m6051l();
        }

        @Nullable
        public final /* synthetic */ RichDocumentEdge mo364g() {
            return m6060j();
        }

        @Nullable
        public final /* synthetic */ RelatedArticleObjectsModel ij_() {
            return m6052m();
        }

        public RichDocumentMasterModel() {
            super(6);
        }

        @Nullable
        public final GraphQLFeedback mo361b() {
            this.f6030d = (GraphQLFeedback) super.a(this.f6030d, 0, GraphQLFeedback.class);
            return this.f6030d;
        }

        @Nullable
        private RichDocumentGlobalShareModel m6050k() {
            this.f6031e = (RichDocumentGlobalShareModel) super.a(this.f6031e, 1, RichDocumentGlobalShareModel.class);
            return this.f6031e;
        }

        @Nullable
        public final String mo362c() {
            this.f6032f = super.a(this.f6032f, 2);
            return this.f6032f;
        }

        @Nullable
        private MessengerContentSubscriptionOptionModel m6051l() {
            this.f6033g = (MessengerContentSubscriptionOptionModel) super.a(this.f6033g, 3, MessengerContentSubscriptionOptionModel.class);
            return this.f6033g;
        }

        @Nullable
        private RelatedArticleObjectsModel m6052m() {
            this.f6034h = (RelatedArticleObjectsModel) super.a(this.f6034h, 4, RelatedArticleObjectsModel.class);
            return this.f6034h;
        }

        @Nullable
        public final RichDocumentEdgeModel m6060j() {
            this.f6035i = (RichDocumentEdgeModel) super.a(this.f6035i, 5, RichDocumentEdgeModel.class);
            return this.f6035i;
        }

        @Nullable
        public final String m6055a() {
            return mo362c();
        }

        public final int jK_() {
            return 1607392245;
        }

        public final GraphQLVisitableModel m6054a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo361b() != null) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(mo361b());
                if (mo361b() != graphQLFeedback) {
                    graphQLVisitableModel = (RichDocumentMasterModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6030d = graphQLFeedback;
                }
            }
            if (m6050k() != null) {
                RichDocumentGlobalShareModel richDocumentGlobalShareModel = (RichDocumentGlobalShareModel) graphQLModelMutatingVisitor.b(m6050k());
                if (m6050k() != richDocumentGlobalShareModel) {
                    graphQLVisitableModel = (RichDocumentMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6031e = richDocumentGlobalShareModel;
                }
            }
            if (m6051l() != null) {
                MessengerContentSubscriptionOptionModel messengerContentSubscriptionOptionModel = (MessengerContentSubscriptionOptionModel) graphQLModelMutatingVisitor.b(m6051l());
                if (m6051l() != messengerContentSubscriptionOptionModel) {
                    graphQLVisitableModel = (RichDocumentMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6033g = messengerContentSubscriptionOptionModel;
                }
            }
            if (m6052m() != null) {
                RelatedArticleObjectsModel relatedArticleObjectsModel = (RelatedArticleObjectsModel) graphQLModelMutatingVisitor.b(m6052m());
                if (m6052m() != relatedArticleObjectsModel) {
                    graphQLVisitableModel = (RichDocumentMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6034h = relatedArticleObjectsModel;
                }
            }
            if (m6060j() != null) {
                RichDocumentEdgeModel richDocumentEdgeModel = (RichDocumentEdgeModel) graphQLModelMutatingVisitor.b(m6060j());
                if (m6060j() != richDocumentEdgeModel) {
                    graphQLVisitableModel = (RichDocumentMasterModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6035i = richDocumentEdgeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6053a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo361b());
            int a2 = ModelHelper.a(flatBufferBuilder, m6050k());
            int b = flatBufferBuilder.b(mo362c());
            int a3 = ModelHelper.a(flatBufferBuilder, m6051l());
            int a4 = ModelHelper.a(flatBufferBuilder, m6052m());
            int a5 = ModelHelper.a(flatBufferBuilder, m6060j());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1913390302)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentNestedListItemFieldsModel extends BaseModel implements GraphQLVisitableModel, RichDocumentNestedListItemFields {
        @Nullable
        private GraphQLObjectType f6036d;
        @Nullable
        private GraphQLDocumentElementType f6037e;
        @Nullable
        private RichDocumentTextModel f6038f;
        @Nullable
        private GraphQLDocumentListStyle f6039g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentNestedListItemFieldsModel.class, new Deserializer());
            }

            public Object m6061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentNestedListItemFieldsParser.m6541a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentNestedListItemFieldsModel = new RichDocumentNestedListItemFieldsModel();
                ((BaseModel) richDocumentNestedListItemFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentNestedListItemFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentNestedListItemFieldsModel).a();
                }
                return richDocumentNestedListItemFieldsModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentNestedListItemFieldsModel> {
            public final void m6062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentNestedListItemFieldsModel richDocumentNestedListItemFieldsModel = (RichDocumentNestedListItemFieldsModel) obj;
                if (richDocumentNestedListItemFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentNestedListItemFieldsModel.m6065a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentNestedListItemFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentNestedListItemFieldsParser.m6542a(richDocumentNestedListItemFieldsModel.w_(), richDocumentNestedListItemFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentNestedListItemFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo359c() {
            return m6064j();
        }

        public RichDocumentNestedListItemFieldsModel() {
            super(4);
        }

        @Nullable
        private GraphQLObjectType m6063a() {
            if (this.b != null && this.f6036d == null) {
                this.f6036d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6036d;
        }

        @Nullable
        public final GraphQLDocumentElementType mo358b() {
            this.f6037e = (GraphQLDocumentElementType) super.b(this.f6037e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6037e;
        }

        @Nullable
        private RichDocumentTextModel m6064j() {
            this.f6038f = (RichDocumentTextModel) super.a(this.f6038f, 2, RichDocumentTextModel.class);
            return this.f6038f;
        }

        @Nullable
        public final GraphQLDocumentListStyle ih_() {
            this.f6039g = (GraphQLDocumentListStyle) super.b(this.f6039g, 3, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6039g;
        }

        public final int jK_() {
            return 473184577;
        }

        public final GraphQLVisitableModel m6066a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6064j() != null) {
                RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6064j());
                if (m6064j() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentNestedListItemFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6038f = richDocumentTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6065a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6063a());
            int a2 = flatBufferBuilder.a(mo358b());
            int a3 = ModelHelper.a(flatBufferBuilder, m6064j());
            int a4 = flatBufferBuilder.a(ih_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 382052748)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentNestedListItemModel extends BaseModel implements GraphQLVisitableModel, RichDocumentNestedListItem {
        @Nullable
        private GraphQLObjectType f6063d;
        @Nullable
        private GraphQLDocumentElementType f6064e;
        @Nullable
        private RichDocumentTextModel f6065f;
        @Nullable
        private LModel f6066g;
        @Nullable
        private GraphQLDocumentListStyle f6067h;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentNestedListItemModel.class, new Deserializer());
            }

            public Object m6069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentNestedListItemParser.m6565a(jsonParser);
                Object richDocumentNestedListItemModel = new RichDocumentNestedListItemModel();
                ((BaseModel) richDocumentNestedListItemModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentNestedListItemModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentNestedListItemModel).a();
                }
                return richDocumentNestedListItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1054922290)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class LModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EModel> f6062d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LModel.class, new Deserializer());
                }

                public Object m6070a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LParser.m6563a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lModel = new LModel();
                    ((BaseModel) lModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lModel instanceof Postprocessable) {
                        return ((Postprocessable) lModel).a();
                    }
                    return lModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 86224836)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_picker_camera_cancelled */
            public final class EModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NModel f6061d;

                /* compiled from: photo_picker_camera_cancelled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EModel.class, new Deserializer());
                    }

                    public Object m6071a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EParser.m6561b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object eModel = new EModel();
                        ((BaseModel) eModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (eModel instanceof Postprocessable) {
                            return ((Postprocessable) eModel).a();
                        }
                        return eModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1719909143)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: photo_picker_camera_cancelled */
                public final class NModel extends BaseModel implements GraphQLVisitableModel, RichDocumentNestedListItemFields {
                    @Nullable
                    private GraphQLObjectType f6056d;
                    @Nullable
                    private GraphQLDocumentElementType f6057e;
                    @Nullable
                    private RichDocumentTextModel f6058f;
                    @Nullable
                    private NLModel f6059g;
                    @Nullable
                    private GraphQLDocumentListStyle f6060h;

                    /* compiled from: photo_picker_camera_cancelled */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NModel.class, new Deserializer());
                        }

                        public Object m6072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NParser.m6559a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nModel = new NModel();
                            ((BaseModel) nModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nModel instanceof Postprocessable) {
                                return ((Postprocessable) nModel).a();
                            }
                            return nModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1827387056)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: photo_picker_camera_cancelled */
                    public final class NLModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<NLEModel> f6055d;

                        /* compiled from: photo_picker_camera_cancelled */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NLModel.class, new Deserializer());
                            }

                            public Object m6073a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NLParser.m6557a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object nLModel = new NLModel();
                                ((BaseModel) nLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (nLModel instanceof Postprocessable) {
                                    return ((Postprocessable) nLModel).a();
                                }
                                return nLModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1155257083)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: photo_picker_camera_cancelled */
                        public final class NLEModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private NLENModel f6054d;

                            /* compiled from: photo_picker_camera_cancelled */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(NLEModel.class, new Deserializer());
                                }

                                public Object m6074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(NLEParser.m6555b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object nLEModel = new NLEModel();
                                    ((BaseModel) nLEModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (nLEModel instanceof Postprocessable) {
                                        return ((Postprocessable) nLEModel).a();
                                    }
                                    return nLEModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1104661084)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: photo_picker_camera_cancelled */
                            public final class NLENModel extends BaseModel implements GraphQLVisitableModel, RichDocumentNestedListItemFields {
                                @Nullable
                                private GraphQLObjectType f6049d;
                                @Nullable
                                private GraphQLDocumentElementType f6050e;
                                @Nullable
                                private RichDocumentTextModel f6051f;
                                @Nullable
                                private NLENLModel f6052g;
                                @Nullable
                                private GraphQLDocumentListStyle f6053h;

                                /* compiled from: photo_picker_camera_cancelled */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(NLENModel.class, new Deserializer());
                                    }

                                    public Object m6075a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(NLENParser.m6553a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object nLENModel = new NLENModel();
                                        ((BaseModel) nLENModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (nLENModel instanceof Postprocessable) {
                                            return ((Postprocessable) nLENModel).a();
                                        }
                                        return nLENModel;
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1371530833)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: photo_picker_camera_cancelled */
                                public final class NLENLModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private List<NLENLEModel> f6048d;

                                    /* compiled from: photo_picker_camera_cancelled */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(NLENLModel.class, new Deserializer());
                                        }

                                        public Object m6076a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(NLENLParser.m6551a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object nLENLModel = new NLENLModel();
                                            ((BaseModel) nLENLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (nLENLModel instanceof Postprocessable) {
                                                return ((Postprocessable) nLENLModel).a();
                                            }
                                            return nLENLModel;
                                        }
                                    }

                                    @JsonDeserialize(using = Deserializer.class)
                                    @ModelWithFlatBufferFormatHash(a = -8360348)
                                    @JsonSerialize(using = Serializer.class)
                                    @FragmentModelWithoutBridge
                                    /* compiled from: photo_picker_camera_cancelled */
                                    public final class NLENLEModel extends BaseModel implements GraphQLVisitableModel {
                                        @Nullable
                                        private NLENLENModel f6047d;

                                        /* compiled from: photo_picker_camera_cancelled */
                                        public class Deserializer extends FbJsonDeserializer {
                                            static {
                                                GlobalAutoGenDeserializerCache.a(NLENLEModel.class, new Deserializer());
                                            }

                                            public Object m6077a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(NLENLEParser.m6549b(jsonParser, flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                                Object nLENLEModel = new NLENLEModel();
                                                ((BaseModel) nLENLEModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                                if (nLENLEModel instanceof Postprocessable) {
                                                    return ((Postprocessable) nLENLEModel).a();
                                                }
                                                return nLENLEModel;
                                            }
                                        }

                                        @JsonDeserialize(using = Deserializer.class)
                                        @ModelWithFlatBufferFormatHash(a = 369341866)
                                        @JsonSerialize(using = Serializer.class)
                                        @FragmentModelWithoutBridge
                                        /* compiled from: photo_picker_camera_cancelled */
                                        public final class NLENLENModel extends BaseModel implements GraphQLVisitableModel, RichDocumentNestedListItemFields {
                                            @Nullable
                                            private GraphQLObjectType f6042d;
                                            @Nullable
                                            private GraphQLDocumentElementType f6043e;
                                            @Nullable
                                            private RichDocumentTextModel f6044f;
                                            @Nullable
                                            private NLENLENLModel f6045g;
                                            @Nullable
                                            private GraphQLDocumentListStyle f6046h;

                                            /* compiled from: photo_picker_camera_cancelled */
                                            public class Deserializer extends FbJsonDeserializer {
                                                static {
                                                    GlobalAutoGenDeserializerCache.a(NLENLENModel.class, new Deserializer());
                                                }

                                                public Object m6078a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                    flatBufferBuilder.d(NLENLENParser.m6547a(jsonParser, flatBufferBuilder));
                                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                    wrap.position(0);
                                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                                    Object nLENLENModel = new NLENLENModel();
                                                    ((BaseModel) nLENLENModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                                    if (nLENLENModel instanceof Postprocessable) {
                                                        return ((Postprocessable) nLENLENModel).a();
                                                    }
                                                    return nLENLENModel;
                                                }
                                            }

                                            @JsonDeserialize(using = Deserializer.class)
                                            @ModelWithFlatBufferFormatHash(a = 1995481301)
                                            @JsonSerialize(using = Serializer.class)
                                            @FragmentModelWithoutBridge
                                            /* compiled from: photo_picker_camera_cancelled */
                                            public final class NLENLENLModel extends BaseModel implements GraphQLVisitableModel {
                                                @Nullable
                                                private List<NLENLENLEModel> f6041d;

                                                /* compiled from: photo_picker_camera_cancelled */
                                                public class Deserializer extends FbJsonDeserializer {
                                                    static {
                                                        GlobalAutoGenDeserializerCache.a(NLENLENLModel.class, new Deserializer());
                                                    }

                                                    public Object m6079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                        flatBufferBuilder.d(NLENLENLParser.m6545a(jsonParser, flatBufferBuilder));
                                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                        wrap.position(0);
                                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                                        Object nLENLENLModel = new NLENLENLModel();
                                                        ((BaseModel) nLENLENLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                                        if (nLENLENLModel instanceof Postprocessable) {
                                                            return ((Postprocessable) nLENLENLModel).a();
                                                        }
                                                        return nLENLENLModel;
                                                    }
                                                }

                                                @JsonDeserialize(using = Deserializer.class)
                                                @ModelWithFlatBufferFormatHash(a = -1942393618)
                                                @JsonSerialize(using = Serializer.class)
                                                @FragmentModelWithoutBridge
                                                /* compiled from: photo_picker_camera_cancelled */
                                                public final class NLENLENLEModel extends BaseModel implements GraphQLVisitableModel {
                                                    @Nullable
                                                    private RichDocumentNestedListItemFieldsModel f6040d;

                                                    /* compiled from: photo_picker_camera_cancelled */
                                                    public class Deserializer extends FbJsonDeserializer {
                                                        static {
                                                            GlobalAutoGenDeserializerCache.a(NLENLENLEModel.class, new Deserializer());
                                                        }

                                                        public Object m6080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                            flatBufferBuilder.d(NLENLENLEParser.m6543b(jsonParser, flatBufferBuilder));
                                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                            wrap.position(0);
                                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                                            Object nLENLENLEModel = new NLENLENLEModel();
                                                            ((BaseModel) nLENLENLEModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                                            if (nLENLENLEModel instanceof Postprocessable) {
                                                                return ((Postprocessable) nLENLENLEModel).a();
                                                            }
                                                            return nLENLENLEModel;
                                                        }
                                                    }

                                                    /* compiled from: photo_picker_camera_cancelled */
                                                    public class Serializer extends JsonSerializer<NLENLENLEModel> {
                                                        public final void m6081a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                            NLENLENLEModel nLENLENLEModel = (NLENLENLEModel) obj;
                                                            if (nLENLENLEModel.w_() == null) {
                                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                                flatBufferBuilder.d(nLENLENLEModel.m6083a(flatBufferBuilder));
                                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                                wrap.position(0);
                                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                                nLENLENLEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                                            }
                                                            NLENLENLEParser.m6544b(nLENLENLEModel.w_(), nLENLENLEModel.u_(), jsonGenerator, serializerProvider);
                                                        }

                                                        static {
                                                            FbSerializerProvider.a(NLENLENLEModel.class, new Serializer());
                                                        }
                                                    }

                                                    @Nullable
                                                    public final /* synthetic */ RichDocumentNestedListItemFields m6085a() {
                                                        return m6082j();
                                                    }

                                                    public NLENLENLEModel() {
                                                        super(1);
                                                    }

                                                    @Nullable
                                                    private RichDocumentNestedListItemFieldsModel m6082j() {
                                                        this.f6040d = (RichDocumentNestedListItemFieldsModel) super.a(this.f6040d, 0, RichDocumentNestedListItemFieldsModel.class);
                                                        return this.f6040d;
                                                    }

                                                    public final int jK_() {
                                                        return -1267606241;
                                                    }

                                                    public final GraphQLVisitableModel m6084a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                                        GraphQLVisitableModel graphQLVisitableModel = null;
                                                        h();
                                                        if (m6082j() != null) {
                                                            RichDocumentNestedListItemFieldsModel richDocumentNestedListItemFieldsModel = (RichDocumentNestedListItemFieldsModel) graphQLModelMutatingVisitor.b(m6082j());
                                                            if (m6082j() != richDocumentNestedListItemFieldsModel) {
                                                                graphQLVisitableModel = (NLENLENLEModel) ModelHelper.a(null, this);
                                                                graphQLVisitableModel.f6040d = richDocumentNestedListItemFieldsModel;
                                                            }
                                                        }
                                                        i();
                                                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                                    }

                                                    public final int m6083a(FlatBufferBuilder flatBufferBuilder) {
                                                        h();
                                                        int a = ModelHelper.a(flatBufferBuilder, m6082j());
                                                        flatBufferBuilder.c(1);
                                                        flatBufferBuilder.b(0, a);
                                                        i();
                                                        return flatBufferBuilder.d();
                                                    }
                                                }

                                                /* compiled from: photo_picker_camera_cancelled */
                                                public class Serializer extends JsonSerializer<NLENLENLModel> {
                                                    public final void m6086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                        NLENLENLModel nLENLENLModel = (NLENLENLModel) obj;
                                                        if (nLENLENLModel.w_() == null) {
                                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                            flatBufferBuilder.d(nLENLENLModel.m6087a(flatBufferBuilder));
                                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                            wrap.position(0);
                                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                            nLENLENLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                                        }
                                                        NLENLENLParser.m6546a(nLENLENLModel.w_(), nLENLENLModel.u_(), jsonGenerator, serializerProvider);
                                                    }

                                                    static {
                                                        FbSerializerProvider.a(NLENLENLModel.class, new Serializer());
                                                    }
                                                }

                                                public NLENLENLModel() {
                                                    super(1);
                                                }

                                                @Nonnull
                                                public final ImmutableList<NLENLENLEModel> m6089a() {
                                                    this.f6041d = super.a(this.f6041d, 0, NLENLENLEModel.class);
                                                    return (ImmutableList) this.f6041d;
                                                }

                                                public final int jK_() {
                                                    return -530948928;
                                                }

                                                public final GraphQLVisitableModel m6088a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                                    h();
                                                    if (m6089a() != null) {
                                                        Builder a = ModelHelper.a(m6089a(), graphQLModelMutatingVisitor);
                                                        if (a != null) {
                                                            graphQLVisitableModel = (NLENLENLModel) ModelHelper.a(null, this);
                                                            graphQLVisitableModel.f6041d = a.b();
                                                        }
                                                    }
                                                    i();
                                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                                }

                                                public final int m6087a(FlatBufferBuilder flatBufferBuilder) {
                                                    h();
                                                    int a = ModelHelper.a(flatBufferBuilder, m6089a());
                                                    flatBufferBuilder.c(1);
                                                    flatBufferBuilder.b(0, a);
                                                    i();
                                                    return flatBufferBuilder.d();
                                                }
                                            }

                                            /* compiled from: photo_picker_camera_cancelled */
                                            public class Serializer extends JsonSerializer<NLENLENModel> {
                                                public final void m6090a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                    NLENLENModel nLENLENModel = (NLENLENModel) obj;
                                                    if (nLENLENModel.w_() == null) {
                                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                        flatBufferBuilder.d(nLENLENModel.m6094a(flatBufferBuilder));
                                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                        wrap.position(0);
                                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                        nLENLENModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                                    }
                                                    NLENLENParser.m6548a(nLENLENModel.w_(), nLENLENModel.u_(), jsonGenerator, serializerProvider);
                                                }

                                                static {
                                                    FbSerializerProvider.a(NLENLENModel.class, new Serializer());
                                                }
                                            }

                                            @Nullable
                                            public final /* synthetic */ NLENLENLModel m6096a() {
                                                return m6093l();
                                            }

                                            @Nullable
                                            public final /* synthetic */ RichDocumentText mo359c() {
                                                return m6092k();
                                            }

                                            public NLENLENModel() {
                                                super(5);
                                            }

                                            @Nullable
                                            private GraphQLObjectType m6091j() {
                                                if (this.b != null && this.f6042d == null) {
                                                    this.f6042d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                                }
                                                return this.f6042d;
                                            }

                                            @Nullable
                                            public final GraphQLDocumentElementType mo358b() {
                                                this.f6043e = (GraphQLDocumentElementType) super.b(this.f6043e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                                return this.f6043e;
                                            }

                                            @Nullable
                                            private RichDocumentTextModel m6092k() {
                                                this.f6044f = (RichDocumentTextModel) super.a(this.f6044f, 2, RichDocumentTextModel.class);
                                                return this.f6044f;
                                            }

                                            @Nullable
                                            private NLENLENLModel m6093l() {
                                                this.f6045g = (NLENLENLModel) super.a(this.f6045g, 3, NLENLENLModel.class);
                                                return this.f6045g;
                                            }

                                            @Nullable
                                            public final GraphQLDocumentListStyle ih_() {
                                                this.f6046h = (GraphQLDocumentListStyle) super.b(this.f6046h, 4, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                                return this.f6046h;
                                            }

                                            public final int jK_() {
                                                return 473184577;
                                            }

                                            public final GraphQLVisitableModel m6095a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                                GraphQLVisitableModel graphQLVisitableModel = null;
                                                h();
                                                if (m6092k() != null) {
                                                    RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6092k());
                                                    if (m6092k() != richDocumentTextModel) {
                                                        graphQLVisitableModel = (NLENLENModel) ModelHelper.a(null, this);
                                                        graphQLVisitableModel.f6044f = richDocumentTextModel;
                                                    }
                                                }
                                                if (m6093l() != null) {
                                                    NLENLENLModel nLENLENLModel = (NLENLENLModel) graphQLModelMutatingVisitor.b(m6093l());
                                                    if (m6093l() != nLENLENLModel) {
                                                        graphQLVisitableModel = (NLENLENModel) ModelHelper.a(graphQLVisitableModel, this);
                                                        graphQLVisitableModel.f6045g = nLENLENLModel;
                                                    }
                                                }
                                                i();
                                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                            }

                                            public final int m6094a(FlatBufferBuilder flatBufferBuilder) {
                                                h();
                                                int a = ModelHelper.a(flatBufferBuilder, m6091j());
                                                int a2 = flatBufferBuilder.a(mo358b());
                                                int a3 = ModelHelper.a(flatBufferBuilder, m6092k());
                                                int a4 = ModelHelper.a(flatBufferBuilder, m6093l());
                                                int a5 = flatBufferBuilder.a(ih_());
                                                flatBufferBuilder.c(5);
                                                flatBufferBuilder.b(0, a);
                                                flatBufferBuilder.b(1, a2);
                                                flatBufferBuilder.b(2, a3);
                                                flatBufferBuilder.b(3, a4);
                                                flatBufferBuilder.b(4, a5);
                                                i();
                                                return flatBufferBuilder.d();
                                            }
                                        }

                                        /* compiled from: photo_picker_camera_cancelled */
                                        public class Serializer extends JsonSerializer<NLENLEModel> {
                                            public final void m6099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                NLENLEModel nLENLEModel = (NLENLEModel) obj;
                                                if (nLENLEModel.w_() == null) {
                                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                    flatBufferBuilder.d(nLENLEModel.m6101a(flatBufferBuilder));
                                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                    wrap.position(0);
                                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                    nLENLEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                                }
                                                NLENLEParser.m6550b(nLENLEModel.w_(), nLENLEModel.u_(), jsonGenerator, serializerProvider);
                                            }

                                            static {
                                                FbSerializerProvider.a(NLENLEModel.class, new Serializer());
                                            }
                                        }

                                        @Nullable
                                        public final /* synthetic */ NLENLENModel m6103a() {
                                            return m6100j();
                                        }

                                        public NLENLEModel() {
                                            super(1);
                                        }

                                        @Nullable
                                        private NLENLENModel m6100j() {
                                            this.f6047d = (NLENLENModel) super.a(this.f6047d, 0, NLENLENModel.class);
                                            return this.f6047d;
                                        }

                                        public final int jK_() {
                                            return -1267606241;
                                        }

                                        public final GraphQLVisitableModel m6102a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                            GraphQLVisitableModel graphQLVisitableModel = null;
                                            h();
                                            if (m6100j() != null) {
                                                NLENLENModel nLENLENModel = (NLENLENModel) graphQLModelMutatingVisitor.b(m6100j());
                                                if (m6100j() != nLENLENModel) {
                                                    graphQLVisitableModel = (NLENLEModel) ModelHelper.a(null, this);
                                                    graphQLVisitableModel.f6047d = nLENLENModel;
                                                }
                                            }
                                            i();
                                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                        }

                                        public final int m6101a(FlatBufferBuilder flatBufferBuilder) {
                                            h();
                                            int a = ModelHelper.a(flatBufferBuilder, m6100j());
                                            flatBufferBuilder.c(1);
                                            flatBufferBuilder.b(0, a);
                                            i();
                                            return flatBufferBuilder.d();
                                        }
                                    }

                                    /* compiled from: photo_picker_camera_cancelled */
                                    public class Serializer extends JsonSerializer<NLENLModel> {
                                        public final void m6104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            NLENLModel nLENLModel = (NLENLModel) obj;
                                            if (nLENLModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(nLENLModel.m6105a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                nLENLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            NLENLParser.m6552a(nLENLModel.w_(), nLENLModel.u_(), jsonGenerator, serializerProvider);
                                        }

                                        static {
                                            FbSerializerProvider.a(NLENLModel.class, new Serializer());
                                        }
                                    }

                                    public NLENLModel() {
                                        super(1);
                                    }

                                    @Nonnull
                                    public final ImmutableList<NLENLEModel> m6107a() {
                                        this.f6048d = super.a(this.f6048d, 0, NLENLEModel.class);
                                        return (ImmutableList) this.f6048d;
                                    }

                                    public final int jK_() {
                                        return -530948928;
                                    }

                                    public final GraphQLVisitableModel m6106a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        GraphQLVisitableModel graphQLVisitableModel = null;
                                        h();
                                        if (m6107a() != null) {
                                            Builder a = ModelHelper.a(m6107a(), graphQLModelMutatingVisitor);
                                            if (a != null) {
                                                graphQLVisitableModel = (NLENLModel) ModelHelper.a(null, this);
                                                graphQLVisitableModel.f6048d = a.b();
                                            }
                                        }
                                        i();
                                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                    }

                                    public final int m6105a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int a = ModelHelper.a(flatBufferBuilder, m6107a());
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, a);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: photo_picker_camera_cancelled */
                                public class Serializer extends JsonSerializer<NLENModel> {
                                    public final void m6108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        NLENModel nLENModel = (NLENModel) obj;
                                        if (nLENModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(nLENModel.m6112a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            nLENModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        NLENParser.m6554a(nLENModel.w_(), nLENModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(NLENModel.class, new Serializer());
                                    }
                                }

                                @Nullable
                                public final /* synthetic */ NLENLModel m6114a() {
                                    return m6111l();
                                }

                                @Nullable
                                public final /* synthetic */ RichDocumentText mo359c() {
                                    return m6110k();
                                }

                                public NLENModel() {
                                    super(5);
                                }

                                @Nullable
                                private GraphQLObjectType m6109j() {
                                    if (this.b != null && this.f6049d == null) {
                                        this.f6049d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                    }
                                    return this.f6049d;
                                }

                                @Nullable
                                public final GraphQLDocumentElementType mo358b() {
                                    this.f6050e = (GraphQLDocumentElementType) super.b(this.f6050e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f6050e;
                                }

                                @Nullable
                                private RichDocumentTextModel m6110k() {
                                    this.f6051f = (RichDocumentTextModel) super.a(this.f6051f, 2, RichDocumentTextModel.class);
                                    return this.f6051f;
                                }

                                @Nullable
                                private NLENLModel m6111l() {
                                    this.f6052g = (NLENLModel) super.a(this.f6052g, 3, NLENLModel.class);
                                    return this.f6052g;
                                }

                                @Nullable
                                public final GraphQLDocumentListStyle ih_() {
                                    this.f6053h = (GraphQLDocumentListStyle) super.b(this.f6053h, 4, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f6053h;
                                }

                                public final int jK_() {
                                    return 473184577;
                                }

                                public final GraphQLVisitableModel m6113a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m6110k() != null) {
                                        RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6110k());
                                        if (m6110k() != richDocumentTextModel) {
                                            graphQLVisitableModel = (NLENModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f6051f = richDocumentTextModel;
                                        }
                                    }
                                    if (m6111l() != null) {
                                        NLENLModel nLENLModel = (NLENLModel) graphQLModelMutatingVisitor.b(m6111l());
                                        if (m6111l() != nLENLModel) {
                                            graphQLVisitableModel = (NLENModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f6052g = nLENLModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m6112a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m6109j());
                                    int a2 = flatBufferBuilder.a(mo358b());
                                    int a3 = ModelHelper.a(flatBufferBuilder, m6110k());
                                    int a4 = ModelHelper.a(flatBufferBuilder, m6111l());
                                    int a5 = flatBufferBuilder.a(ih_());
                                    flatBufferBuilder.c(5);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.b(1, a2);
                                    flatBufferBuilder.b(2, a3);
                                    flatBufferBuilder.b(3, a4);
                                    flatBufferBuilder.b(4, a5);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: photo_picker_camera_cancelled */
                            public class Serializer extends JsonSerializer<NLEModel> {
                                public final void m6117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    NLEModel nLEModel = (NLEModel) obj;
                                    if (nLEModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(nLEModel.m6119a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        nLEModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    NLEParser.m6556b(nLEModel.w_(), nLEModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(NLEModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ NLENModel m6121a() {
                                return m6118j();
                            }

                            public NLEModel() {
                                super(1);
                            }

                            @Nullable
                            private NLENModel m6118j() {
                                this.f6054d = (NLENModel) super.a(this.f6054d, 0, NLENModel.class);
                                return this.f6054d;
                            }

                            public final int jK_() {
                                return -1267606241;
                            }

                            public final GraphQLVisitableModel m6120a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m6118j() != null) {
                                    NLENModel nLENModel = (NLENModel) graphQLModelMutatingVisitor.b(m6118j());
                                    if (m6118j() != nLENModel) {
                                        graphQLVisitableModel = (NLEModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f6054d = nLENModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m6119a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m6118j());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: photo_picker_camera_cancelled */
                        public class Serializer extends JsonSerializer<NLModel> {
                            public final void m6122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NLModel nLModel = (NLModel) obj;
                                if (nLModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nLModel.m6123a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NLParser.m6558a(nLModel.w_(), nLModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NLModel.class, new Serializer());
                            }
                        }

                        public NLModel() {
                            super(1);
                        }

                        @Nonnull
                        public final ImmutableList<NLEModel> m6125a() {
                            this.f6055d = super.a(this.f6055d, 0, NLEModel.class);
                            return (ImmutableList) this.f6055d;
                        }

                        public final int jK_() {
                            return -530948928;
                        }

                        public final GraphQLVisitableModel m6124a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m6125a() != null) {
                                Builder a = ModelHelper.a(m6125a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (NLModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f6055d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m6123a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m6125a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: photo_picker_camera_cancelled */
                    public class Serializer extends JsonSerializer<NModel> {
                        public final void m6126a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NModel nModel = (NModel) obj;
                            if (nModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nModel.m6130a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NParser.m6560a(nModel.w_(), nModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NLModel m6132a() {
                        return m6129l();
                    }

                    @Nullable
                    public final /* synthetic */ RichDocumentText mo359c() {
                        return m6128k();
                    }

                    public NModel() {
                        super(5);
                    }

                    @Nullable
                    private GraphQLObjectType m6127j() {
                        if (this.b != null && this.f6056d == null) {
                            this.f6056d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f6056d;
                    }

                    @Nullable
                    public final GraphQLDocumentElementType mo358b() {
                        this.f6057e = (GraphQLDocumentElementType) super.b(this.f6057e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f6057e;
                    }

                    @Nullable
                    private RichDocumentTextModel m6128k() {
                        this.f6058f = (RichDocumentTextModel) super.a(this.f6058f, 2, RichDocumentTextModel.class);
                        return this.f6058f;
                    }

                    @Nullable
                    private NLModel m6129l() {
                        this.f6059g = (NLModel) super.a(this.f6059g, 3, NLModel.class);
                        return this.f6059g;
                    }

                    @Nullable
                    public final GraphQLDocumentListStyle ih_() {
                        this.f6060h = (GraphQLDocumentListStyle) super.b(this.f6060h, 4, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f6060h;
                    }

                    public final int jK_() {
                        return 473184577;
                    }

                    public final GraphQLVisitableModel m6131a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6128k() != null) {
                            RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6128k());
                            if (m6128k() != richDocumentTextModel) {
                                graphQLVisitableModel = (NModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f6058f = richDocumentTextModel;
                            }
                        }
                        if (m6129l() != null) {
                            NLModel nLModel = (NLModel) graphQLModelMutatingVisitor.b(m6129l());
                            if (m6129l() != nLModel) {
                                graphQLVisitableModel = (NModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f6059g = nLModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6130a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6127j());
                        int a2 = flatBufferBuilder.a(mo358b());
                        int a3 = ModelHelper.a(flatBufferBuilder, m6128k());
                        int a4 = ModelHelper.a(flatBufferBuilder, m6129l());
                        int a5 = flatBufferBuilder.a(ih_());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, a4);
                        flatBufferBuilder.b(4, a5);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: photo_picker_camera_cancelled */
                public class Serializer extends JsonSerializer<EModel> {
                    public final void m6135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EModel eModel = (EModel) obj;
                        if (eModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(eModel.m6137a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            eModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EParser.m6562b(eModel.w_(), eModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NModel m6139a() {
                    return m6136j();
                }

                public EModel() {
                    super(1);
                }

                @Nullable
                private NModel m6136j() {
                    this.f6061d = (NModel) super.a(this.f6061d, 0, NModel.class);
                    return this.f6061d;
                }

                public final int jK_() {
                    return -1267606241;
                }

                public final GraphQLVisitableModel m6138a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6136j() != null) {
                        NModel nModel = (NModel) graphQLModelMutatingVisitor.b(m6136j());
                        if (m6136j() != nModel) {
                            graphQLVisitableModel = (EModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f6061d = nModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6137a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6136j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<LModel> {
                public final void m6140a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LModel lModel = (LModel) obj;
                    if (lModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lModel.m6141a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LParser.m6564a(lModel.w_(), lModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LModel.class, new Serializer());
                }
            }

            public LModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EModel> m6143a() {
                this.f6062d = super.a(this.f6062d, 0, EModel.class);
                return (ImmutableList) this.f6062d;
            }

            public final int jK_() {
                return -530948928;
            }

            public final GraphQLVisitableModel m6142a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6143a() != null) {
                    Builder a = ModelHelper.a(m6143a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (LModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6062d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6141a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6143a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentNestedListItemModel> {
            public final void m6144a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentNestedListItemModel richDocumentNestedListItemModel = (RichDocumentNestedListItemModel) obj;
                if (richDocumentNestedListItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentNestedListItemModel.m6148a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentNestedListItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentNestedListItemModel.w_();
                int u_ = richDocumentNestedListItemModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("l");
                    LParser.m6564a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("list_style");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 4));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentNestedListItemModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentText mo359c() {
            return m6146j();
        }

        public RichDocumentNestedListItemModel() {
            super(5);
        }

        @Nullable
        private GraphQLObjectType m6145a() {
            if (this.b != null && this.f6063d == null) {
                this.f6063d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6063d;
        }

        @Nullable
        public final GraphQLDocumentElementType mo358b() {
            this.f6064e = (GraphQLDocumentElementType) super.b(this.f6064e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6064e;
        }

        @Nullable
        private RichDocumentTextModel m6146j() {
            this.f6065f = (RichDocumentTextModel) super.a(this.f6065f, 2, RichDocumentTextModel.class);
            return this.f6065f;
        }

        @Nullable
        private LModel m6147k() {
            this.f6066g = (LModel) super.a(this.f6066g, 3, LModel.class);
            return this.f6066g;
        }

        @Nullable
        public final GraphQLDocumentListStyle ih_() {
            this.f6067h = (GraphQLDocumentListStyle) super.b(this.f6067h, 4, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6067h;
        }

        public final int jK_() {
            return -1870845885;
        }

        public final GraphQLVisitableModel m6149a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6146j() != null) {
                RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6146j());
                if (m6146j() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentNestedListItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6065f = richDocumentTextModel;
                }
            }
            if (m6147k() != null) {
                LModel lModel = (LModel) graphQLModelMutatingVisitor.b(m6147k());
                if (m6147k() != lModel) {
                    graphQLVisitableModel = (RichDocumentNestedListItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6066g = lModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6148a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6145a());
            int a2 = flatBufferBuilder.a(mo358b());
            int a3 = ModelHelper.a(flatBufferBuilder, m6146j());
            int a4 = ModelHelper.a(flatBufferBuilder, m6147k());
            int a5 = flatBufferBuilder.a(ih_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1617558826)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentRelatedArticleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RelatedArticleGlobalShareModel f6068d;
        private boolean f6069e;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentRelatedArticleModel.class, new Deserializer());
            }

            public Object m6152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentRelatedArticleParser.m6566b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentRelatedArticleModel = new RichDocumentRelatedArticleModel();
                ((BaseModel) richDocumentRelatedArticleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentRelatedArticleModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentRelatedArticleModel).a();
                }
                return richDocumentRelatedArticleModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentRelatedArticleModel> {
            public final void m6153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentRelatedArticleModel richDocumentRelatedArticleModel = (RichDocumentRelatedArticleModel) obj;
                if (richDocumentRelatedArticleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentRelatedArticleModel.m6155a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentRelatedArticleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentRelatedArticleParser.m6567b(richDocumentRelatedArticleModel.w_(), richDocumentRelatedArticleModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentRelatedArticleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RelatedArticleGlobalShareModel m6157a() {
            return m6154j();
        }

        public RichDocumentRelatedArticleModel() {
            super(2);
        }

        @Nullable
        private RelatedArticleGlobalShareModel m6154j() {
            this.f6068d = (RelatedArticleGlobalShareModel) super.a(this.f6068d, 0, RelatedArticleGlobalShareModel.class);
            return this.f6068d;
        }

        public final boolean m6159b() {
            a(0, 1);
            return this.f6069e;
        }

        public final int jK_() {
            return -669384015;
        }

        public final GraphQLVisitableModel m6156a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6154j() != null) {
                RelatedArticleGlobalShareModel relatedArticleGlobalShareModel = (RelatedArticleGlobalShareModel) graphQLModelMutatingVisitor.b(m6154j());
                if (m6154j() != relatedArticleGlobalShareModel) {
                    graphQLVisitableModel = (RichDocumentRelatedArticleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6068d = relatedArticleGlobalShareModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6155a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6154j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f6069e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6158a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6069e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -920116267)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentRelatedArticlesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentRelatedArticles {
        @Nullable
        private String f6071d;
        @Nullable
        private GraphQLDocumentElementType f6072e;
        @Nullable
        private String f6073f;
        @Nullable
        private RelatedArticleObjsModel f6074g;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentRelatedArticlesModel.class, new Deserializer());
            }

            public Object m6160a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentRelatedArticlesParser.m6570a(jsonParser);
                Object richDocumentRelatedArticlesModel = new RichDocumentRelatedArticlesModel();
                ((BaseModel) richDocumentRelatedArticlesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentRelatedArticlesModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentRelatedArticlesModel).a();
                }
                return richDocumentRelatedArticlesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1416977946)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class RelatedArticleObjsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RelatedArticleEdgeModel> f6070d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RelatedArticleObjsModel.class, new Deserializer());
                }

                public Object m6161a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RelatedArticleObjsParser.m6568a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object relatedArticleObjsModel = new RelatedArticleObjsModel();
                    ((BaseModel) relatedArticleObjsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (relatedArticleObjsModel instanceof Postprocessable) {
                        return ((Postprocessable) relatedArticleObjsModel).a();
                    }
                    return relatedArticleObjsModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<RelatedArticleObjsModel> {
                public final void m6162a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RelatedArticleObjsModel relatedArticleObjsModel = (RelatedArticleObjsModel) obj;
                    if (relatedArticleObjsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(relatedArticleObjsModel.m6163a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        relatedArticleObjsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RelatedArticleObjsParser.m6569a(relatedArticleObjsModel.w_(), relatedArticleObjsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RelatedArticleObjsModel.class, new Serializer());
                }
            }

            public RelatedArticleObjsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<RelatedArticleEdgeModel> m6165a() {
                this.f6070d = super.a(this.f6070d, 0, RelatedArticleEdgeModel.class);
                return (ImmutableList) this.f6070d;
            }

            public final int jK_() {
                return 2038352132;
            }

            public final GraphQLVisitableModel m6164a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6165a() != null) {
                    Builder a = ModelHelper.a(m6165a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (RelatedArticleObjsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6070d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6163a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6165a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentRelatedArticlesModel> {
            public final void m6166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentRelatedArticlesModel richDocumentRelatedArticlesModel = (RichDocumentRelatedArticlesModel) obj;
                if (richDocumentRelatedArticlesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentRelatedArticlesModel.m6171a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentRelatedArticlesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentRelatedArticlesModel.w_();
                int u_ = richDocumentRelatedArticlesModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("block_title");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("related_article_objs");
                    RelatedArticleObjsParser.m6569a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentRelatedArticlesModel.class, new Serializer());
            }
        }

        public RichDocumentRelatedArticlesModel() {
            super(4);
        }

        @Nullable
        private String m6167j() {
            this.f6071d = super.a(this.f6071d, 0);
            return this.f6071d;
        }

        @Nullable
        private GraphQLDocumentElementType m6168k() {
            this.f6072e = (GraphQLDocumentElementType) super.b(this.f6072e, 1, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6072e;
        }

        @Nullable
        private String m6169l() {
            this.f6073f = super.a(this.f6073f, 2);
            return this.f6073f;
        }

        @Nullable
        private RelatedArticleObjsModel m6170m() {
            this.f6074g = (RelatedArticleObjsModel) super.a(this.f6074g, 3, RelatedArticleObjsModel.class);
            return this.f6074g;
        }

        @Nullable
        public final String m6173a() {
            return m6169l();
        }

        public final int jK_() {
            return 915230656;
        }

        public final GraphQLVisitableModel m6172a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6170m() != null) {
                RelatedArticleObjsModel relatedArticleObjsModel = (RelatedArticleObjsModel) graphQLModelMutatingVisitor.b(m6170m());
                if (m6170m() != relatedArticleObjsModel) {
                    graphQLVisitableModel = (RichDocumentRelatedArticlesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6074g = relatedArticleObjsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6171a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6167j());
            int a = flatBufferBuilder.a(m6168k());
            int b2 = flatBufferBuilder.b(m6169l());
            int a2 = ModelHelper.a(flatBufferBuilder, m6170m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1277381090)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentSectionEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RichDocumentSectionModel f6147d;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentSectionEdgeModel.class, new Deserializer());
            }

            public Object m6174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentSectionEdgeParser.m6575b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentSectionEdgeModel = new RichDocumentSectionEdgeModel();
                ((BaseModel) richDocumentSectionEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentSectionEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentSectionEdgeModel).a();
                }
                return richDocumentSectionEdgeModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 869291789)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: photo_picker_camera_cancelled */
        public final class RichDocumentSectionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentListItems, RichDocumentPhoto, RichDocumentRelatedArticles, RichDocumentSlideshow, RichDocumentVideo {
            @Nullable
            private GraphQLDocumentElementMarginStyle f6111A;
            @Nullable
            private FBPhotoModel f6112B;
            @Nullable
            private FBPhotoModel f6113C;
            @Nullable
            private GraphQLDocumentMediaPresentationStyle f6114D;
            @Nullable
            private RelatedArticleObjsModel f6115E;
            @Nullable
            private SlideEdgesModel f6116F;
            @Nullable
            private RichDocumentTextAnnotationModel f6117G;
            @Nullable
            private String f6118H;
            @Nullable
            private RichDocumentTextAnnotationModel f6119I;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f6120J;
            @Nullable
            private GraphQLDocumentVideoControlStyle f6121K;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f6122L;
            @Nullable
            private GraphQLDocumentWebviewPresentationStyle f6123M;
            @Nullable
            private GraphQLObjectType f6124d;
            @Nullable
            private GraphQLAudioAnnotationPlayMode f6125e;
            @Nullable
            private RichDocumentTextAnnotationModel f6126f;
            @Nullable
            private String f6127g;
            @Nullable
            private String f6128h;
            @Nullable
            private String f6129i;
            @Nullable
            private List<RichDocumentTextModel> f6130j;
            @Nullable
            private RichDocumentTextAnnotationModel f6131k;
            private int f6132l;
            private int f6133m;
            @Nullable
            private GraphQLDocumentElementType f6134n;
            @Nullable
            private RichDocumentTextModel f6135o;
            @Nullable
            private FBVideoModel f6136p;
            private boolean f6137q;
            @Nullable
            private GraphQLFeedback f6138r;
            @Nullable
            private GraphQLDocumentFeedbackOptions f6139s;
            @Nullable
            private String f6140t;
            @Nullable
            private String f6141u;
            @Nullable
            private ListElementsModel f6142v;
            @Nullable
            private GraphQLDocumentListStyle f6143w;
            @Nullable
            private RichDocumentLocationAnnotationModel f6144x;
            @Nullable
            private List<RichDocumentLocationAnnotationModel> f6145y;
            @Nullable
            private GraphQLDocumentMapStyle f6146z;

            /* compiled from: photo_picker_camera_cancelled */
            public final class Builder {
                @Nullable
                public GraphQLDocumentMediaPresentationStyle f6075A;
                @Nullable
                public RelatedArticleObjsModel f6076B;
                @Nullable
                public SlideEdgesModel f6077C;
                @Nullable
                public RichDocumentTextAnnotationModel f6078D;
                @Nullable
                public String f6079E;
                @Nullable
                public RichDocumentTextAnnotationModel f6080F;
                @Nullable
                public GraphQLDocumentVideoAutoplayStyle f6081G;
                @Nullable
                public GraphQLDocumentVideoControlStyle f6082H;
                @Nullable
                public GraphQLDocumentVideoLoopingStyle f6083I;
                @Nullable
                public GraphQLDocumentWebviewPresentationStyle f6084J;
                @Nullable
                public GraphQLObjectType f6085a;
                @Nullable
                public GraphQLAudioAnnotationPlayMode f6086b;
                @Nullable
                public RichDocumentTextAnnotationModel f6087c;
                @Nullable
                public String f6088d;
                @Nullable
                public String f6089e;
                @Nullable
                public String f6090f;
                @Nullable
                public ImmutableList<RichDocumentTextModel> f6091g;
                @Nullable
                public RichDocumentTextAnnotationModel f6092h;
                public int f6093i;
                public int f6094j;
                @Nullable
                public GraphQLDocumentElementType f6095k;
                @Nullable
                public RichDocumentTextModel f6096l;
                @Nullable
                public FBVideoModel f6097m;
                public boolean f6098n;
                @Nullable
                public GraphQLFeedback f6099o;
                @Nullable
                public GraphQLDocumentFeedbackOptions f6100p;
                @Nullable
                public String f6101q;
                @Nullable
                public String f6102r;
                @Nullable
                public ListElementsModel f6103s;
                @Nullable
                public GraphQLDocumentListStyle f6104t;
                @Nullable
                public RichDocumentLocationAnnotationModel f6105u;
                @Nullable
                public ImmutableList<RichDocumentLocationAnnotationModel> f6106v;
                @Nullable
                public GraphQLDocumentMapStyle f6107w;
                @Nullable
                public GraphQLDocumentElementMarginStyle f6108x;
                @Nullable
                public FBPhotoModel f6109y;
                @Nullable
                public FBPhotoModel f6110z;
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RichDocumentSectionModel.class, new Deserializer());
                }

                public Object m6175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RichDocumentSectionParser.m6571a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object richDocumentSectionModel = new RichDocumentSectionModel();
                    ((BaseModel) richDocumentSectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (richDocumentSectionModel instanceof Postprocessable) {
                        return ((Postprocessable) richDocumentSectionModel).a();
                    }
                    return richDocumentSectionModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<RichDocumentSectionModel> {
                public final void m6176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RichDocumentSectionModel richDocumentSectionModel = (RichDocumentSectionModel) obj;
                    if (richDocumentSectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(richDocumentSectionModel.m6201a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        richDocumentSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RichDocumentSectionParser.m6572a(richDocumentSectionModel.w_(), richDocumentSectionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RichDocumentSectionModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RelatedArticleObjsModel m6177A() {
                return m6196T();
            }

            @Nullable
            public final /* synthetic */ SlideEdgesModel m6178B() {
                return m6197U();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m6179C() {
                return m6198V();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m6180D() {
                return m6200X();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m6206c() {
                return m6186J();
            }

            @Nullable
            public final /* synthetic */ RichDocumentTextAnnotationModel m6208g() {
                return m6189M();
            }

            @Nullable
            public final /* synthetic */ FBVideo ig_() {
                return m6191O();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText m6211l() {
                return m6190N();
            }

            @Nullable
            public final /* synthetic */ FBPhoto mo340n() {
                return m6194R();
            }

            @Nullable
            public final /* synthetic */ ListElementsModel m6218s() {
                return m6192P();
            }

            @Nullable
            public final /* synthetic */ RichDocumentLocationAnnotationModel m6220u() {
                return m6193Q();
            }

            @Nullable
            public final /* synthetic */ FBPhoto m6224y() {
                return m6195S();
            }

            public RichDocumentSectionModel() {
                super(36);
            }

            @Nullable
            public final GraphQLObjectType m6185I() {
                if (this.b != null && this.f6124d == null) {
                    this.f6124d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f6124d;
            }

            @Nullable
            public final GraphQLAudioAnnotationPlayMode m6205b() {
                this.f6125e = (GraphQLAudioAnnotationPlayMode) super.b(this.f6125e, 1, GraphQLAudioAnnotationPlayMode.class, GraphQLAudioAnnotationPlayMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6125e;
            }

            @Nullable
            public final RichDocumentTextAnnotationModel m6186J() {
                this.f6126f = (RichDocumentTextAnnotationModel) super.a(this.f6126f, 2, RichDocumentTextAnnotationModel.class);
                return this.f6126f;
            }

            @Nullable
            public final String m6207d() {
                this.f6127g = super.a(this.f6127g, 3);
                return this.f6127g;
            }

            @Nullable
            public final String ik_() {
                this.f6128h = super.a(this.f6128h, 4);
                return this.f6128h;
            }

            @Nullable
            public final String m6187K() {
                this.f6129i = super.a(this.f6129i, 5);
                return this.f6129i;
            }

            @Nonnull
            public final ImmutableList<RichDocumentTextModel> m6188L() {
                this.f6130j = super.a(this.f6130j, 6, RichDocumentTextModel.class);
                return (ImmutableList) this.f6130j;
            }

            @Nullable
            public final RichDocumentTextAnnotationModel m6189M() {
                this.f6131k = (RichDocumentTextAnnotationModel) super.a(this.f6131k, 7, RichDocumentTextAnnotationModel.class);
                return this.f6131k;
            }

            public final int il_() {
                a(1, 0);
                return this.f6132l;
            }

            public final int m6209j() {
                a(1, 1);
                return this.f6133m;
            }

            @Nullable
            public final GraphQLDocumentElementType m6210k() {
                this.f6134n = (GraphQLDocumentElementType) super.b(this.f6134n, 10, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6134n;
            }

            @Nullable
            public final RichDocumentTextModel m6190N() {
                this.f6135o = (RichDocumentTextModel) super.a(this.f6135o, 11, RichDocumentTextModel.class);
                return this.f6135o;
            }

            @Nullable
            public final FBVideoModel m6191O() {
                this.f6136p = (FBVideoModel) super.a(this.f6136p, 12, FBVideoModel.class);
                return this.f6136p;
            }

            public final boolean m6212m() {
                a(1, 5);
                return this.f6137q;
            }

            @Nullable
            public final GraphQLFeedback m6214o() {
                this.f6138r = (GraphQLFeedback) super.a(this.f6138r, 14, GraphQLFeedback.class);
                return this.f6138r;
            }

            @Nullable
            public final GraphQLDocumentFeedbackOptions m6215p() {
                this.f6139s = (GraphQLDocumentFeedbackOptions) super.b(this.f6139s, 15, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6139s;
            }

            @Nullable
            public final String m6216q() {
                this.f6140t = super.a(this.f6140t, 16);
                return this.f6140t;
            }

            @Nullable
            public final String m6217r() {
                this.f6141u = super.a(this.f6141u, 17);
                return this.f6141u;
            }

            @Nullable
            public final ListElementsModel m6192P() {
                this.f6142v = (ListElementsModel) super.a(this.f6142v, 18, ListElementsModel.class);
                return this.f6142v;
            }

            @Nullable
            public final GraphQLDocumentListStyle m6219t() {
                this.f6143w = (GraphQLDocumentListStyle) super.b(this.f6143w, 19, GraphQLDocumentListStyle.class, GraphQLDocumentListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6143w;
            }

            @Nullable
            public final RichDocumentLocationAnnotationModel m6193Q() {
                this.f6144x = (RichDocumentLocationAnnotationModel) super.a(this.f6144x, 20, RichDocumentLocationAnnotationModel.class);
                return this.f6144x;
            }

            @Nonnull
            public final ImmutableList<RichDocumentLocationAnnotationModel> m6221v() {
                this.f6145y = super.a(this.f6145y, 21, RichDocumentLocationAnnotationModel.class);
                return (ImmutableList) this.f6145y;
            }

            @Nullable
            public final GraphQLDocumentMapStyle m6222w() {
                this.f6146z = (GraphQLDocumentMapStyle) super.b(this.f6146z, 22, GraphQLDocumentMapStyle.class, GraphQLDocumentMapStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6146z;
            }

            @Nullable
            public final GraphQLDocumentElementMarginStyle m6223x() {
                this.f6111A = (GraphQLDocumentElementMarginStyle) super.b(this.f6111A, 23, GraphQLDocumentElementMarginStyle.class, GraphQLDocumentElementMarginStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6111A;
            }

            @Nullable
            public final FBPhotoModel m6194R() {
                this.f6112B = (FBPhotoModel) super.a(this.f6112B, 24, FBPhotoModel.class);
                return this.f6112B;
            }

            @Nullable
            public final FBPhotoModel m6195S() {
                this.f6113C = (FBPhotoModel) super.a(this.f6113C, 25, FBPhotoModel.class);
                return this.f6113C;
            }

            @Nullable
            public final GraphQLDocumentMediaPresentationStyle m6225z() {
                this.f6114D = (GraphQLDocumentMediaPresentationStyle) super.b(this.f6114D, 26, GraphQLDocumentMediaPresentationStyle.class, GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6114D;
            }

            @Nullable
            public final RelatedArticleObjsModel m6196T() {
                this.f6115E = (RelatedArticleObjsModel) super.a(this.f6115E, 27, RelatedArticleObjsModel.class);
                return this.f6115E;
            }

            @Nullable
            public final SlideEdgesModel m6197U() {
                this.f6116F = (SlideEdgesModel) super.a(this.f6116F, 28, SlideEdgesModel.class);
                return this.f6116F;
            }

            @Nullable
            public final RichDocumentTextAnnotationModel m6198V() {
                this.f6117G = (RichDocumentTextAnnotationModel) super.a(this.f6117G, 29, RichDocumentTextAnnotationModel.class);
                return this.f6117G;
            }

            @Nullable
            public final String m6199W() {
                this.f6118H = super.a(this.f6118H, 30);
                return this.f6118H;
            }

            @Nullable
            public final RichDocumentTextAnnotationModel m6200X() {
                this.f6119I = (RichDocumentTextAnnotationModel) super.a(this.f6119I, 31, RichDocumentTextAnnotationModel.class);
                return this.f6119I;
            }

            @Nullable
            public final GraphQLDocumentVideoAutoplayStyle m6181E() {
                this.f6120J = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f6120J, 32, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6120J;
            }

            @Nullable
            public final GraphQLDocumentVideoControlStyle m6182F() {
                this.f6121K = (GraphQLDocumentVideoControlStyle) super.b(this.f6121K, 33, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6121K;
            }

            @Nullable
            public final GraphQLDocumentVideoLoopingStyle m6183G() {
                this.f6122L = (GraphQLDocumentVideoLoopingStyle) super.b(this.f6122L, 34, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6122L;
            }

            @Nullable
            public final GraphQLDocumentWebviewPresentationStyle m6184H() {
                this.f6123M = (GraphQLDocumentWebviewPresentationStyle) super.b(this.f6123M, 35, GraphQLDocumentWebviewPresentationStyle.class, GraphQLDocumentWebviewPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6123M;
            }

            @Nullable
            public final String m6203a() {
                return m6217r();
            }

            public final int jK_() {
                return 473184577;
            }

            public final GraphQLVisitableModel m6202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                RichDocumentTextAnnotationModel richDocumentTextAnnotationModel;
                com.google.common.collect.ImmutableList.Builder a;
                FBPhotoModel fBPhotoModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6186J() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6186J());
                    if (m6186J() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6126f = richDocumentTextAnnotationModel;
                    }
                }
                if (m6188L() != null) {
                    a = ModelHelper.a(m6188L(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        RichDocumentSectionModel richDocumentSectionModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        richDocumentSectionModel.f6130j = a.b();
                        graphQLVisitableModel = richDocumentSectionModel;
                    }
                }
                if (m6189M() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6189M());
                    if (m6189M() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6131k = richDocumentTextAnnotationModel;
                    }
                }
                if (m6190N() != null) {
                    RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6190N());
                    if (m6190N() != richDocumentTextModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6135o = richDocumentTextModel;
                    }
                }
                if (m6191O() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m6191O());
                    if (m6191O() != fBVideoModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6136p = fBVideoModel;
                    }
                }
                if (m6214o() != null) {
                    GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m6214o());
                    if (m6214o() != graphQLFeedback) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6138r = graphQLFeedback;
                    }
                }
                if (m6192P() != null) {
                    ListElementsModel listElementsModel = (ListElementsModel) graphQLModelMutatingVisitor.b(m6192P());
                    if (m6192P() != listElementsModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6142v = listElementsModel;
                    }
                }
                if (m6193Q() != null) {
                    RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel = (RichDocumentLocationAnnotationModel) graphQLModelMutatingVisitor.b(m6193Q());
                    if (m6193Q() != richDocumentLocationAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6144x = richDocumentLocationAnnotationModel;
                    }
                }
                if (m6221v() != null) {
                    a = ModelHelper.a(m6221v(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        richDocumentSectionModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        richDocumentSectionModel.f6145y = a.b();
                        graphQLVisitableModel = richDocumentSectionModel;
                    }
                }
                if (m6194R() != null) {
                    fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m6194R());
                    if (m6194R() != fBPhotoModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6112B = fBPhotoModel;
                    }
                }
                if (m6195S() != null) {
                    fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m6195S());
                    if (m6195S() != fBPhotoModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6113C = fBPhotoModel;
                    }
                }
                if (m6196T() != null) {
                    RelatedArticleObjsModel relatedArticleObjsModel = (RelatedArticleObjsModel) graphQLModelMutatingVisitor.b(m6196T());
                    if (m6196T() != relatedArticleObjsModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6115E = relatedArticleObjsModel;
                    }
                }
                if (m6197U() != null) {
                    SlideEdgesModel slideEdgesModel = (SlideEdgesModel) graphQLModelMutatingVisitor.b(m6197U());
                    if (m6197U() != slideEdgesModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6116F = slideEdgesModel;
                    }
                }
                if (m6198V() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6198V());
                    if (m6198V() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6117G = richDocumentTextAnnotationModel;
                    }
                }
                if (m6200X() != null) {
                    richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6200X());
                    if (m6200X() != richDocumentTextAnnotationModel) {
                        graphQLVisitableModel = (RichDocumentSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6119I = richDocumentTextAnnotationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6201a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6185I());
                int a2 = flatBufferBuilder.a(m6205b());
                int a3 = ModelHelper.a(flatBufferBuilder, m6186J());
                int b = flatBufferBuilder.b(m6207d());
                int b2 = flatBufferBuilder.b(ik_());
                int b3 = flatBufferBuilder.b(m6187K());
                int a4 = ModelHelper.a(flatBufferBuilder, m6188L());
                int a5 = ModelHelper.a(flatBufferBuilder, m6189M());
                int a6 = flatBufferBuilder.a(m6210k());
                int a7 = ModelHelper.a(flatBufferBuilder, m6190N());
                int a8 = ModelHelper.a(flatBufferBuilder, m6191O());
                int a9 = ModelHelper.a(flatBufferBuilder, m6214o());
                int a10 = flatBufferBuilder.a(m6215p());
                int b4 = flatBufferBuilder.b(m6216q());
                int b5 = flatBufferBuilder.b(m6217r());
                int a11 = ModelHelper.a(flatBufferBuilder, m6192P());
                int a12 = flatBufferBuilder.a(m6219t());
                int a13 = ModelHelper.a(flatBufferBuilder, m6193Q());
                int a14 = ModelHelper.a(flatBufferBuilder, m6221v());
                int a15 = flatBufferBuilder.a(m6222w());
                int a16 = flatBufferBuilder.a(m6223x());
                int a17 = ModelHelper.a(flatBufferBuilder, m6194R());
                int a18 = ModelHelper.a(flatBufferBuilder, m6195S());
                int a19 = flatBufferBuilder.a(m6225z());
                int a20 = ModelHelper.a(flatBufferBuilder, m6196T());
                int a21 = ModelHelper.a(flatBufferBuilder, m6197U());
                int a22 = ModelHelper.a(flatBufferBuilder, m6198V());
                int b6 = flatBufferBuilder.b(m6199W());
                int a23 = ModelHelper.a(flatBufferBuilder, m6200X());
                int a24 = flatBufferBuilder.a(m6181E());
                int a25 = flatBufferBuilder.a(m6182F());
                int a26 = flatBufferBuilder.a(m6183G());
                int a27 = flatBufferBuilder.a(m6184H());
                flatBufferBuilder.c(36);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.a(8, this.f6132l, 0);
                flatBufferBuilder.a(9, this.f6133m, 0);
                flatBufferBuilder.b(10, a6);
                flatBufferBuilder.b(11, a7);
                flatBufferBuilder.b(12, a8);
                flatBufferBuilder.a(13, this.f6137q);
                flatBufferBuilder.b(14, a9);
                flatBufferBuilder.b(15, a10);
                flatBufferBuilder.b(16, b4);
                flatBufferBuilder.b(17, b5);
                flatBufferBuilder.b(18, a11);
                flatBufferBuilder.b(19, a12);
                flatBufferBuilder.b(20, a13);
                flatBufferBuilder.b(21, a14);
                flatBufferBuilder.b(22, a15);
                flatBufferBuilder.b(23, a16);
                flatBufferBuilder.b(24, a17);
                flatBufferBuilder.b(25, a18);
                flatBufferBuilder.b(26, a19);
                flatBufferBuilder.b(27, a20);
                flatBufferBuilder.b(28, a21);
                flatBufferBuilder.b(29, a22);
                flatBufferBuilder.b(30, b6);
                flatBufferBuilder.b(31, a23);
                flatBufferBuilder.b(32, a24);
                flatBufferBuilder.b(33, a25);
                flatBufferBuilder.b(34, a26);
                flatBufferBuilder.b(35, a27);
                i();
                return flatBufferBuilder.d();
            }

            public final void m6204a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f6132l = mutableFlatBuffer.a(i, 8, 0);
                this.f6133m = mutableFlatBuffer.a(i, 9, 0);
                this.f6137q = mutableFlatBuffer.a(i, 13);
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentSectionEdgeModel> {
            public final void m6226a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentSectionEdgeModel richDocumentSectionEdgeModel = (RichDocumentSectionEdgeModel) obj;
                if (richDocumentSectionEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentSectionEdgeModel.m6228a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentSectionEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentSectionEdgeParser.m6576b(richDocumentSectionEdgeModel.w_(), richDocumentSectionEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentSectionEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentSectionModel m6230a() {
            return m6227j();
        }

        public RichDocumentSectionEdgeModel() {
            super(1);
        }

        @Nullable
        private RichDocumentSectionModel m6227j() {
            this.f6147d = (RichDocumentSectionModel) super.a(this.f6147d, 0, RichDocumentSectionModel.class);
            return this.f6147d;
        }

        public final int jK_() {
            return -1471668879;
        }

        public final GraphQLVisitableModel m6229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6227j() != null) {
                RichDocumentSectionModel richDocumentSectionModel = (RichDocumentSectionModel) graphQLModelMutatingVisitor.b(m6227j());
                if (m6227j() != richDocumentSectionModel) {
                    graphQLVisitableModel = (RichDocumentSectionEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6147d = richDocumentSectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6228a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6227j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -516795559)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentSlideModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, RichDocumentPhoto, RichDocumentVideo {
        @Nullable
        private GraphQLObjectType f6148d;
        @Nullable
        private GraphQLAudioAnnotationPlayMode f6149e;
        @Nullable
        private RichDocumentTextAnnotationModel f6150f;
        @Nullable
        private String f6151g;
        @Nullable
        private RichDocumentTextAnnotationModel f6152h;
        @Nullable
        private GraphQLDocumentElementType f6153i;
        @Nullable
        private FBVideoModel f6154j;
        @Nullable
        private GraphQLFeedback f6155k;
        @Nullable
        private GraphQLDocumentFeedbackOptions f6156l;
        @Nullable
        private String f6157m;
        @Nullable
        private RichDocumentLocationAnnotationModel f6158n;
        @Nullable
        private FBPhotoModel f6159o;
        @Nullable
        private FBPhotoModel f6160p;
        @Nullable
        private GraphQLDocumentMediaPresentationStyle f6161q;
        @Nullable
        private RichDocumentTextAnnotationModel f6162r;
        @Nullable
        private RichDocumentTextAnnotationModel f6163s;
        @Nullable
        private GraphQLDocumentVideoAutoplayStyle f6164t;
        @Nullable
        private GraphQLDocumentVideoControlStyle f6165u;
        @Nullable
        private GraphQLDocumentVideoLoopingStyle f6166v;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentSlideModel.class, new Deserializer());
            }

            public Object m6231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentSlideParser.m6577b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentSlideModel = new RichDocumentSlideModel();
                ((BaseModel) richDocumentSlideModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentSlideModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentSlideModel).a();
                }
                return richDocumentSlideModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentSlideModel> {
            public final void m6232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentSlideModel richDocumentSlideModel = (RichDocumentSlideModel) obj;
                if (richDocumentSlideModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentSlideModel.m6242a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentSlideModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentSlideParser.m6578b(richDocumentSlideModel.w_(), richDocumentSlideModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentSlideModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentTextAnnotationModel m6246c() {
            return m6237v();
        }

        @Nullable
        public final /* synthetic */ FBVideo ig_() {
            return m6239x();
        }

        @Nullable
        public final /* synthetic */ RichDocumentTextAnnotationModel in_() {
            return m6238w();
        }

        @Nullable
        public final /* synthetic */ RichDocumentLocationAnnotationModel m6251l() {
            return m6240y();
        }

        @Nullable
        public final /* synthetic */ FBPhoto m6252m() {
            return m6233A();
        }

        @Nullable
        public final /* synthetic */ FBPhoto mo340n() {
            return m6241z();
        }

        @Nullable
        public final /* synthetic */ RichDocumentTextAnnotationModel m6255p() {
            return m6234B();
        }

        @Nullable
        public final /* synthetic */ RichDocumentTextAnnotationModel m6256q() {
            return m6235C();
        }

        public RichDocumentSlideModel() {
            super(19);
        }

        @Nullable
        private GraphQLObjectType m6236u() {
            if (this.b != null && this.f6148d == null) {
                this.f6148d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6148d;
        }

        @Nullable
        public final GraphQLAudioAnnotationPlayMode m6245b() {
            this.f6149e = (GraphQLAudioAnnotationPlayMode) super.b(this.f6149e, 1, GraphQLAudioAnnotationPlayMode.class, GraphQLAudioAnnotationPlayMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6149e;
        }

        @Nullable
        private RichDocumentTextAnnotationModel m6237v() {
            this.f6150f = (RichDocumentTextAnnotationModel) super.a(this.f6150f, 2, RichDocumentTextAnnotationModel.class);
            return this.f6150f;
        }

        @Nullable
        public final String m6247d() {
            this.f6151g = super.a(this.f6151g, 3);
            return this.f6151g;
        }

        @Nullable
        private RichDocumentTextAnnotationModel m6238w() {
            this.f6152h = (RichDocumentTextAnnotationModel) super.a(this.f6152h, 4, RichDocumentTextAnnotationModel.class);
            return this.f6152h;
        }

        @Nullable
        public final GraphQLDocumentElementType m6248g() {
            this.f6153i = (GraphQLDocumentElementType) super.b(this.f6153i, 5, GraphQLDocumentElementType.class, GraphQLDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6153i;
        }

        @Nullable
        private FBVideoModel m6239x() {
            this.f6154j = (FBVideoModel) super.a(this.f6154j, 6, FBVideoModel.class);
            return this.f6154j;
        }

        @Nullable
        public final GraphQLFeedback im_() {
            this.f6155k = (GraphQLFeedback) super.a(this.f6155k, 7, GraphQLFeedback.class);
            return this.f6155k;
        }

        @Nullable
        public final GraphQLDocumentFeedbackOptions m6249j() {
            this.f6156l = (GraphQLDocumentFeedbackOptions) super.b(this.f6156l, 8, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6156l;
        }

        @Nullable
        public final String m6250k() {
            this.f6157m = super.a(this.f6157m, 9);
            return this.f6157m;
        }

        @Nullable
        private RichDocumentLocationAnnotationModel m6240y() {
            this.f6158n = (RichDocumentLocationAnnotationModel) super.a(this.f6158n, 10, RichDocumentLocationAnnotationModel.class);
            return this.f6158n;
        }

        @Nullable
        private FBPhotoModel m6241z() {
            this.f6159o = (FBPhotoModel) super.a(this.f6159o, 11, FBPhotoModel.class);
            return this.f6159o;
        }

        @Nullable
        private FBPhotoModel m6233A() {
            this.f6160p = (FBPhotoModel) super.a(this.f6160p, 12, FBPhotoModel.class);
            return this.f6160p;
        }

        @Nullable
        public final GraphQLDocumentMediaPresentationStyle m6254o() {
            this.f6161q = (GraphQLDocumentMediaPresentationStyle) super.b(this.f6161q, 13, GraphQLDocumentMediaPresentationStyle.class, GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6161q;
        }

        @Nullable
        private RichDocumentTextAnnotationModel m6234B() {
            this.f6162r = (RichDocumentTextAnnotationModel) super.a(this.f6162r, 14, RichDocumentTextAnnotationModel.class);
            return this.f6162r;
        }

        @Nullable
        private RichDocumentTextAnnotationModel m6235C() {
            this.f6163s = (RichDocumentTextAnnotationModel) super.a(this.f6163s, 15, RichDocumentTextAnnotationModel.class);
            return this.f6163s;
        }

        @Nullable
        public final GraphQLDocumentVideoAutoplayStyle m6257r() {
            this.f6164t = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f6164t, 16, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6164t;
        }

        @Nullable
        public final GraphQLDocumentVideoControlStyle m6258s() {
            this.f6165u = (GraphQLDocumentVideoControlStyle) super.b(this.f6165u, 17, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6165u;
        }

        @Nullable
        public final GraphQLDocumentVideoLoopingStyle m6259t() {
            this.f6166v = (GraphQLDocumentVideoLoopingStyle) super.b(this.f6166v, 18, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6166v;
        }

        @Nullable
        public final String m6244a() {
            return m6250k();
        }

        public final int jK_() {
            return 473184577;
        }

        public final GraphQLVisitableModel m6243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            RichDocumentTextAnnotationModel richDocumentTextAnnotationModel;
            FBPhotoModel fBPhotoModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6237v() != null) {
                richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6237v());
                if (m6237v() != richDocumentTextAnnotationModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6150f = richDocumentTextAnnotationModel;
                }
            }
            if (m6238w() != null) {
                richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6238w());
                if (m6238w() != richDocumentTextAnnotationModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6152h = richDocumentTextAnnotationModel;
                }
            }
            if (m6239x() != null) {
                FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m6239x());
                if (m6239x() != fBVideoModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6154j = fBVideoModel;
                }
            }
            if (im_() != null) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(im_());
                if (im_() != graphQLFeedback) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6155k = graphQLFeedback;
                }
            }
            if (m6240y() != null) {
                RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel = (RichDocumentLocationAnnotationModel) graphQLModelMutatingVisitor.b(m6240y());
                if (m6240y() != richDocumentLocationAnnotationModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6158n = richDocumentLocationAnnotationModel;
                }
            }
            if (m6241z() != null) {
                fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m6241z());
                if (m6241z() != fBPhotoModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6159o = fBPhotoModel;
                }
            }
            if (m6233A() != null) {
                fBPhotoModel = (FBPhotoModel) graphQLModelMutatingVisitor.b(m6233A());
                if (m6233A() != fBPhotoModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6160p = fBPhotoModel;
                }
            }
            if (m6234B() != null) {
                richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6234B());
                if (m6234B() != richDocumentTextAnnotationModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6162r = richDocumentTextAnnotationModel;
                }
            }
            if (m6235C() != null) {
                richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) graphQLModelMutatingVisitor.b(m6235C());
                if (m6235C() != richDocumentTextAnnotationModel) {
                    graphQLVisitableModel = (RichDocumentSlideModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6163s = richDocumentTextAnnotationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6242a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6236u());
            int a2 = flatBufferBuilder.a(m6245b());
            int a3 = ModelHelper.a(flatBufferBuilder, m6237v());
            int b = flatBufferBuilder.b(m6247d());
            int a4 = ModelHelper.a(flatBufferBuilder, m6238w());
            int a5 = flatBufferBuilder.a(m6248g());
            int a6 = ModelHelper.a(flatBufferBuilder, m6239x());
            int a7 = ModelHelper.a(flatBufferBuilder, im_());
            int a8 = flatBufferBuilder.a(m6249j());
            int b2 = flatBufferBuilder.b(m6250k());
            int a9 = ModelHelper.a(flatBufferBuilder, m6240y());
            int a10 = ModelHelper.a(flatBufferBuilder, m6241z());
            int a11 = ModelHelper.a(flatBufferBuilder, m6233A());
            int a12 = flatBufferBuilder.a(m6254o());
            int a13 = ModelHelper.a(flatBufferBuilder, m6234B());
            int a14 = ModelHelper.a(flatBufferBuilder, m6235C());
            int a15 = flatBufferBuilder.a(m6257r());
            int a16 = flatBufferBuilder.a(m6258s());
            int a17 = flatBufferBuilder.a(m6259t());
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.b(10, a9);
            flatBufferBuilder.b(11, a10);
            flatBufferBuilder.b(12, a11);
            flatBufferBuilder.b(13, a12);
            flatBufferBuilder.b(14, a13);
            flatBufferBuilder.b(15, a14);
            flatBufferBuilder.b(16, a15);
            flatBufferBuilder.b(17, a16);
            flatBufferBuilder.b(18, a17);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1623274283)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentSlideshowModel extends BaseModel implements GraphQLVisitableModel, RichDocumentSlideshow {
        @Nullable
        private GraphQLDocumentMediaPresentationStyle f6168d;
        @Nullable
        private SlideEdgesModel f6169e;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentSlideshowModel.class, new Deserializer());
            }

            public Object m6260a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentSlideshowParser.m6581a(jsonParser);
                Object richDocumentSlideshowModel = new RichDocumentSlideshowModel();
                ((BaseModel) richDocumentSlideshowModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentSlideshowModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentSlideshowModel).a();
                }
                return richDocumentSlideshowModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentSlideshowModel> {
            public final void m6261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentSlideshowModel richDocumentSlideshowModel = (RichDocumentSlideshowModel) obj;
                if (richDocumentSlideshowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentSlideshowModel.m6269a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentSlideshowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentSlideshowModel.w_();
                int u_ = richDocumentSlideshowModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("presentation_state");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("slideEdges");
                    SlideEdgesParser.m6580a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentSlideshowModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -27233711)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: photo_picker_camera_cancelled */
        public final class SlideEdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RichDocumentSlideModel> f6167d;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SlideEdgesModel.class, new Deserializer());
                }

                public Object m6262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SlideEdgesParser.m6579a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object slideEdgesModel = new SlideEdgesModel();
                    ((BaseModel) slideEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (slideEdgesModel instanceof Postprocessable) {
                        return ((Postprocessable) slideEdgesModel).a();
                    }
                    return slideEdgesModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<SlideEdgesModel> {
                public final void m6263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SlideEdgesModel slideEdgesModel = (SlideEdgesModel) obj;
                    if (slideEdgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(slideEdgesModel.m6264a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        slideEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SlideEdgesParser.m6580a(slideEdgesModel.w_(), slideEdgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SlideEdgesModel.class, new Serializer());
                }
            }

            public SlideEdgesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<RichDocumentSlideModel> m6266a() {
                this.f6167d = super.a(this.f6167d, 0, RichDocumentSlideModel.class);
                return (ImmutableList) this.f6167d;
            }

            public final int jK_() {
                return 442067033;
            }

            public final GraphQLVisitableModel m6265a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6266a() != null) {
                    Builder a = ModelHelper.a(m6266a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SlideEdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6167d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6264a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6266a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RichDocumentSlideshowModel() {
            super(2);
        }

        @Nullable
        private GraphQLDocumentMediaPresentationStyle m6267a() {
            this.f6168d = (GraphQLDocumentMediaPresentationStyle) super.b(this.f6168d, 0, GraphQLDocumentMediaPresentationStyle.class, GraphQLDocumentMediaPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6168d;
        }

        @Nullable
        private SlideEdgesModel m6268j() {
            this.f6169e = (SlideEdgesModel) super.a(this.f6169e, 1, SlideEdgesModel.class);
            return this.f6169e;
        }

        public final int jK_() {
            return 1114739273;
        }

        public final GraphQLVisitableModel m6270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6268j() != null) {
                SlideEdgesModel slideEdgesModel = (SlideEdgesModel) graphQLModelMutatingVisitor.b(m6268j());
                if (m6268j() != slideEdgesModel) {
                    graphQLVisitableModel = (RichDocumentSlideshowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6169e = slideEdgesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6269a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m6267a());
            int a2 = ModelHelper.a(flatBufferBuilder, m6268j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1610952982)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentStyleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RichDocumentElementStyleModel f6194A;
        @Nullable
        private RichDocumentElementStyleModel f6195B;
        @Nullable
        private RichDocumentElementStyleModel f6196C;
        @Nullable
        private RichDocumentElementStyleModel f6197D;
        @Nullable
        private String f6198d;
        @Nullable
        private RichDocumentElementStyleModel f6199e;
        @Nullable
        private RichDocumentBylineModel f6200f;
        @Nullable
        private RichDocumentElementStyleModel f6201g;
        @Nullable
        private RichDocumentElementStyleModel f6202h;
        @Nullable
        private RichDocumentElementStyleModel f6203i;
        @Nullable
        private RichDocumentElementStyleModel f6204j;
        @Nullable
        private RichDocumentElementStyleModel f6205k;
        @Nullable
        private RichDocumentElementStyleModel f6206l;
        @Nullable
        private RichDocumentElementStyleModel f6207m;
        @Nullable
        private RichDocumentElementStyleModel f6208n;
        @Nullable
        private RichDocumentElementStyleModel f6209o;
        @Nullable
        private RichDocumentElementStyleModel f6210p;
        @Nullable
        private List<RichDocumentFontResourceModel> f6211q;
        @Nullable
        private RichDocumentElementStyleModel f6212r;
        @Nullable
        private FallbackArticleStyleModel f6213s;
        @Nullable
        private RichDocumentElementStyleModel f6214t;
        @Nullable
        private RichDocumentElementStyleModel f6215u;
        private boolean f6216v;
        @Nullable
        private RichDocumentElementStyleModel f6217w;
        @Nullable
        private RichDocumentLinkStyleModel f6218x;
        @Nullable
        private RichDocumentLogoModel f6219y;
        @Nullable
        private RichDocumentElementStyleModel f6220z;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentStyleModel.class, new Deserializer());
            }

            public Object m6271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentStyleParser.m6584a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentStyleModel = new RichDocumentStyleModel();
                ((BaseModel) richDocumentStyleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentStyleModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentStyleModel).a();
                }
                return richDocumentStyleModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1033468668)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class FallbackArticleStyleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RichDocumentElementStyleModel f6170A;
            @Nullable
            private RichDocumentElementStyleModel f6171d;
            @Nullable
            private RichDocumentBylineModel f6172e;
            @Nullable
            private RichDocumentElementStyleModel f6173f;
            @Nullable
            private RichDocumentElementStyleModel f6174g;
            @Nullable
            private RichDocumentElementStyleModel f6175h;
            @Nullable
            private RichDocumentElementStyleModel f6176i;
            @Nullable
            private RichDocumentElementStyleModel f6177j;
            @Nullable
            private RichDocumentElementStyleModel f6178k;
            @Nullable
            private RichDocumentElementStyleModel f6179l;
            @Nullable
            private RichDocumentElementStyleModel f6180m;
            @Nullable
            private RichDocumentElementStyleModel f6181n;
            @Nullable
            private RichDocumentElementStyleModel f6182o;
            @Nullable
            private List<RichDocumentFontResourceModel> f6183p;
            @Nullable
            private RichDocumentElementStyleModel f6184q;
            @Nullable
            private RichDocumentElementStyleModel f6185r;
            @Nullable
            private RichDocumentElementStyleModel f6186s;
            @Nullable
            private RichDocumentElementStyleModel f6187t;
            @Nullable
            private RichDocumentLinkStyleModel f6188u;
            @Nullable
            private RichDocumentLogoModel f6189v;
            @Nullable
            private RichDocumentElementStyleModel f6190w;
            @Nullable
            private RichDocumentElementStyleModel f6191x;
            @Nullable
            private RichDocumentElementStyleModel f6192y;
            @Nullable
            private RichDocumentElementStyleModel f6193z;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FallbackArticleStyleModel.class, new Deserializer());
                }

                public Object m6272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FallbackArticleStyleParser.m6582a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fallbackArticleStyleModel = new FallbackArticleStyleModel();
                    ((BaseModel) fallbackArticleStyleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fallbackArticleStyleModel instanceof Postprocessable) {
                        return ((Postprocessable) fallbackArticleStyleModel).a();
                    }
                    return fallbackArticleStyleModel;
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<FallbackArticleStyleModel> {
                public final void m6273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FallbackArticleStyleModel fallbackArticleStyleModel = (FallbackArticleStyleModel) obj;
                    if (fallbackArticleStyleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fallbackArticleStyleModel.m6298a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fallbackArticleStyleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FallbackArticleStyleParser.m6583a(fallbackArticleStyleModel.w_(), fallbackArticleStyleModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FallbackArticleStyleModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6300a() {
                return m6294w();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6301b() {
                return m6296y();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6302c() {
                return m6297z();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6303d() {
                return m6274A();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6304g() {
                return m6276C();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel ir_() {
                return m6278E();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel is_() {
                return m6277D();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel it_() {
                return m6275B();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6305j() {
                return m6279F();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6306k() {
                return m6280G();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6307l() {
                return m6281H();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6308m() {
                return m6283J();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6309n() {
                return m6284K();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6310o() {
                return m6285L();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6311p() {
                return m6286M();
            }

            @Nullable
            public final /* synthetic */ RichDocumentLinkStyleModel m6312q() {
                return m6287N();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6313r() {
                return m6289P();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6314s() {
                return m6290Q();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6315t() {
                return m6291R();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6316u() {
                return m6292S();
            }

            @Nullable
            public final /* synthetic */ RichDocumentElementStyleModel m6317v() {
                return m6293T();
            }

            public FallbackArticleStyleModel() {
                super(24);
            }

            @Nullable
            private RichDocumentElementStyleModel m6294w() {
                this.f6171d = (RichDocumentElementStyleModel) super.a(this.f6171d, 0, RichDocumentElementStyleModel.class);
                return this.f6171d;
            }

            @Nullable
            private RichDocumentBylineModel m6295x() {
                this.f6172e = (RichDocumentBylineModel) super.a(this.f6172e, 1, RichDocumentBylineModel.class);
                return this.f6172e;
            }

            @Nullable
            private RichDocumentElementStyleModel m6296y() {
                this.f6173f = (RichDocumentElementStyleModel) super.a(this.f6173f, 2, RichDocumentElementStyleModel.class);
                return this.f6173f;
            }

            @Nullable
            private RichDocumentElementStyleModel m6297z() {
                this.f6174g = (RichDocumentElementStyleModel) super.a(this.f6174g, 3, RichDocumentElementStyleModel.class);
                return this.f6174g;
            }

            @Nullable
            private RichDocumentElementStyleModel m6274A() {
                this.f6175h = (RichDocumentElementStyleModel) super.a(this.f6175h, 4, RichDocumentElementStyleModel.class);
                return this.f6175h;
            }

            @Nullable
            private RichDocumentElementStyleModel m6275B() {
                this.f6176i = (RichDocumentElementStyleModel) super.a(this.f6176i, 5, RichDocumentElementStyleModel.class);
                return this.f6176i;
            }

            @Nullable
            private RichDocumentElementStyleModel m6276C() {
                this.f6177j = (RichDocumentElementStyleModel) super.a(this.f6177j, 6, RichDocumentElementStyleModel.class);
                return this.f6177j;
            }

            @Nullable
            private RichDocumentElementStyleModel m6277D() {
                this.f6178k = (RichDocumentElementStyleModel) super.a(this.f6178k, 7, RichDocumentElementStyleModel.class);
                return this.f6178k;
            }

            @Nullable
            private RichDocumentElementStyleModel m6278E() {
                this.f6179l = (RichDocumentElementStyleModel) super.a(this.f6179l, 8, RichDocumentElementStyleModel.class);
                return this.f6179l;
            }

            @Nullable
            private RichDocumentElementStyleModel m6279F() {
                this.f6180m = (RichDocumentElementStyleModel) super.a(this.f6180m, 9, RichDocumentElementStyleModel.class);
                return this.f6180m;
            }

            @Nullable
            private RichDocumentElementStyleModel m6280G() {
                this.f6181n = (RichDocumentElementStyleModel) super.a(this.f6181n, 10, RichDocumentElementStyleModel.class);
                return this.f6181n;
            }

            @Nullable
            private RichDocumentElementStyleModel m6281H() {
                this.f6182o = (RichDocumentElementStyleModel) super.a(this.f6182o, 11, RichDocumentElementStyleModel.class);
                return this.f6182o;
            }

            @Nonnull
            private ImmutableList<RichDocumentFontResourceModel> m6282I() {
                this.f6183p = super.a(this.f6183p, 12, RichDocumentFontResourceModel.class);
                return (ImmutableList) this.f6183p;
            }

            @Nullable
            private RichDocumentElementStyleModel m6283J() {
                this.f6184q = (RichDocumentElementStyleModel) super.a(this.f6184q, 13, RichDocumentElementStyleModel.class);
                return this.f6184q;
            }

            @Nullable
            private RichDocumentElementStyleModel m6284K() {
                this.f6185r = (RichDocumentElementStyleModel) super.a(this.f6185r, 14, RichDocumentElementStyleModel.class);
                return this.f6185r;
            }

            @Nullable
            private RichDocumentElementStyleModel m6285L() {
                this.f6186s = (RichDocumentElementStyleModel) super.a(this.f6186s, 15, RichDocumentElementStyleModel.class);
                return this.f6186s;
            }

            @Nullable
            private RichDocumentElementStyleModel m6286M() {
                this.f6187t = (RichDocumentElementStyleModel) super.a(this.f6187t, 16, RichDocumentElementStyleModel.class);
                return this.f6187t;
            }

            @Nullable
            private RichDocumentLinkStyleModel m6287N() {
                this.f6188u = (RichDocumentLinkStyleModel) super.a(this.f6188u, 17, RichDocumentLinkStyleModel.class);
                return this.f6188u;
            }

            @Nullable
            private RichDocumentLogoModel m6288O() {
                this.f6189v = (RichDocumentLogoModel) super.a(this.f6189v, 18, RichDocumentLogoModel.class);
                return this.f6189v;
            }

            @Nullable
            private RichDocumentElementStyleModel m6289P() {
                this.f6190w = (RichDocumentElementStyleModel) super.a(this.f6190w, 19, RichDocumentElementStyleModel.class);
                return this.f6190w;
            }

            @Nullable
            private RichDocumentElementStyleModel m6290Q() {
                this.f6191x = (RichDocumentElementStyleModel) super.a(this.f6191x, 20, RichDocumentElementStyleModel.class);
                return this.f6191x;
            }

            @Nullable
            private RichDocumentElementStyleModel m6291R() {
                this.f6192y = (RichDocumentElementStyleModel) super.a(this.f6192y, 21, RichDocumentElementStyleModel.class);
                return this.f6192y;
            }

            @Nullable
            private RichDocumentElementStyleModel m6292S() {
                this.f6193z = (RichDocumentElementStyleModel) super.a(this.f6193z, 22, RichDocumentElementStyleModel.class);
                return this.f6193z;
            }

            @Nullable
            private RichDocumentElementStyleModel m6293T() {
                this.f6170A = (RichDocumentElementStyleModel) super.a(this.f6170A, 23, RichDocumentElementStyleModel.class);
                return this.f6170A;
            }

            public final int jK_() {
                return -1921514186;
            }

            public final GraphQLVisitableModel m6299a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                RichDocumentElementStyleModel richDocumentElementStyleModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6294w() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6294w());
                    if (m6294w() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6171d = richDocumentElementStyleModel;
                    }
                }
                if (m6295x() != null) {
                    RichDocumentBylineModel richDocumentBylineModel = (RichDocumentBylineModel) graphQLModelMutatingVisitor.b(m6295x());
                    if (m6295x() != richDocumentBylineModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6172e = richDocumentBylineModel;
                    }
                }
                if (m6296y() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6296y());
                    if (m6296y() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6173f = richDocumentElementStyleModel;
                    }
                }
                if (m6297z() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6297z());
                    if (m6297z() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6174g = richDocumentElementStyleModel;
                    }
                }
                if (m6274A() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6274A());
                    if (m6274A() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6175h = richDocumentElementStyleModel;
                    }
                }
                if (m6275B() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6275B());
                    if (m6275B() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6176i = richDocumentElementStyleModel;
                    }
                }
                if (m6276C() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6276C());
                    if (m6276C() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6177j = richDocumentElementStyleModel;
                    }
                }
                if (m6277D() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6277D());
                    if (m6277D() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6178k = richDocumentElementStyleModel;
                    }
                }
                if (m6278E() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6278E());
                    if (m6278E() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6179l = richDocumentElementStyleModel;
                    }
                }
                if (m6279F() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6279F());
                    if (m6279F() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6180m = richDocumentElementStyleModel;
                    }
                }
                if (m6280G() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6280G());
                    if (m6280G() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6181n = richDocumentElementStyleModel;
                    }
                }
                if (m6281H() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6281H());
                    if (m6281H() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6182o = richDocumentElementStyleModel;
                    }
                }
                if (m6282I() != null) {
                    Builder a = ModelHelper.a(m6282I(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FallbackArticleStyleModel fallbackArticleStyleModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        fallbackArticleStyleModel.f6183p = a.b();
                        graphQLVisitableModel = fallbackArticleStyleModel;
                    }
                }
                if (m6283J() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6283J());
                    if (m6283J() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6184q = richDocumentElementStyleModel;
                    }
                }
                if (m6284K() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6284K());
                    if (m6284K() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6185r = richDocumentElementStyleModel;
                    }
                }
                if (m6285L() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6285L());
                    if (m6285L() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6186s = richDocumentElementStyleModel;
                    }
                }
                if (m6286M() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6286M());
                    if (m6286M() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6187t = richDocumentElementStyleModel;
                    }
                }
                if (m6287N() != null) {
                    RichDocumentLinkStyleModel richDocumentLinkStyleModel = (RichDocumentLinkStyleModel) graphQLModelMutatingVisitor.b(m6287N());
                    if (m6287N() != richDocumentLinkStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6188u = richDocumentLinkStyleModel;
                    }
                }
                if (m6288O() != null) {
                    RichDocumentLogoModel richDocumentLogoModel = (RichDocumentLogoModel) graphQLModelMutatingVisitor.b(m6288O());
                    if (m6288O() != richDocumentLogoModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6189v = richDocumentLogoModel;
                    }
                }
                if (m6289P() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6289P());
                    if (m6289P() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6190w = richDocumentElementStyleModel;
                    }
                }
                if (m6290Q() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6290Q());
                    if (m6290Q() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6191x = richDocumentElementStyleModel;
                    }
                }
                if (m6291R() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6291R());
                    if (m6291R() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6192y = richDocumentElementStyleModel;
                    }
                }
                if (m6292S() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6292S());
                    if (m6292S() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6193z = richDocumentElementStyleModel;
                    }
                }
                if (m6293T() != null) {
                    richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6293T());
                    if (m6293T() != richDocumentElementStyleModel) {
                        graphQLVisitableModel = (FallbackArticleStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6170A = richDocumentElementStyleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6298a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6294w());
                int a2 = ModelHelper.a(flatBufferBuilder, m6295x());
                int a3 = ModelHelper.a(flatBufferBuilder, m6296y());
                int a4 = ModelHelper.a(flatBufferBuilder, m6297z());
                int a5 = ModelHelper.a(flatBufferBuilder, m6274A());
                int a6 = ModelHelper.a(flatBufferBuilder, m6275B());
                int a7 = ModelHelper.a(flatBufferBuilder, m6276C());
                int a8 = ModelHelper.a(flatBufferBuilder, m6277D());
                int a9 = ModelHelper.a(flatBufferBuilder, m6278E());
                int a10 = ModelHelper.a(flatBufferBuilder, m6279F());
                int a11 = ModelHelper.a(flatBufferBuilder, m6280G());
                int a12 = ModelHelper.a(flatBufferBuilder, m6281H());
                int a13 = ModelHelper.a(flatBufferBuilder, m6282I());
                int a14 = ModelHelper.a(flatBufferBuilder, m6283J());
                int a15 = ModelHelper.a(flatBufferBuilder, m6284K());
                int a16 = ModelHelper.a(flatBufferBuilder, m6285L());
                int a17 = ModelHelper.a(flatBufferBuilder, m6286M());
                int a18 = ModelHelper.a(flatBufferBuilder, m6287N());
                int a19 = ModelHelper.a(flatBufferBuilder, m6288O());
                int a20 = ModelHelper.a(flatBufferBuilder, m6289P());
                int a21 = ModelHelper.a(flatBufferBuilder, m6290Q());
                int a22 = ModelHelper.a(flatBufferBuilder, m6291R());
                int a23 = ModelHelper.a(flatBufferBuilder, m6292S());
                int a24 = ModelHelper.a(flatBufferBuilder, m6293T());
                flatBufferBuilder.c(24);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.b(6, a7);
                flatBufferBuilder.b(7, a8);
                flatBufferBuilder.b(8, a9);
                flatBufferBuilder.b(9, a10);
                flatBufferBuilder.b(10, a11);
                flatBufferBuilder.b(11, a12);
                flatBufferBuilder.b(12, a13);
                flatBufferBuilder.b(13, a14);
                flatBufferBuilder.b(14, a15);
                flatBufferBuilder.b(15, a16);
                flatBufferBuilder.b(16, a17);
                flatBufferBuilder.b(17, a18);
                flatBufferBuilder.b(18, a19);
                flatBufferBuilder.b(19, a20);
                flatBufferBuilder.b(20, a21);
                flatBufferBuilder.b(21, a22);
                flatBufferBuilder.b(22, a23);
                flatBufferBuilder.b(23, a24);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentStyleModel> {
            public final void m6318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentStyleModel richDocumentStyleModel = (RichDocumentStyleModel) obj;
                if (richDocumentStyleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentStyleModel.m6345a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentStyleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentStyleParser.m6585a(richDocumentStyleModel.w_(), richDocumentStyleModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentStyleModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6343A() {
            return m6341Y();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6344B() {
            return m6342Z();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6349b() {
            return m6319C();
        }

        @Nullable
        public final /* synthetic */ RichDocumentBylineModel m6350c() {
            return m6320D();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6351d() {
            return m6321E();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6352g() {
            return m6323G();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel io_() {
            return m6325I();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel ip_() {
            return m6324H();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel iq_() {
            return m6322F();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6353j() {
            return m6326J();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6354k() {
            return m6327K();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6355l() {
            return m6328L();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6356m() {
            return m6329M();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6357n() {
            return m6330N();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6359p() {
            return m6331O();
        }

        @Nullable
        public final /* synthetic */ FallbackArticleStyleModel m6360q() {
            return m6332P();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6361r() {
            return m6333Q();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6362s() {
            return m6334R();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6364u() {
            return m6335S();
        }

        @Nullable
        public final /* synthetic */ RichDocumentLinkStyleModel m6365v() {
            return m6336T();
        }

        @Nullable
        public final /* synthetic */ RichDocumentLogoModel m6366w() {
            return m6337U();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6367x() {
            return m6338V();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6368y() {
            return m6339W();
        }

        @Nullable
        public final /* synthetic */ RichDocumentElementStyleModel m6369z() {
            return m6340X();
        }

        public RichDocumentStyleModel() {
            super(27);
        }

        @Nullable
        public final String m6347a() {
            this.f6198d = super.a(this.f6198d, 0);
            return this.f6198d;
        }

        @Nullable
        private RichDocumentElementStyleModel m6319C() {
            this.f6199e = (RichDocumentElementStyleModel) super.a(this.f6199e, 1, RichDocumentElementStyleModel.class);
            return this.f6199e;
        }

        @Nullable
        private RichDocumentBylineModel m6320D() {
            this.f6200f = (RichDocumentBylineModel) super.a(this.f6200f, 2, RichDocumentBylineModel.class);
            return this.f6200f;
        }

        @Nullable
        private RichDocumentElementStyleModel m6321E() {
            this.f6201g = (RichDocumentElementStyleModel) super.a(this.f6201g, 3, RichDocumentElementStyleModel.class);
            return this.f6201g;
        }

        @Nullable
        private RichDocumentElementStyleModel m6322F() {
            this.f6202h = (RichDocumentElementStyleModel) super.a(this.f6202h, 4, RichDocumentElementStyleModel.class);
            return this.f6202h;
        }

        @Nullable
        private RichDocumentElementStyleModel m6323G() {
            this.f6203i = (RichDocumentElementStyleModel) super.a(this.f6203i, 5, RichDocumentElementStyleModel.class);
            return this.f6203i;
        }

        @Nullable
        private RichDocumentElementStyleModel m6324H() {
            this.f6204j = (RichDocumentElementStyleModel) super.a(this.f6204j, 6, RichDocumentElementStyleModel.class);
            return this.f6204j;
        }

        @Nullable
        private RichDocumentElementStyleModel m6325I() {
            this.f6205k = (RichDocumentElementStyleModel) super.a(this.f6205k, 7, RichDocumentElementStyleModel.class);
            return this.f6205k;
        }

        @Nullable
        private RichDocumentElementStyleModel m6326J() {
            this.f6206l = (RichDocumentElementStyleModel) super.a(this.f6206l, 8, RichDocumentElementStyleModel.class);
            return this.f6206l;
        }

        @Nullable
        private RichDocumentElementStyleModel m6327K() {
            this.f6207m = (RichDocumentElementStyleModel) super.a(this.f6207m, 9, RichDocumentElementStyleModel.class);
            return this.f6207m;
        }

        @Nullable
        private RichDocumentElementStyleModel m6328L() {
            this.f6208n = (RichDocumentElementStyleModel) super.a(this.f6208n, 10, RichDocumentElementStyleModel.class);
            return this.f6208n;
        }

        @Nullable
        private RichDocumentElementStyleModel m6329M() {
            this.f6209o = (RichDocumentElementStyleModel) super.a(this.f6209o, 11, RichDocumentElementStyleModel.class);
            return this.f6209o;
        }

        @Nullable
        private RichDocumentElementStyleModel m6330N() {
            this.f6210p = (RichDocumentElementStyleModel) super.a(this.f6210p, 12, RichDocumentElementStyleModel.class);
            return this.f6210p;
        }

        @Nonnull
        public final ImmutableList<RichDocumentFontResourceModel> m6358o() {
            this.f6211q = super.a(this.f6211q, 13, RichDocumentFontResourceModel.class);
            return (ImmutableList) this.f6211q;
        }

        @Nullable
        private RichDocumentElementStyleModel m6331O() {
            this.f6212r = (RichDocumentElementStyleModel) super.a(this.f6212r, 14, RichDocumentElementStyleModel.class);
            return this.f6212r;
        }

        @Nullable
        private FallbackArticleStyleModel m6332P() {
            this.f6213s = (FallbackArticleStyleModel) super.a(this.f6213s, 15, FallbackArticleStyleModel.class);
            return this.f6213s;
        }

        @Nullable
        private RichDocumentElementStyleModel m6333Q() {
            this.f6214t = (RichDocumentElementStyleModel) super.a(this.f6214t, 16, RichDocumentElementStyleModel.class);
            return this.f6214t;
        }

        @Nullable
        private RichDocumentElementStyleModel m6334R() {
            this.f6215u = (RichDocumentElementStyleModel) super.a(this.f6215u, 17, RichDocumentElementStyleModel.class);
            return this.f6215u;
        }

        public final boolean m6363t() {
            a(2, 2);
            return this.f6216v;
        }

        @Nullable
        private RichDocumentElementStyleModel m6335S() {
            this.f6217w = (RichDocumentElementStyleModel) super.a(this.f6217w, 19, RichDocumentElementStyleModel.class);
            return this.f6217w;
        }

        @Nullable
        private RichDocumentLinkStyleModel m6336T() {
            this.f6218x = (RichDocumentLinkStyleModel) super.a(this.f6218x, 20, RichDocumentLinkStyleModel.class);
            return this.f6218x;
        }

        @Nullable
        private RichDocumentLogoModel m6337U() {
            this.f6219y = (RichDocumentLogoModel) super.a(this.f6219y, 21, RichDocumentLogoModel.class);
            return this.f6219y;
        }

        @Nullable
        private RichDocumentElementStyleModel m6338V() {
            this.f6220z = (RichDocumentElementStyleModel) super.a(this.f6220z, 22, RichDocumentElementStyleModel.class);
            return this.f6220z;
        }

        @Nullable
        private RichDocumentElementStyleModel m6339W() {
            this.f6194A = (RichDocumentElementStyleModel) super.a(this.f6194A, 23, RichDocumentElementStyleModel.class);
            return this.f6194A;
        }

        @Nullable
        private RichDocumentElementStyleModel m6340X() {
            this.f6195B = (RichDocumentElementStyleModel) super.a(this.f6195B, 24, RichDocumentElementStyleModel.class);
            return this.f6195B;
        }

        @Nullable
        private RichDocumentElementStyleModel m6341Y() {
            this.f6196C = (RichDocumentElementStyleModel) super.a(this.f6196C, 25, RichDocumentElementStyleModel.class);
            return this.f6196C;
        }

        @Nullable
        private RichDocumentElementStyleModel m6342Z() {
            this.f6197D = (RichDocumentElementStyleModel) super.a(this.f6197D, 26, RichDocumentElementStyleModel.class);
            return this.f6197D;
        }

        public final int jK_() {
            return -1921514186;
        }

        public final GraphQLVisitableModel m6346a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            RichDocumentElementStyleModel richDocumentElementStyleModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6319C() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6319C());
                if (m6319C() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6199e = richDocumentElementStyleModel;
                }
            }
            if (m6320D() != null) {
                RichDocumentBylineModel richDocumentBylineModel = (RichDocumentBylineModel) graphQLModelMutatingVisitor.b(m6320D());
                if (m6320D() != richDocumentBylineModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6200f = richDocumentBylineModel;
                }
            }
            if (m6321E() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6321E());
                if (m6321E() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6201g = richDocumentElementStyleModel;
                }
            }
            if (m6322F() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6322F());
                if (m6322F() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6202h = richDocumentElementStyleModel;
                }
            }
            if (m6323G() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6323G());
                if (m6323G() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6203i = richDocumentElementStyleModel;
                }
            }
            if (m6324H() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6324H());
                if (m6324H() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6204j = richDocumentElementStyleModel;
                }
            }
            if (m6325I() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6325I());
                if (m6325I() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6205k = richDocumentElementStyleModel;
                }
            }
            if (m6326J() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6326J());
                if (m6326J() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6206l = richDocumentElementStyleModel;
                }
            }
            if (m6327K() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6327K());
                if (m6327K() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6207m = richDocumentElementStyleModel;
                }
            }
            if (m6328L() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6328L());
                if (m6328L() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6208n = richDocumentElementStyleModel;
                }
            }
            if (m6329M() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6329M());
                if (m6329M() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6209o = richDocumentElementStyleModel;
                }
            }
            if (m6330N() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6330N());
                if (m6330N() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6210p = richDocumentElementStyleModel;
                }
            }
            if (m6358o() != null) {
                Builder a = ModelHelper.a(m6358o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    RichDocumentStyleModel richDocumentStyleModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    richDocumentStyleModel.f6211q = a.b();
                    graphQLVisitableModel = richDocumentStyleModel;
                }
            }
            if (m6331O() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6331O());
                if (m6331O() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6212r = richDocumentElementStyleModel;
                }
            }
            if (m6332P() != null) {
                FallbackArticleStyleModel fallbackArticleStyleModel = (FallbackArticleStyleModel) graphQLModelMutatingVisitor.b(m6332P());
                if (m6332P() != fallbackArticleStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6213s = fallbackArticleStyleModel;
                }
            }
            if (m6333Q() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6333Q());
                if (m6333Q() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6214t = richDocumentElementStyleModel;
                }
            }
            if (m6334R() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6334R());
                if (m6334R() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6215u = richDocumentElementStyleModel;
                }
            }
            if (m6335S() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6335S());
                if (m6335S() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6217w = richDocumentElementStyleModel;
                }
            }
            if (m6336T() != null) {
                RichDocumentLinkStyleModel richDocumentLinkStyleModel = (RichDocumentLinkStyleModel) graphQLModelMutatingVisitor.b(m6336T());
                if (m6336T() != richDocumentLinkStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6218x = richDocumentLinkStyleModel;
                }
            }
            if (m6337U() != null) {
                RichDocumentLogoModel richDocumentLogoModel = (RichDocumentLogoModel) graphQLModelMutatingVisitor.b(m6337U());
                if (m6337U() != richDocumentLogoModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6219y = richDocumentLogoModel;
                }
            }
            if (m6338V() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6338V());
                if (m6338V() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6220z = richDocumentElementStyleModel;
                }
            }
            if (m6339W() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6339W());
                if (m6339W() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6194A = richDocumentElementStyleModel;
                }
            }
            if (m6340X() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6340X());
                if (m6340X() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6195B = richDocumentElementStyleModel;
                }
            }
            if (m6341Y() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6341Y());
                if (m6341Y() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6196C = richDocumentElementStyleModel;
                }
            }
            if (m6342Z() != null) {
                richDocumentElementStyleModel = (RichDocumentElementStyleModel) graphQLModelMutatingVisitor.b(m6342Z());
                if (m6342Z() != richDocumentElementStyleModel) {
                    graphQLVisitableModel = (RichDocumentStyleModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6197D = richDocumentElementStyleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6345a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6347a());
            int a = ModelHelper.a(flatBufferBuilder, m6319C());
            int a2 = ModelHelper.a(flatBufferBuilder, m6320D());
            int a3 = ModelHelper.a(flatBufferBuilder, m6321E());
            int a4 = ModelHelper.a(flatBufferBuilder, m6322F());
            int a5 = ModelHelper.a(flatBufferBuilder, m6323G());
            int a6 = ModelHelper.a(flatBufferBuilder, m6324H());
            int a7 = ModelHelper.a(flatBufferBuilder, m6325I());
            int a8 = ModelHelper.a(flatBufferBuilder, m6326J());
            int a9 = ModelHelper.a(flatBufferBuilder, m6327K());
            int a10 = ModelHelper.a(flatBufferBuilder, m6328L());
            int a11 = ModelHelper.a(flatBufferBuilder, m6329M());
            int a12 = ModelHelper.a(flatBufferBuilder, m6330N());
            int a13 = ModelHelper.a(flatBufferBuilder, m6358o());
            int a14 = ModelHelper.a(flatBufferBuilder, m6331O());
            int a15 = ModelHelper.a(flatBufferBuilder, m6332P());
            int a16 = ModelHelper.a(flatBufferBuilder, m6333Q());
            int a17 = ModelHelper.a(flatBufferBuilder, m6334R());
            int a18 = ModelHelper.a(flatBufferBuilder, m6335S());
            int a19 = ModelHelper.a(flatBufferBuilder, m6336T());
            int a20 = ModelHelper.a(flatBufferBuilder, m6337U());
            int a21 = ModelHelper.a(flatBufferBuilder, m6338V());
            int a22 = ModelHelper.a(flatBufferBuilder, m6339W());
            int a23 = ModelHelper.a(flatBufferBuilder, m6340X());
            int a24 = ModelHelper.a(flatBufferBuilder, m6341Y());
            int a25 = ModelHelper.a(flatBufferBuilder, m6342Z());
            flatBufferBuilder.c(27);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.b(10, a10);
            flatBufferBuilder.b(11, a11);
            flatBufferBuilder.b(12, a12);
            flatBufferBuilder.b(13, a13);
            flatBufferBuilder.b(14, a14);
            flatBufferBuilder.b(15, a15);
            flatBufferBuilder.b(16, a16);
            flatBufferBuilder.b(17, a17);
            flatBufferBuilder.a(18, this.f6216v);
            flatBufferBuilder.b(19, a18);
            flatBufferBuilder.b(20, a19);
            flatBufferBuilder.b(21, a20);
            flatBufferBuilder.b(22, a21);
            flatBufferBuilder.b(23, a22);
            flatBufferBuilder.b(24, a23);
            flatBufferBuilder.b(25, a24);
            flatBufferBuilder.b(26, a25);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6348a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6216v = mutableFlatBuffer.a(i, 18);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1272649122)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentTextAnnotationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private RichDocumentTextModel f6221d;
        @Nullable
        private String f6222e;
        @Nullable
        private GraphQLTextAnnotationHorizontalPosition f6223f;
        @Nullable
        private GraphQLTextAnnotationPresentationStyle f6224g;
        @Nullable
        private GraphQLTextAnnotationVerticalPosition f6225h;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentTextAnnotationModel.class, new Deserializer());
            }

            public Object m6370a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object richDocumentTextAnnotationModel = new RichDocumentTextAnnotationModel();
                ((BaseModel) richDocumentTextAnnotationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (richDocumentTextAnnotationModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentTextAnnotationModel).a();
                }
                return richDocumentTextAnnotationModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentTextAnnotationModel> {
            public final void m6371a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RichDocumentTextAnnotationModel richDocumentTextAnnotationModel = (RichDocumentTextAnnotationModel) obj;
                if (richDocumentTextAnnotationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentTextAnnotationModel.m6373a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentTextAnnotationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RichDocumentTextAnnotationParser.m6587a(richDocumentTextAnnotationModel.w_(), richDocumentTextAnnotationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(RichDocumentTextAnnotationModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RichDocumentText m6375a() {
            return m6372j();
        }

        public RichDocumentTextAnnotationModel() {
            super(5);
        }

        @Nullable
        private RichDocumentTextModel m6372j() {
            this.f6221d = (RichDocumentTextModel) super.a(this.f6221d, 0, RichDocumentTextModel.class);
            return this.f6221d;
        }

        @Nullable
        public final String m6376b() {
            this.f6222e = super.a(this.f6222e, 1);
            return this.f6222e;
        }

        @Nullable
        public final GraphQLTextAnnotationHorizontalPosition m6377c() {
            this.f6223f = (GraphQLTextAnnotationHorizontalPosition) super.b(this.f6223f, 2, GraphQLTextAnnotationHorizontalPosition.class, GraphQLTextAnnotationHorizontalPosition.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6223f;
        }

        @Nullable
        public final GraphQLTextAnnotationPresentationStyle m6378d() {
            this.f6224g = (GraphQLTextAnnotationPresentationStyle) super.b(this.f6224g, 3, GraphQLTextAnnotationPresentationStyle.class, GraphQLTextAnnotationPresentationStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6224g;
        }

        @Nullable
        public final GraphQLTextAnnotationVerticalPosition iu_() {
            this.f6225h = (GraphQLTextAnnotationVerticalPosition) super.b(this.f6225h, 4, GraphQLTextAnnotationVerticalPosition.class, GraphQLTextAnnotationVerticalPosition.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6225h;
        }

        public final int jK_() {
            return 1359476311;
        }

        public final GraphQLVisitableModel m6374a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6372j() != null) {
                RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m6372j());
                if (m6372j() != richDocumentTextModel) {
                    graphQLVisitableModel = (RichDocumentTextAnnotationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6221d = richDocumentTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6373a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6372j());
            int b = flatBufferBuilder.b(m6376b());
            int a2 = flatBufferBuilder.a(m6377c());
            int a3 = flatBufferBuilder.a(m6378d());
            int a4 = flatBufferBuilder.a(iu_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 866745381)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentTextModel extends BaseModel implements GraphQLVisitableModel, RichDocumentText {
        @Nullable
        private GraphQLComposedBlockType f6263d;
        private int f6264e;
        @Nullable
        private List<EntityRangesModel> f6265f;
        @Nullable
        private List<InlineStyleRangesModel> f6266g;
        @Nullable
        private String f6267h;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.class;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m6379a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.m6596a(r11, r4);
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r4 = 0;
                r5.position(r4);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = 4;
                r6 = java.lang.Boolean.valueOf(r8);
                r4.a(r5, r6);
                r2 = r4;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r11);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0048;
            L_0x0042:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0048:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1642871126)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class EntityRangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityModel f6256d;
            @Nullable
            private GraphQLComposedEntityType f6257e;
            private int f6258f;
            private int f6259g;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6380a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.EntityRangesParser.m6591b(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1412605510)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_picker_camera_cancelled */
            public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, FBPhoto, FBVideo {
                @Nullable
                private String f6226A;
                @Nullable
                private String f6227B;
                private int f6228C;
                @Nullable
                private GraphQLSubscribeStatus f6229D;
                @Nullable
                private String f6230E;
                @Nullable
                private FBFullImageFragmentModel f6231F;
                private int f6232G;
                @Nullable
                private GraphQLObjectType f6233d;
                @Nullable
                private String f6234e;
                private int f6235f;
                @Nullable
                private String f6236g;
                @Nullable
                private FBFullImageFragmentModel f6237h;
                private int f6238i;
                private int f6239j;
                private int f6240k;
                @Nullable
                private FBFullImageFragmentModel f6241l;
                private boolean f6242m;
                @Nullable
                private MessageModel f6243n;
                @Nullable
                private String f6244o;
                private int f6245p;
                @Nullable
                private String f6246q;
                @Nullable
                private String f6247r;
                @Nullable
                private String f6248s;
                @Nullable
                private String f6249t;
                @Nullable
                private String f6250u;
                @Nullable
                private FBFullImageFragmentModel f6251v;
                @Nullable
                private String f6252w;
                private double f6253x;
                private double f6254y;
                @Nullable
                private String f6255z;

                /* compiled from: photo_picker_camera_cancelled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.class;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$EntityModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m6381a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.EntityRangesParser.EntityParser.m6588a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$EntityModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: photo_picker_camera_cancelled */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m6382a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m6392a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.EntityRangesParser.EntityParser.m6589a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.class;
                        r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$EntityModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.Serializer.<clinit>():void");
                    }
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel mo316c() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m6383C();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.c():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel mo317d() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m6384D();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.d():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                @javax.annotation.Nullable
                public final /* synthetic */ com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel mo337x() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m6389I();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.x():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                public EntityModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 30;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.<init>():void");
                }

                public final void m6396a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m6397a(java.lang.String r1, java.lang.Object r2, boolean r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLObjectType m6418z() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f6233d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f6233d = r0;
                L_0x0017:
                    r0 = r4.f6233d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.z():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6390A() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6234e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f6234e = r0;
                    r0 = r2.f6234e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.A():java.lang.String");
                }

                public final int mo320g() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = 2;
                    r2.a(r0, r1);
                    r0 = r2.f6235f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.g():int");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo315b() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6236g;
                    r1 = 3;
                    r0 = super.a(r0, r1);
                    r2.f6236g = r0;
                    r0 = r2.f6236g;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                private com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel m6383C() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f6237h;
                    r1 = 4;
                    r2 = com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r3.f6237h = r0;
                    r0 = r3.f6237h;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.C():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                public final int hU_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = 5;
                    r2.a(r0, r1);
                    r0 = r2.f6238i;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.hU_():int");
                }

                public final int hV_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = 6;
                    r2.a(r0, r1);
                    r0 = r2.f6239j;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.hV_():int");
                }

                public final int mo323j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r1 = 7;
                    r2.a(r0, r1);
                    r0 = r2.f6240k;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.j():int");
                }

                @javax.annotation.Nullable
                private com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel m6384D() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f6241l;
                    r1 = 8;
                    r2 = com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r3.f6241l = r0;
                    r0 = r3.f6241l;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.D():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                public final boolean mo324k() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1;
                    r1.a(r0, r0);
                    r0 = r1.f6242m;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.k():boolean");
                }

                @javax.annotation.Nullable
                private com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBVideoModel.MessageModel m6385E() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f6243n;
                    r1 = 10;
                    r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBVideoModel.MessageModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBVideoModel.MessageModel) r0;
                    r3.f6243n = r0;
                    r0 = r3.f6243n;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.E():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$FBVideoModel$MessageModel");
                }

                @javax.annotation.Nullable
                private java.lang.String m6386F() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6244o;
                    r1 = 11;
                    r0 = super.a(r0, r1);
                    r2.f6244o = r0;
                    r0 = r2.f6244o;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.F():java.lang.String");
                }

                public final int mo325l() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 1;
                    r1 = 4;
                    r2.a(r0, r1);
                    r0 = r2.f6245p;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.l():int");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo326m() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6246q;
                    r1 = 13;
                    r0 = super.a(r0, r1);
                    r2.f6246q = r0;
                    r0 = r2.f6246q;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.m():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo327n() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6247r;
                    r1 = 14;
                    r0 = super.a(r0, r1);
                    r2.f6247r = r0;
                    r0 = r2.f6247r;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.n():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo328o() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6248s;
                    r1 = 15;
                    r0 = super.a(r0, r1);
                    r2.f6248s = r0;
                    r0 = r2.f6248s;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.o():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo329p() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6249t;
                    r1 = 16;
                    r0 = super.a(r0, r1);
                    r2.f6249t = r0;
                    r0 = r2.f6249t;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.p():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String hS_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6250u;
                    r1 = 17;
                    r0 = super.a(r0, r1);
                    r2.f6250u = r0;
                    r0 = r2.f6250u;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.hS_():java.lang.String");
                }

                @javax.annotation.Nullable
                private com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel m6387G() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f6251v;
                    r1 = 18;
                    r2 = com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r3.f6251v = r0;
                    r0 = r3.f6251v;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.G():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo330q() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6252w;
                    r1 = 19;
                    r0 = super.a(r0, r1);
                    r2.f6252w = r0;
                    r0 = r2.f6252w;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.q():java.lang.String");
                }

                public final double mo331r() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 2;
                    r1 = 4;
                    r2.a(r0, r1);
                    r0 = r2.f6253x;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.r():double");
                }

                public final double mo332s() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 2;
                    r1 = 5;
                    r2.a(r0, r1);
                    r0 = r2.f6254y;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.s():double");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo333t() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6255z;
                    r1 = 22;
                    r0 = super.a(r0, r1);
                    r2.f6255z = r0;
                    r0 = r2.f6255z;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.t():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo334u() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6226A;
                    r1 = 23;
                    r0 = super.a(r0, r1);
                    r2.f6226A = r0;
                    r0 = r2.f6226A;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.u():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String mo335v() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6227B;
                    r1 = 24;
                    r0 = super.a(r0, r1);
                    r2.f6227B = r0;
                    r0 = r2.f6227B;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.v():java.lang.String");
                }

                public final int mo336w() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 3;
                    r1 = 1;
                    r2.a(r0, r1);
                    r0 = r2.f6228C;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.w():int");
                }

                @javax.annotation.Nullable
                private com.facebook.graphql.enums.GraphQLSubscribeStatus m6388H() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f6229D;
                    r1 = 26;
                    r2 = com.facebook.graphql.enums.GraphQLSubscribeStatus.class;
                    r3 = com.facebook.graphql.enums.GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    r0 = super.b(r0, r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLSubscribeStatus) r0;
                    r4.f6229D = r0;
                    r0 = r4.f6229D;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.H():com.facebook.graphql.enums.GraphQLSubscribeStatus");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6391B() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f6230E;
                    r1 = 27;
                    r0 = super.a(r0, r1);
                    r2.f6230E = r0;
                    r0 = r2.f6230E;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.B():java.lang.String");
                }

                @javax.annotation.Nullable
                private com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel m6389I() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f6231F;
                    r1 = 28;
                    r2 = com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r3.f6231F = r0;
                    r0 = r3.f6231F;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.I():com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels$FBFullImageFragmentModel");
                }

                public final int mo338y() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 3;
                    r1 = 5;
                    r2.a(r0, r1);
                    r0 = r2.f6232G;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.y():int");
                }

                @javax.annotation.Nullable
                public final java.lang.String m6394a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.mo315b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.a():java.lang.String");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2080559107; // 0x7c02d003 float:2.7168703E36 double:1.027932779E-314;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m6393a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = 0;
                    r3.h();
                    r0 = r3.m6383C();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m6383C();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r2 = r3.m6383C();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r1;
                    r1.f6237h = r0;
                L_0x0022:
                    r0 = r3.m6384D();
                    if (r0 == 0) goto L_0x0040;
                L_0x0028:
                    r0 = r3.m6384D();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r2 = r3.m6384D();
                    if (r2 == r0) goto L_0x0040;
                L_0x0038:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r1;
                    r1.f6241l = r0;
                L_0x0040:
                    r0 = r3.m6385E();
                    if (r0 == 0) goto L_0x005e;
                L_0x0046:
                    r0 = r3.m6385E();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBVideoModel.MessageModel) r0;
                    r2 = r3.m6385E();
                    if (r2 == r0) goto L_0x005e;
                L_0x0056:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r1;
                    r1.f6243n = r0;
                L_0x005e:
                    r0 = r3.m6387G();
                    if (r0 == 0) goto L_0x007c;
                L_0x0064:
                    r0 = r3.m6387G();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r2 = r3.m6387G();
                    if (r2 == r0) goto L_0x007c;
                L_0x0074:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r1;
                    r1.f6251v = r0;
                L_0x007c:
                    r0 = r3.m6389I();
                    if (r0 == 0) goto L_0x009a;
                L_0x0082:
                    r0 = r3.m6389I();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel) r0;
                    r2 = r3.m6389I();
                    if (r2 == r0) goto L_0x009a;
                L_0x0092:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r1;
                    r1.f6231F = r0;
                L_0x009a:
                    r3.i();
                    if (r1 != 0) goto L_0x00a0;
                L_0x009f:
                    return r3;
                L_0x00a0:
                    r3 = r1;
                    goto L_0x009f;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m6392a(com.facebook.flatbuffers.FlatBufferBuilder r24) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r23 = this;
                    r23.h();
                    r2 = r23.m6418z();
                    r0 = r24;
                    r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                    r3 = r23.m6390A();
                    r0 = r24;
                    r3 = r0.b(r3);
                    r4 = r23.mo315b();
                    r0 = r24;
                    r4 = r0.b(r4);
                    r5 = r23.m6383C();
                    r0 = r24;
                    r5 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r5);
                    r6 = r23.m6384D();
                    r0 = r24;
                    r6 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                    r7 = r23.m6385E();
                    r0 = r24;
                    r7 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r7);
                    r8 = r23.m6386F();
                    r0 = r24;
                    r8 = r0.b(r8);
                    r9 = r23.mo326m();
                    r0 = r24;
                    r9 = r0.b(r9);
                    r10 = r23.mo327n();
                    r0 = r24;
                    r10 = r0.b(r10);
                    r11 = r23.mo328o();
                    r0 = r24;
                    r11 = r0.b(r11);
                    r12 = r23.mo329p();
                    r0 = r24;
                    r12 = r0.b(r12);
                    r13 = r23.hS_();
                    r0 = r24;
                    r13 = r0.b(r13);
                    r14 = r23.m6387G();
                    r0 = r24;
                    r14 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r14);
                    r15 = r23.mo330q();
                    r0 = r24;
                    r15 = r0.b(r15);
                    r16 = r23.mo333t();
                    r0 = r24;
                    r1 = r16;
                    r16 = r0.b(r1);
                    r17 = r23.mo334u();
                    r0 = r24;
                    r1 = r17;
                    r17 = r0.b(r1);
                    r18 = r23.mo335v();
                    r0 = r24;
                    r1 = r18;
                    r18 = r0.b(r1);
                    r19 = r23.m6388H();
                    r0 = r24;
                    r1 = r19;
                    r19 = r0.a(r1);
                    r20 = r23.m6391B();
                    r0 = r24;
                    r1 = r20;
                    r20 = r0.b(r1);
                    r21 = r23.m6389I();
                    r0 = r24;
                    r1 = r21;
                    r21 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                    r22 = 30;
                    r0 = r24;
                    r1 = r22;
                    r0.c(r1);
                    r22 = 0;
                    r0 = r24;
                    r1 = r22;
                    r0.b(r1, r2);
                    r2 = 1;
                    r0 = r24;
                    r0.b(r2, r3);
                    r2 = 2;
                    r0 = r23;
                    r3 = r0.f6235f;
                    r22 = 0;
                    r0 = r24;
                    r1 = r22;
                    r0.a(r2, r3, r1);
                    r2 = 3;
                    r0 = r24;
                    r0.b(r2, r4);
                    r2 = 4;
                    r0 = r24;
                    r0.b(r2, r5);
                    r2 = 5;
                    r0 = r23;
                    r3 = r0.f6238i;
                    r4 = 0;
                    r0 = r24;
                    r0.a(r2, r3, r4);
                    r2 = 6;
                    r0 = r23;
                    r3 = r0.f6239j;
                    r4 = 0;
                    r0 = r24;
                    r0.a(r2, r3, r4);
                    r2 = 7;
                    r0 = r23;
                    r3 = r0.f6240k;
                    r4 = 0;
                    r0 = r24;
                    r0.a(r2, r3, r4);
                    r2 = 8;
                    r0 = r24;
                    r0.b(r2, r6);
                    r2 = 9;
                    r0 = r23;
                    r3 = r0.f6242m;
                    r0 = r24;
                    r0.a(r2, r3);
                    r2 = 10;
                    r0 = r24;
                    r0.b(r2, r7);
                    r2 = 11;
                    r0 = r24;
                    r0.b(r2, r8);
                    r2 = 12;
                    r0 = r23;
                    r3 = r0.f6245p;
                    r4 = 0;
                    r0 = r24;
                    r0.a(r2, r3, r4);
                    r2 = 13;
                    r0 = r24;
                    r0.b(r2, r9);
                    r2 = 14;
                    r0 = r24;
                    r0.b(r2, r10);
                    r2 = 15;
                    r0 = r24;
                    r0.b(r2, r11);
                    r2 = 16;
                    r0 = r24;
                    r0.b(r2, r12);
                    r2 = 17;
                    r0 = r24;
                    r0.b(r2, r13);
                    r2 = 18;
                    r0 = r24;
                    r0.b(r2, r14);
                    r2 = 19;
                    r0 = r24;
                    r0.b(r2, r15);
                    r3 = 20;
                    r0 = r23;
                    r4 = r0.f6253x;
                    r6 = 0;
                    r2 = r24;
                    r2.a(r3, r4, r6);
                    r3 = 21;
                    r0 = r23;
                    r4 = r0.f6254y;
                    r6 = 0;
                    r2 = r24;
                    r2.a(r3, r4, r6);
                    r2 = 22;
                    r0 = r24;
                    r1 = r16;
                    r0.b(r2, r1);
                    r2 = 23;
                    r0 = r24;
                    r1 = r17;
                    r0.b(r2, r1);
                    r2 = 24;
                    r0 = r24;
                    r1 = r18;
                    r0.b(r2, r1);
                    r2 = 25;
                    r0 = r23;
                    r3 = r0.f6228C;
                    r4 = 0;
                    r0 = r24;
                    r0.a(r2, r3, r4);
                    r2 = 26;
                    r0 = r24;
                    r1 = r19;
                    r0.b(r2, r1);
                    r2 = 27;
                    r0 = r24;
                    r1 = r20;
                    r0.b(r2, r1);
                    r2 = 28;
                    r0 = r24;
                    r1 = r21;
                    r0.b(r2, r1);
                    r2 = 29;
                    r0 = r23;
                    r3 = r0.f6232G;
                    r4 = 0;
                    r0 = r24;
                    r0.a(r2, r3, r4);
                    r23.i();
                    r2 = r24.d();
                    return r2;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m6395a(com.facebook.flatbuffers.MutableFlatBuffer r7, int r8, java.lang.Object r9) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r4 = 0;
                    r2 = 0;
                    super.a(r7, r8, r9);
                    r0 = 2;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6235f = r0;
                    r0 = 5;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6238i = r0;
                    r0 = 6;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6239j = r0;
                    r0 = 7;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6240k = r0;
                    r0 = 9;
                    r0 = r7.a(r8, r0);
                    r6.f6242m = r0;
                    r0 = 12;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6245p = r0;
                    r0 = 20;
                    r0 = r7.a(r8, r0, r4);
                    r6.f6253x = r0;
                    r0 = 21;
                    r0 = r7.a(r8, r0, r4);
                    r6.f6254y = r0;
                    r0 = 25;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6228C = r0;
                    r0 = 29;
                    r0 = r7.a(r8, r0, r2);
                    r6.f6232G = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<EntityRangesModel> {
                public final void m6419a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6421a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.EntityRangesParser.m6592b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel m6423a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m6420j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.a():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$EntityModel");
            }

            public EntityRangesModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 4;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel m6420j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f6256d;
                r1 = 0;
                r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r0;
                r3.f6256d = r0;
                r0 = r3.f6256d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.j():com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel$EntityModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.graphql.enums.GraphQLComposedEntityType m6425b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.f6257e;
                r1 = 1;
                r2 = com.facebook.graphql.enums.GraphQLComposedEntityType.class;
                r3 = com.facebook.graphql.enums.GraphQLComposedEntityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                r0 = super.b(r0, r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLComposedEntityType) r0;
                r4.f6257e = r0;
                r0 = r4.f6257e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.b():com.facebook.graphql.enums.GraphQLComposedEntityType");
            }

            public final int m6426c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 2;
                r2.a(r0, r1);
                r0 = r2.f6258f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.c():int");
            }

            public final int m6427d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 3;
                r2.a(r0, r1);
                r0 = r2.f6259g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.d():int");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 199462741; // 0xbe38f55 float:8.765288E-32 double:9.8547688E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6422a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m6420j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m6420j();
                r0 = r4.b(r0);
                r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel) r0;
                r2 = r3.m6420j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel) r1;
                r1.f6256d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m6421a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r3 = 0;
                r4.h();
                r0 = r4.m6420j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                r1 = r4.m6425b();
                r1 = r5.a(r1);
                r2 = 4;
                r5.c(r2);
                r5.b(r3, r0);
                r0 = 1;
                r5.b(r0, r1);
                r0 = 2;
                r1 = r4.f6258f;
                r5.a(r0, r1, r3);
                r0 = 3;
                r1 = r4.f6259g;
                r5.a(r0, r1, r3);
                r4.i();
                r0 = r5.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m6424a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = 0;
                super.a(r3, r4, r5);
                r0 = 2;
                r0 = r3.a(r4, r0, r1);
                r2.f6258f = r0;
                r0 = 3;
                r0 = r3.a(r4, r0, r1);
                r2.f6259g = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1105751430)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_picker_camera_cancelled */
        public final class InlineStyleRangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLInlineStyle f6260d;
            private int f6261e;
            private int f6262f;

            /* compiled from: photo_picker_camera_cancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$InlineStyleRangesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m6428a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.InlineStyleRangesParser.m6595b(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$InlineStyleRangesModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: photo_picker_camera_cancelled */
            public class Serializer extends JsonSerializer<InlineStyleRangesModel> {
                public final void m6429a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m6430a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.InlineStyleRangesParser.m6594a(r0, r1, r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.class;
                    r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$InlineStyleRangesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.Serializer.<clinit>():void");
                }
            }

            public InlineStyleRangesModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 3;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.graphql.enums.GraphQLInlineStyle m6431a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r0 = r4.f6260d;
                r1 = 0;
                r2 = com.facebook.graphql.enums.GraphQLInlineStyle.class;
                r3 = com.facebook.graphql.enums.GraphQLInlineStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                r0 = super.b(r0, r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLInlineStyle) r0;
                r4.f6260d = r0;
                r0 = r4.f6260d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.a():com.facebook.graphql.enums.GraphQLInlineStyle");
            }

            public final int m6434b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 1;
                r2.a(r0, r1);
                r0 = r2.f6261e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.b():int");
            }

            public final int m6435c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 2;
                r2.a(r0, r1);
                r0 = r2.f6262f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.c():int");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 282811186; // 0x10db5b32 float:8.652078E-29 double:1.397272913E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m6432a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.h();
                r0.i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m6430a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r2 = 0;
                r3.h();
                r0 = r3.m6431a();
                r0 = r4.a(r0);
                r1 = 3;
                r4.c(r1);
                r4.b(r2, r0);
                r0 = 1;
                r1 = r3.f6261e;
                r4.a(r0, r1, r2);
                r0 = 2;
                r1 = r3.f6262f;
                r4.a(r0, r1, r2);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m6433a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = 0;
                super.a(r3, r4, r5);
                r0 = 1;
                r0 = r3.a(r4, r0, r1);
                r2.f6261e = r0;
                r0 = 2;
                r0 = r3.a(r4, r0, r1);
                r2.f6262f = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentTextModel> {
            public final void m6436a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r8 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m6437a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r8.a(r0, r1);
            L_0x0035:
                r0 = r8.w_();
                r1 = r8.u_();
                com.facebook.richdocument.model.graphql.RichDocumentGraphQlParsers.RichDocumentTextParser.m6598b(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.class;
                r1 = new com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.Serializer.<clinit>():void");
            }
        }

        public RichDocumentTextModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 5;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.enums.GraphQLComposedBlockType mo300a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f6263d;
            r1 = 0;
            r2 = com.facebook.graphql.enums.GraphQLComposedBlockType.class;
            r3 = com.facebook.graphql.enums.GraphQLComposedBlockType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            r0 = super.b(r0, r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLComposedBlockType) r0;
            r4.f6263d = r0;
            r0 = r4.f6263d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.a():com.facebook.graphql.enums.GraphQLComposedBlockType");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel> mo301b() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f6265f;
            r1 = 2;
            r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f6265f = r0;
            r0 = r3.f6265f;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.b():com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$EntityRangesModel>");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel> mo302c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f6266g;
            r1 = 3;
            r2 = com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.InlineStyleRangesModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f6266g = r0;
            r0 = r3.f6266g;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.c():com.google.common.collect.ImmutableList<com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels$RichDocumentTextModel$InlineStyleRangesModel>");
        }

        @javax.annotation.Nullable
        public final java.lang.String mo303d() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.f6267h;
            r1 = 4;
            r0 = super.a(r0, r1);
            r2.f6267h = r0;
            r0 = r2.f6267h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.d():java.lang.String");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = -671364926; // 0xffffffffd7fbc8c2 float:-5.53679334E14 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m6439a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 0;
            r2.h();
            r1 = r2.mo301b();
            if (r1 == 0) goto L_0x0020;
        L_0x000a:
            r1 = r2.mo301b();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            if (r1 == 0) goto L_0x0020;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel) r0;
            r1 = r1.b();
            r0.f6265f = r1;
        L_0x0020:
            r1 = r2.mo302c();
            if (r1 == 0) goto L_0x003c;
        L_0x0026:
            r1 = r2.mo302c();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            if (r1 == 0) goto L_0x003c;
        L_0x0030:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r0 = (com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel) r0;
            r1 = r1.b();
            r0.f6266g = r1;
        L_0x003c:
            r2.i();
            if (r0 != 0) goto L_0x0042;
        L_0x0041:
            return r2;
        L_0x0042:
            r2 = r0;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m6437a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r6 = this;
            r5 = 0;
            r6.h();
            r0 = r6.mo300a();
            r0 = r7.a(r0);
            r1 = r6.mo301b();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r1);
            r2 = r6.mo302c();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r2);
            r3 = r6.mo303d();
            r3 = r7.b(r3);
            r4 = 5;
            r7.c(r4);
            r7.b(r5, r0);
            r0 = 1;
            r4 = r6.f6264e;
            r7.a(r0, r4, r5);
            r0 = 2;
            r7.b(r0, r1);
            r0 = 3;
            r7.b(r0, r2);
            r0 = 4;
            r7.b(r0, r3);
            r6.i();
            r0 = r7.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        public final void m6440a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            super.a(r3, r4, r5);
            r0 = 1;
            r1 = 0;
            r0 = r3.a(r4, r0, r1);
            r2.f6264e = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -204973154)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_picker_camera_cancelled */
    public final class RichDocumentTrackerModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f6268d;
        @Nullable
        private String f6269e;
        @Nullable
        private String f6270f;

        /* compiled from: photo_picker_camera_cancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentTrackerModel.class, new Deserializer());
            }

            public Object m6444a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentTrackerParser.m6599a(jsonParser);
                Object richDocumentTrackerModel = new RichDocumentTrackerModel();
                ((BaseModel) richDocumentTrackerModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentTrackerModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentTrackerModel).a();
                }
                return richDocumentTrackerModel;
            }
        }

        /* compiled from: photo_picker_camera_cancelled */
        public class Serializer extends JsonSerializer<RichDocumentTrackerModel> {
            public final void m6445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentTrackerModel richDocumentTrackerModel = (RichDocumentTrackerModel) obj;
                if (richDocumentTrackerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentTrackerModel.m6446a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentTrackerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentTrackerModel.w_();
                int u_ = richDocumentTrackerModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("base_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("html_source");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("webview_base_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentTrackerModel.class, new Serializer());
            }
        }

        public RichDocumentTrackerModel() {
            super(3);
        }

        @Nullable
        public final String m6448a() {
            this.f6268d = super.a(this.f6268d, 0);
            return this.f6268d;
        }

        @Nullable
        public final String m6449j() {
            this.f6269e = super.a(this.f6269e, 1);
            return this.f6269e;
        }

        @Nullable
        public final String m6450k() {
            this.f6270f = super.a(this.f6270f, 2);
            return this.f6270f;
        }

        public final int jK_() {
            return 1475051230;
        }

        public final GraphQLVisitableModel m6447a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6446a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6448a());
            int b2 = flatBufferBuilder.b(m6449j());
            int b3 = flatBufferBuilder.b(m6450k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
