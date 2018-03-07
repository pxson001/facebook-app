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
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: shoebox_moments_tab_view */
public class LegacySimplePickerGridViewControllerAdapter implements SimplePickerViewControllerAdapter {
    private final GridView f3011a;
    private final LegacySimplePickerGridViewCursorAdapterProvider f3012b;
    private final boolean f3013c;
    @Nullable
    private LegacySimplePickerGridViewCursorAdapter f3014d;
    private C03828 f3015e;
    @Nullable
    private FramePackModel f3016f;
    private ThumbnailSource f3017g;
    private C03817 f3018h;

    @Inject
    public LegacySimplePickerGridViewControllerAdapter(@Assisted View view, LegacySimplePickerGridViewCursorAdapterProvider legacySimplePickerGridViewCursorAdapterProvider, @Assisted ThumbnailSource thumbnailSource, @Assisted C03817 c03817, @Assisted boolean z) {
        this.f3011a = (GridView) view.findViewById(2131564987);
        this.f3012b = legacySimplePickerGridViewCursorAdapterProvider;
        this.f3017g = thumbnailSource;
        this.f3018h = c03817;
        this.f3013c = z;
    }

    public final int mo142a() {
        return this.f3011a.getChildCount();
    }

    public final View mo143a(int i) {
        return this.f3011a.getChildAt(i);
    }

    public final void mo144a(Cursor cursor, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z) {
        this.f3014d = this.f3012b.m3096a(this.f3017g, cursor, this.f3018h, pickerSelectionController, optional, z, this.f3013c);
        this.f3011a.setAdapter(this.f3014d);
        m3067f();
        if (this.f3015e != null) {
            mo148a(this.f3015e);
        }
    }

    public final int mo149b() {
        if (this.f3014d != null) {
            return this.f3014d.getCount();
        }
        return 0;
    }

    public final void mo145a(Bundle bundle) {
    }

    public final void mo150b(Bundle bundle) {
    }

    public final void mo146a(SupportedMediaType supportedMediaType) {
        if (this.f3014d != null) {
            this.f3014d.m3092a(supportedMediaType, true);
        }
    }

    public final void mo151c() {
        if (this.f3014d != null) {
            this.f3014d.m3094c();
        }
    }

    public final void mo152d() {
        if (this.f3014d != null) {
            this.f3014d.m3095d();
        }
    }

    public final int mo153e() {
        return 0;
    }

    public final void mo147a(FramePackModel framePackModel) {
        this.f3016f = framePackModel;
        m3067f();
    }

    public final void mo148a(C03828 c03828) {
        this.f3015e = c03828;
        if (this.f3014d != null) {
            this.f3014d.f3042H = c03828;
        }
    }

    private void m3067f() {
        if (this.f3014d != null && this.f3016f != null) {
            this.f3014d.m3093a(this.f3016f);
        }
    }
}
