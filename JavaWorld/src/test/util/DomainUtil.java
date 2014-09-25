package test.util;



public class DomainUtil {
	
	/**
	 * 도메인Fqdn 에서 도메인 이름을 추출해서 반환합니다.
	 * ex) naver.com -> naver   , dev.ne.kr -> dev
	 * 단, www.naver.com 과 같이 서브도메인이 있을 경우 정상적인 값을 반환하지 못하므로 주의하십시요.
	 * 
	 * @param domainFqdn
	 * @return
	 */
	public static String getDomainName(String domainFqdn) {
		if (StringUtil.isEmpty(domainFqdn)) return "";
		
		int firstDotIdx = domainFqdn.indexOf('.');
		if (firstDotIdx < 0) return "";
		
		return domainFqdn.substring(0, firstDotIdx);
	}
	
	/**
	 * 도메인Fqdn 에서 TLD를 추출해서 반환합니다.
	 * ex) naver.com -> com   , dev.ne.kr -> ne.kr
	 * 단, www.naver.com 과 같이 서브도메인이 있을 경우 정상적인 값을 반환하지 못하므로 주의하십시요.
	 * 
	 * @param domainFqdn
	 * @return
	 */
	public static String getDomainTld(String domainFqdn) {
		if (StringUtil.isEmpty(domainFqdn)) return "";
		
		int firstDotIdx = domainFqdn.indexOf('.');
		if (firstDotIdx < 0) return "";
		
		return domainFqdn.substring(firstDotIdx + 1);
	}
		
}