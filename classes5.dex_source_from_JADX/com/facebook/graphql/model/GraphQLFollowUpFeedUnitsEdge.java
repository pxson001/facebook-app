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
import com.facebook.graphql.deserializers.GraphQLFollowUpFeedUnitsEdgeDeserializer;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
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
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: hc_timeline */
public final class GraphQLFollowUpFeedUnitsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFollowUpFeedUnitsEdge> CREATOR = new C03271();
    @Nullable
    FeedUnit f3774d;
    List<GraphQLFollowUpFeedUnitActionType> f3775e;

    /* compiled from: hc_timeline */
    final class C03271 implements Creator<GraphQLFollowUpFeedUnitsEdge> {
        C03271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFollowUpFeedUnitsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFollowUpFeedUnitsEdge[i];
        }
    }

    /* compiled from: hc_timeline */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFollowUpFeedUnitsEdge.class, new Deserializer());
        }

        public Object m7534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFollowUpFeedUnitsEdgeDeserializer.m4926a(jsonParser, (short) 326);
            Object graphQLFollowUpFeedUnitsEdge = new GraphQLFollowUpFeedUnitsEdge();
            ((BaseModel) graphQLFollowUpFeedUnitsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFollowUpFeedUnitsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLFollowUpFeedUnitsEdge).a();
            }
            return graphQLFollowUpFeedUnitsEdge;
        }
    }

    /* compiled from: hc_timeline */
    public final class Serializer extends JsonSerializer<GraphQLFollowUpFeedUnitsEdge> {
        public final void m7535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFollowUpFeedUnitsEdge graphQLFollowUpFeedUnitsEdge = (GraphQLFollowUpFeedUnitsEdge) obj;
            GraphQLFollowUpFeedUnitsEdgeDeserializer.m4927b(graphQLFollowUpFeedUnitsEdge.w_(), graphQLFollowUpFeedUnitsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFollowUpFeedUnitsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLFollowUpFeedUnitsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m7537a() {
        this.f3774d = (FeedUnit) super.a(this.f3774d, 0, VirtualFlattenableResolverImpl.a);
        return this.f3774d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFollowUpFeedUnitActionType> m7539j() {
        this.f3775e = super.b(this.f3775e, 1, GraphQLFollowUpFeedUnitActionType.class);
        return (ImmutableList) this.f3775e;
    }

    public final int jK_() {
        return -706191646;
    }

    public final GraphQLVisitableModel m7538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7537a() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m7537a());
            if (m7537a() != feedUnit) {
                graphQLVisitableModel = (GraphQLFollowUpFeedUnitsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3774d = feedUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFollowUpFeedUnitsEdge() {
        super(3);
    }

    public final int m7536a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m7537a(), VirtualFlattenableResolverImpl.a);
        int e = flatBufferBuilder.e(m7539j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, e);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFollowUpFeedUnitsEdge(Parcel parcel) {
        super(3);
        this.f3774d = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f3775e = ImmutableListHelper.a(parcel.readArrayList(GraphQLFollowUpFeedUnitActionType.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7537a());
        parcel.writeList(m7539j());
    }
}
