package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLInterfaces.ContactsPageInfo;
import com.facebook.contacts.graphql.ContactGraphQLInterfaces.ContactsSyncFull;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactCoefficientParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactCoefficientParser.RepresentedProfileParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactsPageInfoParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactsSyncFullParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchAllContactsOmnistoreQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchAllContactsOmnistoreQueryParser.MessengerContactsParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactByProfileIdQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsByProfileIdsQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsCoefficientQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsDeltaQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsDeltaQueryParser.MessengerContactsParser.DeltasParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsDeltaQueryParser.MessengerContactsParser.DeltasParser.NodesParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsFullWithAfterQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchPaymentEligibleContactsQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchPaymentEligibleContactsSearchQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchTopContactsByCFPHatCoefficientQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.MessengerContactIdsQueryParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.PhoneNumberFieldsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: photo_ */
public class ContactGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1115246633)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class ContactCoefficientModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f8162d;
        @Nullable
        private RepresentedProfileModel f8163e;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactCoefficientModel.class, new Deserializer());
            }

            public Object m11766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContactCoefficientParser.m11973b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contactCoefficientModel = new ContactCoefficientModel();
                ((BaseModel) contactCoefficientModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contactCoefficientModel instanceof Postprocessable) {
                    return ((Postprocessable) contactCoefficientModel).a();
                }
                return contactCoefficientModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -192359874)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_ */
        public final class RepresentedProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8159d;
            private double f8160e;
            @Nullable
            private String f8161f;

            /* compiled from: photo_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RepresentedProfileModel.class, new Deserializer());
                }

                public Object m11767a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RepresentedProfileParser.m11971a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object representedProfileModel = new RepresentedProfileModel();
                    ((BaseModel) representedProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (representedProfileModel instanceof Postprocessable) {
                        return ((Postprocessable) representedProfileModel).a();
                    }
                    return representedProfileModel;
                }
            }

            /* compiled from: photo_ */
            public class Serializer extends JsonSerializer<RepresentedProfileModel> {
                public final void m11768a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) obj;
                    if (representedProfileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(representedProfileModel.m11770a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        representedProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RepresentedProfileParser.m11972a(representedProfileModel.w_(), representedProfileModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RepresentedProfileModel.class, new Serializer());
                }
            }

            public RepresentedProfileModel() {
                super(3);
            }

            public final void m11774a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m11775a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m11769j() {
                if (this.b != null && this.f8159d == null) {
                    this.f8159d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8159d;
            }

            public final double m11776b() {
                a(0, 1);
                return this.f8160e;
            }

            @Nullable
            public final String m11777c() {
                this.f8161f = super.a(this.f8161f, 2);
                return this.f8161f;
            }

            @Nullable
            public final String m11772a() {
                return m11777c();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m11771a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m11770a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11769j());
                int b = flatBufferBuilder.b(m11777c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f8160e, 0.0d);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11773a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8160e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<ContactCoefficientModel> {
            public final void m11778a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContactCoefficientModel contactCoefficientModel = (ContactCoefficientModel) obj;
                if (contactCoefficientModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactCoefficientModel.m11780a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactCoefficientModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContactCoefficientParser.m11974b(contactCoefficientModel.w_(), contactCoefficientModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContactCoefficientModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ RepresentedProfileModel m11784c() {
            return m11779j();
        }

        public ContactCoefficientModel() {
            super(2);
        }

        @Nullable
        public final String m11783b() {
            this.f8162d = super.a(this.f8162d, 0);
            return this.f8162d;
        }

        @Nullable
        private RepresentedProfileModel m11779j() {
            this.f8163e = (RepresentedProfileModel) super.a(this.f8163e, 1, RepresentedProfileModel.class);
            return this.f8163e;
        }

        @Nullable
        public final String m11782a() {
            return m11783b();
        }

        public final int jK_() {
            return -1678787584;
        }

        public final GraphQLVisitableModel m11781a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11779j() != null) {
                RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) graphQLModelMutatingVisitor.b(m11779j());
                if (m11779j() != representedProfileModel) {
                    graphQLVisitableModel = (ContactCoefficientModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8163e = representedProfileModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11780a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11783b());
            int a = ModelHelper.a(flatBufferBuilder, m11779j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2005169142)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class ContactsPageInfoModel extends BaseModel implements ContactsPageInfo, GraphQLVisitableModel {
        @Nullable
        private String f8175d;
        private boolean f8176e;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactsPageInfoModel.class, new Deserializer());
            }

            public Object m11823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContactsPageInfoParser.m11982a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contactsPageInfoModel = new ContactsPageInfoModel();
                ((BaseModel) contactsPageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contactsPageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) contactsPageInfoModel).a();
                }
                return contactsPageInfoModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<ContactsPageInfoModel> {
            public final void m11824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContactsPageInfoModel contactsPageInfoModel = (ContactsPageInfoModel) obj;
                if (contactsPageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactsPageInfoModel.m11825a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactsPageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContactsPageInfoParser.m11983a(contactsPageInfoModel.w_(), contactsPageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ContactsPageInfoModel.class, new Serializer());
            }
        }

        public ContactsPageInfoModel() {
            super(2);
        }

        @Nullable
        public final String m11827a() {
            this.f8175d = super.a(this.f8175d, 0);
            return this.f8175d;
        }

        public final boolean m11829b() {
            a(0, 1);
            return this.f8176e;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m11826a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11825a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11827a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f8176e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11828a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8176e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 922061108)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class ContactsSyncFullModel extends BaseModel implements ContactsSyncFull, GraphQLVisitableModel {
        @Nullable
        private List<ContactModel> f8177d;
        @Nullable
        private PageInfoModel f8178e;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactsSyncFullModel.class, new Deserializer());
            }

            public Object m11830a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContactsSyncFullParser.m11984a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contactsSyncFullModel = new ContactsSyncFullModel();
                ((BaseModel) contactsSyncFullModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contactsSyncFullModel instanceof Postprocessable) {
                    return ((Postprocessable) contactsSyncFullModel).a();
                }
                return contactsSyncFullModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<ContactsSyncFullModel> {
            public final void m11833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContactsSyncFullModel contactsSyncFullModel = (ContactsSyncFullModel) obj;
                if (contactsSyncFullModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactsSyncFullModel.m11835a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactsSyncFullModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContactsSyncFullParser.m11985a(contactsSyncFullModel.w_(), contactsSyncFullModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContactsSyncFullModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PageInfoModel m11838b() {
            return m11834j();
        }

        public ContactsSyncFullModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<ContactModel> m11837a() {
            this.f8177d = super.a(this.f8177d, 0, ContactModel.class);
            return (ImmutableList) this.f8177d;
        }

        @Nullable
        private PageInfoModel m11834j() {
            this.f8178e = (PageInfoModel) super.a(this.f8178e, 1, PageInfoModel.class);
            return this.f8178e;
        }

        public final int jK_() {
            return 893816804;
        }

        public final GraphQLVisitableModel m11836a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            PageInfoModel pageInfoModel;
            h();
            if (m11837a() != null) {
                Builder a = ModelHelper.a(m11837a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    ContactsSyncFullModel contactsSyncFullModel = (ContactsSyncFullModel) ModelHelper.a(null, this);
                    contactsSyncFullModel.f8177d = a.b();
                    graphQLVisitableModel = contactsSyncFullModel;
                    if (m11834j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m11834j());
                        if (m11834j() != pageInfoModel) {
                            graphQLVisitableModel = (ContactsSyncFullModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8178e = pageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m11834j() != null) {
                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m11834j());
                if (m11834j() != pageInfoModel) {
                    graphQLVisitableModel = (ContactsSyncFullModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8178e = pageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m11835a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11837a());
            int a2 = ModelHelper.a(flatBufferBuilder, m11834j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1152172708)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchAllContactsOmnistoreQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContactsModel f8183d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchAllContactsOmnistoreQueryModel.class, new Deserializer());
            }

            public Object m11846a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchAllContactsOmnistoreQueryParser.m11992a(jsonParser);
                Object fetchAllContactsOmnistoreQueryModel = new FetchAllContactsOmnistoreQueryModel();
                ((BaseModel) fetchAllContactsOmnistoreQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchAllContactsOmnistoreQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchAllContactsOmnistoreQueryModel).a();
                }
                return fetchAllContactsOmnistoreQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1928335505)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_ */
        public final class MessengerContactsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ContactModel> f8182d;

            /* compiled from: photo_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContactsModel.class, new Deserializer());
                }

                public Object m11847a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerContactsParser.m11990a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContactsModel = new MessengerContactsModel();
                    ((BaseModel) messengerContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContactsModel).a();
                    }
                    return messengerContactsModel;
                }
            }

            /* compiled from: photo_ */
            public class Serializer extends JsonSerializer<MessengerContactsModel> {
                public final void m11848a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContactsModel messengerContactsModel = (MessengerContactsModel) obj;
                    if (messengerContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContactsModel.m11850a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerContactsParser.m11991a(messengerContactsModel.w_(), messengerContactsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContactsModel.class, new Serializer());
                }
            }

            public MessengerContactsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<ContactModel> m11849a() {
                this.f8182d = super.a(this.f8182d, 0, ContactModel.class);
                return (ImmutableList) this.f8182d;
            }

            public final int jK_() {
                return 893816804;
            }

            public final GraphQLVisitableModel m11851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11849a() != null) {
                    Builder a = ModelHelper.a(m11849a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8182d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11850a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11849a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchAllContactsOmnistoreQueryModel> {
            public final void m11852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchAllContactsOmnistoreQueryModel fetchAllContactsOmnistoreQueryModel = (FetchAllContactsOmnistoreQueryModel) obj;
                if (fetchAllContactsOmnistoreQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchAllContactsOmnistoreQueryModel.m11854a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchAllContactsOmnistoreQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchAllContactsOmnistoreQueryModel.w_();
                int u_ = fetchAllContactsOmnistoreQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    MessengerContactsParser.m11991a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchAllContactsOmnistoreQueryModel.class, new Serializer());
            }
        }

        public FetchAllContactsOmnistoreQueryModel() {
            super(1);
        }

        @Nullable
        private MessengerContactsModel m11853a() {
            this.f8183d = (MessengerContactsModel) super.a(this.f8183d, 0, MessengerContactsModel.class);
            return this.f8183d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11855a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11853a() != null) {
                MessengerContactsModel messengerContactsModel = (MessengerContactsModel) graphQLModelMutatingVisitor.b(m11853a());
                if (m11853a() != messengerContactsModel) {
                    graphQLVisitableModel = (FetchAllContactsOmnistoreQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8183d = messengerContactsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11854a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11853a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1596380406)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchContactByProfileIdQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ContactModel f8184d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchContactByProfileIdQueryModel.class, new Deserializer());
            }

            public Object m11856a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchContactByProfileIdQueryParser.m11993a(jsonParser);
                Object fetchContactByProfileIdQueryModel = new FetchContactByProfileIdQueryModel();
                ((BaseModel) fetchContactByProfileIdQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchContactByProfileIdQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchContactByProfileIdQueryModel).a();
                }
                return fetchContactByProfileIdQueryModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchContactByProfileIdQueryModel> {
            public final void m11857a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchContactByProfileIdQueryModel fetchContactByProfileIdQueryModel = (FetchContactByProfileIdQueryModel) obj;
                if (fetchContactByProfileIdQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchContactByProfileIdQueryModel.m11859a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchContactByProfileIdQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchContactByProfileIdQueryModel.w_();
                int u_ = fetchContactByProfileIdQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contact");
                    ContactParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchContactByProfileIdQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ContactModel m11860a() {
            return m11858j();
        }

        public FetchContactByProfileIdQueryModel() {
            super(1);
        }

        public final void m11862a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11863a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ContactModel m11858j() {
            this.f8184d = (ContactModel) super.a(this.f8184d, 0, ContactModel.class);
            return this.f8184d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m11861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11858j() != null) {
                ContactModel contactModel = (ContactModel) graphQLModelMutatingVisitor.b(m11858j());
                if (m11858j() != contactModel) {
                    graphQLVisitableModel = (FetchContactByProfileIdQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8184d = contactModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11859a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11858j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 267486681)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchContactsByProfileIdsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8185d;
        @Nullable
        private ContactModel f8186e;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchContactsByProfileIdsQueryModel.class, new Deserializer());
            }

            public Object m11864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchContactsByProfileIdsQueryParser.m11994a(jsonParser);
                Object fetchContactsByProfileIdsQueryModel = new FetchContactsByProfileIdsQueryModel();
                ((BaseModel) fetchContactsByProfileIdsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchContactsByProfileIdsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchContactsByProfileIdsQueryModel).a();
                }
                return fetchContactsByProfileIdsQueryModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchContactsByProfileIdsQueryModel> {
            public final void m11865a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchContactsByProfileIdsQueryModel fetchContactsByProfileIdsQueryModel = (FetchContactsByProfileIdsQueryModel) obj;
                if (fetchContactsByProfileIdsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchContactsByProfileIdsQueryModel.m11867a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchContactsByProfileIdsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchContactsByProfileIdsQueryModel.w_();
                int u_ = fetchContactsByProfileIdsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("messenger_contact");
                    ContactParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchContactsByProfileIdsQueryModel.class, new Serializer());
            }
        }

        public FetchContactsByProfileIdsQueryModel() {
            super(2);
        }

        public final void m11870a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11871a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m11866j() {
            if (this.b != null && this.f8185d == null) {
                this.f8185d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8185d;
        }

        @Nullable
        public final ContactModel m11868a() {
            this.f8186e = (ContactModel) super.a(this.f8186e, 1, ContactModel.class);
            return this.f8186e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m11869a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11868a() != null) {
                ContactModel contactModel = (ContactModel) graphQLModelMutatingVisitor.b(m11868a());
                if (m11868a() != contactModel) {
                    graphQLVisitableModel = (FetchContactsByProfileIdsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8186e = contactModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11867a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11866j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11868a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1241756973)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchContactsCoefficientQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContactsModel f8188d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchContactsCoefficientQueryModel.class, new Deserializer());
            }

            public Object m11872a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchContactsCoefficientQueryParser.m11997a(jsonParser);
                Object fetchContactsCoefficientQueryModel = new FetchContactsCoefficientQueryModel();
                ((BaseModel) fetchContactsCoefficientQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchContactsCoefficientQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchContactsCoefficientQueryModel).a();
                }
                return fetchContactsCoefficientQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1424509667)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_ */
        public final class MessengerContactsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ContactCoefficientModel> f8187d;

            /* compiled from: photo_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContactsModel.class, new Deserializer());
                }

                public Object m11873a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchContactsCoefficientQueryParser.MessengerContactsParser.m11995a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContactsModel = new MessengerContactsModel();
                    ((BaseModel) messengerContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContactsModel).a();
                    }
                    return messengerContactsModel;
                }
            }

            /* compiled from: photo_ */
            public class Serializer extends JsonSerializer<MessengerContactsModel> {
                public final void m11874a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContactsModel messengerContactsModel = (MessengerContactsModel) obj;
                    if (messengerContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContactsModel.m11875a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchContactsCoefficientQueryParser.MessengerContactsParser.m11996a(messengerContactsModel.w_(), messengerContactsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContactsModel.class, new Serializer());
                }
            }

            public MessengerContactsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ContactCoefficientModel> m11877a() {
                this.f8187d = super.a(this.f8187d, 0, ContactCoefficientModel.class);
                return (ImmutableList) this.f8187d;
            }

            public final int jK_() {
                return 893816804;
            }

            public final GraphQLVisitableModel m11876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11877a() != null) {
                    Builder a = ModelHelper.a(m11877a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8187d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11875a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11877a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchContactsCoefficientQueryModel> {
            public final void m11878a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchContactsCoefficientQueryModel fetchContactsCoefficientQueryModel = (FetchContactsCoefficientQueryModel) obj;
                if (fetchContactsCoefficientQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchContactsCoefficientQueryModel.m11879a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchContactsCoefficientQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchContactsCoefficientQueryModel.w_();
                int u_ = fetchContactsCoefficientQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    FetchContactsCoefficientQueryParser.MessengerContactsParser.m11996a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchContactsCoefficientQueryModel.class, new Serializer());
            }
        }

        public FetchContactsCoefficientQueryModel() {
            super(1);
        }

        @Nullable
        public final MessengerContactsModel m11880a() {
            this.f8188d = (MessengerContactsModel) super.a(this.f8188d, 0, MessengerContactsModel.class);
            return this.f8188d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11881a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11880a() != null) {
                MessengerContactsModel messengerContactsModel = (MessengerContactsModel) graphQLModelMutatingVisitor.b(m11880a());
                if (m11880a() != messengerContactsModel) {
                    graphQLVisitableModel = (FetchContactsCoefficientQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8188d = messengerContactsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11879a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11880a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1510785334)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchContactsDeltaQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContactsModel f8194d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchContactsDeltaQueryModel.class, new Deserializer());
            }

            public Object m11882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchContactsDeltaQueryParser.m12004a(jsonParser);
                Object fetchContactsDeltaQueryModel = new FetchContactsDeltaQueryModel();
                ((BaseModel) fetchContactsDeltaQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchContactsDeltaQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchContactsDeltaQueryModel).a();
                }
                return fetchContactsDeltaQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 857434921)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_ */
        public final class MessengerContactsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DeltasModel f8193d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1621546348)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_ */
            public final class DeltasModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f8191d;
                @Nullable
                private ContactsPageInfoModel f8192e;

                /* compiled from: photo_ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(DeltasModel.class, new Deserializer());
                    }

                    public Object m11883a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(DeltasParser.m12000a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 1105772471)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: photo_ */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ContactModel f8189d;
                    @Nullable
                    private String f8190e;

                    /* compiled from: photo_ */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m11884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m11998b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: photo_ */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m11885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m11887a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m11999b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ContactModel m11888a() {
                        return m11886j();
                    }

                    public NodesModel() {
                        super(2);
                    }

                    @Nullable
                    private ContactModel m11886j() {
                        this.f8189d = (ContactModel) super.a(this.f8189d, 0, ContactModel.class);
                        return this.f8189d;
                    }

                    @Nullable
                    public final String m11890b() {
                        this.f8190e = super.a(this.f8190e, 1);
                        return this.f8190e;
                    }

                    public final int jK_() {
                        return 1757257458;
                    }

                    public final GraphQLVisitableModel m11889a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m11886j() != null) {
                            ContactModel contactModel = (ContactModel) graphQLModelMutatingVisitor.b(m11886j());
                            if (m11886j() != contactModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8189d = contactModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m11887a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m11886j());
                        int b = flatBufferBuilder.b(m11890b());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: photo_ */
                public class Serializer extends JsonSerializer<DeltasModel> {
                    public final void m11891a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        DeltasModel deltasModel = (DeltasModel) obj;
                        if (deltasModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(deltasModel.m11893a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            deltasModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        DeltasParser.m12001a(deltasModel.w_(), deltasModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(DeltasModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ContactsPageInfo m11896b() {
                    return m11892j();
                }

                public DeltasModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m11895a() {
                    this.f8191d = super.a(this.f8191d, 0, NodesModel.class);
                    return (ImmutableList) this.f8191d;
                }

                @Nullable
                private ContactsPageInfoModel m11892j() {
                    this.f8192e = (ContactsPageInfoModel) super.a(this.f8192e, 1, ContactsPageInfoModel.class);
                    return this.f8192e;
                }

                public final int jK_() {
                    return -1885899920;
                }

                public final GraphQLVisitableModel m11894a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    ContactsPageInfoModel contactsPageInfoModel;
                    h();
                    if (m11895a() != null) {
                        Builder a = ModelHelper.a(m11895a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            DeltasModel deltasModel = (DeltasModel) ModelHelper.a(null, this);
                            deltasModel.f8191d = a.b();
                            graphQLVisitableModel = deltasModel;
                            if (m11892j() != null) {
                                contactsPageInfoModel = (ContactsPageInfoModel) graphQLModelMutatingVisitor.b(m11892j());
                                if (m11892j() != contactsPageInfoModel) {
                                    graphQLVisitableModel = (DeltasModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f8192e = contactsPageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m11892j() != null) {
                        contactsPageInfoModel = (ContactsPageInfoModel) graphQLModelMutatingVisitor.b(m11892j());
                        if (m11892j() != contactsPageInfoModel) {
                            graphQLVisitableModel = (DeltasModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8192e = contactsPageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m11893a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11895a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m11892j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContactsModel.class, new Deserializer());
                }

                public Object m11897a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchContactsDeltaQueryParser.MessengerContactsParser.m12002a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContactsModel = new MessengerContactsModel();
                    ((BaseModel) messengerContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContactsModel).a();
                    }
                    return messengerContactsModel;
                }
            }

            /* compiled from: photo_ */
            public class Serializer extends JsonSerializer<MessengerContactsModel> {
                public final void m11898a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContactsModel messengerContactsModel = (MessengerContactsModel) obj;
                    if (messengerContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContactsModel.m11900a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchContactsDeltaQueryParser.MessengerContactsParser.m12003a(messengerContactsModel.w_(), messengerContactsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContactsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DeltasModel m11901a() {
                return m11899j();
            }

            public MessengerContactsModel() {
                super(1);
            }

            @Nullable
            private DeltasModel m11899j() {
                this.f8193d = (DeltasModel) super.a(this.f8193d, 0, DeltasModel.class);
                return this.f8193d;
            }

            public final int jK_() {
                return 893816804;
            }

            public final GraphQLVisitableModel m11902a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11899j() != null) {
                    DeltasModel deltasModel = (DeltasModel) graphQLModelMutatingVisitor.b(m11899j());
                    if (m11899j() != deltasModel) {
                        graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8193d = deltasModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11900a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11899j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchContactsDeltaQueryModel> {
            public final void m11903a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchContactsDeltaQueryModel fetchContactsDeltaQueryModel = (FetchContactsDeltaQueryModel) obj;
                if (fetchContactsDeltaQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchContactsDeltaQueryModel.m11905a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchContactsDeltaQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchContactsDeltaQueryModel.w_();
                int u_ = fetchContactsDeltaQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    FetchContactsDeltaQueryParser.MessengerContactsParser.m12003a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchContactsDeltaQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MessengerContactsModel m11906a() {
            return m11904j();
        }

        public FetchContactsDeltaQueryModel() {
            super(1);
        }

        @Nullable
        private MessengerContactsModel m11904j() {
            this.f8194d = (MessengerContactsModel) super.a(this.f8194d, 0, MessengerContactsModel.class);
            return this.f8194d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11907a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11904j() != null) {
                MessengerContactsModel messengerContactsModel = (MessengerContactsModel) graphQLModelMutatingVisitor.b(m11904j());
                if (m11904j() != messengerContactsModel) {
                    graphQLVisitableModel = (FetchContactsDeltaQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8194d = messengerContactsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11905a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11904j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 872803364)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchContactsFullWithAfterQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactsSyncFullModel f8195d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchContactsFullWithAfterQueryModel.class, new Deserializer());
            }

            public Object m11911a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchContactsFullWithAfterQueryParser.m12005a(jsonParser);
                Object fetchContactsFullWithAfterQueryModel = new FetchContactsFullWithAfterQueryModel();
                ((BaseModel) fetchContactsFullWithAfterQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchContactsFullWithAfterQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchContactsFullWithAfterQueryModel).a();
                }
                return fetchContactsFullWithAfterQueryModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchContactsFullWithAfterQueryModel> {
            public final void m11912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchContactsFullWithAfterQueryModel fetchContactsFullWithAfterQueryModel = (FetchContactsFullWithAfterQueryModel) obj;
                if (fetchContactsFullWithAfterQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchContactsFullWithAfterQueryModel.m11914a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchContactsFullWithAfterQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchContactsFullWithAfterQueryModel.w_();
                int u_ = fetchContactsFullWithAfterQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    ContactsSyncFullParser.m11985a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchContactsFullWithAfterQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ContactsSyncFull m11915a() {
            return m11913j();
        }

        public FetchContactsFullWithAfterQueryModel() {
            super(1);
        }

        @Nullable
        private ContactsSyncFullModel m11913j() {
            this.f8195d = (ContactsSyncFullModel) super.a(this.f8195d, 0, ContactsSyncFullModel.class);
            return this.f8195d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11916a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11913j() != null) {
                ContactsSyncFullModel contactsSyncFullModel = (ContactsSyncFullModel) graphQLModelMutatingVisitor.b(m11913j());
                if (m11913j() != contactsSyncFullModel) {
                    graphQLVisitableModel = (FetchContactsFullWithAfterQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8195d = contactsSyncFullModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11914a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11913j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 872803364)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchPaymentEligibleContactsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactsSyncFullModel f8196d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPaymentEligibleContactsQueryModel.class, new Deserializer());
            }

            public Object m11917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPaymentEligibleContactsQueryParser.m12006a(jsonParser);
                Object fetchPaymentEligibleContactsQueryModel = new FetchPaymentEligibleContactsQueryModel();
                ((BaseModel) fetchPaymentEligibleContactsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPaymentEligibleContactsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPaymentEligibleContactsQueryModel).a();
                }
                return fetchPaymentEligibleContactsQueryModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchPaymentEligibleContactsQueryModel> {
            public final void m11918a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPaymentEligibleContactsQueryModel fetchPaymentEligibleContactsQueryModel = (FetchPaymentEligibleContactsQueryModel) obj;
                if (fetchPaymentEligibleContactsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPaymentEligibleContactsQueryModel.m11920a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPaymentEligibleContactsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPaymentEligibleContactsQueryModel.w_();
                int u_ = fetchPaymentEligibleContactsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    ContactsSyncFullParser.m11985a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPaymentEligibleContactsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ContactsSyncFull m11921a() {
            return m11919j();
        }

        public FetchPaymentEligibleContactsQueryModel() {
            super(1);
        }

        @Nullable
        private ContactsSyncFullModel m11919j() {
            this.f8196d = (ContactsSyncFullModel) super.a(this.f8196d, 0, ContactsSyncFullModel.class);
            return this.f8196d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11919j() != null) {
                ContactsSyncFullModel contactsSyncFullModel = (ContactsSyncFullModel) graphQLModelMutatingVisitor.b(m11919j());
                if (m11919j() != contactsSyncFullModel) {
                    graphQLVisitableModel = (FetchPaymentEligibleContactsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8196d = contactsSyncFullModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11920a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11919j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 872803364)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchPaymentEligibleContactsSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactsSyncFullModel f8197d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPaymentEligibleContactsSearchQueryModel.class, new Deserializer());
            }

            public Object m11923a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPaymentEligibleContactsSearchQueryParser.m12007a(jsonParser);
                Object fetchPaymentEligibleContactsSearchQueryModel = new FetchPaymentEligibleContactsSearchQueryModel();
                ((BaseModel) fetchPaymentEligibleContactsSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPaymentEligibleContactsSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPaymentEligibleContactsSearchQueryModel).a();
                }
                return fetchPaymentEligibleContactsSearchQueryModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchPaymentEligibleContactsSearchQueryModel> {
            public final void m11924a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPaymentEligibleContactsSearchQueryModel fetchPaymentEligibleContactsSearchQueryModel = (FetchPaymentEligibleContactsSearchQueryModel) obj;
                if (fetchPaymentEligibleContactsSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPaymentEligibleContactsSearchQueryModel.m11926a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPaymentEligibleContactsSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPaymentEligibleContactsSearchQueryModel.w_();
                int u_ = fetchPaymentEligibleContactsSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    ContactsSyncFullParser.m11985a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPaymentEligibleContactsSearchQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ContactsSyncFull m11927a() {
            return m11925j();
        }

        public FetchPaymentEligibleContactsSearchQueryModel() {
            super(1);
        }

        @Nullable
        private ContactsSyncFullModel m11925j() {
            this.f8197d = (ContactsSyncFullModel) super.a(this.f8197d, 0, ContactsSyncFullModel.class);
            return this.f8197d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11928a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11925j() != null) {
                ContactsSyncFullModel contactsSyncFullModel = (ContactsSyncFullModel) graphQLModelMutatingVisitor.b(m11925j());
                if (m11925j() != contactsSyncFullModel) {
                    graphQLVisitableModel = (FetchPaymentEligibleContactsSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8197d = contactsSyncFullModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11926a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11925j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1008107095)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class FetchTopContactsByCFPHatCoefficientQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContactsModel f8199d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTopContactsByCFPHatCoefficientQueryModel.class, new Deserializer());
            }

            public Object m11929a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTopContactsByCFPHatCoefficientQueryParser.m12010a(jsonParser);
                Object fetchTopContactsByCFPHatCoefficientQueryModel = new FetchTopContactsByCFPHatCoefficientQueryModel();
                ((BaseModel) fetchTopContactsByCFPHatCoefficientQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTopContactsByCFPHatCoefficientQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTopContactsByCFPHatCoefficientQueryModel).a();
                }
                return fetchTopContactsByCFPHatCoefficientQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1928335505)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_ */
        public final class MessengerContactsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ContactModel> f8198d;

            /* compiled from: photo_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContactsModel.class, new Deserializer());
                }

                public Object m11930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchTopContactsByCFPHatCoefficientQueryParser.MessengerContactsParser.m12008a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContactsModel = new MessengerContactsModel();
                    ((BaseModel) messengerContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContactsModel).a();
                    }
                    return messengerContactsModel;
                }
            }

            /* compiled from: photo_ */
            public class Serializer extends JsonSerializer<MessengerContactsModel> {
                public final void m11931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContactsModel messengerContactsModel = (MessengerContactsModel) obj;
                    if (messengerContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContactsModel.m11932a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchTopContactsByCFPHatCoefficientQueryParser.MessengerContactsParser.m12009a(messengerContactsModel.w_(), messengerContactsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContactsModel.class, new Serializer());
                }
            }

            public MessengerContactsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ContactModel> m11934a() {
                this.f8198d = super.a(this.f8198d, 0, ContactModel.class);
                return (ImmutableList) this.f8198d;
            }

            public final int jK_() {
                return 893816804;
            }

            public final GraphQLVisitableModel m11933a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11934a() != null) {
                    Builder a = ModelHelper.a(m11934a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8198d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11932a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11934a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<FetchTopContactsByCFPHatCoefficientQueryModel> {
            public final void m11935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTopContactsByCFPHatCoefficientQueryModel fetchTopContactsByCFPHatCoefficientQueryModel = (FetchTopContactsByCFPHatCoefficientQueryModel) obj;
                if (fetchTopContactsByCFPHatCoefficientQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTopContactsByCFPHatCoefficientQueryModel.m11936a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTopContactsByCFPHatCoefficientQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTopContactsByCFPHatCoefficientQueryModel.w_();
                int u_ = fetchTopContactsByCFPHatCoefficientQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    FetchTopContactsByCFPHatCoefficientQueryParser.MessengerContactsParser.m12009a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTopContactsByCFPHatCoefficientQueryModel.class, new Serializer());
            }
        }

        public FetchTopContactsByCFPHatCoefficientQueryModel() {
            super(1);
        }

        @Nullable
        public final MessengerContactsModel m11937a() {
            this.f8199d = (MessengerContactsModel) super.a(this.f8199d, 0, MessengerContactsModel.class);
            return this.f8199d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11937a() != null) {
                MessengerContactsModel messengerContactsModel = (MessengerContactsModel) graphQLModelMutatingVisitor.b(m11937a());
                if (m11937a() != messengerContactsModel) {
                    graphQLVisitableModel = (FetchTopContactsByCFPHatCoefficientQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8199d = messengerContactsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11936a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11937a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1806943538)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class MessengerContactIdsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerContactsModel f8204d;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerContactIdsQueryModel.class, new Deserializer());
            }

            public Object m11939a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerContactIdsQueryParser.m12017a(jsonParser);
                Object messengerContactIdsQueryModel = new MessengerContactIdsQueryModel();
                ((BaseModel) messengerContactIdsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerContactIdsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerContactIdsQueryModel).a();
                }
                return messengerContactIdsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 282026425)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_ */
        public final class MessengerContactsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f8203d;

            /* compiled from: photo_ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerContactsModel.class, new Deserializer());
                }

                public Object m11940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerContactIdsQueryParser.MessengerContactsParser.m12015a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerContactsModel = new MessengerContactsModel();
                    ((BaseModel) messengerContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerContactsModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerContactsModel).a();
                    }
                    return messengerContactsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 760601628)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_ */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private RepresentedProfileModel f8202d;

                /* compiled from: photo_ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m11941a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MessengerContactIdsQueryParser.MessengerContactsParser.NodesParser.m12013b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1787905591)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: photo_ */
                public final class RepresentedProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f8200d;
                    @Nullable
                    private String f8201e;

                    /* compiled from: photo_ */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(RepresentedProfileModel.class, new Deserializer());
                        }

                        public Object m11942a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MessengerContactIdsQueryParser.MessengerContactsParser.NodesParser.RepresentedProfileParser.m12011a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object representedProfileModel = new RepresentedProfileModel();
                            ((BaseModel) representedProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (representedProfileModel instanceof Postprocessable) {
                                return ((Postprocessable) representedProfileModel).a();
                            }
                            return representedProfileModel;
                        }
                    }

                    /* compiled from: photo_ */
                    public class Serializer extends JsonSerializer<RepresentedProfileModel> {
                        public final void m11943a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) obj;
                            if (representedProfileModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(representedProfileModel.m11946a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                representedProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MessengerContactIdsQueryParser.MessengerContactsParser.NodesParser.RepresentedProfileParser.m12012a(representedProfileModel.w_(), representedProfileModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(RepresentedProfileModel.class, new Serializer());
                        }
                    }

                    public RepresentedProfileModel() {
                        super(2);
                    }

                    public final void m11949a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m11950a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m11944j() {
                        if (this.b != null && this.f8200d == null) {
                            this.f8200d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8200d;
                    }

                    @Nullable
                    private String m11945k() {
                        this.f8201e = super.a(this.f8201e, 1);
                        return this.f8201e;
                    }

                    @Nullable
                    public final String m11948a() {
                        return m11945k();
                    }

                    public final int jK_() {
                        return 63093205;
                    }

                    public final GraphQLVisitableModel m11947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m11946a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m11944j());
                        int b = flatBufferBuilder.b(m11945k());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: photo_ */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m11951a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m11953a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MessengerContactIdsQueryParser.MessengerContactsParser.NodesParser.m12014b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                private RepresentedProfileModel m11952a() {
                    this.f8202d = (RepresentedProfileModel) super.a(this.f8202d, 0, RepresentedProfileModel.class);
                    return this.f8202d;
                }

                public final int jK_() {
                    return -1678787584;
                }

                public final GraphQLVisitableModel m11954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m11952a() != null) {
                        RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) graphQLModelMutatingVisitor.b(m11952a());
                        if (m11952a() != representedProfileModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8202d = representedProfileModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m11953a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m11952a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_ */
            public class Serializer extends JsonSerializer<MessengerContactsModel> {
                public final void m11955a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerContactsModel messengerContactsModel = (MessengerContactsModel) obj;
                    if (messengerContactsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerContactsModel.m11956a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerContactIdsQueryParser.MessengerContactsParser.m12016a(messengerContactsModel.w_(), messengerContactsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerContactsModel.class, new Serializer());
                }
            }

            public MessengerContactsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m11958a() {
                this.f8203d = super.a(this.f8203d, 0, NodesModel.class);
                return (ImmutableList) this.f8203d;
            }

            public final int jK_() {
                return 893816804;
            }

            public final GraphQLVisitableModel m11957a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11958a() != null) {
                    Builder a = ModelHelper.a(m11958a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8203d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11956a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11958a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<MessengerContactIdsQueryModel> {
            public final void m11959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerContactIdsQueryModel messengerContactIdsQueryModel = (MessengerContactIdsQueryModel) obj;
                if (messengerContactIdsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerContactIdsQueryModel.m11960a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerContactIdsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerContactIdsQueryModel.w_();
                int u_ = messengerContactIdsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_contacts");
                    MessengerContactIdsQueryParser.MessengerContactsParser.m12016a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerContactIdsQueryModel.class, new Serializer());
            }
        }

        public MessengerContactIdsQueryModel() {
            super(1);
        }

        @Nullable
        public final MessengerContactsModel m11961a() {
            this.f8204d = (MessengerContactsModel) super.a(this.f8204d, 0, MessengerContactsModel.class);
            return this.f8204d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11962a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11961a() != null) {
                MessengerContactsModel messengerContactsModel = (MessengerContactsModel) graphQLModelMutatingVisitor.b(m11961a());
                if (m11961a() != messengerContactsModel) {
                    graphQLVisitableModel = (MessengerContactIdsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8204d = messengerContactsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11960a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11961a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 44074500)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class PhoneNumberFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8205d;
        @Nullable
        private String f8206e;

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhoneNumberFieldsModel.class, new Deserializer());
            }

            public Object m11963a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhoneNumberFieldsParser.m12018a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object phoneNumberFieldsModel = new PhoneNumberFieldsModel();
                ((BaseModel) phoneNumberFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (phoneNumberFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) phoneNumberFieldsModel).a();
                }
                return phoneNumberFieldsModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<PhoneNumberFieldsModel> {
            public final void m11964a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhoneNumberFieldsModel phoneNumberFieldsModel = (PhoneNumberFieldsModel) obj;
                if (phoneNumberFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(phoneNumberFieldsModel.m11965a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    phoneNumberFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhoneNumberFieldsParser.m12019a(phoneNumberFieldsModel.w_(), phoneNumberFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PhoneNumberFieldsModel.class, new Serializer());
            }
        }

        public PhoneNumberFieldsModel() {
            super(2);
        }

        @Nullable
        public final String m11967a() {
            this.f8205d = super.a(this.f8205d, 0);
            return this.f8205d;
        }

        @Nullable
        public final String m11968b() {
            this.f8206e = super.a(this.f8206e, 1);
            return this.f8206e;
        }

        public final int jK_() {
            return 474898999;
        }

        public final GraphQLVisitableModel m11966a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11965a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11967a());
            int b2 = flatBufferBuilder.b(m11968b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
