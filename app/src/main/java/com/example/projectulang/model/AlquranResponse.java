package com.example.projectulang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlquranResponse{

	@SerializedName("ar")
	private String ar;

	@SerializedName("id")
	private String id;

	@SerializedName("nomor")
	private String nomor;

	@SerializedName("tr")
	private String tr;

	public void setAr(String ar){
		this.ar = ar;
	}

	public List<AlquranResponse> getAr(){
		return ar;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNomor(String nomor){
		this.nomor = nomor;
	}

	public String getNomor(){
		return nomor;
	}

	public void setTr(String tr){
		this.tr = tr;
	}

	public String getTr(){
		return tr;
	}

	@Override
 	public String toString(){
		return 
			"AlquranResponse{" + 
			"ar = '" + ar + '\'' + 
			",id = '" + id + '\'' + 
			",nomor = '" + nomor + '\'' + 
			",tr = '" + tr + '\'' + 
			"}";
		}
}