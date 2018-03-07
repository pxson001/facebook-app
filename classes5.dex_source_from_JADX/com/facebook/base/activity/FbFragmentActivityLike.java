package com.facebook.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.dispose.AbstractListenableDisposable;
import com.facebook.inject.FbInjector;
import java.util.Set;

/* compiled from: suggest_text_1 */
public interface FbFragmentActivityLike extends ListenableActivity {
    <T> T mo505a(Class<? extends T> cls);

    Object mo506a(Object obj);

    void mo507a();

    @TargetApi(14)
    void mo508a(int i);

    void mo509a(int i, int i2, Intent intent);

    void mo510a(int i, Dialog dialog);

    void mo511a(Activity activity);

    void mo512a(Intent intent);

    void mo513a(Intent intent, int i);

    void mo514a(Configuration configuration);

    void mo515a(Bundle bundle);

    void mo516a(Fragment fragment);

    void mo517a(Fragment fragment, Intent intent, int i);

    void mo518a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo);

    void mo519a(AbstractListenableDisposable abstractListenableDisposable);

    void mo520a(Object obj, Object obj2);

    void mo521a(boolean z);

    boolean mo522a(int i, KeyEvent keyEvent);

    boolean mo523a(KeyEvent keyEvent);

    boolean mo524a(Menu menu);

    boolean mo525a(MenuItem menuItem);

    boolean mo526a(MotionEvent motionEvent);

    boolean mo527a(Throwable th);

    Dialog mo528b(int i);

    void mo529b();

    void mo530b(Intent intent);

    void mo531b(Bundle bundle);

    boolean mo532b(int i, KeyEvent keyEvent);

    boolean mo533b(Menu menu);

    boolean mo534b(MenuItem menuItem);

    <T extends View> T mo535c(int i);

    void mo536c();

    void mo537c(Intent intent);

    void mo538c(Bundle bundle);

    View mo539d(int i);

    void mo540d();

    void mo541d(Bundle bundle);

    void mo542e();

    void mo543e(int i);

    void mo544f();

    void mo545f(int i);

    void mo546g();

    void mo547h();

    void mo548i();

    boolean mo549j();

    void mo550k();

    void mo551l();

    void mo552m();

    @Deprecated
    FbInjector mo553n();

    Set<ActivityListener> mo554o();

    void mo555p();

    void mo556q();

    FragmentManager mo557r();

    Window mo558s();

    Intent mo559t();

    Resources mo560u();

    MenuInflater mo561v();

    boolean mo562w();
}
