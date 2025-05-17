package com.cn.cnkart.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ItemDetails itemDetails;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	//use of mappedBy is in the case of only for bidirectional mapping
	//this annotation is mainly used to prevent spring from creating joining
	//columns at both side. sometimes, the joining column is only required at
	//one side. thus, to prevent the creation of column at the other side, annotation
	//is used with name="columnName" which was used at the other side
	//If the relationship is bidirectional, the mappedBy element must be
	// used to specify the relationship field or property of the entity
	// that is the owner of the relationship.
//	@JoinColumn(name="item_id")
	//This is only limited in the case of unidirectional mapping
	//as there is no mention of mapping item at itemReview type
	//so there was problem i.e. where to put the annotation.
	//In bidirectional, this annotation will go to itemReview side.
	//By using the JoinColumn annotation will create an additional column
	//with name item_id at the itemReview side which will hold
	// the itemId from the item table
	private List<ItemReview> itemReview;
	
	public int getId() {
		return id;
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
	public ItemDetails getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}

	public List<ItemReview> getItemReview() {
		return itemReview;
	}

	public void setItemReview(List<ItemReview> itemReview) {
		this.itemReview = itemReview;
	}
}
