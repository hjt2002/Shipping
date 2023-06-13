package com.example.shipping.entity;


import java.util.Date;

public class Track {

  private int shipperId;
  private int shipmentId;
  private Date shipDate;
  private Date deliveryDate;
  private String status;

  public Track(int shipperId, int shipmentId, Date shipDate, Date deliveryDate, String status) {
    this.shipperId = shipperId;
    this.shipmentId = shipmentId;
    this.shipDate = shipDate;
    this.deliveryDate = deliveryDate;
    this.status = status;
  }


  public int getShipperId() {
    return shipperId;
  }

  public void setShipperId(int shipperId) {
    this.shipperId = shipperId;
  }


  public int getShipmentId() {
    return shipmentId;
  }

  public void setShipmentId(int shipmentId) {
    this.shipmentId = shipmentId;
  }


  public Date getShipDate() {
    return shipDate;
  }

  public void setShipDate(Date shipDate) {
    this.shipDate = shipDate;
  }


  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(java.sql.Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Track{" +
            "shipperId=" + shipperId +
            ", shipmentId=" + shipmentId +
            ", shipDate=" + shipDate +
            ", deliveryDate=" + deliveryDate +
            ", status='" + status + '\'' +
            '}';
  }
}
