package com.facebook.search.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import com.facebook.common.util.SizeUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQueryTabModifier;
import com.facebook.search.model.SuggestionTabType;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.touch.TouchDelegateUtils;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: requestCaptcha */
public class GraphSearchTitleSearchBox extends CustomLinearLayout {
    @Inject
    public TitleBarAnimators f7432a;
    @Inject
    public GatekeeperStoreImpl f7433b;
    @Inject
    public QeAccessor f7434c;
    public final Set<OnClearClickedListener> f7435d = new HashSet();
    public SearchEditText f7436e;
    public LazyView<GlyphView> f7437f;
    private BetterTextView f7438g;
    private SearchBoxType f7439h;
    private String f7440i;
    public String f7441j = "";
    public OnInitStateLeftListener f7442k;

    /* compiled from: requestCaptcha */
    public enum SearchBoxType {
        DEFAULT,
        IMMERSIVE,
        SCOPED
    }

    /* compiled from: requestCaptcha */
    class C03161 implements OnInflateRunner<GlyphView> {
        final /* synthetic */ GraphSearchTitleSearchBox f7492a;

        C03161(GraphSearchTitleSearchBox graphSearchTitleSearchBox) {
            this.f7492a = graphSearchTitleSearchBox;
        }

        public final void mo1672a(View view) {
            ((GlyphView) view).setOnClickListener(new 1(this));
        }
    }

    /* compiled from: requestCaptcha */
    class C03172 implements TextWatcher {
        final /* synthetic */ GraphSearchTitleSearchBox f7493a;

        C03172(GraphSearchTitleSearchBox graphSearchTitleSearchBox) {
            this.f7493a = graphSearchTitleSearchBox;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2;
            GraphSearchTitleSearchBox graphSearchTitleSearchBox = this.f7493a;
            if (charSequence != null) {
                charSequence2 = charSequence.toString();
            } else {
                charSequence2 = "";
            }
            graphSearchTitleSearchBox.f7441j = charSequence2;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f7493a.f7442k != null && charSequence != null) {
                this.f7493a.f7442k.a(this.f7493a.f7441j, charSequence.toString());
            }
        }

        public void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() != 0) {
                this.f7493a.f7432a.m11541a(this.f7493a.f7437f.m12095a());
                ((GlyphView) this.f7493a.f7437f.m12095a()).setVisibility(0);
                this.f7493a.requestLayout();
            } else if (!this.f7493a.f7437f.m12097b()) {
            } else {
                if (((GlyphView) this.f7493a.f7437f.m12095a()).getVisibility() == 0) {
                    this.f7493a.f7432a.m11544b(this.f7493a.f7437f.m12095a());
                } else {
                    ((GlyphView) this.f7493a.f7437f.m12095a()).setVisibility(8);
                }
            }
        }
    }

    /* compiled from: requestCaptcha */
    /* synthetic */ class C03184 {
        static final /* synthetic */ int[] f7494a = new int[SearchBoxType.values().length];

        static {
            try {
                f7494a[SearchBoxType.IMMERSIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7494a[SearchBoxType.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static <T extends View> void m12014a(Class<T> cls, T t) {
        m12015a((Object) t, t.getContext());
    }

    private static void m12015a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        GraphSearchTitleSearchBox graphSearchTitleSearchBox = (GraphSearchTitleSearchBox) obj;
        TitleBarAnimators b = TitleBarAnimators.m11539b(injectorLike);
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike);
        QeAccessor a2 = QeInternalImplMethodAutoProvider.m3744a(injectorLike);
        graphSearchTitleSearchBox.f7432a = b;
        graphSearchTitleSearchBox.f7433b = a;
        graphSearchTitleSearchBox.f7434c = a2;
    }

    public GraphSearchTitleSearchBox(Context context) {
        super(context);
        m12021g();
    }

    public GraphSearchTitleSearchBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12021g();
    }

    public GraphSearchTitleSearchBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12021g();
    }

    private void m12021g() {
        setOrientation(0);
        setBackgroundResource(2130840591);
        m12014a(GraphSearchTitleSearchBox.class, (View) this);
        setContentView(2130904631);
        this.f7437f = new LazyView((ViewStub) m8506a(2131562606), new C03161(this));
        this.f7438g = (BetterTextView) m8506a(2131562607);
        this.f7436e = (SearchEditText) m8506a(2131562543);
        if (this.f7434c.mo596a(ExperimentsForSearchAbTestModule.bl, false)) {
            this.f7436e.setHint(2131237507);
        }
        m12022h();
        setSearchBoxType(SearchBoxType.DEFAULT);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((View) this.f7436e.getParent()).setTouchDelegate(TouchDelegateUtils.m13819a(this.f7436e, -1));
        m12023i();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1004037329);
        super.onDetachedFromWindow();
        this.f7432a.m11540a();
        this.f7438g.setOnTouchListener(null);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1561379462, a);
    }

    private void m12022h() {
        this.f7436e.addTextChangedListener(new C03172(this));
    }

    public void setSearchBoxType(SearchBoxType searchBoxType) {
        if (this.f7439h != searchBoxType) {
            this.f7439h = searchBoxType;
            switch (C03184.f7494a[searchBoxType.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f7436e.setHintTextColor(this.f7436e.getHintTextColors().withAlpha(204));
                    getBackground().mutate().setAlpha(153);
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f7436e.setHintTextColor(this.f7436e.getHintTextColors().withAlpha(HTTPTransportCallback.BODY_BYTES_RECEIVED));
                    getBackground().mutate().setAlpha(51);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m12025a(float f) {
        if (this.f7439h == SearchBoxType.IMMERSIVE) {
            this.f7436e.setHintTextColor(this.f7436e.getHintTextColors().withAlpha(204 - ((int) (76.0f * f))));
            getBackground().mutate().setAlpha(153 - ((int) (102.0f * f)));
        }
    }

    public SearchEditText getSearchEditText() {
        return this.f7436e;
    }

    public final void m12024a() {
        if (this.f7437f.m12097b()) {
            ((GlyphView) this.f7437f.m12095a()).setVisibility(8);
        }
    }

    public final boolean mo1242b() {
        return this.f7433b.m2185a(SearchAbTestGatekeepers.f7134f).asBoolean(false);
    }

    public final void m12029a(OnClearClickedListener onClearClickedListener) {
        this.f7435d.add(onClearClickedListener);
    }

    public final void m12030b(OnClearClickedListener onClearClickedListener) {
        this.f7435d.remove(onClearClickedListener);
    }

    public void setOnInitStateLeftListener(OnInitStateLeftListener onInitStateLeftListener) {
        this.f7442k = onInitStateLeftListener;
    }

    private void m12023i() {
        if (this.f7437f.m12097b()) {
            setTouchDelegate(new TouchDelegate(new Rect(getRight() - SizeUtil.m19191a(getContext(), 48.0f), getTop(), getRight(), getBottom()), this.f7437f.m12095a()));
        }
    }

    public final void m12026a(final OnClickListener onClickListener) {
        OnTouchListener c03193 = new OnTouchListener(this) {
            final /* synthetic */ GraphSearchTitleSearchBox f7552b;
            private Rect f7553c;
            private boolean f7554d;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f7553c = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    this.f7552b.f7436e.setAlpha(0.3f);
                    this.f7554d = true;
                } else if (motionEvent.getAction() == 1 && m12142a(view, motionEvent)) {
                    TitleBarAnimators.m11537a(this.f7552b.f7436e, null);
                    onClickListener.onClick(this.f7552b);
                    view.performClick();
                } else if (motionEvent.getAction() == 2 && this.f7554d && !m12142a(view, motionEvent)) {
                    this.f7554d = false;
                    TitleBarAnimators.m11537a(this.f7552b.f7436e, null);
                } else if (motionEvent.getAction() == 2 && !this.f7554d && m12142a(view, motionEvent)) {
                    this.f7554d = true;
                    this.f7552b.f7436e.setAlpha(0.3f);
                }
                return true;
            }

            private boolean m12142a(View view, MotionEvent motionEvent) {
                return this.f7553c != null && this.f7553c.contains(view.getLeft() + ((int) motionEvent.getX()), view.getTop() + ((int) motionEvent.getY()));
            }
        };
        this.f7436e.m12054a(c03193);
        this.f7438g.setOnTouchListener(c03193);
    }

    public final void m12027a(GraphSearchQuery graphSearchQuery) {
        if (GraphSearchConfig.b(graphSearchQuery)) {
            m12032c();
        } else if (GraphSearchConfig.c(graphSearchQuery)) {
            m12033d();
        } else if (m12017b(graphSearchQuery)) {
            setScopedHintString(getContext().getString(2131237409, new Object[]{graphSearchQuery.g}));
        }
        setSearchBoxType(SearchBoxType.SCOPED);
    }

    public final void m12032c() {
        setScopedHintString(getContext().getString(2131237407));
    }

    public final void m12033d() {
        setScopedHintString(getContext().getString(2131237408));
    }

    private void setScopedHintString(String str) {
        this.f7440i = str;
        SearchEditText searchEditText = this.f7436e;
        if (searchEditText != null) {
            searchEditText.setHint(this.f7440i);
            searchEditText.setEllipsize(TruncateAt.END);
        }
    }

    public final void m12034e() {
        this.f7436e.setHint(getContext().getString(2131237414));
    }

    public final void m12035f() {
        this.f7436e.mo1661a();
    }

    public void setSearchText(String str) {
        this.f7436e.setText(str);
    }

    public final void m12028a(SuggestionTabType suggestionTabType, ScopedEntityType scopedEntityType) {
        if (scopedEntityType != ScopedEntityType.USER) {
            if (SuggestionTabType.SCOPED.equals(suggestionTabType)) {
                SearchEditText searchEditText = this.f7436e;
                if (searchEditText != null && this.f7440i != null) {
                    searchEditText.setHint(this.f7440i);
                }
            } else if (SuggestionTabType.GLOBAL.equals(suggestionTabType)) {
                m12034e();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f7438g.getVisibility() == 0) {
            i -= SizeUtil.m19191a(getContext(), 18.0f);
        }
        super.onMeasure(i, i2);
    }

    public void setNullStateBadge(int i) {
        if (i <= 0) {
            this.f7438g.setVisibility(8);
            return;
        }
        this.f7438g.setVisibility(0);
        BetterTextView betterTextView = this.f7438g;
        if (i > 10) {
            i = 10;
        }
        betterTextView.setText(String.valueOf(i));
    }

    private static boolean m12017b(GraphSearchQuery graphSearchQuery) {
        if (graphSearchQuery.h == ScopedEntityType.VIDEO) {
            return true;
        }
        if (graphSearchQuery.h != ScopedEntityType.GROUP) {
            return false;
        }
        Parcelable a = graphSearchQuery.a(ModifierKeys.SCOPED_TAB);
        if (a == null || !(a instanceof GraphSearchQueryTabModifier)) {
            return true;
        }
        return ((GraphSearchQueryTabModifier) a).a;
    }
}
