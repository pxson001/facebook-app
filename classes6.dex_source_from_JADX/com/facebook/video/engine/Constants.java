package com.facebook.video.engine;

/* compiled from: reviews_click */
public class Constants {

    /* compiled from: reviews_click */
    public enum VideoError {
        UNKNOWN("unknown"),
        NO_SOURCE("no_source"),
        SERVER_DIED("server_died"),
        MALFORMED("malformed"),
        ERROR_IO("error_io"),
        TIMED_OUT("timed_out"),
        UNSUPPORTED("unsupported"),
        PLAYERSERVICE_DEAD("playerservice_dead");
        
        public final String value;

        private VideoError(String str) {
            this.value = str;
        }
    }

    /* compiled from: reviews_click */
    public enum VideoMediaState {
        STOPPED,
        PLAYING,
        PAUSED
    }
}
