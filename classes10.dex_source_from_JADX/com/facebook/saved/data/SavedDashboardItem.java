package com.facebook.saved.data;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.saved.adapter.SavedDashboardListItemType;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedDashboardItemFieldsModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedItemModel.GlobalShareModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedItemModel.PermalinkNodeModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedItemModel.SourceObjectModel;
import javax.annotation.Nullable;

/* compiled from: isTiltToPanGlyphShown */
public class SavedDashboardItem implements SavedDashboardListItem {
    public final String f9106a;
    public final String f9107b;
    public final String f9108c;
    public final String f9109d;
    private final String f9110e;
    public final String f9111f;
    public final SavedDashboardItemFieldsModel f9112g;
    public final SourceObjectModel f9113h;
    public final String f9114i;
    public final boolean f9115j;
    public final PermalinkNodeModel f9116k;
    public final GlobalShareModel f9117l;

    /* compiled from: isTiltToPanGlyphShown */
    public class Builder {
        public String f9094a;
        public String f9095b;
        public String f9096c;
        public String f9097d;
        public String f9098e;
        public String f9099f;
        public SavedDashboardItemFieldsModel f9100g;
        public SourceObjectModel f9101h;
        public String f9102i;
        public boolean f9103j;
        public PermalinkNodeModel f9104k;
        public GlobalShareModel f9105l;

        public final SavedDashboardItem m9103a() {
            return new SavedDashboardItem(this);
        }

        public static Builder m9102a(SavedDashboardItem savedDashboardItem) {
            String str;
            Builder builder = new Builder();
            builder.f9097d = savedDashboardItem.f9109d;
            builder = builder;
            builder.f9095b = savedDashboardItem.f9107b;
            builder = builder;
            builder.f9094a = savedDashboardItem.f9106a;
            builder = builder;
            builder.f9100g = savedDashboardItem.f9112g;
            builder = builder;
            builder.f9104k = savedDashboardItem.f9116k;
            builder = builder;
            builder.f9096c = savedDashboardItem.f9108c;
            builder = builder;
            builder.f9101h = savedDashboardItem.f9113h;
            builder = builder;
            builder.f9102i = savedDashboardItem.f9114i;
            Builder builder2 = builder;
            if (savedDashboardItem.m9106i() == null) {
                str = null;
            } else {
                str = savedDashboardItem.m9106i().toString();
            }
            builder2.f9099f = str;
            builder = builder2;
            builder.f9098e = savedDashboardItem.f9111f;
            builder = builder;
            builder.f9103j = savedDashboardItem.f9115j;
            builder = builder;
            builder.f9105l = savedDashboardItem.f9117l;
            return builder;
        }
    }

    public SavedDashboardItem(Builder builder) {
        this.f9106a = builder.f9094a;
        this.f9107b = builder.f9095b;
        this.f9108c = builder.f9096c;
        this.f9109d = builder.f9097d;
        this.f9112g = builder.f9100g;
        this.f9113h = builder.f9101h;
        this.f9114i = builder.f9102i;
        this.f9115j = builder.f9103j;
        this.f9116k = builder.f9104k;
        this.f9110e = builder.f9099f;
        this.f9111f = builder.f9098e;
        this.f9117l = builder.f9105l;
    }

    public final SavedDashboardListItemType mo423a() {
        return SavedDashboardListItemType.SAVED_DASHBOARD_SAVED_ITEM;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedDashboardItem)) {
            return false;
        }
        SavedDashboardItem savedDashboardItem = (SavedDashboardItem) obj;
        if (this.f9112g == savedDashboardItem.f9112g) {
            return true;
        }
        if (this.f9112g == null || savedDashboardItem.f9112g == null || !StringUtil.a(this.f9112g.m9318o(), savedDashboardItem.f9112g.m9318o())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f9112g == null || this.f9112g.m9318o() == null) ? 0 : this.f9112g.m9318o().hashCode();
    }

    @Nullable
    public final Uri m9106i() {
        if (this.f9110e == null) {
            return null;
        }
        return Uri.parse(this.f9110e);
    }

    public final boolean m9107m() {
        if (this.f9112g != null && this.f9112g.m9322s()) {
            if (!StringUtil.a(new CharSequence[]{this.f9112g.m9318o(), this.f9112g.m9325v()})) {
                return true;
            }
        }
        return false;
    }
}
