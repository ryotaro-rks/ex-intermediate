package com.example.form;

//@Validated
public class HotelForm {
	/** id 主キー */
	private Integer id;
	/** 地域名 */
	private String areaName;
	/** ホテル名 */
	private String hotelName;
	/** 住所 */
	private String address;
	/** 最寄り駅 */
	private String nearestStation;
	/** 料金 */
//	@Pattern(regexp = "^[0-9]$", message = "検索結果に一致するホテルは存在しません")
	private String price;
	/** 駐車場の有無 */
	private String parking;

	@Override
	public String toString() {
		return "HotelForm [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}
}
