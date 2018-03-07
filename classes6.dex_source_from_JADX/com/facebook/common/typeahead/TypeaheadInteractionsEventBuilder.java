package com.facebook.common.typeahead;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.ImmutableList;

/* compiled from: place_picker_people_to_place_skip */
public class TypeaheadInteractionsEventBuilder {
    public final HoneyClientEvent f7751a;

    public TypeaheadInteractionsEventBuilder(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = str2;
        this.f7751a = honeyClientEvent;
    }

    public TypeaheadInteractionsEventBuilder(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = str3;
        this.f7751a = honeyClientEvent;
        this.f7751a.b("composer_session_id", str2);
    }

    public final TypeaheadInteractionsEventBuilder m11066a(String str) {
        this.f7751a.b("action_type_id", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11068b(String str) {
        this.f7751a.b("object_id", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11064a(int i) {
        this.f7751a.a("number_of_results", i);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11065a(ImmutableList<String> immutableList) {
        ArrayNode b = JsonNodeFactory.a.b();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            JsonNodeFactory jsonNodeFactory = JsonNodeFactory.a;
            b.a(TextNode.h(str));
        }
        this.f7751a.a("results", b);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11067b(int i) {
        this.f7751a.a("keystroke_count", i);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11069c(int i) {
        this.f7751a.a("display_position", i);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11070c(String str) {
        this.f7751a.b("search_term", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11071d(String str) {
        this.f7751a.b("typeahead_session_id", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11072e(String str) {
        this.f7751a.b("request_id", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11073f(String str) {
        this.f7751a.b("reshare_nux_variant", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11074g(String str) {
        this.f7751a.b("object_tracking_data", str);
        return this;
    }

    public final TypeaheadInteractionsEventBuilder m11075h(String str) {
        this.f7751a.b("typeahead_source", str);
        return this;
    }
}
