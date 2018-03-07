package com.facebook.common.fragmentconstants;

/* compiled from: all */
public final class FragmentConstants {
    public static String f11084a = "treehouse_basic_model";
    public static String f11085b = "treehouse_name_hint";
    public static final String[] f11086c = new String[]{"chromeless:content:fragment:tag", "ufi:popover:content:fragment:tag", "transliteration:fragment:tag"};
    private static final ContentFragmentType[] f11087d = ContentFragmentType.values();

    public static ContentFragmentType m19076a(int i) {
        if (i < 0 || i >= f11087d.length) {
            return null;
        }
        return f11087d[i];
    }
}
