/**  
* @Title: SpringCasAutoconfig.java
* @Package com.it.springbootconfig
* @Description: TODO(用一句话描述该文件做什么)
* @author   mt  
* @date 2017年7月20日 下午2:15:34
* @version V1.0  
*/
package com.it.springbootconfig;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
* @ClassName: SpringCasAutoconfig
* @Description: TODO(这里用一句话描述这个类的作用)
* @author  mt
* @date 2017年7月20日 下午2:15:34
* @Copyright: Copyright (c) 2017 wisedu
*/
@Component
@ConfigurationProperties(prefix = "auth.cas")
public class SpringCasAutoconfig {
	static final String separator = ",";

	private String validateFilters;
	private String signOutFilters;
	private String authFilters;
	private String assertionFilters;
	private String requestWrapperFilters;

	private String casServerUrlPrefix;
	private String casServerLoginUrl;
	private String serverName;
	private boolean useSession = false;
	private boolean redirectAfterValidation = false;
	private boolean casEnabled = false;

	/**
	 * @return the casEnabled
	 */
	public boolean isCasEnabled() {
		return casEnabled;
	}

	/**
	 * @param casEnabled
	 *            the casEnabled to set
	 */
	public void setCasEnabled(boolean casEnabled) {
		this.casEnabled = casEnabled;
	}

	public List<String> getValidateFilters() {
		return Arrays.asList(validateFilters.split(separator));
	}

	public void setValidateFilters(String validateFilters) {
		this.validateFilters = validateFilters;
	}

	public List<String> getSignOutFilters() {
		return Arrays.asList(signOutFilters.split(separator));
	}

	public void setSignOutFilters(String signOutFilters) {
		this.signOutFilters = signOutFilters;
	}

	public List<String> getAuthFilters() {
		return Arrays.asList(authFilters.split(separator));
	}

	public void setAuthFilters(String authFilters) {
		this.authFilters = authFilters;
	}

	public List<String> getAssertionFilters() {
		return Arrays.asList(assertionFilters.split(separator));
	}

	public void setAssertionFilters(String assertionFilters) {
		this.assertionFilters = assertionFilters;
	}

	public List<String> getRequestWrapperFilters() {
		return Arrays.asList(requestWrapperFilters.split(separator));
	}

	public void setRequestWrapperFilters(String requestWrapperFilters) {
		this.requestWrapperFilters = requestWrapperFilters;
	}

	public String getCasServerUrlPrefix() {
		return casServerUrlPrefix;
	}

	public void setCasServerUrlPrefix(String casServerUrlPrefix) {
		this.casServerUrlPrefix = casServerUrlPrefix;
	}

	public String getCasServerLoginUrl() {
		return casServerLoginUrl;
	}

	public void setCasServerLoginUrl(String casServerLoginUrl) {
		this.casServerLoginUrl = casServerLoginUrl;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public boolean isRedirectAfterValidation() {
		return redirectAfterValidation;
	}

	public void setRedirectAfterValidation(boolean redirectAfterValidation) {
		this.redirectAfterValidation = redirectAfterValidation;
	}

	public boolean isUseSession() {
		return useSession;
	}

	public void setUseSession(boolean useSession) {
		this.useSession = useSession;
	}
}
