package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.DefaultHeaderSubtitleWithLayoutPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSubtitlePartDefinition;
import com.facebook.feed.rows.sections.header.HeaderTitleWithLayoutPartDefinition;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition.Props;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.sections.header.ui.HScrollPageHeaderView;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: best_guess */
public class NetEgoStorySetPageHeaderPartDefinition<E extends CanLikePage & HasContext & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasMenuButtonProvider & HasRowKey> extends BaseSinglePartDefinition<NetEgoStorySetPageProps, Void, E, HScrollPageHeaderView> {
    private static NetEgoStorySetPageHeaderPartDefinition f9555g;
    private static final Object f9556h = new Object();
    private final TextLinkPartDefinition f9557a;
    private final ProfilePhotoPartDefinition<E> f9558b;
    private final HeaderTitleWithLayoutPartDefinition<E> f9559c;
    private final HeaderSubtitlePartDefinition f9560d;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition<E> f9561e;
    private final StoryHeaderUtil f9562f;

    private static NetEgoStorySetPageHeaderPartDefinition m10087b(InjectorLike injectorLike) {
        return new NetEgoStorySetPageHeaderPartDefinition(TextLinkPartDefinition.a(injectorLike), ProfilePhotoPartDefinition.a(injectorLike), HeaderTitleWithLayoutPartDefinition.a(injectorLike), HeaderSubtitlePartDefinition.a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.a(injectorLike), StoryHeaderUtil.a(injectorLike));
    }

    public final Object m10088a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        NetEgoStorySetPageProps netEgoStorySetPageProps = (NetEgoStorySetPageProps) obj;
        FeedProps feedProps = netEgoStorySetPageProps.f9564b;
        subParts.a(this.f9557a, feedProps);
        int c = this.f9562f.c(feedProps);
        subParts.a(2131562764, this.f9558b, new Props(feedProps, this.f9562f.b(feedProps), c));
        subParts.a(2131562765, this.f9559c, new HeaderTitleWithLayoutPartDefinition.Props(feedProps, netEgoStorySetPageProps.f9567e, -1));
        if (netEgoStorySetPageProps.f9567e) {
            subParts.a(2131562766, this.f9561e, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(feedProps, -1));
        } else {
            subParts.a(2131562766, this.f9560d, feedProps);
        }
        return null;
    }

    @Inject
    public NetEgoStorySetPageHeaderPartDefinition(TextLinkPartDefinition textLinkPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, HeaderSubtitlePartDefinition headerSubtitlePartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f9557a = textLinkPartDefinition;
        this.f9558b = profilePhotoPartDefinition;
        this.f9559c = headerTitleWithLayoutPartDefinition;
        this.f9560d = headerSubtitlePartDefinition;
        this.f9561e = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f9562f = storyHeaderUtil;
    }

    public static NetEgoStorySetPageHeaderPartDefinition m10086a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NetEgoStorySetPageHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9556h) {
                NetEgoStorySetPageHeaderPartDefinition netEgoStorySetPageHeaderPartDefinition;
                if (a2 != null) {
                    netEgoStorySetPageHeaderPartDefinition = (NetEgoStorySetPageHeaderPartDefinition) a2.a(f9556h);
                } else {
                    netEgoStorySetPageHeaderPartDefinition = f9555g;
                }
                if (netEgoStorySetPageHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10087b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9556h, b3);
                        } else {
                            f9555g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = netEgoStorySetPageHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
