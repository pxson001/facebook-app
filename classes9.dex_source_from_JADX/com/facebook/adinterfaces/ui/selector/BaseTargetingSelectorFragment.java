package com.facebook.adinterfaces.ui.selector;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.filter.CustomFilter.FilterListener;
import com.facebook.widget.filter.CustomFilter.FilteringState;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
public abstract class BaseTargetingSelectorFragment<T> extends FbFragment {
    public TypeaheadAdapter f23207a;
    public InputMethodManager f23208b;
    public TasksManager f23209c;
    public DefaultUserInteractionController f23210d;
    public BetterListView f23211e;
    public TokenizedAutoCompleteTextView f23212f;
    public TextView f23213g;
    public View f23214h;
    public final FilterListener f23215i = new C27321(this);

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    class C27321 implements FilterListener {
        final /* synthetic */ BaseTargetingSelectorFragment f23197a;

        C27321(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23197a = baseTargetingSelectorFragment;
        }

        public final void m25164a(int i) {
            boolean z = false;
            if (this.f23197a.f23207a != null) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.f23197a.f23207a.c(); i3++) {
                    i2 += this.f23197a.f23207a.c(i3);
                }
                BaseTargetingSelectorFragment baseTargetingSelectorFragment = this.f23197a;
                if (i2 == 0) {
                    z = true;
                }
                BaseTargetingSelectorFragment.m25170a(baseTargetingSelectorFragment, z);
            }
        }

        public final void m25165a(FilteringState filteringState) {
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    class C27332 implements BaseTokenMatcher {
        final /* synthetic */ BaseTargetingSelectorFragment f23198a;
        private String f23199b;

        C27332(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23198a = baseTargetingSelectorFragment;
        }

        public final void m25166a(String str) {
            this.f23199b = str;
        }

        public final boolean m25167a(BaseToken baseToken) {
            return (baseToken == null || this.f23199b == null || !StringLocaleUtil.a(baseToken.b()).startsWith(StringLocaleUtil.a(this.f23199b))) ? false : true;
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    public class C27343 implements OnScrollListener {
        final /* synthetic */ BaseTargetingSelectorFragment f23200a;

        public C27343(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23200a = baseTargetingSelectorFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f23200a.f23210d.b(absListView);
                    return;
                case 1:
                case 2:
                    this.f23200a.f23210d.a(absListView);
                    BaseTargetingSelectorFragment.ax(this.f23200a);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    public class C27354 implements OnItemClickListener {
        final /* synthetic */ BaseTargetingSelectorFragment f23201a;

        public C27354(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23201a = baseTargetingSelectorFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BaseToken baseToken = (BaseToken) this.f23201a.f23207a.getItem(i);
            if (this.f23201a.at().contains(baseToken)) {
                this.f23201a.m25181b(baseToken);
            } else {
                this.f23201a.mo1044a(baseToken);
            }
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    public class C27365 implements TextWatcher {
        final /* synthetic */ BaseTargetingSelectorFragment f23202a;
        private String f23203b = null;
        private int f23204c = 0;

        public C27365(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23202a = baseTargetingSelectorFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 < i2) {
                this.f23202a.f23212f.d();
            }
        }

        public void afterTextChanged(Editable editable) {
            if (!editable.toString().equals(this.f23203b)) {
                this.f23203b = editable.toString();
                BaseTargetingSelectorFragment baseTargetingSelectorFragment = this.f23202a;
                String charSequence = this.f23202a.f23212f.getUserEnteredPlainText().toString();
                if (Strings.isNullOrEmpty(charSequence)) {
                    baseTargetingSelectorFragment.f23209c.c();
                    baseTargetingSelectorFragment.f23214h.setVisibility(4);
                    BaseTargetingSelectorFragment.m25170a(baseTargetingSelectorFragment, true);
                } else {
                    baseTargetingSelectorFragment.f23214h.setVisibility(0);
                    baseTargetingSelectorFragment.f23209c.a(Key.FETCH_TYPEAHEAD_RESULTS, baseTargetingSelectorFragment.mo1039a(charSequence), new C27387(baseTargetingSelectorFragment));
                    baseTargetingSelectorFragment.f23207a.a().a(charSequence, baseTargetingSelectorFragment.f23215i);
                }
                if (this.f23202a.f23212f.getPickedTokenSpans().length != this.f23204c) {
                    this.f23204c = this.f23202a.f23212f.getPickedTokenSpans().length;
                    BaseTargetingSelectorFragment.av(this.f23202a);
                }
            }
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    public class C27376 implements OnFocusChangeListener {
        final /* synthetic */ BaseTargetingSelectorFragment f23205a;

        public C27376(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23205a = baseTargetingSelectorFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                BaseTargetingSelectorFragment.ax(this.f23205a);
            }
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    public class C27387 extends AbstractDisposableFutureCallback<List<T>> {
        final /* synthetic */ BaseTargetingSelectorFragment f23206a;

        public C27387(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
            this.f23206a = baseTargetingSelectorFragment;
        }

        protected final void m25168a(Object obj) {
            List list = (List) obj;
            BaseTargetingSelectorFragment.m25172c(this.f23206a, list);
            BaseTargetingSelectorFragment.m25170a(this.f23206a, list.isEmpty());
            this.f23206a.f23214h.setVisibility(4);
        }

        protected final void m25169a(Throwable th) {
            this.f23206a.f23213g.setText(2131230758);
            this.f23206a.f23214h.setVisibility(4);
        }
    }

    /* compiled from: Unknown item type for TimelineInfoReviewAdapter of type  */
    public enum Key {
        FETCH_TYPEAHEAD_RESULTS
    }

    public static void m25171a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BaseTargetingSelectorFragment baseTargetingSelectorFragment = (BaseTargetingSelectorFragment) obj;
        TypeaheadAdapter b = TypeaheadAdapter.b(fbInjector);
        InputMethodManager b2 = InputMethodManagerMethodAutoProvider.b(fbInjector);
        TasksManager b3 = TasksManager.b(fbInjector);
        DefaultUserInteractionController a = DefaultUserInteractionController.a(fbInjector);
        baseTargetingSelectorFragment.f23207a = b;
        baseTargetingSelectorFragment.f23208b = b2;
        baseTargetingSelectorFragment.f23209c = b3;
        baseTargetingSelectorFragment.f23210d = a;
    }

    public abstract BaseToken<T> mo1038a(T t);

    @Nullable
    public abstract ListenableFuture<List<T>> mo1039a(String str);

    protected abstract List<? extends SectionedListSection<? extends BaseToken<T>>> mo1040a(List<T> list);

    protected abstract String mo1041b();

    protected abstract String mo1043e();

    public void mo1046d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1308257545);
        super.d(bundle);
        this.f23212f = (TokenizedAutoCompleteTextView) e(2131567831);
        this.f23212f.setHint(mo1043e());
        this.f23211e = (BetterListView) e(2131567833);
        this.f23214h = e(2131567832);
        this.f23213g = (TextView) e(2131567834);
        List list = null;
        if (bundle == null && this.s != null) {
            ImmutableList immutableList;
            List<Object> b = FlatBufferModelHelper.b(this.s, "initialData");
            if (b == null || b.isEmpty()) {
                immutableList = null;
            } else {
                Builder builder = ImmutableList.builder();
                for (Object a2 : b) {
                    builder.c(mo1038a(a2));
                }
                immutableList = builder.b();
            }
            list = immutableList;
        }
        this.f23207a.a(new C27332(this));
        m25172c(this, RegularImmutableList.a);
        this.f23211e.setAdapter(this.f23207a);
        this.f23211e.setOnScrollListener(new C27343(this));
        this.f23211e.setOnItemClickListener(new C27354(this));
        if (r0 == null || r0.isEmpty()) {
            m25170a(this, true);
        } else {
            for (BaseToken a3 : r0) {
                this.f23212f.a(a3);
            }
            this.f23212f.d();
            av(this);
        }
        this.f23212f.addTextChangedListener(new C27365(this));
        this.f23212f.setOnFocusChangeListener(new C27376(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1601076948, a);
    }

    public void mo1042c(Bundle bundle) {
        super.c(bundle);
        Class cls = BaseTargetingSelectorFragment.class;
        m25171a((Object) this, getContext());
    }

    public final View m25175a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -174201024);
        View inflate = layoutInflater.inflate(2130907374, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1485071261, a);
        return inflate;
    }

    public final void m25174I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1134483247);
        this.f23209c.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2032836531, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -967543084);
        this.f23211e = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1651690768, a);
    }

    public final void m25173H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 908338049);
        ax(this);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -413650517, a);
    }

    public void mo1047e(Bundle bundle) {
        ArrayList at = at();
        if (!at.isEmpty()) {
            List a = Lists.a();
            int size = at.size();
            for (int i = 0; i < size; i++) {
                a.add(((BaseToken) at.get(i)).d());
            }
            FlatBufferModelHelper.a(bundle, "initialData", a);
        }
        super.e(bundle);
    }

    public ArrayList<?> as() {
        List<BaseToken> at = at();
        ArrayList<?> a = Lists.a();
        for (BaseToken d : at) {
            a.add(d.d());
        }
        return a;
    }

    public static void m25172c(BaseTargetingSelectorFragment baseTargetingSelectorFragment, List list) {
        baseTargetingSelectorFragment.f23207a.a(baseTargetingSelectorFragment.mo1040a(list));
    }

    protected final ArrayList<BaseToken<T>> at() {
        BaseTokenSpan[] baseTokenSpanArr = (BaseTokenSpan[]) this.f23212f.getPickedTokenSpans();
        ArrayList<BaseToken<T>> a = Lists.a();
        for (TokenSpan tokenSpan : baseTokenSpanArr) {
            a.add((BaseToken) tokenSpan.f);
        }
        return a;
    }

    protected void mo1044a(BaseToken<T> baseToken) {
        this.f23212f.a(baseToken);
        this.f23212f.clearComposingText();
        this.f23212f.d();
        av(this);
    }

    protected final void m25181b(BaseToken<T> baseToken) {
        this.f23212f.a(baseToken, false);
        this.f23212f.d();
        av(this);
    }

    public static void av(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
        List at = baseTargetingSelectorFragment.at();
        baseTargetingSelectorFragment.f23207a.i = at;
        AdapterDetour.a(baseTargetingSelectorFragment.f23207a, 912271858);
        if (at.isEmpty()) {
            m25170a(baseTargetingSelectorFragment, true);
        }
    }

    public static void m25170a(BaseTargetingSelectorFragment baseTargetingSelectorFragment, boolean z) {
        CharSequence charSequence = "";
        if (baseTargetingSelectorFragment.f23209c.a()) {
            charSequence = baseTargetingSelectorFragment.b(2131234089);
        } else if (baseTargetingSelectorFragment.f23212f.getUserEnteredPlainText().toString().isEmpty() && baseTargetingSelectorFragment.at().isEmpty()) {
            charSequence = baseTargetingSelectorFragment.mo1041b();
        } else if (!baseTargetingSelectorFragment.f23212f.getUserEnteredPlainText().toString().isEmpty()) {
            charSequence = baseTargetingSelectorFragment.b(2131234077);
        }
        if (z) {
            baseTargetingSelectorFragment.f23213g.setText(charSequence);
            baseTargetingSelectorFragment.f23213g.setVisibility(0);
            baseTargetingSelectorFragment.f23211e.setVisibility(8);
            return;
        }
        baseTargetingSelectorFragment.f23213g.setVisibility(8);
        baseTargetingSelectorFragment.f23211e.setVisibility(0);
    }

    public static void ax(BaseTargetingSelectorFragment baseTargetingSelectorFragment) {
        baseTargetingSelectorFragment.f23208b.hideSoftInputFromWindow(baseTargetingSelectorFragment.f23212f.getWindowToken(), 0);
    }
}
