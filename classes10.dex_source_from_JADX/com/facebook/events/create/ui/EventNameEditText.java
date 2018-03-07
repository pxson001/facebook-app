package com.facebook.events.create.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.events.create.EventCompositionModel;
import com.facebook.events.create.LaunchEventComposerPerformanceLogger;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbEditText;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import javax.inject.Inject;

/* compiled from: contact_sync_web_view_received_error */
public class EventNameEditText extends FbEditText {
    @Inject
    public LaunchEventComposerPerformanceLogger f16374b;
    public EventCompositionModel f16375c;
    public int f16376d = 0;
    private boolean f16377e = true;
    private int f16378f = getResources().getColor(2131361972);
    public OnEventNameEditedListener f16379g;
    public OnDrawListener f16380h;

    /* compiled from: contact_sync_web_view_received_error */
    public interface OnDrawListener {
        void mo775a(EventNameEditText eventNameEditText);
    }

    /* compiled from: contact_sync_web_view_received_error */
    public interface OnEventNameEditedListener {
        void mo778a(String str);
    }

    /* compiled from: contact_sync_web_view_received_error */
    class C22851 extends BaseTextWatcher {
        final /* synthetic */ EventNameEditText f16373a;

        C22851(EventNameEditText eventNameEditText) {
            this.f16373a = eventNameEditText;
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > this.f16373a.f16376d) {
                this.f16373a.f16376d = editable.length();
            }
            if (this.f16373a.f16375c != null) {
                this.f16373a.f16375c.f16045c = editable.toString().trim();
            }
            if (this.f16373a.f16379g != null) {
                this.f16373a.f16379g.mo778a(editable.toString());
            }
        }
    }

    private static <T extends View> void m16841a(Class<T> cls, T t) {
        m16842a((Object) t, t.getContext());
    }

    private static void m16842a(Object obj, Context context) {
        ((EventNameEditText) obj).f16374b = LaunchEventComposerPerformanceLogger.m16624a(FbInjector.get(context));
    }

    private void m16840a(LaunchEventComposerPerformanceLogger launchEventComposerPerformanceLogger) {
        this.f16374b = launchEventComposerPerformanceLogger;
    }

    public EventNameEditText(Context context) {
        super(context);
        m16844b();
    }

    public EventNameEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16844b();
    }

    public EventNameEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16844b();
    }

    public final void m16847a(EventCompositionModel eventCompositionModel) {
        this.f16375c = eventCompositionModel;
        setText(this.f16375c.f16045c);
    }

    private void m16844b() {
        m16841a(EventNameEditText.class, (View) this);
        ViewCompat.b(this, 0, 0, getResources().getDimensionPixelSize(2131431106), 0);
        setTextColor(this.f16378f);
        addTextChangedListener(new C22851(this));
    }

    public void setOnEventNameEditedListener(OnEventNameEditedListener onEventNameEditedListener) {
        this.f16379g = onEventNameEditedListener;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.f16380h = onDrawListener;
    }

    public final void m16846a() {
        this.f16379g = null;
    }

    public int getLongestEverMaxLength() {
        return this.f16376d;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16377e) {
            LaunchEventComposerPerformanceLogger launchEventComposerPerformanceLogger = this.f16374b;
            launchEventComposerPerformanceLogger.f16234b.b(launchEventComposerPerformanceLogger.f16233a);
            this.f16377e = false;
        }
        if (this.f16380h != null) {
            this.f16380h.mo775a(this);
        }
    }

    public void setEventNameTextColor(int i) {
        this.f16378f = i;
        setTextColor(this.f16378f);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Parcelable bundle = new Bundle();
        bundle.putParcelable("eventNameEditTextSuperState", onSaveInstanceState);
        bundle.putInt("eventNameTextColor", this.f16378f);
        bundle.putInt("maxLengthEver", this.f16376d);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("eventNameEditTextSuperState"));
        setEventNameTextColor(bundle.getInt("eventNameTextColor"));
        this.f16376d = bundle.getInt("maxLengthEver");
    }
}
