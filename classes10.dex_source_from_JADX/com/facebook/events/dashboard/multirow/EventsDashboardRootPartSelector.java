package com.facebook.events.dashboard.multirow;

import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironment;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.feed.ReactionRootPartDefinition;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: com.facebook.sdk.APP_EVENTS_FLUSHED */
public class EventsDashboardRootPartSelector extends BaseMultiRowGroupPartDefinition<Object, Void, EventsDashboardEnvironment> {
    private final Map<EventsDashboardPartDefinitionKey, Lazy<? extends MultiRowPartWithIsNeeded>> f17091a = new HashMap();

    public static EventsDashboardRootPartSelector m17398b(InjectorLike injectorLike) {
        return new EventsDashboardRootPartSelector(IdBasedLazy.a(injectorLike, 5566), IdBasedLazy.a(injectorLike, 5567), IdBasedLazy.a(injectorLike, 5568), IdBasedLazy.a(injectorLike, 5569), IdBasedLazy.a(injectorLike, 5570), IdBasedLazy.a(injectorLike, 5574), IdBasedLazy.a(injectorLike, 5575), IdBasedLazy.a(injectorLike, 5571), IdBasedLazy.a(injectorLike, 9857));
    }

    public final Object m17399a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        if (obj != null) {
            EventsDashboardItem eventsDashboardItem = (EventsDashboardItem) obj;
            Object obj2 = ((EventsDashboardItem) obj).f17049a;
            Lazy lazy = (Lazy) this.f17091a.get(eventsDashboardItem.f17050b);
            Preconditions.checkNotNull(lazy, "Part definition is not specified for " + obj2);
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) lazy.get(), obj2);
        }
        return null;
    }

    @Inject
    public EventsDashboardRootPartSelector(Lazy<EventsBirthdayRowPartDefinition> lazy, Lazy<EventsDashboardDateBucketHeaderPartDefinition> lazy2, Lazy<EventsDashboardEventRowPartDefinition> lazy3, Lazy<EventsDashboardLoadingRowPartDefinition> lazy4, Lazy<EventsDashboardNullStateRowPartDefinition> lazy5, Lazy<EventsDashboardViewAllEventsRowPartDefinition> lazy6, Lazy<EventsDashboardViewMoreEventsRowPartDefinition> lazy7, Lazy<EventsDashboardPromptRowPartDefinition> lazy8, Lazy<ReactionRootPartDefinition> lazy9) {
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17086h, lazy);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17079a, lazy2);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17080b, lazy3);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17081c, lazy4);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17082d, lazy5);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17084f, lazy6);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17083e, lazy7);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17087i, lazy8);
        this.f17091a.put(EventsDashboardPartDefinitionKey.f17085g, lazy9);
    }

    public final boolean m17400a(Object obj) {
        return true;
    }
}
