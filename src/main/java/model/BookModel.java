/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author ThuanBui
 */
public class BookModel extends AbstractModel{
    private String title, slug, description, imageThumbnail, nameAuthor, created, updated;
    private Integer idAuthor, quantity;

    public BookModel() {
    }

    public BookModel(String title, String slug, String description, String imageThumbnail, Integer idAuthor, String nameAuthor, Integer quantity) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.imageThumbnail = imageThumbnail;
        this.nameAuthor = nameAuthor;
        this.quantity = quantity;
        this.idAuthor = idAuthor;
    }

    public BookModel(String title, Integer idAuthor, Integer quantity) {
        this.title = title;
        this.idAuthor = idAuthor;
        this.quantity = quantity;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BookModel{" + "title=" + title + ", slug=" + slug + ", description=" + description + ", imageThumbnail=" + imageThumbnail + ", nameAuthor=" + nameAuthor + ", created=" + created + ", updated=" + updated + ", idAuthor=" + idAuthor + ", quantity=" + quantity + '}';
    }
    
    
}
