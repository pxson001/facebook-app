package com.facebook.composer.minutiae;

/* compiled from: trans_suggestion_4 */
public class MinutiaeConstants {

    /* compiled from: trans_suggestion_4 */
    public enum TargetFragment {
        VERB_PICKER("Verb"),
        OBJECT_PICKER("Object"),
        UNKNOWN("Unknown");
        
        private String mFragmentName;

        private TargetFragment(String str) {
            this.mFragmentName = str;
        }

        public final String getFragmentName() {
            return this.mFragmentName;
        }

        public static TargetFragment fromString(String str) {
            if (VERB_PICKER.getFragmentName().equals(str)) {
                return VERB_PICKER;
            }
            if (OBJECT_PICKER.getFragmentName().equals(str)) {
                return OBJECT_PICKER;
            }
            return UNKNOWN;
        }
    }
}
