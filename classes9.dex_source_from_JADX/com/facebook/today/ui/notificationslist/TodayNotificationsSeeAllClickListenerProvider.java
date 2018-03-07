package com.facebook.today.ui.notificationslist;

import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.today.notifications.TodayNotificationsHolder;

/* compiled from: transcode_attempt */
public class TodayNotificationsSeeAllClickListenerProvider extends AbstractAssistedProvider<TodayNotificationsSeeAllClickListener> {
    public final TodayNotificationsSeeAllClickListener m1499a(Boolean bool, ReactionInteractionTracker reactionInteractionTracker, String str, String str2) {
        return new TodayNotificationsSeeAllClickListener(bool, reactionInteractionTracker, str, str2, (UriIntentMapper) Fb4aUriIntentMapper.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), TodayNotificationsHolder.m1361a((InjectorLike) this));
    }
}
