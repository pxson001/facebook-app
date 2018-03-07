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
/* compiled from: local_memory_write */
public final class GraphQLFundraiserCharity extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFundraiserCharity> CREATOR = new 1();
    @Nullable
    String f17040d;
    @Nullable
    GraphQLPage f17041e;
    @Nullable
    String f17042f;
    @Nullable
    String f17043g;

    @FieldOffset
    @Nullable
    public final String m24039j() {
        this.f17040d = super.m9948a(this.f17040d, 1);
        return this.f17040d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m24040k() {
        this.f17041e = (GraphQLPage) super.m9947a(this.f17041e, 2, GraphQLPage.class);
        return this.f17041e;
    }

    @FieldOffset
    @Nullable
    public final String m24041l() {
        this.f17042f = super.m9948a(this.f17042f, 3);
        return this.f17042f;
    }

    @FieldOffset
    @Nullable
    public final String m24042m() {
        this.f17043g = super.m9948a(this.f17043g, 4);
        return this.f17043g;
    }

    @Nullable
    public final String mo2834a() {
        return m24039j();
    }

    public final int jK_() {
        return 1023857133;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24040k() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.mo2928b(m24040k());
            if (m24040k() != graphQLPage) {
                graphQLVisitableModel = (GraphQLFundraiserCharity) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17041e = graphQLPage;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFundraiserCharity() {
        super(6);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24039j());
        int a = ModelHelper.m23093a(flatBufferBuilder, m24040k());
        int b2 = flatBufferBuilder.m21502b(m24041l());
        int b3 = flatBufferBuilder.m21502b(m24042m());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21507b(4, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFundraiserCharity(Parcel parcel) {
        super(6);
        this.f17040d = parcel.readString();
        this.f17041e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f17042f = parcel.readString();
        this.f17043g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24039j());
        parcel.writeValue(m24040k());
        parcel.writeString(m24041l());
        parcel.writeString(m24042m());
    }
}
