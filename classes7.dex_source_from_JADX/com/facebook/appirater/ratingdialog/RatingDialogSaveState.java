package com.facebook.appirater.ratingdialog;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = RatingDialogSaveStateDeserializer.class)
/* compiled from: crowdsourcing_suggest_edits_cards */
public class RatingDialogSaveState {
    @JsonProperty("last_screen")
    public final String lastScreen;
    @JsonProperty("rating")
    public final int rating;
    @JsonProperty("rating_comment")
    public final String ratingComment;

    protected RatingDialogSaveState() {
        this.rating = 0;
        this.ratingComment = null;
        this.lastScreen = null;
    }

    public RatingDialogSaveState(int i, String str, String str2) {
        this.rating = i;
        this.ratingComment = str;
        this.lastScreen = str2;
    }

    public String toString() {
        return "RatingDialogSaveState\nRating: " + this.rating + "\nComment: " + this.ratingComment + "\nLast Screen: " + this.lastScreen;
    }
}
