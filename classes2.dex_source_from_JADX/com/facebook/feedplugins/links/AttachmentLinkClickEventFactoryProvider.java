package com.facebook.feedplugins.links;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.feedplugins.links.AttachmentLinkClickEventFactory.LinkClickType;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.links.AttachmentLinkInspector;

/* compiled from: fetch_code */
public class AttachmentLinkClickEventFactoryProvider extends AbstractAssistedProvider<AttachmentLinkClickEventFactory> {
    public final AttachmentLinkClickEventFactory m32501a(LinkClickType linkClickType) {
        return new AttachmentLinkClickEventFactory(CommonEventsBuilder.m14539b(this), AttachmentLinkInspector.m32230a((InjectorLike) this), linkClickType);
    }
}
