package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: tincan_send_failed_retryable */
public class MarkThread implements TBase, Serializable, Cloneable {
    public static boolean f2906a = true;
    private static final TStruct f2907b = new TStruct("MarkThread");
    private static final TField f2908c = new TField("mark", (byte) 11, (short) 1);
    private static final TField f2909d = new TField("state", (byte) 2, (short) 2);
    private static final TField f2910e = new TField("threadId", (byte) 11, (short) 3);
    private static final TField f2911f = new TField("actionId", (byte) 10, (short) 4);
    private static final TField f2912g = new TField("syncSeqId", (byte) 10, (short) 5);
    private static final TField f2913h = new TField("threadFbId", (byte) 10, (short) 6);
    private static final TField f2914i = new TField("otherUserFbId", (byte) 10, (short) 7);
    private static final TField f2915j = new TField("actorFbId", (byte) 10, (short) 8);
    private static final TField f2916k = new TField("watermarkTimestamp", (byte) 10, (short) 9);
    private static final TField f2917l = new TField("titanOriginatedThreadId", (byte) 11, (short) 10);
    private static final TField f2918m = new TField("shouldSendReadReceipt", (byte) 2, (short) 11);
    public final Long actionId;
    public final Long actorFbId;
    public final String mark;
    public final Long otherUserFbId;
    public final Boolean shouldSendReadReceipt;
    public final Boolean state;
    public final Long syncSeqId;
    public final Long threadFbId;
    public final String threadId;
    public final String titanOriginatedThreadId;
    public final Long watermarkTimestamp;

    public MarkThread(String str, Boolean bool, String str2, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, String str3, Boolean bool2) {
        this.mark = str;
        this.state = bool;
        this.threadId = str2;
        this.actionId = l;
        this.syncSeqId = l2;
        this.threadFbId = l3;
        this.otherUserFbId = l4;
        this.actorFbId = l5;
        this.watermarkTimestamp = l6;
        this.titanOriginatedThreadId = str3;
        this.shouldSendReadReceipt = bool2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MarkThread)) {
            return false;
        }
        MarkThread markThread = (MarkThread) obj;
        boolean z = false;
        if (markThread != null) {
            Object obj2;
            Object obj3 = this.mark != null ? 1 : null;
            if (markThread.mark != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.mark.equals(markThread.mark))) {
                if (this.state != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (markThread.state != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.state.equals(markThread.state))) {
                    if (this.threadId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (markThread.threadId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadId.equals(markThread.threadId))) {
                        if (this.actionId != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (markThread.actionId != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.actionId.equals(markThread.actionId))) {
                            if (this.syncSeqId != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (markThread.syncSeqId != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.syncSeqId.equals(markThread.syncSeqId))) {
                                if (this.threadFbId != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (markThread.threadFbId != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadFbId.equals(markThread.threadFbId))) {
                                    if (this.otherUserFbId != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (markThread.otherUserFbId != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.otherUserFbId.equals(markThread.otherUserFbId))) {
                                        if (this.actorFbId != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (markThread.actorFbId != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.actorFbId.equals(markThread.actorFbId))) {
                                            if (this.watermarkTimestamp != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (markThread.watermarkTimestamp != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.watermarkTimestamp.equals(markThread.watermarkTimestamp))) {
                                                if (this.titanOriginatedThreadId != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (markThread.titanOriginatedThreadId != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.titanOriginatedThreadId.equals(markThread.titanOriginatedThreadId))) {
                                                    if (this.shouldSendReadReceipt != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (markThread.shouldSendReadReceipt != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.shouldSendReadReceipt.equals(markThread.shouldSendReadReceipt))) {
                                                        z = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m3985a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.mark != null) {
            tProtocol.a(f2908c);
            tProtocol.a(this.mark);
        }
        if (this.state != null) {
            tProtocol.a(f2909d);
            tProtocol.a(this.state.booleanValue());
        }
        if (!(this.threadId == null || this.threadId == null)) {
            tProtocol.a(f2910e);
            tProtocol.a(this.threadId);
        }
        if (!(this.actionId == null || this.actionId == null)) {
            tProtocol.a(f2911f);
            tProtocol.a(this.actionId.longValue());
        }
        if (!(this.syncSeqId == null || this.syncSeqId == null)) {
            tProtocol.a(f2912g);
            tProtocol.a(this.syncSeqId.longValue());
        }
        if (!(this.threadFbId == null || this.threadFbId == null)) {
            tProtocol.a(f2913h);
            tProtocol.a(this.threadFbId.longValue());
        }
        if (!(this.otherUserFbId == null || this.otherUserFbId == null)) {
            tProtocol.a(f2914i);
            tProtocol.a(this.otherUserFbId.longValue());
        }
        if (!(this.actorFbId == null || this.actorFbId == null)) {
            tProtocol.a(f2915j);
            tProtocol.a(this.actorFbId.longValue());
        }
        if (!(this.watermarkTimestamp == null || this.watermarkTimestamp == null)) {
            tProtocol.a(f2916k);
            tProtocol.a(this.watermarkTimestamp.longValue());
        }
        if (!(this.titanOriginatedThreadId == null || this.titanOriginatedThreadId == null)) {
            tProtocol.a(f2917l);
            tProtocol.a(this.titanOriginatedThreadId);
        }
        if (!(this.shouldSendReadReceipt == null || this.shouldSendReadReceipt == null)) {
            tProtocol.a(f2918m);
            tProtocol.a(this.shouldSendReadReceipt.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m3984a(1, f2906a);
    }

    public final String m3984a(int i, boolean z) {
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("MarkThread");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("mark");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.mark == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.mark, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("state");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.state == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.m7783a(this.state, i + 1, z));
        }
        if (this.threadId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("threadId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadId, i + 1, z));
            }
        }
        if (this.actionId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("actionId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actionId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actionId, i + 1, z));
            }
        }
        if (this.syncSeqId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("syncSeqId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.syncSeqId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.syncSeqId, i + 1, z));
            }
        }
        if (this.threadFbId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("threadFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.threadFbId, i + 1, z));
            }
        }
        if (this.otherUserFbId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("otherUserFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.otherUserFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.otherUserFbId, i + 1, z));
            }
        }
        if (this.actorFbId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("actorFbId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.actorFbId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.actorFbId, i + 1, z));
            }
        }
        if (this.watermarkTimestamp != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("watermarkTimestamp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.watermarkTimestamp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.watermarkTimestamp, i + 1, z));
            }
        }
        if (this.titanOriginatedThreadId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("titanOriginatedThreadId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.titanOriginatedThreadId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.titanOriginatedThreadId, i + 1, z));
            }
        }
        if (this.shouldSendReadReceipt != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("shouldSendReadReceipt");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.shouldSendReadReceipt == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.shouldSendReadReceipt, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
