package com.facebook.pages.common.scoped_eventbus.scopedevent;

import android.os.ParcelUuid;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.google.common.base.Optional;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: creativecam_working_image_ */
public class PageScopedEventsSubscribers {

    /* compiled from: creativecam_working_image_ */
    public class EventsSubscribeStatusChangedEvent extends PageScopedEvent<Long> {
        public final GraphQLEventsCalendarSubscriptionStatus f16574b;

        public EventsSubscribeStatusChangedEvent(Long l, GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus) {
            super(l);
            this.f16574b = graphQLEventsCalendarSubscriptionStatus;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class EventsSubscribeStatusChangedEventSubscriber extends PageScopedEventSubscriber<Long, EventsSubscribeStatusChangedEvent> {
        public EventsSubscribeStatusChangedEventSubscriber(Long l) {
            super(l);
        }

        public final Class<EventsSubscribeStatusChangedEvent> m19598a() {
            return EventsSubscribeStatusChangedEvent.class;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public class NeedToShowSuggestedPagesEvent extends PageScopedEvent<ParcelUuid> {
        public NeedToShowSuggestedPagesEvent(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class NeedToShowSuggestedPagesEventSubscriber extends PageScopedEventSubscriber<ParcelUuid, NeedToShowSuggestedPagesEvent> {
        public NeedToShowSuggestedPagesEventSubscriber(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }

        public final Class<NeedToShowSuggestedPagesEvent> m19599a() {
            return NeedToShowSuggestedPagesEvent.class;
        }
    }

    @Immutable
    /* compiled from: creativecam_working_image_ */
    public class PageFragmentScopedHeaderPerfLoggingEvent extends PageScopedEvent<ParcelUuid> {
        @Nonnull
        public final Optional<DataFreshnessResult> f16575b;
        @Nonnull
        public final HeaderPerfLoggingEventType f16576c;
        @Nullable
        public final Map<String, String> f16577d;

        /* compiled from: creativecam_working_image_ */
        public enum HeaderPerfLoggingEventType {
            ACTION_BAR_DISPATCH_DRAW_WITH_DATA("ActionBar"),
            CALL_TO_ACTION("CallToAction"),
            CONTEXT_ITEMS_DISPATCH_DRAW("ContextItems"),
            COVER_PHOTO_COMPLETE("CoverPhoto"),
            HEADER_DISPATCH_DRAW_HAS_DATA("HeaderDraw"),
            IS_ADMIN_KNOWN("IsAdminKnown"),
            PROFILE_PHOTO_COMPLETE("ProfilePhoto"),
            METABAX("Metabox");
            
            public String perfTagName;

            private HeaderPerfLoggingEventType(String str) {
                this.perfTagName = str;
            }
        }

        public PageFragmentScopedHeaderPerfLoggingEvent(ParcelUuid parcelUuid, HeaderPerfLoggingEventType headerPerfLoggingEventType, Optional<DataFreshnessResult> optional) {
            this(parcelUuid, headerPerfLoggingEventType, optional, null);
        }

        public PageFragmentScopedHeaderPerfLoggingEvent(ParcelUuid parcelUuid, HeaderPerfLoggingEventType headerPerfLoggingEventType, Optional<DataFreshnessResult> optional, @Nullable Map<String, String> map) {
            super(parcelUuid);
            this.f16575b = optional;
            this.f16576c = headerPerfLoggingEventType;
            this.f16577d = map;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class PageFragmentScopedHeaderPerfLoggingEventSubscriber extends PageScopedEventSubscriber<ParcelUuid, PageFragmentScopedHeaderPerfLoggingEvent> {
        public PageFragmentScopedHeaderPerfLoggingEventSubscriber(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }

        public final Class<PageFragmentScopedHeaderPerfLoggingEvent> m19600a() {
            return PageFragmentScopedHeaderPerfLoggingEvent.class;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public class PageTimelineFirstLoadEvent extends PageScopedEvent<ParcelUuid> {
        public PageTimelineFirstLoadEvent(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class PageTimelineFirstLoadEventSubscriber extends PageScopedEventSubscriber<ParcelUuid, PageTimelineFirstLoadEvent> {
        public PageTimelineFirstLoadEventSubscriber(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }

        public final Class<PageTimelineFirstLoadEvent> m19601a() {
            return PageTimelineFirstLoadEvent.class;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public class PagesInsightsContextItemClickEvent extends PageScopedEvent<ParcelUuid> {
        public final GraphQLEntityCardContextItemType f16578b;

        public PagesInsightsContextItemClickEvent(ParcelUuid parcelUuid, GraphQLEntityCardContextItemType graphQLEntityCardContextItemType) {
            super(parcelUuid);
            this.f16578b = graphQLEntityCardContextItemType;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class PagesInsightsContextItemClickEventSubscriber extends PageScopedEventSubscriber<ParcelUuid, PagesInsightsContextItemClickEvent> {
        public PagesInsightsContextItemClickEventSubscriber(ParcelUuid parcelUuid) {
            super(parcelUuid);
        }

        public final Class<PagesInsightsContextItemClickEvent> m19602a() {
            return PagesInsightsContextItemClickEvent.class;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public class PhotoMenuUploadStartedEvent extends PageScopedEvent<Long> {
        public PhotoMenuUploadStartedEvent(Long l) {
            super(l);
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class PhotoMenuUploadStartedEventSubscriber extends PageScopedEventSubscriber<Long, PhotoMenuUploadStartedEvent> {
        public PhotoMenuUploadStartedEventSubscriber(Long l) {
            super(l);
        }

        public final Class<PhotoMenuUploadStartedEvent> m19603a() {
            return PhotoMenuUploadStartedEvent.class;
        }
    }

    /* compiled from: creativecam_working_image_ */
    public class PlaceQuestionAnsweredEvent extends PageScopedEvent<Long> {
        public PlaceQuestionAnsweredEvent(Long l) {
            super(l);
        }
    }

    /* compiled from: creativecam_working_image_ */
    public abstract class PlaceQuestionAnsweredEventSubscriber extends PageScopedEventSubscriber<Long, PlaceQuestionAnsweredEvent> {
        public PlaceQuestionAnsweredEventSubscriber(Long l) {
            super(l);
        }

        public final Class<PlaceQuestionAnsweredEvent> m19604a() {
            return PlaceQuestionAnsweredEvent.class;
        }
    }
}
