package com.facebook.events.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: contact_sync_permanent_row_failed_click */
public class EventCreationCategorySelectionFragmentFactory implements IFragmentFactory {
    public final Fragment m16482a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventCreationCategorySelectionFragment eventCreationCategorySelectionFragment = new EventCreationCategorySelectionFragment();
        eventCreationCategorySelectionFragment.g(extras);
        return eventCreationCategorySelectionFragment;
    }
}
