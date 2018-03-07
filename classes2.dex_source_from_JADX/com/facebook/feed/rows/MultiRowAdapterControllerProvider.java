package com.facebook.feed.rows;

import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.controllercallbacks.MultiRowAdapterConfiguration;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;

/* compiled from: place/creation */
public class MultiRowAdapterControllerProvider extends AbstractAssistedProvider<MultiRowAdapterController> {
    public final <Dispatcher extends AdapterCreatedCallback & AdapterDataChangedCallback> MultiRowAdapterController<Dispatcher> m14857a(MultiRowAdapterConfiguration multiRowAdapterConfiguration) {
        return new MultiRowAdapterController(multiRowAdapterConfiguration, MultipleRowsScrollHandler.m16539a(this));
    }
}
