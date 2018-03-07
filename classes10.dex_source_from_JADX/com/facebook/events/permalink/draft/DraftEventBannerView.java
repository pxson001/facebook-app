package com.facebook.events.permalink.draft;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.actionbar.ActionItemEdit;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: bug_screenshot_extra */
public class DraftEventBannerView extends CustomLinearLayout {
    @Inject
    public ActionItemEdit f18323a;
    private MetricAffectingSpan f18324b;
    private MetricAffectingSpan f18325c;
    private Resources f18326d;

    /* compiled from: bug_screenshot_extra */
    class C25981 implements OnClickListener {
        final /* synthetic */ DraftEventBannerView f18321a;

        C25981(DraftEventBannerView draftEventBannerView) {
            this.f18321a = draftEventBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1578370677);
            DraftEventBannerView.m18666b(this.f18321a);
            Logger.a(2, EntryType.UI_INPUT_END, -2075699969, a);
        }
    }

    /* compiled from: bug_screenshot_extra */
    class C25992 implements OnMenuItemClickListener {
        final /* synthetic */ DraftEventBannerView f18322a;

        C25992(DraftEventBannerView draftEventBannerView) {
            this.f18322a = draftEventBannerView;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f18322a.f18323a.m18348a(ActionMechanism.PERMALINK_DRAFT_BANNER);
            return true;
        }
    }

    private static <T extends View> void m18664a(Class<T> cls, T t) {
        m18665a((Object) t, t.getContext());
    }

    private static void m18665a(Object obj, Context context) {
        ((DraftEventBannerView) obj).f18323a = ActionItemEdit.m18347b(FbInjector.get(context));
    }

    public DraftEventBannerView(Context context) {
        super(context);
        m18661a();
    }

    public DraftEventBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18661a();
    }

    public DraftEventBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18661a();
    }

    private void m18661a() {
        m18664a(DraftEventBannerView.class, (View) this);
        setContentView(2130904069);
        this.f18326d = getResources();
        setOrientation(0);
        this.f18324b = new TextAppearanceSpan(getContext(), 2131625301);
        this.f18325c = new TextAppearanceSpan(getContext(), 2131625302);
        ((BetterTextView) a(2131561357)).setText(getBannerText());
        ((ImageView) a(2131561358)).setOnClickListener(new C25981(this));
    }

    private void m18662a(ActionItemEdit actionItemEdit) {
        this.f18323a = actionItemEdit;
    }

    public final void m18667a(Event event, EventAnalyticsParams eventAnalyticsParams) {
        this.f18323a.m18350a(event, eventAnalyticsParams);
    }

    public static void m18666b(DraftEventBannerView draftEventBannerView) {
        Context context = draftEventBannerView.getContext();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(context);
        bottomSheetAdapter.a(draftEventBannerView.getResources().getString(2131237045)).setIcon(2130840013).setOnMenuItemClickListener(new C25992(draftEventBannerView));
        bottomSheetDialog.a(bottomSheetAdapter);
        bottomSheetDialog.show();
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private SpannableStringBuilder getBannerText() {
        String string = this.f18326d.getString(2131237251);
        Object obj = string + "\n" + this.f18326d.getString(2131237252);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        spannableStringBuilder.setSpan(this.f18324b, 0, string.length(), 17);
        spannableStringBuilder.setSpan(this.f18325c, string.length() + 1, obj.length(), 17);
        return spannableStringBuilder;
    }
}
