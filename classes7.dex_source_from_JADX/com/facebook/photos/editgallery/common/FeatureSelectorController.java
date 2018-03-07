package com.facebook.photos.editgallery.common;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.google.common.base.Preconditions;

/* compiled from: left_subtitle */
public class FeatureSelectorController {
    private final OnClickListener f10487a = new C08871(this);
    public final MediaEditFeatureController f10488b;
    public final FeatureSelectorControllerCallback f10489c;
    private ImageButton f10490d;
    public boolean f10491e;
    private Fb4aTitleBar f10492f;
    private FbTextView f10493g;
    private Context f10494h;

    /* compiled from: left_subtitle */
    public interface FeatureSelectorControllerCallback {
        void mo577a(FeatureSelectorController featureSelectorController);

        boolean mo578a();
    }

    /* compiled from: left_subtitle */
    class C08871 implements OnClickListener {
        final /* synthetic */ FeatureSelectorController f10486a;

        C08871(FeatureSelectorController featureSelectorController) {
            this.f10486a = featureSelectorController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 280525380);
            if (!this.f10486a.f10489c.mo578a()) {
                Logger.a(2, EntryType.UI_INPUT_END, 1028585630, a);
            } else if (this.f10486a.f10491e) {
                this.f10486a.f10488b.mo565c();
                LogUtils.a(1949585925, a);
            } else {
                this.f10486a.m12367a(true);
                this.f10486a.f10489c.mo577a(this.f10486a);
                LogUtils.a(-1261510549, a);
            }
        }
    }

    public FeatureSelectorController(Context context, View view, FeatureSelectorControllerCallback featureSelectorControllerCallback, MediaEditFeatureController mediaEditFeatureController, Fb4aTitleBar fb4aTitleBar, ImageButton imageButton, FbTextView fbTextView) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(featureSelectorControllerCallback);
        Preconditions.checkNotNull(mediaEditFeatureController);
        this.f10494h = context;
        this.f10489c = featureSelectorControllerCallback;
        this.f10488b = mediaEditFeatureController;
        view.setOnClickListener(this.f10487a);
        view.setVisibility(0);
        this.f10492f = fb4aTitleBar;
        this.f10490d = imageButton;
        this.f10493g = fbTextView;
        this.f10490d.setOnClickListener(this.f10487a);
        m12367a(false);
    }

    public final EditFeature m12366a() {
        return (EditFeature) this.f10488b.mo572j();
    }

    public final void m12367a(boolean z) {
        if (z) {
            this.f10490d.clearColorFilter();
            this.f10493g.setTextColor(this.f10494h.getResources().getColor(2131361917));
            this.f10492f.setTitle(this.f10488b.mo559a());
        } else {
            this.f10490d.setColorFilter(this.f10494h.getResources().getColor(2131362927));
            this.f10493g.setTextColor(this.f10494h.getResources().getColor(2131362927));
            this.f10488b.mo564b();
        }
        this.f10491e = z;
    }

    public final MediaEditFeatureController m12368b() {
        return this.f10488b;
    }
}
