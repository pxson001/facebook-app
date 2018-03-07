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
import com.facebook.graphql.deserializers.C0244x53cdff0a;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.HasTracking;
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
/* compiled from: WRITE_END_MARKER */
public final class GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge extends BaseModel implements GroupsYouShouldJoinFeedUnitItem, HasProperty, HasTracking, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> CREATOR = new C11511();
    @Nullable
    GraphQLGroup f12421d;
    @Nullable
    String f12422e;
    @Nullable
    private PropertyBag f12423f = null;

    /* compiled from: WRITE_END_MARKER */
    final class C11511 implements Creator<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> {
        C11511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge[i];
        }
    }

    /* compiled from: WRITE_END_MARKER */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.class, new Deserializer());
        }

        public Object m20596a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0244x53cdff0a.m5561a(jsonParser, (short) 349);
            Object graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge = new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge();
            ((BaseModel) graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge).a();
            }
            return graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge;
        }
    }

    /* compiled from: WRITE_END_MARKER */
    public final class Serializer extends JsonSerializer<GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge> {
        public final void m20597a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) obj;
            C0244x53cdff0a.m5562b(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.w_(), graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.class, new Serializer());
        }
    }

    public final GraphQLGroup mo612j() {
        return m20603l();
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroup m20603l() {
        this.f12421d = (GraphQLGroup) super.a(this.f12421d, 0, GraphQLGroup.class);
        return this.f12421d;
    }

    @FieldOffset
    @Nullable
    public final String m20602k() {
        this.f12422e = super.a(this.f12422e, 1);
        return this.f12422e;
    }

    public final int jK_() {
        return -760401778;
    }

    public final GraphQLVisitableModel m20600a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20603l() != null) {
            GraphQLGroup graphQLGroup = (GraphQLGroup) graphQLModelMutatingVisitor.b(m20603l());
            if (m20603l() != graphQLGroup) {
                graphQLVisitableModel = (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12421d = graphQLGroup;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge() {
        super(3);
    }

    public final int m20599a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20603l());
        int b = flatBufferBuilder.b(m20602k());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge(Parcel parcel) {
        super(3);
        this.f12421d = (GraphQLGroup) parcel.readValue(GraphQLGroup.class.getClassLoader());
        this.f12422e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m20603l());
        parcel.writeString(m20602k());
    }

    public final PropertyBag U_() {
        if (this.f12423f == null) {
            this.f12423f = new PropertyBag();
        }
        return this.f12423f;
    }
}
