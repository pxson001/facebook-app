package com.facebook.orca.threadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.animatablelistview.custom.AnimatingListViewCustomAnimation;
import com.facebook.widget.animatablelistview.custom.InterceptAnimation;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Supplier;

/* compiled from: migrator_nux_open */
public class InterRowItemAnimationFactory {
    public final Context f6971a;
    public final BetterListView f6972b;
    public final FrameLayout f6973c;
    public final LayoutInflater f6974d;
    public final long f6975e;
    public final UserTileViewParamsFactory f6976f;

    /* compiled from: migrator_nux_open */
    public class MoveUserTileAnimation implements Supplier<AnimatingListViewCustomAnimation> {
        final /* synthetic */ InterRowItemAnimationFactory f6965a;
        private final ParticipantInfo f6966b;
        private final ThreadKey f6967c;
        private final int f6968d;
        private final int f6969e;
        private final boolean f6970f;

        public Object get() {
            UserTileView userTileView = (UserTileView) this.f6965a.f6974d.inflate(2130905754, this.f6965a.f6973c, false);
            userTileView.setParams(this.f6965a.f6976f.a(this.f6966b.b, this.f6966b.c, this.f6967c));
            int dimensionPixelSize = this.f6965a.f6971a.getResources().getDimensionPixelSize(2131428550);
            Context context = this.f6965a.f6971a;
            BetterListView betterListView = this.f6965a.f6972b;
            FrameLayout frameLayout = this.f6965a.f6973c;
            int i = this.f6968d;
            int i2 = this.f6969e;
            long j = this.f6965a.f6975e;
            if (!this.f6970f) {
                dimensionPixelSize = 0;
            }
            return InterceptAnimation.a(context, betterListView, frameLayout, userTileView, i, i2, 2131564859, j, dimensionPixelSize);
        }

        private MoveUserTileAnimation(InterRowItemAnimationFactory interRowItemAnimationFactory, ParticipantInfo participantInfo, ThreadKey threadKey, int i, int i2, boolean z) {
            this.f6965a = interRowItemAnimationFactory;
            this.f6966b = participantInfo;
            this.f6967c = threadKey;
            this.f6968d = i;
            this.f6969e = i2;
            this.f6970f = z;
        }
    }

    public InterRowItemAnimationFactory(Context context, BetterListView betterListView, FrameLayout frameLayout, LayoutInflater layoutInflater, UserTileViewParamsFactory userTileViewParamsFactory, long j) {
        this.f6971a = context;
        this.f6972b = betterListView;
        this.f6973c = frameLayout;
        this.f6974d = layoutInflater;
        this.f6976f = userTileViewParamsFactory;
        this.f6975e = j;
    }

    public final Supplier<AnimatingListViewCustomAnimation> m6574a(ParticipantInfo participantInfo, ThreadKey threadKey, int i, int i2) {
        return new MoveUserTileAnimation(participantInfo, threadKey, i, i2, false);
    }
}
