package com.facebook.messaging.actionlinks;

import com.facebook.inject.AbstractProvider;

/* compiled from: trending_awareness_launch_time */
public class ActionLinkHandlerMethodAutoProvider extends AbstractProvider<ActionLinkHandler> {
    public Object get() {
        return MessagingActionLinkModule.m1589a(KeyboardBroadcastActionLinkHandler.m1587b(this), AutoComposeBroadcastActionLinkHandler.m1580b(this), AutoComposeIntentActionLinkHandler.m1582b(this), DefaultActionLinkHandler.m1585b(this));
    }
}
