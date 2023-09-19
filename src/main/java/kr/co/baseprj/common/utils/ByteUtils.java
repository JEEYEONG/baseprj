package kr.co.baseprj.common.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtils {

    /**
     * 입력한 byte 배열을 char ascii 문자로 바꾸고 String으로 리턴한다.
     * @param param
     * @return
     */
    public static String byteToHexAsciiString(byte[] param) {
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < param.length; i++) {
//            System.out.println("변환값 (" + i + ") : " + Character.toString((char)param[i]));
            output.append(Character.toString((char)param[i]));
        }

        return output.toString();
    }

    /**
     * 입력한 길이 만큼 배열을 생성하고 param 배열을 복사 한 후 남은 자리를 0x00으로 채운다.
     * @param param
     * @param length
     * @return
     */
    public static byte[] byteArrayAddNullValue(byte[] param, int length){
        byte[] bytes = new byte[length];

        if(param.length > length){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return param;
        }

        int paramLength = param.length;

        int reaminLength = paramLength - length;

        for (int i = 0; i < paramLength; i++) {
            bytes[i] = param[i];
        }

        for (int i = 0; i < reaminLength; i++) {
            int index = paramLength + i;
            bytes[paramLength] = 0x00;
        }

        return bytes;
    }

    /**
     * 입력한 숫자 만큼 바이트 배열을 생성하고 0x00으로 채워서 리턴한다.
     * @param length
     * @return
     */
    public static byte[] byteArraySetNullValue(int length){
        byte[] bytes = new byte[length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = 0x00;
        }

        return bytes;
    }




    public static String byteToHexString(byte pram){
        String str = "";

        str = Integer.toString(((pram & 0xff)+0x100),16).substring(1);

        return str;
    }

    public static String byteArrayToHexString(byte[] bytes){

        StringBuilder sb = new StringBuilder();

        for(byte b : bytes){

            sb.append(String.format("%02X", b&0xff));
            sb.append(" ");
        }

        return sb.toString();
    }
    
    /**
     * byte배열을 String  형태로 출력해준다. 
     * 예 : 01 02 03 04
     * @param params
     * @return
     */
    public static String byteArrayToString(byte[] params){
        StringBuffer paramStr = new StringBuffer();
        for (int i = 0; i < params.length; i++){
            paramStr.append(byteToHexString(params[i]) + " ");
        }

        return paramStr.toString();
    }

    /**
     * 입력한 숫자를 그대로 byte형태로 변환해 준다.
     * @param num
     * @return
     */
    public static byte intToHexByte(String num){
        return (byte) (Integer.parseInt(StringUtils.nullToZero(num), 16) & 0xFF);
    }


    /**
     * int형을 byte배열로 바꿈<br>
     * @param integer
     * @param order
     * @return
     */
    public static byte[] intTobyte(int integer, ByteOrder order) {

        ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE/8);
        buff.order(order);

        // 인수로 넘어온 integer을 putInt로설정
        buff.putInt(integer);

//        System.out.println("intTobyte : " + buff);
        return buff.array();
    }

    public static byte[] shortToByte(short value, ByteOrder order) {

        ByteBuffer buff = ByteBuffer.allocate(Short.SIZE/8);
        buff.order(order);

        // 인수로 넘어온 integer을 putInt로설정
        buff.putShort(value);

//        System.out.println("intTobyte : " + buff);
        return buff.array();
    }

    /**
     * byte배열을 int형로 바꿈<br>
     * @param bytes
     * @param order
     * @return
     */
    public static int byteToInt(byte[] bytes, ByteOrder order) {

        ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE/8);
        buff.order(order);

        // buff사이즈는 4인 상태임
        // bytes를 put하면 position과 limit는 같은 위치가 됨.
        buff.put(bytes);
        // flip()가 실행 되면 position은 0에 위치 하게 됨.
        buff.flip();

//        System.out.println("byteToInt : " + buff);

        return buff.getInt(); // position위치(0)에서 부터 4바이트를 int로 변경하여 반환
    }

    /**
     * 입력한 숫자를 BCD 형태의 바이트 배열로 리턴한다. 입력한 값이 0이면 length 길이 만큼 0x00을 채워서 리턴한다.
     * @param num
     * @param length
     * @return
     */
    public static byte[] stringToBcd(long num, int length){
        int digits = 0;
        long temp = num;

        if(temp != 0){
            while (temp != 0) {
                digits++;
                temp /= 10;
            }

            int byteLen = digits % 2 == 0 ? digits / 2 : (digits + 1) / 2;

            byte bcd[] = new byte[byteLen];

            for (int i = 0; i < digits; i++) {
                byte tmp = (byte) (num % 10);
                if (i % 2 == 0) {
                    bcd[i / 2] = tmp;
                } else {
                    bcd[i / 2] |= (byte) (tmp << 4);
                }
                num /= 10;
            }

            for (int i = 0; i < byteLen / 2; i++) {
                byte tmp = bcd[i];
                bcd[i] = bcd[byteLen - i - 1];
                bcd[byteLen - i - 1] = tmp;
            }

            return bcd;
        }else{
            byte[] nullByte = new byte[length];
            for (int i = 0; i < nullByte.length; i++) {
                nullByte[i] = 0x00;
            }
            return nullByte;
        }

    }

    /**
     * 입력한 byte를 String으로 변환해준다.
     * @param bcd
     * @return
     */
    public static String bcdToString(byte bcd) {
        StringBuffer sb = new StringBuffer();

        byte high = (byte) (bcd & 0xf0);
        high >>>= (byte) 4;
        high = (byte) (high & 0x0f);
        byte low = (byte) (bcd & 0x0f);

        sb.append(high);
        sb.append(low);

        return sb.toString();
    }

    /**
     * 입력한 byte배열을 String으로 변환해준다.
     * @param bcd
     * @return
     */
    public static String bcdToString(byte[] bcd) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < bcd.length; i++) {
            sb.append(bcdToString(bcd[i]));
        }

        return sb.toString();
    }
    
    /**
     * byte 배열을 short 형태로 변환한다(LITTLE_ENDIAN)
     * @param bytes
     * @return
     */
    public static short bytesToShortLE(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    public static byte[] intToTwoByteArray(String num){
        int defaultNum = StringUtils.getDefaultIntValue(num, 0);
        byte[] data = new byte[2];

        data[0] = (byte) (defaultNum & 0xFF);
        data[1] = (byte) ((defaultNum >> 8) & 0xFF);

        return data;
    }
    
    
    /**
     * byte substring 
     * @param byt
     * @param st
     * @param en
     * @return
     * @throws Exception
     */
    public static byte[] substring(byte[] byt, int st, int en) throws Exception {
		byte[] tmp = new byte[en - st];
		try {
			int cnt = 0;
			for (int i = st; i < en; i++) {
				tmp[cnt] = byt[i];
				cnt++;
			}
		} catch (Exception e) {
			throw e;
		}
		return tmp;
	}

    /**
     * 입력한 문자열을 2자리씩 나눠서 바이트 배열로 리턴한다.
     * @param number
     * @return
     */
	public static byte[] numberToByteArrTwoCharacter(String number){
        String numberData = StringUtils.nullToBlank(number);
        if(StringUtils.isEmpty(numberData)){
            numberData = "00";
        }
        String[] numberArr = numberData.split("(?<=\\G..)");
        byte[] dataArr = new byte[numberArr.length];
        for (int i = 0; i < numberArr.length; i++) {
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : " + numberArr[i]);
//            dataArr[i] = (byte) StringUtils.getDefaultIntValue(numberArr[i], 0);
//            dataArr[i] = Byte.parseByte(StringUtils.nullToZero(numberArr[i]), 16);
            dataArr[i] = (byte) (Integer.parseInt(numberArr[i], 16) & 0xFF);

//            System.out.println(">>>>>>>>>>>> : " + dataArr[i]);
        }

//        System.out.println("############### : " + byteArrayToHexString(dataArr));
        return dataArr;

    }


    public static void main(String args[]){
//        String data = "02";
//        byte[] arr = new byte[1];
//        arr[0] = (byte) StringUtils.getDefaultIntValue(data, 0);
//
//        System.out.printf(">>>>>>>>>>>>>> : " + byteArrayToString(arr));

//        System.out.println(">>>>>>>>>> : " + Byte.parseByte(StringUtils.nullToZero("23"), 16));
//        System.out.println(">>>>>>>>>> : " + byteArrayToString(numberToByteArrTwoCharacter("0720090020248386")));

//        String[] data = "120329142456".split("(?<=\\G..)");
//        System.out.printf(">>>>>>>>>>>>>>>> : " + java.util.Arrays.toString(data.split("(?<=\\G..)")));

//        numberToByteArrTwoCharacter("120329142456");
//        System.out.println(">>>>>>>>>>>>>>> : " + byteArrayToHexString(intTobyte(StringUtils.getDefaultIntValue("6110", 0), ByteOrder.BIG_ENDIAN)));
//        System.out.println(">>>>>>>>>>>>>>> : " + byteArrayToHexString(shortToByte((short) StringUtils.getDefaultIntValue("132", 0), ByteOrder.LITTLE_ENDIAN)));
//        System.out.println(">>>>>>>>>>>>>>> : " + byteArrayToHexString(StringUtils.nullToBlank("T").getBytes(StandardCharsets.US_ASCII)));

        System.out.println(">>>>>>>>>>>>>>>> : " + byteArrayToString(stringToBcd(0L,2)));
        System.out.println(">>>>>>>>>>>> : " + StringUtils.getDefaultLongValue("0000", 0));
    }
}
