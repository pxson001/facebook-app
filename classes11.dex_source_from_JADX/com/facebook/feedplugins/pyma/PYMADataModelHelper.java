package com.facebook.feedplugins.pyma;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitItem;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitsConnection;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnitsEdge;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnitItem;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collections_collection_prelim */
public class PYMADataModelHelper {
    private static PYMADataModelHelper f8618b;
    private static final Object f8619c = new Object();
    public final PYMAAnalyticsHelper f8620a;

    private static PYMADataModelHelper m9460b(InjectorLike injectorLike) {
        return new PYMADataModelHelper(PYMAAnalyticsHelper.m9456a(injectorLike));
    }

    @Inject
    public PYMADataModelHelper(PYMAAnalyticsHelper pYMAAnalyticsHelper) {
        this.f8620a = pYMAAnalyticsHelper;
    }

    @Nullable
    public final FeedProps<GraphQLPYMLWithLargeImageFeedUnitItem> m9461a(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps) {
        FeedProps<GraphQLPYMLWithLargeImageFeedUnitItem> feedProps2;
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        GraphQLPYMLWithLargeImageFeedUnit a = m9462a(feedProps, true);
        if (a == null) {
            feedProps2 = null;
        } else {
            GraphQLPYMLWithLargeImageFeedUnitsConnection B = a.B();
            if (B == null) {
                if (1 != null) {
                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: pymlItems is null");
                }
                feedProps2 = null;
            } else {
                ImmutableList a2 = B.a();
                if (a2 == null) {
                    if (1 != null) {
                        this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: pymlItems.getEdges() is null");
                    }
                    feedProps2 = null;
                } else if (a2.isEmpty()) {
                    if (1 != null) {
                        this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: pymlItems.getEdges() is empty");
                    }
                    feedProps2 = null;
                } else {
                    GraphQLPYMLWithLargeImageFeedUnitItem a3 = ((GraphQLPYMLWithLargeImageFeedUnitsEdge) a2.get(0)).a();
                    if (a3 == null) {
                        if (1 != null) {
                            this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: node is null");
                        }
                        feedProps2 = null;
                    } else {
                        Object obj;
                        if (a3.D() == null || a3.D().ae() == null || a3.D().aG() == null || a3.v() == null || a3.v().c() == 0 || a3.v().a() == 0) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            if (1 != null) {
                                if (a3.D() == null) {
                                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnitItem.getProfile() == null");
                                } else if (a3.D().ae() == null) {
                                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnitItem.getProfile().getId() == null");
                                } else if (a3.D().aG() == null) {
                                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnitItem.getProfile().getName() == null");
                                } else if (a3.v() == null) {
                                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnitItem.getCreativeImage() == null");
                                } else if (a3.v().c() == 0) {
                                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnitItem.getCreativeImage().getWidth() == 0");
                                } else if (a3.v().a() == 0) {
                                    this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnitItem.getCreativeImage().getHeight() == 0");
                                }
                            }
                            feedProps2 = null;
                        } else {
                            feedProps2 = FeedProps.a(a3, ImmutableList.of(graphQLPagesYouMayAdvertiseFeedUnit));
                        }
                    }
                }
            }
        }
        return feedProps2;
    }

    public static PYMADataModelHelper m9459a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PYMADataModelHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8619c) {
                PYMADataModelHelper pYMADataModelHelper;
                if (a2 != null) {
                    pYMADataModelHelper = (PYMADataModelHelper) a2.a(f8619c);
                } else {
                    pYMADataModelHelper = f8618b;
                }
                if (pYMADataModelHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9460b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8619c, b3);
                        } else {
                            f8618b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pYMADataModelHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Nullable
    public final GraphQLPYMLWithLargeImageFeedUnit m9462a(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps, boolean z) {
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        ImmutableList s = graphQLPagesYouMayAdvertiseFeedUnit.s();
        if (s.isEmpty()) {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: feedUnit.getItems() is empty.");
            }
            return null;
        }
        GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem = (GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0);
        if (graphQLPagesYouMayAdvertiseFeedUnitItem == null) {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: 0th GraphQLPagesYouMayAdvertiseFeedUnitItem is null, list size: " + s.size());
            }
            return null;
        }
        FeedUnit j = graphQLPagesYouMayAdvertiseFeedUnitItem.j();
        if (j == null) {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: FeedUnitPreview is null");
            }
            return null;
        } else if (j instanceof GraphQLPYMLWithLargeImageFeedUnit) {
            return (GraphQLPYMLWithLargeImageFeedUnit) j;
        } else {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid PageLike unit: FeedUnitPreview is not an instanceof GraphQLPYMLWithLargeImageFeedUnit, class: " + j.getClass().getName() + ", GraphQLType: " + j.getType());
            }
            return null;
        }
    }

    @Nullable
    public final FeedProps<GraphQLStory> m9463b(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps) {
        return m9464b(feedProps, true);
    }

    @Nullable
    public final FeedProps<GraphQLStory> m9464b(FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit> feedProps, boolean z) {
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        ImmutableList s = graphQLPagesYouMayAdvertiseFeedUnit.s();
        if (s.isEmpty()) {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid GraphQLStory unit: feedUnit.getItems() is empty.");
            }
            return null;
        }
        GraphQLPagesYouMayAdvertiseFeedUnitItem graphQLPagesYouMayAdvertiseFeedUnitItem = (GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0);
        if (graphQLPagesYouMayAdvertiseFeedUnitItem == null) {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid GraphQLStory unit: feedItems.get(0) == null, size: " + s.size());
            }
            return null;
        }
        FeedUnit j = graphQLPagesYouMayAdvertiseFeedUnitItem.j();
        if (j == null) {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid GraphQLStory unit: feed unit preview is null");
            }
            return null;
        } else if (j instanceof GraphQLStory) {
            return FeedProps.a((GraphQLStory) j, ImmutableList.of(graphQLPagesYouMayAdvertiseFeedUnit));
        } else {
            if (z) {
                this.f8620a.m9458a(graphQLPagesYouMayAdvertiseFeedUnit, "Invalid GraphQLStory unit: FeedUnitPreview is not an instanceof GraphQLStory, class: " + j.getClass().getName() + ", GraphQLType: " + j.getType());
            }
            return null;
        }
    }
}
