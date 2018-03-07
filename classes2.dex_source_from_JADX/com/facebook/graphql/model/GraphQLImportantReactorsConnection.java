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
/* compiled from: live_topic_composer_nux */
public final class GraphQLImportantReactorsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLImportantReactorsConnection> CREATOR = new C08041();
    public List<GraphQLActor> f17317d;

    /* compiled from: live_topic_composer_nux */
    final class C08041 implements Creator<GraphQLImportantReactorsConnection> {
        C08041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLImportantReactorsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLImportantReactorsConnection[i];
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLActor> m24386a() {
        this.f17317d = super.m9944a(this.f17317d, 0, GraphQLActor.class);
        return (ImmutableList) this.f17317d;
    }

    public final int jK_() {
        return 376615537;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24386a() != null) {
            Builder a = ModelHelper.m23097a(m24386a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLImportantReactorsConnection) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17317d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLImportantReactorsConnection() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24386a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLImportantReactorsConnection(Parcel parcel) {
        super(2);
        this.f17317d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActor.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24386a());
    }

    public GraphQLImportantReactorsConnection(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17317d = builder.d;
    }
}
