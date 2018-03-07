package com.facebook.timeline.searchbootstrap;

import com.facebook.ipc.profile.TimelineContext;
import com.facebook.profile.api.RelationshipType;
import com.facebook.search.bootstrap.PendingBootstrapEntitiesManager;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_referer */
public class TimelineBootstrapEntitiesManager {
    private final Provider<PendingBootstrapEntitiesManager> f12649a;
    private boolean f12650b;

    @Inject
    public TimelineBootstrapEntitiesManager(Provider<PendingBootstrapEntitiesManager> provider) {
        this.f12649a = provider;
    }

    public final void m12595a(@Nullable TimelineContext timelineContext, @Nullable TimelineHeaderUserData timelineHeaderUserData, String str) {
        if (timelineContext != null && timelineHeaderUserData != null && !this.f12650b) {
            RelationshipType relationshipType = RelationshipType.getRelationshipType(timelineContext.i(), timelineHeaderUserData.B(), timelineHeaderUserData.C());
            if (!(relationshipType.equals(RelationshipType.FRIEND) || relationshipType.equals(RelationshipType.SELF) || str.equals("pps".toString()) || str.contains("search"))) {
                PendingBootstrapEntitiesManager pendingBootstrapEntitiesManager = (PendingBootstrapEntitiesManager) this.f12649a.get();
                Long valueOf = Long.valueOf(timelineContext.b);
                if (pendingBootstrapEntitiesManager.e.size() < 20) {
                    pendingBootstrapEntitiesManager.e.add(valueOf);
                }
            }
            this.f12650b = true;
        }
    }
}
