package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLParsers.CoverPhotoParser.PhotoParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1902465914)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: photo_ */
public final class ContactGraphQLModels$CoverPhotoModel$PhotoModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private DefaultImageFieldsModel f8181d;

    /* compiled from: photo_ */
    public final class Builder {
        @Nullable
        public DefaultImageFieldsModel f8180a;
    }

    /* compiled from: photo_ */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(ContactGraphQLModels$CoverPhotoModel$PhotoModel.class, new Deserializer());
        }

        public Object m11840a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PhotoParser.m11986a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object contactGraphQLModels$CoverPhotoModel$PhotoModel = new ContactGraphQLModels$CoverPhotoModel$PhotoModel();
            ((BaseModel) contactGraphQLModels$CoverPhotoModel$PhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (contactGraphQLModels$CoverPhotoModel$PhotoModel instanceof Postprocessable) {
                return ((Postprocessable) contactGraphQLModels$CoverPhotoModel$PhotoModel).a();
            }
            return contactGraphQLModels$CoverPhotoModel$PhotoModel;
        }
    }

    /* compiled from: photo_ */
    public class Serializer extends JsonSerializer<ContactGraphQLModels$CoverPhotoModel$PhotoModel> {
        public final void m11841a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            ContactGraphQLModels$CoverPhotoModel$PhotoModel contactGraphQLModels$CoverPhotoModel$PhotoModel = (ContactGraphQLModels$CoverPhotoModel$PhotoModel) obj;
            if (contactGraphQLModels$CoverPhotoModel$PhotoModel.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(contactGraphQLModels$CoverPhotoModel$PhotoModel.m11842a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                contactGraphQLModels$CoverPhotoModel$PhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PhotoParser.m11987a(contactGraphQLModels$CoverPhotoModel$PhotoModel.w_(), contactGraphQLModels$CoverPhotoModel$PhotoModel.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(ContactGraphQLModels$CoverPhotoModel$PhotoModel.class, new Serializer());
        }
    }

    public ContactGraphQLModels$CoverPhotoModel$PhotoModel() {
        super(1);
    }

    public ContactGraphQLModels$CoverPhotoModel$PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final DefaultImageFieldsModel m11843a() {
        this.f8181d = (DefaultImageFieldsModel) super.a(this.f8181d, 0, DefaultImageFieldsModel.class);
        return this.f8181d;
    }

    public final int jK_() {
        return 77090322;
    }

    public final GraphQLVisitableModel m11844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m11843a() != null) {
            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m11843a());
            if (m11843a() != defaultImageFieldsModel) {
                graphQLVisitableModel = (ContactGraphQLModels$CoverPhotoModel$PhotoModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f8181d = defaultImageFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m11842a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m11843a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
