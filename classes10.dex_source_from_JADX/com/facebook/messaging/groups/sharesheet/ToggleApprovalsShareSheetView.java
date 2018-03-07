package com.facebook.messaging.groups.sharesheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.tiles.ThreadTileView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: short[] */
public class ToggleApprovalsShareSheetView extends CustomLinearLayout {
    final OnCheckedChangeListener f2534a = new C04241(this);
    @Inject
    public MessengerThreadTileViewDataFactory f2535b;
    private ContentView f2536c;
    private ViewGroup f2537d;
    private SwitchCompat f2538e;
    private ThreadTileView f2539f;
    @Nullable
    public Callback f2540g;

    /* compiled from: short[] */
    public interface Callback {
        void mo71a(boolean z);
    }

    /* compiled from: short[] */
    class C04241 implements OnCheckedChangeListener {
        final /* synthetic */ ToggleApprovalsShareSheetView f2533a;

        C04241(ToggleApprovalsShareSheetView toggleApprovalsShareSheetView) {
            this.f2533a = toggleApprovalsShareSheetView;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f2533a.f2540g != null) {
                this.f2533a.f2540g.mo71a(z);
            }
        }
    }

    private static <T extends View> void m2554a(Class<T> cls, T t) {
        m2555a((Object) t, t.getContext());
    }

    private static void m2555a(Object obj, Context context) {
        ((ToggleApprovalsShareSheetView) obj).f2535b = MessengerThreadTileViewDataFactory.a(FbInjector.get(context));
    }

    public ToggleApprovalsShareSheetView(Context context) {
        super(context);
        m2553a(context);
    }

    public ToggleApprovalsShareSheetView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2553a(context);
    }

    public ToggleApprovalsShareSheetView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2553a(context);
    }

    private void m2553a(Context context) {
        m2554a(ToggleApprovalsShareSheetView.class, (View) this);
        setOrientation(1);
        setContentView(2130907514);
        this.f2536c = (ContentView) a(2131568033);
        this.f2537d = (ViewGroup) a(2131568034);
        this.f2538e = (SwitchCompat) a(2131568036);
        this.f2538e.setOnCheckedChangeListener(this.f2534a);
        this.f2539f = (ThreadTileView) LayoutInflater.from(context).inflate(2130907515, null);
        this.f2536c.setThumbnailView(this.f2539f);
    }

    public void setCallback(@Nullable Callback callback) {
        this.f2540g = callback;
    }

    public final void m2557a(boolean z) {
        this.f2537d.setVisibility(z ? 0 : 8);
    }

    public void setTogglePosition(boolean z) {
        this.f2538e.setOnCheckedChangeListener(null);
        this.f2538e.setCheckedNoAnimation(z);
        this.f2538e.setOnCheckedChangeListener(this.f2534a);
    }

    public final void m2556a(ThreadSummary threadSummary) {
        Preconditions.checkNotNull(threadSummary);
        this.f2536c.setTitleText(threadSummary.g);
        this.f2539f.setThreadTileViewData(this.f2535b.a(threadSummary));
    }
}
