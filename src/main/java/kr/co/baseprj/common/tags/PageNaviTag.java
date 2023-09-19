package kr.co.baseprj.common.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import kr.co.baseprj.common.base.PageNavigator;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;


/**
 * 페이지 정보 리턴
 * 
 * @author : 인텔리진
 */
public class PageNaviTag extends TagSupport {

	private static final long serialVersionUID = -1774048226116492277L;

	private String data;
	private String formId;

	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		String dateSub = (String) ExpressionEvaluatorManager.evaluate("dateSub", data, String.class, this, pageContext);
		String formIdSub = (String) ExpressionEvaluatorManager.evaluate("formIdSub", formId, String.class, this, pageContext);

		try {
			StringBuffer strValue = new StringBuffer();
			String str = "";

			PageNavigator page = (PageNavigator) pageContext.getRequest().getAttribute(dateSub);
			int adjacentCount = 3;

			if (page != null) {

				String navHeader = "<ul>";
				String navPre = "<li class=\"pager on prev\"><a href=\"#PAGEHREF#\"><img src=\"/static/images/pager_prev.svg\" alt=\"\"></a></li> ";	// 전페이지

				String navNoLink = "<li class=\"mobile_num\";'><a><span>#PAGENUM#</span>&nbsp;/&nbsp;" + page.getPageTotal() + "</a></li>";	// 현재 페이지 (모바일)
				 navNoLink += " <li class=\"pagerNum on\"><a href=\"#!\">#PAGENUM#</a></li>";		// 현재 페이지 (웹)

				String navLink = " <li class=\"pagerNum\"><a href=\"#PAGEHREF#\">#PAGENUM#</a></li>";// 다른 페이지
				String navNext = "<li class=\"pager next\"><a href=\"#PAGEHREF#\"><img src=\"/static/images/pager_next.svg\" alt=\"\"></a></li>";		// 다음페이지지
				String navFooter = "</ul>";

				int firstAdjacentPage = 0;
				int lastAdjacentPage = 0;
				
				int firstPage = 1;
				int lastPage = page.getPageTotal();
				int currentPage = page.getCurrentPage();

				strValue.append(navHeader.trim());

				// 이전 10개 블럭 페이지가 있는가
			/*	if(page.getPageGroupStart() > 1){
					str = navFirst.replaceAll("#PAGEHREF#", "javascript:fuGoPage('" + formIdSub + "','currentPage','1');").trim();
					strValue.append(str);
				}*/

				// 이전 페이지가 있다면 이전 페이지 출력
			//	if(lastPage > 1 &&  currentPage > 1 ){
					str = navPre.replaceAll("#PAGEHREF#", "javascript:fuGoPage('" + formIdSub + "','currentPage','"+(currentPage-1)+"');").trim();
					strValue.append(str);
			//	}

				// 페이지 정보
				for (int i = page.getPageGroupStart(); i <= page.getPageGroupEnd(); i++) {
					if(currentPage == i){
						str = navNoLink.replaceAll("#PAGENUM#", String.valueOf(i)).trim();
					}else{
						str = navLink.replaceAll("#PAGEHREF#", "javascript:fuGoPage('" + formIdSub + "','currentPage'," + String.valueOf(i) + ");")
								.replaceAll("#PAGENUM#", String.valueOf(i)).trim();
					}

					strValue.append(str);
				}

				// 다음 페이지가 있는가
		//		if(lastPage > currentPage){
					str = navNext.replaceAll("#PAGEHREF#", "javascript:fuGoPage('" + formIdSub + "','currentPage','"+(currentPage+1)+"');").trim();
					strValue.append(str);
			//	}

				// 다음 블럭이 있는가
			/*	if(page.getPageTotal() > page.getPageGroupEnd()){
					str = navLast.replaceAll("#PAGEHREF#", "javascript:fuGoPage('" + formIdSub + "','currentPage','"+page.getPageTotal()+"');").trim();
					strValue.append(str);
				}*/

				strValue.append(navFooter);

				out.println(strValue.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}