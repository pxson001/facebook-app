package com.facebook.groups.editsettings.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettingsParsers.FBGroupEditSettingsMutationParser;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettingsParsers.FBGroupEditSettingsMutationParser.GroupParser;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettingsParsers.FBGroupEditSettingsMutationParser.GroupParser.VisibilitySentenceParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: Unable to retrieve MRU sticker ids */
public class FetchGroupEditSettingsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1655031653)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: Unable to retrieve MRU sticker ids */
    public final class FBGroupEditSettingsMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f21691d;

        /* compiled from: Unable to retrieve MRU sticker ids */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGroupEditSettingsMutationModel.class, new Deserializer());
            }

            public Object m22646a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBGroupEditSettingsMutationParser.m22687a(jsonParser);
                Object fBGroupEditSettingsMutationModel = new FBGroupEditSettingsMutationModel();
                ((BaseModel) fBGroupEditSettingsMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBGroupEditSettingsMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGroupEditSettingsMutationModel).a();
                }
                return fBGroupEditSettingsMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1342475382)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: Unable to retrieve MRU sticker ids */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f21679d;
            @Nullable
            private String f21680e;
            @Nullable
            private String f21681f;
            @Nullable
            private GraphQLGroupJoinApprovalSetting f21682g;
            @Nullable
            private String f21683h;
            @Nullable
            private GraphQLGroupPostPermissionSetting f21684i;
            private boolean f21685j;
            private boolean f21686k;
            @Nullable
            private GraphQLGroupJoinState f21687l;
            @Nullable
            private GraphQLGroupPostStatus f21688m;
            @Nullable
            private GraphQLGroupVisibility f21689n;
            @Nullable
            private VisibilitySentenceModel f21690o;

            /* compiled from: Unable to retrieve MRU sticker ids */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m22647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m22685a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupModel = new GroupModel();
                    ((BaseModel) groupModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupModel instanceof Postprocessable) {
                        return ((Postprocessable) groupModel).a();
                    }
                    return groupModel;
                }
            }

            /* compiled from: Unable to retrieve MRU sticker ids */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m22648a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m22673a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m22686a(groupModel.w_(), groupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: Unable to retrieve MRU sticker ids */
            public final class VisibilitySentenceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f21678d;

                /* compiled from: Unable to retrieve MRU sticker ids */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(VisibilitySentenceModel.class, new Deserializer());
                    }

                    public Object m22649a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VisibilitySentenceParser.m22683a(jsonParser, flatBufferBuilder));
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

                /* compiled from: Unable to retrieve MRU sticker ids */
                public class Serializer extends JsonSerializer<VisibilitySentenceModel> {
                    public final void m22650a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) obj;
                        if (visibilitySentenceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(visibilitySentenceModel.m22652a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            visibilitySentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VisibilitySentenceParser.m22684a(visibilitySentenceModel.w_(), visibilitySentenceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(VisibilitySentenceModel.class, new Serializer());
                    }
                }

                public VisibilitySentenceModel() {
                    super(1);
                }

                @Nullable
                private String m22651a() {
                    this.f21678d = super.a(this.f21678d, 0);
                    return this.f21678d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m22653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m22652a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m22651a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public GroupModel() {
                super(12);
            }

            public final void m22677a(String str, ConsistencyTuple consistencyTuple) {
                if ("description".equals(str)) {
                    consistencyTuple.a = m22662j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("join_approval_setting".equals(str)) {
                    consistencyTuple.a = m22664l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("name".equals(str)) {
                    consistencyTuple.a = m22665m();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("post_permission_setting".equals(str)) {
                    consistencyTuple.a = m22666n();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 5;
                } else if ("requires_admin_membership_approval".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m22667o());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else if ("requires_post_approval".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m22668p());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 7;
                } else if ("viewer_join_state".equals(str)) {
                    consistencyTuple.a = m22669q();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 8;
                } else if ("visibility".equals(str)) {
                    consistencyTuple.a = m22671s();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 10;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m22678a(String str, Object obj, boolean z) {
                if ("description".equals(str)) {
                    m22658a((String) obj);
                } else if ("join_approval_setting".equals(str)) {
                    m22654a((GraphQLGroupJoinApprovalSetting) obj);
                } else if ("name".equals(str)) {
                    m22660b((String) obj);
                } else if ("post_permission_setting".equals(str)) {
                    m22656a((GraphQLGroupPostPermissionSetting) obj);
                } else if ("requires_admin_membership_approval".equals(str)) {
                    m22659a(((Boolean) obj).booleanValue());
                } else if ("requires_post_approval".equals(str)) {
                    m22661b(((Boolean) obj).booleanValue());
                } else if ("viewer_join_state".equals(str)) {
                    m22655a((GraphQLGroupJoinState) obj);
                } else if ("visibility".equals(str)) {
                    m22657a((GraphQLGroupVisibility) obj);
                }
            }

            @Nullable
            private String m22662j() {
                this.f21680e = super.a(this.f21680e, 1);
                return this.f21680e;
            }

            private void m22658a(@Nullable String str) {
                this.f21680e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            @Nullable
            private String m22663k() {
                this.f21681f = super.a(this.f21681f, 2);
                return this.f21681f;
            }

            @Nullable
            private GraphQLGroupJoinApprovalSetting m22664l() {
                this.f21682g = (GraphQLGroupJoinApprovalSetting) super.b(this.f21682g, 3, GraphQLGroupJoinApprovalSetting.class, GraphQLGroupJoinApprovalSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f21682g;
            }

            private void m22654a(GraphQLGroupJoinApprovalSetting graphQLGroupJoinApprovalSetting) {
                this.f21682g = graphQLGroupJoinApprovalSetting;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, graphQLGroupJoinApprovalSetting != null ? graphQLGroupJoinApprovalSetting.name() : null);
                }
            }

            @Nullable
            private String m22665m() {
                this.f21683h = super.a(this.f21683h, 4);
                return this.f21683h;
            }

            private void m22660b(@Nullable String str) {
                this.f21683h = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, str);
                }
            }

            @Nullable
            private GraphQLGroupPostPermissionSetting m22666n() {
                this.f21684i = (GraphQLGroupPostPermissionSetting) super.b(this.f21684i, 5, GraphQLGroupPostPermissionSetting.class, GraphQLGroupPostPermissionSetting.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f21684i;
            }

            private void m22656a(GraphQLGroupPostPermissionSetting graphQLGroupPostPermissionSetting) {
                this.f21684i = graphQLGroupPostPermissionSetting;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 5, graphQLGroupPostPermissionSetting != null ? graphQLGroupPostPermissionSetting.name() : null);
                }
            }

            private boolean m22667o() {
                a(0, 6);
                return this.f21685j;
            }

            private void m22659a(boolean z) {
                this.f21685j = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, z);
                }
            }

            private boolean m22668p() {
                a(0, 7);
                return this.f21686k;
            }

            private void m22661b(boolean z) {
                this.f21686k = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 7, z);
                }
            }

            @Nullable
            private GraphQLGroupJoinState m22669q() {
                this.f21687l = (GraphQLGroupJoinState) super.b(this.f21687l, 8, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f21687l;
            }

            private void m22655a(GraphQLGroupJoinState graphQLGroupJoinState) {
                this.f21687l = graphQLGroupJoinState;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 8, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
                }
            }

            @Nullable
            private GraphQLGroupPostStatus m22670r() {
                this.f21688m = (GraphQLGroupPostStatus) super.b(this.f21688m, 9, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f21688m;
            }

            @Nullable
            private GraphQLGroupVisibility m22671s() {
                this.f21689n = (GraphQLGroupVisibility) super.b(this.f21689n, 10, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f21689n;
            }

            private void m22657a(GraphQLGroupVisibility graphQLGroupVisibility) {
                this.f21689n = graphQLGroupVisibility;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 10, graphQLGroupVisibility != null ? graphQLGroupVisibility.name() : null);
                }
            }

            @Nullable
            private VisibilitySentenceModel m22672t() {
                this.f21690o = (VisibilitySentenceModel) super.a(this.f21690o, 11, VisibilitySentenceModel.class);
                return this.f21690o;
            }

            @Nullable
            public final String m22675a() {
                return m22663k();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m22674a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22672t() != null) {
                    VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) graphQLModelMutatingVisitor.b(m22672t());
                    if (m22672t() != visibilitySentenceModel) {
                        graphQLVisitableModel = (GroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21690o = visibilitySentenceModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22673a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m22662j());
                int b2 = flatBufferBuilder.b(m22663k());
                int a = flatBufferBuilder.a(m22664l());
                int b3 = flatBufferBuilder.b(m22665m());
                int a2 = flatBufferBuilder.a(m22666n());
                int a3 = flatBufferBuilder.a(m22669q());
                int a4 = flatBufferBuilder.a(m22670r());
                int a5 = flatBufferBuilder.a(m22671s());
                int a6 = ModelHelper.a(flatBufferBuilder, m22672t());
                flatBufferBuilder.c(12);
                flatBufferBuilder.a(0, this.f21679d);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.a(6, this.f21685j);
                flatBufferBuilder.a(7, this.f21686k);
                flatBufferBuilder.b(8, a3);
                flatBufferBuilder.b(9, a4);
                flatBufferBuilder.b(10, a5);
                flatBufferBuilder.b(11, a6);
                i();
                return flatBufferBuilder.d();
            }

            public final void m22676a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f21679d = mutableFlatBuffer.a(i, 0);
                this.f21685j = mutableFlatBuffer.a(i, 6);
                this.f21686k = mutableFlatBuffer.a(i, 7);
            }
        }

        /* compiled from: Unable to retrieve MRU sticker ids */
        public class Serializer extends JsonSerializer<FBGroupEditSettingsMutationModel> {
            public final void m22679a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBGroupEditSettingsMutationModel fBGroupEditSettingsMutationModel = (FBGroupEditSettingsMutationModel) obj;
                if (fBGroupEditSettingsMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGroupEditSettingsMutationModel.m22681a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGroupEditSettingsMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBGroupEditSettingsMutationModel.w_();
                int u_ = fBGroupEditSettingsMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m22686a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBGroupEditSettingsMutationModel.class, new Serializer());
            }
        }

        public FBGroupEditSettingsMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m22680a() {
            this.f21691d = (GroupModel) super.a(this.f21691d, 0, GroupModel.class);
            return this.f21691d;
        }

        public final int jK_() {
            return -1746793020;
        }

        public final GraphQLVisitableModel m22682a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22680a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m22680a());
                if (m22680a() != groupModel) {
                    graphQLVisitableModel = (FBGroupEditSettingsMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21691d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22681a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22680a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
