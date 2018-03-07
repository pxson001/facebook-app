package com.facebook.events.cancelevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: contacts_you_may_know_people */
public class EventsCancelEventFragmentFactory implements IFragmentFactory {
    public final Fragment m16405a(Intent intent) {
        Bundle extras = intent.getExtras();
        CancelEventFragment cancelEventFragment = new CancelEventFragment();
        cancelEventFragment.g(extras);
        return cancelEventFragment;
    }
}
