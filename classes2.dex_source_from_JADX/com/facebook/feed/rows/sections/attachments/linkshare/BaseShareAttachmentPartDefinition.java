package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AngoraClearPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLabelPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentKey;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentPersistentState;
import com.facebook.feedplugins.highlighter.FeedHighlighter;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_zero_indicator */
public class BaseShareAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState, V extends View & AttachmentHasLabel & AttachmentHasClear> extends BaseSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    private static BaseShareAttachmentPartDefinition f23822g;
    private static final Object f23823h = new Object();
    private final AngoraClearPartDefinition<V> f23824a;
    private final AttachmentLinkPartDefinition f23825b;
    private final BackgroundPartDefinition f23826c;
    private final FeedHighlighter f23827d;
    private final LegacyAngoraAttachmentUtil f23828e;
    private final AttachmentLabelPartDefinition<V> f23829f;

    private static BaseShareAttachmentPartDefinition m32221b(InjectorLike injectorLike) {
        return new BaseShareAttachmentPartDefinition(AngoraClearPartDefinition.m32224a(injectorLike), AttachmentLinkPartDefinition.m32226a(injectorLike), LegacyAngoraAttachmentUtil.m28831a(injectorLike), FeedHighlighter.m28184a(injectorLike), AttachmentLabelPartDefinition.m32323a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object stylingData;
        FeedProps feedProps = (FeedProps) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        CacheableEntity c = AttachmentProps.m28714c(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2756a(this.f23829f, new Props(m32220a((GraphQLStory) c, m32217a(this.f23828e, graphQLStoryAttachment)), m32220a((GraphQLStory) c, LegacyAngoraAttachmentUtil.m28833b(graphQLStoryAttachment))));
        subParts.mo2756a(this.f23825b, new AttachmentLinkPartDefinition.Props(feedProps));
        subParts.mo2756a(this.f23824a, null);
        FollowShareAttachmentPersistentState followShareAttachmentPersistentState = (FollowShareAttachmentPersistentState) ((HasPersistentState) hasInvalidate).mo2425a(new FollowShareAttachmentKey(feedProps), c);
        SinglePartDefinition singlePartDefinition = this.f23826c;
        if (followShareAttachmentPersistentState.f24268b) {
            stylingData = new StylingData(AttachmentProps.m28715e(feedProps), PaddingStyle.f13082l, 2130840181, -1);
        } else {
            stylingData = m32219a(feedProps);
        }
        subParts.mo2756a(singlePartDefinition, stylingData);
        return null;
    }

    @Inject
    public BaseShareAttachmentPartDefinition(AngoraClearPartDefinition angoraClearPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, FeedHighlighter feedHighlighter, AttachmentLabelPartDefinition attachmentLabelPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23824a = angoraClearPartDefinition;
        this.f23825b = attachmentLinkPartDefinition;
        this.f23828e = legacyAngoraAttachmentUtil;
        this.f23827d = feedHighlighter;
        this.f23829f = attachmentLabelPartDefinition;
        this.f23826c = backgroundPartDefinition;
    }

    public static BaseShareAttachmentPartDefinition m32218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23823h) {
                BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition;
                if (a2 != null) {
                    baseShareAttachmentPartDefinition = (BaseShareAttachmentPartDefinition) a2.mo818a(f23823h);
                } else {
                    baseShareAttachmentPartDefinition = f23822g;
                }
                if (baseShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32221b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23823h, b3);
                        } else {
                            f23822g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static Spannable m32217a(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, GraphQLStoryAttachment graphQLStoryAttachment) {
        return legacyAngoraAttachmentUtil.m28835a(graphQLStoryAttachment);
    }

    private CharSequence m32220a(GraphQLStory graphQLStory, CharSequence charSequence) {
        return FeedHighlighter.m28185a(graphQLStory) ? this.f23827d.m28187a(graphQLStory, charSequence) : charSequence;
    }

    public static StylingData m32219a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new StylingData(AttachmentProps.m28715e(feedProps), PaddingStyle.f13078h, 2130840178, -1);
    }
}
