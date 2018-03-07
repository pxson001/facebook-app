package com.facebook.messaging.inbox2.graphql;

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
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsParsers.MessengerInbox2UnitActionMutationParser;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsParsers.MessengerInbox2UnitActionMutationParser.MessengerInboxUnitParser;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsParsers.MessengerInboxItemActionMutationParser;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsParsers.MessengerInboxItemActionMutationParser.MessengerInboxItemParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: mSelectedShippingOption */
public class InboxV2MutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -246600582)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mSelectedShippingOption */
    public final class MessengerInbox2UnitActionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerInboxUnitModel f11136d;

        /* compiled from: mSelectedShippingOption */
        public final class Builder {
            @Nullable
            public MessengerInboxUnitModel f11131a;
        }

        /* compiled from: mSelectedShippingOption */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerInbox2UnitActionMutationModel.class, new Deserializer());
            }

            public Object m11502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerInbox2UnitActionMutationParser.m11540a(jsonParser);
                Object messengerInbox2UnitActionMutationModel = new MessengerInbox2UnitActionMutationModel();
                ((BaseModel) messengerInbox2UnitActionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerInbox2UnitActionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerInbox2UnitActionMutationModel).a();
                }
                return messengerInbox2UnitActionMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -674946873)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mSelectedShippingOption */
        public final class MessengerInboxUnitModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11134d;
            private int f11135e;

            /* compiled from: mSelectedShippingOption */
            public final class Builder {
                @Nullable
                public String f11132a;
                public int f11133b;
            }

            /* compiled from: mSelectedShippingOption */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerInboxUnitModel.class, new Deserializer());
                }

                public Object m11503a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerInboxUnitParser.m11538a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerInboxUnitModel = new MessengerInboxUnitModel();
                    ((BaseModel) messengerInboxUnitModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerInboxUnitModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerInboxUnitModel).a();
                    }
                    return messengerInboxUnitModel;
                }
            }

            /* compiled from: mSelectedShippingOption */
            public class Serializer extends JsonSerializer<MessengerInboxUnitModel> {
                public final void m11504a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerInboxUnitModel messengerInboxUnitModel = (MessengerInboxUnitModel) obj;
                    if (messengerInboxUnitModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerInboxUnitModel.m11508a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerInboxUnitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerInboxUnitParser.m11539a(messengerInboxUnitModel.w_(), messengerInboxUnitModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerInboxUnitModel.class, new Serializer());
                }
            }

            public MessengerInboxUnitModel() {
                super(2);
            }

            public MessengerInboxUnitModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m11512a(String str, ConsistencyTuple consistencyTuple) {
                if ("messenger_inbox_unit_hides_remaining".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m11507k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m11513a(String str, Object obj, boolean z) {
                if ("messenger_inbox_unit_hides_remaining".equals(str)) {
                    m11505a(((Integer) obj).intValue());
                }
            }

            @Nullable
            private String m11506j() {
                this.f11134d = super.a(this.f11134d, 0);
                return this.f11134d;
            }

            private int m11507k() {
                a(0, 1);
                return this.f11135e;
            }

            private void m11505a(int i) {
                this.f11135e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            @Nullable
            public final String m11510a() {
                return m11506j();
            }

            public final int jK_() {
                return -876108937;
            }

            public final GraphQLVisitableModel m11509a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11508a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11506j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f11135e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11511a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11135e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: mSelectedShippingOption */
        public class Serializer extends JsonSerializer<MessengerInbox2UnitActionMutationModel> {
            public final void m11514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerInbox2UnitActionMutationModel messengerInbox2UnitActionMutationModel = (MessengerInbox2UnitActionMutationModel) obj;
                if (messengerInbox2UnitActionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerInbox2UnitActionMutationModel.m11516a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerInbox2UnitActionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerInbox2UnitActionMutationModel.w_();
                int u_ = messengerInbox2UnitActionMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_inbox_unit");
                    MessengerInboxUnitParser.m11539a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerInbox2UnitActionMutationModel.class, new Serializer());
            }
        }

        public MessengerInbox2UnitActionMutationModel() {
            super(1);
        }

        public MessengerInbox2UnitActionMutationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private MessengerInboxUnitModel m11515a() {
            this.f11136d = (MessengerInboxUnitModel) super.a(this.f11136d, 0, MessengerInboxUnitModel.class);
            return this.f11136d;
        }

        public final int jK_() {
            return 1608569647;
        }

        public final GraphQLVisitableModel m11517a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11515a() != null) {
                MessengerInboxUnitModel messengerInboxUnitModel = (MessengerInboxUnitModel) graphQLModelMutatingVisitor.b(m11515a());
                if (m11515a() != messengerInboxUnitModel) {
                    graphQLVisitableModel = (MessengerInbox2UnitActionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11136d = messengerInboxUnitModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11516a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11515a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1014218272)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mSelectedShippingOption */
    public final class MessengerInboxItemActionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerInboxItemModel f11146d;

        /* compiled from: mSelectedShippingOption */
        public final class Builder {
            @Nullable
            public MessengerInboxItemModel f11137a;
        }

        /* compiled from: mSelectedShippingOption */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerInboxItemActionMutationModel.class, new Deserializer());
            }

            public Object m11518a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerInboxItemActionMutationParser.m11543a(jsonParser);
                Object messengerInboxItemActionMutationModel = new MessengerInboxItemActionMutationModel();
                ((BaseModel) messengerInboxItemActionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerInboxItemActionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerInboxItemActionMutationModel).a();
                }
                return messengerInboxItemActionMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 319847742)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mSelectedShippingOption */
        public final class MessengerInboxItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11142d;
            private int f11143e;
            private int f11144f;
            private int f11145g;

            /* compiled from: mSelectedShippingOption */
            public final class Builder {
                @Nullable
                public String f11138a;
                public int f11139b;
                public int f11140c;
                public int f11141d;
            }

            /* compiled from: mSelectedShippingOption */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerInboxItemModel.class, new Deserializer());
                }

                public Object m11519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerInboxItemParser.m11541a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerInboxItemModel = new MessengerInboxItemModel();
                    ((BaseModel) messengerInboxItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerInboxItemModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerInboxItemModel).a();
                    }
                    return messengerInboxItemModel;
                }
            }

            /* compiled from: mSelectedShippingOption */
            public class Serializer extends JsonSerializer<MessengerInboxItemModel> {
                public final void m11520a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerInboxItemModel messengerInboxItemModel = (MessengerInboxItemModel) obj;
                    if (messengerInboxItemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerInboxItemModel.m11528a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerInboxItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerInboxItemParser.m11542a(messengerInboxItemModel.w_(), messengerInboxItemModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerInboxItemModel.class, new Serializer());
                }
            }

            public MessengerInboxItemModel() {
                super(4);
            }

            public MessengerInboxItemModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m11532a(String str, ConsistencyTuple consistencyTuple) {
                if ("messenger_inbox_item_clicks_remaining".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m11525k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("messenger_inbox_item_hides_remaining".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m11526l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("messenger_inbox_item_impressions_remaining".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m11527m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m11533a(String str, Object obj, boolean z) {
                if ("messenger_inbox_item_clicks_remaining".equals(str)) {
                    m11521a(((Integer) obj).intValue());
                } else if ("messenger_inbox_item_hides_remaining".equals(str)) {
                    m11522b(((Integer) obj).intValue());
                } else if ("messenger_inbox_item_impressions_remaining".equals(str)) {
                    m11523c(((Integer) obj).intValue());
                }
            }

            @Nullable
            private String m11524j() {
                this.f11142d = super.a(this.f11142d, 0);
                return this.f11142d;
            }

            private int m11525k() {
                a(0, 1);
                return this.f11143e;
            }

            private void m11521a(int i) {
                this.f11143e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            private int m11526l() {
                a(0, 2);
                return this.f11144f;
            }

            private void m11522b(int i) {
                this.f11144f = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 2, i);
                }
            }

            private int m11527m() {
                a(0, 3);
                return this.f11145g;
            }

            private void m11523c(int i) {
                this.f11145g = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 3, i);
                }
            }

            @Nullable
            public final String m11530a() {
                return m11524j();
            }

            public final int jK_() {
                return -876460794;
            }

            public final GraphQLVisitableModel m11529a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11528a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m11524j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f11143e, 0);
                flatBufferBuilder.a(2, this.f11144f, 0);
                flatBufferBuilder.a(3, this.f11145g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11531a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11143e = mutableFlatBuffer.a(i, 1, 0);
                this.f11144f = mutableFlatBuffer.a(i, 2, 0);
                this.f11145g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: mSelectedShippingOption */
        public class Serializer extends JsonSerializer<MessengerInboxItemActionMutationModel> {
            public final void m11534a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerInboxItemActionMutationModel messengerInboxItemActionMutationModel = (MessengerInboxItemActionMutationModel) obj;
                if (messengerInboxItemActionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerInboxItemActionMutationModel.m11536a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerInboxItemActionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerInboxItemActionMutationModel.w_();
                int u_ = messengerInboxItemActionMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_inbox_item");
                    MessengerInboxItemParser.m11542a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerInboxItemActionMutationModel.class, new Serializer());
            }
        }

        public MessengerInboxItemActionMutationModel() {
            super(1);
        }

        public MessengerInboxItemActionMutationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private MessengerInboxItemModel m11535a() {
            this.f11146d = (MessengerInboxItemModel) super.a(this.f11146d, 0, MessengerInboxItemModel.class);
            return this.f11146d;
        }

        public final int jK_() {
            return 772583488;
        }

        public final GraphQLVisitableModel m11537a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11535a() != null) {
                MessengerInboxItemModel messengerInboxItemModel = (MessengerInboxItemModel) graphQLModelMutatingVisitor.b(m11535a());
                if (m11535a() != messengerInboxItemModel) {
                    graphQLVisitableModel = (MessengerInboxItemActionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11146d = messengerInboxItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11536a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11535a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
