package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: install_referrer_with_campaign */
public final class GraphQLFaceBox extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFaceBox> CREATOR = new C07871();
    @Nullable
    GraphQLVect2 f19810d;
    @Nullable
    GraphQLVect2 f19811e;
    @Nullable
    String f19812f;
    @Nullable
    GraphQLFaceBoxTagSuggestionsConnection f19813g;
    @Nullable
    String f19814h;

    /* compiled from: install_referrer_with_campaign */
    final class C07871 implements Creator<GraphQLFaceBox> {
        C07871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFaceBox(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFaceBox[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m27524j() {
        this.f19810d = (GraphQLVect2) super.m9947a(this.f19810d, 0, GraphQLVect2.class);
        return this.f19810d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m27525k() {
        this.f19811e = (GraphQLVect2) super.m9947a(this.f19811e, 1, GraphQLVect2.class);
        return this.f19811e;
    }

    @FieldOffset
    @Nullable
    public final String m27526l() {
        this.f19812f = super.m9948a(this.f19812f, 2);
        return this.f19812f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFaceBoxTagSuggestionsConnection m27527m() {
        this.f19813g = (GraphQLFaceBoxTagSuggestionsConnection) super.m9947a(this.f19813g, 3, GraphQLFaceBoxTagSuggestionsConnection.class);
        return this.f19813g;
    }

    @FieldOffset
    @Nullable
    public final String m27528n() {
        this.f19814h = super.m9948a(this.f19814h, 4);
        return this.f19814h;
    }

    @Nullable
    public final String mo2834a() {
        return m27526l();
    }

    public final int jK_() {
        return 572280334;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVect2 graphQLVect2;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27524j() != null) {
            graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.mo2928b(m27524j());
            if (m27524j() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLFaceBox) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19810d = graphQLVect2;
            }
        }
        if (m27525k() != null) {
            graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.mo2928b(m27525k());
            if (m27525k() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLFaceBox) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19811e = graphQLVect2;
            }
        }
        if (m27527m() != null) {
            GraphQLFaceBoxTagSuggestionsConnection graphQLFaceBoxTagSuggestionsConnection = (GraphQLFaceBoxTagSuggestionsConnection) graphQLModelMutatingVisitor.mo2928b(m27527m());
            if (m27527m() != graphQLFaceBoxTagSuggestionsConnection) {
                graphQLVisitableModel = (GraphQLFaceBox) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19813g = graphQLFaceBoxTagSuggestionsConnection;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFaceBox() {
        super(6);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27524j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27525k());
        int b = flatBufferBuilder.m21502b(m27526l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27527m());
        int b2 = flatBufferBuilder.m21502b(m27528n());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFaceBox(Parcel parcel) {
        super(6);
        this.f19810d = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        this.f19811e = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        this.f19812f = parcel.readString();
        this.f19813g = (GraphQLFaceBoxTagSuggestionsConnection) parcel.readValue(GraphQLFaceBoxTagSuggestionsConnection.class.getClassLoader());
        this.f19814h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27524j());
        parcel.writeValue(m27525k());
        parcel.writeString(m27526l());
        parcel.writeValue(m27527m());
        parcel.writeString(m27528n());
    }

    public GraphQLFaceBox(Builder builder) {
        super(6);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f19810d = builder.d;
        this.f19811e = builder.e;
        this.f19812f = builder.f;
        this.f19813g = builder.g;
        this.f19814h = builder.h;
    }
}
