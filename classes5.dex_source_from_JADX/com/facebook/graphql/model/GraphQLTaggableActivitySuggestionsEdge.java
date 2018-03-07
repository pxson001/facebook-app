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
import com.facebook.graphql.deserializers.GraphQLTaggableActivitySuggestionsEdgeDeserializer;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: UNREGISTERED */
public final class GraphQLTaggableActivitySuggestionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTaggableActivitySuggestionsEdge> CREATOR = new C12491();
    @Nullable
    GraphQLPlaceFlowInfo f13273d;
    @Nullable
    String f13274e;
    List<GraphQLTaggableActivityIcon> f13275f;
    @Nullable
    String f13276g;
    @Nullable
    GraphQLTaggableActivityIcon f13277h;
    @Nullable
    GraphQLImage f13278i;
    @Nullable
    GraphQLProfile f13279j;
    boolean f13280k;
    @Nullable
    GraphQLTextWithEntities f13281l;
    @Nullable
    String f13282m;

    /* compiled from: UNREGISTERED */
    final class C12491 implements Creator<GraphQLTaggableActivitySuggestionsEdge> {
        C12491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTaggableActivitySuggestionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTaggableActivitySuggestionsEdge[i];
        }
    }

    /* compiled from: UNREGISTERED */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLPlaceFlowInfo f13263d;
        @Nullable
        public String f13264e;
        public ImmutableList<GraphQLTaggableActivityIcon> f13265f;
        @Nullable
        public String f13266g;
        @Nullable
        public GraphQLTaggableActivityIcon f13267h;
        @Nullable
        public GraphQLImage f13268i;
        @Nullable
        public GraphQLProfile f13269j;
        public boolean f13270k;
        @Nullable
        public GraphQLTextWithEntities f13271l;
        @Nullable
        public String f13272m;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: UNREGISTERED */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivitySuggestionsEdge.class, new Deserializer());
        }

        public Object m22064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTaggableActivitySuggestionsEdgeDeserializer.m6045a(jsonParser, (short) 291);
            Object graphQLTaggableActivitySuggestionsEdge = new GraphQLTaggableActivitySuggestionsEdge();
            ((BaseModel) graphQLTaggableActivitySuggestionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTaggableActivitySuggestionsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLTaggableActivitySuggestionsEdge).a();
            }
            return graphQLTaggableActivitySuggestionsEdge;
        }
    }

    /* compiled from: UNREGISTERED */
    public final class Serializer extends JsonSerializer<GraphQLTaggableActivitySuggestionsEdge> {
        public final void m22065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge = (GraphQLTaggableActivitySuggestionsEdge) obj;
            GraphQLTaggableActivitySuggestionsEdgeDeserializer.m6046a(graphQLTaggableActivitySuggestionsEdge.w_(), graphQLTaggableActivitySuggestionsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTaggableActivitySuggestionsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLTaggableActivitySuggestionsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPlaceFlowInfo m22067a() {
        this.f13273d = (GraphQLPlaceFlowInfo) super.a(this.f13273d, 0, GraphQLPlaceFlowInfo.class);
        return this.f13273d;
    }

    @FieldOffset
    @Nullable
    public final String m22070j() {
        this.f13274e = super.a(this.f13274e, 1);
        return this.f13274e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTaggableActivityIcon> m22071k() {
        this.f13275f = super.a(this.f13275f, 2, GraphQLTaggableActivityIcon.class);
        return (ImmutableList) this.f13275f;
    }

    @FieldOffset
    @Nullable
    public final String m22072l() {
        this.f13276g = super.a(this.f13276g, 3);
        return this.f13276g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTaggableActivityIcon m22073m() {
        this.f13277h = (GraphQLTaggableActivityIcon) super.a(this.f13277h, 4, GraphQLTaggableActivityIcon.class);
        return this.f13277h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22074n() {
        this.f13278i = (GraphQLImage) super.a(this.f13278i, 5, GraphQLImage.class);
        return this.f13278i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m22075o() {
        this.f13279j = (GraphQLProfile) super.a(this.f13279j, 6, GraphQLProfile.class);
        return this.f13279j;
    }

    @FieldOffset
    public final boolean m22076p() {
        a(0, 7);
        return this.f13280k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22077q() {
        this.f13281l = (GraphQLTextWithEntities) super.a(this.f13281l, 8, GraphQLTextWithEntities.class);
        return this.f13281l;
    }

    @FieldOffset
    @Nullable
    public final String m22078r() {
        this.f13282m = super.a(this.f13282m, 9);
        return this.f13282m;
    }

    public final int jK_() {
        return -863817930;
    }

    public final GraphQLVisitableModel m22068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22067a() != null) {
            GraphQLPlaceFlowInfo graphQLPlaceFlowInfo = (GraphQLPlaceFlowInfo) graphQLModelMutatingVisitor.b(m22067a());
            if (m22067a() != graphQLPlaceFlowInfo) {
                graphQLVisitableModel = (GraphQLTaggableActivitySuggestionsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13273d = graphQLPlaceFlowInfo;
            }
        }
        if (m22071k() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m22071k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge = (GraphQLTaggableActivitySuggestionsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLTaggableActivitySuggestionsEdge.f13275f = a.b();
                graphQLVisitableModel = graphQLTaggableActivitySuggestionsEdge;
            }
        }
        if (m22073m() != null) {
            GraphQLTaggableActivityIcon graphQLTaggableActivityIcon = (GraphQLTaggableActivityIcon) graphQLModelMutatingVisitor.b(m22073m());
            if (m22073m() != graphQLTaggableActivityIcon) {
                graphQLVisitableModel = (GraphQLTaggableActivitySuggestionsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13277h = graphQLTaggableActivityIcon;
            }
        }
        if (m22074n() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22074n());
            if (m22074n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTaggableActivitySuggestionsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13278i = graphQLImage;
            }
        }
        if (m22075o() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m22075o());
            if (m22075o() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLTaggableActivitySuggestionsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13279j = graphQLProfile;
            }
        }
        if (m22077q() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22077q());
            if (m22077q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLTaggableActivitySuggestionsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13281l = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTaggableActivitySuggestionsEdge() {
        super(11);
    }

    public final void m22069a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13280k = mutableFlatBuffer.a(i, 7);
    }

    public final int m22066a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22067a());
        int b = flatBufferBuilder.b(m22070j());
        int a2 = ModelHelper.a(flatBufferBuilder, m22071k());
        int b2 = flatBufferBuilder.b(m22072l());
        int a3 = ModelHelper.a(flatBufferBuilder, m22073m());
        int a4 = ModelHelper.a(flatBufferBuilder, m22074n());
        int a5 = ModelHelper.a(flatBufferBuilder, m22075o());
        int a6 = ModelHelper.a(flatBufferBuilder, m22077q());
        int b3 = flatBufferBuilder.b(m22078r());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.a(7, m22076p());
        flatBufferBuilder.b(8, a6);
        flatBufferBuilder.b(9, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTaggableActivitySuggestionsEdge(Parcel parcel) {
        super(11);
        this.f13273d = (GraphQLPlaceFlowInfo) parcel.readValue(GraphQLPlaceFlowInfo.class.getClassLoader());
        this.f13274e = parcel.readString();
        this.f13275f = ImmutableListHelper.a(parcel.readArrayList(GraphQLTaggableActivityIcon.class.getClassLoader()));
        this.f13276g = parcel.readString();
        this.f13277h = (GraphQLTaggableActivityIcon) parcel.readValue(GraphQLTaggableActivityIcon.class.getClassLoader());
        this.f13278i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13279j = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f13280k = parcel.readByte() == (byte) 1;
        this.f13281l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13282m = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22067a());
        parcel.writeString(m22070j());
        parcel.writeList(m22071k());
        parcel.writeString(m22072l());
        parcel.writeValue(m22073m());
        parcel.writeValue(m22074n());
        parcel.writeValue(m22075o());
        parcel.writeByte((byte) (m22076p() ? 1 : 0));
        parcel.writeValue(m22077q());
        parcel.writeString(m22078r());
    }

    public GraphQLTaggableActivitySuggestionsEdge(Builder builder) {
        super(11);
        this.b = builder.a;
        this.c = builder.b;
        this.f13273d = builder.f13263d;
        this.f13274e = builder.f13264e;
        this.f13275f = builder.f13265f;
        this.f13276g = builder.f13266g;
        this.f13277h = builder.f13267h;
        this.f13278i = builder.f13268i;
        this.f13279j = builder.f13269j;
        this.f13280k = builder.f13270k;
        this.f13281l = builder.f13271l;
        this.f13282m = builder.f13272m;
    }
}
