package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionItem;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionRequestableField;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.widget.CustomLinearLayout;
import java.util.Iterator;
import java.util.List;

/* compiled from: Ljava/util/Comparator */
public class LinearCollectionView extends CustomLinearLayout {
    private final int f13836a;

    public LinearCollectionView(Context context, LayoutInflater layoutInflater, int i, int i2) {
        super(context);
        this.f13836a = i2;
        for (int i3 = 0; i3 < this.f13836a; i3++) {
            addView(layoutInflater.inflate(i, this, false));
        }
        setOrientation(1);
    }

    protected final void m14992a(List<AppCollectionItem> list, List<CollectionsAppSectionRequestableField> list2, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        int i;
        int size = list2 != null ? list2.size() : 0;
        if (list2 != null) {
            Iterator it = list2.iterator();
            i = size;
            while (it.hasNext()) {
                if (GraphQLInfoRequestFieldStatus.FILLED.equals(((CollectionsAppSectionRequestableFieldModel) it.next()).m14550c())) {
                    size = i - 1;
                } else {
                    size = i;
                }
                i = size;
            }
        } else {
            i = size;
        }
        int size2 = list != null ? list.size() : 0;
        int min = Math.min(size2 + i, this.f13836a);
        int i2 = 0;
        int i3 = 0;
        while (i3 < min) {
            View childAt = getChildAt(i3);
            ICollectionItemView iCollectionItemView = (ICollectionItemView) childAt;
            if (i3 < size2) {
                iCollectionItemView.mo424a((AppCollectionItemModel) list.get(i3));
            } else {
                int i4 = i2;
                while (i4 < list2.size()) {
                    i2 = i4 + 1;
                    CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel = (CollectionsAppSectionRequestableFieldModel) list2.get(i4);
                    if (!collectionsAppSectionRequestableFieldModel.m14550c().equals(GraphQLInfoRequestFieldStatus.FILLED)) {
                        iCollectionItemView.mo425a(collectionsAppSectionRequestableFieldModel, profileViewerContext, graphQLTimelineAppSectionType);
                        break;
                    }
                    i4 = i2;
                }
                i2 = i4;
            }
            childAt.setVisibility(0);
            View findViewById = childAt.findViewById(2131560343);
            if (i3 == min - 1) {
                findViewById.setVisibility(4);
            } else {
                findViewById.setVisibility(0);
            }
            i3++;
        }
        for (size = i3; size < this.f13836a; size++) {
            getChildAt(size).setVisibility(8);
        }
    }
}
