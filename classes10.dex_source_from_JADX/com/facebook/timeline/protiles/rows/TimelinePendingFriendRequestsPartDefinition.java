package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.timeline.event.NavigationEvents.RecentStoriesInvalidatingNavigationEvent;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import com.facebook.timeline.protiles.model.TimelinePromptSource;
import com.facebook.timeline.protiles.views.PromptView;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptApproximateCountFieldsModel;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fb4a_timeline_disk_cache_snapshot_table */
public class TimelinePendingFriendRequestsPartDefinition extends MultiRowSinglePartDefinition<TimelinePromptData, String, AnyEnvironment, PromptView> {
    public static final ViewType f12351a = new C17491();
    private static TimelinePendingFriendRequestsPartDefinition f12352f;
    private static final Object f12353g = new Object();
    public final Provider<FbUriIntentHandler> f12354b;
    public final Provider<TimelineStoryEventBus> f12355c;
    private final ClickListenerPartDefinition f12356d;
    private final TextPartDefinition f12357e;

    /* compiled from: fb4a_timeline_disk_cache_snapshot_table */
    final class C17491 extends ViewType {
        C17491() {
        }

        public final View m12391a(Context context) {
            return new PromptView(context);
        }
    }

    private static TimelinePendingFriendRequestsPartDefinition m12393b(InjectorLike injectorLike) {
        return new TimelinePendingFriendRequestsPartDefinition(ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 616), IdBasedSingletonScopeProvider.a(injectorLike, 11217));
    }

    public final Object m12395a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final TimelinePromptSource timelinePromptSource = (TimelinePromptSource) ((TimelinePromptData) obj).a().get();
        subParts.a(this.f12356d, new OnClickListener(this) {
            final /* synthetic */ TimelinePendingFriendRequestsPartDefinition f12350b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1475917857);
                String str = timelinePromptSource.f12125e;
                if (!(this.f12350b.f12354b == null || str == null)) {
                    ((TimelineStoryEventBus) this.f12350b.f12355c.get()).a(new RecentStoriesInvalidatingNavigationEvent(null));
                    ((FbUriIntentHandler) this.f12350b.f12354b.get()).a(view.getContext(), str);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1378041377, a);
            }
        });
        subParts.a(this.f12357e, timelinePromptSource.f12124d);
        return timelinePromptSource.f12122b.isPresent() ? Integer.toString(((TimelinePromptApproximateCountFieldsModel) timelinePromptSource.f12122b.get()).a()) : null;
    }

    public final /* bridge */ /* synthetic */ void m12396a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -952648590);
        String str = (String) obj2;
        PromptView promptView = (PromptView) view;
        if (str != null) {
            promptView.setBadgeText(str);
        }
        Logger.a(8, EntryType.MARK_POP, -1609258217, a);
    }

    public final boolean m12397a(Object obj) {
        return ((TimelinePromptData) obj).d();
    }

    @Inject
    public TimelinePendingFriendRequestsPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, Provider<FbUriIntentHandler> provider, Provider<TimelineStoryEventBus> provider2) {
        this.f12354b = provider;
        this.f12355c = provider2;
        this.f12356d = clickListenerPartDefinition;
        this.f12357e = textPartDefinition;
    }

    public final ViewType m12394a() {
        return f12351a;
    }

    public static TimelinePendingFriendRequestsPartDefinition m12392a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelinePendingFriendRequestsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12353g) {
                TimelinePendingFriendRequestsPartDefinition timelinePendingFriendRequestsPartDefinition;
                if (a2 != null) {
                    timelinePendingFriendRequestsPartDefinition = (TimelinePendingFriendRequestsPartDefinition) a2.a(f12353g);
                } else {
                    timelinePendingFriendRequestsPartDefinition = f12352f;
                }
                if (timelinePendingFriendRequestsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12393b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12353g, b3);
                        } else {
                            f12352f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelinePendingFriendRequestsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
