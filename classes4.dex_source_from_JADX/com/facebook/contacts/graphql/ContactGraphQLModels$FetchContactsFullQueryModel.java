package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 265686632)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: requires_approval */
public final class ContactGraphQLModels$FetchContactsFullQueryModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private MessengerContactsModel f3430d;

    /* compiled from: requires_approval */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(ContactGraphQLModels$FetchContactsFullQueryModel.class, new Deserializer());
        }

        public Object m3975a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = ContactGraphQLParsers$FetchContactsFullQueryParser.m3976a(jsonParser);
            Object contactGraphQLModels$FetchContactsFullQueryModel = new ContactGraphQLModels$FetchContactsFullQueryModel();
            ((BaseModel) contactGraphQLModels$FetchContactsFullQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
            if (contactGraphQLModels$FetchContactsFullQueryModel instanceof Postprocessable) {
                return ((Postprocessable) contactGraphQLModels$FetchContactsFullQueryModel).a();
            }
            return contactGraphQLModels$FetchContactsFullQueryModel;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1080001334)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requires_approval */
    public final class MessengerContactsModel extends BaseModel implements ContactGraphQLInterfaces$ContactsSyncFull, GraphQLVisitableModel {
        @Nullable
        private List<ContactGraphQLModels$ContactModel> f3593d;
        @Nullable
        private ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel f3594e;
        @Nullable
        private String f3595f;

        @Nullable
        public final /* synthetic */ ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel mo290b() {
            return m4002j();
        }

        public MessengerContactsModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<ContactGraphQLModels$ContactModel> mo289a() {
            this.f3593d = super.a(this.f3593d, 0, ContactGraphQLModels$ContactModel.class);
            return (ImmutableList) this.f3593d;
        }

        @Nullable
        private ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel m4002j() {
            this.f3594e = (ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel) super.a(this.f3594e, 1, ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel.class);
            return this.f3594e;
        }

        @Nullable
        public final String m4007c() {
            this.f3595f = super.a(this.f3595f, 2);
            return this.f3595f;
        }

        public final int jK_() {
            return 893816804;
        }

        public final GraphQLVisitableModel m4004a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel contactGraphQLModels$ContactsSyncFullModel$PageInfoModel;
            h();
            if (mo289a() != null) {
                Builder a = ModelHelper.a(mo289a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MessengerContactsModel messengerContactsModel = (MessengerContactsModel) ModelHelper.a(null, this);
                    messengerContactsModel.f3593d = a.b();
                    graphQLVisitableModel = messengerContactsModel;
                    if (m4002j() != null) {
                        contactGraphQLModels$ContactsSyncFullModel$PageInfoModel = (ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel) graphQLModelMutatingVisitor.b(m4002j());
                        if (m4002j() != contactGraphQLModels$ContactsSyncFullModel$PageInfoModel) {
                            graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3594e = contactGraphQLModels$ContactsSyncFullModel$PageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m4002j() != null) {
                contactGraphQLModels$ContactsSyncFullModel$PageInfoModel = (ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel) graphQLModelMutatingVisitor.b(m4002j());
                if (m4002j() != contactGraphQLModels$ContactsSyncFullModel$PageInfoModel) {
                    graphQLVisitableModel = (MessengerContactsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3594e = contactGraphQLModels$ContactsSyncFullModel$PageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m4003a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo289a());
            int a2 = ModelHelper.a(flatBufferBuilder, m4002j());
            int b = flatBufferBuilder.b(m4007c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @Nullable
    public final /* synthetic */ MessengerContactsModel m3649a() {
        return m3647j();
    }

    public ContactGraphQLModels$FetchContactsFullQueryModel() {
        super(1);
    }

    @Nullable
    private MessengerContactsModel m3647j() {
        this.f3430d = (MessengerContactsModel) super.a(this.f3430d, 0, MessengerContactsModel.class);
        return this.f3430d;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m3650a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3647j() != null) {
            MessengerContactsModel messengerContactsModel = (MessengerContactsModel) graphQLModelMutatingVisitor.b(m3647j());
            if (m3647j() != messengerContactsModel) {
                graphQLVisitableModel = (ContactGraphQLModels$FetchContactsFullQueryModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3430d = messengerContactsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3648a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3647j());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
