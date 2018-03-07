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
import com.facebook.graphql.deserializers.GraphQLSportsDataMatchToFactsConnectionDeserializer;
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
/* compiled from: Unknown token  */
public final class GraphQLSportsDataMatchToFactsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSportsDataMatchToFactsConnection> CREATOR = new C12341();
    public List<GraphQLSportsDataMatchDataFact> f13071d;
    @Nullable
    public GraphQLPageInfo f13072e;

    /* compiled from: Unknown token  */
    final class C12341 implements Creator<GraphQLSportsDataMatchToFactsConnection> {
        C12341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSportsDataMatchToFactsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSportsDataMatchToFactsConnection[i];
        }
    }

    /* compiled from: Unknown token  */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchToFactsConnection.class, new Deserializer());
        }

        public Object m21789a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSportsDataMatchToFactsConnectionDeserializer.m5931a(jsonParser, (short) 477);
            Object graphQLSportsDataMatchToFactsConnection = new GraphQLSportsDataMatchToFactsConnection();
            ((BaseModel) graphQLSportsDataMatchToFactsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSportsDataMatchToFactsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLSportsDataMatchToFactsConnection).a();
            }
            return graphQLSportsDataMatchToFactsConnection;
        }
    }

    /* compiled from: Unknown token  */
    public final class Serializer extends JsonSerializer<GraphQLSportsDataMatchToFactsConnection> {
        public final void m21790a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSportsDataMatchToFactsConnection graphQLSportsDataMatchToFactsConnection = (GraphQLSportsDataMatchToFactsConnection) obj;
            GraphQLSportsDataMatchToFactsConnectionDeserializer.m5932a(graphQLSportsDataMatchToFactsConnection.w_(), graphQLSportsDataMatchToFactsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSportsDataMatchToFactsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLSportsDataMatchToFactsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLSportsDataMatchDataFact> m21793a() {
        this.f13071d = super.a(this.f13071d, 0, GraphQLSportsDataMatchDataFact.class);
        return (ImmutableList) this.f13071d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m21794j() {
        this.f13072e = (GraphQLPageInfo) super.a(this.f13072e, 1, GraphQLPageInfo.class);
        return this.f13072e;
    }

    public final int jK_() {
        return -1530660402;
    }

    public final GraphQLVisitableModel m21792a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m21793a() != null) {
            Builder a = ModelHelper.a(m21793a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLSportsDataMatchToFactsConnection graphQLSportsDataMatchToFactsConnection = (GraphQLSportsDataMatchToFactsConnection) ModelHelper.a(null, this);
                graphQLSportsDataMatchToFactsConnection.f13071d = a.b();
                graphQLVisitableModel = graphQLSportsDataMatchToFactsConnection;
                if (m21794j() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m21794j());
                    if (m21794j() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLSportsDataMatchToFactsConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13072e = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m21794j() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m21794j());
            if (m21794j() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLSportsDataMatchToFactsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13072e = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLSportsDataMatchToFactsConnection() {
        super(3);
    }

    public final int m21791a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21793a());
        int a2 = ModelHelper.a(flatBufferBuilder, m21794j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSportsDataMatchToFactsConnection(Parcel parcel) {
        super(3);
        this.f13071d = ImmutableListHelper.a(parcel.readArrayList(GraphQLSportsDataMatchDataFact.class.getClassLoader()));
        this.f13072e = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m21793a());
        parcel.writeValue(m21794j());
    }
}
