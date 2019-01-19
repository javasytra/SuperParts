package com.javasutra.SuperParts.models;
import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part {
    public Part() {
    }

    public Part(String title, boolean need, int partscount) {
        this.title = title;
        this.need = need;
        this.partscount = partscount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean need;
    private int partscount;
    public String needString(){
        return need? "Да":"Нет";
    }

   public void setTitle(String title) {
        this.title = title;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public void setPartscount(int partscount) {
        this.partscount = partscount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isNeed() {
        return need;
    }

    public int getPartscount() {
        return partscount;
    }
}