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
import com.facebook.graphql.deserializers.GraphQLNotifOptionRowDisplayDeserializer;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: event_hosts */
public final class GraphQLNotifOptionRowDisplay extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNotifOptionRowDisplay> CREATOR = new C04521();
    @Nullable
    public GraphQLObjectType f4646d;
    @Nullable
    public String f4647e;
    @Nullable
    public String f4648f;
    @Nullable
    public GraphQLImage f4649g;
    public GraphQLNotifOptionRowDisplayStyle f4650h;
    @Nullable
    public GraphQLTextWithEntities f4651i;
    @Nullable
    public GraphQLTextWithEntities f4652j;
    @Nullable
    public String f4653k;
    @Nullable
    public GraphQLTextWithEntities f4654l;
    @Nullable
    public GraphQLTextWithEntities f4655m;

    /* compiled from: event_hosts */
    final class C04521 implements Creator<GraphQLNotifOptionRowDisplay> {
        C04521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNotifOptionRowDisplay(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNotifOptionRowDisplay[i];
        }
    }

    /* compiled from: event_hosts */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNotifOptionRowDisplay.class, new Deserializer());
        }

        public Object m9341a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNotifOptionRowDisplayDeserializer.m5449a(jsonParser, (short) 507);
            Object graphQLNotifOptionRowDisplay = new GraphQLNotifOptionRowDisplay();
            ((BaseModel) graphQLNotifOptionRowDisplay).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNotifOptionRowDisplay instanceof Postprocessable) {
                return ((Postprocessable) graphQLNotifOptionRowDisplay).a();
            }
            return graphQLNotifOptionRowDisplay;
        }
    }

    /* compiled from: event_hosts */
    public final class Serializer extends JsonSerializer<GraphQLNotifOptionRowDisplay> {
        public final void m9342a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNotifOptionRowDisplay graphQLNotifOptionRowDisplay = (GraphQLNotifOptionRowDisplay) obj;
            GraphQLNotifOptionRowDisplayDeserializer.m5450a(graphQLNotifOptionRowDisplay.w_(), graphQLNotifOptionRowDisplay.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNotifOptionRowDisplay.class, new Serializer());
            FbSerializerProvider.a(GraphQLNotifOptionRowDisplay.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m9344a() {
        if (this.b != null && this.f4646d == null) {
            this.f4646d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f4646d == null || this.f4646d.g() != 0) {
            return this.f4646d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m9346j() {
        this.f4647e = super.a(this.f4647e, 1);
        return this.f4647e;
    }

    @FieldOffset
    @Nullable
    public final String m9347k() {
        this.f4648f = super.a(this.f4648f, 2);
        return this.f4648f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m9348l() {
        this.f4649g = (GraphQLImage) super.a(this.f4649g, 3, GraphQLImage.class);
        return this.f4649g;
    }

    @FieldOffset
    public final GraphQLNotifOptionRowDisplayStyle m9349m() {
        this.f4650h = (GraphQLNotifOptionRowDisplayStyle) super.a(this.f4650h, 5, GraphQLNotifOptionRowDisplayStyle.class, GraphQLNotifOptionRowDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4650h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9350n() {
        this.f4651i = (GraphQLTextWithEntities) super.a(this.f4651i, 6, GraphQLTextWithEntities.class);
        return this.f4651i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9351o() {
        this.f4652j = (GraphQLTextWithEntities) super.a(this.f4652j, 7, GraphQLTextWithEntities.class);
        return this.f4652j;
    }

    @FieldOffset
    @Nullable
    public final String m9352p() {
        this.f4653k = super.a(this.f4653k, 8);
        return this.f4653k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9353q() {
        this.f4654l = (GraphQLTextWithEntities) super.a(this.f4654l, 9, GraphQLTextWithEntities.class);
        return this.f4654l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9354r() {
        this.f4655m = (GraphQLTextWithEntities) super.a(this.f4655m, 10, GraphQLTextWithEntities.class);
        return this.f4655m;
    }

    public final int jK_() {
        return 1019586317;
    }

    public final GraphQLVisitableModel m9345a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9348l() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m9348l());
            if (m9348l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLNotifOptionRowDisplay) ModelHelper.a(null, this);
                graphQLVisitableModel.f4649g = graphQLImage;
            }
        }
        if (m9350n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9350n());
            if (m9350n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotifOptionRowDisplay) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4651i = graphQLTextWithEntities;
            }
        }
        if (m9351o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9351o());
            if (m9351o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotifOptionRowDisplay) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4652j = graphQLTextWithEntities;
            }
        }
        if (m9353q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9353q());
            if (m9353q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotifOptionRowDisplay) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4654l = graphQLTextWithEntities;
            }
        }
        if (m9354r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9354r());
            if (m9354r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotifOptionRowDisplay) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4655m = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNotifOptionRowDisplay() {
        super(12);
    }

    public final int m9343a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = flatBufferBuilder.a(m9344a() != null ? m9344a().e() : null);
        int b = flatBufferBuilder.b(m9346j());
        int b2 = flatBufferBuilder.b(m9347k());
        int a2 = ModelHelper.a(flatBufferBuilder, m9348l());
        int a3 = ModelHelper.a(flatBufferBuilder, m9350n());
        int a4 = ModelHelper.a(flatBufferBuilder, m9351o());
        int b3 = flatBufferBuilder.b(m9352p());
        int a5 = ModelHelper.a(flatBufferBuilder, m9353q());
        int a6 = ModelHelper.a(flatBufferBuilder, m9354r());
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        if (m9349m() != GraphQLNotifOptionRowDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m9349m();
        }
        flatBufferBuilder.a(5, enumR);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.b(7, a4);
        flatBufferBuilder.b(8, b3);
        flatBufferBuilder.b(9, a5);
        flatBufferBuilder.b(10, a6);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNotifOptionRowDisplay(Parcel parcel) {
        super(12);
        this.f4647e = parcel.readString();
        this.f4648f = parcel.readString();
        this.f4649g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4650h = GraphQLNotifOptionRowDisplayStyle.fromString(parcel.readString());
        this.f4651i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4652j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4653k = parcel.readString();
        this.f4654l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4655m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4646d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9346j());
        parcel.writeString(m9347k());
        parcel.writeValue(m9348l());
        parcel.writeString(m9349m().name());
        parcel.writeValue(m9350n());
        parcel.writeValue(m9351o());
        parcel.writeString(m9352p());
        parcel.writeValue(m9353q());
        parcel.writeValue(m9354r());
        parcel.writeParcelable(this.f4646d, i);
    }
}
