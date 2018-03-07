package com.facebook.auth.protocol;

/* compiled from: suggestion_cover_image */
public class SuggestedFacebookAccountFoundException extends Exception {
    private final SuggestedFacebookAccountInfo mSuggestedFacebookAccountInfo;

    public SuggestedFacebookAccountFoundException(SuggestedFacebookAccountInfo suggestedFacebookAccountInfo) {
        this.mSuggestedFacebookAccountInfo = suggestedFacebookAccountInfo;
    }
}
