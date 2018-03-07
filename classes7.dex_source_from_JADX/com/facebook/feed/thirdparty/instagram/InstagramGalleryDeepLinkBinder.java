package com.facebook.feed.thirdparty.instagram;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.debug.log.BLog;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.galleryutil.MediaGalleryDeepLinkViewGroup;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Strings;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should_show_autos_options_in_composer */
public class InstagramGalleryDeepLinkBinder extends GalleryDeepLinkBinder implements OnClickListener {
    private final InstagramUtils f3771a;
    private final NewsFeedAnalyticsEventBuilder f3772b;
    private final FbObjectMapper f3773c;
    private InstagramDeepLinkBinderConfig f3774d;
    private MediaMetadata f3775e;

    /* compiled from: should_show_autos_options_in_composer */
    public class InstagramDeepLinkBinderConfig extends DeepLinkBinderConfig {
        public static final Creator<InstagramDeepLinkBinderConfig> CREATOR = new C03161();
        public final boolean f3768a;
        public final String f3769b;
        public final String f3770c;

        /* compiled from: should_show_autos_options_in_composer */
        final class C03161 implements Creator<InstagramDeepLinkBinderConfig> {
            C03161() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new InstagramDeepLinkBinderConfig(parcel);
            }

            public final Object[] newArray(int i) {
                return new InstagramDeepLinkBinderConfig[i];
            }
        }

        public InstagramDeepLinkBinderConfig(boolean z, @Nullable String str, @Nullable String str2) {
            this.f3768a = z;
            this.f3769b = str;
            this.f3770c = str2;
        }

        public InstagramDeepLinkBinderConfig(Parcel parcel) {
            this.f3768a = ParcelUtil.a(parcel);
            this.f3769b = parcel.readString();
            this.f3770c = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            ParcelUtil.a(parcel, this.f3768a);
            parcel.writeString(this.f3769b);
            parcel.writeString(this.f3770c);
        }
    }

    @Inject
    public InstagramGalleryDeepLinkBinder(InstagramUtils instagramUtils, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FbObjectMapper fbObjectMapper) {
        this.f3771a = instagramUtils;
        this.f3772b = newsFeedAnalyticsEventBuilder;
        this.f3773c = fbObjectMapper;
    }

    public final boolean m4431a(MediaMetadata mediaMetadata, MediaGalleryDeepLinkViewGroup mediaGalleryDeepLinkViewGroup, FbFragment fbFragment, DeepLinkBinderConfig deepLinkBinderConfig) {
        this.f3775e = mediaMetadata;
        if (this.f3775e == null || this.f3775e.z() == null) {
            return false;
        }
        GraphQLStory a = PhotosMetadataConversionHelper.a(this.f3775e.z());
        if (a == null || !InstagramUtils.a(a) || !this.f3771a.a(InstagramEntryPoint.Photo)) {
            return false;
        }
        if (deepLinkBinderConfig instanceof InstagramDeepLinkBinderConfig) {
            this.f3774d = (InstagramDeepLinkBinderConfig) deepLinkBinderConfig;
        }
        mediaGalleryDeepLinkViewGroup.setAppIconDrawableFromResource(2130840938);
        if (this.f3771a.a()) {
            mediaGalleryDeepLinkViewGroup.setText(2131233567);
        } else {
            mediaGalleryDeepLinkViewGroup.setText(2131233566);
        }
        mediaGalleryDeepLinkViewGroup.setOnClickListener(this);
        return true;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 955096403);
        if (this.f3775e == null || this.f3775e.z() == null) {
            Logger.a(2, EntryType.UI_INPUT_END, 1410706248, a);
            return;
        }
        GraphQLStory a2 = PhotosMetadataConversionHelper.a(this.f3775e.z());
        if (a2 == null) {
            LogUtils.a(1663615518, a);
            return;
        }
        JsonNode jsonNode;
        if (!(this.f3774d == null || Strings.isNullOrEmpty(this.f3774d.f3769b))) {
            try {
                jsonNode = (ArrayNode) this.f3773c.a(this.f3774d.f3769b);
            } catch (IOException e) {
                BLog.b(getClass().getSimpleName(), "MPK we have a problem: " + e.getMessage());
            }
            if (this.f3771a.a()) {
                this.f3771a.a(view.getContext(), InstagramEntryPoint.Photo, a2, jsonNode);
            } else {
                this.f3771a.a(view.getContext(), this.f3774d.f3770c, InstagramEntryPoint.Photo);
            }
            if (this.f3774d != null && this.f3774d.f3768a) {
                this.f3771a.a(view.getContext(), NewsFeedAnalyticsEventBuilder.l(jsonNode));
            }
            LogUtils.a(-1731607844, a);
        }
        jsonNode = null;
        if (this.f3771a.a()) {
            this.f3771a.a(view.getContext(), InstagramEntryPoint.Photo, a2, jsonNode);
        } else {
            this.f3771a.a(view.getContext(), this.f3774d.f3770c, InstagramEntryPoint.Photo);
        }
        this.f3771a.a(view.getContext(), NewsFeedAnalyticsEventBuilder.l(jsonNode));
        LogUtils.a(-1731607844, a);
    }
}
