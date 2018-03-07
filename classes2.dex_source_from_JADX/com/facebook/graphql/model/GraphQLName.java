package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces$DefaultNameFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: legacy_fetch_code */
public final class GraphQLName extends BaseModel implements TypeModel, CommonGraphQL2Interfaces$DefaultNameFields, GraphQLVisitableModel {
    public static final Creator<GraphQLName> CREATOR = new 1();
    @Nullable
    String f17680d;
    List<GraphQLNamePart> f17681e;
    @Nullable
    GraphQLName f17682f;
    @Nullable
    String f17683g;

    @FieldOffset
    @Nullable
    public final String m24873j() {
        this.f17680d = super.m9948a(this.f17680d, 0);
        return this.f17680d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLNamePart> mo2969a() {
        this.f17681e = super.m9944a(this.f17681e, 1, GraphQLNamePart.class);
        return (ImmutableList) this.f17681e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLName m24874k() {
        this.f17682f = (GraphQLName) super.m9947a(this.f17682f, 2, GraphQLName.class);
        return this.f17682f;
    }

    @FieldOffset
    @Nullable
    public final String s_() {
        this.f17683g = super.m9948a(this.f17683g, 3);
        return this.f17683g;
    }

    public final int jK_() {
        return 2420395;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLName graphQLName;
        GraphQLVisitableModel graphQLVisitableModel;
        m9958h();
        if (mo2969a() != null) {
            Builder a = ModelHelper.m23097a(mo2969a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLName = (GraphQLName) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLName.f17681e = a.m1068b();
                graphQLVisitableModel = graphQLName;
                if (m24874k() != null) {
                    graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(m24874k());
                    if (m24874k() != graphQLName) {
                        graphQLVisitableModel = (GraphQLName) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f17682f = graphQLName;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m24874k() != null) {
            graphQLName = (GraphQLName) graphQLModelMutatingVisitor.mo2928b(m24874k());
            if (m24874k() != graphQLName) {
                graphQLVisitableModel = (GraphQLName) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17682f = graphQLName;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLName() {
        super(5);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24873j());
        int a = ModelHelper.m23094a(flatBufferBuilder, mo2969a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24874k());
        int b2 = flatBufferBuilder.m21502b(s_());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLName(Parcel parcel) {
        super(5);
        this.f17680d = parcel.readString();
        this.f17681e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLNamePart.class.getClassLoader()));
        this.f17682f = (GraphQLName) parcel.readValue(GraphQLName.class.getClassLoader());
        this.f17683g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24873j());
        parcel.writeList(mo2969a());
        parcel.writeValue(m24874k());
        parcel.writeString(s_());
    }
}
