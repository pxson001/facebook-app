package com.facebook.saved2.model;

import com.facebook.crudolib.dbinsert.InsertProvider;

/* compiled from: not_closed */
public class Saved2ItemTable_InsertHelper implements InsertProvider {
    public static final String[] f7836a = new String[]{"node_id", "section_name"};
    public static final String[] f7837b = new String[]{"section_name", "node_id", "time_saved_ms", "graphql_cursor", "group_title", "picture_uri", "title", "subtitle", "type", "type_display_extras", "saved_state", "url", "permalink_id", "source_story_id", "fb_link_url", "is_playable", "playable_url", "target_id", "target_graphql_object_type", "global_share_id", "global_share_graphql_object_type", "instant_article_id", "instant_article_canonical_url", "can_viewer_share_event", "is_spherical", "spherical_preferred_fov", "spherical_fullscreen_aspect_ratio", "spherical_inline_aspect_ratio", "spherical_playable_url_sd_string", "spherical_playable_url_hd_string", "initial_view_heading_degrees", "initial_view_pitch_degrees", "initial_view_roll_degrees", "section_name_server", "is_deleted_client", "is_unarchived_client", "media_content_size", "is_download_client"};

    public final Object m8065a() {
        return Saved2ItemTable.class;
    }

    public final Object[] m8066b() {
        return new Object[]{"item", f7837b, Integer.valueOf(5), f7836a, new int[]{1, 0}};
    }
}
