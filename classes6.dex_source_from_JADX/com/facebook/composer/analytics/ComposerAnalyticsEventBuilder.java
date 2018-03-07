package com.facebook.composer.analytics;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.composer.tasks.ComposerTaskId;
import com.facebook.ipc.composer.model.ComposerEntryPicker;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.TargetType;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: place_picker_nonintrusive_error_button_dismiss */
public class ComposerAnalyticsEventBuilder {
    public final HoneyClientEvent f7777a;

    public ComposerAnalyticsEventBuilder(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "composer";
        this.f7777a = honeyClientEvent;
    }

    public static ComposerAnalyticsEventBuilder m11095b() {
        return new ComposerAnalyticsEventBuilder("composer_disabled_post_click");
    }

    public static ComposerAnalyticsEventBuilder m11096c() {
        return new ComposerAnalyticsEventBuilder("composer_post");
    }

    public static ComposerAnalyticsEventBuilder m11097h() {
        return new ComposerAnalyticsEventBuilder("composer_cancel");
    }

    public final ComposerAnalyticsEventBuilder m11111b(String str) {
        this.f7777a.b("publish_method", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11107a(boolean z) {
        this.f7777a.a("inline_sprouts_enabled", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11103a(ComposerType composerType) {
        this.f7777a.b("composer_type", composerType.analyticsName);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11100a(ComposerEntryPicker composerEntryPicker) {
        this.f7777a.b("composer_entry_picker", composerEntryPicker.getAnalyticsName());
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11101a(ComposerSourceSurface composerSourceSurface) {
        this.f7777a.b("composer_source_surface", composerSourceSurface.getAnalyticsName());
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11115c(String str) {
        this.f7777a.b("composer_entry_point_description", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11118d(String str) {
        this.f7777a.b("params", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11098a(int i) {
        this.f7777a.a("retry_count", i);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11124h(String str) {
        this.f7777a.f = str;
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11126i(String str) {
        this.f7777a.b("reachability_status", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11128j(String str) {
        this.f7777a.b("connection_class", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11108b(int i) {
        this.f7777a.a("remaining_character_count", i);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11102a(ComposerSourceType composerSourceType) {
        this.f7777a.a("ref", composerSourceType);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11129k(@Nullable String str) {
        this.f7777a.b("external_ref_name", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11104a(TargetType targetType) {
        this.f7777a.a("target_type", targetType);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11099a(long j) {
        this.f7777a.a("target_id", j);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11106a(Multiset<ComposerTaskId> multiset) {
        ArrayNode b = JsonNodeFactory.a.b();
        for (ComposerTaskId composerTaskId : multiset) {
            JsonNodeFactory jsonNodeFactory = JsonNodeFactory.a;
            b.a(TextNode.h(composerTaskId.name()));
        }
        this.f7777a.a("remaining_tasks", b);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11112b(boolean z) {
        this.f7777a.a("is_privacy_blocked", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11116c(boolean z) {
        this.f7777a.a("has_content", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11109b(long j) {
        this.f7777a.a("publish_target", j);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11114c(long j) {
        this.f7777a.a("loaded_time", j);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11113c(int i) {
        this.f7777a.a("rating", i);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11119d(boolean z) {
        this.f7777a.a("is_media_attached", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11121e(boolean z) {
        this.f7777a.a("auto_tag_timeout_has_passed", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11122f(boolean z) {
        this.f7777a.a("has_user_edited_content", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11123g(boolean z) {
        this.f7777a.a("has_submittable_content", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11125h(boolean z) {
        this.f7777a.a("can_submit", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11105a(ImmutableMap<String, Integer> immutableMap) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((Integer) entry.getValue()).intValue() != 0) {
                objectNode.a((String) entry.getKey(), ((Integer) entry.getValue()).toString());
            }
        }
        this.f7777a.b("payload_count", objectNode.toString());
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11130l(String str) {
        this.f7777a.b("payload_type", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11117d(int i) {
        this.f7777a.a("total_sticker_count", i);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11110b(ImmutableList<String> immutableList, boolean z) {
        ArrayNode b = JsonNodeFactory.a.b();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            b.h((String) immutableList.get(i));
        }
        this.f7777a.a(z ? "video_items_removed" : "photo_items_removed", b);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11127i(boolean z) {
        this.f7777a.a("is_sticker_post", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11132n(String str) {
        this.f7777a.b("viewer_id", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11133p(String str) {
        this.f7777a.b("payload_attachment_format", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11134q(String str) {
        this.f7777a.b("payload_attachment_source", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11120e(int i) {
        this.f7777a.a("char_count", i);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11131m(boolean z) {
        this.f7777a.a("is_edit_composer", z);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11135r(String str) {
        this.f7777a.b("configuration", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11136s(String str) {
        this.f7777a.b("prefilled_share_id", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11137t(String str) {
        this.f7777a.b("attached_share_id", str);
        return this;
    }

    public final ComposerAnalyticsEventBuilder m11138u(@Nullable String str) {
        this.f7777a.b("edited_story_id", str);
        return this;
    }

    public final HoneyClientEvent m11139y() {
        return this.f7777a;
    }
}
