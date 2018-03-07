package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.os.IBinder;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.maps.FbStaticMapView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import javax.annotation.Nullable;

/* compiled from: VOICE */
public class AdInterfacesAddressEditView extends CustomLinearLayout {
    private BetterEditTextView f22514a;
    private FbStaticMapView f22515b;

    public AdInterfacesAddressEditView(Context context) {
        super(context);
        m24382a();
    }

    public AdInterfacesAddressEditView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m24382a();
    }

    protected AdInterfacesAddressEditView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24382a();
    }

    private void m24382a() {
        setOrientation(1);
        setContentView(2130903100);
        this.f22514a = (BetterEditTextView) a(2131559250);
        this.f22514a.setSingleLine(true);
        this.f22515b = (FbStaticMapView) a(2131559251);
    }

    public void setMapOptions(StaticMapOptions staticMapOptions) {
        this.f22515b.setMapOptions(staticMapOptions);
    }

    public void setMapEnabled(boolean z) {
        this.f22515b.setVisibility(z ? 0 : 8);
    }

    public void setAddressString(String str) {
        this.f22514a.setText(str);
    }

    public void setOnAddressChangeListener(TextWatcher textWatcher) {
        this.f22514a.addTextChangedListener(textWatcher);
    }

    public IBinder getEditTextToken() {
        return this.f22514a.getWindowToken();
    }
}
