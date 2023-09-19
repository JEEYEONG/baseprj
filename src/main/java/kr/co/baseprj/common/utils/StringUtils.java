package kr.co.baseprj.common.utils;

import java.text.DecimalFormat;

public class StringUtils {

    /**
     * 입력된 문자에 length 길이 만큼 오른쪽에 공백 문자열을 붙여서 리턴한다.
     * @param str
     * @param length
     * @return
     */
    public static String strRightSpace(String str, int length) {
        int strLength = str.length();
        if(strLength >= length) {
            return str;
        }else{
            int spaceLength = length - strLength;
            for (int i = 0; i < spaceLength; i++) {
                str = str + " ";
            }
            return str;
        }
    }

    /**
     * 입력된 문자에 length 길이 만큼 왼쪽에 0을 붙여서 리턴한다.
     * @param str
     * @param length
     * @return
     */
    public static String strLeftZero(String str, int length) {
        int strLength = str.length();
        if(strLength >= length) {
            return str;
        }else{
            int spaceLength = length - strLength;
            for (int i = 0; i < spaceLength; i++) {
                str = "0" + str;
            }
            return str;
        }
    }

    /**
     * null 인 문자열을 빈 문자열로 리턴한다.
     * @param str
     * @return
     */
    public static String nullToBlank(String str) {
        String returnStr = "";
        if(str == null){
            returnStr = "";
        }else if(str.equals("null") ){
            returnStr = "";
        }else{
            returnStr = str;
        }
        return returnStr;
    }

    /**
     * 입력한 문자열이 숫자인지 체크
     * @param s
     * @return
     */
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException nfe) {
            return false;
        }
        return true;
    }

    /**
     * 일력한 문자열이 숫자이고 0인지 체크한다.
     * @param s
     * @return
     */
    public static boolean isNumericZero(String s) {
        try {
            if(Integer.parseInt(s) == 0) {
                return true;
            }else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException nfe) {
            return false;
        }
    }

    /**
     * 입력한 문자열이 null이나 빈 문자열인지 체크한다.
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if(str == null || str.equals("")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 입력한 문자열이 null이거나 빈 문자열이면 0을 리턴한다.
     * @param str
     * @return
     */
    public static String nullToZero(String str) {
        String result = str;
        if(str == null || str.trim().equals("")){
            result = "0";
        }
        return result;
    }
    /**
     * 입력한 문자열을 8의배수 길이만큼 빈값을 채워준다
     * @param str
     * @return
     */
    public static String eightRpad(String str) {
        String resultStr = "";
        int length = str.length() / 8;
        int lengthMod = str.length() % 8;
        int rPadLength = 0;
        if(lengthMod != 0) {
            rPadLength = (8 * length) + 8;
        }else {
            rPadLength = (8 * length);
        }
        resultStr = strRightSpace(str, rPadLength);

        return resultStr;
    }

    /**
     * 문자열을 byte로 바꿔서 substring 해준다.
     * @param str
     * @param sPoint 시작길이
     * @param length substring할 길이
     * @return
     */
    public static String substringFromByte(String str, int sPoint, int length){
        try {
            String EncodingLang = "euc-kr";
            byte[] bytes = str.getBytes("euc-kr");

            byte[] value = new byte[length];

            if(bytes.length < sPoint + length){
                return "";
            }

            for(int i = 0; i < length; i++){
                value[i] = bytes[sPoint + i];
            }

            return new String(value, EncodingLang).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 문자열중 뒤의 length 길이를 제외한 나마지를 다른 문자열로 치환한다
     * @param str
     * @param length
     * @return
     */
    public static String leftStringReplace(String str,String replaceStr, int length) {

        String resultStr = "";
        try {
            int strLen = str.length();

            if(strLen >= length) {
                for(int i = 0; i < strLen - 4;i++) {
                    resultStr += replaceStr;
                }
                resultStr += str.substring(strLen-length, strLen);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }


        return resultStr;
    }

    /**
     * 문자열의 마지막 문자열을 리턴한다.
     * @param str
     * @return
     */
    public static String getLastString(String str){
        String last = "";
        try {
            if(!StringUtils.isEmpty(str) && str.length() > 1){
                last = str.substring(str.length() - 1);
            }else{
                last = str;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

        return last;
    }

    /**
     * 입력한 문자열의 마지막 문자열이 두번째 문자열과 같으면 마지막 문자열을 삭제하고 나머지 문자열을 리턴한다.
     * @param str
     * @param checkStr
     * @return
     */
    public static String deleteLastCharacter(String str, String checkStr){
        String result = "";
        try {
            String lastChar = getLastString(str);
            if(lastChar.equals(checkStr)){
                result = str.substring(0, str.length() - 1);
            }else{
                result = str;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

        return result;
    }

    /**
     * 입력한 전화번호 사이에 -을 넣어서 리턴해준다.
     * @param src
     * @return
     */
    public static String phoneNumberChange(String src) {
        if (src == null) {
            return "";
        }
        if (src.length() == 8) {
            return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
        } else if (src.length() == 12) {
            return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
        }
        return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    }

    /**
     * 화폐 단위 구분 콤마
     * @param str
     * @return
     */
    public static String numberWithComma(String str){
        System.out.println("str" + str);
        DecimalFormat dc = new DecimalFormat("###,###,###,###");
        String result = dc.format(Integer.parseInt(str));

        return result;

     //   return str;
    }

    /**
     * 입력한 문자열을 숫자로 바꾸고 숫자로 바꿀수 없는 경우 입력한 기본값을 리턴한다.
     * @param number
     * @param defalutValue
     * @return
     */
    public static int getDefaultIntValue(String number, int defaultValue){
        try {
            if(number != null && !number.equals("")){
                return Integer.parseInt(number);
            }else{
                return defaultValue;
            }

        } catch (Exception e) {
            return defaultValue;
        }

    }

    /**
     * 입력한 문자열을 long 타입의 숫자로 바꾸고 숫자로 바꿀수 없는 경우 입력한 기본값을 리턴한다.
     * @param number
     * @param defaultValue
     * @return
     */
    public static long getDefaultLongValue(String number, long defaultValue){
        try {
            if(number != null && !number.equals("")){
                return Long.parseLong(number);
            }else{
                return defaultValue;
            }

        } catch (Exception e) {
            return defaultValue;
        }
    }






    public static void main(String[] args){
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>> : " + getLastString("HSDR201907190003,HSDR201907190003,HSDR201907190003,HSDR201907190003,"));
//
//        String str = ",";
//        System.out.println(">>>>>>>>> : " + deleteLastCharacter(str, ","));
//
//        System.out.println(">>>>>>>>>>>>>>>> : " + phoneNumberChange("01012345678"));
//        System.out.println(">>>>>>>>>>>>>>>> : " + phoneNumberChange("0101245678"));
//        System.out.println(">>>>>>>>>>>>>>>> : " + phoneNumberChange("0212345678"));
        int dbAmountInteger = 2000;
        int kcpAmountInteger = 3000;

        if(dbAmountInteger <= kcpAmountInteger){
            System.out.println("결제 성공!!!!");
        }else{
            System.out.println("결제 실패@@@@@@@@@@@@");

        }
        int reservMgmtUpdateCount = 1;
        if(reservMgmtUpdateCount > 0){
            System.out.println("성공!!!!");
        }else{
            System.out.println("실패!!!!");

        }


    }





















}
