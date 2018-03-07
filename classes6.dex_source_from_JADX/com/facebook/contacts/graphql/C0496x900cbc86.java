package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.PhoneNumberFieldsModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers$ContactParser$ImportedPhoneEntriesParser.PrimaryFieldParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
@ModelWithFlatBufferFormatHash(a = 1730108921)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: photo_ */
public final class C0496x900cbc86 extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    @Nullable
    private GraphQLObjectType f8164d;
    @Nullable
    private String f8165e;
    @Nullable
    private String f8166f;
    @Nullable
    private PhoneNumberFieldsModel f8167g;

    /* compiled from: photo_ */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0496x900cbc86.class, new Deserializer());
        }

        public Object m11787a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PrimaryFieldParser.m11975a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0496x900cbc86 = new C0496x900cbc86();
            ((BaseModel) c0496x900cbc86).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0496x900cbc86 instanceof Postprocessable) {
                return ((Postprocessable) c0496x900cbc86).a();
            }
            return c0496x900cbc86;
        }
    }

    /* compiled from: photo_ */
    public class Serializer extends JsonSerializer<C0496x900cbc86> {
        public final void m11788a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0496x900cbc86 c0496x900cbc86 = (C0496x900cbc86) obj;
            if (c0496x900cbc86.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0496x900cbc86.m11791a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0496x900cbc86.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PrimaryFieldParser.m11976a(c0496x900cbc86.w_(), c0496x900cbc86.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0496x900cbc86.class, new Serializer());
        }
    }

    @Nullable
    public final /* synthetic */ PhoneNumberFieldsModel m11796d() {
        return m11790k();
    }

    public C0496x900cbc86() {
        super(4);
    }

    @Nullable
    private GraphQLObjectType m11789j() {
        if (this.b != null && this.f8164d == null) {
            this.f8164d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f8164d;
    }

    @Nullable
    public final String m11794b() {
        this.f8165e = super.a(this.f8165e, 1);
        return this.f8165e;
    }

    @Nullable
    public final String m11795c() {
        this.f8166f = super.a(this.f8166f, 2);
        return this.f8166f;
    }

    @Nullable
    private PhoneNumberFieldsModel m11790k() {
        this.f8167g = (PhoneNumberFieldsModel) super.a(this.f8167g, 3, PhoneNumberFieldsModel.class);
        return this.f8167g;
    }

    @Nullable
    public final String m11793a() {
        return m11794b();
    }

    public final int jK_() {
        return 1418818778;
    }

    public final GraphQLVisitableModel m11792a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m11790k() != null) {
            PhoneNumberFieldsModel phoneNumberFieldsModel = (PhoneNumberFieldsModel) graphQLModelMutatingVisitor.b(m11790k());
            if (m11790k() != phoneNumberFieldsModel) {
                graphQLVisitableModel = (C0496x900cbc86) ModelHelper.a(null, this);
                graphQLVisitableModel.f8167g = phoneNumberFieldsModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m11791a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m11789j());
        int b = flatBufferBuilder.b(m11794b());
        int b2 = flatBufferBuilder.b(m11795c());
        int a2 = ModelHelper.a(flatBufferBuilder, m11790k());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        i();
        return flatBufferBuilder.d();
    }
}
