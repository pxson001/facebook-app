package com.facebook.feedback.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.FeedbackRootGroupPartDefinition;
import com.facebook.feedback.ui.rows.TypingIndicatorGroupPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: selectedPrivacyName */
public class CommentAdapterFactory {
    private final QeAccessor f4175a;
    private final Lazy<FeedbackRootGroupPartDefinition> f4176b;
    public final Lazy<TypingIndicatorGroupPartDefinition> f4177c;
    private final DefaultCommentAdapterProvider f4178d;
    private final TypingIndicatorAdapterProvider f4179e;
    private final CommentAdapterProvider f4180f;
    public final MultiRowAdapterBuilder f4181g;

    public static CommentAdapterFactory m4798a(InjectorLike injectorLike) {
        return new CommentAdapterFactory((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 6153), IdBasedLazy.a(injectorLike, 6161), (DefaultCommentAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultCommentAdapterProvider.class), (TypingIndicatorAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypingIndicatorAdapterProvider.class), (CommentAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CommentAdapterProvider.class), MultiRowAdapterBuilder.b(injectorLike));
    }

    @Inject
    public CommentAdapterFactory(QeAccessor qeAccessor, Lazy<FeedbackRootGroupPartDefinition> lazy, Lazy<TypingIndicatorGroupPartDefinition> lazy2, DefaultCommentAdapterProvider defaultCommentAdapterProvider, TypingIndicatorAdapterProvider typingIndicatorAdapterProvider, CommentAdapterProvider commentAdapterProvider, MultiRowAdapterBuilder multiRowAdapterBuilder) {
        this.f4175a = qeAccessor;
        this.f4176b = lazy;
        this.f4177c = lazy2;
        this.f4178d = defaultCommentAdapterProvider;
        this.f4179e = typingIndicatorAdapterProvider;
        this.f4180f = commentAdapterProvider;
        this.f4181g = multiRowAdapterBuilder;
    }

    public final CommentAdapter m4801a(BaseCommentNavigationDelegate baseCommentNavigationDelegate, CommentsEnvironment commentsEnvironment, FeedProps<GraphQLStory> feedProps) {
        SingleSegmentCommentAdapter a;
        SingleSegmentCommentAdapter a2;
        if (this.f4175a.a(ExperimentsForFeedbackTestModule.v, false)) {
            a = m4800a(commentsEnvironment, feedProps);
            a2 = m4800a(commentsEnvironment, null);
        } else {
            a = m4799a(baseCommentNavigationDelegate);
            a2 = m4799a(baseCommentNavigationDelegate);
        }
        CommentAdapterProvider commentAdapterProvider = this.f4180f;
        OneItemListItemCollection oneItemListItemCollection = new OneItemListItemCollection();
        oneItemListItemCollection.a = Integer.valueOf(0);
        Builder a3 = this.f4181g.a(this.f4177c, oneItemListItemCollection);
        a3.f = commentsEnvironment;
        return new CommentAdapter(a, a2, new TypingIndicatorAdapter(a3.e(), oneItemListItemCollection), FeedbackMutator.a(commentAdapterProvider));
    }

    private SingleSegmentCommentAdapter m4799a(BaseCommentNavigationDelegate baseCommentNavigationDelegate) {
        DefaultCommentAdapterProvider defaultCommentAdapterProvider = this.f4178d;
        return new DefaultCommentAdapter(baseCommentNavigationDelegate, CommentDelegate.m4850b(defaultCommentAdapterProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(defaultCommentAdapterProvider), LoadMoreCommentsController.m5152b(defaultCommentAdapterProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(defaultCommentAdapterProvider));
    }

    private SingleSegmentCommentAdapter m4800a(CommentsEnvironment commentsEnvironment, FeedProps<GraphQLStory> feedProps) {
        FeedbackListItemCollection feedbackListItemCollection = new FeedbackListItemCollection(feedProps);
        Builder a = this.f4181g.a(this.f4176b, feedbackListItemCollection);
        a.f = commentsEnvironment;
        return new MultiRowCommentAdapter(a.e(), feedbackListItemCollection, commentsEnvironment);
    }
}
