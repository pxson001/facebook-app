package android.support.v4.app;

/* compiled from: wilde_group_profile_upsell */
class FragmentManagerImpl$2 implements Runnable {
    final /* synthetic */ FragmentManagerImpl f63a;

    FragmentManagerImpl$2(FragmentManagerImpl fragmentManagerImpl) {
        this.f63a = fragmentManagerImpl;
    }

    public void run() {
        FragmentManagerImpl fragmentManagerImpl = this.f63a;
        FragmentHost fragmentHost = this.f63a.n;
        fragmentManagerImpl.a(null, -1, 0);
    }
}
