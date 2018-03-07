package com.facebook.composer.feedattachment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: groups_hub_discover */
public interface ComposerFeedAttachmentController {
    View mo191a(Context context, ViewGroup viewGroup);

    View mo192a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup);

    Optional<GraphQLStoryAttachment> mo193a(Throwable th);

    List<GraphQLStoryAttachmentStyle> mo194c();

    ListenableFuture<GraphQLStoryAttachment> mo195d();

    boolean mo196e();

    boolean mo197f();

    String mo198g();

    void mo199h();

    void mo200i();

    View mo201j();

    boolean mo202k();
}
