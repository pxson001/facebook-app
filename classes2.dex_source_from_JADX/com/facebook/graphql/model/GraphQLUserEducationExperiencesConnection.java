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
/* compiled from: lcau */
public final class GraphQLUserEducationExperiencesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLUserEducationExperiencesConnection> CREATOR = new 1();
    public List<GraphQLUserEducationExperiencesEdge> f17744d;
    public List<GraphQLEducationExperience> f17745e;

    @FieldOffset
    public final ImmutableList<GraphQLUserEducationExperiencesEdge> m24960a() {
        this.f17744d = super.m9944a(this.f17744d, 0, GraphQLUserEducationExperiencesEdge.class);
        return (ImmutableList) this.f17744d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLEducationExperience> m24961j() {
        this.f17745e = super.m9944a(this.f17745e, 1, GraphQLEducationExperience.class);
        return (ImmutableList) this.f17745e;
    }

    public final int jK_() {
        return 1010460682;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24960a() != null) {
            a = ModelHelper.m23097a(m24960a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLUserEducationExperiencesConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17744d = a.m1068b();
            }
        }
        if (m24961j() != null) {
            a = ModelHelper.m23097a(m24961j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLUserEducationExperiencesConnection) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17745e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLUserEducationExperiencesConnection() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24960a());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, m24961j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLUserEducationExperiencesConnection(Parcel parcel) {
        super(3);
        this.f17744d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLUserEducationExperiencesEdge.class.getClassLoader()));
        this.f17745e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLEducationExperience.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24960a());
        parcel.writeList(m24961j());
    }
}
