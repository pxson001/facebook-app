package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManagerImpl.LoaderInfo;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: }} */
public class FragmentActivity extends Activity {
    final Handler f71a = new C02171(this);
    public final FragmentManagerImpl f72b = new FragmentManagerImpl();
    public FragmentManagerImpl f73c = null;
    final FragmentContainer f74d = new C02182(this);
    boolean f75e;
    boolean f76f;
    boolean f77g;
    boolean f78h;
    public boolean f79i;
    boolean f80j;
    public boolean f81k;
    public boolean f82l;
    public SimpleArrayMap<String, LoaderManagerImpl> f83m;
    public LoaderManagerImpl f84n;
    FragmentActivityHost f85o;

    /* compiled from: }} */
    class C02171 extends Handler {
        final /* synthetic */ FragmentActivity f3760a;

        C02171(FragmentActivity fragmentActivity) {
            this.f3760a = fragmentActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (this.f3760a.f77g) {
                        this.f3760a.m187a(false);
                        return;
                    }
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f3760a.hp_();
                    this.f3760a.f72b.m6267i();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: }} */
    class C02182 implements FragmentContainer {
        final /* synthetic */ FragmentActivity f3790a;

        C02182(FragmentActivity fragmentActivity) {
            this.f3790a = fragmentActivity;
        }

        public final View mo856a(int i) {
            return this.f3790a.findViewById(i);
        }

        public final boolean mo857s() {
            Window window = this.f3790a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* compiled from: }} */
    final class NonConfigurationInstances {
        Object f3800a;
        Object f3801b;
        SimpleArrayMap<String, Object> f3802c;
        ArrayList<Fragment> f3803d;
        SimpleArrayMap<String, LoaderManagerImpl> f3804e;

        NonConfigurationInstances() {
        }
    }

    public final void m186a(FragmentManager fragmentManager) {
        this.f73c = (FragmentManagerImpl) fragmentManager;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f72b.m6270l();
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
        } else if (i3 < 0) {
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
        } else {
            Fragment c = this.f72b.m6255c(i3);
            if (c == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                c.mo1858a(65535 & i, i2, intent);
            }
        }
    }

    public void onBackPressed() {
        if (!this.f72b.mo853e()) {
            if (VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f72b.m6231a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 630010573);
        this.f72b.m6237a(mo800m(), this.f74d, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        if (!mo800m().mo874q()) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.f83m = nonConfigurationInstances.f3804e;
            }
            if (bundle != null) {
                ArrayList arrayList;
                Parcelable parcelable = bundle.getParcelable("android:support:fragments");
                FragmentManagerImpl fragmentManagerImpl = this.f72b;
                if (nonConfigurationInstances != null) {
                    arrayList = nonConfigurationInstances.f3803d;
                } else {
                    arrayList = null;
                }
                fragmentManagerImpl.m6233a(parcelable, arrayList);
            }
            this.f72b.m6271m();
        }
        LogUtils.c(-1144238732, a);
    }

    public View onCreatePanelView(int i) {
        if (i == 0) {
            View w = this.f72b.m6281w();
            if (w != null) {
                return w;
            }
        }
        return super.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f72b.m6243a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    public MenuInflater getMenuInflater() {
        MenuInflater y = this.f72b.m6283y();
        return y != null ? y : super.getMenuInflater();
    }

    public View onCreateView(String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        View onCreateView = (this.f73c != null ? this.f73c : this.f72b).onCreateView(str, context, attributeSet);
        if (onCreateView == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return onCreateView;
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1956141081);
        super.onDestroy();
        m187a(false);
        this.f72b.m6279u();
        if (this.f84n != null) {
            this.f84n.m6340h();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 373752159, a);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f72b.m6280v();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f72b.m6244a(menuItem);
            case 6:
                return this.f72b.m6253b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f72b.m6251b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1263837095);
        super.onPause();
        this.f76f = false;
        if (this.f71a.hasMessages(2)) {
            this.f71a.removeMessages(2);
            hp_();
        }
        this.f72b.m6275q();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1262288531, a);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f72b.m6270l();
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 535620415);
        super.onResume();
        this.f71a.sendEmptyMessage(2);
        this.f76f = true;
        this.f72b.m6267i();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 459115065, a);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f71a.removeMessages(2);
        hp_();
        this.f72b.m6267i();
    }

    protected void hp_() {
        this.f72b.m6274p();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f80j) {
            this.f80j = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        if ((m181a(view, menu) | this.f72b.m6242a(menu)) == 0 || !menu.hasVisibleItems()) {
            return false;
        }
        return true;
    }

    private boolean m181a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f77g) {
            m187a(true);
        }
        Object obj = null;
        ArrayList j = this.f72b.m6268j();
        int i2;
        if (this.f83m != null) {
            int size = this.f83m.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                loaderManagerImplArr[i3] = (LoaderManagerImpl) this.f83m.c(i3);
            }
            i2 = 0;
            while (i < size) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i];
                if (loaderManagerImpl.f3798g) {
                    i2 = true;
                } else {
                    loaderManagerImpl.m6340h();
                    this.f83m.remove(loaderManagerImpl.f3795d);
                }
                i++;
            }
        } else {
            i2 = 0;
        }
        if (j == null && r0 == 0 && obj == null) {
            return null;
        }
        Object nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.f3800a = null;
        nonConfigurationInstances.f3801b = obj;
        nonConfigurationInstances.f3802c = null;
        nonConfigurationInstances.f3803d = j;
        nonConfigurationInstances.f3804e = this.f83m;
        return nonConfigurationInstances;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable k = this.f72b.m6269k();
        if (k != null) {
            bundle.putParcelable("android:support:fragments", k);
        }
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 719084298);
        super.onStart();
        this.f77g = false;
        this.f78h = false;
        this.f71a.removeMessages(1);
        if (!this.f75e) {
            this.f75e = true;
            this.f72b.m6272n();
        }
        this.f72b.m6270l();
        this.f72b.m6267i();
        if (!this.f82l) {
            this.f82l = true;
            if (this.f84n != null) {
                this.f84n.m6336b();
            } else if (!this.f81k) {
                this.f84n = m183a("(root)", this.f82l, false);
                if (!(this.f84n == null || this.f84n.f3797f)) {
                    this.f84n.m6336b();
                }
            }
            this.f81k = true;
        }
        this.f72b.m6273o();
        if (this.f83m != null) {
            int size = this.f83m.size();
            LoaderManagerImpl[] loaderManagerImplArr = new LoaderManagerImpl[size];
            for (int i = size - 1; i >= 0; i--) {
                loaderManagerImplArr[i] = (LoaderManagerImpl) this.f83m.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                LoaderManagerImpl loaderManagerImpl = loaderManagerImplArr[i2];
                if (loaderManagerImpl.f3798g) {
                    if (LoaderManagerImpl.f3792a) {
                        Log.v("LoaderManager", "Finished Retaining in " + loaderManagerImpl);
                    }
                    loaderManagerImpl.f3798g = false;
                    for (int a2 = loaderManagerImpl.f3793b.m6348a() - 1; a2 >= 0; a2--) {
                        LoaderInfo loaderInfo = (LoaderInfo) loaderManagerImpl.f3793b.m6357f(a2);
                        if (loaderInfo.f3818i) {
                            if (LoaderManagerImpl.f3792a) {
                                Log.v("LoaderManager", "  Finished Retaining: " + loaderInfo);
                            }
                            loaderInfo.f3818i = false;
                            if (!(loaderInfo.f3817h == loaderInfo.f3819j || loaderInfo.f3817h)) {
                                loaderInfo.m6363e();
                            }
                        }
                        if (loaderInfo.f3817h && loaderInfo.f3814e && !loaderInfo.f3820k) {
                            loaderInfo.m6362b(loaderInfo.f3813d, loaderInfo.f3816g);
                        }
                    }
                }
                loaderManagerImpl.m6339g();
            }
        }
        LogUtils.c(1296390606, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -148133936);
        super.onStop();
        this.f77g = true;
        this.f71a.sendEmptyMessage(1);
        this.f72b.m6276r();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 657614596, a);
    }

    public void gE_() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.f80j = true;
        }
        this.f72b.m6282x();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f75e);
        printWriter.print("mResumed=");
        printWriter.print(this.f76f);
        printWriter.print(" mStopped=");
        printWriter.print(this.f77g);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f78h);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f82l);
        if (this.f84n != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f84n)));
            printWriter.println(":");
            this.f84n.m6332a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f72b.mo847a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m180a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String m179a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                stringBuilder.append('I');
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static void m180a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m179a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m180a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final void m187a(boolean z) {
        if (!this.f78h) {
            this.f78h = true;
            this.f79i = z;
            this.f71a.removeMessages(1);
            if (this.f82l) {
                this.f82l = false;
                if (this.f84n != null) {
                    if (this.f79i) {
                        this.f84n.m6338d();
                    } else {
                        this.f84n.m6337c();
                    }
                }
            }
            this.f72b.m6277s();
        }
    }

    public void mo819a(Fragment fragment) {
    }

    public FragmentManager kO_() {
        return this.f72b;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void mo2565a(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            this.f72b.m6246b(0);
            int i2 = fragment.f129q;
            if ((-65536 & i2) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for fragment ID");
            }
            super.startActivityForResult(intent, (i2 << 16) + (65535 & i));
        }
    }

    public final LoaderManagerImpl m183a(String str, boolean z, boolean z2) {
        if (this.f83m == null) {
            this.f83m = new SimpleArrayMap();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f83m.get(str);
        if (loaderManagerImpl != null) {
            loaderManagerImpl.f3796e = mo800m();
            return loaderManagerImpl;
        } else if (!z2) {
            return loaderManagerImpl;
        } else {
            loaderManagerImpl = new LoaderManagerImpl(str, mo800m(), z);
            this.f83m.put(str, loaderManagerImpl);
            return loaderManagerImpl;
        }
    }

    private FragmentHost mo800m() {
        if (this.f85o == null) {
            this.f85o = new FragmentActivityHost(this);
        }
        return this.f85o;
    }
}
