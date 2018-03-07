package com.facebook.phonenumbers;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* compiled from: datr */
public final class Phonemetadata {

    /* compiled from: datr */
    public class NumberFormat implements Externalizable {
        public String domesticCarrierCodeFormattingRule_ = "";
        public String format_ = "";
        public boolean hasDomesticCarrierCodeFormattingRule;
        public boolean hasFormat;
        public boolean hasNationalPrefixFormattingRule;
        public boolean hasNationalPrefixOptionalWhenFormatting;
        public boolean hasPattern;
        private List<String> leadingDigitsPattern_ = new ArrayList();
        public String nationalPrefixFormattingRule_ = "";
        public boolean nationalPrefixOptionalWhenFormatting_ = false;
        public String pattern_ = "";

        /* compiled from: datr */
        public final class Builder extends NumberFormat {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public int leadingDigitsPatternSize() {
            return this.leadingDigitsPattern_.size();
        }

        public String getLeadingDigitsPattern(int i) {
            return (String) this.leadingDigitsPattern_.get(i);
        }

        public void writeExternal(ObjectOutput objectOutput) {
            objectOutput.writeUTF(this.pattern_);
            objectOutput.writeUTF(this.format_);
            int leadingDigitsPatternSize = leadingDigitsPatternSize();
            objectOutput.writeInt(leadingDigitsPatternSize);
            for (int i = 0; i < leadingDigitsPatternSize; i++) {
                objectOutput.writeUTF((String) this.leadingDigitsPattern_.get(i));
            }
            objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
            if (this.hasNationalPrefixFormattingRule) {
                objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
            }
            objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
            if (this.hasDomesticCarrierCodeFormattingRule) {
                objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
            }
            objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
        }

        public void readExternal(ObjectInput objectInput) {
            String readUTF = objectInput.readUTF();
            this.hasPattern = true;
            this.pattern_ = readUTF;
            readUTF = objectInput.readUTF();
            this.hasFormat = true;
            this.format_ = readUTF;
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                this.leadingDigitsPattern_.add(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasNationalPrefixFormattingRule = true;
                this.nationalPrefixFormattingRule_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasDomesticCarrierCodeFormattingRule = true;
                this.domesticCarrierCodeFormattingRule_ = readUTF;
            }
            boolean readBoolean = objectInput.readBoolean();
            this.hasNationalPrefixOptionalWhenFormatting = true;
            this.nationalPrefixOptionalWhenFormatting_ = readBoolean;
        }
    }

    /* compiled from: datr */
    public class PhoneMetadata implements Externalizable {
        private PhoneNumberDesc carrierSpecific_ = null;
        public int countryCode_ = 0;
        private PhoneNumberDesc emergency_ = null;
        public PhoneNumberDesc fixedLine_ = null;
        public PhoneNumberDesc generalDesc_ = null;
        private boolean hasCarrierSpecific;
        public boolean hasCountryCode;
        private boolean hasEmergency;
        private boolean hasFixedLine;
        private boolean hasGeneralDesc;
        public boolean hasId;
        private boolean hasInternationalPrefix;
        public boolean hasLeadingDigits;
        public boolean hasLeadingZeroPossible;
        public boolean hasMainCountryForCode;
        private boolean hasMobile;
        public boolean hasMobileNumberPortableRegion;
        public boolean hasNationalPrefix;
        public boolean hasNationalPrefixForParsing;
        public boolean hasNationalPrefixTransformRule;
        private boolean hasNoInternationalDialling;
        private boolean hasPager;
        private boolean hasPersonalNumber;
        public boolean hasPreferredExtnPrefix;
        public boolean hasPreferredInternationalPrefix;
        private boolean hasPremiumRate;
        public boolean hasSameMobileAndFixedLinePattern;
        private boolean hasSharedCost;
        private boolean hasShortCode;
        private boolean hasStandardRate;
        private boolean hasTollFree;
        private boolean hasUan;
        private boolean hasVoicemail;
        private boolean hasVoip;
        public String id_ = "";
        public String internationalPrefix_ = "";
        public List<NumberFormat> intlNumberFormat_ = new ArrayList();
        public String leadingDigits_ = "";
        public boolean leadingZeroPossible_ = false;
        public boolean mainCountryForCode_ = false;
        public boolean mobileNumberPortableRegion_ = false;
        public PhoneNumberDesc mobile_ = null;
        public String nationalPrefixForParsing_ = "";
        public String nationalPrefixTransformRule_ = "";
        public String nationalPrefix_ = "";
        private PhoneNumberDesc noInternationalDialling_ = null;
        public List<NumberFormat> numberFormat_ = new ArrayList();
        public PhoneNumberDesc pager_ = null;
        public PhoneNumberDesc personalNumber_ = null;
        public String preferredExtnPrefix_ = "";
        public String preferredInternationalPrefix_ = "";
        public PhoneNumberDesc premiumRate_ = null;
        public boolean sameMobileAndFixedLinePattern_ = false;
        public PhoneNumberDesc sharedCost_ = null;
        private PhoneNumberDesc shortCode_ = null;
        private PhoneNumberDesc standardRate_ = null;
        public PhoneNumberDesc tollFree_ = null;
        public PhoneNumberDesc uan_ = null;
        public PhoneNumberDesc voicemail_ = null;
        public PhoneNumberDesc voip_ = null;

        /* compiled from: datr */
        public final class Builder extends PhoneMetadata {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public PhoneMetadata setGeneralDesc(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasGeneralDesc = true;
            this.generalDesc_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setFixedLine(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasFixedLine = true;
            this.fixedLine_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setMobile(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasMobile = true;
            this.mobile_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setTollFree(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasTollFree = true;
            this.tollFree_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setPremiumRate(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasPremiumRate = true;
            this.premiumRate_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setSharedCost(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasSharedCost = true;
            this.sharedCost_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setPersonalNumber(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasPersonalNumber = true;
            this.personalNumber_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setVoip(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasVoip = true;
            this.voip_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setPager(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasPager = true;
            this.pager_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setUan(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasUan = true;
            this.uan_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setEmergency(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasEmergency = true;
            this.emergency_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setVoicemail(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasVoicemail = true;
            this.voicemail_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setShortCode(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasShortCode = true;
            this.shortCode_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setStandardRate(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasStandardRate = true;
            this.standardRate_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setCarrierSpecific(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasCarrierSpecific = true;
            this.carrierSpecific_ = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc == null) {
                throw new NullPointerException();
            }
            this.hasNoInternationalDialling = true;
            this.noInternationalDialling_ = phoneNumberDesc;
            return this;
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public PhoneMetadata setInternationalPrefix(String str) {
            this.hasInternationalPrefix = true;
            this.internationalPrefix_ = str;
            return this;
        }

        public int intlNumberFormatSize() {
            return this.intlNumberFormat_.size();
        }

        public void writeExternal(ObjectOutput objectOutput) {
            int i;
            int i2 = 0;
            objectOutput.writeBoolean(this.hasGeneralDesc);
            if (this.hasGeneralDesc) {
                this.generalDesc_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasFixedLine);
            if (this.hasFixedLine) {
                this.fixedLine_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasMobile);
            if (this.hasMobile) {
                this.mobile_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasTollFree);
            if (this.hasTollFree) {
                this.tollFree_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPremiumRate);
            if (this.hasPremiumRate) {
                this.premiumRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasSharedCost);
            if (this.hasSharedCost) {
                this.sharedCost_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPersonalNumber);
            if (this.hasPersonalNumber) {
                this.personalNumber_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoip);
            if (this.hasVoip) {
                this.voip_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPager);
            if (this.hasPager) {
                this.pager_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasUan);
            if (this.hasUan) {
                this.uan_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasEmergency);
            if (this.hasEmergency) {
                this.emergency_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoicemail);
            if (this.hasVoicemail) {
                this.voicemail_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasShortCode);
            if (this.hasShortCode) {
                this.shortCode_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasStandardRate);
            if (this.hasStandardRate) {
                this.standardRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasCarrierSpecific);
            if (this.hasCarrierSpecific) {
                this.carrierSpecific_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasNoInternationalDialling);
            if (this.hasNoInternationalDialling) {
                this.noInternationalDialling_.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.id_);
            objectOutput.writeInt(this.countryCode_);
            objectOutput.writeUTF(this.internationalPrefix_);
            objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
            if (this.hasPreferredInternationalPrefix) {
                objectOutput.writeUTF(this.preferredInternationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefix);
            if (this.hasNationalPrefix) {
                objectOutput.writeUTF(this.nationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
            if (this.hasPreferredExtnPrefix) {
                objectOutput.writeUTF(this.preferredExtnPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
            if (this.hasNationalPrefixForParsing) {
                objectOutput.writeUTF(this.nationalPrefixForParsing_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
            if (this.hasNationalPrefixTransformRule) {
                objectOutput.writeUTF(this.nationalPrefixTransformRule_);
            }
            objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
            int size = this.numberFormat_.size();
            objectOutput.writeInt(size);
            for (i = 0; i < size; i++) {
                ((NumberFormat) this.numberFormat_.get(i)).writeExternal(objectOutput);
            }
            i = intlNumberFormatSize();
            objectOutput.writeInt(i);
            while (i2 < i) {
                ((NumberFormat) this.intlNumberFormat_.get(i2)).writeExternal(objectOutput);
                i2++;
            }
            objectOutput.writeBoolean(this.mainCountryForCode_);
            objectOutput.writeBoolean(this.hasLeadingDigits);
            if (this.hasLeadingDigits) {
                objectOutput.writeUTF(this.leadingDigits_);
            }
            objectOutput.writeBoolean(this.leadingZeroPossible_);
            objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
        }

        public void readExternal(ObjectInput objectInput) {
            int i = 0;
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setGeneralDesc(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setFixedLine(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setMobile(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setTollFree(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setPremiumRate(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setSharedCost(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setPersonalNumber(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setVoip(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setPager(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setUan(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setEmergency(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setVoicemail(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setShortCode(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setStandardRate(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setCarrierSpecific(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setNoInternationalDialling(phoneNumberDesc);
            }
            String readUTF = objectInput.readUTF();
            this.hasId = true;
            this.id_ = readUTF;
            int readInt = objectInput.readInt();
            this.hasCountryCode = true;
            this.countryCode_ = readInt;
            setInternationalPrefix(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasPreferredInternationalPrefix = true;
                this.preferredInternationalPrefix_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasNationalPrefix = true;
                this.nationalPrefix_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasPreferredExtnPrefix = true;
                this.preferredExtnPrefix_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasNationalPrefixForParsing = true;
                this.nationalPrefixForParsing_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasNationalPrefixTransformRule = true;
                this.nationalPrefixTransformRule_ = readUTF;
            }
            boolean readBoolean = objectInput.readBoolean();
            this.hasSameMobileAndFixedLinePattern = true;
            this.sameMobileAndFixedLinePattern_ = readBoolean;
            int readInt2 = objectInput.readInt();
            for (readInt = 0; readInt < readInt2; readInt++) {
                NumberFormat numberFormat = new NumberFormat();
                numberFormat.readExternal(objectInput);
                this.numberFormat_.add(numberFormat);
            }
            readInt = objectInput.readInt();
            while (i < readInt) {
                NumberFormat numberFormat2 = new NumberFormat();
                numberFormat2.readExternal(objectInput);
                this.intlNumberFormat_.add(numberFormat2);
                i++;
            }
            boolean readBoolean2 = objectInput.readBoolean();
            this.hasMainCountryForCode = true;
            this.mainCountryForCode_ = readBoolean2;
            if (objectInput.readBoolean()) {
                String readUTF2 = objectInput.readUTF();
                this.hasLeadingDigits = true;
                this.leadingDigits_ = readUTF2;
            }
            readBoolean2 = objectInput.readBoolean();
            this.hasLeadingZeroPossible = true;
            this.leadingZeroPossible_ = readBoolean2;
            readBoolean2 = objectInput.readBoolean();
            this.hasMobileNumberPortableRegion = true;
            this.mobileNumberPortableRegion_ = readBoolean2;
        }
    }

    /* compiled from: datr */
    public class PhoneMetadataCollection implements Externalizable {
        public List<PhoneMetadata> metadata_ = new ArrayList();

        /* compiled from: datr */
        public final class Builder extends PhoneMetadataCollection {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public List<PhoneMetadata> getMetadataList() {
            return this.metadata_;
        }

        public void writeExternal(ObjectOutput objectOutput) {
            int size = this.metadata_.size();
            objectOutput.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((PhoneMetadata) this.metadata_.get(i)).writeExternal(objectOutput);
            }
        }

        public void readExternal(ObjectInput objectInput) {
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                PhoneMetadata phoneMetadata = new PhoneMetadata();
                phoneMetadata.readExternal(objectInput);
                this.metadata_.add(phoneMetadata);
            }
        }
    }

    /* compiled from: datr */
    public class PhoneNumberDesc implements Externalizable {
        public String exampleNumber_ = "";
        public boolean hasExampleNumber;
        public boolean hasNationalNumberPattern;
        public boolean hasPossibleNumberPattern;
        public String nationalNumberPattern_ = "";
        public String possibleNumberPattern_ = "";

        /* compiled from: datr */
        public final class Builder extends PhoneNumberDesc {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public void writeExternal(ObjectOutput objectOutput) {
            objectOutput.writeBoolean(this.hasNationalNumberPattern);
            if (this.hasNationalNumberPattern) {
                objectOutput.writeUTF(this.nationalNumberPattern_);
            }
            objectOutput.writeBoolean(this.hasPossibleNumberPattern);
            if (this.hasPossibleNumberPattern) {
                objectOutput.writeUTF(this.possibleNumberPattern_);
            }
            objectOutput.writeBoolean(this.hasExampleNumber);
            if (this.hasExampleNumber) {
                objectOutput.writeUTF(this.exampleNumber_);
            }
        }

        public void readExternal(ObjectInput objectInput) {
            if (objectInput.readBoolean()) {
                String readUTF = objectInput.readUTF();
                this.hasNationalNumberPattern = true;
                this.nationalNumberPattern_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasPossibleNumberPattern = true;
                this.possibleNumberPattern_ = readUTF;
            }
            if (objectInput.readBoolean()) {
                readUTF = objectInput.readUTF();
                this.hasExampleNumber = true;
                this.exampleNumber_ = readUTF;
            }
        }
    }

    private Phonemetadata() {
    }
}
