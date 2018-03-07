package android.support.v4.app;

/* compiled from: wilde_group_profile_upsell */
class FragmentManagerImpl$4 implements Runnable {
    final /* synthetic */ int f67a;
    final /* synthetic */ int f68b;
    final /* synthetic */ FragmentManagerImpl f69c;

    FragmentManagerImpl$4(FragmentManagerImpl fragmentManagerImpl, int i, int i2) {
        this.f69c = fragmentManagerImpl;
        this.f67a = i;
        this.f68b = i2;
    }

    public void run() {
        FragmentManagerImpl fragmentManagerImpl = this.f69c;
        FragmentHost fragmentHost = this.f69c.n;
        fragmentManagerImpl.a(null, this.f67a, this.f68b);
    }
}
