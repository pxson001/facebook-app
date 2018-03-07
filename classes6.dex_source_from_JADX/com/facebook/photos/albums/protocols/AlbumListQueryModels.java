package com.facebook.photos.albums.protocols;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels.NewsFeedDefaultsCompleteFeedbackModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAlbumsConnectionDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.AlbumListCanUploadOnlyQueryParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.AlbumListQueryParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser.FamilyTaggedMediasetParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser.FamilyTaggedMediasetParser.MediaParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser.FamilyTaggedMediasetParser.MediaParser.MediaEdgesParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser.FamilyTaggedMediasetParser.MediaParser.MediaEdgesParser.MediaEdgesNodeParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser.FamilyTaggedMediasetParser.MediaParser.MediaEdgesParser.MediaEdgesNodeParser.ImageParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.FBFamilyNonUserMemberAlbumsQueryParser.FamilyNonUserMembersParser.EdgesParser.NodeParser.FamilyTaggedMediasetParser.TitleParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.GroupAlbumListQueryParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.PageAlbumListQueryParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.PageAlbumsFragmentParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.SimpleAlbumFieldsParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.SimpleAlbumFieldsParser.AlbumCoverPhotoParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.SimpleAlbumFieldsParser.MediaOwnerObjectParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.SimpleAlbumFieldsParser.OwnerParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.SimpleAlbumFieldsParser.PrivacyScopeParser;
import com.facebook.photos.albums.protocols.AlbumListQueryParsers.SimpleAlbumFieldsParser.PrivacyScopeParser.IconImageParser;
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

/* compiled from: invitation_impression */
public class AlbumListQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -582754705)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: invitation_impression */
    public final class AlbumListCanUploadOnlyQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12305d;
        @Nullable
        private GraphQLAlbumsConnection f12306e;

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AlbumListCanUploadOnlyQueryModel.class, new Deserializer());
            }

            public Object m19214a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AlbumListCanUploadOnlyQueryParser.m19373a(jsonParser);
                Object albumListCanUploadOnlyQueryModel = new AlbumListCanUploadOnlyQueryModel();
                ((BaseModel) albumListCanUploadOnlyQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (albumListCanUploadOnlyQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) albumListCanUploadOnlyQueryModel).a();
                }
                return albumListCanUploadOnlyQueryModel;
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<AlbumListCanUploadOnlyQueryModel> {
            public final void m19215a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AlbumListCanUploadOnlyQueryModel albumListCanUploadOnlyQueryModel = (AlbumListCanUploadOnlyQueryModel) obj;
                if (albumListCanUploadOnlyQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(albumListCanUploadOnlyQueryModel.m19217a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    albumListCanUploadOnlyQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = albumListCanUploadOnlyQueryModel.w_();
                int u_ = albumListCanUploadOnlyQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("albums");
                    GraphQLAlbumsConnectionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AlbumListCanUploadOnlyQueryModel.class, new Serializer());
            }
        }

        public AlbumListCanUploadOnlyQueryModel() {
            super(2);
        }

        public final void m19220a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19221a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19216j() {
            if (this.b != null && this.f12305d == null) {
                this.f12305d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12305d;
        }

        @Nullable
        public final GraphQLAlbumsConnection m19218a() {
            this.f12306e = (GraphQLAlbumsConnection) super.a(this.f12306e, 1, GraphQLAlbumsConnection.class);
            return this.f12306e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19219a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19218a() != null) {
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) graphQLModelMutatingVisitor.b(m19218a());
                if (m19218a() != graphQLAlbumsConnection) {
                    graphQLVisitableModel = (AlbumListCanUploadOnlyQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12306e = graphQLAlbumsConnection;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19217a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19216j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19218a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -582754705)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: invitation_impression */
    public final class AlbumListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12307d;
        @Nullable
        private GraphQLAlbumsConnection f12308e;

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AlbumListQueryModel.class, new Deserializer());
            }

            public Object m19222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AlbumListQueryParser.m19374a(jsonParser);
                Object albumListQueryModel = new AlbumListQueryModel();
                ((BaseModel) albumListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (albumListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) albumListQueryModel).a();
                }
                return albumListQueryModel;
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<AlbumListQueryModel> {
            public final void m19223a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AlbumListQueryModel albumListQueryModel = (AlbumListQueryModel) obj;
                if (albumListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(albumListQueryModel.m19225a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    albumListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = albumListQueryModel.w_();
                int u_ = albumListQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("albums");
                    GraphQLAlbumsConnectionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AlbumListQueryModel.class, new Serializer());
            }
        }

        public AlbumListQueryModel() {
            super(2);
        }

        public final void m19228a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19229a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19224j() {
            if (this.b != null && this.f12307d == null) {
                this.f12307d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12307d;
        }

        @Nullable
        public final GraphQLAlbumsConnection m19226a() {
            this.f12308e = (GraphQLAlbumsConnection) super.a(this.f12308e, 1, GraphQLAlbumsConnection.class);
            return this.f12308e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19227a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19226a() != null) {
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) graphQLModelMutatingVisitor.b(m19226a());
                if (m19226a() != graphQLAlbumsConnection) {
                    graphQLVisitableModel = (AlbumListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12308e = graphQLAlbumsConnection;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19225a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19224j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19226a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1094859392)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: invitation_impression */
    public final class FBFamilyNonUserMemberAlbumsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private FamilyNonUserMembersModel f12326d;
        @Nullable
        private String f12327e;

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBFamilyNonUserMemberAlbumsQueryModel.class, new Deserializer());
            }

            public Object m19230a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBFamilyNonUserMemberAlbumsQueryParser.m19393a(jsonParser);
                Object fBFamilyNonUserMemberAlbumsQueryModel = new FBFamilyNonUserMemberAlbumsQueryModel();
                ((BaseModel) fBFamilyNonUserMemberAlbumsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBFamilyNonUserMemberAlbumsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBFamilyNonUserMemberAlbumsQueryModel).a();
                }
                return fBFamilyNonUserMemberAlbumsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 987186722)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: invitation_impression */
        public final class FamilyNonUserMembersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f12325d;

            /* compiled from: invitation_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FamilyNonUserMembersModel.class, new Deserializer());
                }

                public Object m19231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FamilyNonUserMembersParser.m19391a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object familyNonUserMembersModel = new FamilyNonUserMembersModel();
                    ((BaseModel) familyNonUserMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (familyNonUserMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) familyNonUserMembersModel).a();
                    }
                    return familyNonUserMembersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1419958110)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: invitation_impression */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f12324d;

                /* compiled from: invitation_impression */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m19232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m19389b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 257308215)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: invitation_impression */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private FamilyTaggedMediasetModel f12321d;
                    @Nullable
                    private String f12322e;
                    @Nullable
                    private String f12323f;

                    /* compiled from: invitation_impression */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m19233a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m19387a(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 302406935)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: invitation_impression */
                    public final class FamilyTaggedMediasetModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private MediaModel f12319d;
                        @Nullable
                        private TitleModel f12320e;

                        /* compiled from: invitation_impression */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(FamilyTaggedMediasetModel.class, new Deserializer());
                            }

                            public Object m19234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(FamilyTaggedMediasetParser.m19385a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object familyTaggedMediasetModel = new FamilyTaggedMediasetModel();
                                ((BaseModel) familyTaggedMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (familyTaggedMediasetModel instanceof Postprocessable) {
                                    return ((Postprocessable) familyTaggedMediasetModel).a();
                                }
                                return familyTaggedMediasetModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1903506386)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: invitation_impression */
                        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                            private int f12316d;
                            @Nullable
                            private List<MediaEdgesModel> f12317e;

                            /* compiled from: invitation_impression */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                                }

                                public Object m19235a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(MediaParser.m19381a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object mediaModel = new MediaModel();
                                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (mediaModel instanceof Postprocessable) {
                                        return ((Postprocessable) mediaModel).a();
                                    }
                                    return mediaModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = 136929045)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: invitation_impression */
                            public final class MediaEdgesModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private MediaEdgesNodeModel f12315d;

                                /* compiled from: invitation_impression */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(MediaEdgesModel.class, new Deserializer());
                                    }

                                    public Object m19236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(MediaEdgesParser.m19379b(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object mediaEdgesModel = new MediaEdgesModel();
                                        ((BaseModel) mediaEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (mediaEdgesModel instanceof Postprocessable) {
                                            return ((Postprocessable) mediaEdgesModel).a();
                                        }
                                        return mediaEdgesModel;
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 1302126166)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: invitation_impression */
                                public final class MediaEdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                                    @Nullable
                                    private GraphQLObjectType f12312d;
                                    @Nullable
                                    private String f12313e;
                                    @Nullable
                                    private ImageModel f12314f;

                                    /* compiled from: invitation_impression */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(MediaEdgesNodeModel.class, new Deserializer());
                                        }

                                        public Object m19237a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(MediaEdgesNodeParser.m19377a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object mediaEdgesNodeModel = new MediaEdgesNodeModel();
                                            ((BaseModel) mediaEdgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (mediaEdgesNodeModel instanceof Postprocessable) {
                                                return ((Postprocessable) mediaEdgesNodeModel).a();
                                            }
                                            return mediaEdgesNodeModel;
                                        }
                                    }

                                    @JsonDeserialize(using = Deserializer.class)
                                    @ModelWithFlatBufferFormatHash(a = 729935302)
                                    @JsonSerialize(using = Serializer.class)
                                    @FragmentModelWithoutBridge
                                    /* compiled from: invitation_impression */
                                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                                        private int f12309d;
                                        @Nullable
                                        private String f12310e;
                                        private int f12311f;

                                        /* compiled from: invitation_impression */
                                        public class Deserializer extends FbJsonDeserializer {
                                            static {
                                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                                            }

                                            public Object m19238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(ImageParser.m19375a(jsonParser, flatBufferBuilder));
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

                                        /* compiled from: invitation_impression */
                                        public class Serializer extends JsonSerializer<ImageModel> {
                                            public final void m19239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                ImageModel imageModel = (ImageModel) obj;
                                                if (imageModel.w_() == null) {
                                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                    flatBufferBuilder.d(imageModel.m19241a(flatBufferBuilder));
                                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                    wrap.position(0);
                                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                                }
                                                ImageParser.m19376a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                                            }

                                            static {
                                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                                            }
                                        }

                                        public ImageModel() {
                                            super(3);
                                        }

                                        public final int m19240a() {
                                            a(0, 0);
                                            return this.f12309d;
                                        }

                                        @Nullable
                                        public final String m19244j() {
                                            this.f12310e = super.a(this.f12310e, 1);
                                            return this.f12310e;
                                        }

                                        public final int m19245k() {
                                            a(0, 2);
                                            return this.f12311f;
                                        }

                                        public final int jK_() {
                                            return 70760763;
                                        }

                                        public final GraphQLVisitableModel m19242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                            h();
                                            i();
                                            return this;
                                        }

                                        public final int m19241a(FlatBufferBuilder flatBufferBuilder) {
                                            h();
                                            int b = flatBufferBuilder.b(m19244j());
                                            flatBufferBuilder.c(3);
                                            flatBufferBuilder.a(0, this.f12309d, 0);
                                            flatBufferBuilder.b(1, b);
                                            flatBufferBuilder.a(2, this.f12311f, 0);
                                            i();
                                            return flatBufferBuilder.d();
                                        }

                                        public final void m19243a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                            super.a(mutableFlatBuffer, i, obj);
                                            this.f12309d = mutableFlatBuffer.a(i, 0, 0);
                                            this.f12311f = mutableFlatBuffer.a(i, 2, 0);
                                        }
                                    }

                                    /* compiled from: invitation_impression */
                                    public class Serializer extends JsonSerializer<MediaEdgesNodeModel> {
                                        public final void m19246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            MediaEdgesNodeModel mediaEdgesNodeModel = (MediaEdgesNodeModel) obj;
                                            if (mediaEdgesNodeModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(mediaEdgesNodeModel.m19248a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                mediaEdgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            MediaEdgesNodeParser.m19378a(mediaEdgesNodeModel.w_(), mediaEdgesNodeModel.u_(), jsonGenerator, serializerProvider);
                                        }

                                        static {
                                            FbSerializerProvider.a(MediaEdgesNodeModel.class, new Serializer());
                                        }
                                    }

                                    public MediaEdgesNodeModel() {
                                        super(3);
                                    }

                                    @Nullable
                                    private GraphQLObjectType m19247l() {
                                        if (this.b != null && this.f12312d == null) {
                                            this.f12312d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                        }
                                        return this.f12312d;
                                    }

                                    @Nullable
                                    public final String m19251j() {
                                        this.f12313e = super.a(this.f12313e, 1);
                                        return this.f12313e;
                                    }

                                    @Nullable
                                    public final ImageModel m19252k() {
                                        this.f12314f = (ImageModel) super.a(this.f12314f, 2, ImageModel.class);
                                        return this.f12314f;
                                    }

                                    @Nullable
                                    public final String m19250a() {
                                        return m19251j();
                                    }

                                    public final int jK_() {
                                        return 74219460;
                                    }

                                    public final GraphQLVisitableModel m19249a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        GraphQLVisitableModel graphQLVisitableModel = null;
                                        h();
                                        if (m19252k() != null) {
                                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m19252k());
                                            if (m19252k() != imageModel) {
                                                graphQLVisitableModel = (MediaEdgesNodeModel) ModelHelper.a(null, this);
                                                graphQLVisitableModel.f12314f = imageModel;
                                            }
                                        }
                                        i();
                                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                    }

                                    public final int m19248a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int a = ModelHelper.a(flatBufferBuilder, m19247l());
                                        int b = flatBufferBuilder.b(m19251j());
                                        int a2 = ModelHelper.a(flatBufferBuilder, m19252k());
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, a);
                                        flatBufferBuilder.b(1, b);
                                        flatBufferBuilder.b(2, a2);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: invitation_impression */
                                public class Serializer extends JsonSerializer<MediaEdgesModel> {
                                    public final void m19253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        MediaEdgesModel mediaEdgesModel = (MediaEdgesModel) obj;
                                        if (mediaEdgesModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(mediaEdgesModel.m19254a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mediaEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        MediaEdgesParser.m19380b(mediaEdgesModel.w_(), mediaEdgesModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(MediaEdgesModel.class, new Serializer());
                                    }
                                }

                                public MediaEdgesModel() {
                                    super(1);
                                }

                                @Nullable
                                public final MediaEdgesNodeModel m19256a() {
                                    this.f12315d = (MediaEdgesNodeModel) super.a(this.f12315d, 0, MediaEdgesNodeModel.class);
                                    return this.f12315d;
                                }

                                public final int jK_() {
                                    return 1141981027;
                                }

                                public final GraphQLVisitableModel m19255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m19256a() != null) {
                                        MediaEdgesNodeModel mediaEdgesNodeModel = (MediaEdgesNodeModel) graphQLModelMutatingVisitor.b(m19256a());
                                        if (m19256a() != mediaEdgesNodeModel) {
                                            graphQLVisitableModel = (MediaEdgesModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f12315d = mediaEdgesNodeModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m19254a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m19256a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, a);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            /* compiled from: invitation_impression */
                            public class Serializer extends JsonSerializer<MediaModel> {
                                public final void m19257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    MediaModel mediaModel = (MediaModel) obj;
                                    if (mediaModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(mediaModel.m19259a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    MediaParser.m19382a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                                }
                            }

                            public MediaModel() {
                                super(2);
                            }

                            public final int m19258a() {
                                a(0, 0);
                                return this.f12316d;
                            }

                            @Nonnull
                            public final ImmutableList<MediaEdgesModel> m19262j() {
                                this.f12317e = super.a(this.f12317e, 1, MediaEdgesModel.class);
                                return (ImmutableList) this.f12317e;
                            }

                            public final int jK_() {
                                return 747633668;
                            }

                            public final GraphQLVisitableModel m19260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m19262j() != null) {
                                    Builder a = ModelHelper.a(m19262j(), graphQLModelMutatingVisitor);
                                    if (a != null) {
                                        graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f12317e = a.b();
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m19259a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m19262j());
                                flatBufferBuilder.c(2);
                                flatBufferBuilder.a(0, this.f12316d, 0);
                                flatBufferBuilder.b(1, a);
                                i();
                                return flatBufferBuilder.d();
                            }

                            public final void m19261a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                super.a(mutableFlatBuffer, i, obj);
                                this.f12316d = mutableFlatBuffer.a(i, 0, 0);
                            }
                        }

                        /* compiled from: invitation_impression */
                        public class Serializer extends JsonSerializer<FamilyTaggedMediasetModel> {
                            public final void m19263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                FamilyTaggedMediasetModel familyTaggedMediasetModel = (FamilyTaggedMediasetModel) obj;
                                if (familyTaggedMediasetModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(familyTaggedMediasetModel.m19269a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    familyTaggedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                FamilyTaggedMediasetParser.m19386a(familyTaggedMediasetModel.w_(), familyTaggedMediasetModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(FamilyTaggedMediasetModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1352864475)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: invitation_impression */
                        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f12318d;

                            /* compiled from: invitation_impression */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                                }

                                public Object m19264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(TitleParser.m19383a(jsonParser, flatBufferBuilder));
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

                            /* compiled from: invitation_impression */
                            public class Serializer extends JsonSerializer<TitleModel> {
                                public final void m19265a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    TitleModel titleModel = (TitleModel) obj;
                                    if (titleModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(titleModel.m19266a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    TitleParser.m19384a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                                }
                            }

                            public TitleModel() {
                                super(1);
                            }

                            @Nullable
                            public final String m19268a() {
                                this.f12318d = super.a(this.f12318d, 0);
                                return this.f12318d;
                            }

                            public final int jK_() {
                                return -1919764332;
                            }

                            public final GraphQLVisitableModel m19267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m19266a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m19268a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public FamilyTaggedMediasetModel() {
                            super(2);
                        }

                        @Nullable
                        public final MediaModel m19271a() {
                            this.f12319d = (MediaModel) super.a(this.f12319d, 0, MediaModel.class);
                            return this.f12319d;
                        }

                        @Nullable
                        public final TitleModel m19272j() {
                            this.f12320e = (TitleModel) super.a(this.f12320e, 1, TitleModel.class);
                            return this.f12320e;
                        }

                        public final int jK_() {
                            return -1039273109;
                        }

                        public final GraphQLVisitableModel m19270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m19271a() != null) {
                                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m19271a());
                                if (m19271a() != mediaModel) {
                                    graphQLVisitableModel = (FamilyTaggedMediasetModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f12319d = mediaModel;
                                }
                            }
                            if (m19272j() != null) {
                                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m19272j());
                                if (m19272j() != titleModel) {
                                    graphQLVisitableModel = (FamilyTaggedMediasetModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f12320e = titleModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m19269a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m19271a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m19272j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: invitation_impression */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m19273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m19275a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m19388a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(3);
                    }

                    @Nullable
                    public final FamilyTaggedMediasetModel m19278j() {
                        this.f12321d = (FamilyTaggedMediasetModel) super.a(this.f12321d, 0, FamilyTaggedMediasetModel.class);
                        return this.f12321d;
                    }

                    @Nullable
                    public final String m19279k() {
                        this.f12322e = super.a(this.f12322e, 1);
                        return this.f12322e;
                    }

                    @Nullable
                    private String m19274l() {
                        this.f12323f = super.a(this.f12323f, 2);
                        return this.f12323f;
                    }

                    @Nullable
                    public final String m19277a() {
                        return m19279k();
                    }

                    public final int jK_() {
                        return 105285582;
                    }

                    public final GraphQLVisitableModel m19276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m19278j() != null) {
                            FamilyTaggedMediasetModel familyTaggedMediasetModel = (FamilyTaggedMediasetModel) graphQLModelMutatingVisitor.b(m19278j());
                            if (m19278j() != familyTaggedMediasetModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f12321d = familyTaggedMediasetModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m19275a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m19278j());
                        int b = flatBufferBuilder.b(m19279k());
                        int b2 = flatBufferBuilder.b(m19274l());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: invitation_impression */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m19280a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m19281a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m19390b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m19283a() {
                    this.f12324d = (NodeModel) super.a(this.f12324d, 0, NodeModel.class);
                    return this.f12324d;
                }

                public final int jK_() {
                    return 113485997;
                }

                public final GraphQLVisitableModel m19282a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m19283a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m19283a());
                        if (m19283a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12324d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m19281a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m19283a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: invitation_impression */
            public class Serializer extends JsonSerializer<FamilyNonUserMembersModel> {
                public final void m19284a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FamilyNonUserMembersModel familyNonUserMembersModel = (FamilyNonUserMembersModel) obj;
                    if (familyNonUserMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(familyNonUserMembersModel.m19285a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        familyNonUserMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FamilyNonUserMembersParser.m19392a(familyNonUserMembersModel.w_(), familyNonUserMembersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FamilyNonUserMembersModel.class, new Serializer());
                }
            }

            public FamilyNonUserMembersModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m19287a() {
                this.f12325d = super.a(this.f12325d, 0, EdgesModel.class);
                return (ImmutableList) this.f12325d;
            }

            public final int jK_() {
                return 1520223694;
            }

            public final GraphQLVisitableModel m19286a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19287a() != null) {
                    Builder a = ModelHelper.a(m19287a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FamilyNonUserMembersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12325d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19285a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19287a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<FBFamilyNonUserMemberAlbumsQueryModel> {
            public final void m19288a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBFamilyNonUserMemberAlbumsQueryModel fBFamilyNonUserMemberAlbumsQueryModel = (FBFamilyNonUserMemberAlbumsQueryModel) obj;
                if (fBFamilyNonUserMemberAlbumsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBFamilyNonUserMemberAlbumsQueryModel.m19290a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBFamilyNonUserMemberAlbumsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBFamilyNonUserMemberAlbumsQueryModel.w_();
                int u_ = fBFamilyNonUserMemberAlbumsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("family_non_user_members");
                    FamilyNonUserMembersParser.m19392a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBFamilyNonUserMemberAlbumsQueryModel.class, new Serializer());
            }
        }

        public FBFamilyNonUserMemberAlbumsQueryModel() {
            super(2);
        }

        public final void m19293a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19294a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FamilyNonUserMembersModel m19295j() {
            this.f12326d = (FamilyNonUserMembersModel) super.a(this.f12326d, 0, FamilyNonUserMembersModel.class);
            return this.f12326d;
        }

        @Nullable
        private String m19289k() {
            this.f12327e = super.a(this.f12327e, 1);
            return this.f12327e;
        }

        @Nullable
        public final String m19292a() {
            return m19289k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m19291a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19295j() != null) {
                FamilyNonUserMembersModel familyNonUserMembersModel = (FamilyNonUserMembersModel) graphQLModelMutatingVisitor.b(m19295j());
                if (m19295j() != familyNonUserMembersModel) {
                    graphQLVisitableModel = (FBFamilyNonUserMemberAlbumsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12326d = familyNonUserMembersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19290a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19295j());
            int b = flatBufferBuilder.b(m19289k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1720733694)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: invitation_impression */
    public final class GroupAlbumListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLAlbumsConnection f12328d;

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupAlbumListQueryModel.class, new Deserializer());
            }

            public Object m19296a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupAlbumListQueryParser.m19394a(jsonParser);
                Object groupAlbumListQueryModel = new GroupAlbumListQueryModel();
                ((BaseModel) groupAlbumListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupAlbumListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) groupAlbumListQueryModel).a();
                }
                return groupAlbumListQueryModel;
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<GroupAlbumListQueryModel> {
            public final void m19297a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupAlbumListQueryModel groupAlbumListQueryModel = (GroupAlbumListQueryModel) obj;
                if (groupAlbumListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupAlbumListQueryModel.m19298a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupAlbumListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupAlbumListQueryModel.w_();
                int u_ = groupAlbumListQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_albums");
                    GraphQLAlbumsConnectionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupAlbumListQueryModel.class, new Serializer());
            }
        }

        public GroupAlbumListQueryModel() {
            super(1);
        }

        public final void m19301a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19302a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLAlbumsConnection m19299a() {
            this.f12328d = (GraphQLAlbumsConnection) super.a(this.f12328d, 0, GraphQLAlbumsConnection.class);
            return this.f12328d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m19300a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19299a() != null) {
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) graphQLModelMutatingVisitor.b(m19299a());
                if (m19299a() != graphQLAlbumsConnection) {
                    graphQLVisitableModel = (GroupAlbumListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12328d = graphQLAlbumsConnection;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19298a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19299a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1928954760)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: invitation_impression */
    public final class PageAlbumListQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12329d;
        @Nullable
        private PageAlbumsFragmentModel f12330e;

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAlbumListQueryModel.class, new Deserializer());
            }

            public Object m19303a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageAlbumListQueryParser.m19395a(jsonParser);
                Object pageAlbumListQueryModel = new PageAlbumListQueryModel();
                ((BaseModel) pageAlbumListQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageAlbumListQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAlbumListQueryModel).a();
                }
                return pageAlbumListQueryModel;
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<PageAlbumListQueryModel> {
            public final void m19304a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageAlbumListQueryModel pageAlbumListQueryModel = (PageAlbumListQueryModel) obj;
                if (pageAlbumListQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAlbumListQueryModel.m19307a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAlbumListQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageAlbumListQueryModel.w_();
                int u_ = pageAlbumListQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page_albums");
                    PageAlbumsFragmentParser.m19399a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageAlbumListQueryModel.class, new Serializer());
            }
        }

        public PageAlbumListQueryModel() {
            super(2);
        }

        public final void m19309a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19310a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19305a() {
            if (this.b != null && this.f12329d == null) {
                this.f12329d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12329d;
        }

        @Nullable
        private PageAlbumsFragmentModel m19306j() {
            this.f12330e = (PageAlbumsFragmentModel) super.a(this.f12330e, 1, PageAlbumsFragmentModel.class);
            return this.f12330e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19308a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19306j() != null) {
                PageAlbumsFragmentModel pageAlbumsFragmentModel = (PageAlbumsFragmentModel) graphQLModelMutatingVisitor.b(m19306j());
                if (m19306j() != pageAlbumsFragmentModel) {
                    graphQLVisitableModel = (PageAlbumListQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12330e = pageAlbumsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19307a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19305a());
            int a2 = ModelHelper.a(flatBufferBuilder, m19306j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -336295670)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: invitation_impression */
    public final class PageAlbumsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f12332d;
        @Nullable
        private DefaultPageInfoFieldsModel f12333e;

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAlbumsFragmentModel.class, new Deserializer());
            }

            public Object m19311a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageAlbumsFragmentParser.m19398a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageAlbumsFragmentModel = new PageAlbumsFragmentModel();
                ((BaseModel) pageAlbumsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageAlbumsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAlbumsFragmentModel).a();
                }
                return pageAlbumsFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1290119474)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: invitation_impression */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private SimpleAlbumFieldsModel f12331d;

            /* compiled from: invitation_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m19312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageAlbumsFragmentParser.EdgesParser.m19396b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object edgesModel = new EdgesModel();
                    ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (edgesModel instanceof Postprocessable) {
                        return ((Postprocessable) edgesModel).a();
                    }
                    return edgesModel;
                }
            }

            /* compiled from: invitation_impression */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m19313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m19315a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageAlbumsFragmentParser.EdgesParser.m19397b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            private SimpleAlbumFieldsModel m19314a() {
                this.f12331d = (SimpleAlbumFieldsModel) super.a(this.f12331d, 0, SimpleAlbumFieldsModel.class);
                return this.f12331d;
            }

            public final int jK_() {
                return 286196688;
            }

            public final GraphQLVisitableModel m19316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19314a() != null) {
                    SimpleAlbumFieldsModel simpleAlbumFieldsModel = (SimpleAlbumFieldsModel) graphQLModelMutatingVisitor.b(m19314a());
                    if (m19314a() != simpleAlbumFieldsModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12331d = simpleAlbumFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19315a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19314a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<PageAlbumsFragmentModel> {
            public final void m19317a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageAlbumsFragmentModel pageAlbumsFragmentModel = (PageAlbumsFragmentModel) obj;
                if (pageAlbumsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAlbumsFragmentModel.m19320a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAlbumsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageAlbumsFragmentParser.m19399a(pageAlbumsFragmentModel.w_(), pageAlbumsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageAlbumsFragmentModel.class, new Serializer());
            }
        }

        public PageAlbumsFragmentModel() {
            super(2);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m19318a() {
            this.f12332d = super.a(this.f12332d, 0, EdgesModel.class);
            return (ImmutableList) this.f12332d;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m19319j() {
            this.f12333e = (DefaultPageInfoFieldsModel) super.a(this.f12333e, 1, DefaultPageInfoFieldsModel.class);
            return this.f12333e;
        }

        public final int jK_() {
            return 1395784369;
        }

        public final GraphQLVisitableModel m19321a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m19318a() != null) {
                Builder a = ModelHelper.a(m19318a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PageAlbumsFragmentModel pageAlbumsFragmentModel = (PageAlbumsFragmentModel) ModelHelper.a(null, this);
                    pageAlbumsFragmentModel.f12332d = a.b();
                    graphQLVisitableModel = pageAlbumsFragmentModel;
                    if (m19319j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m19319j());
                        if (m19319j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (PageAlbumsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12333e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m19319j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m19319j());
                if (m19319j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (PageAlbumsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12333e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m19320a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19318a());
            int a2 = ModelHelper.a(flatBufferBuilder, m19319j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1286954972)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: invitation_impression */
    public final class SimpleAlbumFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AlbumCoverPhotoModel f12344d;
        @Nullable
        private GraphQLPhotosAlbumAPIType f12345e;
        private boolean f12346f;
        private boolean f12347g;
        private boolean f12348h;
        private long f12349i;
        @Nullable
        private NewsFeedDefaultsCompleteFeedbackModel f12350j;
        @Nullable
        private String f12351k;
        @Nullable
        private MediaOwnerObjectModel f12352l;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12353m;
        private long f12354n;
        @Nullable
        private OwnerModel f12355o;
        @Nullable
        private PrivacyScopeModel f12356p;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12357q;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2124424883)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: invitation_impression */
        public final class AlbumCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f12334d;

            /* compiled from: invitation_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumCoverPhotoModel.class, new Deserializer());
                }

                public Object m19322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumCoverPhotoParser.m19400a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object albumCoverPhotoModel = new AlbumCoverPhotoModel();
                    ((BaseModel) albumCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (albumCoverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) albumCoverPhotoModel).a();
                    }
                    return albumCoverPhotoModel;
                }
            }

            /* compiled from: invitation_impression */
            public class Serializer extends JsonSerializer<AlbumCoverPhotoModel> {
                public final void m19323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumCoverPhotoModel albumCoverPhotoModel = (AlbumCoverPhotoModel) obj;
                    if (albumCoverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumCoverPhotoModel.m19325a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumCoverPhotoParser.m19401a(albumCoverPhotoModel.w_(), albumCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AlbumCoverPhotoModel.class, new Serializer());
                }
            }

            public AlbumCoverPhotoModel() {
                super(1);
            }

            @Nullable
            private DefaultImageFieldsModel m19324a() {
                this.f12334d = (DefaultImageFieldsModel) super.a(this.f12334d, 0, DefaultImageFieldsModel.class);
                return this.f12334d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m19326a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19324a() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19324a());
                    if (m19324a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (AlbumCoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12334d = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19325a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19324a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: invitation_impression */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SimpleAlbumFieldsModel.class, new Deserializer());
            }

            public Object m19327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SimpleAlbumFieldsParser.m19410a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object simpleAlbumFieldsModel = new SimpleAlbumFieldsModel();
                ((BaseModel) simpleAlbumFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (simpleAlbumFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) simpleAlbumFieldsModel).a();
                }
                return simpleAlbumFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: invitation_impression */
        public final class MediaOwnerObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f12335d;
            @Nullable
            private String f12336e;

            /* compiled from: invitation_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaOwnerObjectModel.class, new Deserializer());
                }

                public Object m19328a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaOwnerObjectParser.m19402a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaOwnerObjectModel = new MediaOwnerObjectModel();
                    ((BaseModel) mediaOwnerObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaOwnerObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaOwnerObjectModel).a();
                    }
                    return mediaOwnerObjectModel;
                }
            }

            /* compiled from: invitation_impression */
            public class Serializer extends JsonSerializer<MediaOwnerObjectModel> {
                public final void m19329a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaOwnerObjectModel mediaOwnerObjectModel = (MediaOwnerObjectModel) obj;
                    if (mediaOwnerObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaOwnerObjectModel.m19332a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaOwnerObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaOwnerObjectParser.m19403a(mediaOwnerObjectModel.w_(), mediaOwnerObjectModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MediaOwnerObjectModel.class, new Serializer());
                }
            }

            public MediaOwnerObjectModel() {
                super(2);
            }

            public final void m19335a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m19336a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m19330j() {
                if (this.b != null && this.f12335d == null) {
                    this.f12335d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12335d;
            }

            @Nullable
            private String m19331k() {
                this.f12336e = super.a(this.f12336e, 1);
                return this.f12336e;
            }

            @Nullable
            public final String m19334a() {
                return m19331k();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m19333a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19332a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19330j());
                int b = flatBufferBuilder.b(m19331k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: invitation_impression */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f12337d;
            @Nullable
            private String f12338e;

            /* compiled from: invitation_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m19337a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m19404a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: invitation_impression */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m19338a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m19341a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m19405a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(2);
            }

            public final void m19344a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m19345a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m19339j() {
                if (this.b != null && this.f12337d == null) {
                    this.f12337d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12337d;
            }

            @Nullable
            private String m19340k() {
                this.f12338e = super.a(this.f12338e, 1);
                return this.f12338e;
            }

            @Nullable
            public final String m19343a() {
                return m19340k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m19342a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19341a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19339j());
                int b = flatBufferBuilder.b(m19340k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1657223668)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: invitation_impression */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private IconImageModel f12341d;
            @Nullable
            private String f12342e;
            @Nullable
            private String f12343f;

            /* compiled from: invitation_impression */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m19346a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m19408a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyScopeModel = new PrivacyScopeModel();
                    ((BaseModel) privacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyScopeModel).a();
                    }
                    return privacyScopeModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 201166953)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: invitation_impression */
            public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f12339d;
                @Nullable
                private String f12340e;

                /* compiled from: invitation_impression */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                    }

                    public Object m19347a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconImageParser.m19406a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object iconImageModel = new IconImageModel();
                        ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (iconImageModel instanceof Postprocessable) {
                            return ((Postprocessable) iconImageModel).a();
                        }
                        return iconImageModel;
                    }
                }

                /* compiled from: invitation_impression */
                public class Serializer extends JsonSerializer<IconImageModel> {
                    public final void m19348a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconImageModel iconImageModel = (IconImageModel) obj;
                        if (iconImageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconImageModel.m19351a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconImageParser.m19407a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(IconImageModel.class, new Serializer());
                    }
                }

                public IconImageModel() {
                    super(2);
                }

                @Nullable
                private String m19349a() {
                    this.f12339d = super.a(this.f12339d, 0);
                    return this.f12339d;
                }

                @Nullable
                private String m19350j() {
                    this.f12340e = super.a(this.f12340e, 1);
                    return this.f12340e;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m19352a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m19351a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m19349a());
                    int b2 = flatBufferBuilder.b(m19350j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: invitation_impression */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m19353a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m19357a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m19409a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            public PrivacyScopeModel() {
                super(3);
            }

            @Nullable
            private IconImageModel m19354a() {
                this.f12341d = (IconImageModel) super.a(this.f12341d, 0, IconImageModel.class);
                return this.f12341d;
            }

            @Nullable
            private String m19355j() {
                this.f12342e = super.a(this.f12342e, 1);
                return this.f12342e;
            }

            @Nullable
            private String m19356k() {
                this.f12343f = super.a(this.f12343f, 2);
                return this.f12343f;
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m19358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19354a() != null) {
                    IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m19354a());
                    if (m19354a() != iconImageModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12341d = iconImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19357a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19354a());
                int b = flatBufferBuilder.b(m19355j());
                int b2 = flatBufferBuilder.b(m19356k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: invitation_impression */
        public class Serializer extends JsonSerializer<SimpleAlbumFieldsModel> {
            public final void m19359a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SimpleAlbumFieldsModel simpleAlbumFieldsModel = (SimpleAlbumFieldsModel) obj;
                if (simpleAlbumFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(simpleAlbumFieldsModel.m19369a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    simpleAlbumFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SimpleAlbumFieldsParser.m19411a(simpleAlbumFieldsModel.w_(), simpleAlbumFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SimpleAlbumFieldsModel.class, new Serializer());
            }
        }

        public SimpleAlbumFieldsModel() {
            super(14);
        }

        @Nullable
        private AlbumCoverPhotoModel m19360j() {
            this.f12344d = (AlbumCoverPhotoModel) super.a(this.f12344d, 0, AlbumCoverPhotoModel.class);
            return this.f12344d;
        }

        @Nullable
        private GraphQLPhotosAlbumAPIType m19361k() {
            this.f12345e = (GraphQLPhotosAlbumAPIType) super.b(this.f12345e, 1, GraphQLPhotosAlbumAPIType.class, GraphQLPhotosAlbumAPIType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f12345e;
        }

        @Nullable
        private NewsFeedDefaultsCompleteFeedbackModel m19362l() {
            this.f12350j = (NewsFeedDefaultsCompleteFeedbackModel) super.a(this.f12350j, 6, NewsFeedDefaultsCompleteFeedbackModel.class);
            return this.f12350j;
        }

        @Nullable
        private String m19363m() {
            this.f12351k = super.a(this.f12351k, 7);
            return this.f12351k;
        }

        @Nullable
        private MediaOwnerObjectModel m19364n() {
            this.f12352l = (MediaOwnerObjectModel) super.a(this.f12352l, 8, MediaOwnerObjectModel.class);
            return this.f12352l;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m19365o() {
            this.f12353m = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12353m, 9, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12353m;
        }

        @Nullable
        private OwnerModel m19366p() {
            this.f12355o = (OwnerModel) super.a(this.f12355o, 11, OwnerModel.class);
            return this.f12355o;
        }

        @Nullable
        private PrivacyScopeModel m19367q() {
            this.f12356p = (PrivacyScopeModel) super.a(this.f12356p, 12, PrivacyScopeModel.class);
            return this.f12356p;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m19368r() {
            this.f12357q = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12357q, 13, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12357q;
        }

        @Nullable
        public final String m19371a() {
            return m19363m();
        }

        public final int jK_() {
            return 63344207;
        }

        public final GraphQLVisitableModel m19370a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19360j() != null) {
                AlbumCoverPhotoModel albumCoverPhotoModel = (AlbumCoverPhotoModel) graphQLModelMutatingVisitor.b(m19360j());
                if (m19360j() != albumCoverPhotoModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12344d = albumCoverPhotoModel;
                }
            }
            if (m19362l() != null) {
                NewsFeedDefaultsCompleteFeedbackModel newsFeedDefaultsCompleteFeedbackModel = (NewsFeedDefaultsCompleteFeedbackModel) graphQLModelMutatingVisitor.b(m19362l());
                if (m19362l() != newsFeedDefaultsCompleteFeedbackModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12350j = newsFeedDefaultsCompleteFeedbackModel;
                }
            }
            if (m19364n() != null) {
                MediaOwnerObjectModel mediaOwnerObjectModel = (MediaOwnerObjectModel) graphQLModelMutatingVisitor.b(m19364n());
                if (m19364n() != mediaOwnerObjectModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12352l = mediaOwnerObjectModel;
                }
            }
            if (m19365o() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m19365o());
                if (m19365o() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12353m = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m19366p() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m19366p());
                if (m19366p() != ownerModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12355o = ownerModel;
                }
            }
            if (m19367q() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(m19367q());
                if (m19367q() != privacyScopeModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12356p = privacyScopeModel;
                }
            }
            if (m19368r() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m19368r());
                if (m19368r() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (SimpleAlbumFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12357q = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19369a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19360j());
            int a2 = flatBufferBuilder.a(m19361k());
            int a3 = ModelHelper.a(flatBufferBuilder, m19362l());
            int b = flatBufferBuilder.b(m19363m());
            int a4 = ModelHelper.a(flatBufferBuilder, m19364n());
            int a5 = ModelHelper.a(flatBufferBuilder, m19365o());
            int a6 = ModelHelper.a(flatBufferBuilder, m19366p());
            int a7 = ModelHelper.a(flatBufferBuilder, m19367q());
            int a8 = ModelHelper.a(flatBufferBuilder, m19368r());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f12346f);
            flatBufferBuilder.a(3, this.f12347g);
            flatBufferBuilder.a(4, this.f12348h);
            flatBufferBuilder.a(5, this.f12349i, 0);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.a(10, this.f12354n, 0);
            flatBufferBuilder.b(11, a6);
            flatBufferBuilder.b(12, a7);
            flatBufferBuilder.b(13, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19372a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12346f = mutableFlatBuffer.a(i, 2);
            this.f12347g = mutableFlatBuffer.a(i, 3);
            this.f12348h = mutableFlatBuffer.a(i, 4);
            this.f12349i = mutableFlatBuffer.a(i, 5, 0);
            this.f12354n = mutableFlatBuffer.a(i, 10, 0);
        }
    }
}
