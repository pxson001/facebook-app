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
import com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisItemDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
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
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WHITELISTED_SUGGESTION */
public final class GraphQLPhrasesAnalysisItem extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLPhrasesAnalysisItem> CREATOR = new C11741();
    public int f12579d;
    @Nullable
    public String f12580e;
    @Nullable
    public GraphQLGraphSearchQuery f12581f;
    @Nullable
    public String f12582g;
    public int f12583h;
    public int f12584i;
    @Nullable
    public GraphQLProfile f12585j;
    @Nullable
    public String f12586k;
    @Nullable
    public String f12587l;
    @Nullable
    public String f12588m;

    /* compiled from: WHITELISTED_SUGGESTION */
    final class C11741 implements Creator<GraphQLPhrasesAnalysisItem> {
        C11741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhrasesAnalysisItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhrasesAnalysisItem[i];
        }
    }

    /* compiled from: WHITELISTED_SUGGESTION */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysisItem.class, new Deserializer());
        }

        public Object m20789a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPhrasesAnalysisItemDeserializer.m5630a(jsonParser, (short) 94);
            Object graphQLPhrasesAnalysisItem = new GraphQLPhrasesAnalysisItem();
            ((BaseModel) graphQLPhrasesAnalysisItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPhrasesAnalysisItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLPhrasesAnalysisItem).a();
            }
            return graphQLPhrasesAnalysisItem;
        }
    }

    /* compiled from: WHITELISTED_SUGGESTION */
    public final class Serializer extends JsonSerializer<GraphQLPhrasesAnalysisItem> {
        public final void m20790a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem = (GraphQLPhrasesAnalysisItem) obj;
            GraphQLPhrasesAnalysisItemDeserializer.m5631a(graphQLPhrasesAnalysisItem.w_(), graphQLPhrasesAnalysisItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPhrasesAnalysisItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLPhrasesAnalysisItem.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m20795j() {
        a(0, 0);
        return this.f12579d;
    }

    @FieldOffset
    @Nullable
    public final String m20796k() {
        this.f12580e = super.a(this.f12580e, 1);
        return this.f12580e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQuery m20797l() {
        this.f12581f = (GraphQLGraphSearchQuery) super.a(this.f12581f, 2, GraphQLGraphSearchQuery.class);
        return this.f12581f;
    }

    @FieldOffset
    @Nullable
    public final String m20798m() {
        this.f12582g = super.a(this.f12582g, 3);
        return this.f12582g;
    }

    @FieldOffset
    public final int m20799n() {
        a(0, 4);
        return this.f12583h;
    }

    @FieldOffset
    public final int m20800o() {
        a(0, 5);
        return this.f12584i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m20801p() {
        this.f12585j = (GraphQLProfile) super.a(this.f12585j, 6, GraphQLProfile.class);
        return this.f12585j;
    }

    @FieldOffset
    @Nullable
    public final String m20802q() {
        this.f12586k = super.a(this.f12586k, 7);
        return this.f12586k;
    }

    @FieldOffset
    @Nullable
    public final String m20803r() {
        this.f12587l = super.a(this.f12587l, 8);
        return this.f12587l;
    }

    @FieldOffset
    @Nullable
    public final String m20804s() {
        this.f12588m = super.a(this.f12588m, 9);
        return this.f12588m;
    }

    @Nullable
    public final String m20793a() {
        return m20796k();
    }

    public final int jK_() {
        return -991219223;
    }

    public final GraphQLVisitableModel m20792a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20797l() != null) {
            GraphQLGraphSearchQuery graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) graphQLModelMutatingVisitor.b(m20797l());
            if (m20797l() != graphQLGraphSearchQuery) {
                graphQLVisitableModel = (GraphQLPhrasesAnalysisItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f12581f = graphQLGraphSearchQuery;
            }
        }
        if (m20801p() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m20801p());
            if (m20801p() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLPhrasesAnalysisItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12585j = graphQLProfile;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhrasesAnalysisItem() {
        super(11);
    }

    public final void m20794a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12579d = mutableFlatBuffer.a(i, 0, 0);
        this.f12583h = mutableFlatBuffer.a(i, 4, 0);
        this.f12584i = mutableFlatBuffer.a(i, 5, 0);
    }

    public final int m20791a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20796k());
        int a = ModelHelper.a(flatBufferBuilder, m20797l());
        int b2 = flatBufferBuilder.b(m20798m());
        int a2 = ModelHelper.a(flatBufferBuilder, m20801p());
        int b3 = flatBufferBuilder.b(m20802q());
        int b4 = flatBufferBuilder.b(m20803r());
        int b5 = flatBufferBuilder.b(m20804s());
        flatBufferBuilder.c(10);
        flatBufferBuilder.a(0, m20795j(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.a(4, m20799n(), 0);
        flatBufferBuilder.a(5, m20800o(), 0);
        flatBufferBuilder.b(6, a2);
        flatBufferBuilder.b(7, b3);
        flatBufferBuilder.b(8, b4);
        flatBufferBuilder.b(9, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPhrasesAnalysisItem(Parcel parcel) {
        super(11);
        this.f12579d = parcel.readInt();
        this.f12580e = parcel.readString();
        this.f12581f = (GraphQLGraphSearchQuery) parcel.readValue(GraphQLGraphSearchQuery.class.getClassLoader());
        this.f12582g = parcel.readString();
        this.f12583h = parcel.readInt();
        this.f12584i = parcel.readInt();
        this.f12585j = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f12586k = parcel.readString();
        this.f12587l = parcel.readString();
        this.f12588m = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m20795j());
        parcel.writeString(m20796k());
        parcel.writeValue(m20797l());
        parcel.writeString(m20798m());
        parcel.writeInt(m20799n());
        parcel.writeInt(m20800o());
        parcel.writeValue(m20801p());
        parcel.writeString(m20802q());
        parcel.writeString(m20803r());
        parcel.writeString(m20804s());
    }
}
