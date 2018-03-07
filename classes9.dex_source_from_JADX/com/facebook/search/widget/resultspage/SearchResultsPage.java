package com.facebook.search.widget.resultspage;

/* compiled from: user_friends */
public interface SearchResultsPage {

    /* compiled from: user_friends */
    public enum LoadingIndicatorType {
        SPINNING_WHEEL,
        GLOWING_STORIES
    }

    /* compiled from: user_friends */
    public enum State {
        LOADING,
        LOADING_MORE,
        LOADING_FINISHED_NO_RESULTS,
        LOADING_FINISHED,
        EMPTY,
        ERROR,
        ERROR_LOADING_MORE,
        REQUEST_TIMED_OUT
    }
}
