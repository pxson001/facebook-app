package com.facebook.timeline.stories;

import android.content.Context;
import android.os.ParcelUuid;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.event.NavigationEvents.RecentStoriesInvalidatingNavigationEventSubscriber;
import com.facebook.timeline.stories.TimelineStoryEvents.RedirectToPermalinkEvent;
import com.facebook.timeline.stories.TimelineStoryEvents.RedirectToPermalinkEventSubscriber;
import javax.inject.Inject;

/* compiled from: extra_is_subcateory */
public class TimelineStoriesController {
    public final TimelineContext f12731a;
    public final TimelineStoriesDataFetcher f12732b;
    public final Context f12733c;
    public final FbUriIntentHandler f12734d;

    /* compiled from: extra_is_subcateory */
    public class C17841 extends RecentStoriesInvalidatingNavigationEventSubscriber {
        final /* synthetic */ TimelineStoriesController f12729a;

        public C17841(TimelineStoriesController timelineStoriesController, ParcelUuid parcelUuid) {
            this.f12729a = timelineStoriesController;
            super(parcelUuid);
        }

        public final void m12682b(FbEvent fbEvent) {
            if (this.f12729a.f12732b != null) {
                this.f12729a.f12732b.m10717a();
            }
        }
    }

    /* compiled from: extra_is_subcateory */
    public class C17852 extends RedirectToPermalinkEventSubscriber {
        final /* synthetic */ TimelineStoriesController f12730a;

        public C17852(TimelineStoriesController timelineStoriesController, ParcelUuid parcelUuid) {
            this.f12730a = timelineStoriesController;
            super(parcelUuid);
        }

        public final void m12684b(FbEvent fbEvent) {
            this.f12730a.f12734d.a(this.f12730a.f12733c, StringFormatUtil.formatStrLocaleSafe(FBLinks.aR, ((RedirectToPermalinkEvent) fbEvent).f12735a, null));
        }
    }

    @Inject
    public TimelineStoriesController(@Assisted TimelineContext timelineContext, @Assisted TimelineStoriesDataFetcher timelineStoriesDataFetcher, Context context, FbUriIntentHandler fbUriIntentHandler) {
        this.f12731a = timelineContext;
        this.f12732b = timelineStoriesDataFetcher;
        this.f12733c = context;
        this.f12734d = fbUriIntentHandler;
    }
}
