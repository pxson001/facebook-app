package com.facebook.graphql.model;

import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.ImmutableList;

/* compiled from: iorg_common */
public class FeedTrackableUtil {
    public static ArrayNode m27151a(CachedFeedTrackable cachedFeedTrackable) {
        ArrayNode a = PropertyHelper.m21262a(cachedFeedTrackable);
        if (a != null) {
            return a;
        }
        a = cachedFeedTrackable.R_();
        PropertyHelper.m21281a(cachedFeedTrackable, a);
        return a;
    }

    public static ArrayNode m27147a() {
        return new ArrayNode(JsonNodeFactory.f3121a);
    }

    public static ArrayNode m27149a(GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(graphQLPagesYouMayAdvertiseFeedUnit.mo2877k());
        ImmutableList s = graphQLPagesYouMayAdvertiseFeedUnit.m25621s();
        if (s == null || s.isEmpty()) {
            return null;
        }
        GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem = (GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0);
        if (graphQLPagesYouMayAdvertiseFeedUnitItem == null) {
            return null;
        }
        arrayNode.m13394h(graphQLPagesYouMayAdvertiseFeedUnitItem.k());
        return arrayNode;
    }

    public static ArrayNode m27152a(HasTracking hasTracking) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        String k = hasTracking.mo2877k();
        if (k != null) {
            arrayNode.m13394h(k);
        }
        return arrayNode;
    }

    public static ArrayNode m27150a(GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(graphQLQuickPromotionFeedUnit.m25842u());
        GraphQLQuickPromotionFeedUnitItem a = QuickPromotionFeedUnitHelper.a(graphQLQuickPromotionFeedUnit);
        if (a != null) {
            arrayNode.m13394h(a.m());
        }
        return arrayNode;
    }

    public static ArrayNode m27155c() {
        throw new UnsupportedOperationException("Use TrackableFeedProps.getTrackingCodes");
    }

    public static ArrayNode m27154b(HasTracking hasTracking) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        arrayNode.m13394h(hasTracking.mo2877k());
        return arrayNode;
    }

    public static ArrayNode m27156d() {
        throw new UnsupportedOperationException("Use TrackableFeedProps.getTrackingCodes");
    }

    public static ArrayNode m27148a(FeedUnit feedUnit) {
        if (feedUnit instanceof CachedFeedTrackable) {
            ArrayNode a = PropertyHelper.m21262a((CachedFeedTrackable) feedUnit);
            if (a != null) {
                return a;
            }
        }
        if (feedUnit instanceof GraphQLStory) {
            return m27154b((GraphQLStory) feedUnit);
        }
        return m27153a((Object) feedUnit);
    }

    public static ArrayNode m27153a(Object obj) {
        if (obj instanceof GraphQLStory) {
            throw new UnsupportedOperationException("Use TrackableFeedProps.getTrackingCodes to get tracking codes for a Story");
        } else if (obj instanceof GraphQLStoryAttachment) {
            throw new UnsupportedOperationException("Use TrackableFeedProps.getTrackingCodes to get tracking codes for an Attachment");
        } else if (obj instanceof CachedFeedTrackable) {
            return m27151a((CachedFeedTrackable) obj);
        } else {
            if (obj instanceof GraphQLComment) {
                return m27147a();
            }
            if (obj instanceof GraphQLPagesYouMayAdvertiseFeedUnit) {
                return m27149a((GraphQLPagesYouMayAdvertiseFeedUnit) obj);
            }
            if (obj instanceof GraphQLCreativePagesYouMayLikeFeedUnit) {
                return VisibleItemHelper.m26982c((GraphQLCreativePagesYouMayLikeFeedUnit) obj);
            }
            ArrayNode arrayNode;
            if (obj instanceof GraphQLPeopleYouShouldFollowFeedUnit) {
                GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit = (GraphQLPeopleYouShouldFollowFeedUnit) obj;
                arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
                if (graphQLPeopleYouShouldFollowFeedUnit == null || graphQLPeopleYouShouldFollowFeedUnit.mo2877k() == null) {
                    arrayNode = null;
                } else {
                    arrayNode.m13394h(graphQLPeopleYouShouldFollowFeedUnit.mo2877k());
                }
                return arrayNode;
            } else if (obj instanceof GraphQLPagesYouMayLikeFeedUnit) {
                return VisibleItemHelper.m26982c((GraphQLPagesYouMayLikeFeedUnit) obj);
            } else {
                if (obj instanceof GraphQLPYMLWithLargeImageFeedUnit) {
                    return VisibleItemHelper.m26982c((GraphQLPYMLWithLargeImageFeedUnit) obj);
                }
                if (obj instanceof GraphQLQuickPromotionFeedUnit) {
                    return m27150a((GraphQLQuickPromotionFeedUnit) obj);
                }
                if (obj instanceof GraphQLSavedCollectionFeedUnit) {
                    return VisibleItemHelper.m26982c((GraphQLSavedCollectionFeedUnit) obj);
                }
                if (obj instanceof GraphQLStoryGallerySurveyFeedUnit) {
                    return new ArrayNode(JsonNodeFactory.f3121a);
                }
                if (!(obj instanceof GraphQLStorySet)) {
                    return null;
                }
                GraphQLStorySet graphQLStorySet = (GraphQLStorySet) obj;
                if (graphQLStorySet.mo2895u()) {
                    CachedFeedTrackable a = StorySetHelper.a(graphQLStorySet);
                    if (a == null) {
                        arrayNode = null;
                    } else {
                        arrayNode = PropertyHelper.m21262a(a);
                        if (arrayNode == null) {
                            arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
                            if (a.mo2877k() != null) {
                                arrayNode.m13394h(a.mo2877k());
                            }
                            arrayNode.m13394h(graphQLStorySet.mo2877k());
                            PropertyHelper.m21281a(a, arrayNode);
                        }
                    }
                } else {
                    arrayNode = m27154b(graphQLStorySet);
                }
                return arrayNode;
            }
        }
    }
}
