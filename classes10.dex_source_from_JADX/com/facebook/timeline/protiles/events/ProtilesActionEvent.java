package com.facebook.timeline.protiles.events;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;

/* compiled from: feed_filter_lists */
public class ProtilesActionEvent implements KeyedEvent<String> {
    public final Type f12097a;
    public final ProtileModel f12098b;
    public ProtileItemFieldsModel f12099c;

    /* compiled from: feed_filter_lists */
    public enum Type {
        CLICK_HEADER,
        CLICK_FOOTER,
        CLICK_ITEM
    }

    public ProtilesActionEvent(Type type, ProtileModel protileModel) {
        this.f12097a = type;
        this.f12098b = protileModel;
    }

    public static ProtilesActionEvent m12101a(ProtileModel protileModel, ProtileItemFieldsModel protileItemFieldsModel) {
        ProtilesActionEvent protilesActionEvent = new ProtilesActionEvent(Type.CLICK_ITEM, protileModel);
        protilesActionEvent.f12099c = protileItemFieldsModel;
        return protilesActionEvent;
    }

    public final Object m12102c() {
        return this.f12098b.m12109b() != null ? this.f12098b.m12109b().toString() : null;
    }
}
