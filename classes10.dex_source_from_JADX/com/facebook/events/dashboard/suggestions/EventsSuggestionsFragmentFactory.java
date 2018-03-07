package com.facebook.events.dashboard.suggestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE */
public class EventsSuggestionsFragmentFactory implements IFragmentFactory {
    public final Fragment m17532a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventsSuggestionsFragment eventsSuggestionsFragment = new EventsSuggestionsFragment();
        eventsSuggestionsFragment.g(extras);
        return eventsSuggestionsFragment;
    }
}
