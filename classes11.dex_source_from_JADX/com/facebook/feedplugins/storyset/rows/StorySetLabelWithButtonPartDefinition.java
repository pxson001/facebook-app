package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.text.Spannable;
import com.facebook.attachments.angora.actionbutton.AngoraActionButton;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageLabelWithButtonView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: b11b50cf30cc1584cdd070529c228791 */
public class StorySetLabelWithButtonPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, AnyEnvironment, StoryPageLabelWithButtonView> {
    private static StorySetLabelWithButtonPartDefinition f9670f;
    private static final Object f9671g = new Object();
    private final AngoraActionButtonController f9672a;
    private final AttachmentLinkPartDefinition f9673b;
    private final TextPartDefinition f9674c;
    private final TextPartDefinition f9675d;
    private final LegacyAngoraAttachmentUtil f9676e;

    private static StorySetLabelWithButtonPartDefinition m10157b(InjectorLike injectorLike) {
        return new StorySetLabelWithButtonPartDefinition(AngoraActionButtonController.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), LegacyAngoraAttachmentUtil.a(injectorLike));
    }

    public final Object m10158a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        AngoraActionButton a = this.f9672a.a(feedProps);
        Spannable a2 = this.f9676e.a(graphQLStoryAttachment);
        Spannable b = LegacyAngoraAttachmentUtil.b(graphQLStoryAttachment);
        subParts.a(2131567706, this.f9674c, a2);
        subParts.a(2131567707, this.f9675d, b);
        subParts.a(a.a(), feedProps);
        subParts.a(this.f9673b, new Props(feedProps, null));
        return null;
    }

    @Inject
    public StorySetLabelWithButtonPartDefinition(AngoraActionButtonController angoraActionButtonController, AttachmentLinkPartDefinition attachmentLinkPartDefinition, TextPartDefinition textPartDefinition, TextPartDefinition textPartDefinition2, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil) {
        this.f9672a = angoraActionButtonController;
        this.f9673b = attachmentLinkPartDefinition;
        this.f9674c = textPartDefinition;
        this.f9675d = textPartDefinition2;
        this.f9676e = legacyAngoraAttachmentUtil;
    }

    public static StorySetLabelWithButtonPartDefinition m10156a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetLabelWithButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9671g) {
                StorySetLabelWithButtonPartDefinition storySetLabelWithButtonPartDefinition;
                if (a2 != null) {
                    storySetLabelWithButtonPartDefinition = (StorySetLabelWithButtonPartDefinition) a2.a(f9671g);
                } else {
                    storySetLabelWithButtonPartDefinition = f9670f;
                }
                if (storySetLabelWithButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10157b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9671g, b3);
                        } else {
                            f9670f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetLabelWithButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
