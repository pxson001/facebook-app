package com.facebook.messaging.contactsyoumayknow.graphql;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryParsers.ContactYouMayKnowInfoParser;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryParsers.ContactsYouMayKnowQueryParser;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryParsers.ContactsYouMayKnowQueryParser.MessengerContactsYouMayKnowParser;
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

/* compiled from: switchToDialtone */
public class ContactsYouMayKnowQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 984074165)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: switchToDialtone */
    public final class ContactYouMayKnowInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f2170d;
        private boolean f2171e;
        private int f2172f;
        @Nullable
        private DefaultImageFieldsModel f2173g;
        @Nullable
        private DefaultNameFieldsModel f2174h;

        /* compiled from: switchToDialtone */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactYouMayKnowInfoModel.class, new Deserializer());
            }

            public Object m1978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContactYouMayKnowInfoParser.m2001b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contactYouMayKnowInfoModel = new ContactYouMayKnowInfoModel();
                ((BaseModel) contactYouMayKnowInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contactYouMayKnowInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) contactYouMayKnowInfoModel).a();
                }
                return contactYouMayKnowInfoModel;
            }
        }

        /* compiled from: switchToDialtone */
        public class Serializer extends JsonSerializer<ContactYouMayKnowInfoModel> {
            public final void m1979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContactYouMayKnowInfoModel contactYouMayKnowInfoModel = (ContactYouMayKnowInfoModel) obj;
                if (contactYouMayKnowInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactYouMayKnowInfoModel.m1980a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactYouMayKnowInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContactYouMayKnowInfoParser.m2002b(contactYouMayKnowInfoModel.w_(), contactYouMayKnowInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContactYouMayKnowInfoModel.class, new Serializer());
            }
        }

        public ContactYouMayKnowInfoModel() {
            super(5);
        }

        public final void m1984a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1985a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m1986j() {
            this.f2170d = super.a(this.f2170d, 0);
            return this.f2170d;
        }

        public final boolean m1987k() {
            a(0, 1);
            return this.f2171e;
        }

        public final int m1988l() {
            a(0, 2);
            return this.f2172f;
        }

        @Nullable
        public final DefaultImageFieldsModel m1989m() {
            this.f2173g = (DefaultImageFieldsModel) super.a(this.f2173g, 3, DefaultImageFieldsModel.class);
            return this.f2173g;
        }

        @Nullable
        public final DefaultNameFieldsModel m1990n() {
            this.f2174h = (DefaultNameFieldsModel) super.a(this.f2174h, 4, DefaultNameFieldsModel.class);
            return this.f2174h;
        }

        @Nullable
        public final String m1982a() {
            return m1986j();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m1981a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1989m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m1989m());
                if (m1989m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ContactYouMayKnowInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2173g = defaultImageFieldsModel;
                }
            }
            if (m1990n() != null) {
                DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m1990n());
                if (m1990n() != defaultNameFieldsModel) {
                    graphQLVisitableModel = (ContactYouMayKnowInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2174h = defaultNameFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1980a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1986j());
            int a = ModelHelper.a(flatBufferBuilder, m1989m());
            int a2 = ModelHelper.a(flatBufferBuilder, m1990n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f2171e);
            flatBufferBuilder.a(2, this.f2172f, 0);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1983a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2171e = mutableFlatBuffer.a(i, 1);
            this.f2172f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1587170453)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: switchToDialtone */
    public final class ContactsYouMayKnowQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContactsYouMayKnowModel f2176d;

        /* compiled from: switchToDialtone */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactsYouMayKnowQueryModel.class, new Deserializer());
            }

            public Object m1991a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContactsYouMayKnowQueryParser.m2005a(jsonParser);
                Object contactsYouMayKnowQueryModel = new ContactsYouMayKnowQueryModel();
                ((BaseModel) contactsYouMayKnowQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contactsYouMayKnowQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) contactsYouMayKnowQueryModel).a();
                }
                return contactsYouMayKnowQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 963934207)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: switchToDialtone */
        public final class MessengerContactsYouMayKnowModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ContactYouMayKnowInfoModel> f2175d;

            /* compiled from: switchToDialtone */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContactsYouMayKnowModel.class, new Deserializer());
                }

                public Object m1992a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerContactsYouMayKnowParser.m2003a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContactsYouMayKnowModel = new MessengerContactsYouMayKnowModel();
                    ((BaseModel) messengerContactsYouMayKnowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContactsYouMayKnowModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContactsYouMayKnowModel).a();
                    }
                    return messengerContactsYouMayKnowModel;
                }
            }

            /* compiled from: switchToDialtone */
            public class Serializer extends JsonSerializer<MessengerContactsYouMayKnowModel> {
                public final void m1993a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContactsYouMayKnowModel messengerContactsYouMayKnowModel = (MessengerContactsYouMayKnowModel) obj;
                    if (messengerContactsYouMayKnowModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContactsYouMayKnowModel.m1994a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContactsYouMayKnowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerContactsYouMayKnowParser.m2004a(messengerContactsYouMayKnowModel.w_(), messengerContactsYouMayKnowModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContactsYouMayKnowModel.class, new Serializer());
                }
            }

            public MessengerContactsYouMayKnowModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ContactYouMayKnowInfoModel> m1996a() {
                this.f2175d = super.a(this.f2175d, 0, ContactYouMayKnowInfoModel.class);
                return (ImmutableList) this.f2175d;
            }

            public final int jK_() {
                return 1183654837;
            }

            public final GraphQLVisitableModel m1995a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1996a() != null) {
                    Builder a = ModelHelper.a(m1996a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerContactsYouMayKnowModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2175d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1994a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1996a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: switchToDialtone */
        public class Serializer extends JsonSerializer<ContactsYouMayKnowQueryModel> {
            public final void m1997a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContactsYouMayKnowQueryModel contactsYouMayKnowQueryModel = (ContactsYouMayKnowQueryModel) obj;
                if (contactsYouMayKnowQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactsYouMayKnowQueryModel.m1998a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactsYouMayKnowQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contactsYouMayKnowQueryModel.w_();
                int u_ = contactsYouMayKnowQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts_you_may_know");
                    MessengerContactsYouMayKnowParser.m2004a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContactsYouMayKnowQueryModel.class, new Serializer());
            }
        }

        public ContactsYouMayKnowQueryModel() {
            super(1);
        }

        @Nullable
        public final MessengerContactsYouMayKnowModel m2000a() {
            this.f2176d = (MessengerContactsYouMayKnowModel) super.a(this.f2176d, 0, MessengerContactsYouMayKnowModel.class);
            return this.f2176d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1999a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2000a() != null) {
                MessengerContactsYouMayKnowModel messengerContactsYouMayKnowModel = (MessengerContactsYouMayKnowModel) graphQLModelMutatingVisitor.b(m2000a());
                if (m2000a() != messengerContactsYouMayKnowModel) {
                    graphQLVisitableModel = (ContactsYouMayKnowQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2176d = messengerContactsYouMayKnowModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1998a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2000a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
