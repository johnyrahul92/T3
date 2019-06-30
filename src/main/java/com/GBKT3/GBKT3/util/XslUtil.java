package com.GBKT3.GBKT3.util;


import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.security.Key;
import java.text.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class XslUtil {
    private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private static final Logger LOG = LoggerFactory.getLogger(XslUtil.class);




    public static String encyrpt(String plainText, String TOKEN) throws Exception {

        Key aesKey = new SecretKeySpec(TOKEN.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
        //noinspection Since15
        return java.util.Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }

    public static String decrypt(String encryptedText, String TOKEN) throws Exception {
        Key aesKey = new SecretKeySpec(TOKEN.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(new byte[16]));
        //noinspection Since15
        return new String(cipher.doFinal(java.util.Base64.getDecoder().decode(encryptedText)));
    }



    public static String trim(String input){
        if(input != null) return input.trim();
        else return "";
    }
    public static String toTimeStamp(String date) {
        return toTimeStampImpl(date, df);
    }

    public static String toTimeStamp(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return toTimeStampImpl(date, dateFormat);
    }

    private static String toTimeStampImpl(String date, DateFormat df) {
        try {
            TimeZone utc = TimeZone.getTimeZone("UTC");
            GregorianCalendar calendar = new GregorianCalendar(utc);
            df.setTimeZone(utc);
            calendar.setTime(df.parse(date));
            return calendar.getTime().getTime() + "";
        } catch (Exception e){
            e.printStackTrace();
            return date;
        }
    }

    public static String toDateFormat(String inputDate, String inputformat, String outputFormat) throws ParseException {

        if (inputDate==null || inputDate.isEmpty() || inputDate.equals("")){
            return "";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(inputformat);
        Date date=dateFormat.parse(inputDate);
        dateFormat= new SimpleDateFormat(outputFormat);
        return dateFormat.format(date);

    }

	public static String encodeJson(String strToEncode) {
        return JSONObject.escape(strToEncode);
    }

    public static String getCurrentDay() {
        return new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date());
    }

    public static String getAmountFormat(String currency) {
        int iFractionDigits = getFractionDigits(currency);
        final StringBuilder result = new StringBuilder("#0.");
        for (int i = 1; i <= iFractionDigits; i ++) {
            result.append("0");
        }
        return result.toString();
    }

    public static int getFractionDigits(String currency) {
        int result = -1;
        if (StringUtils.hasText(currency)) {
            switch (currency.toUpperCase().trim()) {
                case "KWD":
                case "JOD":
                case "OMR":
                case "MUR":
                case "FRX":
                case "HUF":
                case "ISK":
                case "VND":
                    result = 3;
                    break;
                case "TWD":
                case "VUV":
                case "XPF":
                case "BIF":
                case "BYR":
                case "CLP":
                case "DJF":
                case "JPY":
                case "KMF":
                case "KRW":
                    result = 0;
                    break;
                default:
                    result = 2;
            }
        }
        return result;
    }


    public static String formatAmount(String amount, String currency) {
        String result = "";
        if (StringUtils.hasText(amount) && StringUtils.hasText(currency)) {
            final NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setGroupingUsed(false);
            nf.setMaximumFractionDigits(getFractionDigits(currency));
            nf.setMinimumFractionDigits(getFractionDigits(currency));
            result = nf.format(Double.parseDouble(amount));
        }
        return result;
    }

    public static String toDefaultDateFormat(String sDate, String currentFormat) {
        String result = "";
        try {
            final DateFormat orgDf = new SimpleDateFormat(currentFormat);
            final Date date = orgDf.parse(sDate);
            result = df.format(date);
        } catch (ParseException ex) {
            LOG.warn(ex.getMessage(), ex);
        }
        return result;
    }

    public static String formatCreditCard(String number) {
        if (number != null && number.length() == 16) {
            final StringBuilder result = new StringBuilder(number);
            result.replace(4, 12, " **** **** ");
            return result.toString();
        } else {
            return number;
        }
    }

    public static String html2text(String html) {
        String htmlText =  Jsoup.parse(html).text();
        return htmlText;
    }

    public static String splitLoanDescription(String desc,int i) {

        String[] splited = desc.trim().split("\\s\\s+");
        String text="";
        if (splited.length>i) {
            text= splited[i];
        }

        return text;
    }

    public static String roundOf(String d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd+"";
    }


    public static String getLoanDate(){


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return dateFormat.format(new Date());


    }

    public static String getInterestRate(String interestrate){
        String stringArray[] =  interestrate.split("\\.");
        String initialValue = stringArray[0];
        double rate = Double.parseDouble(initialValue)/1000;
        DecimalFormat df = new DecimalFormat("###.###");
        double newInterestRate = Double.parseDouble(df.format(rate));
        return String.valueOf(newInterestRate);
    }

    public static String getDateFormat(String date){

        return date.substring(0, 2) + '/' + date.substring(2,4)+ '/'+ date.substring(4);
    }

}
