package com.facebook.composer.feedattachment.minutiae;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.composer.feedattachment.ComposerFeedAttachmentViewBinder;
import com.facebook.composer.feedattachment.minutiae.MinutiaeAttachmentController.SubController;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.feedplugins.minutiae.graphql.FetchMinutiaeAttachment.FetchAttachmentString;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getDefault */
public class MinutiaeSimplePageComposerAttachmentController implements SubController {
    private final Resources f6531a;
    private final GraphQLQueryExecutor f6532b;
    private final ComposerFeedAttachmentViewBinder f6533c;

    /* compiled from: getDefault */
    class C08291 implements Function<GraphQLResult<GraphQLProfile>, GraphQLStoryAttachment> {
        final /* synthetic */ MinutiaeSimplePageComposerAttachmentController f6530a;

        C08291(MinutiaeSimplePageComposerAttachmentController minutiaeSimplePageComposerAttachmentController) {
            this.f6530a = minutiaeSimplePageComposerAttachmentController;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            return ((GraphQLProfile) graphQLResult.e).X();
        }
    }

    @Inject
    public MinutiaeSimplePageComposerAttachmentController(GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, ComposerFeedAttachmentViewBinder composerFeedAttachmentViewBinder) {
        this.f6532b = graphQLQueryExecutor;
        this.f6531a = resources;
        this.f6533c = composerFeedAttachmentViewBinder;
    }

    public final View mo203a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        AngoraAttachmentView angoraAttachmentView = new AngoraAttachmentView(viewGroup.getContext());
        this.f6533c.m7871a(graphQLStoryAttachment, angoraAttachmentView);
        return angoraAttachmentView;
    }

    public final ListenableFuture<GraphQLStoryAttachment> mo204a(MinutiaeObject minutiaeObject) {
        return Futures.a(this.f6532b.a(GraphQLRequest.a(new FetchAttachmentString(), GraphQLProfile.class).a(new FetchAttachmentString().a("object_id", minutiaeObject.object.k().d()).a("profile_image_size", String.valueOf(this.f6531a.getDimensionPixelSize(2131428031))).a).a(GraphQLCachePolicy.c)), new C08291(this), MoreExecutors.a());
    }
}
