package com.facebook.friendsharing.souvenirs.util;

/* compiled from: RCTSourceCode */
enum SouvenirsLogger$Extras {
    CURRENT_INDEX("current_index"),
    PHOTOS_COUNT("photos_count"),
    VIDEOS_COUNT("videos_count"),
    BURST_COUNT("burst_count"),
    TILE_COUNT("tile_count"),
    TOTAL_ASSETS_COUNT("total_assets_count"),
    TOTAL_ASSETS_WITHIN_BURSTS_COUNT("total_assets_within_bursts_count"),
    TIME_SINCE_STORY("time_since_story"),
    SOUVENIR_UNIQUE_ID("souvenir_unique_id"),
    IS_EDITING_FROM_COMPOSER("is_editing_from_composer"),
    ASSET_COUNT_BEFORE_EDIT("asset_count_before_edit"),
    UPDATED_ASSET_COUNT("updated_asset_count"),
    ASSET_TYPE("asset_type"),
    TITLE_LENGTH("title_length");
    
    private final String name;

    private SouvenirsLogger$Extras(String str) {
        this.name = str;
    }

    public final String getParamKey() {
        return this.name;
    }
}
