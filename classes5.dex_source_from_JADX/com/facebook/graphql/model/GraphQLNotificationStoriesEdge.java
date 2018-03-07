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
import com.facebook.graphql.deserializers.GraphQLNotificationStoriesEdgeDeserializer;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: event_coordinates */
public final class GraphQLNotificationStoriesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNotificationStoriesEdge> CREATOR = new C04541();
    @Nullable
    public String f4659d;
    public GraphQLNotifHighlightState f4660e;
    @Nullable
    public GraphQLTextWithEntities f4661f;
    public int f4662g;
    public GraphQLNotifImportanceType f4663h;
    public int f4664i;
    @Nullable
    public GraphQLStory f4665j;
    public List<GraphQLNotifOptionRow> f4666k;
    @Nullable
    public GraphQLReactionUnit f4667l;
    public int f4668m;
    public boolean f4669n;

    /* compiled from: event_coordinates */
    final class C04541 implements Creator<GraphQLNotificationStoriesEdge> {
        C04541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNotificationStoriesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNotificationStoriesEdge[i];
        }
    }

    /* compiled from: event_coordinates */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNotificationStoriesEdge.class, new Deserializer());
        }

        public Object m9371a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNotificationStoriesEdgeDeserializer.m5455a(jsonParser, (short) 448);
            Object graphQLNotificationStoriesEdge = new GraphQLNotificationStoriesEdge();
            ((BaseModel) graphQLNotificationStoriesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNotificationStoriesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLNotificationStoriesEdge).a();
            }
            return graphQLNotificationStoriesEdge;
        }
    }

    /* compiled from: event_coordinates */
    public final class Serializer extends JsonSerializer<GraphQLNotificationStoriesEdge> {
        public final void m9372a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNotificationStoriesEdge graphQLNotificationStoriesEdge = (GraphQLNotificationStoriesEdge) obj;
            GraphQLNotificationStoriesEdgeDeserializer.m5456a(graphQLNotificationStoriesEdge.w_(), graphQLNotificationStoriesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNotificationStoriesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLNotificationStoriesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9375a() {
        this.f4659d = super.a(this.f4659d, 0);
        return this.f4659d;
    }

    @FieldOffset
    public final GraphQLNotifHighlightState m9377j() {
        this.f4660e = (GraphQLNotifHighlightState) super.a(this.f4660e, 1, GraphQLNotifHighlightState.class, GraphQLNotifHighlightState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4660e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9378k() {
        this.f4661f = (GraphQLTextWithEntities) super.a(this.f4661f, 2, GraphQLTextWithEntities.class);
        return this.f4661f;
    }

    @FieldOffset
    public final int m9379l() {
        a(0, 3);
        return this.f4662g;
    }

    @FieldOffset
    public final GraphQLNotifImportanceType m9380m() {
        this.f4663h = (GraphQLNotifImportanceType) super.a(this.f4663h, 4, GraphQLNotifImportanceType.class, GraphQLNotifImportanceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4663h;
    }

    @FieldOffset
    public final int m9381n() {
        a(0, 5);
        return this.f4664i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m9382o() {
        this.f4665j = (GraphQLStory) super.a(this.f4665j, 7, GraphQLStory.class);
        return this.f4665j;
    }

    @FieldOffset
    public final ImmutableList<GraphQLNotifOptionRow> m9383p() {
        this.f4666k = super.a(this.f4666k, 8, GraphQLNotifOptionRow.class);
        return (ImmutableList) this.f4666k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLReactionUnit m9384q() {
        this.f4667l = (GraphQLReactionUnit) super.a(this.f4667l, 9, GraphQLReactionUnit.class);
        return this.f4667l;
    }

    @FieldOffset
    public final int m9385r() {
        a(1, 2);
        return this.f4668m;
    }

    @FieldOffset
    public final boolean m9386s() {
        a(1, 3);
        return this.f4669n;
    }

    public final int jK_() {
        return -560159067;
    }

    public final GraphQLVisitableModel m9374a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9378k() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9378k());
            if (m9378k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNotificationStoriesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4661f = graphQLTextWithEntities;
            }
        }
        if (m9382o() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m9382o());
            if (m9382o() != graphQLStory) {
                graphQLVisitableModel = (GraphQLNotificationStoriesEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4665j = graphQLStory;
            }
        }
        if (m9383p() != null) {
            Builder a = ModelHelper.a(m9383p(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLNotificationStoriesEdge graphQLNotificationStoriesEdge = (GraphQLNotificationStoriesEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLNotificationStoriesEdge.f4666k = a.b();
                graphQLVisitableModel = graphQLNotificationStoriesEdge;
            }
        }
        if (m9384q() != null) {
            GraphQLReactionUnit graphQLReactionUnit = (GraphQLReactionUnit) graphQLModelMutatingVisitor.b(m9384q());
            if (m9384q() != graphQLReactionUnit) {
                graphQLVisitableModel = (GraphQLNotificationStoriesEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4667l = graphQLReactionUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNotificationStoriesEdge() {
        super(13);
    }

    public final void m9376a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4662g = mutableFlatBuffer.a(i, 3, 0);
        this.f4664i = mutableFlatBuffer.a(i, 5, 0);
        this.f4668m = mutableFlatBuffer.a(i, 10, 0);
        this.f4669n = mutableFlatBuffer.a(i, 11);
    }

    public final int m9373a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int b = flatBufferBuilder.b(m9375a());
        int a = ModelHelper.a(flatBufferBuilder, m9378k());
        int a2 = ModelHelper.a(flatBufferBuilder, m9382o());
        int a3 = ModelHelper.a(flatBufferBuilder, m9383p());
        int a4 = ModelHelper.a(flatBufferBuilder, m9384q());
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m9377j() == GraphQLNotifHighlightState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m9377j());
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.a(3, m9379l(), 0);
        if (m9380m() != GraphQLNotifImportanceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m9380m();
        }
        flatBufferBuilder.a(4, enumR);
        flatBufferBuilder.a(5, m9381n(), 0);
        flatBufferBuilder.b(7, a2);
        flatBufferBuilder.b(8, a3);
        flatBufferBuilder.b(9, a4);
        flatBufferBuilder.a(10, m9385r(), 0);
        flatBufferBuilder.a(11, m9386s());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNotificationStoriesEdge(Parcel parcel) {
        super(13);
        this.f4659d = parcel.readString();
        this.f4660e = GraphQLNotifHighlightState.fromString(parcel.readString());
        this.f4661f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4662g = parcel.readInt();
        this.f4663h = GraphQLNotifImportanceType.fromString(parcel.readString());
        this.f4669n = parcel.readByte() == (byte) 1;
        this.f4668m = parcel.readInt();
        this.f4664i = parcel.readInt();
        this.f4665j = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f4666k = ImmutableListHelper.a(parcel.readArrayList(GraphQLNotifOptionRow.class.getClassLoader()));
        this.f4667l = (GraphQLReactionUnit) parcel.readValue(GraphQLReactionUnit.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9375a());
        parcel.writeString(m9377j().name());
        parcel.writeValue(m9378k());
        parcel.writeInt(m9379l());
        parcel.writeString(m9380m().name());
        parcel.writeByte((byte) (m9386s() ? 1 : 0));
        parcel.writeInt(m9385r());
        parcel.writeInt(m9381n());
        parcel.writeValue(m9382o());
        parcel.writeList(m9383p());
        parcel.writeValue(m9384q());
    }
}
