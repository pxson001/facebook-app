package com.facebook.timeline.aboutpage.summary;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionItemType;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory.SummaryListItem;
import javax.inject.Inject;

/* compiled from: MESSAGE */
public class CollectionItemsLoggingViewportListener extends BaseViewportEventListener {
    public final CollectionsSummaryAnalyticsLogger f13559a;
    public final ProfileViewerContext f13560b;

    @Inject
    public CollectionItemsLoggingViewportListener(@Assisted CollectionsSummaryAnalyticsLogger collectionsSummaryAnalyticsLogger, @Assisted ProfileViewerContext profileViewerContext) {
        this.f13559a = collectionsSummaryAnalyticsLogger;
        this.f13560b = profileViewerContext;
    }

    public final void m14780a(Object obj) {
        if (obj instanceof SummaryListItem) {
            AppCollectionItemModel appCollectionItemModel = ((SummaryListItem) obj).f13633a;
            if (appCollectionItemModel != null) {
                GraphQLTimelineAppCollectionItemType b = appCollectionItemModel.m14293b();
                if (b != GraphQLTimelineAppCollectionItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                    CollectionsAnalyticsLogger collectionsAnalyticsLogger = this.f13559a;
                    String str = this.f13560b.a;
                    RelationshipType a = CollectionsAnalyticsLogger.m13739a(this.f13560b);
                    if (!collectionsAnalyticsLogger.f13595b.contains(b)) {
                        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("profile_about_item_vpv");
                        honeyClientEvent.c = collectionsAnalyticsLogger.mo370b();
                        honeyClientEvent = honeyClientEvent;
                        honeyClientEvent.b("profile_id", str);
                        if (!(a == null || a == RelationshipType.UNDEFINED)) {
                            honeyClientEvent.a("relationship_type", a.getValue());
                        }
                        honeyClientEvent.b("item_type", b.name());
                        collectionsAnalyticsLogger.f12997a.a(honeyClientEvent);
                        collectionsAnalyticsLogger.f13595b.add(b);
                    }
                }
            }
        }
    }
}
