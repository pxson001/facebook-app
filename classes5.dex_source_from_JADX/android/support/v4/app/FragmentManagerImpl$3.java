package android.support.v4.app;

/* compiled from: wilde_group_profile_upsell */
class FragmentManagerImpl$3 implements Runnable {
    final /* synthetic */ String f64a;
    final /* synthetic */ int f65b;
    final /* synthetic */ FragmentManagerImpl f66c;

    FragmentManagerImpl$3(FragmentManagerImpl fragmentManagerImpl, String str, int i) {
        this.f66c = fragmentManagerImpl;
        this.f64a = str;
        this.f65b = i;
    }

    public void run() {
        FragmentManagerImpl fragmentManagerImpl = this.f66c;
        FragmentHost fragmentHost = this.f66c.n;
        fragmentManagerImpl.a(this.f64a, -1, this.f65b);
    }
}
