package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.feedplugins.loadingindicator.GlowingStoryView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: V2_CONVERSATION_STARTER */
public class AdInterfacesNativePreviewView extends CustomFrameLayout {
    private GlowingStoryView f22808a;
    public ViewGroup f22809b;

    public AdInterfacesNativePreviewView(Context context) {
        super(context);
        m24733a();
    }

    public AdInterfacesNativePreviewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m24733a();
    }

    public AdInterfacesNativePreviewView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24733a();
    }

    private void m24733a() {
        setContentView(2130903128);
        this.f22808a = (GlowingStoryView) c(2131559308);
        this.f22809b = (ViewGroup) c(2131559309);
    }

    public void setIsLoading(boolean z) {
        this.f22808a.setVisibility(z ? 0 : 8);
        if (z) {
            this.f22808a.a();
        } else {
            this.f22808a.b();
        }
    }

    public ViewGroup getContainerView() {
        return this.f22809b;
    }
}
