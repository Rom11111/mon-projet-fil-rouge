package org.romain.demo2.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

// Un modèle structure les données
@Getter // annotation
@Setter
@Entity // A la fois une classe et un objet
public class Product {

    @Id // Preciser quelle propriété a une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Stratégie à appliquer
    protected Integer id;

    @Column(nullable = false)
    protected String name;


    @Column(length = 15, nullable = false  /* ne peut pas être nul */, unique = true) //force le changement de nom
    @Length(max = 15, min = 3)
    @NotBlank
    protected String code;

    @Column(columnDefinition = "TEXT") //pas de limite de caractères
    protected String description;

    protected float price; // "f" prix peut être de 0 et "F" valeur par défaut null

    @ManyToOne
    protected Etat etat;

    @ManyToMany
    @JoinTable(
            name = "product_label", // nom de la table de jointure
            joinColumns = @JoinColumn(name = "product_id"), // permet de modifier la colonne Produit(je suis dans son entité)
            inverseJoinColumns = @JoinColumn(name = "label_id")

    )
    protected List<Label> labelList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    User creator;
}
