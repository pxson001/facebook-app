package com.facebook.controller.mutation.util;

import com.facebook.api.graphql.commentservice.C0960xbda8dacc;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateFeedbackFieldsModel;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateFeedbackFieldsModel.Builder;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceShimmedMutation.AddCommentString;
import com.facebook.api.ufiservices.common.AddCommentParams;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.shimmedcalls.CommentCreateShimInputData;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: account_user */
public class CommentsServiceHelper {
    private static CommentCreateShimInputData m19740a(AddCommentParams addCommentParams) {
        CommentCreateShimInputData commentCreateShimInputData = new CommentCreateShimInputData();
        commentCreateShimInputData.m22638a(addCommentParams.f10276a);
        commentCreateShimInputData.m22640b(addCommentParams.f10277b);
        commentCreateShimInputData.m22647i(addCommentParams.f10282g);
        if (!Strings.isNullOrEmpty(addCommentParams.f10278c)) {
            commentCreateShimInputData.m22641c(addCommentParams.f10278c);
        }
        if (addCommentParams.f10281f != null) {
            ImmutableList e = addCommentParams.f10281f.e();
            if (e != null && e.size() > 0) {
                commentCreateShimInputData.m22642d(JSONUtil.b(e).toString());
            }
            Object f = addCommentParams.f10281f.f();
            if (!StringUtil.a(f)) {
                commentCreateShimInputData.m22643e(f);
            }
            f = addCommentParams.f10281f.a();
            if (!StringUtil.a(f)) {
                commentCreateShimInputData.m22644f(f);
            }
        }
        if (addCommentParams.f10279d != null) {
            commentCreateShimInputData.m22645g(addCommentParams.f10279d);
        }
        if (!(addCommentParams.f10284i == null || addCommentParams.f10283h == null)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threaded_comments", addCommentParams.f10283h);
                jSONObject.put("comment_post_return_type", addCommentParams.f10284i);
                commentCreateShimInputData.m22646h(jSONObject.toString());
            } catch (Throwable e2) {
                throw Throwables.propagate(e2);
            }
        }
        if (!addCommentParams.f10285j || addCommentParams.f10286k <= 0) {
            commentCreateShimInputData.m22639b(Integer.valueOf(addCommentParams.f10286k));
        } else {
            commentCreateShimInputData.m22637a(Integer.valueOf(addCommentParams.f10286k));
        }
        return commentCreateShimInputData;
    }

    public static MutationRequest<CommentCreateShimMutationFragmentModel> m19739a(AddCommentParams addCommentParams, boolean z) {
        String H;
        String str;
        ImmutableSet of;
        MutationRequest<CommentCreateShimMutationFragmentModel> mutationRequest;
        CommentCreateShimInputData a = m19740a(addCommentParams);
        C0960xbda8dacc c0960xbda8dacc = new C0960xbda8dacc();
        Builder builder = new Builder();
        builder.f9223a = addCommentParams.f10276a;
        builder = builder;
        builder.f9224b = addCommentParams.f10277b;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f9223a);
        int b2 = flatBufferBuilder.b(builder.f9224b);
        int a2 = ModelHelper.a(flatBufferBuilder, builder.f9225c);
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        c0960xbda8dacc.f9234b = new CommentCreateFeedbackFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        c0960xbda8dacc = c0960xbda8dacc;
        c0960xbda8dacc.f9233a = addCommentParams.f10280e;
        CommentCreateShimMutationFragmentModel a3 = c0960xbda8dacc.m15710a();
        GraphQlQueryString addCommentString = new AddCommentString();
        addCommentString.a("input", a);
        addCommentString.a("include_replies_in_total_count", Boolean.toString(z));
        GraphQLComment graphQLComment = addCommentParams.f10280e;
        if (graphQLComment != null) {
            GraphQLActor r = graphQLComment.r();
            if (r != null) {
                H = r.H();
                str = H;
                if (str == null) {
                    of = ImmutableSet.of(str);
                } else {
                    of = RegularImmutableSet.a;
                }
                mutationRequest = new MutationRequest(addCommentString, of);
                mutationRequest.a(a3);
                return mutationRequest;
            }
        }
        H = null;
        str = H;
        if (str == null) {
            of = RegularImmutableSet.a;
        } else {
            of = ImmutableSet.of(str);
        }
        mutationRequest = new MutationRequest(addCommentString, of);
        mutationRequest.a(a3);
        return mutationRequest;
    }
}
