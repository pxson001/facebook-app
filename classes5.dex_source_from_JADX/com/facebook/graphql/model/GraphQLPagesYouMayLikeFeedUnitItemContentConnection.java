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
import com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer;
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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WRITE_REVIEW_ON_PAGE */
public final class GraphQLPagesYouMayLikeFeedUnitItemContentConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPagesYouMayLikeFeedUnitItemContentConnection> CREATOR = new C11421();
    public List<GraphQLNode> f12407d;

    /* compiled from: WRITE_REVIEW_ON_PAGE */
    final class C11421 implements Creator<GraphQLPagesYouMayLikeFeedUnitItemContentConnection> {
        C11421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPagesYouMayLikeFeedUnitItemContentConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPagesYouMayLikeFeedUnitItemContentConnection[i];
        }
    }

    /* compiled from: WRITE_REVIEW_ON_PAGE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class, new Deserializer());
        }

        public Object m20568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer.m5547a(jsonParser, (short) 319);
            Object graphQLPagesYouMayLikeFeedUnitItemContentConnection = new GraphQLPagesYouMayLikeFeedUnitItemContentConnection();
            ((BaseModel) graphQLPagesYouMayLikeFeedUnitItemContentConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPagesYouMayLikeFeedUnitItemContentConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLPagesYouMayLikeFeedUnitItemContentConnection).a();
            }
            return graphQLPagesYouMayLikeFeedUnitItemContentConnection;
        }
    }

    /* compiled from: WRITE_REVIEW_ON_PAGE */
    public final class Serializer extends JsonSerializer<GraphQLPagesYouMayLikeFeedUnitItemContentConnection> {
        public final void m20569a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPagesYouMayLikeFeedUnitItemContentConnection graphQLPagesYouMayLikeFeedUnitItemContentConnection = (GraphQLPagesYouMayLikeFeedUnitItemContentConnection) obj;
            GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer.m5548a(graphQLPagesYouMayLikeFeedUnitItemContentConnection.w_(), graphQLPagesYouMayLikeFeedUnitItemContentConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLNode> m20572a() {
        this.f12407d = super.a(this.f12407d, 0, GraphQLNode.class);
        return (ImmutableList) this.f12407d;
    }

    public final int jK_() {
        return 438687105;
    }

    public final GraphQLVisitableModel m20571a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20572a() != null) {
            Builder a = ModelHelper.a(m20572a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPagesYouMayLikeFeedUnitItemContentConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12407d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPagesYouMayLikeFeedUnitItemContentConnection() {
        super(2);
    }

    public final int m20570a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20572a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPagesYouMayLikeFeedUnitItemContentConnection(Parcel parcel) {
        super(2);
        this.f12407d = ImmutableListHelper.a(parcel.readArrayList(GraphQLNode.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m20572a());
    }
}
