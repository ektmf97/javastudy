package api;

public class Accident {

	// bean에 저장 
	// 1. 필드 
	// 1건의 사건정보 
	private String occrrncDt;
	private String occrrncDayCd;
	private int dthDnvCnt;
	private int injpsnCnt;
	
	
//	public Accident(String occrrncDt, String occrrncDayCd, int dthDnvCnt, int injpsnCnt) {
//		super();
//		this.occrrncDt = occrrncDt;
//		this.occrrncDayCd = occrrncDayCd;
//		this.dthDnvCnt = dthDnvCnt;
//		this.injpsnCnt = injpsnCnt;
//	}
	
	// 2. GET ,SET 만들어주기 
	public String getOccrrncDt() {
		return occrrncDt;
	}
	public void setOccrrncDt(String occrrncDt) {
		this.occrrncDt = occrrncDt;
	}
	public String getOccrrncDayCd() {
		return occrrncDayCd;
	}
	public void setOccrrncDayCd(String occrrncDayCd) {
		this.occrrncDayCd = occrrncDayCd;
	}
	public int getDthDnvCnt() {
		return dthDnvCnt;
	}
	public void setDthDnvCnt(int dthDnvCnt) {
		this.dthDnvCnt = dthDnvCnt;
	}
	public int getInjpsnCnt() {
		return injpsnCnt;
	}
	public void setInjpsnCnt(int injpsnCnt) {
		this.injpsnCnt = injpsnCnt;
	}
	
	
	


}
