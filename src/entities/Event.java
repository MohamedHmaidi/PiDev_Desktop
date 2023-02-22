/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

import java.sql.Date;

/**
 *
 * @author Aymen
 */
public class Event {
    private int event_id, ticketCount, host_id, location_id;
    private String title, type, description, status;
    private Date startDate, endDate;
    private byte[] affiche;
    private float ticketPrice;

    public Event() {
    }

    public Event(int event_id) {
        this.event_id = event_id;
    }

    public Event(int event_id, int ticketCount, int host_id, int location_id, String title, String type, String description, String status, Date startDate, Date endDate, byte[] affiche) {
        this.event_id = event_id;
        this.ticketCount = ticketCount;
        this.host_id = host_id;
        this.location_id = location_id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.affiche = affiche;
    }

    public Event(int ticketCount, int host_id, int location_id, String title, String type, String description, String status, Date startDate, Date endDate, byte[] affiche) {
        this.ticketCount = ticketCount;
        this.host_id = host_id;
        this.location_id = location_id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.affiche = affiche;
    }

    public Event(int event_id, String title, String type) {
        this.event_id = event_id;
        this.title = title;
        this.type = type;
    }
    
    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getHost_id() {
        return host_id;
    }

    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public byte[] getAffiche() {
        return affiche;
    }

    public void setAffiche(byte[] affiche) {
        this.affiche = affiche;
    }
    
    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Event{" + "event_id=" + event_id + ", ticketCount=" + ticketCount + ", host_id=" + host_id + ", location_id=" + location_id + ", title=" + title + ", type=" + type + ", description=" + description + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", affiche=" + affiche + '}';
    }
    
    
}
