package com.facebook.feedplugins.musicstory.utils;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import java.util.HashMap;
import java.util.StringTokenizer;

/* compiled from: com.facebook.katana.activity.contactpoints.AddContactpointFacewebActivity */
public class MusicStoryLoggingParams {
    public final HashMap<Param, String> f8408a = new HashMap();

    /* compiled from: com.facebook.katana.activity.contactpoints.AddContactpointFacewebActivity */
    public enum Param {
        SONG_ID("music_id"),
        STORY_ID("content_id"),
        PROVIDER("platform_name"),
        STORY_TYPE("story_type"),
        MINUTIAE_ID("minutiae_action"),
        TRACKING_CODES("tracking"),
        ALBUM("album_title"),
        SONG("audio_title"),
        MUSICIAN("artist_name");
        
        private final String name;

        private Param(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: com.facebook.katana.activity.contactpoints.AddContactpointFacewebActivity */
    enum StoryTypes {
        album,
        playlist,
        single
    }

    public MusicStoryLoggingParams(FeedProps<GraphQLStoryAttachment> feedProps) {
        String str;
        MusicStoryDataExtractor musicStoryDataExtractor = new MusicStoryDataExtractor(feedProps);
        this.f8408a.put(Param.SONG_ID, musicStoryDataExtractor.f8404d.dp());
        HashMap hashMap = this.f8408a;
        Param param = Param.STORY_ID;
        if (musicStoryDataExtractor.f8403c == null || musicStoryDataExtractor.f8403c.ai() == null) {
            str = null;
        } else {
            str = musicStoryDataExtractor.f8403c.ai();
            if (str.contains("_")) {
                str = str.substring(str.indexOf(95) + 1);
            }
        }
        hashMap.put(param, str);
        this.f8408a.put(Param.PROVIDER, musicStoryDataExtractor.m9302b());
        hashMap = this.f8408a;
        param = Param.TRACKING_CODES;
        if (musicStoryDataExtractor.f8403c == null) {
            str = null;
        } else {
            str = musicStoryDataExtractor.f8403c.k();
        }
        hashMap.put(param, str);
        this.f8408a.put(Param.ALBUM, musicStoryDataExtractor.m9307g());
        this.f8408a.put(Param.SONG, musicStoryDataExtractor.m9303c());
        this.f8408a.put(Param.MUSICIAN, musicStoryDataExtractor.m9306f());
        hashMap = this.f8408a;
        param = Param.MINUTIAE_ID;
        str = null;
        if (musicStoryDataExtractor.f8403c != null && musicStoryDataExtractor.f8403c.k() != null && musicStoryDataExtractor.f8403c.k().contains("og_action_id")) {
            StringTokenizer stringTokenizer = new StringTokenizer(musicStoryDataExtractor.f8403c.k(), "\"{}:");
            while (stringTokenizer.hasMoreTokens()) {
                if (stringTokenizer.nextToken().equalsIgnoreCase("og_action_id") && stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken();
                    break;
                }
            }
        }
        hashMap.put(param, str);
        this.f8408a.put(Param.STORY_TYPE, StoryTypes.single.toString());
    }
}
