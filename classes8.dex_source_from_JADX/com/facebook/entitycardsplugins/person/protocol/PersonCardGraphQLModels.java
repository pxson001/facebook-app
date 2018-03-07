package com.facebook.entitycardsplugins.person.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextItemNodeParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextItemNodeParser.AlbumParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextItemParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextItemParser.ApplicationParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextItemParser.BadgeCountParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextUserFieldsParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardContextUserFieldsParser.TimelineContextItemsParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardCoverPhotoFieldsParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardCoverPhotoFieldsParser.PhotoParser;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLParsers.PersonCardParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLInterfaces.TimelineHeaderActionFields;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLModels.TimelineHeaderActionFieldsModel.FriendsModel;
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

/* compiled from: hint */
public class PersonCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1117714960)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: hint */
    public final class PersonCardContextItemModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ApplicationModel f11169d;
        @Nullable
        private BadgeCountModel f11170e;
        @Nullable
        private DefaultImageFieldsModel f11171f;
        @Nullable
        private DefaultImageFieldsModel f11172g;
        @Nullable
        private PersonCardContextItemNodeModel f11173h;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f11174i;
        @Nullable
        private GraphQLTimelineContextListTargetType f11175j;
        private long f11176k;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f11177l;
        @Nullable
        private GraphQLTimelineContextListItemType f11178m;
        @Nullable
        private String f11179n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: hint */
        public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f11166d;
            @Nullable
            private String f11167e;

            /* compiled from: hint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                }

                public Object m13098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ApplicationParser.m13217a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object applicationModel = new ApplicationModel();
                    ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (applicationModel instanceof Postprocessable) {
                        return ((Postprocessable) applicationModel).a();
                    }
                    return applicationModel;
                }
            }

            /* compiled from: hint */
            public class Serializer extends JsonSerializer<ApplicationModel> {
                public final void m13099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ApplicationModel applicationModel = (ApplicationModel) obj;
                    if (applicationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(applicationModel.m13101a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ApplicationParser.m13218a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                }
            }

            public ApplicationModel() {
                super(2);
            }

            @Nullable
            private String m13100k() {
                this.f11166d = super.a(this.f11166d, 0);
                return this.f11166d;
            }

            @Nullable
            public final String m13104j() {
                this.f11167e = super.a(this.f11167e, 1);
                return this.f11167e;
            }

            @Nullable
            public final String m13103a() {
                return m13100k();
            }

            public final int jK_() {
                return -1072845520;
            }

            public final GraphQLVisitableModel m13102a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13101a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13100k());
                int b2 = flatBufferBuilder.b(m13104j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: hint */
        public final class BadgeCountModel extends BaseModel implements GraphQLVisitableModel {
            private int f11168d;

            /* compiled from: hint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BadgeCountModel.class, new Deserializer());
                }

                public Object m13105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BadgeCountParser.m13219a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object badgeCountModel = new BadgeCountModel();
                    ((BaseModel) badgeCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (badgeCountModel instanceof Postprocessable) {
                        return ((Postprocessable) badgeCountModel).a();
                    }
                    return badgeCountModel;
                }
            }

            /* compiled from: hint */
            public class Serializer extends JsonSerializer<BadgeCountModel> {
                public final void m13106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BadgeCountModel badgeCountModel = (BadgeCountModel) obj;
                    if (badgeCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(badgeCountModel.m13108a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        badgeCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BadgeCountParser.m13220a(badgeCountModel.w_(), badgeCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BadgeCountModel.class, new Serializer());
                }
            }

            public BadgeCountModel() {
                super(1);
            }

            public final int m13107a() {
                a(0, 0);
                return this.f11168d;
            }

            public final int jK_() {
                return 382256763;
            }

            public final GraphQLVisitableModel m13109a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13108a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f11168d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m13110a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11168d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: hint */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonCardContextItemModel.class, new Deserializer());
            }

            public Object m13111a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PersonCardContextItemParser.m13221b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object personCardContextItemModel = new PersonCardContextItemModel();
                ((BaseModel) personCardContextItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (personCardContextItemModel instanceof Postprocessable) {
                    return ((Postprocessable) personCardContextItemModel).a();
                }
                return personCardContextItemModel;
            }
        }

        /* compiled from: hint */
        public class Serializer extends JsonSerializer<PersonCardContextItemModel> {
            public final void m13112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PersonCardContextItemModel personCardContextItemModel = (PersonCardContextItemModel) obj;
                if (personCardContextItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personCardContextItemModel.m13113a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personCardContextItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PersonCardContextItemParser.m13222b(personCardContextItemModel.w_(), personCardContextItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PersonCardContextItemModel.class, new Serializer());
            }
        }

        public PersonCardContextItemModel() {
            super(11);
        }

        @Nullable
        public final ApplicationModel m13114a() {
            this.f11169d = (ApplicationModel) super.a(this.f11169d, 0, ApplicationModel.class);
            return this.f11169d;
        }

        @Nullable
        public final BadgeCountModel m13117j() {
            this.f11170e = (BadgeCountModel) super.a(this.f11170e, 1, BadgeCountModel.class);
            return this.f11170e;
        }

        @Nullable
        public final DefaultImageFieldsModel m13118k() {
            this.f11171f = (DefaultImageFieldsModel) super.a(this.f11171f, 2, DefaultImageFieldsModel.class);
            return this.f11171f;
        }

        @Nullable
        public final DefaultImageFieldsModel m13119l() {
            this.f11172g = (DefaultImageFieldsModel) super.a(this.f11172g, 3, DefaultImageFieldsModel.class);
            return this.f11172g;
        }

        @Nullable
        public final PersonCardContextItemNodeModel m13120m() {
            this.f11173h = (PersonCardContextItemNodeModel) super.a(this.f11173h, 4, PersonCardContextItemNodeModel.class);
            return this.f11173h;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m13121n() {
            this.f11174i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11174i, 5, DefaultTextWithEntitiesFieldsModel.class);
            return this.f11174i;
        }

        @Nullable
        public final GraphQLTimelineContextListTargetType m13122o() {
            this.f11175j = (GraphQLTimelineContextListTargetType) super.b(this.f11175j, 6, GraphQLTimelineContextListTargetType.class, GraphQLTimelineContextListTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11175j;
        }

        public final long m13123p() {
            a(0, 7);
            return this.f11176k;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m13124q() {
            this.f11177l = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f11177l, 8, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f11177l;
        }

        @Nullable
        public final GraphQLTimelineContextListItemType m13125r() {
            this.f11178m = (GraphQLTimelineContextListItemType) super.b(this.f11178m, 9, GraphQLTimelineContextListItemType.class, GraphQLTimelineContextListItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11178m;
        }

        @Nullable
        public final String m13126s() {
            this.f11179n = super.a(this.f11179n, 10);
            return this.f11179n;
        }

        public final int jK_() {
            return -2140001025;
        }

        public final GraphQLVisitableModel m13115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13114a() != null) {
                ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m13114a());
                if (m13114a() != applicationModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11169d = applicationModel;
                }
            }
            if (m13117j() != null) {
                BadgeCountModel badgeCountModel = (BadgeCountModel) graphQLModelMutatingVisitor.b(m13117j());
                if (m13117j() != badgeCountModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11170e = badgeCountModel;
                }
            }
            if (m13118k() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13118k());
                if (m13118k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11171f = defaultImageFieldsModel;
                }
            }
            if (m13119l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13119l());
                if (m13119l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11172g = defaultImageFieldsModel;
                }
            }
            if (m13120m() != null) {
                PersonCardContextItemNodeModel personCardContextItemNodeModel = (PersonCardContextItemNodeModel) graphQLModelMutatingVisitor.b(m13120m());
                if (m13120m() != personCardContextItemNodeModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11173h = personCardContextItemNodeModel;
                }
            }
            if (m13121n() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m13121n());
                if (m13121n() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11174i = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m13124q() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m13124q());
                if (m13124q() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PersonCardContextItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11177l = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13113a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13114a());
            int a2 = ModelHelper.a(flatBufferBuilder, m13117j());
            int a3 = ModelHelper.a(flatBufferBuilder, m13118k());
            int a4 = ModelHelper.a(flatBufferBuilder, m13119l());
            int a5 = ModelHelper.a(flatBufferBuilder, m13120m());
            int a6 = ModelHelper.a(flatBufferBuilder, m13121n());
            int a7 = flatBufferBuilder.a(m13122o());
            int a8 = ModelHelper.a(flatBufferBuilder, m13124q());
            int a9 = flatBufferBuilder.a(m13125r());
            int b = flatBufferBuilder.b(m13126s());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            flatBufferBuilder.a(7, this.f11176k, 0);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.b(10, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13116a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11176k = mutableFlatBuffer.a(i, 7, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1097248576)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: hint */
    public final class PersonCardContextItemNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f11181d;
        @Nullable
        private AlbumModel f11182e;
        @Nullable
        private String f11183f;
        private boolean f11184g;
        private long f11185h;
        @Nullable
        private String f11186i;
        @Nullable
        private DefaultImageFieldsModel f11187j;
        private boolean f11188k;
        @Nullable
        private String f11189l;
        private long f11190m;
        @Nullable
        private String f11191n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: hint */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f11180d;

            /* compiled from: hint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m13127a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m13213a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object albumModel = new AlbumModel();
                    ((BaseModel) albumModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (albumModel instanceof Postprocessable) {
                        return ((Postprocessable) albumModel).a();
                    }
                    return albumModel;
                }
            }

            /* compiled from: hint */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m13128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m13129a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m13214a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            @Nullable
            public final String m13132j() {
                this.f11180d = super.a(this.f11180d, 0);
                return this.f11180d;
            }

            @Nullable
            public final String m13131a() {
                return m13132j();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m13130a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13129a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13132j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: hint */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonCardContextItemNodeModel.class, new Deserializer());
            }

            public Object m13133a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PersonCardContextItemNodeParser.m13215a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object personCardContextItemNodeModel = new PersonCardContextItemNodeModel();
                ((BaseModel) personCardContextItemNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (personCardContextItemNodeModel instanceof Postprocessable) {
                    return ((Postprocessable) personCardContextItemNodeModel).a();
                }
                return personCardContextItemNodeModel;
            }
        }

        /* compiled from: hint */
        public class Serializer extends JsonSerializer<PersonCardContextItemNodeModel> {
            public final void m13134a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PersonCardContextItemNodeModel personCardContextItemNodeModel = (PersonCardContextItemNodeModel) obj;
                if (personCardContextItemNodeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personCardContextItemNodeModel.m13139a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personCardContextItemNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PersonCardContextItemNodeParser.m13216a(personCardContextItemNodeModel.w_(), personCardContextItemNodeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PersonCardContextItemNodeModel.class, new Serializer());
            }
        }

        public PersonCardContextItemNodeModel() {
            super(11);
        }

        public final void m13143a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13144a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m13135m() {
            if (this.b != null && this.f11181d == null) {
                this.f11181d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11181d;
        }

        @Nullable
        public final AlbumModel m13145j() {
            this.f11182e = (AlbumModel) super.a(this.f11182e, 1, AlbumModel.class);
            return this.f11182e;
        }

        @Nullable
        private String m13136n() {
            this.f11183f = super.a(this.f11183f, 2);
            return this.f11183f;
        }

        @Nullable
        public final String m13146k() {
            this.f11186i = super.a(this.f11186i, 5);
            return this.f11186i;
        }

        @Nullable
        public final DefaultImageFieldsModel m13147l() {
            this.f11187j = (DefaultImageFieldsModel) super.a(this.f11187j, 6, DefaultImageFieldsModel.class);
            return this.f11187j;
        }

        @Nullable
        private String m13137o() {
            this.f11189l = super.a(this.f11189l, 8);
            return this.f11189l;
        }

        @Nullable
        private String m13138p() {
            this.f11191n = super.a(this.f11191n, 10);
            return this.f11191n;
        }

        @Nullable
        public final String m13141a() {
            return m13146k();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m13140a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13145j() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m13145j());
                if (m13145j() != albumModel) {
                    graphQLVisitableModel = (PersonCardContextItemNodeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11182e = albumModel;
                }
            }
            if (m13147l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13147l());
                if (m13147l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PersonCardContextItemNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11187j = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13139a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13135m());
            int a2 = ModelHelper.a(flatBufferBuilder, m13145j());
            int b = flatBufferBuilder.b(m13136n());
            int b2 = flatBufferBuilder.b(m13146k());
            int a3 = ModelHelper.a(flatBufferBuilder, m13147l());
            int b3 = flatBufferBuilder.b(m13137o());
            int b4 = flatBufferBuilder.b(m13138p());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f11184g);
            flatBufferBuilder.a(4, this.f11185h, 0);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.a(7, this.f11188k);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.a(9, this.f11190m, 0);
            flatBufferBuilder.b(10, b4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13142a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11184g = mutableFlatBuffer.a(i, 3);
            this.f11185h = mutableFlatBuffer.a(i, 4, 0);
            this.f11188k = mutableFlatBuffer.a(i, 7);
            this.f11190m = mutableFlatBuffer.a(i, 9, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1674750894)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: hint */
    public final class PersonCardContextUserFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private TimelineContextItemsModel f11194d;

        /* compiled from: hint */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonCardContextUserFieldsModel.class, new Deserializer());
            }

            public Object m13148a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PersonCardContextUserFieldsParser.m13225a(jsonParser);
                Object personCardContextUserFieldsModel = new PersonCardContextUserFieldsModel();
                ((BaseModel) personCardContextUserFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (personCardContextUserFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) personCardContextUserFieldsModel).a();
                }
                return personCardContextUserFieldsModel;
            }
        }

        /* compiled from: hint */
        public class Serializer extends JsonSerializer<PersonCardContextUserFieldsModel> {
            public final void m13149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PersonCardContextUserFieldsModel personCardContextUserFieldsModel = (PersonCardContextUserFieldsModel) obj;
                if (personCardContextUserFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personCardContextUserFieldsModel.m13157a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personCardContextUserFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = personCardContextUserFieldsModel.w_();
                int u_ = personCardContextUserFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("timeline_context_items");
                    TimelineContextItemsParser.m13224a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PersonCardContextUserFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 774963689)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: hint */
        public final class TimelineContextItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PersonCardContextItemModel> f11192d;
            @Nullable
            private DefaultPageInfoFieldsModel f11193e;

            /* compiled from: hint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TimelineContextItemsModel.class, new Deserializer());
                }

                public Object m13150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TimelineContextItemsParser.m13223a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object timelineContextItemsModel = new TimelineContextItemsModel();
                    ((BaseModel) timelineContextItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (timelineContextItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) timelineContextItemsModel).a();
                    }
                    return timelineContextItemsModel;
                }
            }

            /* compiled from: hint */
            public class Serializer extends JsonSerializer<TimelineContextItemsModel> {
                public final void m13151a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) obj;
                    if (timelineContextItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(timelineContextItemsModel.m13153a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        timelineContextItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TimelineContextItemsParser.m13224a(timelineContextItemsModel.w_(), timelineContextItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TimelineContextItemsModel.class, new Serializer());
                }
            }

            public TimelineContextItemsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PersonCardContextItemModel> m13155a() {
                this.f11192d = super.a(this.f11192d, 0, PersonCardContextItemModel.class);
                return (ImmutableList) this.f11192d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m13152j() {
                this.f11193e = (DefaultPageInfoFieldsModel) super.a(this.f11193e, 1, DefaultPageInfoFieldsModel.class);
                return this.f11193e;
            }

            public final int jK_() {
                return -2113882798;
            }

            public final GraphQLVisitableModel m13154a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m13155a() != null) {
                    Builder a = ModelHelper.a(m13155a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) ModelHelper.a(null, this);
                        timelineContextItemsModel.f11192d = a.b();
                        graphQLVisitableModel = timelineContextItemsModel;
                        if (m13152j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m13152j());
                            if (m13152j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (TimelineContextItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11193e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13152j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m13152j());
                    if (m13152j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (TimelineContextItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11193e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13153a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13155a());
                int a2 = ModelHelper.a(flatBufferBuilder, m13152j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PersonCardContextUserFieldsModel() {
            super(1);
        }

        public final void m13159a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13160a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TimelineContextItemsModel m13156a() {
            this.f11194d = (TimelineContextItemsModel) super.a(this.f11194d, 0, TimelineContextItemsModel.class);
            return this.f11194d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m13158a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13156a() != null) {
                TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) graphQLModelMutatingVisitor.b(m13156a());
                if (m13156a() != timelineContextItemsModel) {
                    graphQLVisitableModel = (PersonCardContextUserFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11194d = timelineContextItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13157a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13156a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -965655987)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: hint */
    public final class PersonCardCoverPhotoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultVect2FieldsModel f11198d;
        @Nullable
        private PhotoModel f11199e;

        /* compiled from: hint */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonCardCoverPhotoFieldsModel.class, new Deserializer());
            }

            public Object m13161a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PersonCardCoverPhotoFieldsParser.m13228a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object personCardCoverPhotoFieldsModel = new PersonCardCoverPhotoFieldsModel();
                ((BaseModel) personCardCoverPhotoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (personCardCoverPhotoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) personCardCoverPhotoFieldsModel).a();
                }
                return personCardCoverPhotoFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -540550301)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: hint */
        public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f11195d;
            @Nullable
            private DefaultImageFieldsModel f11196e;
            @Nullable
            private String f11197f;

            /* compiled from: hint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m13162a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m13226a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoModel = new PhotoModel();
                    ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoModel instanceof Postprocessable) {
                        return ((Postprocessable) photoModel).a();
                    }
                    return photoModel;
                }
            }

            /* compiled from: hint */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m13163a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m13165a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m13227a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            public PhotoModel() {
                super(3);
            }

            @Nullable
            private String m13164l() {
                this.f11195d = super.a(this.f11195d, 0);
                return this.f11195d;
            }

            @Nullable
            public final DefaultImageFieldsModel m13168j() {
                this.f11196e = (DefaultImageFieldsModel) super.a(this.f11196e, 1, DefaultImageFieldsModel.class);
                return this.f11196e;
            }

            @Nullable
            public final String m13169k() {
                this.f11197f = super.a(this.f11197f, 2);
                return this.f11197f;
            }

            @Nullable
            public final String m13167a() {
                return m13164l();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m13166a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13168j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13168j());
                    if (m13168j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11196e = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13165a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13164l());
                int a = ModelHelper.a(flatBufferBuilder, m13168j());
                int b2 = flatBufferBuilder.b(m13169k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: hint */
        public class Serializer extends JsonSerializer<PersonCardCoverPhotoFieldsModel> {
            public final void m13170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PersonCardCoverPhotoFieldsModel personCardCoverPhotoFieldsModel = (PersonCardCoverPhotoFieldsModel) obj;
                if (personCardCoverPhotoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personCardCoverPhotoFieldsModel.m13171a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personCardCoverPhotoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PersonCardCoverPhotoFieldsParser.m13229a(personCardCoverPhotoFieldsModel.w_(), personCardCoverPhotoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PersonCardCoverPhotoFieldsModel.class, new Serializer());
            }
        }

        public PersonCardCoverPhotoFieldsModel() {
            super(2);
        }

        @Nullable
        public final DefaultVect2FieldsModel m13172a() {
            this.f11198d = (DefaultVect2FieldsModel) super.a(this.f11198d, 0, DefaultVect2FieldsModel.class);
            return this.f11198d;
        }

        @Nullable
        public final PhotoModel m13174j() {
            this.f11199e = (PhotoModel) super.a(this.f11199e, 1, PhotoModel.class);
            return this.f11199e;
        }

        public final int jK_() {
            return 497264923;
        }

        public final GraphQLVisitableModel m13173a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13172a() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m13172a());
                if (m13172a() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (PersonCardCoverPhotoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11198d = defaultVect2FieldsModel;
                }
            }
            if (m13174j() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m13174j());
                if (m13174j() != photoModel) {
                    graphQLVisitableModel = (PersonCardCoverPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11199e = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13171a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13172a());
            int a2 = ModelHelper.a(flatBufferBuilder, m13174j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1303514190)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: hint */
    public final class PersonCardModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, TimelineHeaderActionFields {
        @Nullable
        private String f11223d;
        private boolean f11224e;
        private boolean f11225f;
        private boolean f11226g;
        private boolean f11227h;
        private boolean f11228i;
        private boolean f11229j;
        @Nullable
        private PersonCardCoverPhotoFieldsModel f11230k;
        @Nullable
        private FriendsModel f11231l;
        @Nullable
        private GraphQLFriendshipStatus f11232m;
        @Nullable
        private String f11233n;
        private boolean f11234o;
        private boolean f11235p;
        private boolean f11236q;
        @Nullable
        private String f11237r;
        @Nullable
        private ComposerTargetDataPrivacyScopeFieldsModel f11238s;
        @Nullable
        private DefaultImageFieldsModel f11239t;
        @Nullable
        private DefaultImageFieldsModel f11240u;
        private boolean f11241v;
        @Nullable
        private GraphQLSecondarySubscribeStatus f11242w;
        @Nullable
        private DefaultNameFieldsModel f11243x;
        @Nullable
        private GraphQLSubscribeStatus f11244y;
        @Nullable
        private TimelineContextItemsModel f11245z;

        /* compiled from: hint */
        public final class Builder {
            @Nullable
            public String f11200a;
            public boolean f11201b;
            public boolean f11202c;
            public boolean f11203d;
            public boolean f11204e;
            public boolean f11205f;
            public boolean f11206g;
            @Nullable
            public PersonCardCoverPhotoFieldsModel f11207h;
            @Nullable
            public FriendsModel f11208i;
            @Nullable
            public GraphQLFriendshipStatus f11209j;
            @Nullable
            public String f11210k;
            public boolean f11211l;
            public boolean f11212m;
            public boolean f11213n;
            @Nullable
            public String f11214o;
            @Nullable
            public ComposerTargetDataPrivacyScopeFieldsModel f11215p;
            @Nullable
            public DefaultImageFieldsModel f11216q;
            @Nullable
            public DefaultImageFieldsModel f11217r;
            public boolean f11218s;
            @Nullable
            public GraphQLSecondarySubscribeStatus f11219t;
            @Nullable
            public DefaultNameFieldsModel f11220u;
            @Nullable
            public GraphQLSubscribeStatus f11221v;
            @Nullable
            public TimelineContextItemsModel f11222w;

            public static Builder m13175a(PersonCardModel personCardModel) {
                Builder builder = new Builder();
                builder.f11200a = personCardModel.m13201o();
                builder.f11201b = personCardModel.m13192b();
                builder.f11202c = personCardModel.m13193c();
                builder.f11203d = personCardModel.m13194d();
                builder.f11204e = personCardModel.do_();
                builder.f11205f = personCardModel.m13195g();
                builder.f11206g = personCardModel.dp_();
                builder.f11207h = personCardModel.m13202p();
                builder.f11208i = personCardModel.m13203q();
                builder.f11209j = personCardModel.m13196j();
                builder.f11210k = personCardModel.m13204r();
                builder.f11211l = personCardModel.m13197k();
                builder.f11212m = personCardModel.m13205s();
                builder.f11213n = personCardModel.m13206t();
                builder.f11214o = personCardModel.m13207u();
                builder.f11215p = personCardModel.m13208v();
                builder.f11216q = personCardModel.m13209w();
                builder.f11217r = personCardModel.m13210x();
                builder.f11218s = personCardModel.m13211y();
                builder.f11219t = personCardModel.m13199m();
                builder.f11220u = personCardModel.m13212z();
                builder.f11221v = personCardModel.m13200n();
                builder.f11222w = personCardModel.m13185A();
                return builder;
            }

            public final PersonCardModel m13176a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f11200a);
                int a = ModelHelper.a(flatBufferBuilder, this.f11207h);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11208i);
                int a3 = flatBufferBuilder.a(this.f11209j);
                int b2 = flatBufferBuilder.b(this.f11210k);
                int b3 = flatBufferBuilder.b(this.f11214o);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f11215p);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f11216q);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f11217r);
                int a7 = flatBufferBuilder.a(this.f11219t);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f11220u);
                int a9 = flatBufferBuilder.a(this.f11221v);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f11222w);
                flatBufferBuilder.c(23);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f11201b);
                flatBufferBuilder.a(2, this.f11202c);
                flatBufferBuilder.a(3, this.f11203d);
                flatBufferBuilder.a(4, this.f11204e);
                flatBufferBuilder.a(5, this.f11205f);
                flatBufferBuilder.a(6, this.f11206g);
                flatBufferBuilder.b(7, a);
                flatBufferBuilder.b(8, a2);
                flatBufferBuilder.b(9, a3);
                flatBufferBuilder.b(10, b2);
                flatBufferBuilder.a(11, this.f11211l);
                flatBufferBuilder.a(12, this.f11212m);
                flatBufferBuilder.a(13, this.f11213n);
                flatBufferBuilder.b(14, b3);
                flatBufferBuilder.b(15, a4);
                flatBufferBuilder.b(16, a5);
                flatBufferBuilder.b(17, a6);
                flatBufferBuilder.a(18, this.f11218s);
                flatBufferBuilder.b(19, a7);
                flatBufferBuilder.b(20, a8);
                flatBufferBuilder.b(21, a9);
                flatBufferBuilder.b(22, a10);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PersonCardModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: hint */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PersonCardModel.class, new Deserializer());
            }

            public Object m13177a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PersonCardParser.m13230a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object personCardModel = new PersonCardModel();
                ((BaseModel) personCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (personCardModel instanceof Postprocessable) {
                    return ((Postprocessable) personCardModel).a();
                }
                return personCardModel;
            }
        }

        /* compiled from: hint */
        public class Serializer extends JsonSerializer<PersonCardModel> {
            public final void m13178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PersonCardModel personCardModel = (PersonCardModel) obj;
                if (personCardModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(personCardModel.m13186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    personCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PersonCardParser.m13231a(personCardModel.w_(), personCardModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PersonCardModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FriendsModel dq_() {
            return m13203q();
        }

        @Nullable
        public final /* synthetic */ ComposerTargetDataPrivacyScopeFields m13198l() {
            return m13208v();
        }

        public PersonCardModel() {
            super(23);
        }

        public PersonCardModel(MutableFlatBuffer mutableFlatBuffer) {
            super(23);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m13190a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_message".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m13194d());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("can_viewer_poke".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(do_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
            } else if ("can_viewer_post".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m13195g());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("friendship_status".equals(str)) {
                consistencyTuple.a = m13196j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 9;
            } else if ("secondary_subscribe_status".equals(str)) {
                consistencyTuple.a = m13199m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 19;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m13200n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 21;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m13191a(String str, Object obj, boolean z) {
            if ("can_viewer_message".equals(str)) {
                m13182a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_poke".equals(str)) {
                m13183b(((Boolean) obj).booleanValue());
            } else if ("can_viewer_post".equals(str)) {
                m13184c(((Boolean) obj).booleanValue());
            } else if ("friendship_status".equals(str)) {
                m13179a((GraphQLFriendshipStatus) obj);
            } else if ("secondary_subscribe_status".equals(str)) {
                m13180a((GraphQLSecondarySubscribeStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m13181a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        public final String m13201o() {
            this.f11223d = super.a(this.f11223d, 0);
            return this.f11223d;
        }

        public final boolean m13192b() {
            a(0, 1);
            return this.f11224e;
        }

        public final boolean m13193c() {
            a(0, 2);
            return this.f11225f;
        }

        public final boolean m13194d() {
            a(0, 3);
            return this.f11226g;
        }

        private void m13182a(boolean z) {
            this.f11226g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        public final boolean do_() {
            a(0, 4);
            return this.f11227h;
        }

        private void m13183b(boolean z) {
            this.f11227h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        public final boolean m13195g() {
            a(0, 5);
            return this.f11228i;
        }

        private void m13184c(boolean z) {
            this.f11228i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean dp_() {
            a(0, 6);
            return this.f11229j;
        }

        @Nullable
        public final PersonCardCoverPhotoFieldsModel m13202p() {
            this.f11230k = (PersonCardCoverPhotoFieldsModel) super.a(this.f11230k, 7, PersonCardCoverPhotoFieldsModel.class);
            return this.f11230k;
        }

        @Nullable
        public final FriendsModel m13203q() {
            this.f11231l = (FriendsModel) super.a(this.f11231l, 8, FriendsModel.class);
            return this.f11231l;
        }

        @Nullable
        public final GraphQLFriendshipStatus m13196j() {
            this.f11232m = (GraphQLFriendshipStatus) super.b(this.f11232m, 9, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11232m;
        }

        private void m13179a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f11232m = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 9, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m13204r() {
            this.f11233n = super.a(this.f11233n, 10);
            return this.f11233n;
        }

        public final boolean m13197k() {
            a(1, 3);
            return this.f11234o;
        }

        public final boolean m13205s() {
            a(1, 4);
            return this.f11235p;
        }

        public final boolean m13206t() {
            a(1, 5);
            return this.f11236q;
        }

        @Nullable
        public final String m13207u() {
            this.f11237r = super.a(this.f11237r, 14);
            return this.f11237r;
        }

        @Nullable
        public final ComposerTargetDataPrivacyScopeFieldsModel m13208v() {
            this.f11238s = (ComposerTargetDataPrivacyScopeFieldsModel) super.a(this.f11238s, 15, ComposerTargetDataPrivacyScopeFieldsModel.class);
            return this.f11238s;
        }

        @Nullable
        public final DefaultImageFieldsModel m13209w() {
            this.f11239t = (DefaultImageFieldsModel) super.a(this.f11239t, 16, DefaultImageFieldsModel.class);
            return this.f11239t;
        }

        @Nullable
        public final DefaultImageFieldsModel m13210x() {
            this.f11240u = (DefaultImageFieldsModel) super.a(this.f11240u, 17, DefaultImageFieldsModel.class);
            return this.f11240u;
        }

        public final boolean m13211y() {
            a(2, 2);
            return this.f11241v;
        }

        @Nullable
        public final GraphQLSecondarySubscribeStatus m13199m() {
            this.f11242w = (GraphQLSecondarySubscribeStatus) super.b(this.f11242w, 19, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11242w;
        }

        private void m13180a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
            this.f11242w = graphQLSecondarySubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 19, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final DefaultNameFieldsModel m13212z() {
            this.f11243x = (DefaultNameFieldsModel) super.a(this.f11243x, 20, DefaultNameFieldsModel.class);
            return this.f11243x;
        }

        @Nullable
        public final GraphQLSubscribeStatus m13200n() {
            this.f11244y = (GraphQLSubscribeStatus) super.b(this.f11244y, 21, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f11244y;
        }

        private void m13181a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f11244y = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 21, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final TimelineContextItemsModel m13185A() {
            this.f11245z = (TimelineContextItemsModel) super.a(this.f11245z, 22, TimelineContextItemsModel.class);
            return this.f11245z;
        }

        @Nullable
        public final String m13188a() {
            return m13204r();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m13187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13202p() != null) {
                PersonCardCoverPhotoFieldsModel personCardCoverPhotoFieldsModel = (PersonCardCoverPhotoFieldsModel) graphQLModelMutatingVisitor.b(m13202p());
                if (m13202p() != personCardCoverPhotoFieldsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11230k = personCardCoverPhotoFieldsModel;
                }
            }
            if (m13203q() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m13203q());
                if (m13203q() != friendsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11231l = friendsModel;
                }
            }
            if (m13208v() != null) {
                ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) graphQLModelMutatingVisitor.b(m13208v());
                if (m13208v() != composerTargetDataPrivacyScopeFieldsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11238s = composerTargetDataPrivacyScopeFieldsModel;
                }
            }
            if (m13209w() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13209w());
                if (m13209w() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11239t = defaultImageFieldsModel;
                }
            }
            if (m13210x() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13210x());
                if (m13210x() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11240u = defaultImageFieldsModel;
                }
            }
            if (m13212z() != null) {
                DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m13212z());
                if (m13212z() != defaultNameFieldsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11243x = defaultNameFieldsModel;
                }
            }
            if (m13185A() != null) {
                TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) graphQLModelMutatingVisitor.b(m13185A());
                if (m13185A() != timelineContextItemsModel) {
                    graphQLVisitableModel = (PersonCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11245z = timelineContextItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13201o());
            int a = ModelHelper.a(flatBufferBuilder, m13202p());
            int a2 = ModelHelper.a(flatBufferBuilder, m13203q());
            int a3 = flatBufferBuilder.a(m13196j());
            int b2 = flatBufferBuilder.b(m13204r());
            int b3 = flatBufferBuilder.b(m13207u());
            int a4 = ModelHelper.a(flatBufferBuilder, m13208v());
            int a5 = ModelHelper.a(flatBufferBuilder, m13209w());
            int a6 = ModelHelper.a(flatBufferBuilder, m13210x());
            int a7 = flatBufferBuilder.a(m13199m());
            int a8 = ModelHelper.a(flatBufferBuilder, m13212z());
            int a9 = flatBufferBuilder.a(m13200n());
            int a10 = ModelHelper.a(flatBufferBuilder, m13185A());
            flatBufferBuilder.c(23);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f11224e);
            flatBufferBuilder.a(2, this.f11225f);
            flatBufferBuilder.a(3, this.f11226g);
            flatBufferBuilder.a(4, this.f11227h);
            flatBufferBuilder.a(5, this.f11228i);
            flatBufferBuilder.a(6, this.f11229j);
            flatBufferBuilder.b(7, a);
            flatBufferBuilder.b(8, a2);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, b2);
            flatBufferBuilder.a(11, this.f11234o);
            flatBufferBuilder.a(12, this.f11235p);
            flatBufferBuilder.a(13, this.f11236q);
            flatBufferBuilder.b(14, b3);
            flatBufferBuilder.b(15, a4);
            flatBufferBuilder.b(16, a5);
            flatBufferBuilder.b(17, a6);
            flatBufferBuilder.a(18, this.f11241v);
            flatBufferBuilder.b(19, a7);
            flatBufferBuilder.b(20, a8);
            flatBufferBuilder.b(21, a9);
            flatBufferBuilder.b(22, a10);
            i();
            return flatBufferBuilder.d();
        }

        public final void m13189a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11224e = mutableFlatBuffer.a(i, 1);
            this.f11225f = mutableFlatBuffer.a(i, 2);
            this.f11226g = mutableFlatBuffer.a(i, 3);
            this.f11227h = mutableFlatBuffer.a(i, 4);
            this.f11228i = mutableFlatBuffer.a(i, 5);
            this.f11229j = mutableFlatBuffer.a(i, 6);
            this.f11234o = mutableFlatBuffer.a(i, 11);
            this.f11235p = mutableFlatBuffer.a(i, 12);
            this.f11236q = mutableFlatBuffer.a(i, 13);
            this.f11241v = mutableFlatBuffer.a(i, 18);
        }
    }
}
