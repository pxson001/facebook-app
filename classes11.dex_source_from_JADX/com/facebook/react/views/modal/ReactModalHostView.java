package com.facebook.react.views.modal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.C1381R;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: S */
public class ReactModalHostView extends ViewGroup implements LifecycleEventListener {
    private DialogRootViewGroup f11476a;
    @Nullable
    private Dialog f11477b;
    public boolean f11478c;
    private String f11479d;
    private boolean f11480e;
    @Nullable
    public OnShowListener f11481f;
    @Nullable
    public OnRequestCloseListener f11482g;

    /* compiled from: S */
    public interface OnRequestCloseListener {
        void mo307a();
    }

    /* compiled from: S */
    class C13871 implements OnKeyListener {
        final /* synthetic */ ReactModalHostView f11474a;

        C13871(ReactModalHostView reactModalHostView) {
            this.f11474a = reactModalHostView;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            if (keyEvent.getAction() != 1) {
                return true;
            }
            Assertions.a(this.f11474a.f11482g, "setOnRequestCloseListener must be called by the manager");
            this.f11474a.f11482g.mo307a();
            return true;
        }
    }

    /* compiled from: S */
    class DialogRootViewGroup extends ReactViewGroup implements RootView {
        private final JSTouchDispatcher f11475a = new JSTouchDispatcher(this);

        public DialogRootViewGroup(Context context) {
            super(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f11475a.b(motionEvent, m11891c());
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1526727920);
            this.f11475a.b(motionEvent, m11891c());
            super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 1427069623, a);
            return true;
        }

        public final void m11892a(MotionEvent motionEvent) {
            this.f11475a.a(motionEvent, m11891c());
        }

        public void requestDisallowInterceptTouchEvent(boolean z) {
        }

        private EventDispatcher m11891c() {
            return ((UIManagerModule) ((ReactContext) getContext()).b(UIManagerModule.class)).a;
        }
    }

    public ReactModalHostView(Context context) {
        super(context);
        ((ReactContext) context).a(this);
        this.f11476a = new DialogRootViewGroup(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void addView(View view, int i) {
        this.f11476a.addView(view, i);
    }

    public int getChildCount() {
        return this.f11476a.getChildCount();
    }

    public View getChildAt(int i) {
        return this.f11476a.getChildAt(i);
    }

    public void removeView(View view) {
        this.f11476a.removeView(view);
    }

    public void removeViewAt(int i) {
        this.f11476a.removeView(getChildAt(i));
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public final void m11896a() {
        ((ReactContext) getContext()).b(this);
        m11894e();
    }

    private void m11894e() {
        if (this.f11477b != null) {
            this.f11477b.dismiss();
            this.f11477b = null;
            ((ViewGroup) this.f11476a.getParent()).removeViewAt(0);
        }
    }

    protected void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.f11482g = onRequestCloseListener;
    }

    protected void setOnShowListener(OnShowListener onShowListener) {
        this.f11481f = onShowListener;
    }

    protected void setTransparent(boolean z) {
        this.f11478c = z;
    }

    public void setAnimationType(String str) {
        this.f11479d = str;
        this.f11480e = true;
    }

    public final void hf_() {
        m11897c();
    }

    public final void hg_() {
        m11894e();
    }

    public final void hh_() {
        m11896a();
    }

    @VisibleForTesting
    @Nullable
    public Dialog getDialog() {
        return this.f11477b;
    }

    protected final void m11897c() {
        if (this.f11477b != null) {
            if (this.f11480e) {
                m11894e();
            } else {
                m11895f();
                return;
            }
        }
        this.f11480e = false;
        int i = C1381R.style.Theme_FullScreenDialog;
        if (this.f11479d.equals("fade")) {
            i = C1381R.style.Theme_FullScreenDialogAnimatedFade;
        } else if (this.f11479d.equals("slide")) {
            i = C1381R.style.Theme_FullScreenDialogAnimatedSlide;
        }
        this.f11477b = new Dialog(getContext(), i);
        this.f11477b.setContentView(this.f11476a);
        m11895f();
        this.f11477b.setOnShowListener(this.f11481f);
        this.f11477b.setOnKeyListener(new C13871(this));
        this.f11477b.show();
    }

    private void m11895f() {
        Assertions.a(this.f11477b, "mDialog must exist when we call updateProperties");
        this.f11477b.getWindow().addFlags(67108864);
        if (this.f11478c) {
            this.f11477b.getWindow().clearFlags(2);
            return;
        }
        this.f11477b.getWindow().setDimAmount(0.5f);
        this.f11477b.getWindow().setFlags(2, 2);
    }
}
