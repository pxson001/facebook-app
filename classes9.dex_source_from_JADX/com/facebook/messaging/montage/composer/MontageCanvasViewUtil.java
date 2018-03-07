package com.facebook.messaging.montage.composer;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: is_sender */
public class MontageCanvasViewUtil {
    private final MontageComposerNavigationController f12455a;
    private final Rect f12456b;
    private final WeakReference<ViewGroup> f12457c;

    @Inject
    public MontageCanvasViewUtil(@Assisted MontageComposerNavigationController montageComposerNavigationController, @Assisted ViewGroup viewGroup) {
        this.f12457c = new WeakReference(viewGroup);
        this.f12455a = montageComposerNavigationController;
        this.f12456b = new Rect(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }

    public final void m12928a(final MontageComposerCanvas montageComposerCanvas) {
        ViewGroup viewGroup = (ViewGroup) this.f12457c.get();
        if (viewGroup != null) {
            if (VERSION.SDK_INT >= 23) {
                ViewCompat.a(viewGroup, new OnApplyWindowInsetsListener(this) {
                    final /* synthetic */ MontageCanvasViewUtil f12454b;

                    public final WindowInsetsCompat m12925a(View view, WindowInsetsCompat windowInsetsCompat) {
                        this.f12454b.m12927a(montageComposerCanvas, windowInsetsCompat.a(), windowInsetsCompat.b(), windowInsetsCompat.c());
                        return windowInsetsCompat.f();
                    }
                });
                ViewCompat.z(viewGroup);
                return;
            }
            m12927a(montageComposerCanvas, 0, 0, 0);
        }
    }

    private void m12927a(MontageComposerCanvas montageComposerCanvas, int i, int i2, int i3) {
        montageComposerCanvas.mo474a(this.f12456b.left + i, this.f12456b.top + i2, this.f12456b.right + i3, this.f12456b.bottom + this.f12455a.f12501c.getHeight());
    }
}
