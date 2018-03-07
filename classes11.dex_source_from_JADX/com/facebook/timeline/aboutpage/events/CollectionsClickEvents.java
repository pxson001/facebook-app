package com.facebook.timeline.aboutpage.events;

import android.os.Bundle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;

/* compiled from: NOT_DONATED */
public class CollectionsClickEvents {

    /* compiled from: NOT_DONATED */
    public abstract class CollectionCurationClickEventSubscriber extends CollectionsEventSubscriber<CollectionCurationClickEvent> {
        public final Class<CollectionCurationClickEvent> m13744a() {
            return CollectionCurationClickEvent.class;
        }
    }

    /* compiled from: NOT_DONATED */
    public abstract class DeleteExperienceEventSubscriber extends CollectionsEventSubscriber<DeleteExperienceEvent> {
        public final Class<DeleteExperienceEvent> m13795a() {
            return DeleteExperienceEvent.class;
        }
    }

    /* compiled from: NOT_DONATED */
    public abstract class RedirectToUriEventSubscriber extends CollectionsEventSubscriber<RedirectToUriEvent> {
        public final Class<RedirectToUriEvent> m13823a() {
            return RedirectToUriEvent.class;
        }
    }

    /* compiled from: NOT_DONATED */
    public class CollectionCurationClickEvent extends CollectionsEvent {
        public final String f13139a;

        public CollectionCurationClickEvent(String str) {
            this.f13139a = str;
        }
    }

    /* compiled from: NOT_DONATED */
    public class CollectionTitleClickEvent extends CollectionsEvent {
        public final String f13140a;
        public final Bundle f13141b;
        public final String f13142c;
        public final CollectionWithItemsAndSuggestions f13143d;
        public final GraphQLTimelineAppSectionType f13144e;
        public final DefaultImageFields f13145f;
        public final String f13146g;

        public CollectionTitleClickEvent(String str, Bundle bundle, String str2, CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, DefaultImageFields defaultImageFields, String str3) {
            this.f13140a = str;
            this.f13141b = bundle;
            this.f13142c = str2;
            this.f13143d = collectionWithItemsAndSuggestions;
            this.f13144e = graphQLTimelineAppSectionType;
            this.f13145f = defaultImageFields;
            this.f13146g = str3;
        }
    }

    /* compiled from: NOT_DONATED */
    public abstract class CollectionTitleClickEventSubscriber extends CollectionsEventSubscriber<CollectionTitleClickEvent> {
        public final Class<CollectionTitleClickEvent> m13928a() {
            return CollectionTitleClickEvent.class;
        }
    }

    /* compiled from: NOT_DONATED */
    public class DeleteExperienceEvent extends CollectionsEvent {
        public final String f13147a;

        public DeleteExperienceEvent(String str) {
            this.f13147a = str;
        }
    }

    /* compiled from: NOT_DONATED */
    public class RedirectToUriEvent extends CollectionsEvent {
        public final String f13148a;

        public RedirectToUriEvent(String str) {
            this.f13148a = str;
        }
    }
}
