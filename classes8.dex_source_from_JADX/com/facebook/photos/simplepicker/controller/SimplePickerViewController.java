package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewStub;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.simplepicker.SimplePickerFragment.CameraButtonDelegate;
import com.facebook.photos.simplepicker.SimplePickerFragment.CursorUpdatedCallback;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.simplepicker.view.SelectableView;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.LazyView;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: should use init(GraphQLAlbum album) instead.  */
public abstract class SimplePickerViewController implements CursorUpdatedCallback {
    protected final boolean f2998a;
    public final SimplePickerViewControllerAdapter f2999b;
    private final View f3000c;
    public final PickerSelectionController f3001d;
    private final Optional<PickerLongPressProgressBar> f3002e;
    private final boolean f3003f;
    private final QeAccessor f3004g;
    private final boolean f3005h;
    private final boolean f3006i;
    public SupportedMediaType f3007j;
    private LazyView<View> f3008k = new LazyView((ViewStub) this.f3000c.findViewById(2131567467));
    @Nullable
    public CameraButtonDelegate f3009l;

    /* compiled from: should use init(GraphQLAlbum album) instead.  */
    public class C04061 {
        final /* synthetic */ SimplePickerViewController f3156a;

        public C04061(SimplePickerViewController simplePickerViewController) {
            this.f3156a = simplePickerViewController;
        }

        public final List<SelectableView> m3154a() {
            List<SelectableView> arrayList = new ArrayList();
            for (int e = this.f3156a.f2999b.mo153e(); e < this.f3156a.f2999b.mo142a(); e++) {
                arrayList.add((SelectableView) this.f3156a.f2999b.mo143a(e));
            }
            return arrayList;
        }
    }

    public SimplePickerViewController(View view, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, SimplePickerViewControllerAdapter simplePickerViewControllerAdapter, boolean z, boolean z2, boolean z3, Provider<Boolean> provider, QeAccessor qeAccessor) {
        this.f3000c = view;
        this.f3001d = pickerSelectionController;
        this.f3002e = optional;
        this.f2999b = simplePickerViewControllerAdapter;
        this.f3003f = ((Boolean) provider.get()).booleanValue();
        this.f3004g = qeAccessor;
        this.f3005h = z;
        this.f3006i = z2;
        this.f2998a = z3;
    }

    public final void m3061a(SupportedMediaType supportedMediaType) {
        if (this.f3007j != supportedMediaType) {
            this.f3007j = supportedMediaType;
            this.f2999b.mo146a(this.f3007j);
        }
    }

    public final void m3062a(CameraButtonDelegate cameraButtonDelegate) {
        this.f3009l = cameraButtonDelegate;
    }

    public final void mo134a(Cursor cursor) {
        this.f2999b.mo144a(cursor, this.f3001d, this.f3002e, this.f2998a);
        this.f2999b.mo146a(this.f3007j);
        if (this.f2999b.mo149b() == 0) {
            if (this.f3003f) {
                this.f3008k.a().setBackgroundResource(2131361920);
            }
            this.f3008k.a().setVisibility(0);
        } else if (this.f3008k.b()) {
            this.f3008k.a().setVisibility(8);
        }
    }

    public final void m3064b() {
        ImmutableList a = this.f3001d.m3129a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) a.get(i);
            int e = this.f2999b.mo153e();
            while (e < this.f2999b.mo142a()) {
                SelectableView selectableView = (SelectableView) this.f2999b.mo143a(e);
                MediaItem mediaItem2 = selectableView.getMediaItem();
                if (mediaItem2 == null || mediaItem2.c() != mediaItem.c() || mediaItem2.l() != mediaItem.l() || selectableView.isSelected()) {
                    e++;
                } else {
                    selectableView.mo154a(a.size(), true);
                    return;
                }
            }
        }
    }

    public final boolean m3063a() {
        if (VERSION.SDK_INT < 16) {
            return false;
        }
        if (this.f2998a || (this.f3005h && this.f3009l != null && this.f3009l.mo133a() && this.f3004g.a(ExperimentsForCreativeEditingAbtestModule.d, false))) {
            return true;
        }
        return false;
    }
}
