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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: layout_inflater */
public final class GraphQLUserWorkExperiencesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLUserWorkExperiencesConnection> CREATOR = new 1();
    public List<GraphQLUserWorkExperiencesEdge> f17750d;
    public List<GraphQLWorkExperience> f17751e;

    @FieldOffset
    public final ImmutableList<GraphQLUserWorkExperiencesEdge> m24974a() {
        this.f17750d = super.m9944a(this.f17750d, 0, GraphQLUserWorkExperiencesEdge.class);
        return (ImmutableList) this.f17750d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLWorkExperience> m24975j() {
        this.f17751e = super.m9944a(this.f17751e, 1, GraphQLWorkExperience.class);
        return (ImmutableList) this.f17751e;
    }

    public final int jK_() {
        return -1378049077;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24974a() != null) {
            a = ModelHelper.m23097a(m24974a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLUserWorkExperiencesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17750d = a.m1068b();
            }
        }
        if (m24975j() != null) {
            a = ModelHelper.m23097a(m24975j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLUserWorkExperiencesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17751e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLUserWorkExperiencesConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24974a());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24975j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLUserWorkExperiencesConnection(Parcel parcel) {
        super(3);
        this.f17750d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUserWorkExperiencesEdge.class.getClassLoader()));
        this.f17751e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLWorkExperience.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24974a());
        parcel.writeList(m24975j());
    }
}
