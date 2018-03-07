package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.directinstall.util.DirectInstallApplicationUtils;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.links.AttachmentLinkLauncher;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_sticker_packs_and_stickers */
public class ThirdPartyNativeAttachmentClickHandler {
    private static ThirdPartyNativeAttachmentClickHandler f23930e;
    private static final Object f23931f = new Object();
    private final NewsFeedAnalyticsEventBuilder f23932a;
    private final AttachmentLinkInspector f23933b;
    private final AttachmentLinkLauncher f23934c;
    private final InlineCommentComposerCache f23935d;

    private static ThirdPartyNativeAttachmentClickHandler m32313b(InjectorLike injectorLike) {
        return new ThirdPartyNativeAttachmentClickHandler(NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), AttachmentLinkInspector.m32230a(injectorLike), AttachmentLinkLauncher.m32296a(injectorLike), InlineCommentComposerCache.m14459a(injectorLike));
    }

    @Inject
    public ThirdPartyNativeAttachmentClickHandler(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AttachmentLinkInspector attachmentLinkInspector, AttachmentLinkLauncher attachmentLinkLauncher, InlineCommentComposerCache inlineCommentComposerCache) {
        this.f23932a = newsFeedAnalyticsEventBuilder;
        this.f23933b = attachmentLinkInspector;
        this.f23934c = attachmentLinkLauncher;
        this.f23935d = inlineCommentComposerCache;
    }

    public final <E extends HasInvalidate> void m32314a(View view, FeedProps<GraphQLStoryAttachment> feedProps, String str, @Nullable Map<String, Object> map, E e) {
        Object obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        FeedProps feedProps2 = feedProps.f13445b;
        Map d = NewsFeedAnalyticsEventBuilder.m14121d(AttachmentLinkInspector.m32233b((FeedProps) feedProps), feedProps2 != null ? TrackableFeedProps.m27452b(feedProps2) : null);
        if (!(map == null || map.isEmpty())) {
            d.putAll(map);
        }
        TrackingNode a = TrackingNodes.m27140a(view);
        if (a != null) {
            ArrayNode b = TrackingNodes.m27146b(a);
            if (b != null) {
                d.put("tn", b);
            }
        }
        FeedProps e2 = AttachmentProps.m28715e(feedProps);
        if (e2 == null) {
            obj = null;
        } else {
            GraphQLStory graphQLStory = (GraphQLStory) e2.f13444a;
        }
        this.f23935d.m14462a(obj, e, Boolean.valueOf(true));
        Builder f = NativeUri.f();
        f.a = str;
        f = f;
        f.d = DirectInstallApplicationUtils.a(graphQLStoryAttachment, obj, str);
        Builder builder = f;
        builder.b = this.f23934c.m32303a(null, (FeedProps) feedProps, str, DefaultAttachmentLinkClickHandler.m32289a(e, e2, "applink_"));
        builder = builder.a(d);
        builder.e = "NEWSFEED";
        this.f23934c.m32304a(view.getContext(), builder.a());
    }

    public static ThirdPartyNativeAttachmentClickHandler m32312a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThirdPartyNativeAttachmentClickHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23931f) {
                ThirdPartyNativeAttachmentClickHandler thirdPartyNativeAttachmentClickHandler;
                if (a2 != null) {
                    thirdPartyNativeAttachmentClickHandler = (ThirdPartyNativeAttachmentClickHandler) a2.mo818a(f23931f);
                } else {
                    thirdPartyNativeAttachmentClickHandler = f23930e;
                }
                if (thirdPartyNativeAttachmentClickHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32313b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23931f, b3);
                        } else {
                            f23930e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = thirdPartyNativeAttachmentClickHandler;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
