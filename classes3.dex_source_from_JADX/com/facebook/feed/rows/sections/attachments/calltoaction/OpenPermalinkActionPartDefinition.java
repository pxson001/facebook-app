package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ui.CallToActionAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.links.AttachmentLinkLauncher;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: VideoAspectRatioKey */
public class OpenPermalinkActionPartDefinition<V extends View & AngoraAttachment & AttachmentHasSubcontext & AttachmentHasRating> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, V> {
    private static OpenPermalinkActionPartDefinition f331f;
    private static final Object f332g = new Object();
    private final BackgroundPartDefinition f333a;
    private final DefaultPaddingStyleResolver f334b;
    private final OpenPermalinkActionTextPartDefinition<V> f335c;
    public final AttachmentLinkLauncher f336d;
    private final ClickListenerPartDefinition f337e;

    private static OpenPermalinkActionPartDefinition m294b(InjectorLike injectorLike) {
        return new OpenPermalinkActionPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), OpenPermalinkActionTextPartDefinition.m298a(injectorLike), AttachmentLinkLauncher.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m296a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) feedProps.a, -1580386863);
        subParts.a(this.f335c, feedProps.a);
        1 1 = new 1(this, a);
        subParts.a(2131560131, this.f337e, 1);
        subParts.a(this.f337e, 1);
        subParts.a(this.f333a, new StylingData(AttachmentProps.e(feedProps), this.f334b.h(), 2130840313, -1));
        return null;
    }

    public final boolean m297a(Object obj) {
        return CallToActionUtil.j((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    @Inject
    public OpenPermalinkActionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, OpenPermalinkActionTextPartDefinition openPermalinkActionTextPartDefinition, AttachmentLinkLauncher attachmentLinkLauncher, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f333a = backgroundPartDefinition;
        this.f334b = defaultPaddingStyleResolver;
        this.f335c = openPermalinkActionTextPartDefinition;
        this.f336d = attachmentLinkLauncher;
        this.f337e = clickListenerPartDefinition;
    }

    public static OpenPermalinkActionPartDefinition m293a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenPermalinkActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f332g) {
                OpenPermalinkActionPartDefinition openPermalinkActionPartDefinition;
                if (a2 != null) {
                    openPermalinkActionPartDefinition = (OpenPermalinkActionPartDefinition) a2.a(f332g);
                } else {
                    openPermalinkActionPartDefinition = f331f;
                }
                if (openPermalinkActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m294b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f332g, b3);
                        } else {
                            f331f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openPermalinkActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<V> m295a() {
        return CallToActionAttachmentView.a;
    }
}
