package com.facebook.timeline.aboutpage.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.model.extras.InfoRequestFieldExtra;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionItemConnectionWithFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.SubtitleModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsAppSectionModel.TitleModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsEligibleSuggestionsFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsNodeIdFieldsModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsPeekFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.AboutPageUserFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.AboutPageUserFieldsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.AppSectionInfoParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionWithItemsOrRequestablesParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionsAppSectionMediasetParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionsAppSectionRequestableFieldParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionsAppSectionRequestableFieldsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionsAppSectionWithItemsOrRequestablesParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionsAppSectionWithItemsOrRequestablesParser.CollectionsNoItemsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.CollectionsAppSectionWithItemsOrRequestablesParser.CollectionsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineAppSectionsStructuredNameParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineAppSectionsStructuredNameParser.PartsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineCollectionAppSectionsFieldsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineCollectionAppSectionsFieldsParser.PageInfoParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineCollectionAppSectionsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineMutualFriendFieldsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineMutualFriendsParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
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

/* compiled from: MapView */
public class FetchTimelineAppSectionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1861930988)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class AboutPageUserFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel, AboutPageUserFields {
        @Nullable
        private TimelineMutualFriendsModel f13385d;
        @Nullable
        private String f13386e;
        @Nullable
        private TimelineAppSectionsStructuredNameModel f13387f;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AboutPageUserFieldsModel.class, new Deserializer());
            }

            public Object m14493a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AboutPageUserFieldsParser.m14639a(jsonParser);
                Object aboutPageUserFieldsModel = new AboutPageUserFieldsModel();
                ((BaseModel) aboutPageUserFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (aboutPageUserFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) aboutPageUserFieldsModel).a();
                }
                return aboutPageUserFieldsModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<AboutPageUserFieldsModel> {
            public final void m14494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AboutPageUserFieldsModel aboutPageUserFieldsModel = (AboutPageUserFieldsModel) obj;
                if (aboutPageUserFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(aboutPageUserFieldsModel.m14497a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    aboutPageUserFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = aboutPageUserFieldsModel.w_();
                int u_ = aboutPageUserFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    TimelineMutualFriendsParser.m14667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("structured_name");
                    TimelineAppSectionsStructuredNameParser.m14658a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AboutPageUserFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineAppSectionsStructuredNameModel mo382k() {
            return m14496m();
        }

        @Nullable
        public final /* synthetic */ TimelineMutualFriendsModel mo383l() {
            return m14495j();
        }

        public AboutPageUserFieldsModel() {
            super(3);
        }

        public final void m14500a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14501a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TimelineMutualFriendsModel m14495j() {
            this.f13385d = (TimelineMutualFriendsModel) super.a(this.f13385d, 0, TimelineMutualFriendsModel.class);
            return this.f13385d;
        }

        @Nullable
        public final String mo381a() {
            this.f13386e = super.a(this.f13386e, 1);
            return this.f13386e;
        }

        @Nullable
        private TimelineAppSectionsStructuredNameModel m14496m() {
            this.f13387f = (TimelineAppSectionsStructuredNameModel) super.a(this.f13387f, 2, TimelineAppSectionsStructuredNameModel.class);
            return this.f13387f;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m14498a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14495j() != null) {
                TimelineMutualFriendsModel timelineMutualFriendsModel = (TimelineMutualFriendsModel) graphQLModelMutatingVisitor.b(m14495j());
                if (m14495j() != timelineMutualFriendsModel) {
                    graphQLVisitableModel = (AboutPageUserFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13385d = timelineMutualFriendsModel;
                }
            }
            if (m14496m() != null) {
                TimelineAppSectionsStructuredNameModel timelineAppSectionsStructuredNameModel = (TimelineAppSectionsStructuredNameModel) graphQLModelMutatingVisitor.b(m14496m());
                if (m14496m() != timelineAppSectionsStructuredNameModel) {
                    graphQLVisitableModel = (AboutPageUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13387f = timelineAppSectionsStructuredNameModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14497a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14495j());
            int b = flatBufferBuilder.b(mo381a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14496m());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1492284437)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class AppSectionInfoModel extends BaseModel implements GraphQLVisitableConsistentModel, AboutPageUserFields {
        @Nullable
        private TimelineMutualFriendsModel f13388d;
        @Nullable
        private String f13389e;
        @Nullable
        private TimelineAppSectionsStructuredNameModel f13390f;
        @Nullable
        private TimelineCollectionAppSectionsFieldsModel f13391g;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppSectionInfoModel.class, new Deserializer());
            }

            public Object m14504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppSectionInfoParser.m14640a(jsonParser);
                Object appSectionInfoModel = new AppSectionInfoModel();
                ((BaseModel) appSectionInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appSectionInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) appSectionInfoModel).a();
                }
                return appSectionInfoModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<AppSectionInfoModel> {
            public final void m14505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppSectionInfoModel appSectionInfoModel = (AppSectionInfoModel) obj;
                if (appSectionInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appSectionInfoModel.m14508a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appSectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appSectionInfoModel.w_();
                int u_ = appSectionInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    TimelineMutualFriendsParser.m14667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("structured_name");
                    TimelineAppSectionsStructuredNameParser.m14658a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("timeline_collection_app_sections");
                    TimelineCollectionAppSectionsFieldsParser.m14662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppSectionInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineAppSectionsStructuredNameModel mo382k() {
            return m14507n();
        }

        @Nullable
        public final /* synthetic */ TimelineMutualFriendsModel mo383l() {
            return m14506m();
        }

        public AppSectionInfoModel() {
            super(4);
        }

        public final void m14511a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14512a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TimelineMutualFriendsModel m14506m() {
            this.f13388d = (TimelineMutualFriendsModel) super.a(this.f13388d, 0, TimelineMutualFriendsModel.class);
            return this.f13388d;
        }

        @Nullable
        public final String mo381a() {
            this.f13389e = super.a(this.f13389e, 1);
            return this.f13389e;
        }

        @Nullable
        private TimelineAppSectionsStructuredNameModel m14507n() {
            this.f13390f = (TimelineAppSectionsStructuredNameModel) super.a(this.f13390f, 2, TimelineAppSectionsStructuredNameModel.class);
            return this.f13390f;
        }

        @Nullable
        public final TimelineCollectionAppSectionsFieldsModel m14513j() {
            this.f13391g = (TimelineCollectionAppSectionsFieldsModel) super.a(this.f13391g, 3, TimelineCollectionAppSectionsFieldsModel.class);
            return this.f13391g;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m14509a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14506m() != null) {
                TimelineMutualFriendsModel timelineMutualFriendsModel = (TimelineMutualFriendsModel) graphQLModelMutatingVisitor.b(m14506m());
                if (m14506m() != timelineMutualFriendsModel) {
                    graphQLVisitableModel = (AppSectionInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13388d = timelineMutualFriendsModel;
                }
            }
            if (m14507n() != null) {
                TimelineAppSectionsStructuredNameModel timelineAppSectionsStructuredNameModel = (TimelineAppSectionsStructuredNameModel) graphQLModelMutatingVisitor.b(m14507n());
                if (m14507n() != timelineAppSectionsStructuredNameModel) {
                    graphQLVisitableModel = (AppSectionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13390f = timelineAppSectionsStructuredNameModel;
                }
            }
            if (m14513j() != null) {
                TimelineCollectionAppSectionsFieldsModel timelineCollectionAppSectionsFieldsModel = (TimelineCollectionAppSectionsFieldsModel) graphQLModelMutatingVisitor.b(m14513j());
                if (m14513j() != timelineCollectionAppSectionsFieldsModel) {
                    graphQLVisitableModel = (AppSectionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13391g = timelineCollectionAppSectionsFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14508a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14506m());
            int b = flatBufferBuilder.b(mo381a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14507n());
            int a3 = ModelHelper.a(flatBufferBuilder, m14513j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -347817614)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class CollectionWithItemsOrRequestablesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionWithItemsAndSuggestions {
        @Nullable
        private String f13392d;
        @Nullable
        private CollectionsEligibleSuggestionsFieldsModel f13393e;
        @Nullable
        private String f13394f;
        @Nullable
        private CollectionItemConnectionWithFieldsModel f13395g;
        @Nullable
        private CollectionsAppSectionMediasetModel f13396h;
        @Nullable
        private String f13397i;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13398j;
        @Nullable
        private CollectionsAppSectionRequestableFieldsModel f13399k;
        @Nullable
        private List<GraphQLTimelineAppCollectionStyle> f13400l;
        private boolean f13401m;
        @Nullable
        private String f13402n;
        @Nullable
        private String f13403o;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionWithItemsOrRequestablesModel.class, new Deserializer());
            }

            public Object m14516a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionWithItemsOrRequestablesParser.m14641b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionWithItemsOrRequestablesModel = new CollectionWithItemsOrRequestablesModel();
                ((BaseModel) collectionWithItemsOrRequestablesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionWithItemsOrRequestablesModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionWithItemsOrRequestablesModel).a();
                }
                return collectionWithItemsOrRequestablesModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<CollectionWithItemsOrRequestablesModel> {
            public final void m14517a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) obj;
                if (collectionWithItemsOrRequestablesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionWithItemsOrRequestablesModel.m14520a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionWithItemsOrRequestablesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionWithItemsOrRequestablesParser.m14642b(collectionWithItemsOrRequestablesModel.w_(), collectionWithItemsOrRequestablesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionWithItemsOrRequestablesModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CollectionsAppSectionMediasetModel m14527g() {
            return m14518r();
        }

        @Nullable
        public final /* synthetic */ CollectionsAppSectionRequestableFieldsModel nT_() {
            return m14531m();
        }

        @Nullable
        public final /* synthetic */ CollectionItemConnectionWithFieldsModel nU_() {
            return m14530l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields mo403p() {
            return m14519s();
        }

        @Nullable
        public final /* synthetic */ CollectionsEligibleSuggestionsFieldsModel mo404q() {
            return m14529k();
        }

        public CollectionWithItemsOrRequestablesModel() {
            super(12);
        }

        @Nullable
        public final String mo397b() {
            this.f13392d = super.a(this.f13392d, 0);
            return this.f13392d;
        }

        @Nullable
        public final CollectionsEligibleSuggestionsFieldsModel m14529k() {
            this.f13393e = (CollectionsEligibleSuggestionsFieldsModel) super.a(this.f13393e, 1, CollectionsEligibleSuggestionsFieldsModel.class);
            return this.f13393e;
        }

        @Nullable
        public final String mo395c() {
            this.f13394f = super.a(this.f13394f, 2);
            return this.f13394f;
        }

        @Nullable
        public final CollectionItemConnectionWithFieldsModel m14530l() {
            this.f13395g = (CollectionItemConnectionWithFieldsModel) super.a(this.f13395g, 3, CollectionItemConnectionWithFieldsModel.class);
            return this.f13395g;
        }

        @Nullable
        private CollectionsAppSectionMediasetModel m14518r() {
            this.f13396h = (CollectionsAppSectionMediasetModel) super.a(this.f13396h, 4, CollectionsAppSectionMediasetModel.class);
            return this.f13396h;
        }

        @Nullable
        public final String nS_() {
            this.f13397i = super.a(this.f13397i, 5);
            return this.f13397i;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14519s() {
            this.f13398j = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13398j, 6, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13398j;
        }

        @Nullable
        public final CollectionsAppSectionRequestableFieldsModel m14531m() {
            this.f13399k = (CollectionsAppSectionRequestableFieldsModel) super.a(this.f13399k, 7, CollectionsAppSectionRequestableFieldsModel.class);
            return this.f13399k;
        }

        @Nonnull
        public final ImmutableList<GraphQLTimelineAppCollectionStyle> mo396d() {
            this.f13400l = super.c(this.f13400l, 8, GraphQLTimelineAppCollectionStyle.class);
            return (ImmutableList) this.f13400l;
        }

        public final boolean mo399n() {
            a(1, 1);
            return this.f13401m;
        }

        @Nullable
        public final String mo398j() {
            this.f13402n = super.a(this.f13402n, 10);
            return this.f13402n;
        }

        @Nullable
        public final String mo402o() {
            this.f13403o = super.a(this.f13403o, 11);
            return this.f13403o;
        }

        @Nullable
        public final String m14522a() {
            return mo395c();
        }

        public final int jK_() {
            return -1476137794;
        }

        public final GraphQLVisitableModel m14521a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14529k() != null) {
                CollectionsEligibleSuggestionsFieldsModel collectionsEligibleSuggestionsFieldsModel = (CollectionsEligibleSuggestionsFieldsModel) graphQLModelMutatingVisitor.b(m14529k());
                if (m14529k() != collectionsEligibleSuggestionsFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsOrRequestablesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13393e = collectionsEligibleSuggestionsFieldsModel;
                }
            }
            if (m14530l() != null) {
                CollectionItemConnectionWithFieldsModel collectionItemConnectionWithFieldsModel = (CollectionItemConnectionWithFieldsModel) graphQLModelMutatingVisitor.b(m14530l());
                if (m14530l() != collectionItemConnectionWithFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13395g = collectionItemConnectionWithFieldsModel;
                }
            }
            if (m14518r() != null) {
                CollectionsAppSectionMediasetModel collectionsAppSectionMediasetModel = (CollectionsAppSectionMediasetModel) graphQLModelMutatingVisitor.b(m14518r());
                if (m14518r() != collectionsAppSectionMediasetModel) {
                    graphQLVisitableModel = (CollectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13396h = collectionsAppSectionMediasetModel;
                }
            }
            if (m14519s() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14519s());
                if (m14519s() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13398j = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m14531m() != null) {
                CollectionsAppSectionRequestableFieldsModel collectionsAppSectionRequestableFieldsModel = (CollectionsAppSectionRequestableFieldsModel) graphQLModelMutatingVisitor.b(m14531m());
                if (m14531m() != collectionsAppSectionRequestableFieldsModel) {
                    graphQLVisitableModel = (CollectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13399k = collectionsAppSectionRequestableFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14520a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo397b());
            int a = ModelHelper.a(flatBufferBuilder, m14529k());
            int b2 = flatBufferBuilder.b(mo395c());
            int a2 = ModelHelper.a(flatBufferBuilder, m14530l());
            int a3 = ModelHelper.a(flatBufferBuilder, m14518r());
            int b3 = flatBufferBuilder.b(nS_());
            int a4 = ModelHelper.a(flatBufferBuilder, m14519s());
            int a5 = ModelHelper.a(flatBufferBuilder, m14531m());
            int d = flatBufferBuilder.d(mo396d());
            int b4 = flatBufferBuilder.b(mo398j());
            int b5 = flatBufferBuilder.b(mo402o());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, d);
            flatBufferBuilder.a(9, this.f13401m);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, b5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14523a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13401m = mutableFlatBuffer.a(i, 9);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1787905591)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class CollectionsAppSectionMediasetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f13404d;
        @Nullable
        private String f13405e;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsAppSectionMediasetModel.class, new Deserializer());
            }

            public Object m14536a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsAppSectionMediasetParser.m14643a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsAppSectionMediasetModel = new CollectionsAppSectionMediasetModel();
                ((BaseModel) collectionsAppSectionMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsAppSectionMediasetModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsAppSectionMediasetModel).a();
                }
                return collectionsAppSectionMediasetModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<CollectionsAppSectionMediasetModel> {
            public final void m14537a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsAppSectionMediasetModel collectionsAppSectionMediasetModel = (CollectionsAppSectionMediasetModel) obj;
                if (collectionsAppSectionMediasetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsAppSectionMediasetModel.m14539a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsAppSectionMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsAppSectionMediasetParser.m14644a(collectionsAppSectionMediasetModel.w_(), collectionsAppSectionMediasetModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CollectionsAppSectionMediasetModel.class, new Serializer());
            }
        }

        public CollectionsAppSectionMediasetModel() {
            super(2);
        }

        @Nullable
        private GraphQLObjectType m14538j() {
            if (this.b != null && this.f13404d == null) {
                this.f13404d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13404d;
        }

        @Nullable
        public final String m14542b() {
            this.f13405e = super.a(this.f13405e, 1);
            return this.f13405e;
        }

        @Nullable
        public final String m14541a() {
            return m14542b();
        }

        public final int jK_() {
            return -836141570;
        }

        public final GraphQLVisitableModel m14540a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14539a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14538j());
            int b = flatBufferBuilder.b(m14542b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 731015839)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class CollectionsAppSectionRequestableFieldModel extends BaseModel implements GraphQLVisitableModel {
        private InfoRequestFieldExtra f13410d;
        @Nullable
        private GraphQLInfoRequestFieldType f13411e;
        @Nullable
        private String f13412f;
        @Nullable
        private GraphQLInfoRequestFieldStatus f13413g;
        @Nullable
        private String f13414h;

        /* compiled from: MapView */
        public final class Builder {
            @Nullable
            public GraphQLInfoRequestFieldType f13406a;
            @Nullable
            public String f13407b;
            @Nullable
            public GraphQLInfoRequestFieldStatus f13408c;
            @Nullable
            public String f13409d;
        }

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsAppSectionRequestableFieldModel.class, new Deserializer());
            }

            public Object m14543a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsAppSectionRequestableFieldParser.m14646b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsAppSectionRequestableFieldModel = new CollectionsAppSectionRequestableFieldModel();
                ((BaseModel) collectionsAppSectionRequestableFieldModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsAppSectionRequestableFieldModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsAppSectionRequestableFieldModel).a();
                }
                return collectionsAppSectionRequestableFieldModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<CollectionsAppSectionRequestableFieldModel> {
            public final void m14544a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel = (CollectionsAppSectionRequestableFieldModel) obj;
                if (collectionsAppSectionRequestableFieldModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsAppSectionRequestableFieldModel.m14546a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsAppSectionRequestableFieldModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsAppSectionRequestableFieldParser.m14645a(collectionsAppSectionRequestableFieldModel.w_(), collectionsAppSectionRequestableFieldModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CollectionsAppSectionRequestableFieldModel.class, new Serializer());
            }
        }

        public final InfoRequestFieldExtra m14552j() {
            if (this.f13410d == null) {
                if (this.b == null || !this.b.d) {
                    this.f13410d = new InfoRequestFieldExtra();
                } else {
                    this.f13410d = (InfoRequestFieldExtra) this.b.a(this.c, this, InfoRequestFieldExtra.class);
                }
            }
            return this.f13410d;
        }

        public CollectionsAppSectionRequestableFieldModel() {
            super(4);
        }

        public CollectionsAppSectionRequestableFieldModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLInfoRequestFieldType m14547a() {
            this.f13411e = (GraphQLInfoRequestFieldType) super.b(this.f13411e, 0, GraphQLInfoRequestFieldType.class, GraphQLInfoRequestFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13411e;
        }

        @Nullable
        public final String m14549b() {
            this.f13412f = super.a(this.f13412f, 1);
            return this.f13412f;
        }

        @Nullable
        public final GraphQLInfoRequestFieldStatus m14550c() {
            this.f13413g = (GraphQLInfoRequestFieldStatus) super.b(this.f13413g, 2, GraphQLInfoRequestFieldStatus.class, GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13413g;
        }

        @Nullable
        public final String m14551d() {
            this.f13414h = super.a(this.f13414h, 3);
            return this.f13414h;
        }

        public static CollectionsAppSectionRequestableFieldModel m14545a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel) {
            if (collectionsAppSectionRequestableFieldModel == null) {
                return null;
            }
            if (collectionsAppSectionRequestableFieldModel instanceof CollectionsAppSectionRequestableFieldModel) {
                return collectionsAppSectionRequestableFieldModel;
            }
            Builder builder = new Builder();
            builder.f13406a = collectionsAppSectionRequestableFieldModel.m14547a();
            builder.f13407b = collectionsAppSectionRequestableFieldModel.m14549b();
            builder.f13408c = collectionsAppSectionRequestableFieldModel.m14550c();
            builder.f13409d = collectionsAppSectionRequestableFieldModel.m14551d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f13406a);
            int b = flatBufferBuilder.b(builder.f13407b);
            int a2 = flatBufferBuilder.a(builder.f13408c);
            int b2 = flatBufferBuilder.b(builder.f13409d);
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new CollectionsAppSectionRequestableFieldModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1373476967;
        }

        public final GraphQLVisitableModel m14548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14546a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m14547a());
            int b = flatBufferBuilder.b(m14549b());
            int a2 = flatBufferBuilder.a(m14550c());
            int b2 = flatBufferBuilder.b(m14551d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 837448005)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class CollectionsAppSectionRequestableFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<CollectionsAppSectionRequestableFieldModel> f13415d;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsAppSectionRequestableFieldsModel.class, new Deserializer());
            }

            public Object m14553a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsAppSectionRequestableFieldsParser.m14647a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsAppSectionRequestableFieldsModel = new CollectionsAppSectionRequestableFieldsModel();
                ((BaseModel) collectionsAppSectionRequestableFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsAppSectionRequestableFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsAppSectionRequestableFieldsModel).a();
                }
                return collectionsAppSectionRequestableFieldsModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<CollectionsAppSectionRequestableFieldsModel> {
            public final void m14554a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsAppSectionRequestableFieldsModel collectionsAppSectionRequestableFieldsModel = (CollectionsAppSectionRequestableFieldsModel) obj;
                if (collectionsAppSectionRequestableFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsAppSectionRequestableFieldsModel.m14555a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsAppSectionRequestableFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsAppSectionRequestableFieldsParser.m14648a(collectionsAppSectionRequestableFieldsModel.w_(), collectionsAppSectionRequestableFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionsAppSectionRequestableFieldsModel.class, new Serializer());
            }
        }

        public CollectionsAppSectionRequestableFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<CollectionsAppSectionRequestableFieldModel> m14557a() {
            this.f13415d = super.a(this.f13415d, 0, CollectionsAppSectionRequestableFieldModel.class);
            return (ImmutableList) this.f13415d;
        }

        public final int jK_() {
            return -962218376;
        }

        public final GraphQLVisitableModel m14556a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14557a() != null) {
                Builder a = ModelHelper.a(m14557a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CollectionsAppSectionRequestableFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13415d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14555a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14557a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1363597244)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class CollectionsAppSectionWithItemsOrRequestablesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionsAppSection {
        @Nullable
        private CollectionsModel f13419d;
        @Nullable
        private CollectionsNoItemsModel f13420e;
        @Nullable
        private CollectionsPeekFieldsModel f13421f;
        @Nullable
        private DefaultImageFieldsModel f13422g;
        @Nullable
        private String f13423h;
        @Nullable
        private String f13424i;
        @Nullable
        private GraphQLTimelineAppSectionType f13425j;
        @Nullable
        private String f13426k;
        @Nullable
        private SubtitleModel f13427l;
        @Nullable
        private TitleModel f13428m;
        @Nullable
        private String f13429n;
        @Nullable
        private String f13430o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 592460275)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MapView */
        public final class CollectionsModel extends BaseModel implements GraphQLVisitableModel {
            private int f13416d;
            @Nullable
            private List<CollectionWithItemsOrRequestablesModel> f13417e;

            /* compiled from: MapView */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CollectionsModel.class, new Deserializer());
                }

                public Object m14558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CollectionsParser.m14651a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object collectionsModel = new CollectionsModel();
                    ((BaseModel) collectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (collectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) collectionsModel).a();
                    }
                    return collectionsModel;
                }
            }

            /* compiled from: MapView */
            public class Serializer extends JsonSerializer<CollectionsModel> {
                public final void m14559a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CollectionsModel collectionsModel = (CollectionsModel) obj;
                    if (collectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(collectionsModel.m14560a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        collectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CollectionsParser.m14652a(collectionsModel.w_(), collectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CollectionsModel.class, new Serializer());
                }
            }

            public CollectionsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<CollectionWithItemsOrRequestablesModel> m14562a() {
                this.f13417e = super.a(this.f13417e, 1, CollectionWithItemsOrRequestablesModel.class);
                return (ImmutableList) this.f13417e;
            }

            public final int jK_() {
                return -306448333;
            }

            public final GraphQLVisitableModel m14561a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14562a() != null) {
                    Builder a = ModelHelper.a(m14562a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CollectionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13417e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14560a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14562a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f13416d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14563a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13416d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 131979838)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MapView */
        public final class CollectionsNoItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CollectionsNodeIdFieldsModel> f13418d;

            /* compiled from: MapView */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CollectionsNoItemsModel.class, new Deserializer());
                }

                public Object m14564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CollectionsNoItemsParser.m14649a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object collectionsNoItemsModel = new CollectionsNoItemsModel();
                    ((BaseModel) collectionsNoItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (collectionsNoItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) collectionsNoItemsModel).a();
                    }
                    return collectionsNoItemsModel;
                }
            }

            /* compiled from: MapView */
            public class Serializer extends JsonSerializer<CollectionsNoItemsModel> {
                public final void m14565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CollectionsNoItemsModel collectionsNoItemsModel = (CollectionsNoItemsModel) obj;
                    if (collectionsNoItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(collectionsNoItemsModel.m14566a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        collectionsNoItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CollectionsNoItemsParser.m14650a(collectionsNoItemsModel.w_(), collectionsNoItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CollectionsNoItemsModel.class, new Serializer());
                }
            }

            public CollectionsNoItemsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<CollectionsNodeIdFieldsModel> m14568a() {
                this.f13418d = super.a(this.f13418d, 0, CollectionsNodeIdFieldsModel.class);
                return (ImmutableList) this.f13418d;
            }

            public final int jK_() {
                return -306448333;
            }

            public final GraphQLVisitableModel m14567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14568a() != null) {
                    Builder a = ModelHelper.a(m14568a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CollectionsNoItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13418d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14566a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14568a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsAppSectionWithItemsOrRequestablesModel.class, new Deserializer());
            }

            public Object m14569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsAppSectionWithItemsOrRequestablesParser.m14653b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsAppSectionWithItemsOrRequestablesModel = new CollectionsAppSectionWithItemsOrRequestablesModel();
                ((BaseModel) collectionsAppSectionWithItemsOrRequestablesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsAppSectionWithItemsOrRequestablesModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsAppSectionWithItemsOrRequestablesModel).a();
                }
                return collectionsAppSectionWithItemsOrRequestablesModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<CollectionsAppSectionWithItemsOrRequestablesModel> {
            public final void m14570a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel = (CollectionsAppSectionWithItemsOrRequestablesModel) obj;
                if (collectionsAppSectionWithItemsOrRequestablesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsAppSectionWithItemsOrRequestablesModel.m14576a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsAppSectionWithItemsOrRequestablesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsAppSectionWithItemsOrRequestablesParser.m14654b(collectionsAppSectionWithItemsOrRequestablesModel.w_(), collectionsAppSectionWithItemsOrRequestablesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionsAppSectionWithItemsOrRequestablesModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo388b() {
            return m14573r();
        }

        @Nullable
        public final /* synthetic */ CollectionsModel m14583j() {
            return m14588o();
        }

        @Nullable
        public final /* synthetic */ CollectionsNoItemsModel m14584k() {
            return m14571p();
        }

        @Nullable
        public final /* synthetic */ CollectionsPeekFieldsModel m14585l() {
            return m14572q();
        }

        @Nullable
        public final /* synthetic */ SubtitleModel m14586m() {
            return m14574s();
        }

        @Nullable
        public final /* synthetic */ TitleModel m14587n() {
            return m14575t();
        }

        public CollectionsAppSectionWithItemsOrRequestablesModel() {
            super(12);
        }

        @Nullable
        public final CollectionsModel m14588o() {
            this.f13419d = (CollectionsModel) super.a(this.f13419d, 0, CollectionsModel.class);
            return this.f13419d;
        }

        @Nullable
        private CollectionsNoItemsModel m14571p() {
            this.f13420e = (CollectionsNoItemsModel) super.a(this.f13420e, 1, CollectionsNoItemsModel.class);
            return this.f13420e;
        }

        @Nullable
        private CollectionsPeekFieldsModel m14572q() {
            this.f13421f = (CollectionsPeekFieldsModel) super.a(this.f13421f, 2, CollectionsPeekFieldsModel.class);
            return this.f13421f;
        }

        @Nullable
        private DefaultImageFieldsModel m14573r() {
            this.f13422g = (DefaultImageFieldsModel) super.a(this.f13422g, 3, DefaultImageFieldsModel.class);
            return this.f13422g;
        }

        @Nullable
        public final String mo389c() {
            this.f13423h = super.a(this.f13423h, 4);
            return this.f13423h;
        }

        @Nullable
        public final String mo390d() {
            this.f13424i = super.a(this.f13424i, 5);
            return this.f13424i;
        }

        @Nullable
        public final GraphQLTimelineAppSectionType nP_() {
            this.f13425j = (GraphQLTimelineAppSectionType) super.b(this.f13425j, 6, GraphQLTimelineAppSectionType.class, GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13425j;
        }

        @Nullable
        public final String mo391g() {
            this.f13426k = super.a(this.f13426k, 7);
            return this.f13426k;
        }

        @Nullable
        private SubtitleModel m14574s() {
            this.f13427l = (SubtitleModel) super.a(this.f13427l, 8, SubtitleModel.class);
            return this.f13427l;
        }

        @Nullable
        private TitleModel m14575t() {
            this.f13428m = (TitleModel) super.a(this.f13428m, 9, TitleModel.class);
            return this.f13428m;
        }

        @Nullable
        public final String nQ_() {
            this.f13429n = super.a(this.f13429n, 10);
            return this.f13429n;
        }

        @Nullable
        public final String nR_() {
            this.f13430o = super.a(this.f13430o, 11);
            return this.f13430o;
        }

        @Nullable
        public final String m14578a() {
            return mo389c();
        }

        public final int jK_() {
            return 1842803909;
        }

        public final GraphQLVisitableModel m14577a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14588o() != null) {
                CollectionsModel collectionsModel = (CollectionsModel) graphQLModelMutatingVisitor.b(m14588o());
                if (m14588o() != collectionsModel) {
                    graphQLVisitableModel = (CollectionsAppSectionWithItemsOrRequestablesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13419d = collectionsModel;
                }
            }
            if (m14571p() != null) {
                CollectionsNoItemsModel collectionsNoItemsModel = (CollectionsNoItemsModel) graphQLModelMutatingVisitor.b(m14571p());
                if (m14571p() != collectionsNoItemsModel) {
                    graphQLVisitableModel = (CollectionsAppSectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13420e = collectionsNoItemsModel;
                }
            }
            if (m14572q() != null) {
                CollectionsPeekFieldsModel collectionsPeekFieldsModel = (CollectionsPeekFieldsModel) graphQLModelMutatingVisitor.b(m14572q());
                if (m14572q() != collectionsPeekFieldsModel) {
                    graphQLVisitableModel = (CollectionsAppSectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13421f = collectionsPeekFieldsModel;
                }
            }
            if (m14573r() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14573r());
                if (m14573r() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CollectionsAppSectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13422g = defaultImageFieldsModel;
                }
            }
            if (m14574s() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m14574s());
                if (m14574s() != subtitleModel) {
                    graphQLVisitableModel = (CollectionsAppSectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13427l = subtitleModel;
                }
            }
            if (m14575t() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14575t());
                if (m14575t() != titleModel) {
                    graphQLVisitableModel = (CollectionsAppSectionWithItemsOrRequestablesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13428m = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14576a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14588o());
            int a2 = ModelHelper.a(flatBufferBuilder, m14571p());
            int a3 = ModelHelper.a(flatBufferBuilder, m14572q());
            int a4 = ModelHelper.a(flatBufferBuilder, m14573r());
            int b = flatBufferBuilder.b(mo389c());
            int b2 = flatBufferBuilder.b(mo390d());
            int a5 = flatBufferBuilder.a(nP_());
            int b3 = flatBufferBuilder.b(mo391g());
            int a6 = ModelHelper.a(flatBufferBuilder, m14574s());
            int a7 = ModelHelper.a(flatBufferBuilder, m14575t());
            int b4 = flatBufferBuilder.b(nQ_());
            int b5 = flatBufferBuilder.b(nR_());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, b5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1735763009)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class TimelineAppSectionsStructuredNameModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<PartsModel> f13434d;
        @Nullable
        private String f13435e;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineAppSectionsStructuredNameModel.class, new Deserializer());
            }

            public Object m14589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineAppSectionsStructuredNameParser.m14657a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineAppSectionsStructuredNameModel = new TimelineAppSectionsStructuredNameModel();
                ((BaseModel) timelineAppSectionsStructuredNameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineAppSectionsStructuredNameModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineAppSectionsStructuredNameModel).a();
                }
                return timelineAppSectionsStructuredNameModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1501120714)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MapView */
        public final class PartsModel extends BaseModel implements GraphQLVisitableModel {
            private int f13431d;
            private int f13432e;
            @Nullable
            private GraphQLStructuredNamePart f13433f;

            /* compiled from: MapView */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PartsModel.class, new Deserializer());
                }

                public Object m14590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PartsParser.m14656b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object partsModel = new PartsModel();
                    ((BaseModel) partsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (partsModel instanceof Postprocessable) {
                        return ((Postprocessable) partsModel).a();
                    }
                    return partsModel;
                }
            }

            /* compiled from: MapView */
            public class Serializer extends JsonSerializer<PartsModel> {
                public final void m14591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PartsModel partsModel = (PartsModel) obj;
                    if (partsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(partsModel.m14593a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        partsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PartsParser.m14655a(partsModel.w_(), partsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PartsModel.class, new Serializer());
                }
            }

            public PartsModel() {
                super(3);
            }

            public final int m14592a() {
                a(0, 0);
                return this.f13431d;
            }

            public final int m14596b() {
                a(0, 1);
                return this.f13432e;
            }

            @Nullable
            public final GraphQLStructuredNamePart m14597c() {
                this.f13433f = (GraphQLStructuredNamePart) super.b(this.f13433f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f13433f;
            }

            public final int jK_() {
                return 1905097022;
            }

            public final GraphQLVisitableModel m14594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14593a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m14597c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f13431d, 0);
                flatBufferBuilder.a(1, this.f13432e, 0);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14595a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13431d = mutableFlatBuffer.a(i, 0, 0);
                this.f13432e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<TimelineAppSectionsStructuredNameModel> {
            public final void m14598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineAppSectionsStructuredNameModel timelineAppSectionsStructuredNameModel = (TimelineAppSectionsStructuredNameModel) obj;
                if (timelineAppSectionsStructuredNameModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineAppSectionsStructuredNameModel.m14599a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineAppSectionsStructuredNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineAppSectionsStructuredNameParser.m14658a(timelineAppSectionsStructuredNameModel.w_(), timelineAppSectionsStructuredNameModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineAppSectionsStructuredNameModel.class, new Serializer());
            }
        }

        public TimelineAppSectionsStructuredNameModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<PartsModel> m14601a() {
            this.f13434d = super.a(this.f13434d, 0, PartsModel.class);
            return (ImmutableList) this.f13434d;
        }

        @Nullable
        public final String m14602b() {
            this.f13435e = super.a(this.f13435e, 1);
            return this.f13435e;
        }

        public final int jK_() {
            return 2420395;
        }

        public final GraphQLVisitableModel m14600a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14601a() != null) {
                Builder a = ModelHelper.a(m14601a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TimelineAppSectionsStructuredNameModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13434d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14599a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14601a());
            int b = flatBufferBuilder.b(m14602b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1497054953)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class TimelineCollectionAppSectionsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<CollectionsAppSectionWithItemsOrRequestablesModel> f13438d;
        @Nullable
        private PageInfoModel f13439e;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineCollectionAppSectionsFieldsModel.class, new Deserializer());
            }

            public Object m14603a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineCollectionAppSectionsFieldsParser.m14661a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineCollectionAppSectionsFieldsModel = new TimelineCollectionAppSectionsFieldsModel();
                ((BaseModel) timelineCollectionAppSectionsFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineCollectionAppSectionsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineCollectionAppSectionsFieldsModel).a();
                }
                return timelineCollectionAppSectionsFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2005169142)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MapView */
        public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13436d;
            private boolean f13437e;

            /* compiled from: MapView */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                }

                public Object m14604a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageInfoParser.m14659a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageInfoModel = new PageInfoModel();
                    ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) pageInfoModel).a();
                    }
                    return pageInfoModel;
                }
            }

            /* compiled from: MapView */
            public class Serializer extends JsonSerializer<PageInfoModel> {
                public final void m14605a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageInfoModel pageInfoModel = (PageInfoModel) obj;
                    if (pageInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageInfoModel.m14606a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageInfoParser.m14660a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                }
            }

            public PageInfoModel() {
                super(2);
            }

            @Nullable
            public final String m14608a() {
                this.f13436d = super.a(this.f13436d, 0);
                return this.f13436d;
            }

            public final boolean m14610b() {
                a(0, 1);
                return this.f13437e;
            }

            public final int jK_() {
                return 923779069;
            }

            public final GraphQLVisitableModel m14607a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14606a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14608a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f13437e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14609a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13437e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<TimelineCollectionAppSectionsFieldsModel> {
            public final void m14611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineCollectionAppSectionsFieldsModel timelineCollectionAppSectionsFieldsModel = (TimelineCollectionAppSectionsFieldsModel) obj;
                if (timelineCollectionAppSectionsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineCollectionAppSectionsFieldsModel.m14612a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineCollectionAppSectionsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineCollectionAppSectionsFieldsParser.m14662a(timelineCollectionAppSectionsFieldsModel.w_(), timelineCollectionAppSectionsFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineCollectionAppSectionsFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PageInfoModel m14615b() {
            return m14616j();
        }

        public TimelineCollectionAppSectionsFieldsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<CollectionsAppSectionWithItemsOrRequestablesModel> m14614a() {
            this.f13438d = super.a(this.f13438d, 0, CollectionsAppSectionWithItemsOrRequestablesModel.class);
            return (ImmutableList) this.f13438d;
        }

        @Nullable
        public final PageInfoModel m14616j() {
            this.f13439e = (PageInfoModel) super.a(this.f13439e, 1, PageInfoModel.class);
            return this.f13439e;
        }

        public final int jK_() {
            return 420443596;
        }

        public final GraphQLVisitableModel m14613a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PageInfoModel pageInfoModel;
            h();
            if (m14614a() != null) {
                Builder a = ModelHelper.a(m14614a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    TimelineCollectionAppSectionsFieldsModel timelineCollectionAppSectionsFieldsModel = (TimelineCollectionAppSectionsFieldsModel) ModelHelper.a(null, this);
                    timelineCollectionAppSectionsFieldsModel.f13438d = a.b();
                    graphQLVisitableModel = timelineCollectionAppSectionsFieldsModel;
                    if (m14616j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m14616j());
                        if (m14616j() != pageInfoModel) {
                            graphQLVisitableModel = (TimelineCollectionAppSectionsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13439e = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14616j() != null) {
                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m14616j());
                if (m14616j() != pageInfoModel) {
                    graphQLVisitableModel = (TimelineCollectionAppSectionsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13439e = pageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14612a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14614a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14616j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -150725567)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class TimelineCollectionAppSectionsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private TimelineCollectionAppSectionsFieldsModel f13440d;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineCollectionAppSectionsModel.class, new Deserializer());
            }

            public Object m14617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineCollectionAppSectionsParser.m14663a(jsonParser);
                Object timelineCollectionAppSectionsModel = new TimelineCollectionAppSectionsModel();
                ((BaseModel) timelineCollectionAppSectionsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineCollectionAppSectionsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineCollectionAppSectionsModel).a();
                }
                return timelineCollectionAppSectionsModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<TimelineCollectionAppSectionsModel> {
            public final void m14618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineCollectionAppSectionsModel timelineCollectionAppSectionsModel = (TimelineCollectionAppSectionsModel) obj;
                if (timelineCollectionAppSectionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineCollectionAppSectionsModel.m14619a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineCollectionAppSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineCollectionAppSectionsModel.w_();
                int u_ = timelineCollectionAppSectionsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("timeline_collection_app_sections");
                    TimelineCollectionAppSectionsFieldsParser.m14662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineCollectionAppSectionsModel.class, new Serializer());
            }
        }

        public TimelineCollectionAppSectionsModel() {
            super(1);
        }

        public final void m14622a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14623a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final TimelineCollectionAppSectionsFieldsModel m14621a() {
            this.f13440d = (TimelineCollectionAppSectionsFieldsModel) super.a(this.f13440d, 0, TimelineCollectionAppSectionsFieldsModel.class);
            return this.f13440d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m14620a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14621a() != null) {
                TimelineCollectionAppSectionsFieldsModel timelineCollectionAppSectionsFieldsModel = (TimelineCollectionAppSectionsFieldsModel) graphQLModelMutatingVisitor.b(m14621a());
                if (m14621a() != timelineCollectionAppSectionsFieldsModel) {
                    graphQLVisitableModel = (TimelineCollectionAppSectionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13440d = timelineCollectionAppSectionsFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14619a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14621a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1097398158)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class TimelineMutualFriendFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultImageFieldsModel f13441d;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineMutualFriendFieldsModel.class, new Deserializer());
            }

            public Object m14624a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineMutualFriendFieldsParser.m14664b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineMutualFriendFieldsModel = new TimelineMutualFriendFieldsModel();
                ((BaseModel) timelineMutualFriendFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineMutualFriendFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineMutualFriendFieldsModel).a();
                }
                return timelineMutualFriendFieldsModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<TimelineMutualFriendFieldsModel> {
            public final void m14625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineMutualFriendFieldsModel timelineMutualFriendFieldsModel = (TimelineMutualFriendFieldsModel) obj;
                if (timelineMutualFriendFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineMutualFriendFieldsModel.m14627a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineMutualFriendFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineMutualFriendFieldsParser.m14665b(timelineMutualFriendFieldsModel.w_(), timelineMutualFriendFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineMutualFriendFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m14628a() {
            return m14626j();
        }

        public TimelineMutualFriendFieldsModel() {
            super(1);
        }

        public final void m14630a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14631a(String str, Object obj, boolean z) {
        }

        @Nullable
        private DefaultImageFieldsModel m14626j() {
            this.f13441d = (DefaultImageFieldsModel) super.a(this.f13441d, 0, DefaultImageFieldsModel.class);
            return this.f13441d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m14629a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14626j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14626j());
                if (m14626j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TimelineMutualFriendFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13441d = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14627a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14626j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2032980950)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MapView */
    public final class TimelineMutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
        private int f13442d;
        @Nullable
        private List<TimelineMutualFriendFieldsModel> f13443e;

        /* compiled from: MapView */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineMutualFriendsModel.class, new Deserializer());
            }

            public Object m14632a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineMutualFriendsParser.m14666a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineMutualFriendsModel = new TimelineMutualFriendsModel();
                ((BaseModel) timelineMutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineMutualFriendsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineMutualFriendsModel).a();
                }
                return timelineMutualFriendsModel;
            }
        }

        /* compiled from: MapView */
        public class Serializer extends JsonSerializer<TimelineMutualFriendsModel> {
            public final void m14633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineMutualFriendsModel timelineMutualFriendsModel = (TimelineMutualFriendsModel) obj;
                if (timelineMutualFriendsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineMutualFriendsModel.m14635a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineMutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineMutualFriendsParser.m14667a(timelineMutualFriendsModel.w_(), timelineMutualFriendsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineMutualFriendsModel.class, new Serializer());
            }
        }

        public TimelineMutualFriendsModel() {
            super(2);
        }

        public final int m14634a() {
            a(0, 0);
            return this.f13442d;
        }

        @Nonnull
        public final ImmutableList<TimelineMutualFriendFieldsModel> m14638b() {
            this.f13443e = super.a(this.f13443e, 1, TimelineMutualFriendFieldsModel.class);
            return (ImmutableList) this.f13443e;
        }

        public final int jK_() {
            return 1532278911;
        }

        public final GraphQLVisitableModel m14636a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14638b() != null) {
                Builder a = ModelHelper.a(m14638b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TimelineMutualFriendsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13443e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14635a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14638b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f13442d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14637a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13442d = mutableFlatBuffer.a(i, 0, 0);
        }
    }
}
