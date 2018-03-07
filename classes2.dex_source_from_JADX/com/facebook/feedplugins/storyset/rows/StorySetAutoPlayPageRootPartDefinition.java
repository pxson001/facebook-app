package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
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
import com.facebook.feedplugins.storyset.rows.ui.StoryPageWithVideoAutoPlayView;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
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
import com.google.common.base.Absent;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key = ? */
public class StorySetAutoPlayPageRootPartDefinition<E extends CanLikePage & CanShowVideoInFullScreen & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasScrollListenerSupport & HasIsAsync> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, StoryPageWithVideoAutoPlayView> {
    public static final StoryPageWithVideoAutoPlayViewType f18521a = new StoryPageWithVideoAutoPlayViewType();
    private static StorySetAutoPlayPageRootPartDefinition f18522e;
    private static final Object f18523f = new Object();
    private final StorySetBasicPagePartDefinition<E> f18524b;
    private final StorySetPageVideoAttachmentPartDefinition<E> f18525c;
    private final RichVideoPlayerPartDefinition<E, RichVideoAttachmentView> f18526d;

    /* compiled from: key = ? */
    class StoryPageWithVideoAutoPlayViewType extends StorySetEmbededHeaderViewType<StoryPageWithVideoAutoPlayView> {
        public final View mo1995a(Context context) {
            return (StoryPageWithVideoAutoPlayView) m26000a(new StoryPageWithVideoAutoPlayView(context));
        }
    }

    private static StorySetAutoPlayPageRootPartDefinition m26002b(InjectorLike injectorLike) {
        return new StorySetAutoPlayPageRootPartDefinition(StorySetBasicPagePartDefinition.a(injectorLike), StorySetPageVideoAttachmentPartDefinition.a(injectorLike), RichVideoPlayerPartDefinition.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        FeedProps i = StoryProps.m27461i(storySetPageProps.b);
        subParts.mo2756a(this.f18524b, storySetPageProps);
        subParts.mo2755a(2131559579, this.f18525c, i);
        subParts.mo2755a(2131559579, this.f18526d, new Props(i, storySetPageProps.c, Absent.INSTANCE, new AtomicReference()));
        return null;
    }

    public static StorySetAutoPlayPageRootPartDefinition m26001a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetAutoPlayPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18523f) {
                StorySetAutoPlayPageRootPartDefinition storySetAutoPlayPageRootPartDefinition;
                if (a2 != null) {
                    storySetAutoPlayPageRootPartDefinition = (StorySetAutoPlayPageRootPartDefinition) a2.mo818a(f18523f);
                } else {
                    storySetAutoPlayPageRootPartDefinition = f18522e;
                }
                if (storySetAutoPlayPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26002b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18523f, b3);
                        } else {
                            f18522e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetAutoPlayPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public StorySetAutoPlayPageRootPartDefinition(StorySetBasicPagePartDefinition storySetBasicPagePartDefinition, StorySetPageVideoAttachmentPartDefinition storySetPageVideoAttachmentPartDefinition, RichVideoPlayerPartDefinition richVideoPlayerPartDefinition) {
        this.f18524b = storySetBasicPagePartDefinition;
        this.f18525c = storySetPageVideoAttachmentPartDefinition;
        this.f18526d = richVideoPlayerPartDefinition;
    }

    public final ViewType<StoryPageWithVideoAutoPlayView> mo2547a() {
        f18521a.f18520a = this.f18524b.a();
        return f18521a;
    }
}
