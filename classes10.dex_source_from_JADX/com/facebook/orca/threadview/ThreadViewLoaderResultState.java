package com.facebook.orca.threadview;

import com.facebook.orca.threadview.ThreadViewLoader.Error;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import javax.annotation.Nullable;

/* compiled from: message is a broadcast */
public class ThreadViewLoaderResultState {
    public static final ThreadViewLoaderResultState f7642c = new ThreadViewLoaderResultState(Result.f7610h, null);
    public final Result f7643a;
    @Nullable
    public final Error f7644b;

    public ThreadViewLoaderResultState(Result result, Error error) {
        this.f7643a = result;
        this.f7644b = error;
    }

    public static ThreadViewLoaderResultState m7354a() {
        return f7642c;
    }
}
