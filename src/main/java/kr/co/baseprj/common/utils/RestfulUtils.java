package kr.co.baseprj.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestfulUtils {

    /**
     * Restful 조회
     * @param sendUrl
     * @return
     */
    public static String sendREST(String sendUrl){

        StringBuffer outResult = new StringBuffer();
        String inputLine = null;

        try {

            URL url = new URL(sendUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset","UTF-8");
            conn.setConnectTimeout(10 * 1000); //10초
            conn.setReadTimeout(10 * 1000); // 10초


            OutputStream os = conn.getOutputStream();
            os.flush();

            // 응답 결과 읽기
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            while ((inputLine = in.readLine()) != null){
                outResult.append(inputLine);
            }

            conn.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }
        return outResult.toString();
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
