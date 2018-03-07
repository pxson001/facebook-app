package com.facebook.goodwill.feed.rows;

import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: fb_android */
public class ThrowbackFriendversaryFriendPartDefinitionProvider extends AbstractAssistedProvider<ThrowbackFriendversaryFriendPartDefinition> {
    public final ThrowbackFriendversaryFriendPartDefinition m15392a(Boolean bool) {
        return new ThrowbackFriendversaryFriendPartDefinition(BackgroundPartDefinition.a(this), ThrowbackFriendversaryFriendViewPartDefinition.m15394a((InjectorLike) this), bool);
    }
}
