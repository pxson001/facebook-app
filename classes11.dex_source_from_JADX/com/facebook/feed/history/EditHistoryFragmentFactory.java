package com.facebook.feed.history;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.google.common.base.Preconditions;

/* compiled from: drops */
public class EditHistoryFragmentFactory implements IFragmentFactory {
    public final Fragment m8729a(Intent intent) {
        String str = (String) Preconditions.checkNotNull(intent.getStringExtra("story_id"));
        String str2 = (String) Preconditions.checkNotNull(intent.getStringExtra("module_name"));
        StoryEditHistoryFragment storyEditHistoryFragment = new StoryEditHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("node_id", str);
        bundle.putString("module", str2);
        storyEditHistoryFragment.g(bundle);
        return storyEditHistoryFragment;
    }
}
