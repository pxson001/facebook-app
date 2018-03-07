package com.facebook.feedplugins.musicstory.providers;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.musicstory.SimpleMusicPopupManager;
import com.facebook.feedplugins.musicstory.SingleSongData;
import com.facebook.feedplugins.musicstory.SingleSongPartDefinition.PersistentState;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLogger.ActionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.facebook.work.profilepictureinterstitial.ProfilePictureInterstitialActivity */
public class DocomoMusicBuilder implements MusicProviderBuilder {
    public final Context f8359a;
    public final MusicProviderUtils f8360b;
    public final SimpleMusicPopupManager f8361c;

    @JsonIgnoreProperties(b = true)
    /* compiled from: com.facebook.work.profilepictureinterstitial.ProfilePictureInterstitialActivity */
    class AppSiteData {
        @JsonProperty("app_name")
        String appName;
        @JsonProperty("appsite")
        String appSite;
        @JsonProperty("appsite_url")
        String appSiteUrl;
        @JsonProperty("fallback_url")
        String fallbackUrl;
        @JsonProperty("is_app_link")
        String isAppLink;
        @JsonProperty("key_hashes")
        List<String> keyHashes;
        @JsonProperty("market_uri")
        String marketUri;
        @JsonProperty("package")
        String packageName;

        private AppSiteData() {
        }
    }

    @JsonIgnoreProperties(b = true)
    /* compiled from: com.facebook.work.profilepictureinterstitial.ProfilePictureInterstitialActivity */
    class AppSites {
        @JsonProperty("android")
        List<AppSiteData> appSites;

        private AppSites() {
        }
    }

    /* compiled from: com.facebook.work.profilepictureinterstitial.ProfilePictureInterstitialActivity */
    public class DocomoMusic implements MusicProvider {
        final /* synthetic */ DocomoMusicBuilder f8355a;
        private final OnClickListener f8356b = new C10321(this);
        public final SingleSongData f8357c;
        public final MusicStoryLogger f8358d;

        /* compiled from: com.facebook.work.profilepictureinterstitial.ProfilePictureInterstitialActivity */
        class C10321 implements OnClickListener {
            final /* synthetic */ DocomoMusic f8354a;

            C10321(DocomoMusic docomoMusic) {
                this.f8354a = docomoMusic;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -733721560);
                Uri uri = this.f8354a.f8357c.f8235k;
                if (uri == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, -755934606, a);
                    return;
                }
                r2 = new Uri[2];
                DocomoMusic docomoMusic = this.f8354a;
                r2[0] = DocomoMusic.m9267a(uri);
                docomoMusic = this.f8354a;
                r2[1] = DocomoMusic.m9268b(uri);
                if (this.f8354a.f8355a.f8361c != null) {
                    this.f8354a.f8355a.f8361c.m9186a(view.getContext(), r2);
                } else {
                    this.f8354a.f8355a.f8360b.m9283a(uri);
                }
                if (this.f8354a.f8358d != null) {
                    this.f8354a.f8358d.m9315a(ActionType.deep_link);
                }
                LogUtils.a(1660123472, a);
            }
        }

        public DocomoMusic(DocomoMusicBuilder docomoMusicBuilder, SingleSongData singleSongData, MusicStoryLogger musicStoryLogger) {
            this.f8355a = docomoMusicBuilder;
            this.f8357c = singleSongData;
            this.f8358d = musicStoryLogger;
        }

        public final String mo240a() {
            return this.f8355a.f8359a.getResources().getString(2131242488);
        }

        public final OnClickListener mo241b() {
            return this.f8356b;
        }

        public final int mo242c() {
            return 0;
        }

        public final int mo243d() {
            return 2130838324;
        }

        public static Uri m9267a(Uri uri) {
            return uri.getScheme().startsWith("fbrpc") ? uri : null;
        }

        public static Uri m9268b(Uri uri) {
            Builder builder = new Builder();
            builder.scheme("https");
            builder.authority("music.dmkt-sp.jp");
            if (uri == null) {
                return builder.build();
            }
            String queryParameter = uri.getQueryParameter("app_id");
            if (queryParameter == null || (!queryParameter.equals("799889663393876") && !queryParameter.equals("823778694338306"))) {
                return builder.build();
            }
            AppSites appSites;
            Object queryParameter2 = uri.getQueryParameter("appsite_data");
            if (TextUtils.isEmpty(queryParameter2)) {
                appSites = null;
            } else {
                try {
                    appSites = (AppSites) FbObjectMapper.i().a(queryParameter2, AppSites.class);
                } catch (JsonProcessingException e) {
                    return builder.build();
                } catch (IOException e2) {
                    return builder.build();
                }
            }
            if (!(appSites == null || appSites.appSites == null || appSites.appSites.isEmpty())) {
                for (AppSiteData appSiteData : appSites.appSites) {
                    if (!TextUtils.isEmpty(appSiteData.appSiteUrl)) {
                        queryParameter = appSiteData.appSiteUrl;
                        break;
                    }
                }
            }
            queryParameter = null;
            if (queryParameter == null) {
                return builder.build();
            }
            queryParameter = Uri.parse(queryParameter).getQueryParameter("url");
            if (queryParameter == null) {
                return builder.build();
            }
            queryParameter = Uri.parse(queryParameter).getQueryParameter("fb_music");
            if (queryParameter != null) {
                builder.path("/song/S" + queryParameter + "/");
            }
            return builder.build();
        }
    }

    @Inject
    public DocomoMusicBuilder(Context context, MusicProviderUtils musicProviderUtils, SimpleMusicPopupManager simpleMusicPopupManager) {
        this.f8359a = context;
        this.f8360b = musicProviderUtils;
        this.f8361c = simpleMusicPopupManager;
    }

    public final String mo245a() {
        return "124946600918797";
    }

    public final String mo246b() {
        return "Docomo";
    }

    public final MusicProvider mo244a(SingleSongData singleSongData, MusicStoryLogger musicStoryLogger, HasInvalidate hasInvalidate, PersistentState persistentState) {
        return new DocomoMusic(this, singleSongData, musicStoryLogger);
    }
}
