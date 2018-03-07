package com.facebook.feedback.ui;

import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.flyout.PopoverFragmentContainer;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;

/* compiled from: scaleXY */
public class FeedbackCommentNavigationDelegateProvider extends AbstractAssistedProvider<FeedbackCommentNavigationDelegate> {
    public final FeedbackCommentNavigationDelegate m5040a(PopoverFragmentContainer popoverFragmentContainer, FeedbackParams feedbackParams) {
        return new FeedbackCommentNavigationDelegate(popoverFragmentContainer, feedbackParams, (SecureContextHelper) DefaultSecureContextHelper.a(this), (UriIntentMapper) Fb4aUriIntentMapper.a(this), UFIPopoverLauncher.b(this));
    }
}
