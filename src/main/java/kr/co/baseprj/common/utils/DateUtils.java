package kr.co.baseprj.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {

	
	/**
	 * 현재 날짜와 시간을 yyyy-MM-dd HH:mm:ss 로 리턴한다.
	 * @return
	 */
	public static String getDate() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		String nowDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return nowDate;
	}
	
	/**
	 * 현재 날짜를 yyyyMMdd 형식으로 리턴한다.
	 * @return
	 */
	public static String getDateyyyyMMdd(){
		LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		String nowDate = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return nowDate;
	}
	
	/**
	 * 현재 날짜를 yyyyMMdd 형식으로 리턴한다.
	 * @return
	 */
	public static String getYear(){
		LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		String nowDate = localDate.format(DateTimeFormatter.ofPattern("yyyy"));
		return nowDate;
	}

	/**
	 * 현재 날짜를 yyyyMMdd 형식으로 리턴한다.
	 * @return
	 */
	public static String getMonth(){
		LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		String nowDate = localDate.format(DateTimeFormatter.ofPattern("MM"));
		return nowDate;
	}


	/**
	 * 현재 날짜에서 입력한 날짜 이전이나 이후 날짜를 입력한 형식으로 리턴한다.
	 * @param calcDate
	 * @param pattern
	 * @return
	 */
	public static String getCalcDay(int calcDate, String pattern) {
		LocalDate calcLocalDate = getDayCalcLocalDate(calcDate);

		String calcDateStr = calcLocalDate.format(DateTimeFormatter.ofPattern(pattern));
		return calcDateStr;
	}

	/**
	 * 현재 날짜에서 입력한 날짜 이전이나 이후 날짜를 yyyyMMdd 형식으로 리턴한다.
	 * @param calcDate
	 * @return
	 */
	public static String getCalcDay(int calcDate) {
		LocalDate calcLocalDate = getDayCalcLocalDate(calcDate);
		String calcDateStr = calcLocalDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return calcDateStr;
	}

	/**
	 * 현재 날짜애서 입력한 날짜 이전이나 이후 날짜의 LocalDate를 리턴한다.
	 * @param calcDate
	 * @return
	 */
	public static LocalDate getDayCalcLocalDate(int calcDate){
		LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		LocalDate calcLocalDate = null;
		if(calcDate >= 0) {
			// 이후 날짜
			calcLocalDate = nowDate.plusDays(calcDate);
		}else {
			// 이전 날짜
			calcLocalDate = nowDate.minusDays((calcDate * -1));
		}

		return calcLocalDate;
	}


	/**
	 * 현재 날짜에서 입력한 개월수 만큼 이전이나 이후 날짜의 LocalDate를 리턴한다.
	 * @param calcMonth
	 * @return
	 */
	public static LocalDate getMonthCalcLocalDate(int calcMonth){
		LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		LocalDate calcLocalDate = null;
		if(calcMonth >= 0) {
			// 이후 날짜
			calcLocalDate = nowDate.plusMonths(calcMonth);
		}else {
			// 이전 날짜
			calcLocalDate = nowDate.minusMonths((calcMonth * -1));
		}

		return calcLocalDate;
	}


	/**
	 * 현재 날짜에서 입력한 날짜 이전이나 이후 날짜를 yyyyMMdd 형식으로 리턴한다.
	 * @param calcDate
	 * @return
	 */
	public static String getCalcDate(int calcDate) {
		LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		LocalDate calcLocalDate = null;
		if(calcDate >= 0) {
			// 이후 날짜
			calcLocalDate = nowDate.plusDays(calcDate);
		}else {
			// 이전 날짜
			calcLocalDate = nowDate.minusDays((calcDate * -1));
		}
		String calcDateStr = calcLocalDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return calcDateStr;
	}

	/**
	 * 현재 날짜에서 입력한 개월수 만큼 이전이나 이후 날짜를 입력한 형식으로 리턴한다.
	 * @param calcMonth
	 * @param pattern
	 * @return
	 */
	public static String getCalcMonth(int calcMonth, String pattern) {
		LocalDate calcLocalDate = getMonthCalcLocalDate(calcMonth);

		String calcDateStr = calcLocalDate.format(DateTimeFormatter.ofPattern(pattern));
		return calcDateStr;
	}

	/**
	 * 현재 날짜에서 입력한 개월수 만큼 이전이나 이후 날짜를 yyyyMMdd 형식으로 리턴한다.
	 * @param calcMonth
	 * @return
	 */
	public static String getCalcMonth(int calcMonth) {
		LocalDate calcLocalDate = getMonthCalcLocalDate(calcMonth);
		String calcDateStr = calcLocalDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		return calcDateStr;
	}

	/**
	 * 두 날짜간의 전체 일 수 차이를 구한다.
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long betweenTwoDate(String startDate, String endDate){
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);

		long betweenDays = ChronoUnit.DAYS.between(start, end);

		return betweenDays;
	}

	
	/**
	 * 현재 날짜를 입력한 형식으로 리턴한다.
	 * @param pattern
	 * @return
	 */
	public static String getDatePattern(String pattern){
		LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		String nowDate = localDate.format(DateTimeFormatter.ofPattern(pattern));
		return nowDate;
	}
	
	/**
	 * 현재 날짜를 MMdd 형식으로 리턴한다.
	 * @return
	 */
	public static String getDateMMdd(){
		LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
		String nowDate = localDate.format(DateTimeFormatter.ofPattern("MMdd"));
		return nowDate;
	}
	
	/**
	 * 현재 시간을 HHmmss (24시간 형식)으로 리턴한다.
	 * @return
	 */
	public static String getTimeHHmmss(){
		LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Seoul"));
		String nowTime = localTime.format(DateTimeFormatter.ofPattern("HHmmss"));
		return nowTime;
	}

	/**
	 * 입력한 날짜를 두번째 입력한 패턴으로 변환해서 리턴한다.
	 * @param date
	 * @param inputPattern
	 * @param outputPattern
	 * @return
	 */
	public static String changeDateFormat(String date, String inputPattern, String outputPattern){

		String changeDate = "";
		SimpleDateFormat inSdf = new SimpleDateFormat(inputPattern);
		SimpleDateFormat outSdf = new SimpleDateFormat(outputPattern);

		try {
			changeDate = outSdf.format(inSdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}

		return changeDate;
	}

	/**
	 * 입력한 날짜가 yyyyMMdd 형식일 경우 입력한 일수 차이만큼 날짜를 계산해서 입력한 outputPattern으로 리턴한다.
	 * @param startDate
	 * @param calcDay
	 * @param outputPattern
	 * @return
	 */
	public static String getCalcDay(String startDate, int calcDay, String outputPattern){
		String outputDate = "";
		try {
			if(!StringUtils.isEmpty(startDate) && startDate.length() == 8){
				int year = Integer.parseInt(startDate.substring(0, 4));
				int month = Integer.parseInt(startDate.substring(4, 6));
				int day = Integer.parseInt(startDate.substring(6));

				LocalDate localDate = LocalDate.of(year, month, day);

				LocalDate calcLocalDate = null;
				if(calcDay >= 0) {
					// 이후 날짜
					calcLocalDate = localDate.plusDays(calcDay);
				}else {
					// 이전 날짜
					calcLocalDate = localDate.minusDays((calcDay * -1));
				}

				outputDate = calcLocalDate.format(DateTimeFormatter.ofPattern(outputPattern));

			}

			return outputDate;
		}catch (Exception e){
			e.printStackTrace();
			return "";
		}
	}

	public static long getCalcTime(String startDateTime, String endDayTime, String dateTimeFormat){

		long calDateTime = 0;

		try {
			LocalDateTime startTime = LocalDateTime.parse(startDateTime,DateTimeFormatter.ofPattern(dateTimeFormat));
			LocalDateTime endTime = LocalDateTime.parse(endDayTime,DateTimeFormatter.ofPattern(dateTimeFormat));
			calDateTime = Duration.between(startTime, endTime).getSeconds();

			int hour = (int)(calDateTime/(60*60));
			int min = (int) (calDateTime - (hour *60*60)) / 60;
			int sec = (int) (calDateTime - ((hour* 60*60)+ (min*60)));

			return calDateTime;
		}catch (Exception e){
			e.printStackTrace();
			return calDateTime;
		}
	}


	/*
	현재 시간, 초를 계산 해서 DateTime 을 리턴
	 */
	public static String getCalcTimeForDatetime(int inputSec, String inputDate, String dateTimeFormat ){

		String resultDate = "";
		try{

//			System.out.println("inputsec ["+Integer.toString(inputSec)+"]inputDate ["+inputDate+"]dateTimeFormat ["+dateTimeFormat+"]");
			// date format 생성
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat, Locale.KOREA);

			LocalDateTime dateTime = LocalDateTime.parse(inputDate, formatter);


			//timestamp 로 변환
			Timestamp timestamp = Timestamp.valueOf(dateTime);

			//Calendar 로 변환 후 더하기
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(timestamp.getTime());
			cal.add(Calendar.SECOND, inputSec);

			Timestamp calTimestamp = new Timestamp(cal.getTime().getTime());

			LocalDateTime localDateTime1 = calTimestamp.toLocalDateTime();

			resultDate = localDateTime1.format(DateTimeFormatter.ofPattern(dateTimeFormat));


		}catch (Exception e){
			e.printStackTrace();
		}

		return resultDate;
	}


	
	public static void main(String[] args) {

//		System.out.println("두 날짜의 차 : " + getCalcTime("20210113100000", "20210113131010", "yyyyMMddHHmmss"));
		System.out.println("두 날짜의 차 : " + getCalcTimeForDatetime(60, "20210923000100", "yyyyMMddHHmmss"));
//		System.out.println("현재 날짜 : " + getDateyyyyMMdd());
//		System.out.println("현재 시간 : " + getTimeHHmmss());
//		System.out.println("현재 시간 : " + getMonth());
//		System.out.println("어제 날짜 : " + getCalcDate(1,"yyyyMMdd"));
//		System.out.println("내일 날짜 : " + getCalcDate(-1,"yyyy-MM-dd"));
//		System.out.println("어제 날짜 : " + getCalcDate(2));
//		System.out.println("내일 날짜 : " + getCalcDate(-2));

		/*String startDate = "20190723";

		int year = Integer.parseInt(startDate.substring(0, 4));
		int month = Integer.parseInt(startDate.substring(4, 6));
		int day = Integer.parseInt(startDate.substring(6));

		System.out.println(changeDateFormat("20190723", "yyyyMMdd", "yyyy-MM-dd"));
		System.out.println(">>>>>>>>>>>>> : " + year);
		System.out.println(">>>>>>>>>>>>> : " + month);
		System.out.println(">>>>>>>>>>>>> : " + day);


		*/

//		System.out.println(">>>>>>>>>>>>>> : " + betweenTwoDate("2019-07-26", "2019-07-27"));
//		System.out.println(">>>>>>>>>>> : [" + getCalcDay("20200131", -1, "yyyyMMdd") + "]");
//		long dayDiff = 1;
//
//		if(dayDiff <= 0){
////			param.setRefundAmount("0");
//			System.out.println(">>>>>>>>>>>> 환불 불가!");
//		}else if(dayDiff >= 10){
//			System.out.println(">>>>>>>>>>>> 전액 환불 ");
////			param.setRefundAmount(param.getPaymentAmmount());
//		}else{
//			int payAmount = Integer.parseInt("200000");
//			payAmount = (int) (payAmount * ( 0.1 * dayDiff));
//			System.out.println(">>>>>>>>>>>> : " + payAmount);
//		}


	}
}
