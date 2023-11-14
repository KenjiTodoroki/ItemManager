package model.entity;

import java.io.Serializable;

public class MakerBean implements Serializable {
	/**
	 * メーカーコード
	 */
	private String makerCode;

	/**
	 * メーカ名
	 */
	private String makerName;

	/**
	 * デフォルトコンストラクタ
	 */
	public MakerBean() {

	}

	/**
	 * @return makerCode
	 */
	public String getMakerCode() {
		return makerCode;
	}

	/**
	 * @param makerCode セットする makerCode
	 */
	public void setMakerCode(String makerCode) {
		this.makerCode = makerCode;
	}

	/**
	 * @return makerName
	 */
	public String getMakerName() {
		return makerName;
	}

	/**
	 * @param makerName セットする makerName
	 */
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}
}
