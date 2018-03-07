package com.facebook.events.permalink.calltoaction;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.ComposerPublishServiceHelper.PublishLogger;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventStatus;
import com.facebook.events.eventsevents.EventsEvents.PostEvent;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.fb4a.Fb4aSoundUtil;
import javax.inject.Inject;

/* compiled from: button1 */
public class EventCheckinButtonActivityResultHandler {
    public final DefaultAndroidThreadUtil f18282a;
    public final ComposerPublishServiceHelper f18283b;
    public final EventsEventBus f18284c;
    public final EventEventLogger f18285d;
    public final FBSoundUtil f18286e;

    /* compiled from: button1 */
    public class C25881 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ EventCheckinButtonActivityResultHandler f18279a;

        public C25881(EventCheckinButtonActivityResultHandler eventCheckinButtonActivityResultHandler) {
            this.f18279a = eventCheckinButtonActivityResultHandler;
        }

        protected final void m18634a(Object obj) {
            this.f18279a.f18286e.b("post_main");
            this.f18279a.f18284c.a(new PostEvent(EventStatus.SUCCESS));
        }

        protected final void m18635a(Throwable th) {
            this.f18279a.f18284c.a(new PostEvent(EventStatus.FAILURE));
        }
    }

    /* compiled from: button1 */
    public class CheckPublishLogger implements PublishLogger {
        private final String f18280a;
        private final EventEventLogger f18281b;

        public CheckPublishLogger(String str, EventEventLogger eventEventLogger) {
            this.f18280a = str;
            this.f18281b = eventEventLogger;
        }

        public final void m18636a(PublishPostParams publishPostParams) {
        }

        public final void m18639b(PublishPostParams publishPostParams) {
        }

        public final void m18637a(String str, PublishPostParams publishPostParams) {
            EventEventLogger eventEventLogger = this.f18281b;
            String str2 = this.f18280a;
            String str3 = publishPostParams.composerSessionId;
            String actionMechanism = ActionMechanism.CHECKIN_COMPOSER.toString();
            HoneyClientEventFast a = eventEventLogger.f17787i.a("event_checkin_posted", false);
            if (a.a()) {
                a.a("event_permalink");
                a.d(eventEventLogger.f17788j.b(eventEventLogger.f17785g));
                a.b("Event");
                a.c(str2);
                a.a("action_mechanism", actionMechanism);
                a.a("composer_session_id", str3);
                a.a("event_id", str2);
                a.b();
            }
        }

        public final void m18638a(String str, PublishPostParams publishPostParams, ServiceException serviceException) {
        }
    }

    public static EventCheckinButtonActivityResultHandler m18640a(InjectorLike injectorLike) {
        return new EventCheckinButtonActivityResultHandler(DefaultAndroidThreadUtil.b(injectorLike), ComposerPublishServiceHelper.b(injectorLike), EventsEventBus.a(injectorLike), EventEventLogger.m18119b(injectorLike), (FBSoundUtil) Fb4aSoundUtil.a(injectorLike));
    }

    @Inject
    public EventCheckinButtonActivityResultHandler(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ComposerPublishServiceHelper composerPublishServiceHelper, EventsEventBus eventsEventBus, EventEventLogger eventEventLogger, FBSoundUtil fBSoundUtil) {
        this.f18282a = defaultAndroidThreadUtil;
        this.f18283b = composerPublishServiceHelper;
        this.f18284c = eventsEventBus;
        this.f18285d = eventEventLogger;
        this.f18286e = fBSoundUtil;
    }
}
