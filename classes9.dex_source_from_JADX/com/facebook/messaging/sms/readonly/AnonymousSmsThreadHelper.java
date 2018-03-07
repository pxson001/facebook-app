package com.facebook.messaging.sms.readonly;

import android.content.Context;
import com.facebook.messaging.clockskew.EstimatedServerClock;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadParticipantBuilder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryBuilder;
import com.facebook.messaging.sms.abtest.ExperimentsForSmsTakeoverAbTestModule;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.sms.util.SmsContactUtil;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.orca.common.ui.titlebar.DIVEBAR_STATE_CHANGED */
public class AnonymousSmsThreadHelper {
    public static long f17729a = -100;
    public static ThreadKey f17730b = ThreadKey.b(-100);
    private final EstimatedServerClock f17731c;
    private final SmsContactUtil f17732d;
    private final SmsTakeoverMultiverseExperimentHelper f17733e;
    private final SmsPermissionsUtil f17734f;
    private final Context f17735g;
    private ImmutableList<ThreadParticipant> f17736h;
    private ThreadSummary f17737i;

    @Inject
    public AnonymousSmsThreadHelper(EstimatedServerClock estimatedServerClock, SmsContactUtil smsContactUtil, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, SmsPermissionsUtil smsPermissionsUtil, Context context) {
        this.f17731c = estimatedServerClock;
        this.f17732d = smsContactUtil;
        this.f17733e = smsTakeoverMultiverseExperimentHelper;
        this.f17734f = smsPermissionsUtil;
        this.f17735g = context;
    }

    public final ThreadSummary m17687a(long j) {
        return m17684a(j, true);
    }

    @Nullable
    public final ThreadSummary m17686a() {
        if (this.f17733e.k() <= 0) {
            return null;
        }
        if (this.f17737i == null) {
            this.f17737i = m17684a(-1, false);
        }
        return this.f17737i;
    }

    private ThreadSummary m17684a(long j, boolean z) {
        String a;
        long a2 = z ? this.f17731c.a(j) : j;
        if (this.f17734f.m17594b()) {
            a = this.f17733e.a.a(ExperimentsForSmsTakeoverAbTestModule.k, null);
            if (a == null) {
                a = this.f17735g.getString(2131240083);
            }
        } else {
            a = this.f17733e.j();
            if (a == null) {
                a = this.f17735g.getString(2131240084);
            }
        }
        ThreadSummaryBuilder newBuilder = ThreadSummary.newBuilder();
        newBuilder.A = FolderName.INBOX;
        newBuilder = newBuilder;
        newBuilder.a = ThreadKey.b(f17729a);
        newBuilder = newBuilder;
        newBuilder.u = false;
        newBuilder = newBuilder;
        newBuilder.k = a2;
        newBuilder = newBuilder;
        newBuilder.K = j;
        newBuilder = newBuilder;
        newBuilder.l = a2;
        ThreadSummaryBuilder threadSummaryBuilder = newBuilder;
        threadSummaryBuilder.h = m17685b();
        threadSummaryBuilder = threadSummaryBuilder;
        threadSummaryBuilder.p = a;
        threadSummaryBuilder = threadSummaryBuilder;
        if (j == -1) {
            threadSummaryBuilder.U = this.f17733e.k();
        }
        return threadSummaryBuilder.V();
    }

    private ImmutableList<ThreadParticipant> m17685b() {
        if (this.f17736h == null) {
            String a = this.f17733e.a.a(ExperimentsForSmsTakeoverAbTestModule.p, null);
            if (a == null) {
                a = this.f17735g.getString(2131240082);
            }
            ParticipantInfo participantInfo = new ParticipantInfo(new UserKey(Type.EMAIL, ""), a);
            ThreadParticipantBuilder threadParticipantBuilder = new ThreadParticipantBuilder();
            threadParticipantBuilder.a = participantInfo;
            ThreadParticipant f = threadParticipantBuilder.f();
            ThreadParticipantBuilder threadParticipantBuilder2 = new ThreadParticipantBuilder();
            threadParticipantBuilder2.a = this.f17732d.m17713a();
            this.f17736h = ImmutableList.of(f, threadParticipantBuilder2.f());
        }
        return this.f17736h;
    }
}
