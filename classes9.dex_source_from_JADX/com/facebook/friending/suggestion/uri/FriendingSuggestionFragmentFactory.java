package com.facebook.friending.suggestion.uri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.friending.suggestion.fragment.FriendingSuggestionFragment;

/* compiled from: TEXT PRIMARY KEY */
public class FriendingSuggestionFragmentFactory implements IFragmentFactory {
    public final Fragment m26771a(Intent intent) {
        long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
        String stringExtra = intent.getStringExtra("profile_name");
        FriendingSuggestionFragment friendingSuggestionFragment = new FriendingSuggestionFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", longExtra);
        bundle.putString("profile_name", stringExtra);
        friendingSuggestionFragment.g(bundle);
        return friendingSuggestionFragment;
    }
}
