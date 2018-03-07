package com.facebook.phonenumbers;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.phonenumbers.Phonemetadata.NumberFormat;
import com.facebook.phonenumbers.Phonemetadata.PhoneMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: dbl_check_nonce */
public class AsYouTypeFormatter {
    public static final Pattern CHARACTER_CLASS_PATTERN = Pattern.compile("\\[([^\\[\\]])*\\]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile(" ");
    public static final Pattern ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]*)+");
    private static final PhoneMetadata EMPTY_METADATA = new PhoneMetadata().setInternationalPrefix("NA");
    private static final Pattern NATIONAL_PREFIX_SEPARATORS_PATTERN = Pattern.compile("[- ]");
    public static final Pattern STANDALONE_DIGIT_PATTERN = Pattern.compile("\\d(?=[^,}][^,}])");
    private boolean ableToFormat = true;
    public StringBuilder accruedInput = new StringBuilder();
    private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
    private String currentFormattingPattern = "";
    public PhoneMetadata currentMetadata;
    private String currentOutput = "";
    private String defaultCountry;
    private PhoneMetadata defaultMetadata;
    private String extractedNationalPrefix = "";
    public StringBuilder formattingTemplate = new StringBuilder();
    private boolean inputHasFormatting = false;
    private boolean isCompleteNumber = false;
    private boolean isExpectingCountryCallingCode = false;
    private int lastMatchPosition = 0;
    public StringBuilder nationalNumber = new StringBuilder();
    private int originalPosition = 0;
    private final PhoneNumberUtil phoneUtil;
    private int positionToRemember = 0;
    private List<NumberFormat> possibleFormats = new ArrayList();
    private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
    public RegexCache regexCache = new RegexCache(64);
    private boolean shouldAddSpaceAfterNationalPrefix = false;

    public AsYouTypeFormatter(String str, PhoneNumberUtil phoneNumberUtil) {
        this.phoneUtil = phoneNumberUtil;
        this.defaultCountry = str;
        this.currentMetadata = getMetadataForRegion(this.defaultCountry);
        this.defaultMetadata = this.currentMetadata;
    }

    private PhoneMetadata getMetadataForRegion(String str) {
        PhoneMetadata metadataForRegion = this.phoneUtil.getMetadataForRegion(this.phoneUtil.getRegionCodeForCountryCode(this.phoneUtil.getCountryCodeForRegion(str)));
        return metadataForRegion != null ? metadataForRegion : EMPTY_METADATA;
    }

    private boolean maybeCreateNewTemplate() {
        Iterator it = this.possibleFormats.iterator();
        while (it.hasNext()) {
            NumberFormat numberFormat = (NumberFormat) it.next();
            String str = numberFormat.pattern_;
            if (this.currentFormattingPattern.equals(str)) {
                return false;
            }
            int i = 0;
            String str2 = numberFormat.pattern_;
            if (str2.indexOf(124) == -1) {
                str2 = STANDALONE_DIGIT_PATTERN.matcher(CHARACTER_CLASS_PATTERN.matcher(str2).replaceAll("\\\\d")).replaceAll("\\\\d");
                this.formattingTemplate.setLength(0);
                String str3 = numberFormat.format_;
                Matcher matcher = this.regexCache.getPatternForRegex(str2).matcher("999999999999999");
                matcher.find();
                String group = matcher.group();
                if (group.length() < this.nationalNumber.length()) {
                    group = "";
                } else {
                    group = group.replaceAll(str2, str3).replaceAll("9", " ");
                }
                str2 = group;
                if (str2.length() > 0) {
                    this.formattingTemplate.append(str2);
                    i = 1;
                }
            }
            if (i != 0) {
                this.currentFormattingPattern = str;
                this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(numberFormat.nationalPrefixFormattingRule_).find();
                this.lastMatchPosition = 0;
                return true;
            }
            it.remove();
        }
        this.ableToFormat = false;
        return false;
    }

    private void getAvailableFormats(String str) {
        List list;
        if (!this.isCompleteNumber || this.currentMetadata.intlNumberFormatSize() <= 0) {
            list = this.currentMetadata.numberFormat_;
        } else {
            list = this.currentMetadata.intlNumberFormat_;
        }
        boolean z = this.currentMetadata.hasNationalPrefix;
        for (NumberFormat numberFormat : r0) {
            if (!(!z || this.isCompleteNumber || numberFormat.nationalPrefixOptionalWhenFormatting_)) {
                Object obj;
                String str2 = numberFormat.nationalPrefixFormattingRule_;
                if (str2.length() == 0 || PhoneNumberUtil.FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(str2).matches()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                }
            }
            if (ELIGIBLE_FORMAT_PATTERN.matcher(numberFormat.format_).matches()) {
                this.possibleFormats.add(numberFormat);
            }
        }
        narrowDownPossibleFormats(str);
    }

    private void narrowDownPossibleFormats(String str) {
        int length = str.length() - 3;
        Iterator it = this.possibleFormats.iterator();
        while (it.hasNext()) {
            NumberFormat numberFormat = (NumberFormat) it.next();
            if (numberFormat.leadingDigitsPatternSize() != 0) {
                if (!this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(Math.min(length, numberFormat.leadingDigitsPatternSize() - 1))).matcher(str).lookingAt()) {
                    it.remove();
                }
            }
        }
    }

    public void clear() {
        this.currentOutput = "";
        this.accruedInput.setLength(0);
        this.accruedInputWithoutFormatting.setLength(0);
        this.formattingTemplate.setLength(0);
        this.lastMatchPosition = 0;
        this.currentFormattingPattern = "";
        this.prefixBeforeNationalNumber.setLength(0);
        this.extractedNationalPrefix = "";
        this.nationalNumber.setLength(0);
        this.ableToFormat = true;
        this.inputHasFormatting = false;
        this.positionToRemember = 0;
        this.originalPosition = 0;
        this.isCompleteNumber = false;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.shouldAddSpaceAfterNationalPrefix = false;
        if (!this.currentMetadata.equals(this.defaultMetadata)) {
            this.currentMetadata = getMetadataForRegion(this.defaultCountry);
        }
    }

    public String inputDigit(char c) {
        this.currentOutput = inputDigitWithOptionToRememberPosition(c, false);
        return this.currentOutput;
    }

    public String inputDigitAndRememberPosition(char c) {
        this.currentOutput = inputDigitWithOptionToRememberPosition(c, true);
        return this.currentOutput;
    }

    private String inputDigitWithOptionToRememberPosition(char c, boolean z) {
        this.accruedInput.append(c);
        if (z) {
            this.originalPosition = this.accruedInput.length();
        }
        Object obj = 1;
        if (!(Character.isDigit(c) || (this.accruedInput.length() == 1 && PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(c)).matches()))) {
            obj = null;
        }
        if (obj == null) {
            this.ableToFormat = false;
            this.inputHasFormatting = true;
        } else {
            c = normalizeAndAccrueDigitsAndPlusSign(c, z);
        }
        if (this.ableToFormat) {
            switch (this.accruedInputWithoutFormatting.length()) {
                case 0:
                case 1:
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    return this.accruedInput.toString();
                case 3:
                    if (attemptToExtractIdd()) {
                        this.isExpectingCountryCallingCode = true;
                        break;
                    }
                    this.extractedNationalPrefix = removeNationalPrefixFromNationalNumber();
                    return attemptToChooseFormattingPattern();
            }
            if (this.isExpectingCountryCallingCode) {
                if (attemptToExtractCountryCallingCode()) {
                    this.isExpectingCountryCallingCode = false;
                }
                return this.prefixBeforeNationalNumber + this.nationalNumber.toString();
            } else if (this.possibleFormats.size() <= 0) {
                return attemptToChooseFormattingPattern();
            } else {
                String inputDigitHelper = inputDigitHelper(c);
                String attemptToFormatAccruedDigits = attemptToFormatAccruedDigits();
                if (attemptToFormatAccruedDigits.length() > 0) {
                    return attemptToFormatAccruedDigits;
                }
                narrowDownPossibleFormats(this.nationalNumber.toString());
                if (maybeCreateNewTemplate()) {
                    return inputAccruedNationalNumber();
                }
                return this.ableToFormat ? appendNationalNumber(inputDigitHelper) : this.accruedInput.toString();
            }
        } else if (this.inputHasFormatting) {
            return this.accruedInput.toString();
        } else {
            if (attemptToExtractIdd()) {
                if (attemptToExtractCountryCallingCode()) {
                    return attemptToChoosePatternWithPrefixExtracted();
                }
            } else if (ableToExtractLongerNdd()) {
                this.prefixBeforeNationalNumber.append(' ');
                return attemptToChoosePatternWithPrefixExtracted();
            }
            return this.accruedInput.toString();
        }
    }

    private String attemptToChoosePatternWithPrefixExtracted() {
        this.ableToFormat = true;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        return attemptToChooseFormattingPattern();
    }

    private boolean ableToExtractLongerNdd() {
        if (this.extractedNationalPrefix.length() > 0) {
            this.nationalNumber.insert(0, this.extractedNationalPrefix);
            this.prefixBeforeNationalNumber.setLength(this.prefixBeforeNationalNumber.lastIndexOf(this.extractedNationalPrefix));
        }
        if (this.extractedNationalPrefix.equals(removeNationalPrefixFromNationalNumber())) {
            return false;
        }
        return true;
    }

    String attemptToFormatAccruedDigits() {
        for (NumberFormat numberFormat : this.possibleFormats) {
            Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.pattern_).matcher(this.nationalNumber);
            if (matcher.matches()) {
                this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(numberFormat.nationalPrefixFormattingRule_).find();
                return appendNationalNumber(matcher.replaceAll(numberFormat.format_));
            }
        }
        return "";
    }

    public int getRememberedPosition() {
        int i = 0;
        if (!this.ableToFormat) {
            return this.originalPosition;
        }
        int i2 = 0;
        while (i2 < this.positionToRemember && i < this.currentOutput.length()) {
            if (this.accruedInputWithoutFormatting.charAt(i2) == this.currentOutput.charAt(i)) {
                i2++;
            }
            i++;
        }
        return i;
    }

    private String appendNationalNumber(String str) {
        int length = this.prefixBeforeNationalNumber.length();
        if (!this.shouldAddSpaceAfterNationalPrefix || length <= 0 || this.prefixBeforeNationalNumber.charAt(length - 1) == ' ') {
            return this.prefixBeforeNationalNumber + str;
        }
        return new String(this.prefixBeforeNationalNumber) + ' ' + str;
    }

    private String attemptToChooseFormattingPattern() {
        if (this.nationalNumber.length() < 3) {
            return appendNationalNumber(this.nationalNumber.toString());
        }
        getAvailableFormats(this.nationalNumber.toString());
        String attemptToFormatAccruedDigits = attemptToFormatAccruedDigits();
        if (attemptToFormatAccruedDigits.length() > 0) {
            return attemptToFormatAccruedDigits;
        }
        return maybeCreateNewTemplate() ? inputAccruedNationalNumber() : this.accruedInput.toString();
    }

    private String inputAccruedNationalNumber() {
        int length = this.nationalNumber.length();
        if (length <= 0) {
            return this.prefixBeforeNationalNumber.toString();
        }
        String str = "";
        for (int i = 0; i < length; i++) {
            str = inputDigitHelper(this.nationalNumber.charAt(i));
        }
        return this.ableToFormat ? appendNationalNumber(str) : this.accruedInput.toString();
    }

    private String removeNationalPrefixFromNationalNumber() {
        int i = 1;
        int i2 = 1;
        if (this.currentMetadata.countryCode_ != 1 || this.nationalNumber.charAt(0) != '1' || this.nationalNumber.charAt(1) == '0' || this.nationalNumber.charAt(1) == '1') {
            i2 = 0;
        }
        if (i2 != 0) {
            this.prefixBeforeNationalNumber.append('1').append(' ');
            this.isCompleteNumber = true;
        } else {
            if (this.currentMetadata.hasNationalPrefixForParsing) {
                Matcher matcher = this.regexCache.getPatternForRegex(this.currentMetadata.nationalPrefixForParsing_).matcher(this.nationalNumber);
                if (matcher.lookingAt() && matcher.end() > 0) {
                    this.isCompleteNumber = true;
                    i = matcher.end();
                    this.prefixBeforeNationalNumber.append(this.nationalNumber.substring(0, i));
                }
            }
            i = 0;
        }
        String substring = this.nationalNumber.substring(0, i);
        this.nationalNumber.delete(0, i);
        return substring;
    }

    private boolean attemptToExtractIdd() {
        Matcher matcher = this.regexCache.getPatternForRegex("\\+|" + this.currentMetadata.internationalPrefix_).matcher(this.accruedInputWithoutFormatting);
        if (!matcher.lookingAt()) {
            return false;
        }
        this.isCompleteNumber = true;
        int end = matcher.end();
        this.nationalNumber.setLength(0);
        this.nationalNumber.append(this.accruedInputWithoutFormatting.substring(end));
        this.prefixBeforeNationalNumber.setLength(0);
        this.prefixBeforeNationalNumber.append(this.accruedInputWithoutFormatting.substring(0, end));
        if (this.accruedInputWithoutFormatting.charAt(0) == '+') {
            return true;
        }
        this.prefixBeforeNationalNumber.append(' ');
        return true;
    }

    private boolean attemptToExtractCountryCallingCode() {
        if (this.nationalNumber.length() == 0) {
            return false;
        }
        CharSequence stringBuilder = new StringBuilder();
        int extractCountryCode = this.phoneUtil.extractCountryCode(this.nationalNumber, stringBuilder);
        if (extractCountryCode == 0) {
            return false;
        }
        this.nationalNumber.setLength(0);
        this.nationalNumber.append(stringBuilder);
        String regionCodeForCountryCode = this.phoneUtil.getRegionCodeForCountryCode(extractCountryCode);
        if ("001".equals(regionCodeForCountryCode)) {
            this.currentMetadata = this.phoneUtil.getMetadataForNonGeographicalRegion(extractCountryCode);
        } else if (!regionCodeForCountryCode.equals(this.defaultCountry)) {
            this.currentMetadata = getMetadataForRegion(regionCodeForCountryCode);
        }
        this.prefixBeforeNationalNumber.append(Integer.toString(extractCountryCode)).append(' ');
        this.extractedNationalPrefix = "";
        return true;
    }

    private char normalizeAndAccrueDigitsAndPlusSign(char c, boolean z) {
        if (c == '+') {
            this.accruedInputWithoutFormatting.append(c);
        } else {
            c = Character.forDigit(Character.digit(c, 10), 10);
            this.accruedInputWithoutFormatting.append(c);
            this.nationalNumber.append(c);
        }
        if (z) {
            this.positionToRemember = this.accruedInputWithoutFormatting.length();
        }
        return c;
    }

    private String inputDigitHelper(char c) {
        Matcher matcher = DIGIT_PATTERN.matcher(this.formattingTemplate);
        if (matcher.find(this.lastMatchPosition)) {
            String replaceFirst = matcher.replaceFirst(Character.toString(c));
            this.formattingTemplate.replace(0, replaceFirst.length(), replaceFirst);
            this.lastMatchPosition = matcher.start();
            return this.formattingTemplate.substring(0, this.lastMatchPosition + 1);
        }
        if (this.possibleFormats.size() == 1) {
            this.ableToFormat = false;
        }
        this.currentFormattingPattern = "";
        return this.accruedInput.toString();
    }
}
