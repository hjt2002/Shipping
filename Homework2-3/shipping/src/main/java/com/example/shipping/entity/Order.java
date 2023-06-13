package com.example.shipping.entity;

import lombok.Data;

@Data
public class Order {
  private int shipmentId;
  private String consigneeName;
  private String consigneeAddress;
  private String description;
  private int weigth;

  public Order(int shipmentId, String consigneeName, String consigneeAddress, String description, int weigth) {
    this.shipmentId = shipmentId;
    this.consigneeName = consigneeName;
    this.consigneeAddress = consigneeAddress;
    this.description = description;
    this.weigth = weigth;
  }


  public int getShipmentId() {
    return shipmentId;
  }

  public void setShipmentId(int shipmentId) {
    this.shipmentId = shipmentId;
  }


  public String getConsigneeName() {
    return consigneeName;
  }

  public void setConsigneeName(String consigneeName) {
    this.consigneeName = consigneeName;
  }


  public String getConsigneeAddress() {
    return consigneeAddress;
  }

  public void setConsigneeAddress(String consigneeAddress) {
    this.consigneeAddress = consigneeAddress;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public int getWeigth() {
    return weigth;
  }

  public void setWeigth(int weigth) {
    this.weigth = weigth;
  }

}
