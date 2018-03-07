package com.facebook.feedback.ui.environment;

import android.content.Context;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.ui.BaseCommentNavigationDelegate;
import com.facebook.feedback.ui.CommentDelegate;
import com.facebook.feedback.ui.LoadMoreCommentsController;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: ridge_trigger_surface */
public class BaseCommentsEnvironmentProvider extends AbstractAssistedProvider<BaseCommentsEnvironment> {
    public final BaseCommentsEnvironment m5348a(Context context, BaseCommentNavigationDelegate baseCommentNavigationDelegate, Runnable runnable) {
        return new BaseCommentsEnvironment(context, baseCommentNavigationDelegate, runnable, CommentDelegate.m4850b(this), LoadMoreCommentsController.m5152b(this), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasPersistentStateImpl.b(this), InlineReplyExpansionExperimentUtil.a(this));
    }
}
