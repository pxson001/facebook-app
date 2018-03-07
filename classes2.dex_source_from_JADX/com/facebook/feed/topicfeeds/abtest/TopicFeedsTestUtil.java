package com.facebook.feed.topicfeeds.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: should_show_shortcut_banner */
public class TopicFeedsTestUtil {
    public final QeAccessor f4902a;
    private Optional<Boolean> f4903b = Absent.INSTANCE;
    private Optional<Boolean> f4904c = Absent.INSTANCE;
    private Optional<Boolean> f4905d = Absent.INSTANCE;
    private Optional<Boolean> f4906e = Absent.INSTANCE;
    private Optional<Boolean> f4907f = Absent.INSTANCE;
    private Optional<Long> f4908g = Absent.INSTANCE;
    private Optional<Boolean> f4909h = Absent.INSTANCE;
    private Optional<Integer> f4910i = Absent.INSTANCE;
    private Optional<Boolean> f4911j = Absent.INSTANCE;
    private Optional<Boolean> f4912k = Absent.INSTANCE;
    private Optional<Boolean> f4913l = Absent.INSTANCE;
    private Optional<Long> f4914m = Absent.INSTANCE;
    private Optional<Boolean> f4915n = Absent.INSTANCE;
    private Optional<Long> f4916o = Absent.INSTANCE;
    public Optional<Integer> f4917p = Absent.INSTANCE;
    private Optional<Boolean> f4918q = Absent.INSTANCE;

    public static TopicFeedsTestUtil m8789b(InjectorLike injectorLike) {
        return new TopicFeedsTestUtil(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static TopicFeedsTestUtil m8785a(InjectorLike injectorLike) {
        return m8789b(injectorLike);
    }

    @Inject
    public TopicFeedsTestUtil(QeAccessor qeAccessor) {
        this.f4902a = qeAccessor;
    }

    public final boolean m8791a() {
        boolean z = false;
        if (this.f4903b.isPresent()) {
            return ((Boolean) this.f4903b.get()).booleanValue();
        }
        if (m8790p() || this.f4902a.mo596a(ExperimentsForTopicFeedsTestModule.f6710z, false)) {
            z = true;
        }
        this.f4903b = Optional.of(Boolean.valueOf(z));
        return ((Boolean) this.f4903b.get()).booleanValue();
    }

    public final boolean m8792b() {
        if (this.f4905d.isPresent()) {
            return ((Boolean) this.f4905d.get()).booleanValue();
        }
        this.f4905d = m8788a(ExperimentsForTopicFeedsTestModule.f6688d, ExperimentsForTopicFeedsTestModule.f6709y, false);
        return ((Boolean) this.f4905d.get()).booleanValue();
    }

    public final boolean m8793c() {
        if (this.f4906e.isPresent()) {
            return ((Boolean) this.f4906e.get()).booleanValue();
        }
        this.f4906e = m8788a(ExperimentsForTopicFeedsTestModule.f6690f, ExperimentsForTopicFeedsTestModule.f6698n, false);
        return ((Boolean) this.f4906e.get()).booleanValue();
    }

    public final boolean m8794d() {
        if (this.f4907f.isPresent()) {
            return ((Boolean) this.f4907f.get()).booleanValue();
        }
        this.f4907f = m8788a(ExperimentsForTopicFeedsTestModule.f6689e, ExperimentsForTopicFeedsTestModule.f6698n, false);
        return ((Boolean) this.f4907f.get()).booleanValue();
    }

    public final long m8795e() {
        if (this.f4908g.isPresent()) {
            return ((Long) this.f4908g.get()).longValue();
        }
        if (m8790p()) {
            this.f4908g = Optional.of(Long.valueOf(this.f4902a.mo575a(ExperimentsForTopicFeedsTestModule.f6693i, 5000)));
        } else {
            this.f4908g = Optional.of(Long.valueOf(((long) this.f4902a.mo571a(ExperimentsForTopicFeedsTestModule.f6706v, 5.0f)) * 1000));
        }
        return ((Long) this.f4908g.get()).longValue();
    }

    public final boolean m8796f() {
        if (this.f4909h.isPresent()) {
            return ((Boolean) this.f4909h.get()).booleanValue();
        }
        this.f4909h = m8788a(ExperimentsForTopicFeedsTestModule.f6686b, ExperimentsForTopicFeedsTestModule.f6701q, false);
        return ((Boolean) this.f4909h.get()).booleanValue();
    }

    public final int m8797g() {
        if (this.f4910i.isPresent()) {
            return ((Integer) this.f4910i.get()).intValue();
        }
        this.f4910i = m8786a(ExperimentsForTopicFeedsTestModule.f6691g, ExperimentsForTopicFeedsTestModule.f6700p, 3);
        return ((Integer) this.f4910i.get()).intValue();
    }

    public final boolean m8798h() {
        if (this.f4911j.isPresent()) {
            return ((Boolean) this.f4911j.get()).booleanValue();
        }
        this.f4911j = m8788a(ExperimentsForTopicFeedsTestModule.f6685a, ExperimentsForTopicFeedsTestModule.f6699o, false);
        return ((Boolean) this.f4911j.get()).booleanValue();
    }

    public final boolean m8799i() {
        if (this.f4912k.isPresent()) {
            return ((Boolean) this.f4912k.get()).booleanValue();
        }
        this.f4912k = m8788a(ExperimentsForTopicFeedsTestModule.f6687c, ExperimentsForTopicFeedsTestModule.f6709y, false);
        return ((Boolean) this.f4912k.get()).booleanValue();
    }

    public final boolean m8800j() {
        if (this.f4913l.isPresent()) {
            return ((Boolean) this.f4913l.get()).booleanValue();
        }
        this.f4913l = m8788a(ExperimentsForTopicFeedsTestModule.f6683C, ExperimentsForTopicFeedsTestModule.f6708x, false);
        return ((Boolean) this.f4913l.get()).booleanValue();
    }

    public final long m8801k() {
        if (this.f4914m.isPresent()) {
            return ((Long) this.f4914m.get()).longValue();
        }
        this.f4914m = m8787a(ExperimentsForTopicFeedsTestModule.f6682B, ExperimentsForTopicFeedsTestModule.f6707w, 30);
        return ((Long) this.f4914m.get()).longValue();
    }

    public final boolean m8802l() {
        if (this.f4915n.isPresent()) {
            return ((Boolean) this.f4915n.get()).booleanValue();
        }
        this.f4915n = m8788a(ExperimentsForTopicFeedsTestModule.f6681A, ExperimentsForTopicFeedsTestModule.f6704t, false);
        return ((Boolean) this.f4915n.get()).booleanValue();
    }

    private boolean m8790p() {
        if (this.f4904c.isPresent()) {
            return ((Boolean) this.f4904c.get()).booleanValue();
        }
        this.f4904c = Optional.of(Boolean.valueOf(this.f4902a.mo596a(ExperimentsForTopicFeedsTestModule.f6695k, false)));
        return ((Boolean) this.f4904c.get()).booleanValue();
    }

    public final long m8803m() {
        if (this.f4916o.isPresent()) {
            return ((Long) this.f4916o.get()).longValue();
        }
        this.f4916o = Optional.of(Long.valueOf(this.f4902a.mo575a(ExperimentsForTopicFeedsTestModule.f6694j, 1000)));
        return ((Long) this.f4916o.get()).longValue();
    }

    public final boolean m8804o() {
        if (this.f4918q.isPresent()) {
            return ((Boolean) this.f4918q.get()).booleanValue();
        }
        this.f4918q = m8788a(ExperimentsForTopicFeedsTestModule.f6684D, ExperimentsForTopicFeedsTestModule.f6702r, false);
        return ((Boolean) this.f4918q.get()).booleanValue();
    }

    private Optional<Boolean> m8788a(short s, short s2, boolean z) {
        boolean a;
        if (m8790p()) {
            a = this.f4902a.mo596a(s, z);
        } else {
            a = this.f4902a.mo596a(s2, z);
        }
        return Optional.of(Boolean.valueOf(a));
    }

    private Optional<Long> m8787a(long j, long j2, long j3) {
        long a;
        if (m8790p()) {
            a = this.f4902a.mo575a(j, j3);
        } else {
            a = this.f4902a.mo575a(j2, j3);
        }
        return Optional.of(Long.valueOf(a));
    }

    private Optional<Integer> m8786a(int i, int i2, int i3) {
        int a;
        if (m8790p()) {
            a = this.f4902a.mo572a(i, i3);
        } else {
            a = this.f4902a.mo572a(i2, i3);
        }
        return Optional.of(Integer.valueOf(a));
    }
}
