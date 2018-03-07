package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03828;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: show_more_title */
public class DraweeSimplePickerGridViewControllerAdapter implements SimplePickerViewControllerAdapter {
    private final GridView f2925a;
    private final DraweeSimplePickerGridViewCursorAdapterProvider f2926b;
    private final boolean f2927c;
    @Nullable
    private DraweeSimplePickerGridViewCursorAdapter f2928d;
    private C03828 f2929e;
    @Nullable
    private FramePackModel f2930f;
    private C03817 f2931g;

    @Inject
    public DraweeSimplePickerGridViewControllerAdapter(@Assisted View view, DraweeSimplePickerGridViewCursorAdapterProvider draweeSimplePickerGridViewCursorAdapterProvider, @Assisted C03817 c03817, @Assisted boolean z) {
        this.f2925a = (GridView) view.findViewById(2131564987);
        this.f2926b = draweeSimplePickerGridViewCursorAdapterProvider;
        this.f2931g = c03817;
        this.f2927c = z;
    }

    public final int mo142a() {
        return this.f2925a.getChildCount();
    }

    public final View mo143a(int i) {
        return this.f2925a.getChildAt(i);
    }

    public final void mo144a(Cursor cursor, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z) {
        this.f2928d = this.f2926b.m3035a(cursor, this.f2931g, pickerSelectionController, optional, z, this.f2927c);
        this.f2925a.setAdapter(this.f2928d);
        m3007f();
        if (this.f2929e != null) {
            mo148a(this.f2929e);
        }
    }

    public final int mo149b() {
        if (this.f2928d != null) {
            return this.f2928d.getCount();
        }
        return 0;
    }

    public final void mo145a(Bundle bundle) {
    }

    public final void mo150b(Bundle bundle) {
    }

    public final void mo146a(SupportedMediaType supportedMediaType) {
        if (this.f2928d != null) {
            this.f2928d.m3031a(supportedMediaType, true);
        }
    }

    public final void mo151c() {
        if (this.f2928d != null) {
            this.f2928d.m3033c();
        }
    }

    public final void mo152d() {
        if (this.f2928d != null) {
            this.f2928d.m3034d();
        }
    }

    public final int mo153e() {
        return 0;
    }

    public final void mo147a(FramePackModel framePackModel) {
        this.f2930f = framePackModel;
        m3007f();
    }

    public final void mo148a(C03828 c03828) {
        this.f2929e = c03828;
        if (this.f2928d != null) {
            this.f2928d.f2956H = c03828;
        }
    }

    private void m3007f() {
        if (this.f2928d != null && this.f2930f != null) {
            this.f2928d.m3032a(this.f2930f);
        }
    }
}
