package android.support.v7.internal.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;

/* compiled from: upsell_buy_attempt */
public class ContextThemeWrapper extends ContextWrapper {
    public int f708a;
    private Theme f709b;
    private LayoutInflater f710c;

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f708a = i;
    }

    public void setTheme(int i) {
        this.f708a = i;
        m1280b();
    }

    public Theme getTheme() {
        if (this.f709b != null) {
            return this.f709b;
        }
        if (this.f708a == 0) {
            this.f708a = 2131624138;
        }
        m1280b();
        return this.f709b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f710c == null) {
            this.f710c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f710c;
    }

    private void m1280b() {
        if ((this.f709b == null ? 1 : null) != null) {
            this.f709b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f709b.setTo(theme);
            }
        }
        this.f709b.applyStyle(this.f708a, true);
    }
}
