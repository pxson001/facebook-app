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
import com.facebook.graphql.deserializers.GraphQLSportsDataMatchDataFactDeserializer;
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
/* compiled from: Unmatched first part of surrogate pair (0x */
public final class GraphQLSportsDataMatchDataFact extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSportsDataMatchDataFact> CREATOR = new C12331();
    @Nullable
    GraphQLPage f13058d;
    @Nullable
    String f13059e;
    @Nullable
    String f13060f;
    @Nullable
    String f13061g;
    long f13062h;
    @Nullable
    GraphQLFeedback f13063i;
    @Nullable
    String f13064j;
    @Nullable
    String f13065k;
    @Nullable
    String f13066l;
    int f13067m;
    @Nullable
    GraphQLStory f13068n;
    @Nullable
    String f13069o;
    @Nullable
    GraphQLComment f13070p;

    /* compiled from: Unmatched first part of surrogate pair (0x */
    final class C12331 implements Creator<GraphQLSportsDataMatchDataFact> {
        C12331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSportsDataMatchDataFact(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSportsDataMatchDataFact[i];
        }
    }

    /* compiled from: Unmatched first part of surrogate pair (0x */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchDataFact.class, new Deserializer());
        }

        public Object m21761a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSportsDataMatchDataFactDeserializer.m5928a(jsonParser, (short) 79);
            Object graphQLSportsDataMatchDataFact = new GraphQLSportsDataMatchDataFact();
            ((BaseModel) graphQLSportsDataMatchDataFact).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSportsDataMatchDataFact instanceof Postprocessable) {
                return ((Postprocessable) graphQLSportsDataMatchDataFact).a();
            }
            return graphQLSportsDataMatchDataFact;
        }
    }

    /* compiled from: Unmatched first part of surrogate pair (0x */
    public final class Serializer extends JsonSerializer<GraphQLSportsDataMatchDataFact> {
        public final void m21762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSportsDataMatchDataFact graphQLSportsDataMatchDataFact = (GraphQLSportsDataMatchDataFact) obj;
            GraphQLSportsDataMatchDataFactDeserializer.m5929b(graphQLSportsDataMatchDataFact.w_(), graphQLSportsDataMatchDataFact.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSportsDataMatchDataFact.class, new Serializer());
            FbSerializerProvider.a(GraphQLSportsDataMatchDataFact.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m21767j() {
        this.f13058d = (GraphQLPage) super.a(this.f13058d, 0, GraphQLPage.class);
        return this.f13058d;
    }

    @FieldOffset
    @Nullable
    public final String m21768k() {
        this.f13059e = super.a(this.f13059e, 1);
        return this.f13059e;
    }

    @FieldOffset
    @Nullable
    public final String m21769l() {
        this.f13060f = super.a(this.f13060f, 2);
        return this.f13060f;
    }

    @FieldOffset
    @Nullable
    public final String m21770m() {
        this.f13061g = super.a(this.f13061g, 3);
        return this.f13061g;
    }

    @FieldOffset
    public final long m21771n() {
        a(0, 4);
        return this.f13062h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m21772o() {
        this.f13063i = (GraphQLFeedback) super.a(this.f13063i, 5, GraphQLFeedback.class);
        return this.f13063i;
    }

    @FieldOffset
    @Nullable
    public final String m21773p() {
        this.f13064j = super.a(this.f13064j, 6);
        return this.f13064j;
    }

    @FieldOffset
    @Nullable
    public final String m21774q() {
        this.f13065k = super.a(this.f13065k, 7);
        return this.f13065k;
    }

    @FieldOffset
    @Nullable
    public final String m21775r() {
        this.f13066l = super.a(this.f13066l, 8);
        return this.f13066l;
    }

    @FieldOffset
    public final int m21776s() {
        a(1, 1);
        return this.f13067m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m21777t() {
        this.f13068n = (GraphQLStory) super.a(this.f13068n, 10, GraphQLStory.class);
        return this.f13068n;
    }

    @FieldOffset
    @Nullable
    public final String m21778u() {
        this.f13069o = super.a(this.f13069o, 11);
        return this.f13069o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLComment m21779v() {
        this.f13070p = (GraphQLComment) super.a(this.f13070p, 12, GraphQLComment.class);
        return this.f13070p;
    }

    @Nullable
    public final String m21765a() {
        return m21774q();
    }

    public final int jK_() {
        return 2006245554;
    }

    public final GraphQLVisitableModel m21764a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21767j() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m21767j());
            if (m21767j() != graphQLPage) {
                graphQLVisitableModel = (GraphQLSportsDataMatchDataFact) ModelHelper.a(null, this);
                graphQLVisitableModel.f13058d = graphQLPage;
            }
        }
        if (m21772o() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m21772o());
            if (m21772o() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLSportsDataMatchDataFact) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13063i = graphQLFeedback;
            }
        }
        if (m21779v() != null) {
            GraphQLComment graphQLComment = (GraphQLComment) graphQLModelMutatingVisitor.b(m21779v());
            if (m21779v() != graphQLComment) {
                graphQLVisitableModel = (GraphQLSportsDataMatchDataFact) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13070p = graphQLComment;
            }
        }
        if (m21777t() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m21777t());
            if (m21777t() != graphQLStory) {
                graphQLVisitableModel = (GraphQLSportsDataMatchDataFact) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13068n = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSportsDataMatchDataFact() {
        super(14);
    }

    public final void m21766a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13062h = mutableFlatBuffer.a(i, 4, 0);
        this.f13067m = mutableFlatBuffer.a(i, 9, 0);
    }

    public final int m21763a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21767j());
        int b = flatBufferBuilder.b(m21768k());
        int b2 = flatBufferBuilder.b(m21769l());
        int b3 = flatBufferBuilder.b(m21770m());
        int a2 = ModelHelper.a(flatBufferBuilder, m21772o());
        int b4 = flatBufferBuilder.b(m21773p());
        int b5 = flatBufferBuilder.b(m21774q());
        int b6 = flatBufferBuilder.b(m21775r());
        int a3 = ModelHelper.a(flatBufferBuilder, m21777t());
        int b7 = flatBufferBuilder.b(m21778u());
        int a4 = ModelHelper.a(flatBufferBuilder, m21779v());
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.a(4, m21771n(), 0);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, b4);
        flatBufferBuilder.b(7, b5);
        flatBufferBuilder.b(8, b6);
        flatBufferBuilder.a(9, m21776s(), 0);
        flatBufferBuilder.b(10, a3);
        flatBufferBuilder.b(11, b7);
        flatBufferBuilder.b(12, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSportsDataMatchDataFact(Parcel parcel) {
        super(14);
        this.f13058d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f13059e = parcel.readString();
        this.f13060f = parcel.readString();
        this.f13061g = parcel.readString();
        this.f13062h = parcel.readLong();
        this.f13063i = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f13064j = parcel.readString();
        this.f13065k = parcel.readString();
        this.f13070p = (GraphQLComment) parcel.readValue(GraphQLComment.class.getClassLoader());
        this.f13066l = parcel.readString();
        this.f13067m = parcel.readInt();
        this.f13068n = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f13069o = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21767j());
        parcel.writeString(m21768k());
        parcel.writeString(m21769l());
        parcel.writeString(m21770m());
        parcel.writeLong(m21771n());
        parcel.writeValue(m21772o());
        parcel.writeString(m21773p());
        parcel.writeString(m21774q());
        parcel.writeValue(m21779v());
        parcel.writeString(m21775r());
        parcel.writeInt(m21776s());
        parcel.writeValue(m21777t());
        parcel.writeString(m21778u());
    }
}
