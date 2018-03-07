package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.ArticleIconPartDefinition;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: content-encoding */
public class InstantArticlesVideoAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, InstantArticlesRichVideoAttachmentView> {
    private static InstantArticlesVideoAttachmentPartDefinition f7986d;
    private static final Object f7987e = new Object();
    private final RichVideoPlayerPartDefinition<E, RichVideoAttachmentView> f7988a;
    private final ArticleIconPartDefinition f7989b;
    private final AttachmentLinkPartDefinition f7990c;

    private static InstantArticlesVideoAttachmentPartDefinition m9062b(InjectorLike injectorLike) {
        return new InstantArticlesVideoAttachmentPartDefinition(RichVideoPlayerPartDefinition.a(injectorLike), ArticleIconPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m9064a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f7988a, new Props(feedProps, -1, Absent.INSTANCE, new AtomicReference()));
        subParts.a(this.f7989b, feedProps.a);
        subParts.a(this.f7990c, new AttachmentLinkPartDefinition.Props(feedProps));
        return null;
    }

    public final boolean m9065a(Object obj) {
        return GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) ((FeedProps) obj).a, GraphQLStoryAttachmentStyle.INSTANT_ARTICLE_VIDEO);
    }

    @Inject
    public InstantArticlesVideoAttachmentPartDefinition(RichVideoPlayerPartDefinition richVideoPlayerPartDefinition, ArticleIconPartDefinition articleIconPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f7988a = richVideoPlayerPartDefinition;
        this.f7989b = articleIconPartDefinition;
        this.f7990c = attachmentLinkPartDefinition;
    }

    public static InstantArticlesVideoAttachmentPartDefinition m9061a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticlesVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7987e) {
                InstantArticlesVideoAttachmentPartDefinition instantArticlesVideoAttachmentPartDefinition;
                if (a2 != null) {
                    instantArticlesVideoAttachmentPartDefinition = (InstantArticlesVideoAttachmentPartDefinition) a2.a(f7987e);
                } else {
                    instantArticlesVideoAttachmentPartDefinition = f7986d;
                }
                if (instantArticlesVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9062b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7987e, b3);
                        } else {
                            f7986d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticlesVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<InstantArticlesRichVideoAttachmentView> m9063a() {
        return InstantArticlesRichVideoAttachmentView.f7984c;
    }
}
