package com.facebook.apptab.ui.nux;

import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.apptab.state.AppTabPrefKeys;
import com.facebook.apptab.state.TabTag;
import com.facebook.nux.ui.NuxBubbleView;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.inject.Inject;

/* compiled from: spam_reporting */
public class FbMainTabActivityNuxController extends MainTabNuxController {
    public State f4257a = State.HIDDEN;
    private FbSharedPreferences f4258b;

    /* compiled from: spam_reporting */
    public enum State {
        SHOWN_TABS,
        SHOWN_MORE,
        HIDDEN
    }

    @Inject
    public FbMainTabActivityNuxController(FbSharedPreferences fbSharedPreferences, Resources resources) {
        super(resources);
        this.f4258b = fbSharedPreferences;
    }

    public static void m7882a(FbMainTabActivityNuxController fbMainTabActivityNuxController, State state) {
        fbMainTabActivityNuxController.f4257a = state;
        switch (1.a[state.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                fbMainTabActivityNuxController.m7890g();
                fbMainTabActivityNuxController.m7886a(fbMainTabActivityNuxController.m7883b(State.SHOWN_TABS), null);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                fbMainTabActivityNuxController.m7890g();
                if (fbMainTabActivityNuxController.m7889f() != 0) {
                    fbMainTabActivityNuxController.m7886a(fbMainTabActivityNuxController.m7883b(State.SHOWN_MORE), TabTag.Bookmark);
                    fbMainTabActivityNuxController.mo1176c();
                    return;
                }
                return;
            case 3:
                fbMainTabActivityNuxController.m7890g();
                return;
            default:
                return;
        }
    }

    private NuxBubbleView m7883b(State state) {
        String str = "";
        CharSequence charSequence = "";
        switch (1.a[state.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = this.f4263e.getString(2131232631);
                charSequence = this.f4263e.getString(2131232630);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = this.f4263e.getString(2131232633);
                charSequence = this.f4263e.getString(2131232632);
                break;
        }
        NuxBubbleView nuxBubbleView = new NuxBubbleView(this.f4261c.getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        nuxBubbleView.setLayoutParams(layoutParams);
        layoutParams.topMargin = this.f4263e.getDimensionPixelSize(2131428118);
        nuxBubbleView.setNubPosition(1);
        if (str != null) {
            nuxBubbleView.setBubbleTitle(str);
        }
        nuxBubbleView.setBubbleBody(charSequence);
        NuxBubbleView nuxBubbleView2 = nuxBubbleView;
        nuxBubbleView2.setOnTouchListener(new NuxBubbleTouchListener(this));
        return nuxBubbleView2;
    }

    protected final void mo1176c() {
        this.f4258b.edit().putBoolean(AppTabPrefKeys.f8143d, true).commit();
    }
}
