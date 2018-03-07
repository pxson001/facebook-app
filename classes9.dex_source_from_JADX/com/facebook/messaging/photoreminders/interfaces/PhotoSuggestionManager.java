package com.facebook.messaging.photoreminders.interfaces;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: dob_year */
public interface PhotoSuggestionManager {
    boolean m16148a();

    ImmutableList<PhotoSuggestion> m16149b();

    ListenableFuture<ImmutableList<PhotoSuggestion>> m16150c();

    ImmutableList<String> m16151d();

    boolean m16152e();
}
