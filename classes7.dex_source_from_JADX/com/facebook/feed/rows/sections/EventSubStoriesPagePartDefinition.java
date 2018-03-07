package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.EventAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.ui.EventSubStoryItemView;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
/* compiled from: __RCTProfileIsProfiling */
public class EventSubStoriesPagePartDefinition<E extends CanFeedback & CanShowVideoInFullScreen & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, EventSubStoryItemView> {
    public static final ViewType<EventSubStoryItemView> f20359a = new C17561();
    private static EventSubStoriesPagePartDefinition f20360e;
    private static final Object f20361f = new Object();
    private final BlingBarPartDefinition f20362b;
    private final EventAttachmentPartDefinition f20363c;
    private final EventSubStoryFooterPartDefinition f20364d;

    /* compiled from: __RCTProfileIsProfiling */
    final class C17561 extends ViewType<EventSubStoryItemView> {
        C17561() {
        }

        public final View m23485a(Context context) {
            return new EventSubStoryItemView(context);
        }
    }

    private static EventSubStoriesPagePartDefinition m23487b(InjectorLike injectorLike) {
        return new EventSubStoriesPagePartDefinition(BlingBarPartDefinition.m25426a(injectorLike), EventAttachmentPartDefinition.a(injectorLike), EventSubStoryFooterPartDefinition.m23491a(injectorLike));
    }

    public final Object m23489a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(2131561428, this.f20362b, new Props(feedProps, true));
        subParts.a(2131561429, this.f20364d, feedProps);
        subParts.a(2131561426, this.f20363c, feedProps.a(StoryAttachmentHelper.o(graphQLStory)));
        return null;
    }

    @Inject
    public EventSubStoriesPagePartDefinition(BlingBarPartDefinition blingBarPartDefinition, EventAttachmentPartDefinition eventAttachmentPartDefinition, EventSubStoryFooterPartDefinition eventSubStoryFooterPartDefinition) {
        this.f20362b = blingBarPartDefinition;
        this.f20363c = eventAttachmentPartDefinition;
        this.f20364d = eventSubStoryFooterPartDefinition;
    }

    public static EventSubStoriesPagePartDefinition m23486a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventSubStoriesPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20361f) {
                EventSubStoriesPagePartDefinition eventSubStoriesPagePartDefinition;
                if (a2 != null) {
                    eventSubStoriesPagePartDefinition = (EventSubStoriesPagePartDefinition) a2.a(f20361f);
                } else {
                    eventSubStoriesPagePartDefinition = f20360e;
                }
                if (eventSubStoriesPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23487b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20361f, b3);
                        } else {
                            f20360e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventSubStoriesPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<EventSubStoryItemView> m23488a() {
        return f20359a;
    }

    public final boolean m23490a(Object obj) {
        return true;
    }
}
