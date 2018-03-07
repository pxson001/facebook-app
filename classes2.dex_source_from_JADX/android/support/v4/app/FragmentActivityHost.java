package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: suppressed_tracer */
public class FragmentActivityHost extends FragmentHost {
    private final FragmentActivity f3791a;

    public FragmentActivityHost(FragmentActivity fragmentActivity) {
        this.f3791a = fragmentActivity;
    }

    public final Context mo865h() {
        return this.f3791a;
    }

    public final Handler mo866i() {
        return this.f3791a.f71a;
    }

    public final Window mo867j() {
        return this.f3791a.getWindow();
    }

    public final Resources mo868k() {
        return this.f3791a.getResources();
    }

    public final LayoutInflater mo870m() {
        return this.f3791a.getLayoutInflater();
    }

    public final View mo856a(int i) {
        return this.f3791a.findViewById(i);
    }

    public final boolean mo857s() {
        Window window = this.f3791a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public final boolean mo874q() {
        return this.f3791a.isFinishing();
    }

    public final FragmentManager mo873p() {
        return mo872o();
    }

    final FragmentManagerImpl mo872o() {
        return this.f3791a.f72b;
    }

    final void mo859a(Fragment fragment) {
        this.f3791a.mo819a(fragment);
    }

    final boolean mo871n() {
        return this.f3791a.f79i;
    }

    final FragmentManager mo875r() {
        return this.f3791a.f73c;
    }

    final void mo861a(FragmentManager fragmentManager) {
        this.f3791a.m186a(fragmentManager);
    }

    final void mo863a(String str) {
        FragmentActivity fragmentActivity = this.f3791a;
        if (fragmentActivity.f83m != null) {
            LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) fragmentActivity.f83m.get(str);
            if (loaderManagerImpl != null && !loaderManagerImpl.f3798g) {
                loaderManagerImpl.m6340h();
                fragmentActivity.f83m.remove(str);
            }
        }
    }

    final LoaderManagerImpl mo858a(String str, boolean z, boolean z2) {
        return this.f3791a.m183a(str, z, z2);
    }

    final void mo869l() {
        this.f3791a.gE_();
    }

    final void mo862a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        this.f3791a.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    final void mo860a(Fragment fragment, Intent intent, int i) {
        this.f3791a.mo2565a(fragment, intent, i);
    }

    final void mo864a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3791a.dump(str, fileDescriptor, printWriter, strArr);
    }
}
