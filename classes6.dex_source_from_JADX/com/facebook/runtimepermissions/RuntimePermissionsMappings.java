package com.facebook.runtimepermissions;

/* compiled from: setInitialPageData */
public final class RuntimePermissionsMappings {
    public static String m7563a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2062386608:
                if (str.equals("android.permission.READ_SMS")) {
                    obj = 19;
                    break;
                }
                break;
            case -1928411001:
                if (str.equals("android.permission.READ_CALENDAR")) {
                    obj = null;
                    break;
                }
                break;
            case -1921431796:
                if (str.equals("android.permission.READ_CALL_LOG")) {
                    obj = 11;
                    break;
                }
                break;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    obj = 6;
                    break;
                }
                break;
            case -1479758289:
                if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                    obj = 20;
                    break;
                }
                break;
            case -1238066820:
                if (str.equals("android.permission.BODY_SENSORS")) {
                    obj = 16;
                    break;
                }
                break;
            case -895673731:
                if (str.equals("android.permission.RECEIVE_SMS")) {
                    obj = 18;
                    break;
                }
                break;
            case -406040016:
                if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    obj = 21;
                    break;
                }
                break;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    obj = 7;
                    break;
                }
                break;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    obj = 9;
                    break;
                }
                break;
            case 52602690:
                if (str.equals("android.permission.SEND_SMS")) {
                    obj = 17;
                    break;
                }
                break;
            case 112197485:
                if (str.equals("android.permission.CALL_PHONE")) {
                    obj = 10;
                    break;
                }
                break;
            case 214526995:
                if (str.equals("android.permission.WRITE_CONTACTS")) {
                    obj = 4;
                    break;
                }
                break;
            case 463403621:
                if (str.equals("android.permission.CAMERA")) {
                    obj = 2;
                    break;
                }
                break;
            case 603653886:
                if (str.equals("android.permission.WRITE_CALENDAR")) {
                    obj = 1;
                    break;
                }
                break;
            case 610633091:
                if (str.equals("android.permission.WRITE_CALL_LOG")) {
                    obj = 12;
                    break;
                }
                break;
            case 784519842:
                if (str.equals("android.permission.USE_SIP")) {
                    obj = 14;
                    break;
                }
                break;
            case 952819282:
                if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                    obj = 15;
                    break;
                }
                break;
            case 1271781903:
                if (str.equals("android.permission.GET_ACCOUNTS")) {
                    obj = 5;
                    break;
                }
                break;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    obj = 22;
                    break;
                }
                break;
            case 1831139720:
                if (str.equals("android.permission.RECORD_AUDIO")) {
                    obj = 8;
                    break;
                }
                break;
            case 1977429404:
                if (str.equals("android.permission.READ_CONTACTS")) {
                    obj = 3;
                    break;
                }
                break;
            case 2133799037:
                if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    obj = 13;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
                return "android.permission-group.CALENDAR";
            case 2:
                return "android.permission-group.CAMERA";
            case 3:
            case 4:
            case 5:
                return "android.permission-group.CONTACTS";
            case 6:
            case 7:
                return "android.permission-group.LOCATION";
            case 8:
                return "android.permission-group.MICROPHONE";
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return "android.permission-group.PHONE";
            case 16:
                return "android.permission-group.SENSORS";
            case 17:
            case 18:
            case 19:
            case 20:
                return "android.permission-group.SMS";
            case 21:
            case 22:
                return "android.permission-group.STORAGE";
            default:
                return "";
        }
    }

    public static int m7564c(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    i = 2;
                    break;
                }
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    i = 5;
                    break;
                }
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    i = 0;
                    break;
                }
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    i = 1;
                    break;
                }
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    i = 6;
                    break;
                }
                break;
            case 828638019:
                if (str.equals("android.permission-group.LOCATION")) {
                    i = 3;
                    break;
                }
                break;
            case 852078861:
                if (str.equals("android.permission-group.STORAGE")) {
                    i = 8;
                    break;
                }
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    i = 4;
                    break;
                }
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    i = 7;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 2131235928;
            case 1:
                return 2131235929;
            case 2:
                return 2131235930;
            case 3:
                return 2131235931;
            case 4:
                return 2131235932;
            case 5:
                return 2131235933;
            case 6:
                return 2131235934;
            case 7:
                return 2131235935;
            case 8:
                return 2131235936;
            default:
                return 0;
        }
    }

    public static int m7565d(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -2062386608:
                if (str.equals("android.permission.READ_SMS")) {
                    i = 19;
                    break;
                }
                break;
            case -1928411001:
                if (str.equals("android.permission.READ_CALENDAR")) {
                    i = 0;
                    break;
                }
                break;
            case -1921431796:
                if (str.equals("android.permission.READ_CALL_LOG")) {
                    i = 11;
                    break;
                }
                break;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    i = 6;
                    break;
                }
                break;
            case -1479758289:
                if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                    i = 20;
                    break;
                }
                break;
            case -1238066820:
                if (str.equals("android.permission.BODY_SENSORS")) {
                    i = 16;
                    break;
                }
                break;
            case -895673731:
                if (str.equals("android.permission.RECEIVE_SMS")) {
                    i = 18;
                    break;
                }
                break;
            case -406040016:
                if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    i = 21;
                    break;
                }
                break;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    i = 7;
                    break;
                }
                break;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    i = 9;
                    break;
                }
                break;
            case 52602690:
                if (str.equals("android.permission.SEND_SMS")) {
                    i = 17;
                    break;
                }
                break;
            case 112197485:
                if (str.equals("android.permission.CALL_PHONE")) {
                    i = 10;
                    break;
                }
                break;
            case 214526995:
                if (str.equals("android.permission.WRITE_CONTACTS")) {
                    i = 4;
                    break;
                }
                break;
            case 463403621:
                if (str.equals("android.permission.CAMERA")) {
                    i = 2;
                    break;
                }
                break;
            case 603653886:
                if (str.equals("android.permission.WRITE_CALENDAR")) {
                    i = 1;
                    break;
                }
                break;
            case 610633091:
                if (str.equals("android.permission.WRITE_CALL_LOG")) {
                    i = 12;
                    break;
                }
                break;
            case 784519842:
                if (str.equals("android.permission.USE_SIP")) {
                    i = 14;
                    break;
                }
                break;
            case 952819282:
                if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                    i = 15;
                    break;
                }
                break;
            case 1271781903:
                if (str.equals("android.permission.GET_ACCOUNTS")) {
                    i = 5;
                    break;
                }
                break;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    i = 22;
                    break;
                }
                break;
            case 1831139720:
                if (str.equals("android.permission.RECORD_AUDIO")) {
                    i = 8;
                    break;
                }
                break;
            case 1977429404:
                if (str.equals("android.permission.READ_CONTACTS")) {
                    i = 3;
                    break;
                }
                break;
            case 2133799037:
                if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    i = 13;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
                return 2131235910;
            case 2:
                return 2131235912;
            case 3:
            case 4:
            case 5:
                return 2131235914;
            case 6:
            case 7:
                return 2131235916;
            case 8:
                return 2131235918;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 2131235920;
            case 16:
                return 2131235922;
            case 17:
            case 18:
            case 19:
            case 20:
                return 2131235924;
            case 21:
            case 22:
                return 2131235926;
            default:
                return 0;
        }
    }

    public static int m7566e(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -2062386608:
                if (str.equals("android.permission.READ_SMS")) {
                    i = 19;
                    break;
                }
                break;
            case -1928411001:
                if (str.equals("android.permission.READ_CALENDAR")) {
                    i = 0;
                    break;
                }
                break;
            case -1921431796:
                if (str.equals("android.permission.READ_CALL_LOG")) {
                    i = 11;
                    break;
                }
                break;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    i = 6;
                    break;
                }
                break;
            case -1479758289:
                if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                    i = 20;
                    break;
                }
                break;
            case -1238066820:
                if (str.equals("android.permission.BODY_SENSORS")) {
                    i = 16;
                    break;
                }
                break;
            case -895673731:
                if (str.equals("android.permission.RECEIVE_SMS")) {
                    i = 18;
                    break;
                }
                break;
            case -406040016:
                if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                    i = 21;
                    break;
                }
                break;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    i = 7;
                    break;
                }
                break;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    i = 9;
                    break;
                }
                break;
            case 52602690:
                if (str.equals("android.permission.SEND_SMS")) {
                    i = 17;
                    break;
                }
                break;
            case 112197485:
                if (str.equals("android.permission.CALL_PHONE")) {
                    i = 10;
                    break;
                }
                break;
            case 214526995:
                if (str.equals("android.permission.WRITE_CONTACTS")) {
                    i = 4;
                    break;
                }
                break;
            case 463403621:
                if (str.equals("android.permission.CAMERA")) {
                    i = 2;
                    break;
                }
                break;
            case 603653886:
                if (str.equals("android.permission.WRITE_CALENDAR")) {
                    i = 1;
                    break;
                }
                break;
            case 610633091:
                if (str.equals("android.permission.WRITE_CALL_LOG")) {
                    i = 12;
                    break;
                }
                break;
            case 784519842:
                if (str.equals("android.permission.USE_SIP")) {
                    i = 14;
                    break;
                }
                break;
            case 952819282:
                if (str.equals("android.permission.PROCESS_OUTGOING_CALLS")) {
                    i = 15;
                    break;
                }
                break;
            case 1271781903:
                if (str.equals("android.permission.GET_ACCOUNTS")) {
                    i = 5;
                    break;
                }
                break;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    i = 22;
                    break;
                }
                break;
            case 1831139720:
                if (str.equals("android.permission.RECORD_AUDIO")) {
                    i = 8;
                    break;
                }
                break;
            case 1977429404:
                if (str.equals("android.permission.READ_CONTACTS")) {
                    i = 3;
                    break;
                }
                break;
            case 2133799037:
                if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    i = 13;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
                return 2131235911;
            case 2:
                return 2131235913;
            case 3:
            case 4:
            case 5:
                return 2131235915;
            case 6:
            case 7:
                return 2131235917;
            case 8:
                return 2131235919;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 2131235921;
            case 16:
                return 2131235923;
            case 17:
            case 18:
            case 19:
            case 20:
                return 2131235925;
            case 21:
            case 22:
                return 2131235927;
            default:
                return 0;
        }
    }
}
