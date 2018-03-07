package com.facebook.tools.flatbuffer;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: android_mobile_payments_%s */
public class FlatBufferHelper {
    public static boolean m19975a(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case 73679:
                if (str.equals("Int")) {
                    z = true;
                    break;
                }
                break;
            case 2086184:
                if (str.equals("Byte")) {
                    z = true;
                    break;
                }
                break;
            case 2374300:
                if (str.equals("Long")) {
                    z = true;
                    break;
                }
                break;
            case 2606829:
                if (str.equals("Time")) {
                    z = true;
                    break;
                }
                break;
            case 67973692:
                if (str.equals("Float")) {
                    z = true;
                    break;
                }
                break;
            case 79860828:
                if (str.equals("Short")) {
                    z = true;
                    break;
                }
                break;
            case 1729365000:
                if (str.equals("Boolean")) {
                    z = false;
                    break;
                }
                break;
            case 2052876273:
                if (str.equals("Double")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static boolean m19978b(String str) {
        return str.equals("String") || str.equals("Url");
    }

    public static boolean m19976a(String str, JSONObject jSONObject) {
        try {
            if (!(m19979c(str) || m19975a(str) || m19978b(str))) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(str);
                if (jSONObject2.has("_isEnum_")) {
                    return jSONObject2.getBoolean("_isEnum_");
                }
            }
            return false;
        } catch (JSONException e) {
            System.out.println(String.format("%s: enum type %s is not defined in schema", new Object[]{FlatBufferHelper.class.getSimpleName(), str}));
            return false;
        }
    }

    public static boolean m19977a(JSONObject jSONObject) {
        try {
            return jSONObject.getBoolean("plural");
        } catch (JSONException e) {
            return false;
        }
    }

    public static boolean m19979c(String str) {
        return str.equals("_VirtualObject_");
    }
}
