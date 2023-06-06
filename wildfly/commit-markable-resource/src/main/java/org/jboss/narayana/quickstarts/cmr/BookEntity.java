package org.jboss.narayana.quickstarts.cmr;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * Entity serving as simple test one to save data to database.
 */
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * If the {@link #id} is null it's not yet generated by Hibernate
     * and thus it's transient and we need to persist.
     * Otherwise update is demanded. 
     */
    @XmlTransient
    public boolean isTransient() {
        return this.id == null;
    }
}