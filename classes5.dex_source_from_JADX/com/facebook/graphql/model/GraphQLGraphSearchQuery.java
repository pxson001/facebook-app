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
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryDeserializer;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: getBluetoothOnTime */
public final class GraphQLGraphSearchQuery extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchQuery> CREATOR = new C03741();
    @Deprecated
    @Nullable
    GraphQLGraphSearchQuery f4057d;
    @Nullable
    String f4058e;
    @Nullable
    GraphQLGraphSearchModulesConnection f4059f;
    @Nullable
    String f4060g;
    List<String> f4061h;
    List<GraphQLGraphSearchQueryFilterGroup> f4062i;
    @Nullable
    String f4063j;
    @Nullable
    String f4064k;
    @Nullable
    GraphQLGraphSearchQueryTitle f4065l;
    @Nullable
    GraphQLGraphSearchResultsConnection f4066m;
    List<GraphQLGraphSearchResultsDisplayStyle> f4067n;
    @Nullable
    String f4068o;
    List<GraphQLGraphSearchQueryFilterGroup> f4069p;
    @Nullable
    GraphQLProfile f4070q;
    @Nullable
    String f4071r;
    @Nullable
    String f4072s;
    @Nullable
    String f4073t;
    int f4074u;

    /* compiled from: getBluetoothOnTime */
    final class C03741 implements Creator<GraphQLGraphSearchQuery> {
        C03741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchQuery(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchQuery[i];
        }
    }

    /* compiled from: getBluetoothOnTime */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQuery.class, new Deserializer());
        }

        public Object m8174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchQueryDeserializer.m5084a(jsonParser, (short) 95);
            Object graphQLGraphSearchQuery = new GraphQLGraphSearchQuery();
            ((BaseModel) graphQLGraphSearchQuery).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchQuery instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchQuery).a();
            }
            return graphQLGraphSearchQuery;
        }
    }

    /* compiled from: getBluetoothOnTime */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchQuery> {
        public final void m8175a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchQuery graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) obj;
            GraphQLGraphSearchQueryDeserializer.m5085a(graphQLGraphSearchQuery.w_(), graphQLGraphSearchQuery.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchQuery.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchQuery.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQuery m8181j() {
        this.f4057d = (GraphQLGraphSearchQuery) super.a(this.f4057d, 0, GraphQLGraphSearchQuery.class);
        return this.f4057d;
    }

    @FieldOffset
    @Nullable
    public final String m8182k() {
        this.f4058e = super.a(this.f4058e, 1);
        return this.f4058e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchModulesConnection m8183l() {
        this.f4059f = (GraphQLGraphSearchModulesConnection) super.a(this.f4059f, 2, GraphQLGraphSearchModulesConnection.class);
        return this.f4059f;
    }

    @FieldOffset
    @Nullable
    public final String m8184m() {
        this.f4060g = super.a(this.f4060g, 3);
        return this.f4060g;
    }

    @FieldOffset
    public final ImmutableList<String> m8185n() {
        this.f4061h = super.a(this.f4061h, 4);
        return (ImmutableList) this.f4061h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchQueryFilterGroup> m8186o() {
        this.f4062i = super.a(this.f4062i, 5, GraphQLGraphSearchQueryFilterGroup.class);
        return (ImmutableList) this.f4062i;
    }

    @FieldOffset
    @Nullable
    public final String m8187p() {
        this.f4063j = super.a(this.f4063j, 6);
        return this.f4063j;
    }

    @FieldOffset
    @Nullable
    public final String m8188q() {
        this.f4064k = super.a(this.f4064k, 7);
        return this.f4064k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQueryTitle m8189r() {
        this.f4065l = (GraphQLGraphSearchQueryTitle) super.a(this.f4065l, 8, GraphQLGraphSearchQueryTitle.class);
        return this.f4065l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchResultsConnection m8190s() {
        this.f4066m = (GraphQLGraphSearchResultsConnection) super.a(this.f4066m, 9, GraphQLGraphSearchResultsConnection.class);
        return this.f4066m;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchResultsDisplayStyle> m8191t() {
        this.f4067n = super.b(this.f4067n, 10, GraphQLGraphSearchResultsDisplayStyle.class);
        return (ImmutableList) this.f4067n;
    }

    @FieldOffset
    @Nullable
    public final String m8192u() {
        this.f4068o = super.a(this.f4068o, 11);
        return this.f4068o;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchQueryFilterGroup> m8193v() {
        this.f4069p = super.a(this.f4069p, 12, GraphQLGraphSearchQueryFilterGroup.class);
        return (ImmutableList) this.f4069p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m8194w() {
        this.f4070q = (GraphQLProfile) super.a(this.f4070q, 13, GraphQLProfile.class);
        return this.f4070q;
    }

    @FieldOffset
    @Nullable
    public final String m8195x() {
        this.f4071r = super.a(this.f4071r, 14);
        return this.f4071r;
    }

    @FieldOffset
    @Nullable
    public final String m8196y() {
        this.f4072s = super.a(this.f4072s, 15);
        return this.f4072s;
    }

    @FieldOffset
    @Nullable
    public final String m8197z() {
        this.f4073t = super.a(this.f4073t, 16);
        return this.f4073t;
    }

    @FieldOffset
    public final int m8176A() {
        a(2, 2);
        return this.f4074u;
    }

    @Nullable
    public final String m8179a() {
        return m8182k();
    }

    public final int jK_() {
        return -466486798;
    }

    public final GraphQLVisitableModel m8178a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLGraphSearchQuery graphQLGraphSearchQuery;
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8181j() != null) {
            graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) graphQLModelMutatingVisitor.b(m8181j());
            if (m8181j() != graphQLGraphSearchQuery) {
                graphQLVisitableModel = (GraphQLGraphSearchQuery) ModelHelper.a(null, this);
                graphQLVisitableModel.f4057d = graphQLGraphSearchQuery;
            }
        }
        if (m8183l() != null) {
            GraphQLGraphSearchModulesConnection graphQLGraphSearchModulesConnection = (GraphQLGraphSearchModulesConnection) graphQLModelMutatingVisitor.b(m8183l());
            if (m8183l() != graphQLGraphSearchModulesConnection) {
                graphQLVisitableModel = (GraphQLGraphSearchQuery) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4059f = graphQLGraphSearchModulesConnection;
            }
        }
        if (m8186o() != null) {
            a = ModelHelper.a(m8186o(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGraphSearchQuery.f4062i = a.b();
                graphQLVisitableModel = graphQLGraphSearchQuery;
            }
        }
        if (m8189r() != null) {
            GraphQLGraphSearchQueryTitle graphQLGraphSearchQueryTitle = (GraphQLGraphSearchQueryTitle) graphQLModelMutatingVisitor.b(m8189r());
            if (m8189r() != graphQLGraphSearchQueryTitle) {
                graphQLVisitableModel = (GraphQLGraphSearchQuery) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4065l = graphQLGraphSearchQueryTitle;
            }
        }
        if (m8190s() != null) {
            GraphQLGraphSearchResultsConnection graphQLGraphSearchResultsConnection = (GraphQLGraphSearchResultsConnection) graphQLModelMutatingVisitor.b(m8190s());
            if (m8190s() != graphQLGraphSearchResultsConnection) {
                graphQLVisitableModel = (GraphQLGraphSearchQuery) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4066m = graphQLGraphSearchResultsConnection;
            }
        }
        if (m8193v() != null) {
            a = ModelHelper.a(m8193v(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGraphSearchQuery.f4069p = a.b();
                graphQLVisitableModel = graphQLGraphSearchQuery;
            }
        }
        if (m8194w() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m8194w());
            if (m8194w() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLGraphSearchQuery) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4070q = graphQLProfile;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchQuery() {
        super(20);
    }

    public final void m8180a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4074u = mutableFlatBuffer.a(i, 18, 0);
    }

    public final int m8177a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8181j());
        int b = flatBufferBuilder.b(m8182k());
        int a2 = ModelHelper.a(flatBufferBuilder, m8183l());
        int b2 = flatBufferBuilder.b(m8184m());
        int c = flatBufferBuilder.c(m8185n());
        int a3 = ModelHelper.a(flatBufferBuilder, m8186o());
        int b3 = flatBufferBuilder.b(m8187p());
        int b4 = flatBufferBuilder.b(m8188q());
        int a4 = ModelHelper.a(flatBufferBuilder, m8189r());
        int a5 = ModelHelper.a(flatBufferBuilder, m8190s());
        int e = flatBufferBuilder.e(m8191t());
        int b5 = flatBufferBuilder.b(m8192u());
        int a6 = ModelHelper.a(flatBufferBuilder, m8193v());
        int a7 = ModelHelper.a(flatBufferBuilder, m8194w());
        int b6 = flatBufferBuilder.b(m8195x());
        int b7 = flatBufferBuilder.b(m8196y());
        int b8 = flatBufferBuilder.b(m8197z());
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, c);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, b3);
        flatBufferBuilder.b(7, b4);
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(9, a5);
        flatBufferBuilder.b(10, e);
        flatBufferBuilder.b(11, b5);
        flatBufferBuilder.b(12, a6);
        flatBufferBuilder.b(13, a7);
        flatBufferBuilder.b(14, b6);
        flatBufferBuilder.b(15, b7);
        flatBufferBuilder.b(16, b8);
        flatBufferBuilder.a(18, m8176A(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchQuery(Parcel parcel) {
        super(20);
        this.f4074u = parcel.readInt();
        this.f4057d = (GraphQLGraphSearchQuery) parcel.readValue(GraphQLGraphSearchQuery.class.getClassLoader());
        this.f4058e = parcel.readString();
        this.f4059f = (GraphQLGraphSearchModulesConnection) parcel.readValue(GraphQLGraphSearchModulesConnection.class.getClassLoader());
        this.f4060g = parcel.readString();
        this.f4061h = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4062i = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchQueryFilterGroup.class.getClassLoader()));
        this.f4063j = parcel.readString();
        this.f4064k = parcel.readString();
        this.f4073t = parcel.readString();
        this.f4065l = (GraphQLGraphSearchQueryTitle) parcel.readValue(GraphQLGraphSearchQueryTitle.class.getClassLoader());
        this.f4066m = (GraphQLGraphSearchResultsConnection) parcel.readValue(GraphQLGraphSearchResultsConnection.class.getClassLoader());
        this.f4067n = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchResultsDisplayStyle.class.getClassLoader()));
        this.f4068o = parcel.readString();
        this.f4069p = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchQueryFilterGroup.class.getClassLoader()));
        this.f4070q = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f4071r = parcel.readString();
        this.f4072s = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m8176A());
        parcel.writeValue(m8181j());
        parcel.writeString(m8182k());
        parcel.writeValue(m8183l());
        parcel.writeString(m8184m());
        parcel.writeList(m8185n());
        parcel.writeList(m8186o());
        parcel.writeString(m8187p());
        parcel.writeString(m8188q());
        parcel.writeString(m8197z());
        parcel.writeValue(m8189r());
        parcel.writeValue(m8190s());
        parcel.writeList(m8191t());
        parcel.writeString(m8192u());
        parcel.writeList(m8193v());
        parcel.writeValue(m8194w());
        parcel.writeString(m8195x());
        parcel.writeString(m8196y());
    }
}
