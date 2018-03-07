package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_default_receiving */
public class MontageSeenByListItemView extends CustomRelativeLayout {
    @Inject
    public MessagingDateUtil f12602a;
    @Inject
    public UserTileViewParamsFactory f12603b;
    public final UserTileView f12604c;
    public final FbTextView f12605d;
    public final FbTextView f12606e;

    public static void m13053a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MontageSeenByListItemView montageSeenByListItemView = (MontageSeenByListItemView) obj;
        MessagingDateUtil a = MessagingDateUtil.a(injectorLike);
        UserTileViewParamsFactory a2 = UserTileViewParamsFactory.m16379a(injectorLike);
        montageSeenByListItemView.f12602a = a;
        montageSeenByListItemView.f12603b = a2;
    }

    public MontageSeenByListItemView(Context context) {
        this(context, null);
    }

    private MontageSeenByListItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MontageSeenByListItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MontageSeenByListItemView.class;
        m13053a(this, getContext());
        setContentView(2130905336);
        this.f12604c = (UserTileView) a(2131563980);
        this.f12605d = (FbTextView) a(2131563981);
        this.f12606e = (FbTextView) a(2131563982);
    }
}
