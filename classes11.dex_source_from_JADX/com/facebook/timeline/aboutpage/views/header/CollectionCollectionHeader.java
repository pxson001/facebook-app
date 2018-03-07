package com.facebook.timeline.aboutpage.views.header;

import android.content.Context;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.views.CollectionTitleBarView;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: Ljava/lang/Long; */
public class CollectionCollectionHeader extends CustomLinearLayout {
    public final CollectionTitleBarView f13959a = ((CollectionTitleBarView) a(2131560345));

    public CollectionCollectionHeader(Context context) {
        super(context);
        setContentView(2130903586);
        setOrientation(1);
        setPadding(0, 0, 0, context.getResources().getDimensionPixelSize(2131434531));
    }

    public final void m15079a(ItemData itemData, boolean z, boolean z2, boolean z3) {
        this.f13959a.f13770b = z2;
        this.f13959a.f13772d = z;
        this.f13959a.f13771c = z3;
        this.f13959a.m14935a(itemData);
    }

    public final void m15077a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel) {
        boolean z;
        this.f13959a.f13770b = false;
        CollectionTitleBarView collectionTitleBarView = this.f13959a;
        if (collectionsAppSectionWithItemsOrRequestablesModel.mo391g() != null) {
            z = true;
        } else {
            z = false;
        }
        collectionTitleBarView.f13772d = z;
        this.f13959a.f13771c = false;
        this.f13959a.m14933a(collectionsAppSectionWithItemsOrRequestablesModel);
    }

    public final void m15078a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel, ProfileViewerContext profileViewerContext) {
        boolean z;
        this.f13959a.f13770b = profileViewerContext.f();
        CollectionTitleBarView collectionTitleBarView = this.f13959a;
        if (collectionsAppSectionWithItemsOrRequestablesModel.nR_() != null) {
            z = true;
        } else {
            z = false;
        }
        collectionTitleBarView.f13772d = z;
        this.f13959a.f13771c = false;
        this.f13959a.m14936b(collectionsAppSectionWithItemsOrRequestablesModel);
    }
}
