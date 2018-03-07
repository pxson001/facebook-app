package com.facebook.search.fragment;

/* compiled from: ThumbnailDecodingSequence */
public enum GraphSearchFragmentType {
    AWARENESS_NULL_STATE,
    RESULTS_TEXT,
    RESULTS_PHOTO,
    RESULTS_KEYWORD_TABS,
    RESULTS_KEYWORD,
    SUGGESTIONS,
    RESULTS_SEE_MORE,
    REACT_NATIVE;

    public final String getTag() {
        return "graphsearch_" + name();
    }
}
