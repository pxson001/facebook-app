package com.facebook.location.write;

import android.annotation.TargetApi;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.TimeConversions;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LocationUpdateInputData;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.Connected;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.Connected.CdmaInfo;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.Connected.CdmaInfo.BaseStationCoordinates;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.Connected.GsmInfo;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.Connected.LteInfo;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.Connected.WcdmaInfo;
import com.facebook.graphql.calls.LocationUpdateInputData.LocationManagerInfo.Locations;
import com.facebook.graphql.calls.LocationUpdateInputData.WifiInfo;
import com.facebook.graphql.calls.LocationUpdateInputData.WifiInfo.ScanResults;
import com.facebook.inject.Assisted;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.wifiscan.ScanResultUtil;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: log */
public class LocationMutationModelCreator {
    public final LocationMutationModelCreatorParams f16467a;
    private final AppStateManager f16468b;
    public final UniqueIdForDeviceHolderImpl f16469c;
    public final LocationAgeUtil f16470d;
    public final MonotonicClock f16471e;
    public final LocationTransformFunction f16472f = new LocationTransformFunction(this);
    private final WifiScanTransformFunction f16473g = new WifiScanTransformFunction(this);
    public final ConnectedCellTransformFunction f16474h = new ConnectedCellTransformFunction();
    public final CellScanTransformFunction f16475i = new CellScanTransformFunction();

    /* compiled from: log */
    public class LocationTransformFunction implements Function<ImmutableLocation, Locations> {
        final /* synthetic */ LocationMutationModelCreator f16476a;

        public LocationTransformFunction(LocationMutationModelCreator locationMutationModelCreator) {
            this.f16476a = locationMutationModelCreator;
        }

        @Nullable
        public /* synthetic */ Object apply(@Nullable Object obj) {
            return m23325a((ImmutableLocation) obj);
        }

        @Nullable
        public final Locations m23325a(@Nullable ImmutableLocation immutableLocation) {
            if (immutableLocation == null) {
                return null;
            }
            Locations locations = new Locations();
            locations.m11394a("latitude", Double.valueOf(immutableLocation.m11984a()));
            locations.m11394a("longitude", Double.valueOf(immutableLocation.m11985b()));
            locations.m11394a("accuracy_meters", Double.valueOf((double) ((Float) immutableLocation.m11986c().get()).floatValue()));
            locations.m11396a("age_ms", Integer.valueOf((int) this.f16476a.f16470d.m8269a(immutableLocation)));
            Optional d = immutableLocation.m11987d();
            if (d.isPresent()) {
                locations.m11394a("altitude_meters", (Double) d.get());
            }
            d = immutableLocation.m11988e();
            if (d.isPresent()) {
                locations.m11394a("bearing_degrees", Double.valueOf((double) ((Float) d.get()).floatValue()));
            }
            d = immutableLocation.m11989f();
            if (d.isPresent()) {
                locations.m11394a("speed_meters_per_second", Double.valueOf((double) ((Float) d.get()).floatValue()));
            }
            return locations;
        }
    }

    /* compiled from: log */
    class WifiScanTransformFunction implements Function<ScanResult, ScanResults> {
        final /* synthetic */ LocationMutationModelCreator f16477a;

        public WifiScanTransformFunction(LocationMutationModelCreator locationMutationModelCreator) {
            this.f16477a = locationMutationModelCreator;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ScanResult scanResult = (ScanResult) obj;
            if (scanResult == null) {
                return null;
            }
            Object scanResults = new ScanResults();
            scanResults.m11396a("age_ms", Integer.valueOf((int) TimeConversions.m11978r((this.f16477a.f16471e.now() * 1000) - scanResult.timestamp)));
            scanResults.m11397a("hardware_address", scanResult.BSSID);
            scanResults.m11397a("network_name", scanResult.SSID);
            scanResults.m11396a("rssi_dbm", Integer.valueOf(scanResult.level));
            if (!this.f16477a.f16467a.f16464a) {
                return scanResults;
            }
            scanResults.m11396a("frequency_mhz", Integer.valueOf(scanResult.frequency));
            return scanResults;
        }
    }

    /* compiled from: log */
    class ConnectedCellTransformFunction implements Function<CellInfo, Connected> {
        @Nullable
        public Object apply(@Nullable Object obj) {
            CellInfo cellInfo = (CellInfo) obj;
            if (cellInfo == null) {
                return null;
            }
            Object connected = new Connected();
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CdmaInfo cdmaInfo = new CdmaInfo();
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                if (cellIdentity.getBasestationId() != Integer.MAX_VALUE) {
                    cdmaInfo.m11396a("base_station_id", Integer.valueOf(cellIdentity.getBasestationId()));
                }
                if (!(cellIdentity.getLatitude() == Integer.MAX_VALUE || cellIdentity.getLongitude() == Integer.MAX_VALUE)) {
                    GraphQlCallInput baseStationCoordinates = new BaseStationCoordinates();
                    baseStationCoordinates.m11394a("latitude", Double.valueOf(LocationMutationModelCreator.m23316a(cellIdentity.getLatitude())));
                    baseStationCoordinates.m11394a("longitude", Double.valueOf(LocationMutationModelCreator.m23316a(cellIdentity.getLongitude())));
                    cdmaInfo.m11393a("base_station_coordinates", baseStationCoordinates);
                }
                if (cellIdentity.getNetworkId() != Integer.MAX_VALUE) {
                    cdmaInfo.m11396a("network_id", Integer.valueOf(cellIdentity.getNetworkId()));
                }
                if (cellIdentity.getSystemId() != Integer.MAX_VALUE) {
                    cdmaInfo.m11396a("system_id", Integer.valueOf(cellIdentity.getSystemId()));
                }
                CellSignalStrengthCdma cellSignalStrength = cellInfoCdma.getCellSignalStrength();
                cdmaInfo.m11396a("cdma_ecio_db10", Integer.valueOf(cellSignalStrength.getCdmaEcio()));
                cdmaInfo.m11396a("cdma_rssi_dbm", Integer.valueOf(cellSignalStrength.getCdmaDbm()));
                cdmaInfo.m11396a("evdo_ecio_db10", Integer.valueOf(cellSignalStrength.getEvdoEcio()));
                cdmaInfo.m11396a("evdo_rssi_dbm", Integer.valueOf(cellSignalStrength.getEvdoDbm()));
                cdmaInfo.m11396a("evdo_signal_to_noise", Integer.valueOf(cellSignalStrength.getEvdoSnr()));
                connected.m11393a("cdma_info", (GraphQlCallInput) cdmaInfo);
                return connected;
            } else if (cellInfo instanceof CellInfoGsm) {
                connected.m11393a("gsm_info", LocationMutationModelCreator.m23317c((CellInfoGsm) cellInfo));
                return connected;
            } else if (cellInfo instanceof CellInfoLte) {
                connected.m11393a("lte_info", LocationMutationModelCreator.m23318c((CellInfoLte) cellInfo));
                return connected;
            } else if (!(cellInfo instanceof CellInfoWcdma)) {
                return connected;
            } else {
                connected.m11393a("wcdma_info", LocationMutationModelCreator.m23319c((CellInfoWcdma) cellInfo));
                return connected;
            }
        }
    }

    @TargetApi(17)
    /* compiled from: log */
    class CellScanTransformFunction implements Function<CellInfo, LocationUpdateInputData.CellInfo.ScanResults> {
        @Nullable
        public Object apply(@Nullable Object obj) {
            CellInfo cellInfo = (CellInfo) obj;
            if (cellInfo == null) {
                return null;
            }
            Object scanResults = new LocationUpdateInputData.CellInfo.ScanResults();
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                LocationUpdateInputData.CellInfo.ScanResults.CdmaInfo cdmaInfo = new LocationUpdateInputData.CellInfo.ScanResults.CdmaInfo();
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                if (cellIdentity.getBasestationId() != Integer.MAX_VALUE) {
                    cdmaInfo.m11396a("base_station_id", Integer.valueOf(cellIdentity.getBasestationId()));
                }
                if (!(cellIdentity.getLatitude() == Integer.MAX_VALUE || cellIdentity.getLongitude() == Integer.MAX_VALUE)) {
                    GraphQlCallInput baseStationCoordinates = new LocationUpdateInputData.CellInfo.ScanResults.CdmaInfo.BaseStationCoordinates();
                    baseStationCoordinates.m11394a("latitude", Double.valueOf(LocationMutationModelCreator.m23316a(cellIdentity.getLatitude())));
                    baseStationCoordinates.m11394a("longitude", Double.valueOf(LocationMutationModelCreator.m23316a(cellIdentity.getLongitude())));
                    cdmaInfo.m11393a("base_station_coordinates", baseStationCoordinates);
                }
                if (cellIdentity.getNetworkId() != Integer.MAX_VALUE) {
                    cdmaInfo.m11396a("network_id", Integer.valueOf(cellIdentity.getNetworkId()));
                }
                if (cellIdentity.getSystemId() != Integer.MAX_VALUE) {
                    cdmaInfo.m11396a("system_id", Integer.valueOf(cellIdentity.getSystemId()));
                }
                CellSignalStrengthCdma cellSignalStrength = cellInfoCdma.getCellSignalStrength();
                cdmaInfo.m11396a("cdma_ecio_db10", Integer.valueOf(cellSignalStrength.getCdmaEcio()));
                cdmaInfo.m11396a("cdma_rssi_dbm", Integer.valueOf(cellSignalStrength.getCdmaDbm()));
                cdmaInfo.m11396a("evdo_ecio_db10", Integer.valueOf(cellSignalStrength.getEvdoEcio()));
                cdmaInfo.m11396a("evdo_rssi_dbm", Integer.valueOf(cellSignalStrength.getEvdoDbm()));
                cdmaInfo.m11396a("evdo_signal_to_noise", Integer.valueOf(cellSignalStrength.getEvdoSnr()));
                scanResults.m11393a("cdma_info", (GraphQlCallInput) cdmaInfo);
            } else if (cellInfo instanceof CellInfoGsm) {
                scanResults.m11393a("gsm_info", LocationMutationModelCreator.m23320d((CellInfoGsm) cellInfo));
            } else if (cellInfo instanceof CellInfoLte) {
                scanResults.m11393a("lte_info", LocationMutationModelCreator.m23321d((CellInfoLte) cellInfo));
            } else if (cellInfo instanceof CellInfoWcdma) {
                scanResults.m11393a("wcdma_info", LocationMutationModelCreator.m23322d((CellInfoWcdma) cellInfo));
            }
            scanResults.m11396a("age_ms", Integer.valueOf(0));
            return scanResults;
        }
    }

    @Inject
    public LocationMutationModelCreator(@Assisted LocationMutationModelCreatorParams locationMutationModelCreatorParams, AppStateManager appStateManager, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, LocationAgeUtil locationAgeUtil, MonotonicClock monotonicClock) {
        this.f16467a = locationMutationModelCreatorParams;
        this.f16468b = appStateManager;
        this.f16469c = uniqueIdForDeviceHolderImpl;
        this.f16470d = locationAgeUtil;
        this.f16471e = monotonicClock;
    }

    @TargetApi(17)
    public final List<ScanResults> m23324a(List<ScanResult> list) {
        List list2;
        Preconditions.checkNotNull(list);
        int i = this.f16467a.f16466c;
        int i2 = this.f16467a.f16465b;
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i2 > 0);
        List arrayList = new ArrayList();
        for (ScanResult scanResult : list) {
            if (scanResult.level >= i) {
                arrayList.add(scanResult);
            }
        }
        if (arrayList.size() <= i2) {
            list2 = arrayList;
        } else {
            Collections.sort(arrayList, ScanResultUtil.a);
            arrayList.subList(i2, arrayList.size()).clear();
            list2 = arrayList;
        }
        return Lists.m1303a(list2, this.f16473g);
    }

    public final WifiInfo.Connected m23323a(android.net.wifi.WifiInfo wifiInfo) {
        Preconditions.checkNotNull(wifiInfo);
        WifiInfo.Connected connected = new WifiInfo.Connected();
        connected.m11397a("hardware_address", wifiInfo.getBSSID());
        connected.m11397a("network_name", wifiInfo.getSSID());
        connected.m11396a("rssi_dbm", Integer.valueOf(wifiInfo.getRssi()));
        if (this.f16467a.f16464a && VERSION.SDK_INT >= 21) {
            Preconditions.checkState(VERSION.SDK_INT >= 21);
            connected.m11396a("frequency_mhz", Integer.valueOf(wifiInfo.getFrequency()));
        }
        return connected;
    }

    @TargetApi(17)
    public static GsmInfo m23317c(CellInfoGsm cellInfoGsm) {
        GsmInfo gsmInfo = new GsmInfo();
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("cell_id", Integer.valueOf(cellIdentity.getCid()));
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("location_area_code", Integer.valueOf(cellIdentity.getLac()));
        }
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("mobile_country_code", Integer.valueOf(cellIdentity.getMcc()));
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("mobile_network_code", Integer.valueOf(cellIdentity.getMnc()));
        }
        gsmInfo.m11396a("rssi_dbm", Integer.valueOf(cellInfoGsm.getCellSignalStrength().getDbm()));
        return gsmInfo;
    }

    @TargetApi(17)
    public static LteInfo m23318c(CellInfoLte cellInfoLte) {
        LteInfo lteInfo = new LteInfo();
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        if (cellIdentity.getCi() != Integer.MAX_VALUE) {
            lteInfo.m11396a("cell_id", Integer.valueOf(cellIdentity.getCi()));
        }
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            lteInfo.m11396a("mobile_country_code", Integer.valueOf(cellIdentity.getMcc()));
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            lteInfo.m11396a("mobile_network_code", Integer.valueOf(cellIdentity.getMnc()));
        }
        if (cellIdentity.getPci() != Integer.MAX_VALUE) {
            lteInfo.m11396a("physical_cell_id", Integer.valueOf(cellIdentity.getPci()));
        }
        if (cellIdentity.getTac() != Integer.MAX_VALUE) {
            lteInfo.m11396a("tracking_area_code", Integer.valueOf(cellIdentity.getTac()));
        }
        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
        lteInfo.m11396a("rssi_dbm", Integer.valueOf(cellSignalStrength.getDbm()));
        lteInfo.m11396a("timing_advance", Integer.valueOf(cellSignalStrength.getTimingAdvance()));
        return lteInfo;
    }

    @TargetApi(18)
    public static WcdmaInfo m23319c(CellInfoWcdma cellInfoWcdma) {
        WcdmaInfo wcdmaInfo = new WcdmaInfo();
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("cell_id", Integer.valueOf(cellIdentity.getCid()));
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("location_area_code", Integer.valueOf(cellIdentity.getLac()));
        }
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("mobile_country_code", Integer.valueOf(cellIdentity.getMcc()));
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("mobile_network_code", Integer.valueOf(cellIdentity.getMnc()));
        }
        if (cellIdentity.getPsc() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("primary_scrambling_code", Integer.valueOf(cellIdentity.getPsc()));
        }
        wcdmaInfo.m11396a("rssi_dbm", Integer.valueOf(cellInfoWcdma.getCellSignalStrength().getDbm()));
        return wcdmaInfo;
    }

    @TargetApi(17)
    public static LocationUpdateInputData.CellInfo.ScanResults.GsmInfo m23320d(CellInfoGsm cellInfoGsm) {
        LocationUpdateInputData.CellInfo.ScanResults.GsmInfo gsmInfo = new LocationUpdateInputData.CellInfo.ScanResults.GsmInfo();
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("cell_id", Integer.valueOf(cellIdentity.getCid()));
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("location_area_code", Integer.valueOf(cellIdentity.getLac()));
        }
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("mobile_country_code", Integer.valueOf(cellIdentity.getMcc()));
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            gsmInfo.m11396a("mobile_network_code", Integer.valueOf(cellIdentity.getMnc()));
        }
        gsmInfo.m11396a("rssi_dbm", Integer.valueOf(cellInfoGsm.getCellSignalStrength().getDbm()));
        return gsmInfo;
    }

    @TargetApi(17)
    public static LocationUpdateInputData.CellInfo.ScanResults.LteInfo m23321d(CellInfoLte cellInfoLte) {
        LocationUpdateInputData.CellInfo.ScanResults.LteInfo lteInfo = new LocationUpdateInputData.CellInfo.ScanResults.LteInfo();
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        if (cellIdentity.getCi() != Integer.MAX_VALUE) {
            lteInfo.m11396a("cell_id", Integer.valueOf(cellIdentity.getCi()));
        }
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            lteInfo.m11396a("mobile_country_code", Integer.valueOf(cellIdentity.getMcc()));
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            lteInfo.m11396a("mobile_network_code", Integer.valueOf(cellIdentity.getMnc()));
        }
        if (cellIdentity.getPci() != Integer.MAX_VALUE) {
            lteInfo.m11396a("physical_cell_id", Integer.valueOf(cellIdentity.getPci()));
        }
        if (cellIdentity.getTac() != Integer.MAX_VALUE) {
            lteInfo.m11396a("tracking_area_code", Integer.valueOf(cellIdentity.getTac()));
        }
        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
        lteInfo.m11396a("rssi_dbm", Integer.valueOf(cellSignalStrength.getDbm()));
        lteInfo.m11396a("timing_advance", Integer.valueOf(cellSignalStrength.getTimingAdvance()));
        return lteInfo;
    }

    @TargetApi(18)
    public static LocationUpdateInputData.CellInfo.ScanResults.WcdmaInfo m23322d(CellInfoWcdma cellInfoWcdma) {
        LocationUpdateInputData.CellInfo.ScanResults.WcdmaInfo wcdmaInfo = new LocationUpdateInputData.CellInfo.ScanResults.WcdmaInfo();
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        if (cellIdentity.getCid() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("cell_id", Integer.valueOf(cellIdentity.getCid()));
        }
        if (cellIdentity.getLac() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("location_area_code", Integer.valueOf(cellIdentity.getLac()));
        }
        if (cellIdentity.getMcc() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("mobile_country_code", Integer.valueOf(cellIdentity.getMcc()));
        }
        if (cellIdentity.getMnc() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("mobile_network_code", Integer.valueOf(cellIdentity.getMnc()));
        }
        if (cellIdentity.getPsc() != Integer.MAX_VALUE) {
            wcdmaInfo.m11396a("primary_scrambling_code", Integer.valueOf(cellIdentity.getPsc()));
        }
        wcdmaInfo.m11396a("rssi_dbm", Integer.valueOf(cellInfoWcdma.getCellSignalStrength().getDbm()));
        return wcdmaInfo;
    }

    public static double m23316a(int i) {
        return (((double) i) / 4.0d) / 3600.0d;
    }
}
