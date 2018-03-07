package com.facebook.analytics.logger;

/* compiled from: timeline_collections_pymk */
public class AnalyticsEventNames {

    /* compiled from: timeline_collections_pymk */
    public enum ContentFragmentType {
        MAINTAB("maintab"),
        IMMERSIVE("immersive");
        
        private String typeName;

        private ContentFragmentType(String str) {
            this.typeName = str;
        }

        public final String toString() {
            return this.typeName;
        }
    }
}
