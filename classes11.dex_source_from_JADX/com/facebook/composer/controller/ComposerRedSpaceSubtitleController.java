package com.facebook.composer.controller;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.nux.RedSpaceInterstitialController;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: history_suggestion */
public class ComposerRedSpaceSubtitleController<DataProvider extends ProvidesTargetData & ProvidesRedSpaceValue> implements ComposerEventHandler {
    private final WeakReference<DataProvider> f6295a;
    public final LazyView<View> f6296b;
    public final RedSpaceInterstitialController f6297c;
    public final GlyphColorizer f6298d;
    public boolean f6299e;
    public final OnClickListener f6300f = new C07861(this);

    /* compiled from: history_suggestion */
    class C07861 implements OnClickListener {
        final /* synthetic */ ComposerRedSpaceSubtitleController f6294a;

        C07861(ComposerRedSpaceSubtitleController composerRedSpaceSubtitleController) {
            this.f6294a = composerRedSpaceSubtitleController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -163626442);
            RedSpaceInterstitialController redSpaceInterstitialController = this.f6294a.f6297c;
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(2131427420);
            Tooltip tooltip = new Tooltip(view.getContext(), 2);
            tooltip.a(2131235758);
            tooltip.b(view.getResources().getString(2131235759));
            tooltip.a(Position.BELOW);
            tooltip.t = -1;
            if (dimensionPixelSize != 0) {
                tooltip.r = -dimensionPixelSize;
            }
            tooltip.a(view);
            Logger.a(2, EntryType.UI_INPUT_END, 2060749770, a);
        }
    }

    @Inject
    public ComposerRedSpaceSubtitleController(RedSpaceInterstitialController redSpaceInterstitialController, GlyphColorizer glyphColorizer, @Assisted ViewStub viewStub, @Assisted DataProvider dataProvider) {
        this.f6297c = redSpaceInterstitialController;
        this.f6298d = glyphColorizer;
        this.f6295a = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6296b = new LazyView((ViewStub) Preconditions.checkNotNull(viewStub));
        m7732a();
    }

    private void m7732a() {
        ProvidesTargetData providesTargetData = (ProvidesTargetData) Preconditions.checkNotNull(this.f6295a.get());
        if (((ProvidesRedSpaceValue) providesTargetData).k() == RedSpaceValue.POST_TO_REDSPACE) {
            boolean z;
            this.f6296b.a().setVisibility(0);
            if (providesTargetData.s().targetType == TargetType.UNDIRECTED) {
                z = true;
            } else {
                z = false;
            }
            if (this.f6299e != z) {
                this.f6299e = z;
                this.f6296b.a().setOnClickListener(z ? this.f6300f : null);
                TextView textView = (TextView) this.f6296b.a().findViewById(2131560612);
                textView.setText(2131234764);
                if (z) {
                    Drawable a = this.f6298d.a(this.f6296b.a().getResources().getDrawable(2130839943), textView.getCurrentTextColor());
                    int lineHeight = textView.getLineHeight();
                    a.setBounds(0, 0, lineHeight, lineHeight);
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(textView.getText());
                    spannableStringBuilder.append(" ");
                    spannableStringBuilder.append(" ");
                    spannableStringBuilder.setSpan(new ImageSpan(a, 0), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    textView.setText(spannableStringBuilder);
                    return;
                }
                return;
            }
            return;
        }
        this.f6296b.c();
    }

    public final void m7733a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE || composerEvent == ComposerEvent.ON_FIRST_DRAW) {
            m7732a();
        }
    }
}
