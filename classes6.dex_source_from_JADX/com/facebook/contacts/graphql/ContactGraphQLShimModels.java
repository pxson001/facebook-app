package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser;
import com.facebook.contacts.graphql.ContactGraphQLShimParsers.AddContactParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: photoUpdate */
public class ContactGraphQLShimModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -377488603)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photoUpdate */
    public final class AddContactModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactModel f8207d;

        /* compiled from: photoUpdate */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AddContactModel.class, new Deserializer());
            }

            public Object m12020a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AddContactParser.m12025a(jsonParser);
                Object addContactModel = new AddContactModel();
                ((BaseModel) addContactModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (addContactModel instanceof Postprocessable) {
                    return ((Postprocessable) addContactModel).a();
                }
                return addContactModel;
            }
        }

        /* compiled from: photoUpdate */
        public class Serializer extends JsonSerializer<AddContactModel> {
            public final void m12021a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AddContactModel addContactModel = (AddContactModel) obj;
                if (addContactModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(addContactModel.m12022a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    addContactModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = addContactModel.w_();
                int u_ = addContactModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("contact");
                    ContactParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AddContactModel.class, new Serializer());
            }
        }

        public AddContactModel() {
            super(1);
        }

        @Nullable
        public final ContactModel m12023a() {
            this.f8207d = (ContactModel) super.a(this.f8207d, 0, ContactModel.class);
            return this.f8207d;
        }

        public final int jK_() {
            return 177855825;
        }

        public final GraphQLVisitableModel m12024a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12023a() != null) {
                ContactModel contactModel = (ContactModel) graphQLModelMutatingVisitor.b(m12023a());
                if (m12023a() != contactModel) {
                    graphQLVisitableModel = (AddContactModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8207d = contactModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12022a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12023a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
