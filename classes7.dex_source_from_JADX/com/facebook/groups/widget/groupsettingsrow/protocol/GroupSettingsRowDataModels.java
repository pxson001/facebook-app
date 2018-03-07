package com.facebook.groups.widget.groupsettingsrow.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataInterfaces.GroupSettingsRowData;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataInterfaces.GroupSubscriptionData;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSettingsRowDataParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSettingsRowDataParser.SettingsRowCoverPhotoParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSettingsRowDataParser.SettingsRowCoverPhotoParser.PhotoParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSettingsRowDataParser.SettingsRowCoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSubscriptionDataParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSubscriptionDataParser.PossiblePushSubscriptionLevelsParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSubscriptionDataParser.PossiblePushSubscriptionLevelsParser.EdgesParser;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataParsers.GroupSubscriptionDataParser.PossibleSubscriptionLevelsParser;
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

/* compiled from: profile pic load state */
public class GroupSettingsRowDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1250676182)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile pic load state */
    public final class GroupSettingsRowDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GroupSettingsRowData {
        @Nullable
        private String f5966d;
        @Nullable
        private String f5967e;
        @Nullable
        private PossiblePushSubscriptionLevelsModel f5968f;
        @Nullable
        private PossibleSubscriptionLevelsModel f5969g;
        @Nullable
        private SettingsRowCoverPhotoModel f5970h;
        @Nullable
        private GraphQLGroupAdminType f5971i;
        @Nullable
        private GraphQLGroupPushSubscriptionLevel f5972j;
        @Nullable
        private GraphQLGroupRequestToJoinSubscriptionLevel f5973k;
        @Nullable
        private GraphQLGroupSubscriptionLevel f5974l;

        /* compiled from: profile pic load state */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSettingsRowDataModel.class, new Deserializer());
            }

            public Object m7606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSettingsRowDataParser.m7687a(jsonParser);
                Object groupSettingsRowDataModel = new GroupSettingsRowDataModel();
                ((BaseModel) groupSettingsRowDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSettingsRowDataModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSettingsRowDataModel).a();
                }
                return groupSettingsRowDataModel;
            }
        }

        /* compiled from: profile pic load state */
        public class Serializer extends JsonSerializer<GroupSettingsRowDataModel> {
            public final void m7607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupSettingsRowDataModel groupSettingsRowDataModel = (GroupSettingsRowDataModel) obj;
                if (groupSettingsRowDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSettingsRowDataModel.m7630a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSettingsRowDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupSettingsRowDataParser.m7688a(groupSettingsRowDataModel.w_(), groupSettingsRowDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupSettingsRowDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729739606)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile pic load state */
        public final class SettingsRowCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f5965d;

            /* compiled from: profile pic load state */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SettingsRowCoverPhotoModel.class, new Deserializer());
                }

                public Object m7608a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SettingsRowCoverPhotoParser.m7685a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object settingsRowCoverPhotoModel = new SettingsRowCoverPhotoModel();
                    ((BaseModel) settingsRowCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (settingsRowCoverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) settingsRowCoverPhotoModel).a();
                    }
                    return settingsRowCoverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2054825796)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile pic load state */
            public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ImageModel f5964d;

                /* compiled from: profile pic load state */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m7609a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m7683a(jsonParser, flatBufferBuilder));
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
                /* compiled from: profile pic load state */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5963d;

                    /* compiled from: profile pic load state */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m7610a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m7681a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: profile pic load state */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m7611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m7613a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m7682a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m7612a() {
                        this.f5963d = super.a(this.f5963d, 0);
                        return this.f5963d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m7614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m7613a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m7612a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile pic load state */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m7615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m7617a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m7684a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(1);
                }

                @Nullable
                private ImageModel m7616a() {
                    this.f5964d = (ImageModel) super.a(this.f5964d, 0, ImageModel.class);
                    return this.f5964d;
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m7618a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7616a() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m7616a());
                        if (m7616a() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5964d = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7617a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7616a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile pic load state */
            public class Serializer extends JsonSerializer<SettingsRowCoverPhotoModel> {
                public final void m7619a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SettingsRowCoverPhotoModel settingsRowCoverPhotoModel = (SettingsRowCoverPhotoModel) obj;
                    if (settingsRowCoverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(settingsRowCoverPhotoModel.m7621a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        settingsRowCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SettingsRowCoverPhotoParser.m7686a(settingsRowCoverPhotoModel.w_(), settingsRowCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SettingsRowCoverPhotoModel.class, new Serializer());
                }
            }

            public SettingsRowCoverPhotoModel() {
                super(1);
            }

            @Nullable
            private PhotoModel m7620a() {
                this.f5965d = (PhotoModel) super.a(this.f5965d, 0, PhotoModel.class);
                return this.f5965d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m7622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7620a() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m7620a());
                    if (m7620a() != photoModel) {
                        graphQLVisitableModel = (SettingsRowCoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5965d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7621a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7620a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ PossiblePushSubscriptionLevelsModel mo325c() {
            return m7627k();
        }

        @Nullable
        public final /* synthetic */ PossibleSubscriptionLevelsModel mo326d() {
            return m7628l();
        }

        public GroupSettingsRowDataModel() {
            super(9);
        }

        public final void m7633a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = mo324b();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("viewer_push_subscription_level".equals(str)) {
                consistencyTuple.a = hc_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
            } else if ("viewer_subscription_level".equals(str)) {
                consistencyTuple.a = hd_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m7634a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m7625a((String) obj);
            } else if ("viewer_push_subscription_level".equals(str)) {
                m7623a((GraphQLGroupPushSubscriptionLevel) obj);
            } else if ("viewer_subscription_level".equals(str)) {
                m7624a((GraphQLGroupSubscriptionLevel) obj);
            }
        }

        @Nullable
        private String m7626j() {
            this.f5966d = super.a(this.f5966d, 0);
            return this.f5966d;
        }

        @Nullable
        public final String mo324b() {
            this.f5967e = super.a(this.f5967e, 1);
            return this.f5967e;
        }

        private void m7625a(@Nullable String str) {
            this.f5967e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        @Nullable
        private PossiblePushSubscriptionLevelsModel m7627k() {
            this.f5968f = (PossiblePushSubscriptionLevelsModel) super.a(this.f5968f, 2, PossiblePushSubscriptionLevelsModel.class);
            return this.f5968f;
        }

        @Nullable
        private PossibleSubscriptionLevelsModel m7628l() {
            this.f5969g = (PossibleSubscriptionLevelsModel) super.a(this.f5969g, 3, PossibleSubscriptionLevelsModel.class);
            return this.f5969g;
        }

        @Nullable
        private SettingsRowCoverPhotoModel m7629m() {
            this.f5970h = (SettingsRowCoverPhotoModel) super.a(this.f5970h, 4, SettingsRowCoverPhotoModel.class);
            return this.f5970h;
        }

        @Nullable
        public final GraphQLGroupAdminType mo330n() {
            this.f5971i = (GraphQLGroupAdminType) super.b(this.f5971i, 5, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5971i;
        }

        @Nullable
        public final GraphQLGroupPushSubscriptionLevel hc_() {
            this.f5972j = (GraphQLGroupPushSubscriptionLevel) super.b(this.f5972j, 6, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5972j;
        }

        private void m7623a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            this.f5972j = graphQLGroupPushSubscriptionLevel;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, graphQLGroupPushSubscriptionLevel != null ? graphQLGroupPushSubscriptionLevel.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupRequestToJoinSubscriptionLevel mo327g() {
            this.f5973k = (GraphQLGroupRequestToJoinSubscriptionLevel) super.b(this.f5973k, 7, GraphQLGroupRequestToJoinSubscriptionLevel.class, GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5973k;
        }

        @Nullable
        public final GraphQLGroupSubscriptionLevel hd_() {
            this.f5974l = (GraphQLGroupSubscriptionLevel) super.b(this.f5974l, 8, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5974l;
        }

        private void m7624a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
            this.f5974l = graphQLGroupSubscriptionLevel;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, graphQLGroupSubscriptionLevel != null ? graphQLGroupSubscriptionLevel.name() : null);
            }
        }

        @Nullable
        public final String m7632a() {
            return m7626j();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7631a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7627k() != null) {
                PossiblePushSubscriptionLevelsModel possiblePushSubscriptionLevelsModel = (PossiblePushSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7627k());
                if (m7627k() != possiblePushSubscriptionLevelsModel) {
                    graphQLVisitableModel = (GroupSettingsRowDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5968f = possiblePushSubscriptionLevelsModel;
                }
            }
            if (m7628l() != null) {
                PossibleSubscriptionLevelsModel possibleSubscriptionLevelsModel = (PossibleSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7628l());
                if (m7628l() != possibleSubscriptionLevelsModel) {
                    graphQLVisitableModel = (GroupSettingsRowDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5969g = possibleSubscriptionLevelsModel;
                }
            }
            if (m7629m() != null) {
                SettingsRowCoverPhotoModel settingsRowCoverPhotoModel = (SettingsRowCoverPhotoModel) graphQLModelMutatingVisitor.b(m7629m());
                if (m7629m() != settingsRowCoverPhotoModel) {
                    graphQLVisitableModel = (GroupSettingsRowDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5970h = settingsRowCoverPhotoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7630a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7626j());
            int b2 = flatBufferBuilder.b(mo324b());
            int a = ModelHelper.a(flatBufferBuilder, m7627k());
            int a2 = ModelHelper.a(flatBufferBuilder, m7628l());
            int a3 = ModelHelper.a(flatBufferBuilder, m7629m());
            int a4 = flatBufferBuilder.a(mo330n());
            int a5 = flatBufferBuilder.a(hc_());
            int a6 = flatBufferBuilder.a(mo327g());
            int a7 = flatBufferBuilder.a(hd_());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 852165712)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile pic load state */
    public final class GroupSubscriptionDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GroupSubscriptionData {
        @Nullable
        private String f5982d;
        @Nullable
        private String f5983e;
        @Nullable
        private PossiblePushSubscriptionLevelsModel f5984f;
        @Nullable
        private PossibleSubscriptionLevelsModel f5985g;
        @Nullable
        private GraphQLGroupAdminType f5986h;
        @Nullable
        private GraphQLGroupPushSubscriptionLevel f5987i;
        @Nullable
        private GraphQLGroupRequestToJoinSubscriptionLevel f5988j;
        @Nullable
        private GraphQLGroupSubscriptionLevel f5989k;

        /* compiled from: profile pic load state */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupSubscriptionDataModel.class, new Deserializer());
            }

            public Object m7640a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupSubscriptionDataParser.m7697a(jsonParser);
                Object groupSubscriptionDataModel = new GroupSubscriptionDataModel();
                ((BaseModel) groupSubscriptionDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupSubscriptionDataModel instanceof Postprocessable) {
                    return ((Postprocessable) groupSubscriptionDataModel).a();
                }
                return groupSubscriptionDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2053421740)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile pic load state */
        public final class PossiblePushSubscriptionLevelsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5977d;

            /* compiled from: profile pic load state */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PossiblePushSubscriptionLevelsModel.class, new Deserializer());
                }

                public Object m7641a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PossiblePushSubscriptionLevelsParser.m7691a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object possiblePushSubscriptionLevelsModel = new PossiblePushSubscriptionLevelsModel();
                    ((BaseModel) possiblePushSubscriptionLevelsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (possiblePushSubscriptionLevelsModel instanceof Postprocessable) {
                        return ((Postprocessable) possiblePushSubscriptionLevelsModel).a();
                    }
                    return possiblePushSubscriptionLevelsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -114794976)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile pic load state */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f5975d;
                @Nullable
                private GraphQLGroupPushSubscriptionLevel f5976e;

                /* compiled from: profile pic load state */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m7642a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m7690b(jsonParser, flatBufferBuilder));
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

                /* compiled from: profile pic load state */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m7643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m7644a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m7689a(edgesModel.w_(), edgesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                @Nullable
                public final String m7646a() {
                    this.f5975d = super.a(this.f5975d, 0);
                    return this.f5975d;
                }

                @Nullable
                public final GraphQLGroupPushSubscriptionLevel m7647b() {
                    this.f5976e = (GraphQLGroupPushSubscriptionLevel) super.b(this.f5976e, 1, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f5976e;
                }

                public final int jK_() {
                    return -1320639934;
                }

                public final GraphQLVisitableModel m7645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7644a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7646a());
                    int a = flatBufferBuilder.a(m7647b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile pic load state */
            public class Serializer extends JsonSerializer<PossiblePushSubscriptionLevelsModel> {
                public final void m7648a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PossiblePushSubscriptionLevelsModel possiblePushSubscriptionLevelsModel = (PossiblePushSubscriptionLevelsModel) obj;
                    if (possiblePushSubscriptionLevelsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(possiblePushSubscriptionLevelsModel.m7649a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        possiblePushSubscriptionLevelsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PossiblePushSubscriptionLevelsParser.m7692a(possiblePushSubscriptionLevelsModel.w_(), possiblePushSubscriptionLevelsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PossiblePushSubscriptionLevelsModel.class, new Serializer());
                }
            }

            public PossiblePushSubscriptionLevelsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m7651a() {
                this.f5977d = super.a(this.f5977d, 0, EdgesModel.class);
                return (ImmutableList) this.f5977d;
            }

            public final int jK_() {
                return -876381277;
            }

            public final GraphQLVisitableModel m7650a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7651a() != null) {
                    Builder a = ModelHelper.a(m7651a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PossiblePushSubscriptionLevelsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5977d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7649a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7651a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -26802724)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile pic load state */
        public final class PossibleSubscriptionLevelsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f5981d;

            /* compiled from: profile pic load state */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PossibleSubscriptionLevelsModel.class, new Deserializer());
                }

                public Object m7652a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PossibleSubscriptionLevelsParser.m7695a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object possibleSubscriptionLevelsModel = new PossibleSubscriptionLevelsModel();
                    ((BaseModel) possibleSubscriptionLevelsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (possibleSubscriptionLevelsModel instanceof Postprocessable) {
                        return ((Postprocessable) possibleSubscriptionLevelsModel).a();
                    }
                    return possibleSubscriptionLevelsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1228671481)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile pic load state */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f5978d;
                @Nullable
                private String f5979e;
                @Nullable
                private GraphQLGroupSubscriptionLevel f5980f;

                /* compiled from: profile pic load state */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m7653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PossibleSubscriptionLevelsParser.EdgesParser.m7694b(jsonParser, flatBufferBuilder));
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

                /* compiled from: profile pic load state */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m7654a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m7655a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PossibleSubscriptionLevelsParser.EdgesParser.m7693a(edgesModel.w_(), edgesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                public final String m7657a() {
                    this.f5978d = super.a(this.f5978d, 0);
                    return this.f5978d;
                }

                @Nullable
                public final String m7658b() {
                    this.f5979e = super.a(this.f5979e, 1);
                    return this.f5979e;
                }

                @Nullable
                public final GraphQLGroupSubscriptionLevel m7659c() {
                    this.f5980f = (GraphQLGroupSubscriptionLevel) super.b(this.f5980f, 2, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f5980f;
                }

                public final int jK_() {
                    return -537416184;
                }

                public final GraphQLVisitableModel m7656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7655a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7657a());
                    int b2 = flatBufferBuilder.b(m7658b());
                    int a = flatBufferBuilder.a(m7659c());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile pic load state */
            public class Serializer extends JsonSerializer<PossibleSubscriptionLevelsModel> {
                public final void m7660a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PossibleSubscriptionLevelsModel possibleSubscriptionLevelsModel = (PossibleSubscriptionLevelsModel) obj;
                    if (possibleSubscriptionLevelsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(possibleSubscriptionLevelsModel.m7661a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        possibleSubscriptionLevelsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PossibleSubscriptionLevelsParser.m7696a(possibleSubscriptionLevelsModel.w_(), possibleSubscriptionLevelsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PossibleSubscriptionLevelsModel.class, new Serializer());
                }
            }

            public PossibleSubscriptionLevelsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m7663a() {
                this.f5981d = super.a(this.f5981d, 0, EdgesModel.class);
                return (ImmutableList) this.f5981d;
            }

            public final int jK_() {
                return -909108503;
            }

            public final GraphQLVisitableModel m7662a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7663a() != null) {
                    Builder a = ModelHelper.a(m7663a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PossibleSubscriptionLevelsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5981d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7661a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7663a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile pic load state */
        public class Serializer extends JsonSerializer<GroupSubscriptionDataModel> {
            public final void m7664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupSubscriptionDataModel groupSubscriptionDataModel = (GroupSubscriptionDataModel) obj;
                if (groupSubscriptionDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupSubscriptionDataModel.m7671a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupSubscriptionDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupSubscriptionDataParser.m7698a(groupSubscriptionDataModel.w_(), groupSubscriptionDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupSubscriptionDataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PossiblePushSubscriptionLevelsModel mo325c() {
            return m7669k();
        }

        @Nullable
        public final /* synthetic */ PossibleSubscriptionLevelsModel mo326d() {
            return m7670l();
        }

        public GroupSubscriptionDataModel() {
            super(8);
        }

        public final void m7674a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = mo324b();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("viewer_push_subscription_level".equals(str)) {
                consistencyTuple.a = hc_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("viewer_subscription_level".equals(str)) {
                consistencyTuple.a = hd_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m7675a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m7667a((String) obj);
            } else if ("viewer_push_subscription_level".equals(str)) {
                m7665a((GraphQLGroupPushSubscriptionLevel) obj);
            } else if ("viewer_subscription_level".equals(str)) {
                m7666a((GraphQLGroupSubscriptionLevel) obj);
            }
        }

        @Nullable
        private String m7668j() {
            this.f5982d = super.a(this.f5982d, 0);
            return this.f5982d;
        }

        @Nullable
        public final String mo324b() {
            this.f5983e = super.a(this.f5983e, 1);
            return this.f5983e;
        }

        private void m7667a(@Nullable String str) {
            this.f5983e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        @Nullable
        private PossiblePushSubscriptionLevelsModel m7669k() {
            this.f5984f = (PossiblePushSubscriptionLevelsModel) super.a(this.f5984f, 2, PossiblePushSubscriptionLevelsModel.class);
            return this.f5984f;
        }

        @Nullable
        private PossibleSubscriptionLevelsModel m7670l() {
            this.f5985g = (PossibleSubscriptionLevelsModel) super.a(this.f5985g, 3, PossibleSubscriptionLevelsModel.class);
            return this.f5985g;
        }

        @Nullable
        public final GraphQLGroupAdminType mo330n() {
            this.f5986h = (GraphQLGroupAdminType) super.b(this.f5986h, 4, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5986h;
        }

        @Nullable
        public final GraphQLGroupPushSubscriptionLevel hc_() {
            this.f5987i = (GraphQLGroupPushSubscriptionLevel) super.b(this.f5987i, 5, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5987i;
        }

        private void m7665a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            this.f5987i = graphQLGroupPushSubscriptionLevel;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLGroupPushSubscriptionLevel != null ? graphQLGroupPushSubscriptionLevel.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupRequestToJoinSubscriptionLevel mo327g() {
            this.f5988j = (GraphQLGroupRequestToJoinSubscriptionLevel) super.b(this.f5988j, 6, GraphQLGroupRequestToJoinSubscriptionLevel.class, GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5988j;
        }

        @Nullable
        public final GraphQLGroupSubscriptionLevel hd_() {
            this.f5989k = (GraphQLGroupSubscriptionLevel) super.b(this.f5989k, 7, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f5989k;
        }

        private void m7666a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
            this.f5989k = graphQLGroupSubscriptionLevel;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, graphQLGroupSubscriptionLevel != null ? graphQLGroupSubscriptionLevel.name() : null);
            }
        }

        @Nullable
        public final String m7673a() {
            return m7668j();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7672a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7669k() != null) {
                PossiblePushSubscriptionLevelsModel possiblePushSubscriptionLevelsModel = (PossiblePushSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7669k());
                if (m7669k() != possiblePushSubscriptionLevelsModel) {
                    graphQLVisitableModel = (GroupSubscriptionDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5984f = possiblePushSubscriptionLevelsModel;
                }
            }
            if (m7670l() != null) {
                PossibleSubscriptionLevelsModel possibleSubscriptionLevelsModel = (PossibleSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7670l());
                if (m7670l() != possibleSubscriptionLevelsModel) {
                    graphQLVisitableModel = (GroupSubscriptionDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5985g = possibleSubscriptionLevelsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7671a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7668j());
            int b2 = flatBufferBuilder.b(mo324b());
            int a = ModelHelper.a(flatBufferBuilder, m7669k());
            int a2 = ModelHelper.a(flatBufferBuilder, m7670l());
            int a3 = flatBufferBuilder.a(mo330n());
            int a4 = flatBufferBuilder.a(hc_());
            int a5 = flatBufferBuilder.a(mo327g());
            int a6 = flatBufferBuilder.a(hd_());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            i();
            return flatBufferBuilder.d();
        }
    }
}
