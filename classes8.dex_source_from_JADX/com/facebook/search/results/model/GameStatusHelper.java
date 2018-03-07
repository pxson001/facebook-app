package com.facebook.search.results.model;

import com.facebook.common.time.SystemClock;

/* compiled from: SCROLLING_SLIDESHOW */
public class GameStatusHelper {

    /* compiled from: SCROLLING_SLIDESHOW */
    public enum GameStatus {
        PREGAME,
        ONGOING,
        POSTGAME
    }

    public static GameStatus m27022a(long j, String str) {
        if (1000 * j > SystemClock.a.a()) {
            return GameStatus.PREGAME;
        }
        if (str.equals("closed")) {
            return GameStatus.POSTGAME;
        }
        return GameStatus.ONGOING;
    }
}
