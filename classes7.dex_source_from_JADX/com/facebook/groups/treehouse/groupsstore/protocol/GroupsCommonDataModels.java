package com.facebook.groups.treehouse.groupsstore.protocol;

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
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupPurposeType;
import com.facebook.graphql.enums.GraphQLGroupPushSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupRequestToJoinSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser.GroupsParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser.GroupsParser.DeltasParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser.GroupsParser.DeltasParser.NodesParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser.GroupsParser.DeltasParser.NodesParser.AddedEdgeParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser.GroupsParser.DeltasParser.NodesParser.ModifiedEdgeParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheDeltaSyncParser.ActorParser.GroupsParser.PageInfoParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheInitialSyncParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheUnseenSyncParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCacheUnseenSyncParser.ActorParser.GroupsParser.NodesParser.GroupFeedParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataPageInfoParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser.LastViewTimeParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser.ParentGroupParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser.PhotoForLauncherShortcutParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser.PhotoForLauncherShortcutParser.PhotoParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupCommonDataParser.AdminAwareGroupParser.PhotoForLauncherShortcutParser.PhotoParser.ImageParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupPurposesFragmentParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupPurposesFragmentParser.GroupPurposeFirstParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupPurposesFragmentParser.GroupPurposeFirstParser.EdgesParser;
import com.facebook.groups.treehouse.groupsstore.protocol.GroupsCommonDataParsers.GroupPurposesFragmentParser.GroupPurposeFirstParser.EdgesParser.NodeParser;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentModels.GroupsGroupGridItemFragmentModel.GroupFeedModel;
import com.facebook.groups.widget.groupgriditem.protocol.GroupsGroupGridItemFragmentModels.GroupsGroupGridItemFragmentModel.GroupItemCoverPhotoModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSettingsRowDataModel.SettingsRowCoverPhotoModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossiblePushSubscriptionLevelsModel;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataModels.GroupSubscriptionDataModel.PossibleSubscriptionLevelsModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentInterfaces$TreehouseHeaderFragment;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentModels.TreehouseHeaderFragmentModel.PendingMembersModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentModels.TreehouseHeaderFragmentModel.PendingStoriesModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentModels.TreehouseHeaderFragmentModel.ReportedStoriesModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentModels.TreehouseHeaderFragmentModel.TreehouseMembersModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentModels.TreehouseHeaderFragmentModel.TreehouseheaderCoverPhotoModel;
import com.facebook.groups.widget.header.protocol.TreehouseHeaderFragmentModels.TreehouseHeaderFragmentModel.VisibilitySentenceModel;
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

/* compiled from: profile_pic_frame_id */
public class GroupsCommonDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -760087801)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_pic_frame_id */
    public final class GroupCacheDeltaSyncModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f5829d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1091151977)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_pic_frame_id */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f5827d;
            @Nullable
            private GroupsModel f5828e;

            /* compiled from: profile_pic_frame_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m7223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorParser.m7455a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 978707971)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class GroupsModel extends BaseModel implements GraphQLVisitableModel {
                private int f5824d;
                @Nullable
                private DeltasModel f5825e;
                @Nullable
                private PageInfoModel f5826f;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1836760296)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: profile_pic_frame_id */
                public final class DeltasModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<NodesModel> f5822d;

                    /* compiled from: profile_pic_frame_id */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(DeltasModel.class, new Deserializer());
                        }

                        public Object m7224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(DeltasParser.m7449a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object deltasModel = new DeltasModel();
                            ((BaseModel) deltasModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (deltasModel instanceof Postprocessable) {
                                return ((Postprocessable) deltasModel).a();
                            }
                            return deltasModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1133523816)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: profile_pic_frame_id */
                    public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private AddedEdgeModel f5818d;
                        @Nullable
                        private ModifiedEdgeModel f5819e;
                        @Nullable
                        private String f5820f;
                        @Nullable
                        private String f5821g;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -498816574)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: profile_pic_frame_id */
                        public final class AddedEdgeModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private GroupCommonDataModel f5816d;

                            /* compiled from: profile_pic_frame_id */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(AddedEdgeModel.class, new Deserializer());
                                }

                                public Object m7225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(AddedEdgeParser.m7443a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object addedEdgeModel = new AddedEdgeModel();
                                    ((BaseModel) addedEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (addedEdgeModel instanceof Postprocessable) {
                                        return ((Postprocessable) addedEdgeModel).a();
                                    }
                                    return addedEdgeModel;
                                }
                            }

                            /* compiled from: profile_pic_frame_id */
                            public class Serializer extends JsonSerializer<AddedEdgeModel> {
                                public final void m7226a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    AddedEdgeModel addedEdgeModel = (AddedEdgeModel) obj;
                                    if (addedEdgeModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(addedEdgeModel.m7228a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        addedEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    AddedEdgeParser.m7444a(addedEdgeModel.w_(), addedEdgeModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(AddedEdgeModel.class, new Serializer());
                                }
                            }

                            public AddedEdgeModel() {
                                super(1);
                            }

                            @Nullable
                            private GroupCommonDataModel m7227a() {
                                this.f5816d = (GroupCommonDataModel) super.a(this.f5816d, 0, GroupCommonDataModel.class);
                                return this.f5816d;
                            }

                            public final int jK_() {
                                return -1001943599;
                            }

                            public final GraphQLVisitableModel m7229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m7227a() != null) {
                                    GroupCommonDataModel groupCommonDataModel = (GroupCommonDataModel) graphQLModelMutatingVisitor.b(m7227a());
                                    if (m7227a() != groupCommonDataModel) {
                                        graphQLVisitableModel = (AddedEdgeModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f5816d = groupCommonDataModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m7228a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m7227a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: profile_pic_frame_id */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                            }

                            public Object m7230a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodesParser.m7447b(jsonParser, flatBufferBuilder));
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
                        @ModelWithFlatBufferFormatHash(a = -498816574)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: profile_pic_frame_id */
                        public final class ModifiedEdgeModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private GroupCommonDataModel f5817d;

                            /* compiled from: profile_pic_frame_id */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ModifiedEdgeModel.class, new Deserializer());
                                }

                                public Object m7231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(ModifiedEdgeParser.m7445a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object modifiedEdgeModel = new ModifiedEdgeModel();
                                    ((BaseModel) modifiedEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (modifiedEdgeModel instanceof Postprocessable) {
                                        return ((Postprocessable) modifiedEdgeModel).a();
                                    }
                                    return modifiedEdgeModel;
                                }
                            }

                            /* compiled from: profile_pic_frame_id */
                            public class Serializer extends JsonSerializer<ModifiedEdgeModel> {
                                public final void m7232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ModifiedEdgeModel modifiedEdgeModel = (ModifiedEdgeModel) obj;
                                    if (modifiedEdgeModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(modifiedEdgeModel.m7234a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        modifiedEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    ModifiedEdgeParser.m7446a(modifiedEdgeModel.w_(), modifiedEdgeModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(ModifiedEdgeModel.class, new Serializer());
                                }
                            }

                            public ModifiedEdgeModel() {
                                super(1);
                            }

                            @Nullable
                            private GroupCommonDataModel m7233a() {
                                this.f5817d = (GroupCommonDataModel) super.a(this.f5817d, 0, GroupCommonDataModel.class);
                                return this.f5817d;
                            }

                            public final int jK_() {
                                return -1001943599;
                            }

                            public final GraphQLVisitableModel m7235a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m7233a() != null) {
                                    GroupCommonDataModel groupCommonDataModel = (GroupCommonDataModel) graphQLModelMutatingVisitor.b(m7233a());
                                    if (m7233a() != groupCommonDataModel) {
                                        graphQLVisitableModel = (ModifiedEdgeModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f5817d = groupCommonDataModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m7234a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m7233a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: profile_pic_frame_id */
                        public class Serializer extends JsonSerializer<NodesModel> {
                            public final void m7236a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodesModel nodesModel = (NodesModel) obj;
                                if (nodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodesModel.m7241a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodesParser.m7448b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodesModel.class, new Serializer());
                            }
                        }

                        public NodesModel() {
                            super(4);
                        }

                        @Nullable
                        private AddedEdgeModel m7237a() {
                            this.f5818d = (AddedEdgeModel) super.a(this.f5818d, 0, AddedEdgeModel.class);
                            return this.f5818d;
                        }

                        @Nullable
                        private ModifiedEdgeModel m7238j() {
                            this.f5819e = (ModifiedEdgeModel) super.a(this.f5819e, 1, ModifiedEdgeModel.class);
                            return this.f5819e;
                        }

                        @Nullable
                        private String m7239k() {
                            this.f5820f = super.a(this.f5820f, 2);
                            return this.f5820f;
                        }

                        @Nullable
                        private String m7240l() {
                            this.f5821g = super.a(this.f5821g, 3);
                            return this.f5821g;
                        }

                        public final int jK_() {
                            return -996368860;
                        }

                        public final GraphQLVisitableModel m7242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m7237a() != null) {
                                AddedEdgeModel addedEdgeModel = (AddedEdgeModel) graphQLModelMutatingVisitor.b(m7237a());
                                if (m7237a() != addedEdgeModel) {
                                    graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f5818d = addedEdgeModel;
                                }
                            }
                            if (m7238j() != null) {
                                ModifiedEdgeModel modifiedEdgeModel = (ModifiedEdgeModel) graphQLModelMutatingVisitor.b(m7238j());
                                if (m7238j() != modifiedEdgeModel) {
                                    graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f5819e = modifiedEdgeModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m7241a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m7237a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m7238j());
                            int b = flatBufferBuilder.b(m7239k());
                            int b2 = flatBufferBuilder.b(m7240l());
                            flatBufferBuilder.c(4);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.b(2, b);
                            flatBufferBuilder.b(3, b2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: profile_pic_frame_id */
                    public class Serializer extends JsonSerializer<DeltasModel> {
                        public final void m7243a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            DeltasModel deltasModel = (DeltasModel) obj;
                            if (deltasModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(deltasModel.m7245a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                deltasModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            DeltasParser.m7450a(deltasModel.w_(), deltasModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(DeltasModel.class, new Serializer());
                        }
                    }

                    public DeltasModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<NodesModel> m7244a() {
                        this.f5822d = super.a(this.f5822d, 0, NodesModel.class);
                        return (ImmutableList) this.f5822d;
                    }

                    public final int jK_() {
                        return 279878690;
                    }

                    public final GraphQLVisitableModel m7246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m7244a() != null) {
                            Builder a = ModelHelper.a(m7244a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (DeltasModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f5822d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m7245a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m7244a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GroupsModel.class, new Deserializer());
                    }

                    public Object m7247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupsParser.m7453a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1883761447)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: profile_pic_frame_id */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f5823d;

                    /* compiled from: profile_pic_frame_id */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m7248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageInfoParser.m7451a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: profile_pic_frame_id */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m7249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m7251a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageInfoParser.m7452a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(1);
                    }

                    @Nullable
                    private String m7250a() {
                        this.f5823d = super.a(this.f5823d, 0);
                        return this.f5823d;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m7252a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m7251a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m7250a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<GroupsModel> {
                    public final void m7253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GroupsModel groupsModel = (GroupsModel) obj;
                        if (groupsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(groupsModel.m7256a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            groupsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupsParser.m7454a(groupsModel.w_(), groupsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(GroupsModel.class, new Serializer());
                    }
                }

                public GroupsModel() {
                    super(3);
                }

                @Nullable
                private DeltasModel m7254a() {
                    this.f5825e = (DeltasModel) super.a(this.f5825e, 1, DeltasModel.class);
                    return this.f5825e;
                }

                @Nullable
                private PageInfoModel m7255j() {
                    this.f5826f = (PageInfoModel) super.a(this.f5826f, 2, PageInfoModel.class);
                    return this.f5826f;
                }

                public final int jK_() {
                    return 222380018;
                }

                public final GraphQLVisitableModel m7257a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7254a() != null) {
                        DeltasModel deltasModel = (DeltasModel) graphQLModelMutatingVisitor.b(m7254a());
                        if (m7254a() != deltasModel) {
                            graphQLVisitableModel = (GroupsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5825e = deltasModel;
                        }
                    }
                    if (m7255j() != null) {
                        PageInfoModel pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m7255j());
                        if (m7255j() != pageInfoModel) {
                            graphQLVisitableModel = (GroupsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f5826f = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7256a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7254a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m7255j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f5824d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7258a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5824d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: profile_pic_frame_id */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m7259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m7262a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorParser.m7456a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(2);
            }

            public final void m7264a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m7265a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m7260a() {
                if (this.b != null && this.f5827d == null) {
                    this.f5827d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5827d;
            }

            @Nullable
            private GroupsModel m7261j() {
                this.f5828e = (GroupsModel) super.a(this.f5828e, 1, GroupsModel.class);
                return this.f5828e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m7263a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7261j() != null) {
                    GroupsModel groupsModel = (GroupsModel) graphQLModelMutatingVisitor.b(m7261j());
                    if (m7261j() != groupsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5828e = groupsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7262a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7260a());
                int a2 = ModelHelper.a(flatBufferBuilder, m7261j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupCacheDeltaSyncModel.class, new Deserializer());
            }

            public Object m7266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupCacheDeltaSyncParser.m7457a(jsonParser);
                Object groupCacheDeltaSyncModel = new GroupCacheDeltaSyncModel();
                ((BaseModel) groupCacheDeltaSyncModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupCacheDeltaSyncModel instanceof Postprocessable) {
                    return ((Postprocessable) groupCacheDeltaSyncModel).a();
                }
                return groupCacheDeltaSyncModel;
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Serializer extends JsonSerializer<GroupCacheDeltaSyncModel> {
            public final void m7267a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupCacheDeltaSyncModel groupCacheDeltaSyncModel = (GroupCacheDeltaSyncModel) obj;
                if (groupCacheDeltaSyncModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupCacheDeltaSyncModel.m7269a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupCacheDeltaSyncModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupCacheDeltaSyncModel.w_();
                int u_ = groupCacheDeltaSyncModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    ActorParser.m7456a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupCacheDeltaSyncModel.class, new Serializer());
            }
        }

        public GroupCacheDeltaSyncModel() {
            super(1);
        }

        @Nullable
        private ActorModel m7268a() {
            this.f5829d = (ActorModel) super.a(this.f5829d, 0, ActorModel.class);
            return this.f5829d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m7270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7268a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m7268a());
                if (m7268a() != actorModel) {
                    graphQLVisitableModel = (GroupCacheDeltaSyncModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5829d = actorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7269a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7268a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1966438396)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_pic_frame_id */
    public final class GroupCacheInitialSyncModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f5835d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1101677377)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_pic_frame_id */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f5833d;
            @Nullable
            private GroupsModel f5834e;

            /* compiled from: profile_pic_frame_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m7271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupCacheInitialSyncParser.ActorParser.m7460a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1611184115)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class GroupsModel extends BaseModel implements GraphQLVisitableModel {
                private int f5830d;
                @Nullable
                private List<GroupCommonDataModel> f5831e;
                @Nullable
                private GroupCommonDataPageInfoModel f5832f;

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GroupsModel.class, new Deserializer());
                    }

                    public Object m7272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupCacheInitialSyncParser.ActorParser.GroupsParser.m7458a(jsonParser, flatBufferBuilder));
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

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<GroupsModel> {
                    public final void m7273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GroupsModel groupsModel = (GroupsModel) obj;
                        if (groupsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(groupsModel.m7276a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            groupsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupCacheInitialSyncParser.ActorParser.GroupsParser.m7459a(groupsModel.w_(), groupsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(GroupsModel.class, new Serializer());
                    }
                }

                public GroupsModel() {
                    super(3);
                }

                @Nonnull
                private ImmutableList<GroupCommonDataModel> m7274a() {
                    this.f5831e = super.a(this.f5831e, 1, GroupCommonDataModel.class);
                    return (ImmutableList) this.f5831e;
                }

                @Nullable
                private GroupCommonDataPageInfoModel m7275j() {
                    this.f5832f = (GroupCommonDataPageInfoModel) super.a(this.f5832f, 2, GroupCommonDataPageInfoModel.class);
                    return this.f5832f;
                }

                public final int jK_() {
                    return 222380018;
                }

                public final GraphQLVisitableModel m7277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    GroupCommonDataPageInfoModel groupCommonDataPageInfoModel;
                    h();
                    if (m7274a() != null) {
                        Builder a = ModelHelper.a(m7274a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            GroupsModel groupsModel = (GroupsModel) ModelHelper.a(null, this);
                            groupsModel.f5831e = a.b();
                            graphQLVisitableModel = groupsModel;
                            if (m7275j() != null) {
                                groupCommonDataPageInfoModel = (GroupCommonDataPageInfoModel) graphQLModelMutatingVisitor.b(m7275j());
                                if (m7275j() != groupCommonDataPageInfoModel) {
                                    graphQLVisitableModel = (GroupsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f5832f = groupCommonDataPageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m7275j() != null) {
                        groupCommonDataPageInfoModel = (GroupCommonDataPageInfoModel) graphQLModelMutatingVisitor.b(m7275j());
                        if (m7275j() != groupCommonDataPageInfoModel) {
                            graphQLVisitableModel = (GroupsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f5832f = groupCommonDataPageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m7276a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7274a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m7275j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f5830d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7278a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5830d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: profile_pic_frame_id */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m7279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m7282a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupCacheInitialSyncParser.ActorParser.m7461a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(2);
            }

            public final void m7284a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m7285a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m7280a() {
                if (this.b != null && this.f5833d == null) {
                    this.f5833d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5833d;
            }

            @Nullable
            private GroupsModel m7281j() {
                this.f5834e = (GroupsModel) super.a(this.f5834e, 1, GroupsModel.class);
                return this.f5834e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m7283a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7281j() != null) {
                    GroupsModel groupsModel = (GroupsModel) graphQLModelMutatingVisitor.b(m7281j());
                    if (m7281j() != groupsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5834e = groupsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7282a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7280a());
                int a2 = ModelHelper.a(flatBufferBuilder, m7281j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupCacheInitialSyncModel.class, new Deserializer());
            }

            public Object m7286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupCacheInitialSyncParser.m7462a(jsonParser);
                Object groupCacheInitialSyncModel = new GroupCacheInitialSyncModel();
                ((BaseModel) groupCacheInitialSyncModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupCacheInitialSyncModel instanceof Postprocessable) {
                    return ((Postprocessable) groupCacheInitialSyncModel).a();
                }
                return groupCacheInitialSyncModel;
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Serializer extends JsonSerializer<GroupCacheInitialSyncModel> {
            public final void m7287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupCacheInitialSyncModel groupCacheInitialSyncModel = (GroupCacheInitialSyncModel) obj;
                if (groupCacheInitialSyncModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupCacheInitialSyncModel.m7289a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupCacheInitialSyncModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupCacheInitialSyncModel.w_();
                int u_ = groupCacheInitialSyncModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    GroupCacheInitialSyncParser.ActorParser.m7461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupCacheInitialSyncModel.class, new Serializer());
            }
        }

        public GroupCacheInitialSyncModel() {
            super(1);
        }

        @Nullable
        private ActorModel m7288a() {
            this.f5835d = (ActorModel) super.a(this.f5835d, 0, ActorModel.class);
            return this.f5835d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m7290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7288a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m7288a());
                if (m7288a() != actorModel) {
                    graphQLVisitableModel = (GroupCacheInitialSyncModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5835d = actorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7289a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7288a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 620571818)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_pic_frame_id */
    public final class GroupCacheUnseenSyncModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f5843d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1201513513)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_pic_frame_id */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f5841d;
            @Nullable
            private GroupsModel f5842e;

            /* compiled from: profile_pic_frame_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m7291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupCacheUnseenSyncParser.ActorParser.m7469a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1372646834)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class GroupsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f5840d;

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GroupsModel.class, new Deserializer());
                    }

                    public Object m7292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupCacheUnseenSyncParser.ActorParser.GroupsParser.m7467a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 1601113912)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: profile_pic_frame_id */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GroupFeedModel f5837d;
                    @Nullable
                    private String f5838e;
                    @Nullable
                    private String f5839f;

                    /* compiled from: profile_pic_frame_id */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m7293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(GroupCacheUnseenSyncParser.ActorParser.GroupsParser.NodesParser.m7465b(jsonParser, flatBufferBuilder));
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
                    /* compiled from: profile_pic_frame_id */
                    public final class GroupFeedModel extends BaseModel implements GraphQLVisitableModel {
                        private int f5836d;

                        /* compiled from: profile_pic_frame_id */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(GroupFeedModel.class, new Deserializer());
                            }

                            public Object m7294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(GroupFeedParser.m7463a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: profile_pic_frame_id */
                        public class Serializer extends JsonSerializer<GroupFeedModel> {
                            public final void m7295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                GroupFeedModel groupFeedModel = (GroupFeedModel) obj;
                                if (groupFeedModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(groupFeedModel.m7296a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    groupFeedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                GroupFeedParser.m7464a(groupFeedModel.w_(), groupFeedModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(GroupFeedModel.class, new Serializer());
                            }
                        }

                        public GroupFeedModel() {
                            super(1);
                        }

                        public final int jK_() {
                            return 1273041755;
                        }

                        public final GraphQLVisitableModel m7297a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m7296a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.a(0, this.f5836d, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m7298a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f5836d = mutableFlatBuffer.a(i, 0, 0);
                        }
                    }

                    /* compiled from: profile_pic_frame_id */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m7299a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m7304a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            GroupCacheUnseenSyncParser.ActorParser.GroupsParser.NodesParser.m7466b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(3);
                    }

                    public final void m7307a(String str, ConsistencyTuple consistencyTuple) {
                        if ("name".equals(str)) {
                            consistencyTuple.a = m7303l();
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 2;
                            return;
                        }
                        consistencyTuple.a();
                    }

                    public final void m7308a(String str, Object obj, boolean z) {
                        if ("name".equals(str)) {
                            m7300a((String) obj);
                        }
                    }

                    @Nullable
                    private GroupFeedModel m7301j() {
                        this.f5837d = (GroupFeedModel) super.a(this.f5837d, 0, GroupFeedModel.class);
                        return this.f5837d;
                    }

                    @Nullable
                    private String m7302k() {
                        this.f5838e = super.a(this.f5838e, 1);
                        return this.f5838e;
                    }

                    @Nullable
                    private String m7303l() {
                        this.f5839f = super.a(this.f5839f, 2);
                        return this.f5839f;
                    }

                    private void m7300a(@Nullable String str) {
                        this.f5839f = str;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 2, str);
                        }
                    }

                    @Nullable
                    public final String m7306a() {
                        return m7302k();
                    }

                    public final int jK_() {
                        return 69076575;
                    }

                    public final GraphQLVisitableModel m7305a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m7301j() != null) {
                            GroupFeedModel groupFeedModel = (GroupFeedModel) graphQLModelMutatingVisitor.b(m7301j());
                            if (m7301j() != groupFeedModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f5837d = groupFeedModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m7304a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m7301j());
                        int b = flatBufferBuilder.b(m7302k());
                        int b2 = flatBufferBuilder.b(m7303l());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<GroupsModel> {
                    public final void m7309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GroupsModel groupsModel = (GroupsModel) obj;
                        if (groupsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(groupsModel.m7311a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            groupsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupCacheUnseenSyncParser.ActorParser.GroupsParser.m7468a(groupsModel.w_(), groupsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(GroupsModel.class, new Serializer());
                    }
                }

                public GroupsModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<NodesModel> m7310a() {
                    this.f5840d = super.a(this.f5840d, 0, NodesModel.class);
                    return (ImmutableList) this.f5840d;
                }

                public final int jK_() {
                    return 222380018;
                }

                public final GraphQLVisitableModel m7312a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7310a() != null) {
                        Builder a = ModelHelper.a(m7310a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (GroupsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5840d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7311a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7310a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile_pic_frame_id */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m7313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m7316a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupCacheUnseenSyncParser.ActorParser.m7470a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(2);
            }

            public final void m7318a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m7319a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m7314a() {
                if (this.b != null && this.f5841d == null) {
                    this.f5841d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5841d;
            }

            @Nullable
            private GroupsModel m7315j() {
                this.f5842e = (GroupsModel) super.a(this.f5842e, 1, GroupsModel.class);
                return this.f5842e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m7317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7315j() != null) {
                    GroupsModel groupsModel = (GroupsModel) graphQLModelMutatingVisitor.b(m7315j());
                    if (m7315j() != groupsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5842e = groupsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7316a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7314a());
                int a2 = ModelHelper.a(flatBufferBuilder, m7315j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupCacheUnseenSyncModel.class, new Deserializer());
            }

            public Object m7320a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupCacheUnseenSyncParser.m7471a(jsonParser);
                Object groupCacheUnseenSyncModel = new GroupCacheUnseenSyncModel();
                ((BaseModel) groupCacheUnseenSyncModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupCacheUnseenSyncModel instanceof Postprocessable) {
                    return ((Postprocessable) groupCacheUnseenSyncModel).a();
                }
                return groupCacheUnseenSyncModel;
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Serializer extends JsonSerializer<GroupCacheUnseenSyncModel> {
            public final void m7321a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupCacheUnseenSyncModel groupCacheUnseenSyncModel = (GroupCacheUnseenSyncModel) obj;
                if (groupCacheUnseenSyncModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupCacheUnseenSyncModel.m7323a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupCacheUnseenSyncModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupCacheUnseenSyncModel.w_();
                int u_ = groupCacheUnseenSyncModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    GroupCacheUnseenSyncParser.ActorParser.m7470a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupCacheUnseenSyncModel.class, new Serializer());
            }
        }

        public GroupCacheUnseenSyncModel() {
            super(1);
        }

        @Nullable
        private ActorModel m7322a() {
            this.f5843d = (ActorModel) super.a(this.f5843d, 0, ActorModel.class);
            return this.f5843d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m7324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7322a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m7322a());
                if (m7322a() != actorModel) {
                    graphQLVisitableModel = (GroupCacheUnseenSyncModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5843d = actorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7323a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7322a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -924340298)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_pic_frame_id */
    public final class GroupCommonDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private AdminAwareGroupModel f5885d;
        @Nullable
        private String f5886e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1265353586)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_pic_frame_id */
        public final class AdminAwareGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, TreehouseHeaderFragmentInterfaces$TreehouseHeaderFragment {
            @Nullable
            private GraphQLGroupAdminType f5852A;
            @Nullable
            private GraphQLGroupJoinState f5853B;
            private long f5854C;
            @Nullable
            private GraphQLLeavingGroupScenario f5855D;
            @Nullable
            private GraphQLGroupPostStatus f5856E;
            @Nullable
            private GraphQLGroupPushSubscriptionLevel f5857F;
            @Nullable
            private GraphQLGroupRequestToJoinSubscriptionLevel f5858G;
            @Nullable
            private GraphQLGroupSubscriptionLevel f5859H;
            @Nullable
            private GraphQLGroupVisibility f5860I;
            @Nullable
            private VisibilitySentenceModel f5861J;
            @Nullable
            private String f5862d;
            @Nullable
            private String f5863e;
            @Nullable
            private GroupItemCoverPhotoModel f5864f;
            @Nullable
            private GroupPurposeFirstModel f5865g;
            @Nullable
            private GroupFeedModel f5866h;
            private boolean f5867i;
            private boolean f5868j;
            @Nullable
            private String f5869k;
            private boolean f5870l;
            @Nullable
            private LastViewTimeModel f5871m;
            private long f5872n;
            @Nullable
            private String f5873o;
            @Nullable
            private ParentGroupModel f5874p;
            @Nullable
            private PendingMembersModel f5875q;
            @Nullable
            private PendingStoriesModel f5876r;
            @Nullable
            private PhotoForLauncherShortcutModel f5877s;
            @Nullable
            private PossiblePushSubscriptionLevelsModel f5878t;
            @Nullable
            private PossibleSubscriptionLevelsModel f5879u;
            @Nullable
            private ReportedStoriesModel f5880v;
            @Nullable
            private SettingsRowCoverPhotoModel f5881w;
            @Nullable
            private TreehouseMembersModel f5882x;
            @Nullable
            private TreehouseheaderCoverPhotoModel f5883y;
            @Nullable
            private String f5884z;

            /* compiled from: profile_pic_frame_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminAwareGroupModel.class, new Deserializer());
                }

                public Object m7325a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminAwareGroupParser.m7484a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminAwareGroupModel = new AdminAwareGroupModel();
                    ((BaseModel) adminAwareGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminAwareGroupModel instanceof Postprocessable) {
                        return ((Postprocessable) adminAwareGroupModel).a();
                    }
                    return adminAwareGroupModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1724293297)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class LastViewTimeModel extends BaseModel implements GraphQLVisitableModel {
                private long f5844d;

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LastViewTimeModel.class, new Deserializer());
                    }

                    public Object m7326a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LastViewTimeParser.m7474a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object lastViewTimeModel = new LastViewTimeModel();
                        ((BaseModel) lastViewTimeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (lastViewTimeModel instanceof Postprocessable) {
                            return ((Postprocessable) lastViewTimeModel).a();
                        }
                        return lastViewTimeModel;
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<LastViewTimeModel> {
                    public final void m7327a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LastViewTimeModel lastViewTimeModel = (LastViewTimeModel) obj;
                        if (lastViewTimeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(lastViewTimeModel.m7328a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            lastViewTimeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LastViewTimeParser.m7475a(lastViewTimeModel.w_(), lastViewTimeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LastViewTimeModel.class, new Serializer());
                    }
                }

                public LastViewTimeModel() {
                    super(1);
                }

                public final int jK_() {
                    return 1273041755;
                }

                public final GraphQLVisitableModel m7329a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7328a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f5844d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7330a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5844d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415735059)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class ParentGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f5845d;
                @Nullable
                private String f5846e;
                @Nullable
                private String f5847f;

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ParentGroupModel.class, new Deserializer());
                    }

                    public Object m7331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ParentGroupParser.m7476a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object parentGroupModel = new ParentGroupModel();
                        ((BaseModel) parentGroupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (parentGroupModel instanceof Postprocessable) {
                            return ((Postprocessable) parentGroupModel).a();
                        }
                        return parentGroupModel;
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<ParentGroupModel> {
                    public final void m7332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ParentGroupModel parentGroupModel = (ParentGroupModel) obj;
                        if (parentGroupModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(parentGroupModel.m7337a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            parentGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ParentGroupParser.m7477a(parentGroupModel.w_(), parentGroupModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ParentGroupModel.class, new Serializer());
                    }
                }

                public ParentGroupModel() {
                    super(3);
                }

                public final void m7340a(String str, ConsistencyTuple consistencyTuple) {
                    if ("name".equals(str)) {
                        consistencyTuple.a = m7335k();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m7341a(String str, Object obj, boolean z) {
                    if ("name".equals(str)) {
                        m7333a((String) obj);
                    }
                }

                @Nullable
                private String m7334j() {
                    this.f5845d = super.a(this.f5845d, 0);
                    return this.f5845d;
                }

                @Nullable
                private String m7335k() {
                    this.f5846e = super.a(this.f5846e, 1);
                    return this.f5846e;
                }

                private void m7333a(@Nullable String str) {
                    this.f5846e = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 1, str);
                    }
                }

                @Nullable
                private String m7336l() {
                    this.f5847f = super.a(this.f5847f, 2);
                    return this.f5847f;
                }

                @Nullable
                public final String m7339a() {
                    return m7334j();
                }

                public final int jK_() {
                    return 69076575;
                }

                public final GraphQLVisitableModel m7338a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7337a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7334j());
                    int b2 = flatBufferBuilder.b(m7335k());
                    int b3 = flatBufferBuilder.b(m7336l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -134098667)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class PhotoForLauncherShortcutModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PhotoModel f5851d;

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoForLauncherShortcutModel.class, new Deserializer());
                    }

                    public Object m7342a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoForLauncherShortcutParser.m7482a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object photoForLauncherShortcutModel = new PhotoForLauncherShortcutModel();
                        ((BaseModel) photoForLauncherShortcutModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (photoForLauncherShortcutModel instanceof Postprocessable) {
                            return ((Postprocessable) photoForLauncherShortcutModel).a();
                        }
                        return photoForLauncherShortcutModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1101309555)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: profile_pic_frame_id */
                public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f5849d;
                    @Nullable
                    private ImageModel f5850e;

                    /* compiled from: profile_pic_frame_id */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                        }

                        public Object m7343a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PhotoParser.m7480a(jsonParser, flatBufferBuilder));
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
                    /* compiled from: profile_pic_frame_id */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f5848d;

                        /* compiled from: profile_pic_frame_id */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m7344a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m7478a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: profile_pic_frame_id */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m7345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m7347a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m7479a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(1);
                        }

                        @Nullable
                        private String m7346a() {
                            this.f5848d = super.a(this.f5848d, 0);
                            return this.f5848d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m7348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m7347a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m7346a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: profile_pic_frame_id */
                    public class Serializer extends JsonSerializer<PhotoModel> {
                        public final void m7349a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PhotoModel photoModel = (PhotoModel) obj;
                            if (photoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(photoModel.m7352a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PhotoParser.m7481a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PhotoModel.class, new Serializer());
                        }
                    }

                    public PhotoModel() {
                        super(2);
                    }

                    @Nullable
                    private String m7350j() {
                        this.f5849d = super.a(this.f5849d, 0);
                        return this.f5849d;
                    }

                    @Nullable
                    private ImageModel m7351k() {
                        this.f5850e = (ImageModel) super.a(this.f5850e, 1, ImageModel.class);
                        return this.f5850e;
                    }

                    @Nullable
                    public final String m7354a() {
                        return m7350j();
                    }

                    public final int jK_() {
                        return 77090322;
                    }

                    public final GraphQLVisitableModel m7353a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m7351k() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m7351k());
                            if (m7351k() != imageModel) {
                                graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f5850e = imageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m7352a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m7350j());
                        int a = ModelHelper.a(flatBufferBuilder, m7351k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<PhotoForLauncherShortcutModel> {
                    public final void m7355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoForLauncherShortcutModel photoForLauncherShortcutModel = (PhotoForLauncherShortcutModel) obj;
                        if (photoForLauncherShortcutModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoForLauncherShortcutModel.m7357a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoForLauncherShortcutModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoForLauncherShortcutParser.m7483a(photoForLauncherShortcutModel.w_(), photoForLauncherShortcutModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoForLauncherShortcutModel.class, new Serializer());
                    }
                }

                public PhotoForLauncherShortcutModel() {
                    super(1);
                }

                @Nullable
                private PhotoModel m7356a() {
                    this.f5851d = (PhotoModel) super.a(this.f5851d, 0, PhotoModel.class);
                    return this.f5851d;
                }

                public final int jK_() {
                    return 497264923;
                }

                public final GraphQLVisitableModel m7358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7356a() != null) {
                        PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m7356a());
                        if (m7356a() != photoModel) {
                            graphQLVisitableModel = (PhotoForLauncherShortcutModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5851d = photoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7357a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7356a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile_pic_frame_id */
            public class Serializer extends JsonSerializer<AdminAwareGroupModel> {
                public final void m7359a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) obj;
                    if (adminAwareGroupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminAwareGroupModel.m7391a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminAwareGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminAwareGroupParser.m7485a(adminAwareGroupModel.w_(), adminAwareGroupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AdminAwareGroupModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PossiblePushSubscriptionLevelsModel mo325c() {
                return m7387w();
            }

            @Nullable
            public final /* synthetic */ PossibleSubscriptionLevelsModel mo326d() {
                return m7388x();
            }

            public AdminAwareGroupModel() {
                super(33);
            }

            public final void m7395a(String str, ConsistencyTuple consistencyTuple) {
                if ("description".equals(str)) {
                    consistencyTuple.a = m7376k();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("has_viewer_favorited".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m7380p());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                } else if ("name".equals(str)) {
                    consistencyTuple.a = mo324b();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 11;
                } else if ("viewer_join_state".equals(str)) {
                    consistencyTuple.a = m7363D();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 24;
                } else if ("viewer_push_subscription_level".equals(str)) {
                    consistencyTuple.a = hc_();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 28;
                } else if ("viewer_subscription_level".equals(str)) {
                    consistencyTuple.a = hd_();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 30;
                } else if ("visibility".equals(str)) {
                    consistencyTuple.a = m7366G();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 31;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m7396a(String str, Object obj, boolean z) {
                if ("description".equals(str)) {
                    m7372a((String) obj);
                } else if ("has_viewer_favorited".equals(str)) {
                    m7373a(((Boolean) obj).booleanValue());
                } else if ("name".equals(str)) {
                    m7374b((String) obj);
                } else if ("viewer_join_state".equals(str)) {
                    m7368a((GraphQLGroupJoinState) obj);
                } else if ("viewer_push_subscription_level".equals(str)) {
                    m7369a((GraphQLGroupPushSubscriptionLevel) obj);
                } else if ("viewer_subscription_level".equals(str)) {
                    m7370a((GraphQLGroupSubscriptionLevel) obj);
                } else if ("visibility".equals(str)) {
                    m7371a((GraphQLGroupVisibility) obj);
                }
            }

            @Nullable
            private String m7375j() {
                this.f5862d = super.a(this.f5862d, 0);
                return this.f5862d;
            }

            @Nullable
            private String m7376k() {
                this.f5863e = super.a(this.f5863e, 1);
                return this.f5863e;
            }

            private void m7372a(@Nullable String str) {
                this.f5863e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            @Nullable
            private GroupItemCoverPhotoModel m7377l() {
                this.f5864f = (GroupItemCoverPhotoModel) super.a(this.f5864f, 2, GroupItemCoverPhotoModel.class);
                return this.f5864f;
            }

            @Nullable
            private GroupPurposeFirstModel m7378m() {
                this.f5865g = (GroupPurposeFirstModel) super.a(this.f5865g, 3, GroupPurposeFirstModel.class);
                return this.f5865g;
            }

            @Nullable
            private GroupFeedModel m7379o() {
                this.f5866h = (GroupFeedModel) super.a(this.f5866h, 4, GroupFeedModel.class);
                return this.f5866h;
            }

            private boolean m7380p() {
                a(0, 5);
                return this.f5867i;
            }

            private void m7373a(boolean z) {
                this.f5867i = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, z);
                }
            }

            @Nullable
            private String m7381q() {
                this.f5869k = super.a(this.f5869k, 7);
                return this.f5869k;
            }

            @Nullable
            private LastViewTimeModel m7382r() {
                this.f5871m = (LastViewTimeModel) super.a(this.f5871m, 9, LastViewTimeModel.class);
                return this.f5871m;
            }

            @Nullable
            public final String mo324b() {
                this.f5873o = super.a(this.f5873o, 11);
                return this.f5873o;
            }

            private void m7374b(@Nullable String str) {
                this.f5873o = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 11, str);
                }
            }

            @Nullable
            private ParentGroupModel m7383s() {
                this.f5874p = (ParentGroupModel) super.a(this.f5874p, 12, ParentGroupModel.class);
                return this.f5874p;
            }

            @Nullable
            private PendingMembersModel m7384t() {
                this.f5875q = (PendingMembersModel) super.a(this.f5875q, 13, PendingMembersModel.class);
                return this.f5875q;
            }

            @Nullable
            private PendingStoriesModel m7385u() {
                this.f5876r = (PendingStoriesModel) super.a(this.f5876r, 14, PendingStoriesModel.class);
                return this.f5876r;
            }

            @Nullable
            private PhotoForLauncherShortcutModel m7386v() {
                this.f5877s = (PhotoForLauncherShortcutModel) super.a(this.f5877s, 15, PhotoForLauncherShortcutModel.class);
                return this.f5877s;
            }

            @Nullable
            private PossiblePushSubscriptionLevelsModel m7387w() {
                this.f5878t = (PossiblePushSubscriptionLevelsModel) super.a(this.f5878t, 16, PossiblePushSubscriptionLevelsModel.class);
                return this.f5878t;
            }

            @Nullable
            private PossibleSubscriptionLevelsModel m7388x() {
                this.f5879u = (PossibleSubscriptionLevelsModel) super.a(this.f5879u, 17, PossibleSubscriptionLevelsModel.class);
                return this.f5879u;
            }

            @Nullable
            private ReportedStoriesModel m7389y() {
                this.f5880v = (ReportedStoriesModel) super.a(this.f5880v, 18, ReportedStoriesModel.class);
                return this.f5880v;
            }

            @Nullable
            private SettingsRowCoverPhotoModel m7390z() {
                this.f5881w = (SettingsRowCoverPhotoModel) super.a(this.f5881w, 19, SettingsRowCoverPhotoModel.class);
                return this.f5881w;
            }

            @Nullable
            private TreehouseMembersModel m7360A() {
                this.f5882x = (TreehouseMembersModel) super.a(this.f5882x, 20, TreehouseMembersModel.class);
                return this.f5882x;
            }

            @Nullable
            private TreehouseheaderCoverPhotoModel m7361B() {
                this.f5883y = (TreehouseheaderCoverPhotoModel) super.a(this.f5883y, 21, TreehouseheaderCoverPhotoModel.class);
                return this.f5883y;
            }

            @Nullable
            private String m7362C() {
                this.f5884z = super.a(this.f5884z, 22);
                return this.f5884z;
            }

            @Nullable
            public final GraphQLGroupAdminType mo330n() {
                this.f5852A = (GraphQLGroupAdminType) super.b(this.f5852A, 23, GraphQLGroupAdminType.class, GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5852A;
            }

            @Nullable
            private GraphQLGroupJoinState m7363D() {
                this.f5853B = (GraphQLGroupJoinState) super.b(this.f5853B, 24, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5853B;
            }

            private void m7368a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f5853B = graphQLGroupJoinState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 24, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                }
            }

            @Nullable
            private GraphQLLeavingGroupScenario m7364E() {
                this.f5855D = (GraphQLLeavingGroupScenario) super.b(this.f5855D, 26, GraphQLLeavingGroupScenario.class, GraphQLLeavingGroupScenario.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5855D;
            }

            @Nullable
            private GraphQLGroupPostStatus m7365F() {
                this.f5856E = (GraphQLGroupPostStatus) super.b(this.f5856E, 27, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5856E;
            }

            @Nullable
            public final GraphQLGroupPushSubscriptionLevel hc_() {
                this.f5857F = (GraphQLGroupPushSubscriptionLevel) super.b(this.f5857F, 28, GraphQLGroupPushSubscriptionLevel.class, GraphQLGroupPushSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5857F;
            }

            private void m7369a(GraphQLGroupPushSubscriptionLevel graphQLGroupPushSubscriptionLevel) {
                this.f5857F = graphQLGroupPushSubscriptionLevel;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 28, graphQLGroupPushSubscriptionLevel != null ? graphQLGroupPushSubscriptionLevel.name() : null);
                }
            }

            @Nullable
            public final GraphQLGroupRequestToJoinSubscriptionLevel mo327g() {
                this.f5858G = (GraphQLGroupRequestToJoinSubscriptionLevel) super.b(this.f5858G, 29, GraphQLGroupRequestToJoinSubscriptionLevel.class, GraphQLGroupRequestToJoinSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5858G;
            }

            @Nullable
            public final GraphQLGroupSubscriptionLevel hd_() {
                this.f5859H = (GraphQLGroupSubscriptionLevel) super.b(this.f5859H, 30, GraphQLGroupSubscriptionLevel.class, GraphQLGroupSubscriptionLevel.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5859H;
            }

            private void m7370a(GraphQLGroupSubscriptionLevel graphQLGroupSubscriptionLevel) {
                this.f5859H = graphQLGroupSubscriptionLevel;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 30, graphQLGroupSubscriptionLevel != null ? graphQLGroupSubscriptionLevel.name() : null);
                }
            }

            @Nullable
            private GraphQLGroupVisibility m7366G() {
                this.f5860I = (GraphQLGroupVisibility) super.b(this.f5860I, 31, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5860I;
            }

            private void m7371a(GraphQLGroupVisibility graphQLGroupVisibility) {
                this.f5860I = graphQLGroupVisibility;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 31, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
                }
            }

            @Nullable
            private VisibilitySentenceModel m7367H() {
                this.f5861J = (VisibilitySentenceModel) super.a(this.f5861J, 32, VisibilitySentenceModel.class);
                return this.f5861J;
            }

            @Nullable
            public final String m7393a() {
                return m7381q();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m7392a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7377l() != null) {
                    GroupItemCoverPhotoModel groupItemCoverPhotoModel = (GroupItemCoverPhotoModel) graphQLModelMutatingVisitor.b(m7377l());
                    if (m7377l() != groupItemCoverPhotoModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5864f = groupItemCoverPhotoModel;
                    }
                }
                if (m7378m() != null) {
                    GroupPurposeFirstModel groupPurposeFirstModel = (GroupPurposeFirstModel) graphQLModelMutatingVisitor.b(m7378m());
                    if (m7378m() != groupPurposeFirstModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5865g = groupPurposeFirstModel;
                    }
                }
                if (m7379o() != null) {
                    GroupFeedModel groupFeedModel = (GroupFeedModel) graphQLModelMutatingVisitor.b(m7379o());
                    if (m7379o() != groupFeedModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5866h = groupFeedModel;
                    }
                }
                if (m7382r() != null) {
                    LastViewTimeModel lastViewTimeModel = (LastViewTimeModel) graphQLModelMutatingVisitor.b(m7382r());
                    if (m7382r() != lastViewTimeModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5871m = lastViewTimeModel;
                    }
                }
                if (m7383s() != null) {
                    ParentGroupModel parentGroupModel = (ParentGroupModel) graphQLModelMutatingVisitor.b(m7383s());
                    if (m7383s() != parentGroupModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5874p = parentGroupModel;
                    }
                }
                if (m7384t() != null) {
                    PendingMembersModel pendingMembersModel = (PendingMembersModel) graphQLModelMutatingVisitor.b(m7384t());
                    if (m7384t() != pendingMembersModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5875q = pendingMembersModel;
                    }
                }
                if (m7385u() != null) {
                    PendingStoriesModel pendingStoriesModel = (PendingStoriesModel) graphQLModelMutatingVisitor.b(m7385u());
                    if (m7385u() != pendingStoriesModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5876r = pendingStoriesModel;
                    }
                }
                if (m7386v() != null) {
                    PhotoForLauncherShortcutModel photoForLauncherShortcutModel = (PhotoForLauncherShortcutModel) graphQLModelMutatingVisitor.b(m7386v());
                    if (m7386v() != photoForLauncherShortcutModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5877s = photoForLauncherShortcutModel;
                    }
                }
                if (m7387w() != null) {
                    PossiblePushSubscriptionLevelsModel possiblePushSubscriptionLevelsModel = (PossiblePushSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7387w());
                    if (m7387w() != possiblePushSubscriptionLevelsModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5878t = possiblePushSubscriptionLevelsModel;
                    }
                }
                if (m7388x() != null) {
                    PossibleSubscriptionLevelsModel possibleSubscriptionLevelsModel = (PossibleSubscriptionLevelsModel) graphQLModelMutatingVisitor.b(m7388x());
                    if (m7388x() != possibleSubscriptionLevelsModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5879u = possibleSubscriptionLevelsModel;
                    }
                }
                if (m7389y() != null) {
                    ReportedStoriesModel reportedStoriesModel = (ReportedStoriesModel) graphQLModelMutatingVisitor.b(m7389y());
                    if (m7389y() != reportedStoriesModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5880v = reportedStoriesModel;
                    }
                }
                if (m7390z() != null) {
                    SettingsRowCoverPhotoModel settingsRowCoverPhotoModel = (SettingsRowCoverPhotoModel) graphQLModelMutatingVisitor.b(m7390z());
                    if (m7390z() != settingsRowCoverPhotoModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5881w = settingsRowCoverPhotoModel;
                    }
                }
                if (m7360A() != null) {
                    TreehouseMembersModel treehouseMembersModel = (TreehouseMembersModel) graphQLModelMutatingVisitor.b(m7360A());
                    if (m7360A() != treehouseMembersModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5882x = treehouseMembersModel;
                    }
                }
                if (m7361B() != null) {
                    TreehouseheaderCoverPhotoModel treehouseheaderCoverPhotoModel = (TreehouseheaderCoverPhotoModel) graphQLModelMutatingVisitor.b(m7361B());
                    if (m7361B() != treehouseheaderCoverPhotoModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5883y = treehouseheaderCoverPhotoModel;
                    }
                }
                if (m7367H() != null) {
                    VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) graphQLModelMutatingVisitor.b(m7367H());
                    if (m7367H() != visibilitySentenceModel) {
                        graphQLVisitableModel = (AdminAwareGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5861J = visibilitySentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7391a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7375j());
                int b2 = flatBufferBuilder.b(m7376k());
                int a = ModelHelper.a(flatBufferBuilder, m7377l());
                int a2 = ModelHelper.a(flatBufferBuilder, m7378m());
                int a3 = ModelHelper.a(flatBufferBuilder, m7379o());
                int b3 = flatBufferBuilder.b(m7381q());
                int a4 = ModelHelper.a(flatBufferBuilder, m7382r());
                int b4 = flatBufferBuilder.b(mo324b());
                int a5 = ModelHelper.a(flatBufferBuilder, m7383s());
                int a6 = ModelHelper.a(flatBufferBuilder, m7384t());
                int a7 = ModelHelper.a(flatBufferBuilder, m7385u());
                int a8 = ModelHelper.a(flatBufferBuilder, m7386v());
                int a9 = ModelHelper.a(flatBufferBuilder, m7387w());
                int a10 = ModelHelper.a(flatBufferBuilder, m7388x());
                int a11 = ModelHelper.a(flatBufferBuilder, m7389y());
                int a12 = ModelHelper.a(flatBufferBuilder, m7390z());
                int a13 = ModelHelper.a(flatBufferBuilder, m7360A());
                int a14 = ModelHelper.a(flatBufferBuilder, m7361B());
                int b5 = flatBufferBuilder.b(m7362C());
                int a15 = flatBufferBuilder.a(mo330n());
                int a16 = flatBufferBuilder.a(m7363D());
                int a17 = flatBufferBuilder.a(m7364E());
                int a18 = flatBufferBuilder.a(m7365F());
                int a19 = flatBufferBuilder.a(hc_());
                int a20 = flatBufferBuilder.a(mo327g());
                int a21 = flatBufferBuilder.a(hd_());
                int a22 = flatBufferBuilder.a(m7366G());
                int a23 = ModelHelper.a(flatBufferBuilder, m7367H());
                flatBufferBuilder.c(33);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.a(5, this.f5867i);
                flatBufferBuilder.a(6, this.f5868j);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.a(8, this.f5870l);
                flatBufferBuilder.b(9, a4);
                flatBufferBuilder.a(10, this.f5872n, 0);
                flatBufferBuilder.b(11, b4);
                flatBufferBuilder.b(12, a5);
                flatBufferBuilder.b(13, a6);
                flatBufferBuilder.b(14, a7);
                flatBufferBuilder.b(15, a8);
                flatBufferBuilder.b(16, a9);
                flatBufferBuilder.b(17, a10);
                flatBufferBuilder.b(18, a11);
                flatBufferBuilder.b(19, a12);
                flatBufferBuilder.b(20, a13);
                flatBufferBuilder.b(21, a14);
                flatBufferBuilder.b(22, b5);
                flatBufferBuilder.b(23, a15);
                flatBufferBuilder.b(24, a16);
                flatBufferBuilder.a(25, this.f5854C, 0);
                flatBufferBuilder.b(26, a17);
                flatBufferBuilder.b(27, a18);
                flatBufferBuilder.b(28, a19);
                flatBufferBuilder.b(29, a20);
                flatBufferBuilder.b(30, a21);
                flatBufferBuilder.b(31, a22);
                flatBufferBuilder.b(32, a23);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7394a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5867i = mutableFlatBuffer.a(i, 5);
                this.f5868j = mutableFlatBuffer.a(i, 6);
                this.f5870l = mutableFlatBuffer.a(i, 8);
                this.f5872n = mutableFlatBuffer.a(i, 10, 0);
                this.f5854C = mutableFlatBuffer.a(i, 25, 0);
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupCommonDataModel.class, new Deserializer());
            }

            public Object m7402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupCommonDataParser.m7486a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupCommonDataModel = new GroupCommonDataModel();
                ((BaseModel) groupCommonDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupCommonDataModel instanceof Postprocessable) {
                    return ((Postprocessable) groupCommonDataModel).a();
                }
                return groupCommonDataModel;
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Serializer extends JsonSerializer<GroupCommonDataModel> {
            public final void m7403a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupCommonDataModel groupCommonDataModel = (GroupCommonDataModel) obj;
                if (groupCommonDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupCommonDataModel.m7406a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupCommonDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupCommonDataParser.m7487b(groupCommonDataModel.w_(), groupCommonDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GroupCommonDataModel.class, new Serializer());
            }
        }

        public GroupCommonDataModel() {
            super(2);
        }

        public final void m7409a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7410a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AdminAwareGroupModel m7404j() {
            this.f5885d = (AdminAwareGroupModel) super.a(this.f5885d, 0, AdminAwareGroupModel.class);
            return this.f5885d;
        }

        @Nullable
        private String m7405k() {
            this.f5886e = super.a(this.f5886e, 1);
            return this.f5886e;
        }

        @Nullable
        public final String m7408a() {
            return m7405k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7404j() != null) {
                AdminAwareGroupModel adminAwareGroupModel = (AdminAwareGroupModel) graphQLModelMutatingVisitor.b(m7404j());
                if (m7404j() != adminAwareGroupModel) {
                    graphQLVisitableModel = (GroupCommonDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5885d = adminAwareGroupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7406a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7404j());
            int b = flatBufferBuilder.b(m7405k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2116135956)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_pic_frame_id */
    public final class GroupCommonDataPageInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f5887d;
        @Nullable
        private String f5888e;
        private boolean f5889f;
        @Nullable
        private String f5890g;

        /* compiled from: profile_pic_frame_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupCommonDataPageInfoModel.class, new Deserializer());
            }

            public Object m7411a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GroupCommonDataPageInfoParser.m7472a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object groupCommonDataPageInfoModel = new GroupCommonDataPageInfoModel();
                ((BaseModel) groupCommonDataPageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (groupCommonDataPageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) groupCommonDataPageInfoModel).a();
                }
                return groupCommonDataPageInfoModel;
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Serializer extends JsonSerializer<GroupCommonDataPageInfoModel> {
            public final void m7412a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GroupCommonDataPageInfoModel groupCommonDataPageInfoModel = (GroupCommonDataPageInfoModel) obj;
                if (groupCommonDataPageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupCommonDataPageInfoModel.m7416a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupCommonDataPageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GroupCommonDataPageInfoParser.m7473a(groupCommonDataPageInfoModel.w_(), groupCommonDataPageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GroupCommonDataPageInfoModel.class, new Serializer());
            }
        }

        public GroupCommonDataPageInfoModel() {
            super(4);
        }

        @Nullable
        private String m7413a() {
            this.f5887d = super.a(this.f5887d, 0);
            return this.f5887d;
        }

        @Nullable
        private String m7414j() {
            this.f5888e = super.a(this.f5888e, 1);
            return this.f5888e;
        }

        @Nullable
        private String m7415k() {
            this.f5890g = super.a(this.f5890g, 3);
            return this.f5890g;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m7417a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7416a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7413a());
            int b2 = flatBufferBuilder.b(m7414j());
            int b3 = flatBufferBuilder.b(m7415k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f5889f);
            flatBufferBuilder.b(3, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7418a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f5889f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 404192646)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_pic_frame_id */
    public final class GroupPurposesFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupPurposeFirstModel f5896d;

        /* compiled from: profile_pic_frame_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPurposesFragmentModel.class, new Deserializer());
            }

            public Object m7419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupPurposesFragmentParser.m7494a(jsonParser);
                Object groupPurposesFragmentModel = new GroupPurposesFragmentModel();
                ((BaseModel) groupPurposesFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupPurposesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPurposesFragmentModel).a();
                }
                return groupPurposesFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -58977704)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_pic_frame_id */
        public final class GroupPurposeFirstModel extends BaseModel implements GraphQLVisitableModel {
            private int f5894d;
            @Nullable
            private List<EdgesModel> f5895e;

            /* compiled from: profile_pic_frame_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupPurposeFirstModel.class, new Deserializer());
                }

                public Object m7420a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPurposeFirstParser.m7492a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupPurposeFirstModel = new GroupPurposeFirstModel();
                    ((BaseModel) groupPurposeFirstModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupPurposeFirstModel instanceof Postprocessable) {
                        return ((Postprocessable) groupPurposeFirstModel).a();
                    }
                    return groupPurposeFirstModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 684549480)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: profile_pic_frame_id */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f5893d;

                /* compiled from: profile_pic_frame_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m7421a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m7490b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 1213560187)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: profile_pic_frame_id */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLGroupPurposeType f5891d;
                    @Nullable
                    private String f5892e;

                    /* compiled from: profile_pic_frame_id */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m7422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m7488a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: profile_pic_frame_id */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m7423a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m7426a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m7489a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLGroupPurposeType m7424a() {
                        this.f5891d = (GraphQLGroupPurposeType) super.b(this.f5891d, 0, GraphQLGroupPurposeType.class, GraphQLGroupPurposeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f5891d;
                    }

                    @Nullable
                    private String m7425j() {
                        this.f5892e = super.a(this.f5892e, 1);
                        return this.f5892e;
                    }

                    public final int jK_() {
                        return -405572161;
                    }

                    public final GraphQLVisitableModel m7427a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m7426a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = flatBufferBuilder.a(m7424a());
                        int b = flatBufferBuilder.b(m7425j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: profile_pic_frame_id */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m7428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m7430a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m7491b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m7429a() {
                    this.f5893d = (NodeModel) super.a(this.f5893d, 0, NodeModel.class);
                    return this.f5893d;
                }

                public final int jK_() {
                    return 397031628;
                }

                public final GraphQLVisitableModel m7431a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7429a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m7429a());
                        if (m7429a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5893d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7430a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7429a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: profile_pic_frame_id */
            public class Serializer extends JsonSerializer<GroupPurposeFirstModel> {
                public final void m7432a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupPurposeFirstModel groupPurposeFirstModel = (GroupPurposeFirstModel) obj;
                    if (groupPurposeFirstModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupPurposeFirstModel.m7434a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupPurposeFirstModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPurposeFirstParser.m7493a(groupPurposeFirstModel.w_(), groupPurposeFirstModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupPurposeFirstModel.class, new Serializer());
                }
            }

            public GroupPurposeFirstModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m7433a() {
                this.f5895e = super.a(this.f5895e, 1, EdgesModel.class);
                return (ImmutableList) this.f5895e;
            }

            public final int jK_() {
                return -1875344723;
            }

            public final GraphQLVisitableModel m7435a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7433a() != null) {
                    Builder a = ModelHelper.a(m7433a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupPurposeFirstModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5895e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7434a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7433a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f5894d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7436a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f5894d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: profile_pic_frame_id */
        public class Serializer extends JsonSerializer<GroupPurposesFragmentModel> {
            public final void m7437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupPurposesFragmentModel groupPurposesFragmentModel = (GroupPurposesFragmentModel) obj;
                if (groupPurposesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPurposesFragmentModel.m7439a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPurposesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupPurposesFragmentModel.w_();
                int u_ = groupPurposesFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("groupPurposeFirst");
                    GroupPurposeFirstParser.m7493a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupPurposesFragmentModel.class, new Serializer());
            }
        }

        public GroupPurposesFragmentModel() {
            super(1);
        }

        public final void m7441a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7442a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupPurposeFirstModel m7438a() {
            this.f5896d = (GroupPurposeFirstModel) super.a(this.f5896d, 0, GroupPurposeFirstModel.class);
            return this.f5896d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7440a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7438a() != null) {
                GroupPurposeFirstModel groupPurposeFirstModel = (GroupPurposeFirstModel) graphQLModelMutatingVisitor.b(m7438a());
                if (m7438a() != groupPurposeFirstModel) {
                    graphQLVisitableModel = (GroupPurposesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5896d = groupPurposeFirstModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7439a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7438a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
