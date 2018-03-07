package com.facebook.saved.event;

import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.saved.data.SavedDashboardItem;

/* compiled from: is_birthday_today */
public class SavedEvents {

    /* compiled from: is_birthday_today */
    public abstract class SavedItemMutatedEventSubscriber extends SavedEventSubscriber<SavedItemMutatedEvent> {
        public final Class<SavedItemMutatedEvent> m9074a() {
            return SavedItemMutatedEvent.class;
        }
    }

    /* compiled from: is_birthday_today */
    public abstract class SavedItemReviewedSubscriber extends SavedEventSubscriber<SavedItemReviewedEvent> {
        public final Class<SavedItemReviewedEvent> m9076a() {
            return SavedItemReviewedEvent.class;
        }
    }

    /* compiled from: is_birthday_today */
    public class SavedItemMutatedEvent extends SavedEvent {
        public final SavedDashboardItem f9128a;

        public SavedItemMutatedEvent(SavedDashboardItem savedDashboardItem) {
            this.f9128a = savedDashboardItem;
        }
    }

    /* compiled from: is_birthday_today */
    public class SavedItemReviewedEvent extends SavedEvent {
        public final ReviewBasicFields f9129a;
        public final String f9130b;

        public SavedItemReviewedEvent(ReviewBasicFields reviewBasicFields, String str) {
            this.f9129a = reviewBasicFields;
            this.f9130b = str;
        }
    }
}
