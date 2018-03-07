package com.facebook.messaging.sync.model.thrift;

import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.TUnion;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolUtil;
import com.facebook.thrift.protocol.TStruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: transferId */
public class DeltaWrapper extends TUnion {
    private static final TField f2675A = new TField("deltaDeliveryReceipt", (byte) 12, (short) 25);
    private static final TField f2676B = new TField("deltaP2PPaymentMessage", (byte) 12, (short) 26);
    private static final TField f2677C = new TField("deltaFolderCount", (byte) 12, (short) 27);
    private static final TField f2678D = new TField("deltaPagesManagerEvent", (byte) 12, (short) 28);
    private static final TField f2679E = new TField("deltaNotificationSettings", (byte) 12, (short) 29);
    private static final TField f2680F = new TField("deltaReplaceMessage", (byte) 12, (short) 30);
    private static final TField f2681G = new TField("deltaZeroRating", (byte) 12, (short) 31);
    private static final TField f2682H = new TField("deltaMontageMessage", (byte) 12, (short) 32);
    private static final TField f2683I = new TField("deltaGenieMessage", (byte) 12, (short) 33);
    private static final TField f2684J = new TField("deltaGenericMapMutation", (byte) 12, (short) 34);
    private static final TField f2685K = new TField("deltaAdminAddedToGroupThread", (byte) 12, (short) 35);
    private static final TField f2686L = new TField("deltaAdminRemovedFromGroupThread", (byte) 12, (short) 36);
    private static final TField f2687M = new TField("deltaRtcCallData", (byte) 12, (short) 37);
    private static final TField f2688N = new TField("deltaJoinableMode", (byte) 12, (short) 38);
    private static final TField f2689O = new TField("deltaApprovalMode", (byte) 12, (short) 39);
    private static final TField f2690P = new TField("deltaApprovalQueue", (byte) 12, (short) 40);
    public static boolean f2691a = true;
    private static final TStruct f2692b = new TStruct("DeltaWrapper");
    private static final TField f2693c = new TField("deltaNoOp", (byte) 12, (short) 1);
    private static final TField f2694d = new TField("deltaNewMessage", (byte) 12, (short) 2);
    private static final TField f2695e = new TField("deltaNewGroupThread", (byte) 12, (short) 3);
    private static final TField f2696f = new TField("deltaMarkRead", (byte) 12, (short) 4);
    private static final TField f2697g = new TField("deltaMarkUnread", (byte) 12, (short) 5);
    private static final TField f2698h = new TField("deltaMessageDelete", (byte) 12, (short) 6);
    private static final TField f2699i = new TField("deltaThreadDelete", (byte) 12, (short) 7);
    private static final TField f2700j = new TField("deltaParticipantsAddedToGroupThread", (byte) 12, (short) 8);
    private static final TField f2701k = new TField("deltaParticipantLeftGroupThread", (byte) 12, (short) 9);
    private static final TField f2702l = new TField("deltaThreadName", (byte) 12, (short) 10);
    private static final TField f2703m = new TField("deltaThreadImage", (byte) 12, (short) 11);
    private static final TField f2704n = new TField("deltaThreadMuteSettings", (byte) 12, (short) 12);
    private static final TField f2705o = new TField("deltaThreadAction", (byte) 12, (short) 13);
    private static final TField f2706p = new TField("deltaThreadFolder", (byte) 12, (short) 14);
    private static final TField f2707q = new TField("deltaRTCEventLog", (byte) 12, (short) 15);
    private static final TField f2708r = new TField("deltaVideoCall", (byte) 12, (short) 16);
    private static final TField f2709s = new TField("deltaAdminTextMessage", (byte) 12, (short) 17);
    private static final TField f2710t = new TField("deltaForcedFetch", (byte) 12, (short) 18);
    private static final TField f2711u = new TField("deltaReadReceipt", (byte) 12, (short) 19);
    private static final TField f2712v = new TField("deltaBroadcastMessage", (byte) 12, (short) 20);
    private static final TField f2713w = new TField("deltaMarkFolderSeen", (byte) 12, (short) 21);
    private static final TField f2714x = new TField("deltaSentMessage", (byte) 12, (short) 22);
    private static final TField f2715y = new TField("deltaPinnedGroups", (byte) 12, (short) 23);
    private static final TField f2716z = new TField("deltaPageAdminReply", (byte) 12, (short) 24);

    private DeltaNewGroupThread m3830I() {
        if (this.setField_ == 3) {
            return (DeltaNewGroupThread) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaNewGroupThread' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaVideoCall m3831J() {
        if (this.setField_ == 16) {
            return (DeltaVideoCall) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaVideoCall' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaMarkFolderSeen m3832K() {
        if (this.setField_ == 21) {
            return (DeltaMarkFolderSeen) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaMarkFolderSeen' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaPinnedGroups m3833L() {
        if (this.setField_ == 23) {
            return (DeltaPinnedGroups) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPinnedGroups' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaPageAdminReply m3834M() {
        if (this.setField_ == 24) {
            return (DeltaPageAdminReply) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPageAdminReply' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaPagesManagerEvent m3835N() {
        if (this.setField_ == 28) {
            return (DeltaPagesManagerEvent) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaPagesManagerEvent' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaNotificationSettings m3836O() {
        if (this.setField_ == 29) {
            return (DeltaNotificationSettings) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaNotificationSettings' because union is currently set to " + mo154a(this.setField_).a);
    }

    private DeltaGenericMapMutation m3837P() {
        if (this.setField_ == 34) {
            return (DeltaGenericMapMutation) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaGenericMapMutation' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaMontageMessage m3839A() {
        if (this.setField_ == 32) {
            return (DeltaMontageMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaMontageMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaGenieMessage m3840B() {
        if (this.setField_ == 33) {
            return (DeltaGenieMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaGenieMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaAdminAddedToGroupThread m3841C() {
        if (this.setField_ == 35) {
            return (DeltaAdminAddedToGroupThread) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaAdminAddedToGroupThread' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaAdminRemovedFromGroupThread m3842D() {
        if (this.setField_ == 36) {
            return (DeltaAdminRemovedFromGroupThread) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaAdminRemovedFromGroupThread' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaRtcCallData m3843E() {
        if (this.setField_ == 37) {
            return (DeltaRtcCallData) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaRtcCallData' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaJoinableMode m3844F() {
        if (this.setField_ == 38) {
            return (DeltaJoinableMode) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaJoinableMode' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaApprovalMode m3845G() {
        if (this.setField_ == 39) {
            return (DeltaApprovalMode) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaApprovalMode' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaApprovalQueue m3846H() {
        if (this.setField_ == 40) {
            return (DeltaApprovalQueue) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaApprovalQueue' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaNoOp m3851c() {
        if (this.setField_ == 1) {
            return (DeltaNoOp) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaNoOp' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaNewMessage m3852d() {
        if (this.setField_ == 2) {
            return (DeltaNewMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaNewMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaMarkRead m3853e() {
        if (this.setField_ == 4) {
            return (DeltaMarkRead) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaMarkRead' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaMarkUnread m3854f() {
        if (this.setField_ == 5) {
            return (DeltaMarkUnread) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaMarkUnread' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaMessageDelete m3855g() {
        if (this.setField_ == 6) {
            return (DeltaMessageDelete) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaMessageDelete' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaThreadDelete m3856h() {
        if (this.setField_ == 7) {
            return (DeltaThreadDelete) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaThreadDelete' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaParticipantsAddedToGroupThread m3857i() {
        if (this.setField_ == 8) {
            return (DeltaParticipantsAddedToGroupThread) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaParticipantsAddedToGroupThread' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaParticipantLeftGroupThread m3858j() {
        if (this.setField_ == 9) {
            return (DeltaParticipantLeftGroupThread) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaParticipantLeftGroupThread' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaThreadName m3859k() {
        if (this.setField_ == 10) {
            return (DeltaThreadName) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaThreadName' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaThreadImage m3860l() {
        if (this.setField_ == 11) {
            return (DeltaThreadImage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaThreadImage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaThreadMuteSettings m3861m() {
        if (this.setField_ == 12) {
            return (DeltaThreadMuteSettings) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaThreadMuteSettings' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaThreadAction m3862n() {
        if (this.setField_ == 13) {
            return (DeltaThreadAction) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaThreadAction' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaThreadFolder m3863o() {
        if (this.setField_ == 14) {
            return (DeltaThreadFolder) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaThreadFolder' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaRTCEventLog m3864p() {
        if (this.setField_ == 15) {
            return (DeltaRTCEventLog) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaRTCEventLog' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaAdminTextMessage m3865q() {
        if (this.setField_ == 17) {
            return (DeltaAdminTextMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaAdminTextMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaForcedFetch m3866r() {
        if (this.setField_ == 18) {
            return (DeltaForcedFetch) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaForcedFetch' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaReadReceipt m3867s() {
        if (this.setField_ == 19) {
            return (DeltaReadReceipt) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaReadReceipt' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaBroadcastMessage m3868t() {
        if (this.setField_ == 20) {
            return (DeltaBroadcastMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaBroadcastMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaSentMessage m3869u() {
        if (this.setField_ == 22) {
            return (DeltaSentMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaSentMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaDeliveryReceipt m3870v() {
        if (this.setField_ == 25) {
            return (DeltaDeliveryReceipt) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaDeliveryReceipt' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaP2PPaymentMessage m3871w() {
        if (this.setField_ == 26) {
            return (DeltaP2PPaymentMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaP2PPaymentMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaFolderCount m3872x() {
        if (this.setField_ == 27) {
            return (DeltaFolderCount) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaFolderCount' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaReplaceMessage m3873y() {
        if (this.setField_ == 30) {
            return (DeltaReplaceMessage) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaReplaceMessage' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final DeltaZeroRating m3874z() {
        if (this.setField_ == 31) {
            return (DeltaZeroRating) this.value_;
        }
        throw new RuntimeException("Cannot get field 'deltaZeroRating' because union is currently set to " + mo154a(this.setField_).a);
    }

    public final Object mo155a(TProtocol tProtocol, TField tField) {
        Integer num;
        TField f;
        switch (tField.c) {
            case (short) 1:
                if (tField.b == f2693c.b) {
                    num = null;
                    tProtocol.r();
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 8) {
                                        TProtocolUtil.m7816a(tProtocol, f.b);
                                        break;
                                    }
                                    num = Integer.valueOf(tProtocol.m());
                                    break;
                                default:
                                    TProtocolUtil.m7816a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaNoOp(num);
                    }
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 2:
                if (tField.b == f2694d.b) {
                    return DeltaNewMessage.m3748b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 3:
                if (tField.b == f2695e.b) {
                    List list = null;
                    tProtocol.r();
                    ThreadKey threadKey = null;
                    while (true) {
                        TField f2 = tProtocol.f();
                        if (f2.b != (byte) 0) {
                            switch (f2.c) {
                                case (short) 1:
                                    if (f2.b != (byte) 12) {
                                        TProtocolUtil.m7816a(tProtocol, f2.b);
                                        break;
                                    }
                                    threadKey = ThreadKey.m3936b(tProtocol);
                                    break;
                                case (short) 2:
                                    if (f2.b != (byte) 15) {
                                        TProtocolUtil.m7816a(tProtocol, f2.b);
                                        break;
                                    }
                                    TList h = tProtocol.h();
                                    List arrayList = new ArrayList(Math.max(0, h.b));
                                    int i = 0;
                                    while (true) {
                                        if (h.b < 0) {
                                            if (!TProtocol.t()) {
                                                list = arrayList;
                                                break;
                                            }
                                        } else if (i >= h.b) {
                                            list = arrayList;
                                        }
                                        arrayList.add(ParticipantInfo.m3925b(tProtocol));
                                        i++;
                                    }
                                default:
                                    TProtocolUtil.m7816a(tProtocol, f2.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaNewGroupThread(threadKey, list);
                    }
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 4:
                if (tField.b == f2696f.b) {
                    return DeltaMarkRead.m3732b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 5:
                if (tField.b == f2697g.b) {
                    return DeltaMarkUnread.m3735b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 6:
                if (tField.b == f2698h.b) {
                    return DeltaMessageDelete.m3738b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 7:
                if (tField.b == f2699i.b) {
                    return DeltaThreadDelete.m3803b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 8:
                if (tField.b == f2700j.b) {
                    return DeltaParticipantsAddedToGroupThread.m3774b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 9:
                if (tField.b == f2701k.b) {
                    return DeltaParticipantLeftGroupThread.m3770b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 10:
                if (tField.b == f2702l.b) {
                    return DeltaThreadName.m3818b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 11:
                if (tField.b == f2703m.b) {
                    return DeltaThreadImage.m3811b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 12:
                if (tField.b == f2704n.b) {
                    return DeltaThreadMuteSettings.m3814b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 13:
                if (tField.b == f2705o.b) {
                    return DeltaThreadAction.m3800b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 14:
                if (tField.b == f2706p.b) {
                    return DeltaThreadFolder.m3807b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 15:
                if (tField.b == f2707q.b) {
                    return DeltaRTCEventLog.m3781b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 16:
                if (tField.b == f2708r.b) {
                    return DeltaVideoCall.m3822b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 17:
                if (tField.b == f2709s.b) {
                    return DeltaAdminTextMessage.m3693b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 18:
                if (tField.b == f2710t.b) {
                    return DeltaForcedFetch.m3714b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 19:
                if (tField.b == f2711u.b) {
                    return DeltaReadReceipt.m3784b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 20:
                if (tField.b == f2712v.b) {
                    return DeltaBroadcastMessage.m3704b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 21:
                if (tField.b == f2713w.b) {
                    return DeltaMarkFolderSeen.m3729b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 22:
                if (tField.b == f2714x.b) {
                    return DeltaSentMessage.m3796b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 23:
                if (tField.b == f2715y.b) {
                    return DeltaPinnedGroups.m3777b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 24:
                if (tField.b == f2716z.b) {
                    return DeltaPageAdminReply.m3762b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 25:
                if (tField.b == f2675A.b) {
                    return DeltaDeliveryReceipt.m3707b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 26:
                if (tField.b == f2676B.b) {
                    return DeltaP2PPaymentMessage.m3758b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 27:
                if (tField.b == f2677C.b) {
                    return DeltaFolderCount.m3711b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 28:
                if (tField.b == f2678D.b) {
                    return DeltaPagesManagerEvent.m3766b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 29:
                if (tField.b == f2679E.b) {
                    return DeltaNotificationSettings.m3754b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 30:
                if (tField.b == f2680F.b) {
                    return DeltaReplaceMessage.m3788b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 31:
                if (tField.b == f2681G.b) {
                    num = null;
                    tProtocol.r();
                    while (true) {
                        f = tProtocol.f();
                        if (f.b != (byte) 0) {
                            switch (f.c) {
                                case (short) 1:
                                    if (f.b != (byte) 8) {
                                        TProtocolUtil.m7816a(tProtocol, f.b);
                                        break;
                                    }
                                    num = Integer.valueOf(tProtocol.m());
                                    break;
                                default:
                                    TProtocolUtil.m7816a(tProtocol, f.b);
                                    break;
                            }
                        }
                        tProtocol.e();
                        return new DeltaZeroRating(num);
                    }
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 32:
                if (tField.b == f2682H.b) {
                    return DeltaMontageMessage.m3742b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 33:
                if (tField.b == f2683I.b) {
                    return DeltaGenieMessage.m3722b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 34:
                if (tField.b == f2684J.b) {
                    return DeltaGenericMapMutation.m3718b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 35:
                if (tField.b == f2685K.b) {
                    return DeltaAdminAddedToGroupThread.m3685b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 36:
                if (tField.b == f2686L.b) {
                    return DeltaAdminRemovedFromGroupThread.m3689b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 37:
                if (tField.b == f2687M.b) {
                    return DeltaRtcCallData.m3792b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 38:
                if (tField.b == f2688N.b) {
                    return DeltaJoinableMode.m3726b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 39:
                if (tField.b == f2689O.b) {
                    return DeltaApprovalMode.m3697b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            case (short) 40:
                if (tField.b == f2690P.b) {
                    return DeltaApprovalQueue.m3701b(tProtocol);
                }
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
            default:
                TProtocolUtil.m7816a(tProtocol, tField.b);
                return null;
        }
    }

    protected final void mo156a(TProtocol tProtocol, short s) {
        switch (s) {
            case (short) 1:
                ((DeltaNoOp) this.value_).m3753a(tProtocol);
                return;
            case (short) 2:
                ((DeltaNewMessage) this.value_).m3750a(tProtocol);
                return;
            case (short) 3:
                ((DeltaNewGroupThread) this.value_).m3746a(tProtocol);
                return;
            case (short) 4:
                ((DeltaMarkRead) this.value_).m3734a(tProtocol);
                return;
            case (short) 5:
                ((DeltaMarkUnread) this.value_).m3737a(tProtocol);
                return;
            case (short) 6:
                ((DeltaMessageDelete) this.value_).m3740a(tProtocol);
                return;
            case (short) 7:
                ((DeltaThreadDelete) this.value_).m3805a(tProtocol);
                return;
            case (short) 8:
                ((DeltaParticipantsAddedToGroupThread) this.value_).m3776a(tProtocol);
                return;
            case (short) 9:
                ((DeltaParticipantLeftGroupThread) this.value_).m3772a(tProtocol);
                return;
            case (short) 10:
                ((DeltaThreadName) this.value_).m3820a(tProtocol);
                return;
            case (short) 11:
                ((DeltaThreadImage) this.value_).m3813a(tProtocol);
                return;
            case (short) 12:
                ((DeltaThreadMuteSettings) this.value_).m3816a(tProtocol);
                return;
            case (short) 13:
                ((DeltaThreadAction) this.value_).m3802a(tProtocol);
                return;
            case (short) 14:
                ((DeltaThreadFolder) this.value_).m3809a(tProtocol);
                return;
            case (short) 15:
                ((DeltaRTCEventLog) this.value_).m3783a(tProtocol);
                return;
            case (short) 16:
                ((DeltaVideoCall) this.value_).m3824a(tProtocol);
                return;
            case (short) 17:
                ((DeltaAdminTextMessage) this.value_).m3695a(tProtocol);
                return;
            case (short) 18:
                ((DeltaForcedFetch) this.value_).m3716a(tProtocol);
                return;
            case (short) 19:
                ((DeltaReadReceipt) this.value_).m3786a(tProtocol);
                return;
            case (short) 20:
                ((DeltaBroadcastMessage) this.value_).m3706a(tProtocol);
                return;
            case (short) 21:
                ((DeltaMarkFolderSeen) this.value_).m3731a(tProtocol);
                return;
            case (short) 22:
                ((DeltaSentMessage) this.value_).m3798a(tProtocol);
                return;
            case (short) 23:
                ((DeltaPinnedGroups) this.value_).m3779a(tProtocol);
                return;
            case (short) 24:
                ((DeltaPageAdminReply) this.value_).m3764a(tProtocol);
                return;
            case (short) 25:
                ((DeltaDeliveryReceipt) this.value_).m3709a(tProtocol);
                return;
            case (short) 26:
                ((DeltaP2PPaymentMessage) this.value_).m3760a(tProtocol);
                return;
            case (short) 27:
                ((DeltaFolderCount) this.value_).m3713a(tProtocol);
                return;
            case (short) 28:
                ((DeltaPagesManagerEvent) this.value_).m3768a(tProtocol);
                return;
            case (short) 29:
                ((DeltaNotificationSettings) this.value_).m3756a(tProtocol);
                return;
            case (short) 30:
                ((DeltaReplaceMessage) this.value_).m3790a(tProtocol);
                return;
            case (short) 31:
                ((DeltaZeroRating) this.value_).m3876a(tProtocol);
                return;
            case (short) 32:
                ((DeltaMontageMessage) this.value_).m3744a(tProtocol);
                return;
            case (short) 33:
                ((DeltaGenieMessage) this.value_).m3724a(tProtocol);
                return;
            case (short) 34:
                ((DeltaGenericMapMutation) this.value_).m3720a(tProtocol);
                return;
            case (short) 35:
                ((DeltaAdminAddedToGroupThread) this.value_).m3687a(tProtocol);
                return;
            case (short) 36:
                ((DeltaAdminRemovedFromGroupThread) this.value_).m3691a(tProtocol);
                return;
            case (short) 37:
                ((DeltaRtcCallData) this.value_).m3794a(tProtocol);
                return;
            case (short) 38:
                ((DeltaJoinableMode) this.value_).m3728a(tProtocol);
                return;
            case (short) 39:
                ((DeltaApprovalMode) this.value_).m3699a(tProtocol);
                return;
            case (short) 40:
                ((DeltaApprovalQueue) this.value_).m3703a(tProtocol);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + s);
        }
    }

    protected final TField mo154a(int i) {
        switch (i) {
            case 1:
                return f2693c;
            case 2:
                return f2694d;
            case 3:
                return f2695e;
            case 4:
                return f2696f;
            case 5:
                return f2697g;
            case 6:
                return f2698h;
            case 7:
                return f2699i;
            case 8:
                return f2700j;
            case 9:
                return f2701k;
            case 10:
                return f2702l;
            case 11:
                return f2703m;
            case 12:
                return f2704n;
            case 13:
                return f2705o;
            case 14:
                return f2706p;
            case 15:
                return f2707q;
            case 16:
                return f2708r;
            case 17:
                return f2709s;
            case 18:
                return f2710t;
            case 19:
                return f2711u;
            case 20:
                return f2712v;
            case 21:
                return f2713w;
            case 22:
                return f2714x;
            case 23:
                return f2715y;
            case 24:
                return f2716z;
            case 25:
                return f2675A;
            case 26:
                return f2676B;
            case 27:
                return f2677C;
            case 28:
                return f2678D;
            case 29:
                return f2679E;
            case 30:
                return f2680F;
            case 31:
                return f2681G;
            case 32:
                return f2682H;
            case 33:
                return f2683I;
            case 34:
                return f2684J;
            case 35:
                return f2685K;
            case 36:
                return f2686L;
            case 37:
                return f2687M;
            case 38:
                return f2688N;
            case 39:
                return f2689O;
            case 40:
                return f2690P;
            default:
                throw new IllegalArgumentException("Unknown field id " + i);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DeltaWrapper)) {
            return false;
        }
        boolean z;
        DeltaWrapper deltaWrapper = (DeltaWrapper) obj;
        if (this.setField_ != deltaWrapper.setField_ || ((this.value_ instanceof byte[]) ? Arrays.equals((byte[]) this.value_, (byte[]) deltaWrapper.value_) : this.value_.equals(deltaWrapper.value_))) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public static DeltaWrapper m3838b(TProtocol tProtocol) {
        DeltaWrapper deltaWrapper = new DeltaWrapper();
        TUnion deltaWrapper2 = new DeltaWrapper();
        deltaWrapper2.setField_ = 0;
        deltaWrapper2.value_ = null;
        tProtocol.r();
        TField f = tProtocol.f();
        deltaWrapper2.value_ = deltaWrapper2.mo155a(tProtocol, f);
        if (deltaWrapper2.value_ != null) {
            deltaWrapper2.setField_ = f.c;
        }
        tProtocol.f();
        tProtocol.e();
        return deltaWrapper2;
    }

    public String toString() {
        return m3849a(1, f2691a);
    }

    public final String m3849a(int i, boolean z) {
        Object obj = 1;
        Object obj2 = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeltaWrapper");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        if (this.setField_ == 1) {
            stringBuilder.append(a);
            stringBuilder.append("deltaNoOp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3851c() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3851c(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 2) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaNewMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3852d() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3852d(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 3) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaNewGroupThread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3830I() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3830I(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 4) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaMarkRead");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3853e() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3853e(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 5) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaMarkUnread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3854f() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3854f(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 6) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaMessageDelete");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3855g() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3855g(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 7) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaThreadDelete");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3856h() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3856h(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 8) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaParticipantsAddedToGroupThread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3857i() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3857i(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 9) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaParticipantLeftGroupThread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3858j() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3858j(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 10) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaThreadName");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3859k() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3859k(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 11) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaThreadImage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3860l() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3860l(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 12) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaThreadMuteSettings");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3861m() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3861m(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 13) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaThreadAction");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3862n() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3862n(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 14) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaThreadFolder");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3863o() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3863o(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 15) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaRTCEventLog");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3864p() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3864p(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 16) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaVideoCall");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3831J() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3831J(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 17) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaAdminTextMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3865q() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3865q(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 18) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaForcedFetch");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3866r() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3866r(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 19) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaReadReceipt");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3867s() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3867s(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 20) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaBroadcastMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3868t() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3868t(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 21) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaMarkFolderSeen");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3832K() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3832K(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 22) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaSentMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3869u() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3869u(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 23) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPinnedGroups");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3833L() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3833L(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 24) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPageAdminReply");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3834M() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3834M(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 25) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaDeliveryReceipt");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3870v() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3870v(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 26) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaP2PPaymentMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3871w() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3871w(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 27) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaFolderCount");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3872x() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3872x(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 28) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaPagesManagerEvent");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3835N() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3835N(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 29) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaNotificationSettings");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3836O() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3836O(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 30) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaReplaceMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3873y() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3873y(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 31) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaZeroRating");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3874z() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3874z(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 32) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaMontageMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3839A() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3839A(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 33) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaGenieMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3840B() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3840B(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 34) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaGenericMapMutation");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3837P() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3837P(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 35) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaAdminAddedToGroupThread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3841C() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3841C(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 36) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaAdminRemovedFromGroupThread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3842D() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3842D(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 37) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaRtcCallData");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3843E() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3843E(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 38) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaJoinableMode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3844F() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3844F(), i + 1, z));
            }
            obj = null;
        }
        if (this.setField_ == 39) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaApprovalMode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3845G() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3845G(), i + 1, z));
            }
        } else {
            obj2 = obj;
        }
        if (this.setField_ == 40) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("deltaApprovalQueue");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (m3846H() == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(m3846H(), i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
