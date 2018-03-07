package com.facebook.groups.mutations.protocol;

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
import com.facebook.groups.mutations.protocol.GroupPostMutationsParsers.GroupApprovePendingStoryMutationParser;
import com.facebook.groups.mutations.protocol.GroupPostMutationsParsers.GroupApprovePendingStoryMutationParser.GroupParser;
import com.facebook.groups.mutations.protocol.GroupPostMutationsParsers.GroupPinStoryMutationParser;
import com.facebook.groups.mutations.protocol.GroupPostMutationsParsers.GroupUnpinStoryMutationParser;
import com.facebook.groups.mutations.protocol.GroupPostMutationsParsers.LocalGroupModerationFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: entity_cards_remove_title_bar */
public class GroupPostMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 544045736)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_cards_remove_title_bar */
    public final class GroupApprovePendingStoryMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14776d;

        /* compiled from: entity_cards_remove_title_bar */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupApprovePendingStoryMutationModel.class, new Deserializer());
            }

            public Object m17071a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupApprovePendingStoryMutationParser.m17130a(jsonParser);
                Object groupApprovePendingStoryMutationModel = new GroupApprovePendingStoryMutationModel();
                ((BaseModel) groupApprovePendingStoryMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupApprovePendingStoryMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupApprovePendingStoryMutationModel).a();
                }
                return groupApprovePendingStoryMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_cards_remove_title_bar */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14775d;

            /* compiled from: entity_cards_remove_title_bar */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m17128a(jsonParser, flatBufferBuilder));
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

            /* compiled from: entity_cards_remove_title_bar */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17073a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17075a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m17129a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m17078a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17079a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17074j() {
                this.f14775d = super.a(this.f14775d, 0);
                return this.f14775d;
            }

            @Nullable
            public final String m17077a() {
                return m17074j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17075a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17074j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: entity_cards_remove_title_bar */
        public class Serializer extends JsonSerializer<GroupApprovePendingStoryMutationModel> {
            public final void m17080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupApprovePendingStoryMutationModel groupApprovePendingStoryMutationModel = (GroupApprovePendingStoryMutationModel) obj;
                if (groupApprovePendingStoryMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupApprovePendingStoryMutationModel.m17082a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupApprovePendingStoryMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupApprovePendingStoryMutationModel.w_();
                int u_ = groupApprovePendingStoryMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m17129a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupApprovePendingStoryMutationModel.class, new Serializer());
            }
        }

        public GroupApprovePendingStoryMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17081a() {
            this.f14776d = (GroupModel) super.a(this.f14776d, 0, GroupModel.class);
            return this.f14776d;
        }

        public final int jK_() {
            return -2093427775;
        }

        public final GraphQLVisitableModel m17083a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17081a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17081a());
                if (m17081a() != groupModel) {
                    graphQLVisitableModel = (GroupApprovePendingStoryMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14776d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17082a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17081a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 977109267)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_cards_remove_title_bar */
    public final class GroupPinStoryMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14778d;

        /* compiled from: entity_cards_remove_title_bar */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupPinStoryMutationModel.class, new Deserializer());
            }

            public Object m17084a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupPinStoryMutationParser.m17133a(jsonParser);
                Object groupPinStoryMutationModel = new GroupPinStoryMutationModel();
                ((BaseModel) groupPinStoryMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupPinStoryMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupPinStoryMutationModel).a();
                }
                return groupPinStoryMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_cards_remove_title_bar */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14777d;

            /* compiled from: entity_cards_remove_title_bar */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17085a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupPinStoryMutationParser.GroupParser.m17131a(jsonParser, flatBufferBuilder));
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

            /* compiled from: entity_cards_remove_title_bar */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17088a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupPinStoryMutationParser.GroupParser.m17132a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m17091a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17092a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17087j() {
                this.f14777d = super.a(this.f14777d, 0);
                return this.f14777d;
            }

            @Nullable
            public final String m17090a() {
                return m17087j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17089a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17088a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17087j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: entity_cards_remove_title_bar */
        public class Serializer extends JsonSerializer<GroupPinStoryMutationModel> {
            public final void m17093a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupPinStoryMutationModel groupPinStoryMutationModel = (GroupPinStoryMutationModel) obj;
                if (groupPinStoryMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupPinStoryMutationModel.m17095a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupPinStoryMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupPinStoryMutationModel.w_();
                int u_ = groupPinStoryMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupPinStoryMutationParser.GroupParser.m17132a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupPinStoryMutationModel.class, new Serializer());
            }
        }

        public GroupPinStoryMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17094a() {
            this.f14778d = (GroupModel) super.a(this.f14778d, 0, GroupModel.class);
            return this.f14778d;
        }

        public final int jK_() {
            return 1453637678;
        }

        public final GraphQLVisitableModel m17096a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17094a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17094a());
                if (m17094a() != groupModel) {
                    graphQLVisitableModel = (GroupPinStoryMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14778d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17095a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17094a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1342955902)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_cards_remove_title_bar */
    public final class GroupUnpinStoryMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f14780d;

        /* compiled from: entity_cards_remove_title_bar */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GroupUnpinStoryMutationModel.class, new Deserializer());
            }

            public Object m17097a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GroupUnpinStoryMutationParser.m17136a(jsonParser);
                Object groupUnpinStoryMutationModel = new GroupUnpinStoryMutationModel();
                ((BaseModel) groupUnpinStoryMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (groupUnpinStoryMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) groupUnpinStoryMutationModel).a();
                }
                return groupUnpinStoryMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: entity_cards_remove_title_bar */
        public final class GroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f14779d;

            /* compiled from: entity_cards_remove_title_bar */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m17098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupUnpinStoryMutationParser.GroupParser.m17134a(jsonParser, flatBufferBuilder));
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

            /* compiled from: entity_cards_remove_title_bar */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m17099a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m17101a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupUnpinStoryMutationParser.GroupParser.m17135a(groupModel.w_(), groupModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m17104a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17105a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17100j() {
                this.f14779d = super.a(this.f14779d, 0);
                return this.f14779d;
            }

            @Nullable
            public final String m17103a() {
                return m17100j();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m17102a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17101a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17100j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: entity_cards_remove_title_bar */
        public class Serializer extends JsonSerializer<GroupUnpinStoryMutationModel> {
            public final void m17106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GroupUnpinStoryMutationModel groupUnpinStoryMutationModel = (GroupUnpinStoryMutationModel) obj;
                if (groupUnpinStoryMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(groupUnpinStoryMutationModel.m17108a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    groupUnpinStoryMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = groupUnpinStoryMutationModel.w_();
                int u_ = groupUnpinStoryMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupUnpinStoryMutationParser.GroupParser.m17135a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GroupUnpinStoryMutationModel.class, new Serializer());
            }
        }

        public GroupUnpinStoryMutationModel() {
            super(1);
        }

        @Nullable
        private GroupModel m17107a() {
            this.f14780d = (GroupModel) super.a(this.f14780d, 0, GroupModel.class);
            return this.f14780d;
        }

        public final int jK_() {
            return 45625653;
        }

        public final GraphQLVisitableModel m17109a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17107a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m17107a());
                if (m17107a() != groupModel) {
                    graphQLVisitableModel = (GroupUnpinStoryMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14780d = groupModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17108a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17107a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1388001995)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: entity_cards_remove_title_bar */
    public final class LocalGroupModerationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f14786d;
        private boolean f14787e;
        private boolean f14788f;
        private boolean f14789g;
        private boolean f14790h;

        /* compiled from: entity_cards_remove_title_bar */
        public final class Builder {
            @Nullable
            public String f14781a;
            public boolean f14782b;
            public boolean f14783c;
            public boolean f14784d;
            public boolean f14785e;

            public final LocalGroupModerationFieldsModel m17110a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f14781a);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f14782b);
                flatBufferBuilder.a(2, this.f14783c);
                flatBufferBuilder.a(3, this.f14784d);
                flatBufferBuilder.a(4, this.f14785e);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new LocalGroupModerationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: entity_cards_remove_title_bar */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocalGroupModerationFieldsModel.class, new Deserializer());
            }

            public Object m17111a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LocalGroupModerationFieldsParser.m17137a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object localGroupModerationFieldsModel = new LocalGroupModerationFieldsModel();
                ((BaseModel) localGroupModerationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (localGroupModerationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) localGroupModerationFieldsModel).a();
                }
                return localGroupModerationFieldsModel;
            }
        }

        /* compiled from: entity_cards_remove_title_bar */
        public class Serializer extends JsonSerializer<LocalGroupModerationFieldsModel> {
            public final void m17112a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocalGroupModerationFieldsModel localGroupModerationFieldsModel = (LocalGroupModerationFieldsModel) obj;
                if (localGroupModerationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(localGroupModerationFieldsModel.m17122a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    localGroupModerationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = localGroupModerationFieldsModel.w_();
                int u_ = localGroupModerationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("local_group_did_approve");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("local_group_did_ignore_report");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("local_group_did_pin");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 4);
                if (a) {
                    jsonGenerator.a("local_group_did_unpin");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocalGroupModerationFieldsModel.class, new Serializer());
            }
        }

        public LocalGroupModerationFieldsModel() {
            super(5);
        }

        public LocalGroupModerationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m17126a(String str, ConsistencyTuple consistencyTuple) {
            if ("local_group_did_approve".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m17118k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("local_group_did_ignore_report".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m17119l());
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else if ("local_group_did_pin".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m17120m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("local_group_did_unpin".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m17121n());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m17127a(String str, Object obj, boolean z) {
            if ("local_group_did_approve".equals(str)) {
                m17113a(((Boolean) obj).booleanValue());
            } else if ("local_group_did_ignore_report".equals(str)) {
                m17114b(((Boolean) obj).booleanValue());
            } else if ("local_group_did_pin".equals(str)) {
                m17115c(((Boolean) obj).booleanValue());
            } else if ("local_group_did_unpin".equals(str)) {
                m17116d(((Boolean) obj).booleanValue());
            }
        }

        @Nullable
        private String m17117j() {
            this.f14786d = super.a(this.f14786d, 0);
            return this.f14786d;
        }

        private boolean m17118k() {
            a(0, 1);
            return this.f14787e;
        }

        private void m17113a(boolean z) {
            this.f14787e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        private boolean m17119l() {
            a(0, 2);
            return this.f14788f;
        }

        private void m17114b(boolean z) {
            this.f14788f = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, z);
            }
        }

        private boolean m17120m() {
            a(0, 3);
            return this.f14789g;
        }

        private void m17115c(boolean z) {
            this.f14789g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        private boolean m17121n() {
            a(0, 4);
            return this.f14790h;
        }

        private void m17116d(boolean z) {
            this.f14790h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        @Nullable
        public final String m17124a() {
            return m17117j();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m17123a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17122a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m17117j());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f14787e);
            flatBufferBuilder.a(2, this.f14788f);
            flatBufferBuilder.a(3, this.f14789g);
            flatBufferBuilder.a(4, this.f14790h);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17125a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f14787e = mutableFlatBuffer.a(i, 1);
            this.f14788f = mutableFlatBuffer.a(i, 2);
            this.f14789g = mutableFlatBuffer.a(i, 3);
            this.f14790h = mutableFlatBuffer.a(i, 4);
        }
    }
}
