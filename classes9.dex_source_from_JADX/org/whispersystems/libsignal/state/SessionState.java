package org.whispersystems.libsignal.state;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessage;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.DjbECPublicKey;
import org.whispersystems.libsignal.ecc.ECKeyPair;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.kdf.HKDF;
import org.whispersystems.libsignal.logging.Log;
import org.whispersystems.libsignal.ratchet.ChainKey;
import org.whispersystems.libsignal.ratchet.MessageKeys;
import org.whispersystems.libsignal.ratchet.RootKey;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Builder;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure.Chain.MessageKey;
import org.whispersystems.libsignal.state.StorageProtos.SessionStructure.PendingPreKey;
import org.whispersystems.libsignal.util.Pair;
import org.whispersystems.libsignal.util.guava.Optional;

/* compiled from: actionType */
public class SessionState {
    public SessionStructure f21362a;

    /* compiled from: actionType */
    public class UnacknowledgedPreKeyMessageItems {
        private final Optional<Integer> f21359a;
        private final int f21360b;
        private final DjbECPublicKey f21361c;

        public UnacknowledgedPreKeyMessageItems(Optional<Integer> optional, int i, ECPublicKey eCPublicKey) {
            this.f21359a = optional;
            this.f21360b = i;
            this.f21361c = eCPublicKey;
        }

        public final Optional<Integer> m21915a() {
            return this.f21359a;
        }

        public final int m21916b() {
            return this.f21360b;
        }

        public final DjbECPublicKey m21917c() {
            return this.f21361c;
        }
    }

    public SessionState() {
        this.f21362a = Builder.m22085x().m22116l();
    }

    public SessionState(SessionStructure sessionStructure) {
        this.f21362a = sessionStructure;
    }

    public SessionState(SessionState sessionState) {
        this.f21362a = sessionState.f21362a.m22342O().m22116l();
    }

    public final byte[] m21935b() {
        return this.f21362a.aliceBaseKey_.m20185d();
    }

    public final void m21927a(byte[] bArr) {
        this.f21362a = this.f21362a.m22342O().m22108d(ByteString.m20174a(bArr)).m22116l();
    }

    public final void m21919a(int i) {
        this.f21362a = this.f21362a.m22342O().m22089a(i).m22116l();
    }

    public final int m21936c() {
        int i = this.f21362a.sessionVersion_;
        if (i == 0) {
            return 2;
        }
        return i;
    }

    public final void m21920a(IdentityKey identityKey) {
        this.f21362a = this.f21362a.m22342O().m22099b(ByteString.m20174a(identityKey.m21715b())).m22116l();
    }

    public final void m21933b(IdentityKey identityKey) {
        this.f21362a = this.f21362a.m22342O().m22091a(ByteString.m20174a(identityKey.m21715b())).m22116l();
    }

    public final IdentityKey m21938d() {
        try {
            if (this.f21362a.m22351o()) {
                return new IdentityKey(this.f21362a.m22352p().m20185d(), 0);
            }
            return null;
        } catch (Throwable e) {
            Log.m21752a("SessionRecordV2", e);
            return null;
        }
    }

    public final IdentityKey m21940e() {
        try {
            return new IdentityKey(this.f21362a.m22350n().m20185d(), 0);
        } catch (InvalidKeyException e) {
            throw new AssertionError(e);
        }
    }

    public final int m21941f() {
        return this.f21362a.previousCounter_;
    }

    public final void m21932b(int i) {
        this.f21362a = this.f21362a.m22342O().m22098b(i).m22116l();
    }

    public final RootKey m21942g() {
        return new RootKey(HKDF.m21744a(m21936c()), this.f21362a.rootKey_.m20185d());
    }

    public final void m21925a(RootKey rootKey) {
        this.f21362a = this.f21362a.m22342O().m22105c(ByteString.m20174a(rootKey.f21346b)).m22116l();
    }

    public final DjbECPublicKey m21943h() {
        try {
            return Curve.m21736a(this.f21362a.m22358z().m22242l().m20185d(), 0);
        } catch (InvalidKeyException e) {
            throw new AssertionError(e);
        }
    }

    public final ECKeyPair m21944i() {
        return new ECKeyPair(m21943h(), Curve.m21735a(this.f21362a.senderChain_.senderRatchetKeyPrivate_.m20185d()));
    }

    public final boolean m21928a(DjbECPublicKey djbECPublicKey) {
        return m21918c(djbECPublicKey) != null;
    }

    private Pair<Chain, Integer> m21918c(ECPublicKey eCPublicKey) {
        int i = 0;
        for (Chain chain : this.f21362a.m22339A()) {
            try {
                if (Curve.m21736a(chain.m22242l().m20185d(), 0).equals(eCPublicKey)) {
                    return new Pair(chain, Integer.valueOf(i));
                }
                i++;
            } catch (Throwable e) {
                Log.m21752a("SessionRecordV2", e);
            }
        }
        return null;
    }

    public final ChainKey m21930b(DjbECPublicKey djbECPublicKey) {
        Chain chain = (Chain) m21918c(djbECPublicKey).f21480a;
        if (chain == null) {
            return null;
        }
        return new ChainKey(HKDF.m21744a(m21936c()), chain.chainKey_.key_.m20185d(), chain.chainKey_.index_);
    }

    public final void m21921a(DjbECPublicKey djbECPublicKey, ChainKey chainKey) {
        this.f21362a = this.f21362a.m22342O().m22100b(Chain.Builder.m22125y().m22132a(Chain.ChainKey.Builder.m22155w().m22160a(ByteString.m20174a(chainKey.f21337d)).m22159a(chainKey.f21338e).m22175l()).m22130a(ByteString.m20174a(djbECPublicKey.m21741a())).m22149l()).m22116l();
        if (this.f21362a.receiverChains_.size() > 5) {
            this.f21362a = this.f21362a.m22342O().m22104c(0).m22116l();
        }
    }

    public final void m21923a(ECKeyPair eCKeyPair, ChainKey chainKey) {
        this.f21362a = this.f21362a.m22342O().m22092a(Chain.Builder.m22125y().m22130a(ByteString.m20174a(eCKeyPair.f21262a.m21741a())).m22138b(ByteString.m20174a(eCKeyPair.f21263b.f21260a)).m22132a(Chain.ChainKey.Builder.m22155w().m22160a(ByteString.m20174a(chainKey.f21337d)).m22159a(chainKey.f21338e).m22175l()).m22149l()).m22116l();
    }

    public final ChainKey m21945k() {
        Chain.ChainKey chainKey = this.f21362a.senderChain_.chainKey_;
        return new ChainKey(HKDF.m21744a(m21936c()), chainKey.key_.m20185d(), chainKey.index_);
    }

    public final void m21924a(ChainKey chainKey) {
        this.f21362a = this.f21362a.m22342O().m22092a(this.f21362a.senderChain_.m22243r().m22132a(Chain.ChainKey.Builder.m22155w().m22160a(ByteString.m20174a(chainKey.f21337d)).m22159a(chainKey.f21338e).m22175l()).m22149l()).m22116l();
    }

    public final boolean m21929a(DjbECPublicKey djbECPublicKey, int i) {
        Chain chain = (Chain) m21918c(djbECPublicKey).f21480a;
        if (chain == null) {
            return false;
        }
        for (MessageKey messageKey : chain.messageKeys_) {
            if (messageKey.index_ == i) {
                return true;
            }
        }
        return false;
    }

    public final MessageKeys m21931b(DjbECPublicKey djbECPublicKey, int i) {
        Pair c = m21918c(djbECPublicKey);
        Chain chain = (Chain) c.f21480a;
        if (chain == null) {
            return null;
        }
        MessageKeys messageKeys;
        Iterable linkedList = new LinkedList(chain.messageKeys_);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            MessageKey messageKey = (MessageKey) it.next();
            if (messageKey.index_ == i) {
                MessageKeys messageKeys2 = new MessageKeys(new SecretKeySpec(messageKey.cipherKey_.m20185d(), "AES"), new SecretKeySpec(messageKey.macKey_.m20185d(), "HmacSHA256"), new IvParameterSpec(messageKey.iv_.m20185d()), messageKey.index_);
                it.remove();
                messageKeys = messageKeys2;
                break;
            }
        }
        messageKeys = null;
        GeneratedMessage.Builder r = chain.m22243r();
        if (r.f21406g == null) {
            r.f21405f = Collections.emptyList();
            r.f21400a &= -9;
            r.m20312t();
        } else {
            r.f21406g.m21415e();
        }
        this.f21362a = this.f21362a.m22342O().m22090a(((Integer) c.f21481b).intValue(), r.mo938a(linkedList).m22149l()).m22116l();
        return messageKeys;
    }

    public final void m21922a(DjbECPublicKey djbECPublicKey, MessageKeys messageKeys) {
        int size;
        Pair c = m21918c(djbECPublicKey);
        Chain chain = (Chain) c.f21480a;
        Chain.Builder a = chain.m22243r().m22133a(MessageKey.Builder.m22195u().m22201a(ByteString.m20174a(messageKeys.f21339a.getEncoded())).m22206b(ByteString.m20174a(messageKeys.f21340b.getEncoded())).m22200a(messageKeys.f21342d).m22210c(ByteString.m20174a(messageKeys.f21341c.getIV())).m22218l());
        if (a.f21406g == null) {
            size = a.f21405f.size();
        } else {
            size = a.f21406g.m21412c();
        }
        if (size > 2000) {
            a.m22129a(0);
        }
        this.f21362a = this.f21362a.m22342O().m22090a(((Integer) c.f21481b).intValue(), a.m22149l()).m22116l();
    }

    public final void m21934b(DjbECPublicKey djbECPublicKey, ChainKey chainKey) {
        Pair c = m21918c(djbECPublicKey);
        Chain chain = (Chain) c.f21480a;
        this.f21362a = this.f21362a.m22342O().m22090a(((Integer) c.f21481b).intValue(), chain.m22243r().m22132a(Chain.ChainKey.Builder.m22155w().m22160a(ByteString.m20174a(chainKey.f21337d)).m22159a(chainKey.f21338e).m22175l()).m22149l()).m22116l();
    }

    public final void m21926a(Optional<Integer> optional, int i, ECPublicKey eCPublicKey) {
        PendingPreKey.Builder a = PendingPreKey.Builder.m22295w().m22305b(i).m22300a(ByteString.m20174a(eCPublicKey.m21741a()));
        if (optional.mo939a()) {
            a.m22299a(((Integer) optional.mo940b()).intValue());
        }
        this.f21362a = this.f21362a.m22342O().m22093a(a.m22316l()).m22116l();
    }

    public final boolean m21946l() {
        return this.f21362a.m22340D();
    }

    public final UnacknowledgedPreKeyMessageItems m21947m() {
        try {
            Optional a;
            if (this.f21362a.m22341F().m22328k()) {
                a = Optional.m22417a(Integer.valueOf(this.f21362a.m22341F().m22329l()));
            } else {
                a = Optional.m22419c();
            }
            return new UnacknowledgedPreKeyMessageItems(a, this.f21362a.m22341F().m22330n(), Curve.m21736a(this.f21362a.m22341F().m22331p().m20185d(), 0));
        } catch (InvalidKeyException e) {
            throw new AssertionError(e);
        }
    }

    public final void m21937c(int i) {
        this.f21362a = this.f21362a.m22342O().m22107d(i).m22116l();
    }

    public final void m21939d(int i) {
        this.f21362a = this.f21362a.m22342O().m22110e(i).m22116l();
    }

    public final int m21948o() {
        return this.f21362a.localRegistrationId_;
    }
}
