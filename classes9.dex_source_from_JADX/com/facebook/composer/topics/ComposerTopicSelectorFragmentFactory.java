package com.facebook.composer.topics;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: Type  */
public class ComposerTopicSelectorFragmentFactory implements IFragmentFactory {
    public final Fragment m25872a(Intent intent) {
        ComposerTopicSelectorFragment composerTopicSelectorFragment = new ComposerTopicSelectorFragment();
        composerTopicSelectorFragment.g(intent.getExtras());
        return composerTopicSelectorFragment;
    }
}
