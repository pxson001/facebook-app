package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQPStringEnumTemplateParameterDeserializer;
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
/* compiled from: VISITS_AP */
public final class GraphQLQPStringEnumTemplateParameter extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQPStringEnumTemplateParameter> CREATOR = new C11861();
    @Nullable
    public String f12817d;
    public boolean f12818e;
    @Nullable
    public String f12819f;

    /* compiled from: VISITS_AP */
    final class C11861 implements Creator<GraphQLQPStringEnumTemplateParameter> {
        C11861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQPStringEnumTemplateParameter(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQPStringEnumTemplateParameter[i];
        }
    }

    /* compiled from: VISITS_AP */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQPStringEnumTemplateParameter.class, new Deserializer());
        }

        public Object m21117a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQPStringEnumTemplateParameterDeserializer.m5726a(jsonParser, (short) 365);
            Object graphQLQPStringEnumTemplateParameter = new GraphQLQPStringEnumTemplateParameter();
            ((BaseModel) graphQLQPStringEnumTemplateParameter).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQPStringEnumTemplateParameter instanceof Postprocessable) {
                return ((Postprocessable) graphQLQPStringEnumTemplateParameter).a();
            }
            return graphQLQPStringEnumTemplateParameter;
        }
    }

    /* compiled from: VISITS_AP */
    public final class Serializer extends JsonSerializer<GraphQLQPStringEnumTemplateParameter> {
        public final void m21118a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQPStringEnumTemplateParameter graphQLQPStringEnumTemplateParameter = (GraphQLQPStringEnumTemplateParameter) obj;
            GraphQLQPStringEnumTemplateParameterDeserializer.m5727a(graphQLQPStringEnumTemplateParameter.w_(), graphQLQPStringEnumTemplateParameter.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLQPStringEnumTemplateParameter.class, new Serializer());
            FbSerializerProvider.a(GraphQLQPStringEnumTemplateParameter.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21121a() {
        this.f12817d = super.a(this.f12817d, 0);
        return this.f12817d;
    }

    @FieldOffset
    public final boolean m21123j() {
        a(0, 1);
        return this.f12818e;
    }

    @FieldOffset
    @Nullable
    public final String m21124k() {
        this.f12819f = super.a(this.f12819f, 2);
        return this.f12819f;
    }

    public final int jK_() {
        return 1883206686;
    }

    public final GraphQLVisitableModel m21120a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLQPStringEnumTemplateParameter() {
        super(4);
    }

    public final void m21122a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12818e = mutableFlatBuffer.a(i, 1);
    }

    public final int m21119a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21121a());
        int b2 = flatBufferBuilder.b(m21124k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m21123j());
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQPStringEnumTemplateParameter(Parcel parcel) {
        boolean z = true;
        super(4);
        this.f12817d = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12818e = z;
        this.f12819f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21121a());
        parcel.writeByte((byte) (m21123j() ? 1 : 0));
        parcel.writeString(m21124k());
    }
}
