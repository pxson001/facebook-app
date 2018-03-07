package com.facebook.friending.immersive;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.controllers.FriendingButtonControllerWithCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: addNativeEventListener */
public class ImmersivePeopleYouMayKnowAdapterProvider extends AbstractAssistedProvider<ImmersivePeopleYouMayKnowAdapter> {
    public final ImmersivePeopleYouMayKnowAdapter m20510a(OnClickListener onClickListener) {
        return new ImmersivePeopleYouMayKnowAdapter(AllCapsTransformationMethod.b(this), (Context) getInstance(Context.class), FbUriIntentHandler.a(this), FriendingButtonControllerWithCallback.b(this), FriendingClient.b(this), FriendingEventBus.a(this), GlyphColorizer.a(this), ResourcesMethodAutoProvider.a(this), ImmersivePeopleYouMayKnowLoadingState.m20528a(this), onClickListener);
    }
}
