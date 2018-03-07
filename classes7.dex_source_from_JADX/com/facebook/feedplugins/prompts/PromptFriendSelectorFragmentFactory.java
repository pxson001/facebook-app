package com.facebook.feedplugins.prompts;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: SMS_DEFAULT_APP */
public class PromptFriendSelectorFragmentFactory implements IFragmentFactory {
    public final Fragment m25918a(Intent intent) {
        PromptFriendSelectorFragment promptFriendSelectorFragment = new PromptFriendSelectorFragment();
        promptFriendSelectorFragment.g(intent.getExtras());
        return promptFriendSelectorFragment;
    }
}
