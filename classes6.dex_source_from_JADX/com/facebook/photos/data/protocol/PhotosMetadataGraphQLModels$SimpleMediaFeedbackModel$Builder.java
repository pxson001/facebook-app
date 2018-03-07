package com.facebook.photos.data.protocol;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: suggest_edits */
public final class PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$Builder {
    public boolean f3809a;
    public boolean f3810b;
    public boolean f3811c;
    public boolean f3812d;
    public boolean f3813e;
    public boolean f3814f;
    public boolean f3815g;
    public boolean f3816h;
    public boolean f3817i;
    @Nullable
    public String f3818j;
    @Nullable
    public ImportantReactorsModel f3819k;
    public boolean f3820l;
    @Nullable
    public String f3821m;
    @Nullable
    public PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$LikersModel f3822n;
    @Nullable
    public ReactorsModel f3823o;
    @Nullable
    public String f3824p;
    @Nullable
    public ImmutableList<SupportedReactionsModel> f3825q;
    @Nullable
    public C0220xee8e0a15 f3826r;
    @Nullable
    public TopReactionsModel f3827s;
    @Nullable
    public ViewerActsAsPersonModel f3828t;
    public int f3829u;

    public final SimpleMediaFeedbackModel m5335a() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(this.f3818j);
        int a = ModelHelper.a(flatBufferBuilder, this.f3819k);
        int b2 = flatBufferBuilder.b(this.f3821m);
        int a2 = ModelHelper.a(flatBufferBuilder, this.f3822n);
        int a3 = ModelHelper.a(flatBufferBuilder, this.f3823o);
        int b3 = flatBufferBuilder.b(this.f3824p);
        int a4 = ModelHelper.a(flatBufferBuilder, this.f3825q);
        int a5 = ModelHelper.a(flatBufferBuilder, this.f3826r);
        int a6 = ModelHelper.a(flatBufferBuilder, this.f3827s);
        int a7 = ModelHelper.a(flatBufferBuilder, this.f3828t);
        flatBufferBuilder.c(21);
        flatBufferBuilder.a(0, this.f3809a);
        flatBufferBuilder.a(1, this.f3810b);
        flatBufferBuilder.a(2, this.f3811c);
        flatBufferBuilder.a(3, this.f3812d);
        flatBufferBuilder.a(4, this.f3813e);
        flatBufferBuilder.a(5, this.f3814f);
        flatBufferBuilder.a(6, this.f3815g);
        flatBufferBuilder.a(7, this.f3816h);
        flatBufferBuilder.a(8, this.f3817i);
        flatBufferBuilder.b(9, b);
        flatBufferBuilder.b(10, a);
        flatBufferBuilder.a(11, this.f3820l);
        flatBufferBuilder.b(12, b2);
        flatBufferBuilder.b(13, a2);
        flatBufferBuilder.b(14, a3);
        flatBufferBuilder.b(15, b3);
        flatBufferBuilder.b(16, a4);
        flatBufferBuilder.b(17, a5);
        flatBufferBuilder.b(18, a6);
        flatBufferBuilder.b(19, a7);
        flatBufferBuilder.a(20, this.f3829u, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new SimpleMediaFeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}
