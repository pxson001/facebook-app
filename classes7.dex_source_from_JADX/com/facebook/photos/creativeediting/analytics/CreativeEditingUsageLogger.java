package com.facebook.photos.creativeediting.analytics;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: magic_stories_feed_prompt_closed */
public class CreativeEditingUsageLogger {
    private final AnalyticsLogger f9530a;
    private final String f9531b;

    /* compiled from: magic_stories_feed_prompt_closed */
    public interface EventListener {
        void mo490a(String str);

        void mo491a(String str, int i);

        void mo492a(String str, SwipeableParams swipeableParams, int i);

        void mo493b(String str, int i);

        void mo494c(String str, int i);

        void mo495d(String str, int i);

        void mo496e(String str, int i);
    }

    /* compiled from: magic_stories_feed_prompt_closed */
    enum Params {
        MEDIA_ITEM_IDENTIFIER("media_id"),
        NUMBER_OF_UG_ENTRIES("gv_editing_entries"),
        NUMBER_OF_STICKERS_ENTRIES("sticker_flow_entries"),
        NUMBER_OF_TEXT_ENTRIES("text_flow_entries"),
        NUMBER_OF_CROP_ENTRIES("crop_flow_entries"),
        NUMBER_OF_FILTER_ENTRIES("filter_in_gallery_entries"),
        NUMBER_OF_SWIPES("swipe_count"),
        NUMBER_OF_STICKER_ON_PHOTO("sticker_count"),
        NUMBER_OF_TEXT_ON_PHOTO("text_count"),
        NUMBER_OF_DOODLE_ON_PHOTO("doodle_count"),
        APPLIED_FILTER_NAME("filter_name"),
        IS_PHOTO_CROPPED("is_cropped"),
        IS_PHOTO_ROTATED("is_rotated"),
        IS_PHOTO_DELETED("is_deleted"),
        IS_PHOTO_PUBLISHED("is_published"),
        Entry_POINT("entry_point"),
        MEDIA_ITEM_URI("media_uri");
        
        private final String name;

        private Params(String str) {
            this.name = str;
        }

        public final String getParamKey() {
            return this.name;
        }
    }

    @Inject
    public CreativeEditingUsageLogger(@Assisted String str, AnalyticsLogger analyticsLogger) {
        this.f9531b = str;
        this.f9530a = analyticsLogger;
    }

    public final void m11492a(String str, CreativeEditingUsageParams creativeEditingUsageParams) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        Preconditions.checkNotNull(creativeEditingUsageParams);
        if (Strings.isNullOrEmpty(this.f9531b)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("composer_creative_editing_tools");
        honeyClientEvent.c = "creative_editing";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f9531b;
        honeyClientEvent = honeyClientEvent.b(Params.MEDIA_ITEM_IDENTIFIER.getParamKey(), str).a(Params.NUMBER_OF_UG_ENTRIES.getParamKey(), creativeEditingUsageParams.f9550d).a(Params.NUMBER_OF_STICKERS_ENTRIES.getParamKey(), creativeEditingUsageParams.f9551e).a(Params.NUMBER_OF_STICKER_ON_PHOTO.getParamKey(), creativeEditingUsageParams.f9556j).a(Params.NUMBER_OF_TEXT_ENTRIES.getParamKey(), creativeEditingUsageParams.f9552f).a(Params.NUMBER_OF_TEXT_ON_PHOTO.getParamKey(), creativeEditingUsageParams.f9557k).a(Params.NUMBER_OF_CROP_ENTRIES.getParamKey(), creativeEditingUsageParams.f9553g).a(Params.NUMBER_OF_DOODLE_ON_PHOTO.getParamKey(), creativeEditingUsageParams.f9558l).a(Params.IS_PHOTO_CROPPED.getParamKey(), creativeEditingUsageParams.f9547a);
        String paramKey = Params.IS_PHOTO_ROTATED.getParamKey();
        if (creativeEditingUsageParams.f9559m == 0) {
            z2 = false;
        }
        this.f9530a.a(honeyClientEvent.a(paramKey, z2).a(Params.NUMBER_OF_FILTER_ENTRIES.getParamKey(), creativeEditingUsageParams.f9554h).a(Params.NUMBER_OF_SWIPES.getParamKey(), creativeEditingUsageParams.f9555i).b(Params.APPLIED_FILTER_NAME.getParamKey(), creativeEditingUsageParams.f9560n).a(Params.IS_PHOTO_DELETED.getParamKey(), creativeEditingUsageParams.f9548b).a(Params.IS_PHOTO_PUBLISHED.getParamKey(), creativeEditingUsageParams.f9549c).a(Params.Entry_POINT.getParamKey(), creativeEditingUsageParams.f9561o));
    }
}
