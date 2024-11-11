package Files;

import java.util.List;

public class coursespojo {
	
	private List<WebAutomation> WB;
	private List<API> api;
	private List<Mobile> mobile ;	
	
	public List getWebAutomation() {
		return WB;
	}
	public void setWebAutomation(List<WebAutomation> WB) {
		this.WB = WB;
	}
	public List getApi() {
		return api;
	}
	public void setApi(List<API> api) {
		this.api = api;
	}
	public List getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile1) {
		this.mobile = mobile1;
	}


}
