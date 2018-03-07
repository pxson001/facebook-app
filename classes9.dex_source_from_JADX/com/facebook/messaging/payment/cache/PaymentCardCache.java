package com.facebook.messaging.payment.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.messaging.payment.model.PaymentCard;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: interest_ids */
public class PaymentCardCache implements IHaveUserData {
    private static final Object f12819d = new Object();
    private Optional<ImmutableList<PaymentCard>> f12820a = Absent.INSTANCE;
    private ImmutableList<PaymentCard> f12821b = RegularImmutableList.a;
    public Optional<PaymentCard> f12822c;

    private static PaymentCardCache m13160f() {
        return new PaymentCardCache();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.cache.PaymentCardCache m13157a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006b }
        r1 = f12819d;	 Catch:{ all -> 0x006b }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006b }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006b }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007b;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0066 }
        r6.e();	 Catch:{ all -> 0x0061 }
        r1 = m13160f();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f12819d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.cache.PaymentCardCache) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.messaging.payment.cache.PaymentCardCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0066:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006b:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0070:
        r0 = f12819d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.cache.PaymentCardCache) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.cache.PaymentCardCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.cache.PaymentCardCache");
    }

    @Nullable
    public final synchronized Optional<PaymentCard> m13161a() {
        return this.f12822c;
    }

    public final synchronized void m13163a(PaymentCard paymentCard) {
        this.f12822c = Optional.of(paymentCard);
    }

    public final synchronized Optional<PaymentCard> m13162a(long j) {
        Optional<PaymentCard> of;
        if (this.f12820a.isPresent()) {
            ImmutableList immutableList = (ImmutableList) this.f12820a.get();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PaymentCard paymentCard = (PaymentCard) immutableList.get(i);
                if (paymentCard.m13511m() == j) {
                    of = Optional.of(paymentCard);
                    break;
                }
            }
            of = Absent.withType();
        } else {
            of = Absent.withType();
        }
        return of;
    }

    public final synchronized Optional<ImmutableList<PaymentCard>> m13165b() {
        return this.f12820a;
    }

    public final synchronized void m13166b(long j) {
        if (this.f12822c != null && this.f12822c.isPresent() && j == ((PaymentCard) this.f12822c.get()).m13511m()) {
            m13169d();
        }
        if (this.f12820a.isPresent()) {
            Builder builder = new Builder();
            ImmutableList immutableList = (ImmutableList) this.f12820a.get();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PaymentCard paymentCard = (PaymentCard) immutableList.get(i);
                if (paymentCard.m13511m() != j) {
                    builder.c(paymentCard);
                }
            }
            this.f12820a = Optional.of(builder.b());
        }
    }

    public final synchronized void m13164a(ImmutableList<PaymentCard> immutableList) {
        this.f12820a = Optional.of(immutableList);
    }

    private Optional<PaymentCard> m13158d(long j) {
        int size = this.f12821b.size();
        for (int i = 0; i < size; i++) {
            PaymentCard paymentCard = (PaymentCard) this.f12821b.get(i);
            if (paymentCard.f13202a == j) {
                return Optional.of(paymentCard);
            }
        }
        return Absent.INSTANCE;
    }

    public final synchronized void m13167b(PaymentCard paymentCard) {
        if (!m13158d(paymentCard.m13511m()).isPresent()) {
            Builder builder = new Builder();
            builder.b(this.f12821b);
            builder.c(paymentCard);
            this.f12821b = builder.b();
        }
    }

    public final Optional<PaymentCard> m13168c(long j) {
        Optional<PaymentCard> a = m13162a(j);
        return a.isPresent() ? a : m13158d(j);
    }

    public void clearUserData() {
        m13159e();
    }

    private synchronized void m13159e() {
        this.f12820a = Absent.withType();
        this.f12821b = ImmutableList.of();
        m13169d();
    }

    public final synchronized void m13169d() {
        this.f12822c = Absent.withType();
    }
}
