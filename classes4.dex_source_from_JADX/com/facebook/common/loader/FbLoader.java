package com.facebook.common.loader;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: failure */
public interface FbLoader<PARAMS, RESULT, ERROR> {

    /* compiled from: failure */
    public interface Callback<PARAMS, RESULT, ERROR> {
        void mo948a(PARAMS params, ListenableFuture<?> listenableFuture);

        void mo949a(PARAMS params, RESULT result);

        void mo950b(PARAMS params, RESULT result);

        void mo951c(PARAMS params, ERROR error);
    }

    void mo903a(Callback<PARAMS, RESULT, ERROR> callback);

    void mo904a(PARAMS params);
}
