package com.facebook.messaging.conversationstarters.graphql;

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
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields.ItemImage;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryParsers.ConversationStartersFieldsParser;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryParsers.ConversationStartersFieldsParser.ItemDescriptionIconParser;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryParsers.ConversationStartersFieldsParser.ItemDescriptionParser;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryParsers.ConversationStartersFieldsParser.ItemImageParser;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryParsers.ConversationStartersFieldsParser.ItemUserParser;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryParsers.ConversationStartersFieldsParser.McsItemTitleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: member_profile_size */
public class ConversationStartersQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1003274252)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: member_profile_size */
    public final class ConversationStartersFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, ConversationStartersFields {
        private int f10224d;
        @Nullable
        private String f10225e;
        @Nullable
        private String f10226f;
        @Nullable
        private ItemDescriptionModel f10227g;
        @Nullable
        private ItemDescriptionIconModel f10228h;
        @Nullable
        private ItemImageModel f10229i;
        @Nullable
        private String f10230j;
        @Nullable
        private ItemUserModel f10231k;
        @Nullable
        private McsItemTitleModel f10232l;
        private boolean f10233m;

        /* compiled from: member_profile_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConversationStartersFieldsModel.class, new Deserializer());
            }

            public Object m10785a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConversationStartersFieldsParser.m10847a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object conversationStartersFieldsModel = new ConversationStartersFieldsModel();
                ((BaseModel) conversationStartersFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (conversationStartersFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) conversationStartersFieldsModel).a();
                }
                return conversationStartersFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: member_profile_size */
        public final class ItemDescriptionIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10217d;

            /* compiled from: member_profile_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemDescriptionIconModel.class, new Deserializer());
                }

                public Object m10786a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemDescriptionIconParser.m10837a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemDescriptionIconModel = new ItemDescriptionIconModel();
                    ((BaseModel) itemDescriptionIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemDescriptionIconModel instanceof Postprocessable) {
                        return ((Postprocessable) itemDescriptionIconModel).a();
                    }
                    return itemDescriptionIconModel;
                }
            }

            /* compiled from: member_profile_size */
            public class Serializer extends JsonSerializer<ItemDescriptionIconModel> {
                public final void m10787a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemDescriptionIconModel itemDescriptionIconModel = (ItemDescriptionIconModel) obj;
                    if (itemDescriptionIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemDescriptionIconModel.m10788a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemDescriptionIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemDescriptionIconParser.m10838a(itemDescriptionIconModel.w_(), itemDescriptionIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemDescriptionIconModel.class, new Serializer());
                }
            }

            public ItemDescriptionIconModel() {
                super(1);
            }

            @Nullable
            public final String m10790a() {
                this.f10217d = super.a(this.f10217d, 0);
                return this.f10217d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m10789a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10788a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10790a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: member_profile_size */
        public final class ItemDescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10218d;

            /* compiled from: member_profile_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemDescriptionModel.class, new Deserializer());
                }

                public Object m10791a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemDescriptionParser.m10839a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemDescriptionModel = new ItemDescriptionModel();
                    ((BaseModel) itemDescriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemDescriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) itemDescriptionModel).a();
                    }
                    return itemDescriptionModel;
                }
            }

            /* compiled from: member_profile_size */
            public class Serializer extends JsonSerializer<ItemDescriptionModel> {
                public final void m10792a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemDescriptionModel itemDescriptionModel = (ItemDescriptionModel) obj;
                    if (itemDescriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemDescriptionModel.m10793a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemDescriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemDescriptionParser.m10840a(itemDescriptionModel.w_(), itemDescriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemDescriptionModel.class, new Serializer());
                }
            }

            public ItemDescriptionModel() {
                super(1);
            }

            @Nullable
            public final String m10795a() {
                this.f10218d = super.a(this.f10218d, 0);
                return this.f10218d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10794a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10793a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10795a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: member_profile_size */
        public final class ItemImageModel extends BaseModel implements GraphQLVisitableModel, ItemImage {
            @Nullable
            private String f10219d;

            /* compiled from: member_profile_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemImageModel.class, new Deserializer());
                }

                public Object m10796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemImageParser.m10841a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemImageModel = new ItemImageModel();
                    ((BaseModel) itemImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemImageModel instanceof Postprocessable) {
                        return ((Postprocessable) itemImageModel).a();
                    }
                    return itemImageModel;
                }
            }

            /* compiled from: member_profile_size */
            public class Serializer extends JsonSerializer<ItemImageModel> {
                public final void m10797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemImageModel itemImageModel = (ItemImageModel) obj;
                    if (itemImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemImageModel.m10798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemImageParser.m10842a(itemImageModel.w_(), itemImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemImageModel.class, new Serializer());
                }
            }

            public ItemImageModel() {
                super(1);
            }

            @Nullable
            public final String mo415a() {
                this.f10219d = super.a(this.f10219d, 0);
                return this.f10219d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m10799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo415a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1448579406)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: member_profile_size */
        public final class ItemUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10220d;
            private boolean f10221e;
            private boolean f10222f;

            /* compiled from: member_profile_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemUserModel.class, new Deserializer());
                }

                public Object m10801a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemUserParser.m10843a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemUserModel = new ItemUserModel();
                    ((BaseModel) itemUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemUserModel instanceof Postprocessable) {
                        return ((Postprocessable) itemUserModel).a();
                    }
                    return itemUserModel;
                }
            }

            /* compiled from: member_profile_size */
            public class Serializer extends JsonSerializer<ItemUserModel> {
                public final void m10802a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemUserModel itemUserModel = (ItemUserModel) obj;
                    if (itemUserModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemUserModel.m10803a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemUserParser.m10844a(itemUserModel.w_(), itemUserModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemUserModel.class, new Serializer());
                }
            }

            public ItemUserModel() {
                super(3);
            }

            public final void m10807a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10808a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m10809b() {
                this.f10220d = super.a(this.f10220d, 0);
                return this.f10220d;
            }

            public final boolean m10810c() {
                a(0, 1);
                return this.f10221e;
            }

            public final boolean m10811d() {
                a(0, 2);
                return this.f10222f;
            }

            @Nullable
            public final String m10805a() {
                return m10809b();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m10804a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10803a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10809b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f10221e);
                flatBufferBuilder.a(2, this.f10222f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10806a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10221e = mutableFlatBuffer.a(i, 1);
                this.f10222f = mutableFlatBuffer.a(i, 2);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: member_profile_size */
        public final class McsItemTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10223d;

            /* compiled from: member_profile_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(McsItemTitleModel.class, new Deserializer());
                }

                public Object m10812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(McsItemTitleParser.m10845a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mcsItemTitleModel = new McsItemTitleModel();
                    ((BaseModel) mcsItemTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mcsItemTitleModel instanceof Postprocessable) {
                        return ((Postprocessable) mcsItemTitleModel).a();
                    }
                    return mcsItemTitleModel;
                }
            }

            /* compiled from: member_profile_size */
            public class Serializer extends JsonSerializer<McsItemTitleModel> {
                public final void m10813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    McsItemTitleModel mcsItemTitleModel = (McsItemTitleModel) obj;
                    if (mcsItemTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mcsItemTitleModel.m10814a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mcsItemTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    McsItemTitleParser.m10846a(mcsItemTitleModel.w_(), mcsItemTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(McsItemTitleModel.class, new Serializer());
                }
            }

            public McsItemTitleModel() {
                super(1);
            }

            @Nullable
            public final String m10816a() {
                this.f10223d = super.a(this.f10223d, 0);
                return this.f10223d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10814a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10816a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: member_profile_size */
        public class Serializer extends JsonSerializer<ConversationStartersFieldsModel> {
            public final void m10817a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ConversationStartersFieldsModel conversationStartersFieldsModel = (ConversationStartersFieldsModel) obj;
                if (conversationStartersFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(conversationStartersFieldsModel.m10827a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    conversationStartersFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = conversationStartersFieldsModel.w_();
                int u_ = conversationStartersFieldsModel.u_();
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("actions_remaining");
                    jsonGenerator.b(a);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("call_to_action_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                a = mutableFlatBuffer.g(u_, 3);
                if (a != 0) {
                    jsonGenerator.a("item_description");
                    ItemDescriptionParser.m10840a(mutableFlatBuffer, a, jsonGenerator);
                }
                a = mutableFlatBuffer.g(u_, 4);
                if (a != 0) {
                    jsonGenerator.a("item_description_icon");
                    ItemDescriptionIconParser.m10838a(mutableFlatBuffer, a, jsonGenerator);
                }
                a = mutableFlatBuffer.g(u_, 5);
                if (a != 0) {
                    jsonGenerator.a("item_image");
                    ItemImageParser.m10842a(mutableFlatBuffer, a, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("item_logging_data");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
                }
                a = mutableFlatBuffer.g(u_, 7);
                if (a != 0) {
                    jsonGenerator.a("item_user");
                    ItemUserParser.m10844a(mutableFlatBuffer, a, jsonGenerator);
                }
                a = mutableFlatBuffer.g(u_, 8);
                if (a != 0) {
                    jsonGenerator.a("mcs_item_title");
                    McsItemTitleParser.m10846a(mutableFlatBuffer, a, jsonGenerator);
                }
                boolean a2 = mutableFlatBuffer.a(u_, 9);
                if (a2) {
                    jsonGenerator.a("show_presence");
                    jsonGenerator.a(a2);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ConversationStartersFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ItemDescriptionModel mo417c() {
            return m10821l();
        }

        @Nullable
        public final /* synthetic */ ItemDescriptionIconModel mo418d() {
            return m10822m();
        }

        @Nullable
        public final /* synthetic */ ItemUserModel mo419g() {
            return m10825p();
        }

        @Nullable
        public final /* synthetic */ McsItemTitleModel lK_() {
            return m10826q();
        }

        @Nullable
        public final /* synthetic */ ItemImage lL_() {
            return m10823n();
        }

        public ConversationStartersFieldsModel() {
            super(10);
        }

        public final void m10831a(String str, ConsistencyTuple consistencyTuple) {
            if ("actions_remaining".equals(str)) {
                consistencyTuple.a = Integer.valueOf(m10819j());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m10832a(String str, Object obj, boolean z) {
            if ("actions_remaining".equals(str)) {
                m10818a(((Integer) obj).intValue());
            }
        }

        private int m10819j() {
            a(0, 0);
            return this.f10224d;
        }

        private void m10818a(int i) {
            this.f10224d = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 0, i);
            }
        }

        @Nullable
        public final String mo416b() {
            this.f10225e = super.a(this.f10225e, 1);
            return this.f10225e;
        }

        @Nullable
        private String m10820k() {
            this.f10226f = super.a(this.f10226f, 2);
            return this.f10226f;
        }

        @Nullable
        private ItemDescriptionModel m10821l() {
            this.f10227g = (ItemDescriptionModel) super.a(this.f10227g, 3, ItemDescriptionModel.class);
            return this.f10227g;
        }

        @Nullable
        private ItemDescriptionIconModel m10822m() {
            this.f10228h = (ItemDescriptionIconModel) super.a(this.f10228h, 4, ItemDescriptionIconModel.class);
            return this.f10228h;
        }

        @Nullable
        private ItemImageModel m10823n() {
            this.f10229i = (ItemImageModel) super.a(this.f10229i, 5, ItemImageModel.class);
            return this.f10229i;
        }

        @Nullable
        private String m10824o() {
            this.f10230j = super.a(this.f10230j, 6);
            return this.f10230j;
        }

        @Nullable
        private ItemUserModel m10825p() {
            this.f10231k = (ItemUserModel) super.a(this.f10231k, 7, ItemUserModel.class);
            return this.f10231k;
        }

        @Nullable
        private McsItemTitleModel m10826q() {
            this.f10232l = (McsItemTitleModel) super.a(this.f10232l, 8, McsItemTitleModel.class);
            return this.f10232l;
        }

        public final boolean lJ_() {
            a(1, 1);
            return this.f10233m;
        }

        @Nullable
        public final String m10829a() {
            return m10820k();
        }

        public final int jK_() {
            return 1251514188;
        }

        public final GraphQLVisitableModel m10828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10821l() != null) {
                ItemDescriptionModel itemDescriptionModel = (ItemDescriptionModel) graphQLModelMutatingVisitor.b(m10821l());
                if (m10821l() != itemDescriptionModel) {
                    graphQLVisitableModel = (ConversationStartersFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10227g = itemDescriptionModel;
                }
            }
            if (m10822m() != null) {
                ItemDescriptionIconModel itemDescriptionIconModel = (ItemDescriptionIconModel) graphQLModelMutatingVisitor.b(m10822m());
                if (m10822m() != itemDescriptionIconModel) {
                    graphQLVisitableModel = (ConversationStartersFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10228h = itemDescriptionIconModel;
                }
            }
            if (m10823n() != null) {
                ItemImageModel itemImageModel = (ItemImageModel) graphQLModelMutatingVisitor.b(m10823n());
                if (m10823n() != itemImageModel) {
                    graphQLVisitableModel = (ConversationStartersFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10229i = itemImageModel;
                }
            }
            if (m10825p() != null) {
                ItemUserModel itemUserModel = (ItemUserModel) graphQLModelMutatingVisitor.b(m10825p());
                if (m10825p() != itemUserModel) {
                    graphQLVisitableModel = (ConversationStartersFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10231k = itemUserModel;
                }
            }
            if (m10826q() != null) {
                McsItemTitleModel mcsItemTitleModel = (McsItemTitleModel) graphQLModelMutatingVisitor.b(m10826q());
                if (m10826q() != mcsItemTitleModel) {
                    graphQLVisitableModel = (ConversationStartersFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10232l = mcsItemTitleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10827a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo416b());
            int b2 = flatBufferBuilder.b(m10820k());
            int a = ModelHelper.a(flatBufferBuilder, m10821l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10822m());
            int a3 = ModelHelper.a(flatBufferBuilder, m10823n());
            int b3 = flatBufferBuilder.b(m10824o());
            int a4 = ModelHelper.a(flatBufferBuilder, m10825p());
            int a5 = ModelHelper.a(flatBufferBuilder, m10826q());
            flatBufferBuilder.c(10);
            flatBufferBuilder.a(0, this.f10224d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.a(9, this.f10233m);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10830a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10224d = mutableFlatBuffer.a(i, 0, 0);
            this.f10233m = mutableFlatBuffer.a(i, 9);
        }
    }
}
