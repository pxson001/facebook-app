package com.facebook.feedplugins.pymk.quickpromotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;

/* compiled from: TMType; */
public class QuickPromotionFeedPYMKFragment extends QuickPromotionFragment {
    public Runnable f24732a;
    private Creative f24733b;

    /* compiled from: TMType; */
    class C29831 implements OnClickListener {
        final /* synthetic */ QuickPromotionFeedPYMKFragment f24731a;

        C29831(QuickPromotionFeedPYMKFragment quickPromotionFeedPYMKFragment) {
            this.f24731a = quickPromotionFeedPYMKFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1844930199);
            this.f24731a.as();
            Logger.a(2, EntryType.UI_INPUT_END, 1615848703, a);
        }
    }

    public final void m26600c(Bundle bundle) {
        super.c(bundle);
        this.f24733b = this.b;
    }

    public final View m26597a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 268849994);
        View inflate = layoutInflater.inflate(2130906166, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 566847648, a);
        return inflate;
    }

    public final void m26598a(View view, Bundle bundle) {
        super.a(view, bundle);
        TextView textView = (TextView) e(2131565829);
        Button button = (Button) e(2131558610);
        ((TextView) e(2131565828)).setText(this.f24733b.title);
        textView.setText(this.f24733b.content);
        button.setText(this.f24733b.primaryAction.title);
        button.setOnClickListener(new C29831(this));
    }

    protected final void m26599a(boolean z) {
        super.a(z);
        if (z && this.f24732a != null) {
            this.f24732a.run();
        }
    }
}
