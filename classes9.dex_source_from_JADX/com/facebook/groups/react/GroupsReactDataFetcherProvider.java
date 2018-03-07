package com.facebook.groups.react;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.react.bridge.ReactContext;
import com.facebook.ui.futures.TasksManager;

/* compiled from: payment_pin */
public class GroupsReactDataFetcherProvider extends AbstractAssistedProvider<GroupsReactDataFetcher> {
    public final GroupsReactDataFetcher m7318a(ReactContext reactContext) {
        return new GroupsReactDataFetcher(reactContext, TasksManager.b(this), IdBasedLazy.a(this, 3530));
    }
}
