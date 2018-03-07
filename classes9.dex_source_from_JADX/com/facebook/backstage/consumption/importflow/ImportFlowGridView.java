package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.SimpleAnimationHelper;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationType;
import com.facebook.backstage.consumption.StatusBarColorChanger;
import com.facebook.backstage.consumption.importflow.ImportFlowStackView.ImportFlowStackEventListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: risk_result */
public class ImportFlowGridView extends FrameLayout {
    @Inject
    public BackstageAnalyticsLogger f4742a;
    private final OnItemClickListener f4743b;
    public final OnClickListener f4744c;
    public final OnClickListener f4745d;
    public final ImportFlowStackEventListener f4746e;
    private final SimpleAnimationHelper f4747f;
    public final ImportFlowAdapter f4748g;
    private final GridView f4749h;
    public final ImportFlowTitleView f4750i;
    private final FbTextView f4751j;
    public final ImportFlowStackView f4752k;
    private BackstageNavigatorApi f4753l;
    private StatusBarColorChanger f4754m;

    /* compiled from: risk_result */
    class C04831 implements OnItemClickListener {
        final /* synthetic */ ImportFlowGridView f4737a;

        C04831(ImportFlowGridView importFlowGridView) {
            this.f4737a = importFlowGridView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4737a.f4748g.m4614a(view, i);
            this.f4737a.m4627a(this.f4737a.f4748g.m4613a().size());
        }
    }

    /* compiled from: risk_result */
    class C04842 implements OnClickListener {
        final /* synthetic */ ImportFlowGridView f4738a;

        C04842(ImportFlowGridView importFlowGridView) {
            this.f4738a = importFlowGridView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -479799314);
            this.f4738a.f4752k.m4676a(this.f4738a.f4748g.m4613a(), this.f4738a.f4750i, this.f4738a.f4746e);
            this.f4738a.f4742a.m4264a(Event.IMPORT_GRID_TO_PUBLISHER);
            Logger.a(2, EntryType.UI_INPUT_END, -975268768, a);
        }
    }

    /* compiled from: risk_result */
    class C04853 implements OnClickListener {
        final /* synthetic */ ImportFlowGridView f4739a;

        C04853(ImportFlowGridView importFlowGridView) {
            this.f4739a = importFlowGridView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -758494356);
            this.f4739a.f4742a.m4264a(Event.IMPORT_CANCEL);
            this.f4739a.f4750i;
            Logger.a(2, EntryType.UI_INPUT_END, -722145746, a);
        }
    }

    /* compiled from: risk_result */
    class C04864 implements ImportFlowStackEventListener {
        final /* synthetic */ ImportFlowGridView f4740a;

        C04864(ImportFlowGridView importFlowGridView) {
            this.f4740a = importFlowGridView;
        }

        public final void mo161a() {
            this.f4740a.f4750i.setOnShareClickedListener(this.f4740a.f4744c);
            this.f4740a.f4750i.setOnCloseClickedListener(this.f4740a.f4745d);
            this.f4740a.f4750i.m4703e();
            this.f4740a.f4750i;
            this.f4740a.f4742a.m4264a(Event.IMPORT_SHARE);
        }

        public final void mo162b() {
            this.f4740a.f4750i.setOnShareClickedListener(this.f4740a.f4744c);
            this.f4740a.f4750i.setOnCloseClickedListener(this.f4740a.f4745d);
            this.f4740a.f4750i.m4703e();
            this.f4740a.f4750i.m4699a(this.f4740a.f4748g.m4613a().size());
            this.f4740a.f4742a.m4264a(Event.IMPORT_PUBLISHER_TO_GRID);
        }
    }

    /* compiled from: risk_result */
    class C04875 implements OnClickListener {
        final /* synthetic */ ImportFlowGridView f4741a;

        C04875(ImportFlowGridView importFlowGridView) {
            this.f4741a = importFlowGridView;
        }

        public void onClick(View view) {
            int i;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1142995889);
            BaseAdapter baseAdapter = this.f4741a.f4748g;
            int i2 = 0;
            boolean z = true;
            int size = baseAdapter.f4722b.size();
            for (i = 0; i < size; i++) {
                if (((ImportMedia) baseAdapter.f4722b.get(i)).f4822b) {
                    z = false;
                    break;
                }
            }
            i = baseAdapter.f4722b.size();
            while (i2 < i) {
                ((ImportMedia) baseAdapter.f4722b.get(i2)).f4822b = z;
                i2++;
            }
            AdapterDetour.a(baseAdapter, -307741581);
            this.f4741a.m4627a(this.f4741a.f4748g.m4613a().size());
            Logger.a(2, EntryType.UI_INPUT_END, -1898916464, a);
        }
    }

    private static <T extends View> void m4630a(Class<T> cls, T t) {
        m4631a((Object) t, t.getContext());
    }

    private static void m4631a(Object obj, Context context) {
        ((ImportFlowGridView) obj).f4742a = BackstageAnalyticsLogger.m4259a(FbInjector.get(context));
    }

    private void m4628a(BackstageAnalyticsLogger backstageAnalyticsLogger) {
        this.f4742a = backstageAnalyticsLogger;
    }

    public ImportFlowGridView(Context context) {
        this(context, null);
    }

    public ImportFlowGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImportFlowGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4743b = new C04831(this);
        this.f4744c = new C04842(this);
        this.f4745d = new C04853(this);
        this.f4746e = new C04864(this);
        this.f4747f = new SimpleAnimationHelper(this, null);
        m4630a(ImportFlowGridView.class, (View) this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130904852, this);
        this.f4750i = (ImportFlowTitleView) inflate.findViewById(2131563080);
        this.f4748g = new ImportFlowAdapter(getContext());
        this.f4749h = (GridView) inflate.findViewById(2131563077);
        this.f4749h.setAdapter(this.f4748g);
        this.f4749h.setOnItemClickListener(this.f4743b);
        this.f4752k = (ImportFlowStackView) inflate.findViewById(2131563079);
        this.f4751j = (FbTextView) inflate.findViewById(2131563078);
        this.f4751j.setText(2131239914);
        this.f4751j.setOnClickListener(new C04875(this));
        this.f4750i.setOnShareClickedListener(this.f4744c);
        this.f4750i.setOnCloseClickedListener(this.f4745d);
    }

    public final void m4641a(@Nullable ImmutableList<ImportMedia> immutableList, BackstageNavigatorApi backstageNavigatorApi, StatusBarColorChanger statusBarColorChanger) {
        this.f4753l = backstageNavigatorApi;
        this.f4754m = statusBarColorChanger;
        this.f4747f.m4560a(AnimationType.SLIDE_FROM_RIGHT);
        BaseAdapter baseAdapter = this.f4748g;
        baseAdapter.f4722b = immutableList;
        AdapterDetour.a(baseAdapter, 24741541);
        m4627a(immutableList.size());
        this.f4742a.m4264a(Event.IMPORT_ENTER);
        m4635c();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 112630885);
        super.onAttachedToWindow();
        m4635c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1156722438, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -684031024);
        super.onDetachedFromWindow();
        m4637d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1827707970, a);
    }

    public static void m4633b(ImportFlowGridView importFlowGridView) {
        importFlowGridView.m4637d();
        importFlowGridView.f4747f.m4562b(AnimationType.SLIDE_FROM_RIGHT);
        BaseAdapter baseAdapter = importFlowGridView.f4748g;
        baseAdapter.f4722b = RegularImmutableList.a;
        AdapterDetour.a(baseAdapter, -1773346780);
        importFlowGridView.f4753l.m4492a(NavigationState.IMPORT, NavigationState.MAIN_LIST);
    }

    public final boolean m4642a() {
        if (this.f4752k.m4677a()) {
            this.f4750i.setOnShareClickedListener(this.f4744c);
            this.f4750i.setOnCloseClickedListener(this.f4745d);
            return true;
        } else if (getVisibility() != 0) {
            return false;
        } else {
            this.f4742a.m4264a(Event.IMPORT_CANCEL);
            this.f4750i;
            return true;
        }
    }

    private void m4635c() {
        if (this.f4754m != null) {
            this.f4754m.m4564a(2131361850);
        }
    }

    private void m4637d() {
        if (this.f4754m != null) {
            this.f4754m.m4563a();
        }
    }

    private void m4627a(int i) {
        this.f4750i.m4699a(i);
        this.f4751j.setText(i == 0 ? 2131239913 : 2131239914);
        this.f4742a.m4264a(i == 0 ? Event.IMPORT_GALLERY_SELECT_ALL : Event.IMPORT_GALLERY_DESELECT_ALL);
    }
}
