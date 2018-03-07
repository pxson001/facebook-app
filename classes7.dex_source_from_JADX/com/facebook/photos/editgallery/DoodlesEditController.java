package com.facebook.photos.editgallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.facebook.inject.Assisted;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.DoodleOnPhotosLoggingParams;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.ui.PhotoDoodleEditorLayout;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: life_event_model */
public class DoodlesEditController implements EditFeatureController {
    private static final String f10223a = DoodlesEditController.class.getSimpleName();
    private final OnClickListener f10224b = new C08601(this);
    private final OnClickListener f10225c = new C08612(this);
    private final C08623 f10226d = new C08623(this);
    private final Context f10227e;
    private final FrameLayout f10228f;
    private final String f10229g;
    private final EditGalleryFragmentController f10230h;
    private final CreativeEditingFileManager f10231i;
    public PhotoDoodleEditorLayout f10232j;
    private View f10233k;
    public FbTextView f10234l;
    public FbTextView f10235m;
    private State f10236n;
    public DoodleOnPhotosLoggingParams f10237o = new DoodleOnPhotosLoggingParams();
    public EditableOverlayContainerView f10238p;
    private Optional<CreativeEditingLogger> f10239q;

    /* compiled from: life_event_model */
    class C08601 implements OnClickListener {
        final /* synthetic */ DoodlesEditController f10220a;

        C08601(DoodlesEditController doodlesEditController) {
            this.f10220a = doodlesEditController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 412084301);
            DoodleOnPhotosLoggingParams doodleOnPhotosLoggingParams = this.f10220a.f10237o;
            doodleOnPhotosLoggingParams.f9565d++;
            PhotoDoodleEditorLayout photoDoodleEditorLayout = this.f10220a.f10232j;
            photoDoodleEditorLayout.f10014a.b();
            photoDoodleEditorLayout.f10018e = true;
            this.f10220a.f10238p.mo584l();
            if (!this.f10220a.f10232j.m11956f()) {
                this.f10220a.f10235m.setVisibility(4);
                this.f10220a.f10234l.setVisibility(4);
                if (this.f10220a.f10238p.m12234n()) {
                    this.f10220a.f10238p.mo585m();
                }
            }
            this.f10220a.f10238p.invalidate();
            Logger.a(2, EntryType.UI_INPUT_END, 1388083024, a);
        }
    }

    /* compiled from: life_event_model */
    class C08612 implements OnClickListener {
        final /* synthetic */ DoodlesEditController f10221a;

        C08612(DoodlesEditController doodlesEditController) {
            this.f10221a = doodlesEditController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -939458068);
            DoodleOnPhotosLoggingParams doodleOnPhotosLoggingParams = this.f10221a.f10237o;
            doodleOnPhotosLoggingParams.f9566e++;
            PhotoDoodleEditorLayout photoDoodleEditorLayout = this.f10221a.f10232j;
            photoDoodleEditorLayout.f10014a.a();
            photoDoodleEditorLayout.f10018e = true;
            this.f10221a.f10238p.mo585m();
            this.f10221a.f10238p.invalidate();
            this.f10221a.f10235m.setVisibility(4);
            this.f10221a.f10234l.setVisibility(4);
            Logger.a(2, EntryType.UI_INPUT_END, -1510415284, a);
        }
    }

    /* compiled from: life_event_model */
    public class C08623 {
        public final /* synthetic */ DoodlesEditController f10222a;

        C08623(DoodlesEditController doodlesEditController) {
            this.f10222a = doodlesEditController;
        }
    }

    @Inject
    public DoodlesEditController(@Assisted FrameLayout frameLayout, @Assisted View view, @Assisted EditableOverlayContainerView editableOverlayContainerView, @Assisted String str, @Assisted Optional<CreativeEditingLogger> optional, @Assisted RotatingPhotoViewController rotatingPhotoViewController, Context context, CreativeEditingFileManager creativeEditingFileManager) {
        this.f10228f = frameLayout;
        this.f10227e = context;
        this.f10229g = str;
        this.f10230h = rotatingPhotoViewController;
        this.f10231i = creativeEditingFileManager;
        this.f10232j = new PhotoDoodleEditorLayout(this.f10227e);
        this.f10232j.f10020g = this.f10226d;
        this.f10233k = view;
        this.f10234l = (FbTextView) this.f10233k.findViewById(2131559197);
        this.f10235m = (FbTextView) this.f10233k.findViewById(2131559199);
        this.f10238p = editableOverlayContainerView;
        this.f10228f.addView(this.f10232j, new LayoutParams(-1, -1));
        this.f10232j.m11957i();
        m12088o();
        this.f10239q = optional;
    }

    public final void mo564b() {
        this.f10232j.m11957i();
        this.f10235m.setVisibility(4);
        this.f10234l.setVisibility(4);
        this.f10233k.setVisibility(4);
    }

    public final void mo568f() {
    }

    public final void mo565c() {
    }

    public final String mo559a() {
        return this.f10227e.getString(2131237787);
    }

    public final boolean mo574l() {
        return this.f10232j.f10018e || this.f10232j.m11956f();
    }

    public final State mo575m() {
        if (this.f10232j.f10018e && this.f10232j.m11956f()) {
            m12089p();
        }
        this.f10232j.m11955a();
        this.f10236n.f10290k = new Builder(this.f10236n.f10290k).b(this.f10238p.getOverlayParamsForOriginalPhoto()).a();
        return this.f10236n;
    }

    public final boolean mo566d() {
        return false;
    }

    public final UriRequestType mo573k() {
        return UriRequestType.SHOW_EDITED_URI;
    }

    public final void mo562a(UsageParams usageParams) {
        usageParams.f10348c++;
    }

    public final boolean mo567e() {
        return false;
    }

    public final void mo560a(Rect rect) {
        Preconditions.checkNotNull(rect);
        PhotoDoodleEditorLayout photoDoodleEditorLayout = this.f10232j;
        ViewGroup.LayoutParams layoutParams = new LayoutParams(rect.width(), rect.height());
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        photoDoodleEditorLayout.f10014a.setLayoutParams(layoutParams);
    }

    public final Object mo572j() {
        return EditFeature.DOODLE;
    }

    public final void mo569g() {
    }

    public final void mo570h() {
        this.f10238p.setVisibility(0);
        this.f10238p.setActionButtonEnabled(true);
    }

    public final void mo571i() {
        this.f10238p.setVisibility(4);
        this.f10238p.setActionButtonEnabled(false);
    }

    public final void mo563a(boolean z) {
        this.f10237o.f9563b = z;
        if (this.f10239q.isPresent()) {
            ((CreativeEditingLogger) this.f10239q.get()).m11475a(this.f10237o);
        }
    }

    private void m12088o() {
        this.f10233k.setVisibility(0);
        this.f10235m.setText(this.f10227e.getString(2131237574));
        this.f10235m.setOnClickListener(this.f10224b);
        this.f10235m.setTextColor(this.f10227e.getResources().getColor(2131362927));
        this.f10235m.setVisibility(4);
        this.f10235m.setContentDescription(this.f10227e.getString(2131237800));
        this.f10234l.setText(this.f10227e.getString(2131237790));
        this.f10234l.setOnClickListener(this.f10225c);
        this.f10234l.setTextColor(this.f10227e.getResources().getColor(2131362927));
        this.f10234l.setVisibility(4);
        this.f10234l.setContentDescription(this.f10227e.getString(2131237799));
        this.f10233k.findViewById(2131559198).setVisibility(4);
        if (this.f10232j.m11956f()) {
            this.f10235m.setVisibility(0);
            this.f10234l.setVisibility(0);
        }
        if (this.f10236n != null && this.f10236n.f10290k != null && this.f10236n.f10290k.f() != null && !this.f10236n.f10290k.f().isEmpty()) {
            this.f10234l.setVisibility(0);
        }
    }

    private void m12089p() {
        Preconditions.checkArgument(this.f10232j.m11956f());
        try {
            File a = this.f10231i.a(this.f10229g, ".png");
            Bitmap a2 = this.f10232j.m11954a(2);
            if (a == null || a2 == null) {
                Toast.makeText(this.f10227e, this.f10227e.getString(2131237801), 0).show();
                return;
            }
            OutputStream fileOutputStream = new FileOutputStream(a);
            a2.compress(CompressFormat.PNG, 0, fileOutputStream);
            fileOutputStream.close();
            Uri fromFile = Uri.fromFile(a);
            this.f10238p.m12223a(fromFile, a2.getWidth() * 2, a2.getHeight() * 2, (float) this.f10230h.m12196a(fromFile), "doodle");
            this.f10228f.invalidate();
        } catch (IOException e) {
            if (null != null) {
                CreativeEditingFileManager.a(null);
            }
            e.getMessage();
        } finally {
            this.f10228f.invalidate();
        }
    }

    public final void mo561a(State state) {
        Preconditions.checkNotNull(state.f10290k);
        this.f10236n = state;
        this.f10232j.m11955a();
        PhotoDoodleEditorLayout photoDoodleEditorLayout = this.f10232j;
        photoDoodleEditorLayout.setVisibility(0);
        photoDoodleEditorLayout.setEnabled(true);
        m12088o();
    }
}
