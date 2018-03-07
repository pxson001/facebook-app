package com.facebook.privacy.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.FetchComposerPostPrivacyFollowUpInfoModels$ComposerInlinePrivacySurveyFieldsModel.Deserializer;
import com.facebook.privacy.protocol.FetchComposerPostPrivacyFollowUpInfoModels$ComposerInlinePrivacySurveyFieldsModel.Serializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1070427783)
@JsonSerialize(using = Serializer.class)
/* compiled from: record_self_video */
public final class C0164x41da8659 extends BaseModel implements GraphQLVisitableModel {
    private boolean f3545d;
    @Nullable
    private GraphQLPrivacyOption f3546e;
    @Nullable
    private GraphQLPrivacyOption f3547f;
    @Nullable
    private GraphQLPrivacyOption f3548g;

    public C0164x41da8659() {
        super(4);
    }

    public final boolean m3936a() {
        a(0, 0);
        return this.f3545d;
    }

    @Nullable
    public final GraphQLPrivacyOption m3937j() {
        this.f3546e = (GraphQLPrivacyOption) super.a(this.f3546e, 1, GraphQLPrivacyOption.class);
        return this.f3546e;
    }

    @Nullable
    public final GraphQLPrivacyOption m3938k() {
        this.f3547f = (GraphQLPrivacyOption) super.a(this.f3547f, 2, GraphQLPrivacyOption.class);
        return this.f3547f;
    }

    @Nullable
    public final GraphQLPrivacyOption m3939l() {
        this.f3548g = (GraphQLPrivacyOption) super.a(this.f3548g, 3, GraphQLPrivacyOption.class);
        return this.f3548g;
    }

    public final int jK_() {
        return 1658610306;
    }

    public final GraphQLVisitableModel m3934a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPrivacyOption graphQLPrivacyOption;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3937j() != null) {
            graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m3937j());
            if (m3937j() != graphQLPrivacyOption) {
                graphQLVisitableModel = (C0164x41da8659) ModelHelper.a(null, this);
                graphQLVisitableModel.f3546e = graphQLPrivacyOption;
            }
        }
        if (m3938k() != null) {
            graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m3938k());
            if (m3938k() != graphQLPrivacyOption) {
                graphQLVisitableModel = (C0164x41da8659) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3547f = graphQLPrivacyOption;
            }
        }
        if (m3939l() != null) {
            graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m3939l());
            if (m3939l() != graphQLPrivacyOption) {
                graphQLVisitableModel = (C0164x41da8659) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3548g = graphQLPrivacyOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3933a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3937j());
        int a2 = ModelHelper.a(flatBufferBuilder, m3938k());
        int a3 = ModelHelper.a(flatBufferBuilder, m3939l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, this.f3545d);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public final void m3935a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3545d = mutableFlatBuffer.a(i, 0);
    }
}
