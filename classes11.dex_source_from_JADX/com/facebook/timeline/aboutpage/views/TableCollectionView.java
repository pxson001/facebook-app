package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionItem;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Ljava/lang/String; */
public class TableCollectionView extends TableLayout {
    @Inject
    public StandardCollectionSizes f13930a;
    private final int f13931b = 2;
    private final int f13932c = this.f13930a.f13056a;

    public static void m15051a(Object obj, Context context) {
        ((TableCollectionView) obj).f13930a = StandardCollectionSizes.m13827a(FbInjector.get(context));
    }

    private TableCollectionView(Context context, LayoutInflater layoutInflater, int i) {
        super(context, null);
        Class cls = TableCollectionView.class;
        m15051a(this, getContext());
        for (int i2 = 0; i2 < this.f13931b; i2++) {
            View tableRow = new TableRow(getContext());
            tableRow.setLayoutParams(new LayoutParams(-1, -2));
            for (int i3 = 0; i3 < this.f13932c; i3++) {
                tableRow.addView(layoutInflater.inflate(i, tableRow, false));
            }
            addView(tableRow);
        }
        setShrinkAllColumns(true);
        setStretchAllColumns(true);
    }

    public final void m15053a(List<AppCollectionItem> list, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        for (int i = 0; i < this.f13931b; i++) {
            TableRow tableRow = (TableRow) getChildAt(i);
            if (list.size() <= this.f13932c * i) {
                tableRow.setVisibility(8);
            } else {
                tableRow.setVisibility(0);
                for (int i2 = 0; i2 < this.f13932c; i2++) {
                    int i3 = (this.f13932c * i) + i2;
                    View childAt = tableRow.getChildAt(i2);
                    if (i3 >= list.size()) {
                        childAt.setVisibility(4);
                    } else {
                        ((ICollectionItemView) childAt).mo424a((AppCollectionItemModel) list.get(i3));
                        childAt.setVisibility(0);
                    }
                }
            }
        }
    }

    public static TableCollectionView m15050a(Context context, LayoutInflater layoutInflater, int i) {
        TableCollectionView tableCollectionView = new TableCollectionView(context, layoutInflater, i);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131434523);
        tableCollectionView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        return tableCollectionView;
    }

    public static TableCollectionView m15052b(Context context, LayoutInflater layoutInflater, int i) {
        TableCollectionView tableCollectionView = new TableCollectionView(context, layoutInflater, i);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131434523);
        tableCollectionView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        return tableCollectionView;
    }
}
