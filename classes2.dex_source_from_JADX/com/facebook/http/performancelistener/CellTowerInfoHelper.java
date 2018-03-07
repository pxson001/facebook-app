package com.facebook.http.performancelistener;

import android.location.LocationManager;
import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.util.TriState;
import com.google.common.base.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: profile_type */
public class CellTowerInfoHelper {
    private static final String[] f8792e = new String[]{"network_type", "phone_type", "sim_country_iso", "sim_operator_name", "network_country_iso", "network_operator_name", "is_network_roaming", "signal_level", "signal_asu_level", "signal_dbm"};
    private static final String[] f8793f = new String[]{"sim_operator_mcc_mnc", "has_icc_card", "cdma_base_station_id", "cdma_base_station_latitude", "cdma_base_station_longitude", "cdma_network_id", "cdma_system_id", "network_operator_mcc_mnc", "gsm_cid", "gsm_lac", "gsm_psc", "lte_ci", "lte_mcc", "lte_mnc", "lte_pci", "lte_tac"};
    private final CellDiagnosticsSerializer f8794a;
    private final Provider<TriState> f8795b;
    public final LocationManager f8796c;
    private int f8797d;

    public CellTowerInfoHelper(CellDiagnosticsSerializer cellDiagnosticsSerializer, Provider<TriState> provider, LocationManager locationManager) {
        this.f8794a = (CellDiagnosticsSerializer) Preconditions.checkNotNull(cellDiagnosticsSerializer);
        this.f8795b = (Provider) Preconditions.checkNotNull(provider);
        this.f8796c = locationManager;
    }

    public final void m13644a(Map<String, String> map) {
        m13643a(map, true);
    }

    public final void m13645b(Map<String, String> map) {
        m13643a(map, false);
    }

    private void m13643a(Map<String, String> map, boolean z) {
        Map b = this.f8794a.m13587b();
        if (b == null) {
            return;
        }
        if (z) {
            this.f8797d = CellDiagnosticsSerializer.m13577a(b);
            m13642a(map, b, f8792e);
            if (((TriState) this.f8795b.get()).asBoolean(false)) {
                Object obj;
                if (this.f8796c.isProviderEnabled("gps") || this.f8796c.isProviderEnabled("network")) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    m13642a(map, b, f8793f);
                    return;
                }
                return;
            }
            return;
        }
        map.put("tower_changed", String.valueOf(this.f8797d != CellDiagnosticsSerializer.m13577a(b)));
    }

    private static void m13642a(Map<String, String> map, Map<String, Object> map2, String[] strArr) {
        for (Object obj : strArr) {
            Object obj2 = map2.get(obj);
            if (obj2 != null) {
                map.put(obj, obj2.toString());
            }
        }
    }
}
