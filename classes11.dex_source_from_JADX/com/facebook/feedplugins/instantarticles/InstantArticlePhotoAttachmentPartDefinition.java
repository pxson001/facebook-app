package com.facebook.feedplugins.instantarticles;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasArticleIcon;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.AttachmentHasTooltipAnchor;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.ArticleIconPartDefinition;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: context_items_row_limit */
public class InstantArticlePhotoAttachmentPartDefinition<E extends HasInvalidate & HasImageLoadListener & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasPlayIcon & AttachmentHasArticleIcon & AttachmentHasTooltipAnchor> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, InstantArticlePhotoAttachmentContainerView> {
    private static InstantArticlePhotoAttachmentPartDefinition f7977d;
    private static final Object f7978e = new Object();
    private final AttachmentLinkPartDefinition f7979a;
    private final PhotoAttachmentPartDefinition<E> f7980b;
    private final ArticleIconPartDefinition f7981c;

    private static InstantArticlePhotoAttachmentPartDefinition m9053b(InjectorLike injectorLike) {
        return new InstantArticlePhotoAttachmentPartDefinition(AttachmentLinkPartDefinition.a(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike), ArticleIconPartDefinition.a(injectorLike));
    }

    public final Object m9055a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f7979a, new Props(feedProps));
        subParts.a(this.f7980b, feedProps);
        subParts.a(this.f7981c, graphQLStoryAttachment);
        return null;
    }

    public final boolean m9056a(Object obj) {
        return GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) ((FeedProps) obj).a, GraphQLStoryAttachmentStyle.INSTANT_ARTICLE_PHOTO);
    }

    @Inject
    public InstantArticlePhotoAttachmentPartDefinition(AttachmentLinkPartDefinition attachmentLinkPartDefinition, PhotoAttachmentPartDefinition photoAttachmentPartDefinition, ArticleIconPartDefinition articleIconPartDefinition) {
        this.f7979a = attachmentLinkPartDefinition;
        this.f7980b = photoAttachmentPartDefinition;
        this.f7981c = articleIconPartDefinition;
    }

    public static InstantArticlePhotoAttachmentPartDefinition m9052a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticlePhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7978e) {
                InstantArticlePhotoAttachmentPartDefinition instantArticlePhotoAttachmentPartDefinition;
                if (a2 != null) {
                    instantArticlePhotoAttachmentPartDefinition = (InstantArticlePhotoAttachmentPartDefinition) a2.a(f7978e);
                } else {
                    instantArticlePhotoAttachmentPartDefinition = f7977d;
                }
                if (instantArticlePhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9053b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7978e, b3);
                        } else {
                            f7977d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticlePhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<InstantArticlePhotoAttachmentContainerView> m9054a() {
        return InstantArticlePhotoAttachmentContainerView.f7975b;
    }
}
