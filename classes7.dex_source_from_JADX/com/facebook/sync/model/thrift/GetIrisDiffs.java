package com.facebook.sync.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;

/* compiled from: feed_article_chaining */
public class GetIrisDiffs implements TBase, Serializable, Cloneable {
    public static boolean f14535a = true;
    private static final TStruct f14536b = new TStruct("GetIrisDiffs");
    private static final TField f14537c = new TField("syncToken", (byte) 11, (short) 1);
    private static final TField f14538d = new TField("lastSeqId", (byte) 10, (short) 2);
    private static final TField f14539e = new TField("maxDeltasAbleToProcess", (byte) 8, (short) 3);
    private static final TField f14540f = new TField("deltaBatchSize", (byte) 8, (short) 4);
    private static final TField f14541g = new TField("encoding", (byte) 11, (short) 5);
    private static final TField f14542h = new TField("queueType", (byte) 11, (short) 6);
    private static final TField f14543i = new TField("syncApiVersion", (byte) 8, (short) 7);
    private static final TField f14544j = new TField("deviceId", (byte) 11, (short) 8);
    private static final TField f14545k = new TField("deviceParams", (byte) 11, (short) 9);
    private static final TField f14546l = new TField("queueParams", (byte) 11, (short) 10);
    private static final TField f14547m = new TField("entityFbid", (byte) 10, (short) 11);
    public final Integer deltaBatchSize;
    public final String deviceId;
    public final String deviceParams;
    public final String encoding;
    public final Long entityFbid;
    public final Long lastSeqId;
    public final Integer maxDeltasAbleToProcess;
    public final String queueParams;
    public final String queueType;
    public final Integer syncApiVersion;
    public final String syncToken;

    public GetIrisDiffs(String str, Long l, Integer num, Integer num2, String str2, String str3, Integer num3, String str4, String str5, String str6, Long l2) {
        this.syncToken = str;
        this.lastSeqId = l;
        this.maxDeltasAbleToProcess = num;
        this.deltaBatchSize = num2;
        this.encoding = str2;
        this.queueType = str3;
        this.syncApiVersion = num3;
        this.deviceId = str4;
        this.deviceParams = str5;
        this.queueParams = str6;
        this.entityFbid = l2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GetIrisDiffs)) {
            return false;
        }
        GetIrisDiffs getIrisDiffs = (GetIrisDiffs) obj;
        boolean z = false;
        if (getIrisDiffs != null) {
            Object obj2;
            Object obj3 = this.syncToken != null ? 1 : null;
            if (getIrisDiffs.syncToken != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.syncToken.equals(getIrisDiffs.syncToken))) {
                if (this.lastSeqId != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (getIrisDiffs.lastSeqId != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.lastSeqId.equals(getIrisDiffs.lastSeqId))) {
                    if (this.maxDeltasAbleToProcess != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (getIrisDiffs.maxDeltasAbleToProcess != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.maxDeltasAbleToProcess.equals(getIrisDiffs.maxDeltasAbleToProcess))) {
                        if (this.deltaBatchSize != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (getIrisDiffs.deltaBatchSize != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deltaBatchSize.equals(getIrisDiffs.deltaBatchSize))) {
                            if (this.encoding != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (getIrisDiffs.encoding != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.encoding.equals(getIrisDiffs.encoding))) {
                                if (this.queueType != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (getIrisDiffs.queueType != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.queueType.equals(getIrisDiffs.queueType))) {
                                    if (this.syncApiVersion != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (getIrisDiffs.syncApiVersion != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.syncApiVersion.equals(getIrisDiffs.syncApiVersion))) {
                                        if (this.deviceId != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (getIrisDiffs.deviceId != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deviceId.equals(getIrisDiffs.deviceId))) {
                                            if (this.deviceParams != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (getIrisDiffs.deviceParams != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.deviceParams.equals(getIrisDiffs.deviceParams))) {
                                                if (this.queueParams != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (getIrisDiffs.queueParams != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.queueParams.equals(getIrisDiffs.queueParams))) {
                                                    if (this.entityFbid != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (getIrisDiffs.entityFbid != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.entityFbid.equals(getIrisDiffs.entityFbid))) {
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

    public final void m18440a(TProtocol tProtocol) {
        m18438a();
        tProtocol.a();
        if (this.syncToken != null) {
            tProtocol.a(f14537c);
            tProtocol.a(this.syncToken);
        }
        if (this.lastSeqId != null) {
            tProtocol.a(f14538d);
            tProtocol.a(this.lastSeqId.longValue());
        }
        if (this.maxDeltasAbleToProcess != null) {
            tProtocol.a(f14539e);
            tProtocol.a(this.maxDeltasAbleToProcess.intValue());
        }
        if (!(this.deltaBatchSize == null || this.deltaBatchSize == null)) {
            tProtocol.a(f14540f);
            tProtocol.a(this.deltaBatchSize.intValue());
        }
        if (!(this.encoding == null || this.encoding == null)) {
            tProtocol.a(f14541g);
            tProtocol.a(this.encoding);
        }
        if (!(this.queueType == null || this.queueType == null)) {
            tProtocol.a(f14542h);
            tProtocol.a(this.queueType);
        }
        if (!(this.syncApiVersion == null || this.syncApiVersion == null)) {
            tProtocol.a(f14543i);
            tProtocol.a(this.syncApiVersion.intValue());
        }
        if (!(this.deviceId == null || this.deviceId == null)) {
            tProtocol.a(f14544j);
            tProtocol.a(this.deviceId);
        }
        if (!(this.deviceParams == null || this.deviceParams == null)) {
            tProtocol.a(f14545k);
            tProtocol.a(this.deviceParams);
        }
        if (!(this.queueParams == null || this.queueParams == null)) {
            tProtocol.a(f14546l);
            tProtocol.a(this.queueParams);
        }
        if (!(this.entityFbid == null || this.entityFbid == null)) {
            tProtocol.a(f14547m);
            tProtocol.a(this.entityFbid.longValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m18439a(1, f14535a);
    }

    public final String m18439a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("GetIrisDiffs");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("syncToken");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.syncToken == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.syncToken, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("lastSeqId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.lastSeqId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.lastSeqId, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("maxDeltasAbleToProcess");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.maxDeltasAbleToProcess == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.maxDeltasAbleToProcess, i + 1, z));
        }
        if (this.deltaBatchSize != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("deltaBatchSize");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deltaBatchSize == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deltaBatchSize, i + 1, z));
            }
        }
        if (this.encoding != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("encoding");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.encoding == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.encoding, i + 1, z));
            }
        }
        if (this.queueType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("queueType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.queueType == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.queueType, i + 1, z));
            }
        }
        if (this.syncApiVersion != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("syncApiVersion");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.syncApiVersion == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.syncApiVersion, i + 1, z));
            }
        }
        if (this.deviceId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("deviceId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deviceId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deviceId, i + 1, z));
            }
        }
        if (this.deviceParams != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("deviceParams");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deviceParams == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deviceParams, i + 1, z));
            }
        }
        if (this.queueParams != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("queueParams");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.queueParams == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.queueParams, i + 1, z));
            }
        }
        if (this.entityFbid != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("entityFbid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.entityFbid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.entityFbid, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m18438a() {
        if (this.syncToken == null) {
            throw new TProtocolException(6, "Required field 'syncToken' was not present! Struct: " + toString());
        } else if (this.lastSeqId == null) {
            throw new TProtocolException(6, "Required field 'lastSeqId' was not present! Struct: " + toString());
        } else if (this.maxDeltasAbleToProcess == null) {
            throw new TProtocolException(6, "Required field 'maxDeltasAbleToProcess' was not present! Struct: " + toString());
        }
    }
}
