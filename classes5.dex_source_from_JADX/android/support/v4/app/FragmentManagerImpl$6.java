package android.support.v4.app;

/* compiled from: wilde_group_profile_upsell */
class FragmentManagerImpl$6 implements Runnable {
    final /* synthetic */ Exception f72a;
    final /* synthetic */ FragmentManagerImpl f73b;

    FragmentManagerImpl$6(FragmentManagerImpl fragmentManagerImpl, Exception exception) {
        this.f73b = fragmentManagerImpl;
        this.f72a = exception;
    }

    public void run() {
        throw new RuntimeException("Re-posting exception from listener", this.f72a);
    }
}
