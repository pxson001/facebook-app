package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.internal.widget.TintAutoCompleteTextView;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: treehouse_notif */
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    private static final boolean DBG = false;
    static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final boolean IS_AT_LEAST_FROYO;
    private static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    public final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    public final ImageView mGoButton;
    public boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final OnClickListener mOnClickListener;
    public OnCloseListener mOnCloseListener;
    private final OnEditorActionListener mOnEditorActionListener;
    private final OnItemClickListener mOnItemClickListener;
    private final OnItemSelectedListener mOnItemSelectedListener;
    public OnQueryTextListener mOnQueryChangeListener;
    public OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    public final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    public final SearchAutoComplete mSearchSrcTextView;
    public SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    public final int mSuggestionCommitIconResId;
    public final int mSuggestionRowLayout;
    public CursorAdapter mSuggestionsAdapter;
    OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private final TintManager mTintManager;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    public final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    /* compiled from: treehouse_notif */
    class C00711 implements Runnable {
        final /* synthetic */ SearchView f1444a;

        C00711(SearchView searchView) {
            this.f1444a = searchView;
        }

        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1444a.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                SearchView.HIDDEN_METHOD_INVOKER.m1964a(inputMethodManager, this.f1444a, 0);
            }
        }
    }

    /* compiled from: treehouse_notif */
    class C00722 implements Runnable {
        final /* synthetic */ SearchView f1445a;

        C00722(SearchView searchView) {
            this.f1445a = searchView;
        }

        public void run() {
            SearchView.updateFocusedState(this.f1445a);
        }
    }

    /* compiled from: treehouse_notif */
    class C00733 implements Runnable {
        final /* synthetic */ SearchView f1446a;

        C00733(SearchView searchView) {
            this.f1446a = searchView;
        }

        public void run() {
            if (this.f1446a.mSuggestionsAdapter != null && (this.f1446a.mSuggestionsAdapter instanceof SuggestionsAdapter)) {
                this.f1446a.mSuggestionsAdapter.mo170a(null);
            }
        }
    }

    /* compiled from: treehouse_notif */
    class C00744 implements OnFocusChangeListener {
        final /* synthetic */ SearchView f1447a;

        C00744(SearchView searchView) {
            this.f1447a = searchView;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f1447a.mOnQueryTextFocusChangeListener != null) {
                this.f1447a.mOnQueryTextFocusChangeListener.onFocusChange(this.f1447a, z);
            }
        }
    }

    /* compiled from: treehouse_notif */
    class C00755 implements OnLayoutChangeListener {
        final /* synthetic */ SearchView f1448a;

        C00755(SearchView searchView) {
            this.f1448a = searchView;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.adjustDropDownSizeAndPosition(this.f1448a);
        }
    }

    /* compiled from: treehouse_notif */
    class C00766 implements OnGlobalLayoutListener {
        final /* synthetic */ SearchView f1449a;

        C00766(SearchView searchView) {
            this.f1449a = searchView;
        }

        public void onGlobalLayout() {
            SearchView.adjustDropDownSizeAndPosition(this.f1449a);
        }
    }

    /* compiled from: treehouse_notif */
    class C00777 implements OnClickListener {
        final /* synthetic */ SearchView f1450a;

        C00777(SearchView searchView) {
            this.f1450a = searchView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 570534003);
            if (view == this.f1450a.mSearchButton) {
                SearchView.onSearchClicked(this.f1450a);
            } else if (view == this.f1450a.mCloseButton) {
                SearchView.onCloseClicked(this.f1450a);
            } else if (view == this.f1450a.mGoButton) {
                SearchView.onSubmitQuery(this.f1450a);
            } else if (view == this.f1450a.mVoiceButton) {
                SearchView.onVoiceClicked(this.f1450a);
            } else if (view == this.f1450a.mSearchSrcTextView) {
                SearchView.forceSuggestionQuery(this.f1450a);
            }
            LogUtils.a(2050682940, a);
        }
    }

    /* compiled from: treehouse_notif */
    class C00788 implements OnKeyListener {
        final /* synthetic */ SearchView f1451a;

        C00788(SearchView searchView) {
            this.f1451a = searchView;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (this.f1451a.mSearchable == null) {
                return false;
            }
            if (this.f1451a.mSearchSrcTextView.isPopupShowing() && this.f1451a.mSearchSrcTextView.getListSelection() != -1) {
                return SearchView.onSuggestionsKey(this.f1451a, view, i, keyEvent);
            }
            if (this.f1451a.mSearchSrcTextView.m1973a() || !KeyEventCompat.m341a(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView.launchQuerySearch(this.f1451a, 0, null, this.f1451a.mSearchSrcTextView.getText().toString());
            return true;
        }
    }

    /* compiled from: treehouse_notif */
    class C00799 implements OnEditorActionListener {
        final /* synthetic */ SearchView f1452a;

        C00799(SearchView searchView) {
            this.f1452a = searchView;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.onSubmitQuery(this.f1452a);
            return true;
        }
    }

    /* compiled from: treehouse_notif */
    class AutoCompleteTextViewReflector {
        private Method f1453a;
        private Method f1454b;
        private Method f1455c;
        private Method f1456d;

        AutoCompleteTextViewReflector() {
            try {
                this.f1453a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1453a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1454b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1454b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1455c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1455c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1456d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1456d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        final void m1965a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1453a != null) {
                try {
                    this.f1453a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        final void m1967b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1454b != null) {
                try {
                    this.f1454b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        final void m1966a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1455c != null) {
                try {
                    this.f1455c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        final void m1964a(InputMethodManager inputMethodManager, View view, int i) {
            if (this.f1456d != null) {
                try {
                    this.f1456d.invoke(inputMethodManager, new Object[]{Integer.valueOf(i), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(view, i);
        }
    }

    /* compiled from: treehouse_notif */
    public interface OnCloseListener {
        boolean m1968a();
    }

    /* compiled from: treehouse_notif */
    public interface OnQueryTextListener {
        boolean m1969a(String str);

        boolean m1970b(String str);
    }

    /* compiled from: treehouse_notif */
    public interface OnSuggestionListener {
        boolean m1971a();

        boolean m1972b();
    }

    /* compiled from: treehouse_notif */
    public class SearchAutoComplete extends TintAutoCompleteTextView {
        private int f1457a;
        public SearchView f1458b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 16842859);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1457a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.f1458b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1457a = i;
        }

        private boolean m1973a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1130706488);
            super.onWindowFocusChanged(z);
            if (z && this.f1458b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.isLandscapeMode(getContext())) {
                    SearchView.HIDDEN_METHOD_INVOKER.m1966a(this, true);
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -16457538, a);
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -397782071);
            super.onFocusChanged(z, i, rect);
            this.f1458b.onTextFocusChanged();
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1996456029, a);
        }

        public boolean enoughToFilter() {
            return this.f1457a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1458b.clearFocus();
                        SearchView.setImeVisibility(this.f1458b, false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        IS_AT_LEAST_FROYO = z;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772034);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowImeRunnable = new C00711(this);
        this.mUpdateDrawableStateRunnable = new C00722(this);
        this.mReleaseCursorRunnable = new C00733(this);
        this.mOutsideDrawablesCache = new WeakHashMap();
        this.mOnClickListener = new C00777(this);
        this.mTextKeyListener = new C00788(this);
        this.mOnEditorActionListener = new C00799(this);
        this.mOnItemClickListener = new OnItemClickListener(this) {
            final /* synthetic */ SearchView f1441a;

            {
                this.f1441a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.onItemClicked(this.f1441a, i, 0, null);
            }
        };
        this.mOnItemSelectedListener = new OnItemSelectedListener(this) {
            final /* synthetic */ SearchView f1442a;

            {
                this.f1442a = r1;
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.onItemSelected(this.f1442a, i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mTextWatcher = new TextWatcher(this) {
            final /* synthetic */ SearchView f1443a;

            {
                this.f1443a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.onTextChanged(this.f1443a, charSequence);
            }

            public void afterTextChanged(Editable editable) {
            }
        };
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, R.styleable.SearchView, i, 0);
        this.mTintManager = a.m1700c();
        LayoutInflater.from(context).inflate(a.m1704f(4, 2130903061), this, true);
        this.mSearchSrcTextView = (SearchAutoComplete) findViewById(2131559139);
        this.mSearchSrcTextView.f1458b = this;
        this.mSearchEditFrame = findViewById(2131559136);
        this.mSearchPlate = findViewById(2131559138);
        this.mSubmitArea = findViewById(2131559141);
        this.mSearchButton = (ImageView) findViewById(2131559135);
        this.mGoButton = (ImageView) findViewById(2131559142);
        this.mCloseButton = (ImageView) findViewById(2131559140);
        this.mVoiceButton = (ImageView) findViewById(2131559143);
        this.mCollapsedIcon = (ImageView) findViewById(2131559137);
        this.mSearchPlate.setBackgroundDrawable(a.m1695a(14));
        this.mSubmitArea.setBackgroundDrawable(a.m1695a(15));
        this.mSearchButton.setImageDrawable(a.m1695a(9));
        this.mGoButton.setImageDrawable(a.m1695a(8));
        this.mCloseButton.setImageDrawable(a.m1695a(7));
        this.mVoiceButton.setImageDrawable(a.m1695a(11));
        this.mCollapsedIcon.setImageDrawable(a.m1695a(9));
        this.mSearchHintIcon = a.m1695a(10);
        this.mSuggestionRowLayout = a.m1704f(13, 2130903060);
        this.mSuggestionCommitIconResId = a.m1704f(12, 0);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mGoButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.setOnClickListener(this.mOnClickListener);
        this.mSearchSrcTextView.addTextChangedListener(this.mTextWatcher);
        this.mSearchSrcTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mSearchSrcTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mSearchSrcTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mSearchSrcTextView.setOnKeyListener(this.mTextKeyListener);
        this.mSearchSrcTextView.setOnFocusChangeListener(new C00744(this));
        setIconifiedByDefault(a.m1696a(5, true));
        int d = a.m1701d(1, -1);
        if (d != -1) {
            setMaxWidth(d);
        }
        CharSequence b = a.m1697b(6);
        if (!TextUtils.isEmpty(b)) {
            setQueryHint(b);
        }
        d = a.m1694a(3, -1);
        if (d != -1) {
            setImeOptions(d);
        }
        d = a.m1694a(2, -1);
        if (d != -1) {
            setInputType(d);
        }
        setFocusable(a.m1696a(0, true));
        a.m1698b();
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent.addFlags(268435456);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent.addFlags(268435456);
        this.mDropDownAnchor = findViewById(this.mSearchSrcTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            if (VERSION.SDK_INT >= 11) {
                addOnLayoutChangeListenerToDropDownAnchorSDK11();
            } else {
                addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    @TargetApi(11)
    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        this.mDropDownAnchor.addOnLayoutChangeListener(new C00755(this));
    }

    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new C00766(this));
    }

    int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchable = searchableInfo;
        if (this.mSearchable != null) {
            if (IS_AT_LEAST_FROYO) {
                updateSearchAutoComplete();
            }
            updateQueryHint();
        }
        boolean z = IS_AT_LEAST_FROYO && hasVoiceSearch();
        this.mVoiceButtonEnabled = z;
        if (this.mVoiceButtonEnabled) {
            this.mSearchSrcTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(this.mIconified);
    }

    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (this.mIconified) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.mSearchSrcTextView.requestFocus(i, rect);
        if (requestFocus) {
            updateViewsVisibility(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        setImeVisibility(this, false);
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mClearingFocus = false;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.mOnQueryChangeListener = onQueryTextListener;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.mOnSuggestionListener = onSuggestionListener;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            this.mSearchSrcTextView.setSelection(this.mSearchSrcTextView.length());
            this.mUserQuery = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            onSubmitQuery(this);
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        if (this.mQueryHint != null) {
            return this.mQueryHint;
        }
        if (!IS_AT_LEAST_FROYO || this.mSearchable == null) {
            return null;
        }
        int hintId = this.mSearchable.getHintId();
        if (hintId != 0) {
            return getContext().getString(hintId);
        }
        return null;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault != z) {
            this.mIconifiedByDefault = z;
            updateViewsVisibility(z);
            updateQueryHint();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked(this);
        } else {
            onSearchClicked(this);
        }
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    protected void onMeasure(int i, int i2) {
        if (this.mIconified) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.mMaxWidth <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
            case 0:
                if (this.mMaxWidth <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.mMaxWidth;
                    break;
                }
            case 1073741824:
                if (this.mMaxWidth > 0) {
                    size = Math.min(this.mMaxWidth, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    void onTextFocusChanged() {
        updateViewsVisibility(this.mIconified);
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery(this);
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(this.mIconified);
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.mQueryRefinement = z;
        if (this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
            int i;
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mSuggestionsAdapter;
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            suggestionsAdapter.f1527q = i;
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(2131427336);
    }

    private void updateViewsVisibility(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.mIconified = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.mSearchButton.setVisibility(i2);
        updateSubmitButton(z2);
        View view = this.mSearchEditFrame;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        ImageView imageView = this.mCollapsedIcon;
        if (!this.mIconifiedByDefault) {
            i = 0;
        }
        imageView.setVisibility(i);
        updateCloseButton();
        if (z2) {
            z3 = false;
        }
        updateVoiceButton(z3);
        updateSubmitArea();
    }

    @TargetApi(8)
    private boolean hasVoiceSearch() {
        if (this.mSearchable == null || !this.mSearchable.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
            intent = this.mVoiceWebSearchIntent;
        } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
            intent = this.mVoiceAppSearchIntent;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !this.mIconified;
    }

    private void updateSubmitButton(boolean z) {
        int i = 8;
        if (this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (z || !this.mVoiceButtonEnabled)) {
            i = 0;
        }
        this.mGoButton.setVisibility(i);
    }

    private void updateSubmitArea() {
        int i = 8;
        if (isSubmitAreaEnabled() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) {
            i = 0;
        }
        this.mSubmitArea.setVisibility(i);
    }

    private void updateCloseButton() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.mSearchSrcTextView.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
            i = 0;
        }
        ImageView imageView = this.mCloseButton;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? View.ENABLED_STATE_SET : View.EMPTY_STATE_SET);
        }
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    public static void updateFocusedState(SearchView searchView) {
        int[] iArr = searchView.mSearchSrcTextView.hasFocus() ? View.FOCUSED_STATE_SET : View.EMPTY_STATE_SET;
        Drawable background = searchView.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = searchView.mSubmitArea.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        searchView.invalidate();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2065287362);
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -890152325, a);
    }

    public static void setImeVisibility(SearchView searchView, boolean z) {
        if (z) {
            searchView.post(searchView.mShowImeRunnable);
            return;
        }
        searchView.removeCallbacks(searchView.mShowImeRunnable);
        InputMethodManager inputMethodManager = (InputMethodManager) searchView.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
        }
    }

    void onQueryRefine(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public static boolean onSuggestionsKey(SearchView searchView, View view, int i, KeyEvent keyEvent) {
        if (searchView.mSearchable == null || searchView.mSuggestionsAdapter == null || keyEvent.getAction() != 0 || !KeyEventCompat.m341a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return onItemClicked(searchView, searchView.mSearchSrcTextView.getListSelection(), 0, null);
        }
        if (i != 21 && i != 22) {
            return (i == 19 && searchView.mSearchSrcTextView.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = searchView.mSearchSrcTextView.length();
            }
            searchView.mSearchSrcTextView.setSelection(i2);
            searchView.mSearchSrcTextView.setListSelection(0);
            searchView.mSearchSrcTextView.clearListSelection();
            HIDDEN_METHOD_INVOKER.m1966a(searchView.mSearchSrcTextView, true);
            return true;
        }
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        if (!this.mIconifiedByDefault || this.mSearchHintIcon == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void updateQueryHint() {
        if (this.mQueryHint != null) {
            this.mSearchSrcTextView.setHint(getDecoratedHint(this.mQueryHint));
        } else if (!IS_AT_LEAST_FROYO || this.mSearchable == null) {
            this.mSearchSrcTextView.setHint(getDecoratedHint(""));
        } else {
            CharSequence charSequence = null;
            int hintId = this.mSearchable.getHintId();
            if (hintId != 0) {
                charSequence = getContext().getString(hintId);
            }
            if (charSequence != null) {
                this.mSearchSrcTextView.setHint(getDecoratedHint(charSequence));
            }
        }
    }

    @TargetApi(8)
    private void updateSearchAutoComplete() {
        int i = 1;
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        if (this.mSuggestionsAdapter != null) {
            this.mSuggestionsAdapter.mo170a(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSearchSrcTextView.setAdapter(this.mSuggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                i = 2;
            }
            suggestionsAdapter.f1527q = i;
        }
    }

    private void updateVoiceButton(boolean z) {
        int i;
        if (this.mVoiceButtonEnabled && !this.mIconified && z) {
            i = 0;
            this.mGoButton.setVisibility(8);
        } else {
            i = 8;
        }
        this.mVoiceButton.setVisibility(i);
    }

    public static void onTextChanged(SearchView searchView, CharSequence charSequence) {
        boolean z = true;
        CharSequence text = searchView.mSearchSrcTextView.getText();
        searchView.mUserQuery = text;
        boolean z2 = !TextUtils.isEmpty(text);
        searchView.updateSubmitButton(z2);
        if (z2) {
            z = false;
        }
        searchView.updateVoiceButton(z);
        searchView.updateCloseButton();
        searchView.updateSubmitArea();
        if (!(searchView.mOnQueryChangeListener == null || TextUtils.equals(charSequence, searchView.mOldQueryText))) {
            searchView.mOnQueryChangeListener.m1970b(charSequence.toString());
        }
        searchView.mOldQueryText = charSequence.toString();
    }

    public static void onSubmitQuery(SearchView searchView) {
        CharSequence text = searchView.mSearchSrcTextView.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (searchView.mOnQueryChangeListener == null || !searchView.mOnQueryChangeListener.m1969a(text.toString())) {
                if (searchView.mSearchable != null) {
                    launchQuerySearch(searchView, 0, null, text.toString());
                }
                setImeVisibility(searchView, false);
                searchView.dismissSuggestions();
            }
        }
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    public static void onCloseClicked(SearchView searchView) {
        if (!TextUtils.isEmpty(searchView.mSearchSrcTextView.getText())) {
            searchView.mSearchSrcTextView.setText("");
            searchView.mSearchSrcTextView.requestFocus();
            setImeVisibility(searchView, true);
        } else if (!searchView.mIconifiedByDefault) {
        } else {
            if (searchView.mOnCloseListener == null || !searchView.mOnCloseListener.m1968a()) {
                searchView.clearFocus();
                searchView.updateViewsVisibility(true);
            }
        }
    }

    public static void onSearchClicked(SearchView searchView) {
        searchView.updateViewsVisibility(false);
        searchView.mSearchSrcTextView.requestFocus();
        setImeVisibility(searchView, true);
        if (searchView.mOnSearchClickListener != null) {
            searchView.mOnSearchClickListener.onClick(searchView);
        }
    }

    @TargetApi(8)
    public static void onVoiceClicked(SearchView searchView) {
        if (searchView.mSearchable != null) {
            SearchableInfo searchableInfo = searchView.mSearchable;
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    searchView.getContext().startActivity(searchView.createVoiceWebSearchIntent(searchView.mVoiceWebSearchIntent, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    searchView.getContext().startActivity(searchView.createVoiceAppSearchIntent(searchView.mVoiceAppSearchIntent, searchableInfo));
                }
            } catch (ActivityNotFoundException e) {
                Log.w(LOG_TAG, "Could not find voice search activity");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1662170118);
        super.onWindowFocusChanged(z);
        postUpdateFocusedState();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -838073836, a);
    }

    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
            this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions | 33554432);
            this.mSearchSrcTextView.setText("");
            setIconified(false);
        }
    }

    public static void adjustDropDownSizeAndPosition(SearchView searchView) {
        if (searchView.mDropDownAnchor.getWidth() > 1) {
            int dimensionPixelSize;
            int i;
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.mSearchPlate.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = ViewUtils.m1756a(searchView);
            if (searchView.mIconifiedByDefault) {
                dimensionPixelSize = resources.getDimensionPixelSize(2131427337) + resources.getDimensionPixelSize(2131427339);
            } else {
                dimensionPixelSize = 0;
            }
            searchView.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            if (a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            searchView.mSearchSrcTextView.setDropDownHorizontalOffset(i);
            searchView.mSearchSrcTextView.setDropDownWidth((dimensionPixelSize + ((searchView.mDropDownAnchor.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    public static boolean onItemClicked(SearchView searchView, int i, int i2, String str) {
        if (searchView.mOnSuggestionListener != null && searchView.mOnSuggestionListener.m1972b()) {
            return false;
        }
        searchView.launchSuggestion(i, 0, null);
        setImeVisibility(searchView, false);
        searchView.dismissSuggestions();
        return true;
    }

    public static boolean onItemSelected(SearchView searchView, int i) {
        if (searchView.mOnSuggestionListener != null && searchView.mOnSuggestionListener.m1971a()) {
            return false;
        }
        searchView.rewriteQueryFromSuggestion(i);
        return true;
    }

    private void rewriteQueryFromSuggestion(int i) {
        CharSequence text = this.mSearchSrcTextView.getText();
        Cursor a = this.mSuggestionsAdapter.mo168a();
        if (a != null) {
            if (a.moveToPosition(i)) {
                CharSequence c = this.mSuggestionsAdapter.mo171c(a);
                if (c != null) {
                    setQuery(c);
                    return;
                } else {
                    setQuery(text);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private boolean launchSuggestion(int i, int i2, String str) {
        Cursor a = this.mSuggestionsAdapter.mo168a();
        if (a == null || !a.moveToPosition(i)) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(a, i2, str));
        return true;
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (Throwable e) {
                Log.e(LOG_TAG, "Failed launch activity: " + intent, e);
            }
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.mSearchSrcTextView.setText(charSequence);
        this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public static void launchQuerySearch(SearchView searchView, int i, String str, String str2) {
        searchView.getContext().startActivity(searchView.createIntent("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.mAppSearchData != null) {
            intent.putExtra("app_data", this.mAppSearchData);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (IS_AT_LEAST_FROYO) {
            intent.setComponent(this.mSearchable.getSearchActivity());
        }
        return intent;
    }

    @TargetApi(8)
    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    @TargetApi(8)
    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        String string;
        String string2;
        String str;
        int voiceMaxResults;
        String str2 = null;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        Parcelable activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.mAppSearchData != null) {
            bundle.putParcelable("app_data", this.mAppSearchData);
        }
        Intent intent3 = new Intent(intent);
        String str3 = "free_form";
        if (VERSION.SDK_INT >= 8) {
            Resources resources = getResources();
            if (searchableInfo.getVoiceLanguageModeId() != 0) {
                str3 = resources.getString(searchableInfo.getVoiceLanguageModeId());
            }
            if (searchableInfo.getVoicePromptTextId() != 0) {
                string = resources.getString(searchableInfo.getVoicePromptTextId());
            } else {
                string = null;
            }
            if (searchableInfo.getVoiceLanguageId() != 0) {
                string2 = resources.getString(searchableInfo.getVoiceLanguageId());
            } else {
                string2 = null;
            }
            if (searchableInfo.getVoiceMaxResults() != 0) {
                str = str3;
                voiceMaxResults = searchableInfo.getVoiceMaxResults();
            } else {
                str = str3;
                voiceMaxResults = 1;
            }
        } else {
            string2 = null;
            string = null;
            str = str3;
            voiceMaxResults = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        str3 = "calling_package";
        if (searchActivity != null) {
            str2 = searchActivity.flattenToShortString();
        }
        intent3.putExtra(str3, str2);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i, String str) {
        try {
            String a = SuggestionsAdapter.m2088a(cursor, "suggest_intent_action");
            if (a == null && VERSION.SDK_INT >= 8) {
                a = this.mSearchable.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = SuggestionsAdapter.m2088a(cursor, "suggest_intent_data");
            if (IS_AT_LEAST_FROYO && a2 == null) {
                a2 = this.mSearchable.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = SuggestionsAdapter.m2088a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return createIntent(a, a2 == null ? null : Uri.parse(a2), SuggestionsAdapter.m2088a(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.m2088a(cursor, "suggest_intent_query"), i, str);
        } catch (Throwable e) {
            int position;
            Throwable th = e;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + position + " returned exception.", th);
            return null;
        }
    }

    public static void forceSuggestionQuery(SearchView searchView) {
        HIDDEN_METHOD_INVOKER.m1965a(searchView.mSearchSrcTextView);
        HIDDEN_METHOD_INVOKER.m1967b(searchView.mSearchSrcTextView);
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
