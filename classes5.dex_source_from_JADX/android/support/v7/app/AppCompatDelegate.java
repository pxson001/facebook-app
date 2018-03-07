package android.support.v7.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* compiled from: userIdToDeleteOnExit cannot be null for logout */
public abstract class AppCompatDelegate {
    public abstract ActionBar mo203a();

    public abstract View mo208a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public abstract void mo209a(int i);

    public abstract void mo204a(Bundle bundle);

    public abstract void mo210a(View view);

    public abstract void mo211a(View view, LayoutParams layoutParams);

    public abstract MenuInflater mo205b();

    public abstract void mo216b(View view, LayoutParams layoutParams);

    public abstract boolean mo217b(int i);

    public abstract void mo219c();

    public abstract void mo221d();

    public abstract void mo206e();

    AppCompatDelegate() {
    }
}
