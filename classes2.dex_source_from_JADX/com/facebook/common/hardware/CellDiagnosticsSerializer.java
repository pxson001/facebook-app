package com.facebook.common.hardware;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.hardware.TelephonyManagerUtils.CellType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: prompt_type */
public class CellDiagnosticsSerializer {
    private static volatile CellDiagnosticsSerializer f8744d;
    @Nullable
    private final TelephonyManager f8745a;
    private final Clock f8746b;
    private final RuntimePermissionsUtil f8747c;

    public static com.facebook.common.hardware.CellDiagnosticsSerializer m13578a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8744d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.hardware.CellDiagnosticsSerializer.class;
        monitor-enter(r1);
        r0 = f8744d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13582b(r0);	 Catch:{ all -> 0x0035 }
        f8744d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8744d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.hardware.CellDiagnosticsSerializer.a(com.facebook.inject.InjectorLike):com.facebook.common.hardware.CellDiagnosticsSerializer");
    }

    private static CellDiagnosticsSerializer m13582b(InjectorLike injectorLike) {
        return new CellDiagnosticsSerializer(TelephonyManagerMethodAutoProvider.m3851b(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), RuntimePermissionsUtil.m13589b(injectorLike));
    }

    @Inject
    public CellDiagnosticsSerializer(@Nullable TelephonyManager telephonyManager, Clock clock, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f8745a = telephonyManager;
        this.f8746b = clock;
        this.f8747c = runtimePermissionsUtil;
    }

    private void m13581a(@Nullable Map<String, Object> map, ObjectNode objectNode) {
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof Boolean) {
                    objectNode.m5131a(str, (Boolean) value);
                } else if (value instanceof Integer) {
                    objectNode.m5134a(str, (Integer) value);
                } else if (value instanceof Long) {
                    objectNode.m5135a(str, (Long) value);
                } else if (value instanceof String) {
                    objectNode.m5137a(str, (String) value);
                } else if (value instanceof List) {
                    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
                    m13580a((List) value, arrayNode);
                    objectNode.m5143c(str, arrayNode);
                } else {
                    throw new UnsupportedOperationException("Unsupported type:" + value.getClass().getName());
                }
            }
        }
    }

    private void m13580a(List list, ArrayNode arrayNode) {
        for (Object next : list) {
            if (next instanceof Map) {
                try {
                    Map map = (Map) next;
                    JsonNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
                    m13581a(map, (ObjectNode) objectNode);
                    arrayNode.m13381a(objectNode);
                } catch (ClassCastException e) {
                    throw new UnsupportedOperationException("Unsupported type:" + next.getClass().getName());
                }
            }
            throw new UnsupportedOperationException("Unsupported type:" + next.getClass().getName());
        }
    }

    @Nullable
    public final JsonNode m13586a() {
        Map b = m13587b();
        if (b == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        m13581a(b, objectNode);
        return objectNode;
    }

    @Nullable
    public final Map<String, Object> m13587b() {
        if (this.f8745a == null) {
            return null;
        }
        Map treeMap = new TreeMap();
        m13583b(treeMap);
        if (this.f8747c.m13593a("android.permission.ACCESS_COARSE_LOCATION")) {
            Object obj;
            List<NeighboringCellInfo> neighboringCellInfo = this.f8745a.getNeighboringCellInfo();
            if (neighboringCellInfo == null || neighboringCellInfo.isEmpty()) {
                obj = null;
            } else {
                List b = Lists.m1306b();
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    Map treeMap2 = new TreeMap();
                    treeMap2.put("network_type", TelephonyManagerUtils.m27405a(neighboringCellInfo2.getNetworkType()));
                    int cid = neighboringCellInfo2.getCid();
                    int lac = neighboringCellInfo2.getLac();
                    int psc = neighboringCellInfo2.getPsc();
                    int rssi = neighboringCellInfo2.getRssi();
                    if (cid != -1) {
                        treeMap2.put("cid", Integer.valueOf(cid));
                    }
                    if (lac != -1) {
                        treeMap2.put("lac", Integer.valueOf(lac));
                    }
                    if (psc != -1) {
                        treeMap2.put("PSC", Integer.valueOf(psc));
                    }
                    if (rssi != 99) {
                        treeMap2.put("rssi", Integer.valueOf(rssi));
                    }
                    b.add(treeMap2);
                }
                List list = b;
            }
            Object obj2 = obj;
            if (obj2 != null) {
                treeMap.put("neighbor_cell_info", obj2);
            }
        }
        m13584c(treeMap);
        return treeMap;
    }

    private void m13583b(Map<String, Object> map) {
        map.put("network_type", TelephonyManagerUtils.m27405a(this.f8745a.getNetworkType()));
        map.put("phone_type", TelephonyManagerUtils.m27410c(this.f8745a));
        map.put("sim_country_iso", this.f8745a.getSimCountryIso());
        map.put("sim_operator_mcc_mnc", this.f8745a.getSimOperator());
        map.put("sim_operator_name", this.f8745a.getSimOperatorName());
        map.put("has_icc_card", Boolean.valueOf(this.f8745a.hasIccCard()));
        map.put("timestamp", Long.valueOf(this.f8746b.mo211a()));
        CellLocation cellLocation = null;
        if (this.f8747c.m13593a("android.permission.ACCESS_COARSE_LOCATION") || this.f8747c.m13593a("android.permission.ACCESS_FINE_LOCATION")) {
            cellLocation = this.f8745a.getCellLocation();
        }
        if (cellLocation == null) {
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            int baseStationId = cdmaCellLocation.getBaseStationId();
            int baseStationLatitude = cdmaCellLocation.getBaseStationLatitude();
            int baseStationLongitude = cdmaCellLocation.getBaseStationLongitude();
            int networkId = cdmaCellLocation.getNetworkId();
            int systemId = cdmaCellLocation.getSystemId();
            if (baseStationId != -1) {
                map.put("cdma_base_station_id", Integer.valueOf(baseStationId));
            }
            if (baseStationLatitude != Integer.MAX_VALUE) {
                map.put("cdma_base_station_latitude", Integer.valueOf(baseStationLatitude));
            }
            if (baseStationLongitude != Integer.MAX_VALUE) {
                map.put("cdma_base_station_longitude", Integer.valueOf(baseStationLongitude));
            }
            if (networkId != -1) {
                map.put("cdma_network_id", Integer.valueOf(networkId));
            }
            if (systemId != -1) {
                map.put("cdma_system_id", Integer.valueOf(systemId));
            }
        } else if (cellLocation instanceof GsmCellLocation) {
            m13579a((GsmCellLocation) cellLocation, (Map) map);
        }
    }

    private void m13579a(GsmCellLocation gsmCellLocation, Map<String, Object> map) {
        map.put("network_country_iso", this.f8745a.getNetworkCountryIso());
        map.put("network_operator_mcc_mnc", this.f8745a.getNetworkOperator());
        map.put("network_operator_name", this.f8745a.getNetworkOperatorName());
        map.put("is_network_roaming", Boolean.valueOf(this.f8745a.isNetworkRoaming()));
        int cid = gsmCellLocation.getCid();
        int lac = gsmCellLocation.getLac();
        int psc = gsmCellLocation.getPsc();
        if (cid != -1) {
            map.put("gsm_cid", Integer.valueOf(cid));
        }
        if (lac != -1) {
            map.put("gsm_lac", Integer.valueOf(lac));
        }
        if (psc != -1) {
            map.put("gsm_psc", Integer.valueOf(psc));
        }
    }

    @TargetApi(18)
    private void m13584c(Map<String, Object> map) {
        if (VERSION.SDK_INT >= 18) {
            List list = null;
            if (this.f8747c.m13593a("android.permission.ACCESS_COARSE_LOCATION")) {
                list = this.f8745a.getAllCellInfo();
            }
            if (r0 != null) {
                for (CellInfo cellInfo : r0) {
                    if (cellInfo instanceof CellInfoCdma) {
                        CellSignalStrengthCdma cellSignalStrength = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                        map.put("signal_asu_level", Integer.valueOf(cellSignalStrength.getAsuLevel()));
                        map.put("signal_dbm", Integer.valueOf(cellSignalStrength.getDbm()));
                        map.put("signal_level", Integer.valueOf(cellSignalStrength.getLevel()));
                        map.put("signal_cdma_dbm", Integer.valueOf(cellSignalStrength.getCdmaDbm()));
                        map.put("signal_cdma_ecio", Integer.valueOf(cellSignalStrength.getCdmaEcio()));
                        map.put("signal_cdma_level", Integer.valueOf(cellSignalStrength.getCdmaLevel()));
                        map.put("signal_evdo_dbm", Integer.valueOf(cellSignalStrength.getEvdoDbm()));
                        map.put("signal_evdo_ecio", Integer.valueOf(cellSignalStrength.getEvdoEcio()));
                        map.put("signal_evdo_level", Integer.valueOf(cellSignalStrength.getEvdoLevel()));
                        map.put("signal_evdo_snr", Integer.valueOf(cellSignalStrength.getEvdoSnr()));
                    } else if (cellInfo instanceof CellInfoGsm) {
                        CellSignalStrengthGsm cellSignalStrength2 = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                        map.put("signal_asu_level", Integer.valueOf(cellSignalStrength2.getAsuLevel()));
                        map.put("signal_dbm", Integer.valueOf(cellSignalStrength2.getDbm()));
                        map.put("signal_level", Integer.valueOf(cellSignalStrength2.getLevel()));
                    } else if (cellInfo instanceof CellInfoLte) {
                        CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                        map.put("signal_asu_level", Integer.valueOf(cellSignalStrength3.getAsuLevel()));
                        map.put("signal_dbm", Integer.valueOf(cellSignalStrength3.getDbm()));
                        map.put("signal_level", Integer.valueOf(cellSignalStrength3.getLevel()));
                        map.put("signal_lte_timing_advance", Integer.valueOf(cellSignalStrength3.getTimingAdvance()));
                        CellIdentityLte cellIdentity = ((CellInfoLte) cellInfo).getCellIdentity();
                        map.put("lte_ci", Integer.valueOf(cellIdentity.getCi()));
                        map.put("lte_mcc", Integer.valueOf(cellIdentity.getMcc()));
                        map.put("lte_mnc", Integer.valueOf(cellIdentity.getMnc()));
                        map.put("lte_pci", Integer.valueOf(cellIdentity.getPci()));
                        map.put("lte_tac", Integer.valueOf(cellIdentity.getTac()));
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                        map.put("signal_asu_level", Integer.valueOf(cellSignalStrength4.getAsuLevel()));
                        map.put("signal_dbm", Integer.valueOf(cellSignalStrength4.getDbm()));
                        map.put("signal_level", Integer.valueOf(cellSignalStrength4.getLevel()));
                    }
                }
            }
        }
    }

    @TargetApi(18)
    public final CellSignalStrength m13585a(int i) {
        if (VERSION.SDK_INT >= 18 && this.f8745a != null) {
            CellType cellType;
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                case 3:
                case 11:
                    cellType = CellType.GSM;
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                case 5:
                case 6:
                case 7:
                case 12:
                case 14:
                    cellType = CellType.CDMA;
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                case 9:
                case 10:
                case 15:
                    cellType = CellType.WCDMA;
                    break;
                case 13:
                    cellType = CellType.LTE;
                    break;
                default:
                    cellType = CellType.UNKNOWN;
                    break;
            }
            CellType cellType2 = cellType;
            List allCellInfo;
            if (this.f8747c.m13593a("android.permission.ACCESS_COARSE_LOCATION")) {
                allCellInfo = this.f8745a.getAllCellInfo();
            } else {
                allCellInfo = null;
            }
            if (r0 != null) {
                CellSignalStrength cellSignalStrength = null;
                for (CellInfo cellInfo : r0) {
                    CellSignalStrength cellSignalStrength2;
                    if ((cellInfo instanceof CellInfoCdma) && cellType2 == CellType.CDMA) {
                        cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                    } else if ((cellInfo instanceof CellInfoGsm) && cellType2 == CellType.GSM) {
                        cellSignalStrength2 = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                    } else if ((cellInfo instanceof CellInfoLte) && cellType2 == CellType.LTE) {
                        cellSignalStrength2 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                    } else if ((cellInfo instanceof CellInfoWcdma) && cellType2 == CellType.WCDMA) {
                        cellSignalStrength2 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                    } else {
                        cellSignalStrength2 = null;
                    }
                    if (cellSignalStrength != null && (r0 == null || cellSignalStrength.getDbm() >= r0.getDbm())) {
                        cellSignalStrength2 = cellSignalStrength;
                    }
                    cellSignalStrength = cellSignalStrength2;
                }
                return cellSignalStrength;
            }
        }
        return null;
    }

    public static int m13577a(Map<String, Object> map) {
        if (map.containsKey("cdma_base_station_id")) {
            return ((Integer) map.get("cdma_base_station_id")).intValue();
        }
        if (map.containsKey("gsm_cid")) {
            return ((Integer) map.get("gsm_cid")).intValue();
        }
        return 0;
    }
}
