package com.facebook.messaging.composershortcuts;

import com.facebook.messaging.composershortcuts.ComposerButton.ComposerButtonStateObserver;
import com.facebook.orca.compose.TwoLineComposerView.13;

/* compiled from: messenger_ads_link_click_cta */
public interface ComposerShortcutsContainer {

    /* compiled from: messenger_ads_link_click_cta */
    public class ComposerShortcutState {
        public ComposerShortcutItem f10012a;
        public boolean f10013b = true;
        public boolean f10014c = true;
        boolean f10015d;

        ComposerShortcutState(ComposerShortcutItem composerShortcutItem) {
            this.f10012a = composerShortcutItem;
        }
    }

    int mo409a(String str, boolean z);

    ComposerShortcutsContainerLogic getComposerShortcutsContainerLogic();

    void setComposerButtonStateObserver(ComposerButtonStateObserver composerButtonStateObserver);

    void setLikeIconIdOverride(int i);

    void setListener(13 13);

    void setNonBuiltInShortcutsHidden(boolean z);
}
