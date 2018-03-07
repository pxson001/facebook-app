package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageWithVideoView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key */
public class StorySetVideoPageRootPartDefinition<E extends CanLikePage & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasScrollListenerSupport & HasIsAsync> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, StoryPageWithVideoView> {
    public static final StoryPageWithVideoViewType f18527a = new StoryPageWithVideoViewType();
    private static StorySetVideoPageRootPartDefinition f18528e;
    private static final Object f18529f = new Object();
    private final StorySetBasicPagePartDefinition<E> f18530b;
    private final StorySetPageVideoAttachmentPartDefinition<E> f18531c;
    private final StorySetAttachmentImagePartDefinition f18532d;

    /* compiled from: key */
    class StoryPageWithVideoViewType extends StorySetEmbededHeaderViewType<StoryPageWithVideoView> {
        public final View mo1995a(Context context) {
            return (StoryPageWithVideoView) m26000a(new StoryPageWithVideoView(context));
        }
    }

    private static StorySetVideoPageRootPartDefinition m26007b(InjectorLike injectorLike) {
        return new StorySetVideoPageRootPartDefinition(StorySetBasicPagePartDefinition.a(injectorLike), StorySetPageVideoAttachmentPartDefinition.a(injectorLike), StorySetAttachmentImagePartDefinition.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        FeedProps i = StoryProps.m27461i(storySetPageProps.b);
        subParts.mo2756a(this.f18530b, storySetPageProps);
        subParts.mo2755a(2131567716, this.f18532d, i.f13444a);
        subParts.mo2755a(2131567716, this.f18531c, i);
        return null;
    }

    public static StorySetVideoPageRootPartDefinition m26006a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetVideoPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18529f) {
                StorySetVideoPageRootPartDefinition storySetVideoPageRootPartDefinition;
                if (a2 != null) {
                    storySetVideoPageRootPartDefinition = (StorySetVideoPageRootPartDefinition) a2.mo818a(f18529f);
                } else {
                    storySetVideoPageRootPartDefinition = f18528e;
                }
                if (storySetVideoPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26007b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18529f, b3);
                        } else {
                            f18528e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetVideoPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public StorySetVideoPageRootPartDefinition(StorySetBasicPagePartDefinition storySetBasicPagePartDefinition, StorySetPageVideoAttachmentPartDefinition storySetPageVideoAttachmentPartDefinition, StorySetAttachmentImagePartDefinition storySetAttachmentImagePartDefinition) {
        this.f18530b = storySetBasicPagePartDefinition;
        this.f18531c = storySetPageVideoAttachmentPartDefinition;
        this.f18532d = storySetAttachmentImagePartDefinition;
    }

    public final ViewType<StoryPageWithVideoView> mo2547a() {
        f18527a.f18520a = this.f18530b.a();
        return f18527a;
    }
}
