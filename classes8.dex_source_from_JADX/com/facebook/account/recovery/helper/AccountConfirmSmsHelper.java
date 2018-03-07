package com.facebook.account.recovery.helper;

import com.facebook.account.recovery.fragment.AccountConfirmFragment;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timer.IntervalTimer;
import com.facebook.common.timer.IntervalTimer.IntervalTimerListener;
import com.facebook.common.timer.IntervalTimerProvider;
import com.facebook.confirmation.task.SmsCode;
import com.facebook.confirmation.util.ReadSmsHelper;
import com.facebook.inject.InjectorLike;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: local_content_photo_upload_enabled */
public class AccountConfirmSmsHelper {
    private final Clock f10297a;
    private final ReadSmsHelper f10298b;
    public IntervalTimer f10299c = IntervalTimerProvider.m12621a(Long.valueOf(250), Long.valueOf(250));
    private AccountConfirmFragment f10300d;
    private long f10301e = 0;

    /* compiled from: local_content_photo_upload_enabled */
    class TimerListener implements IntervalTimerListener {
        final /* synthetic */ AccountConfirmSmsHelper f10296a;

        public TimerListener(AccountConfirmSmsHelper accountConfirmSmsHelper) {
            this.f10296a = accountConfirmSmsHelper;
        }

        public final void mo677a(long j) {
        }

        public final void mo676a() {
            AccountConfirmSmsHelper.m12075c(this.f10296a);
        }
    }

    public static AccountConfirmSmsHelper m12074b(InjectorLike injectorLike) {
        return new AccountConfirmSmsHelper((Clock) SystemClockMethodAutoProvider.a(injectorLike), ReadSmsHelper.b(injectorLike), (IntervalTimerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(IntervalTimerProvider.class));
    }

    @Inject
    public AccountConfirmSmsHelper(Clock clock, ReadSmsHelper readSmsHelper, IntervalTimerProvider intervalTimerProvider) {
        this.f10297a = clock;
        this.f10298b = readSmsHelper;
    }

    public final void m12077a(AccountConfirmFragment accountConfirmFragment) {
        this.f10300d = accountConfirmFragment;
        m12076d();
    }

    public final void m12078b() {
        Object obj;
        if (this.f10299c.f10691a != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null && this.f10300d != null && this.f10301e > 0) {
            m12073a(this.f10301e);
        }
    }

    public static void m12075c(AccountConfirmSmsHelper accountConfirmSmsHelper) {
        List a = accountConfirmSmsHelper.f10298b.a(accountConfirmSmsHelper.f10298b.a(accountConfirmSmsHelper.f10301e, (accountConfirmSmsHelper.f10297a.a() - accountConfirmSmsHelper.f10301e) + 250), Collections.emptySet(), Pattern.compile("(^|\\D)(\\d{4,10})($|\\D)"), 2);
        if (a.isEmpty()) {
            accountConfirmSmsHelper.m12076d();
            return;
        }
        AccountConfirmFragment accountConfirmFragment = accountConfirmSmsHelper.f10300d;
        String str = ((SmsCode) a.get(0)).f10806a;
        accountConfirmFragment.aO = accountConfirmFragment.f10240h.a() - accountConfirmFragment.aN;
        AccountConfirmFragment.m12022b(accountConfirmFragment, str);
    }

    private void m12076d() {
        m12073a(this.f10297a.a() - 250);
    }

    private void m12073a(long j) {
        this.f10301e = j;
        this.f10299c.m12619c();
    }
}
