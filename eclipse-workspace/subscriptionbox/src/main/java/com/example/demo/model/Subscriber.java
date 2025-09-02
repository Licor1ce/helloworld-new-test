package com.example.demo.model;

public class Subscriber {

    private String name;
    private String email;
    private String phone;
    private String[] interests; // checkboxes 
    private String inquiry;     // radio button 

    public Subscriber() {}

    // getters y setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String[] getInterests() { return interests; }
    public void setInterests(String[] interests) { this.interests = interests; }

    public String getInquiry() { return inquiry; }
    public void setInquiry(String inquiry) { this.inquiry = inquiry; }
}
