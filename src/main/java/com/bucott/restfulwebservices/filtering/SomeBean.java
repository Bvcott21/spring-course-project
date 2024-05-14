package com.bucott.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * field2 is present in both @JsonIgnoreProperties and also with @JsonIgnore to
 * demonstrate 2 things:
 * 
 * - How to include multiple fields in the @JsonIgnoreProperties at class level
 * - How to specific fields at attribute level
 * 
 * But remember that only one is actually required to ignore a specific field 
 * in a Json object.
 */
@JsonIgnoreProperties({"field1", "field2"})
public class SomeBean {
	private String field1;
	@JsonIgnore
	private String field2;
	private String field3;
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	
}
