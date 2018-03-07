package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ThemeUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.R;
import java.util.WeakHashMap;

/* compiled from: publishPhoto */
public class TextInputLayout extends LinearLayout {
    public EditText f7099a;
    private CharSequence f7100b;
    private Paint f7101c;
    private LinearLayout f7102d;
    public boolean f7103e;
    public TextView f7104f;
    private int f7105g;
    private boolean f7106h;
    public boolean f7107i;
    private TextView f7108j;
    public int f7109k;
    private int f7110l;
    private int f7111m;
    private boolean f7112n;
    private ColorStateList f7113o;
    private ColorStateList f7114p;
    public final CollapsingTextHelper f7115q;
    public boolean f7116r;
    private ValueAnimatorCompat f7117s;

    /* compiled from: publishPhoto */
    class C04131 implements TextWatcher {
        final /* synthetic */ TextInputLayout f7094a;

        C04131(TextInputLayout textInputLayout) {
            this.f7094a = textInputLayout;
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout.m10215a(this.f7094a, true);
            if (this.f7094a.f7107i) {
                TextInputLayout.m10214a(this.f7094a, editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: publishPhoto */
    class C04142 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ TextInputLayout f7095a;

        C04142(TextInputLayout textInputLayout) {
            this.f7095a = textInputLayout;
        }

        public final void m10205a(View view) {
            view.setVisibility(0);
        }
    }

    /* compiled from: publishPhoto */
    class C04153 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ TextInputLayout f7096a;

        C04153(TextInputLayout textInputLayout) {
            this.f7096a = textInputLayout;
        }

        public final void m10206b(View view) {
            view.setVisibility(4);
            TextInputLayout.m10215a(this.f7096a, true);
        }
    }

    /* compiled from: publishPhoto */
    class C04164 implements AnimatorUpdateListener {
        final /* synthetic */ TextInputLayout f7097a;

        C04164(TextInputLayout textInputLayout) {
            this.f7097a = textInputLayout;
        }

        public final void mo847a(ValueAnimatorCompat valueAnimatorCompat) {
            this.f7097a.f7115q.m10054b(valueAnimatorCompat.m10243d());
        }
    }

    /* compiled from: publishPhoto */
    class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ TextInputLayout f7098b;

        public TextInputAccessibilityDelegate(TextInputLayout textInputLayout) {
            this.f7098b = textInputLayout;
        }

        public final void m10210d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public final void m10209c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            CharSequence charSequence = this.f7098b.f7115q.f6949x;
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityEvent.getText().add(charSequence);
            }
        }

        public final void m10208a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.b(TextInputLayout.class.getSimpleName());
            CharSequence charSequence = this.f7098b.f7115q.f6949x;
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.c(charSequence);
            }
            if (this.f7098b.f7099a != null) {
                EditText editText = this.f7098b.f7099a;
            }
            charSequence = this.f7098b.f7104f != null ? this.f7098b.f7104f.getText() : null;
            if (!TextUtils.isEmpty(charSequence)) {
                AccessibilityNodeInfoCompat.a.j(accessibilityNodeInfoCompat.b, true);
                AccessibilityNodeInfoCompat.a.a(accessibilityNodeInfoCompat.b, charSequence);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f7115q = new CollapsingTextHelper(this);
        ThemeUtils.m10221a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        CollapsingTextHelper collapsingTextHelper = this.f7115q;
        collapsingTextHelper.f6919K = AnimationUtils.f6855b;
        collapsingTextHelper.m10063g();
        collapsingTextHelper = this.f7115q;
        collapsingTextHelper.f6918J = new AccelerateInterpolator();
        collapsingTextHelper.m10063g();
        this.f7115q.m10060d(8388659);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextInputLayout, i, 2131624585);
        setHint(obtainStyledAttributes.getText(1));
        this.f7116r = obtainStyledAttributes.getBoolean(9, true);
        if (obtainStyledAttributes.hasValue(0)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            this.f7114p = colorStateList;
            this.f7113o = colorStateList;
        }
        if (obtainStyledAttributes.getResourceId(2, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(2, 0));
        }
        this.f7105g = obtainStyledAttributes.getResourceId(4, 0);
        boolean z = obtainStyledAttributes.getBoolean(3, false);
        boolean z2 = obtainStyledAttributes.getBoolean(5, false);
        int i2 = obtainStyledAttributes.getInt(6, -1);
        if (this.f7109k != i2) {
            if (i2 > 0) {
                this.f7109k = i2;
            } else {
                this.f7109k = -1;
            }
            if (this.f7107i) {
                m10214a(this, this.f7099a == null ? 0 : this.f7099a.getText().length());
            }
        }
        this.f7110l = obtainStyledAttributes.getResourceId(7, 0);
        this.f7111m = obtainStyledAttributes.getResourceId(8, 0);
        obtainStyledAttributes.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        if (ViewCompat.e(this) == 0) {
            ViewCompat.d(this, 1);
        }
        ViewCompat.a(this, new TextInputAccessibilityDelegate(this));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            setEditText((EditText) view);
            super.addView(view, 0, m10211a(layoutParams));
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        this.f7115q.m10059c(typeface);
    }

    @NonNull
    public Typeface getTypeface() {
        return this.f7115q.m10057c();
    }

    private void setEditText(EditText editText) {
        if (this.f7099a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f7099a = editText;
        this.f7115q.m10059c(this.f7099a.getTypeface());
        CollapsingTextHelper collapsingTextHelper = this.f7115q;
        float textSize = this.f7099a.getTextSize();
        if (collapsingTextHelper.f6936k != textSize) {
            collapsingTextHelper.f6936k = textSize;
            collapsingTextHelper.m10063g();
        }
        this.f7115q.m10058c(this.f7099a.getGravity());
        this.f7099a.addTextChangedListener(new C04131(this));
        if (this.f7113o == null) {
            this.f7113o = this.f7099a.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.f7100b)) {
            setHint(this.f7099a.getHint());
            this.f7099a.setHint(null);
        }
        if (this.f7108j != null) {
            m10214a(this, this.f7099a.getText().length());
        }
        if (this.f7102d != null) {
            m10212a();
        }
        m10215a(this, false);
    }

    private LinearLayout.LayoutParams m10211a(LayoutParams layoutParams) {
        layoutParams = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f7101c == null) {
            this.f7101c = new Paint();
        }
        this.f7101c.setTypeface(this.f7115q.m10057c());
        this.f7101c.setTextSize(this.f7115q.f6937l);
        layoutParams.topMargin = (int) (-this.f7101c.ascent());
        return layoutParams;
    }

    public static void m10215a(TextInputLayout textInputLayout, boolean z) {
        CharSequence text;
        Object obj = 1;
        Object obj2 = (textInputLayout.f7099a == null || TextUtils.isEmpty(textInputLayout.f7099a.getText())) ? null : 1;
        Object obj3 = null;
        for (int i : textInputLayout.getDrawableState()) {
            if (i == 16842908) {
                obj3 = 1;
                break;
            }
        }
        Object obj4 = obj3;
        if (textInputLayout.f7103e && textInputLayout.f7104f != null && textInputLayout.f7104f.getVisibility() == 0) {
            text = textInputLayout.f7104f.getText();
        } else {
            text = null;
        }
        if (TextUtils.isEmpty(text)) {
            obj = null;
        }
        if (textInputLayout.f7113o != null) {
            textInputLayout.f7115q.m10055b(textInputLayout.f7113o.getDefaultColor());
        }
        if (textInputLayout.f7112n && textInputLayout.f7108j != null) {
            textInputLayout.f7115q.m10050a(textInputLayout.f7108j.getCurrentTextColor());
        } else if (obj != null && textInputLayout.f7104f != null) {
            textInputLayout.f7115q.m10050a(textInputLayout.f7104f.getCurrentTextColor());
        } else if (obj4 != null && textInputLayout.f7114p != null) {
            textInputLayout.f7115q.m10050a(textInputLayout.f7114p.getDefaultColor());
        } else if (textInputLayout.f7113o != null) {
            textInputLayout.f7115q.m10050a(textInputLayout.f7113o.getDefaultColor());
        }
        if (obj2 == null && obj4 == null && obj == null) {
            textInputLayout.m10220c(z);
        } else {
            textInputLayout.m10219b(z);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f7100b = charSequence;
        this.f7115q.m10053a(charSequence);
        sendAccessibilityEvent(2048);
    }

    @Nullable
    public CharSequence getHint() {
        return this.f7100b;
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.f7115q.m10061e(i);
        this.f7114p = ColorStateList.valueOf(this.f7115q.f6939n);
        if (this.f7099a != null) {
            m10215a(this, false);
            this.f7099a.setLayoutParams(m10211a(this.f7099a.getLayoutParams()));
            this.f7099a.requestLayout();
        }
    }

    private void m10217a(TextView textView, int i) {
        if (this.f7102d == null) {
            this.f7102d = new LinearLayout(getContext());
            this.f7102d.setOrientation(0);
            addView(this.f7102d, -1, -2);
            this.f7102d.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f7099a != null) {
                m10212a();
            }
        }
        this.f7102d.setVisibility(0);
        this.f7102d.addView(textView, i);
    }

    private void m10212a() {
        ViewCompat.b(this.f7102d, ViewCompat.n(this.f7099a), 0, ViewCompat.o(this.f7099a), this.f7099a.getPaddingBottom());
    }

    private void m10216a(TextView textView) {
        if (this.f7102d != null) {
            this.f7102d.removeView(textView);
            if (this.f7102d.getChildCount() == 0) {
                this.f7102d.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        if (this.f7103e != z) {
            if (this.f7104f != null) {
                ViewCompat.t(this.f7104f).a();
            }
            if (z) {
                this.f7104f = new TextView(getContext());
                this.f7104f.setTextAppearance(getContext(), this.f7105g);
                this.f7104f.setVisibility(4);
                ViewCompat.f(this.f7104f, 1);
                m10217a(this.f7104f, 0);
            } else {
                this.f7106h = false;
                m10218b();
                m10216a(this.f7104f);
                this.f7104f = null;
            }
            this.f7103e = z;
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f7103e) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            ViewCompat.c(this.f7104f, 0.0f);
            this.f7104f.setText(charSequence);
            ViewCompat.t(this.f7104f).a(1.0f).a(200).a(AnimationUtils.f6857d).a(new C04142(this)).b();
            this.f7106h = true;
            m10218b();
            m10215a(this, true);
        } else if (this.f7104f.getVisibility() == 0) {
            ViewCompat.t(this.f7104f).a(0.0f).a(200).a(AnimationUtils.f6856c).a(new C04153(this)).b();
            this.f7106h = false;
            m10218b();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f7107i != z) {
            if (z) {
                this.f7108j = new TextView(getContext());
                this.f7108j.setMaxLines(1);
                this.f7108j.setTextAppearance(getContext(), this.f7110l);
                ViewCompat.f(this.f7108j, 1);
                m10217a(this.f7108j, -1);
                if (this.f7099a == null) {
                    m10214a(this, 0);
                } else {
                    m10214a(this, this.f7099a.getText().length());
                }
            } else {
                m10216a(this.f7108j);
                this.f7108j = null;
            }
            this.f7107i = z;
        }
    }

    public int getCounterMaxLength() {
        return this.f7109k;
    }

    public static void m10214a(TextInputLayout textInputLayout, int i) {
        boolean z = textInputLayout.f7112n;
        if (textInputLayout.f7109k == -1) {
            textInputLayout.f7108j.setText(String.valueOf(i));
            textInputLayout.f7112n = false;
        } else {
            textInputLayout.f7112n = i > textInputLayout.f7109k;
            if (z != textInputLayout.f7112n) {
                textInputLayout.f7108j.setTextAppearance(textInputLayout.getContext(), textInputLayout.f7112n ? textInputLayout.f7111m : textInputLayout.f7110l);
            }
            textInputLayout.f7108j.setText(textInputLayout.getContext().getString(2131230855, new Object[]{Integer.valueOf(i), Integer.valueOf(textInputLayout.f7109k)}));
        }
        if (textInputLayout.f7099a != null && z != textInputLayout.f7112n) {
            m10215a(textInputLayout, false);
            textInputLayout.m10218b();
        }
    }

    private void m10218b() {
        if (this.f7106h && this.f7104f != null) {
            ViewCompat.a(this.f7099a, ColorStateList.valueOf(this.f7104f.getCurrentTextColor()));
        } else if (!this.f7112n || this.f7108j == null) {
            SparseArray sparseArray;
            ColorStateList colorStateList;
            View view = this.f7099a;
            if (AppCompatDrawableManager.b == null) {
                AppCompatDrawableManager.b = new AppCompatDrawableManager();
            }
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.b;
            Context context = getContext();
            if (appCompatDrawableManager.j != null) {
                sparseArray = (SparseArray) appCompatDrawableManager.j.get(context);
                colorStateList = sparseArray != null ? (ColorStateList) sparseArray.get(2130837523) : null;
            } else {
                colorStateList = null;
            }
            ColorStateList colorStateList2 = colorStateList;
            if (colorStateList2 == null) {
                if (2130837523 == 2130837523) {
                    r6 = new int[3][];
                    int[] iArr = new int[]{ThemeUtils.a, ThemeUtils.c(context, 2130772051), ThemeUtils.g};
                    iArr[1] = ThemeUtils.a(context, 2130772051);
                    r6[2] = ThemeUtils.h;
                    iArr[2] = ThemeUtils.a(context, 2130772052);
                    colorStateList2 = new ColorStateList(r6, iArr);
                } else if (2130837523 == 2130837555) {
                    colorStateList2 = AppCompatDrawableManager.c(context);
                } else if (2130837523 == 2130837554) {
                    colorStateList2 = AppCompatDrawableManager.d(context);
                } else if (2130837523 == 2130837512 || 2130837523 == 2130837507) {
                    colorStateList2 = AppCompatDrawableManager.c(context, 2130772054);
                } else if (2130837523 == 2130837511) {
                    colorStateList2 = AppCompatDrawableManager.c(context, 2130772050);
                } else if (2130837523 == 2130837552 || 2130837523 == 2130837553) {
                    colorStateList2 = AppCompatDrawableManager.h(context);
                } else if (AppCompatDrawableManager.a(AppCompatDrawableManager.e, 2130837523)) {
                    colorStateList2 = ThemeUtils.b(context, 2130772051);
                } else if (AppCompatDrawableManager.a(AppCompatDrawableManager.h, 2130837523)) {
                    colorStateList2 = AppCompatDrawableManager.a(context);
                } else if (AppCompatDrawableManager.a(AppCompatDrawableManager.i, 2130837523)) {
                    colorStateList2 = AppCompatDrawableManager.b(context);
                }
                if (colorStateList2 != null) {
                    if (appCompatDrawableManager.j == null) {
                        appCompatDrawableManager.j = new WeakHashMap();
                    }
                    sparseArray = (SparseArray) appCompatDrawableManager.j.get(context);
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        appCompatDrawableManager.j.put(context, sparseArray);
                    }
                    sparseArray.append(2130837523, colorStateList2);
                }
            }
            ViewCompat.a(view, colorStateList2);
        } else {
            ViewCompat.a(this.f7099a, ColorStateList.valueOf(this.f7108j.getCurrentTextColor()));
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f7115q.m10052a(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f7099a != null) {
            int left = this.f7099a.getLeft() + this.f7099a.getCompoundPaddingLeft();
            int right = this.f7099a.getRight() - this.f7099a.getCompoundPaddingRight();
            this.f7115q.m10051a(left, this.f7099a.getTop() + this.f7099a.getCompoundPaddingTop(), right, this.f7099a.getBottom() - this.f7099a.getCompoundPaddingBottom());
            this.f7115q.m10056b(left, getPaddingTop(), right, (i4 - i2) - getPaddingBottom());
            this.f7115q.m10063g();
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        m10215a(this, ViewCompat.E(this));
    }

    private void m10219b(boolean z) {
        if (this.f7117s != null && this.f7117s.m10241b()) {
            this.f7117s.m10244e();
        }
        if (z && this.f7116r) {
            m10213a(1.0f);
        } else {
            this.f7115q.m10054b(1.0f);
        }
    }

    private void m10220c(boolean z) {
        if (this.f7117s != null && this.f7117s.m10241b()) {
            this.f7117s.m10244e();
        }
        if (z && this.f7116r) {
            m10213a(0.0f);
        } else {
            this.f7115q.m10054b(0.0f);
        }
    }

    private void m10213a(float f) {
        if (this.f7115q.f6930e != f) {
            if (this.f7117s == null) {
                this.f7117s = ViewUtils.m10279a();
                this.f7117s.m10240a(AnimationUtils.f6854a);
                this.f7117s.m10237a(200);
                this.f7117s.m10239a(new C04164(this));
            }
            this.f7117s.m10236a(this.f7115q.f6930e, f);
            this.f7117s.m10235a();
        }
    }
}
