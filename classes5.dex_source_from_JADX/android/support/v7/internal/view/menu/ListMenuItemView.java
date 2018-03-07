package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.MenuView.ItemView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: upcoming_events */
public class ListMenuItemView extends LinearLayout implements ItemView {
    private MenuItemImpl f821a;
    private ImageView f822b;
    private RadioButton f823c;
    private TextView f824d;
    private CheckBox f825e;
    private TextView f826f;
    private Drawable f827g;
    private int f828h;
    private Context f829i;
    private boolean f830j;
    private int f831k;
    private Context f832l;
    private LayoutInflater f833m;
    private boolean f834n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f832l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MenuView, i, 0);
        this.f827g = obtainStyledAttributes.getDrawable(5);
        this.f828h = obtainStyledAttributes.getResourceId(1, -1);
        this.f830j = obtainStyledAttributes.getBoolean(7, false);
        this.f829i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2125131181);
        super.onFinishInflate();
        setBackgroundDrawable(this.f827g);
        this.f824d = (TextView) findViewById(2131558927);
        if (this.f828h != -1) {
            this.f824d.setTextAppearance(this.f829i, this.f828h);
        }
        this.f826f = (TextView) findViewById(2131559124);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 842755090, a);
    }

    public final void mo301a(MenuItemImpl menuItemImpl, int i) {
        this.f821a = menuItemImpl;
        this.f831k = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.m1430a((ItemView) this));
        setCheckable(menuItemImpl.isCheckable());
        boolean f = menuItemImpl.m1439f();
        menuItemImpl.m1436d();
        setShortcut$25d965e(f);
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f834n = z;
        this.f830j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f824d.setText(charSequence);
            if (this.f824d.getVisibility() != 0) {
                this.f824d.setVisibility(0);
            }
        } else if (this.f824d.getVisibility() != 8) {
            this.f824d.setVisibility(8);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f821a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f823c != null || this.f825e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f821a.m1440g()) {
                if (this.f823c == null) {
                    m1373c();
                }
                compoundButton = this.f823c;
                compoundButton2 = this.f825e;
            } else {
                if (this.f825e == null) {
                    m1374d();
                }
                compoundButton = this.f825e;
                compoundButton2 = this.f823c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f821a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f825e != null) {
                this.f825e.setVisibility(8);
            }
            if (this.f823c != null) {
                this.f823c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f821a.m1440g()) {
            if (this.f823c == null) {
                m1373c();
            }
            compoundButton = this.f823c;
        } else {
            if (this.f825e == null) {
                m1374d();
            }
            compoundButton = this.f825e;
        }
        compoundButton.setChecked(z);
    }

    private void setShortcut$25d965e(boolean z) {
        int i = (z && this.f821a.m1439f()) ? 0 : 8;
        if (i == 0) {
            String str;
            TextView textView = this.f826f;
            char d = this.f821a.m1436d();
            if (d == '\u0000') {
                str = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(MenuItemImpl.f875w);
                switch (d) {
                    case '\b':
                        stringBuilder.append(MenuItemImpl.f877y);
                        break;
                    case '\n':
                        stringBuilder.append(MenuItemImpl.f876x);
                        break;
                    case ' ':
                        stringBuilder.append(MenuItemImpl.f878z);
                        break;
                    default:
                        stringBuilder.append(d);
                        break;
                }
                str = stringBuilder.toString();
            }
            textView.setText(str);
        }
        if (this.f826f.getVisibility() != i) {
            this.f826f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i;
        if (this.f821a.f890l.f865t || this.f834n) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 0 && !this.f830j) {
            return;
        }
        if (this.f822b != null || drawable != null || this.f830j) {
            if (this.f822b == null) {
                m1372b();
            }
            if (drawable != null || this.f830j) {
                ImageView imageView = this.f822b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f822b.getVisibility() != 0) {
                    this.f822b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f822b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f822b != null && this.f830j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f822b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m1372b() {
        this.f822b = (ImageView) getInflater().inflate(2130903052, this, false);
        addView(this.f822b, 0);
    }

    private void m1373c() {
        this.f823c = (RadioButton) getInflater().inflate(2130903054, this, false);
        addView(this.f823c);
    }

    private void m1374d() {
        this.f825e = (CheckBox) getInflater().inflate(2130903051, this, false);
        addView(this.f825e);
    }

    public final boolean gO_() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f833m == null) {
            this.f833m = LayoutInflater.from(this.f832l);
        }
        return this.f833m;
    }
}
