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
import com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionsConnectionDeserializer;
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
/* compiled from: UNIVERSITY_CLEAN */
public final class GraphQLTimelineAppCollectionsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimelineAppCollectionsConnection> CREATOR = new C12531();
    public int f13327d;
    public List<GraphQLTimelineAppCollection> f13328e;
    @Nullable
    public GraphQLPageInfo f13329f;

    /* compiled from: UNIVERSITY_CLEAN */
    final class C12531 implements Creator<GraphQLTimelineAppCollectionsConnection> {
        C12531() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimelineAppCollectionsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimelineAppCollectionsConnection[i];
        }
    }

    /* compiled from: UNIVERSITY_CLEAN */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollectionsConnection.class, new Deserializer());
        }

        public Object m22163a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTimelineAppCollectionsConnectionDeserializer.m6078a(jsonParser, (short) 498);
            Object graphQLTimelineAppCollectionsConnection = new GraphQLTimelineAppCollectionsConnection();
            ((BaseModel) graphQLTimelineAppCollectionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTimelineAppCollectionsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLTimelineAppCollectionsConnection).a();
            }
            return graphQLTimelineAppCollectionsConnection;
        }
    }

    /* compiled from: UNIVERSITY_CLEAN */
    public final class Serializer extends JsonSerializer<GraphQLTimelineAppCollectionsConnection> {
        public final void m22164a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTimelineAppCollectionsConnection graphQLTimelineAppCollectionsConnection = (GraphQLTimelineAppCollectionsConnection) obj;
            GraphQLTimelineAppCollectionsConnectionDeserializer.m6079a(graphQLTimelineAppCollectionsConnection.w_(), graphQLTimelineAppCollectionsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTimelineAppCollectionsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLTimelineAppCollectionsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m22165a() {
        a(0, 0);
        return this.f13327d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLTimelineAppCollection> m22169j() {
        this.f13328e = super.a(this.f13328e, 1, GraphQLTimelineAppCollection.class);
        return (ImmutableList) this.f13328e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m22170k() {
        this.f13329f = (GraphQLPageInfo) super.a(this.f13329f, 2, GraphQLPageInfo.class);
        return this.f13329f;
    }

    public final int jK_() {
        return -306448333;
    }

    public final GraphQLVisitableModel m22167a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLPageInfo graphQLPageInfo;
        h();
        if (m22169j() != null) {
            Builder a = ModelHelper.a(m22169j(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLTimelineAppCollectionsConnection graphQLTimelineAppCollectionsConnection = (GraphQLTimelineAppCollectionsConnection) ModelHelper.a(null, this);
                graphQLTimelineAppCollectionsConnection.f13328e = a.b();
                graphQLVisitableModel = graphQLTimelineAppCollectionsConnection;
                if (m22170k() != null) {
                    graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m22170k());
                    if (m22170k() != graphQLPageInfo) {
                        graphQLVisitableModel = (GraphQLTimelineAppCollectionsConnection) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13329f = graphQLPageInfo;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m22170k() != null) {
            graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m22170k());
            if (m22170k() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLTimelineAppCollectionsConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13329f = graphQLPageInfo;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLTimelineAppCollectionsConnection() {
        super(4);
    }

    public final void m22168a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13327d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m22166a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22169j());
        int a2 = ModelHelper.a(flatBufferBuilder, m22170k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m22165a(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimelineAppCollectionsConnection(Parcel parcel) {
        super(4);
        this.f13327d = parcel.readInt();
        this.f13328e = ImmutableListHelper.a(parcel.readArrayList(GraphQLTimelineAppCollection.class.getClassLoader()));
        this.f13329f = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22165a());
        parcel.writeList(m22169j());
        parcel.writeValue(m22170k());
    }
}
