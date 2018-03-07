package com.facebook.feedplugins.video;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.attachments.angora.AngoraVideoAttachmentView;
import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AngoraAttachmentUtil;
import com.facebook.feed.rows.sections.attachments.AngoraClearPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AvatarAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.SmallImagePartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.AngoraAttachmentBackgroundPartDefinition;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.text.CustomFontUtil;
import com.google.common.base.Absent;
import com.google.common.base.Strings;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: frame interval = %.2f ms  */
public class AvatarVideoAttachmentPartDefinition<E extends CanShowVideoInFullScreen & HasFeedListType & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, AngoraVideoAttachmentView> {
    private static final CallerContext f13012a = CallerContext.a(AvatarAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "small_photo", "native_newsfeed");
    private static AvatarVideoAttachmentPartDefinition f13013k;
    private static final Object f13014l = new Object();
    private final CustomFontUtil f13015b;
    private final LegacyAngoraAttachmentUtil f13016c;
    private final AngoraClearPartDefinition<AngoraVideoAttachmentView> f13017d;
    private final InlineVideoPartDefinition<E, InlineVideoAttachmentView> f13018e;
    private final TextOrHiddenPartDefinition f13019f;
    private final ActionButtonPartDefinition<E, AngoraVideoAttachmentView> f13020g;
    private final AttachmentLinkPartDefinition f13021h;
    private final AngoraAttachmentBackgroundPartDefinition f13022i;
    private final SmallImagePartDefinition<AngoraVideoAttachmentView> f13023j;

    private static AvatarVideoAttachmentPartDefinition m14724b(InjectorLike injectorLike) {
        return new AvatarVideoAttachmentPartDefinition(LegacyAngoraAttachmentUtil.a(injectorLike), CustomFontUtil.a(injectorLike), AngoraClearPartDefinition.a(injectorLike), InlineVideoPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), AngoraAttachmentBackgroundPartDefinition.a(injectorLike), SmallImagePartDefinition.a(injectorLike));
    }

    public final Object m14726a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(2131559579, this.f13018e, new Props(feedProps, -1, Absent.INSTANCE, new AtomicReference()));
        subParts.a(2131559571, this.f13019f, m14722a(graphQLStoryAttachment));
        TextOrHiddenPartDefinition textOrHiddenPartDefinition = this.f13019f;
        SpannableStringBuilder spannableStringBuilder = null;
        if (graphQLStoryAttachment.y() != null) {
            spannableStringBuilder = SpannableStringBuilder.valueOf(graphQLStoryAttachment.y());
        }
        if (!(graphQLStoryAttachment.n() == null || graphQLStoryAttachment.n().a() == null)) {
            CharSequence a = graphQLStoryAttachment.n().a();
            if (spannableStringBuilder != null) {
                LegacyAngoraAttachmentUtil.a(spannableStringBuilder);
                spannableStringBuilder.append(a);
            } else {
                spannableStringBuilder = SpannableStringBuilder.valueOf(a);
            }
        }
        subParts.a(2131559572, textOrHiddenPartDefinition, spannableStringBuilder);
        subParts.a(this.f13020g, feedProps);
        subParts.a(this.f13022i, feedProps);
        subParts.a(this.f13021h, new AttachmentLinkPartDefinition.Props(feedProps));
        subParts.a(this.f13023j, new SmallImagePartDefinition.Props(AngoraAttachmentUtil.a(graphQLStoryAttachment), f13012a));
        subParts.a(this.f13017d, null);
        return null;
    }

    public static AvatarVideoAttachmentPartDefinition m14723a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AvatarVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13014l) {
                AvatarVideoAttachmentPartDefinition avatarVideoAttachmentPartDefinition;
                if (a2 != null) {
                    avatarVideoAttachmentPartDefinition = (AvatarVideoAttachmentPartDefinition) a2.a(f13014l);
                } else {
                    avatarVideoAttachmentPartDefinition = f13013k;
                }
                if (avatarVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14724b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13014l, b3);
                        } else {
                            f13013k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = avatarVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AvatarVideoAttachmentPartDefinition(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, CustomFontUtil customFontUtil, AngoraClearPartDefinition angoraClearPartDefinition, InlineVideoPartDefinition inlineVideoPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, ActionButtonPartDefinition actionButtonPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, AngoraAttachmentBackgroundPartDefinition angoraAttachmentBackgroundPartDefinition, SmallImagePartDefinition smallImagePartDefinition) {
        this.f13016c = legacyAngoraAttachmentUtil;
        this.f13015b = customFontUtil;
        this.f13017d = angoraClearPartDefinition;
        this.f13018e = inlineVideoPartDefinition;
        this.f13019f = textOrHiddenPartDefinition;
        this.f13020g = actionButtonPartDefinition;
        this.f13021h = attachmentLinkPartDefinition;
        this.f13022i = angoraAttachmentBackgroundPartDefinition;
        this.f13023j = smallImagePartDefinition;
    }

    public final ViewType m14725a() {
        return AngoraVideoAttachmentView.a;
    }

    public final boolean m14727a(Object obj) {
        return true;
    }

    private Spannable m14722a(GraphQLStoryAttachment graphQLStoryAttachment) {
        Spannable valueOf = SpannableStringBuilder.valueOf(graphQLStoryAttachment.A());
        if (!Strings.isNullOrEmpty(graphQLStoryAttachment.A())) {
            valueOf.setSpan(CustomFontUtil.a(), 0, graphQLStoryAttachment.A().length(), 17);
        }
        return valueOf;
    }
}
