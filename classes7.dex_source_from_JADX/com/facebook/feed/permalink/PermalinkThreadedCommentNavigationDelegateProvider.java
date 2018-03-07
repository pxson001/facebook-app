package com.facebook.feed.permalink;

import android.content.Context;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.ufiservices.flyout.UFIPopoverLauncher;

/* compiled from: admin_tapped_remove_from_favorites */
public class PermalinkThreadedCommentNavigationDelegateProvider extends AbstractAssistedProvider<PermalinkThreadedCommentNavigationDelegate> {
    public final PermalinkThreadedCommentNavigationDelegate m22919a(Context context) {
        return new PermalinkThreadedCommentNavigationDelegate(context, (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (UriIntentMapper) Fb4aUriIntentMapper.a(this), UFIPopoverLauncher.b(this));
    }
}
