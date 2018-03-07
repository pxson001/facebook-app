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
import com.facebook.graphql.deserializers.GraphQLBoostedComponentMessageDeserializer;
import com.facebook.graphql.enums.GraphQLBoostedComponentMessageType;
import com.facebook.graphql.enums.GraphQLBoostedComponentSpecElement;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
/* compiled from: is_multi_company_group */
public final class GraphQLBoostedComponentMessage extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLBoostedComponentMessage> CREATOR = new C02761();
    @Nullable
    GraphQLAYMTNativeMobileAction f3396d;
    @Nullable
    GraphQLError f3397e;
    GraphQLBoostedComponentMessageType f3398f;
    GraphQLBoostedComponentSpecElement f3399g;
    @Nullable
    GraphQLTextWithEntities f3400h;
    @Nullable
    GraphQLTextWithEntities f3401i;

    /* compiled from: is_multi_company_group */
    final class C02761 implements Creator<GraphQLBoostedComponentMessage> {
        C02761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLBoostedComponentMessage(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLBoostedComponentMessage[i];
        }
    }

    /* compiled from: is_multi_company_group */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLBoostedComponentMessage.class, new Deserializer());
        }

        public Object m6647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLBoostedComponentMessageDeserializer.m4615a(jsonParser, (short) 264);
            Object graphQLBoostedComponentMessage = new GraphQLBoostedComponentMessage();
            ((BaseModel) graphQLBoostedComponentMessage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLBoostedComponentMessage instanceof Postprocessable) {
                return ((Postprocessable) graphQLBoostedComponentMessage).a();
            }
            return graphQLBoostedComponentMessage;
        }
    }

    /* compiled from: is_multi_company_group */
    public final class Serializer extends JsonSerializer<GraphQLBoostedComponentMessage> {
        public final void m6648a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLBoostedComponentMessage graphQLBoostedComponentMessage = (GraphQLBoostedComponentMessage) obj;
            GraphQLBoostedComponentMessageDeserializer.m4617b(graphQLBoostedComponentMessage.w_(), graphQLBoostedComponentMessage.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLBoostedComponentMessage.class, new Serializer());
            FbSerializerProvider.a(GraphQLBoostedComponentMessage.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLAYMTNativeMobileAction m6650a() {
        this.f3396d = (GraphQLAYMTNativeMobileAction) super.a(this.f3396d, 0, GraphQLAYMTNativeMobileAction.class);
        return this.f3396d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLError m6652j() {
        this.f3397e = (GraphQLError) super.a(this.f3397e, 1, GraphQLError.class);
        return this.f3397e;
    }

    @FieldOffset
    public final GraphQLBoostedComponentMessageType m6653k() {
        this.f3398f = (GraphQLBoostedComponentMessageType) super.a(this.f3398f, 2, GraphQLBoostedComponentMessageType.class, GraphQLBoostedComponentMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3398f;
    }

    @FieldOffset
    public final GraphQLBoostedComponentSpecElement m6654l() {
        this.f3399g = (GraphQLBoostedComponentSpecElement) super.a(this.f3399g, 3, GraphQLBoostedComponentSpecElement.class, GraphQLBoostedComponentSpecElement.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3399g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6655m() {
        this.f3400h = (GraphQLTextWithEntities) super.a(this.f3400h, 4, GraphQLTextWithEntities.class);
        return this.f3400h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m6656n() {
        this.f3401i = (GraphQLTextWithEntities) super.a(this.f3401i, 5, GraphQLTextWithEntities.class);
        return this.f3401i;
    }

    public final int jK_() {
        return -757923892;
    }

    public final GraphQLVisitableModel m6651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6650a() != null) {
            GraphQLAYMTNativeMobileAction graphQLAYMTNativeMobileAction = (GraphQLAYMTNativeMobileAction) graphQLModelMutatingVisitor.b(m6650a());
            if (m6650a() != graphQLAYMTNativeMobileAction) {
                graphQLVisitableModel = (GraphQLBoostedComponentMessage) ModelHelper.a(null, this);
                graphQLVisitableModel.f3396d = graphQLAYMTNativeMobileAction;
            }
        }
        if (m6652j() != null) {
            GraphQLError graphQLError = (GraphQLError) graphQLModelMutatingVisitor.b(m6652j());
            if (m6652j() != graphQLError) {
                graphQLVisitableModel = (GraphQLBoostedComponentMessage) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3397e = graphQLError;
            }
        }
        if (m6655m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6655m());
            if (m6655m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLBoostedComponentMessage) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3400h = graphQLTextWithEntities;
            }
        }
        if (m6656n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m6656n());
            if (m6656n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLBoostedComponentMessage) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3401i = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLBoostedComponentMessage() {
        super(7);
    }

    public final int m6649a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6650a());
        int a2 = ModelHelper.a(flatBufferBuilder, m6652j());
        int a3 = ModelHelper.a(flatBufferBuilder, m6655m());
        int a4 = ModelHelper.a(flatBufferBuilder, m6656n());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.a(2, m6653k() == GraphQLBoostedComponentMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m6653k());
        if (m6654l() != GraphQLBoostedComponentSpecElement.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m6654l();
        }
        flatBufferBuilder.a(3, enumR);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLBoostedComponentMessage(Parcel parcel) {
        super(7);
        this.f3396d = (GraphQLAYMTNativeMobileAction) parcel.readValue(GraphQLAYMTNativeMobileAction.class.getClassLoader());
        this.f3397e = (GraphQLError) parcel.readValue(GraphQLError.class.getClassLoader());
        this.f3398f = GraphQLBoostedComponentMessageType.fromString(parcel.readString());
        this.f3399g = GraphQLBoostedComponentSpecElement.fromString(parcel.readString());
        this.f3400h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3401i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6650a());
        parcel.writeValue(m6652j());
        parcel.writeString(m6653k().name());
        parcel.writeString(m6654l().name());
        parcel.writeValue(m6655m());
        parcel.writeValue(m6656n());
    }
}
