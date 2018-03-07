package com.facebook.ufiservices.util;

import android.content.res.Resources;
import android.text.Editable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import javax.inject.Inject;

/* compiled from: cropRectangle */
public class OptimisticCommentFactory {
    private final Resources f18345a;
    private final TaggingProfiles f18346b;
    private final PendingCommentCache f18347c;

    public static OptimisticCommentFactory m26954b(InjectorLike injectorLike) {
        return new OptimisticCommentFactory(ResourcesMethodAutoProvider.a(injectorLike.getApplicationInjector()), TaggingProfiles.m25203b(injectorLike), PendingCommentCache.m26489a(injectorLike));
    }

    @Inject
    OptimisticCommentFactory(@NeedsApplicationInjector Resources resources, TaggingProfiles taggingProfiles, PendingCommentCache pendingCommentCache) {
        this.f18345a = resources;
        this.f18346b = taggingProfiles;
        this.f18347c = pendingCommentCache;
    }

    public final GraphQLComment m26955a(String str, GraphQLActor graphQLActor, PendingCommentInputEntry pendingCommentInputEntry) {
        Editable a = MentionsSpannableStringBuilder.m25490a(pendingCommentInputEntry.f17973c, this.f18345a, this.f18346b, null);
        return FeedCommentPreview.m26840a(graphQLActor, a.toString(), MentionsUtils.m25503b(a), str, pendingCommentInputEntry.f17976f, pendingCommentInputEntry.f17977g, this.f18347c);
    }
}
