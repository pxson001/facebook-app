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

/* compiled from: suppressed */
public abstract class FragmentHost implements FragmentContainer {
    abstract LoaderManagerImpl mo858a(String str, boolean z, boolean z2);

    abstract void mo859a(Fragment fragment);

    abstract void mo860a(Fragment fragment, Intent intent, int i);

    abstract void mo861a(FragmentManager fragmentManager);

    abstract void mo862a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo);

    abstract void mo863a(String str);

    abstract void mo864a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Context mo865h();

    public abstract Handler mo866i();

    public abstract Window mo867j();

    public abstract Resources mo868k();

    abstract void mo869l();

    public abstract LayoutInflater mo870m();

    abstract boolean mo871n();

    public abstract FragmentManagerImpl mo872o();

    public abstract FragmentManager mo873p();

    public abstract boolean mo874q();

    abstract FragmentManager mo875r();
}
