package kr.co.baseprj.common.vo;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
/**
 * 이 클래스는 작업의 결과나 응답을 나타내는 제네릭 클래스입니다.
 *
 * @param <D> 데이터의 유형을 제네릭으로 지정합니다.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ResultVo<D> {
  /**
   * 결과 코드를 나타내는 문자열입니다.
   */
  private final String resultCode;

  /**
   * 결과에 대한 추가 메시지를 나타내는 문자열입니다.
   */
  private final String message;

  /**
   * 작업의 결과 데이터를 나타내는 제네릭 데이터입니다.
   */
  private final D data;

  /**
   * 정적 팩토리 메서드를 사용하여 ResultVo 인스턴스를 생성합니다.
   *
   * @param resultCode 결과 코드
   * @param message    결과 메시지
   * @param data       결과 데이터
   * @param <D>        데이터의 유형
   * @return 생성된 ResultVo 인스턴스
   */
  public static <D> ResultVo<D> of(String resultCode, String message, D data) {
    return new ResultVo<>(resultCode, message, data);
  }
}
