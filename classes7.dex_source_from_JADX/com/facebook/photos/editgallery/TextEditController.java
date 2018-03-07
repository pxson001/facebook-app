package com.facebook.photos.editgallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.TextOnPhotosLoggingParams;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem.OverlayItemType;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.model.TextParams;
import com.facebook.photos.creativeediting.ui.KeyboardAwareEditText.KeyboardEventCallBack;
import com.facebook.photos.creativeediting.ui.PhotoTextEditorEntryLayout;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.EditableOverlayContainerView.CallBack;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: latest_notification_creation_time */
public class TextEditController implements EditFeatureController, MovableItemListener {
    private final KeyboardEventCallBack f10439a = new C08801(this);
    public final CallBack f10440b = new C08812(this);
    public final Context f10441c;
    private final CreativeEditingFileManager f10442d;
    public final SpringAlphaAnimator f10443e;
    private final FrameLayout f10444f;
    private final String f10445g;
    public final EditGalleryFragmentController f10446h;
    public final FbDraweeControllerBuilder f10447i;
    public final PostprocessorFactory f10448j;
    private final Fb4aTitleBar f10449k;
    public final String f10450l;
    public boolean f10451m;
    public PhotoTextEditorEntryLayout f10452n;
    public EditableOverlayContainerView f10453o;
    public State f10454p;
    public TextOnPhotosLoggingParams f10455q = new TextOnPhotosLoggingParams();
    public Uri f10456r;
    private boolean f10457s;
    @Nullable
    private Rect f10458t;
    public TextEditState f10459u;
    private Optional<CreativeEditingLogger> f10460v;
    public MovableItemListener f10461w;

    /* compiled from: latest_notification_creation_time */
    class C08801 implements KeyboardEventCallBack {
        final /* synthetic */ TextEditController f10435a;

        C08801(TextEditController textEditController) {
            this.f10435a = textEditController;
        }

        public final void mo593a() {
            TextEditController.m12308a(this.f10435a, this.f10435a.f10452n.f10025a);
            TextEditController.m12309a(this.f10435a, this.f10435a.f10450l);
            this.f10435a.f10459u = TextEditState.TEXT_EDIT;
            if (this.f10435a.f10453o.getOverlayParamsForOriginalPhoto().isEmpty()) {
                this.f10435a.f10455q.f9574b = false;
            }
            this.f10435a.f10452n.setTextParams(null);
        }

        public final void mo594a(int i) {
            TextEditController.m12307a(this.f10435a, i);
        }
    }

    /* compiled from: latest_notification_creation_time */
    class C08812 implements CallBack {
        final /* synthetic */ TextEditController f10436a;

        C08812(TextEditController textEditController) {
            this.f10436a = textEditController;
        }

        public final void mo587a() {
            TextEditController.m12309a(this.f10436a, this.f10436a.f10441c.getResources().getString(2131234500));
            TextEditController.m12311r(this.f10436a);
        }

        public final void mo590a(boolean z) {
            PhotoOverlayItem selectedItem = this.f10436a.f10453o.getSelectedItem();
            if (selectedItem instanceof TextParams) {
                TextParams textParams = (TextParams) selectedItem;
                this.f10436a.f10452n.setTextParams(textParams);
                String g = textParams.g();
                if (g != null) {
                    TextOnPhotosLoggingParams textOnPhotosLoggingParams = this.f10436a.f10455q;
                    Preconditions.checkNotNull(g);
                    if (!textOnPhotosLoggingParams.f9577e.contains(g)) {
                        textOnPhotosLoggingParams.f9577e.add(g);
                    }
                }
                TextEditController.m12309a(this.f10436a, this.f10436a.f10441c.getResources().getString(2131234500));
                TextEditController.m12311r(this.f10436a);
                this.f10436a.f10451m = true;
            }
        }

        public final void mo588a(PhotoOverlayItem photoOverlayItem) {
            this.f10436a.f10451m = true;
            this.f10436a.f10461w.mo579a(EditableOverlayContainerView.m12220c(photoOverlayItem));
        }

        public final void mo589a(String str) {
            this.f10436a.f10451m = true;
            this.f10436a.f10461w.mo580a(str, EditableOverlayContainerView.m12220c(this.f10436a.f10453o.getSelectedItem()));
        }

        public final void mo591b(String str) {
            this.f10436a.f10451m = true;
            this.f10436a.f10461w.mo581b(str, EditableOverlayContainerView.m12220c(this.f10436a.f10453o.getSelectedItem()));
        }

        public final void mo592c(String str) {
            this.f10436a.f10451m = true;
            this.f10436a.f10461w.mo582c(str, EditableOverlayContainerView.m12220c(this.f10436a.f10453o.getSelectedItem()));
        }
    }

    /* compiled from: latest_notification_creation_time */
    enum TextEditState {
        TEXT_ENTRY,
        TEXT_EDIT
    }

    @Inject
    public TextEditController(@Assisted Uri uri, @Assisted Fb4aTitleBar fb4aTitleBar, @Assisted String str, @Assisted FrameLayout frameLayout, @Assisted EditableOverlayContainerView editableOverlayContainerView, @Assisted String str2, @Assisted PostprocessorFactory postprocessorFactory, @Assisted RotatingPhotoViewController rotatingPhotoViewController, @Assisted MovableItemListener movableItemListener, @Assisted Optional<CreativeEditingLogger> optional, FbDraweeControllerBuilder fbDraweeControllerBuilder, Context context, CreativeEditingFileManager creativeEditingFileManager, SpringAlphaAnimator springAlphaAnimator) {
        this.f10456r = uri;
        this.f10449k = fb4aTitleBar;
        this.f10450l = str;
        this.f10444f = frameLayout;
        this.f10441c = context;
        this.f10447i = fbDraweeControllerBuilder;
        this.f10446h = rotatingPhotoViewController;
        this.f10445g = str2;
        this.f10442d = creativeEditingFileManager;
        this.f10448j = postprocessorFactory;
        this.f10443e = springAlphaAnimator;
        this.f10452n = new PhotoTextEditorEntryLayout(this.f10441c);
        this.f10452n.m11960a();
        this.f10444f.addView(this.f10452n, new LayoutParams(-1, -1));
        this.f10452n.setCallBack(this.f10439a);
        this.f10453o = editableOverlayContainerView;
        this.f10459u = TextEditState.TEXT_EDIT;
        this.f10460v = optional;
        this.f10461w = movableItemListener;
    }

    public final void mo564b() {
        this.f10453o.m11588b();
        this.f10453o.m11593j();
        this.f10457s = false;
    }

    public final void mo562a(UsageParams usageParams) {
        usageParams.f10346a++;
    }

    public final void mo565c() {
        this.f10440b.mo587a();
    }

    public final void mo569g() {
        this.f10452n.m11960a();
    }

    public final String mo559a() {
        return this.f10441c.getResources().getString(2131237785);
    }

    public final void mo560a(Rect rect) {
        this.f10458t = rect;
        m12310p();
    }

    public final boolean mo574l() {
        return this.f10451m;
    }

    public final State mo575m() {
        this.f10454p.f10290k = new Builder(this.f10454p.f10290k).b(this.f10453o.getOverlayParamsForOriginalPhoto()).a();
        return this.f10454p;
    }

    public final Object mo572j() {
        return EditFeature.TEXT;
    }

    public final boolean mo566d() {
        return false;
    }

    public final boolean mo567e() {
        if (this.f10459u != TextEditState.TEXT_ENTRY) {
            return false;
        }
        this.f10452n.f10026b.m11932b();
        return true;
    }

    public final void mo568f() {
    }

    public final void mo570h() {
        if (this.f10453o.getVisibility() != 0) {
            this.f10453o.setAlpha(0.0f);
            this.f10453o.setVisibility(0);
            this.f10443e.a();
            this.f10443e.a(this.f10453o, 1);
        }
        this.f10453o.setActionButtonEnabled(true);
    }

    public final void mo571i() {
        this.f10453o.setVisibility(4);
        this.f10453o.setActionButtonEnabled(false);
    }

    public final void mo563a(boolean z) {
        this.f10455q.f9574b = z;
        if (this.f10460v.isPresent()) {
            ((CreativeEditingLogger) this.f10460v.get()).m11477a(this.f10455q);
        }
    }

    public final UriRequestType mo573k() {
        return UriRequestType.SHOW_EDITED_URI;
    }

    private void m12310p() {
        if (this.f10458t != null && this.f10457s) {
            this.f10452n.m11960a();
        }
    }

    public static void m12308a(@Nullable TextEditController textEditController, TextParams textParams) {
        try {
            if (Strings.isNullOrEmpty(textEditController.f10452n.getText())) {
                if (textParams != null) {
                    textEditController.f10453o.m11589b(textParams);
                }
                m12307a(textEditController, 0);
                textEditController.f10452n.m11960a();
                textEditController.f10444f.invalidate();
                return;
            }
            textEditController.f10452n.m11963e();
            File a = textEditController.f10442d.a(textEditController.f10445g, ".png");
            if (a == null) {
                m12307a(textEditController, 0);
                textEditController.f10452n.m11960a();
                textEditController.f10444f.invalidate();
                return;
            }
            textEditController.f10452n.m11962a(a);
            Uri fromFile = Uri.fromFile(a);
            if (textParams == null) {
                textEditController.f10453o.m12226a(fromFile, textEditController.f10452n.getText(), textEditController.f10452n.getTextWidth(), textEditController.f10452n.getTextHeight(), textEditController.f10452n.getTextColor(), null);
            } else {
                textEditController.f10453o.mo583k();
                textEditController.f10453o.m12225a(fromFile, textEditController.f10452n.getText(), textEditController.f10452n.getTextWidth(), textEditController.f10452n.getTextHeight(), textEditController.f10452n.getTextColor(), textParams);
            }
            textEditController.f10455q.m11497a();
            textEditController.f10451m = true;
            if (textEditController.f10452n.m11964g() && textEditController.f10452n.getTextColor() != -1) {
                textEditController.f10455q.f9573a = true;
            }
            m12307a(textEditController, 0);
            textEditController.f10452n.m11960a();
            textEditController.f10444f.invalidate();
        } catch (IOException e) {
            if (null != null) {
                CreativeEditingFileManager.a(null);
            }
            m12307a(textEditController, 0);
            textEditController.f10452n.m11960a();
            textEditController.f10444f.invalidate();
        } catch (Throwable th) {
            m12307a(textEditController, 0);
            textEditController.f10452n.m11960a();
            textEditController.f10444f.invalidate();
        }
    }

    public static void m12311r(TextEditController textEditController) {
        textEditController.f10452n.setAlpha(0.0f);
        textEditController.f10452n.bringToFront();
        PhotoTextEditorEntryLayout photoTextEditorEntryLayout = textEditController.f10452n;
        photoTextEditorEntryLayout.bringToFront();
        photoTextEditorEntryLayout.f10026b.setVisibility(0);
        photoTextEditorEntryLayout.f10026b.m11934d();
        photoTextEditorEntryLayout.setVisibility(0);
        photoTextEditorEntryLayout.f10027c.setVisibility(0);
        photoTextEditorEntryLayout.f10027c.setEnabled(true);
        photoTextEditorEntryLayout.f10028d.setVisibility(0);
        photoTextEditorEntryLayout.f10028d.setEnabled(true);
        photoTextEditorEntryLayout.f10029e.setVisibility(0);
        photoTextEditorEntryLayout.f10030f.setVisibility(0);
        photoTextEditorEntryLayout.f10031g.setVisibility(0);
        textEditController.f10459u = TextEditState.TEXT_ENTRY;
    }

    public static void m12309a(TextEditController textEditController, String str) {
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = str;
        textEditController.f10449k.setButtonSpecs(ImmutableList.of(a.a()));
    }

    public static void m12307a(TextEditController textEditController, final int i) {
        textEditController.f10443e.a();
        PhotoTextEditorEntryLayout photoTextEditorEntryLayout = textEditController.f10452n;
        EditGalleryDialogFragment editGalleryDialogFragment = textEditController.f10446h.f10331l;
        int measuredHeight = (editGalleryDialogFragment.T.getMeasuredHeight() - editGalleryDialogFragment.jW_().getDimensionPixelSize(2131429566)) - i;
        LayoutParamsUtil.b(photoTextEditorEntryLayout.f10032h, measuredHeight);
        photoTextEditorEntryLayout.f10026b.setMaxHeight(measuredHeight - photoTextEditorEntryLayout.getResources().getDimensionPixelSize(2131429541));
        textEditController.f10452n.requestLayout();
        textEditController.f10452n.postDelayed(new Runnable(textEditController) {
            final /* synthetic */ TextEditController f10438b;

            public void run() {
                this.f10438b.f10443e.a(this.f10438b.f10452n, i > 0 ? 1 : 0);
            }
        }, 200);
    }

    public final void mo579a(@Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.TEXT) {
            TextOnPhotosLoggingParams textOnPhotosLoggingParams = this.f10455q;
            textOnPhotosLoggingParams.f9580h++;
        }
    }

    public final void mo580a(String str, @Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.TEXT) {
            TextOnPhotosLoggingParams textOnPhotosLoggingParams = this.f10455q;
            Preconditions.checkNotNull(str);
            if (!textOnPhotosLoggingParams.f9575c.contains(str)) {
                textOnPhotosLoggingParams.f9575c.add(str);
            }
        }
    }

    public final void mo581b(String str, @Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.TEXT) {
            TextOnPhotosLoggingParams textOnPhotosLoggingParams = this.f10455q;
            Preconditions.checkNotNull(str);
            if (!textOnPhotosLoggingParams.f9576d.contains(str)) {
                textOnPhotosLoggingParams.f9576d.add(str);
            }
        }
    }

    public final void mo582c(String str, @Nullable OverlayItemType overlayItemType) {
        if (overlayItemType != null && overlayItemType == OverlayItemType.TEXT) {
            TextOnPhotosLoggingParams textOnPhotosLoggingParams = this.f10455q;
            Preconditions.checkNotNull(str);
            if (!textOnPhotosLoggingParams.f9578f.contains(str)) {
                textOnPhotosLoggingParams.f9578f.add(str);
            }
        }
    }

    public final void mo561a(State state) {
        int width;
        int height;
        Preconditions.checkNotNull(state.f10290k);
        this.f10454p = state;
        this.f10453o.m11585a(2130843810, 2131234481, 2131234478);
        this.f10453o.f10365n = this.f10440b;
        this.f10453o.m11590e();
        CreativeEditingData creativeEditingData = this.f10454p.f10290k;
        Uri o = creativeEditingData.o() != null ? creativeEditingData.o() : this.f10456r;
        if (creativeEditingData.c() != null) {
            width = (int) (((float) this.f10446h.f10313P) * creativeEditingData.c().width());
        } else {
            width = this.f10446h.f10313P;
        }
        if (creativeEditingData.c() != null) {
            height = (int) (((float) this.f10446h.f10314Q) * creativeEditingData.c().height());
        } else {
            height = this.f10446h.f10314Q;
        }
        this.f10452n.m11961a(this.f10447i, o, width, height, this.f10448j.m12267a(creativeEditingData, mo573k(), this.f10446h.m12196a(o)));
        this.f10457s = true;
        this.f10451m = false;
        m12310p();
    }
}
