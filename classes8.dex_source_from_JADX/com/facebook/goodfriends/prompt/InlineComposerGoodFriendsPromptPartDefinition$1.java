package com.facebook.goodfriends.prompt;

import android.view.View;

/* compiled from: {share_id} */
class InlineComposerGoodFriendsPromptPartDefinition$1 implements Runnable {
    final /* synthetic */ InlineComposerGoodFriendsPromptPartDefinition$State f28a;
    final /* synthetic */ View f29b;
    final /* synthetic */ InlineComposerGoodFriendsPromptPartDefinition f30c;

    InlineComposerGoodFriendsPromptPartDefinition$1(InlineComposerGoodFriendsPromptPartDefinition inlineComposerGoodFriendsPromptPartDefinition, InlineComposerGoodFriendsPromptPartDefinition$State inlineComposerGoodFriendsPromptPartDefinition$State, View view) {
        this.f30c = inlineComposerGoodFriendsPromptPartDefinition;
        this.f28a = inlineComposerGoodFriendsPromptPartDefinition$State;
        this.f29b = view;
    }

    public void run() {
        if (this.f28a.f31a != null) {
            this.f28a.f31a.a(this.f29b);
            this.f28a.f31a = null;
            this.f30c.b.b.edit().putBoolean(GoodFriendsPromptController.a, false).commit();
        }
    }
}
