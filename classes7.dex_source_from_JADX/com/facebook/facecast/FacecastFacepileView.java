package com.facebook.facecast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.widget.CustomLinearLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: burst_count */
public class FacecastFacepileView extends CustomLinearLayout {
    @Inject
    public UserTileViewLogic f18008a;
    private final int f18009b;
    private final List<FacepileView> f18010c;
    private final List<Face> f18011d;

    private static <T extends View> void m21862a(Class<T> cls, T t) {
        m21863a((Object) t, t.getContext());
    }

    private static void m21863a(Object obj, Context context) {
        ((FacecastFacepileView) obj).f18008a = UserTileViewLogic.a(FbInjector.get(context));
    }

    public FacecastFacepileView(Context context) {
        this(context, null);
    }

    public FacecastFacepileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastFacepileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21862a(FacecastFacepileView.class, (View) this);
        setOrientation(1);
        this.f18009b = getResources().getDimensionPixelSize(2131432319);
        this.f18010c = new ArrayList();
        for (int i2 = 0; i2 <= 0; i2++) {
            View.inflate(context, 2130904205, this);
            this.f18010c.add((FacepileView) getChildAt(getChildCount() - 1));
        }
        this.f18011d = new ArrayList();
    }

    public void setFBIDs(List<String> list) {
        this.f18011d.clear();
        for (String a : list) {
            this.f18011d.add(new Face(this.f18008a.a(a, this.f18009b, this.f18009b)));
        }
        ((FacepileView) this.f18010c.get(0)).setFaces(this.f18011d);
    }

    private void m21861a(UserTileViewLogic userTileViewLogic) {
        this.f18008a = userTileViewLogic;
    }
}
