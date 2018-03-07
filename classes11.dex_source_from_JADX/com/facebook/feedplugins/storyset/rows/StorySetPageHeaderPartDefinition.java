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
/* compiled from: authorization_declined */
public class StorySetPageHeaderPartDefinition<E extends CanLikePage & HasContext & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher & HasMenuButtonProvider & HasRowKey> extends BaseSinglePartDefinition<StorySetPageProps, Void, E, HScrollPageHeaderView> {
    private static StorySetPageHeaderPartDefinition f9724g;
    private static final Object f9725h = new Object();
    private final TextLinkPartDefinition f9726a;
    private final ProfilePhotoPartDefinition<E> f9727b;
    private final HeaderTitleWithLayoutPartDefinition<E> f9728c;
    private final HeaderSubtitlePartDefinition f9729d;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition<E> f9730e;
    private final StoryHeaderUtil f9731f;

    private static StorySetPageHeaderPartDefinition m10180b(InjectorLike injectorLike) {
        return new StorySetPageHeaderPartDefinition(TextLinkPartDefinition.a(injectorLike), ProfilePhotoPartDefinition.a(injectorLike), HeaderTitleWithLayoutPartDefinition.a(injectorLike), HeaderSubtitlePartDefinition.a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.a(injectorLike), StoryHeaderUtil.a(injectorLike));
    }

    public final Object m10181a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        FeedProps feedProps = storySetPageProps.f9733b;
        subParts.a(this.f9726a, feedProps);
        int c = this.f9731f.c(feedProps);
        subParts.a(2131562764, this.f9727b, new Props(feedProps, this.f9731f.b(feedProps), c));
        subParts.a(2131562765, this.f9728c, new HeaderTitleWithLayoutPartDefinition.Props(feedProps, storySetPageProps.f9736e, -1));
        if (storySetPageProps.f9736e) {
            subParts.a(2131562766, this.f9730e, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(feedProps, -1));
        } else {
            subParts.a(2131562766, this.f9729d, feedProps);
        }
        return null;
    }

    @Inject
    public StorySetPageHeaderPartDefinition(TextLinkPartDefinition textLinkPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, HeaderSubtitlePartDefinition headerSubtitlePartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f9726a = textLinkPartDefinition;
        this.f9727b = profilePhotoPartDefinition;
        this.f9728c = headerTitleWithLayoutPartDefinition;
        this.f9729d = headerSubtitlePartDefinition;
        this.f9730e = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f9731f = storyHeaderUtil;
    }

    public static StorySetPageHeaderPartDefinition m10179a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9725h) {
                StorySetPageHeaderPartDefinition storySetPageHeaderPartDefinition;
                if (a2 != null) {
                    storySetPageHeaderPartDefinition = (StorySetPageHeaderPartDefinition) a2.a(f9725h);
                } else {
                    storySetPageHeaderPartDefinition = f9724g;
                }
                if (storySetPageHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10180b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9725h, b3);
                        } else {
                            f9724g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
