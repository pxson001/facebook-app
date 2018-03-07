package com.facebook.groups.sideshow.graphql;

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
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser.GroupsParser;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser.GroupsParser.NodesParser;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser.GroupsParser.NodesParser.CoverPhotoParser;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser.GroupsParser.NodesParser.CoverPhotoParser.PhotoParser;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser.GroupsParser.NodesParser.CoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLParsers.FetchRecentActiveGroupsQueryParser.GroupsParser.NodesParser.GroupFeedParser;
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

/* compiled from: window.__fbPlatDialogHost.%1$s() */
public class FetchRecentActiveGroupsDataQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -640186423)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: window.__fbPlatDialogHost.%1$s() */
    public final class FetchRecentActiveGroupsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupsModel f333d;

        /* compiled from: window.__fbPlatDialogHost.%1$s() */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchRecentActiveGroupsQueryModel.class, new Deserializer());
            }

            public Object m415a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchRecentActiveGroupsQueryParser.m472a(jsonParser);
                Object fetchRecentActiveGroupsQueryModel = new FetchRecentActiveGroupsQueryModel();
                ((BaseModel) fetchRecentActiveGroupsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchRecentActiveGroupsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchRecentActiveGroupsQueryModel).a();
                }
                return fetchRecentActiveGroupsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1416384088)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: window.__fbPlatDialogHost.%1$s() */
        public final class GroupsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f332d;

            /* compiled from: window.__fbPlatDialogHost.%1$s() */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupsModel.class, new Deserializer());
                }

                public Object m416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupsParser.m470a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupsModel = new GroupsModel();
                    ((BaseModel) groupsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupsModel instanceof Postprocessable) {
                        return ((Postprocessable) groupsModel).a();
                    }
                    return groupsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1974325609)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: window.__fbPlatDialogHost.%1$s() */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private CoverPhotoModel f328d;
                @Nullable
                private GroupFeedModel f329e;
                @Nullable
                private String f330f;
                @Nullable
                private String f331g;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1758898405)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: window.__fbPlatDialogHost.%1$s() */
                public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private PhotoModel f326d;

                    /* compiled from: window.__fbPlatDialogHost.%1$s() */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                        }

                        public Object m417a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(CoverPhotoParser.m464a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 2132855053)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: window.__fbPlatDialogHost.%1$s() */
                    public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private ImageModel f325d;

                        /* compiled from: window.__fbPlatDialogHost.%1$s() */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                            }

                            public Object m418a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(PhotoParser.m462a(jsonParser, flatBufferBuilder));
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
                        /* compiled from: window.__fbPlatDialogHost.%1$s() */
                        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f324d;

                            /* compiled from: window.__fbPlatDialogHost.%1$s() */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                                }

                                public Object m419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ImageParser.m460a(jsonParser, flatBufferBuilder));
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

                            /* compiled from: window.__fbPlatDialogHost.%1$s() */
                            public class Serializer extends JsonSerializer<ImageModel> {
                                public final void m420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ImageModel imageModel = (ImageModel) obj;
                                    if (imageModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(imageModel.m421a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ImageParser.m461a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                                }
                            }

                            public ImageModel() {
                                super(1);
                            }

                            @Nullable
                            public final String m423a() {
                                this.f324d = super.a(this.f324d, 0);
                                return this.f324d;
                            }

                            public final int jK_() {
                                return 70760763;
                            }

                            public final GraphQLVisitableModel m422a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m421a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m423a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: window.__fbPlatDialogHost.%1$s() */
                        public class Serializer extends JsonSerializer<PhotoModel> {
                            public final void m424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                PhotoModel photoModel = (PhotoModel) obj;
                                if (photoModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(photoModel.m425a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                PhotoParser.m463a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(PhotoModel.class, new Serializer());
                            }
                        }

                        public PhotoModel() {
                            super(1);
                        }

                        @Nullable
                        public final ImageModel m427a() {
                            this.f325d = (ImageModel) super.a(this.f325d, 0, ImageModel.class);
                            return this.f325d;
                        }

                        public final int jK_() {
                            return 77090322;
                        }

                        public final GraphQLVisitableModel m426a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m427a() != null) {
                                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m427a());
                                if (m427a() != imageModel) {
                                    graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f325d = imageModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m425a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m427a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: window.__fbPlatDialogHost.%1$s() */
                    public class Serializer extends JsonSerializer<CoverPhotoModel> {
                        public final void m428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                            if (coverPhotoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(coverPhotoModel.m429a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            CoverPhotoParser.m465a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                        }
                    }

                    public CoverPhotoModel() {
                        super(1);
                    }

                    @Nullable
                    public final PhotoModel m431a() {
                        this.f326d = (PhotoModel) super.a(this.f326d, 0, PhotoModel.class);
                        return this.f326d;
                    }

                    public final int jK_() {
                        return 497264923;
                    }

                    public final GraphQLVisitableModel m430a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m431a() != null) {
                            PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m431a());
                            if (m431a() != photoModel) {
                                graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f326d = photoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m429a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m431a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: window.__fbPlatDialogHost.%1$s() */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m468b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 179261320)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: window.__fbPlatDialogHost.%1$s() */
                public final class GroupFeedModel extends BaseModel implements GraphQLVisitableModel {
                    private int f327d;

                    /* compiled from: window.__fbPlatDialogHost.%1$s() */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(GroupFeedModel.class, new Deserializer());
                        }

                        public Object m433a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(GroupFeedParser.m466a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object groupFeedModel = new GroupFeedModel();
                            ((BaseModel) groupFeedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (groupFeedModel instanceof Postprocessable) {
                                return ((Postprocessable) groupFeedModel).a();
                            }
                            return groupFeedModel;
                        }
                    }

                    /* compiled from: window.__fbPlatDialogHost.%1$s() */
                    public class Serializer extends JsonSerializer<GroupFeedModel> {
                        public final void m434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            GroupFeedModel groupFeedModel = (GroupFeedModel) obj;
                            if (groupFeedModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(groupFeedModel.m436a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                groupFeedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            GroupFeedParser.m467a(groupFeedModel.w_(), groupFeedModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(GroupFeedModel.class, new Serializer());
                        }
                    }

                    public GroupFeedModel() {
                        super(1);
                    }

                    public final int m435a() {
                        a(0, 0);
                        return this.f327d;
                    }

                    public final int jK_() {
                        return 1273041755;
                    }

                    public final GraphQLVisitableModel m437a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m436a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f327d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m438a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f327d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                /* compiled from: window.__fbPlatDialogHost.%1$s() */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m441a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m469b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(4);
                }

                public final void m444a(String str, ConsistencyTuple consistencyTuple) {
                    if ("name".equals(str)) {
                        consistencyTuple.a = m449m();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 3;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m445a(String str, Object obj, boolean z) {
                    if ("name".equals(str)) {
                        m440a((String) obj);
                    }
                }

                @Nullable
                public final CoverPhotoModel m446j() {
                    this.f328d = (CoverPhotoModel) super.a(this.f328d, 0, CoverPhotoModel.class);
                    return this.f328d;
                }

                @Nullable
                public final GroupFeedModel m447k() {
                    this.f329e = (GroupFeedModel) super.a(this.f329e, 1, GroupFeedModel.class);
                    return this.f329e;
                }

                @Nullable
                public final String m448l() {
                    this.f330f = super.a(this.f330f, 2);
                    return this.f330f;
                }

                @Nullable
                public final String m449m() {
                    this.f331g = super.a(this.f331g, 3);
                    return this.f331g;
                }

                private void m440a(@Nullable String str) {
                    this.f331g = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 3, str);
                    }
                }

                @Nullable
                public final String m443a() {
                    return m448l();
                }

                public final int jK_() {
                    return 69076575;
                }

                public final GraphQLVisitableModel m442a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m446j() != null) {
                        CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m446j());
                        if (m446j() != coverPhotoModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f328d = coverPhotoModel;
                        }
                    }
                    if (m447k() != null) {
                        GroupFeedModel groupFeedModel = (GroupFeedModel) graphQLModelMutatingVisitor.b(m447k());
                        if (m447k() != groupFeedModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f329e = groupFeedModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m441a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m446j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m447k());
                    int b = flatBufferBuilder.b(m448l());
                    int b2 = flatBufferBuilder.b(m449m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: window.__fbPlatDialogHost.%1$s() */
            public class Serializer extends JsonSerializer<GroupsModel> {
                public final void m450a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupsModel groupsModel = (GroupsModel) obj;
                    if (groupsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupsModel.m451a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupsParser.m471a(groupsModel.w_(), groupsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupsModel.class, new Serializer());
                }
            }

            public GroupsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m453a() {
                this.f332d = super.a(this.f332d, 0, NodesModel.class);
                return (ImmutableList) this.f332d;
            }

            public final int jK_() {
                return 222380018;
            }

            public final GraphQLVisitableModel m452a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m453a() != null) {
                    Builder a = ModelHelper.a(m453a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f332d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m451a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m453a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: window.__fbPlatDialogHost.%1$s() */
        public class Serializer extends JsonSerializer<FetchRecentActiveGroupsQueryModel> {
            public final void m454a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchRecentActiveGroupsQueryModel fetchRecentActiveGroupsQueryModel = (FetchRecentActiveGroupsQueryModel) obj;
                if (fetchRecentActiveGroupsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchRecentActiveGroupsQueryModel.m455a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchRecentActiveGroupsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchRecentActiveGroupsQueryModel.w_();
                int u_ = fetchRecentActiveGroupsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("groups");
                    GroupsParser.m471a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchRecentActiveGroupsQueryModel.class, new Serializer());
            }
        }

        public FetchRecentActiveGroupsQueryModel() {
            super(1);
        }

        public final void m458a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m459a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GroupsModel m457a() {
            this.f333d = (GroupsModel) super.a(this.f333d, 0, GroupsModel.class);
            return this.f333d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m456a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m457a() != null) {
                GroupsModel groupsModel = (GroupsModel) graphQLModelMutatingVisitor.b(m457a());
                if (m457a() != groupsModel) {
                    graphQLVisitableModel = (FetchRecentActiveGroupsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f333d = groupsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m455a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m457a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
