package com.example.shipping.entity;

import lombok.Data;

@Data
public class Shipper {

  private int shipperId;
  private String shipperName;
  private String email;
  private String password;
  private String shipperAddress;

  public Shipper(int shipperId, String shipperName, String email, String password, String shipperAddress) {
    this.shipperId = shipperId;
    this.shipperName = shipperName;
    this.email = email;
    this.password = password;
    this.shipperAddress = shipperAddress;
  }


  public int getShipperId() {
    return shipperId;
  }

  public void setShipperId(int shipperId) {
    this.shipperId = shipperId;
  }


  public String getShipperName() {
    return shipperName;
  }

  public void setShipperName(String shipperName) {
    this.shipperName = shipperName;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getShipperAddress() {
    return shipperAddress;
  }

  public void setShipperAddress(String shipperAddress) {
    this.shipperAddress = shipperAddress;
  }

}
