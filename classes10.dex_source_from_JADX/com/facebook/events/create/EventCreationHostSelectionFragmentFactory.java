package com.facebook.events.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: contact_picker_no_nux */
public class EventCreationHostSelectionFragmentFactory implements IFragmentFactory {
    public final Fragment m16491a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventCreationHostSelectionFragment eventCreationHostSelectionFragment = new EventCreationHostSelectionFragment();
        eventCreationHostSelectionFragment.g(extras);
        return eventCreationHostSelectionFragment;
    }
}
