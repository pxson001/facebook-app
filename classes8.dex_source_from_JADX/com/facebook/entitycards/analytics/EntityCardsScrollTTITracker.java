package com.facebook.entitycards.analytics;

import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.entitycards.model.ScrollLoadError;
import com.facebook.entitycards.model.ScrollLoadTrigger;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: index_in_group */
public class EntityCardsScrollTTITracker {
    private final EntityCardsPerfLogger f10896a;
    public int f10897b;
    private Object f10898c;

    @Inject
    public EntityCardsScrollTTITracker(@Assisted EntityCardsPerfLogger entityCardsPerfLogger) {
        this.f10896a = entityCardsPerfLogger;
    }

    public final void m12833a(int i, Object obj) {
        if (this.f10897b != i || this.f10898c != obj) {
            if (!(this.f10898c instanceof ScrollLoadTrigger) && (obj instanceof ScrollLoadTrigger)) {
                this.f10896a.m12825a(m12831a(i));
            } else if (!(this.f10898c instanceof ScrollLoadTrigger) || (obj instanceof ScrollLoadTrigger)) {
                if (m12832d(this.f10898c) && m12832d(obj)) {
                    this.f10896a.m12825a(m12831a(i));
                    this.f10896a.m12826b(m12831a(i));
                }
            } else if (obj instanceof ScrollLoadError) {
                this.f10896a.m12824a();
            } else {
                this.f10896a.m12826b(m12831a(i));
            }
            this.f10898c = obj;
            this.f10897b = i;
        }
    }

    private boolean m12832d(Object obj) {
        return ((obj instanceof ScrollLoadTrigger) || (obj instanceof ScrollLoadError)) ? false : true;
    }

    private EntityCardsScrollDirection m12831a(int i) {
        return this.f10897b > i ? EntityCardsScrollDirection.LEFT : EntityCardsScrollDirection.RIGHT;
    }
}
