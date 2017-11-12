package com.soecode.lyf.entity;

/**
 * 图书实体
 */
public class Product {
	
	private long id;
	private String name;
	private String description;
	private long categoryId;
	private long price;
	private String size;
	private String distImageUrl1;
	private String distImageUrl2;
	private String distImageUrl3;
	private String mainImageUrl1;
	private String mainImageUrl2;
	private String mainImageUrl3;
	private String mainImageUrl4;			

	
	public Product(){
		
	}
	
	public Product(long id, String name, String description, String digest_image_url1, String digest_image_url2, 
			String digest_image_url3, String main_image_url1, String main_image_url2, 
			String main_image_url3, String main_image_url4, long price, String size, long product_type, String mainImageUrl1) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.distImageUrl1 = digest_image_url1;
		this.distImageUrl2 = digest_image_url2;
		this.distImageUrl3 = digest_image_url3;
		this.mainImageUrl1 = main_image_url1;
		this.mainImageUrl2 = main_image_url2;
		this.mainImageUrl3 = main_image_url3;
		this.mainImageUrl4 = main_image_url4;
		this.price = price;
		this.size = size;
		this.categoryId = product_type;
		this.mainImageUrl1 = mainImageUrl1;

	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDistImageUrl1() {
		return distImageUrl1;
	}

	public void setDistImageUrl1(String distImageUrl1) {
		this.distImageUrl1 = distImageUrl1;
	}

	public String getDistImageUrl2() {
		return distImageUrl2;
	}

	public void setDistImageUrl2(String distImageUrl2) {
		this.distImageUrl2 = distImageUrl2;
	}

	public String getDistImageUrl3() {
		return distImageUrl3;
	}

	public void setDistImageUrl3(String distImageUrl3) {
		this.distImageUrl3 = distImageUrl3;
	}

	public String getMainImageUrl1() {
		return mainImageUrl1;
	}

	public void setMainImageUrl1(String mainImageUrl1) {
		this.mainImageUrl1 = mainImageUrl1;
	}

	public String getMainImageUrl2() {
		return mainImageUrl2;
	}

	public void setMainImageUrl2(String mainImageUrl2) {
		this.mainImageUrl2 = mainImageUrl2;
	}

	public String getMainImageUrl3() {
		return mainImageUrl3;
	}

	public void setMainImageUrl3(String mainImageUrl3) {
		this.mainImageUrl3 = mainImageUrl3;
	}

	public String getMainImageUrl4() {
		return mainImageUrl4;
	}

	public void setMainImageUrl4(String mainImageUrl4) {
		this.mainImageUrl4 = mainImageUrl4;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
	}


}
