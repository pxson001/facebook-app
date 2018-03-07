package com.facebook.groups.widget.header.protocol;

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
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSettingsRowDataModel.SettingsRowCoverPhotoModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossiblePushSubscriptionLevelsModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossibleSubscriptionLevelsModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.PendingMembersParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.PendingStoriesParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.ReportedStoriesParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.TreehouseMembersParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.TreehouseheaderCoverPhotoParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.TreehouseheaderCoverPhotoParser.PhotoParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.TreehouseheaderCoverPhotoParser.PhotoParser.ImageParser;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentParsers.TreehouseHeaderFragmentParser.VisibilitySentenceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: private_event */
public class TreehouseHeaderFragmentModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 713320447)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: private_event */
    public final class TreehouseHeaderFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, TreehouseHeaderFragmentInterfaces$TreehouseHeaderFragment {
        @Nullable
        private String f6002d;
        @Nullable
        private String f6003e;
        @Nullable
        private PendingMembersModel f6004f;
        @Nullable
        private PendingStoriesModel f6005g;
        @Nullable
        private PossiblePushSubscriptionLevelsModel f6006h;
        @Nullable
        private PossibleSubscriptionLevelsModel f6007i;
        @Nullable
        private ReportedStoriesModel f6008j;
        @Nullable
        private SettingsRowCoverPhotoModel f6009k;
        @Nullable
        private TreehouseMembersModel f6010l;
        @Nullable
        private TreehouseheaderCoverPhotoModel f6011m;
        @Nullable
        private GraphQLGroupAdminType f6012n;
        @Nullable
        private GraphQLGroupPushSubscriptionLevel f6013o;
        @Nullable
        private GraphQLGroupRequestToJoinSubscriptionLevel f6014p;
        @Nullable
        private GraphQLGroupSubscriptionLevel f6015q;
        @Nullable
        private GraphQLGroupVisibility f6016r;
        @Nullable
        private VisibilitySentenceModel f6017s;

        /* compiled from: private_event */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TreehouseHeaderFragmentModel.class, new Deserializer());
            }

            public Object m7700a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TreehouseHeaderFragmentParser.m7785a(jsonParser);
                Object treehouseHeaderFragmentModel = new TreehouseHeaderFragmentModel();
                ((BaseModel) treehouseHeaderFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (treehouseHeaderFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) treehouseHeaderFragmentModel).a();
                }
                return treehouseHeaderFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: private_event */
        public final class PendingMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f5993d;

            /* compiled from: private_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PendingMembersModel.class, new Deserializer());
                }

                public Object m7701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PendingMembersParser.m7769a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pendingMembersModel = new PendingMembersModel();
                    ((BaseModel) pendingMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pendingMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) pendingMembersModel).a();
                    }
                    return pendingMembersModel;
                }
            }

            /* compiled from: private_event */
            public class Serializer extends JsonSerializer<PendingMembersModel> {
                public final void m7702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PendingMembersModel pendingMembersModel = (PendingMembersModel) obj;
                    if (pendingMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pendingMembersModel.m7703a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pendingMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PendingMembersParser.m7770a(pendingMembersModel.w_(), pendingMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PendingMembersModel.class, new Serializer());
                }
            }

            public PendingMembersModel() {
                super(1);
            }

            public final int jK_() {
                return 494751103;
            }

            public final GraphQLVisitableModel m7704a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7703a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5993d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7705a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5993d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: private_event */
        public final class PendingStoriesModel extends BaseModel implements GraphQLVisitableModel {
            private int f5994d;

            /* compiled from: private_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PendingStoriesModel.class, new Deserializer());
                }

                public Object m7706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PendingStoriesParser.m7771a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pendingStoriesModel = new PendingStoriesModel();
                    ((BaseModel) pendingStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pendingStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) pendingStoriesModel).a();
                    }
                    return pendingStoriesModel;
                }
            }

            /* compiled from: private_event */
            public class Serializer extends JsonSerializer<PendingStoriesModel> {
                public final void m7707a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PendingStoriesModel pendingStoriesModel = (PendingStoriesModel) obj;
                    if (pendingStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pendingStoriesModel.m7708a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pendingStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PendingStoriesParser.m7772a(pendingStoriesModel.w_(), pendingStoriesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PendingStoriesModel.class, new Serializer());
                }
            }

            public PendingStoriesModel() {
                super(1);
            }

            public final int jK_() {
                return 1621009465;
            }

            public final GraphQLVisitableModel m7709a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7708a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5994d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7710a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5994d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: private_event */
        public final class ReportedStoriesModel extends BaseModel implements GraphQLVisitableModel {
            private int f5995d;

            /* compiled from: private_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReportedStoriesModel.class, new Deserializer());
                }

                public Object m7711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReportedStoriesParser.m7773a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reportedStoriesModel = new ReportedStoriesModel();
                    ((BaseModel) reportedStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reportedStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) reportedStoriesModel).a();
                    }
                    return reportedStoriesModel;
                }
            }

            /* compiled from: private_event */
            public class Serializer extends JsonSerializer<ReportedStoriesModel> {
                public final void m7712a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReportedStoriesModel reportedStoriesModel = (ReportedStoriesModel) obj;
                    if (reportedStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reportedStoriesModel.m7713a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reportedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReportedStoriesParser.m7774a(reportedStoriesModel.w_(), reportedStoriesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ReportedStoriesModel.class, new Serializer());
                }
            }

            public ReportedStoriesModel() {
                super(1);
            }

            public final int jK_() {
                return -35660449;
            }

            public final GraphQLVisitableModel m7714a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7713a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5995d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7715a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5995d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: private_event */
        public class Serializer extends JsonSerializer<TreehouseHeaderFragmentModel> {
            public final void m7716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TreehouseHeaderFragmentModel treehouseHeaderFragmentModel = (TreehouseHeaderFragmentModel) obj;
                if (treehouseHeaderFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(treehouseHeaderFragmentModel.m7759a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    treehouseHeaderFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TreehouseHeaderFragmentParser.m7786a(treehouseHeaderFragmentModel.w_(), treehouseHeaderFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TreehouseHeaderFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: private_event */
        public final class TreehouseMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f5996d;

            /* compiled from: private_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TreehouseMembersModel.class, new Deserializer());
                }

                public Object m7717a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TreehouseMembersParser.m7775a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object treehouseMembersModel = new TreehouseMembersModel();
                    ((BaseModel) treehouseMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (treehouseMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) treehouseMembersModel).a();
                    }
                    return treehouseMembersModel;
                }
            }

            /* compiled from: private_event */
            public class Serializer extends JsonSerializer<TreehouseMembersModel> {
                public final void m7718a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TreehouseMembersModel treehouseMembersModel = (TreehouseMembersModel) obj;
                    if (treehouseMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(treehouseMembersModel.m7719a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        treehouseMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TreehouseMembersParser.m7776a(treehouseMembersModel.w_(), treehouseMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TreehouseMembersModel.class, new Serializer());
                }
            }

            public TreehouseMembersModel() {
                super(1);
            }

            public final int jK_() {
                return 103365688;
            }

            public final GraphQLVisitableModel m7720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7719a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f5996d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7721a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5996d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 441952364)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: private_event */
        public final class TreehouseheaderCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhotoModel f6000d;

            /* compiled from: private_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TreehouseheaderCoverPhotoModel.class, new Deserializer());
                }

                public Object m7722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TreehouseheaderCoverPhotoParser.m7781a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object treehouseheaderCoverPhotoModel = new TreehouseheaderCoverPhotoModel();
                    ((BaseModel) treehouseheaderCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (treehouseheaderCoverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) treehouseheaderCoverPhotoModel).a();
                    }
                    return treehouseheaderCoverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1800208321)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: private_event */
            public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f5998d;
                @Nullable
                private ImageModel f5999e;

                /* compiled from: private_event */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m7723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m7779a(jsonParser, flatBufferBuilder));
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
                /* compiled from: private_event */
                public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5997d;

                    /* compiled from: private_event */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                        }

                        public Object m7724a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ImageParser.m7777a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: private_event */
                    public class Serializer extends JsonSerializer<ImageModel> {
                        public final void m7725a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ImageModel imageModel = (ImageModel) obj;
                            if (imageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(imageModel.m7727a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ImageParser.m7778a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ImageModel.class, new Serializer());
                        }
                    }

                    public ImageModel() {
                        super(1);
                    }

                    @Nullable
                    private String m7726a() {
                        this.f5997d = super.a(this.f5997d, 0);
                        return this.f5997d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m7728a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m7727a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m7726a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: private_event */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m7729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m7732a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m7780a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(2);
                }

                @Nullable
                private String m7730j() {
                    this.f5998d = super.a(this.f5998d, 0);
                    return this.f5998d;
                }

                @Nullable
                private ImageModel m7731k() {
                    this.f5999e = (ImageModel) super.a(this.f5999e, 1, ImageModel.class);
                    return this.f5999e;
                }

                @Nullable
                public final String m7734a() {
                    return m7730j();
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m7733a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7731k() != null) {
                        ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m7731k());
                        if (m7731k() != imageModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5999e = imageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7732a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7730j());
                    int a = ModelHelper.a(flatBufferBuilder, m7731k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: private_event */
            public class Serializer extends JsonSerializer<TreehouseheaderCoverPhotoModel> {
                public final void m7735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TreehouseheaderCoverPhotoModel treehouseheaderCoverPhotoModel = (TreehouseheaderCoverPhotoModel) obj;
                    if (treehouseheaderCoverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(treehouseheaderCoverPhotoModel.m7737a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        treehouseheaderCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TreehouseheaderCoverPhotoParser.m7782a(treehouseheaderCoverPhotoModel.w_(), treehouseheaderCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TreehouseheaderCoverPhotoModel.class, new Serializer());
                }
            }

            public TreehouseheaderCoverPhotoModel() {
                super(1);
            }

            @Nullable
            private PhotoModel m7736a() {
                this.f6000d = (PhotoModel) super.a(this.f6000d, 0, PhotoModel.class);
                return this.f6000d;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m7738a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7736a() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m7736a());
                    if (m7736a() != photoModel) {
                        graphQLVisitableModel = (TreehouseheaderCoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6000d = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7737a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7736a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: private_event */
        public final class VisibilitySentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6001d;

            /* compiled from: private_event */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VisibilitySentenceModel.class, new Deserializer());
                }

                public Object m7739a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VisibilitySentenceParser.m7783a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object visibilitySentenceModel = new VisibilitySentenceModel();
                    ((BaseModel) visibilitySentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (visibilitySentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) visibilitySentenceModel).a();
                    }
                    return visibilitySentenceModel;
                }
            }

            /* compiled from: private_event */
            public class Serializer extends JsonSerializer<VisibilitySentenceModel> {
                public final void m7740a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) obj;
                    if (visibilitySentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(visibilitySentenceModel.m7742a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        visibilitySentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VisibilitySentenceParser.m7784a(visibilitySentenceModel.w_(), visibilitySentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VisibilitySentenceModel.class, new Serializer());
                }
            }

            public VisibilitySentenceModel() {
                super(1);
            }

            @Nullable
            private String m7741a() {
                this.f6001d = super.a(this.f6001d, 0);
                return this.f6001d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m7743a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7742a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7741a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ PossiblePushSubscriptionLevelsModel mo325c() {
            return m7751m();
        }

        @Nullable
        public final /* synthetic */ PossibleSubscriptionLevelsModel mo326d() {
            return m7752o();
        }

        public TreehouseHeaderFragmentModel() {
            super(16);
        }

        public final void m7762a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = mo324b();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("viewer_push_subscription_level".equals(str)) {
                consistencyTuple.a = hc_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 11;
            } else if ("viewer_subscription_level".equals(str)) {
                consistencyTuple.a = hd_();
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else if ("visibility".equals(str)) {
                consistencyTuple.a = m7757t();
                consistencyTuple.b = u_();
                consistencyTuple.c = 14;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m7763a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m7747a((String) obj);
            } else if ("viewer_push_subscription_level".equals(str)) {
                m7744a((GraphQLGroupPushSubscriptionLevel) obj);
            } else if ("viewer_subscription_level".equals(str)) {
                m7745a((GraphQLGroupSubscriptionLevel) obj);
            } else if ("visibility".equals(str)) {
                m7746a((GraphQLGroupVisibility) obj);
            }
        }

        @Nullable
        private String m7748j() {
            this.f6002d = super.a(this.f6002d, 0);
            return this.f6002d;
        }

        @Nullable
        public final String mo324b() {
            this.f6003e = super.a(this.f6003e, 1);
            return this.f6003e;
        }

        private void m7747a(@Nullable String str) {
            this.f6003e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        @Nullable
        private PendingMembersModel m7749k() {
            this.f6004f = (PendingMembersModel) super.a(this.f6004f, 2, PendingMembersModel.class);
            return this.f6004f;
        }

        @Nullable
        private PendingStoriesModel m7750l() {
            this.f6005g = (PendingStoriesModel) super.a(this.f6005g, 3, PendingStoriesModel.class);
            return this.f6005g;
        }

        @Nullable
        private PossiblePushSubscriptionLevelsModel m7751m() {
            this.f6006h = (PossiblePushSubscriptionLevelsModel) super.a(this.f6006h, 4, PossiblePushSubscriptionLevelsModel.class);
            return this.f6006h;
        }

        @Nullable
        private PossibleSubscriptionLevelsModel m7752o() {
            this.f6007i = (PossibleSubscriptionLevelsModel) super.a(this.f6007i, 5, PossibleSubscriptionLevelsModel.class);
            return this.f6007i;
        }

        @Nullable
        private ReportedStoriesModel m7753p() {
            this.f6008j = (ReportedStoriesModel) super.a(this.f6008j, 6, ReportedStoriesModel.class);
            return this.f6008j;
        }

        @Nullable
        private SettingsRowCoverPhotoModel m7754q() {
            this.f6009k = (SettingsRowCoverPhotoModel) super.a(this.f6009k, 7, SettingsRowCoverPhotoModel.class);
            return this.f6009k;
        }

        @Nullable
        private TreehouseMembersModel m7755r() {
            this.f6010l = (TreehouseMembersModel) super.a(this.f6010l, 8, TreehouseMembersModel.class);
            return this.f6010l;
        }

        @Nullable
        private TreehouseheaderCoverPhotoModel m7756s() {
            this.f6011m = (TreehouseheaderCoverPhotoModel) super.a(this.f6011m, 9, TreehouseheaderCoverPhotoModel.class);
            return this.f6011m;
        }

        @Nullable
        public final GraphQLGroupAdminType mo330n() {
            this.f6012n = (GraphQLGroupAdminType) super.b(this.f6012n, 10, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6012n;
        }

        @Nullable
        public final GraphQLGroupPushSubscriptionLevel hc_() {
            this.f6013o = (GraphQLGroupPushSubscriptionLevel) super.b(this.f6013o, 11, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6013o;
        }

        private void m7744a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
            this.f6013o = graphQLGroupPushSubscriptionLevel;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 11, graphQLGroupPushSubscriptionLevel != null ? graphQLGroupPushSubscriptionLevel.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupRequestToJoinSubscriptionLevel mo327g() {
            this.f6014p = (GraphQLGroupRequestToJoinSubscriptionLevel) super.b(this.f6014p, 12, GraphQLGroupRequestToJoinSubscriptionLevel.class, GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6014p;
        }

        @Nullable
        public final GraphQLGroupSubscriptionLevel hd_() {
            this.f6015q = (GraphQLGroupSubscriptionLevel) super.b(this.f6015q, 13, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6015q;
        }

        private void m7745a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
            this.f6015q = graphQLGroupSubscriptionLevel;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, graphQLGroupSubscriptionLevel != null ? graphQLGroupSubscriptionLevel.name() : null);
            }
        }

        @Nullable
        private GraphQLGroupVisibility m7757t() {
            this.f6016r = (GraphQLGroupVisibility) super.b(this.f6016r, 14, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6016r;
        }

        private void m7746a(GraphQLGroupVisibility graphQLGroupVisibility) {
            this.f6016r = graphQLGroupVisibility;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 14, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
            }
        }

        @Nullable
        private VisibilitySentenceModel m7758u() {
            this.f6017s = (VisibilitySentenceModel) super.a(this.f6017s, 15, VisibilitySentenceModel.class);
            return this.f6017s;
        }

        @Nullable
        public final String m7761a() {
            return m7748j();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7749k() != null) {
                PendingMembersModel pendingMembersModel = (PendingMembersModel) graphQLModelMutatingVisitor.b(m7749k());
                if (m7749k() != pendingMembersModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6004f = pendingMembersModel;
                }
            }
            if (m7750l() != null) {
                PendingStoriesModel pendingStoriesModel = (PendingStoriesModel) graphQLModelMutatingVisitor.b(m7750l());
                if (m7750l() != pendingStoriesModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6005g = pendingStoriesModel;
                }
            }
            if (m7751m() != null) {
                PossiblePushSubscriptionLevelsModel possiblePushSubscriptionLevelsModel = (PossiblePushSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7751m());
                if (m7751m() != possiblePushSubscriptionLevelsModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6006h = possiblePushSubscriptionLevelsModel;
                }
            }
            if (m7752o() != null) {
                PossibleSubscriptionLevelsModel possibleSubscriptionLevelsModel = (PossibleSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7752o());
                if (m7752o() != possibleSubscriptionLevelsModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6007i = possibleSubscriptionLevelsModel;
                }
            }
            if (m7753p() != null) {
                ReportedStoriesModel reportedStoriesModel = (ReportedStoriesModel) graphQLModelMutatingVisitor.b(m7753p());
                if (m7753p() != reportedStoriesModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6008j = reportedStoriesModel;
                }
            }
            if (m7754q() != null) {
                SettingsRowCoverPhotoModel settingsRowCoverPhotoModel = (SettingsRowCoverPhotoModel) graphQLModelMutatingVisitor.b(m7754q());
                if (m7754q() != settingsRowCoverPhotoModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6009k = settingsRowCoverPhotoModel;
                }
            }
            if (m7755r() != null) {
                TreehouseMembersModel treehouseMembersModel = (TreehouseMembersModel) graphQLModelMutatingVisitor.b(m7755r());
                if (m7755r() != treehouseMembersModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6010l = treehouseMembersModel;
                }
            }
            if (m7756s() != null) {
                TreehouseheaderCoverPhotoModel treehouseheaderCoverPhotoModel = (TreehouseheaderCoverPhotoModel) graphQLModelMutatingVisitor.b(m7756s());
                if (m7756s() != treehouseheaderCoverPhotoModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6011m = treehouseheaderCoverPhotoModel;
                }
            }
            if (m7758u() != null) {
                VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) graphQLModelMutatingVisitor.b(m7758u());
                if (m7758u() != visibilitySentenceModel) {
                    graphQLVisitableModel = (TreehouseHeaderFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6017s = visibilitySentenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7759a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7748j());
            int b2 = flatBufferBuilder.b(mo324b());
            int a = ModelHelper.a(flatBufferBuilder, m7749k());
            int a2 = ModelHelper.a(flatBufferBuilder, m7750l());
            int a3 = ModelHelper.a(flatBufferBuilder, m7751m());
            int a4 = ModelHelper.a(flatBufferBuilder, m7752o());
            int a5 = ModelHelper.a(flatBufferBuilder, m7753p());
            int a6 = ModelHelper.a(flatBufferBuilder, m7754q());
            int a7 = ModelHelper.a(flatBufferBuilder, m7755r());
            int a8 = ModelHelper.a(flatBufferBuilder, m7756s());
            int a9 = flatBufferBuilder.a(mo330n());
            int a10 = flatBufferBuilder.a(hc_());
            int a11 = flatBufferBuilder.a(mo327g());
            int a12 = flatBufferBuilder.a(hd_());
            int a13 = flatBufferBuilder.a(m7757t());
            int a14 = ModelHelper.a(flatBufferBuilder, m7758u());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
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
            i();
            return flatBufferBuilder.d();
        }
    }
}
