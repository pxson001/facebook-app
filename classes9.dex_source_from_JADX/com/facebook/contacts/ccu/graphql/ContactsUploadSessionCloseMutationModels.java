package com.facebook.contacts.ccu.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.ccu.graphql.ContactsUploadSessionCloseMutationParsers.ContactUploadSessionCloseMutationFieldsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
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

/* compiled from: product_tag */
public class ContactsUploadSessionCloseMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 546226947)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: product_tag */
    public final class ContactUploadSessionCloseMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f6244d;

        /* compiled from: product_tag */
        public final class Builder {
            public boolean f6243a;

            public final ContactUploadSessionCloseMutationFieldsModel m6584a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f6243a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ContactUploadSessionCloseMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: product_tag */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactUploadSessionCloseMutationFieldsModel.class, new Deserializer());
            }

            public Object m6585a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContactUploadSessionCloseMutationFieldsParser.m6591a(jsonParser);
                Object contactUploadSessionCloseMutationFieldsModel = new ContactUploadSessionCloseMutationFieldsModel();
                ((BaseModel) contactUploadSessionCloseMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contactUploadSessionCloseMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) contactUploadSessionCloseMutationFieldsModel).a();
                }
                return contactUploadSessionCloseMutationFieldsModel;
            }
        }

        /* compiled from: product_tag */
        public class Serializer extends JsonSerializer<ContactUploadSessionCloseMutationFieldsModel> {
            public final void m6586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContactUploadSessionCloseMutationFieldsModel contactUploadSessionCloseMutationFieldsModel = (ContactUploadSessionCloseMutationFieldsModel) obj;
                if (contactUploadSessionCloseMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactUploadSessionCloseMutationFieldsModel.m6587a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactUploadSessionCloseMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contactUploadSessionCloseMutationFieldsModel.w_();
                int u_ = contactUploadSessionCloseMutationFieldsModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("in_sync");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContactUploadSessionCloseMutationFieldsModel.class, new Serializer());
            }
        }

        public ContactUploadSessionCloseMutationFieldsModel() {
            super(1);
        }

        public ContactUploadSessionCloseMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m6590a() {
            a(0, 0);
            return this.f6244d;
        }

        public final int jK_() {
            return 176449994;
        }

        public final GraphQLVisitableModel m6588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6587a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f6244d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6589a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6244d = mutableFlatBuffer.a(i, 0);
        }
    }
}
