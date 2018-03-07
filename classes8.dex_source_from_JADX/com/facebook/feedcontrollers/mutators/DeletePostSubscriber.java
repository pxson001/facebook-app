package com.facebook.feedcontrollers.mutators;

import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventBus;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEvent;
import com.facebook.timeline.event.TimelineStoryEventBus;
import javax.inject.Inject;

/* compiled from: group_admins */
public class DeletePostSubscriber {
    public final DeleteStoryHelper f11980a;
    public final Subscriber f11981b = new Subscriber(this);
    public final FbEventBus f11982c;

    /* compiled from: group_admins */
    class Subscriber extends FbEventSubscriber<DeleteStoryClickedEvent> {
        final /* synthetic */ DeletePostSubscriber f11979a;

        public Subscriber(DeletePostSubscriber deletePostSubscriber) {
            this.f11979a = deletePostSubscriber;
        }

        public final void m14063b(FbEvent fbEvent) {
            DeleteStoryClickedEvent deleteStoryClickedEvent = (DeleteStoryClickedEvent) fbEvent;
            this.f11979a.f11980a.a(new Params(deleteStoryClickedEvent.f9145a, null, deleteStoryClickedEvent.f9147c, DeleteMode.LOCAL_AND_SERVER));
        }

        public final Class<DeleteStoryClickedEvent> m14062a() {
            return DeleteStoryClickedEvent.class;
        }
    }

    public static DeletePostSubscriber m14064a(InjectorLike injectorLike) {
        return new DeletePostSubscriber(DeleteStoryHelper.b(injectorLike), TimelineStoryEventBus.m10934a(injectorLike));
    }

    @Inject
    public DeletePostSubscriber(DeleteStoryHelper deleteStoryHelper, TimelineStoryEventBus timelineStoryEventBus) {
        this.f11980a = deleteStoryHelper;
        this.f11982c = timelineStoryEventBus;
    }
}
