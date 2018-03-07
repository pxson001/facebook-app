package com.facebook.events.permalink.multirow;

import com.facebook.events.permalink.multirow.environment.EventPermalinkEnvironment;
import com.facebook.events.permalink.pinnedpost.PinnedPostGroupPartDefinition;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.MultiRowSubParts;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: bc72fb48a881c9568114877f6062d8df */
public class EventPermalinkRootPartSelector extends BaseMultiRowGroupPartDefinition<Object, Void, EventPermalinkEnvironment> {
    private final Map<EventPartDefinitionKey, Lazy<? extends MultiRowPartWithIsNeeded>> f18714a = new HashMap();

    @Inject
    public EventPermalinkRootPartSelector(Lazy<EventFeedComposerRootPartDefinition> lazy, Lazy<PostingStoryProgressBarRootPartDefinition> lazy2, Lazy<PinnedPostGroupPartDefinition> lazy3, Lazy<NewsFeedRootGroupPartDefinition> lazy4) {
        m18999a(EventPartDefinitionKey.f18707a, lazy);
        m18999a(EventPartDefinitionKey.f18709c, lazy3);
        m18999a(EventPartDefinitionKey.f18708b, lazy4);
        m18999a(EventPartDefinitionKey.f18711e, lazy2);
    }

    private <Props> void m18999a(EventPartDefinitionKey<Props> eventPartDefinitionKey, Lazy<? extends MultiRowPartWithIsNeeded<? super Props, ? extends AnyEnvironment>> lazy) {
        this.f18714a.put(eventPartDefinitionKey, lazy);
    }

    public final boolean m19002a(Object obj) {
        return true;
    }

    public final Object m19001a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        if (obj instanceof EventPermalinkNode) {
            EventPermalinkNode eventPermalinkNode = (EventPermalinkNode) obj;
            m19000a(baseMultiRowSubParts, eventPermalinkNode.f18713b, eventPermalinkNode.f18712a);
        } else if (obj instanceof FeedUnit) {
            m19000a(baseMultiRowSubParts, EventPartDefinitionKey.f18708b, obj);
        }
        return null;
    }

    private void m19000a(MultiRowSubParts<EventPermalinkEnvironment> multiRowSubParts, EventPartDefinitionKey<?> eventPartDefinitionKey, Object obj) {
        Lazy lazy = (Lazy) this.f18714a.get(eventPartDefinitionKey);
        Preconditions.checkNotNull(lazy, "Part definition is not specified for " + obj);
        multiRowSubParts.a((MultiRowPartWithIsNeeded) lazy.get(), obj);
    }
}
