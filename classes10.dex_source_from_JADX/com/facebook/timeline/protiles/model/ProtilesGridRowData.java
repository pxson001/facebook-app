package com.facebook.timeline.protiles.model;

import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: feed_filter_dismiss_script */
public class ProtilesGridRowData {
    public final ProtileModel f12116a;
    public final ViewPosition f12117b;
    public final List<ProtileItemFieldsModel> f12118c;

    /* compiled from: feed_filter_dismiss_script */
    public enum ViewPosition {
        TOP_ROW,
        MIDDLE_ROW,
        BOTTOM_ROW
    }

    public ProtilesGridRowData(ProtileModel protileModel, ViewPosition viewPosition, List<ProtileItemFieldsModel> list) {
        this.f12116a = (ProtileModel) Preconditions.checkNotNull(protileModel);
        this.f12117b = viewPosition;
        this.f12118c = (List) Preconditions.checkNotNull(list);
        Preconditions.checkArgument(list.size() <= 3);
    }
}
