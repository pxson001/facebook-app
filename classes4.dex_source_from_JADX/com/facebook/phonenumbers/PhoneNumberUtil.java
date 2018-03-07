package com.facebook.phonenumbers;

import android.content.Context;
import com.facebook.phonenumbers.NumberParseException.ErrorType;
import com.facebook.phonenumbers.Phonemetadata.NumberFormat;
import com.facebook.phonenumbers.Phonemetadata.PhoneMetadata;
import com.facebook.phonenumbers.Phonemetadata.PhoneMetadataCollection;
import com.facebook.phonenumbers.Phonemetadata.PhoneNumberDesc;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: eid */
public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    public static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
    public static final Pattern CC_PATTERN = Pattern.compile("\\$CC");
    static final MetadataLoader DEFAULT_METADATA_LOADER = new C06261();
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final Pattern EXTN_PATTERN = Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", 66);
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final Pattern FG_PATTERN = Pattern.compile("\\$FG");
    public static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    public static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    public static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    public static final Pattern NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
    private static final Pattern NP_PATTERN = Pattern.compile("\\$NP");
    public static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
    public static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile("[\\\\/] *x");
    public static final Pattern SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    public static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    private static final String VALID_ALPHA = (Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
    private static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String VALID_PHONE_NUMBER = ("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*" + VALID_ALPHA + "\\p{Nd}]*");
    private static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", 66);
    public static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile("[+＋\\p{Nd}]");
    private static PhoneNumberUtil instance = null;
    public static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    public final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final Map<Integer, PhoneMetadata> countryCodeToNonGeographicalMetadataMap = Collections.synchronizedMap(new HashMap());
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
    private final String currentFilePrefix;
    private final Context mContext;
    private final MetadataLoader metadataLoader;
    private final Set<String> nanpaRegions = new HashSet(35);
    public final RegexCache regexCache = new RegexCache(100);
    private final Map<String, Integer> regionCodeToCountryCallingCodeMap;
    private final Map<String, PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap());
    private final Set<String> supportedRegions = new HashSet(320);

    /* compiled from: eid */
    final class C06261 implements MetadataLoader {
        C06261() {
        }

        public final InputStream loadMetadata(String str) {
            return PhoneNumberUtil.class.getResourceAsStream(str);
        }
    }

    /* compiled from: eid */
    final class C06272 implements MetadataLoader {
        final /* synthetic */ Context val$context;

        C06272(Context context) {
            this.val$context = context;
        }

        public final InputStream loadMetadata(String str) {
            try {
                InputStream zipInputStream = new ZipInputStream(this.val$context.getAssets().open("libphone_data.zip"));
                ZipEntry nextEntry;
                do {
                    nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        return null;
                    }
                } while (!nextEntry.getName().equals(str));
                return zipInputStream;
            } catch (IOException e) {
                return null;
            }
        }
    }

    public String getRegionCodeForNumber(PhoneNumber phoneNumber) {
        int i = phoneNumber.countryCode_;
        List list = (List) this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null) {
            logger.log(Level.WARNING, "Missing/invalid country_code (" + i + ") for number " + getNationalSignificantNumber(phoneNumber));
            return null;
        } else if (list.size() == 1) {
            return (String) list.get(0);
        } else {
            return getRegionCodeForNumberFromRegionList(phoneNumber, list);
        }
    }

    public String format(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.nationalNumber_ == 0 && phoneNumber.hasRawInput) {
            String str = phoneNumber.rawInput_;
            if (str.length() > 0) {
                return str;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        format(phoneNumber, phoneNumberFormat, stringBuilder);
        return stringBuilder.toString();
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(Integer.valueOf(52), "1");
        hashMap.put(Integer.valueOf(54), "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(hashMap);
        Map hashMap2 = new HashMap();
        hashMap2.put(Character.valueOf('0'), Character.valueOf('0'));
        hashMap2.put(Character.valueOf('1'), Character.valueOf('1'));
        hashMap2.put(Character.valueOf('2'), Character.valueOf('2'));
        hashMap2.put(Character.valueOf('3'), Character.valueOf('3'));
        hashMap2.put(Character.valueOf('4'), Character.valueOf('4'));
        hashMap2.put(Character.valueOf('5'), Character.valueOf('5'));
        hashMap2.put(Character.valueOf('6'), Character.valueOf('6'));
        hashMap2.put(Character.valueOf('7'), Character.valueOf('7'));
        hashMap2.put(Character.valueOf('8'), Character.valueOf('8'));
        hashMap2.put(Character.valueOf('9'), Character.valueOf('9'));
        hashMap = new HashMap(40);
        hashMap.put(Character.valueOf('A'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('B'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('C'), Character.valueOf('2'));
        hashMap.put(Character.valueOf('D'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('E'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('F'), Character.valueOf('3'));
        hashMap.put(Character.valueOf('G'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('H'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('I'), Character.valueOf('4'));
        hashMap.put(Character.valueOf('J'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('K'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('L'), Character.valueOf('5'));
        hashMap.put(Character.valueOf('M'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('N'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('O'), Character.valueOf('6'));
        hashMap.put(Character.valueOf('P'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('Q'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('R'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('S'), Character.valueOf('7'));
        hashMap.put(Character.valueOf('T'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('U'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('V'), Character.valueOf('8'));
        hashMap.put(Character.valueOf('W'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('X'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Y'), Character.valueOf('9'));
        hashMap.put(Character.valueOf('Z'), Character.valueOf('9'));
        ALPHA_MAPPINGS = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap(100);
        hashMap.putAll(ALPHA_MAPPINGS);
        hashMap.putAll(hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.putAll(hashMap2);
        hashMap.put(Character.valueOf('+'), Character.valueOf('+'));
        hashMap.put(Character.valueOf('*'), Character.valueOf('*'));
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(hashMap);
        Map hashMap3 = new HashMap();
        for (Character charValue : ALPHA_MAPPINGS.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap3.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap3.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap3.putAll(hashMap2);
        hashMap3.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('－'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‐'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‑'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('‒'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('–'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('—'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('―'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('−'), Character.valueOf('-'));
        hashMap3.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf('／'), Character.valueOf('/'));
        hashMap3.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('　'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('⁠'), Character.valueOf(' '));
        hashMap3.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap3.put(Character.valueOf('．'), Character.valueOf('.'));
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(hashMap3);
        String str = "xｘ#＃~～";
        EXTN_PATTERNS_FOR_PARSING = createExtnPattern("," + str);
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern(str);
    }

    private PhoneNumberType getNumberTypeHelper(String str, PhoneMetadata phoneMetadata) {
        if (!isNumberMatchingDesc(str, phoneMetadata.generalDesc_)) {
            return PhoneNumberType.UNKNOWN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.premiumRate_)) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.tollFree_)) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.sharedCost_)) {
            return PhoneNumberType.SHARED_COST;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.voip_)) {
            return PhoneNumberType.VOIP;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.personalNumber_)) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.pager_)) {
            return PhoneNumberType.PAGER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.uan_)) {
            return PhoneNumberType.UAN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.voicemail_)) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.fixedLine_)) {
            if (phoneMetadata.sameMobileAndFixedLinePattern_) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (isNumberMatchingDesc(str, phoneMetadata.mobile_)) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        } else if (phoneMetadata.sameMobileAndFixedLinePattern_ || !isNumberMatchingDesc(str, phoneMetadata.mobile_)) {
            return PhoneNumberType.UNKNOWN;
        } else {
            return PhoneNumberType.MOBILE;
        }
    }

    private static String createExtnPattern(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*" + "(\\p{Nd}{1,7})#?|" + "[- ]+(\\p{Nd}" + "{1,5})#";
    }

    PhoneNumberUtil(String str, MetadataLoader metadataLoader, Map<Integer, List<String>> map, Map<String, Integer> map2, Context context) {
        this.mContext = context;
        this.currentFilePrefix = str;
        this.metadataLoader = metadataLoader;
        this.countryCallingCodeToRegionCodeMap = map;
        this.regionCodeToCountryCallingCodeMap = map2;
        for (Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() == 1 && "001".equals(list.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
            } else {
                this.supportedRegions.addAll(list);
            }
        }
        if (this.supportedRegions.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll((Collection) map.get(Integer.valueOf(1)));
    }

    void loadMetadataFromFile(String str, String str2, int i, MetadataLoader metadataLoader) {
        boolean equals = "001".equals(str2);
        String str3 = "libphone_data/" + str + "_" + (equals ? String.valueOf(i) : str2);
        InputStream loadMetadata = metadataLoader.loadMetadata(str3);
        if (loadMetadata == null) {
            logger.log(Level.SEVERE, "missing metadata: " + str3);
            throw new IllegalStateException("missing metadata: " + str3);
        }
        try {
            List metadataList = loadMetadataAndCloseInput(new ObjectInputStream(loadMetadata)).getMetadataList();
            if (metadataList.isEmpty()) {
                logger.log(Level.SEVERE, "empty metadata: " + str3);
                throw new IllegalStateException("empty metadata: " + str3);
            }
            if (metadataList.size() > 1) {
                logger.log(Level.WARNING, "invalid metadata (too many entries): " + str3);
            }
            PhoneMetadata phoneMetadata = (PhoneMetadata) metadataList.get(0);
            if (equals) {
                this.countryCodeToNonGeographicalMetadataMap.put(Integer.valueOf(i), phoneMetadata);
            } else {
                this.regionToMetadataMap.put(str2, phoneMetadata);
            }
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "cannot load/parse metadata: " + str3, e);
            throw new RuntimeException("cannot load/parse metadata: " + str3, e);
        }
    }

    private String formatNsn(String str, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, String str2) {
        List list;
        if (phoneMetadata.intlNumberFormat_.size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) {
            list = phoneMetadata.numberFormat_;
        } else {
            list = phoneMetadata.intlNumberFormat_;
        }
        for (NumberFormat numberFormat : r0) {
            int leadingDigitsPatternSize = numberFormat.leadingDigitsPatternSize();
            if ((leadingDigitsPatternSize == 0 || this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(leadingDigitsPatternSize - 1)).matcher(str).lookingAt()) && this.regexCache.getPatternForRegex(numberFormat.pattern_).matcher(str).matches()) {
                break;
            }
        }
        NumberFormat numberFormat2 = null;
        NumberFormat numberFormat3 = numberFormat2;
        if (numberFormat3 == null) {
            return str;
        }
        CharSequence replaceAll;
        String str3 = numberFormat3.format_;
        Matcher matcher = this.regexCache.getPatternForRegex(numberFormat3.pattern_).matcher(str);
        if (phoneNumberFormat != PhoneNumberFormat.NATIONAL || str2 == null || str2.length() <= 0 || numberFormat3.domesticCarrierCodeFormattingRule_.length() <= 0) {
            String str4 = numberFormat3.nationalPrefixFormattingRule_;
            if (phoneNumberFormat == PhoneNumberFormat.NATIONAL && str4 != null && str4.length() > 0) {
                replaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(str3).replaceFirst(str4));
                if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                    matcher = SEPARATOR_PATTERN.matcher(replaceAll);
                    if (matcher.lookingAt()) {
                        replaceAll = matcher.replaceFirst("");
                    }
                    replaceAll = matcher.reset(replaceAll).replaceAll("-");
                }
                return replaceAll;
            }
        }
        str3 = FIRST_GROUP_PATTERN.matcher(str3).replaceFirst(CC_PATTERN.matcher(numberFormat3.domesticCarrierCodeFormattingRule_).replaceFirst(str2));
        replaceAll = matcher.replaceAll(str3);
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            matcher = SEPARATOR_PATTERN.matcher(replaceAll);
            if (matcher.lookingAt()) {
                replaceAll = matcher.replaceFirst("");
            }
            replaceAll = matcher.reset(replaceAll).replaceAll("-");
        }
        return replaceAll;
    }

    private static PhoneMetadataCollection loadMetadataAndCloseInput(ObjectInputStream objectInputStream) {
        PhoneMetadataCollection phoneMetadataCollection = new PhoneMetadataCollection();
        try {
            phoneMetadataCollection.readExternal(objectInputStream);
            try {
                objectInputStream.close();
            } catch (Throwable e) {
                logger.log(Level.WARNING, "error closing input stream (ignored)", e);
            } catch (Throwable th) {
            }
        } catch (Throwable e2) {
            logger.log(Level.WARNING, "error reading input (ignored)", e2);
            try {
                objectInputStream.close();
            } catch (Throwable e22) {
                logger.log(Level.WARNING, "error closing input stream (ignored)", e22);
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
            try {
                objectInputStream.close();
            } catch (Throwable e222) {
                logger.log(Level.WARNING, "error closing input stream (ignored)", e222);
            } catch (Throwable th4) {
            }
        }
        return phoneMetadataCollection;
    }

    static boolean isViablePhoneNumber(String str) {
        if (str.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(str).matches();
    }

    public static String normalize(String str) {
        if (!VALID_ALPHA_PHONE_PATTERN.matcher(str).matches()) {
            return normalizeDigitsOnly(str);
        }
        Map map = ALPHA_PHONE_MAPPINGS;
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            Character ch = (Character) map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                stringBuilder.append(ch);
            } else if (1 == 0) {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    public static void normalize(StringBuilder stringBuilder) {
        stringBuilder.replace(0, stringBuilder.length(), normalize(stringBuilder.toString()));
    }

    public static String normalizeDigitsOnly(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (digit != -1) {
                stringBuilder.append(digit);
            } else if (null != null) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public int getLengthOfGeographicalAreaCode(PhoneNumber phoneNumber) {
        PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(phoneNumber));
        if (metadataForRegion == null) {
            return 0;
        }
        if (!metadataForRegion.hasNationalPrefix && !phoneNumber.italianLeadingZero_) {
            return 0;
        }
        Object obj;
        PhoneNumberType numberType = getNumberType(phoneNumber);
        if (numberType == PhoneNumberType.FIXED_LINE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return 0;
        }
        PhoneNumber phoneNumber2;
        int i;
        if (phoneNumber.hasExtension) {
            phoneNumber2 = new PhoneNumber();
            if (phoneNumber.hasCountryCode) {
                phoneNumber2.setCountryCode(phoneNumber.countryCode_);
            }
            if (phoneNumber.hasNationalNumber) {
                phoneNumber2.setNationalNumber(phoneNumber.nationalNumber_);
            }
            if (phoneNumber.hasExtension) {
                phoneNumber2.setExtension(phoneNumber.extension_);
            }
            if (phoneNumber.hasItalianLeadingZero) {
                phoneNumber2.setItalianLeadingZero(phoneNumber.italianLeadingZero_);
            }
            if (phoneNumber.hasNumberOfLeadingZeros) {
                phoneNumber2.setNumberOfLeadingZeros(phoneNumber.numberOfLeadingZeros_);
            }
            if (phoneNumber.hasRawInput) {
                phoneNumber2.setRawInput(phoneNumber.rawInput_);
            }
            if (phoneNumber.hasCountryCodeSource) {
                phoneNumber2.setCountryCodeSource(phoneNumber.countryCodeSource_);
            }
            if (phoneNumber.hasPreferredDomesticCarrierCode) {
                phoneNumber2.setPreferredDomesticCarrierCode(phoneNumber.preferredDomesticCarrierCode_);
            }
            phoneNumber2.hasExtension = false;
            phoneNumber2.extension_ = "";
        } else {
            phoneNumber2 = phoneNumber;
        }
        String[] split = NON_DIGITS_PATTERN.split(format(phoneNumber2, PhoneNumberFormat.INTERNATIONAL));
        if (split.length <= 3) {
            i = 0;
        } else {
            if (getNumberType(phoneNumber) == PhoneNumberType.MOBILE) {
                String str;
                int i2 = phoneNumber.countryCode_;
                if (MOBILE_TOKEN_MAPPINGS.containsKey(Integer.valueOf(i2))) {
                    str = (String) MOBILE_TOKEN_MAPPINGS.get(Integer.valueOf(i2));
                } else {
                    str = "";
                }
                if (!str.equals("")) {
                    i = split[3].length() + split[2].length();
                }
            }
            i = split[2].length();
        }
        return i;
    }

    static synchronized void setInstance(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            instance = phoneNumberUtil;
        }
    }

    public static synchronized PhoneNumberUtil getInstance(Context context) {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            if (instance == null) {
                setInstance(createInstance(new C06272(context), context));
            }
            phoneNumberUtil = instance;
        }
        return phoneNumberUtil;
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader, Context context) {
        if (metadataLoader == null) {
            throw new IllegalArgumentException("metadataLoader could not be null.");
        }
        CountryCodeToRegionCodeMap.maybeInitializeMaps();
        Map map = CountryCodeToRegionCodeMap.sCountryCodeToRegionCodeMap;
        CountryCodeToRegionCodeMap.maybeInitializeMaps();
        return new PhoneNumberUtil("PhoneNumberMetadataProto", metadataLoader, map, CountryCodeToRegionCodeMap.sRegionCodeToCountryCodeMap, context);
    }

    private boolean isValidRegionCode(String str) {
        return str != null && this.supportedRegions.contains(str);
    }

    public void format(PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        int i = phoneNumber.countryCode_;
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            stringBuilder.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.E164, stringBuilder);
        } else if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i))) {
            PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
            stringBuilder.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat));
            if (phoneNumber.hasExtension && phoneNumber.extension_.length() > 0) {
                if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                    stringBuilder.append(";ext=").append(phoneNumber.extension_);
                } else if (metadataForRegionOrCallingCode.hasPreferredExtnPrefix) {
                    stringBuilder.append(metadataForRegionOrCallingCode.preferredExtnPrefix_).append(phoneNumber.extension_);
                } else {
                    stringBuilder.append(" ext. ").append(phoneNumber.extension_);
                }
            }
            prefixNumberWithCountryCallingCode(i, phoneNumberFormat, stringBuilder);
        } else {
            stringBuilder.append(nationalSignificantNumber);
        }
    }

    private PhoneMetadata getMetadataForRegionOrCallingCode(int i, String str) {
        return "001".equals(str) ? getMetadataForNonGeographicalRegion(i) : getMetadataForRegion(str);
    }

    public String getNationalSignificantNumber(PhoneNumber phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (phoneNumber.italianLeadingZero_) {
            char[] cArr = new char[phoneNumber.numberOfLeadingZeros_];
            Arrays.fill(cArr, '0');
            stringBuilder.append(new String(cArr));
        }
        stringBuilder.append(phoneNumber.nationalNumber_);
        return stringBuilder.toString();
    }

    private void prefixNumberWithCountryCallingCode(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        switch (4.$SwitchMap$com$facebook$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[phoneNumberFormat.ordinal()]) {
            case 1:
                stringBuilder.insert(0, i).insert(0, '+');
                return;
            case 2:
                stringBuilder.insert(0, " ").insert(0, i).insert(0, '+');
                return;
            case 3:
                stringBuilder.insert(0, "-").insert(0, i).insert(0, '+').insert(0, "tel:");
                return;
            default:
                return;
        }
    }

    private String formatNsn(String str, PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return formatNsn(str, phoneMetadata, phoneNumberFormat, null);
    }

    public PhoneNumberType getNumberType(PhoneNumber phoneNumber) {
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(phoneNumber.countryCode_, getRegionCodeForNumber(phoneNumber));
        if (metadataForRegionOrCallingCode == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode);
    }

    PhoneMetadata getMetadataForRegion(String str) {
        if (!isValidRegionCode(str)) {
            return null;
        }
        synchronized (this.regionToMetadataMap) {
            if (!this.regionToMetadataMap.containsKey(str)) {
                loadMetadataFromFile(this.currentFilePrefix, str, 0, this.metadataLoader);
            }
        }
        return (PhoneMetadata) this.regionToMetadataMap.get(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.facebook.phonenumbers.Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int r5) {
        /*
        r4 = this;
        r1 = r4.countryCodeToNonGeographicalMetadataMap;
        monitor-enter(r1);
        r0 = r4.countryCallingCodeToRegionCodeMap;	 Catch:{ all -> 0x0035 }
        r2 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0035 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0012;
    L_0x000f:
        r0 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
    L_0x0011:
        return r0;
    L_0x0012:
        r0 = r4.countryCodeToNonGeographicalMetadataMap;	 Catch:{ all -> 0x0035 }
        r2 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0035 }
        r0 = r0.containsKey(r2);	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0027;
    L_0x001e:
        r0 = r4.currentFilePrefix;	 Catch:{ all -> 0x0035 }
        r2 = "001";
        r3 = r4.metadataLoader;	 Catch:{ all -> 0x0035 }
        r4.loadMetadataFromFile(r0, r2, r5, r3);	 Catch:{ all -> 0x0035 }
    L_0x0027:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        r0 = r4.countryCodeToNonGeographicalMetadataMap;
        r1 = java.lang.Integer.valueOf(r5);
        r0 = r0.get(r1);
        r0 = (com.facebook.phonenumbers.Phonemetadata.PhoneMetadata) r0;
        goto L_0x0011;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.phonenumbers.PhoneNumberUtil.getMetadataForNonGeographicalRegion(int):com.facebook.phonenumbers.Phonemetadata$PhoneMetadata");
    }

    boolean isNumberMatchingDesc(String str, PhoneNumberDesc phoneNumberDesc) {
        return this.regexCache.getPatternForRegex(phoneNumberDesc.possibleNumberPattern_).matcher(str).matches() && this.regexCache.getPatternForRegex(phoneNumberDesc.nationalNumberPattern_).matcher(str).matches();
    }

    public boolean isValidNumber(PhoneNumber phoneNumber) {
        return isValidNumberForRegion(phoneNumber, getRegionCodeForNumber(phoneNumber));
    }

    public boolean isValidNumberForRegion(PhoneNumber phoneNumber, String str) {
        int i = phoneNumber.countryCode_;
        PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(i, str);
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        if (("001".equals(str) || i == getCountryCodeForValidRegion(str)) && getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode) != PhoneNumberType.UNKNOWN) {
            return true;
        }
        return false;
    }

    private String getRegionCodeForNumberFromRegionList(PhoneNumber phoneNumber, List<String> list) {
        Object nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String str : list) {
            PhoneMetadata metadataForRegion = getMetadataForRegion(str);
            if (metadataForRegion.hasLeadingDigits) {
                if (this.regexCache.getPatternForRegex(metadataForRegion.leadingDigits_).matcher(nationalSignificantNumber).lookingAt()) {
                    return str;
                }
            } else if (getNumberTypeHelper(nationalSignificantNumber, metadataForRegion) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public String getRegionCodeForCountryCode(int i) {
        List list = (List) this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        return list == null ? "ZZ" : (String) list.get(0);
    }

    public int getCountryCodeForRegion(String str) {
        if (isValidRegionCode(str)) {
            return getCountryCodeForValidRegion(str);
        }
        Logger logger = logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        logger.log(level, stringBuilder.append(str).append(") provided.").toString());
        return 0;
    }

    private int getCountryCodeForValidRegion(String str) {
        if (this.regionCodeToCountryCallingCodeMap.containsKey(str)) {
            return ((Integer) this.regionCodeToCountryCallingCodeMap.get(str)).intValue();
        }
        PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion == null) {
            throw new IllegalArgumentException("Invalid region code: " + str);
        }
        this.regionCodeToCountryCallingCodeMap.put(str, Integer.valueOf(metadataForRegion.countryCode_));
        return metadataForRegion.countryCode_;
    }

    private ValidationResult testNumberLengthAgainstPattern(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (matcher.lookingAt()) {
            return ValidationResult.TOO_LONG;
        }
        return ValidationResult.TOO_SHORT;
    }

    private boolean isShorterThanPossibleNormalNumber(PhoneMetadata phoneMetadata, String str) {
        return testNumberLengthAgainstPattern(this.regexCache.getPatternForRegex(phoneMetadata.generalDesc_.possibleNumberPattern_), str) == ValidationResult.TOO_SHORT;
    }

    int extractCountryCode(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == '0') {
            return 0;
        }
        int length = stringBuilder.length();
        int i = 1;
        while (i <= 3 && i <= length) {
            int parseInt = Integer.parseInt(stringBuilder.substring(0, i));
            if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(parseInt))) {
                stringBuilder2.append(stringBuilder.substring(i));
                return parseInt;
            }
            i++;
        }
        return 0;
    }

    int maybeExtractCountryCode(String str, PhoneMetadata phoneMetadata, StringBuilder stringBuilder, boolean z, PhoneNumber phoneNumber) {
        if (str.length() == 0) {
            return 0;
        }
        Object stringBuilder2 = new StringBuilder(str);
        String str2 = "NonMatch";
        if (phoneMetadata != null) {
            str2 = phoneMetadata.internationalPrefix_;
        }
        CountryCodeSource maybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(stringBuilder2, str2);
        if (z) {
            phoneNumber.setCountryCodeSource(maybeStripInternationalPrefixAndNormalize);
        }
        int i;
        if (maybeStripInternationalPrefixAndNormalize == CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (phoneMetadata != null) {
                i = phoneMetadata.countryCode_;
                String valueOf = String.valueOf(i);
                String stringBuilder3 = stringBuilder2.toString();
                if (stringBuilder3.startsWith(valueOf)) {
                    CharSequence stringBuilder4 = new StringBuilder(stringBuilder3.substring(valueOf.length()));
                    PhoneNumberDesc phoneNumberDesc = phoneMetadata.generalDesc_;
                    Pattern patternForRegex = this.regexCache.getPatternForRegex(phoneNumberDesc.nationalNumberPattern_);
                    maybeStripNationalPrefixAndCarrierCode(stringBuilder4, phoneMetadata, null);
                    Pattern patternForRegex2 = this.regexCache.getPatternForRegex(phoneNumberDesc.possibleNumberPattern_);
                    if ((!patternForRegex.matcher(stringBuilder2).matches() && patternForRegex.matcher(stringBuilder4).matches()) || testNumberLengthAgainstPattern(patternForRegex2, stringBuilder2.toString()) == ValidationResult.TOO_LONG) {
                        stringBuilder.append(stringBuilder4);
                        if (z) {
                            phoneNumber.setCountryCodeSource(CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.setCountryCode(i);
                        return i;
                    }
                }
            }
            phoneNumber.setCountryCode(0);
            return 0;
        } else if (stringBuilder2.length() <= 2) {
            throw new NumberParseException(ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        } else {
            i = extractCountryCode(stringBuilder2, stringBuilder);
            if (i != 0) {
                phoneNumber.setCountryCode(i);
                return i;
            }
            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
    }

    CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder stringBuilder, String str) {
        if (stringBuilder.length() == 0) {
            return CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(stringBuilder);
        if (matcher.lookingAt()) {
            stringBuilder.delete(0, matcher.end());
            normalize(stringBuilder);
            return CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(str);
        normalize(stringBuilder);
        int i = 0;
        Matcher matcher2 = patternForRegex.matcher(stringBuilder);
        if (matcher2.lookingAt()) {
            int end = matcher2.end();
            Matcher matcher3 = CAPTURING_DIGIT_PATTERN.matcher(stringBuilder.substring(end));
            if (!(matcher3.find() && normalizeDigitsOnly(matcher3.group(1)).equals("0"))) {
                stringBuilder.delete(0, end);
                i = 1;
            }
        }
        return i != 0 ? CountryCodeSource.FROM_NUMBER_WITH_IDD : CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder stringBuilder, PhoneMetadata phoneMetadata, StringBuilder stringBuilder2) {
        int length = stringBuilder.length();
        String str = phoneMetadata.nationalPrefixForParsing_;
        if (length == 0 || str.length() == 0) {
            return false;
        }
        Matcher matcher = this.regexCache.getPatternForRegex(str).matcher(stringBuilder);
        if (!matcher.lookingAt()) {
            return false;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(phoneMetadata.generalDesc_.nationalNumberPattern_);
        boolean matches = patternForRegex.matcher(stringBuilder).matches();
        int groupCount = matcher.groupCount();
        String str2 = phoneMetadata.nationalPrefixTransformRule_;
        if (str2 != null && str2.length() != 0 && matcher.group(groupCount) != null) {
            StringBuilder stringBuilder3 = new StringBuilder(stringBuilder);
            stringBuilder3.replace(0, length, matcher.replaceFirst(str2));
            if (matches && !patternForRegex.matcher(stringBuilder3.toString()).matches()) {
                return false;
            }
            if (stringBuilder2 != null && groupCount > 1) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
            return true;
        } else if (matches && !patternForRegex.matcher(stringBuilder.substring(matcher.end())).matches()) {
            return false;
        } else {
            if (!(stringBuilder2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                stringBuilder2.append(matcher.group(1));
            }
            stringBuilder.delete(0, matcher.end());
            return true;
        }
    }

    String maybeStripExtension(StringBuilder stringBuilder) {
        Matcher matcher = EXTN_PATTERN.matcher(stringBuilder);
        if (matcher.find() && isViablePhoneNumber(stringBuilder.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    stringBuilder.delete(matcher.start(), stringBuilder.length());
                    return group;
                }
            }
        }
        return "";
    }

    private boolean checkRegionForParsing(String str, String str2) {
        if (isValidRegionCode(str2) || (str != null && str.length() != 0 && PLUS_CHARS_PATTERN.matcher(str).lookingAt())) {
            return true;
        }
        return false;
    }

    public PhoneNumber parse(String str, String str2) {
        PhoneNumber phoneNumber = new PhoneNumber();
        parse(str, str2, phoneNumber);
        return phoneNumber;
    }

    public void parse(String str, String str2, PhoneNumber phoneNumber) {
        parseHelper(str, str2, false, true, phoneNumber);
    }

    public PhoneNumber parseAndKeepRawInput(String str, String str2) {
        PhoneNumber phoneNumber = new PhoneNumber();
        parseAndKeepRawInput(str, str2, phoneNumber);
        return phoneNumber;
    }

    public void parseAndKeepRawInput(String str, String str2, PhoneNumber phoneNumber) {
        parseHelper(str, str2, true, true, phoneNumber);
    }

    static void setItalianLeadingZerosForPhoneNumber(String str, PhoneNumber phoneNumber) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            phoneNumber.setItalianLeadingZero(true);
            int i = 1;
            while (i < str.length() - 1 && str.charAt(i) == '0') {
                i++;
            }
            if (i != 1) {
                phoneNumber.setNumberOfLeadingZeros(i);
            }
        }
    }

    private void parseHelper(String str, String str2, boolean z, boolean z2, PhoneNumber phoneNumber) {
        if (str == null) {
            throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (str.length() > 250) {
            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            buildNationalNumberForParsing(str, stringBuilder);
            if (!isViablePhoneNumber(stringBuilder.toString())) {
                throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z2 || checkRegionForParsing(stringBuilder.toString(), str2)) {
                int maybeExtractCountryCode;
                if (z) {
                    phoneNumber.setRawInput(str);
                }
                String maybeStripExtension = maybeStripExtension(stringBuilder);
                if (maybeStripExtension.length() > 0) {
                    phoneNumber.setExtension(maybeStripExtension);
                }
                PhoneMetadata metadataForRegion = getMetadataForRegion(str2);
                StringBuilder stringBuilder2 = new StringBuilder();
                try {
                    maybeExtractCountryCode = maybeExtractCountryCode(stringBuilder.toString(), metadataForRegion, stringBuilder2, z, phoneNumber);
                } catch (NumberParseException e) {
                    Matcher matcher = PLUS_CHARS_PATTERN.matcher(stringBuilder.toString());
                    if (e.getErrorType() == ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                        maybeExtractCountryCode = maybeExtractCountryCode(stringBuilder.substring(matcher.end()), metadataForRegion, stringBuilder2, z, phoneNumber);
                        if (maybeExtractCountryCode == 0) {
                            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    throw new NumberParseException(e.getErrorType(), e.getMessage());
                }
                if (maybeExtractCountryCode != 0) {
                    String regionCodeForCountryCode = getRegionCodeForCountryCode(maybeExtractCountryCode);
                    if (!regionCodeForCountryCode.equals(str2)) {
                        metadataForRegion = getMetadataForRegionOrCallingCode(maybeExtractCountryCode, regionCodeForCountryCode);
                    }
                } else {
                    normalize(stringBuilder);
                    stringBuilder2.append(stringBuilder);
                    if (str2 != null) {
                        phoneNumber.setCountryCode(metadataForRegion.getCountryCode());
                    } else if (z) {
                        phoneNumber.clearCountryCodeSource();
                    }
                }
                if (stringBuilder2.length() < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
                if (metadataForRegion != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    StringBuilder stringBuilder4 = new StringBuilder(stringBuilder2);
                    maybeStripNationalPrefixAndCarrierCode(stringBuilder4, metadataForRegion, stringBuilder3);
                    if (!isShorterThanPossibleNormalNumber(metadataForRegion, stringBuilder4.toString())) {
                        if (z) {
                            phoneNumber.setPreferredDomesticCarrierCode(stringBuilder3.toString());
                        }
                        stringBuilder2 = stringBuilder4;
                    }
                }
                maybeExtractCountryCode = stringBuilder2.length();
                if (maybeExtractCountryCode < 2) {
                    throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                } else if (maybeExtractCountryCode > 17) {
                    throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                } else {
                    setItalianLeadingZerosForPhoneNumber(stringBuilder2.toString(), phoneNumber);
                    phoneNumber.setNationalNumber(Long.parseLong(stringBuilder2.toString()));
                }
            } else {
                throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        }
    }

    private void buildNationalNumberForParsing(String str, StringBuilder stringBuilder) {
        int i;
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf > 0) {
            i = indexOf + 15;
            if (str.charAt(i) == '+') {
                int indexOf2 = str.indexOf(59, i);
                if (indexOf2 > 0) {
                    stringBuilder.append(str.substring(i, indexOf2));
                } else {
                    stringBuilder.append(str.substring(i));
                }
            }
            i = str.indexOf("tel:");
            stringBuilder.append(str.substring(i >= 0 ? i + 4 : 0, indexOf));
        } else {
            String substring;
            Matcher matcher = VALID_START_CHAR_PATTERN.matcher(str);
            if (matcher.find()) {
                substring = str.substring(matcher.start());
                Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(substring);
                if (matcher2.find()) {
                    substring = substring.substring(0, matcher2.start());
                    logger.log(Level.FINER, "Stripped trailing characters: " + substring);
                }
                matcher2 = SECOND_NUMBER_START_PATTERN.matcher(substring);
                if (matcher2.find()) {
                    substring = substring.substring(0, matcher2.start());
                }
            } else {
                substring = "";
            }
            stringBuilder.append(substring);
        }
        i = stringBuilder.indexOf(";isub=");
        if (i > 0) {
            stringBuilder.delete(i, stringBuilder.length());
        }
    }
}
