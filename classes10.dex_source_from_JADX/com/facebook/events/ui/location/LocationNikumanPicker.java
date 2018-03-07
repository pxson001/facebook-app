package com.facebook.events.ui.location;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Provider;

/* compiled from: application/x-www-form-urlencoded;charset=UTF-8 */
public class LocationNikumanPicker extends BadgeTextView {
    public EventLocationModel f19465a;
    public Activity f19466b;
    public boolean f19467c;
    public boolean f19468d;
    public int f19469e;
    public Provider<LocationPickerLauncher> f19470f;

    /* compiled from: application/x-www-form-urlencoded;charset=UTF-8 */
    class C27701 implements OnClickListener {
        final /* synthetic */ LocationNikumanPicker f19464a;

        C27701(LocationNikumanPicker locationNikumanPicker) {
            this.f19464a = locationNikumanPicker;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1519161022);
            LocationPickerLauncher locationPickerLauncher = (LocationPickerLauncher) this.f19464a.f19470f.get();
            locationPickerLauncher.f19479c = this.f19464a.f19465a;
            locationPickerLauncher = locationPickerLauncher;
            locationPickerLauncher.f19478b = this.f19464a.f19468d;
            locationPickerLauncher.m19662a(this.f19464a.f19466b, this.f19464a.f19469e);
            this.f19464a.f19467c = true;
            Logger.a(2, EntryType.UI_INPUT_END, 419722293, a);
        }
    }

    public LocationNikumanPicker(Context context) {
        super(context);
        m19639b();
    }

    public LocationNikumanPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19639b();
    }

    public LocationNikumanPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19639b();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m19639b() {
        setFocusable(false);
        setCursorVisible(false);
        setHint(2131236904);
        setSingleLine(true);
        setLines(1);
        setEllipsize(TruncateAt.END);
        setOnClickListener(new C27701(this));
    }

    public final void m19645a(EventLocationModel eventLocationModel, Provider<LocationPickerLauncher> provider, Activity activity, int i, boolean z) {
        this.f19465a = eventLocationModel;
        this.f19470f = provider;
        this.f19466b = activity;
        this.f19469e = i;
        this.f19468d = z;
        m19640c();
    }

    public final void m19644a(Intent intent) {
        this.f19465a.m19634a(intent);
        m19640c();
    }

    public final boolean m19646a() {
        return this.f19467c;
    }

    public EventLocationModel getPickedLocation() {
        return this.f19465a;
    }

    private void m19640c() {
        if (this.f19465a.f19461a != null) {
            setText(this.f19465a.f19461a.j());
            a(getContext(), 2131626534);
        } else if (this.f19465a.f19463c != null) {
            setText(this.f19465a.f19463c);
            a(getContext(), 2131626534);
        } else {
            setText("");
            a(getContext(), 2131626533);
        }
    }
}
