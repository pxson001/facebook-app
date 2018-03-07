package com.facebook.saved.data;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.saved.contextmenu.interfaces.ReviewableItemWrapper;
import com.facebook.saved.contextmenu.interfaces.SavableItemWrapper;
import com.facebook.saved.contextmenu.interfaces.SharableItemWrapper;
import com.facebook.saved.helper.SavedItemHelper;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedDashboardItemFieldsModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedItemModel.SourceObjectModel.ActorsModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: isGooglePlayServicesAvailable */
public class SavedDashboardItemWrapper implements ReviewableItemWrapper<SavedDashboardItem>, SavableItemWrapper<SavedDashboardItem>, SharableItemWrapper<SavedDashboardItem> {
    private final SavedDashboardItem f9118a;
    private final SavedItemHelper f9119b;

    @Inject
    public SavedDashboardItemWrapper(@Assisted SavedDashboardItem savedDashboardItem, SavedItemHelper savedItemHelper) {
        this.f9118a = savedDashboardItem;
        this.f9119b = savedItemHelper;
    }

    public final Object mo425b() {
        return this.f9118a;
    }

    @Nullable
    public final String mo424a() {
        return this.f9118a.f9112g == null ? null : this.f9118a.f9112g.m9318o();
    }

    @Nullable
    public final GraphQLSavedState mo429f() {
        return SavedItemHelper.m9174d(this.f9118a);
    }

    @Nullable
    public final String mo430g() {
        return this.f9118a.f9113h == null ? null : this.f9118a.f9113h.m9381k();
    }

    @Nullable
    public final String mo431h() {
        String a;
        SavedItemHelper savedItemHelper = this.f9119b;
        SavedDashboardItem savedDashboardItem = this.f9118a;
        if (savedDashboardItem != null) {
            Object obj = null;
            if (!(savedDashboardItem == null || savedDashboardItem.f9113h == null || StringUtil.a(savedDashboardItem.f9113h.m9381k()))) {
                obj = 1;
            }
            if (!(obj == null || savedDashboardItem.f9113h.m9380j().isEmpty())) {
                a = ((ActorsModel) savedDashboardItem.f9113h.m9380j().get(0)).m9371a();
                return a;
            }
        }
        a = null;
        return a;
    }

    public final boolean mo426c() {
        return this.f9118a.f9112g != null && this.f9118a.f9112g.m9314k();
    }

    public final boolean mo427d() {
        SavedDashboardItem savedDashboardItem = this.f9118a;
        boolean z = (savedDashboardItem == null || savedDashboardItem.f9112g == null || savedDashboardItem.f9112g.m9305E() == null) ? false : true;
        return z;
    }

    @Nullable
    public final String mo428e() {
        return this.f9118a.f9112g == null ? null : this.f9118a.f9112g.m9324u();
    }

    @Nullable
    public final GraphQLEntity mo432i() {
        SavedItemHelper savedItemHelper = this.f9119b;
        SavedDashboardItem savedDashboardItem = this.f9118a;
        GraphQLEntity graphQLEntity = null;
        if (!(savedDashboardItem == null || savedDashboardItem.f9112g == null)) {
            Object obj;
            SavedDashboardItemFieldsModel savedDashboardItemFieldsModel = savedDashboardItem.f9112g;
            if (savedDashboardItemFieldsModel.m9313j() == null || savedDashboardItemFieldsModel.m9313j().g() != 2479791 || Strings.isNullOrEmpty(savedDashboardItemFieldsModel.m9318o())) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                boolean z;
                if (savedDashboardItemFieldsModel.m9313j() == null || Strings.isNullOrEmpty(savedDashboardItemFieldsModel.m9318o()) || savedDashboardItemFieldsModel.m9313j().g() != 67338874 || savedDashboardItemFieldsModel.m9315l() == null) {
                    z = false;
                } else {
                    z = savedDashboardItemFieldsModel.m9315l().m9423a();
                }
                if (!z) {
                    obj = (savedDashboardItemFieldsModel.m9316m() == null || StringUtil.a(savedDashboardItemFieldsModel.m9316m().m9429j()) || savedDashboardItemFieldsModel.m9316m().jK_() != 514783620) ? null : 1;
                    if (obj != null) {
                        graphQLEntity = GraphQLHelper.a(savedDashboardItemFieldsModel.m9316m().m9429j(), 514783620);
                    }
                }
            }
            graphQLEntity = GraphQLHelper.a(savedDashboardItemFieldsModel.m9318o(), savedDashboardItemFieldsModel.m9313j());
        }
        return graphQLEntity;
    }
}
