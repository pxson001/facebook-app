package com.facebook.groups.widget.groupgriditem.protocol;

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
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupFeedParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupItemCoverPhotoParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupItemCoverPhotoParser.PhotoParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentParsers.GroupsGroupGridItemFragmentParser.GroupItemCoverPhotoParser.PhotoParser.ImageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_context_item_click */
public class GroupsGroupGridItemFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1109991667)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_context_item_click */
    public final class GroupsGroupGridItemFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GroupItemCoverPhotoModel f5945d;
        @Nullable
        private GroupFeedModel f5946e;
        @Nullable
        private String f5947f;
        @Nullable
        private String f5948g;

        /* compiled from: profile_context_item_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupsGroupGridItemFragmentModel.class, new Deserializer());
            }

            public Object m7562a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupsGroupGridItemFragmentParser.m7603a(jsonParser);
                Object groupsGroupGridItemFragmentModel = new GroupsGroupGridItemFragmentModel();
                ((BaseModel) groupsGroupGridItemFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupsGroupGridItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupsGroupGridItemFragmentModel).a();
                }
                return groupsGroupGridItemFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 179261320)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_context_item_click */
        public final class GroupFeedModel extends BaseModel implements GraphQLVisitableModel {
            private int f5941d;

            /* compiled from: profile_context_item_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupFeedModel.class, new Deserializer());
                }

                public Object m7563a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupFeedParser.m7595a(jsonParser, flatBufferBuilder));
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

            /* compiled from: profile_context_item_click */
            public class Serializer extends JsonSerializer<GroupFeedModel> {
                public final void m7564a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupFeedModel groupFeedModel = (GroupFeedModel) obj;
                    if (groupFeedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupFeedModel.m7566a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupFeedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupFeedParser.m7596a(groupFeedModel.w_(), groupFeedModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupFeedModel.class, new Serializer());
                }
            }

            public GroupFeedModel() {
                super(1);
            }

            public final int m7565a() {
                a(0, 0);
                return this.f5941d;
            }

            public final int jK_() {
                return 1273041755;
            }

            public final GraphQLVisitableModel m7567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7566a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5941d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7568a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5941d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 82366530)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_context_item_click */
        public final class GroupItemCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f5944d;

            /* compiled from: profile_context_item_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupItemCoverPhotoModel.class, new Deserializer());
                }

                public Object m7569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupItemCoverPhotoParser.m7601a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupItemCoverPhotoModel = new GroupItemCoverPhotoModel();
                    ((BaseModel) groupItemCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupItemCoverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) groupItemCoverPhotoModel).a();
                    }
                    return groupItemCoverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 480966798)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_context_item_click */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f5943d;

                /* compiled from: profile_context_item_click */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m7570a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m7599a(jsonParser, flatBufferBuilder));
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
                /* compiled from: profile_context_item_click */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5942d;

                    /* compiled from: profile_context_item_click */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m7571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m7597a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: profile_context_item_click */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m7572a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m7573a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m7598a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m7575a() {
                        this.f5942d = super.a(this.f5942d, 0);
                        return this.f5942d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m7574a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m7573a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m7575a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile_context_item_click */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m7576a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m7577a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m7600a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(1);
                }

                @Nullable
                public final ImageModel m7579a() {
                    this.f5943d = (ImageModel) super.a(this.f5943d, 0, ImageModel.class);
                    return this.f5943d;
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m7578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7579a() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m7579a());
                        if (m7579a() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5943d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7577a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7579a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile_context_item_click */
            public class Serializer extends JsonSerializer<GroupItemCoverPhotoModel> {
                public final void m7580a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupItemCoverPhotoModel groupItemCoverPhotoModel = (GroupItemCoverPhotoModel) obj;
                    if (groupItemCoverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupItemCoverPhotoModel.m7581a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupItemCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupItemCoverPhotoParser.m7602a(groupItemCoverPhotoModel.w_(), groupItemCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupItemCoverPhotoModel.class, new Serializer());
                }
            }

            public GroupItemCoverPhotoModel() {
                super(1);
            }

            @Nullable
            public final PhotoModel m7583a() {
                this.f5944d = (PhotoModel) super.a(this.f5944d, 0, PhotoModel.class);
                return this.f5944d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m7582a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7583a() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m7583a());
                    if (m7583a() != photoModel) {
                        graphQLVisitableModel = (GroupItemCoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5944d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7581a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7583a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile_context_item_click */
        public class Serializer extends JsonSerializer<GroupsGroupGridItemFragmentModel> {
            public final void m7584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupsGroupGridItemFragmentModel groupsGroupGridItemFragmentModel = (GroupsGroupGridItemFragmentModel) obj;
                if (groupsGroupGridItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupsGroupGridItemFragmentModel.m7590a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupsGroupGridItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupsGroupGridItemFragmentModel.w_();
                int u_ = groupsGroupGridItemFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("groupItemCoverPhoto");
                    GroupItemCoverPhotoParser.m7602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("group_feed");
                    GroupFeedParser.m7596a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupsGroupGridItemFragmentModel.class, new Serializer());
            }
        }

        public GroupsGroupGridItemFragmentModel() {
            super(4);
        }

        public final void m7593a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m7589m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
                return;
            }
            consistencyTuple.a();
        }

        public final void m7594a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m7585a((String) obj);
            }
        }

        @Nullable
        private GroupItemCoverPhotoModel m7586j() {
            this.f5945d = (GroupItemCoverPhotoModel) super.a(this.f5945d, 0, GroupItemCoverPhotoModel.class);
            return this.f5945d;
        }

        @Nullable
        private GroupFeedModel m7587k() {
            this.f5946e = (GroupFeedModel) super.a(this.f5946e, 1, GroupFeedModel.class);
            return this.f5946e;
        }

        @Nullable
        private String m7588l() {
            this.f5947f = super.a(this.f5947f, 2);
            return this.f5947f;
        }

        @Nullable
        private String m7589m() {
            this.f5948g = super.a(this.f5948g, 3);
            return this.f5948g;
        }

        private void m7585a(@Nullable String str) {
            this.f5948g = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, str);
            }
        }

        @Nullable
        public final String m7592a() {
            return m7588l();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7591a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7586j() != null) {
                GroupItemCoverPhotoModel groupItemCoverPhotoModel = (GroupItemCoverPhotoModel) graphQLModelMutatingVisitor.b(m7586j());
                if (m7586j() != groupItemCoverPhotoModel) {
                    graphQLVisitableModel = (GroupsGroupGridItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5945d = groupItemCoverPhotoModel;
                }
            }
            if (m7587k() != null) {
                GroupFeedModel groupFeedModel = (GroupFeedModel) graphQLModelMutatingVisitor.b(m7587k());
                if (m7587k() != groupFeedModel) {
                    graphQLVisitableModel = (GroupsGroupGridItemFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5946e = groupFeedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7590a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7586j());
            int a2 = ModelHelper.a(flatBufferBuilder, m7587k());
            int b = flatBufferBuilder.b(m7588l());
            int b2 = flatBufferBuilder.b(m7589m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
