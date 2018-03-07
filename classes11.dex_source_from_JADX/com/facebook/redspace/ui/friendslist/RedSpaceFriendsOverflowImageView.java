package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.NodesModel;
import com.facebook.user.model.UserKey;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.tiles.ThreadTileView;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: PRIVACY_CHECKUP_PROFILE_STEP_NEXT */
public class RedSpaceFriendsOverflowImageView extends CustomLinearLayout {
    private TextView f12481a;
    public ThreadTileView f12482b;
    private TileData f12483c;

    /* compiled from: PRIVACY_CHECKUP_PROFILE_STEP_NEXT */
    class C14761 implements OnPreDrawListener {
        final /* synthetic */ RedSpaceFriendsOverflowImageView f12478a;

        C14761(RedSpaceFriendsOverflowImageView redSpaceFriendsOverflowImageView) {
            this.f12478a = redSpaceFriendsOverflowImageView;
        }

        public boolean onPreDraw() {
            this.f12478a.f12482b.setTileSizePx(this.f12478a.getWidth());
            this.f12478a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* compiled from: PRIVACY_CHECKUP_PROFILE_STEP_NEXT */
    public class TileData implements ThreadTileViewData {
        public OverflowFriendsModel f12479a;
        public Postprocessor f12480b;

        public final TileData m12881a(OverflowFriendsModel overflowFriendsModel) {
            this.f12479a = overflowFriendsModel;
            return this;
        }

        public final TileData m12880a(Postprocessor postprocessor) {
            this.f12480b = postprocessor;
            return this;
        }

        public final int m12878a() {
            if (this.f12479a == null) {
                return 0;
            }
            if (this.f12479a.j().size() <= 3) {
                return this.f12479a.j().size();
            }
            return 3;
        }

        public final ImmutableList<UserKey> m12885d() {
            return RegularImmutableList.a;
        }

        public final ImageRequest m12879a(int i, int i2, int i3) {
            try {
                Uri parse = Uri.parse(((NodesModel) this.f12479a.j().get(i)).a().b());
                Preconditions.checkArgument(m12878a() > 0);
                return ImageRequestBuilder.a(parse).a(this.f12480b).m();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public final ImageRequest m12882b(int i, int i2, int i3) {
            return null;
        }

        public final TileBadge m12883b() {
            return TileBadge.NONE;
        }

        public final boolean m12884c() {
            return false;
        }

        @Nullable
        public final Bitmap m12886e() {
            return null;
        }

        public final String m12887f() {
            return null;
        }
    }

    public RedSpaceFriendsOverflowImageView(Context context) {
        super(context);
        m12889a(context, null);
    }

    public RedSpaceFriendsOverflowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12889a(context, attributeSet);
    }

    public RedSpaceFriendsOverflowImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12889a(context, attributeSet);
    }

    private void m12889a(Context context, @Nullable AttributeSet attributeSet) {
        setContentView(2130906767);
        this.f12481a = (TextView) findViewById(2131566864);
        this.f12482b = (ThreadTileView) findViewById(2131560123);
        getViewTreeObserver().addOnPreDrawListener(new C14761(this));
        this.f12483c = new TileData();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RedSpaceFriendsOverflowImageView);
            int color = obtainStyledAttributes.getColor(1, -1);
            if (color != -1) {
                this.f12483c.f12480b = new DarkenPostProcessor(color);
            }
            color = obtainStyledAttributes.getResourceId(0, -1);
            if (color != -1) {
                this.f12481a.setTextAppearance(context, color);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void m12890a(OverflowFriendsModel overflowFriendsModel) {
        if (this.f12483c.f12479a != overflowFriendsModel) {
            CharSequence charSequence;
            int a = overflowFriendsModel.a().a();
            boolean j = overflowFriendsModel.a().j();
            if (a == 0) {
                a = overflowFriendsModel.j().size();
                j = overflowFriendsModel.j().size() == 3;
            }
            String valueOf = String.valueOf(a);
            if (j) {
                charSequence = valueOf + "+";
            } else {
                Object obj = valueOf;
            }
            this.f12481a.setText(charSequence);
            this.f12483c.f12479a = overflowFriendsModel;
            this.f12482b.setThreadTileViewData(this.f12483c);
        }
    }
}
