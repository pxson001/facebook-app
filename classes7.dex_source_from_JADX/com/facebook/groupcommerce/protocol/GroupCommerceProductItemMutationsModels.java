package com.facebook.groupcommerce.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.GroupParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.GroupParser.GroupOwnerAuthoredStoriesParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.StoryParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.StoryParser.AttachmentsParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.StoryParser.AttachmentsParser.AttachmentPropertiesParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.StoryParser.AttachmentsParser.AttachmentPropertiesParser.ValueParser;
import com.facebook.groupcommerce.protocol.GroupCommerceProductItemMutationsParsers.ProductItemChangeAvailabilityCoreMutationFieldsParser.StoryParser.AttachmentsParser.TargetParser;
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

/* compiled from: recent_invitee_section */
public class GroupCommerceProductItemMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1316091981)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: recent_invitee_section */
    public final class ProductItemChangeAvailabilityCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GroupModel f5413d;
        @Nullable
        private StoryModel f5414e;

        /* compiled from: recent_invitee_section */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProductItemChangeAvailabilityCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m5965a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProductItemChangeAvailabilityCoreMutationFieldsParser.m6037a(jsonParser);
                Object productItemChangeAvailabilityCoreMutationFieldsModel = new ProductItemChangeAvailabilityCoreMutationFieldsModel();
                ((BaseModel) productItemChangeAvailabilityCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (productItemChangeAvailabilityCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) productItemChangeAvailabilityCoreMutationFieldsModel).a();
                }
                return productItemChangeAvailabilityCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1861648428)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: recent_invitee_section */
        public final class GroupModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GroupOwnerAuthoredStoriesModel f5401d;

            /* compiled from: recent_invitee_section */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupModel.class, new Deserializer());
                }

                public Object m5966a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupParser.m6025a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -640101579)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: recent_invitee_section */
            public final class GroupOwnerAuthoredStoriesModel extends BaseModel implements GraphQLVisitableModel {
                private int f5399d;
                private int f5400e;

                /* compiled from: recent_invitee_section */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GroupOwnerAuthoredStoriesModel.class, new Deserializer());
                    }

                    public Object m5967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupOwnerAuthoredStoriesParser.m6023a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object groupOwnerAuthoredStoriesModel = new GroupOwnerAuthoredStoriesModel();
                        ((BaseModel) groupOwnerAuthoredStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (groupOwnerAuthoredStoriesModel instanceof Postprocessable) {
                            return ((Postprocessable) groupOwnerAuthoredStoriesModel).a();
                        }
                        return groupOwnerAuthoredStoriesModel;
                    }
                }

                /* compiled from: recent_invitee_section */
                public class Serializer extends JsonSerializer<GroupOwnerAuthoredStoriesModel> {
                    public final void m5968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GroupOwnerAuthoredStoriesModel groupOwnerAuthoredStoriesModel = (GroupOwnerAuthoredStoriesModel) obj;
                        if (groupOwnerAuthoredStoriesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(groupOwnerAuthoredStoriesModel.m5970a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            groupOwnerAuthoredStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupOwnerAuthoredStoriesParser.m6024a(groupOwnerAuthoredStoriesModel.w_(), groupOwnerAuthoredStoriesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(GroupOwnerAuthoredStoriesModel.class, new Serializer());
                    }
                }

                public GroupOwnerAuthoredStoriesModel() {
                    super(2);
                }

                public final int m5969a() {
                    a(0, 0);
                    return this.f5399d;
                }

                public final void m5972a(int i) {
                    this.f5399d = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 0, i);
                    }
                }

                public final int m5975j() {
                    a(0, 1);
                    return this.f5400e;
                }

                public final void m5974b(int i) {
                    this.f5400e = i;
                    if (this.b != null && this.b.d) {
                        this.b.b(this.c, 1, i);
                    }
                }

                public final int jK_() {
                    return -2125813741;
                }

                public final GraphQLVisitableModel m5971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5970a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f5399d, 0);
                    flatBufferBuilder.a(1, this.f5400e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m5973a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5399d = mutableFlatBuffer.a(i, 0, 0);
                    this.f5400e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: recent_invitee_section */
            public class Serializer extends JsonSerializer<GroupModel> {
                public final void m5976a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupModel groupModel = (GroupModel) obj;
                    if (groupModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupModel.m5978a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupParser.m6026a(groupModel.w_(), groupModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupModel.class, new Serializer());
                }
            }

            public GroupModel() {
                super(1);
            }

            public final void m5980a(String str, ConsistencyTuple consistencyTuple) {
                GroupOwnerAuthoredStoriesModel a;
                if ("group_owner_authored_stories.available_for_sale_count".equals(str)) {
                    a = m5977a();
                    if (a != null) {
                        consistencyTuple.a = Integer.valueOf(a.m5969a());
                        consistencyTuple.b = a.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("group_owner_authored_stories.total_for_sale_count".equals(str)) {
                    a = m5977a();
                    if (a != null) {
                        consistencyTuple.a = Integer.valueOf(a.m5975j());
                        consistencyTuple.b = a.u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                }
                consistencyTuple.a();
            }

            public final void m5981a(String str, Object obj, boolean z) {
                GroupOwnerAuthoredStoriesModel a;
                if ("group_owner_authored_stories.available_for_sale_count".equals(str)) {
                    a = m5977a();
                    if (a == null) {
                        return;
                    }
                    if (z) {
                        a = (GroupOwnerAuthoredStoriesModel) a.clone();
                        a.m5972a(((Integer) obj).intValue());
                        this.f5401d = a;
                        return;
                    }
                    a.m5972a(((Integer) obj).intValue());
                } else if ("group_owner_authored_stories.total_for_sale_count".equals(str)) {
                    a = m5977a();
                    if (a == null) {
                        return;
                    }
                    if (z) {
                        a = (GroupOwnerAuthoredStoriesModel) a.clone();
                        a.m5974b(((Integer) obj).intValue());
                        this.f5401d = a;
                        return;
                    }
                    a.m5974b(((Integer) obj).intValue());
                }
            }

            @Nullable
            private GroupOwnerAuthoredStoriesModel m5977a() {
                this.f5401d = (GroupOwnerAuthoredStoriesModel) super.a(this.f5401d, 0, GroupOwnerAuthoredStoriesModel.class);
                return this.f5401d;
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m5979a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5977a() != null) {
                    GroupOwnerAuthoredStoriesModel groupOwnerAuthoredStoriesModel = (GroupOwnerAuthoredStoriesModel) graphQLModelMutatingVisitor.b(m5977a());
                    if (m5977a() != groupOwnerAuthoredStoriesModel) {
                        graphQLVisitableModel = (GroupModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5401d = groupOwnerAuthoredStoriesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5978a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5977a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: recent_invitee_section */
        public class Serializer extends JsonSerializer<ProductItemChangeAvailabilityCoreMutationFieldsModel> {
            public final void m5982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProductItemChangeAvailabilityCoreMutationFieldsModel productItemChangeAvailabilityCoreMutationFieldsModel = (ProductItemChangeAvailabilityCoreMutationFieldsModel) obj;
                if (productItemChangeAvailabilityCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(productItemChangeAvailabilityCoreMutationFieldsModel.m6021a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    productItemChangeAvailabilityCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = productItemChangeAvailabilityCoreMutationFieldsModel.w_();
                int u_ = productItemChangeAvailabilityCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group");
                    GroupParser.m6026a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("story");
                    StoryParser.m6036a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProductItemChangeAvailabilityCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 882889452)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: recent_invitee_section */
        public final class StoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private List<AttachmentsModel> f5412d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -771843092)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: recent_invitee_section */
            public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<AttachmentPropertiesModel> f5410d;
                @Nullable
                private TargetModel f5411e;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -449566365)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: recent_invitee_section */
                public final class AttachmentPropertiesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ValueModel f5403d;

                    /* compiled from: recent_invitee_section */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(AttachmentPropertiesModel.class, new Deserializer());
                        }

                        public Object m5983a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(AttachmentPropertiesParser.m6029b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object attachmentPropertiesModel = new AttachmentPropertiesModel();
                            ((BaseModel) attachmentPropertiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (attachmentPropertiesModel instanceof Postprocessable) {
                                return ((Postprocessable) attachmentPropertiesModel).a();
                            }
                            return attachmentPropertiesModel;
                        }
                    }

                    /* compiled from: recent_invitee_section */
                    public class Serializer extends JsonSerializer<AttachmentPropertiesModel> {
                        public final void m5984a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            AttachmentPropertiesModel attachmentPropertiesModel = (AttachmentPropertiesModel) obj;
                            if (attachmentPropertiesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(attachmentPropertiesModel.m5991a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                attachmentPropertiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            AttachmentPropertiesParser.m6030b(attachmentPropertiesModel.w_(), attachmentPropertiesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(AttachmentPropertiesModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1352864475)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: recent_invitee_section */
                    public final class ValueModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f5402d;

                        /* compiled from: recent_invitee_section */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ValueModel.class, new Deserializer());
                            }

                            public Object m5985a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ValueParser.m6027a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object valueModel = new ValueModel();
                                ((BaseModel) valueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (valueModel instanceof Postprocessable) {
                                    return ((Postprocessable) valueModel).a();
                                }
                                return valueModel;
                            }
                        }

                        /* compiled from: recent_invitee_section */
                        public class Serializer extends JsonSerializer<ValueModel> {
                            public final void m5986a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ValueModel valueModel = (ValueModel) obj;
                                if (valueModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(valueModel.m5988a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    valueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ValueParser.m6028a(valueModel.w_(), valueModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ValueModel.class, new Serializer());
                            }
                        }

                        public ValueModel() {
                            super(1);
                        }

                        @Nullable
                        private String m5987a() {
                            this.f5402d = super.a(this.f5402d, 0);
                            return this.f5402d;
                        }

                        public final int jK_() {
                            return -1919764332;
                        }

                        public final GraphQLVisitableModel m5989a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m5988a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m5987a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public AttachmentPropertiesModel() {
                        super(1);
                    }

                    @Nullable
                    private ValueModel m5990a() {
                        this.f5403d = (ValueModel) super.a(this.f5403d, 0, ValueModel.class);
                        return this.f5403d;
                    }

                    public final int jK_() {
                        return -363494344;
                    }

                    public final GraphQLVisitableModel m5992a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m5990a() != null) {
                            ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m5990a());
                            if (m5990a() != valueModel) {
                                graphQLVisitableModel = (AttachmentPropertiesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f5403d = valueModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m5991a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m5990a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: recent_invitee_section */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                    }

                    public Object m5993a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AttachmentsParser.m6033b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object attachmentsModel = new AttachmentsModel();
                        ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (attachmentsModel instanceof Postprocessable) {
                            return ((Postprocessable) attachmentsModel).a();
                        }
                        return attachmentsModel;
                    }
                }

                /* compiled from: recent_invitee_section */
                public class Serializer extends JsonSerializer<AttachmentsModel> {
                    public final void m5994a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                        if (attachmentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(attachmentsModel.m6010a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AttachmentsParser.m6034b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1179968873)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: recent_invitee_section */
                public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f5407d;
                    @Nullable
                    private String f5408e;
                    private boolean f5409f;

                    /* compiled from: recent_invitee_section */
                    public final class Builder {
                        @Nullable
                        public GraphQLObjectType f5404a;
                        @Nullable
                        public String f5405b;
                        public boolean f5406c;

                        public final TargetModel m5995a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f5404a);
                            int b = flatBufferBuilder.b(this.f5405b);
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.a(2, this.f5406c);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new TargetModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: recent_invitee_section */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                        }

                        public Object m5996a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TargetParser.m6031a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object targetModel = new TargetModel();
                            ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (targetModel instanceof Postprocessable) {
                                return ((Postprocessable) targetModel).a();
                            }
                            return targetModel;
                        }
                    }

                    /* compiled from: recent_invitee_section */
                    public class Serializer extends JsonSerializer<TargetModel> {
                        public final void m5997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TargetModel targetModel = (TargetModel) obj;
                            if (targetModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(targetModel.m6002a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TargetParser.m6032a(targetModel.w_(), targetModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TargetModel.class, new Serializer());
                        }
                    }

                    public TargetModel() {
                        super(3);
                    }

                    public TargetModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(3);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final void m6006a(String str, ConsistencyTuple consistencyTuple) {
                        if ("is_sold".equals(str)) {
                            consistencyTuple.a = Boolean.valueOf(m6001l());
                            consistencyTuple.b = u_();
                            consistencyTuple.c = 2;
                            return;
                        }
                        consistencyTuple.a();
                    }

                    public final void m6007a(String str, Object obj, boolean z) {
                        if ("is_sold".equals(str)) {
                            m5998a(((Boolean) obj).booleanValue());
                        }
                    }

                    @Nullable
                    private GraphQLObjectType m5999j() {
                        if (this.b != null && this.f5407d == null) {
                            this.f5407d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f5407d;
                    }

                    @Nullable
                    private String m6000k() {
                        this.f5408e = super.a(this.f5408e, 1);
                        return this.f5408e;
                    }

                    private boolean m6001l() {
                        a(0, 2);
                        return this.f5409f;
                    }

                    private void m5998a(boolean z) {
                        this.f5409f = z;
                        if (this.b != null && this.b.d) {
                            this.b.a(this.c, 2, z);
                        }
                    }

                    @Nullable
                    public final String m6004a() {
                        return m6000k();
                    }

                    public final int jK_() {
                        return 2433570;
                    }

                    public final GraphQLVisitableModel m6003a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m6002a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m5999j());
                        int b = flatBufferBuilder.b(m6000k());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f5409f);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m6005a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f5409f = mutableFlatBuffer.a(i, 2);
                    }
                }

                public AttachmentsModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<AttachmentPropertiesModel> m6008a() {
                    this.f5410d = super.a(this.f5410d, 0, AttachmentPropertiesModel.class);
                    return (ImmutableList) this.f5410d;
                }

                @Nullable
                private TargetModel m6009j() {
                    this.f5411e = (TargetModel) super.a(this.f5411e, 1, TargetModel.class);
                    return this.f5411e;
                }

                public final int jK_() {
                    return -1267730472;
                }

                public final GraphQLVisitableModel m6011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    TargetModel targetModel;
                    h();
                    if (m6008a() != null) {
                        Builder a = ModelHelper.a(m6008a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            AttachmentsModel attachmentsModel = (AttachmentsModel) ModelHelper.a(null, this);
                            attachmentsModel.f5410d = a.b();
                            graphQLVisitableModel = attachmentsModel;
                            if (m6009j() != null) {
                                targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m6009j());
                                if (m6009j() != targetModel) {
                                    graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f5411e = targetModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m6009j() != null) {
                        targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m6009j());
                        if (m6009j() != targetModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f5411e = targetModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m6010a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6008a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6009j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: recent_invitee_section */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m6012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m6035a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyModel = new StoryModel();
                    ((BaseModel) storyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyModel instanceof Postprocessable) {
                        return ((Postprocessable) storyModel).a();
                    }
                    return storyModel;
                }
            }

            /* compiled from: recent_invitee_section */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m6013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m6015a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m6036a(storyModel.w_(), storyModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(1);
            }

            public final void m6017a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m6018a(String str, Object obj, boolean z) {
            }

            @Nonnull
            private ImmutableList<AttachmentsModel> m6014a() {
                this.f5412d = super.a(this.f5412d, 0, AttachmentsModel.class);
                return (ImmutableList) this.f5412d;
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m6016a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6014a() != null) {
                    Builder a = ModelHelper.a(m6014a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (StoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5412d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6015a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6014a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ProductItemChangeAvailabilityCoreMutationFieldsModel() {
            super(2);
        }

        @Nullable
        private GroupModel m6019a() {
            this.f5413d = (GroupModel) super.a(this.f5413d, 0, GroupModel.class);
            return this.f5413d;
        }

        @Nullable
        private StoryModel m6020j() {
            this.f5414e = (StoryModel) super.a(this.f5414e, 1, StoryModel.class);
            return this.f5414e;
        }

        public final int jK_() {
            return 40596736;
        }

        public final GraphQLVisitableModel m6022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6019a() != null) {
                GroupModel groupModel = (GroupModel) graphQLModelMutatingVisitor.b(m6019a());
                if (m6019a() != groupModel) {
                    graphQLVisitableModel = (ProductItemChangeAvailabilityCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5413d = groupModel;
                }
            }
            if (m6020j() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m6020j());
                if (m6020j() != storyModel) {
                    graphQLVisitableModel = (ProductItemChangeAvailabilityCoreMutationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5414e = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6021a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6019a());
            int a2 = ModelHelper.a(flatBufferBuilder, m6020j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
