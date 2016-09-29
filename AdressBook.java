/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adressbookmain;

/**
 *
 * @author Dilara
 */
public class AdressBook {
 private String name;
 private String address;
 private String telNo;
 private String email;
 
public AdressBook() {
 name = "";
 address = "";
 telNo = "";
 email = "";
 }
 
public AdressBook(String name, String address, String telNo, String email) {
 this.name = name;
 this.address = address;
 this.telNo = telNo;
 this.email = email;
 }
 
//setters
 public void setName(String name) {
 this.name = name;
 }
 
public void setAddress(String address) {
 this.address = address;
 }
 
public void setTelNo(String telNo) {
 this.telNo = telNo;
 }
 
public void setEmail(String email) {
 this.email = email;
 }
 
//getters
 public String getName() {
 return name;
 }
 
public String getAddress() {
 return address;
 }
 
public String getTelNo() {
 return telNo;
 }
 
public String getEmail() {
 return email;
 }
} 
    

