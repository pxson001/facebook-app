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
import com.facebook.graphql.deserializers.GraphQLNotifOptionRowDeserializer;
import com.facebook.graphql.enums.GraphQLNotifOptionRenderType;
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
/* compiled from: event_invitees */
public final class GraphQLNotifOptionRow extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNotifOptionRow> CREATOR = new C04511();
    @Nullable
    String f4640d;
    GraphQLNotifOptionRenderType f4641e;
    @Nullable
    String f4642f;
    @Nullable
    GraphQLTextWithEntities f4643g;
    @Nullable
    String f4644h;
    @Nullable
    GraphQLTextWithEntities f4645i;

    /* compiled from: event_invitees */
    final class C04511 implements Creator<GraphQLNotifOptionRow> {
        C04511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNotifOptionRow(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNotifOptionRow[i];
        }
    }

    /* compiled from: event_invitees */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNotifOptionRow.class, new Deserializer());
        }

        public Object m9330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNotifOptionRowDeserializer.m5445a(jsonParser, (short) 449);
            Object graphQLNotifOptionRow = new GraphQLNotifOptionRow();
            ((BaseModel) graphQLNotifOptionRow).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNotifOptionRow instanceof Postprocessable) {
                return ((Postprocessable) graphQLNotifOptionRow).a();
            }
            return graphQLNotifOptionRow;
        }
    }

    /* compiled from: event_invitees */
    public final class Serializer extends JsonSerializer<GraphQLNotifOptionRow> {
        public final void m9331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNotifOptionRow graphQLNotifOptionRow = (GraphQLNotifOptionRow) obj;
            GraphQLNotifOptionRowDeserializer.m5447b(graphQLNotifOptionRow.w_(), graphQLNotifOptionRow.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNotifOptionRow.class, new Serializer());
            FbSerializerProvider.a(GraphQLNotifOptionRow.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9334a() {
        this.f4640d = super.a(this.f4640d, 0);
        return this.f4640d;
    }

    @FieldOffset
    public final GraphQLNotifOptionRenderType m9335j() {
        this.f4641e = (GraphQLNotifOptionRenderType) super.a(this.f4641e, 2, GraphQLNotifOptionRenderType.class, GraphQLNotifOptionRenderType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4641e;
    }

    @FieldOffset
    @Nullable
    public final String m9336k() {
        this.f4642f = super.a(this.f4642f, 3);
        return this.f4642f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9337l() {
        this.f4643g = (GraphQLTextWithEntities) super.a(this.f4643g, 4, GraphQLTextWithEntities.class);
        return this.f4643g;
    }

    @FieldOffset
    @Nullable
    public final String m9338m() {
        this.f4644h = super.a(this.f4644h, 5);
        return this.f4644h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9339n() {
        this.f4645i = (GraphQLTextWithEntities) super.a(this.f4645i, 6, GraphQLTextWithEntities.class);
        return this.f4645i;
    }

    public final int jK_() {
        return 90414069;
    }

    public final GraphQLVisitableModel m9333a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9337l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9337l());
            if (m9337l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotifOptionRow) ModelHelper.a(null, this);
                graphQLVisitableModel.f4643g = graphQLTextWithEntities;
            }
        }
        if (m9339n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9339n());
            if (m9339n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotifOptionRow) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4645i = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNotifOptionRow() {
        super(8);
    }

    public final int m9332a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9334a());
        int b2 = flatBufferBuilder.b(m9336k());
        int a = ModelHelper.a(flatBufferBuilder, m9337l());
        int b3 = flatBufferBuilder.b(m9338m());
        int a2 = ModelHelper.a(flatBufferBuilder, m9339n());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(2, m9335j() == GraphQLNotifOptionRenderType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m9335j());
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, a);
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.b(6, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNotifOptionRow(Parcel parcel) {
        super(8);
        this.f4640d = parcel.readString();
        this.f4641e = GraphQLNotifOptionRenderType.fromString(parcel.readString());
        this.f4642f = parcel.readString();
        this.f4643g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4644h = parcel.readString();
        this.f4645i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9334a());
        parcel.writeString(m9335j().name());
        parcel.writeString(m9336k());
        parcel.writeValue(m9337l());
        parcel.writeString(m9338m());
        parcel.writeValue(m9339n());
    }
}
