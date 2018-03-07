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
/* compiled from: live_video_state */
public final class GraphQLVideoGuidedTour extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoGuidedTour> CREATOR = new 1();
    public List<GraphQLVideoGuidedTourKeyframe> f17261d;

    @FieldOffset
    public final ImmutableList<GraphQLVideoGuidedTourKeyframe> m24323a() {
        this.f17261d = super.m9944a(this.f17261d, 0, GraphQLVideoGuidedTourKeyframe.class);
        return (ImmutableList) this.f17261d;
    }

    public final int jK_() {
        return 302897691;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24323a() != null) {
            Builder a = ModelHelper.m23097a(m24323a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLVideoGuidedTour) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17261d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLVideoGuidedTour() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24323a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLVideoGuidedTour(Parcel parcel) {
        super(2);
        this.f17261d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLVideoGuidedTourKeyframe.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24323a());
    }

    public GraphQLVideoGuidedTour(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17261d = builder.d;
    }
}
