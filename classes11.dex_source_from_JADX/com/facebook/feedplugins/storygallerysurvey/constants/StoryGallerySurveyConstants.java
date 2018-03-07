package com.facebook.feedplugins.storygallerysurvey.constants;

import com.facebook.inject.InjectorLike;

/* compiled from: birthday_selfie_cam_processing_failed */
public class StoryGallerySurveyConstants {

    /* compiled from: birthday_selfie_cam_processing_failed */
    public enum ActionType {
        SEEN("SEEN"),
        HIDE("HIDE"),
        TAKEN("TAKEN"),
        START("START"),
        FINISH("FINISH");
        
        private final String mActionType;

        private ActionType(String str) {
            this.mActionType = str;
        }

        public final String toString() {
            return this.mActionType;
        }

        public final String toEventName() {
            switch (this) {
                case SEEN:
                    return "story_gallery_survey_feed_unit_impression";
                case HIDE:
                    return "story_gallery_survey_feed_unit_hide";
                case TAKEN:
                    return "story_gallery_survey_feed_unit_taken";
                case START:
                    return "story_gallery_survey_feed_unit_start";
                case FINISH:
                    return "story_gallery_survey_feed_unit_finish";
                default:
                    return "";
            }
        }
    }

    /* compiled from: birthday_selfie_cam_processing_failed */
    public enum Rating {
        PREF_FIRST("PREF_FIRST"),
        PREF_SECOND("PREF_SECOND"),
        PREF_SKIP("PREF_SKIP");
        
        private final String mRating;

        private Rating(String str) {
            this.mRating = str;
        }

        public final String toString() {
            return this.mRating;
        }

        public final String toEventName() {
            switch (this) {
                case PREF_FIRST:
                    return "story_gallery_survey_ratings_pref_first";
                case PREF_SECOND:
                    return "story_gallery_survey_ratings_pref_second";
                case PREF_SKIP:
                    return "story_gallery_survey_ratings_pref_skip";
                default:
                    return "";
            }
        }
    }

    public static StoryGallerySurveyConstants m10065a(InjectorLike injectorLike) {
        return new StoryGallerySurveyConstants();
    }
}
