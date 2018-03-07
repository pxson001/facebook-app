package com.facebook.events.permalink.messageguests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: bf0636eedf250571aac47fe4c4f85841 */
public class EventMessageGuestsFragmentFactory implements IFragmentFactory {
    public final Fragment m18964a(Intent intent) {
        Bundle extras = intent.getExtras();
        EventMessageGuestsFrameFragment eventMessageGuestsFrameFragment = new EventMessageGuestsFrameFragment();
        eventMessageGuestsFrameFragment.g(extras);
        return eventMessageGuestsFrameFragment;
    }
}
