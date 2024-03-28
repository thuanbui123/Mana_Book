/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author ThuanBui
 */
public class CategoryModel extends AbstractModel{

    private String name, slug;

    public CategoryModel() {
    }

    public CategoryModel(int id, Timestamp created_at, Timestamp updated_at, String name, String slug) {
        super(id, created_at, updated_at);
        this.name = name;
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}