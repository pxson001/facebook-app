package android.support.v7.internal.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.facebook.R;
import java.lang.reflect.Method;

/* compiled from: upsell_Time_label */
public class SupportMenuInflater extends MenuInflater {
    public static final Class<?>[] f753a;
    public static final Class<?>[] f754b;
    public final Object[] f755c;
    public final Object[] f756d = this.f755c;
    public Context f757e;
    private Object f758f;

    /* compiled from: upsell_Time_label */
    class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
        private static final Class<?>[] f724a = new Class[]{MenuItem.class};
        private Object f725b;
        private Method f726c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f725b = obj;
            Class cls = obj.getClass();
            try {
                this.f726c = cls.getMethod(str, f724a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f726c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f726c.invoke(this.f725b, new Object[]{menuItem})).booleanValue();
                }
                this.f726c.invoke(this.f725b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: upsell_Time_label */
    public class MenuState {
        final /* synthetic */ SupportMenuInflater f727a;
        private Menu f728b;
        private int f729c;
        private int f730d;
        private int f731e;
        private int f732f;
        private boolean f733g;
        private boolean f734h;
        public boolean f735i;
        private int f736j;
        private int f737k;
        private CharSequence f738l;
        private CharSequence f739m;
        private int f740n;
        private char f741o;
        private char f742p;
        private int f743q;
        private boolean f744r;
        private boolean f745s;
        private boolean f746t;
        private int f747u;
        private int f748v;
        private String f749w;
        private String f750x;
        private String f751y;
        public ActionProvider f752z;

        public MenuState(SupportMenuInflater supportMenuInflater, Menu menu) {
            this.f727a = supportMenuInflater;
            this.f728b = menu;
            m1305a();
        }

        public final void m1305a() {
            this.f729c = 0;
            this.f730d = 0;
            this.f731e = 0;
            this.f732f = 0;
            this.f733g = true;
            this.f734h = true;
        }

        public final void m1306a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f727a.f757e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f729c = obtainStyledAttributes.getResourceId(1, 0);
            this.f730d = obtainStyledAttributes.getInt(3, 0);
            this.f731e = obtainStyledAttributes.getInt(4, 0);
            this.f732f = obtainStyledAttributes.getInt(5, 0);
            this.f733g = obtainStyledAttributes.getBoolean(2, true);
            this.f734h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public final void m1308b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f727a.f757e.obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
            this.f736j = obtainStyledAttributes.getResourceId(2, 0);
            this.f737k = (obtainStyledAttributes.getInt(5, this.f730d) & -65536) | (obtainStyledAttributes.getInt(6, this.f731e) & 65535);
            this.f738l = obtainStyledAttributes.getText(7);
            this.f739m = obtainStyledAttributes.getText(8);
            this.f740n = obtainStyledAttributes.getResourceId(0, 0);
            this.f741o = m1302a(obtainStyledAttributes.getString(9));
            this.f742p = m1302a(obtainStyledAttributes.getString(10));
            if (obtainStyledAttributes.hasValue(11)) {
                this.f743q = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
            } else {
                this.f743q = this.f732f;
            }
            this.f744r = obtainStyledAttributes.getBoolean(3, false);
            this.f745s = obtainStyledAttributes.getBoolean(4, this.f733g);
            this.f746t = obtainStyledAttributes.getBoolean(1, this.f734h);
            this.f747u = obtainStyledAttributes.getInt(13, -1);
            this.f751y = obtainStyledAttributes.getString(12);
            this.f748v = obtainStyledAttributes.getResourceId(14, 0);
            this.f749w = obtainStyledAttributes.getString(15);
            this.f750x = obtainStyledAttributes.getString(16);
            if (this.f750x == null) {
                z = false;
            }
            if (z && this.f748v == 0 && this.f749w == null) {
                this.f752z = (ActionProvider) m1303a(this.f750x, SupportMenuInflater.f754b, this.f727a.f756d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f752z = null;
            }
            obtainStyledAttributes.recycle();
            this.f735i = false;
        }

        private static char m1302a(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void m1304a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f744r).setVisible(this.f745s).setEnabled(this.f746t).setCheckable(this.f743q > 0).setTitleCondensed(this.f739m).setIcon(this.f740n).setAlphabeticShortcut(this.f741o).setNumericShortcut(this.f742p);
            if (this.f747u >= 0) {
                MenuItemCompat.m380a(menuItem, this.f747u);
            }
            if (this.f751y != null) {
                if (this.f727a.f757e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.m1312c(this.f727a), this.f751y));
            }
            if (this.f743q >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).m1432a(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).m1452a(true);
                }
            }
            if (this.f749w != null) {
                MenuItemCompat.m378a(menuItem, (View) m1303a(this.f749w, SupportMenuInflater.f753a, this.f727a.f755c));
            } else {
                z = false;
            }
            if (this.f748v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    MenuItemCompat.m381b(menuItem, this.f748v);
                }
            }
            if (this.f752z != null) {
                MenuItemCompat.m376a(menuItem, this.f752z);
            }
        }

        public final void m1307b() {
            this.f735i = true;
            m1304a(this.f728b.add(this.f729c, this.f736j, this.f737k, this.f738l));
        }

        public final SubMenu m1309c() {
            this.f735i = true;
            SubMenu addSubMenu = this.f728b.addSubMenu(this.f729c, this.f736j, this.f737k, this.f738l);
            m1304a(addSubMenu.getItem());
            return addSubMenu;
        }

        private <T> T m1303a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                return this.f727a.f757e.getClassLoader().loadClass(str).getConstructor(clsArr).newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        f753a = clsArr;
        f754b = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f757e = context;
        this.f755c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof SupportMenu) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f757e.getResources().getLayout(i);
                m1311a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1311a(org.xmlpull.v1.XmlPullParser r12, android.util.AttributeSet r13, android.view.Menu r14) {
        /*
        r11 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.internal.view.SupportMenuInflater$MenuState;
        r7.<init>(r11, r14);
        r0 = r12.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x0046;
    L_0x000f:
        r0 = r12.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r12.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00d6;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00ce;
            case 2: goto L_0x004d;
            case 3: goto L_0x0081;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r12.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0046:
        r0 = r12.next();
        if (r0 != r1) goto L_0x000c;
    L_0x004c:
        goto L_0x001f;
    L_0x004d:
        if (r5 != 0) goto L_0x0028;
    L_0x004f:
        r3 = r12.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0060;
    L_0x005b:
        r7.m1306a(r13);
        r3 = r5;
        goto L_0x0029;
    L_0x0060:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x006d;
    L_0x0068:
        r7.m1308b(r13);
        r3 = r5;
        goto L_0x0029;
    L_0x006d:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x007e;
    L_0x0075:
        r3 = r7.m1309c();
        r11.m1311a(r12, r13, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x007e:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0081:
        r3 = r12.getName();
        if (r5 == 0) goto L_0x0090;
    L_0x0087:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0090;
    L_0x008d:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0090:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x009d;
    L_0x0098:
        r7.m1305a();
        r3 = r5;
        goto L_0x0029;
    L_0x009d:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00c2;
    L_0x00a5:
        r10 = r7.f735i;
        r3 = r10;
        if (r3 != 0) goto L_0x0028;
    L_0x00aa:
        r3 = r7.f752z;
        if (r3 == 0) goto L_0x00bc;
    L_0x00ae:
        r3 = r7.f752z;
        r3 = r3.mo319e();
        if (r3 == 0) goto L_0x00bc;
    L_0x00b6:
        r7.m1309c();
        r3 = r5;
        goto L_0x0029;
    L_0x00bc:
        r7.m1307b();
        r3 = r5;
        goto L_0x0029;
    L_0x00c2:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00ca:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00ce:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00d6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.SupportMenuInflater.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    public static Object m1312c(SupportMenuInflater supportMenuInflater) {
        if (supportMenuInflater.f758f == null) {
            supportMenuInflater.f758f = supportMenuInflater.m1310a(supportMenuInflater.f757e);
        }
        return supportMenuInflater.f758f;
    }

    private Object m1310a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m1310a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
