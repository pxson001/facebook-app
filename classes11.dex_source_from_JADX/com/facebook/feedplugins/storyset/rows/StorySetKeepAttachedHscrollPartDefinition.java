package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.hscrollrecyclerview.KeepAttachedHScrollRecyclerView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: b47c2819c161625963f2857d5bcb970d */
public class StorySetKeepAttachedHscrollPartDefinition extends MultiRowSinglePartDefinition<FeedUnitAndChangePageListener<GraphQLStorySet>, Void, FeedEnvironment, KeepAttachedHScrollRecyclerView> {
    private static StorySetKeepAttachedHscrollPartDefinition f9660c;
    private static final Object f9661d = new Object();
    private final StorySetAttachmentStyleHScrollPartDefinition f9662a;
    private final VideoSetsQeAccessor f9663b;

    private static StorySetKeepAttachedHscrollPartDefinition m10149b(InjectorLike injectorLike) {
        return new StorySetKeepAttachedHscrollPartDefinition(StorySetAttachmentStyleHScrollPartDefinition.m10110a(injectorLike), VideoSetsQeAccessor.a(injectorLike));
    }

    public final Object m10151a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9662a, (FeedUnitAndChangePageListener) obj);
        return null;
    }

    public final boolean m10152a(Object obj) {
        return StorySetHelper.d((GraphQLStorySet) ((FeedUnitAndChangePageListener) obj).a.a) && this.f9663b.b();
    }

    @Inject
    public StorySetKeepAttachedHscrollPartDefinition(StorySetAttachmentStyleHScrollPartDefinition storySetAttachmentStyleHScrollPartDefinition, VideoSetsQeAccessor videoSetsQeAccessor) {
        this.f9662a = storySetAttachmentStyleHScrollPartDefinition;
        this.f9663b = videoSetsQeAccessor;
    }

    public final ViewType<KeepAttachedHScrollRecyclerView> m10150a() {
        return HScrollRecyclerViewRowType.c;
    }

    public static StorySetKeepAttachedHscrollPartDefinition m10148a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetKeepAttachedHscrollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9661d) {
                StorySetKeepAttachedHscrollPartDefinition storySetKeepAttachedHscrollPartDefinition;
                if (a2 != null) {
                    storySetKeepAttachedHscrollPartDefinition = (StorySetKeepAttachedHscrollPartDefinition) a2.a(f9661d);
                } else {
                    storySetKeepAttachedHscrollPartDefinition = f9660c;
                }
                if (storySetKeepAttachedHscrollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10149b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9661d, b3);
                        } else {
                            f9660c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetKeepAttachedHscrollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
