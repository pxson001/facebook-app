package com.facebook.facecastdisplay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.followvideos.qe.FollowVideosButtonTextHelper;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: audio/true-hd */
public class LiveSubscribeEventView extends CustomLinearLayout {
    @Inject
    public QeAccessor f18936a;
    private final Resources f18937b;
    private final FbButton f18938c;
    private final FbTextView f18939d;

    private static <T extends View> void m22532a(Class<T> cls, T t) {
        m22533a((Object) t, t.getContext());
    }

    private static void m22533a(Object obj, Context context) {
        ((LiveSubscribeEventView) obj).f18936a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public LiveSubscribeEventView(Context context) {
        this(context, null);
    }

    public LiveSubscribeEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveSubscribeEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22532a(LiveSubscribeEventView.class, (View) this);
        setContentView(2130905089);
        setOrientation(0);
        this.f18937b = getResources();
        this.f18938c = (FbButton) a(2131563502);
        this.f18939d = (FbTextView) a(2131563501);
    }

    public final void m22534a(boolean z) {
        boolean a = this.f18936a.a(ExperimentsForVideoHomeAbTestModule.p, false);
        if (z) {
            if (a) {
                this.f18938c.setText(FollowVideosButtonTextHelper.m19645b(this.f18936a, getContext()));
            } else {
                this.f18938c.setText(2131235672);
            }
            this.f18938c.setTextColor(-1);
            this.f18938c.setBackgroundResource(2130841083);
            return;
        }
        if (a) {
            this.f18938c.setText(FollowVideosButtonTextHelper.m19644a(this.f18936a, getContext()));
        } else {
            this.f18938c.setText(2131235671);
        }
        this.f18938c.setTextColor(this.f18937b.getColor(2131361938));
        this.f18938c.setBackgroundResource(2130841082);
    }

    private void m22531a(QeAccessor qeAccessor) {
        this.f18936a = qeAccessor;
    }
}
