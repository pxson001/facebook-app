package com.facebook.timeline.aboutpage.summary;

import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Location is not supported on device */
public class SummaryConnectionConfigurationHelper {
    private final QeAccessor f13653a;

    public static SummaryConnectionConfigurationHelper m14849b(InjectorLike injectorLike) {
        return new SummaryConnectionConfigurationHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SummaryConnectionConfigurationHelper(QeAccessor qeAccessor) {
        this.f13653a = qeAccessor;
    }

    public final boolean m14850a(CollectionStyleMapper collectionStyleMapper, CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel) {
        if (collectionsAppSectionWithItemsOrRequestablesModel == null || collectionsAppSectionWithItemsOrRequestablesModel.m14588o() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14588o().m14562a().isEmpty()) {
            return false;
        }
        ImmutableList a = collectionsAppSectionWithItemsOrRequestablesModel.m14588o().m14562a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) a.get(i);
            GraphQLTimelineAppCollectionStyle a2 = collectionStyleMapper.m14916a(collectionWithItemsOrRequestablesModel.mo396d());
            if (a2 == GraphQLTimelineAppCollectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                return false;
            }
            if ((a2 == GraphQLTimelineAppCollectionStyle.ABOUT || a2 == GraphQLTimelineAppCollectionStyle.CONTACT_LIST) && this.f13653a.a(ExperimentsForTimelineAbTestModule.ax, false)) {
                return false;
            }
            boolean z = ((collectionWithItemsOrRequestablesModel.m14530l() == null || collectionWithItemsOrRequestablesModel.m14530l().m14346b().isEmpty()) && (collectionWithItemsOrRequestablesModel.m14529k() == null || collectionWithItemsOrRequestablesModel.m14529k().m14409a().isEmpty())) ? false : true;
            if (!z) {
                return false;
            }
        }
        return true;
    }
}
