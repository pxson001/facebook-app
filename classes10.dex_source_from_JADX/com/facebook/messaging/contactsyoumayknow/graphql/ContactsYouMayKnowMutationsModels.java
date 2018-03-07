package com.facebook.messaging.contactsyoumayknow.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser;
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
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsParsers.AddCYMKSuggestionParser;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsParsers.BatchAddCYMKSuggestionParser;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsParsers.HideCYMKSuggestionParser;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowMutationsParsers.HideCYMKSuggestionParser.SuggestionParser;
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

/* compiled from: switch_messenger_account_button */
public class ContactsYouMayKnowMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -377488603)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: switch_messenger_account_button */
    public final class AddCYMKSuggestionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactModel f2165d;

        /* compiled from: switch_messenger_account_button */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AddCYMKSuggestionModel.class, new Deserializer());
            }

            public Object m1948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AddCYMKSuggestionParser.m1972a(jsonParser);
                Object addCYMKSuggestionModel = new AddCYMKSuggestionModel();
                ((BaseModel) addCYMKSuggestionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (addCYMKSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) addCYMKSuggestionModel).a();
                }
                return addCYMKSuggestionModel;
            }
        }

        /* compiled from: switch_messenger_account_button */
        public class Serializer extends JsonSerializer<AddCYMKSuggestionModel> {
            public final void m1949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AddCYMKSuggestionModel addCYMKSuggestionModel = (AddCYMKSuggestionModel) obj;
                if (addCYMKSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(addCYMKSuggestionModel.m1950a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    addCYMKSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = addCYMKSuggestionModel.w_();
                int u_ = addCYMKSuggestionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("contact");
                    ContactParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AddCYMKSuggestionModel.class, new Serializer());
            }
        }

        public AddCYMKSuggestionModel() {
            super(1);
        }

        @Nullable
        public final ContactModel m1951a() {
            this.f2165d = (ContactModel) super.a(this.f2165d, 0, ContactModel.class);
            return this.f2165d;
        }

        public final int jK_() {
            return 1969598580;
        }

        public final GraphQLVisitableModel m1952a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1951a() != null) {
                ContactModel contactModel = (ContactModel) graphQLModelMutatingVisitor.b(m1951a());
                if (m1951a() != contactModel) {
                    graphQLVisitableModel = (AddCYMKSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2165d = contactModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1950a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1951a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1631073352)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: switch_messenger_account_button */
    public final class BatchAddCYMKSuggestionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ContactModel> f2166d;

        /* compiled from: switch_messenger_account_button */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BatchAddCYMKSuggestionModel.class, new Deserializer());
            }

            public Object m1953a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BatchAddCYMKSuggestionParser.m1973a(jsonParser);
                Object batchAddCYMKSuggestionModel = new BatchAddCYMKSuggestionModel();
                ((BaseModel) batchAddCYMKSuggestionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (batchAddCYMKSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) batchAddCYMKSuggestionModel).a();
                }
                return batchAddCYMKSuggestionModel;
            }
        }

        /* compiled from: switch_messenger_account_button */
        public class Serializer extends JsonSerializer<BatchAddCYMKSuggestionModel> {
            public final void m1954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BatchAddCYMKSuggestionModel batchAddCYMKSuggestionModel = (BatchAddCYMKSuggestionModel) obj;
                if (batchAddCYMKSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(batchAddCYMKSuggestionModel.m1956a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    batchAddCYMKSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = batchAddCYMKSuggestionModel.w_();
                int u_ = batchAddCYMKSuggestionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("contacts");
                    ContactParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BatchAddCYMKSuggestionModel.class, new Serializer());
            }
        }

        public BatchAddCYMKSuggestionModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<ContactModel> m1955a() {
            this.f2166d = super.a(this.f2166d, 0, ContactModel.class);
            return (ImmutableList) this.f2166d;
        }

        public final int jK_() {
            return 1063045450;
        }

        public final GraphQLVisitableModel m1957a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1955a() != null) {
                Builder a = ModelHelper.a(m1955a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BatchAddCYMKSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2166d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1956a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1955a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1697285127)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: switch_messenger_account_button */
    public final class HideCYMKSuggestionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestionModel f2169d;

        /* compiled from: switch_messenger_account_button */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HideCYMKSuggestionModel.class, new Deserializer());
            }

            public Object m1958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = HideCYMKSuggestionParser.m1976a(jsonParser);
                Object hideCYMKSuggestionModel = new HideCYMKSuggestionModel();
                ((BaseModel) hideCYMKSuggestionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (hideCYMKSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) hideCYMKSuggestionModel).a();
                }
                return hideCYMKSuggestionModel;
            }
        }

        /* compiled from: switch_messenger_account_button */
        public class Serializer extends JsonSerializer<HideCYMKSuggestionModel> {
            public final void m1959a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                HideCYMKSuggestionModel hideCYMKSuggestionModel = (HideCYMKSuggestionModel) obj;
                if (hideCYMKSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(hideCYMKSuggestionModel.m1970a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    hideCYMKSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = hideCYMKSuggestionModel.w_();
                int u_ = hideCYMKSuggestionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggestion");
                    SuggestionParser.m1975a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(HideCYMKSuggestionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -90820978)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: switch_messenger_account_button */
        public final class SuggestionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f2167d;
            private boolean f2168e;

            /* compiled from: switch_messenger_account_button */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestionModel.class, new Deserializer());
                }

                public Object m1960a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestionParser.m1974a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestionModel = new SuggestionModel();
                    ((BaseModel) suggestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestionModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestionModel).a();
                    }
                    return suggestionModel;
                }
            }

            /* compiled from: switch_messenger_account_button */
            public class Serializer extends JsonSerializer<SuggestionModel> {
                public final void m1961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestionModel suggestionModel = (SuggestionModel) obj;
                    if (suggestionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestionModel.m1963a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestionParser.m1975a(suggestionModel.w_(), suggestionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestionModel.class, new Serializer());
                }
            }

            public SuggestionModel() {
                super(2);
            }

            public final void m1967a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1968a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1962j() {
                this.f2167d = super.a(this.f2167d, 0);
                return this.f2167d;
            }

            @Nullable
            public final String m1965a() {
                return m1962j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m1964a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1963a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1962j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f2168e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1966a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2168e = mutableFlatBuffer.a(i, 1);
            }
        }

        public HideCYMKSuggestionModel() {
            super(1);
        }

        @Nullable
        private SuggestionModel m1969a() {
            this.f2169d = (SuggestionModel) super.a(this.f2169d, 0, SuggestionModel.class);
            return this.f2169d;
        }

        public final int jK_() {
            return 569651936;
        }

        public final GraphQLVisitableModel m1971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1969a() != null) {
                SuggestionModel suggestionModel = (SuggestionModel) graphQLModelMutatingVisitor.b(m1969a());
                if (m1969a() != suggestionModel) {
                    graphQLVisitableModel = (HideCYMKSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2169d = suggestionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1970a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1969a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
