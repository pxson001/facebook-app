package com.facebook.reaction.constants;

import javax.annotation.Nullable;

/* compiled from: facecast_live_video */
public class ReactionIntentConstants {

    /* compiled from: facecast_live_video */
    public enum EntryPoint {
        NEWSFEED("newsfeed"),
        SEARCH_NULL_STATE("search_null");
        
        private final String mMarauderValue;

        @Nullable
        public static String getMarauderValue(@Nullable EntryPoint entryPoint) {
            if (entryPoint == null) {
                return null;
            }
            return entryPoint.getMarauderValue();
        }

        private EntryPoint(String str) {
            this.mMarauderValue = str;
        }

        public final String getMarauderValue() {
            return this.mMarauderValue;
        }
    }
}
