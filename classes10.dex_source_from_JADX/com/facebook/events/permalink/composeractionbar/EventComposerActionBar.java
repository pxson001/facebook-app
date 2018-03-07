package com.facebook.events.permalink.composeractionbar;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.actionbar.ActionItemPost.C25442;
import com.facebook.events.planning.EventsPlanningPollCreationActivity;
import com.facebook.events.planning.gating.ExperimentsForEventsPlanningModule;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: business_extensions */
public class EventComposerActionBar extends SegmentedLinearLayout {
    @Inject
    GlyphColorizer f18313a;
    @Inject
    QeAccessor f18314b;
    public ActionItemPost f18315c;

    /* compiled from: business_extensions */
    class C25971 implements OnClickListener {
        final /* synthetic */ EventComposerActionBar f18312a;

        C25971(EventComposerActionBar eventComposerActionBar) {
            this.f18312a = eventComposerActionBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 376040570);
            if (this.f18312a.f18315c == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 2048389358, a);
                return;
            }
            int id = view.getId();
            if (id == 2131558634) {
                this.f18312a.f18315c.m18373a();
            } else if (id == 2131558635) {
                r1 = this.f18312a.f18315c;
                if (!(r1.f17987k == null || r1.f17977a == null)) {
                    r1.f17982f.m19060a(r1.f17987k, new C25442(r1));
                }
            } else if (id == 2131558636) {
                r1 = this.f18312a.f18315c;
                if (!(r1.f17987k == null || r1.f17977a == null)) {
                    r1.f17986j.a(EventsPlanningPollCreationActivity.m19229a(r1.f17977a.getContext()), 9, r1.f17977a);
                }
            } else {
                RuntimeException runtimeException = new RuntimeException("Unknown composer id " + id);
                LogUtils.a(-1107943183, a);
                throw runtimeException;
            }
            LogUtils.a(-1448398772, a);
        }
    }

    private static <T extends View> void m18657a(Class<T> cls, T t) {
        m18658a((Object) t, t.getContext());
    }

    private static void m18658a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventComposerActionBar) obj).m18656a(GlyphColorizer.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public EventComposerActionBar(Context context) {
        super(context);
        m18655a();
    }

    public EventComposerActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18655a();
    }

    private void m18655a() {
        m18657a(EventComposerActionBar.class, (View) this);
        setContentView(2130904062);
        OnClickListener c25971 = new C25971(this);
        m18654a(2131558634, 2131237034, 2130839809, c25971);
        m18654a(2131558635, 2131237035, 2130839749, c25971);
        if (this.f18314b.a(ExperimentsForEventsPlanningModule.f19003a, false)) {
            m18654a(2131558636, 2131237036, 2130839851, c25971);
        }
    }

    private void m18656a(GlyphColorizer glyphColorizer, QeAccessor qeAccessor) {
        this.f18313a = glyphColorizer;
        this.f18314b = qeAccessor;
    }

    public final void m18659a(ActionItemPost actionItemPost) {
        this.f18315c = actionItemPost;
    }

    private ImageWithTextView m18654a(@IdRes int i, @StringRes int i2, @DrawableRes int i3, OnClickListener onClickListener) {
        ImageWithTextView imageWithTextView = (ImageWithTextView) a(i);
        imageWithTextView.setText(i2);
        imageWithTextView.setImageDrawable(this.f18313a.a(i3, -7235677));
        imageWithTextView.setVisibility(0);
        imageWithTextView.setOnClickListener(onClickListener);
        return imageWithTextView;
    }
}
