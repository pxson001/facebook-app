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
import com.facebook.graphql.deserializers.GraphQLInfoRequestFieldDeserializer;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;
import com.facebook.graphql.model.extras.InfoRequestFieldExtra;
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
/* compiled from: five_neutral */
public final class GraphQLInfoRequestField extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLInfoRequestField> CREATOR = new C04161();
    public GraphQLInfoRequestFieldType f4301d;
    @Nullable
    public String f4302e;
    public GraphQLInfoRequestFieldStatus f4303f;
    @Deprecated
    @Nullable
    public String f4304g;
    public InfoRequestFieldExtra f4305h;

    /* compiled from: five_neutral */
    final class C04161 implements Creator<GraphQLInfoRequestField> {
        C04161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLInfoRequestField(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLInfoRequestField[i];
        }
    }

    /* compiled from: five_neutral */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLInfoRequestField.class, new Deserializer());
        }

        public Object m8674a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLInfoRequestFieldDeserializer.m5242a(jsonParser, (short) 387);
            Object graphQLInfoRequestField = new GraphQLInfoRequestField();
            ((BaseModel) graphQLInfoRequestField).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLInfoRequestField instanceof Postprocessable) {
                return ((Postprocessable) graphQLInfoRequestField).a();
            }
            return graphQLInfoRequestField;
        }
    }

    /* compiled from: five_neutral */
    public final class Serializer extends JsonSerializer<GraphQLInfoRequestField> {
        public final void m8675a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLInfoRequestField graphQLInfoRequestField = (GraphQLInfoRequestField) obj;
            GraphQLInfoRequestFieldDeserializer.m5243a(graphQLInfoRequestField.w_(), graphQLInfoRequestField.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLInfoRequestField.class, new Serializer());
            FbSerializerProvider.a(GraphQLInfoRequestField.class, new Serializer());
        }
    }

    @FieldOffset
    public final GraphQLInfoRequestFieldType m8677a() {
        this.f4301d = (GraphQLInfoRequestFieldType) super.a(this.f4301d, 0, GraphQLInfoRequestFieldType.class, GraphQLInfoRequestFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4301d;
    }

    @FieldOffset
    @Nullable
    public final String m8679j() {
        this.f4302e = super.a(this.f4302e, 1);
        return this.f4302e;
    }

    @FieldOffset
    public final GraphQLInfoRequestFieldStatus m8680k() {
        this.f4303f = (GraphQLInfoRequestFieldStatus) super.a(this.f4303f, 2, GraphQLInfoRequestFieldStatus.class, GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4303f;
    }

    @FieldOffset
    @Nullable
    public final String m8681l() {
        this.f4304g = super.a(this.f4304g, 3);
        return this.f4304g;
    }

    public final int jK_() {
        return -1373476967;
    }

    public final GraphQLVisitableModel m8678a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLInfoRequestField() {
        super(5);
    }

    public final int m8676a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int b = flatBufferBuilder.b(m8679j());
        int b2 = flatBufferBuilder.b(m8681l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, m8677a() == GraphQLInfoRequestFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8677a());
        flatBufferBuilder.b(1, b);
        if (m8680k() != GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m8680k();
        }
        flatBufferBuilder.a(2, enumR);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLInfoRequestField(Parcel parcel) {
        super(5);
        this.f4301d = GraphQLInfoRequestFieldType.fromString(parcel.readString());
        this.f4302e = parcel.readString();
        this.f4303f = GraphQLInfoRequestFieldStatus.fromString(parcel.readString());
        this.f4304g = parcel.readString();
        this.f4305h = (InfoRequestFieldExtra) ParcelUtil.m3828b(parcel, InfoRequestFieldExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8677a().name());
        parcel.writeString(m8679j());
        parcel.writeString(m8680k().name());
        parcel.writeString(m8681l());
        if (this.f4305h == null) {
            if (this.b == null || !this.b.d) {
                this.f4305h = new InfoRequestFieldExtra();
            } else {
                this.f4305h = (InfoRequestFieldExtra) this.b.a(this.c, this, InfoRequestFieldExtra.class);
            }
        }
        parcel.writeParcelable(this.f4305h, i);
    }
}
