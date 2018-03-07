package com.facebook.ufiservices.flyout.views;

import android.text.Spannable;
import android.text.TextUtils;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.cache.PendingCommentCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: custom_protocol */
public class CommentMetadataSpannableUtil {
    private final PendingCommentCache f18148a;
    private final Provider<TimeFormatUtil> f18149b;
    private final ReactionsExperimentUtil f18150c;

    public static CommentMetadataSpannableUtil m26698b(InjectorLike injectorLike) {
        return new CommentMetadataSpannableUtil(PendingCommentCache.m26489a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 610), ReactionsExperimentUtil.a(injectorLike));
    }

    @Inject
    public CommentMetadataSpannableUtil(PendingCommentCache pendingCommentCache, Provider<TimeFormatUtil> provider, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f18148a = pendingCommentCache;
        this.f18149b = provider;
        this.f18150c = reactionsExperimentUtil;
    }

    public final CharSequence m26699a(CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams, GraphQLComment graphQLComment, boolean z) {
        List a = m26696a(commentMetadataSpannableBuilderParams, graphQLComment).mo1387a(graphQLComment);
        if (z) {
            Collections.reverse(a);
        }
        return TextUtils.concat((CharSequence[]) a.toArray(new CharSequence[a.size()]));
    }

    public final List<Spannable> m26700a(CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams, GraphQLComment graphQLComment, GraphQLComment graphQLComment2) {
        return m26696a(commentMetadataSpannableBuilderParams, graphQLComment).mo1388a(graphQLComment, graphQLComment2);
    }

    public final List<Spannable> m26701a(CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams, GraphQLComment graphQLComment, GraphQLComment graphQLComment2, FeedbackReaction feedbackReaction) {
        DefaultCommentMetadataSpannableBuilder a = m26696a(commentMetadataSpannableBuilderParams, graphQLComment);
        a.f18169e = feedbackReaction;
        return a.mo1388a(graphQLComment, graphQLComment2);
    }

    public static CharSequence m26697a(List<Spannable> list, boolean z) {
        List arrayList = new ArrayList(list);
        if (z) {
            Collections.reverse(arrayList);
        }
        return TextUtils.concat((CharSequence[]) arrayList.toArray(new CharSequence[list.size()]));
    }

    private DefaultCommentMetadataSpannableBuilder m26696a(CommentMetadataSpannableBuilderParams commentMetadataSpannableBuilderParams, GraphQLComment graphQLComment) {
        boolean g = this.f18150c.g();
        if (GraphQLHelper.c(graphQLComment)) {
            return new PagesCommentMetadataSpannableBuilder(commentMetadataSpannableBuilderParams, this.f18148a, this.f18149b, g);
        }
        return new DefaultCommentMetadataSpannableBuilder(commentMetadataSpannableBuilderParams, this.f18148a, this.f18149b, g);
    }
}
