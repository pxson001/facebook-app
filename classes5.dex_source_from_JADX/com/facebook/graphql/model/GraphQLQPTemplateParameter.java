package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQPTemplateParameterDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VISIBLE */
public final class GraphQLQPTemplateParameter extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQPTemplateParameter> CREATOR = new C11871();
    @Nullable
    public GraphQLObjectType f12820d;
    @Nullable
    public String f12821e;
    public boolean f12822f;
    @Nullable
    public String f12823g;

    /* compiled from: VISIBLE */
    final class C11871 implements Creator<GraphQLQPTemplateParameter> {
        C11871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQPTemplateParameter(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQPTemplateParameter[i];
        }
    }

    /* compiled from: VISIBLE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQPTemplateParameter.class, new Deserializer());
        }

        public Object m21127a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQPTemplateParameterDeserializer.m5729a(jsonParser, (short) 366);
            Object graphQLQPTemplateParameter = new GraphQLQPTemplateParameter();
            ((BaseModel) graphQLQPTemplateParameter).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQPTemplateParameter instanceof Postprocessable) {
                return ((Postprocessable) graphQLQPTemplateParameter).a();
            }
            return graphQLQPTemplateParameter;
        }
    }

    /* compiled from: VISIBLE */
    public final class Serializer extends JsonSerializer<GraphQLQPTemplateParameter> {
        public final void m21128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) obj;
            GraphQLQPTemplateParameterDeserializer.m5730a(graphQLQPTemplateParameter.w_(), graphQLQPTemplateParameter.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLQPTemplateParameter.class, new Serializer());
            FbSerializerProvider.a(GraphQLQPTemplateParameter.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m21130a() {
        if (this.b != null && this.f12820d == null) {
            this.f12820d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f12820d == null || this.f12820d.g() != 0) {
            return this.f12820d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m21133j() {
        this.f12821e = super.a(this.f12821e, 1);
        return this.f12821e;
    }

    @FieldOffset
    public final boolean m21134k() {
        a(0, 2);
        return this.f12822f;
    }

    @FieldOffset
    @Nullable
    public final String m21135l() {
        this.f12823g = super.a(this.f12823g, 3);
        return this.f12823g;
    }

    public final int jK_() {
        return 1482639344;
    }

    public final GraphQLVisitableModel m21131a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLQPTemplateParameter() {
        super(5);
    }

    public final void m21132a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12822f = mutableFlatBuffer.a(i, 2);
    }

    public final int m21129a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m21130a() != null ? m21130a().e() : null);
        int b = flatBufferBuilder.b(m21133j());
        int b2 = flatBufferBuilder.b(m21135l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, m21134k());
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQPTemplateParameter(Parcel parcel) {
        boolean z = true;
        super(5);
        this.f12821e = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12822f = z;
        this.f12823g = parcel.readString();
        this.f12820d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21133j());
        parcel.writeByte((byte) (m21134k() ? 1 : 0));
        parcel.writeString(m21135l());
        parcel.writeParcelable(this.f12820d, i);
    }
}
