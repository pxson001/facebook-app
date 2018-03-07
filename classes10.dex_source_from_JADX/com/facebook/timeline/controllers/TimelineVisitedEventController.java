package com.facebook.timeline.controllers;

import android.os.ParcelUuid;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.event.TimelineVisitedEvent;
import com.facebook.timeline.event.TimelineVisitedEventSubscriber;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import javax.inject.Inject;

/* compiled from: group_invite_dialog_shown */
public class TimelineVisitedEventController {
    public final TimelineContext f10355a;
    public final ProtilesData f10356b;
    private final TimelineAllSectionsData f10357c;
    public final ProfileControllerDelegate f10358d;

    /* compiled from: group_invite_dialog_shown */
    public class C15241 extends TimelineVisitedEventSubscriber {
        final /* synthetic */ TimelineVisitedEventController f10354a;

        public C15241(TimelineVisitedEventController timelineVisitedEventController, ParcelUuid parcelUuid) {
            this.f10354a = timelineVisitedEventController;
            super(parcelUuid);
        }

        public final void m10481b(FbEvent fbEvent) {
            this.f10354a.f10356b.m12120a(((TimelineVisitedEvent) fbEvent).b);
            this.f10354a.f10358d.mo_();
        }
    }

    @Inject
    public TimelineVisitedEventController(@Assisted TimelineContext timelineContext, @Assisted TimelineAllSectionsData timelineAllSectionsData, ProtilesData protilesData, ProfileControllerDelegate profileControllerDelegate) {
        this.f10355a = timelineContext;
        this.f10357c = timelineAllSectionsData;
        this.f10356b = protilesData;
        this.f10358d = profileControllerDelegate;
    }
}
