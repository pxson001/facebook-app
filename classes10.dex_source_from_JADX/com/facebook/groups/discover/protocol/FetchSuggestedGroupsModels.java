package com.facebook.groups.discover.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.CoverPhotoParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.CoverPhotoParser.PhotoParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.CoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.GroupMembersParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.GroupMembersParser.EdgesParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.GroupMembersParser.EdgesParser.EdgesNodeParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.NodeParser.GroupMembersParser.EdgesParser.EdgesNodeParser.ProfilePictureParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FB4ADiscoverRowDataParser.SuggestionContextParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FetchSuggestedGroupsParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FetchSuggestedGroupsParser.GroupsYouShouldJoinParser;
import com.facebook.groups.discover.protocol.FetchSuggestedGroupsParsers.FetchSuggestedGroupsParser.GroupsYouShouldJoinParser.PageInfoParser;
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

/* compiled from: UserIdentification */
public class FetchSuggestedGroupsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2110785210)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UserIdentification */
    public final class FB4ADiscoverRowDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NodeModel f21314d;
        @Nullable
        private SuggestionContextModel f21315e;
        @Nullable
        private String f21316f;

        /* compiled from: UserIdentification */
        public final class Builder {
            @Nullable
            public NodeModel f21288a;
            @Nullable
            public SuggestionContextModel f21289b;
            @Nullable
            public String f21290c;

            public static Builder m22190a(FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel) {
                Builder builder = new Builder();
                builder.f21288a = fB4ADiscoverRowDataModel.m22260a();
                builder.f21289b = fB4ADiscoverRowDataModel.m22261j();
                builder.f21290c = fB4ADiscoverRowDataModel.m22262k();
                return builder;
            }

            public final FB4ADiscoverRowDataModel m22191a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f21288a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f21289b);
                int b = flatBufferBuilder.b(this.f21290c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FB4ADiscoverRowDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: UserIdentification */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FB4ADiscoverRowDataModel.class, new Deserializer());
            }

            public Object m22192a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FB4ADiscoverRowDataParser.m22303b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fB4ADiscoverRowDataModel = new FB4ADiscoverRowDataModel();
                ((BaseModel) fB4ADiscoverRowDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fB4ADiscoverRowDataModel instanceof Postprocessable) {
                    return ((Postprocessable) fB4ADiscoverRowDataModel).a();
                }
                return fB4ADiscoverRowDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 725985595)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UserIdentification */
        public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private CoverPhotoModel f21307d;
            @Nullable
            private GroupMembersModel f21308e;
            private int f21309f;
            @Nullable
            private String f21310g;
            @Nullable
            private String f21311h;
            @Nullable
            private GraphQLGroupJoinState f21312i;

            /* compiled from: UserIdentification */
            public final class Builder {
                @Nullable
                public CoverPhotoModel f21291a;
                @Nullable
                public GroupMembersModel f21292b;
                public int f21293c;
                @Nullable
                public String f21294d;
                @Nullable
                public String f21295e;
                @Nullable
                public GraphQLGroupJoinState f21296f;

                public final NodeModel m22193a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f21291a);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f21292b);
                    int b = flatBufferBuilder.b(this.f21294d);
                    int b2 = flatBufferBuilder.b(this.f21295e);
                    int a3 = flatBufferBuilder.a(this.f21296f);
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.a(2, this.f21293c, 0);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, a3);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -114743920)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UserIdentification */
            public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PhotoModel f21300d;

                /* compiled from: UserIdentification */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                    }

                    public Object m22194a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CoverPhotoParser.m22289a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object coverPhotoModel = new CoverPhotoModel();
                        ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (coverPhotoModel instanceof Postprocessable) {
                            return ((Postprocessable) coverPhotoModel).a();
                        }
                        return coverPhotoModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 395495914)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: UserIdentification */
                public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f21298d;
                    @Nullable
                    private ImageModel f21299e;

                    /* compiled from: UserIdentification */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                        }

                        public Object m22195a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PhotoParser.m22287a(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: UserIdentification */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f21297d;

                        /* compiled from: UserIdentification */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m22196a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m22285a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: UserIdentification */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m22197a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m22198a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m22286a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m22200a() {
                            this.f21297d = super.a(this.f21297d, 0);
                            return this.f21297d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m22199a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m22198a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m22200a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: UserIdentification */
                    public class Serializer extends JsonSerializer<PhotoModel> {
                        public final void m22201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PhotoModel photoModel = (PhotoModel) obj;
                            if (photoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(photoModel.m22203a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PhotoParser.m22288a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PhotoModel.class, new Serializer());
                        }
                    }

                    public PhotoModel() {
                        super(2);
                    }

                    @Nullable
                    private String m22202k() {
                        this.f21298d = super.a(this.f21298d, 0);
                        return this.f21298d;
                    }

                    @Nullable
                    public final ImageModel m22206j() {
                        this.f21299e = (ImageModel) super.a(this.f21299e, 1, ImageModel.class);
                        return this.f21299e;
                    }

                    @Nullable
                    public final String m22205a() {
                        return m22202k();
                    }

                    public final int jK_() {
                        return 77090322;
                    }

                    public final GraphQLVisitableModel m22204a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m22206j() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m22206j());
                            if (m22206j() != imageModel) {
                                graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f21299e = imageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m22203a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m22202k());
                        int a = ModelHelper.a(flatBufferBuilder, m22206j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: UserIdentification */
                public class Serializer extends JsonSerializer<CoverPhotoModel> {
                    public final void m22207a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                        if (coverPhotoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(coverPhotoModel.m22208a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CoverPhotoParser.m22290a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                    }
                }

                public CoverPhotoModel() {
                    super(1);
                }

                @Nullable
                public final PhotoModel m22210a() {
                    this.f21300d = (PhotoModel) super.a(this.f21300d, 0, PhotoModel.class);
                    return this.f21300d;
                }

                public final int jK_() {
                    return 497264923;
                }

                public final GraphQLVisitableModel m22209a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m22210a() != null) {
                        PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m22210a());
                        if (m22210a() != photoModel) {
                            graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f21300d = photoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m22208a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m22210a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: UserIdentification */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m22211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m22299a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 86333968)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UserIdentification */
            public final class GroupMembersModel extends BaseModel implements GraphQLVisitableModel {
                private int f21305d;
                @Nullable
                private List<EdgesModel> f21306e;

                /* compiled from: UserIdentification */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GroupMembersModel.class, new Deserializer());
                    }

                    public Object m22212a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupMembersParser.m22297a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object groupMembersModel = new GroupMembersModel();
                        ((BaseModel) groupMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (groupMembersModel instanceof Postprocessable) {
                            return ((Postprocessable) groupMembersModel).a();
                        }
                        return groupMembersModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1838904141)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: UserIdentification */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private EdgesNodeModel f21304d;

                    /* compiled from: UserIdentification */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m22213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m22295b(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = -1250757003)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: UserIdentification */
                    public final class EdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f21302d;
                        @Nullable
                        private ProfilePictureModel f21303e;

                        /* compiled from: UserIdentification */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EdgesNodeModel.class, new Deserializer());
                            }

                            public Object m22214a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EdgesNodeParser.m22293a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object edgesNodeModel = new EdgesNodeModel();
                                ((BaseModel) edgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (edgesNodeModel instanceof Postprocessable) {
                                    return ((Postprocessable) edgesNodeModel).a();
                                }
                                return edgesNodeModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 842551240)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: UserIdentification */
                        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f21301d;

                            /* compiled from: UserIdentification */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                                }

                                public Object m22215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ProfilePictureParser.m22291a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object profilePictureModel = new ProfilePictureModel();
                                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (profilePictureModel instanceof Postprocessable) {
                                        return ((Postprocessable) profilePictureModel).a();
                                    }
                                    return profilePictureModel;
                                }
                            }

                            /* compiled from: UserIdentification */
                            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                                public final void m22216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                    if (profilePictureModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(profilePictureModel.m22217a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ProfilePictureParser.m22292a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                                }
                            }

                            public ProfilePictureModel() {
                                super(1);
                            }

                            @Nullable
                            public final String m22219a() {
                                this.f21301d = super.a(this.f21301d, 0);
                                return this.f21301d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m22218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m22217a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m22219a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: UserIdentification */
                        public class Serializer extends JsonSerializer<EdgesNodeModel> {
                            public final void m22220a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EdgesNodeModel edgesNodeModel = (EdgesNodeModel) obj;
                                if (edgesNodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(edgesNodeModel.m22221a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    edgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EdgesNodeParser.m22294a(edgesNodeModel.w_(), edgesNodeModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(EdgesNodeModel.class, new Serializer());
                            }
                        }

                        public EdgesNodeModel() {
                            super(2);
                        }

                        public final void m22224a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m22225a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        public final String m22226j() {
                            this.f21302d = super.a(this.f21302d, 0);
                            return this.f21302d;
                        }

                        @Nullable
                        public final ProfilePictureModel m22227k() {
                            this.f21303e = (ProfilePictureModel) super.a(this.f21303e, 1, ProfilePictureModel.class);
                            return this.f21303e;
                        }

                        @Nullable
                        public final String m22223a() {
                            return m22226j();
                        }

                        public final int jK_() {
                            return 2645995;
                        }

                        public final GraphQLVisitableModel m22222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m22227k() != null) {
                                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m22227k());
                                if (m22227k() != profilePictureModel) {
                                    graphQLVisitableModel = (EdgesNodeModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f21303e = profilePictureModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m22221a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m22226j());
                            int a = ModelHelper.a(flatBufferBuilder, m22227k());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: UserIdentification */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m22228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m22229a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m22296b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    public final EdgesNodeModel m22231a() {
                        this.f21304d = (EdgesNodeModel) super.a(this.f21304d, 0, EdgesNodeModel.class);
                        return this.f21304d;
                    }

                    public final int jK_() {
                        return -1730431337;
                    }

                    public final GraphQLVisitableModel m22230a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m22231a() != null) {
                            EdgesNodeModel edgesNodeModel = (EdgesNodeModel) graphQLModelMutatingVisitor.b(m22231a());
                            if (m22231a() != edgesNodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f21304d = edgesNodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m22229a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m22231a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: UserIdentification */
                public class Serializer extends JsonSerializer<GroupMembersModel> {
                    public final void m22232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GroupMembersModel groupMembersModel = (GroupMembersModel) obj;
                        if (groupMembersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(groupMembersModel.m22233a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            groupMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupMembersParser.m22298a(groupMembersModel.w_(), groupMembersModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(GroupMembersModel.class, new Serializer());
                    }
                }

                public GroupMembersModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m22235a() {
                    this.f21306e = super.a(this.f21306e, 1, EdgesModel.class);
                    return (ImmutableList) this.f21306e;
                }

                public final int jK_() {
                    return 103365688;
                }

                public final GraphQLVisitableModel m22234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m22235a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m22235a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (GroupMembersModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f21306e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m22233a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m22235a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f21305d, 0);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m22236a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f21305d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: UserIdentification */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m22237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m22240a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m22300a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            public NodeModel() {
                super(6);
            }

            public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(6);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m22244a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m22250n();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("viewer_join_state".equals(str)) {
                    consistencyTuple.a = m22251o();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m22245a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m22239a((String) obj);
                } else if ("viewer_join_state".equals(str)) {
                    m22238a((GraphQLGroupJoinState) obj);
                }
            }

            @Nullable
            public final CoverPhotoModel m22246j() {
                this.f21307d = (CoverPhotoModel) super.a(this.f21307d, 0, CoverPhotoModel.class);
                return this.f21307d;
            }

            @Nullable
            public final GroupMembersModel m22247k() {
                this.f21308e = (GroupMembersModel) super.a(this.f21308e, 1, GroupMembersModel.class);
                return this.f21308e;
            }

            public final int m22248l() {
                a(0, 2);
                return this.f21309f;
            }

            @Nullable
            public final String m22249m() {
                this.f21310g = super.a(this.f21310g, 3);
                return this.f21310g;
            }

            @Nullable
            public final String m22250n() {
                this.f21311h = super.a(this.f21311h, 4);
                return this.f21311h;
            }

            private void m22239a(@Nullable String str) {
                this.f21311h = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, str);
                }
            }

            @Nullable
            public final GraphQLGroupJoinState m22251o() {
                this.f21312i = (GraphQLGroupJoinState) super.b(this.f21312i, 5, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f21312i;
            }

            private void m22238a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f21312i = graphQLGroupJoinState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                }
            }

            @Nullable
            public final String m22242a() {
                return m22249m();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m22241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22246j() != null) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m22246j());
                    if (m22246j() != coverPhotoModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21307d = coverPhotoModel;
                    }
                }
                if (m22247k() != null) {
                    GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m22247k());
                    if (m22247k() != groupMembersModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f21308e = groupMembersModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22240a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m22246j());
                int a2 = ModelHelper.a(flatBufferBuilder, m22247k());
                int b = flatBufferBuilder.b(m22249m());
                int b2 = flatBufferBuilder.b(m22250n());
                int a3 = flatBufferBuilder.a(m22251o());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.a(2, this.f21309f, 0);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m22243a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f21309f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: UserIdentification */
        public class Serializer extends JsonSerializer<FB4ADiscoverRowDataModel> {
            public final void m22252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FB4ADiscoverRowDataModel fB4ADiscoverRowDataModel = (FB4ADiscoverRowDataModel) obj;
                if (fB4ADiscoverRowDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fB4ADiscoverRowDataModel.m22258a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fB4ADiscoverRowDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FB4ADiscoverRowDataParser.m22304b(fB4ADiscoverRowDataModel.w_(), fB4ADiscoverRowDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FB4ADiscoverRowDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UserIdentification */
        public final class SuggestionContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f21313d;

            /* compiled from: UserIdentification */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestionContextModel.class, new Deserializer());
                }

                public Object m22253a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestionContextParser.m22301a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestionContextModel = new SuggestionContextModel();
                    ((BaseModel) suggestionContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestionContextModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestionContextModel).a();
                    }
                    return suggestionContextModel;
                }
            }

            /* compiled from: UserIdentification */
            public class Serializer extends JsonSerializer<SuggestionContextModel> {
                public final void m22254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestionContextModel suggestionContextModel = (SuggestionContextModel) obj;
                    if (suggestionContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestionContextModel.m22255a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestionContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestionContextParser.m22302a(suggestionContextModel.w_(), suggestionContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestionContextModel.class, new Serializer());
                }
            }

            public SuggestionContextModel() {
                super(1);
            }

            @Nullable
            public final String m22257a() {
                this.f21313d = super.a(this.f21313d, 0);
                return this.f21313d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m22256a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m22255a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m22257a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FB4ADiscoverRowDataModel() {
            super(3);
        }

        public FB4ADiscoverRowDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final NodeModel m22260a() {
            this.f21314d = (NodeModel) super.a(this.f21314d, 0, NodeModel.class);
            return this.f21314d;
        }

        @Nullable
        public final SuggestionContextModel m22261j() {
            this.f21315e = (SuggestionContextModel) super.a(this.f21315e, 1, SuggestionContextModel.class);
            return this.f21315e;
        }

        @Nullable
        public final String m22262k() {
            this.f21316f = super.a(this.f21316f, 2);
            return this.f21316f;
        }

        public final int jK_() {
            return 770527045;
        }

        public final GraphQLVisitableModel m22259a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22260a() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m22260a());
                if (m22260a() != nodeModel) {
                    graphQLVisitableModel = (FB4ADiscoverRowDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21314d = nodeModel;
                }
            }
            if (m22261j() != null) {
                SuggestionContextModel suggestionContextModel = (SuggestionContextModel) graphQLModelMutatingVisitor.b(m22261j());
                if (m22261j() != suggestionContextModel) {
                    graphQLVisitableModel = (FB4ADiscoverRowDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21315e = suggestionContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22258a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22260a());
            int a2 = ModelHelper.a(flatBufferBuilder, m22261j());
            int b = flatBufferBuilder.b(m22262k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1440869715)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UserIdentification */
    public final class FetchSuggestedGroupsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupsYouShouldJoinModel f21325d;

        /* compiled from: UserIdentification */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSuggestedGroupsModel.class, new Deserializer());
            }

            public Object m22263a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchSuggestedGroupsParser.m22309a(jsonParser);
                Object fetchSuggestedGroupsModel = new FetchSuggestedGroupsModel();
                ((BaseModel) fetchSuggestedGroupsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchSuggestedGroupsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSuggestedGroupsModel).a();
                }
                return fetchSuggestedGroupsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 707101753)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: UserIdentification */
        public final class GroupsYouShouldJoinModel extends BaseModel implements GraphQLVisitableModel {
            private int f21322d;
            @Nullable
            private List<FB4ADiscoverRowDataModel> f21323e;
            @Nullable
            private PageInfoModel f21324f;

            /* compiled from: UserIdentification */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupsYouShouldJoinModel.class, new Deserializer());
                }

                public Object m22264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupsYouShouldJoinParser.m22307a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupsYouShouldJoinModel = new GroupsYouShouldJoinModel();
                    ((BaseModel) groupsYouShouldJoinModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupsYouShouldJoinModel instanceof Postprocessable) {
                        return ((Postprocessable) groupsYouShouldJoinModel).a();
                    }
                    return groupsYouShouldJoinModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1536830492)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: UserIdentification */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f21317d;
                @Nullable
                private String f21318e;
                private boolean f21319f;
                private boolean f21320g;
                @Nullable
                private String f21321h;

                /* compiled from: UserIdentification */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m22265a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m22305a(jsonParser, flatBufferBuilder));
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

                /* compiled from: UserIdentification */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m22266a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m22269a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m22306a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(5);
                }

                @Nullable
                private String m22267k() {
                    this.f21317d = super.a(this.f21317d, 0);
                    return this.f21317d;
                }

                @Nullable
                public final String m22271a() {
                    this.f21318e = super.a(this.f21318e, 1);
                    return this.f21318e;
                }

                public final boolean m22273j() {
                    a(0, 2);
                    return this.f21319f;
                }

                @Nullable
                private String m22268l() {
                    this.f21321h = super.a(this.f21321h, 4);
                    return this.f21321h;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m22270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m22269a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m22267k());
                    int b2 = flatBufferBuilder.b(m22271a());
                    int b3 = flatBufferBuilder.b(m22268l());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.a(2, this.f21319f);
                    flatBufferBuilder.a(3, this.f21320g);
                    flatBufferBuilder.b(4, b3);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m22272a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f21319f = mutableFlatBuffer.a(i, 2);
                    this.f21320g = mutableFlatBuffer.a(i, 3);
                }
            }

            /* compiled from: UserIdentification */
            public class Serializer extends JsonSerializer<GroupsYouShouldJoinModel> {
                public final void m22274a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupsYouShouldJoinModel groupsYouShouldJoinModel = (GroupsYouShouldJoinModel) obj;
                    if (groupsYouShouldJoinModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupsYouShouldJoinModel.m22276a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupsYouShouldJoinModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupsYouShouldJoinParser.m22308a(groupsYouShouldJoinModel.w_(), groupsYouShouldJoinModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupsYouShouldJoinModel.class, new Serializer());
                }
            }

            public GroupsYouShouldJoinModel() {
                super(3);
            }

            public final int m22275a() {
                a(0, 0);
                return this.f21322d;
            }

            @Nonnull
            public final ImmutableList<FB4ADiscoverRowDataModel> m22279j() {
                this.f21323e = super.a(this.f21323e, 1, FB4ADiscoverRowDataModel.class);
                return (ImmutableList) this.f21323e;
            }

            @Nullable
            public final PageInfoModel m22280k() {
                this.f21324f = (PageInfoModel) super.a(this.f21324f, 2, PageInfoModel.class);
                return this.f21324f;
            }

            public final int jK_() {
                return 1915034214;
            }

            public final GraphQLVisitableModel m22277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m22279j() != null) {
                    Builder a = ModelHelper.a(m22279j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        GroupsYouShouldJoinModel groupsYouShouldJoinModel = (GroupsYouShouldJoinModel) ModelHelper.a(null, this);
                        groupsYouShouldJoinModel.f21323e = a.b();
                        graphQLVisitableModel = groupsYouShouldJoinModel;
                        if (m22280k() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m22280k());
                            if (m22280k() != pageInfoModel) {
                                graphQLVisitableModel = (GroupsYouShouldJoinModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f21324f = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m22280k() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m22280k());
                    if (m22280k() != pageInfoModel) {
                        graphQLVisitableModel = (GroupsYouShouldJoinModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f21324f = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m22276a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m22279j());
                int a2 = ModelHelper.a(flatBufferBuilder, m22280k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f21322d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m22278a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f21322d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: UserIdentification */
        public class Serializer extends JsonSerializer<FetchSuggestedGroupsModel> {
            public final void m22281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchSuggestedGroupsModel fetchSuggestedGroupsModel = (FetchSuggestedGroupsModel) obj;
                if (fetchSuggestedGroupsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSuggestedGroupsModel.m22282a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSuggestedGroupsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchSuggestedGroupsModel.w_();
                int u_ = fetchSuggestedGroupsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("groups_you_should_join");
                    GroupsYouShouldJoinParser.m22308a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchSuggestedGroupsModel.class, new Serializer());
            }
        }

        public FetchSuggestedGroupsModel() {
            super(1);
        }

        @Nullable
        public final GroupsYouShouldJoinModel m22284a() {
            this.f21325d = (GroupsYouShouldJoinModel) super.a(this.f21325d, 0, GroupsYouShouldJoinModel.class);
            return this.f21325d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m22283a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22284a() != null) {
                GroupsYouShouldJoinModel groupsYouShouldJoinModel = (GroupsYouShouldJoinModel) graphQLModelMutatingVisitor.b(m22284a());
                if (m22284a() != groupsYouShouldJoinModel) {
                    graphQLVisitableModel = (FetchSuggestedGroupsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21325d = groupsYouShouldJoinModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22282a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22284a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
